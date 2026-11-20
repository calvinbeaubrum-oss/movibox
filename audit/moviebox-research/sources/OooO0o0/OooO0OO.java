package OooO0o0;

import OooO0o0.OooO0OO;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.StringRes;
import androidx.appcompat.app.w;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$style;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class OooO0OO extends w implements id.a, id.h, id.e, id.d, id.b, id.f, DialogInterface.OnShowListener, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e<OooO0OO> f23g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<j> f24h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<f> f25i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<h> f26j;

    /* JADX INFO: compiled from: source.java */
    public static class OooO00o<B extends OooO00o<B>> implements id.a, id.h, id.d, id.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f27a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public OooO0OO f28b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f29c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f30d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f31f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f32g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f33h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f34i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f35j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f36k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f37l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f38m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f39n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f40o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public g f41p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Lazy f42q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Lazy f43r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final Lazy f44s;

        /* JADX INFO: renamed from: OooO0o0.OooO0OO$OooO00o$OooO00o, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0003OooO00o extends Lambda implements Function0<ArrayList<f>> {
            public static final C0003OooO00o OooO00o = new C0003OooO00o();

            public C0003OooO00o() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public ArrayList<f> invoke() {
                return new ArrayList<>();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class OooO0O0 extends Lambda implements Function0<ArrayList<h>> {
            public static final OooO0O0 OooO00o = new OooO0O0();

            public OooO0O0() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public ArrayList<h> invoke() {
                return new ArrayList<>();
            }
        }

        /* JADX INFO: renamed from: OooO0o0.OooO0OO$OooO00o$OooO0OO, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0004OooO0OO extends Lambda implements Function0<ArrayList<j>> {
            public static final C0004OooO0OO OooO00o = new C0004OooO0OO();

            public C0004OooO0OO() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public ArrayList<j> invoke() {
                return new ArrayList<>();
            }
        }

        public OooO00o(Context context) {
            Intrinsics.g(context, "context");
            this.f27a = context;
            this.f30d = R$style.MiniSDKDialogTheme;
            this.f31f = -1;
            this.f32g = -2;
            this.f33h = -2;
            this.f37l = true;
            this.f38m = true;
            this.f39n = true;
            this.f40o = 0.5f;
            this.f42q = LazyKt__LazyJVMKt.b(C0004OooO0OO.OooO00o);
            this.f43r = LazyKt__LazyJVMKt.b(C0003OooO00o.OooO00o);
            this.f44s = LazyKt__LazyJVMKt.b(OooO0O0.OooO00o);
        }

        public B a(float f11) {
            OooO0OO oooO0OO;
            Window window;
            this.f40o = f11;
            if (o() && (oooO0OO = this.f28b) != null && (window = oooO0OO.getWindow()) != null) {
                window.setDimAmount(f11);
            }
            Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B b(int i11) {
            OooO0OO oooO0OO;
            Window window;
            this.f31f = i11;
            if (o() && (oooO0OO = this.f28b) != null && (window = oooO0OO.getWindow()) != null) {
                window.setWindowAnimations(i11);
            }
            Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B c(f listener) {
            Intrinsics.g(listener, "listener");
            ((List) this.f43r.getValue()).add(listener);
            Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B d(h listener) {
            Intrinsics.g(listener, "listener");
            ((List) this.f44s.getValue()).add(listener);
            Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B e(j listener) {
            Intrinsics.g(listener, "listener");
            ((List) this.f42q.getValue()).add(listener);
            Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B f(View view) {
            int i11;
            Window window;
            Window window2;
            if (view == null) {
                throw new IllegalArgumentException("are you ok?");
            }
            this.f29c = view;
            if (o()) {
                OooO0OO oooO0OO = this.f28b;
                if (oooO0OO != null) {
                    oooO0OO.setContentView(view);
                }
                Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
                return this;
            }
            View view2 = this.f29c;
            ViewGroup.LayoutParams layoutParams = view2 != null ? view2.getLayoutParams() : null;
            if (layoutParams != null && this.f32g == -2 && this.f33h == -2) {
                int i12 = layoutParams.width;
                this.f32g = i12;
                if (o()) {
                    OooO0OO oooO0OO2 = this.f28b;
                    if (oooO0OO2 != null && (window2 = oooO0OO2.getWindow()) != null) {
                        WindowManager.LayoutParams attributes = window2.getAttributes();
                        if (attributes != null) {
                            attributes.width = i12;
                        }
                        window2.setAttributes(attributes);
                    }
                    Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
                } else {
                    View view3 = this.f29c;
                    ViewGroup.LayoutParams layoutParams2 = view3 != null ? view3.getLayoutParams() : null;
                    if (layoutParams2 != null) {
                        layoutParams2.width = i12;
                        View view4 = this.f29c;
                        if (view4 != null) {
                            view4.setLayoutParams(layoutParams2);
                        }
                    }
                    Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
                }
                int i13 = layoutParams.height;
                this.f33h = i13;
                if (o()) {
                    OooO0OO oooO0OO3 = this.f28b;
                    if (oooO0OO3 != null && (window = oooO0OO3.getWindow()) != null) {
                        WindowManager.LayoutParams attributes2 = window.getAttributes();
                        if (attributes2 != null) {
                            attributes2.height = i13;
                        }
                        window.setAttributes(attributes2);
                    }
                    Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
                } else {
                    View view5 = this.f29c;
                    ViewGroup.LayoutParams layoutParams3 = view5 != null ? view5.getLayoutParams() : null;
                    if (layoutParams3 != null) {
                        layoutParams3.height = i13;
                        View view6 = this.f29c;
                        if (view6 != null) {
                            view6.setLayoutParams(layoutParams3);
                        }
                    }
                    Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
                }
            }
            if (this.f34i == 0) {
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    int i14 = ((FrameLayout.LayoutParams) layoutParams).gravity;
                    if (i14 != -1) {
                        m(i14);
                    }
                } else if ((layoutParams instanceof LinearLayout.LayoutParams) && (i11 = ((LinearLayout.LayoutParams) layoutParams).gravity) != 0) {
                    m(i11);
                }
                if (this.f34i == 0) {
                    m(17);
                }
            }
            Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        @Override // id.d
        public <V extends View> V findViewById(int i11) {
            View view = this.f29c;
            if (view != null) {
                return (V) view.findViewById(i11);
            }
            throw new IllegalStateException("are you ok?");
        }

        public B g(boolean z11) {
            OooO0OO oooO0OO;
            this.f39n = z11;
            if (o() && (oooO0OO = this.f28b) != null) {
                if (z11) {
                    Window window = oooO0OO.getWindow();
                    if (window != null) {
                        window.addFlags(2);
                    }
                } else {
                    Window window2 = oooO0OO.getWindow();
                    if (window2 != null) {
                        window2.clearFlags(2);
                    }
                }
            }
            Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        @Override // id.a, id.h
        public Context getContext() {
            return this.f27a;
        }

        public OooO0OO h() {
            if (this.f29c == null) {
                throw new IllegalArgumentException("are you ok?");
            }
            if (p()) {
                l();
            }
            if (this.f34i == 0) {
                this.f34i = 17;
            }
            int iB = -1;
            if (this.f31f == -1) {
                int i11 = this.f34i;
                if (i11 == 3) {
                    iB = id.b.f67188f8.b();
                } else if (i11 == 5) {
                    iB = id.b.f67188f8.c();
                } else if (i11 == 48) {
                    iB = id.b.f67188f8.d();
                } else if (i11 == 80) {
                    iB = id.b.f67188f8.a();
                }
                this.f31f = iB;
            }
            OooO0OO oooO0OOI = i(this.f27a, this.f30d);
            this.f28b = oooO0OOI;
            Intrinsics.d(oooO0OOI);
            View view = this.f29c;
            Intrinsics.d(view);
            oooO0OOI.setContentView(view);
            oooO0OOI.setCancelable(this.f37l);
            if (this.f37l) {
                oooO0OOI.setCanceledOnTouchOutside(this.f38m);
            }
            OooO0OO.p(oooO0OOI, (List) this.f42q.getValue());
            OooO0OO.n(oooO0OOI, (List) this.f43r.getValue());
            OooO0OO.o(oooO0OOI, (List) this.f44s.getValue());
            oooO0OOI.l(null);
            Window window = oooO0OOI.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Intrinsics.f(attributes, "window.attributes");
                attributes.width = this.f32g;
                attributes.height = this.f33h;
                attributes.gravity = this.f34i;
                attributes.x = this.f35j;
                attributes.y = this.f36k;
                attributes.windowAnimations = this.f31f;
                if (this.f39n) {
                    window.addFlags(2);
                    window.setDimAmount(this.f40o);
                } else {
                    window.clearFlags(2);
                }
                window.setAttributes(attributes);
            }
            Activity activity = r();
            if (activity != null) {
                Intrinsics.g(activity, "activity");
                new b(activity, oooO0OOI);
            }
            g gVar = this.f41p;
            if (gVar != null) {
                gVar.a(oooO0OOI);
            }
            OooO0OO oooO0OO = this.f28b;
            Intrinsics.d(oooO0OO);
            return oooO0OO;
        }

        public OooO0OO i(Context context, int i11) {
            Intrinsics.g(context, "context");
            return new OooO0OO(context, i11);
        }

        public B j(int i11) {
            return (B) f(LayoutInflater.from(this.f27a).inflate(i11, (ViewGroup) new FrameLayout(this.f27a), false));
        }

        public B k(boolean z11) {
            OooO0OO oooO0OO;
            this.f37l = z11;
            if (o() && (oooO0OO = this.f28b) != null) {
                oooO0OO.setCancelable(z11);
            }
            Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public void l() {
            OooO0OO oooO0OO;
            try {
                Activity activityR = r();
                if (activityR == null || activityR.isFinishing() || activityR.isDestroyed() || (oooO0OO = this.f28b) == null) {
                    return;
                }
                oooO0OO.dismiss();
            } catch (Throwable th2) {
                TmcLogger.f("BaseDialog", "dismiss ->" + th2);
            }
        }

        public B m(int i11) {
            OooO0OO oooO0OO;
            Window window;
            this.f34i = Gravity.getAbsoluteGravity(i11, s().getConfiguration().getLayoutDirection());
            if (o() && (oooO0OO = this.f28b) != null && (window = oooO0OO.getWindow()) != null) {
                window.setGravity(i11);
            }
            Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B n(boolean z11) {
            OooO0OO oooO0OO;
            this.f38m = z11;
            if (o() && this.f37l && (oooO0OO = this.f28b) != null) {
                oooO0OO.setCanceledOnTouchOutside(z11);
            }
            Intrinsics.e(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public boolean o() {
            return this.f28b != null;
        }

        public void onClick(View view) {
            id.d.a.a(this, view);
        }

        public boolean p() {
            OooO0OO oooO0OO;
            return o() && (oooO0OO = this.f28b) != null && oooO0OO.isShowing();
        }

        public void q() {
            OooO0OO oooO0OO;
            try {
                Activity activityR = r();
                if (activityR != null && !activityR.isFinishing() && !activityR.isDestroyed()) {
                    if (!o()) {
                        h();
                    }
                    if (p() || (oooO0OO = this.f28b) == null) {
                        return;
                    }
                    oooO0OO.show();
                }
            } catch (Throwable th2) {
                TmcLogger.f("BaseDialog", "show ->" + th2);
            }
        }

        public Activity r() {
            return id.a.C0709a.a(this);
        }

        public Resources s() {
            return id.h.a.c(this);
        }

        @Override // id.d
        public void setOnClickListener(View.OnClickListener onClickListener, int... iArr) {
            id.d.a.b(this, onClickListener, iArr);
        }

        @Override // id.d
        public void setOnClickListener(View.OnClickListener onClickListener, View... viewArr) {
            id.d.a.c(this, onClickListener, viewArr);
        }

        public String t(@StringRes int i11) {
            return id.h.a.d(this, i11);
        }

        public void u(View... viewArr) {
            id.d.a.e(this, viewArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a extends SoftReference<DialogInterface.OnCancelListener> implements f {
        public a(DialogInterface.OnCancelListener onCancelListener) {
            super(onCancelListener);
        }

        @Override // OooO0o0.OooO0OO.f
        public void a(OooO0OO oooO0OO) {
            DialogInterface.OnCancelListener onCancelListener = get();
            if (onCancelListener != null) {
                onCancelListener.onCancel(oooO0OO);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements Application.ActivityLifecycleCallbacks, j, h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Activity f45a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public OooO0OO f46b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f47c;

        public b(Activity activity, OooO0OO oooO0OO) {
            this.f45a = activity;
            this.f46b = oooO0OO;
            if (oooO0OO != null) {
                oooO0OO.m(this);
            }
            OooO0OO oooO0OO2 = this.f46b;
            if (oooO0OO2 != null) {
                oooO0OO2.k(this);
            }
        }

        public static final void c(OooO0OO it, b this$0) {
            Intrinsics.g(it, "$it");
            Intrinsics.g(this$0, "this$0");
            if (it.isShowing()) {
                it.j(this$0.f47c);
            }
        }

        @Override // OooO0o0.OooO0OO.h
        public void a(OooO0OO oooO0OO) {
            this.f46b = null;
            Activity activity = this.f45a;
            if (activity != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    activity.unregisterActivityLifecycleCallbacks(this);
                } else {
                    activity.getApplication().unregisterActivityLifecycleCallbacks(this);
                }
            }
        }

        @Override // OooO0o0.OooO0OO.j
        public void b(OooO0OO oooO0OO) {
            this.f46b = oooO0OO;
            Activity activity = this.f45a;
            if (activity != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    activity.registerActivityLifecycleCallbacks(this);
                } else {
                    activity.getApplication().registerActivityLifecycleCallbacks(this);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.g(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.g(activity, "activity");
            Activity activity2 = this.f45a;
            if (activity2 != activity) {
                return;
            }
            if (activity2 != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    activity2.unregisterActivityLifecycleCallbacks(this);
                } else {
                    activity2.getApplication().unregisterActivityLifecycleCallbacks(this);
                }
            }
            this.f45a = null;
            OooO0OO oooO0OO = this.f46b;
            if (oooO0OO != null) {
                List<j> list = oooO0OO.f24h;
                if (list != null) {
                    list.remove(this);
                }
                List<h> list2 = oooO0OO.f26j;
                if (list2 != null) {
                    list2.remove(this);
                }
                if (oooO0OO.isShowing()) {
                    oooO0OO.dismiss();
                }
            }
            this.f46b = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            OooO0OO oooO0OO;
            Intrinsics.g(activity, "activity");
            if (this.f45a == activity && (oooO0OO = this.f46b) != null && oooO0OO.isShowing()) {
                Window window = oooO0OO.getWindow();
                this.f47c = window == null ? -1 : window.getAttributes().windowAnimations;
                oooO0OO.j(0);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            final OooO0OO oooO0OO;
            Intrinsics.g(activity, "activity");
            if (this.f45a == activity && (oooO0OO = this.f46b) != null && oooO0OO.isShowing()) {
                id.e.b.e(oooO0OO, new Runnable() { // from class: j.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooO0OO.b.c(oooO0OO, this);
                    }
                }, 100L);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Intrinsics.g(activity, "activity");
            Intrinsics.g(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.g(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.g(activity, "activity");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends SoftReference<DialogInterface.OnDismissListener> implements h {
        public c(DialogInterface.OnDismissListener onDismissListener) {
            super(onDismissListener);
        }

        @Override // OooO0o0.OooO0OO.h
        public void a(OooO0OO oooO0OO) {
            DialogInterface.OnDismissListener onDismissListener = get();
            if (onDismissListener != null) {
                onDismissListener.onDismiss(oooO0OO);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements DialogInterface.OnKeyListener {
        public d(i iVar) {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e<T extends DialogInterface.OnShowListener & DialogInterface.OnCancelListener & DialogInterface.OnDismissListener> extends SoftReference<T> implements DialogInterface.OnShowListener, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
        public e(T t11) {
            super(t11);
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            T t11 = get();
            if (t11 != null) {
                t11.onCancel(dialogInterface);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            T t11 = get();
            if (t11 != null) {
                t11.onDismiss(dialogInterface);
            }
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            T t11 = get();
            if (t11 != null) {
                t11.onShow(dialogInterface);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        void a(OooO0OO oooO0OO);
    }

    /* JADX INFO: compiled from: source.java */
    public interface g {
        void a(OooO0OO oooO0OO);
    }

    /* JADX INFO: compiled from: source.java */
    public interface h {
        void a(OooO0OO oooO0OO);
    }

    /* JADX INFO: compiled from: source.java */
    public interface i {
    }

    /* JADX INFO: compiled from: source.java */
    public interface j {
        void b(OooO0OO oooO0OO);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class k extends SoftReference<DialogInterface.OnShowListener> implements j {
        public k(DialogInterface.OnShowListener onShowListener) {
            super(onShowListener);
        }

        @Override // OooO0o0.OooO0OO.j
        public void b(OooO0OO oooO0OO) {
            DialogInterface.OnShowListener onShowListener = get();
            if (onShowListener != null) {
                onShowListener.onShow(oooO0OO);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class l implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f48a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f49b;

        public l(Runnable runnable, long j11) {
            this.f48a = runnable;
            this.f49b = j11;
        }

        @Override // OooO0o0.OooO0OO.j
        public void b(OooO0OO oooO0OO) {
            List<j> list;
            if (this.f48a == null) {
                return;
            }
            if (oooO0OO != null && (list = oooO0OO.f24h) != null) {
                list.remove(this);
            }
            if (oooO0OO != null) {
                id.e.b.e(oooO0OO, this.f48a, this.f49b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooO0OO(Context context, int i11) {
        super(context, i11);
        Intrinsics.g(context, "context");
        this.f23g = new e<>(this);
    }

    public static final void n(OooO0OO oooO0OO, List list) {
        super.setOnCancelListener(oooO0OO.f23g);
        oooO0OO.f25i = list;
    }

    public static final void o(OooO0OO oooO0OO, List list) {
        super.setOnDismissListener(oooO0OO.f23g);
        oooO0OO.f26j = list;
    }

    public static final void p(OooO0OO oooO0OO, List list) {
        super.setOnShowListener(oooO0OO.f23g);
        oooO0OO.f24h = list;
    }

    @Override // androidx.appcompat.app.w, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        id.e.b.f(this);
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) id.h.a.e(this, InputMethodManager.class)).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        super.dismiss();
    }

    public void j(int i11) {
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(i11);
        }
    }

    public void k(h hVar) {
        if (this.f26j == null) {
            this.f26j = new ArrayList();
            super.setOnDismissListener(this.f23g);
        }
        List<h> list = this.f26j;
        if (list != null) {
            list.add(hVar);
        }
    }

    public void l(i iVar) {
        super.setOnKeyListener(new d(null));
    }

    public void m(j jVar) {
        if (this.f24h == null) {
            this.f24h = new ArrayList();
            super.setOnShowListener(this.f23g);
        }
        List<j> list = this.f24h;
        if (list != null) {
            list.add(jVar);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        List<f> list = this.f25i;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                f fVar = list.get(i11);
                if (fVar != null) {
                    fVar.a(this);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        id.d.a.a(this, view);
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        List<h> list = this.f26j;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                h hVar = list.get(i11);
                if (hVar != null) {
                    hVar.a(this);
                }
            }
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        List<j> list = this.f24h;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                j jVar = list.get(i11);
                if (jVar != null) {
                    jVar.b(this);
                }
            }
        }
    }

    @Override // androidx.activity.k, android.app.Dialog
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void onStop() {
        super.onStop();
    }

    @Override // id.e
    public boolean postAtTime(Runnable runnable, long j11) {
        return id.e.b.c(this, runnable, j11);
    }

    @Override // id.e
    public boolean postDelayed(Runnable runnable, long j11) {
        return id.e.b.e(this, runnable, j11);
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        if (onCancelListener == null) {
            return;
        }
        a aVar = new a(onCancelListener);
        if (this.f25i == null) {
            this.f25i = new ArrayList();
            super.setOnCancelListener(this.f23g);
        }
        List<f> list = this.f25i;
        if (list != null) {
            list.add(aVar);
        }
    }

    @Override // id.d
    public void setOnClickListener(View.OnClickListener onClickListener, int... iArr) {
        id.d.a.b(this, onClickListener, iArr);
    }

    @Override // id.d
    public void setOnClickListener(View.OnClickListener onClickListener, View... viewArr) {
        id.d.a.c(this, onClickListener, viewArr);
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener == null) {
            return;
        }
        k(new c(onDismissListener));
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        super.setOnKeyListener(onKeyListener);
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        if (onShowListener == null) {
            return;
        }
        m(new k(onShowListener));
    }
}
