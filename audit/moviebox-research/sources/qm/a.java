package qm;

import com.google.android.gms.common.api.Api;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f74803d = "0123456789-$:/.+ABCD".toCharArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f74804e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final char[] f74805f = {'A', 'B', 'C', 'D'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f74806a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f74807b = new int[80];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f74808c = 0;

    public static boolean h(char[] cArr, char c11) {
        if (cArr != null) {
            for (char c12 : cArr) {
                if (c12 == c11) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // qm.q
    public com.google.zxing.j c(int i11, hm.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i12;
        Arrays.fill(this.f74807b, 0);
        k(aVar);
        int iJ = j();
        this.f74806a.setLength(0);
        int i13 = iJ;
        while (true) {
            int iL = l(i13);
            if (iL == -1) {
                throw NotFoundException.getNotFoundInstance();
            }
            this.f74806a.append((char) iL);
            i12 = i13 + 8;
            if ((this.f74806a.length() > 1 && h(f74805f, f74803d[iL])) || i12 >= this.f74808c) {
                break;
            }
            i13 = i12;
        }
        int i14 = i13 + 7;
        int i15 = this.f74807b[i14];
        int i16 = 0;
        for (int i17 = -8; i17 < -1; i17++) {
            i16 += this.f74807b[i12 + i17];
        }
        if (i12 < this.f74808c && i15 < i16 / 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        m(iJ);
        for (int i18 = 0; i18 < this.f74806a.length(); i18++) {
            StringBuilder sb2 = this.f74806a;
            sb2.setCharAt(i18, f74803d[sb2.charAt(i18)]);
        }
        char cCharAt = this.f74806a.charAt(0);
        char[] cArr = f74805f;
        if (!h(cArr, cCharAt)) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb3 = this.f74806a;
        if (!h(cArr, sb3.charAt(sb3.length() - 1))) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (this.f74806a.length() <= 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
            StringBuilder sb4 = this.f74806a;
            sb4.deleteCharAt(sb4.length() - 1);
            this.f74806a.deleteCharAt(0);
        }
        int i19 = 0;
        for (int i21 = 0; i21 < iJ; i21++) {
            i19 += this.f74807b[i21];
        }
        float f11 = i19;
        while (iJ < i14) {
            i19 += this.f74807b[iJ];
            iJ++;
        }
        float f12 = i11;
        com.google.zxing.j jVar = new com.google.zxing.j(this.f74806a.toString(), null, new com.google.zxing.k[]{new com.google.zxing.k(f11, f12), new com.google.zxing.k(i19, f12)}, BarcodeFormat.CODABAR);
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]F0");
        return jVar;
    }

    public final void i(int i11) {
        int[] iArr = this.f74807b;
        int i12 = this.f74808c;
        iArr[i12] = i11;
        int i13 = i12 + 1;
        this.f74808c = i13;
        if (i13 >= iArr.length) {
            int[] iArr2 = new int[i13 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i13);
            this.f74807b = iArr2;
        }
    }

    public final int j() throws NotFoundException {
        for (int i11 = 1; i11 < this.f74808c; i11 += 2) {
            int iL = l(i11);
            if (iL != -1 && h(f74805f, f74803d[iL])) {
                int i12 = 0;
                for (int i13 = i11; i13 < i11 + 7; i13++) {
                    i12 += this.f74807b[i13];
                }
                if (i11 == 1 || this.f74807b[i11 - 1] >= i12 / 2) {
                    return i11;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void k(hm.a aVar) throws NotFoundException {
        int i11 = 0;
        this.f74808c = 0;
        int iL = aVar.l(0);
        int iM = aVar.m();
        if (iL >= iM) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z11 = true;
        while (iL < iM) {
            if (aVar.h(iL) != z11) {
                i11++;
            } else {
                i(i11);
                z11 = !z11;
                i11 = 1;
            }
            iL++;
        }
        i(i11);
    }

    public final int l(int i11) {
        int i12 = i11 + 7;
        if (i12 >= this.f74808c) {
            return -1;
        }
        int[] iArr = this.f74807b;
        int i13 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i14 = 0;
        int i15 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i16 = 0;
        for (int i17 = i11; i17 < i12; i17 += 2) {
            int i18 = iArr[i17];
            if (i18 < i15) {
                i15 = i18;
            }
            if (i18 > i16) {
                i16 = i18;
            }
        }
        int i19 = (i15 + i16) / 2;
        int i21 = 0;
        for (int i22 = i11 + 1; i22 < i12; i22 += 2) {
            int i23 = iArr[i22];
            if (i23 < i13) {
                i13 = i23;
            }
            if (i23 > i21) {
                i21 = i23;
            }
        }
        int i24 = (i13 + i21) / 2;
        int i25 = 128;
        int i26 = 0;
        for (int i27 = 0; i27 < 7; i27++) {
            i25 >>= 1;
            if (iArr[i11 + i27] > ((i27 & 1) == 0 ? i19 : i24)) {
                i26 |= i25;
            }
        }
        while (true) {
            int[] iArr2 = f74804e;
            if (i14 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i14] == i26) {
                return i14;
            }
            i14++;
        }
    }

    public final void m(int i11) throws NotFoundException {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.f74806a.length() - 1;
        int i12 = i11;
        int i13 = 0;
        while (true) {
            if (i13 > length) {
                break;
            }
            int i14 = f74804e[this.f74806a.charAt(i13)];
            for (int i15 = 6; i15 >= 0; i15--) {
                int i16 = (i15 & 1) + ((i14 & 1) * 2);
                iArr[i16] = iArr[i16] + this.f74807b[i12 + i15];
                iArr2[i16] = iArr2[i16] + 1;
                i14 >>= 1;
            }
            i12 += 8;
            i13++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i17 = 0; i17 < 2; i17++) {
            fArr2[i17] = 0.0f;
            int i18 = i17 + 2;
            float f11 = iArr[i17] / iArr2[i17];
            int i19 = iArr[i18];
            int i21 = iArr2[i18];
            float f12 = (f11 + (i19 / i21)) / 2.0f;
            fArr2[i18] = f12;
            fArr[i17] = f12;
            fArr[i18] = ((i19 * 2.0f) + 1.5f) / i21;
        }
        int i22 = i11;
        for (int i23 = 0; i23 <= length; i23++) {
            int i24 = f74804e[this.f74806a.charAt(i23)];
            for (int i25 = 6; i25 >= 0; i25--) {
                int i26 = (i25 & 1) + ((i24 & 1) * 2);
                float f13 = this.f74807b[i22 + i25];
                if (f13 < fArr2[i26] || f13 > fArr[i26]) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i24 >>= 1;
            }
            i22 += 8;
        }
    }
}
