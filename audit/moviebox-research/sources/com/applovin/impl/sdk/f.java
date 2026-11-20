package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends BroadcastReceiver implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f22518i = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AudioManager f22519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f22520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f22521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f22522d = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f22523f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f22524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f22525h;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(int i11);
    }

    public f(j jVar) {
        this.f22521c = jVar;
        Context contextL = j.l();
        this.f22520b = contextL;
        this.f22519a = (AudioManager) contextL.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public static boolean a(int i11) {
        return i11 == 0 || i11 == 1;
    }

    private void b() {
        this.f22521c.J();
        if (n.a()) {
            this.f22521c.J().a("AudioSessionManager", "Observing ringer mode...");
        }
        this.f22525h = f22518i;
        this.f22520b.registerReceiver(this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    private void b(final int i11) {
        if (this.f22524g) {
            return;
        }
        this.f22521c.J();
        if (n.a()) {
            this.f22521c.J().a("AudioSessionManager", "Ringer mode is " + i11);
        }
        synchronized (this.f22523f) {
            try {
                for (final a aVar : this.f22522d) {
                    AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.c0
                        @Override // java.lang.Runnable
                        public final void run() {
                            aVar.a(i11);
                        }
                    });
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void c() {
        this.f22521c.J();
        if (n.a()) {
            this.f22521c.J().a("AudioSessionManager", "Stopping observation of mute switch state...");
        }
        this.f22520b.unregisterReceiver(this);
        AppLovinBroadcastManager.unregisterReceiver(this);
    }

    public int a() {
        return this.f22519a.getRingerMode();
    }

    public void a(a aVar) {
        synchronized (this.f22523f) {
            try {
                if (this.f22522d.contains(aVar)) {
                    return;
                }
                this.f22522d.add(aVar);
                if (this.f22522d.size() == 1) {
                    b();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.f22523f) {
            try {
                if (this.f22522d.contains(aVar)) {
                    this.f22522d.remove(aVar);
                    if (this.f22522d.isEmpty()) {
                        c();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
            b(this.f22519a.getRingerMode());
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.f22524g = true;
            this.f22525h = this.f22519a.getRingerMode();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            this.f22524g = false;
            if (this.f22525h != this.f22519a.getRingerMode()) {
                this.f22525h = f22518i;
                b(this.f22519a.getRingerMode());
            }
        }
    }
}
