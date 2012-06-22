package com.helloandroid;

import java.util.List;
import java.util.Locale;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.widget.TextView;

public class AppService extends Service implements LocationListener {

  public static final String LOCATION_SERVICE = "com.helloandroid.service.location";

  private Intent intent;

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    intent = new Intent("locAction");

    LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
    // Gets the location using the Network Provider
    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0,
                                           0, this);
  }

  @Override
  public void onStart(Intent intent, int startid) {

  }

  public void onLocationChanged(Location location) {
    try {

      Geocoder gcd = new Geocoder(this.getApplicationContext(),
                                  Locale.getDefault());
      List<Address> addresses = gcd.getFromLocation(location.getLatitude(),
                                                    location.getLongitude(), 1);
      // Gets the city name
      this.intent.putExtra("userLocation", addresses.get(0).getLocality());
      this.sendStickyBroadcast(intent);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void onStatusChanged(String provider, int status, Bundle extras) {
  }

  public void onProviderEnabled(String provider) {
  }

  public void onProviderDisabled(String provider) {
  }

  @Override
  public void onDestroy() {
    // code to execute when the service is shutting down
  }

  public Intent getIntent() {
    return intent;
  }

  public void setIntent(Intent intent) {
    this.intent = intent;
  }

}
