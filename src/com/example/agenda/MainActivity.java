package com.example.agenda;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class MainActivity extends Activity {
	EditText et1,et2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
    }

    public void guardar (View v) {
    	String fecha=et1.getText().toString();
    	String actividades=et2.getText().toString();
    	
    	SharedPreferences prefe1=getSharedPreferences("agenda", Context.MODE_PRIVATE);
    	
    	Editor editor1=prefe1.edit();
    	editor1.putString(fecha, actividades);
    	editor1.commit();
    	
    	Toast.makeText(this, "Los datos fueron grabados", Toast.LENGTH_LONG).show();
    	et1.setText("");
    	et2.setText("");
    	//Window /Show view /Other /File Explorer /Data /Data /com.example.agenda /shared_prefs /Descargo ese mismo archivo hacia el escritorio, pull a file from the device (diskete arriba a la derecha)
    }
    
    public void recuperar (View v) {
    	String fecha=et1.getText().toString();
    	
    	SharedPreferences prefe1=getSharedPreferences("agenda", Context.MODE_PRIVATE);
    	
    	String dato=prefe1.getString(fecha, ""); //el segundo dato que devuelve lo definí como vacío
    	
    	if (dato.length()>0) {
    		et2.setText(dato);
    		Toast.makeText(this, "Recuperado correctamente", Toast.LENGTH_LONG).show();
		}else{
			Toast.makeText(this, "No existen actividades para esa fecha", Toast.LENGTH_LONG).show();
		}
    }
}
