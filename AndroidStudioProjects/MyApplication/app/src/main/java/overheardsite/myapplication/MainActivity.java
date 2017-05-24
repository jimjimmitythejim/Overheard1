package overheardsite.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import java.util.Calendar;
import java.util.TimeZone;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;
import static java.util.TimeZone.getTimeZone;

// FOR ALL ACTIVITIES SOMETIMES THERE WERE MULTIPLE OPTIONS AVAILABLE TO IMPORT SO JUST SAYING IF THERE'S SOME RANDOM PROBLEM IN THE FUTURE
// IT MIGHT BE BECAUSE THE WRONG OPTION WAS IMPORTED

public class MainActivity extends AppCompatActivity {

    public long numberOfPeople;
    public long count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*RelativeLayout mainLayout = new RelativeLayout(this);
        mainLayout.setBackgroundColor(Color.WHITE);
        */

        // widgets
        Button wait4prayer = (Button) findViewById(R.id.sendDataButton);
        TextClock clock1 = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock1 = (TextClock) findViewById(R.id.textClock);
        }
        /*TextClock clock2 = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock2 = new TextClock(this);
        }
        TextClock clock3 = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock3 = new TextClock(this);
        }
        TextClock clock4 = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock4 = new TextClock(this);
        }*/
        // textclock is only available after api lvl 17; the min you have set is 15
        TextView description = (TextView) findViewById(R.id.WhenToGather);
        TextView bibleQuote = (TextView) findViewById(R.id.textView6);
        //Toolbar actionbar = new Toolbar(this);

        /*
        Resources r = getResources();
        int px1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120, r.getDisplayMetrics());
        int px2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, r.getDisplayMetrics());
        int px3 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, r.getDisplayMetrics());
        int px4 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, r.getDisplayMetrics());
        int px5 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, r.getDisplayMetrics());
        int px6 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250, r.getDisplayMetrics());
        int px7 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, r.getDisplayMetrics());
        int px8 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 350, r.getDisplayMetrics());
*/
        /*
        final float scale = this.getResources().getDisplayMetrics().density;
        int pixels = (int) (300 * scale + 0.5f);
        int pixels2 = (int) (350 * scale + 0.5f);
        int pixels3 = (int) (50 * scale + 0.5f);
        int textSize = (int) (10 * scale + 0.5f);

        //set ids
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock1.setId(View.generateViewId());
        }
        else{
            clock1.setId(1);
        }*/
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock2.setId(View.generateViewId());
        }
        else{
            clock2.setId(5);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock3.setId(View.generateViewId());
        }
        else{
            clock3.setId(6);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock4.setId(View.generateViewId());
        }
        else{
            clock4.setId(7);
        }*/
        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            description.setId(View.generateViewId());
        }
        else{
            description.setId(2);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            wait4prayer.setId(View.generateViewId());
        }
        else{
            wait4prayer.setId(3);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            bibleQuote.setId(View.generateViewId());
        }
        else{
            bibleQuote.setId(4);
        }

        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams clock1Details = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams descriptionDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams bibleQuoteDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );*/
        /*RelativeLayout.LayoutParams clock2Details = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams clock3Details = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams clock4Details = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );*/

 /*       // button to Waiting4Prayer1
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        //buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);
        buttonDetails.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        wait4prayer.setWidth(pixels);
        buttonDetails.setMargins(0, pixels3, 0, pixels3);
        wait4prayer.setLayoutParams(buttonDetails); // do i need these???
        wait4prayer.setText("Join Friends in Prayer");
        wait4prayer.setTextColor(Color.BLACK);
        wait4prayer.setBackgroundColor(Color.RED);
        */
/*
        descriptionDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        descriptionDetails.addRule(RelativeLayout.ABOVE, wait4prayer.getId());
        descriptionDetails.setMargins(10, 10, 10, 10);
        description.setTextSize(textSize);
        description.setWidth(pixels);
        description.setGravity(Gravity.CENTER);
        description.setLayoutParams(descriptionDetails);
        description.setText("Join friends in prayer everyday at 8:00 a.m. EST, 2:00 p.m. EST, and 9:00 p.m. EST.");
        description.setTextColor(Color.BLACK);
        */
/*
        clock1Details.addRule(RelativeLayout.CENTER_HORIZONTAL);
        clock1Details.addRule(RelativeLayout.ABOVE, bibleQuote.getId());
        clock1Details.setMargins(0, 10, 0, 10);
        clock1.setLayoutParams(clock1Details);
        clock1.setTextSize(textSize);
        clock1.setTextColor(Color.BLACK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock1.setFormat12Hour("hh:mm:ss a");
        }*/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock1.setTimeZone(TimeZone.getDefault().toString());
        }
        // NULL POINTER EXCEPTION IS BECAUSE OF API CONSTRAINT

/*
        clock2Details.addRule(RelativeLayout.CENTER_HORIZONTAL);
        clock2Details.addRule(RelativeLayout.ABOVE, clock3.getId());
        clock2Details.setMargins(0, px2, 0, px2);
        clock2.setLayoutParams(clock2Details);
        clock2.setTextSize(px2);
        clock2.setTextColor(Color.BLACK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock2.setFormat12Hour("hh:mm:ss a");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock2.setTimeZone("America/Chicago");
        }

        clock3Details.addRule(RelativeLayout.CENTER_HORIZONTAL);
        clock3Details.addRule(RelativeLayout.ABOVE, clock4.getId());
        clock3Details.setMargins(0, px2, 0, px2);
        clock3.setLayoutParams(clock3Details);
        clock3.setTextSize(px2);
        clock3.setTextColor(Color.BLACK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock3.setFormat12Hour("hh:mm:ss a");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock3.setTimeZone("America/Denver");
        }

        clock4Details.addRule(RelativeLayout.CENTER_HORIZONTAL);
        clock4Details.addRule(RelativeLayout.ABOVE, bibleQuote.getId());
        clock4Details.setMargins(0, px2, 0, px2);
        clock4.setLayoutParams(clock4Details);
        clock4.setTextSize(px2);
        clock4.setTextColor(Color.BLACK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock4.setFormat12Hour("hh:mm:ss a");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            clock4.setTimeZone("America/Los_Angeles");
        }
*/
/*
        bibleQuoteDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        bibleQuoteDetails.addRule(RelativeLayout.ABOVE, description.getId());
        bibleQuoteDetails.setMargins(0, 0, 0, 10);
        bibleQuote.setWidth(pixels2);
        bibleQuote.setTextSize(textSize);
        bibleQuote.setLayoutParams(bibleQuoteDetails);
        bibleQuote.setText(Html.fromHtml("<i>\"For where two or three gather together in My name, there I am with them.\"</i> (MT 18:20)"));
        bibleQuote.setTextColor(Color.BLACK);
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            bibleQuote.setGravity(Gravity.CENTER);
        //}
*/
        //actionbar.setBackgroundColor(Color.CYAN);
/*
        mainLayout.addView(wait4prayer, buttonDetails);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mainLayout.addView(clock1, clock1Details);
        }
        mainLayout.addView(description, descriptionDetails);
        mainLayout.addView(bibleQuote, bibleQuoteDetails);
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        //    mainLayout.addView(clock2, clock2Details);
        //}
        //mainLayout.addView(clock3, clock3Details);
        //mainLayout.addView(clock4, clock4Details);
*/
        //setContentView(mainLayout);

            // Firebase variable
            final Firebase mRef2;

            // was using a different way to get the id
            // final String id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

            final TelephonyManager id = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);

            // android suggested that the IMEI_Number_Holder be an array; idk why
            final String[] tmDevice = new String[1];
/*
            mSendData = (Button) findViewById(R.id.sendDataButton);
//            if (mSendData.getParent() != null)
//                ((ViewGroup) mSendData.getParent()).removeView(mSendData); // <- fix
//            mainLayout.addView(mSendData);

            est = (TextView) findViewById(R.id.textView6);
//            if (est.getParent() != null)
//                ((ViewGroup) est.getParent()).removeView(est); // <- fix
//            mainLayout.addView(est);

            gather = (TextView) findViewById(R.id.WhenToGather);
//            if (gather.getParent() != null)
//                ((ViewGroup) gather.getParent()).removeView(gather); // <- fix
//            mainLayout.addView(gather);

            time = (TextClock) findViewById(R.id.textClock);
            // min api level in order to switch TextClock to View is 17 and the current setting has the
            // min at 15, so there is this if statement
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//                if (time.getParent() != null)
//                    ((ViewGroup) time.getParent()).removeView(time); // <- fix
//                mainLayout.addView(time);
            }
*/
            mRef2 = new Firebase("https://my-awesome-project-ce89c.firebaseio.com/");

            // just doing this to make sure the id is gotten before the onclicklistener sends the value to the database
            //  // //  tmDevice[0] = "" + id.getDeviceId();

            // sets it so that multiple functions happen with one click of the button such as
            // sending data to database and opening the Waiting4Prayer activity
            CompositeOnClickListener groupListener = new CompositeOnClickListener();

            wait4prayer.setOnClickListener(groupListener);

            // gets imei, device id.... DON'T KNOW IF THIS WORKS, but idk why it wouldn't
            groupListener.addOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tmDevice[0] = "" + id.getDeviceId();
                }
            });


            // putting in data with a click just to test whether or not the numberOfPeople will be counted and shown in the HowManyPrayed TextView
        /*
            groupListener.addOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Firebase mRefChild = mRef.child("random stuff");

                    mRefChild.setValue("things");
                }
            });
            */

            groupListener.addOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Firebase mRefChild2 = mRef2.child(tmDevice[0]);

                    // DO I NEED A VALUE FOR THE CHILD??
                    mRefChild2.setValue("");

                }
            });

            groupListener.addOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, Waiting4Prayer1.class);

                    startActivity(intent);

                }
            });


            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference();
            //You must remember to remove the listener when you finish using it, also to keep track of changes you can use the ChildChange
            myRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    numberOfPeople = dataSnapshot.getChildrenCount();
                    count++;
                    DataHolder.setData(count);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    numberOfPeople = dataSnapshot.getChildrenCount();
                    count--;
                    DataHolder.setData(count);
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

/*
        DatabaseReference fbDb = FirebaseDatabase.getInstance().getReference();

        fbDb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               numberOfPeople = dataSnapshot.getChildrenCount();
                DataHolder.setData(numberOfPeople + 1);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
*/

        // should set the number of people that join in prayer to the String variable "data," which
        // is set as the value of the variable in the class DataHolder

        // data2 = Integer.toString(count);
        // DataHolder.setData(data2);

    }
}