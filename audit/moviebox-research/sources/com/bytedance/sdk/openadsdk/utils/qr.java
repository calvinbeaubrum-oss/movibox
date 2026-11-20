package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr implements Tf, Runnable {
    private long ExN;
    private boolean Qj;
    private boolean TRI;
    private long We;
    private final Activity pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final sc f28779qr;
    private final AtomicBoolean Ol = new AtomicBoolean(false);
    private final Handler zY = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private View f28780sc = We();

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void pFF();

        View sc();
    }

    private qr(Activity activity, int i11, sc scVar) {
        this.f28779qr = scVar;
        this.pFF = activity;
        this.We = i11;
    }

    private void ExN() {
        this.Qj = false;
        this.ExN = SystemClock.elapsedRealtime();
        Handler handler = this.zY;
        if (handler != null) {
            handler.postDelayed(this, this.We);
        }
    }

    private void TRI() {
        Activity activity;
        View childAt;
        if (this.TRI || (activity = this.pFF) == null || activity.isFinishing() || this.pFF.isDestroyed()) {
            return;
        }
        if (this.f28780sc == null) {
            this.f28780sc = We();
        }
        View view = this.f28780sc;
        if (view != null) {
            if (pFF(view)) {
                sc(this.f28780sc);
                View view2 = this.f28780sc;
                if ((view2 instanceof ViewGroup) && ((ViewGroup) view2).getChildCount() > 0 && (childAt = ((ViewGroup) this.f28780sc).getChildAt(0)) != null && pFF(childAt)) {
                    sc(childAt);
                }
                sc scVar = this.f28779qr;
                if (scVar != null) {
                    scVar.pFF();
                }
            }
            qr();
        }
        this.TRI = true;
    }

    private View We() {
        sc scVar = this.f28779qr;
        if (scVar != null) {
            return scVar.sc();
        }
        return null;
    }

    private boolean pFF(View view) {
        if (view == null) {
            return true;
        }
        return !view.isShown() || ((double) view.getAlpha()) <= 0.9d;
    }

    private void qr() {
        ViewParent parent = this.f28780sc.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.indexOfChild(this.f28780sc) != viewGroup.getChildCount() - 1) {
                this.f28780sc.bringToFront();
            }
        }
    }

    public static Tf sc(Activity activity, sc scVar) {
        int iJcs = com.bytedance.sdk.openadsdk.core.settings.dE.ef().jcs();
        return iJcs < 0 ? new Tf() { // from class: com.bytedance.sdk.openadsdk.utils.qr.1
            @Override // com.bytedance.sdk.openadsdk.utils.Tf
            public void pFF() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.Tf
            public void sc() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.Tf
            public void sc(long j11) {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.Tf
            public void zY() {
            }
        } : new qr(activity, Math.min(iJcs, 50) * 1000, scVar);
    }

    private void sc(View view) {
        view.setVisibility(0);
        view.setAlpha(1.0f);
    }

    @Override // com.bytedance.sdk.openadsdk.utils.Tf
    public void pFF() {
        if (this.ExN <= 0 || this.TRI) {
            return;
        }
        if (!this.Qj) {
            this.We -= SystemClock.elapsedRealtime() - this.ExN;
        }
        this.Qj = true;
        if (this.We <= 0) {
            TRI();
            return;
        }
        Handler handler = this.zY;
        if (handler != null) {
            try {
                handler.removeCallbacks(this);
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.pFF(th2.getMessage());
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        TRI();
    }

    @Override // com.bytedance.sdk.openadsdk.utils.Tf
    public void sc() {
        if (this.ExN == 0 || !this.Qj) {
            return;
        }
        ExN();
    }

    @Override // com.bytedance.sdk.openadsdk.utils.Tf
    public void sc(long j11) {
        if (this.Ol.compareAndSet(false, true)) {
            if (j11 < 0) {
                j11 = 0;
            }
            this.We += j11;
            ExN();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.Tf
    public void zY() {
        if (this.TRI) {
            return;
        }
        this.TRI = true;
        Handler handler = this.zY;
        if (handler != null) {
            try {
                handler.removeCallbacks(this);
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.pFF(th2.getMessage());
            }
        }
    }
}
