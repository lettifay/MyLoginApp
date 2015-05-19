package crf.myloginapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences mySharedPreferences = getSharedPreferences("mySP",Activity.MODE_PRIVATE);
        final String usr = mySharedPreferences.getString("username","");
        final String pwd = mySharedPreferences.getString("password","");

        Switch aSwitch = (Switch)findViewById(R.id.mySwitch);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
//                    login(usr, pwd, true);
                } else {
//                    logout(usr, pwd, false);
                }
            }
        });
    }

    private void login(String usr, String pwd, final Boolean isChecked){
        new Thread(new Runnable() {
            public void run() {
                //do log in
//                showToast(isChecked);
            }
        }).start();
    }

    private void logout(String usr, String pwd, final Boolean isChecked){
        new Thread(new Runnable() {
            public void run() {
                //do log out
//                showToast(isChecked);
            }
        }).start();
    }

    private void showToast(Boolean isChecked) {
        if (isChecked){
            Toast toast = Toast.makeText(this,R.string.status_on,Toast.LENGTH_SHORT);
            toast.show();
        }else {
            Toast toast = Toast.makeText(this,R.string.status_off,Toast.LENGTH_SHORT);
            toast.show();
        }
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
            Intent myIntent = new Intent(this,SettingsActivity.class);
            startActivity(myIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}