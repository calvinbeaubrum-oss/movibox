package n0;

import OooO0o0.OooO0OO;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Handler f71334g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f71335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f71336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f71337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f71338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AnimatorSet f71339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f71340f;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends OooO0OO.OooO00o<a> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context);
            Intrinsics.g(context, "context");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements OooO0OO.g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f71342b;

        public b(i iVar) {
            this.f71342b = iVar;
        }

        @Override // OooO0o0.OooO0OO.g
        public void a(OooO0OO oooO0OO) {
            Window window = oooO0OO.getWindow();
            if (window != null) {
                h hVar = h.this;
                i iVar = this.f71342b;
                WindowManager.LayoutParams attributes = window.getAttributes();
                Intrinsics.f(attributes, "window.attributes");
                hVar.getClass();
                attributes.verticalMargin = iVar.f71354h;
                attributes.horizontalMargin = iVar.f71353g;
                window.addFlags(128);
                n0.d dVar = iVar.f71355i;
                if (dVar == null || !dVar.f71323d) {
                    window.addFlags(8);
                    window.addFlags(16);
                }
                window.setAttributes(attributes);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements OooO0OO.j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f71344b;

        public c(i iVar) {
            this.f71344b = iVar;
        }

        @Override // OooO0o0.OooO0OO.j
        public void b(OooO0OO oooO0OO) {
            ImageView imageViewA;
            TmcLogger.c("ToastDialog", "onShow");
            if (h.e(h.this, this.f71344b)) {
                h hVar = h.this;
                i iVar = this.f71344b;
                hVar.getClass();
                try {
                    TmcLogger.c("ToastDialog", "startAnimator");
                    if (hVar.f71340f || (imageViewA = o0.e.a.a(iVar.f71347a)) == null) {
                        return;
                    }
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageViewA, "rotation", 0.0f, 360.0f);
                    Intrinsics.f(objectAnimatorOfFloat, "ofFloat(it, \"rotation\", 0F, 360F)");
                    objectAnimatorOfFloat.setDuration(600L);
                    objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                    objectAnimatorOfFloat.setRepeatCount(-1);
                    hVar.f71339e.play(objectAnimatorOfFloat);
                    hVar.f71339e.start();
                    hVar.f71340f = true;
                } catch (Throwable th2) {
                    TmcLogger.h("ToastDialog", th2);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements OooO0OO.h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f71346b;

        public d(i iVar) {
            this.f71346b = iVar;
        }

        @Override // OooO0o0.OooO0OO.h
        public void a(OooO0OO oooO0OO) {
            TmcLogger.c("ToastDialog", "onDismiss");
            if (h.e(h.this, this.f71346b)) {
                h hVar = h.this;
                hVar.getClass();
                try {
                    TmcLogger.c("ToastDialog", "cancelAnimator");
                    if (hVar.f71340f) {
                        hVar.f71339e.cancel();
                        hVar.f71340f = false;
                    }
                } catch (Throwable th2) {
                    TmcLogger.h("ToastDialog", th2);
                }
            }
        }
    }

    public h(Context context, final i toast) {
        Intrinsics.g(context, "context");
        Intrinsics.g(toast, "toast");
        this.f71338d = new Object();
        this.f71339e = new AnimatorSet();
        a aVar = new a(context);
        c(toast, aVar);
        this.f71335a = aVar;
        this.f71336b = new Runnable() { // from class: n0.e
            @Override // java.lang.Runnable
            public final void run() {
                h.d(toast, this);
            }
        };
        this.f71337c = new Runnable() { // from class: n0.f
            @Override // java.lang.Runnable
            public final void run() {
                h.b(this.f71332a);
            }
        };
    }

    public static final void b(h this$0) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f71335a.p()) {
            TmcLogger.c("ToastDialog", "It's showing, will be dismissed");
            this$0.f71335a.l();
        }
        TmcLogger.c("ToastDialog", "cancel runnable is running");
    }

    public static final void d(i toast, final h this$0) {
        long j11;
        Intrinsics.g(toast, "$toast");
        Intrinsics.g(this$0, "this$0");
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i11 = toast.f71349c;
        if (i11 == 1) {
            j11 = 3500;
        } else {
            j11 = (i11 != 0 && i11 <= 60000 && i11 >= 1000) ? i11 : AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
        }
        long j12 = jUptimeMillis + j11;
        if (this$0.f71335a.p()) {
            TmcLogger.c("ToastDialog", "It's showing, will be update content");
            f71334g.removeCallbacksAndMessages(this$0.f71338d);
            this$0.c(toast, this$0.f71335a);
        }
        this$0.f71335a.q();
        f71334g.postAtTime(new Runnable() { // from class: n0.g
            @Override // java.lang.Runnable
            public final void run() {
                h.f(this.f71333a);
            }
        }, this$0.f71338d, j12);
        TmcLogger.c("ToastDialog", "show runnable is running");
    }

    public static final boolean e(h hVar, i iVar) {
        hVar.getClass();
        n0.d dVar = iVar.f71355i;
        o0.c<?> cVar = dVar != null ? dVar.f71326g : null;
        return (cVar instanceof f0.c) && (cVar.OooO00o() instanceof o0.a.b);
    }

    public static final void f(h this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.a();
    }

    public final void a() {
        TmcLogger.c("ToastDialog", "cancel toast dialog");
        Handler handler = f71334g;
        handler.removeCallbacks(this.f71336b);
        if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
            this.f71337c.run();
        } else {
            handler.removeCallbacks(this.f71337c);
            handler.post(this.f71337c);
        }
    }

    public final void c(i iVar, a aVar) {
        OooO0OO oooO0OO;
        Window window;
        OooO0OO oooO0OO2;
        Window window2;
        a aVarM = aVar.f(iVar.f71347a).m(iVar.f71350d);
        int i11 = iVar.f71351e;
        aVarM.f35j = i11;
        if (aVarM.o() && (oooO0OO2 = aVarM.f28b) != null && (window2 = oooO0OO2.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window2.getAttributes();
            if (attributes != null) {
                attributes.x = i11;
            }
            window2.setAttributes(attributes);
        }
        Intrinsics.e(aVarM, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
        int i12 = iVar.f71352f;
        aVarM.f36k = i12;
        if (aVarM.o() && (oooO0OO = aVarM.f28b) != null && (window = oooO0OO.getWindow()) != null) {
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            if (attributes2 != null) {
                attributes2.y = i12;
            }
            window.setAttributes(attributes2);
        }
        Intrinsics.e(aVarM, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
        a aVarG = aVarM.b(0).k(false).g(false);
        b listener = new b(iVar);
        Intrinsics.g(listener, "listener");
        aVarG.f41p = listener;
        Intrinsics.e(aVarG, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
        aVarG.e(new c(iVar)).d(new d(iVar));
    }
}
