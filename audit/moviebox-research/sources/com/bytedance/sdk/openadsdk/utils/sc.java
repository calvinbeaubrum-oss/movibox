package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bytedance.sdk.openadsdk.ApmHelper;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements Application.ActivityLifecycleCallbacks {
    public static long pFF = 0;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static boolean f28781sc = false;
    public static long zY;
    private volatile WeakReference<Activity> Ql;
    private final AtomicBoolean We = new AtomicBoolean(false);
    private final RunnableC0317sc ExN = new RunnableC0317sc();
    private final We TRI = new We();

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final zY f28782qr = new zY();
    private final pFF Qj = new pFF();
    private int Ol = 0;
    private volatile CopyOnWriteArrayList<WeakReference<com.bytedance.sdk.component.adexpress.sc>> WH = new CopyOnWriteArrayList<>();
    private HandlerThread UFX = null;
    private Handler Tf = null;
    private final LinkedList<Activity> SR = new LinkedList<>();

    /* JADX INFO: compiled from: source.java */
    public class ExN implements Runnable {
        private boolean We;
        private long pFF;
        private long zY;

        public ExN(long j11, long j12, boolean z11) {
            this.pFF = j11;
            this.zY = j12;
            this.We = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.We) {
                com.bytedance.sdk.openadsdk.SR.zY.sc().sc(this.pFF / 1000, this.zY / 1000);
            }
            sc.this.We();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class We implements Runnable {
        public We() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.core.SR.pFF().removeMessages(1001);
            if (com.bytedance.sdk.openadsdk.core.Xc.sc() == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.WH.sc.pFF();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class pFF implements Runnable {
        private pFF() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.TRI.pFF.sc().pFF();
            com.bytedance.sdk.openadsdk.We.sc.SR srGx = com.bytedance.sdk.openadsdk.core.settings.dE.ef().gx();
            if (srGx == null || srGx.sc() || !com.bytedance.sdk.component.utils.BT.Qj(com.bytedance.sdk.openadsdk.core.Xc.sc())) {
                return;
            }
            com.bytedance.sdk.openadsdk.We.sc.We.sc(com.bytedance.sdk.openadsdk.core.Tf.sc(com.bytedance.sdk.openadsdk.core.Xc.sc()));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.utils.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class RunnableC0317sc implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Cb.zY(new com.bytedance.sdk.component.Qj.Qj("reportPvFromBackGround") { // from class: com.bytedance.sdk.openadsdk.utils.sc.sc.1
                @Override // java.lang.Runnable
                public void run() {
                    ApmHelper.reportPvFromBackGround();
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class zY implements Runnable {
        public zY() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ApmHelper.isIsInit()) {
                Handler handlerPFF = com.bytedance.sdk.openadsdk.core.SR.pFF();
                Message messageObtain = Message.obtain(handlerPFF, sc.this.ExN);
                messageObtain.what = 1001;
                handlerPFF.sendMessageDelayed(messageObtain, 30000L);
            }
        }
    }

    public sc() {
        zY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We() {
        com.bytedance.sdk.openadsdk.We.sc.sc.sc();
    }

    private void sc(Runnable runnable) {
        if (!this.UFX.isAlive()) {
            zY();
        }
        this.Tf.postDelayed(runnable, 1000L);
    }

    private void zY() {
        HandlerThread handlerThread = new HandlerThread(RequestParameters.SUBRESOURCE_LIFECYCLE, 10);
        this.UFX = handlerThread;
        handlerThread.start();
        this.Tf = new Handler(this.UFX.getLooper());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(final Activity activity, Bundle bundle) {
        Window window;
        this.SR.addFirst(activity);
        if (!kX.pFF() || (window = activity.getWindow()) == null) {
            return;
        }
        final View decorView = window.getDecorView();
        decorView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.sc.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@NonNull View view) {
                decorView.removeOnAttachStateChangeListener(this);
                if (kX.We(activity)) {
                    kX.sc(true);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@NonNull View view) {
                decorView.removeOnAttachStateChangeListener(this);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.WH != null && this.WH.size() > 0) {
            for (WeakReference<com.bytedance.sdk.component.adexpress.sc> weakReference : this.WH) {
                if (weakReference != null && weakReference.get() != null) {
                    try {
                        weakReference.get().sc(activity);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        if (this.Ql != null && this.Ql.get() == activity) {
            this.Ql = null;
        }
        this.SR.remove(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        int i11 = this.Ol - 1;
        this.Ol = i11;
        if (i11 < 0) {
            this.Ol = 0;
        }
        if (ApmHelper.isIsInit()) {
            sc(this.f28782qr);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        sc(this.TRI);
        if (!f28781sc) {
            pFF = System.currentTimeMillis();
            f28781sc = true;
        }
        this.Ql = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.Ol++;
        this.Tf.removeCallbacks(this.Qj);
        if (this.We.get()) {
            sc(this.Qj);
        }
        this.We.set(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.Ol <= 0) {
            this.We.set(true);
        }
        if (sc()) {
            f28781sc = false;
            com.bytedance.sdk.openadsdk.core.SR.pFF.set(false);
            zY = System.currentTimeMillis();
            sc(this.Qj);
        }
        sc(new ExN(pFF, zY, sc()));
    }

    public Activity pFF() {
        if (this.SR.isEmpty()) {
            return null;
        }
        return this.SR.getFirst();
    }

    public boolean pFF(com.bytedance.sdk.component.adexpress.sc scVar) {
        return this.WH.remove(new WeakReference(scVar));
    }

    public void sc(com.bytedance.sdk.component.adexpress.sc scVar) {
        this.WH.add(new WeakReference<>(scVar));
    }

    public boolean sc() {
        return this.We.get();
    }

    public boolean sc(boolean z11) {
        Activity activity;
        Window window;
        return (this.Ql == null || (activity = this.Ql.get()) == null || (window = activity.getWindow()) == null) ? z11 : window.getDecorView().hasWindowFocus();
    }
}
