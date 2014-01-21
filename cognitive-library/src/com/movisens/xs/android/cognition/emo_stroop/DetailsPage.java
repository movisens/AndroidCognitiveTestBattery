package com.movisens.xs.android.cognition.emo_stroop;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * This activity displays the test result for every individual word in a list.
 * It can be activated after the test is over.
 * 
 * @author Stephan Grund
 * 
 */
public class DetailsPage extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Sets the main list with an additional footnote.
		ListView lv = new ListView(this);
		lv.setId(android.R.id.list);
		TextView footnote = new TextView(this);
		footnote.setText("* emotional words");
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT, 1);
		ll.addView(lv, lp);
		ll.addView(footnote);
		this.setContentView(ll);

		Intent intent = getIntent();

		try {
			@SuppressWarnings("unchecked")
			List<Result> results = (List<Result>) new ObjectInputStream(
					new ByteArrayInputStream(
							intent.getByteArrayExtra("results"))).readObject();
			Set<String> emotionalWords = new HashSet<String>(
					intent.getStringArrayListExtra("emotional"));
//			Set<String> neutralWords = new HashSet<String>(
//					intent.getStringArrayListExtra("neutral"));

			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1);
			for (int i = 0; i < results.size(); i++) {
				final Result r = results.get(i);
				adapter.add(r.testWord
						+ (emotionalWords.contains(r.testWord) ? "*" : "")
						+ ": " + r.reaction + " ms (" + r.choice + ")");
			}

			this.setListAdapter(adapter);

		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
