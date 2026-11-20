package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_DEFAULT = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final e mImpl;

    /* JADX INFO: compiled from: source.java */
    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(@NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(20)
    public static class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final Window f7989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final SoftwareKeyboardControllerCompat f7990b;

        public a(@NonNull Window window, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.f7989a = window;
            this.f7990b = softwareKeyboardControllerCompat;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void a(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void b(int i11, long j11, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public int c() {
            return 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void d(int i11) {
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    l(i12);
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void g(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void j(int i11) {
            if (i11 == 0) {
                p(6144);
                return;
            }
            if (i11 == 1) {
                p(4096);
                m(2048);
            } else {
                if (i11 != 2) {
                    return;
                }
                p(2048);
                m(4096);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void k(int i11) {
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    o(i12);
                }
            }
        }

        public final void l(int i11) {
            if (i11 == 1) {
                m(4);
            } else if (i11 == 2) {
                m(2);
            } else {
                if (i11 != 8) {
                    return;
                }
                this.f7990b.hide();
            }
        }

        public void m(int i11) {
            View decorView = this.f7989a.getDecorView();
            decorView.setSystemUiVisibility(i11 | decorView.getSystemUiVisibility());
        }

        public void n(int i11) {
            this.f7989a.addFlags(i11);
        }

        public final void o(int i11) {
            if (i11 == 1) {
                p(4);
                q(1024);
            } else if (i11 == 2) {
                p(2);
            } else {
                if (i11 != 8) {
                    return;
                }
                this.f7990b.show();
            }
        }

        public void p(int i11) {
            View decorView = this.f7989a.getDecorView();
            decorView.setSystemUiVisibility((~i11) & decorView.getSystemUiVisibility());
        }

        public void q(int i11) {
            this.f7989a.clearFlags(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class b extends a {
        public b(@NonNull Window window, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public boolean f() {
            return (this.f7989a.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void i(boolean z11) {
            if (!z11) {
                p(8192);
                return;
            }
            q(67108864);
            n(Integer.MIN_VALUE);
            m(8192);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static class c extends b {
        public c(@NonNull Window window, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public boolean e() {
            return (this.f7989a.getDecorView().getSystemUiVisibility() & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void h(boolean z11) {
            if (!z11) {
                p(16);
                return;
            }
            q(ASTNode.NOJIT);
            n(Integer.MIN_VALUE);
            m(16);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(30)
    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowInsetsControllerCompat f7991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowInsetsController f7992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SoftwareKeyboardControllerCompat f7993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final androidx.collection.v0<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> f7994d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Window f7995e;

        /* JADX INFO: compiled from: source.java */
        public class a implements WindowInsetsAnimationControlListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public WindowInsetsAnimationControllerCompat f7996a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ WindowInsetsAnimationControlListenerCompat f7997b;

            public a(WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
                this.f7997b = windowInsetsAnimationControlListenerCompat;
            }

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onCancelled(@Nullable WindowInsetsAnimationController windowInsetsAnimationController) {
                this.f7997b.onCancelled(windowInsetsAnimationController == null ? null : this.f7996a);
            }

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onFinished(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
                this.f7997b.onFinished(this.f7996a);
            }

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onReady(@NonNull WindowInsetsAnimationController windowInsetsAnimationController, int i11) {
                WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                this.f7996a = windowInsetsAnimationControllerCompat;
                this.f7997b.onReady(windowInsetsAnimationControllerCompat, i11);
            }
        }

        public d(@NonNull Window window, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this(window.getInsetsController(), windowInsetsControllerCompat, softwareKeyboardControllerCompat);
            this.f7995e = window;
        }

        public d(@NonNull WindowInsetsController windowInsetsController, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.f7994d = new androidx.collection.v0<>();
            this.f7992b = windowInsetsController;
            this.f7991a = windowInsetsControllerCompat;
            this.f7993c = softwareKeyboardControllerCompat;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void a(@NonNull final OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            if (this.f7994d.containsKey(onControllableInsetsChangedListener)) {
                return;
            }
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener2 = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.t2
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i11) {
                    this.f8023a.m(onControllableInsetsChangedListener, windowInsetsController, i11);
                }
            };
            this.f7994d.put(onControllableInsetsChangedListener, onControllableInsetsChangedListener2);
            this.f7992b.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void b(int i11, long j11, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
            this.f7992b.controlWindowInsetsAnimation(i11, j11, interpolator, cancellationSignal, new a(windowInsetsAnimationControlListenerCompat));
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        @SuppressLint({"WrongConstant"})
        public int c() {
            return this.f7992b.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void d(int i11) {
            if ((i11 & 8) != 0) {
                this.f7993c.hide();
            }
            this.f7992b.hide(i11 & (-9));
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public boolean e() {
            this.f7992b.setSystemBarsAppearance(0, 0);
            return (this.f7992b.getSystemBarsAppearance() & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public boolean f() {
            this.f7992b.setSystemBarsAppearance(0, 0);
            return (this.f7992b.getSystemBarsAppearance() & 8) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void g(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListenerA = n2.a(this.f7994d.remove(onControllableInsetsChangedListener));
            if (onControllableInsetsChangedListenerA != null) {
                this.f7992b.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListenerA);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void h(boolean z11) {
            if (z11) {
                if (this.f7995e != null) {
                    n(16);
                }
                this.f7992b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f7995e != null) {
                    o(16);
                }
                this.f7992b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void i(boolean z11) {
            if (z11) {
                if (this.f7995e != null) {
                    n(8192);
                }
                this.f7992b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f7995e != null) {
                    o(8192);
                }
                this.f7992b.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void j(int i11) {
            this.f7992b.setSystemBarsBehavior(i11);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.e
        public void k(int i11) {
            if ((i11 & 8) != 0) {
                this.f7993c.show();
            }
            this.f7992b.show(i11 & (-9));
        }

        public final /* synthetic */ void m(OnControllableInsetsChangedListener onControllableInsetsChangedListener, WindowInsetsController windowInsetsController, int i11) {
            if (this.f7992b == windowInsetsController) {
                onControllableInsetsChangedListener.onControllableInsetsChanged(this.f7991a, i11);
            }
        }

        public void n(int i11) {
            View decorView = this.f7995e.getDecorView();
            decorView.setSystemUiVisibility(i11 | decorView.getSystemUiVisibility());
        }

        public void o(int i11) {
            View decorView = this.f7995e.getDecorView();
            decorView.setSystemUiVisibility((~i11) & decorView.getSystemUiVisibility());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {
        public void a(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            throw null;
        }

        public void b(int i11, long j11, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
            throw null;
        }

        public int c() {
            throw null;
        }

        public void d(int i11) {
            throw null;
        }

        public boolean e() {
            return false;
        }

        public boolean f() {
            return false;
        }

        public void g(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            throw null;
        }

        public void h(boolean z11) {
        }

        public void i(boolean z11) {
        }

        public void j(int i11) {
            throw null;
        }

        public void k(int i11) {
            throw null;
        }
    }

    public WindowInsetsControllerCompat(@NonNull Window window, @NonNull View view) {
        SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            this.mImpl = new d(window, this, softwareKeyboardControllerCompat);
            return;
        }
        if (i11 >= 26) {
            this.mImpl = new c(window, softwareKeyboardControllerCompat);
        } else if (i11 >= 23) {
            this.mImpl = new b(window, softwareKeyboardControllerCompat);
        } else {
            this.mImpl = new a(window, softwareKeyboardControllerCompat);
        }
    }

    @RequiresApi(30)
    @Deprecated
    private WindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        this.mImpl = new d(windowInsetsController, this, new SoftwareKeyboardControllerCompat(windowInsetsController));
    }

    @NonNull
    @RequiresApi(30)
    @Deprecated
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void addOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.a(onControllableInsetsChangedListener);
    }

    public void controlWindowInsetsAnimation(int i11, long j11, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.mImpl.b(i11, j11, interpolator, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    @SuppressLint({"WrongConstant"})
    public int getSystemBarsBehavior() {
        return this.mImpl.c();
    }

    public void hide(int i11) {
        this.mImpl.d(i11);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.e();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.f();
    }

    public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.g(onControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean z11) {
        this.mImpl.h(z11);
    }

    public void setAppearanceLightStatusBars(boolean z11) {
        this.mImpl.i(z11);
    }

    public void setSystemBarsBehavior(int i11) {
        this.mImpl.j(i11);
    }

    public void show(int i11) {
        this.mImpl.k(i11);
    }
}
