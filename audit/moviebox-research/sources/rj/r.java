package rj;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0<?> f75568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f75569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f75570c;

    public r(Class<?> cls, int i11, int i12) {
        this((b0<?>) b0.b(cls), i11, i12);
    }

    public r(b0<?> b0Var, int i11, int i12) {
        this.f75568a = (b0) a0.c(b0Var, "Null dependency anInterface.");
        this.f75569b = i11;
        this.f75570c = i12;
    }

    public static r a(Class<?> cls) {
        return new r(cls, 0, 2);
    }

    public static String b(int i11) {
        if (i11 == 0) {
            return DevicePublicKeyStringDef.DIRECT;
        }
        if (i11 == 1) {
            return "provider";
        }
        if (i11 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i11);
    }

    @Deprecated
    public static r h(Class<?> cls) {
        return new r(cls, 0, 0);
    }

    public static r i(Class<?> cls) {
        return new r(cls, 0, 1);
    }

    public static r j(Class<?> cls) {
        return new r(cls, 1, 0);
    }

    public static r k(b0<?> b0Var) {
        return new r(b0Var, 1, 0);
    }

    public static r l(Class<?> cls) {
        return new r(cls, 1, 1);
    }

    public static r m(Class<?> cls) {
        return new r(cls, 2, 0);
    }

    public b0<?> c() {
        return this.f75568a;
    }

    public boolean d() {
        return this.f75570c == 2;
    }

    public boolean e() {
        return this.f75570c == 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f75568a.equals(rVar.f75568a) && this.f75569b == rVar.f75569b && this.f75570c == rVar.f75570c;
    }

    public boolean f() {
        return this.f75569b == 1;
    }

    public boolean g() {
        return this.f75569b == 2;
    }

    public int hashCode() {
        return ((((this.f75568a.hashCode() ^ 1000003) * 1000003) ^ this.f75569b) * 1000003) ^ this.f75570c;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("Dependency{anInterface=");
        sb2.append(this.f75568a);
        sb2.append(", type=");
        int i11 = this.f75569b;
        if (i11 == 1) {
            str = "required";
        } else {
            str = i11 == 0 ? "optional" : "set";
        }
        sb2.append(str);
        sb2.append(", injection=");
        sb2.append(b(this.f75570c));
        sb2.append("}");
        return sb2.toString();
    }
}
