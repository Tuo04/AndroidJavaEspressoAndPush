package androidjavaespresso0714.androidjavaespresso0714;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.microsoft.azure.mobile.MobileCenter;
import com.microsoft.azure.mobile.analytics.Analytics;
import com.microsoft.azure.mobile.crashes.Crashes;
import com.microsoft.azure.mobile.push.Push;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Push.setListener(new MyPushListener());
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.inputField);
        btn = (Button) findViewById(R.id.switchActivity);
        Analytics.setEnabled(true);
        Analytics.trackEvent("Button clicked");

        MobileCenter.start(getApplication(), "2bf45de0-39b5-4d7d-98a0-5d9da6b9caff",
                Analytics.class, Crashes.class, Push.class);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changeText:
                editText.setText("Lalala");
                break;
        }
    }
    public void onSwitchActivity(android.view.View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("input", editText.getText().toString());
        startActivity(intent);

    }
    public void onCrash(View view){
        Crashes.generateTestCrash();
    }
}
