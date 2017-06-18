package overheardsite.myapplication;

import android.content.Context;
import android.content.Intent;
import java.util.Calendar;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.TimeZone;


public class Prayer5 extends AppCompatActivity {

    String text = "Heavenly Father, we thank You for the dawn of a new day!\n" +
            "Thank You for Your blessings upon our lives and our families.\n" +
            "We give You all the praise and honor, because this is the day You've made,\n" +
            "and You are mighty and worthy indeed!\n" +
            "All honor and glory belongs to You.\n" +
            "With You, we will do the impossible, we will not fail.\n" +
            "Our past is no longer important, because You, Oh Lord, are our future.";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer5);

        final TextView numberOfPeople = (TextView) findViewById(R.id.textView5);
        SharedPreferences sharedPreferences = getSharedPreferences("counter", Context.MODE_PRIVATE);
        Long count = sharedPreferences.getLong("count", 0);

        numberOfPeople.setText(String.valueOf(count));

        Button goBack = (Button) findViewById(R.id.returnToMainButton);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Prayer5.this, MainActivity.class);

                startActivity(intent);

            }
        });

        /*
        // the following code should cause the Prayer1 activity to close and go to the HowManyPrayed activity at
        // 2:03 and 0 seconds everyday; 2:00 is when the prayer would be and 2:03 is when it would end
        Calendar calendar = Calendar.getInstance();

        // will set calendar to 2:03 if the person's timezone is that of New York
        TimeZone tz = TimeZone.getDefault();

        calendar.set(Calendar.HOUR, 8);
        calendar.set(Calendar.MINUTE, 1);
        calendar.set(Calendar.SECOND, 0);

        Intent intent = new Intent(Prayer1.this, HowManyPrayed.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(Prayer1.this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        ((AlarmManager) getSystemService(ALARM_SERVICE)).set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        */

        /* new CountDownTimer(30000, 1000) {

    public void onTick(long millisUntilFinished) {
    }

    public void onFinish() {
        Intent intent = new Intent(Prayer1.this, HowManyPrayed.class);
        startActivity(intent);
    }
    }.start();
    */

        //Timer timer = new Timer();
        //timer.schedule(new UpdateTimeTask(), 5000, 1000);

        final TextView prayer = (TextView) findViewById(R.id.textView);
        prayer.setText(text);
        //Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Arial.otf");
        //prayer.setTypeface(tf);

        Thread t = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(50); // I don't think running it every 100 milliseconds makes a difference but I'll run it at 40
                        // just in case to make it definitely smooth

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                SharedPreferences sharedPreferences = getSharedPreferences("counter", Context.MODE_PRIVATE);
                                Long count = sharedPreferences.getLong("count", 0);

                                numberOfPeople.setText(String.valueOf(count));

                                long millis = System.currentTimeMillis();
                                Calendar c = Calendar.getInstance();
                                c.setTimeZone(TimeZone.getTimeZone("Africa/Casablanca"));
                                c.setTimeInMillis(millis);

                                int hours = c.get(Calendar.HOUR_OF_DAY);
                                int minutes = c.get(Calendar.MINUTE);
                                int seconds = c.get(Calendar.SECOND);
                                int milliseconds = c.get(Calendar.MILLISECOND);

                         //       if (minutes == 0) {

                                    if (seconds == 5) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 6) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 16, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 17, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 18, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 7) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 21, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 22, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 23, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 24, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 25, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 26, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 27, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 28, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 30, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 8) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 31, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 32, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 33, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 34, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 35, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 36, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 37, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 38, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 39, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 40, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 9) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 41, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 42, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 43, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 44, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 45, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 46, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 47, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 48, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 49, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 50, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 10) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 51, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 52, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 53, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 54, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 55, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 56, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 57, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 58, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 59, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 60, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 11) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 61, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 62, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 63, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 64, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 65, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 66, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 67, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 68, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 69, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 70, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 12) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 71, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 72, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 73, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 74, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 75, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 76, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 77, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 78, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 79, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 80, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 13) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 81, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 82, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 83, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 84, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 85, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 86, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 87, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 88, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 89, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 90, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 14) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 91, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 92, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 93, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 94, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 95, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 96, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 97, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 98, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 99, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 100, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 15) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 101, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 102, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 103, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 104, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 105, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 106, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 107, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 108, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 109, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 110, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 16) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 111, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 112, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 113, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 114, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 115, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 116, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 117, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 118, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 119, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 120, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 17) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 121, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 122, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 123, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 124, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 125, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 126, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 127, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 128, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 129, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 130, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 18) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 131, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 132, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 133, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 134, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 135, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 136, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 137, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 138, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 139, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 140, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 19) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 141, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 142, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 143, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 144, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 145, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 146, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 147, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 148, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 149, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 150, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 20) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 151, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 152, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 153, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 154, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 155, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 156, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 157, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 158, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 159, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 160, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 21) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 161, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 162, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 163, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 164, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 165, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 166, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 167, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 168, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 169, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 170, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 22) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 171, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 172, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 173, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 174, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 175, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 176, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 177, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 178, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 179, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 180, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 23) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 181, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 182, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 183, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 184, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 185, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 186, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 187, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 188, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 189, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 190, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 24) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 191, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 192, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 193, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 194, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 195, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 196, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 197, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 198, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 199, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 200, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 25) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 201, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 202, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 203, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 204, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 205, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 206, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 207, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 208, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 209, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 210, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 26) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 211, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 212, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 213, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 214, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 215, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 216, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 217, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 218, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 219, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 220, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 27) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 221, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 222, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 223, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 224, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 225, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 226, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 227, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 228, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 229, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 230, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 28) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 231, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 232, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 233, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 234, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 235, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 236, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 237, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 238, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 239, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 240, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 29) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 241, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 242, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 243, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 244, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 245, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 246, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 247, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 248, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 249, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 250, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 30) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 251, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 252, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 253, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 254, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 255, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 256, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 257, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 258, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 259, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 260, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    } else if (seconds == 31) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 261, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 262, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 263, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 264, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 265, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 266, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 267, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 268, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 269, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 270, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    } else if (seconds == 32) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 271, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 272, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 273, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 274, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 275, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 276, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 277, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 278, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 279, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 280, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    } else if (seconds == 33) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 281, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 282, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 283, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 284, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 285, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 286, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 287, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 288, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 289, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 290, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    } else if (seconds == 34) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 291, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 292, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 293, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 294, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 295, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 296, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 297, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 298, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 299, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 300, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    } else if (seconds == 35) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 301, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 302, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 303, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 304, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 305, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 306, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 307, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 308, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 309, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 310, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    } else if (seconds == 36) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 311, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 312, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 313, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 314, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 315, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 316, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 317, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 318, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 319, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 320, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    } else if (seconds == 37) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 321, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 322, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 323, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 324, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 325, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 326, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 327, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 328, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 329, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 330, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    } else if (seconds == 38) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 331, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 332, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 333, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 334, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 335, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 336, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 337, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 338, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 339, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 340, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    } else if (seconds == 39) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 341, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 342, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 343, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 344, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 345, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 346, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 347, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 348, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 349, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 350, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    } else if (seconds == 40) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 351, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 352, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 353, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 354, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 355, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 356, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 357, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 358, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 359, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 360, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    } else if (seconds == 41) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 361, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 362, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 363, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 364, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 365, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 366, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 367, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 368, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 369, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 370, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    } else if (seconds == 42) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 371, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 372, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 373, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 374, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 375, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 376, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 377, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 378, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 379, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 380, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    } else if (seconds == 43) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 381, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 382, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 383, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 384, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 385, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 386, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 387, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 388, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    } else if (seconds > 43) {
                                        Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                        spanText.setSpan(new BackgroundColorSpan(0x80ffa500), 0, 388, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        prayer.setText(spanText);
                                    }
                         //       }
                                if (minutes == 3) {
                                    Intent intent = new Intent(Prayer5.this, HowManyPrayed.class);
                                    startActivity(intent);
                                }


                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }
}