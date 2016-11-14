package isel.pdm.demos.demoapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HelloActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v("PAULO", "HelloActivity.onCreate() starting");
        final TextView msgBox = new TextView(this);
        msgBox.setText("Hello Android");
        msgBox.setTextAppearance(android.R.style.TextAppearance_Large);
        msgBox.setBackgroundColor(Color.RED);
        msgBox.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );

        Button button = new Button(this);
        button.setText("CLICK ME");
        button.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("PAULO", "button.onClick()");
                msgBox.setText("YEAAAAAAHHHHHH!");
            }
        });

        LinearLayout layout = new LinearLayout(this);
        layout.addView(msgBox);
        layout.addView(button);
        layout.setOrientation(LinearLayout.VERTICAL);

        setContentView(layout);

        Log.v("PAULO", "HelloActivity.onCreate() terminating");
    }
}
