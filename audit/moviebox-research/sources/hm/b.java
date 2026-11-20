package hm;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f66498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f66499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f66500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f66501d;

    public b(int i11) {
        this(i11, i11);
    }

    public b(int i11, int i12) {
        if (i11 < 1 || i12 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f66498a = i11;
        this.f66499b = i12;
        int i13 = (i11 + 31) / 32;
        this.f66500c = i13;
        this.f66501d = new int[i13 * i12];
    }

    public b(int i11, int i12, int i13, int[] iArr) {
        this.f66498a = i11;
        this.f66499b = i12;
        this.f66500c = i13;
        this.f66501d = iArr;
    }

    public final String a(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(this.f66499b * (this.f66498a + 1));
        for (int i11 = 0; i11 < this.f66499b; i11++) {
            for (int i12 = 0; i12 < this.f66498a; i12++) {
                sb2.append(g(i12, i11) ? str : str2);
            }
            sb2.append(str3);
        }
        return sb2.toString();
    }

    public void b() {
        int length = this.f66501d.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.f66501d[i11] = 0;
        }
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.f66498a, this.f66499b, this.f66500c, (int[]) this.f66501d.clone());
    }

    public void d() {
        int length = this.f66501d.length;
        for (int i11 = 0; i11 < length; i11++) {
            int[] iArr = this.f66501d;
            iArr[i11] = ~iArr[i11];
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f66498a == bVar.f66498a && this.f66499b == bVar.f66499b && this.f66500c == bVar.f66500c && Arrays.equals(this.f66501d, bVar.f66501d);
    }

    public void f(int i11, int i12) {
        int i13 = (i12 * this.f66500c) + (i11 / 32);
        int[] iArr = this.f66501d;
        iArr[i13] = (1 << (i11 & 31)) ^ iArr[i13];
    }

    public boolean g(int i11, int i12) {
        return ((this.f66501d[(i12 * this.f66500c) + (i11 / 32)] >>> (i11 & 31)) & 1) != 0;
    }

    public int[] h() {
        int length = this.f66501d.length - 1;
        while (length >= 0 && this.f66501d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i11 = this.f66500c;
        int i12 = length / i11;
        int i13 = (length % i11) * 32;
        int i14 = 31;
        while ((this.f66501d[length] >>> i14) == 0) {
            i14--;
        }
        return new int[]{i13 + i14, i12};
    }

    public int hashCode() {
        int i11 = this.f66498a;
        return (((((((i11 * 31) + i11) * 31) + this.f66499b) * 31) + this.f66500c) * 31) + Arrays.hashCode(this.f66501d);
    }

    public int[] j() {
        int i11 = this.f66498a;
        int i12 = this.f66499b;
        int i13 = -1;
        int i14 = -1;
        for (int i15 = 0; i15 < this.f66499b; i15++) {
            int i16 = 0;
            while (true) {
                int i17 = this.f66500c;
                if (i16 < i17) {
                    int i18 = this.f66501d[(i17 * i15) + i16];
                    if (i18 != 0) {
                        if (i15 < i12) {
                            i12 = i15;
                        }
                        if (i15 > i14) {
                            i14 = i15;
                        }
                        int i19 = i16 * 32;
                        if (i19 < i11) {
                            int i21 = 0;
                            while ((i18 << (31 - i21)) == 0) {
                                i21++;
                            }
                            int i22 = i21 + i19;
                            if (i22 < i11) {
                                i11 = i22;
                            }
                        }
                        if (i19 + 31 > i13) {
                            int i23 = 31;
                            while ((i18 >>> i23) == 0) {
                                i23--;
                            }
                            int i24 = i19 + i23;
                            if (i24 > i13) {
                                i13 = i24;
                            }
                        }
                    }
                    i16++;
                }
            }
        }
        if (i13 < i11 || i14 < i12) {
            return null;
        }
        return new int[]{i11, i12, (i13 - i11) + 1, (i14 - i12) + 1};
    }

    public int k() {
        return this.f66499b;
    }

    public a l(int i11, a aVar) {
        if (aVar == null || aVar.m() < this.f66498a) {
            aVar = new a(this.f66498a);
        } else {
            aVar.d();
        }
        int i12 = i11 * this.f66500c;
        for (int i13 = 0; i13 < this.f66500c; i13++) {
            aVar.s(i13 * 32, this.f66501d[i12 + i13]);
        }
        return aVar;
    }

    public int[] m() {
        int[] iArr;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            iArr = this.f66501d;
            if (i12 >= iArr.length || iArr[i12] != 0) {
                break;
            }
            i12++;
        }
        if (i12 == iArr.length) {
            return null;
        }
        int i13 = this.f66500c;
        int i14 = i12 / i13;
        int i15 = (i12 % i13) * 32;
        while ((iArr[i12] << (31 - i11)) == 0) {
            i11++;
        }
        return new int[]{i15 + i11, i14};
    }

    public int n() {
        return this.f66498a;
    }

    public void o(int i11) {
        int i12 = i11 % 360;
        if (i12 != 0) {
            if (i12 == 90) {
                q();
                return;
            }
            if (i12 == 180) {
                p();
            } else {
                if (i12 != 270) {
                    throw new IllegalArgumentException("degrees must be a multiple of 0, 90, 180, or 270");
                }
                q();
                p();
            }
        }
    }

    public void p() {
        a aVar = new a(this.f66498a);
        a aVar2 = new a(this.f66498a);
        int i11 = (this.f66499b + 1) / 2;
        for (int i12 = 0; i12 < i11; i12++) {
            aVar = l(i12, aVar);
            int i13 = (this.f66499b - 1) - i12;
            aVar2 = l(i13, aVar2);
            aVar.q();
            aVar2.q();
            t(i12, aVar2);
            t(i13, aVar);
        }
    }

    public void q() {
        int i11 = this.f66499b;
        int i12 = this.f66498a;
        int i13 = (i11 + 31) / 32;
        int[] iArr = new int[i13 * i12];
        for (int i14 = 0; i14 < this.f66499b; i14++) {
            for (int i15 = 0; i15 < this.f66498a; i15++) {
                if (((this.f66501d[(this.f66500c * i14) + (i15 / 32)] >>> (i15 & 31)) & 1) != 0) {
                    int i16 = (((i12 - 1) - i15) * i13) + (i14 / 32);
                    iArr[i16] = (1 << (i14 & 31)) | iArr[i16];
                }
            }
        }
        this.f66498a = i11;
        this.f66499b = i12;
        this.f66500c = i13;
        this.f66501d = iArr;
    }

    public void r(int i11, int i12) {
        int i13 = (i12 * this.f66500c) + (i11 / 32);
        int[] iArr = this.f66501d;
        iArr[i13] = (1 << (i11 & 31)) | iArr[i13];
    }

    public void s(int i11, int i12, int i13, int i14) {
        if (i12 < 0 || i11 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i14 < 1 || i13 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i15 = i13 + i11;
        int i16 = i14 + i12;
        if (i16 > this.f66499b || i15 > this.f66498a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i12 < i16) {
            int i17 = this.f66500c * i12;
            for (int i18 = i11; i18 < i15; i18++) {
                int[] iArr = this.f66501d;
                int i19 = (i18 / 32) + i17;
                iArr[i19] = iArr[i19] | (1 << (i18 & 31));
            }
            i12++;
        }
    }

    public void t(int i11, a aVar) {
        int[] iArrJ = aVar.j();
        int[] iArr = this.f66501d;
        int i12 = this.f66500c;
        System.arraycopy(iArrJ, 0, iArr, i11 * i12, i12);
    }

    public String toString() {
        return v("X ", "  ");
    }

    public String v(String str, String str2) {
        return a(str, str2, "\n");
    }
}
