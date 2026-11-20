package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.WindowInsetsAnimationController;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class WindowInsetsAnimationControllerCompat {
    private final b mImpl;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(30)
    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowInsetsAnimationController f7958a;

        public a(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
            this.f7958a = windowInsetsAnimationController;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        public void a(boolean z11) {
            this.f7958a.finish(z11);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        public float b() {
            return this.f7958a.getCurrentAlpha();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        public float c() {
            return this.f7958a.getCurrentFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        @NonNull
        public c3.c d() {
            return c3.c.e(this.f7958a.getCurrentInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        @NonNull
        public c3.c e() {
            return c3.c.e(this.f7958a.getHiddenStateInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        @NonNull
        public c3.c f() {
            return c3.c.e(this.f7958a.getShownStateInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        @SuppressLint({"WrongConstant"})
        public int g() {
            return this.f7958a.getTypes();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        public boolean h() {
            return this.f7958a.isCancelled();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        public boolean i() {
            return this.f7958a.isFinished();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        public void j(@Nullable c3.c cVar, float f11, float f12) {
            this.f7958a.setInsetsAndAlpha(cVar == null ? null : cVar.f(), f11, f12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {
        public void a(boolean z11) {
            throw null;
        }

        public float b() {
            throw null;
        }

        public float c() {
            throw null;
        }

        @NonNull
        public c3.c d() {
            throw null;
        }

        @NonNull
        public c3.c e() {
            throw null;
        }

        @NonNull
        public c3.c f() {
            throw null;
        }

        public int g() {
            throw null;
        }

        public boolean h() {
            throw null;
        }

        public boolean i() {
            throw null;
        }

        public void j(@Nullable c3.c cVar, float f11, float f12) {
            throw null;
        }
    }

    @RequiresApi(30)
    public WindowInsetsAnimationControllerCompat(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mImpl = new a(windowInsetsAnimationController);
    }

    public void finish(boolean z11) {
        this.mImpl.a(z11);
    }

    public float getCurrentAlpha() {
        return this.mImpl.b();
    }

    public float getCurrentFraction() {
        return this.mImpl.c();
    }

    @NonNull
    public c3.c getCurrentInsets() {
        return this.mImpl.d();
    }

    @NonNull
    public c3.c getHiddenStateInsets() {
        return this.mImpl.e();
    }

    @NonNull
    public c3.c getShownStateInsets() {
        return this.mImpl.f();
    }

    public int getTypes() {
        return this.mImpl.g();
    }

    public boolean isCancelled() {
        return this.mImpl.h();
    }

    public boolean isFinished() {
        return this.mImpl.i();
    }

    public boolean isReady() {
        return (isFinished() || isCancelled()) ? false : true;
    }

    public void setInsetsAndAlpha(@Nullable c3.c cVar, float f11, float f12) {
        this.mImpl.j(cVar, f11, f12);
    }
}
