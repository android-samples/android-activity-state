package com.example.activitystate;

import com.example.activitystate.R;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class SubActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("appstate", "sub create");
		setContentView(R.layout.activity_sub);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub, menu);
		return true;
	}
	
	public void buttonMethod(View button){
		finish();
	}
	
	@Override
	protected void onDestroy() {
		Log.i("appstate", "sub destroy");
		super.onDestroy();
	}

	@Override
	protected void onStart() {
		Log.i("appstate", "sub start");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		Log.i("appstate", "sub restart");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.i("appstate", "sub resume");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.i("appstate", "sub pause");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.i("appstate", "sub stop");
		super.onStop();
	}

}
