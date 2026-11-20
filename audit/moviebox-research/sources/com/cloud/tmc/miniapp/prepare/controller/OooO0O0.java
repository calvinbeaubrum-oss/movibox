package com.cloud.tmc.miniapp.prepare.controller;

import android.os.Handler;
import android.os.Looper;
import com.cloud.tmc.kernel.log.TmcLogger;
import v.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class OooO0O0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f31564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f31565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OooO0OO f31566c = null;

    /* JADX INFO: compiled from: source.java */
    public class OooO0OO implements Runnable {
        public long OooO00o;
        public boolean OooO0O0 = false;

        public OooO0OO(long j11) {
            this.OooO00o = j11;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.OooO00o;
            TmcLogger.c("Tmcresource:Timer", "timer timeout on elapsed: " + jCurrentTimeMillis);
            if (this.OooO0O0) {
                return;
            }
            b bVar = OooO0O0.this.f31564a;
            if (bVar != null) {
                bVar.onTimeout(jCurrentTimeMillis);
            }
            OooO0O0.this.f31566c = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Handler f31567a = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void onTimeout(long j11);
    }

    public OooO0O0(b bVar, d dVar) {
        this.f31564a = bVar;
        this.f31565b = dVar;
    }
}
