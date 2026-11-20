package nm;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f72065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f72066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f72067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f72068d;

    public e(CharSequence charSequence, int i11, int i12) {
        this.f72065a = charSequence;
        this.f72067c = i11;
        this.f72066b = i12;
        byte[] bArr = new byte[i11 * i12];
        this.f72068d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    public final void a(int i11) {
        f(this.f72066b - 1, 0, i11, 1);
        f(this.f72066b - 1, 1, i11, 2);
        f(this.f72066b - 1, 2, i11, 3);
        f(0, this.f72067c - 2, i11, 4);
        f(0, this.f72067c - 1, i11, 5);
        f(1, this.f72067c - 1, i11, 6);
        f(2, this.f72067c - 1, i11, 7);
        f(3, this.f72067c - 1, i11, 8);
    }

    public final void b(int i11) {
        f(this.f72066b - 3, 0, i11, 1);
        f(this.f72066b - 2, 0, i11, 2);
        f(this.f72066b - 1, 0, i11, 3);
        f(0, this.f72067c - 4, i11, 4);
        f(0, this.f72067c - 3, i11, 5);
        f(0, this.f72067c - 2, i11, 6);
        f(0, this.f72067c - 1, i11, 7);
        f(1, this.f72067c - 1, i11, 8);
    }

    public final void c(int i11) {
        f(this.f72066b - 3, 0, i11, 1);
        f(this.f72066b - 2, 0, i11, 2);
        f(this.f72066b - 1, 0, i11, 3);
        f(0, this.f72067c - 2, i11, 4);
        f(0, this.f72067c - 1, i11, 5);
        f(1, this.f72067c - 1, i11, 6);
        f(2, this.f72067c - 1, i11, 7);
        f(3, this.f72067c - 1, i11, 8);
    }

    public final void d(int i11) {
        f(this.f72066b - 1, 0, i11, 1);
        f(this.f72066b - 1, this.f72067c - 1, i11, 2);
        f(0, this.f72067c - 3, i11, 3);
        f(0, this.f72067c - 2, i11, 4);
        f(0, this.f72067c - 1, i11, 5);
        f(1, this.f72067c - 3, i11, 6);
        f(1, this.f72067c - 2, i11, 7);
        f(1, this.f72067c - 1, i11, 8);
    }

    public final boolean e(int i11, int i12) {
        return this.f72068d[(i12 * this.f72067c) + i11] == 1;
    }

    public final void f(int i11, int i12, int i13, int i14) {
        if (i11 < 0) {
            int i15 = this.f72066b;
            i11 += i15;
            i12 += 4 - ((i15 + 4) % 8);
        }
        if (i12 < 0) {
            int i16 = this.f72067c;
            i12 += i16;
            i11 += 4 - ((i16 + 4) % 8);
        }
        i(i12, i11, (this.f72065a.charAt(i13) & (1 << (8 - i14))) != 0);
    }

    public final boolean g(int i11, int i12) {
        return this.f72068d[(i12 * this.f72067c) + i11] < 0;
    }

    public final void h() {
        int i11;
        int i12;
        int i13 = 0;
        int i14 = 0;
        int i15 = 4;
        while (true) {
            if (i15 == this.f72066b && i13 == 0) {
                a(i14);
                i14++;
            }
            if (i15 == this.f72066b - 2 && i13 == 0 && this.f72067c % 4 != 0) {
                b(i14);
                i14++;
            }
            if (i15 == this.f72066b - 2 && i13 == 0 && this.f72067c % 8 == 4) {
                c(i14);
                i14++;
            }
            if (i15 == this.f72066b + 4 && i13 == 2 && this.f72067c % 8 == 0) {
                d(i14);
                i14++;
            }
            while (true) {
                if (i15 < this.f72066b && i13 >= 0 && g(i13, i15)) {
                    j(i15, i13, i14);
                    i14++;
                }
                int i16 = i15 - 2;
                int i17 = i13 + 2;
                if (i16 < 0 || i17 >= this.f72067c) {
                    break;
                }
                i15 = i16;
                i13 = i17;
            }
            int i18 = i15 - 1;
            int i19 = i13 + 5;
            while (true) {
                if (i18 >= 0 && i19 < this.f72067c && g(i19, i18)) {
                    j(i18, i19, i14);
                    i14++;
                }
                int i21 = i18 + 2;
                int i22 = i19 - 2;
                i11 = this.f72066b;
                if (i21 >= i11 || i22 < 0) {
                    break;
                }
                i18 = i21;
                i19 = i22;
            }
            i15 = i18 + 5;
            i13 = i19 - 1;
            if (i15 >= i11 && i13 >= (i12 = this.f72067c)) {
                break;
            }
        }
        if (g(i12 - 1, i11 - 1)) {
            i(this.f72067c - 1, this.f72066b - 1, true);
            i(this.f72067c - 2, this.f72066b - 2, true);
        }
    }

    public final void i(int i11, int i12, boolean z11) {
        this.f72068d[(i12 * this.f72067c) + i11] = z11 ? (byte) 1 : (byte) 0;
    }

    public final void j(int i11, int i12, int i13) {
        int i14 = i11 - 2;
        int i15 = i12 - 2;
        f(i14, i15, i13, 1);
        int i16 = i12 - 1;
        f(i14, i16, i13, 2);
        int i17 = i11 - 1;
        f(i17, i15, i13, 3);
        f(i17, i16, i13, 4);
        f(i17, i12, i13, 5);
        f(i11, i15, i13, 6);
        f(i11, i16, i13, 7);
        f(i11, i12, i13, 8);
    }
}
