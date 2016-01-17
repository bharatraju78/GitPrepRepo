package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

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
		switch (item.getItemId()) {
			case R.id.app_menu_dashboard:
				Toast.makeText(MainActivity.this, "Dashboard is Selected", Toast.LENGTH_SHORT).show();
				return true;
			case R.id.app_menu_health_data:
				Intent intent = new Intent(this, ListHealthDataActivity.class);
				startActivity(intent);
				Toast.makeText(MainActivity.this, "Health Data is Selected", Toast.LENGTH_SHORT).show();
				return true;
			case R.id.app_menu_promotions:
				Toast.makeText(MainActivity.this, "Promotions is Selected", Toast.LENGTH_SHORT).show();
				return true;
			case R.id.app_menu_settings:
				Toast.makeText(MainActivity.this, "Settings is Selected", Toast.LENGTH_SHORT).show();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}
