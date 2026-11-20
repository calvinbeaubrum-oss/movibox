package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f33201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f33202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f33203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AudioManager f33204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public c f33205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f33206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f33207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f33208h;

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void f(int i11);

        void r(int i11, boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public final class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = e3.this.f33202b;
            final e3 e3Var = e3.this;
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.f3
                @Override // java.lang.Runnable
                public final void run() {
                    e3.b(e3Var);
                }
            });
        }
    }

    public e3(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f33201a = applicationContext;
        this.f33202b = handler;
        this.f33203c = bVar;
        AudioManager audioManager = (AudioManager) com.google.android.exoplayer2.util.a.i((AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.f33204d = audioManager;
        this.f33206f = 3;
        this.f33207g = f(audioManager, 3);
        this.f33208h = e(audioManager, this.f33206f);
        c cVar = new c();
        try {
            applicationContext.registerReceiver(cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f33205e = cVar;
        } catch (RuntimeException e11) {
            com.google.android.exoplayer2.util.s.j("StreamVolumeManager", "Error registering stream volume receiver", e11);
        }
    }

    public static /* synthetic */ void b(e3 e3Var) {
        e3Var.i();
    }

    public static boolean e(AudioManager audioManager, int i11) {
        if (com.google.android.exoplayer2.util.o0.f35608a >= 23) {
            return audioManager.isStreamMute(i11);
        }
        return f(audioManager, i11) == 0;
    }

    public static int f(AudioManager audioManager, int i11) {
        try {
            return audioManager.getStreamVolume(i11);
        } catch (RuntimeException e11) {
            com.google.android.exoplayer2.util.s.j("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i11, e11);
            return audioManager.getStreamMaxVolume(i11);
        }
    }

    public int c() {
        return this.f33204d.getStreamMaxVolume(this.f33206f);
    }

    public int d() {
        if (com.google.android.exoplayer2.util.o0.f35608a >= 28) {
            return this.f33204d.getStreamMinVolume(this.f33206f);
        }
        return 0;
    }

    public void g() {
        c cVar = this.f33205e;
        if (cVar != null) {
            try {
                this.f33201a.unregisterReceiver(cVar);
            } catch (RuntimeException e11) {
                com.google.android.exoplayer2.util.s.j("StreamVolumeManager", "Error unregistering stream volume receiver", e11);
            }
            this.f33205e = null;
        }
    }

    public void h(int i11) {
        if (this.f33206f == i11) {
            return;
        }
        this.f33206f = i11;
        i();
        this.f33203c.f(i11);
    }

    public final void i() {
        int iF = f(this.f33204d, this.f33206f);
        boolean zE = e(this.f33204d, this.f33206f);
        if (this.f33207g == iF && this.f33208h == zE) {
            return;
        }
        this.f33207g = iF;
        this.f33208h = zE;
        this.f33203c.r(iF, zE);
    }
}
