package yn;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f81571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f81572b;

    public d(A a11, B b11) {
        this.f81571a = a11;
        this.f81572b = b11;
    }

    public static <A, B> d<A, B> b(A a11, B b11) {
        return new d<>(a11, b11);
    }

    public A a() {
        return this.f81571a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        A a11 = this.f81571a;
        if (a11 == null) {
            if (dVar.f81571a != null) {
                return false;
            }
        } else if (!a11.equals(dVar.f81571a)) {
            return false;
        }
        B b11 = this.f81572b;
        if (b11 == null) {
            if (dVar.f81572b != null) {
                return false;
            }
        } else if (!b11.equals(dVar.f81572b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a11 = this.f81571a;
        int iHashCode = ((a11 == null ? 0 : a11.hashCode()) + 31) * 31;
        B b11 = this.f81572b;
        return iHashCode + (b11 != null ? b11.hashCode() : 0);
    }
}
