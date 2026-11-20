package sm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.j;
import com.google.zxing.k;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;
import qm.q;
import rm.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d extends rm.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f76404k = {7, 5, 4, 3, 1};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f76405l = {4, 20, 52, 104, 204};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f76406m = {0, 348, 1388, 2948, 3988};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[][] f76407n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[][] f76408o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{PsExtractor.PRIVATE_STREAM_1, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, TsExtractor.TS_STREAM_TYPE_DTS, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, TsExtractor.TS_STREAM_TYPE_AC3, 176, 106, 107, Worker.WHAT_QUIT, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 179, 115}, new int[]{TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, PsExtractor.AUDIO_STREAM, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, WebSocketProtocol.PAYLOAD_SHORT, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{Worker.WHAT_SYNC_DATA, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, TsExtractor.TS_STREAM_TYPE_E_AC3, 194, 160, 58, 174, 100, 89}};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[][] f76409p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<b> f76410g = new ArrayList(11);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<c> f76411h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f76412i = new int[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f76413j;

    public static boolean A(rm.c cVar, boolean z11, boolean z12) {
        return (cVar.c() == 0 && z11 && z12) ? false : true;
    }

    public static boolean B(Iterable<b> iterable, Iterable<c> iterable2) {
        for (c cVar : iterable2) {
            for (b bVar : iterable) {
                Iterator<b> it = cVar.a().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (bVar.equals(it.next())) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean C(List<b> list) {
        for (int[] iArr : f76409p) {
            if (list.size() <= iArr.length) {
                for (int i11 = 0; i11 < list.size(); i11++) {
                    if (list.get(i11).a().c() == iArr[i11]) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void E(Collection<b> collection, Collection<c> collection2) {
        Iterator<c> it = collection2.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a().size() != collection.size()) {
                Iterator<b> it2 = next.a().iterator();
                do {
                    if (!it2.hasNext()) {
                        it.remove();
                        break;
                    }
                } while (collection.contains(it2.next()));
            }
        }
    }

    public static void G(int[] iArr) {
        int length = iArr.length;
        for (int i11 = 0; i11 < length / 2; i11++) {
            int i12 = iArr[i11];
            int i13 = (length - i11) - 1;
            iArr[i11] = iArr[i13];
            iArr[i13] = i12;
        }
    }

    public static j v(List<b> list) throws NotFoundException, FormatException {
        String strD = tm.j.a(a.a(list)).d();
        k[] kVarArrA = list.get(0).a().a();
        k[] kVarArrA2 = list.get(list.size() - 1).a().a();
        j jVar = new j(strD, null, new k[]{kVarArrA[0], kVarArrA[1], kVarArrA2[0], kVarArrA2[1]}, BarcodeFormat.RSS_EXPANDED);
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]e0");
        return jVar;
    }

    public static int z(hm.a aVar, int i11) {
        return aVar.h(i11) ? aVar.k(aVar.l(i11)) : aVar.l(aVar.k(i11));
    }

    public final rm.c D(hm.a aVar, int i11, boolean z11) {
        int i12;
        int i13;
        int i14;
        if (z11) {
            int i15 = this.f76412i[0] - 1;
            while (i15 >= 0 && !aVar.h(i15)) {
                i15--;
            }
            int i16 = i15 + 1;
            int[] iArr = this.f76412i;
            i14 = iArr[0] - i16;
            i12 = iArr[1];
            i13 = i16;
        } else {
            int[] iArr2 = this.f76412i;
            int i17 = iArr2[0];
            int iL = aVar.l(iArr2[1] + 1);
            i12 = iL;
            i13 = i17;
            i14 = iL - this.f76412i[1];
        }
        int[] iArrJ = j();
        System.arraycopy(iArrJ, 0, iArrJ, 1, iArrJ.length - 1);
        iArrJ[0] = i14;
        try {
            return new rm.c(rm.a.q(iArrJ, f76407n), new int[]{i13, i12}, i13, i12, i11);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public b F(hm.a aVar, List<b> list, int i11) throws NotFoundException {
        rm.c cVarD;
        rm.b bVarW;
        boolean z11 = list.size() % 2 == 0;
        if (this.f76413j) {
            z11 = !z11;
        }
        int iZ = -1;
        boolean z12 = true;
        do {
            y(aVar, list, iZ);
            cVarD = D(aVar, i11, z11);
            if (cVarD == null) {
                iZ = z(aVar, this.f76412i[0]);
            } else {
                z12 = false;
            }
        } while (z12);
        rm.b bVarW2 = w(aVar, cVarD, z11, true);
        if (!list.isEmpty() && list.get(list.size() - 1).d()) {
            throw NotFoundException.getNotFoundInstance();
        }
        try {
            bVarW = w(aVar, cVarD, z11, false);
        } catch (NotFoundException unused) {
            bVarW = null;
        }
        return new b(bVarW2, bVarW, cVarD);
    }

    public final void H(int i11) {
        int i12 = 0;
        boolean zC = false;
        while (i12 < this.f76411h.size()) {
            c cVar = this.f76411h.get(i12);
            if (cVar.b() > i11) {
                if (!cVar.c(this.f76410g)) {
                    break;
                } else {
                    return;
                }
            } else {
                zC = cVar.c(this.f76410g);
                i12++;
            }
        }
        if (zC || B(this.f76410g, this.f76411h)) {
            return;
        }
        this.f76411h.add(i12, new c(this.f76410g, i11));
        E(this.f76410g, this.f76411h);
    }

    @Override // qm.q
    public j c(int i11, hm.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.f76410g.clear();
        this.f76413j = false;
        try {
            return v(x(i11, aVar));
        } catch (NotFoundException unused) {
            this.f76410g.clear();
            this.f76413j = true;
            return v(x(i11, aVar));
        }
    }

    public final void r(int i11) throws NotFoundException {
        boolean z11;
        boolean z12;
        boolean z13;
        int iD = im.a.d(m());
        int iD2 = im.a.d(k());
        boolean z14 = true;
        if (iD > 13) {
            z14 = false;
            z11 = true;
        } else {
            z14 = iD < 4;
            z11 = false;
        }
        if (iD2 > 13) {
            z12 = false;
            z13 = true;
        } else {
            z12 = iD2 < 4;
            z13 = false;
        }
        int i12 = (iD + iD2) - i11;
        boolean z15 = (iD & 1) == 1;
        boolean z16 = (iD2 & 1) == 0;
        if (i12 != -1) {
            if (i12 != 0) {
                if (i12 != 1) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z15) {
                    if (z16) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z11 = true;
                } else {
                    if (!z16) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z14 = z14;
                    z13 = true;
                }
            } else if (z15) {
                if (!z16) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (iD < iD2) {
                    z13 = true;
                } else {
                    z12 = true;
                    z11 = true;
                }
            } else {
                if (z16) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z14 = z14;
            }
        } else if (z15) {
            if (z16) {
                throw NotFoundException.getNotFoundInstance();
            }
        } else {
            if (!z16) {
                throw NotFoundException.getNotFoundInstance();
            }
            z14 = z14;
            z12 = true;
        }
        if (z14) {
            if (z11) {
                throw NotFoundException.getNotFoundInstance();
            }
            rm.a.o(m(), n());
        }
        if (z11) {
            rm.a.h(m(), n());
        }
        if (z12) {
            if (z13) {
                throw NotFoundException.getNotFoundInstance();
            }
            rm.a.o(k(), n());
        }
        if (z13) {
            rm.a.h(k(), l());
        }
    }

    @Override // qm.q, com.google.zxing.i
    public void reset() {
        this.f76410g.clear();
        this.f76411h.clear();
    }

    public final boolean s() {
        b bVar = this.f76410g.get(0);
        rm.b bVarB = bVar.b();
        rm.b bVarC = bVar.c();
        if (bVarC == null) {
            return false;
        }
        int iA = bVarC.a();
        int i11 = 2;
        for (int i12 = 1; i12 < this.f76410g.size(); i12++) {
            b bVar2 = this.f76410g.get(i12);
            iA += bVar2.b().a();
            int i13 = i11 + 1;
            rm.b bVarC2 = bVar2.c();
            if (bVarC2 != null) {
                iA += bVarC2.a();
                i11 += 2;
            } else {
                i11 = i13;
            }
        }
        return ((i11 + (-4)) * 211) + (iA % 211) == bVarB.b();
    }

    public final List<b> t(List<c> list, int i11) throws NotFoundException {
        while (i11 < this.f76411h.size()) {
            c cVar = this.f76411h.get(i11);
            this.f76410g.clear();
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                this.f76410g.addAll(it.next().a());
            }
            this.f76410g.addAll(cVar.a());
            if (C(this.f76410g)) {
                if (s()) {
                    return this.f76410g;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(cVar);
                try {
                    return t(arrayList, i11 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i11++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final List<b> u(boolean z11) {
        List<b> listT = null;
        if (this.f76411h.size() > 25) {
            this.f76411h.clear();
            return null;
        }
        this.f76410g.clear();
        if (z11) {
            Collections.reverse(this.f76411h);
        }
        try {
            listT = t(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z11) {
            Collections.reverse(this.f76411h);
        }
        return listT;
    }

    public rm.b w(hm.a aVar, rm.c cVar, boolean z11, boolean z12) throws NotFoundException {
        int[] iArrI = i();
        Arrays.fill(iArrI, 0);
        if (z12) {
            q.g(aVar, cVar.b()[0], iArrI);
        } else {
            q.f(aVar, cVar.b()[1], iArrI);
            int i11 = 0;
            for (int length = iArrI.length - 1; i11 < length; length--) {
                int i12 = iArrI[i11];
                iArrI[i11] = iArrI[length];
                iArrI[length] = i12;
                i11++;
            }
        }
        float fD = im.a.d(iArrI) / 17;
        float f11 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(fD - f11) / f11 > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int[] iArrM = m();
        int[] iArrK = k();
        float[] fArrN = n();
        float[] fArrL = l();
        for (int i13 = 0; i13 < iArrI.length; i13++) {
            float f12 = (iArrI[i13] * 1.0f) / fD;
            int i14 = (int) (0.5f + f12);
            if (i14 < 1) {
                if (f12 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i14 = 1;
            } else if (i14 > 8) {
                if (f12 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i14 = 8;
            }
            int i15 = i13 / 2;
            if ((i13 & 1) == 0) {
                iArrM[i15] = i14;
                fArrN[i15] = f12 - i14;
            } else {
                iArrK[i15] = i14;
                fArrL[i15] = f12 - i14;
            }
        }
        r(17);
        int iC = (((cVar.c() * 4) + (z11 ? 0 : 2)) + (!z12 ? 1 : 0)) - 1;
        int i16 = 0;
        int i17 = 0;
        for (int length2 = iArrM.length - 1; length2 >= 0; length2--) {
            if (A(cVar, z11, z12)) {
                i16 += iArrM[length2] * f76408o[iC][length2 * 2];
            }
            i17 += iArrM[length2];
        }
        int i18 = 0;
        for (int length3 = iArrK.length - 1; length3 >= 0; length3--) {
            if (A(cVar, z11, z12)) {
                i18 += iArrK[length3] * f76408o[iC][(length3 * 2) + 1];
            }
        }
        int i19 = i16 + i18;
        if ((i17 & 1) != 0 || i17 > 13 || i17 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i21 = (13 - i17) / 2;
        int i22 = f76404k[i21];
        return new rm.b((f.b(iArrM, i22, true) * f76405l[i21]) + f.b(iArrK, 9 - i22, false) + f76406m[i21], i19);
    }

    public List<b> x(int i11, hm.a aVar) throws NotFoundException {
        boolean z11 = false;
        while (!z11) {
            try {
                List<b> list = this.f76410g;
                list.add(F(aVar, list, i11));
            } catch (NotFoundException e11) {
                if (this.f76410g.isEmpty()) {
                    throw e11;
                }
                z11 = true;
            }
        }
        if (s()) {
            return this.f76410g;
        }
        boolean z12 = !this.f76411h.isEmpty();
        H(i11);
        if (z12) {
            List<b> listU = u(false);
            if (listU != null) {
                return listU;
            }
            List<b> listU2 = u(true);
            if (listU2 != null) {
                return listU2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void y(hm.a aVar, List<b> list, int i11) throws NotFoundException {
        int[] iArrJ = j();
        iArrJ[0] = 0;
        iArrJ[1] = 0;
        iArrJ[2] = 0;
        iArrJ[3] = 0;
        int iM = aVar.m();
        if (i11 < 0) {
            i11 = list.isEmpty() ? 0 : list.get(list.size() - 1).a().b()[1];
        }
        boolean z11 = list.size() % 2 != 0;
        if (this.f76413j) {
            z11 = !z11;
        }
        boolean z12 = false;
        while (i11 < iM) {
            z12 = !aVar.h(i11);
            if (!z12) {
                break;
            } else {
                i11++;
            }
        }
        boolean z13 = z12;
        int i12 = 0;
        int i13 = i11;
        while (i11 < iM) {
            if (aVar.h(i11) != z13) {
                iArrJ[i12] = iArrJ[i12] + 1;
            } else {
                if (i12 == 3) {
                    if (z11) {
                        G(iArrJ);
                    }
                    if (rm.a.p(iArrJ)) {
                        int[] iArr = this.f76412i;
                        iArr[0] = i13;
                        iArr[1] = i11;
                        return;
                    }
                    if (z11) {
                        G(iArrJ);
                    }
                    i13 += iArrJ[0] + iArrJ[1];
                    iArrJ[0] = iArrJ[2];
                    iArrJ[1] = iArrJ[3];
                    iArrJ[2] = 0;
                    iArrJ[3] = 0;
                    i12--;
                } else {
                    i12++;
                }
                iArrJ[i12] = 1;
                z13 = !z13;
            }
            i11++;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
