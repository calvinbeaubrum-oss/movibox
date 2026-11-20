package xn;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class t implements Comparable<t> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f80643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f80644b;

    public t(int i11, int i12) {
        this.f80643a = i11;
        this.f80644b = i12;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull t tVar) {
        int i11 = this.f80644b * this.f80643a;
        int i12 = tVar.f80644b * tVar.f80643a;
        if (i12 < i11) {
            return 1;
        }
        return i12 > i11 ? -1 : 0;
    }

    public boolean b(t tVar) {
        return this.f80643a <= tVar.f80643a && this.f80644b <= tVar.f80644b;
    }

    public t c() {
        return new t(this.f80644b, this.f80643a);
    }

    public t d(int i11, int i12) {
        return new t((this.f80643a * i11) / i12, (this.f80644b * i11) / i12);
    }

    public t e(t tVar) {
        int i11 = this.f80643a;
        int i12 = tVar.f80644b;
        int i13 = i11 * i12;
        int i14 = tVar.f80643a;
        int i15 = this.f80644b;
        return i13 <= i14 * i15 ? new t(i14, (i15 * i14) / i11) : new t((i11 * i12) / i15, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        return this.f80643a == tVar.f80643a && this.f80644b == tVar.f80644b;
    }

    public t h(t tVar) {
        int i11 = this.f80643a;
        int i12 = tVar.f80644b;
        int i13 = i11 * i12;
        int i14 = tVar.f80643a;
        int i15 = this.f80644b;
        return i13 >= i14 * i15 ? new t(i14, (i15 * i14) / i11) : new t((i11 * i12) / i15, i12);
    }

    public int hashCode() {
        return (this.f80643a * 31) + this.f80644b;
    }

    public String toString() {
        return this.f80643a + "x" + this.f80644b;
    }
}
