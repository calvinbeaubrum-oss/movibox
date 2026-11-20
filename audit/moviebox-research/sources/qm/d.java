package qm;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import com.google.logging.type.LogSeverity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d extends q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f74814e = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, LogSeverity.WARNING_VALUE, 208, 133, 388, 196, 168, 162, TsExtractor.TS_STREAM_TYPE_DTS, 42};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f74815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f74816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StringBuilder f74817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f74818d;

    public d() {
        this(false);
    }

    public d(boolean z11) {
        this(z11, false);
    }

    public d(boolean z11, boolean z12) {
        this.f74815a = z11;
        this.f74816b = z12;
        this.f74817c = new StringBuilder(20);
        this.f74818d = new int[9];
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    public static String h(CharSequence charSequence) throws FormatException {
        int i11;
        char c11;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i12 = 0;
        while (i12 < length) {
            char cCharAt = charSequence.charAt(i12);
            if (cCharAt == '+' || cCharAt == '$' || cCharAt == '%' || cCharAt == '/') {
                i12++;
                char cCharAt2 = charSequence.charAt(i12);
                if (cCharAt != '$') {
                    if (cCharAt != '%') {
                        if (cCharAt != '+') {
                            if (cCharAt != '/') {
                                c11 = 0;
                            } else if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                i11 = cCharAt2 - ' ';
                            } else {
                                if (cCharAt2 != 'Z') {
                                    throw FormatException.getFormatInstance();
                                }
                                c11 = ':';
                            }
                        } else {
                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            i11 = cCharAt2 + ' ';
                        }
                    } else if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                        i11 = cCharAt2 - '&';
                    } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                        i11 = cCharAt2 - 11;
                    } else if (cCharAt2 >= 'K' && cCharAt2 <= 'O') {
                        i11 = cCharAt2 + 16;
                    } else if (cCharAt2 >= 'P' && cCharAt2 <= 'T') {
                        i11 = cCharAt2 + '+';
                    } else if (cCharAt2 == 'U') {
                        c11 = 0;
                    } else if (cCharAt2 == 'V') {
                        c11 = '@';
                    } else if (cCharAt2 == 'W') {
                        c11 = '`';
                    } else {
                        if (cCharAt2 != 'X' && cCharAt2 != 'Y' && cCharAt2 != 'Z') {
                            throw FormatException.getFormatInstance();
                        }
                        c11 = Ascii.MAX;
                    }
                    sb2.append(c11);
                } else {
                    if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                        throw FormatException.getFormatInstance();
                    }
                    i11 = cCharAt2 - '@';
                }
                c11 = (char) i11;
                sb2.append(c11);
            } else {
                sb2.append(cCharAt);
            }
            i12++;
        }
        return sb2.toString();
    }

    public static int[] i(hm.a aVar, int[] iArr) throws NotFoundException {
        int iM = aVar.m();
        int iK = aVar.k(0);
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
                    if (k(iArr) == 148 && aVar.o(Math.max(0, i11 - ((iK - i11) / 2)), i11, false)) {
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

    public static char j(int i11) throws NotFoundException {
        int i12 = 0;
        while (true) {
            int[] iArr = f74814e;
            if (i12 >= iArr.length) {
                if (i11 == 148) {
                    return '*';
                }
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i12] == i11) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i12);
            }
            i12++;
        }
    }

    public static int k(int[] iArr) {
        int length = iArr.length;
        int i11 = 0;
        while (true) {
            int i12 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i13 : iArr) {
                if (i13 < i12 && i13 > i11) {
                    i12 = i13;
                }
            }
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < length; i17++) {
                int i18 = iArr[i17];
                if (i18 > i12) {
                    i15 |= 1 << ((length - 1) - i17);
                    i14++;
                    i16 += i18;
                }
            }
            if (i14 == 3) {
                for (int i19 = 0; i19 < length && i14 > 0; i19++) {
                    int i21 = iArr[i19];
                    if (i21 > i12) {
                        i14--;
                        if (i21 * 2 >= i16) {
                            return -1;
                        }
                    }
                }
                return i15;
            }
            if (i14 <= 3) {
                return -1;
            }
            i11 = i12;
        }
    }

    @Override // qm.q
    public com.google.zxing.j c(int i11, hm.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] iArr = this.f74818d;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f74817c;
        sb2.setLength(0);
        int[] iArrI = i(aVar, iArr);
        int iK = aVar.k(iArrI[1]);
        int iM = aVar.m();
        while (true) {
            q.f(aVar, iK, iArr);
            int iK2 = k(iArr);
            if (iK2 < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char cJ = j(iK2);
            sb2.append(cJ);
            int i12 = iK;
            for (int i13 : iArr) {
                i12 += i13;
            }
            int iK3 = aVar.k(i12);
            if (cJ == '*') {
                sb2.setLength(sb2.length() - 1);
                int i14 = 0;
                for (int i15 : iArr) {
                    i14 += i15;
                }
                int i16 = (iK3 - iK) - i14;
                if (iK3 != iM && i16 * 2 < i14) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (this.f74815a) {
                    int length = sb2.length() - 1;
                    int iIndexOf = 0;
                    for (int i17 = 0; i17 < length; i17++) {
                        iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f74817c.charAt(i17));
                    }
                    if (sb2.charAt(length) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    sb2.setLength(length);
                }
                if (sb2.length() == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                float f11 = i11;
                com.google.zxing.j jVar = new com.google.zxing.j(this.f74816b ? h(sb2) : sb2.toString(), null, new com.google.zxing.k[]{new com.google.zxing.k((iArrI[1] + iArrI[0]) / 2.0f, f11), new com.google.zxing.k(iK + (i14 / 2.0f), f11)}, BarcodeFormat.CODE_39);
                jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]A0");
                return jVar;
            }
            iK = iK3;
        }
    }
}
