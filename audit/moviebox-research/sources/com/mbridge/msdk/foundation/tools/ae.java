package com.mbridge.msdk.foundation.tools;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f44966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f44967b = new byte[128];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<Character, Character> f44968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static char[] f44969d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f44966a = cArr;
        HashMap map = new HashMap();
        f44968c = map;
        map.put('A', 'v');
        f44968c.put('B', 'S');
        f44968c.put('C', 'o');
        f44968c.put('D', 'a');
        f44968c.put('E', 'j');
        f44968c.put('F', 'c');
        f44968c.put('G', '7');
        f44968c.put('H', 'd');
        f44968c.put('I', 'R');
        f44968c.put('J', 'z');
        f44968c.put('K', 'p');
        f44968c.put('L', 'W');
        f44968c.put('M', 'i');
        f44968c.put('N', 'f');
        f44968c.put('O', 'G');
        f44968c.put('P', 'y');
        f44968c.put('Q', 'N');
        f44968c.put('R', 'x');
        f44968c.put('S', 'Z');
        f44968c.put('T', 'n');
        f44968c.put('U', 'V');
        f44968c.put('V', '5');
        f44968c.put('W', 'k');
        f44968c.put('X', '+');
        f44968c.put('Y', 'D');
        f44968c.put('Z', 'H');
        f44968c.put('a', 'L');
        f44968c.put('b', 'Y');
        f44968c.put('c', 'h');
        f44968c.put('d', 'J');
        f44968c.put('e', '4');
        f44968c.put('f', '6');
        f44968c.put('g', 'l');
        f44968c.put('h', 't');
        f44968c.put('i', '0');
        f44968c.put('j', 'U');
        f44968c.put('k', '3');
        f44968c.put('l', 'Q');
        f44968c.put('m', 'r');
        f44968c.put('n', 'g');
        f44968c.put('o', 'E');
        f44968c.put('p', 'u');
        f44968c.put('q', 'q');
        f44968c.put('r', '8');
        f44968c.put('s', 's');
        f44968c.put('t', 'w');
        f44968c.put('u', '/');
        f44968c.put('v', 'X');
        f44968c.put('w', 'M');
        f44968c.put('x', 'e');
        f44968c.put('y', 'B');
        f44968c.put('z', 'A');
        f44968c.put('0', 'T');
        f44968c.put('1', '2');
        f44968c.put('2', 'F');
        f44968c.put('3', 'b');
        f44968c.put('4', '9');
        f44968c.put('5', 'P');
        f44968c.put('6', '1');
        f44968c.put('7', 'O');
        f44968c.put('8', 'I');
        f44968c.put('9', 'K');
        f44968c.put('+', 'm');
        f44968c.put('/', 'C');
        f44969d = new char[cArr.length];
        int i11 = 0;
        int i12 = 0;
        while (true) {
            char[] cArr2 = f44966a;
            if (i12 >= cArr2.length) {
                break;
            }
            f44969d[i12] = f44968c.get(Character.valueOf(cArr2[i12])).charValue();
            i12++;
        }
        int i13 = 0;
        while (true) {
            byte[] bArr = f44967b;
            if (i13 >= bArr.length) {
                break;
            }
            bArr[i13] = Ascii.DEL;
            i13++;
        }
        while (true) {
            char[] cArr3 = f44969d;
            if (i11 >= cArr3.length) {
                return;
            }
            f44967b[cArr3[i11]] = (byte) i11;
            i11++;
        }
    }

    private static int a(char[] cArr, byte[] bArr, int i11) {
        try {
            char c11 = cArr[3];
            char c12 = c11 == '=' ? (char) 2 : (char) 3;
            char c13 = cArr[2];
            if (c13 == '=') {
                c12 = 1;
            }
            byte[] bArr2 = f44967b;
            byte b11 = bArr2[cArr[0]];
            byte b12 = bArr2[cArr[1]];
            byte b13 = bArr2[c13];
            byte b14 = bArr2[c11];
            if (c12 == 1) {
                bArr[i11] = (byte) (((b12 >> 4) & 3) | ((b11 << 2) & 252));
                return 1;
            }
            if (c12 == 2) {
                bArr[i11] = (byte) ((3 & (b12 >> 4)) | ((b11 << 2) & 252));
                bArr[i11 + 1] = (byte) (((b12 << 4) & 240) | ((b13 >> 2) & 15));
                return 2;
            }
            if (c12 != 3) {
                throw new RuntimeException("Internal Error");
            }
            bArr[i11] = (byte) (((b11 << 2) & 252) | ((b12 >> 4) & 3));
            bArr[i11 + 1] = (byte) (((b12 << 4) & 240) | ((b13 >> 2) & 15));
            bArr[i11 + 2] = (byte) (((b13 << 6) & PsExtractor.AUDIO_STREAM) | (b14 & Utf8.REPLACEMENT_BYTE));
            return 3;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String a(String str) {
        byte[] bArrC = c(str);
        if (bArrC == null || bArrC.length <= 0) {
            return null;
        }
        return new String(bArrC);
    }

    private static String a(byte[] bArr, int i11, int i12) {
        if (i12 <= 0) {
            return "";
        }
        try {
            char[] cArr = new char[((i12 / 3) << 2) + 4];
            int i13 = 0;
            while (i12 >= 3) {
                int i14 = ((bArr[i11] & 255) << 16) + ((bArr[i11 + 1] & 255) << 8) + (bArr[i11 + 2] & 255);
                char[] cArr2 = f44969d;
                cArr[i13] = cArr2[i14 >> 18];
                cArr[i13 + 1] = cArr2[(i14 >> 12) & 63];
                int i15 = i13 + 3;
                cArr[i13 + 2] = cArr2[(i14 >> 6) & 63];
                i13 += 4;
                cArr[i15] = cArr2[i14 & 63];
                i11 += 3;
                i12 -= 3;
            }
            if (i12 == 1) {
                int i16 = bArr[i11] & 255;
                char[] cArr3 = f44969d;
                cArr[i13] = cArr3[i16 >> 2];
                cArr[i13 + 1] = cArr3[(i16 << 4) & 63];
                int i17 = i13 + 3;
                cArr[i13 + 2] = '=';
                i13 += 4;
                cArr[i17] = '=';
            } else if (i12 == 2) {
                int i18 = ((bArr[i11] & 255) << 8) + (bArr[i11 + 1] & 255);
                char[] cArr4 = f44969d;
                cArr[i13] = cArr4[i18 >> 10];
                cArr[i13 + 1] = cArr4[(i18 >> 4) & 63];
                int i19 = i13 + 3;
                cArr[i13 + 2] = cArr4[(i18 << 2) & 63];
                i13 += 4;
                cArr[i19] = '=';
            }
            return new String(cArr, 0, i13);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str) {
        byte[] bytes = str.getBytes();
        return a(bytes, 0, bytes.length);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003d A[Catch: Exception -> 0x005b, TryCatch #0 {Exception -> 0x005b, blocks: (B:2:0x0000, B:5:0x0009, B:7:0x0019, B:9:0x001d, B:13:0x002c, B:15:0x0032, B:17:0x0037, B:23:0x004c, B:19:0x003d, B:21:0x0044, B:10:0x0023, B:27:0x0055), top: B:31:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0044 A[Catch: Exception -> 0x005b, TryCatch #0 {Exception -> 0x005b, blocks: (B:2:0x0000, B:5:0x0009, B:7:0x0019, B:9:0x001d, B:13:0x002c, B:15:0x0032, B:17:0x0037, B:23:0x004c, B:19:0x003d, B:21:0x0044, B:10:0x0023, B:27:0x0055), top: B:31:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x004b  */
    private static byte[] c(String str) {
        int i11;
        int i12;
        try {
            int length = str.length();
            char[] cArr = new char[length < 259 ? length : 259];
            int i13 = ((length >> 2) * 3) + 3;
            byte[] bArr = new byte[i13];
            int i14 = 0;
            int iA = 0;
            int i15 = 0;
            while (i14 < length) {
                int i16 = i14 + 256;
                if (i16 <= length) {
                    str.getChars(i14, i16, cArr, i15);
                    i11 = i15 + 256;
                } else {
                    str.getChars(i14, length, cArr, i15);
                    i11 = (length - i14) + i15;
                }
                int i17 = i15;
                while (i15 < i11) {
                    char c11 = cArr[i15];
                    if (c11 != '=') {
                        byte[] bArr2 = f44967b;
                        if (c11 < bArr2.length && bArr2[c11] != 127) {
                            i12 = i17 + 1;
                            cArr[i17] = c11;
                            if (i12 == 4) {
                                iA += a(cArr, bArr, iA);
                                i17 = 0;
                            } else {
                                i17 = i12;
                            }
                        }
                    } else {
                        i12 = i17 + 1;
                        cArr[i17] = c11;
                        if (i12 == 4) {
                            iA += a(cArr, bArr, iA);
                            i17 = 0;
                        } else {
                            i17 = i12;
                        }
                    }
                    i15++;
                }
                i14 = i16;
                i15 = i17;
            }
            if (iA == i13) {
                return bArr;
            }
            byte[] bArr3 = new byte[iA];
            System.arraycopy(bArr, 0, bArr3, 0, iA);
            return bArr3;
        } catch (Exception unused) {
            return null;
        }
    }
}
