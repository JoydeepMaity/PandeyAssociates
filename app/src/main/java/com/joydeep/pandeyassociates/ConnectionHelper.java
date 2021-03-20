package com.joydeep.pandeyassociates;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection Connection;
    String ip,port,db,un,pass;

    @SuppressLint("NewApi")
    public Connection conclass() {
        ip="0.0.0.0";
        port="51688";
        db="Joydeep";
        un="sa";
        pass="test12345";
        StrictMode.ThreadPolicy tpolicy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tpolicy);
        Connection con = null;
        String ConnectionURL = null;
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL= "jdbc:jtds:sqlserver://"+ ip + ":"+ port+";"+ "databasename="+ db+";user="+un+";password="+pass+";";
            con= DriverManager.getConnection(ConnectionURL);
        }
        catch (Exception ex)
        {
            Log.e(" Error : ", ex.getMessage());

        }
        return con;


    }
}
