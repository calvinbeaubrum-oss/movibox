package com.mbridge.msdk.newreward.a.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f46069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, c> f46070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f46071c;

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.a.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0504a {
        void a(String str, long j11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f46072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f46073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f46074c;

        public b(String str, long j11) {
            this.f46072a = str;
            this.f46073b = j11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f46075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC0504a f46076b;

        public c(b bVar, InterfaceC0504a interfaceC0504a) {
            this.f46075a = bVar;
            this.f46076b = interfaceC0504a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InterfaceC0504a interfaceC0504a;
            if (MBridgeConstans.DEBUG) {
                ad.a("MBridgeTimer", "TimerTask run taskID: " + this.f46075a.f46072a + " isStop: " + this.f46075a.f46074c);
            }
            if (this.f46075a.f46074c || (interfaceC0504a = this.f46076b) == null) {
                return;
            }
            try {
                interfaceC0504a.a(this.f46075a.f46072a, this.f46075a.f46073b);
            } catch (Exception unused) {
            }
        }
    }

    public a() {
        HandlerThread handlerThread = new HandlerThread("MBridgeTimerThread");
        handlerThread.start();
        this.f46071c = new Handler(handlerThread.getLooper());
        this.f46070b = new HashMap();
    }

    public static a a() {
        if (f46069a == null) {
            synchronized (a.class) {
                try {
                    if (f46069a == null) {
                        f46069a = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f46069a;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c cVarRemove = this.f46070b.remove(str);
        if (MBridgeConstans.DEBUG) {
            ad.a("MBridgeTimer", "stopTimer taskID: " + str);
        }
        if (cVarRemove != null) {
            cVarRemove.f46075a.f46074c = true;
            this.f46071c.removeCallbacks(cVarRemove);
        }
    }

    public final void a(String str, long j11, InterfaceC0504a interfaceC0504a) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (MBridgeConstans.DEBUG) {
            ad.a("MBridgeTimer", "startTimer taskID: " + str + " timeout: " + j11);
        }
        if (this.f46070b.containsKey(str)) {
            return;
        }
        c cVar = new c(new b(str, j11), interfaceC0504a);
        this.f46070b.put(str, cVar);
        this.f46071c.postDelayed(cVar, j11);
    }
}
