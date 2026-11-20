package com.cloud.hisavana.sdk.common.tranmeasure;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.cloud.hisavana.sdk.b2;
import com.cloud.hisavana.sdk.i2;
import com.cloud.hisavana.sdk.k2;
import com.cloud.hisavana.sdk.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f29505a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f29506b = "";

    public static g b(b2 b2Var) {
        if (b2Var == null) {
            return null;
        }
        if (b2Var.f29197a > 0.0f) {
            return new i2();
        }
        if (b2Var.f29198b > 0) {
            return new k2();
        }
        return null;
    }

    public int a(b2 b2Var, View view) {
        int iD;
        if (!e(view) || b2Var == null || (iD = d(b2Var, view)) == 0 || c(view)) {
            return 0;
        }
        return iD;
    }

    public final boolean c(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    do {
                        ViewParent parent = view.getParent();
                        if (parent instanceof ViewGroup) {
                            view = (ViewGroup) parent;
                        }
                    } while (view.getVisibility() == 0);
                    return true;
                }
            } catch (Throwable th2) {
                z.a().w("ssp", Log.getStackTraceString(th2));
            }
        }
        return false;
    }

    public abstract int d(b2 b2Var, View view);

    public final boolean e(View view) {
        return (view == null || view.getVisibility() != 0 || view.getAlpha() == 0.0f || !view.isAttachedToWindow() || view.getRootView() == null) ? false : true;
    }
}
