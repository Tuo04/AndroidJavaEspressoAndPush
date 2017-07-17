package androidjavaespresso0714.androidjavaespresso0714;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        TextView viewById = (TextView) findViewById(R.id.resultView);

        Intent iin=getIntent();
        String input = iin.getStringExtra("input");

        viewById.setText(input);
    }
}