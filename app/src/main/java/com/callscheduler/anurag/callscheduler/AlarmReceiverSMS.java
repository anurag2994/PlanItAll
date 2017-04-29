package com.callscheduler.anurag.callscheduler;

/**
 * Created by Anurag Ranjan on 20-Apr-17.
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

public class AlarmReceiverSMS extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // Storing the value of number in state

        String state = intent.getExtras().getString("num");

        // here you can start an activity or service depending on your need
        // for ex you can start an activity to vibrate phone or to ring the phone
        // phone number to which Call to be made

        // SMS Code here

        // Phone Number
        String phoneNumberReceiver = state;
        // Message to send
        String message = intent.getExtras().getString("msg");
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumberReceiver, null, message, null, null);
        Toast.makeText(context.getApplicationContext(), "SMS Sent", Toast.LENGTH_LONG).show();

    }


}
