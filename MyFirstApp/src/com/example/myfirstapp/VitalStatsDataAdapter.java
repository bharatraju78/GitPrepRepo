package com.example.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class VitalStatsDataAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final String[] values;
	
	public VitalStatsDataAdapter(Context context, String[] values) {
		super(context, R.layout.list_vitalstats, values);
		this.context = context;
		this.values = values;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.list_vitalstats, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.vitalStatDataItem);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		textView.setText(values[position]);

		// Change icon based on name
		String s = values[position];

		System.out.println(s);

		if (s.equals("BloodPressure")) {
			imageView.setImageResource(R.drawable.ic_launcher);
		} else if (s.equals("BloodSugar")) {
			imageView.setImageResource(R.drawable.ic_launcher);
		} else if (s.equals("HeartRate")) {
			imageView.setImageResource(R.drawable.ic_launcher);
		} else {
			imageView.setImageResource(R.drawable.ic_launcher);
		}

		return rowView;
	}
}
