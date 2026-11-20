package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.e0;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class FirebaseInstanceIdReceiver extends CloudMessagingReceiver {
    public static Intent a(@NonNull Context context, @NonNull String str, @NonNull Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    public int onMessageReceive(@NonNull Context context, @NonNull CloudMessage cloudMessage) {
        try {
            return ((Integer) Tasks.await(new com.google.firebase.messaging.m(context).k(cloudMessage.getIntent()))).intValue();
        } catch (InterruptedException | ExecutionException e11) {
            Log.e("FirebaseMessaging", "Failed to send message to service.", e11);
            return 500;
        }
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    public void onNotificationDismissed(@NonNull Context context, @NonNull Bundle bundle) {
        Intent intentA = a(context, CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_DISMISS, bundle);
        if (e0.A(intentA)) {
            e0.s(intentA);
        }
    }
}
