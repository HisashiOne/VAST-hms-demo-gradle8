package com.dtse.huawei.demo.hms.training.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;


import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
// ... and
import android.content.pm.PackageManager;

import com.dtse.huawei.demo.hms.training.R;
import com.dtse.huawei.demo.hms.training.bean.AdConfig;


public class SettingActivity extends Activity {

    public static final String VAST_PLAYER_CONFIG = "VAST_PLAYER_CONFIG";

    private boolean mIsCustomVideoPlayer = true;

    private String mAdContentClassification = "A";
    private static final int PERMISSION_REQUEST_CODE = 1001;
    private static final String PHONE_STATE_PERMISSION = android.Manifest.permission.READ_PHONE_STATE;

    private void checkAndRequestPermissions() {
        if (ContextCompat.checkSelfPermission(this, PHONE_STATE_PERMISSION)
                != android.content.pm.PackageManager.PERMISSION_GRANTED) {

            // Permission is NOT granted, request it
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{PHONE_STATE_PERMISSION},
                    PERMISSION_REQUEST_CODE
            );
        } else {
            // Permission is already granted
            //initializeAdSdkAndLaunchActivity();
            launchLinearAdView();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 &&
                    grantResults[0] == android.content.pm.PackageManager.PERMISSION_GRANTED) {

                // Permission granted by user
                //initializeAdSdkAndLaunchActivity();
                launchLinearAdView();
            } else {
                // Permission denied by user
                // Handle the denial (e.g., show a message or load non-personalized ads)
                // You might still try to initialize the SDK here, but be aware of limitations.
                //initializeAdSdkAndLaunchActivity();
                launchLinearAdView();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        checkAndRequestPermissions();
        listenerVideoPlayerType();
        //launchLinearAdView();
        launchAdPodsView();
    }

    private void listenerVideoPlayerType() {
        mIsCustomVideoPlayer = false;
        /*this.<RadioGroup>findViewById(R.id.rg_select_video_mode).setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_custom:
                    mIsCustomVideoPlayer = false;
                    break;
                case R.id.rb_default:
                    mIsCustomVideoPlayer = true;
                    break;
                default:
                    break;
            }
        });*/
    }

    private void launchLinearAdView() {
        findViewById(R.id.btn_linear_ad).setOnClickListener(v -> {
            AdConfig adConfig = new AdConfig(mIsCustomVideoPlayer, mAdContentClassification);
            LinearAdActivity.launchLinearAdView(this, generateBundle(adConfig));
        });

        //findViewById(R.id.btn_launch_fetch_data_view)
                //.setOnClickListener(v -> AdsDataLinearAdActivity.launchAdsView(SettingActivity.this));
    }

    private void launchAdPodsView() {
       /* findViewById(R.id.btn_adpods_ad).setOnClickListener(v -> {
            AdConfig adConfig = new AdConfig(mIsCustomVideoPlayer, mAdContentClassification);
            AdPodsActivity.launchAdPodsView(this, generateBundle(adConfig));
        });*/
    }

    private Bundle generateBundle(AdConfig adConfig) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(VAST_PLAYER_CONFIG, adConfig);
        return bundle;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}