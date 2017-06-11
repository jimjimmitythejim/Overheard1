package overheardsite.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import java.util.Objects;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.w3c.dom.Text;

public class HowManyPrayed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_many_prayed);

        /*RelativeLayout jimmysLayout = new RelativeLayout(this);
        jimmysLayout.setBackgroundColor(Color.CYAN);

        // button layout details
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.setMargins(0, 80, 0, 0);
*/

        // return button
        Button goBackToMain = (Button) findViewById(R.id.returnToMain);
        //goBackToMain.setText(R.string.Return); // this is a string resource from the string resource file
        //goBackToMain.setBackgroundColor(Color.BLUE);

        // number of people text
        TextView number = (TextView) findViewById(R.id.Number);

        SharedPreferences sharedPreferences = getSharedPreferences("counter", Context.MODE_PRIVATE);
        Long count = sharedPreferences.getLong("count", 0);

        number.setText(String.valueOf(count));

        /*

        // number of people text layout details
        RelativeLayout.LayoutParams numberDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        numberDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        numberDetails.addRule(RelativeLayout.ABOVE, goBackToMain.getId());
        numberDetails.setMargins(0, 0, 0, 30);

        // calling this down here cause the number.getId() can only be called after number is made
        buttonDetails.addRule(RelativeLayout.ALIGN_BASELINE, number.getId());

        // you have prayed with text
        TextView text1 = new TextView(this);
        text1.setText("You have prayed with ");

        // you have prayed with text details
        RelativeLayout.LayoutParams text1Details = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        text1Details.addRule(RelativeLayout.ALIGN_PARENT_LEFT, number.getId());

        // people text
        TextView text2 = new TextView(this);
        text2.setText(" people.");

        // people text details
        RelativeLayout.LayoutParams text2Details = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        text2Details.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, number.getId());

        // widget ids
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            goBackToMain.setId(View.generateViewId());
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            number.setId(View.generateViewId());
        }

        jimmysLayout.addView(goBackToMain, buttonDetails);
        jimmysLayout.addView(number, numberDetails);
        jimmysLayout.addView(text1, text1Details);
        jimmysLayout.addView(text2, text2Details);

        setContentView(jimmysLayout);
*/

        CompositeOnClickListener multipleListener = new CompositeOnClickListener();

        goBackToMain.setOnClickListener(multipleListener);

        final TelephonyManager id = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
        final String[] tmDevice = new String[1];
        tmDevice[0] = "" + id.getDeviceId();

        multipleListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HowManyPrayed.this, MainActivity.class);

                startActivity(intent);
            }
        });

        // supposed to remove the person's imei id from the database when they return to the homepage
        multipleListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Firebase mRef;
                mRef = new Firebase("https://my-awesome-project-ce89c.firebaseio.com/");

                // should delete the child IMEI and its values
                // don't know if I should have the mRefChild2 in the MainActivity cause it seems that's where the value is
                // being set but idk
                mRef.child(tmDevice[0]).removeValue();
                // NEED  TO REMOVE VALUE REGARDLESS IF THEY CLICK CAUSE THYE MIGHT CLOSE APP WITHOUT HITTING THE BUTTON

                /*DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                Query IMEIQuery = ref.child(tmDevice[0]).orderByChild("title").equalTo(something);

                // I SERIOUSLY do no know if this works <<<<<<<<<<<<<<<<<<<<<<<<<<<<
                IMEIQuery.getRef().removeValue();
                */
            }
        });

        TextView email = (TextView) findViewById(R.id.email);
        email.setMovementMethod(LinkMovementMethod.getInstance());

        TextView facebookpage = (TextView) findViewById(R.id.facebookpage);
        facebookpage.setMovementMethod(LinkMovementMethod.getInstance());

        TextView twitter = (TextView) findViewById(R.id.twitter);
        twitter.setMovementMethod(LinkMovementMethod.getInstance());

        // should set the textview to the number of people that prayed
        // don't know if this will change as people leave the page
        // number.setText(DataHolder.getData());
        // MIGHT ONLY WORK IF YOU HAVE YOUR OWN RELATIVE LAYOUT AND THEN YOU CAN CONFIGURE THIS

        /*
        Intent myIntent = new Intent(HowManyPrayed.this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(), 0, myIntent, 0);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);


        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(System.currentTimeMillis());

        calendar.add(Calendar.SECOND, 10);

        long interval = 60 * 1000; // every minute

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), interval, pendingIntent);

        finish();
        */

        // can use this instead of the universal timer cause everyone is on the same time at this point
        // due to the universal timer to gether here anyway
        /*new CountDownTimer(30000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {

            }
        }.start();
        */

        // setting universal timer
        /*
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 14);

        calendar.set(Calendar.MINUTE, 0);

        calendar.set(Calendar.SECOND, 0);

        Intent intent1 = new Intent(HowManyPrayed.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(HowManyPrayed.this, 0,intent1, PendingIntent.FLAG_ONE_SHOT);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        long interval = 60 * 1000; // every minute

        ((AlarmManager) getSystemService(ALARM_SERVICE)).set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        */
    }
}
