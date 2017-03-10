package com.github.splendinator.treasurehuntapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class Participate2 extends AppCompatActivity {

    private final long SWOOSH_SPEED = 600;
    private final String FIELD = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participate);

        if (getIntent().hasExtra("swoosh")) {
            if (getIntent().getExtras().getString("swoosh").equals("left"))
                swoosh(true);
            if (getIntent().getExtras().getString("swoosh").equals("right"))
                swoosh(false);
        }

    }
    public void swoosh(boolean left){
        final int sign = (left?-1:1);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        final int width = metrics.widthPixels;
        View content = findViewById(R.id.content);
        content.setTranslationX(-sign*width);
        content.animate().translationXBy(sign*width).setDuration(SWOOSH_SPEED);
    }

    public void swoosh(boolean left, final Intent nextLayout){
        final int sign = (left?-1:1);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        final int width = metrics.widthPixels;
        findViewById(R.id.content).animate().translationX(sign*width).setDuration(SWOOSH_SPEED).withEndAction(new Runnable() {
            @Override
            public void run() {
                startActivity(nextLayout);
            }
        });
    }
    public String getInput() {
        TextView x = (TextView) findViewById(R.id.input);
        return x.getText().toString();
    }
}
