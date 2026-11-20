package rj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f75515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<b0<? super T>> f75516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<r> f75517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f75518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f75519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h<T> f75520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Class<?>> f75521g;

    /* JADX INFO: compiled from: source.java */
    public static class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f75522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<b0<? super T>> f75523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<r> f75524c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f75525d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f75526e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public h<T> f75527f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Set<Class<?>> f75528g;

        @SafeVarargs
        public b(Class<T> cls, Class<? super T>... clsArr) {
            this.f75522a = null;
            HashSet hashSet = new HashSet();
            this.f75523b = hashSet;
            this.f75524c = new HashSet();
            this.f75525d = 0;
            this.f75526e = 0;
            this.f75528g = new HashSet();
            a0.c(cls, "Null interface");
            hashSet.add(b0.b(cls));
            for (Class<? super T> cls2 : clsArr) {
                a0.c(cls2, "Null interface");
                this.f75523b.add(b0.b(cls2));
            }
        }

        @SafeVarargs
        public b(b0<T> b0Var, b0<? super T>... b0VarArr) {
            this.f75522a = null;
            HashSet hashSet = new HashSet();
            this.f75523b = hashSet;
            this.f75524c = new HashSet();
            this.f75525d = 0;
            this.f75526e = 0;
            this.f75528g = new HashSet();
            a0.c(b0Var, "Null interface");
            hashSet.add(b0Var);
            for (b0<? super T> b0Var2 : b0VarArr) {
                a0.c(b0Var2, "Null interface");
            }
            Collections.addAll(this.f75523b, b0VarArr);
        }

        public b<T> b(r rVar) {
            a0.c(rVar, "Null dependency");
            j(rVar.c());
            this.f75524c.add(rVar);
            return this;
        }

        public b<T> c() {
            return i(1);
        }

        public c<T> d() {
            a0.d(this.f75527f != null, "Missing required property: factory.");
            return new c<>(this.f75522a, new HashSet(this.f75523b), new HashSet(this.f75524c), this.f75525d, this.f75526e, this.f75527f, this.f75528g);
        }

        public b<T> e() {
            return i(2);
        }

        public b<T> f(h<T> hVar) {
            this.f75527f = (h) a0.c(hVar, "Null factory");
            return this;
        }

        public final b<T> g() {
            this.f75526e = 1;
            return this;
        }

        public b<T> h(@NonNull String str) {
            this.f75522a = str;
            return this;
        }

        public final b<T> i(int i11) {
            a0.d(this.f75525d == 0, "Instantiation type has already been set.");
            this.f75525d = i11;
            return this;
        }

        public final void j(b0<?> b0Var) {
            a0.a(!this.f75523b.contains(b0Var), "Components are not allowed to depend on interfaces they themselves provide.");
        }
    }

    public c(@Nullable String str, Set<b0<? super T>> set, Set<r> set2, int i11, int i12, h<T> hVar, Set<Class<?>> set3) {
        this.f75515a = str;
        this.f75516b = Collections.unmodifiableSet(set);
        this.f75517c = Collections.unmodifiableSet(set2);
        this.f75518d = i11;
        this.f75519e = i12;
        this.f75520f = hVar;
        this.f75521g = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> c(Class<T> cls) {
        return new b<>(cls, new Class[0]);
    }

    @SafeVarargs
    public static <T> b<T> d(Class<T> cls, Class<? super T>... clsArr) {
        return new b<>(cls, clsArr);
    }

    public static <T> b<T> e(b0<T> b0Var) {
        return new b<>(b0Var, new b0[0]);
    }

    @SafeVarargs
    public static <T> b<T> f(b0<T> b0Var, b0<? super T>... b0VarArr) {
        return new b<>(b0Var, b0VarArr);
    }

    public static <T> c<T> l(final T t11, Class<T> cls) {
        return m(cls).f(new h() { // from class: rj.a
            @Override // rj.h
            public final Object a(e eVar) {
                return c.q(t11, eVar);
            }
        }).d();
    }

    public static <T> b<T> m(Class<T> cls) {
        return c(cls).g();
    }

    public static /* synthetic */ Object q(Object obj, e eVar) {
        return obj;
    }

    public static /* synthetic */ Object r(Object obj, e eVar) {
        return obj;
    }

    @SafeVarargs
    public static <T> c<T> s(final T t11, Class<T> cls, Class<? super T>... clsArr) {
        return d(cls, clsArr).f(new h() { // from class: rj.b
            @Override // rj.h
            public final Object a(e eVar) {
                return c.r(t11, eVar);
            }
        }).d();
    }

    public Set<r> g() {
        return this.f75517c;
    }

    public h<T> h() {
        return this.f75520f;
    }

    @Nullable
    public String i() {
        return this.f75515a;
    }

    public Set<b0<? super T>> j() {
        return this.f75516b;
    }

    public Set<Class<?>> k() {
        return this.f75521g;
    }

    public boolean n() {
        return this.f75518d == 1;
    }

    public boolean o() {
        return this.f75518d == 2;
    }

    public boolean p() {
        return this.f75519e == 0;
    }

    public c<T> t(h<T> hVar) {
        return new c<>(this.f75515a, this.f75516b, this.f75517c, this.f75518d, this.f75519e, hVar, this.f75521g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f75516b.toArray()) + ">{" + this.f75518d + ", type=" + this.f75519e + ", deps=" + Arrays.toString(this.f75517c.toArray()) + "}";
    }
}
