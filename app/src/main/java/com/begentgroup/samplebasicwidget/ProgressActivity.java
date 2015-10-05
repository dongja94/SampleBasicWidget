package com.begentgroup.samplebasicwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class ProgressActivity extends AppCompatActivity {
    ProgressBar progressView;
    SeekBar seekView;
    RatingBar ratingView;

    private static final String TAG = "ProgressActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        progressView = (ProgressBar)findViewById(R.id.progressBar2);
        progressView.setMax(15324);
        seekView = (SeekBar)findViewById(R.id.seekBar);
        seekView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            private static final int NOT_CHANGED = -1;
            int progress = NOT_CHANGED;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i(TAG, "progress : " + progress + ", fromUser : " + fromUser);
                if (fromUser) {
                    this.progress = progress;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                progress = NOT_CHANGED;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (progress != NOT_CHANGED) {
                    Toast.makeText(ProgressActivity.this, "Progress Changed : " + progress, Toast.LENGTH_SHORT).show();
                }
            }
        });

        seekView.setMax(1000);

        ratingView = (RatingBar)findViewById(R.id.ratingBar);
        ratingView.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.i(TAG, "Rating changed : " + rating);
            }
        });
        Button btn = (Button)findViewById(R.id.btn_progress);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int progress = progressView.getProgress();
                progress += 500;
                progressView.setProgress(progress);
                progressView.setSecondaryProgress(12345);
            }
        });
    }
}
