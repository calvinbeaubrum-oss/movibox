package com.cloud.sdk.commonutil.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class RunTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30270a = 60000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f30271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f30272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f30273d;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void isTimeOut();
    }

    public void b() {
        this.f30271b = null;
        Handler handler = this.f30272c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f30272c = null;
        }
        this.f30273d = null;
    }

    public void c() {
        if (this.f30272c == null) {
            this.f30272c = new Handler(Looper.getMainLooper());
        }
        if (this.f30273d == null) {
            this.f30273d = new Runnable() { // from class: com.cloud.sdk.commonutil.util.RunTimer.1
                @Override // java.lang.Runnable
                public void run() {
                    if (RunTimer.this.f30271b != null) {
                        RunTimer.this.f30271b.isTimeOut();
                    }
                }
            };
        }
        try {
            this.f30272c.postDelayed(this.f30273d, this.f30270a);
        } catch (Throwable th2) {
            Log.e("RunTimer", Log.getStackTraceString(th2));
        }
    }

    public void d(int i11) {
        this.f30270a = i11;
    }

    public void e(a aVar) {
        this.f30271b = aVar;
    }
}
