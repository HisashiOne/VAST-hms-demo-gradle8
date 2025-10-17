package com.dtse.huawei.demo.hms.training;

import static com.dtse.huawei.demo.hms.training.Constants.IS_TEST;

import android.app.Application;
import android.content.Context;

import com.huawei.hms.ads.vast.adapter.SdkFactory;
import com.huawei.hms.ads.vast.player.VastApplication;

public class DemoApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        VastApplication.init(DemoApplication.this, IS_TEST);
        SdkFactory.userAcceptAdLicense(true);
    }

    public static Context getContext() {
        return context;
    }
}
