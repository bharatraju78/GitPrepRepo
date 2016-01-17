package com.example.myfirstapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ListMeasurementDataActivity extends ListActivity {

	static final String[] MEASUREMENT_DATA_LIST = new String[] { "Weight", "Height", "Back" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new BodyMeasurementDataAdapter(this, MEASUREMENT_DATA_LIST));

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
				Toast.makeText(ListMeasurementDataActivity.this, "Dashboard is Selected", Toast.LENGTH_SHORT).show();
				return true;
			case R.id.app_menu_health_data:
				Intent intent = new Intent(this, ListMeasurementDataActivity.class);
				startActivity(intent);
				Toast.makeText(ListMeasurementDataActivity.this, "Health Data is Selected", Toast.LENGTH_SHORT).show();
				return true;
			case R.id.app_menu_promotions:
				Toast.makeText(ListMeasurementDataActivity.this, "Promotions is Selected", Toast.LENGTH_SHORT).show();
				return true;
			case R.id.app_menu_settings:
				Toast.makeText(ListMeasurementDataActivity.this, "Settings is Selected", Toast.LENGTH_SHORT).show();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected void onListItemClick(ListView listView, View view, int position, long id) {

		// get selected items
		String selectedValue = (String) getListAdapter().getItem(position);
		Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
		if ("Weight".equalsIgnoreCase(selectedValue)) {

		} else if ("Height".equalsIgnoreCase(selectedValue)) {

		} else if ("Back".equalsIgnoreCase(selectedValue)) {
			Intent intent = new Intent(this, ListHealthDataActivity.class);
			startActivity(intent);
		}

	}
}
