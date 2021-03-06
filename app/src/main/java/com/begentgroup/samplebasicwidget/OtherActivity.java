package com.begentgroup.samplebasicwidget;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OtherActivity extends AppCompatActivity {

    EditText passwordView;

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        imageView = (ImageView)findViewById(R.id.imageView);
        passwordView = (EditText)findViewById(R.id.editText2);
        passwordView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();
                if (text.length() < 6) {
                    passwordView.setTextColor(Color.RED);
                } else {
                    passwordView.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        passwordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    // ....
                    Toast.makeText(OtherActivity.this, "click send key", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    public void onButtonClick(View view) {
        Drawable d = imageView.getDrawable();
        int level = d.getLevel();
        level = (level + 1000) % 11000;
        d.setLevel(level);
    }
}
