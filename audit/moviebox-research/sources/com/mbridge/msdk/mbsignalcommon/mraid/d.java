package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static double f45741a = -1.0d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f45742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AudioManager f45743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f45744d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f45745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f45746f;

    /* JADX INFO: compiled from: source.java */
    public static class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<d> f45747a;

        public a(d dVar) {
            this.f45747a = new WeakReference<>(dVar);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            d dVar;
            b bVarB;
            if (!"android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3 || (dVar = this.f45747a.get()) == null || (bVarB = dVar.b()) == null) {
                return;
            }
            double dA = dVar.a();
            if (dA >= 0.0d) {
                bVarB.a(dA);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(double d11);
    }

    public d(Context context) {
        this.f45742b = context;
        this.f45743c = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public final double a() {
        AudioManager audioManager = this.f45743c;
        int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : -1;
        AudioManager audioManager2 = this.f45743c;
        double streamVolume = (((double) (audioManager2 != null ? audioManager2.getStreamVolume(3) : -1)) * 100.0d) / ((double) streamMaxVolume);
        f45741a = streamVolume;
        return streamVolume;
    }

    public final void a(b bVar) {
        this.f45745e = bVar;
    }

    public final b b() {
        return this.f45745e;
    }

    public final void c() {
        if (this.f45742b != null) {
            this.f45746f = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.f45742b.registerReceiver(this.f45746f, intentFilter);
            this.f45744d = true;
        }
    }

    public final void d() {
        Context context;
        if (!this.f45744d || (context = this.f45742b) == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.f45746f);
            this.f45745e = null;
            this.f45744d = false;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
