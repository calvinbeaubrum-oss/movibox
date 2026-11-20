package c7;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f14666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f14667b;

    public d(float[] fArr, int[] iArr) {
        this.f14666a = fArr;
        this.f14667b = iArr;
    }

    public final void a(d dVar) {
        int i11 = 0;
        while (true) {
            int[] iArr = dVar.f14667b;
            if (i11 >= iArr.length) {
                return;
            }
            this.f14666a[i11] = dVar.f14666a[i11];
            this.f14667b[i11] = iArr[i11];
            i11++;
        }
    }

    public d b(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i11 = 0; i11 < fArr.length; i11++) {
            iArr[i11] = c(fArr[i11]);
        }
        return new d(fArr, iArr);
    }

    public final int c(float f11) {
        int iBinarySearch = Arrays.binarySearch(this.f14666a, f11);
        if (iBinarySearch >= 0) {
            return this.f14667b[iBinarySearch];
        }
        int i11 = -(iBinarySearch + 1);
        if (i11 == 0) {
            return this.f14667b[0];
        }
        int[] iArr = this.f14667b;
        if (i11 == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.f14666a;
        int i12 = i11 - 1;
        float f12 = fArr[i12];
        return g7.d.c((f11 - f12) / (fArr[i11] - f12), iArr[i12], iArr[i11]);
    }

    public int[] d() {
        return this.f14667b;
    }

    public float[] e() {
        return this.f14666a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return Arrays.equals(this.f14666a, dVar.f14666a) && Arrays.equals(this.f14667b, dVar.f14667b);
    }

    public int f() {
        return this.f14667b.length;
    }

    public void g(d dVar, d dVar2, float f11) {
        int[] iArr;
        if (dVar.equals(dVar2)) {
            a(dVar);
            return;
        }
        if (f11 <= 0.0f) {
            a(dVar);
            return;
        }
        if (f11 >= 1.0f) {
            a(dVar2);
            return;
        }
        if (dVar.f14667b.length != dVar2.f14667b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + dVar.f14667b.length + " vs " + dVar2.f14667b.length + ")");
        }
        int i11 = 0;
        while (true) {
            iArr = dVar.f14667b;
            if (i11 >= iArr.length) {
                break;
            }
            this.f14666a[i11] = g7.k.i(dVar.f14666a[i11], dVar2.f14666a[i11], f11);
            this.f14667b[i11] = g7.d.c(f11, dVar.f14667b[i11], dVar2.f14667b[i11]);
            i11++;
        }
        int length = iArr.length;
        while (true) {
            float[] fArr = this.f14666a;
            if (length >= fArr.length) {
                return;
            }
            int[] iArr2 = dVar.f14667b;
            fArr[length] = fArr[iArr2.length - 1];
            int[] iArr3 = this.f14667b;
            iArr3[length] = iArr3[iArr2.length - 1];
            length++;
        }
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f14666a) * 31) + Arrays.hashCode(this.f14667b);
    }
}
