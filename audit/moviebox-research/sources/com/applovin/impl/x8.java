package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Charsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x8 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a9 f24267a;

        public a(a9 a9Var) {
            this.f24267a = a9Var;
        }
    }

    public static a9.a a(bh bhVar) {
        bhVar.g(1);
        int iZ = bhVar.z();
        long jD = ((long) bhVar.d()) + ((long) iZ);
        int i11 = iZ / 18;
        long[] jArrCopyOf = new long[i11];
        long[] jArrCopyOf2 = new long[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            long jS = bhVar.s();
            if (jS == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i12);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i12);
                break;
            }
            jArrCopyOf[i12] = jS;
            jArrCopyOf2[i12] = bhVar.s();
            bhVar.g(2);
        }
        bhVar.g((int) (jD - ((long) bhVar.d())));
        return new a9.a(jArrCopyOf, jArrCopyOf2);
    }

    public static bf a(l8 l8Var, boolean z11) {
        bf bfVarA = new za().a(l8Var, z11 ? null : xa.f24270b);
        if (bfVarA == null || bfVarA.c() == 0) {
            return null;
        }
        return bfVarA;
    }

    private static lh a(l8 l8Var, int i11) {
        bh bhVar = new bh(i11);
        l8Var.d(bhVar.c(), 0, i11);
        bhVar.g(4);
        int iJ = bhVar.j();
        String strA = bhVar.a(bhVar.j(), Charsets.US_ASCII);
        String strC = bhVar.c(bhVar.j());
        int iJ2 = bhVar.j();
        int iJ3 = bhVar.j();
        int iJ4 = bhVar.j();
        int iJ5 = bhVar.j();
        int iJ6 = bhVar.j();
        byte[] bArr = new byte[iJ6];
        bhVar.a(bArr, 0, iJ6);
        return new lh(iJ, strA, strC, iJ2, iJ3, iJ4, iJ5, bArr);
    }

    public static boolean a(l8 l8Var) {
        bh bhVar = new bh(4);
        l8Var.c(bhVar.c(), 0, 4);
        return bhVar.y() == 1716281667;
    }

    public static boolean a(l8 l8Var, a aVar) {
        l8Var.b();
        ah ahVar = new ah(new byte[4]);
        l8Var.c(ahVar.f17657a, 0, 4);
        boolean zF = ahVar.f();
        int iA = ahVar.a(7);
        int iA2 = ahVar.a(24) + 4;
        if (iA == 0) {
            aVar.f24267a = c(l8Var);
        } else {
            a9 a9Var = aVar.f24267a;
            if (a9Var == null) {
                throw new IllegalArgumentException();
            }
            if (iA == 3) {
                aVar.f24267a = a9Var.a(b(l8Var, iA2));
            } else if (iA == 4) {
                aVar.f24267a = a9Var.b(c(l8Var, iA2));
            } else if (iA == 6) {
                aVar.f24267a = a9Var.a(Collections.singletonList(a(l8Var, iA2)));
            } else {
                l8Var.a(iA2);
            }
        }
        return zF;
    }

    public static int b(l8 l8Var) throws dh {
        l8Var.b();
        bh bhVar = new bh(2);
        l8Var.c(bhVar.c(), 0, 2);
        int iC = bhVar.C();
        if ((iC >> 2) == 16382) {
            l8Var.b();
            return iC;
        }
        l8Var.b();
        throw dh.a("First frame does not start with sync code.", null);
    }

    private static a9.a b(l8 l8Var, int i11) {
        bh bhVar = new bh(i11);
        l8Var.d(bhVar.c(), 0, i11);
        return a(bhVar);
    }

    public static bf b(l8 l8Var, boolean z11) {
        l8Var.b();
        long jD = l8Var.d();
        bf bfVarA = a(l8Var, z11);
        l8Var.a((int) (l8Var.d() - jD));
        return bfVarA;
    }

    private static a9 c(l8 l8Var) {
        byte[] bArr = new byte[38];
        l8Var.d(bArr, 0, 38);
        return new a9(bArr, 4);
    }

    private static List c(l8 l8Var, int i11) {
        bh bhVar = new bh(i11);
        l8Var.d(bhVar.c(), 0, i11);
        bhVar.g(4);
        return Arrays.asList(fr.a(bhVar, false, false).f19104b);
    }

    public static void d(l8 l8Var) throws dh {
        bh bhVar = new bh(4);
        l8Var.d(bhVar.c(), 0, 4);
        if (bhVar.y() != 1716281667) {
            throw dh.a("Failed to read FLAC stream marker.", null);
        }
    }
}
