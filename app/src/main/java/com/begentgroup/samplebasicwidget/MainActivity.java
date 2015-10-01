package com.begentgroup.samplebasicwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox enableView;
    TextView messageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageView = (TextView)findViewById(R.id.text_message);
        String text = getResources().getString(R.string.test_text);
        messageView.setText(Html.fromHtml(text));

        enableView = (CheckBox)findViewById(R.id.check_enable);
        enableView.setChecked(true);

        enableView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isForced) return;
                Toast.makeText(MainActivity.this, "checked : " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });
    }

    boolean isForced = false;

    public void onButtonClick(View view) {
        String checkedText = enableView.isChecked()?"Enable True":"Enable False";

        Toast.makeText(this, checkedText, Toast.LENGTH_SHORT).show();

        isForced = true;
        enableView.setChecked(!enableView.isChecked());
        isForced = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
