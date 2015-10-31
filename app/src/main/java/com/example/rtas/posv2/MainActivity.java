package com.example.rtas.posv2;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PayFragment.OnFragmentInteractionListener, ButtonsFragment.OnFragmentInteractionListener, ItemFragment.OnListInteractionListener ,View.OnClickListener{


    /*Class variables*/
    double subtotalPrice = 0;
    double taxPrice = 0;
    double totalPrice = 0;
    public static boolean halfPriceFlag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        POSItems.init();
        setContentView(R.layout.activity_main);
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*Pre generated methods*/
    @Override
    public void onFragmentInteraction(int id) {
        ButtonsFragment buttonsFragment = (ButtonsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        Toast.makeText(getApplicationContext(), "Pushed button. ID:"+id,
                Toast.LENGTH_SHORT).show();
        if(buttonsFragment != null)
        {

        }
    }


    public void onFragmentInteraction(String id){

    }

    @Override
    public void onFragmentInteractionPay(int id) {

    }



    /*OnClick listener for all buttons*/
    @Override
    public void onClick(View v) {
        MyItem item;
        TextView subtotal = (TextView)findViewById(R.id.subtotal);
        TextView tax = (TextView)findViewById(R.id.tax);
        TextView total = (TextView)findViewById(R.id.total);
        DecimalFormat df = new DecimalFormat(".##");

        switch (v.getId())
        {
            default:
                /*Add item to shopping list*/
                ItemFragment.mAdapter.notifyDataSetChanged();
                item = POSItems.getItemById(v.getId());
                ListContent.addItem(POSItems.getItemById(v.getId()));
                ItemFragment.mAdapter.notifyDataSetChanged();
                subtotalPrice += item.getPrice();
                taxPrice = subtotalPrice*.12;
                totalPrice = subtotalPrice+taxPrice;
                subtotal.setText("$ "+df.format(subtotalPrice));
                tax.setText("$ "+df.format(taxPrice));
                total.setText("$ "+df.format(totalPrice));
                ItemFragment.mAdapter.notifyDataSetChanged();
                break;

            case R.id.pay:{
                /*Finish transaction*/
                /*Display Receipt*/
                Toast.makeText(MainActivity.this, "Payment Processed", Toast.LENGTH_SHORT).show();
                AlertDialog receiptDialog = new AlertDialog.Builder(MainActivity.this).create();

                receiptDialog.setTitle("Receipt");
                LinearLayout lila1= new LinearLayout(this);
                lila1.setOrientation(LinearLayout.VERTICAL);
                final TextView title  = new TextView(this);
                final TextView line  = new TextView(this);
                final TextView blank = new TextView(this);
                final TextView totalTitle = new TextView(this);
                final TextView totalNum = new TextView(this);

                title.setText("Item              Price               Qty.");
                title.setPadding(10, 5, 0, 0);

                line.setText("_____________________________________");

                blank.setText("\n");
                totalTitle.setText("Total");
                totalTitle.setPadding(10, 2, 0, 0);
                totalNum.setText("$" + df.format(this.totalPrice));
                totalNum.setPadding(10,0,0,0);

                lila1.addView(title);
                for(MyItem thisItem : ListContent.ITEMS)
                {
                    final TextView listView = new TextView(this);
                    listView.setText(thisItem.toString());
                    listView.setPadding(10,0,0,10);
                    lila1.addView(listView);
                }
                lila1.addView(line);
                lila1.addView(totalTitle);
                lila1.addView(totalNum);
                receiptDialog.setView(lila1);

                receiptDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                receiptDialog.show();

                //gets how many items are in the list and clears the items out one by one
                Toast.makeText(MainActivity.this, "Clear", Toast.LENGTH_SHORT).show();
                int count = ItemFragment.mAdapter.getCount();
                for(int i=0;i<count;i++){
                    ListContent.removeItem(0);
                    ItemFragment.mAdapter.notifyDataSetChanged();
                }
                //clears the all the prices
                Log.d("DEBUG", "Count of the array = "+count);
                subtotalPrice = 0.00;
                taxPrice = 0.00;
                totalPrice = 0.00;
                subtotal.setText("$ "+df.format(subtotalPrice));
                tax.setText("$ "+df.format(taxPrice));
                total.setText("$ " + df.format(totalPrice));
                ItemFragment.mAdapter.notifyDataSetChanged();
                halfPriceFlag = false;
                break;
            }
            case R.id.half: {
                //checks if half price has already been applied and decides whether to apply it
                if (halfPriceFlag) {
                    Toast.makeText(MainActivity.this, "Already half off!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "1/2 Off", Toast.LENGTH_SHORT).show();
                    subtotalPrice /= 2;
                    taxPrice = subtotalPrice * .12;
                    totalPrice = subtotalPrice + taxPrice;
                    subtotal.setText("$ " + df.format(subtotalPrice));
                    tax.setText("$ " + df.format(taxPrice));
                    total.setText("$ " + df.format(totalPrice));
                    halfPriceFlag = true;
                }
                break;
            }
            case R.id.clear:{
                //gets how many items are in the list and clears the items out one by one
                Toast.makeText(MainActivity.this, "Clear", Toast.LENGTH_SHORT).show();
                int count = ItemFragment.mAdapter.getCount();
                for(int i=0;i<count;i++){
                    ListContent.removeItem(0);
                    ItemFragment.mAdapter.notifyDataSetChanged();
                }
                //clears the all the prices
                Log.d("DEBUG", "Count of the array = "+count);
                subtotalPrice = 0.00;
                taxPrice = 0.00;
                totalPrice = 0.00;
                subtotal.setText("$ "+df.format(subtotalPrice));
                tax.setText("$ "+df.format(taxPrice));
                total.setText("$ " + df.format(totalPrice));
                ItemFragment.mAdapter.notifyDataSetChanged();
                halfPriceFlag = false;
                break;

            }
        }

    }


    @Override
    public void onListInteraction(ArrayAdapter adapter, int id) {
        /*Removing an item from the list*/
        MyItem item = ListContent.ITEMS.get(id);
        TextView subtotal = (TextView)findViewById(R.id.subtotal);
        TextView tax = (TextView)findViewById(R.id.tax);
        TextView total = (TextView)findViewById(R.id.total);
        DecimalFormat df = new DecimalFormat("#.##");
        if(halfPriceFlag){
            subtotalPrice -= ((item.getPrice()*(item.getQuantity()))/2);
            taxPrice = subtotalPrice*.12;
            totalPrice = subtotalPrice+taxPrice;
        }else{
            subtotalPrice -= (item.getPrice()*(item.getQuantity()));
            taxPrice = subtotalPrice*.12;
            totalPrice = subtotalPrice+taxPrice;
        }
        subtotal.setText("$ "+df.format(subtotalPrice));
        tax.setText("$ "+df.format(taxPrice));
        total.setText("$ "+df.format(totalPrice));
        Log.d("DEBUG", "Position = " + id);
        ListContent.removeItem(id);

        ItemFragment.mAdapter.notifyDataSetChanged();
        ItemFragment.mAdapter.notifyDataSetChanged();
    }
}

