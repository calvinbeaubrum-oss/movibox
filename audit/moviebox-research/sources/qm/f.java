package qm;

import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.logging.type.LogSeverity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;
import org.apache.tools.zip.UnixStat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f extends q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f74819c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f74820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f74821e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f74822a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f74823b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, UnixStat.DEFAULT_FILE_PERM, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, LogSeverity.NOTICE_VALUE, 278, 436, 434, 428, 422, 406, TTAdConstant.IMAGE_LIST_SIZE_CODE, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f74820d = iArr;
        f74821e = iArr[47];
    }

    public static void h(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        i(charSequence, length - 2, 20);
        i(charSequence, length - 1, 15);
    }

    public static void i(CharSequence charSequence, int i11, int i12) throws ChecksumException {
        int iIndexOf = 0;
        int i13 = 1;
        for (int i14 = i11 - 1; i14 >= 0; i14--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i14)) * i13;
            i13++;
            if (i13 > i12) {
                i13 = 1;
            }
        }
        if (charSequence.charAt(i11) != f74819c[iIndexOf % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x002c  */
    private static String j(CharSequence charSequence) throws FormatException {
        int i11;
        char c11;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i12 = 0;
        while (i12 < length) {
            char cCharAt = charSequence.charAt(i12);
            if (cCharAt >= 'a' && cCharAt <= 'd') {
                if (i12 >= length - 1) {
                    throw FormatException.getFormatInstance();
                }
                i12++;
                char cCharAt2 = charSequence.charAt(i12);
                switch (cCharAt) {
                    case 'a':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        }
                        i11 = cCharAt2 - '@';
                        c11 = (char) i11;
                        sb2.append(c11);
                        break;
                    case 'b':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                            i11 = cCharAt2 - '&';
                        } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                            i11 = cCharAt2 - 11;
                        } else if (cCharAt2 < 'K' || cCharAt2 > 'O') {
                            if (cCharAt2 >= 'P' && cCharAt2 <= 'T') {
                                i11 = cCharAt2 + '+';
                            } else if (cCharAt2 == 'U') {
                                c11 = 0;
                            } else if (cCharAt2 == 'V') {
                                c11 = '@';
                            } else if (cCharAt2 == 'W') {
                                c11 = '`';
                            } else {
                                if (cCharAt2 < 'X' || cCharAt2 > 'Z') {
                                    throw FormatException.getFormatInstance();
                                }
                                c11 = Ascii.MAX;
                            }
                            sb2.append(c11);
                        } else {
                            i11 = cCharAt2 + 16;
                        }
                        c11 = (char) i11;
                        sb2.append(c11);
                        break;
                    case 'c':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                            i11 = cCharAt2 - ' ';
                            c11 = (char) i11;
                        } else {
                            if (cCharAt2 != 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            c11 = ':';
                        }
                        sb2.append(c11);
                        break;
                    case 'd':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        }
                        i11 = cCharAt2 + ' ';
                        c11 = (char) i11;
                        sb2.append(c11);
                        break;
                    default:
                        c11 = 0;
                        sb2.append(c11);
                        break;
                }
            } else {
                sb2.append(cCharAt);
            }
            i12++;
        }
        return sb2.toString();
    }

    private static char l(int i11) throws NotFoundException {
        int i12 = 0;
        while (true) {
            int[] iArr = f74820d;
            if (i12 >= iArr.length) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i12] == i11) {
                return f74819c[i12];
            }
            i12++;
        }
    }

    public static int m(int[] iArr) {
        int i11 = 0;
        for (int i12 : iArr) {
            i11 += i12;
        }
        int length = iArr.length;
        int i13 = 0;
        for (int i14 = 0; i14 < length; i14++) {
            int iRound = Math.round((iArr[i14] * 9.0f) / i11);
            if (iRound < 1 || iRound > 4) {
                return -1;
            }
            if ((i14 & 1) == 0) {
                for (int i15 = 0; i15 < iRound; i15++) {
                    i13 = (i13 << 1) | 1;
                }
            } else {
                i13 <<= iRound;
            }
        }
        return i13;
    }

    @Override // qm.q
    public com.google.zxing.j c(int i11, hm.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] iArrK = k(aVar);
        int iK = aVar.k(iArrK[1]);
        int iM = aVar.m();
        int[] iArr = this.f74823b;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f74822a;
        sb2.setLength(0);
        while (true) {
            q.f(aVar, iK, iArr);
            int iM2 = m(iArr);
            if (iM2 < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char cL = l(iM2);
            sb2.append(cL);
            int i12 = iK;
            for (int i13 : iArr) {
                i12 += i13;
            }
            int iK2 = aVar.k(i12);
            if (cL == '*') {
                sb2.deleteCharAt(sb2.length() - 1);
                int i14 = 0;
                for (int i15 : iArr) {
                    i14 += i15;
                }
                if (iK2 == iM || !aVar.h(iK2)) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sb2.length() < 2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                h(sb2);
                sb2.setLength(sb2.length() - 2);
                float f11 = i11;
                com.google.zxing.j jVar = new com.google.zxing.j(j(sb2), null, new com.google.zxing.k[]{new com.google.zxing.k((iArrK[1] + iArrK[0]) / 2.0f, f11), new com.google.zxing.k(iK + (i14 / 2.0f), f11)}, BarcodeFormat.CODE_93);
                jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]G0");
                return jVar;
            }
            iK = iK2;
        }
    }

    public final int[] k(hm.a aVar) throws NotFoundException {
        int iM = aVar.m();
        int iK = aVar.k(0);
        Arrays.fill(this.f74823b, 0);
        int[] iArr = this.f74823b;
        int length = iArr.length;
        int i11 = iK;
        boolean z11 = false;
        int i12 = 0;
        while (iK < iM) {
            if (aVar.h(iK) != z11) {
                iArr[i12] = iArr[i12] + 1;
            } else {
                if (i12 != length - 1) {
                    i12++;
                } else {
                    if (m(iArr) == f74821e) {
                        return new int[]{i11, iK};
                    }
                    i11 += iArr[0] + iArr[1];
                    int i13 = i12 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i13);
                    iArr[i13] = 0;
                    iArr[i12] = 0;
                    i12--;
                }
                iArr[i12] = 1;
                z11 = !z11;
            }
            iK++;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
