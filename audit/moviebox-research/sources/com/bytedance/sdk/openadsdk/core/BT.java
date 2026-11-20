package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.ApmHelper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BT {
    private boolean pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.utils.sc f28000sc = new com.bytedance.sdk.openadsdk.utils.sc();

    /* JADX INFO: compiled from: source.java */
    public static class sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private static final BT f28001sc = new BT();
    }

    public static BT sc() {
        return sc.f28001sc;
    }

    public com.bytedance.sdk.openadsdk.utils.sc ExN() {
        return this.f28000sc;
    }

    public boolean We() {
        return this.f28000sc.sc();
    }

    public void pFF() {
        try {
            Context contextSc = Xc.sc();
            if (contextSc instanceof Application) {
                ((Application) contextSc).registerActivityLifecycleCallbacks(this.f28000sc);
                this.pFF = true;
            } else {
                if (contextSc == null || contextSc.getApplicationContext() == null) {
                    return;
                }
                ((Application) contextSc.getApplicationContext()).registerActivityLifecycleCallbacks(this.f28000sc);
                this.pFF = true;
            }
        } catch (Throwable th2) {
            ApmHelper.reportCustomError("registerActivityLifecycleError", "registerActivityLifecycle", th2);
        }
    }

    public boolean sc(boolean z11) {
        return this.f28000sc.sc(z11);
    }

    public boolean zY() {
        return this.pFF;
    }
}
