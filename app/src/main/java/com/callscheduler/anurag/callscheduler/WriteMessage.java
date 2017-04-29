package com.callscheduler.anurag.callscheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.id.message;

/**
 * Created by Anurag Ranjan on 20-Apr-17.
 */

public class WriteMessage extends Activity {

    EditText textSMS;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writemessage);

        textSMS = (EditText) findViewById(R.id.editTextMessage);

    }

    public void submitMessage(View V) {

        // get the Entered  message
        String str = textSMS.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("message", str);
        setResult(Activity.RESULT_OK, intent);
        // finish The activity

        finish();

    }

    // Function to handle event when back button pressed
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

}



