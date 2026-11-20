package y6;

import android.annotation.SuppressLint;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<K, A> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d<K> f81229c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public h7.c<A> f81231e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f81227a = new ArrayList(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f81228b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f81230d = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public A f81232f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f81233g = -1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f81234h = -1.0f;

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void b();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c<T> implements d<T> {
        public c() {
        }

        @Override // y6.a.d
        public boolean a(float f11) {
            throw new IllegalStateException("not implemented");
        }

        @Override // y6.a.d
        public h7.a<T> b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // y6.a.d
        public boolean c(float f11) {
            return false;
        }

        @Override // y6.a.d
        public float d() {
            return 0.0f;
        }

        @Override // y6.a.d
        public float e() {
            return 1.0f;
        }

        @Override // y6.a.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d<T> {
        boolean a(float f11);

        h7.a<T> b();

        boolean c(float f11);

        float d();

        float e();

        boolean isEmpty();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<? extends h7.a<T>> f81235a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h7.a<T> f81237c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f81238d = -1.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public h7.a<T> f81236b = f(0.0f);

        public e(List<? extends h7.a<T>> list) {
            this.f81235a = list;
        }

        @Override // y6.a.d
        public boolean a(float f11) {
            h7.a<T> aVar = this.f81237c;
            h7.a<T> aVar2 = this.f81236b;
            if (aVar == aVar2 && this.f81238d == f11) {
                return true;
            }
            this.f81237c = aVar2;
            this.f81238d = f11;
            return false;
        }

        @Override // y6.a.d
        @NonNull
        public h7.a<T> b() {
            return this.f81236b;
        }

        @Override // y6.a.d
        public boolean c(float f11) {
            if (this.f81236b.a(f11)) {
                return !this.f81236b.i();
            }
            this.f81236b = f(f11);
            return true;
        }

        @Override // y6.a.d
        public float d() {
            return this.f81235a.get(0).f();
        }

        @Override // y6.a.d
        public float e() {
            List<? extends h7.a<T>> list = this.f81235a;
            return list.get(list.size() - 1).c();
        }

        public final h7.a<T> f(float f11) {
            List<? extends h7.a<T>> list = this.f81235a;
            h7.a<T> aVar = list.get(list.size() - 1);
            if (f11 >= aVar.f()) {
                return aVar;
            }
            for (int size = this.f81235a.size() - 2; size >= 1; size--) {
                h7.a<T> aVar2 = this.f81235a.get(size);
                if (this.f81236b != aVar2 && aVar2.a(f11)) {
                    return aVar2;
                }
            }
            return this.f81235a.get(0);
        }

        @Override // y6.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final h7.a<T> f81239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f81240b = -1.0f;

        public f(List<? extends h7.a<T>> list) {
            this.f81239a = list.get(0);
        }

        @Override // y6.a.d
        public boolean a(float f11) {
            if (this.f81240b == f11) {
                return true;
            }
            this.f81240b = f11;
            return false;
        }

        @Override // y6.a.d
        public h7.a<T> b() {
            return this.f81239a;
        }

        @Override // y6.a.d
        public boolean c(float f11) {
            return !this.f81239a.i();
        }

        @Override // y6.a.d
        public float d() {
            return this.f81239a.f();
        }

        @Override // y6.a.d
        public float e() {
            return this.f81239a.c();
        }

        @Override // y6.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    public a(List<? extends h7.a<K>> list) {
        this.f81229c = p(list);
    }

    public static <T> d<T> p(List<? extends h7.a<T>> list) {
        if (list.isEmpty()) {
            return new c();
        }
        return list.size() == 1 ? new f(list) : new e(list);
    }

    public void a(b bVar) {
        this.f81227a.add(bVar);
    }

    public h7.a<K> b() {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("BaseKeyframeAnimation#getCurrentKeyframe");
        }
        h7.a<K> aVarB = this.f81229c.b();
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("BaseKeyframeAnimation#getCurrentKeyframe");
        }
        return aVarB;
    }

    @SuppressLint({"Range"})
    public float c() {
        if (this.f81234h == -1.0f) {
            this.f81234h = this.f81229c.e();
        }
        return this.f81234h;
    }

    public float d() {
        Interpolator interpolator;
        h7.a<K> aVarB = b();
        if (aVarB == null || aVarB.i() || (interpolator = aVarB.f66352d) == null) {
            return 0.0f;
        }
        return interpolator.getInterpolation(e());
    }

    public float e() {
        if (this.f81228b) {
            return 0.0f;
        }
        h7.a<K> aVarB = b();
        if (aVarB.i()) {
            return 0.0f;
        }
        return (this.f81230d - aVarB.f()) / (aVarB.c() - aVarB.f());
    }

    public float f() {
        return this.f81230d;
    }

    @SuppressLint({"Range"})
    public final float g() {
        if (this.f81233g == -1.0f) {
            this.f81233g = this.f81229c.d();
        }
        return this.f81233g;
    }

    public A h() {
        float fE = e();
        if (this.f81231e == null && this.f81229c.a(fE)) {
            return this.f81232f;
        }
        h7.a<K> aVarB = b();
        Interpolator interpolator = aVarB.f66353e;
        A aI = (interpolator == null || aVarB.f66354f == null) ? i(aVarB, d()) : j(aVarB, fE, interpolator.getInterpolation(fE), aVarB.f66354f.getInterpolation(fE));
        this.f81232f = aI;
        return aI;
    }

    public abstract A i(h7.a<K> aVar, float f11);

    public A j(h7.a<K> aVar, float f11, float f12, float f13) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public boolean k() {
        return this.f81231e != null;
    }

    public void l() {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("BaseKeyframeAnimation#notifyListeners");
        }
        for (int i11 = 0; i11 < this.f81227a.size(); i11++) {
            this.f81227a.get(i11).b();
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("BaseKeyframeAnimation#notifyListeners");
        }
    }

    public void m() {
        this.f81228b = true;
    }

    public void n(float f11) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("BaseKeyframeAnimation#setProgress");
        }
        if (this.f81229c.isEmpty()) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseKeyframeAnimation#setProgress");
                return;
            }
            return;
        }
        if (f11 < g()) {
            f11 = g();
        } else if (f11 > c()) {
            f11 = c();
        }
        if (f11 == this.f81230d) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseKeyframeAnimation#setProgress");
            }
        } else {
            this.f81230d = f11;
            if (this.f81229c.c(f11)) {
                l();
            }
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseKeyframeAnimation#setProgress");
            }
        }
    }

    public void o(@Nullable h7.c<A> cVar) {
        h7.c<A> cVar2 = this.f81231e;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f81231e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
