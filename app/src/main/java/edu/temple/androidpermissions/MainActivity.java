package edu.temple.androidpermissions;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends Activity {

    private final int PERMISSION_REQUEST_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if we currently have permission to use the resource
        if (PackageManager.PERMISSION_DENIED != checkSelfPermission(Manifest.permission.SEND_SMS)) {
            doSMSAction();
        } else {
            if (shouldShowRequestPermissionRationale(Manifest.permission.SEND_SMS)){
                showDialogExplainingWhyPermissionNeeded();
                requestPermissions(new String[]{Manifest.permission.SEND_SMS}, PERMISSION_REQUEST_CODE);
            } else {
                // Do nothing. The user does not want this permission granted.
            }

        }

    }

    /**
     * Perform SMS action that might cost the user money
     */
    private void doSMSAction(){}

    /**
     * Display a dialog with a clear explanation of why the permission is needed.
     * We might be here because the user previously declined to provide access.
     */
    private void showDialogExplainingWhyPermissionNeeded(){}

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){

        // Since we only requested one permission, there's no need to check which just returned
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            doSMSAction();
    }
}
