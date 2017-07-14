package androidjavaespresso0714.androidjavaespresso0714;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.Toast;

import java.util.Map;
import com.microsoft.azure.mobile.push.PushNotification;
import com.microsoft.azure.mobile.push.PushListener;


public class MyPushListener implements PushListener {

    @Override
    public void onPushNotificationReceived(Activity activity, PushNotification pushNotification) {

        /* The following notification properties are available. */
        String title = pushNotification.getTitle();
        String message = pushNotification.getMessage();
        Map<String, String> customData = pushNotification.getCustomData();

        /*
         * Message and title cannot be read from a background notification object.
         * Message being a mandatory field, you can use that to check foreground vs background.
         */
        if (message != null) {

            /* Display an alert for foreground push. */
            AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
            if (title != null) {
                dialog.setTitle(title);
            }
            dialog.setMessage(message);
            if (!customData.isEmpty()) {
                dialog.setMessage(message + "\n" + customData);
            }
            dialog.setPositiveButton(android.R.string.ok, null);
            dialog.show();
        } else {
            Toast.makeText(activity, String.format(activity.getString(R.string.push_toast), customData), Toast.LENGTH_LONG).show(); // For example R.string.push_toast would be "Push clicked with data=%1s"
        }
    }
}
