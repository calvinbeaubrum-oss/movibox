package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.transsion.push.PushConstants;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessagingService extends EnhancedIntentService {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Queue<String> f40763g = new ArrayDeque(10);

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public Intent e(Intent intent) {
        return q0.b().c();
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void f(Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
            o(intent);
        } else {
            if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
                s(intent.getStringExtra("token"));
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown intent action: ");
            sb2.append(intent.getAction());
        }
    }

    public final boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue<String> queue = f40763g;
        if (!queue.contains(str)) {
            if (queue.size() >= 10) {
                queue.remove();
            }
            queue.add(str);
            return false;
        }
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Received duplicate message: ");
        sb2.append(str);
        return true;
    }

    public final void m(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (g0.t(extras)) {
            g0 g0Var = new g0(extras);
            ExecutorService executorServiceE = n.e();
            try {
                if (new f(this, g0Var, executorServiceE).a()) {
                    executorServiceE.shutdown();
                    return;
                } else {
                    executorServiceE.shutdown();
                    if (e0.A(intent)) {
                        e0.t(intent);
                    }
                }
            } catch (Throwable th2) {
                executorServiceE.shutdown();
                throw th2;
            }
        }
        q(new RemoteMessage(extras));
    }

    public final String n(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra(PushConstants.EXTRA_PUSH_MESSAGE_ID) : stringExtra;
    }

    public final void o(Intent intent) {
        if (l(intent.getStringExtra("google.message_id"))) {
            return;
        }
        u(intent);
    }

    public void p() {
    }

    public void q(@NonNull RemoteMessage remoteMessage) {
    }

    public void r(@NonNull String str) {
    }

    public void s(@NonNull String str) {
    }

    public void t(@NonNull String str, @NonNull Exception exc) {
    }

    public final void u(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_PUSH_MESSAGE_TYPE);
        if (stringExtra == null) {
            stringExtra = GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE;
        }
        switch (stringExtra) {
            case "deleted_messages":
                p();
                break;
            case "gcm":
                e0.v(intent);
                m(intent);
                break;
            case "send_error":
                t(n(intent), new SendException(intent.getStringExtra("error")));
                break;
            case "send_event":
                r(intent.getStringExtra("google.message_id"));
                break;
            default:
                Log.w("FirebaseMessaging", "Received message with unknown type: " + stringExtra);
                break;
        }
    }
}
