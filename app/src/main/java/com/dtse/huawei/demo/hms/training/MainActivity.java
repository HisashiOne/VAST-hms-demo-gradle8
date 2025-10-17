package com.dtse.huawei.demo.hms.training;

import static com.dtse.huawei.demo.hms.training.Constants.IS_TEST;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hms.ads.vast.adapter.SdkFactory;
import com.huawei.hms.ads.vast.player.VastApplication;

public class MainActivity extends AppCompatActivity {

    private static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();

    }


}