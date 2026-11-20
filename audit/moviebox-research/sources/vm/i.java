package vm;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.k;
import com.google.zxing.pdf417.decoder.DecodedBitStreamParser;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wm.a f79026a = new wm.a();

    public static c a(g gVar) throws NotFoundException {
        int[] iArrJ;
        if (gVar == null || (iArrJ = gVar.j()) == null) {
            return null;
        }
        int iP = p(iArrJ);
        int i11 = 0;
        int i12 = 0;
        for (int i13 : iArrJ) {
            i12 += iP - i13;
            if (i13 > 0) {
                break;
            }
        }
        d[] dVarArrD = gVar.d();
        for (int i14 = 0; i12 > 0 && dVarArrD[i14] == null; i14++) {
            i12--;
        }
        for (int length = iArrJ.length - 1; length >= 0; length--) {
            int i15 = iArrJ[length];
            i11 += iP - i15;
            if (i15 > 0) {
                break;
            }
        }
        for (int length2 = dVarArrD.length - 1; i11 > 0 && dVarArrD[length2] == null; length2--) {
            i11--;
        }
        return gVar.a().a(i12, i11, gVar.k());
    }

    public static void b(e eVar, b[][] bVarArr) throws NotFoundException {
        b bVar = bVarArr[0][1];
        int[] iArrA = bVar.a();
        int iJ = (eVar.j() * eVar.l()) - r(eVar.k());
        if (iArrA.length == 0) {
            if (iJ < 1 || iJ > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            bVar.b(iJ);
            return;
        }
        if (iArrA[0] == iJ || iJ < 1 || iJ > 928) {
            return;
        }
        bVar.b(iJ);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0011  */
    /* JADX WARN: Code duplicated, block: B:14:0x0017  */
    /* JADX WARN: Code duplicated, block: B:17:0x0020 A[LOOP:1: B:8:0x000a->B:17:0x0020, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x001f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0022 A[EDGE_INSN: B:24:0x0022->B:18:0x0022 BREAK  A[LOOP:1: B:8:0x000a->B:17:0x0020], SYNTHETIC] */
    public static int c(hm.b bVar, int i11, int i12, boolean z11, int i13, int i14) {
        int i15 = z11 ? -1 : 1;
        int i16 = i13;
        for (int i17 = 0; i17 < 2; i17++) {
            while (true) {
                if (!z11) {
                    if (i16 >= i12) {
                        break;
                    }
                    if (z11 == bVar.g(i16, i14)) {
                        break;
                        break;
                    }
                    if (Math.abs(i13 - i16) > 2) {
                        return i13;
                    }
                    i16 += i15;
                } else {
                    if (i16 < i11) {
                        break;
                    }
                    if (z11 == bVar.g(i16, i14)) {
                        break;
                    }
                    if (Math.abs(i13 - i16) > 2) {
                        return i13;
                    }
                    i16 += i15;
                }
            }
            i15 = -i15;
            z11 = !z11;
        }
        return i16;
    }

    public static boolean d(int i11, int i12, int i13) {
        return i12 + (-2) <= i11 && i11 <= i13 + 2;
    }

    public static int e(int[] iArr, int[] iArr2, int i11) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i11 / 2) + 3) && i11 >= 0 && i11 <= 512) {
            return f79026a.a(iArr, i11, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    public static b[][] f(e eVar) {
        int iC;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, eVar.l(), eVar.j() + 2);
        for (b[] bVarArr2 : bVarArr) {
            int i11 = 0;
            while (true) {
                if (i11 < bVarArr2.length) {
                    bVarArr2[i11] = new b();
                    i11++;
                }
            }
        }
        int i12 = 0;
        for (f fVar : eVar.o()) {
            if (fVar != null) {
                for (d dVar : fVar.d()) {
                    if (dVar != null && (iC = dVar.c()) >= 0 && iC < bVarArr.length) {
                        bVarArr[iC][i12].b(dVar.e());
                    }
                }
            }
            i12++;
        }
        return bVarArr;
    }

    public static hm.d g(e eVar) throws NotFoundException, ChecksumException, FormatException {
        b[][] bVarArrF = f(eVar);
        b(eVar, bVarArrF);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[eVar.l() * eVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i11 = 0; i11 < eVar.l(); i11++) {
            int i12 = 0;
            while (i12 < eVar.j()) {
                int i13 = i12 + 1;
                int[] iArrA = bVarArrF[i11][i13].a();
                int iJ = (eVar.j() * i11) + i12;
                if (iArrA.length == 0) {
                    arrayList.add(Integer.valueOf(iJ));
                } else if (iArrA.length == 1) {
                    iArr[iJ] = iArrA[0];
                } else {
                    arrayList3.add(Integer.valueOf(iJ));
                    arrayList2.add(iArrA);
                }
                i12 = i13;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i14 = 0; i14 < size; i14++) {
            iArr2[i14] = (int[]) arrayList2.get(i14);
        }
        return h(eVar.k(), iArr, um.a.b(arrayList), um.a.b(arrayList3), iArr2);
    }

    public static hm.d h(int i11, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws ChecksumException, FormatException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i12 = 100;
        while (true) {
            int i13 = i12 - 1;
            if (i12 <= 0) {
                throw ChecksumException.getChecksumInstance();
            }
            for (int i14 = 0; i14 < length; i14++) {
                iArr[iArr3[i14]] = iArr4[i14][iArr5[i14]];
            }
            try {
                return j(iArr, i11, iArr2);
            } catch (ChecksumException unused) {
                if (length == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                for (int i15 = 0; i15 < length; i15++) {
                    int i16 = iArr5[i15];
                    if (i16 < iArr4[i15].length - 1) {
                        iArr5[i15] = i16 + 1;
                        break;
                    }
                    iArr5[i15] = 0;
                    if (i15 == length - 1) {
                        throw ChecksumException.getChecksumInstance();
                    }
                }
                i12 = i13;
            }
        }
    }

    public static hm.d i(hm.b bVar, k kVar, k kVar2, k kVar3, k kVar4, int i11, int i12) throws NotFoundException, ChecksumException, FormatException {
        int i13;
        int i14;
        f fVar;
        g gVarS = null;
        g gVarS2 = null;
        c cVar = new c(bVar, kVar, kVar2, kVar3, kVar4);
        boolean z11 = true;
        while (true) {
            if (kVar != null) {
                gVarS = s(bVar, cVar, kVar, true, i11, i12);
            }
            if (kVar3 != null) {
                gVarS2 = s(bVar, cVar, kVar3, false, i11, i12);
            }
            e eVarV = v(gVarS, gVarS2);
            if (eVarV == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            c cVarM = eVarV.m();
            if (!z11 || cVarM == null || (cVarM.g() >= cVar.g() && cVarM.e() <= cVar.e())) {
                eVarV.p(cVar);
                int iJ = eVarV.j() + 1;
                eVarV.q(0, gVarS);
                eVarV.q(iJ, gVarS2);
                boolean z12 = gVarS != null;
                int iMin = i11;
                int iMax = i12;
                for (int i15 = 1; i15 <= iJ; i15++) {
                    int i16 = z12 ? i15 : iJ - i15;
                    if (eVarV.n(i16) == null) {
                        f gVar = (i16 == 0 || i16 == iJ) ? new g(cVar, i16 == 0) : new f(cVar);
                        eVarV.q(i16, gVar);
                        int i17 = -1;
                        int iG = cVar.g();
                        int i18 = -1;
                        while (iG <= cVar.e()) {
                            int iT = t(eVarV, i16, iG, z12);
                            if (iT < 0 || iT > cVar.d()) {
                                if (i18 == i17) {
                                    i14 = iG;
                                    fVar = gVar;
                                } else {
                                    i13 = i18;
                                }
                                i18 = i18;
                                iG = i14 + 1;
                                gVar = fVar;
                                i17 = -1;
                            } else {
                                i13 = iT;
                            }
                            int i19 = iG;
                            fVar = gVar;
                            d dVarK = k(bVar, cVar.f(), cVar.d(), z12, i13, i19, iMin, iMax);
                            i14 = i19;
                            if (dVarK != null) {
                                fVar.f(i14, dVarK);
                                iMin = Math.min(iMin, dVarK.f());
                                iMax = Math.max(iMax, dVarK.f());
                                i18 = i13;
                            } else {
                                i18 = i18;
                            }
                            iG = i14 + 1;
                            gVar = fVar;
                            i17 = -1;
                        }
                    }
                }
                return g(eVarV);
            }
            cVar = cVarM;
            z11 = false;
        }
    }

    public static hm.d j(int[] iArr, int i11, int[] iArr2) throws ChecksumException, FormatException {
        if (iArr.length == 0) {
            throw FormatException.getFormatInstance();
        }
        int i12 = 1 << (i11 + 1);
        int iE = e(iArr, iArr2, i12);
        w(iArr, i12);
        hm.d dVarB = DecodedBitStreamParser.b(iArr, String.valueOf(i11));
        dVarB.n(Integer.valueOf(iE));
        dVarB.m(Integer.valueOf(iArr2.length));
        return dVarB;
    }

    public static d k(hm.b bVar, int i11, int i12, boolean z11, int i13, int i14, int i15, int i16) {
        int i17;
        int iD;
        int iA;
        int iC = c(bVar, i11, i12, z11, i13, i14);
        int[] iArrQ = q(bVar, i11, i12, z11, iC, i14);
        if (iArrQ == null) {
            return null;
        }
        int iD2 = im.a.d(iArrQ);
        if (z11) {
            i17 = iC + iD2;
        } else {
            for (int i18 = 0; i18 < iArrQ.length / 2; i18++) {
                int i19 = iArrQ[i18];
                iArrQ[i18] = iArrQ[(iArrQ.length - 1) - i18];
                iArrQ[(iArrQ.length - 1) - i18] = i19;
            }
            iC -= iD2;
            i17 = iC;
        }
        if (d(iD2, i15, i16) && (iA = um.a.a((iD = h.d(iArrQ)))) != -1) {
            return new d(iC, i17, n(iD), iA);
        }
        return null;
    }

    public static a l(g gVar, g gVar2) {
        a aVarI;
        a aVarI2;
        if (gVar == null || (aVarI = gVar.i()) == null) {
            if (gVar2 == null) {
                return null;
            }
            return gVar2.i();
        }
        if (gVar2 == null || (aVarI2 = gVar2.i()) == null || aVarI.a() == aVarI2.a() || aVarI.b() == aVarI2.b() || aVarI.c() == aVarI2.c()) {
            return aVarI;
        }
        return null;
    }

    public static int[] m(int i11) {
        int[] iArr = new int[8];
        int i12 = 0;
        int i13 = 7;
        while (true) {
            int i14 = i11 & 1;
            if (i14 != i12) {
                i13--;
                if (i13 < 0) {
                    return iArr;
                }
                i12 = i14;
            }
            iArr[i13] = iArr[i13] + 1;
            i11 >>= 1;
        }
    }

    public static int n(int i11) {
        return o(m(i11));
    }

    public static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    public static int p(int[] iArr) {
        int iMax = -1;
        for (int i11 : iArr) {
            iMax = Math.max(iMax, i11);
        }
        return iMax;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0013 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    /* JADX WARN: Code duplicated, block: B:28:0x0027 A[EDGE_INSN: B:28:0x0027->B:16:0x0027 BREAK  A[LOOP:0: B:7:0x000c->B:31:0x000c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x001b A[SYNTHETIC] */
    public static int[] q(hm.b bVar, int i11, int i12, boolean z11, int i13, int i14) {
        int[] iArr = new int[8];
        int i15 = z11 ? 1 : -1;
        int i16 = 0;
        boolean z12 = z11;
        while (true) {
            if (!z11) {
                if (i13 < i11) {
                    break;
                }
                if (i16 < 8) {
                    break;
                    break;
                }
                if (bVar.g(i13, i14) == z12) {
                    iArr[i16] = iArr[i16] + 1;
                    i13 += i15;
                } else {
                    i16++;
                    z12 = !z12;
                }
            } else {
                if (i13 >= i12) {
                    break;
                }
                if (i16 < 8) {
                    break;
                }
                if (bVar.g(i13, i14) == z12) {
                    iArr[i16] = iArr[i16] + 1;
                    i13 += i15;
                } else {
                    i16++;
                    z12 = !z12;
                }
            }
        }
        if (i16 != 8) {
            if (z11) {
                i11 = i12;
            }
            if (i13 != i11 || i16 != 7) {
                return null;
            }
        }
        return iArr;
    }

    public static int r(int i11) {
        return 2 << i11;
    }

    public static g s(hm.b bVar, c cVar, k kVar, boolean z11, int i11, int i12) {
        g gVar = new g(cVar, z11);
        int i13 = 0;
        while (i13 < 2) {
            int i14 = i13 == 0 ? 1 : -1;
            int iC = (int) kVar.c();
            for (int iD = (int) kVar.d(); iD <= cVar.e() && iD >= cVar.g(); iD += i14) {
                d dVarK = k(bVar, 0, bVar.n(), z11, iC, iD, i11, i12);
                if (dVarK != null) {
                    gVar.f(iD, dVarK);
                    iC = z11 ? dVarK.d() : dVarK.b();
                }
            }
            i13++;
        }
        return gVar;
    }

    public static int t(e eVar, int i11, int i12, boolean z11) {
        int i13 = z11 ? 1 : -1;
        int i14 = i11 - i13;
        d dVarB = u(eVar, i14) ? eVar.n(i14).b(i12) : null;
        if (dVarB != null) {
            return z11 ? dVarB.b() : dVarB.d();
        }
        d dVarC = eVar.n(i11).c(i12);
        if (dVarC != null) {
            return z11 ? dVarC.d() : dVarC.b();
        }
        if (u(eVar, i14)) {
            dVarC = eVar.n(i14).c(i12);
        }
        if (dVarC != null) {
            return z11 ? dVarC.b() : dVarC.d();
        }
        int i15 = 0;
        while (true) {
            i11 -= i13;
            if (!u(eVar, i11)) {
                c cVarM = eVar.m();
                return z11 ? cVarM.f() : cVarM.d();
            }
            for (d dVar : eVar.n(i11).d()) {
                if (dVar != null) {
                    return (z11 ? dVar.b() : dVar.d()) + (i13 * i15 * (dVar.b() - dVar.d()));
                }
            }
            i15++;
        }
    }

    public static boolean u(e eVar, int i11) {
        return i11 >= 0 && i11 <= eVar.j() + 1;
    }

    public static e v(g gVar, g gVar2) throws NotFoundException {
        a aVarL;
        if ((gVar == null && gVar2 == null) || (aVarL = l(gVar, gVar2)) == null) {
            return null;
        }
        return new e(aVarL, c.j(a(gVar), a(gVar2)));
    }

    public static void w(int[] iArr, int i11) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i12 = iArr[0];
        if (i12 > iArr.length) {
            throw FormatException.getFormatInstance();
        }
        if (i12 == 0) {
            if (i11 >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            iArr[0] = iArr.length - i11;
        }
    }
}
