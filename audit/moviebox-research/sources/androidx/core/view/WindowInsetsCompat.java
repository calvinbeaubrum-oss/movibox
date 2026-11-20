package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsCompat {

    @NonNull
    public static final WindowInsetsCompat CONSUMED;
    private static final String TAG = "WindowInsetsCompat";
    private final k mImpl;

    /* JADX INFO: compiled from: source.java */
    public static final class Builder {
        private final e mImpl;

        public Builder() {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30) {
                this.mImpl = new d();
            } else if (i11 >= 29) {
                this.mImpl = new c();
            } else {
                this.mImpl = new b();
            }
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30) {
                this.mImpl = new d(windowInsetsCompat);
            } else if (i11 >= 29) {
                this.mImpl = new c(windowInsetsCompat);
            } else {
                this.mImpl = new b(windowInsetsCompat);
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.mImpl.b();
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.mImpl.c(displayCutoutCompat);
            return this;
        }

        @NonNull
        public Builder setInsets(int i11, @NonNull c3.c cVar) {
            this.mImpl.d(i11, cVar);
            return this;
        }

        @NonNull
        public Builder setInsetsIgnoringVisibility(int i11, @NonNull c3.c cVar) {
            this.mImpl.e(i11, cVar);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setMandatorySystemGestureInsets(@NonNull c3.c cVar) {
            this.mImpl.f(cVar);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setStableInsets(@NonNull c3.c cVar) {
            this.mImpl.g(cVar);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemGestureInsets(@NonNull c3.c cVar) {
            this.mImpl.h(cVar);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemWindowInsets(@NonNull c3.c cVar) {
            this.mImpl.i(cVar);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTappableElementInsets(@NonNull c3.c cVar) {
            this.mImpl.j(cVar);
            return this;
        }

        @NonNull
        public Builder setVisible(int i11, boolean z11) {
            this.mImpl.k(i11, z11);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class Type {
        static final int CAPTION_BAR = 4;
        static final int DISPLAY_CUTOUT = 128;
        static final int FIRST = 1;
        static final int IME = 8;
        static final int LAST = 256;
        static final int MANDATORY_SYSTEM_GESTURES = 32;
        static final int NAVIGATION_BARS = 2;
        static final int SIZE = 9;
        static final int STATUS_BARS = 1;
        static final int SYSTEM_GESTURES = 16;
        static final int TAPPABLE_ELEMENT = 64;
        static final int WINDOW_DECOR = 256;

        /* JADX INFO: compiled from: source.java */
        @Retention(RetentionPolicy.SOURCE)
        public @interface InsetsType {
        }

        private Type() {
        }

        @SuppressLint({"WrongConstant"})
        public static int all() {
            return -1;
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        public static int indexOf(int i11) {
            if (i11 == 1) {
                return 0;
            }
            if (i11 == 2) {
                return 1;
            }
            if (i11 == 4) {
                return 2;
            }
            if (i11 == 8) {
                return 3;
            }
            if (i11 == 16) {
                return 4;
            }
            if (i11 == 32) {
                return 5;
            }
            if (i11 == 64) {
                return 6;
            }
            if (i11 == 128) {
                return 7;
            }
            if (i11 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i11);
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 7;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int tappableElement() {
            return 64;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(21)
    @SuppressLint({"SoonBlockedPrivateApi"})
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Field f7959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Field f7960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Field f7961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static boolean f7962d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f7959a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f7960b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f7961c = declaredField3;
                declaredField3.setAccessible(true);
                f7962d = true;
            } catch (ReflectiveOperationException e11) {
                Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets from AttachInfo " + e11.getMessage(), e11);
            }
        }

        @Nullable
        public static WindowInsetsCompat a(@NonNull View view) {
            if (f7962d && view.isAttachedToWindow()) {
                try {
                    Object obj = f7959a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f7960b.get(obj);
                        Rect rect2 = (Rect) f7961c.get(obj);
                        if (rect != null && rect2 != null) {
                            WindowInsetsCompat windowInsetsCompatBuild = new Builder().setStableInsets(c3.c.c(rect)).setSystemWindowInsets(c3.c.c(rect2)).build();
                            windowInsetsCompatBuild.setRootWindowInsets(windowInsetsCompatBuild);
                            windowInsetsCompatBuild.copyRootViewBounds(view.getRootView());
                            return windowInsetsCompatBuild;
                        }
                    }
                } catch (IllegalAccessException e11) {
                    Log.w(WindowInsetsCompat.TAG, "Failed to get insets from AttachInfo. " + e11.getMessage(), e11);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(api = 20)
    public static class b extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Field f7963e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static boolean f7964f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static Constructor<WindowInsets> f7965g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f7966h = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WindowInsets f7967c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c3.c f7968d;

        public b() {
            this.f7967c = l();
        }

        public b(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.f7967c = windowInsetsCompat.toWindowInsets();
        }

        @Nullable
        private static WindowInsets l() {
            if (!f7964f) {
                try {
                    f7963e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f7964f = true;
            }
            Field field = f7963e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!f7966h) {
                try {
                    f7965g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException unused3) {
                }
                f7966h = true;
            }
            Constructor<WindowInsets> constructor = f7965g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException unused4) {
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        @NonNull
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.f7967c);
            windowInsetsCompat.setOverriddenInsets(this.f7971b);
            windowInsetsCompat.setStableInsets(this.f7968d);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void g(@Nullable c3.c cVar) {
            this.f7968d = cVar;
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void i(@NonNull c3.c cVar) {
            WindowInsets windowInsets = this.f7967c;
            if (windowInsets != null) {
                this.f7967c = windowInsets.replaceSystemWindowInsets(cVar.f14554a, cVar.f14555b, cVar.f14556c, cVar.f14557d);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(api = VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class c extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f7969c;

        public c() {
            this.f7969c = i3.c.a();
        }

        public c(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            this.f7969c = windowInsets != null ? r1.a(windowInsets) : i3.c.a();
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        @NonNull
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.f7969c.build());
            windowInsetsCompat.setOverriddenInsets(this.f7971b);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void c(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.f7969c.setDisplayCutout(displayCutoutCompat != null ? displayCutoutCompat.unwrap() : null);
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void f(@NonNull c3.c cVar) {
            this.f7969c.setMandatorySystemGestureInsets(cVar.f());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void g(@NonNull c3.c cVar) {
            this.f7969c.setStableInsets(cVar.f());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void h(@NonNull c3.c cVar) {
            this.f7969c.setSystemGestureInsets(cVar.f());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void i(@NonNull c3.c cVar) {
            this.f7969c.setSystemWindowInsets(cVar.f());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void j(@NonNull c3.c cVar) {
            this.f7969c.setTappableElementInsets(cVar.f());
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(30)
    public static class d extends c {
        public d() {
        }

        public d(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void d(int i11, @NonNull c3.c cVar) {
            this.f7969c.setInsets(l.a(i11), cVar.f());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void e(int i11, @NonNull c3.c cVar) {
            this.f7969c.setInsetsIgnoringVisibility(l.a(i11), cVar.f());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void k(int i11, boolean z11) {
            this.f7969c.setVisible(l.a(i11), z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowInsetsCompat f7970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c3.c[] f7971b;

        public e() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        public e(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f7970a = windowInsetsCompat;
        }

        public final void a() {
            c3.c[] cVarArr = this.f7971b;
            if (cVarArr != null) {
                c3.c insets = cVarArr[Type.indexOf(1)];
                c3.c insets2 = this.f7971b[Type.indexOf(2)];
                if (insets2 == null) {
                    insets2 = this.f7970a.getInsets(2);
                }
                if (insets == null) {
                    insets = this.f7970a.getInsets(1);
                }
                i(c3.c.a(insets, insets2));
                c3.c cVar = this.f7971b[Type.indexOf(16)];
                if (cVar != null) {
                    h(cVar);
                }
                c3.c cVar2 = this.f7971b[Type.indexOf(32)];
                if (cVar2 != null) {
                    f(cVar2);
                }
                c3.c cVar3 = this.f7971b[Type.indexOf(64)];
                if (cVar3 != null) {
                    j(cVar3);
                }
            }
        }

        @NonNull
        public WindowInsetsCompat b() {
            throw null;
        }

        public void c(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        }

        public void d(int i11, @NonNull c3.c cVar) {
            if (this.f7971b == null) {
                this.f7971b = new c3.c[9];
            }
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    this.f7971b[Type.indexOf(i12)] = cVar;
                }
            }
        }

        public void e(int i11, @NonNull c3.c cVar) {
            if (i11 == 8) {
                throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
            }
        }

        public void f(@NonNull c3.c cVar) {
        }

        public void g(@NonNull c3.c cVar) {
            throw null;
        }

        public void h(@NonNull c3.c cVar) {
        }

        public void i(@NonNull c3.c cVar) {
            throw null;
        }

        public void j(@NonNull c3.c cVar) {
        }

        public void k(int i11, boolean z11) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(20)
    public static class f extends k {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f7972h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static Method f7973i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static Class<?> f7974j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static Field f7975k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static Field f7976l;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public final WindowInsets f7977c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c3.c[] f7978d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c3.c f7979e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public WindowInsetsCompat f7980f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public c3.c f7981g;

        public f(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.f7979e = null;
            this.f7977c = windowInsets;
        }

        public f(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull f fVar) {
            this(windowInsetsCompat, new WindowInsets(fVar.f7977c));
        }

        @SuppressLint({"PrivateApi"})
        private static void A() {
            try {
                f7973i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f7974j = cls;
                f7975k = cls.getDeclaredField("mVisibleInsets");
                f7976l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f7975k.setAccessible(true);
                f7976l.setAccessible(true);
            } catch (ReflectiveOperationException e11) {
                Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e11.getMessage(), e11);
            }
            f7972h = true;
        }

        @NonNull
        @SuppressLint({"WrongConstant"})
        private c3.c v(int i11, boolean z11) {
            c3.c cVarA = c3.c.f14553e;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    cVarA = c3.c.a(cVarA, w(i12, z11));
                }
            }
            return cVarA;
        }

        private c3.c x() {
            WindowInsetsCompat windowInsetsCompat = this.f7980f;
            return windowInsetsCompat != null ? windowInsetsCompat.getStableInsets() : c3.c.f14553e;
        }

        @Nullable
        private c3.c y(@NonNull View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f7972h) {
                A();
            }
            Method method = f7973i;
            if (method != null && f7974j != null && f7975k != null) {
                try {
                    Object objInvoke = method.invoke(view, new Object[0]);
                    if (objInvoke == null) {
                        Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f7975k.get(f7976l.get(objInvoke));
                    if (rect != null) {
                        return c3.c.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e11) {
                    Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e11.getMessage(), e11);
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public void d(@NonNull View view) {
            c3.c cVarY = y(view);
            if (cVarY == null) {
                cVarY = c3.c.f14553e;
            }
            s(cVarY);
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public void e(@NonNull WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.setRootWindowInsets(this.f7980f);
            windowInsetsCompat.setRootViewData(this.f7981g);
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f7981g, ((f) obj).f7981g);
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public c3.c g(int i11) {
            return v(i11, false);
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public c3.c h(int i11) {
            return v(i11, true);
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public final c3.c l() {
            if (this.f7979e == null) {
                this.f7979e = c3.c.b(this.f7977c.getSystemWindowInsetLeft(), this.f7977c.getSystemWindowInsetTop(), this.f7977c.getSystemWindowInsetRight(), this.f7977c.getSystemWindowInsetBottom());
            }
            return this.f7979e;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public WindowInsetsCompat n(int i11, int i12, int i13, int i14) {
            Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.f7977c));
            builder.setSystemWindowInsets(WindowInsetsCompat.insetInsets(l(), i11, i12, i13, i14));
            builder.setStableInsets(WindowInsetsCompat.insetInsets(j(), i11, i12, i13, i14));
            return builder.build();
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public boolean p() {
            return this.f7977c.isRound();
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @SuppressLint({"WrongConstant"})
        public boolean q(int i11) {
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) != 0 && !z(i12)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public void r(c3.c[] cVarArr) {
            this.f7978d = cVarArr;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public void s(@NonNull c3.c cVar) {
            this.f7981g = cVar;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public void t(@Nullable WindowInsetsCompat windowInsetsCompat) {
            this.f7980f = windowInsetsCompat;
        }

        @NonNull
        public c3.c w(int i11, boolean z11) {
            c3.c stableInsets;
            int i12;
            if (i11 == 1) {
                return z11 ? c3.c.b(0, Math.max(x().f14555b, l().f14555b), 0, 0) : c3.c.b(0, l().f14555b, 0, 0);
            }
            if (i11 == 2) {
                if (z11) {
                    c3.c cVarX = x();
                    c3.c cVarJ = j();
                    return c3.c.b(Math.max(cVarX.f14554a, cVarJ.f14554a), 0, Math.max(cVarX.f14556c, cVarJ.f14556c), Math.max(cVarX.f14557d, cVarJ.f14557d));
                }
                c3.c cVarL = l();
                WindowInsetsCompat windowInsetsCompat = this.f7980f;
                stableInsets = windowInsetsCompat != null ? windowInsetsCompat.getStableInsets() : null;
                int iMin = cVarL.f14557d;
                if (stableInsets != null) {
                    iMin = Math.min(iMin, stableInsets.f14557d);
                }
                return c3.c.b(cVarL.f14554a, 0, cVarL.f14556c, iMin);
            }
            if (i11 != 8) {
                if (i11 == 16) {
                    return k();
                }
                if (i11 == 32) {
                    return i();
                }
                if (i11 == 64) {
                    return m();
                }
                if (i11 != 128) {
                    return c3.c.f14553e;
                }
                WindowInsetsCompat windowInsetsCompat2 = this.f7980f;
                DisplayCutoutCompat displayCutout = windowInsetsCompat2 != null ? windowInsetsCompat2.getDisplayCutout() : f();
                return displayCutout != null ? c3.c.b(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom()) : c3.c.f14553e;
            }
            c3.c[] cVarArr = this.f7978d;
            stableInsets = cVarArr != null ? cVarArr[Type.indexOf(8)] : null;
            if (stableInsets != null) {
                return stableInsets;
            }
            c3.c cVarL2 = l();
            c3.c cVarX2 = x();
            int i13 = cVarL2.f14557d;
            if (i13 > cVarX2.f14557d) {
                return c3.c.b(0, 0, 0, i13);
            }
            c3.c cVar = this.f7981g;
            return (cVar == null || cVar.equals(c3.c.f14553e) || (i12 = this.f7981g.f14557d) <= cVarX2.f14557d) ? c3.c.f14553e : c3.c.b(0, 0, 0, i12);
        }

        public boolean z(int i11) {
            if (i11 != 1 && i11 != 2) {
                if (i11 == 4) {
                    return false;
                }
                if (i11 != 8 && i11 != 128) {
                    return true;
                }
            }
            return !w(i11, false).equals(c3.c.f14553e);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(21)
    public static class g extends f {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public c3.c f7982m;

        public g(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.f7982m = null;
        }

        public g(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull g gVar) {
            super(windowInsetsCompat, gVar);
            this.f7982m = null;
            this.f7982m = gVar.f7982m;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public WindowInsetsCompat b() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f7977c.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public WindowInsetsCompat c() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f7977c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public final c3.c j() {
            if (this.f7982m == null) {
                this.f7982m = c3.c.b(this.f7977c.getStableInsetLeft(), this.f7977c.getStableInsetTop(), this.f7977c.getStableInsetRight(), this.f7977c.getStableInsetBottom());
            }
            return this.f7982m;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public boolean o() {
            return this.f7977c.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public void u(@Nullable c3.c cVar) {
            this.f7982m = cVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(28)
    public static class h extends g {
        public h(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public h(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull h hVar) {
            super(windowInsetsCompat, hVar);
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public WindowInsetsCompat a() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f7977c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.k
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Objects.equals(this.f7977c, hVar.f7977c) && Objects.equals(this.f7981g, hVar.f7981g);
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @Nullable
        public DisplayCutoutCompat f() {
            return DisplayCutoutCompat.wrap(this.f7977c.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public int hashCode() {
            return this.f7977c.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class i extends h {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public c3.c f7983n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public c3.c f7984o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public c3.c f7985p;

        public i(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.f7983n = null;
            this.f7984o = null;
            this.f7985p = null;
        }

        public i(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull i iVar) {
            super(windowInsetsCompat, iVar);
            this.f7983n = null;
            this.f7984o = null;
            this.f7985p = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public c3.c i() {
            if (this.f7984o == null) {
                this.f7984o = c3.c.e(this.f7977c.getMandatorySystemGestureInsets());
            }
            return this.f7984o;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public c3.c k() {
            if (this.f7983n == null) {
                this.f7983n = c3.c.e(this.f7977c.getSystemGestureInsets());
            }
            return this.f7983n;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public c3.c m() {
            if (this.f7985p == null) {
                this.f7985p = c3.c.e(this.f7977c.getTappableElementInsets());
            }
            return this.f7985p;
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public WindowInsetsCompat n(int i11, int i12, int i13, int i14) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f7977c.inset(i11, i12, i13, i14));
        }

        @Override // androidx.core.view.WindowInsetsCompat.g, androidx.core.view.WindowInsetsCompat.k
        public void u(@Nullable c3.c cVar) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(30)
    public static class j extends i {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @NonNull
        public static final WindowInsetsCompat f7986q = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);

        public j(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public j(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull j jVar) {
            super(windowInsetsCompat, jVar);
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.k
        public final void d(@NonNull View view) {
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public c3.c g(int i11) {
            return c3.c.e(this.f7977c.getInsets(l.a(i11)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public c3.c h(int i11) {
            return c3.c.e(this.f7977c.getInsetsIgnoringVisibility(l.a(i11)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.k
        public boolean q(int i11) {
            return this.f7977c.isVisible(l.a(i11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public static final WindowInsetsCompat f7987b = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowInsetsCompat f7988a;

        public k(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f7988a = windowInsetsCompat;
        }

        @NonNull
        public WindowInsetsCompat a() {
            return this.f7988a;
        }

        @NonNull
        public WindowInsetsCompat b() {
            return this.f7988a;
        }

        @NonNull
        public WindowInsetsCompat c() {
            return this.f7988a;
        }

        public void d(@NonNull View view) {
        }

        public void e(@NonNull WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return p() == kVar.p() && o() == kVar.o() && androidx.core.util.d.a(l(), kVar.l()) && androidx.core.util.d.a(j(), kVar.j()) && androidx.core.util.d.a(f(), kVar.f());
        }

        @Nullable
        public DisplayCutoutCompat f() {
            return null;
        }

        @NonNull
        public c3.c g(int i11) {
            return c3.c.f14553e;
        }

        @NonNull
        public c3.c h(int i11) {
            if ((i11 & 8) == 0) {
                return c3.c.f14553e;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return androidx.core.util.d.b(Boolean.valueOf(p()), Boolean.valueOf(o()), l(), j(), f());
        }

        @NonNull
        public c3.c i() {
            return l();
        }

        @NonNull
        public c3.c j() {
            return c3.c.f14553e;
        }

        @NonNull
        public c3.c k() {
            return l();
        }

        @NonNull
        public c3.c l() {
            return c3.c.f14553e;
        }

        @NonNull
        public c3.c m() {
            return l();
        }

        @NonNull
        public WindowInsetsCompat n(int i11, int i12, int i13, int i14) {
            return f7987b;
        }

        public boolean o() {
            return false;
        }

        public boolean p() {
            return false;
        }

        public boolean q(int i11) {
            return true;
        }

        public void r(c3.c[] cVarArr) {
        }

        public void s(@NonNull c3.c cVar) {
        }

        public void t(@Nullable WindowInsetsCompat windowInsetsCompat) {
        }

        public void u(c3.c cVar) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(30)
    public static final class l {
        public static int a(int i11) {
            int iStatusBars;
            int i12 = 0;
            for (int i13 = 1; i13 <= 256; i13 <<= 1) {
                if ((i11 & i13) != 0) {
                    if (i13 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i13 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i13 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i13 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i13 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i13 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i13 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i13 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i12 |= iStatusBars;
                }
            }
            return i12;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            CONSUMED = j.f7986q;
        } else {
            CONSUMED = k.f7987b;
        }
    }

    @RequiresApi(20)
    private WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            this.mImpl = new j(this, windowInsets);
            return;
        }
        if (i11 >= 29) {
            this.mImpl = new i(this, windowInsets);
        } else if (i11 >= 28) {
            this.mImpl = new h(this, windowInsets);
        } else {
            this.mImpl = new g(this, windowInsets);
        }
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat == null) {
            this.mImpl = new k(this);
            return;
        }
        k kVar = windowInsetsCompat.mImpl;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30 && (kVar instanceof j)) {
            this.mImpl = new j(this, (j) kVar);
        } else if (i11 >= 29 && (kVar instanceof i)) {
            this.mImpl = new i(this, (i) kVar);
        } else if (i11 >= 28 && (kVar instanceof h)) {
            this.mImpl = new h(this, (h) kVar);
        } else if (kVar instanceof g) {
            this.mImpl = new g(this, (g) kVar);
        } else if (kVar instanceof f) {
            this.mImpl = new f(this, (f) kVar);
        } else {
            this.mImpl = new k(this);
        }
        kVar.e(this);
    }

    public static c3.c insetInsets(@NonNull c3.c cVar, int i11, int i12, int i13, int i14) {
        int iMax = Math.max(0, cVar.f14554a - i11);
        int iMax2 = Math.max(0, cVar.f14555b - i12);
        int iMax3 = Math.max(0, cVar.f14556c - i13);
        int iMax4 = Math.max(0, cVar.f14557d - i14);
        return (iMax == i11 && iMax2 == i12 && iMax3 == i13 && iMax4 == i14) ? cVar : c3.c.b(iMax, iMax2, iMax3, iMax4);
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, null);
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets, @Nullable View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) androidx.core.util.i.g(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            windowInsetsCompat.setRootWindowInsets(ViewCompat.getRootWindowInsets(view));
            windowInsetsCompat.copyRootViewBounds(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.a();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.b();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.c();
    }

    public void copyRootViewBounds(@NonNull View view) {
        this.mImpl.d(view);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WindowInsetsCompat) {
            return androidx.core.util.d.a(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
        }
        return false;
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.f();
    }

    @NonNull
    public c3.c getInsets(int i11) {
        return this.mImpl.g(i11);
    }

    @NonNull
    public c3.c getInsetsIgnoringVisibility(int i11) {
        return this.mImpl.h(i11);
    }

    @NonNull
    @Deprecated
    public c3.c getMandatorySystemGestureInsets() {
        return this.mImpl.i();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.j().f14557d;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.j().f14554a;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.mImpl.j().f14556c;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.mImpl.j().f14555b;
    }

    @NonNull
    @Deprecated
    public c3.c getStableInsets() {
        return this.mImpl.j();
    }

    @NonNull
    @Deprecated
    public c3.c getSystemGestureInsets() {
        return this.mImpl.k();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.l().f14557d;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.l().f14554a;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.l().f14556c;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.l().f14555b;
    }

    @NonNull
    @Deprecated
    public c3.c getSystemWindowInsets() {
        return this.mImpl.l();
    }

    @NonNull
    @Deprecated
    public c3.c getTappableElementInsets() {
        return this.mImpl.m();
    }

    public boolean hasInsets() {
        c3.c insets = getInsets(Type.all());
        c3.c cVar = c3.c.f14553e;
        return (insets.equals(cVar) && getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(cVar) && getDisplayCutout() == null) ? false : true;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.mImpl.j().equals(c3.c.f14553e);
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.mImpl.l().equals(c3.c.f14553e);
    }

    public int hashCode() {
        k kVar = this.mImpl;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }

    @NonNull
    public WindowInsetsCompat inset(int i11, int i12, int i13, int i14) {
        return this.mImpl.n(i11, i12, i13, i14);
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull c3.c cVar) {
        return inset(cVar.f14554a, cVar.f14555b, cVar.f14556c, cVar.f14557d);
    }

    public boolean isConsumed() {
        return this.mImpl.o();
    }

    public boolean isRound() {
        return this.mImpl.p();
    }

    public boolean isVisible(int i11) {
        return this.mImpl.q(i11);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i11, int i12, int i13, int i14) {
        return new Builder(this).setSystemWindowInsets(c3.c.b(i11, i12, i13, i14)).build();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect rect) {
        return new Builder(this).setSystemWindowInsets(c3.c.c(rect)).build();
    }

    public void setOverriddenInsets(c3.c[] cVarArr) {
        this.mImpl.r(cVarArr);
    }

    public void setRootViewData(@NonNull c3.c cVar) {
        this.mImpl.s(cVar);
    }

    public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
        this.mImpl.t(windowInsetsCompat);
    }

    public void setStableInsets(@Nullable c3.c cVar) {
        this.mImpl.u(cVar);
    }

    @Nullable
    @RequiresApi(20)
    public WindowInsets toWindowInsets() {
        k kVar = this.mImpl;
        if (kVar instanceof f) {
            return ((f) kVar).f7977c;
        }
        return null;
    }
}
