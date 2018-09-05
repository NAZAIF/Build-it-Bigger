package com.example.jokeandroidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    TextView jokeTextView;
    public static final String INTENT_CONSTANT = "GCE_RESULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        jokeTextView = (TextView) findViewById(R.id.textView);
        String result = getIntent().getStringExtra(INTENT_CONSTANT);
        jokeTextView.setText(result);
    }
}
