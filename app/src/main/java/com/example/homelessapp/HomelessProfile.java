package com.example.homelessapp;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homelessapp.Database.HomelessPerson;
import com.example.homelessapp.Database.SampleDataProvider;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class HomelessProfile extends AppCompatActivity {

    private HomelessPerson homelessPerson;
    private int homelessId;
//    private String userName;

    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;
    private IntentFilter writeTagFilters[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeless_profile);

//        Intent intent = getIntent();
//        userName = intent.getStringExtra("USERNAME");
//        int id = intent.getIntExtra("HOMELESS-ID", -1);
//        if(id == -1){
//            id = 4321; //todo fix this please
//        }

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter == null) {
            // Stop here, we definitely need NFC
            finish();
        }
        String id = readFromIntent(getIntent());

        pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        IntentFilter tagDetected = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
        tagDetected.addCategory(Intent.CATEGORY_DEFAULT);
        writeTagFilters = new IntentFilter[]{tagDetected};

        homelessId = Integer.valueOf(id);
        for (HomelessPerson person: SampleDataProvider.homelessPeople) {
            if(homelessId == person.getId()){
                homelessPerson = person;
                break;
            }
        }

        ImageView profileImage = findViewById(R.id.profile_image);
        int imageId = getResources().getIdentifier("drawable/" + homelessPerson.getPicture(), null, getPackageName());
        profileImage.setImageResource(imageId);

        TextView tv = findViewById(R.id.about_content);
        tv.setText(homelessPerson.getBiography());
        tv.setMovementMethod(new ScrollingMovementMethod());

        TextView tv2 = findViewById(R.id.life_goals_content);
        tv2.setText(homelessPerson.getLifeGoals());
        tv2.setMovementMethod(new ScrollingMovementMethod());

        TextView firstName = findViewById(R.id.first_name);
        firstName.setText(homelessPerson.getFirstName());

        TextView lastName = findViewById(R.id.last_name);
        lastName.setText(homelessPerson.getLastName());

        TextView location = findViewById(R.id.location);
        location.setText(homelessPerson.getLocation());


        Button donateButton = findViewById(R.id.donate);



//        final int idToSend = id;
        donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomelessProfile.this, DonationPots.class);
                intent.putExtra("USERNAME", "bob");  //todo fix this
                intent.putExtra("HOMELESS-ID", homelessId);
                startActivity(intent);
            }
        });



    }

    private String readFromIntent(Intent intent) {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            NdefMessage[] msgs = null;
            if (rawMsgs != null) {
                msgs = new NdefMessage[rawMsgs.length];
                for (int i = 0; i < rawMsgs.length; i++) {
                    msgs[i] = (NdefMessage) rawMsgs[i];
                }
            }
            return buildTagViews(msgs);
        }
        return "";
    }

    private String buildTagViews(NdefMessage[] msgs) {
        if (msgs == null || msgs.length == 0) return "";

        String text = "";
        byte[] payload = msgs[0].getRecords()[0].getPayload();
        String textEncoding = ((payload[0] & 128) == 0) ? "UTF-8" : "UTF-16"; // Get the Text Encoding
        int languageCodeLength = payload[0] & 0063; // Get the Language Code, e.g. "en"

        try {
            // Get the Text
            text = new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding);
        } catch (UnsupportedEncodingException e) {
            Log.e("UnsupportedEncoding", e.toString());
        }
        return text;
    }
}
