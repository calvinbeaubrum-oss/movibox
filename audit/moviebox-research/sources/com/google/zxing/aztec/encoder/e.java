package com.google.zxing.aztec.encoder;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f41489f = new e(f.f41495b, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f41491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f41493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f41494e;

    public e(f fVar, int i11, int i12, int i13) {
        this.f41491b = fVar;
        this.f41490a = i11;
        this.f41492c = i12;
        this.f41493d = i13;
        this.f41494e = c(i12);
    }

    public static int c(int i11) {
        if (i11 > 62) {
            return 21;
        }
        if (i11 > 31) {
            return 20;
        }
        return i11 > 0 ? 10 : 0;
    }

    public e a(int i11) {
        int i12;
        f fVarA = this.f41491b;
        int i13 = this.f41490a;
        int i14 = this.f41493d;
        if (i13 == 4 || i13 == 2) {
            int i15 = HighLevelEncoder.f41474d[i13][0];
            int i16 = 65535 & i15;
            int i17 = i15 >> 16;
            fVarA = fVarA.a(i16, i17);
            i14 += i17;
            i13 = 0;
        }
        int i18 = this.f41492c;
        if (i18 == 0 || i18 == 31) {
            i12 = 18;
        } else {
            i12 = i18 == 62 ? 9 : 8;
        }
        e eVar = new e(fVarA, i13, i18 + 1, i14 + i12);
        return eVar.f41492c == 2078 ? eVar.d(i11 + 1) : eVar;
    }

    public e b(int i11) {
        f fVarA;
        f fVar = j(4, 0).f41491b;
        int length = 3;
        if (i11 < 0) {
            fVarA = fVar.a(0, 3);
        } else {
            if (i11 > 999999) {
                throw new IllegalArgumentException("ECI code must be between 0 and 999999");
            }
            byte[] bytes = Integer.toString(i11).getBytes(StandardCharsets.ISO_8859_1);
            f fVarA2 = fVar.a(bytes.length, 3);
            for (byte b11 : bytes) {
                fVarA2 = fVarA2.a(b11 - 46, 4);
            }
            length = 3 + (bytes.length * 4);
            fVarA = fVarA2;
        }
        return new e(fVarA, this.f41490a, 0, this.f41493d + length);
    }

    public e d(int i11) {
        int i12 = this.f41492c;
        return i12 == 0 ? this : new e(this.f41491b.b(i11 - i12, i12), this.f41490a, 0, this.f41493d);
    }

    public int e() {
        return this.f41492c;
    }

    public int f() {
        return this.f41493d;
    }

    public int g() {
        return this.f41490a;
    }

    public boolean h(e eVar) {
        int i11 = this.f41493d + (HighLevelEncoder.f41474d[this.f41490a][eVar.f41490a] >> 16);
        int i12 = this.f41492c;
        int i13 = eVar.f41492c;
        if (i12 < i13) {
            i11 += eVar.f41494e - this.f41494e;
        } else if (i12 > i13 && i13 > 0) {
            i11 += 10;
        }
        return i11 <= eVar.f41493d;
    }

    public e i(int i11, int i12) {
        int i13 = this.f41493d;
        f fVarA = this.f41491b;
        int i14 = this.f41490a;
        if (i11 != i14) {
            int i15 = HighLevelEncoder.f41474d[i14][i11];
            int i16 = 65535 & i15;
            int i17 = i15 >> 16;
            fVarA = fVarA.a(i16, i17);
            i13 += i17;
        }
        int i18 = i11 == 2 ? 4 : 5;
        return new e(fVarA.a(i12, i18), i11, 0, i13 + i18);
    }

    public e j(int i11, int i12) {
        f fVar = this.f41491b;
        int i13 = this.f41490a;
        int i14 = i13 == 2 ? 4 : 5;
        return new e(fVar.a(HighLevelEncoder.f41476f[i13][i11], i14).a(i12, 5), this.f41490a, 0, this.f41493d + i14 + 5);
    }

    public hm.a k(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        for (f fVarD = d(bArr.length).f41491b; fVarD != null; fVarD = fVarD.d()) {
            arrayList.add(fVarD);
        }
        hm.a aVar = new hm.a();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((f) arrayList.get(size)).c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.f41473c[this.f41490a], Integer.valueOf(this.f41493d), Integer.valueOf(this.f41492c));
    }
}
