package lm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f70327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f70328b;

    public b(int i11, byte[] bArr) {
        this.f70327a = i11;
        this.f70328b = bArr;
    }

    public static b[] b(byte[] bArr, d dVar) {
        d.c cVarD = dVar.d();
        d.b[] bVarArrA = cVarD.a();
        int iA = 0;
        for (d.b bVar : bVarArrA) {
            iA += bVar.a();
        }
        b[] bVarArr = new b[iA];
        int i11 = 0;
        for (d.b bVar2 : bVarArrA) {
            int i12 = 0;
            while (i12 < bVar2.a()) {
                int iB = bVar2.b();
                bVarArr[i11] = new b(iB, new byte[cVarD.b() + iB]);
                i12++;
                i11++;
            }
        }
        int length = bVarArr[0].f70328b.length - cVarD.b();
        int i13 = length - 1;
        int i14 = 0;
        for (int i15 = 0; i15 < i13; i15++) {
            int i16 = 0;
            while (i16 < i11) {
                bVarArr[i16].f70328b[i15] = bArr[i14];
                i16++;
                i14++;
            }
        }
        boolean z11 = dVar.i() == 24;
        int i17 = z11 ? 8 : i11;
        int i18 = 0;
        while (i18 < i17) {
            bVarArr[i18].f70328b[i13] = bArr[i14];
            i18++;
            i14++;
        }
        int length2 = bVarArr[0].f70328b.length;
        while (length < length2) {
            int i19 = 0;
            while (i19 < i11) {
                int i21 = z11 ? (i19 + 8) % i11 : i19;
                bVarArr[i21].f70328b[(!z11 || i21 <= 7) ? length : length - 1] = bArr[i14];
                i19++;
                i14++;
            }
            length++;
        }
        if (i14 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] a() {
        return this.f70328b;
    }

    public int c() {
        return this.f70327a;
    }
}
