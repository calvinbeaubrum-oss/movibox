package pm;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.zxing.FormatException;
import hm.d;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f73947a = {53, 54, 43, 44, 45, 46, 47, 48, 37, 38};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f73948b = {55, 56, 57, 58, 59, 60, 49, 50, 51, 52};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f73949c = {39, 40, 41, 42, Ascii.US, 32};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f73950d = {33, 34, 35, 36, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 7, 8, 9, 10, Ascii.VT, Ascii.FF, 1, 2};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[][] f73951e = {new byte[]{39, 40, 41, 42, Ascii.US, 32}, new byte[]{33, 34, 35, 36, Ascii.EM, Ascii.SUB}, new byte[]{Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, 19, Ascii.DC4}, new byte[]{Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.CR, Ascii.SO}, new byte[]{Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 7, 8}, new byte[]{9, 10, Ascii.VT, Ascii.FF, 1, 2}};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f73952f = {"\rABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001e\ufffbÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8"};

    public static d a(byte[] bArr, int i11) throws FormatException {
        String strH;
        StringBuilder sb2 = new StringBuilder(144);
        if (i11 == 2 || i11 == 3) {
            if (i11 == 2) {
                int iF = f(bArr);
                int iG = g(bArr);
                if (iG > 10) {
                    throw FormatException.getFormatInstance();
                }
                strH = new DecimalFormat("0000000000".substring(0, iG)).format(iF);
            } else {
                strH = h(bArr);
            }
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String str = decimalFormat.format(c(bArr));
            String str2 = decimalFormat.format(i(bArr));
            sb2.append(e(bArr, 10, 84));
            if (sb2.toString().startsWith("[)>\u001e01\u001d")) {
                sb2.insert(9, strH + (char) 29 + str + (char) 29 + str2 + (char) 29);
            } else {
                sb2.insert(0, strH + (char) 29 + str + (char) 29 + str2 + (char) 29);
            }
        } else if (i11 == 4) {
            sb2.append(e(bArr, 1, 93));
        } else if (i11 == 5) {
            sb2.append(e(bArr, 1, 77));
        }
        return new d(bArr, sb2.toString(), null, String.valueOf(i11));
    }

    public static int b(int i11, byte[] bArr) {
        int i12 = i11 - 1;
        return ((1 << (5 - (i12 % 6))) & bArr[i12 / 6]) == 0 ? 0 : 1;
    }

    public static int c(byte[] bArr) {
        return d(bArr, f73947a);
    }

    public static int d(byte[] bArr, byte[] bArr2) {
        int iB = 0;
        for (int i11 = 0; i11 < bArr2.length; i11++) {
            iB += b(bArr2[i11], bArr) << ((bArr2.length - i11) - 1);
        }
        return iB;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String e(byte[] bArr, int i11, int i12) {
        StringBuilder sb2 = new StringBuilder();
        int i13 = i11;
        int i14 = 0;
        int i15 = -1;
        int i16 = 0;
        while (i13 < i11 + i12) {
            char cCharAt = f73952f[i14].charAt(bArr[i13]);
            switch (cCharAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i16 = i14;
                    i14 = cCharAt - 65520;
                    i15 = 1;
                    break;
                case 65525:
                    i15 = 2;
                    i16 = i14;
                    i14 = 0;
                    break;
                case 65526:
                    i15 = 3;
                    i16 = i14;
                    i14 = 0;
                    break;
                case 65527:
                    i14 = 0;
                    i15 = -1;
                    break;
                case 65528:
                    i14 = 1;
                    i15 = -1;
                    break;
                case 65529:
                    i15 = -1;
                    break;
                case 65530:
                default:
                    sb2.append(cCharAt);
                    break;
                case 65531:
                    int i17 = (bArr[i13 + 1] << Ascii.CAN) + (bArr[i13 + 2] << Ascii.DC2) + (bArr[i13 + 3] << Ascii.FF) + (bArr[i13 + 4] << 6);
                    i13 += 5;
                    sb2.append(new DecimalFormat("000000000").format(i17 + bArr[i13]));
                    break;
            }
            int i18 = i15 - 1;
            if (i15 == 0) {
                i14 = i16;
            }
            i13++;
            i15 = i18;
        }
        while (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == 65532) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2.toString();
    }

    public static int f(byte[] bArr) {
        return d(bArr, f73950d);
    }

    public static int g(byte[] bArr) {
        return d(bArr, f73949c);
    }

    public static String h(byte[] bArr) {
        byte[][] bArr2 = f73951e;
        StringBuilder sb2 = new StringBuilder(bArr2.length);
        for (byte[] bArr3 : bArr2) {
            sb2.append(f73952f[0].charAt(d(bArr, bArr3)));
        }
        return sb2.toString();
    }

    public static int i(byte[] bArr) {
        return d(bArr, f73948b);
    }
}
