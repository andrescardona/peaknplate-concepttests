package com.helloandroid;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity {
  private static final int SECOND_SCREEN_REQUESTED = 0;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Starts the service for location
    this.startService(new Intent(this, AppService.class));

    setContentView(R.layout.main);

    Button btOpen1 = (Button) findViewById(R.id.btOpen1);
    btOpen1.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        executeOpenActivity();

      }
    });

    Button btOpen2 = (Button) findViewById(R.id.btOpen2);
    btOpen2.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        executeOpenActivityForResult();

      }
    });

    TextView text = (TextView) super.findViewById(R.id.textArea);

  }

  protected void executeOpenActivityForResult() {
    // Abrir activity Second sin tomar en cuenta la respuesta
    Intent intent = new Intent(this, Second.class);
    startActivityForResult(intent, SECOND_SCREEN_REQUESTED);

  }

  protected void executeOpenActivity() {
    // Abrir activity Second sin tomar en cuenta la respuesta
    Intent intent = new Intent(this, Second.class);
    startActivity(intent);

  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    // S�lo se ejecuta cuando el activity se llam� con
    // startActivityForResult
    if (requestCode == SECOND_SCREEN_REQUESTED) {
      System.out.println("onActivityResult!! SECOND_SCREEN_REQUESTED resultCode: "
                         + resultCode);
    }
  }

  @Override
  protected void onResume() {
    super.onResume();
    System.out.println("Main onResume!!");
  }

  @Override
  protected void onPause() {
    super.onPause();
    System.out.println("Main onPause!!");
  }

  @Override
  protected void onStop() {
    super.onStop();
    System.out.println("Main onStop!!");
  }
}