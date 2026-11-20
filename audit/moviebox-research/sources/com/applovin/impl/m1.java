package com.applovin.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f20559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f20560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f20561c;

    /* JADX INFO: compiled from: source.java */
    public final class a extends BroadcastReceiver implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f20562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Handler f20563b;

        public a(Handler handler, b bVar) {
            this.f20563b = handler;
            this.f20562a = bVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f20563b.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m1.this.f20561c) {
                this.f20562a.c();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void c();
    }

    public m1(Context context, Handler handler, b bVar) {
        this.f20559a = context.getApplicationContext();
        this.f20560b = new a(handler, bVar);
    }

    public void a(boolean z11) {
        if (z11 && !this.f20561c) {
            this.f20559a.registerReceiver(this.f20560b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f20561c = true;
        } else {
            if (z11 || !this.f20561c) {
                return;
            }
            this.f20559a.unregisterReceiver(this.f20560b);
            this.f20561c = false;
        }
    }
}
