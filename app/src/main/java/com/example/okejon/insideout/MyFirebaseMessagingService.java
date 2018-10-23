package com.example.okejon.insideout;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "firebase_emoji";

    //public void onNewToken(String s) {
    //    super.onNewToken(s);
    //    Log.e("NEW_TOKEN",s);
    //}
    //NEW_TOKEN: eegh4Fhw4TI:APA91bEanIjT6TWRJxzShWGWDtay5IMIBTgOqrfIOSjV37ks6fkdENhZaVm91evXz0jZxSV6F2meOqRg479XMW1HVp6_iYw-EskJh_JNf_RhNfFoAZXZrG75Va5jT4c8SjzzQzZaGTRq

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d(TAG, "Pengirim: " + remoteMessage.getFrom());
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG,"Pesannya adalah : " + remoteMessage.getData().get("body"));
        }

        //panggil display notif dr class notifmgr
        MyNotificationManager.getInstance(this).displayNotification(remoteMessage.getData().get("body"), remoteMessage.getData().get("title"));
    }
}