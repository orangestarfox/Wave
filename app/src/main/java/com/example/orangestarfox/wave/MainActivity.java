package com.example.orangestarfox.wave;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // SeekBar seekBar1=(SeekBar)findViewById(R.id.r);

             //   SeekBar seekBar2=(SeekBar)findViewById(R.id.m);

               // SeekBar seekBar3=(SeekBar)findViewById(R.id.x);

              //  SeekBar seekBar4=(SeekBar)findViewById(R.id.y);
              //  int R=seekBar1.getProgress();
              int[] stars=new int[5];

                EditText editTextR=(EditText)findViewById(R.id.r);

                EditText editTextG=(EditText)findViewById(R.id.g);

                EditText editTextM=(EditText)findViewById(R.id.m);

                EditText editTextX=(EditText)findViewById(R.id.x);

                EditText editTextY=(EditText)findViewById(R.id.y);
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
                stars[0]=Integer.parseInt("0"+editTextR.getText().toString());

                stars[1]=Integer.parseInt("0"+editTextG.getText().toString());

                stars[2]=Integer.parseInt("0"+editTextM.getText().toString());

                stars[3]=Integer.parseInt("0"+editTextX.getText().toString());

                stars[4]=Integer.parseInt("0"+editTextY.getText().toString());

                Intent intent =new Intent(MainActivity.this, Graph.class);
              intent.putExtra("stars",stars);
              MainActivity.this.startActivityForResult(intent, 1);



            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            if(resultCode==RESULT_CANCELED)
                ;
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.mode1) {
            int[] stars={30,300,10000,2,2};

            Intent intent =new Intent(MainActivity.this, Graph.class);
            intent.putExtra("stars",stars);
            MainActivity.this.startActivityForResult(intent, 1);
            // Handle the camera action
        } else if (id == R.id.mode2) {
            int[] stars={300,60,10000,2,2};

            Intent intent =new Intent(MainActivity.this, Graph.class);
            intent.putExtra("stars",stars);
            MainActivity.this.startActivityForResult(intent, 1);

        } else if (id == R.id.mode3) {
            int[] stars={15,10,100000,2,2};

            Intent intent =new Intent(MainActivity.this, Graph.class);
            intent.putExtra("stars",stars);
            MainActivity.this.startActivityForResult(intent, 1);

        } else if (id == R.id.mode4) {
            int[] stars={200,120,30000,3,3};

            Intent intent =new Intent(MainActivity.this, Graph.class);
            intent.putExtra("stars",stars);
            MainActivity.this.startActivityForResult(intent, 1);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
