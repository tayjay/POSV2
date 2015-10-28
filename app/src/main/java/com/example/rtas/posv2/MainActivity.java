package com.example.rtas.posv2;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PayFragment.OnFragmentInteractionListener, ButtonsFragment.OnFragmentInteractionListener, ItemFragment.OnFragmentInteractionListener,View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        POSItems.init();
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

    @Override
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
            case R.id.apple:
                item = POSItems.getItemById(v.getId());
                Toast.makeText(getApplicationContext(), item.getName()+" $"+item.getPrice(),
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.banana:
                item = POSItems.getItemById(v.getId());
                Toast.makeText(getApplicationContext(), item.getName()+" $"+item.getPrice(),
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.battery:
                item = POSItems.getItemById(v.getId());
                Toast.makeText(getApplicationContext(), item.getName()+" $"+item.getPrice(),
                        Toast.LENGTH_SHORT).show();
            default:
                item = POSItems.getItemById(v.getId());
                Toast.makeText(getApplicationContext(), item.getName()+" $"+item.getPrice(),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
