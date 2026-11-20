package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f10316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f10317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AudioManager f10318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public c f10319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10322h;

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
            Handler handler = f3.this.f10316b;
            final f3 f3Var = f3.this;
            handler.post(new Runnable() { // from class: androidx.media3.exoplayer.g3
                @Override // java.lang.Runnable
                public final void run() {
                    f3.b(f3Var);
                }
            });
        }
    }

    public f3(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f10315a = applicationContext;
        this.f10316b = handler;
        this.f10317c = bVar;
        AudioManager audioManager = (AudioManager) z3.a.i((AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.f10318d = audioManager;
        this.f10320f = 3;
        this.f10321g = f(audioManager, 3);
        this.f10322h = e(audioManager, this.f10320f);
        c cVar = new c();
        try {
            applicationContext.registerReceiver(cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f10319e = cVar;
        } catch (RuntimeException e11) {
            z3.o.i("StreamVolumeManager", "Error registering stream volume receiver", e11);
        }
    }

    public static /* synthetic */ void b(f3 f3Var) {
        f3Var.k();
    }

    public static boolean e(AudioManager audioManager, int i11) {
        if (z3.u0.f81838a >= 23) {
            return audioManager.isStreamMute(i11);
        }
        return f(audioManager, i11) == 0;
    }

    public static int f(AudioManager audioManager, int i11) {
        try {
            return audioManager.getStreamVolume(i11);
        } catch (RuntimeException e11) {
            z3.o.i("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i11, e11);
            return audioManager.getStreamMaxVolume(i11);
        }
    }

    public int c() {
        return this.f10318d.getStreamMaxVolume(this.f10320f);
    }

    public int d() {
        if (z3.u0.f81838a >= 28) {
            return this.f10318d.getStreamMinVolume(this.f10320f);
        }
        return 0;
    }

    public boolean g() {
        return this.f10322h;
    }

    public void h() {
        c cVar = this.f10319e;
        if (cVar != null) {
            try {
                this.f10315a.unregisterReceiver(cVar);
            } catch (RuntimeException e11) {
                z3.o.i("StreamVolumeManager", "Error unregistering stream volume receiver", e11);
            }
            this.f10319e = null;
        }
    }

    public void i(boolean z11, int i11) {
        if (z3.u0.f81838a >= 23) {
            this.f10318d.adjustStreamVolume(this.f10320f, z11 ? -100 : 100, i11);
        } else {
            this.f10318d.setStreamMute(this.f10320f, z11);
        }
        k();
    }

    public void j(int i11) {
        if (this.f10320f == i11) {
            return;
        }
        this.f10320f = i11;
        k();
        this.f10317c.f(i11);
    }

    public final void k() {
        int iF = f(this.f10318d, this.f10320f);
        boolean zE = e(this.f10318d, this.f10320f);
        if (this.f10321g == iF && this.f10322h == zE) {
            return;
        }
        this.f10321g = iF;
        this.f10322h = zE;
        this.f10317c.r(iF, zE);
    }
}
