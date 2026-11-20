package com.cloud.tmc.integration;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.cloud.tmc.kernel.log.TmcLogger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f30761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f30762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout.LayoutParams f30763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f30764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f30765e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f30766f;

    /* JADX INFO: compiled from: source.java */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (e.this.f30765e) {
                e eVar = e.this;
                eVar.f30764d = eVar.f30761a.getHeight();
                e.this.f30765e = false;
            }
            e.this.i();
        }
    }

    public e(Activity activity) {
        View childAt = ((FrameLayout) activity.findViewById(R.id.content)).getChildAt(0);
        this.f30761a = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.f30763c = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        this.f30766f = h(activity);
    }

    public static void f(Activity activity) {
        new e(activity);
    }

    public final int g() {
        Rect rect = new Rect();
        this.f30761a.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    public final int h(Activity activity) {
        if (activity == null) {
            return 0;
        }
        try {
            int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return activity.getResources().getDimensionPixelSize(identifier);
            }
        } catch (Throwable th2) {
            TmcLogger.g("SoftHideKeyBoardUtil", "Unable to get status bar height", th2);
        }
        return 0;
    }

    public final void i() {
        int iG = g();
        if (iG != this.f30762b) {
            int height = this.f30761a.getRootView().getHeight();
            int i11 = height - iG;
            if (i11 > height / 4) {
                this.f30763c.height = (height - i11) + this.f30766f;
            } else {
                this.f30763c.height = this.f30764d;
            }
            this.f30761a.requestLayout();
            this.f30762b = iG;
        }
    }
}
