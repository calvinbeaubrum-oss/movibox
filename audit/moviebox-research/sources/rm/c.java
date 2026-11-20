package rm;

import com.google.zxing.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f75628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f75629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k[] f75630c;

    public c(int i11, int[] iArr, int i12, int i13, int i14) {
        this.f75628a = i11;
        this.f75629b = iArr;
        float f11 = i14;
        this.f75630c = new k[]{new k(i12, f11), new k(i13, f11)};
    }

    public k[] a() {
        return this.f75630c;
    }

    public int[] b() {
        return this.f75629b;
    }

    public int c() {
        return this.f75628a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f75628a == ((c) obj).f75628a;
    }

    public int hashCode() {
        return this.f75628a;
    }
}
