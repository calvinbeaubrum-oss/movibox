package com.applovin.impl;

import android.util.Pair;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tc extends vo {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f23236c;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f23237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String[] f23238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f23239c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final po[] f23240d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f23241e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[][][] f23242f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final po f23243g;

        public a(String[] strArr, int[] iArr, po[] poVarArr, int[] iArr2, int[][][] iArr3, po poVar) {
            this.f23238b = strArr;
            this.f23239c = iArr;
            this.f23240d = poVarArr;
            this.f23242f = iArr3;
            this.f23241e = iArr2;
            this.f23243g = poVar;
            this.f23237a = iArr.length;
        }

        public int a() {
            return this.f23237a;
        }

        public int a(int i11) {
            return this.f23239c[i11];
        }

        public po b(int i11) {
            return this.f23240d[i11];
        }
    }

    private static int a(ri[] riVarArr, oo ooVar, int[] iArr, boolean z11) {
        int length = riVarArr.length;
        int i11 = 0;
        boolean z12 = true;
        for (int i12 = 0; i12 < riVarArr.length; i12++) {
            ri riVar = riVarArr[i12];
            int iMax = 0;
            for (int i13 = 0; i13 < ooVar.f21584a; i13++) {
                iMax = Math.max(iMax, v40.d(riVar.a(ooVar.a(i13))));
            }
            boolean z13 = iArr[i12] == 0;
            if (iMax > i11 || (iMax == i11 && z11 && !z12 && z13)) {
                length = i12;
                z12 = z13;
                i11 = iMax;
            }
        }
        return length;
    }

    private static int[] a(ri riVar, oo ooVar) {
        int[] iArr = new int[ooVar.f21584a];
        for (int i11 = 0; i11 < ooVar.f21584a; i11++) {
            iArr[i11] = riVar.a(ooVar.a(i11));
        }
        return iArr;
    }

    private static int[] a(ri[] riVarArr) {
        int length = riVarArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = riVarArr[i11].m();
        }
        return iArr;
    }

    public abstract Pair a(a aVar, int[][][] iArr, int[] iArr2, be.a aVar2, fo foVar);

    @Override // com.applovin.impl.vo
    public final wo a(ri[] riVarArr, po poVar, be.a aVar, fo foVar) {
        int[] iArr = new int[riVarArr.length + 1];
        int length = riVarArr.length + 1;
        oo[][] ooVarArr = new oo[length][];
        int[][][] iArr2 = new int[riVarArr.length + 1][][];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = poVar.f21810a;
            ooVarArr[i11] = new oo[i12];
            iArr2[i11] = new int[i12][];
        }
        int[] iArrA = a(riVarArr);
        for (int i13 = 0; i13 < poVar.f21810a; i13++) {
            oo ooVarA = poVar.a(i13);
            int iA = a(riVarArr, ooVarA, iArr, Cif.e(ooVarA.a(0).f18900m) == 5);
            int[] iArrA2 = iA == riVarArr.length ? new int[ooVarA.f21584a] : a(riVarArr[iA], ooVarA);
            int i14 = iArr[iA];
            ooVarArr[iA][i14] = ooVarA;
            iArr2[iA][i14] = iArrA2;
            iArr[iA] = i14 + 1;
        }
        po[] poVarArr = new po[riVarArr.length];
        String[] strArr = new String[riVarArr.length];
        int[] iArr3 = new int[riVarArr.length];
        for (int i15 = 0; i15 < riVarArr.length; i15++) {
            int i16 = iArr[i15];
            poVarArr[i15] = new po((oo[]) xp.a(ooVarArr[i15], i16));
            iArr2[i15] = (int[][]) xp.a(iArr2[i15], i16);
            strArr[i15] = riVarArr[i15].getName();
            iArr3[i15] = riVarArr[i15].e();
        }
        a aVar2 = new a(strArr, iArr3, poVarArr, iArrA, iArr2, new po((oo[]) xp.a(ooVarArr[riVarArr.length], iArr[riVarArr.length])));
        Pair pairA = a(aVar2, iArr2, iArrA, aVar, foVar);
        return new wo((si[]) pairA.first, (h8[]) pairA.second, aVar2);
    }

    @Override // com.applovin.impl.vo
    public final void a(Object obj) {
        this.f23236c = (a) obj;
    }
}
