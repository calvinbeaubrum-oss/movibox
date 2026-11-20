package rj;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends Annotation> f75513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<T> f75514b;

    /* JADX INFO: compiled from: source.java */
    public @interface a {
    }

    public b0(Class<? extends Annotation> cls, Class<T> cls2) {
        this.f75513a = cls;
        this.f75514b = cls2;
    }

    public static <T> b0<T> a(Class<? extends Annotation> cls, Class<T> cls2) {
        return new b0<>(cls, cls2);
    }

    public static <T> b0<T> b(Class<T> cls) {
        return new b0<>(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b0.class != obj.getClass()) {
            return false;
        }
        b0 b0Var = (b0) obj;
        if (this.f75514b.equals(b0Var.f75514b)) {
            return this.f75513a.equals(b0Var.f75513a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f75514b.hashCode() * 31) + this.f75513a.hashCode();
    }

    public String toString() {
        if (this.f75513a == a.class) {
            return this.f75514b.getName();
        }
        return "@" + this.f75513a.getName() + " " + this.f75514b.getName();
    }
}
