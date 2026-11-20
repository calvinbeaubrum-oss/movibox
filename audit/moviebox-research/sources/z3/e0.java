package z3;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e0 f81770c = new e0(-1, -1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e0 f81771d = new e0(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f81772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f81773b;

    public e0(int i11, int i12) {
        a.a((i11 == -1 || i11 >= 0) && (i12 == -1 || i12 >= 0));
        this.f81772a = i11;
        this.f81773b = i12;
    }

    public int a() {
        return this.f81773b;
    }

    public int b() {
        return this.f81772a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return this.f81772a == e0Var.f81772a && this.f81773b == e0Var.f81773b;
    }

    public int hashCode() {
        int i11 = this.f81773b;
        int i12 = this.f81772a;
        return i11 ^ ((i12 >>> 16) | (i12 << 16));
    }

    public String toString() {
        return this.f81772a + "x" + this.f81773b;
    }
}
