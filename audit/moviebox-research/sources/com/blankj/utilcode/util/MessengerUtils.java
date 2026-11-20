package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MessengerUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<String, a> f25227a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, Object> f25228b = new HashMap();

    /* JADX INFO: compiled from: source.java */
    public static class ServerService extends Service {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<Integer, Messenger> f25229a = new ConcurrentHashMap<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SuppressLint({"HandlerLeak"})
        public final Handler f25230b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Messenger f25231c;

        /* JADX INFO: compiled from: source.java */
        public class a extends Handler {
            public a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i11 = message.what;
                if (i11 == 0) {
                    ServerService.this.f25229a.put(Integer.valueOf(message.arg1), message.replyTo);
                    return;
                }
                if (i11 == 1) {
                    ServerService.this.f25229a.remove(Integer.valueOf(message.arg1));
                } else if (i11 != 2) {
                    super.handleMessage(message);
                } else {
                    ServerService.this.e(message);
                    ServerService.this.d(message);
                }
            }
        }

        public ServerService() {
            a aVar = new a();
            this.f25230b = aVar;
            this.f25231c = new Messenger(aVar);
        }

        public final void d(Message message) {
            String string;
            a aVar;
            Bundle data = message.getData();
            if (data == null || (string = data.getString("MESSENGER_UTILS")) == null || (aVar = (a) MessengerUtils.f25227a.get(string)) == null) {
                return;
            }
            aVar.a(data);
        }

        public final void e(Message message) {
            Message messageObtain = Message.obtain(message);
            for (Messenger messenger : this.f25229a.values()) {
                if (messenger != null) {
                    try {
                        messenger.send(Message.obtain(messageObtain));
                    } catch (RemoteException e11) {
                        e11.printStackTrace();
                    }
                }
            }
            messageObtain.recycle();
        }

        @Override // android.app.Service
        @Nullable
        public IBinder onBind(Intent intent) {
            return this.f25231c.getBinder();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i11, int i12) {
            Bundle extras;
            if (Build.VERSION.SDK_INT >= 26) {
                startForeground(1, j0.q(t.a.f25338b, null));
            }
            if (intent != null && (extras = intent.getExtras()) != null) {
                Message messageObtain = Message.obtain(this.f25230b, 2);
                messageObtain.replyTo = this.f25231c;
                messageObtain.setData(extras);
                e(messageObtain);
                d(messageObtain);
            }
            return 2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(Bundle bundle);
    }
}
