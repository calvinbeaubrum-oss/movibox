package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class fr {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f19099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f19100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f19101d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f19102e;

        public a(int i11, int i12, long[] jArr, int i13, boolean z11) {
            this.f19098a = i11;
            this.f19099b = i12;
            this.f19100c = jArr;
            this.f19101d = i13;
            this.f19102e = z11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f19104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f19105c;

        public b(String str, String[] strArr, int i11) {
            this.f19103a = str;
            this.f19104b = strArr;
            this.f19105c = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f19106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f19107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f19108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f19109d;

        public c(boolean z11, int i11, int i12, int i13) {
            this.f19106a = z11;
            this.f19107b = i11;
            this.f19108c = i12;
            this.f19109d = i13;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f19111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f19112c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f19113d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f19114e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f19115f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f19116g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f19117h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f19118i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final byte[] f19119j;

        public d(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, boolean z11, byte[] bArr) {
            this.f19110a = i11;
            this.f19111b = i12;
            this.f19112c = i13;
            this.f19113d = i14;
            this.f19114e = i15;
            this.f19115f = i16;
            this.f19116g = i17;
            this.f19117h = i18;
            this.f19118i = z11;
            this.f19119j = bArr;
        }
    }

    public static int a(int i11) {
        int i12 = 0;
        while (i11 > 0) {
            i12++;
            i11 >>>= 1;
        }
        return i12;
    }

    private static long a(long j11, long j12) {
        return (long) Math.floor(Math.pow(j11, 1.0d / j12));
    }

    private static a a(cr crVar) throws dh {
        if (crVar.a(24) != 5653314) {
            throw dh.a("expected code book to start with [0x56, 0x43, 0x42] at " + crVar.b(), null);
        }
        int iA = crVar.a(16);
        int iA2 = crVar.a(24);
        long[] jArr = new long[iA2];
        boolean zC = crVar.c();
        long jA = 0;
        if (zC) {
            int iA3 = crVar.a(5) + 1;
            int i11 = 0;
            while (i11 < iA2) {
                int iA4 = crVar.a(a(iA2 - i11));
                for (int i12 = 0; i12 < iA4 && i11 < iA2; i12++) {
                    jArr[i11] = iA3;
                    i11++;
                }
                iA3++;
            }
        } else {
            boolean zC2 = crVar.c();
            for (int i13 = 0; i13 < iA2; i13++) {
                if (!zC2) {
                    jArr[i13] = crVar.a(5) + 1;
                } else if (crVar.c()) {
                    jArr[i13] = crVar.a(5) + 1;
                } else {
                    jArr[i13] = 0;
                }
            }
        }
        int iA5 = crVar.a(4);
        if (iA5 > 2) {
            throw dh.a("lookup type greater than 2 not decodable: " + iA5, null);
        }
        if (iA5 == 1 || iA5 == 2) {
            crVar.b(32);
            crVar.b(32);
            int iA6 = crVar.a(4) + 1;
            crVar.b(1);
            if (iA5 != 1) {
                jA = ((long) iA2) * ((long) iA);
            } else if (iA != 0) {
                jA = a(iA2, iA);
            }
            crVar.b((int) (jA * ((long) iA6)));
        }
        return new a(iA, iA2, jArr, iA5, zC);
    }

    public static b a(bh bhVar) {
        return a(bhVar, true, true);
    }

    public static b a(bh bhVar, boolean z11, boolean z12) throws dh {
        if (z11) {
            a(3, bhVar, false);
        }
        String strC = bhVar.c((int) bhVar.p());
        int length = strC.length();
        long jP = bhVar.p();
        String[] strArr = new String[(int) jP];
        int length2 = length + 15;
        for (int i11 = 0; i11 < jP; i11++) {
            String strC2 = bhVar.c((int) bhVar.p());
            strArr[i11] = strC2;
            length2 = length2 + 4 + strC2.length();
        }
        if (z12 && (bhVar.w() & 1) == 0) {
            throw dh.a("framing bit expected to be set", null);
        }
        return new b(strC, strArr, length2 + 1);
    }

    private static void a(int i11, cr crVar) throws dh {
        int iA = crVar.a(6) + 1;
        for (int i12 = 0; i12 < iA; i12++) {
            int iA2 = crVar.a(16);
            if (iA2 != 0) {
                pc.b("VorbisUtil", "mapping type other than 0 not supported: " + iA2);
            } else {
                int iA3 = crVar.c() ? crVar.a(4) + 1 : 1;
                if (crVar.c()) {
                    int iA4 = crVar.a(8) + 1;
                    for (int i13 = 0; i13 < iA4; i13++) {
                        int i14 = i11 - 1;
                        crVar.b(a(i14));
                        crVar.b(a(i14));
                    }
                }
                if (crVar.a(2) != 0) {
                    throw dh.a("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (iA3 > 1) {
                    for (int i15 = 0; i15 < i11; i15++) {
                        crVar.b(4);
                    }
                }
                for (int i16 = 0; i16 < iA3; i16++) {
                    crVar.b(8);
                    crVar.b(8);
                    crVar.b(8);
                }
            }
        }
    }

    public static boolean a(int i11, bh bhVar, boolean z11) throws dh {
        if (bhVar.a() < 7) {
            if (z11) {
                return false;
            }
            throw dh.a("too short header: " + bhVar.a(), null);
        }
        if (bhVar.w() != i11) {
            if (z11) {
                return false;
            }
            throw dh.a("expected header type " + Integer.toHexString(i11), null);
        }
        if (bhVar.w() == 118 && bhVar.w() == 111 && bhVar.w() == 114 && bhVar.w() == 98 && bhVar.w() == 105 && bhVar.w() == 115) {
            return true;
        }
        if (z11) {
            return false;
        }
        throw dh.a("expected characters 'vorbis'", null);
    }

    public static c[] a(bh bhVar, int i11) throws dh {
        a(5, bhVar, false);
        int iW = bhVar.w() + 1;
        cr crVar = new cr(bhVar.c());
        crVar.b(bhVar.d() * 8);
        for (int i12 = 0; i12 < iW; i12++) {
            a(crVar);
        }
        int iA = crVar.a(6) + 1;
        for (int i13 = 0; i13 < iA; i13++) {
            if (crVar.a(16) != 0) {
                throw dh.a("placeholder of time domain transforms not zeroed out", null);
            }
        }
        b(crVar);
        d(crVar);
        a(i11, crVar);
        c[] cVarArrC = c(crVar);
        if (crVar.c()) {
            return cVarArrC;
        }
        throw dh.a("framing bit after modes not set as expected", null);
    }

    public static d b(bh bhVar) throws dh {
        a(1, bhVar, false);
        int iQ = bhVar.q();
        int iW = bhVar.w();
        int iQ2 = bhVar.q();
        int iM = bhVar.m();
        if (iM <= 0) {
            iM = -1;
        }
        int iM2 = bhVar.m();
        if (iM2 <= 0) {
            iM2 = -1;
        }
        int iM3 = bhVar.m();
        if (iM3 <= 0) {
            iM3 = -1;
        }
        int iW2 = bhVar.w();
        return new d(iQ, iW, iQ2, iM, iM2, iM3, (int) Math.pow(2.0d, iW2 & 15), (int) Math.pow(2.0d, (iW2 & 240) >> 4), (bhVar.w() & 1) > 0, Arrays.copyOf(bhVar.c(), bhVar.e()));
    }

    private static void b(cr crVar) throws dh {
        int iA = crVar.a(6) + 1;
        for (int i11 = 0; i11 < iA; i11++) {
            int iA2 = crVar.a(16);
            if (iA2 == 0) {
                crVar.b(8);
                crVar.b(16);
                crVar.b(16);
                crVar.b(6);
                crVar.b(8);
                int iA3 = crVar.a(4) + 1;
                for (int i12 = 0; i12 < iA3; i12++) {
                    crVar.b(8);
                }
            } else {
                if (iA2 != 1) {
                    throw dh.a("floor type greater than 1 not decodable: " + iA2, null);
                }
                int iA4 = crVar.a(5);
                int[] iArr = new int[iA4];
                int i13 = -1;
                for (int i14 = 0; i14 < iA4; i14++) {
                    int iA5 = crVar.a(4);
                    iArr[i14] = iA5;
                    if (iA5 > i13) {
                        i13 = iA5;
                    }
                }
                int i15 = i13 + 1;
                int[] iArr2 = new int[i15];
                for (int i16 = 0; i16 < i15; i16++) {
                    iArr2[i16] = crVar.a(3) + 1;
                    int iA6 = crVar.a(2);
                    if (iA6 > 0) {
                        crVar.b(8);
                    }
                    for (int i17 = 0; i17 < (1 << iA6); i17++) {
                        crVar.b(8);
                    }
                }
                crVar.b(2);
                int iA7 = crVar.a(4);
                int i18 = 0;
                int i19 = 0;
                for (int i21 = 0; i21 < iA4; i21++) {
                    i18 += iArr2[iArr[i21]];
                    while (i19 < i18) {
                        crVar.b(iA7);
                        i19++;
                    }
                }
            }
        }
    }

    private static c[] c(cr crVar) {
        int iA = crVar.a(6) + 1;
        c[] cVarArr = new c[iA];
        for (int i11 = 0; i11 < iA; i11++) {
            cVarArr[i11] = new c(crVar.c(), crVar.a(16), crVar.a(16), crVar.a(8));
        }
        return cVarArr;
    }

    private static void d(cr crVar) throws dh {
        int iA = crVar.a(6) + 1;
        for (int i11 = 0; i11 < iA; i11++) {
            if (crVar.a(16) > 2) {
                throw dh.a("residueType greater than 2 is not decodable", null);
            }
            crVar.b(24);
            crVar.b(24);
            crVar.b(24);
            int iA2 = crVar.a(6) + 1;
            crVar.b(8);
            int[] iArr = new int[iA2];
            for (int i12 = 0; i12 < iA2; i12++) {
                iArr[i12] = ((crVar.c() ? crVar.a(5) : 0) * 8) + crVar.a(3);
            }
            for (int i13 = 0; i13 < iA2; i13++) {
                for (int i14 = 0; i14 < 8; i14++) {
                    if ((iArr[i13] & (1 << i14)) != 0) {
                        crVar.b(8);
                    }
                }
            }
        }
    }
}
