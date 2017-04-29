package com.callscheduler.anurag.callscheduler;

/**
 * Created by Anurag Ranjan on 19-Apr-17.
 */

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;
import android.widget.Toast;

public class AlarmReceiverCall extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // Storing the value of number in state

        String state = intent.getExtras().getString("num");

        // here you can start an activity or service depending on your need
        // for ex you can start an activity to vibrate phone or to ring the phone
        // phone number to which Call to be made

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + state));
        // Adding this flag so that we are able to startactivty in onReceive
        callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        context.startActivity(callIntent);

        // Show the toast
        Toast.makeText(context, "Call made", Toast.LENGTH_LONG).show();
    }

}