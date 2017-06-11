package overheardsite.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.TimeZone;

import java.util.concurrent.TimeUnit;

public class Waiting4Prayer1 extends AppCompatActivity {

    public long numberOfPeople;
    public long count = 0;


    Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting4_prayer1);

        //RelativeLayout waitLayout = new RelativeLayout(this);
        //waitLayout.setBackgroundColor(Color.WHITE);

        Button returnbutton = (Button) findViewById(R.id.returnButton);
        TextView time1 = (TextView) findViewById(R.id.textView12);
        TextView time2 = (TextView) findViewById(R.id.textView13);
        TextView time3 = (TextView) findViewById(R.id.textView14);

        TimeZone tz = TimeZone.getDefault();
        Date now = new Date();
        int offsetFromUtc = tz.getOffset(now.getTime()) / 1000 / 60 / 60; // should get timezone difference in hours

        if (offsetFromUtc == -7) {
            time1.setText("5:00 a.m.");
            time2.setText("11:00 a.m.");
            time3.setText("6:00 p.m.");
        }
        else if (offsetFromUtc == 14) {
            time1.setText("2:00 a.m.");
            time2.setText("8:00 a.m.");
            time3.setText("3:00 p.m.");
        }
        else if (offsetFromUtc == -4) {
            time1.setText(R.string.one);
            time2.setText(R.string.two);
            time3.setText(R.string.three);
        }
        /*else if (tz == TimeZone.getTimeZone("Pacific/Chatham")) {
            time1.setText("12:45 p.m.");
            time2.setText("6:45 a.m.");
            time3.setText("9:00 p.m.");
        }*/
        else if (offsetFromUtc == 13) {
            time1.setText("1:00 a.m.");
            time2.setText("7:00 a.m.");
            time3.setText("2:00 p.m.");
        }
        /*else if (tz == TimeZone.getTimeZone("Australia/Lord_Howe")) {
            time1.setText("10:30 p.m.");
            time2.setText("4:30 a.m.");
            time3.setText("11:30 a.m.");
        }*/
        else if (offsetFromUtc == 10) {
            time1.setText("10:00 p.m.");
            time2.setText("4:00 a.m.");
            time3.setText("11:00 a.m.");
        }
        /*else if (tz == TimeZone.getTimeZone("Australia/Adelaide")) {
            time1.setText("9:30 p.m.");
            time2.setText("3:30 a.m.");
            time3.setText("10:30 a.m.");
        }*/
        else if (offsetFromUtc == 9) {
            time1.setText("9:00 p.m.");
            time2.setText("3:00 a.m.");
            time3.setText("10:00 a.m.");
        }
        /*else if (tz == TimeZone.getTimeZone("Australia/Eucla")) {
            time1.setText("8:45 p.m.");
            time2.setText("2:45 a.m.");
            time3.setText("9:45 a.m.");
        }*/
        /*else if (tz == TimeZone.getTimeZone("Asia/Pyongyang")) {
            time1.setText("8:30 p.m.");
            time2.setText("2:30 a.m.");
            time3.setText("9:30 a.m.");
        }*/
        else if (offsetFromUtc == 8) {
            time1.setText("8:00 p.m.");
            time2.setText("2:00 a.m.");
            time3.setText("9:00 a.m.");
        }
        else if (offsetFromUtc == 7) {
            time1.setText("7:00 p.m.");
            time2.setText("1:00 a.m.");
            time3.setText("8:00 a.m.");
        }
        else if (offsetFromUtc == 6) {
            time1.setText("6:00 p.m.");
            time2.setText("12:00 a.m.");
            time3.setText("7:00 a.m.");
        }
        /*else if (tz == TimeZone.getTimeZone("Asia/Kathmandu")) {
            time1.setText("5:45 p.m.");
            time2.setText("11:45 p.m.");
            time3.setText("6:45 a.m.");
        }*/
        else if (offsetFromUtc == 5) {
            time1.setText("5:00 p.m.");
            time2.setText("11:00 p.m.");
            time3.setText("6:00 a.m.");
        }
        /*else if (tz == TimeZone.getTimeZone("Asia/Tehran")) {
            time1.setText("4:30 p.m.");
            time2.setText("10:30 p.m.");
            time3.setText("5:30 a.m.");
        }*/
        else if (offsetFromUtc == 4) {
            time1.setText("4:00 p.m.");
            time2.setText("10:00 p.m.");
            time3.setText("5:00 a.m.");
        }
        else if (offsetFromUtc == 3) {
            time1.setText("3:00 p.m.");
            time2.setText("9:00 p.m.");
            time3.setText("4:00 a.m.");
        }
        else if (offsetFromUtc == 2) {
            time1.setText("2:00 p.m.");
            time2.setText("8:00 p.m.");
            time3.setText("3:00 a.m.");
        }
        else if (offsetFromUtc == 1) {
            time1.setText("1:00 p.m.");
            time2.setText("7:00 p.m.");
            time3.setText("2:00 a.m.");
        }
        else if (offsetFromUtc == 0) {
            time1.setText("12:00 p.m.");
            time2.setText("6:00 p.m.");
            time3.setText("1:00 a.m.");
        }
        else if (offsetFromUtc == -3) {
            time1.setText("9:00 a.m.");
            time2.setText("3:00 p.m.");
            time3.setText("10:00 p.m.");
        }
        else if (offsetFromUtc == -5) {
            time1.setText("7:00 a.m.");
            time2.setText("1:00 p.m.");
            time3.setText("8:00 p.m.");
        }
        else if (offsetFromUtc == -6) {
            time1.setText("6:00 a.m.");
            time2.setText("12:00 a.m.");
            time3.setText("7:00 p.m.");
        }
        else if (offsetFromUtc == -8) {
            time1.setText("4:00 a.m.");
            time2.setText("10:00 a.m.");
            time3.setText("5:00 p.m.");
        }
        else if (offsetFromUtc == -9) {
            time1.setText("3:00 a.m.");
            time2.setText("9:00 a.m.");
            time3.setText("4:00 p.m.");
        }
        else if (offsetFromUtc == -10) {
            time1.setText("2:00 a.m.");
            time2.setText("8:00 a.m.");
            time3.setText("3:00 p.m.");
        }


        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            description.setId(View.generateViewId());
        }
        else{
            description.setId(1);
        }

        Resources r = getResources();
        int px1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, r.getDisplayMetrics());
        int px2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, r.getDisplayMetrics());
        int px3 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, r.getDisplayMetrics());
        int px4 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, r.getDisplayMetrics());
        int px5 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, r.getDisplayMetrics());
        int px6 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, r.getDisplayMetrics());

        RelativeLayout.LayoutParams returnbuttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams descriptionDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        returnbuttonDetails.addRule(RelativeLayout.BELOW, description.getId());
        returnbuttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        returnbuttonDetails.setMargins(px6, px4, px6, px5);
        returnbutton.setLayoutParams(returnbuttonDetails);
        returnbutton.setTextColor(Color.BLACK);
        returnbutton.setText("Return to the Homepage.");
        returnbutton.setBackgroundColor(Color.RED);

        descriptionDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        descriptionDetails.setMargins(px3, px2, px3, px2);
        description.setLayoutParams(descriptionDetails);
        description.setTextSize(px5);
        description.setWidth(px1);
        description.setText("At 8:00 a.m. EST, 2:00 p.m. EST, and 9:00 p.m. EST this page will switch to the prayer. " +
                "Stay on this page just before these times in order to join others in prayer");
        description.setTextColor(Color.BLACK);

        waitLayout.addView(returnbutton, returnbuttonDetails);
        waitLayout.addView(description, descriptionDetails);

        setContentView(waitLayout);
        */

        // hopefully makes all phones' timezones EST so their activities change at the right time
        /////TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));


        ////final Firebase mRef;
        ////mRef = new Firebase("https://my-awesome-project-ce89c.firebaseio.com/");

        CompositeOnClickListener compositeListener = new CompositeOnClickListener();

        returnbutton.setOnClickListener(compositeListener);

        ///////final TelephonyManager id = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
        //////final String[] tmDevice = new String[1];
        // I do this twice (this and the onclicklistener) just to make sure cause i dont really know how it works
        ///////tmDevice[0] = "" + id.getDeviceId();

        /*compositeListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tmDevice[0] = "" + id.getDeviceId();

            }
        });
        */

        // supposed to remove the person's imei id from the database when they return to the homepage
//        compositeListener.addOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //////mRef.child(tmDevice[0]).removeValue();
//
//                count = DataHolder.getData();
//                count--;
//                DataHolder.setData(count);
//
//                // should delete the child IMEI and its values
//                // don't know if I should have the mRefChild2 in the MainActivity cause it seems that's where the value is
//                // being set but idk
//                //mRef.child(tmDevice[0]).removeValue();
//
//                /*DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
//                Query IMEIQuery = ref.child("IMEI").orderByChild("title").equalTo(tmDevice[0]);
//
//                // I SERIOUSLY do no know if this works <<<<<<<<<<<<<<<<<<<<<<<<<<<<
//                IMEIQuery.getRef().removeValue();
//                */
//            }
//        });

        final SharedPreferences sharedPreferences = getSharedPreferences("counter", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        final SharedPreferences pref = getSharedPreferences("countTotal", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edits = pref.edit();

        compositeListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Long counts = sharedPreferences.getLong("count", 0);

                counts--;

                editor.putLong("count", counts);
                editor.apply();

                Long total = pref.getLong("total", 0);
                total--;

                edits.putLong("total", total);
                edits.apply();

                System.out.println("banana" + counts + total);

                Intent intent = new Intent(Waiting4Prayer1.this, MainActivity.class);

                startActivity(intent);

            }
        });

        // the following code should cause the Waiting4Prayer1 activity to close and go to the Prayer1 activity at
        // 2:00 and 0 seconds everyday; 2:00 is when the prayer would be and 2:03 is when it would end

        // if person's timezone is that of New York, the calendar will be set and the activity
        // will switch to/at 2:00
        //TimeZone tz = TimeZone.getDefault();
        // how does this work in different time zones??

/*
        DatabaseReference fbDb = FirebaseDatabase.getInstance().getReference();

        fbDb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                numberOfPeople = dataSnapshot.getChildrenCount();
                DataHolder.setData(numberOfPeople);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
*/

        /* FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        //You must remember to remove the listener when you finish using it, also to keep track of changes you can use the ChildChange
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                numberOfPeople = dataSnapshot.getChildrenCount();
                DataHolder.setData(numberOfPeople);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                numberOfPeople = dataSnapshot.getChildrenCount();
                DataHolder.setData(numberOfPeople - 3);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/

        /*
        Calendar calendarend1 = Calendar.getInstance();
        calendarend1.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        calendarend1.set(Calendar.HOUR, 8);
        calendarend1.set(Calendar.MINUTE, 0);
        calendarend1.set(Calendar.SECOND, 5);

        calendar.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        // went off at 8:00 p.m........
        calendar.set(Calendar.HOUR, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Intent intent = new Intent(Waiting4Prayer1.this, Prayer1.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(Waiting4Prayer1.this, (int) System.currentTimeMillis(), intent, PendingIntent.FLAG_ONE_SHOT);

        ((AlarmManager) getSystemService(ALARM_SERVICE)).set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        if (time >= calendarend1.getTimeInMillis()) {
            pendingIntent.cancel();
        }

        Calendar calendarend2 = Calendar.getInstance();
        calendarend2.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        calendarend2.set(Calendar.HOUR, 14);
        calendarend2.set(Calendar.MINUTE, 0);
        calendarend2.set(Calendar.SECOND, 5);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        calendar2.set(Calendar.HOUR, 14);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);

        Intent intent2 = new Intent(Waiting4Prayer1.this, Prayer2.class);

        PendingIntent pendingIntent2 = PendingIntent.getActivity(Waiting4Prayer1.this, (int) System.currentTimeMillis(), intent2, PendingIntent.FLAG_ONE_SHOT);

        ((AlarmManager) getSystemService(ALARM_SERVICE)).set(AlarmManager.RTC_WAKEUP, calendar2.getTimeInMillis(), pendingIntent2);

        if (time >= calendarend2.getTimeInMillis()) {
            pendingIntent2.cancel();
        }

        Calendar calendarend3 = Calendar.getInstance();
        calendarend3.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        calendarend3.set(Calendar.HOUR, 22);
        calendarend3.set(Calendar.MINUTE, 36);
        calendarend3.set(Calendar.SECOND, 5);

        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        calendar3.set(Calendar.HOUR, 22);
        calendar3.set(Calendar.MINUTE, 36);
        calendar3.set(Calendar.SECOND, 0);

        Intent intent3 = new Intent(Waiting4Prayer1.this, Prayer3.class);

        PendingIntent pendingIntent3 = PendingIntent.getActivity(Waiting4Prayer1.this, (int) System.currentTimeMillis(), intent3, PendingIntent.FLAG_ONE_SHOT);

        ((AlarmManager) getSystemService(ALARM_SERVICE)).set(AlarmManager.RTC_WAKEUP, calendar3.getTimeInMillis(), pendingIntent3);

        if (time >= calendarend3.getTimeInMillis()) {
            pendingIntent3.cancel();
        }
        */

        Intent change1 = new Intent(Waiting4Prayer1.this, Prayer1.class);
        Intent change2 = new Intent(Waiting4Prayer1.this, Prayer2.class);
        Intent change3 = new Intent(Waiting4Prayer1.this, Prayer3.class);

        long millis = System.currentTimeMillis();
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("Africa/Casablanca"));
        c.setTimeInMillis(millis);

        int hours = c.get(Calendar.HOUR_OF_DAY);
        int minutes = c.get(Calendar.MINUTE);
        int seconds = c.get(Calendar.SECOND);

            startActivity(change3);

        if (hours == 12 && minutes == 0) { // starts activity at 8:00 am EST
            if (seconds > 0) {
                if (seconds < 5) {
                    startActivity(change1);
                }
            }
        }
        else if (hours == 18 && minutes == 0) {
            if (seconds >= 0) {
                if (seconds <= 5) {
                    startActivity(change2);
                }
            }
        }
        else if (hours == 1 && minutes == 0) {
            if (seconds >= 0) {
                if (seconds <= 5) {
                    startActivity(change3);
                }
            }
        }

    }
}