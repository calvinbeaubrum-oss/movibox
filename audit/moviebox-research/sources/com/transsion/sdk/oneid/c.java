package com.transsion.sdk.oneid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f57395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler.Callback f57396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Messenger f57397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Messenger f57398d = new Messenger(new a());

    /* JADX INFO: compiled from: source.java */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.f57417a.g("ReplyMessenger msg.what = " + message.what);
            if (c.this.f57396b != null) {
                c.this.f57396b.handleMessage(message);
            }
            c.c(c.this);
        }
    }

    public c(Context context, Handler.Callback callback) {
        this.f57395a = context;
        this.f57396b = callback;
    }

    public static void c(c cVar) {
        cVar.getClass();
        try {
            if (cVar.f57397c != null) {
                cVar.f57397c = null;
                cVar.f57395a.unbindService(cVar);
            }
        } catch (Exception e11) {
            f.f57417a.i(Log.getStackTraceString(e11));
        }
    }

    public void b() {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.hoffnung", "com.transsion.dataservice.binder.DCService");
            this.f57395a.bindService(intent, this, 1);
        } catch (Exception e11) {
            f.f57417a.i(Log.getStackTraceString(e11));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        f.f57417a.g("onServiceConnected");
        try {
            Message messageObtain = Message.obtain((Handler) null, 100);
            Bundle bundle = new Bundle();
            bundle.putString("key", "oneid");
            messageObtain.setData(bundle);
            messageObtain.replyTo = this.f57398d;
            Messenger messenger = new Messenger(iBinder);
            this.f57397c = messenger;
            messenger.send(messageObtain);
        } catch (Exception e11) {
            f.f57417a.i(Log.getStackTraceString(e11));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        f.f57417a.g("onServiceDisconnected");
    }
}
