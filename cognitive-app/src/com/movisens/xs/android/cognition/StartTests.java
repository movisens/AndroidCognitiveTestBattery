package com.movisens.xs.android.cognition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.movisens.xs.android.cognition.dualnback.DualNBack;
import com.movisens.xs.android.cognition.pvt.PVT;
import com.movisens.xs.android.cognitive.R;

public class StartTests extends Activity {

	private static final String TAG = "StartTests";

	private final String XS_config = "XS_config";
	private final String PVT_TestParameters_config = "{'minDelay':1000,'maxDelay':4000}";
	private final String DUALNBACK_TestParameters_config = "{}";

	public static final int PVT_REQUEST = 1;
	public static final int DUALNBACK_REQUEST = 2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.start_tests);

		final Context context = this;

		findViewById(R.id.pvt).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, PVT.class);
				intent.putExtra(XS_config, PVT_TestParameters_config);
				startActivityForResult(intent, PVT_REQUEST);
				startActivity(intent);
			}
		});

		findViewById(R.id.dualnback).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						Intent intent = new Intent(context, DualNBack.class);
						intent.putExtra(XS_config,
								DUALNBACK_TestParameters_config);
						startActivityForResult(intent, DUALNBACK_REQUEST);
						startActivity(intent);
					}
				});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);

		if (resultCode == RESULT_CANCELED) {
			// request was canceled, so do nothing
			return;
		}

		String result = "";

		switch (requestCode) {
		case PVT_REQUEST:
			result = ((Intent) intent).getStringExtra("value");
			break;
		case DUALNBACK_REQUEST:
			result = ((Intent) intent).getStringExtra("value");
			break;
		default:
			Log.d(TAG, "Result from unknown request");
		}

		Log.d(TAG, "PVT Result: " + result);
	}
}