package rm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;
import qm.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f75633i = {1, 10, 34, 70, WebSocketProtocol.PAYLOAD_SHORT};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f75634j = {4, 20, 48, 81};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f75635k = {0, 161, 961, 2015, 2715};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f75636l = {0, 336, 1036, 1516};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f75637m = {8, 6, 4, 3, 1};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f75638n = {2, 4, 6, 8};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[][] f75639o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<d> f75640g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<d> f75641h = new ArrayList();

    public static void r(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        for (d dVar2 : collection) {
            if (dVar2.b() == dVar.b()) {
                dVar2.e();
                return;
            }
        }
        collection.add(dVar);
    }

    public static boolean t(d dVar, d dVar2) {
        int iA = (dVar.a() + (dVar2.a() * 16)) % 79;
        int iC = (dVar.d().c() * 9) + dVar2.d().c();
        if (iC > 72) {
            iC--;
        }
        if (iC > 8) {
            iC--;
        }
        return iA == iC;
    }

    public static j u(d dVar, d dVar2) {
        String strValueOf = String.valueOf((((long) dVar.b()) * 4537077) + ((long) dVar2.b()));
        StringBuilder sb2 = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb2.append('0');
        }
        sb2.append(strValueOf);
        int i11 = 0;
        for (int i12 = 0; i12 < 13; i12++) {
            int iCharAt = sb2.charAt(i12) - '0';
            if ((i12 & 1) == 0) {
                iCharAt *= 3;
            }
            i11 += iCharAt;
        }
        int i13 = 10 - (i11 % 10);
        if (i13 == 10) {
            i13 = 0;
        }
        sb2.append(i13);
        k[] kVarArrA = dVar.d().a();
        k[] kVarArrA2 = dVar2.d().a();
        j jVar = new j(sb2.toString(), null, new k[]{kVarArrA[0], kVarArrA[1], kVarArrA2[0], kVarArrA2[1]}, BarcodeFormat.RSS_14);
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]e0");
        return jVar;
    }

    @Override // qm.q
    public j c(int i11, hm.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        r(this.f75640g, w(aVar, false, i11, map));
        aVar.q();
        r(this.f75641h, w(aVar, true, i11, map));
        aVar.q();
        for (d dVar : this.f75640g) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f75641h) {
                    if (dVar2.c() > 1 && t(dVar, dVar2)) {
                        return u(dVar, dVar2);
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // qm.q, com.google.zxing.i
    public void reset() {
        this.f75640g.clear();
        this.f75641h.clear();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0025 A[PHI: r6 r7
  0x0025: PHI (r6v9 boolean) = (r6v3 boolean), (r6v13 boolean) binds: [B:26:0x0040, B:11:0x0023] A[DONT_GENERATE, DONT_INLINE]
  0x0025: PHI (r7v9 boolean) = (r7v1 boolean), (r7v11 boolean) binds: [B:26:0x0040, B:11:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x002a A[PHI: r6 r7
  0x002a: PHI (r6v7 boolean) = (r6v3 boolean), (r6v13 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]
  0x002a: PHI (r7v5 boolean) = (r7v1 boolean), (r7v11 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:16:0x002d A[PHI: r6 r7
  0x002d: PHI (r6v5 boolean) = (r6v3 boolean), (r6v13 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]
  0x002d: PHI (r7v3 boolean) = (r7v1 boolean), (r7v11 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    public final void s(boolean z11, int i11) throws NotFoundException {
        boolean z12;
        boolean z13;
        boolean z14;
        int iD = im.a.d(m());
        int iD2 = im.a.d(k());
        boolean z15 = true;
        if (z11) {
            if (iD > 12) {
                z15 = false;
                z12 = true;
            } else {
                z15 = iD < 4;
                z12 = false;
            }
            if (iD2 > 12) {
                z13 = false;
                z14 = true;
            } else {
                if (iD2 < 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = false;
            }
        } else {
            if (iD > 11) {
                z15 = false;
                z12 = true;
            } else {
                z15 = iD < 5;
                z12 = false;
            }
            if (iD2 > 10) {
                z13 = false;
                z14 = true;
            } else {
                if (iD2 < 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = false;
            }
        }
        int i12 = (iD + iD2) - i11;
        boolean z16 = (iD & 1) == z11;
        boolean z17 = (iD2 & 1) == 1;
        if (i12 != -1) {
            if (i12 != 0) {
                if (i12 != 1) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z16) {
                    if (z17) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z12 = true;
                } else {
                    if (!z17) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z15 = z15;
                    z14 = true;
                }
            } else if (z16) {
                if (!z17) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (iD < iD2) {
                    z14 = true;
                } else {
                    z13 = true;
                    z12 = true;
                }
            } else {
                if (z17) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z15 = z15;
            }
        } else if (z16) {
            if (z17) {
                throw NotFoundException.getNotFoundInstance();
            }
        } else {
            if (!z17) {
                throw NotFoundException.getNotFoundInstance();
            }
            z15 = z15;
            z13 = true;
        }
        if (z15) {
            if (z12) {
                throw NotFoundException.getNotFoundInstance();
            }
            a.o(m(), n());
        }
        if (z12) {
            a.h(m(), n());
        }
        if (z13) {
            if (z14) {
                throw NotFoundException.getNotFoundInstance();
            }
            a.o(k(), n());
        }
        if (z14) {
            a.h(k(), l());
        }
    }

    public final b v(hm.a aVar, c cVar, boolean z11) throws NotFoundException {
        int[] iArrI = i();
        Arrays.fill(iArrI, 0);
        if (z11) {
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
        int i13 = z11 ? 16 : 15;
        float fD = im.a.d(iArrI) / i13;
        int[] iArrM = m();
        int[] iArrK = k();
        float[] fArrN = n();
        float[] fArrL = l();
        for (int i14 = 0; i14 < iArrI.length; i14++) {
            float f11 = iArrI[i14] / fD;
            int i15 = (int) (0.5f + f11);
            if (i15 < 1) {
                i15 = 1;
            } else if (i15 > 8) {
                i15 = 8;
            }
            int i16 = i14 / 2;
            if ((i14 & 1) == 0) {
                iArrM[i16] = i15;
                fArrN[i16] = f11 - i15;
            } else {
                iArrK[i16] = i15;
                fArrL[i16] = f11 - i15;
            }
        }
        s(z11, i13);
        int i17 = 0;
        int i18 = 0;
        for (int length2 = iArrM.length - 1; length2 >= 0; length2--) {
            int i19 = iArrM[length2];
            i17 = (i17 * 9) + i19;
            i18 += i19;
        }
        int i21 = 0;
        int i22 = 0;
        for (int length3 = iArrK.length - 1; length3 >= 0; length3--) {
            int i23 = iArrK[length3];
            i21 = (i21 * 9) + i23;
            i22 += i23;
        }
        int i24 = i17 + (i21 * 3);
        if (!z11) {
            if ((i22 & 1) != 0 || i22 > 10 || i22 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i25 = (10 - i22) / 2;
            int i26 = f75638n[i25];
            return new b((f.b(iArrK, 9 - i26, false) * f75634j[i25]) + f.b(iArrM, i26, true) + f75636l[i25], i24);
        }
        if ((i18 & 1) != 0 || i18 > 12 || i18 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i27 = (12 - i18) / 2;
        int i28 = f75637m[i27];
        return new b((f.b(iArrM, i28, false) * f75633i[i27]) + f.b(iArrK, 9 - i28, true) + f75635k[i27], i24);
    }

    public final d w(hm.a aVar, boolean z11, int i11, Map<DecodeHintType, ?> map) {
        try {
            c cVarY = y(aVar, i11, z11, x(aVar, z11));
            l lVar = map == null ? null : (l) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (lVar != null) {
                int[] iArrB = cVarY.b();
                float fM = ((iArrB[0] + iArrB[1]) - 1) / 2.0f;
                if (z11) {
                    fM = (aVar.m() - 1) - fM;
                }
                lVar.a(new k(fM, i11));
            }
            b bVarV = v(aVar, cVarY, true);
            b bVarV2 = v(aVar, cVarY, false);
            return new d((bVarV.b() * 1597) + bVarV2.b(), bVarV.a() + (bVarV2.a() * 4), cVarY);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public final int[] x(hm.a aVar, boolean z11) throws NotFoundException {
        int[] iArrJ = j();
        iArrJ[0] = 0;
        iArrJ[1] = 0;
        iArrJ[2] = 0;
        iArrJ[3] = 0;
        int iM = aVar.m();
        int i11 = 0;
        boolean z12 = false;
        while (i11 < iM) {
            z12 = !aVar.h(i11);
            if (z11 == z12) {
                break;
            }
            i11++;
        }
        int i12 = i11;
        int i13 = 0;
        while (i11 < iM) {
            if (aVar.h(i11) != z12) {
                iArrJ[i13] = iArrJ[i13] + 1;
            } else {
                if (i13 != 3) {
                    i13++;
                } else {
                    if (a.p(iArrJ)) {
                        return new int[]{i12, i11};
                    }
                    i12 += iArrJ[0] + iArrJ[1];
                    iArrJ[0] = iArrJ[2];
                    iArrJ[1] = iArrJ[3];
                    iArrJ[2] = 0;
                    iArrJ[3] = 0;
                    i13--;
                }
                iArrJ[i13] = 1;
                z12 = !z12;
            }
            i11++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final c y(hm.a aVar, int i11, boolean z11, int[] iArr) throws NotFoundException {
        int iM;
        int i12;
        boolean zH = aVar.h(iArr[0]);
        int i13 = iArr[0] - 1;
        while (i13 >= 0 && zH != aVar.h(i13)) {
            i13--;
        }
        int i14 = i13 + 1;
        int i15 = iArr[0] - i14;
        int[] iArrJ = j();
        System.arraycopy(iArrJ, 0, iArrJ, 1, iArrJ.length - 1);
        iArrJ[0] = i15;
        int iQ = a.q(iArrJ, f75639o);
        int i16 = iArr[1];
        if (z11) {
            int iM2 = (aVar.m() - 1) - i14;
            iM = (aVar.m() - 1) - i16;
            i12 = iM2;
        } else {
            iM = i16;
            i12 = i14;
        }
        return new c(iQ, new int[]{i14, iArr[1]}, i12, iM, i11);
    }
}
