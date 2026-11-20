package com.tn.lib.widget.toast.core;

import android.R;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import com.blankj.utilcode.util.f0;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class ToastImpl {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Handler f50008g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aq.a f50009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f50010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f50011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f50012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f50013e = new AnonymousClass1();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f50014f = new Runnable() { // from class: com.tn.lib.widget.toast.core.ToastImpl.2
        @Override // java.lang.Runnable
        public void run() {
            WindowManager windowManager;
            try {
                try {
                    Activity activityA = ToastImpl.this.f50010b.a();
                    if (activityA != null && (windowManager = (WindowManager) activityA.getSystemService("window")) != null) {
                        windowManager.removeViewImmediate(ToastImpl.this.f50009a.getView());
                    }
                } catch (IllegalArgumentException e11) {
                    e11.printStackTrace();
                }
            } finally {
                ToastImpl.this.f50010b.c();
                ToastImpl.this.g(false);
            }
        }
    };

    /* JADX INFO: renamed from: com.tn.lib.widget.toast.core.ToastImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            ToastImpl.this.e();
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activityA = ToastImpl.this.f50010b.a();
            if (activityA == null || activityA.isFinishing() || activityA.isDestroyed()) {
                return;
            }
            int iA = (ToastImpl.this.f50009a.getView() == null || !(ToastImpl.this.f50009a.getView().getTag() instanceof Integer)) ? -2 : f0.a(((Integer) ToastImpl.this.f50009a.getView().getTag()).intValue());
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = iA;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation.Toast;
            if (ToastImpl.this.f50009a.a()) {
                layoutParams.flags = 136;
            } else {
                layoutParams.flags = 152;
            }
            layoutParams.packageName = ToastImpl.this.f50011c;
            layoutParams.gravity = ToastImpl.this.f50009a.getGravity();
            layoutParams.x = ToastImpl.this.f50009a.getXOffset();
            layoutParams.y = ToastImpl.this.f50009a.getYOffset();
            layoutParams.verticalMargin = ToastImpl.this.f50009a.getVerticalMargin();
            layoutParams.horizontalMargin = ToastImpl.this.f50009a.getHorizontalMargin();
            WindowManager windowManager = (WindowManager) activityA.getSystemService("window");
            if (windowManager == null) {
                return;
            }
            try {
                windowManager.addView(ToastImpl.this.f50009a.getView(), layoutParams);
                ToastImpl.f50008g.postDelayed(new Runnable() { // from class: com.tn.lib.widget.toast.core.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f50028a.lambda$run$0();
                    }
                }, ToastImpl.this.f50009a.getDuration() == 1 ? 3500L : AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                ToastImpl.this.f50010b.b(ToastImpl.this);
                ToastImpl.this.g(true);
            } catch (WindowManager.BadTokenException | IllegalStateException e11) {
                e11.printStackTrace();
            }
        }
    }

    public ToastImpl(Activity activity, aq.a aVar) {
        this.f50009a = aVar;
        this.f50011c = activity.getPackageName();
        this.f50010b = new i(activity);
    }

    public void e() {
        if (f()) {
            Handler handler = f50008g;
            handler.removeCallbacks(this.f50014f);
            handler.post(this.f50014f);
        }
    }

    public boolean f() {
        return this.f50012d;
    }

    public void g(boolean z11) {
        this.f50012d = z11;
    }

    public void h() {
        if (f()) {
            return;
        }
        Handler handler = f50008g;
        handler.removeCallbacks(this.f50013e);
        handler.post(this.f50013e);
    }
}
