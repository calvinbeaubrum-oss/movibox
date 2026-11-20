package com.applovin.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class il {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f19745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f19746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f19747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AudioManager f19748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f19749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f19752h;

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(int i11, boolean z11);

        void d(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public final class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = il.this.f19746b;
            final il ilVar = il.this;
            handler.post(new Runnable() { // from class: com.applovin.impl.ry
                @Override // java.lang.Runnable
                public final void run() {
                    ilVar.d();
                }
            });
        }
    }

    public il(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f19745a = applicationContext;
        this.f19746b = handler;
        this.f19747c = bVar;
        AudioManager audioManager = (AudioManager) b1.b((AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.f19748d = audioManager;
        this.f19750f = 3;
        this.f19751g = b(audioManager, 3);
        this.f19752h = a(audioManager, this.f19750f);
        c cVar = new c();
        try {
            applicationContext.registerReceiver(cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f19749e = cVar;
        } catch (RuntimeException e11) {
            pc.c("StreamVolumeManager", "Error registering stream volume receiver", e11);
        }
    }

    private static boolean a(AudioManager audioManager, int i11) {
        if (xp.f24372a >= 23) {
            return audioManager.isStreamMute(i11);
        }
        return b(audioManager, i11) == 0;
    }

    private static int b(AudioManager audioManager, int i11) {
        try {
            return audioManager.getStreamVolume(i11);
        } catch (RuntimeException e11) {
            pc.c("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i11, e11);
            return audioManager.getStreamMaxVolume(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int iB = b(this.f19748d, this.f19750f);
        boolean zA = a(this.f19748d, this.f19750f);
        if (this.f19751g == iB && this.f19752h == zA) {
            return;
        }
        this.f19751g = iB;
        this.f19752h = zA;
        this.f19747c.a(iB, zA);
    }

    public int a() {
        return this.f19748d.getStreamMaxVolume(this.f19750f);
    }

    public void a(int i11) {
        if (this.f19750f == i11) {
            return;
        }
        this.f19750f = i11;
        d();
        this.f19747c.d(i11);
    }

    public int b() {
        if (xp.f24372a >= 28) {
            return this.f19748d.getStreamMinVolume(this.f19750f);
        }
        return 0;
    }

    public void c() {
        c cVar = this.f19749e;
        if (cVar != null) {
            try {
                this.f19745a.unregisterReceiver(cVar);
            } catch (RuntimeException e11) {
                pc.c("StreamVolumeManager", "Error unregistering stream volume receiver", e11);
            }
            this.f19749e = null;
        }
    }
}
