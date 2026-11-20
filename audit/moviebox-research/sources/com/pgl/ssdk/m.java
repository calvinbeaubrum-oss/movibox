package com.pgl.ssdk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class m<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f48794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f48795b;

    public m(A a11, B b11) {
        this.f48794a = a11;
        this.f48795b = b11;
    }

    public static <A, B> m<A, B> a(A a11, B b11) {
        return new m<>(a11, b11);
    }

    public A a() {
        return this.f48794a;
    }

    public B b() {
        return this.f48795b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        A a11 = this.f48794a;
        if (a11 == null) {
            if (mVar.f48794a != null) {
                return false;
            }
        } else if (!a11.equals(mVar.f48794a)) {
            return false;
        }
        B b11 = this.f48795b;
        if (b11 == null) {
            if (mVar.f48795b != null) {
                return false;
            }
        } else if (!b11.equals(mVar.f48795b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a11 = this.f48794a;
        int iHashCode = ((a11 == null ? 0 : a11.hashCode()) + 31) * 31;
        B b11 = this.f48795b;
        return iHashCode + (b11 != null ? b11.hashCode() : 0);
    }
}
