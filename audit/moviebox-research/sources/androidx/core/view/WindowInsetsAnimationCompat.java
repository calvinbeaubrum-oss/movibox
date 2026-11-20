package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.R$id;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class WindowInsetsAnimationCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "WindowInsetsAnimCompat";
    private b mImpl;

    /* JADX INFO: compiled from: source.java */
    public static final class BoundsCompat {
        private final c3.c mLowerBound;
        private final c3.c mUpperBound;

        @RequiresApi(30)
        private BoundsCompat(@NonNull WindowInsetsAnimation.Bounds bounds) {
            this.mLowerBound = a.k(bounds);
            this.mUpperBound = a.j(bounds);
        }

        public BoundsCompat(@NonNull c3.c cVar, @NonNull c3.c cVar2) {
            this.mLowerBound = cVar;
            this.mUpperBound = cVar2;
        }

        @NonNull
        @RequiresApi(30)
        public static BoundsCompat toBoundsCompat(@NonNull WindowInsetsAnimation.Bounds bounds) {
            return new BoundsCompat(bounds);
        }

        @NonNull
        public c3.c getLowerBound() {
            return this.mLowerBound;
        }

        @NonNull
        public c3.c getUpperBound() {
            return this.mUpperBound;
        }

        @NonNull
        public BoundsCompat inset(@NonNull c3.c cVar) {
            return new BoundsCompat(WindowInsetsCompat.insetInsets(this.mLowerBound, cVar.f14554a, cVar.f14555b, cVar.f14556c, cVar.f14557d), WindowInsetsCompat.insetInsets(this.mUpperBound, cVar.f14554a, cVar.f14555b, cVar.f14556c, cVar.f14557d));
        }

        @NonNull
        @RequiresApi(30)
        public WindowInsetsAnimation.Bounds toBounds() {
            return a.i(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.mLowerBound + " upper=" + this.mUpperBound + "}";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class Callback {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        WindowInsets mDispachedInsets;
        private final int mDispatchMode;

        /* JADX INFO: compiled from: source.java */
        @Retention(RetentionPolicy.SOURCE)
        public @interface DispatchMode {
        }

        public Callback(int i11) {
            this.mDispatchMode = i11;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public void onEnd(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public void onPrepare(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        @NonNull
        public abstract WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list);

        @NonNull
        public BoundsCompat onStart(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat, @NonNull BoundsCompat boundsCompat) {
            return boundsCompat;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class Impl21 extends b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Interpolator f7934f = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Interpolator f7935g = new q3.a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Interpolator f7936h = new DecelerateInterpolator();

        /* JADX INFO: compiled from: source.java */
        @RequiresApi(21)
        public static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Callback f7937a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public WindowInsetsCompat f7938b;

            /* JADX INFO: compiled from: source.java */
            public class a implements ValueAnimator.AnimatorUpdateListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ WindowInsetsAnimationCompat f7939a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ WindowInsetsCompat f7940b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ WindowInsetsCompat f7941c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ int f7942d;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                public final /* synthetic */ View f7943f;

                public a(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int i11, View view) {
                    this.f7939a = windowInsetsAnimationCompat;
                    this.f7940b = windowInsetsCompat;
                    this.f7941c = windowInsetsCompat2;
                    this.f7942d = i11;
                    this.f7943f = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f7939a.setFraction(valueAnimator.getAnimatedFraction());
                    Impl21.o(this.f7943f, Impl21.s(this.f7940b, this.f7941c, this.f7939a.getInterpolatedFraction(), this.f7942d), Collections.singletonList(this.f7939a));
                }
            }

            /* JADX INFO: compiled from: source.java */
            public class b extends AnimatorListenerAdapter {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ WindowInsetsAnimationCompat f7945a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ View f7946b;

                public b(WindowInsetsAnimationCompat windowInsetsAnimationCompat, View view) {
                    this.f7945a = windowInsetsAnimationCompat;
                    this.f7946b = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.f7945a.setFraction(1.0f);
                    Impl21.m(this.f7946b, this.f7945a);
                }
            }

            public Impl21OnApplyWindowInsetsListener(@NonNull View view, @NonNull Callback callback) {
                this.f7937a = callback;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
                this.f7938b = rootWindowInsets != null ? new WindowInsetsCompat.Builder(rootWindowInsets).build() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(final View view, WindowInsets windowInsets) {
                int i11;
                if (!view.isLaidOut()) {
                    this.f7938b = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                    return Impl21.q(view, windowInsets);
                }
                WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                if (this.f7938b == null) {
                    this.f7938b = ViewCompat.getRootWindowInsets(view);
                }
                if (this.f7938b == null) {
                    this.f7938b = windowInsetsCompat;
                    return Impl21.q(view, windowInsets);
                }
                Callback callbackR = Impl21.r(view);
                if ((callbackR == null || !Objects.equals(callbackR.mDispachedInsets, windowInsets)) && (i11 = Impl21.i(windowInsetsCompat, this.f7938b)) != 0) {
                    WindowInsetsCompat windowInsetsCompat2 = this.f7938b;
                    final WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(i11, Impl21.k(i11, windowInsetsCompat, windowInsetsCompat2), 160L);
                    windowInsetsAnimationCompat.setFraction(0.0f);
                    final ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(windowInsetsAnimationCompat.getDurationMillis());
                    final BoundsCompat boundsCompatJ = Impl21.j(windowInsetsCompat, windowInsetsCompat2, i11);
                    Impl21.n(view, windowInsetsAnimationCompat, windowInsets, false);
                    duration.addUpdateListener(new a(windowInsetsAnimationCompat, windowInsetsCompat, windowInsetsCompat2, i11, view));
                    duration.addListener(new b(windowInsetsAnimationCompat, view));
                    OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.3
                        @Override // java.lang.Runnable
                        public void run() {
                            Impl21.p(view, windowInsetsAnimationCompat, boundsCompatJ);
                            duration.start();
                        }
                    });
                    this.f7938b = windowInsetsCompat;
                    return Impl21.q(view, windowInsets);
                }
                return Impl21.q(view, windowInsets);
            }
        }

        public Impl21(int i11, @Nullable Interpolator interpolator, long j11) {
            super(i11, interpolator, j11);
        }

        @SuppressLint({"WrongConstant"})
        public static int i(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat windowInsetsCompat2) {
            int i11 = 0;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if (!windowInsetsCompat.getInsets(i12).equals(windowInsetsCompat2.getInsets(i12))) {
                    i11 |= i12;
                }
            }
            return i11;
        }

        @NonNull
        public static BoundsCompat j(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat windowInsetsCompat2, int i11) {
            c3.c insets = windowInsetsCompat.getInsets(i11);
            c3.c insets2 = windowInsetsCompat2.getInsets(i11);
            return new BoundsCompat(c3.c.b(Math.min(insets.f14554a, insets2.f14554a), Math.min(insets.f14555b, insets2.f14555b), Math.min(insets.f14556c, insets2.f14556c), Math.min(insets.f14557d, insets2.f14557d)), c3.c.b(Math.max(insets.f14554a, insets2.f14554a), Math.max(insets.f14555b, insets2.f14555b), Math.max(insets.f14556c, insets2.f14556c), Math.max(insets.f14557d, insets2.f14557d)));
        }

        public static Interpolator k(int i11, WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2) {
            if ((i11 & 8) != 0) {
                return windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime()).f14557d > windowInsetsCompat2.getInsets(WindowInsetsCompat.Type.ime()).f14557d ? f7934f : f7935g;
            }
            return f7936h;
        }

        @NonNull
        public static View.OnApplyWindowInsetsListener l(@NonNull View view, @NonNull Callback callback) {
            return new Impl21OnApplyWindowInsetsListener(view, callback);
        }

        public static void m(@NonNull View view, @NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Callback callbackR = r(view);
            if (callbackR != null) {
                callbackR.onEnd(windowInsetsAnimationCompat);
                if (callbackR.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    m(viewGroup.getChildAt(i11), windowInsetsAnimationCompat);
                }
            }
        }

        public static void n(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean z11) {
            Callback callbackR = r(view);
            if (callbackR != null) {
                callbackR.mDispachedInsets = windowInsets;
                if (!z11) {
                    callbackR.onPrepare(windowInsetsAnimationCompat);
                    z11 = callbackR.getDispatchMode() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    n(viewGroup.getChildAt(i11), windowInsetsAnimationCompat, windowInsets, z11);
                }
            }
        }

        public static void o(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list) {
            Callback callbackR = r(view);
            if (callbackR != null) {
                windowInsetsCompat = callbackR.onProgress(windowInsetsCompat, list);
                if (callbackR.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    o(viewGroup.getChildAt(i11), windowInsetsCompat, list);
                }
            }
        }

        public static void p(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            Callback callbackR = r(view);
            if (callbackR != null) {
                callbackR.onStart(windowInsetsAnimationCompat, boundsCompat);
                if (callbackR.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    p(viewGroup.getChildAt(i11), windowInsetsAnimationCompat, boundsCompat);
                }
            }
        }

        @NonNull
        public static WindowInsets q(@NonNull View view, @NonNull WindowInsets windowInsets) {
            return view.getTag(R$id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        @Nullable
        public static Callback r(View view) {
            Object tag = view.getTag(R$id.tag_window_insets_animation_callback);
            if (tag instanceof Impl21OnApplyWindowInsetsListener) {
                return ((Impl21OnApplyWindowInsetsListener) tag).f7937a;
            }
            return null;
        }

        @SuppressLint({"WrongConstant"})
        public static WindowInsetsCompat s(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, float f11, int i11) {
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(windowInsetsCompat);
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) == 0) {
                    builder.setInsets(i12, windowInsetsCompat.getInsets(i12));
                } else {
                    c3.c insets = windowInsetsCompat.getInsets(i12);
                    c3.c insets2 = windowInsetsCompat2.getInsets(i12);
                    float f12 = 1.0f - f11;
                    builder.setInsets(i12, WindowInsetsCompat.insetInsets(insets, (int) (((double) ((insets.f14554a - insets2.f14554a) * f12)) + 0.5d), (int) (((double) ((insets.f14555b - insets2.f14555b) * f12)) + 0.5d), (int) (((double) ((insets.f14556c - insets2.f14556c) * f12)) + 0.5d), (int) (((double) ((insets.f14557d - insets2.f14557d) * f12)) + 0.5d)));
                }
            }
            return builder.build();
        }

        public static void t(@NonNull View view, @Nullable Callback callback) {
            Object tag = view.getTag(R$id.tag_on_apply_window_listener);
            if (callback == null) {
                view.setTag(R$id.tag_window_insets_animation_callback, null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListenerL = l(view, callback);
            view.setTag(R$id.tag_window_insets_animation_callback, onApplyWindowInsetsListenerL);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListenerL);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(30)
    public static class a extends b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NonNull
        public final WindowInsetsAnimation f7948f;

        /* JADX INFO: renamed from: androidx.core.view.WindowInsetsAnimationCompat$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @RequiresApi(30)
        public static class C0075a extends WindowInsetsAnimation.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Callback f7949a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public List<WindowInsetsAnimationCompat> f7950b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public ArrayList<WindowInsetsAnimationCompat> f7951c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> f7952d;

            public C0075a(@NonNull Callback callback) {
                super(callback.getDispatchMode());
                this.f7952d = new HashMap<>();
                this.f7949a = callback;
            }

            @NonNull
            public final WindowInsetsAnimationCompat a(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.f7952d.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat != null) {
                    return windowInsetsAnimationCompat;
                }
                WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = WindowInsetsAnimationCompat.toWindowInsetsAnimationCompat(windowInsetsAnimation);
                this.f7952d.put(windowInsetsAnimation, windowInsetsAnimationCompat2);
                return windowInsetsAnimationCompat2;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                this.f7949a.onEnd(a(windowInsetsAnimation));
                this.f7952d.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                this.f7949a.onPrepare(a(windowInsetsAnimation));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @NonNull
            public WindowInsets onProgress(@NonNull WindowInsets windowInsets, @NonNull List<WindowInsetsAnimation> list) {
                ArrayList<WindowInsetsAnimationCompat> arrayList = this.f7951c;
                if (arrayList == null) {
                    ArrayList<WindowInsetsAnimationCompat> arrayList2 = new ArrayList<>(list.size());
                    this.f7951c = arrayList2;
                    this.f7950b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimationA = a1.a(list.get(size));
                    WindowInsetsAnimationCompat windowInsetsAnimationCompatA = a(windowInsetsAnimationA);
                    windowInsetsAnimationCompatA.setFraction(windowInsetsAnimationA.getFraction());
                    this.f7951c.add(windowInsetsAnimationCompatA);
                }
                return this.f7949a.onProgress(WindowInsetsCompat.toWindowInsetsCompat(windowInsets), this.f7950b).toWindowInsets();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @NonNull
            public WindowInsetsAnimation.Bounds onStart(@NonNull WindowInsetsAnimation windowInsetsAnimation, @NonNull WindowInsetsAnimation.Bounds bounds) {
                return this.f7949a.onStart(a(windowInsetsAnimation), BoundsCompat.toBoundsCompat(bounds)).toBounds();
            }
        }

        public a(int i11, Interpolator interpolator, long j11) {
            this(z0.a(i11, interpolator, j11));
        }

        public a(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f7948f = windowInsetsAnimation;
        }

        @NonNull
        public static WindowInsetsAnimation.Bounds i(@NonNull BoundsCompat boundsCompat) {
            q0.a();
            return p0.a(boundsCompat.getLowerBound().f(), boundsCompat.getUpperBound().f());
        }

        @NonNull
        public static c3.c j(@NonNull WindowInsetsAnimation.Bounds bounds) {
            return c3.c.e(bounds.getUpperBound());
        }

        @NonNull
        public static c3.c k(@NonNull WindowInsetsAnimation.Bounds bounds) {
            return c3.c.e(bounds.getLowerBound());
        }

        public static void l(@NonNull View view, @Nullable Callback callback) {
            view.setWindowInsetsAnimationCallback(callback != null ? new C0075a(callback) : null);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public long b() {
            return this.f7948f.getDurationMillis();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public float c() {
            return this.f7948f.getFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public float d() {
            return this.f7948f.getInterpolatedFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        @Nullable
        public Interpolator e() {
            return this.f7948f.getInterpolator();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public int f() {
            return this.f7948f.getTypeMask();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public void h(float f11) {
            this.f7948f.setFraction(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f7954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final Interpolator f7955c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f7956d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f7957e;

        public b(int i11, @Nullable Interpolator interpolator, long j11) {
            this.f7953a = i11;
            this.f7955c = interpolator;
            this.f7956d = j11;
        }

        public float a() {
            return this.f7957e;
        }

        public long b() {
            return this.f7956d;
        }

        public float c() {
            return this.f7954b;
        }

        public float d() {
            Interpolator interpolator = this.f7955c;
            return interpolator != null ? interpolator.getInterpolation(this.f7954b) : this.f7954b;
        }

        @Nullable
        public Interpolator e() {
            return this.f7955c;
        }

        public int f() {
            return this.f7953a;
        }

        public void g(float f11) {
            this.f7957e = f11;
        }

        public void h(float f11) {
            this.f7954b = f11;
        }
    }

    public WindowInsetsAnimationCompat(int i11, @Nullable Interpolator interpolator, long j11) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new a(i11, interpolator, j11);
        } else {
            this.mImpl = new Impl21(i11, interpolator, j11);
        }
    }

    @RequiresApi(30)
    private WindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new a(windowInsetsAnimation);
        }
    }

    public static void setCallback(@NonNull View view, @Nullable Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            a.l(view, callback);
        } else {
            Impl21.t(view, callback);
        }
    }

    @RequiresApi(30)
    public static WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        return new WindowInsetsAnimationCompat(windowInsetsAnimation);
    }

    public float getAlpha() {
        return this.mImpl.a();
    }

    public long getDurationMillis() {
        return this.mImpl.b();
    }

    public float getFraction() {
        return this.mImpl.c();
    }

    public float getInterpolatedFraction() {
        return this.mImpl.d();
    }

    @Nullable
    public Interpolator getInterpolator() {
        return this.mImpl.e();
    }

    public int getTypeMask() {
        return this.mImpl.f();
    }

    public void setAlpha(float f11) {
        this.mImpl.g(f11);
    }

    public void setFraction(float f11) {
        this.mImpl.h(f11);
    }
}
