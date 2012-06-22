package com.helloandroid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Second extends Activity implements OnClickListener {

	Button mBtClose;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		registerReceiver(broadcastReceiver, new IntentFilter("locAction"));
		setContentView(R.layout.second);
		mBtClose = (Button) findViewById(R.id.btClose);
		mBtClose.setOnClickListener(this);
	}
	
	private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
      updateUI(intent);
      context.unregisterReceiver(this);
    }
  };
  
  private void updateUI(Intent intent) {
    System.out.println("ENTRO A UPDATEUI");    
    TextView view = (TextView)this.findViewById(R.id.txtView);
    view.append(intent.getExtras().getString("userLocation"));
  }

	@Override
	public void onClick(View v) {
		setResult(RESULT_OK);
		finish();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		System.out.println("Second onResume!!");
	}

	@Override
	protected void onPause() {
		super.onPause();
		System.out.println("Second onPause!!");
	}

	@Override
	protected void onStop() {
		super.onStop();
		System.out.println("Second onStop!!");
	}	
}
