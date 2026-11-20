package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Properties f15554a = new Properties();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f15555b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f15556c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean[] f15557d = new boolean[256];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean[] f15558e = new boolean[256];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f15559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f15560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean[] f15561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean[] f15562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char[] f15563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char[] f15564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final char[] f15565l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final char[] f15566m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final char[] f15567n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f15568o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final char[] f15569p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f15570q;

    /* JADX INFO: compiled from: source.java */
    public static class a implements PrivilegedAction<InputStream> {
        @Override // java.security.PrivilegedAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InputStream run() {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            return contextClassLoader != null ? contextClassLoader.getResourceAsStream("fastjson.properties") : ClassLoader.getSystemResourceAsStream("fastjson.properties");
        }
    }

    static {
        char c11 = 0;
        while (true) {
            boolean[] zArr = f15557d;
            if (c11 >= zArr.length) {
                break;
            }
            if (c11 >= 'A' && c11 <= 'Z') {
                zArr[c11] = true;
            } else if (c11 >= 'a' && c11 <= 'z') {
                zArr[c11] = true;
            } else if (c11 == '_' || c11 == '$') {
                zArr[c11] = true;
            }
            c11 = (char) (c11 + 1);
        }
        char c12 = 0;
        while (true) {
            boolean[] zArr2 = f15558e;
            if (c12 < zArr2.length) {
                if (c12 >= 'A' && c12 <= 'Z') {
                    zArr2[c12] = true;
                } else if (c12 >= 'a' && c12 <= 'z') {
                    zArr2[c12] = true;
                } else if (c12 == '_') {
                    zArr2[c12] = true;
                } else if (c12 >= '0' && c12 <= '9') {
                    zArr2[c12] = true;
                }
                c12 = (char) (c12 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        m();
        byte[] bArr = new byte[161];
        f15559f = bArr;
        byte[] bArr2 = new byte[161];
        f15560g = bArr2;
        f15561h = new boolean[161];
        f15562i = new boolean[161];
        f15563j = new char[93];
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i11 = 14; i11 <= 31; i11++) {
            f15559f[i11] = 4;
            f15560g[i11] = 4;
        }
        for (int i12 = 127; i12 < 160; i12++) {
            f15559f[i12] = 4;
            f15560g[i12] = 4;
        }
        for (int i13 = 0; i13 < 161; i13++) {
            f15561h[i13] = f15559f[i13] != 0;
            f15562i[i13] = f15560g[i13] != 0;
        }
        char[] cArr = f15563j;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        f15564k = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        f15565l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f15566m = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        f15567n = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        f15568o = new int[]{9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Api.BaseClientBuilder.API_PRIORITY_OTHER};
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f15569p = charArray;
        int[] iArr = new int[256];
        f15570q = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i14 = 0; i14 < length; i14++) {
            f15570q[f15569p[i14]] = i14;
        }
        f15570q[61] = 0;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void b(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult coderResultDecode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!coderResultDecode.isUnderflow()) {
                coderResultDecode.throwException();
            }
            CoderResult coderResultFlush = charsetDecoder.flush(charBuffer);
            if (coderResultFlush.isUnderflow()) {
                return;
            }
            coderResultFlush.throwException();
        } catch (CharacterCodingException e11) {
            throw new JSONException("utf8 decode error, " + e11.getMessage(), e11);
        }
    }

    public static byte[] c(String str) {
        int i11;
        int i12;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i13 = length - 1;
        int i14 = 0;
        while (i14 < i13 && f15570q[str.charAt(i14) & 255] < 0) {
            i14++;
        }
        while (i13 > 0 && f15570q[str.charAt(i13) & 255] < 0) {
            i13--;
        }
        if (str.charAt(i13) == '=') {
            i11 = str.charAt(i13 + (-1)) == '=' ? 2 : 1;
        } else {
            i11 = 0;
        }
        int i15 = (i13 - i14) + 1;
        if (length > 76) {
            i12 = (str.charAt(76) == '\r' ? i15 / 78 : 0) << 1;
        } else {
            i12 = 0;
        }
        int i16 = (((i15 - i12) * 6) >> 3) - i11;
        byte[] bArr = new byte[i16];
        int i17 = (i16 / 3) * 3;
        int i18 = 0;
        int i19 = 0;
        while (i18 < i17) {
            int[] iArr = f15570q;
            int i21 = i14 + 4;
            int i22 = iArr[str.charAt(i14 + 3)] | (iArr[str.charAt(i14 + 1)] << 12) | (iArr[str.charAt(i14)] << 18) | (iArr[str.charAt(i14 + 2)] << 6);
            bArr[i18] = (byte) (i22 >> 16);
            int i23 = i18 + 2;
            bArr[i18 + 1] = (byte) (i22 >> 8);
            i18 += 3;
            bArr[i23] = (byte) i22;
            if (i12 <= 0 || (i19 = i19 + 1) != 19) {
                i14 = i21;
            } else {
                i14 += 6;
                i19 = 0;
            }
        }
        if (i18 < i16) {
            int i24 = 0;
            int i25 = 0;
            while (i14 <= i13 - i11) {
                i24 |= f15570q[str.charAt(i14)] << (18 - (i25 * 6));
                i25++;
                i14++;
            }
            int i26 = 16;
            while (i18 < i16) {
                bArr[i18] = (byte) (i24 >> i26);
                i26 -= 8;
                i18++;
            }
        }
        return bArr;
    }

    public static byte[] d(String str, int i11, int i12) {
        int i13;
        int i14;
        if (i12 == 0) {
            return new byte[0];
        }
        int i15 = (i11 + i12) - 1;
        int i16 = i11;
        while (i16 < i15 && f15570q[str.charAt(i16)] < 0) {
            i16++;
        }
        while (i15 > 0 && f15570q[str.charAt(i15)] < 0) {
            i15--;
        }
        if (str.charAt(i15) == '=') {
            i13 = str.charAt(i15 + (-1)) == '=' ? 2 : 1;
        } else {
            i13 = 0;
        }
        int i17 = (i15 - i16) + 1;
        if (i12 > 76) {
            i14 = (str.charAt(76) == '\r' ? i17 / 78 : 0) << 1;
        } else {
            i14 = 0;
        }
        int i18 = (((i17 - i14) * 6) >> 3) - i13;
        byte[] bArr = new byte[i18];
        int i19 = (i18 / 3) * 3;
        int i21 = 0;
        int i22 = 0;
        while (i21 < i19) {
            int[] iArr = f15570q;
            int i23 = i16 + 4;
            int i24 = iArr[str.charAt(i16 + 3)] | (iArr[str.charAt(i16 + 1)] << 12) | (iArr[str.charAt(i16)] << 18) | (iArr[str.charAt(i16 + 2)] << 6);
            bArr[i21] = (byte) (i24 >> 16);
            int i25 = i21 + 2;
            bArr[i21 + 1] = (byte) (i24 >> 8);
            i21 += 3;
            bArr[i25] = (byte) i24;
            if (i14 <= 0 || (i22 = i22 + 1) != 19) {
                i16 = i23;
            } else {
                i16 += 6;
                i22 = 0;
            }
        }
        if (i21 < i18) {
            int i26 = 0;
            int i27 = 0;
            while (i16 <= i15 - i13) {
                i26 |= f15570q[str.charAt(i16)] << (18 - (i27 * 6));
                i27++;
                i16++;
            }
            int i28 = 16;
            while (i21 < i18) {
                bArr[i21] = (byte) (i26 >> i28);
                i28 -= 8;
                i21++;
            }
        }
        return bArr;
    }

    public static byte[] e(char[] cArr, int i11, int i12) {
        int i13;
        int i14;
        int i15 = 0;
        if (i12 == 0) {
            return new byte[0];
        }
        int i16 = (i11 + i12) - 1;
        int i17 = i11;
        while (i17 < i16 && f15570q[cArr[i17]] < 0) {
            i17++;
        }
        while (i16 > 0 && f15570q[cArr[i16]] < 0) {
            i16--;
        }
        if (cArr[i16] == '=') {
            i13 = cArr[i16 + (-1)] == '=' ? 2 : 1;
        } else {
            i13 = 0;
        }
        int i18 = (i16 - i17) + 1;
        if (i12 > 76) {
            i14 = (cArr[76] == '\r' ? i18 / 78 : 0) << 1;
        } else {
            i14 = 0;
        }
        int i19 = (((i18 - i14) * 6) >> 3) - i13;
        byte[] bArr = new byte[i19];
        int i21 = (i19 / 3) * 3;
        int i22 = 0;
        loop2: while (true) {
            int i23 = 0;
            while (true) {
                if (i22 >= i21) {
                    break loop2;
                }
                int[] iArr = f15570q;
                int i24 = i17 + 4;
                int i25 = iArr[cArr[i17 + 3]] | (iArr[cArr[i17 + 1]] << 12) | (iArr[cArr[i17]] << 18) | (iArr[cArr[i17 + 2]] << 6);
                bArr[i22] = (byte) (i25 >> 16);
                int i26 = i22 + 2;
                bArr[i22 + 1] = (byte) (i25 >> 8);
                i22 += 3;
                bArr[i26] = (byte) i25;
                if (i14 <= 0 || (i23 = i23 + 1) != 19) {
                    i17 = i24;
                }
            }
            i17 += 6;
        }
        if (i22 < i19) {
            int i27 = 0;
            while (i17 <= i16 - i13) {
                i15 |= f15570q[cArr[i17]] << (18 - (i27 * 6));
                i27++;
                i17++;
            }
            int i28 = 16;
            while (i22 < i19) {
                bArr[i22] = (byte) (i15 >> i28);
                i28 -= 8;
                i22++;
            }
        }
        return bArr;
    }

    public static int f(byte[] bArr, int i11, int i12, char[] cArr) {
        int i13 = i11 + i12;
        int iMin = Math.min(i12, cArr.length);
        int i14 = 0;
        while (i14 < iMin) {
            byte b11 = bArr[i11];
            if (b11 < 0) {
                break;
            }
            i11++;
            cArr[i14] = (char) b11;
            i14++;
        }
        while (i11 < i13) {
            int i15 = i11 + 1;
            byte b12 = bArr[i11];
            if (b12 >= 0) {
                cArr[i14] = (char) b12;
                i14++;
                i11 = i15;
            } else {
                if ((b12 >> 5) != -2 || (b12 & Ascii.RS) == 0) {
                    if ((b12 >> 4) == -2) {
                        int i16 = i11 + 2;
                        if (i16 < i13) {
                            byte b13 = bArr[i15];
                            i11 += 3;
                            byte b14 = bArr[i16];
                            if ((b12 != -32 || (b13 & 224) != 128) && (b13 & 192) == 128 && (b14 & 192) == 128) {
                                char c11 = (char) (((b13 << 6) ^ (b12 << Ascii.FF)) ^ ((-123008) ^ b14));
                                if (c11 >= 55296 && c11 < 57344) {
                                    return -1;
                                }
                                cArr[i14] = c11;
                                i14++;
                            }
                        }
                        return -1;
                    }
                    if ((b12 >> 3) == -2 && i11 + 3 < i13) {
                        byte b15 = bArr[i15];
                        int i17 = i11 + 3;
                        byte b16 = bArr[i11 + 2];
                        i11 += 4;
                        byte b17 = bArr[i17];
                        int i18 = (((b12 << Ascii.DC2) ^ (b15 << Ascii.FF)) ^ (b16 << 6)) ^ (3678080 ^ b17);
                        if ((b15 & 192) == 128 && (b16 & 192) == 128 && (b17 & 192) == 128 && i18 >= 65536 && i18 < 1114112) {
                            int i19 = i14 + 1;
                            cArr[i14] = (char) ((i18 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                            i14 += 2;
                            cArr[i19] = (char) ((i18 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                        }
                    }
                    return -1;
                }
                if (i15 >= i13) {
                    return -1;
                }
                i11 += 2;
                byte b18 = bArr[i15];
                if ((b18 & 192) != 128) {
                    return -1;
                }
                cArr[i14] = (char) ((b18 ^ (b12 << 6)) ^ Utf8.MASK_2BYTES);
                i14++;
            }
        }
        return i14;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0079  */
    /* JADX WARN: Code duplicated, block: B:37:0x007e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [char, int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v8 */
    public static int g(char[] cArr, int i11, int i12, byte[] bArr) {
        int i13;
        char c11;
        int i14 = i11 + i12;
        int iMin = Math.min(i12, bArr.length);
        int i15 = 0;
        while (i15 < iMin && (c11 = cArr[i11]) < 128) {
            i11++;
            bArr[i15] = (byte) c11;
            i15++;
        }
        while (i11 < i14) {
            int i16 = i11 + 1;
            char c12 = cArr[i11];
            if (c12 < 128) {
                i13 = i15 + 1;
                bArr[i15] = (byte) c12;
            } else {
                if (c12 < 2048) {
                    int i17 = i15 + 1;
                    bArr[i15] = (byte) ((c12 >> 6) | PsExtractor.AUDIO_STREAM);
                    i15 += 2;
                    bArr[i17] = (byte) ((c12 & 63) | 128);
                } else if (c12 < 55296 || c12 >= 57344) {
                    bArr[i15] = (byte) ((c12 >> 12) | 224);
                    int i18 = i15 + 2;
                    bArr[i15 + 1] = (byte) ((63 & (c12 >> 6)) | 128);
                    i15 += 3;
                    bArr[i18] = (byte) ((c12 & 63) | 128);
                } else if (c12 >= 55296 && c12 < 56320) {
                    if (i14 - i11 < 2) {
                        c12 = -1;
                    } else {
                        char c13 = cArr[i11 + 1];
                        if (c13 < 56320 || c13 >= 57344) {
                            i13 = i15 + 1;
                            bArr[i15] = Utf8.REPLACEMENT_BYTE;
                        } else {
                            c12 = ((c12 << 10) + c13) - 56613888;
                        }
                    }
                    if (c12 < 0) {
                        i13 = i15 + 1;
                        bArr[i15] = Utf8.REPLACEMENT_BYTE;
                    } else {
                        bArr[i15] = (byte) ((c12 >> 18) | 240);
                        bArr[i15 + 1] = (byte) (((c12 >> 12) & 63) | 128);
                        bArr[i15 + 2] = (byte) ((63 & (c12 >> 6)) | 128);
                        bArr[i15 + 3] = (byte) ((c12 & 63) | 128);
                        i16 = i11 + 2;
                        i13 = i15 + 4;
                    }
                } else if (c12 >= 56320 && c12 < 57344) {
                    i13 = i15 + 1;
                    bArr[i15] = Utf8.REPLACEMENT_BYTE;
                } else if (c12 < 0) {
                    i13 = i15 + 1;
                    bArr[i15] = Utf8.REPLACEMENT_BYTE;
                } else {
                    bArr[i15] = (byte) ((c12 >> 18) | 240);
                    bArr[i15 + 1] = (byte) (((c12 >> 12) & 63) | 128);
                    bArr[i15 + 2] = (byte) ((63 & (c12 >> 6)) | 128);
                    bArr[i15 + 3] = (byte) ((c12 & 63) | 128);
                    i16 = i11 + 2;
                    i13 = i15 + 4;
                }
                i11 = i16;
            }
            i15 = i13;
            i11 = i16;
        }
        return i15;
    }

    public static boolean h(char c11) {
        boolean[] zArr = f15557d;
        return c11 < zArr.length && zArr[c11];
    }

    public static void i(int i11, int i12, char[] cArr) {
        char c11;
        if (i11 < 0) {
            i11 = -i11;
            c11 = '-';
        } else {
            c11 = 0;
        }
        while (i11 >= 65536) {
            int i13 = i11 / 100;
            int i14 = i11 - (((i13 << 6) + (i13 << 5)) + (i13 << 2));
            cArr[i12 - 1] = f15567n[i14];
            i12 -= 2;
            cArr[i12] = f15566m[i14];
            i11 = i13;
        }
        while (true) {
            int i15 = (52429 * i11) >>> 19;
            int i16 = i12 - 1;
            cArr[i16] = f15565l[i11 - ((i15 << 3) + (i15 << 1))];
            if (i15 == 0) {
                break;
            }
            i11 = i15;
            i12 = i16;
        }
        if (c11 != 0) {
            cArr[i12 - 2] = c11;
        }
    }

    public static void j(long j11, int i11, char[] cArr) {
        char c11;
        if (j11 < 0) {
            j11 = -j11;
            c11 = '-';
        } else {
            c11 = 0;
        }
        while (j11 > 2147483647L) {
            long j12 = j11 / 100;
            int i12 = (int) (j11 - (((j12 << 6) + (j12 << 5)) + (j12 << 2)));
            cArr[i11 - 1] = f15567n[i12];
            i11 -= 2;
            cArr[i11] = f15566m[i12];
            j11 = j12;
        }
        int i13 = (int) j11;
        while (i13 >= 65536) {
            int i14 = i13 / 100;
            int i15 = i13 - (((i14 << 6) + (i14 << 5)) + (i14 << 2));
            cArr[i11 - 1] = f15567n[i15];
            i11 -= 2;
            cArr[i11] = f15566m[i15];
            i13 = i14;
        }
        while (true) {
            int i16 = (52429 * i13) >>> 19;
            int i17 = i11 - 1;
            cArr[i17] = f15565l[i13 - ((i16 << 3) + (i16 << 1))];
            if (i16 == 0) {
                break;
            }
            i13 = i16;
            i11 = i17;
        }
        if (c11 != 0) {
            cArr[i11 - 2] = c11;
        }
    }

    public static String k(String str) {
        String property;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        return property == null ? f15554a.getProperty(str) : property;
    }

    public static boolean l(char c11) {
        boolean[] zArr = f15558e;
        return c11 < zArr.length && zArr[c11];
    }

    public static void m() {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new a());
        if (inputStream != null) {
            try {
                f15554a.load(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String n(Reader reader) {
        StringBuilder sb2 = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int i11 = reader.read(cArr, 0, 2048);
                if (i11 < 0) {
                    return sb2.toString();
                }
                sb2.append(cArr, 0, i11);
            }
        } catch (Exception e11) {
            throw new JSONException("read string from reader error", e11);
        }
    }

    public static int o(int i11) {
        int i12 = 0;
        while (i11 > f15568o[i12]) {
            i12++;
        }
        return i12 + 1;
    }

    public static int p(long j11) {
        long j12 = 10;
        for (int i11 = 1; i11 < 19; i11++) {
            if (j11 < j12) {
                return i11;
            }
            j12 *= 10;
        }
        return 19;
    }
}
