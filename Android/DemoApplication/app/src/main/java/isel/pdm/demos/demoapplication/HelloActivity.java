package isel.pdm.demos.demoapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Constructor;

public class HelloActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("PAULO", "HelloActivity.onCreate() starting");
        setContentView(R.layout.hello_activity_layout);

        final TextView msgBox = (TextView) findViewById(R.id.msgBox);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("PAULO", "button.onClick()");
                msgBox.setText("YEEEEAAHHHH");
            }
        });

        Log.v("PAULO", "HelloActivity.onCreate() terminating");
    }
}
