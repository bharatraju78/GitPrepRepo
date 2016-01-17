package com.example.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthDataAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final String[] values;
	
	public HealthDataAdapter(Context context, String[] values) {
		super(context, R.layout.list_healthdata, values);
		this.context = context;
		this.values = values;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.list_healthdata, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.healthDataItem);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		textView.setText(values[position]);

		// Change icon based on name
		String s = values[position];

		System.out.println(s);

		if (s.equals("Fitness")) {
			imageView.setImageResource(R.drawable.ic_launcher);
		} else if (s.equals("Nutrition")) {
			imageView.setImageResource(R.drawable.ic_launcher);
		} else if (s.equals("BodyMeasurements")) {
			imageView.setImageResource(R.drawable.ic_launcher);
		} else if (s.equals("Vitals")) {
			imageView.setImageResource(R.drawable.ic_launcher);
		}else {
			imageView.setImageResource(R.drawable.ic_launcher);
		}

		return rowView;
	}
}
