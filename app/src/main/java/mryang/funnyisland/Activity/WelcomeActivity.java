package mryang.funnyisland.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import mryang.funnyisland.Activity.login.SelectLoginModeActivity;
import mryang.funnyisland.R;


public class WelcomeActivity extends AppCompatActivity {

    private boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        IsFirst();

    }

    private void IsFirst() {
        SharedPreferences sp = getSharedPreferences("myFirst", MODE_PRIVATE);
        Boolean first = sp.getBoolean("isFirst", true);
        if (first == false) {
            startActivity(new Intent(WelcomeActivity.this, SelectLoginModeActivity.class));
            finish();
        } else {
            isFirst = false;
            SharedPreferences sp2 = getSharedPreferences("myFirst", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp2.edit();
            editor.putBoolean("isFirst", isFirst);
            editor.commit();
            if (editor.commit()) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(WelcomeActivity.this, SelectLoginModeActivity.class));
                        finish();
                    }
                },3000);
            }
        }
    }


}
