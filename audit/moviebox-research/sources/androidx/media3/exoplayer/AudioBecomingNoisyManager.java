package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class AudioBecomingNoisyManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioBecomingNoisyReceiver f9817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9818c;

    /* JADX INFO: compiled from: source.java */
    public final class AudioBecomingNoisyReceiver extends BroadcastReceiver implements Runnable {
        private final Handler eventHandler;
        private final a listener;

        public AudioBecomingNoisyReceiver(Handler handler, a aVar) {
            this.eventHandler = handler;
            this.listener = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.eventHandler.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AudioBecomingNoisyManager.this.f9818c) {
                this.listener.m();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void m();
    }

    public AudioBecomingNoisyManager(Context context, Handler handler, a aVar) {
        this.f9816a = context.getApplicationContext();
        this.f9817b = new AudioBecomingNoisyReceiver(handler, aVar);
    }

    public void b(boolean z11) {
        if (z11 && !this.f9818c) {
            this.f9816a.registerReceiver(this.f9817b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f9818c = true;
        } else {
            if (z11 || !this.f9818c) {
                return;
            }
            this.f9816a.unregisterReceiver(this.f9817b);
            this.f9818c = false;
        }
    }
}
