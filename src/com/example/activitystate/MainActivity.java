package com.example.activitystate;

import java.util.Timer;
import java.util.TimerTask;

import com.example.activitystate.R;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Timer   mTimer   = null;            //onClickメソッドでインスタンス生成
	Handler mHandler = new Handler();   //UI Threadへのpost用ハンドラ
	int m_count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("appstate", "main create");
		setContentView(R.layout.activity_main);
		// タイマー
		mTimer = new Timer(false);
		mTimer.schedule( new TimerTask(){
	        @Override
	        public void run() {
	            // mHandlerを通じてUI Threadへ処理をキューイング
	            mHandler.post( new Runnable() {
	                public void run() {
	                	m_count++;
	                	TextView textView = (TextView)findViewById(R.id.textView1);
	                	textView.setText("count:" + m_count);
	                }
	            });
	        }
	    }, 100, 1000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void buttonMethod(View button){
		Intent intent = new Intent(this, SubActivity.class);
		startActivity(intent);
	}
	
	public void buttonMethod2(View button){
		Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
	}

	public void buttonMethod3(View button){
		Intent intent = new Intent(this, ThirdActivity.class);
		startActivity(intent);
	}

	public void buttonMethod4(View button){
    	// アラートビルダ準備
    	AlertDialog.Builder myBuilder = new AlertDialog.Builder(this);
    	myBuilder.setTitle("My Alert Dialog");
    	myBuilder.setMessage("Are you really sure?");
    	// リスナを作る
    	MyListener listener = new MyListener(); // 独自リスナ
    	myBuilder.setPositiveButton("Yes", listener); // 左側のボタン
    	myBuilder.setNeutralButton("Maybe", listener); // 真ん中のボタン
    	//myBuilder.setNegativeButton("No", listener); // 右側のボタン
    	myBuilder.setCancelable(true);
    	myBuilder.setOnCancelListener(listener);
    	// ビルダによりダイアログ作成
    	AlertDialog myAlertDialog = myBuilder.create();
    	myAlertDialog.show();
	}

	public void buttonMethod5(View button){
		Intent intent = new Intent();
		intent.setClassName("com.example.alpha", "com.example.alpha.MainActivity");
		startActivity(intent);
	}

	public void buttonMethod6(View button){
		finish();
	}

    // もうここはコピペでいいかな
    public class MyListener implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener{// android.content.DialogInterface.OnClickListener {
    		/*
			@Override
    		public void onClick(DialogInterface v, int i) {
    			aTextView.setText(String.format("You selected %d", i));
    		}
    		*/
			@Override
			public void onClick(DialogInterface dialog, int which) {
				TextView aTextView = (TextView)findViewById(R.id.textView2);
				// TODO Auto-generated method stub
    			switch(which){
    			case AlertDialog.BUTTON_POSITIVE:
        			aTextView.setText("positive");
        			break;
    			case AlertDialog.BUTTON_NEUTRAL:
        			aTextView.setText("neutral");
        			break;
    			case AlertDialog.BUTTON_NEGATIVE:
        			aTextView.setText("negative");
        			break;
				default:
        			aTextView.setText(String.format("You selected %d", which));
					return;
    			}
			}

			@Override
			public void onCancel(DialogInterface dialog) {
				TextView aTextView = (TextView)findViewById(R.id.textView2);
				aTextView.setText("Canceled");
			}
    }

	@Override
	protected void onDestroy() {
		Log.i("appstate", "main destroy");
		super.onDestroy();
	}

	@Override
	protected void onStart() {
		Log.i("appstate", "main start");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		Log.i("appstate", "main restart");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.i("appstate", "main resume");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.i("appstate", "main pause");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.i("appstate", "main stop");
		super.onStop();
	}

}
