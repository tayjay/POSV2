package com.example.rtas.posv2;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PayFragment.OnFragmentInteractionListener, ButtonsFragment.OnFragmentInteractionListener, ItemFragment.OnListInteractionListener ,View.OnClickListener{



    double subtotalPrice = 0;
    double taxPrice = 0;
    double totalPrice = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        POSItems.init();
        setContentView(R.layout.activity_main);




        //ListView list = (ListView) findViewById(R.id.fragment3);
        //list.deferNotifyDataSetChanged();





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


    @Override
    public void onClick(View v) {
        MyItem item;

        switch (v.getId())
        {
            /*
            case R.id.apple:
                item = POSItems.getItemById(v.getId());
                Toast.makeText(getApplicationContext(), item.getName()+" $"+item.getPrice(),
                        Toast.LENGTH_SHORT).show();
                ListContent.addItem(POSItems.getItemById(v.getId()));
                ItemFragment.mAdapter.notifyDataSetChanged();


                break;
            case R.id.banana:
                item = POSItems.getItemById(v.getId());
                Toast.makeText(getApplicationContext(), item.getName()+" $"+item.getPrice(),
                        Toast.LENGTH_SHORT).show();
                ListContent.addItem(POSItems.getItemById(v.getId()));
                ItemFragment.mAdapter.notifyDataSetChanged();

                break;
            case R.id.battery:
                item = POSItems.getItemById(v.getId());
                Toast.makeText(getApplicationContext(), item.getName()+" $"+item.getPrice(),
                        Toast.LENGTH_SHORT).show();
                ListContent.addItem(POSItems.getItemById(v.getId()));
                ItemFragment.mAdapter.notifyDataSetChanged();
                break;
            */
            default:
                item = POSItems.getItemById(v.getId());
                //Toast.makeText(getApplicationContext(), item.getName()+" $"+item.getPrice(),
                       // Toast.LENGTH_SHORT).show();
                ListContent.addItem(POSItems.getItemById(v.getId()));
                ItemFragment.mAdapter.notifyDataSetChanged();

                TextView subtotal = (TextView)findViewById(R.id.subtotal);
                TextView tax = (TextView)findViewById(R.id.tax);
                TextView total = (TextView)findViewById(R.id.total);
                DecimalFormat df = new DecimalFormat(".##");
                subtotalPrice += item.getPrice();
                taxPrice = subtotalPrice*.12;
                totalPrice = subtotalPrice+taxPrice;
                subtotal.setText("$ "+df.format(subtotalPrice));
                tax.setText("$ "+df.format(taxPrice));
                total.setText("$ "+df.format(totalPrice));
                ItemFragment.mAdapter.notifyDataSetChanged();
                break;

        }

    }


    @Override
    public void onListInteraction(ArrayAdapter adapter, int id) {
        MyItem item = ListContent.ITEMS.get(id);


        TextView subtotal = (TextView)findViewById(R.id.subtotal);
        TextView tax = (TextView)findViewById(R.id.tax);
        TextView total = (TextView)findViewById(R.id.total);
        DecimalFormat df = new DecimalFormat("#.##");
        subtotalPrice -= (item.getPrice()*(item.getQuantity()));
        taxPrice = subtotalPrice*.12;
        totalPrice = subtotalPrice+taxPrice;
        subtotal.setText("$ "+df.format(subtotalPrice));
        tax.setText("$ "+df.format(taxPrice));
        total.setText("$ "+df.format(totalPrice));
        ListContent.removeItem(id);
        ItemFragment.mAdapter.notifyDataSetChanged();
        ItemFragment.mAdapter.notifyDataSetChanged();
    }
}
