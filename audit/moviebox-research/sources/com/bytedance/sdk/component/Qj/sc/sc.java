package com.bytedance.sdk.component.Qj.sc;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.FI;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private Handler pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final We<pFF> f26568sc;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.Qj.sc.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0247sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private static final sc f26571sc = new sc();
    }

    private sc() {
        this.f26568sc = We.sc(2);
    }

    private pFF pFF(FI.sc scVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return new pFF(handlerThread, scVar);
    }

    public static sc sc() {
        return C0247sc.f26571sc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(final Handler handler, final Handler handler2) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (!handler.getLooper().getQueue().isIdle()) {
                handler2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.Qj.sc.sc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        sc.this.sc(handler, handler2);
                    }
                }, 1000L);
            } else {
                handler.removeCallbacksAndMessages(null);
                handler.getLooper().quit();
            }
        }
    }

    public Handler pFF() {
        if (this.pFF == null) {
            synchronized (sc.class) {
                try {
                    if (this.pFF == null) {
                        this.pFF = sc("csj_io_handler");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.pFF;
    }

    public FI sc(FI.sc scVar, final String str) {
        pFF pff = (pFF) this.f26568sc.sc();
        if (pff == null) {
            return pFF(scVar, str);
        }
        pff.sc(scVar);
        pff.post(new Runnable() { // from class: com.bytedance.sdk.component.Qj.sc.sc.2
            @Override // java.lang.Runnable
            public void run() {
                Thread.currentThread().setName(str);
            }
        });
        return pff;
    }

    public FI sc(String str) {
        return sc((FI.sc) null, str);
    }

    public boolean sc(FI fi2) {
        if (!(fi2 instanceof pFF)) {
            return false;
        }
        pFF pff = (pFF) fi2;
        if (this.f26568sc.sc(pff)) {
            return true;
        }
        pff.pFF();
        return true;
    }
}
