package com.joydeep.pandeyassociates;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class SearchActivity extends AppCompatActivity {

    Connection connect;
    String connectionResult="";
    //EditText editText;
    EditText nm;
    //Button clearButton;



    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        nm = (EditText) findViewById(R.id.et_rg);
        //clearButton.setOnClickListener(new View.OnClickListener() {
            //public void onClick(View v) {

                //nm.setText("");

            //}
        //});

    }
    public void GetDataToTextView(View v){
        String n  = nm.getText().toString();
        TextView txt1 =(TextView) findViewById(R.id.Contract_No);
        TextView txt2 =(TextView) findViewById(R.id.name);
        TextView txt3 =(TextView) findViewById(R.id.Vehicle);
        TextView txt4 =(TextView) findViewById(R.id.Chassis_no);
        TextView txt5 =(TextView) findViewById(R.id.Engine_No);
        //EditText etxt =(EditText) findViewById(R.id.et_rg);
        try{
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect= connectionHelper.conclass();
            if(connect!=null)
            {
                String query = "Select * from Sheet1$ where RC_No='"+n+"'";
                Statement smt = connect.createStatement();
                ResultSet rs = smt.executeQuery(query);

                while (rs.next())
                {
                    txt1.setText(rs.getString(1));
                    txt2.setText(rs.getString(2));
                    txt3.setText(rs.getString(3));
                    txt4.setText(rs.getString(4));
                    txt5.setText(rs.getString(5));
                }

            }

        }
        catch (Exception ex)
        {
            Log.e("Error :", ex.getMessage());

        }
    }

}
