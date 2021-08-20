package com.jamper91.llamadows;

import java.util.HashMap;
import java.util.Map;




import com.jamper91.WebService.Asynchtask;
import com.jamper91.WebService.WebService;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity implements Asynchtask {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void acciones(View v)
	{
		switch (v.getId()) {
		case R.id.button1:
				//Llamo al ws
			Log.i("acciones", "Llamando al ws");
			Map<String, String> datos = new HashMap<String, String>();
            WebService ws= new WebService("http://192.168.1.46/codigobarras/students/getAllStudents.xml", datos, MainActivity.this, MainActivity.this);
            ws.execute("");
			break;

		default:
			break;
		}
	}

	@Override
	public void processFinish(String result) {
		// TODO Auto-generated method stub
		Log.i("processFinish", result);
		
	}
}
