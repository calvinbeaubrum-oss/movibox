package an;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import hm.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f578a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f579a;

        static {
            int[] iArr = new int[Mode.values().length];
            f579a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f579a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f579a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f579a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f579a[Mode.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f579a[Mode.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f579a[Mode.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f579a[Mode.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f579a[Mode.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f579a[Mode.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:41:0x0102 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0104  */
    /* JADX WARN: Code duplicated, block: B:43:0x0106 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x0108  */
    /* JADX WARN: Code duplicated, block: B:45:0x010b  */
    /* JADX WARN: Code duplicated, block: B:46:0x010d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x010f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0111 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0113  */
    /* JADX WARN: Code duplicated, block: B:50:0x0116  */
    /* JADX WARN: Code duplicated, block: B:53:0x0123  */
    /* JADX WARN: Code duplicated, block: B:54:0x0125  */
    /* JADX WARN: Code duplicated, block: B:56:0x0128  */
    /* JADX WARN: Code duplicated, block: B:57:0x012a  */
    /* JADX WARN: Code duplicated, block: B:60:0x013b A[LOOP:0: B:63:0x0021->B:60:0x013b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x0100 A[SYNTHETIC] */
    public static hm.d a(byte[] bArr, f fVar, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        int i11;
        ArrayList arrayList;
        String string;
        hm.c cVar = new hm.c(bArr);
        StringBuilder sb2 = new StringBuilder(50);
        int i12 = 1;
        ArrayList arrayList2 = new ArrayList(1);
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        int i13 = -1;
        int iD = -1;
        CharacterSetECI characterSetECIByValue = null;
        while (true) {
            try {
                Mode modeForBits = cVar.a() < 4 ? Mode.TERMINATOR : Mode.forBits(cVar.d(4));
                int[] iArr = a.f579a;
                switch (iArr[modeForBits.ordinal()]) {
                    case 5:
                        modeForBits = modeForBits;
                        if (modeForBits == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z12) {
                                    i11 = 4;
                                } else if (z13) {
                                    i11 = 6;
                                } else {
                                    i11 = 2;
                                }
                            } else if (z12) {
                                i11 = 3;
                            } else if (z13) {
                                i11 = 5;
                            } else {
                                i11 = 1;
                            }
                            String string2 = sb2.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            if (errorCorrectionLevel == null) {
                                string = null;
                            } else {
                                string = errorCorrectionLevel.toString();
                            }
                            return new hm.d(bArr, string2, arrayList, string, i13, iD, i11);
                        }
                        i12 = 1;
                        break;
                    case 6:
                        modeForBits = modeForBits;
                        z11 = true;
                        z12 = true;
                        if (modeForBits == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z12) {
                                    i11 = 4;
                                } else if (z13) {
                                    i11 = 6;
                                } else {
                                    i11 = 2;
                                }
                            } else if (z12) {
                                i11 = 3;
                            } else if (z13) {
                                i11 = 5;
                            } else {
                                i11 = 1;
                            }
                            String string3 = sb2.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            if (errorCorrectionLevel == null) {
                                string = null;
                            } else {
                                string = errorCorrectionLevel.toString();
                            }
                            return new hm.d(bArr, string3, arrayList, string, i13, iD, i11);
                        }
                        i12 = 1;
                        break;
                    case 7:
                        modeForBits = modeForBits;
                        z11 = true;
                        z13 = true;
                        if (modeForBits == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z12) {
                                    i11 = 4;
                                } else if (z13) {
                                    i11 = 6;
                                } else {
                                    i11 = 2;
                                }
                            } else if (z12) {
                                i11 = 3;
                            } else if (z13) {
                                i11 = 5;
                            } else {
                                i11 = 1;
                            }
                            String string4 = sb2.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            if (errorCorrectionLevel == null) {
                                string = null;
                            } else {
                                string = errorCorrectionLevel.toString();
                            }
                            return new hm.d(bArr, string4, arrayList, string, i13, iD, i11);
                        }
                        i12 = 1;
                        break;
                    case 8:
                        modeForBits = modeForBits;
                        if (cVar.a() < 16) {
                            throw FormatException.getFormatInstance();
                        }
                        int iD2 = cVar.d(8);
                        iD = cVar.d(8);
                        i13 = iD2;
                        if (modeForBits == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z12) {
                                    i11 = 4;
                                } else if (z13) {
                                    i11 = 6;
                                } else {
                                    i11 = 2;
                                }
                            } else if (z12) {
                                i11 = 3;
                            } else if (z13) {
                                i11 = 5;
                            } else {
                                i11 = 1;
                            }
                            String string5 = sb2.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            if (errorCorrectionLevel == null) {
                                string = null;
                            } else {
                                string = errorCorrectionLevel.toString();
                            }
                            return new hm.d(bArr, string5, arrayList, string, i13, iD, i11);
                        }
                        i12 = 1;
                        break;
                        break;
                    case 9:
                        modeForBits = modeForBits;
                        characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(g(cVar));
                        if (characterSetECIByValue == null) {
                            throw FormatException.getFormatInstance();
                        }
                        if (modeForBits == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z12) {
                                    i11 = 4;
                                } else if (z13) {
                                    i11 = 6;
                                } else {
                                    i11 = 2;
                                }
                            } else if (z12) {
                                i11 = 3;
                            } else if (z13) {
                                i11 = 5;
                            } else {
                                i11 = 1;
                            }
                            String string6 = sb2.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            if (errorCorrectionLevel == null) {
                                string = null;
                            } else {
                                string = errorCorrectionLevel.toString();
                            }
                            return new hm.d(bArr, string6, arrayList, string, i13, iD, i11);
                        }
                        i12 = 1;
                        break;
                        break;
                    case 10:
                        modeForBits = modeForBits;
                        int iD3 = cVar.d(4);
                        int iD4 = cVar.d(modeForBits.getCharacterCountBits(fVar));
                        if (iD3 == 1) {
                            d(cVar, sb2, iD4);
                        }
                        if (modeForBits == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z12) {
                                    i11 = 4;
                                } else if (z13) {
                                    i11 = 6;
                                } else {
                                    i11 = 2;
                                }
                            } else if (z12) {
                                i11 = 3;
                            } else if (z13) {
                                i11 = 5;
                            } else {
                                i11 = 1;
                            }
                            String string7 = sb2.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            if (errorCorrectionLevel == null) {
                                string = null;
                            } else {
                                string = errorCorrectionLevel.toString();
                            }
                            return new hm.d(bArr, string7, arrayList, string, i13, iD, i11);
                        }
                        i12 = 1;
                        break;
                    default:
                        int iD5 = cVar.d(modeForBits.getCharacterCountBits(fVar));
                        int i14 = iArr[modeForBits.ordinal()];
                        if (i14 == i12) {
                            f(cVar, sb2, iD5);
                        } else if (i14 == 2) {
                            b(cVar, sb2, iD5, z11);
                        } else if (i14 == 3) {
                            c(cVar, sb2, iD5, characterSetECIByValue, arrayList2, map);
                        } else {
                            if (i14 != 4) {
                                throw FormatException.getFormatInstance();
                            }
                            e(cVar, sb2, iD5);
                            modeForBits = modeForBits;
                            if (modeForBits == Mode.TERMINATOR) {
                                if (characterSetECIByValue != null) {
                                    if (z12) {
                                        i11 = 4;
                                    } else if (z13) {
                                        i11 = 6;
                                    } else {
                                        i11 = 2;
                                    }
                                } else if (z12) {
                                    i11 = 3;
                                } else if (z13) {
                                    i11 = 5;
                                } else {
                                    i11 = 1;
                                }
                                String string8 = sb2.toString();
                                if (arrayList2.isEmpty()) {
                                    arrayList = null;
                                } else {
                                    arrayList = arrayList2;
                                }
                                if (errorCorrectionLevel == null) {
                                    string = null;
                                } else {
                                    string = errorCorrectionLevel.toString();
                                }
                                return new hm.d(bArr, string8, arrayList, string, i13, iD, i11);
                            }
                            i12 = 1;
                        }
                        if (modeForBits == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z12) {
                                    i11 = 4;
                                } else if (z13) {
                                    i11 = 6;
                                } else {
                                    i11 = 2;
                                }
                            } else if (z12) {
                                i11 = 3;
                            } else if (z13) {
                                i11 = 5;
                            } else {
                                i11 = 1;
                            }
                            String string9 = sb2.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            if (errorCorrectionLevel == null) {
                                string = null;
                            } else {
                                string = errorCorrectionLevel.toString();
                            }
                            return new hm.d(bArr, string9, arrayList, string, i13, iD, i11);
                        }
                        i12 = 1;
                        break;
                }
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    public static void b(hm.c cVar, StringBuilder sb2, int i11, boolean z11) throws FormatException {
        while (i11 > 1) {
            if (cVar.a() < 11) {
                throw FormatException.getFormatInstance();
            }
            int iD = cVar.d(11);
            sb2.append(h(iD / 45));
            sb2.append(h(iD % 45));
            i11 -= 2;
        }
        if (i11 == 1) {
            if (cVar.a() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(cVar.d(6)));
        }
        if (z11) {
            for (int length = sb2.length(); length < sb2.length(); length++) {
                if (sb2.charAt(length) == '%') {
                    if (length < sb2.length() - 1) {
                        int i12 = length + 1;
                        if (sb2.charAt(i12) == '%') {
                            sb2.deleteCharAt(i12);
                        } else {
                            sb2.setCharAt(length, (char) 29);
                        }
                    } else {
                        sb2.setCharAt(length, (char) 29);
                    }
                }
            }
        }
    }

    public static void c(hm.c cVar, StringBuilder sb2, int i11, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        if (i11 * 8 > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            bArr[i12] = (byte) cVar.d(8);
        }
        sb2.append(new String(bArr, characterSetECI == null ? o.a(bArr, map) : characterSetECI.getCharset()));
        collection.add(bArr);
    }

    public static void d(hm.c cVar, StringBuilder sb2, int i11) throws FormatException {
        if (o.f66546c == null) {
            throw FormatException.getFormatInstance();
        }
        if (i11 * 13 > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i11 * 2];
        int i12 = 0;
        while (i11 > 0) {
            int iD = cVar.d(13);
            int i13 = (iD % 96) | ((iD / 96) << 8);
            int i14 = i13 + (i13 < 2560 ? 41377 : 42657);
            bArr[i12] = (byte) ((i14 >> 8) & 255);
            bArr[i12 + 1] = (byte) (i14 & 255);
            i12 += 2;
            i11--;
        }
        sb2.append(new String(bArr, o.f66546c));
    }

    public static void e(hm.c cVar, StringBuilder sb2, int i11) throws FormatException {
        if (i11 * 13 > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i11 * 2];
        int i12 = 0;
        while (i11 > 0) {
            int iD = cVar.d(13);
            int i13 = (iD % PsExtractor.AUDIO_STREAM) | ((iD / PsExtractor.AUDIO_STREAM) << 8);
            int i14 = i13 + (i13 < 7936 ? 33088 : 49472);
            bArr[i12] = (byte) (i14 >> 8);
            bArr[i12 + 1] = (byte) i14;
            i12 += 2;
            i11--;
        }
        sb2.append(new String(bArr, o.f66545b));
    }

    public static void f(hm.c cVar, StringBuilder sb2, int i11) throws FormatException {
        while (i11 >= 3) {
            if (cVar.a() < 10) {
                throw FormatException.getFormatInstance();
            }
            int iD = cVar.d(10);
            if (iD >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(iD / 100));
            sb2.append(h((iD / 10) % 10));
            sb2.append(h(iD % 10));
            i11 -= 3;
        }
        if (i11 == 2) {
            if (cVar.a() < 7) {
                throw FormatException.getFormatInstance();
            }
            int iD2 = cVar.d(7);
            if (iD2 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(iD2 / 10));
            sb2.append(h(iD2 % 10));
            return;
        }
        if (i11 == 1) {
            if (cVar.a() < 4) {
                throw FormatException.getFormatInstance();
            }
            int iD3 = cVar.d(4);
            if (iD3 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(iD3));
        }
    }

    public static int g(hm.c cVar) throws FormatException {
        int iD = cVar.d(8);
        if ((iD & 128) == 0) {
            return iD & 127;
        }
        if ((iD & PsExtractor.AUDIO_STREAM) == 128) {
            return cVar.d(8) | ((iD & 63) << 8);
        }
        if ((iD & 224) == 192) {
            return cVar.d(16) | ((iD & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    public static char h(int i11) throws FormatException {
        char[] cArr = f578a;
        if (i11 < cArr.length) {
            return cArr[i11];
        }
        throw FormatException.getFormatInstance();
    }
}
