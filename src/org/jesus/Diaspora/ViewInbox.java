package org.jesus.Diaspora;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class ViewInbox extends Activity {
	List<Message> inbox = new ArrayList<Message>();
	List<LinearLayout> list = new ArrayList<LinearLayout>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.message_inbox);
		Toast.makeText(getBaseContext(), "example of the inbox view",
				Toast.LENGTH_LONG).show();
		// load the simulated messages
		loadSimulatedNotifys();
		// load the interface with the simulated messages
		loadInterface();
		((Button) findViewById(R.id.new_message))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(ViewInbox.this,
								NewMessage.class));
						//finish();
					}
				});

	}

	private void loadInterface() {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		for (int i = 0; i < inbox.size(); i++) {
			View v = inflater.inflate(R.layout.message_list_element, null);
			v.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					startActivity(new Intent(ViewInbox.this,Conversation.class));
				}});
			((LinearLayout) findViewById(R.id.layout_message_inbox)).addView(v);
		}

	}

	private void loadSimulatedNotifys() {
		// TODO Auto-generated method stub
		List<Message> l1 = new ArrayList<Message>();

		l1.add(new Message("Receiver name", "Sender name", "matter",
				"This is the message body", (java.sql.Date) new Date(Date
						.parse("Thu, 12 May 2010 12:16:00 GMT-0500"))));
		l1.add(new Message("Receiver name", "Sender name", "matter",
				"This is the message body", (java.sql.Date) new Date(Date
						.parse("Thu, 12 May 2010 12:16:00 GMT-0500"))));
		l1.add(new Message("Receiver name", "Sender name", "matter",
				"This is the message body", (java.sql.Date) new Date(Date
						.parse("Thu, 12 May 2010 12:16:00 GMT-0500"))));
		l1.add(new Message("Receiver name", "Sender name", "matter",
				"This is the message body", (java.sql.Date) new Date(Date
						.parse("Thu, 12 May 2010 12:16:00 GMT-0500"))));
		l1.add(new Message("Receiver name", "Sender name", "matter",
				"This is the message body", (java.sql.Date) new Date(Date
						.parse("Thu, 12 May 2010 12:16:00 GMT-0500"))));
		inbox = l1;

	}


}
