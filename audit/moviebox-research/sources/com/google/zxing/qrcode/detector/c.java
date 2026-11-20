package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.k;
import com.google.zxing.l;
import hm.f;
import hm.n;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hm.b f41573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f41574b;

    public c(hm.b bVar) {
        this.f41573a = bVar;
    }

    public static int c(k kVar, k kVar2, k kVar3, float f11) throws NotFoundException {
        int iC = (im.a.c(k.b(kVar, kVar2) / f11) + im.a.c(k.b(kVar, kVar3) / f11)) / 2;
        int i11 = iC + 7;
        int i12 = i11 & 3;
        if (i12 == 0) {
            return iC + 8;
        }
        if (i12 == 2) {
            return iC + 6;
        }
        if (i12 != 3) {
            return i11;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static n d(k kVar, k kVar2, k kVar3, k kVar4, int i11) {
        float fC;
        float fD;
        float f11;
        float f12 = i11 - 3.5f;
        if (kVar4 != null) {
            fC = kVar4.c();
            fD = kVar4.d();
            f11 = f12 - 3.0f;
        } else {
            fC = (kVar2.c() - kVar.c()) + kVar3.c();
            fD = (kVar2.d() - kVar.d()) + kVar3.d();
            f11 = f12;
        }
        return n.b(3.5f, 3.5f, f12, 3.5f, f11, f11, 3.5f, f12, kVar.c(), kVar.d(), kVar2.c(), kVar2.d(), fC, fD, kVar3.c(), kVar3.d());
    }

    public static hm.b h(hm.b bVar, n nVar, int i11) throws NotFoundException {
        return hm.k.b().d(bVar, i11, i11, nVar);
    }

    public final float a(k kVar, k kVar2, k kVar3) {
        return (b(kVar, kVar2) + b(kVar, kVar3)) / 2.0f;
    }

    public final float b(k kVar, k kVar2) {
        float fJ = j((int) kVar.c(), (int) kVar.d(), (int) kVar2.c(), (int) kVar2.d());
        float fJ2 = j((int) kVar2.c(), (int) kVar2.d(), (int) kVar.c(), (int) kVar.d());
        if (Float.isNaN(fJ)) {
            return fJ2 / 7.0f;
        }
        return Float.isNaN(fJ2) ? fJ / 7.0f : (fJ + fJ2) / 14.0f;
    }

    public final f e(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.f41574b = map == null ? null : (l) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return g(new FinderPatternFinder(this.f41573a, this.f41574b).g(map));
    }

    public final a f(float f11, int i11, int i12, float f12) throws NotFoundException {
        int i13 = (int) (f12 * f11);
        int iMax = Math.max(0, i11 - i13);
        int iMin = Math.min(this.f41573a.n() - 1, i11 + i13) - iMax;
        float f13 = 3.0f * f11;
        if (iMin < f13) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iMax2 = Math.max(0, i12 - i13);
        int iMin2 = Math.min(this.f41573a.k() - 1, i12 + i13) - iMax2;
        if (iMin2 >= f13) {
            return new b(this.f41573a, iMax, iMax2, iMin, iMin2, f11, this.f41574b).c();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final f g(e eVar) throws NotFoundException, FormatException {
        a aVarF;
        d dVarB = eVar.b();
        d dVarC = eVar.c();
        d dVarA = eVar.a();
        float fA = a(dVarB, dVarC, dVarA);
        if (fA < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iC = c(dVarB, dVarC, dVarA, fA);
        an.f fVarG = an.f.g(iC);
        int iE = fVarG.e() - 7;
        if (fVarG.d().length <= 0) {
            aVarF = null;
            break;
        }
        float fC = (dVarC.c() - dVarB.c()) + dVarA.c();
        float fD = (dVarC.d() - dVarB.d()) + dVarA.d();
        float f11 = 1.0f - (3.0f / iE);
        int iC2 = (int) (dVarB.c() + ((fC - dVarB.c()) * f11));
        int iD = (int) (dVarB.d() + (f11 * (fD - dVarB.d())));
        int i11 = 4;
        while (true) {
            if (i11 > 16) {
                aVarF = null;
                break;
            }
            try {
                aVarF = f(fA, iC2, iD, i11);
                break;
            } catch (NotFoundException unused) {
                i11 <<= 1;
            }
        }
        return new f(h(this.f41573a, d(dVarB, dVarC, dVarA, aVarF, iC), iC), aVarF == null ? new k[]{dVarA, dVarB, dVarC} : new k[]{dVarA, dVarB, dVarC, aVarF});
    }

    public final float i(int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19 = 1;
        boolean z11 = Math.abs(i14 - i12) > Math.abs(i13 - i11);
        if (z11) {
            i16 = i11;
            i15 = i12;
            i18 = i13;
            i17 = i14;
        } else {
            i15 = i11;
            i16 = i12;
            i17 = i13;
            i18 = i14;
        }
        int iAbs = Math.abs(i17 - i15);
        int iAbs2 = Math.abs(i18 - i16);
        int i21 = (-iAbs) / 2;
        int i22 = i15 < i17 ? 1 : -1;
        int i23 = i16 < i18 ? 1 : -1;
        int i24 = i17 + i22;
        int i25 = i15;
        int i26 = i16;
        int i27 = 0;
        while (true) {
            if (i25 == i24) {
                i24 = i24;
                break;
            }
            if ((i27 == i19) == this.f41573a.g(z11 ? i26 : i25, z11 ? i25 : i26)) {
                if (i27 == 2) {
                    return im.a.b(i25, i26, i15, i16);
                }
                i27++;
            }
            i21 += iAbs2;
            if (i21 > 0) {
                if (i26 == i18) {
                    break;
                }
                i26 += i23;
                i21 -= iAbs;
            }
            i25 += i22;
            i24 = i24;
            z11 = z11;
            i19 = 1;
        }
        if (i27 == 2) {
            return im.a.b(i24, i18, i15, i16);
        }
        return Float.NaN;
    }

    public final float j(int i11, int i12, int i13, int i14) {
        float fN;
        float fK;
        float fI = i(i11, i12, i13, i14);
        int iN = i11 - (i13 - i11);
        int iK = 0;
        if (iN < 0) {
            fN = i11 / (i11 - iN);
            iN = 0;
        } else if (iN >= this.f41573a.n()) {
            fN = ((this.f41573a.n() - 1) - i11) / (iN - i11);
            iN = this.f41573a.n() - 1;
        } else {
            fN = 1.0f;
        }
        float f11 = i12;
        int i15 = (int) (f11 - ((i14 - i12) * fN));
        if (i15 < 0) {
            fK = f11 / (i12 - i15);
        } else if (i15 >= this.f41573a.k()) {
            fK = ((this.f41573a.k() - 1) - i12) / (i15 - i12);
            iK = this.f41573a.k() - 1;
        } else {
            iK = i15;
            fK = 1.0f;
        }
        return (fI + i(i11, i12, (int) (i11 + ((iN - i11) * fK)), iK)) - 1.0f;
    }
}
