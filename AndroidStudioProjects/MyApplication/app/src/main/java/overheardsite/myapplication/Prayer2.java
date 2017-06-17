package overheardsite.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;

public class Prayer2 extends AppCompatActivity {

    Button goBack;

    String text = "Our Father, who art in Heaven, hallowed by Thy name. Thy kingdom come, Thy will be done, on Earth as it is in Heaven.\n" +
            "    Give us this day our daily bread, and forgive us our trespasses, as we forgive those who trespass against us. And lead us\n" +
            "    not into temptation, but deliver us from evil.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer2);

        final TextView numberOfPeople = (TextView) findViewById(R.id.textView5);
        SharedPreferences sharedPreferences = getSharedPreferences("counter", Context.MODE_PRIVATE);
        Long count = sharedPreferences.getLong("count", 0);

        numberOfPeople.setText(String.valueOf(count));

        goBack = (Button) findViewById(R.id.returnToMainButton);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Prayer2.this, MainActivity.class);

                startActivity(intent);

            }
        });

        /* new CountDownTimer(30000, 1000) {

    public void onTick(long millisUntilFinished) {
    }

    public void onFinish() {
        Intent intent = new Intent(Prayer1.this, HowManyPrayed.class);
        startActivity(intent);
    }
    }.start();
    */

        final TextView prayer = (TextView) findViewById(R.id.textView);
        prayer.setText(text);
        //Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Arial.otf");
        //prayer.setTypeface(tf);

        Thread t = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(50); // I don't think running it every 100 milliseconds makes a difference but I'll run it at 50
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

                                if (hours == 16 || hours == 18 || hours == 1) {

                                    if (seconds == 5) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 6) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 16, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 17, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 18, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 7) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 21, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 22, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 23, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 24, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 25, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 26, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 27, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 28, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 30, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 8) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 31, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 32, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 33, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 34, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 35, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 36, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 37, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 38, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 39, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 40, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 9) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 41, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 42, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 43, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 44, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 45, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 46, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 47, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 48, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 49, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 50, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 10) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 51, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 52, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 53, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 54, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 55, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 56, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 57, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 58, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 59, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 60, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 11) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 61, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 62, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 63, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 64, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 65, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 66, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 67, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 68, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 69, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 70, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 12) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 71, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 72, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 73, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 74, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 75, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 76, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 77, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 78, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 79, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 80, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 13) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 81, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 82, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 83, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 84, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 85, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 86, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 87, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 88, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 89, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 90, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 14) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 91, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 92, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 93, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 94, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 95, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 96, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 97, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 98, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 99, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 100, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 15) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 101, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 102, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 103, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 104, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 105, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 106, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 107, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 108, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 109, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 110, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 16) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 111, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 112, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 113, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 114, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 115, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 116, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 117, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 118, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 119, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 120, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 17) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 121, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 122, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 123, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 124, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 125, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 126, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 127, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 128, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 129, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 130, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 18) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 131, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 132, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 133, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 134, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 135, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 136, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 137, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 138, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 139, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 140, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 19) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 141, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 142, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 143, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 144, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 145, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 146, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 147, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 148, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 149, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 150, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 20) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 151, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 152, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 153, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 154, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 155, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 156, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 157, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 158, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 159, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 160, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 21) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 161, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 162, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 163, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 164, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 165, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 166, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 167, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 168, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 169, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 170, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 22) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 171, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 172, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 173, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 174, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 175, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 176, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 177, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 178, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 179, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 180, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 23) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 181, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 182, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 183, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 184, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 185, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 186, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 187, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 188, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 189, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 190, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 24) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 191, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 192, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 193, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 194, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 195, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 196, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 197, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 198, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 199, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 200, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 25) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 201, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 202, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 203, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 204, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 205, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 206, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 207, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 208, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 209, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 210, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 26) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 211, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 212, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 213, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 214, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 215, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 216, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 217, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 218, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 219, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 220, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 27) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 221, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 222, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 223, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 224, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 225, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 226, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 227, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 228, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 229, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 230, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 28) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 231, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 232, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 233, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 234, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 235, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 236, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 237, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 238, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 239, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 240, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 29) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 241, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 242, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 243, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 244, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 245, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 246, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 247, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 248, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 249, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 250, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 30) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 251, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 252, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 253, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 254, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 255, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 256, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 257, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 258, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 259, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 260, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 31) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 261, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 262, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 263, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 264, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 265, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 266, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 267, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 268, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 269, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 270, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 32) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 271, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 272, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 273, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 274, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 275, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 600) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 276, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 700) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 277, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 800) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 278, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 900) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 279, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 280, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds == 33) {
                                        if (milliseconds < 100) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 281, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 200) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 282, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 300) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 283, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 400) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 284, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds < 500) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 285, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        } else if (milliseconds <= 999) {
                                            Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                            spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 286, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            prayer.setText(spanText);
                                        }
                                    }
                                    else if (seconds > 33) {
                                        Spannable spanText = Spannable.Factory.getInstance().newSpannable(text);
                                        spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 0, 286, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        prayer.setText(spanText);

                                        if (seconds == 50) {
                                            Intent intent = new Intent(Prayer2.this, HowManyPrayed.class);
                                            startActivity(intent);
                                        }
                                    }
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
