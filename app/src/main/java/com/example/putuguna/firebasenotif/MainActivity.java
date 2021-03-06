package com.example.putuguna.firebasenotif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private Button mButtonSubscribe;
    private Button mButtonLogToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //start handle data extra
        if(getIntent().getExtras()!=null){
            for(String key : getIntent().getExtras().keySet()){
                String value = getIntent().getExtras().getString(key);
                Log.d("TAG", "KEY : " + key + "Value : " + value);
            }
        }

        mButtonSubscribe = (Button) findViewById(R.id.subscribeButton);
        mButtonSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseMessaging.getInstance().subscribeToTopic("news");
                Log.d("TAG", "Subscribe to news topic");
            }
        });

        mButtonLogToken = (Button) findViewById(R.id.logTokenButton);
        mButtonLogToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "InstanceID Token : " + FirebaseInstanceId.getInstance().getToken());
            }
        });
    }

    /**
     * nama project firebaseNotif appchef
     * https://firebase.google.com/docs/notifications/android/console-audience#receive_and_handle_notifications
     * https://console.firebase.google.com/project/notifpushfirebase/notification
     *
     * sumber lain yang bagus :
     * https://github.com/akrajilwar/Firebase-Cloud-Messaging
     *
     *
     * ini yang ada tutorial php login dan register
     * http://inducesmile.com/android/android-firebase-cloud-messaging-push-notification-with-server-admin-in-php-and-mysql-database/
     *
     *
     * key dan value itu ternyata untuk judul notificationnya
     */
}
