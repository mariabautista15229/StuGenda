package com.example.stugenda;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.wdullaer.materialdatetimepicker.date.TextViewWithCircularIndicator;

import org.w3c.dom.Text;

import java.util.Objects;

public class menu extends AppCompatActivity {

    TextView pass;

   private Switch SwitchDemo;
   private LinearLayout switchlayout;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SwitchDemo1 = "SwitchDemo";

    private boolean switchOnOff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
/*
        pass = (TextView) findViewById(R.id.pass);
        if (pass != null) {
            pass.setText(getIntent().getExtras().getString("value"));
        }
*/

        switchlayout=(LinearLayout)findViewById(R.id.switchlayout);
        SwitchDemo = (Switch) findViewById(R.id.SwitchDemo);



        SwitchDemo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveData();



                if (SwitchDemo.isChecked())
                {
                    switchlayout.setBackground(getDrawable(R.drawable.b));


                }
                else {
                    switchlayout.setBackground(getDrawable(R.drawable.f));
                }

            }
        });


        loadData();
        updateViews();


    }//oncreate



    public void saveData() {

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(SwitchDemo1, SwitchDemo.isChecked());

        editor.apply();

       // Toast.makeText(this, "Theme Changed", Toast.LENGTH_SHORT).show();


    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        switchOnOff = sharedPreferences.getBoolean(SwitchDemo1, false);
    }

    public void updateViews(){
        SwitchDemo.setChecked(switchOnOff);
    }






    public void rembtn(View view) {
        Intent intent = new Intent(menu.this, picker.class);
        startActivity(intent);
        finish();
    }




    public void agenbtn(View view) {
        Intent intent = new Intent(menu.this, Todo.class);
        startActivity(intent);
        finish();
    }



    public void calenbtn(View view) {
        Intent intent = new Intent(menu.this, calendar.class);
        startActivity(intent);
        finish();

    }



    public void notebtn(View view) {
        Intent intent = new Intent(menu.this, Notes.class);
        startActivity(intent);
        finish();
    }






//exit pag back
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure you want to Exit StuGenda?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        menu.super.onBackPressed();
                        finish();
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }




}