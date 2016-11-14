package com.axiba.gradledemo;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private TextView packageTV;
    private TextView metaValueTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        packageTV = (TextView) findViewById(R.id.package_name);
        metaValueTV = (TextView) findViewById(R.id.meta_value);

        text.setText(BuildConfig.BUILD_TYPE);

        if (BuildConfig.DEBUG) {
            Log.d("tag", "something happened");
        }

        packageTV.setText(this.getPackageName());


        ApplicationInfo appInfo = null;
        try {
            appInfo = this.getPackageManager()
                    .getApplicationInfo(getPackageName(),
                            PackageManager.GET_META_DATA);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String msg=appInfo.metaData.getString("UMENG_CHANNEL");

        metaValueTV.setText(msg);

        metaValueTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("123", "123");
            }
        });
    }
}
