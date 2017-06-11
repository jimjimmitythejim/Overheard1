package overheardsite.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class Prayer4 extends AppCompatActivity {

    Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer4);

        TextView numberOfPeople;
        numberOfPeople = (TextView) findViewById(R.id.textView5);
        numberOfPeople.setText(Long.toString(DataHolder.getData()));

        goBack = (Button) findViewById(R.id.returnToMainButton);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Prayer4.this, MainActivity.class);

                startActivity(intent);

            }
        });

        // the following code should cause the Prayer1 activity to close and go to the HowManyPrayed activity at
        // 2:03 and 0 seconds everyday; 2:00 is when the prayer would be and 2:03 is when it would end
        Calendar calendar = Calendar.getInstance();

        // will set calendar to 2:03 if the person's timezone is that of New York
        // TimeZone tz = TimeZone.getDefault();

        calendar.set(Calendar.HOUR, 14);
        calendar.set(Calendar.MINUTE, 1);
        calendar.set(Calendar.SECOND, 0);

        Intent intent = new Intent(Prayer4.this, HowManyPrayed.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(Prayer4.this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        ((AlarmManager) getSystemService(ALARM_SERVICE)).set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        /* new CountDownTimer(30000, 1000) {

    public void onTick(long millisUntilFinished) {
    }

    public void onFinish() {
        Intent intent = new Intent(Prayer1.this, HowManyPrayed.class);
        startActivity(intent);
    }
    }.start();
    */
    }
}