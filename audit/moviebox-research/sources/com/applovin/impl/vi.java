package com.applovin.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.sdk.utils.StringUtils;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class vi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f23908a = {-83, -98, -53, -112, -29, -118, 55, 117, 59, 8, -12, -15, 73, 110, -67, 57, 117, 4, -26, 97, 66, -12, 125, 91, -119, -103, -30, 114, 123, 54, 51, -77};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f23909b;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        NONE(-1),
        DEFAULT(0),
        V2(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f23914a;

        a(int i11) {
            this.f23914a = i11;
        }

        public static a a(int i11) {
            if (i11 != 0 && i11 == 1) {
                return V2;
            }
            return DEFAULT;
        }

        public int b() {
            return this.f23914a;
        }
    }

    static {
        byte[] bArr = new byte[32];
        f23909b = bArr;
        System.arraycopy(new byte[]{Ascii.DC2, Ascii.FF, Ascii.FS, Ascii.DC4, 17, Ascii.ETB, Ascii.SUB, 9, Ascii.NAK, 3, Ascii.SO, Ascii.GS, 4, 0, 2, 7, 10, Ascii.GS, 6, Ascii.DC4, 1}, 0, bArr, 0, 21);
    }

    private static int a(byte[] bArr, byte b11) {
        if (bArr != null && bArr.length != 0) {
            for (int i11 = 0; i11 < bArr.length; i11++) {
                if (bArr[i11] == b11) {
                    return i11;
                }
            }
        }
        return -1;
    }

    private static String a(String str) {
        return str.replace('-', '+').replace('_', '/').replace('*', '=');
    }

    private static String a(String str, String str2, com.applovin.impl.sdk.j jVar) {
        String str3;
        String[] strArrSplit = str.split(":");
        char c11 = 0;
        try {
            try {
                if (!"1".equals(strArrSplit[0])) {
                    return null;
                }
                try {
                    if (strArrSplit.length != 4) {
                        return null;
                    }
                    String str4 = strArrSplit[1];
                    String str5 = strArrSplit[2];
                    byte[] bArrB = b(strArrSplit[3]);
                    if (!str2.endsWith(str5)) {
                        return null;
                    }
                    byte[] bArr = f23908a;
                    if (!a(bArr, jVar).equals(str4)) {
                        return null;
                    }
                    char c12 = ' ';
                    byte[] bArrA = a(str2.substring(0, 32), bArr, jVar);
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrB);
                    char c13 = '\b';
                    long j11 = (((long) ((byteArrayInputStream.read() ^ bArrA[1]) & 255)) << 8) | ((long) ((byteArrayInputStream.read() ^ bArrA[0]) & 255)) | (((long) ((byteArrayInputStream.read() ^ bArrA[2]) & 255)) << 16) | (((long) ((byteArrayInputStream.read() ^ bArrA[3]) & 255)) << 24) | (((long) ((byteArrayInputStream.read() ^ bArrA[4]) & 255)) << 32) | (((long) ((byteArrayInputStream.read() ^ bArrA[5]) & 255)) << 40) | (((long) ((byteArrayInputStream.read() ^ bArrA[6]) & 255)) << 48) | (((long) ((byteArrayInputStream.read() ^ bArrA[7]) & 255)) << 56);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[8];
                    int i11 = byteArrayInputStream.read(bArr2);
                    int i12 = 0;
                    while (i11 >= 0) {
                        ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
                        long j12 = ((long) i12) + j11;
                        long j13 = (j12 ^ (j12 >> 33)) * (-4417276706812531889L);
                        long j14 = (j13 ^ (j13 >> 29)) * (-8796714831421723037L);
                        long j15 = j14 ^ (j14 >> c12);
                        byteArrayOutputStream.write((byte) (((long) (bArr2[c11] ^ bArrA[i12 % bArrA.length])) ^ (j15 & 255)));
                        byteArrayOutputStream.write((byte) (((long) (bArrA[(i12 + 1) % bArrA.length] ^ bArr2[1])) ^ ((j15 >> c13) & 255)));
                        byteArrayOutputStream.write((byte) (((long) (bArrA[(i12 + 2) % bArrA.length] ^ bArr2[2])) ^ ((j15 >> 16) & 255)));
                        byteArrayOutputStream.write((byte) (((long) (bArr2[3] ^ bArrA[(i12 + 3) % bArrA.length])) ^ ((j15 >> 24) & 255)));
                        byteArrayOutputStream.write((byte) (((long) (bArrA[(i12 + 4) % bArrA.length] ^ bArr2[4])) ^ ((j15 >> 32) & 255)));
                        byteArrayOutputStream.write((byte) (((long) (bArrA[(i12 + 5) % bArrA.length] ^ bArr2[5])) ^ ((j15 >> 40) & 255)));
                        byteArrayOutputStream.write((byte) (((long) (bArrA[(i12 + 6) % bArrA.length] ^ bArr2[6])) ^ ((j15 >> 48) & 255)));
                        byteArrayOutputStream.write((byte) (((long) (bArr2[7] ^ bArrA[(i12 + 7) % bArrA.length])) ^ ((j15 >> 56) & 255)));
                        i12 += 8;
                        byteArrayInputStream = byteArrayInputStream2;
                        i11 = byteArrayInputStream2.read(bArr2);
                        j11 = j11;
                        c13 = '\b';
                        c11 = 0;
                        c12 = ' ';
                    }
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8").trim();
                } catch (IOException e11) {
                    e = e11;
                    str3 = null;
                    com.applovin.impl.sdk.n.b("AppLovinSdk", "Failed to read bytes", e);
                    jVar.E().a("AppLovinSdk", "decode", e);
                    return str3;
                }
            } catch (IOException e12) {
                e = e12;
                str3 = null;
            }
        } catch (UnsupportedEncodingException e13) {
            jVar.E().a("AppLovinSdk", "decode", e13);
            throw new RuntimeException("UTF-8 encoding not found", e13);
        }
    }

    private static String a(byte[] bArr) {
        return new String(bArr, "UTF-8").replace('+', '-').replace('/', '_').replace('=', '*');
    }

    private static String a(byte[] bArr, com.applovin.impl.sdk.j jVar) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_1);
            messageDigest.update(bArr);
            return StringUtils.toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e11) {
            jVar.E().a("AppLovinSdk", "SHA1", e11);
            throw new RuntimeException("SHA-1 algorithm not found", e11);
        }
    }

    private static String a(byte[] bArr, String str, com.applovin.impl.sdk.j jVar) {
        try {
            int iC = c(bArr, str, jVar);
            if (iC == 0) {
                return null;
            }
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, iC, bArr.length);
            if (bArrCopyOfRange.length < 16) {
                return null;
            }
            long jA = yp.a(bArrCopyOfRange, 8);
            byte[] bArrA = a(str.substring(0, 32), f23909b, jVar);
            return new String(yp.d(a(Arrays.copyOfRange(bArrCopyOfRange, 16, bArrCopyOfRange.length), jA ^ yp.c(bArrA), bArrA)), "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            jVar.E().a("AppLovinSdk", "decode2", e11);
            throw new RuntimeException("UTF-8 encoding not found", e11);
        } catch (IOException e12) {
            com.applovin.impl.sdk.n.b("AppLovinSdk", "Failed to ungzip decode", e12);
            jVar.E().a("AppLovinSdk", "decode2", e12);
            return null;
        }
    }

    public static byte[] a(String str, long j11, a aVar, String str2, com.applovin.impl.sdk.j jVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("No SDK key specified");
        }
        if (str2.length() < 80) {
            throw new IllegalArgumentException("SDK key is too short");
        }
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        if (a.NONE == aVar) {
            return str.getBytes();
        }
        return a.V2 == aVar ? a(str, j11, false, str2, jVar) : a(str, j11, str2, jVar);
    }

    private static byte[] a(String str, long j11, String str2, com.applovin.impl.sdk.j jVar) {
        char c11 = ' ';
        try {
            String strSubstring = str2.substring(32);
            String strSubstring2 = str2.substring(0, 32);
            byte[] bytes = str.getBytes("UTF-8");
            byte[] bArrA = a(strSubstring2, f23908a, jVar);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(((byte) (j11 & 255)) ^ bArrA[0]);
            byteArrayOutputStream.write(((byte) ((j11 >> 8) & 255)) ^ bArrA[1]);
            byteArrayOutputStream.write(((byte) ((j11 >> 16) & 255)) ^ bArrA[2]);
            byteArrayOutputStream.write(((byte) ((j11 >> 24) & 255)) ^ bArrA[3]);
            byteArrayOutputStream.write(((byte) ((j11 >> 32) & 255)) ^ bArrA[4]);
            byteArrayOutputStream.write(((byte) ((j11 >> 40) & 255)) ^ bArrA[5]);
            byteArrayOutputStream.write(((byte) ((j11 >> 48) & 255)) ^ bArrA[6]);
            byteArrayOutputStream.write(((byte) ((j11 >> 56) & 255)) ^ bArrA[7]);
            int i11 = 0;
            while (i11 < bytes.length) {
                long j12 = j11 + ((long) i11);
                long j13 = (j12 ^ (j12 >> 33)) * (-4417276706812531889L);
                long j14 = (j13 ^ (j13 >> 29)) * (-8796714831421723037L);
                long j15 = j14 ^ (j14 >> c11);
                String str3 = strSubstring;
                byteArrayOutputStream.write((byte) (((long) ((i11 >= bytes.length ? (byte) 0 : bytes[i11]) ^ bArrA[i11 % bArrA.length])) ^ (j15 & 255)));
                int i12 = i11 + 1;
                byteArrayOutputStream.write((byte) (((long) (bArrA[i12 % bArrA.length] ^ (i12 >= bytes.length ? (byte) 0 : bytes[i12]))) ^ ((j15 >> 8) & 255)));
                int i13 = i11 + 2;
                byteArrayOutputStream.write((byte) (((long) (bArrA[i13 % bArrA.length] ^ (i13 >= bytes.length ? (byte) 0 : bytes[i13]))) ^ ((j15 >> 16) & 255)));
                int i14 = i11 + 3;
                byteArrayOutputStream.write((byte) (((long) (bArrA[i14 % bArrA.length] ^ (i14 >= bytes.length ? (byte) 0 : bytes[i14]))) ^ ((j15 >> 24) & 255)));
                int i15 = i11 + 4;
                byteArrayOutputStream.write((byte) (((long) (bArrA[i15 % bArrA.length] ^ (i15 >= bytes.length ? (byte) 0 : bytes[i15]))) ^ ((j15 >> 32) & 255)));
                int i16 = i11 + 5;
                byteArrayOutputStream.write((byte) (((long) (bArrA[i16 % bArrA.length] ^ (i16 >= bytes.length ? (byte) 0 : bytes[i16]))) ^ ((j15 >> 40) & 255)));
                int i17 = i11 + 6;
                byteArrayOutputStream.write((byte) (((long) (bArrA[i17 % bArrA.length] ^ (i17 >= bytes.length ? (byte) 0 : bytes[i17]))) ^ ((j15 >> 48) & 255)));
                int i18 = i11 + 7;
                byteArrayOutputStream.write((byte) (((long) (bArrA[i18 % bArrA.length] ^ (i18 >= bytes.length ? (byte) 0 : bytes[i18]))) ^ ((j15 >> 56) & 255)));
                i11 += 8;
                strSubstring = str3;
                c11 = ' ';
            }
            String str4 = strSubstring;
            String strC = c(byteArrayOutputStream.toByteArray());
            return ("1:" + a(f23908a, jVar) + ":" + str4 + ":" + strC).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e11) {
            jVar.E().a("AppLovinSdk", "encode", e11);
            return null;
        }
    }

    private static byte[] a(String str, long j11, boolean z11, String str2, com.applovin.impl.sdk.j jVar) {
        ByteBuffer byteBufferAllocate;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length;
            String strSubstring = str2.substring(32);
            String strSubstring2 = str2.substring(0, 32);
            byte[] bArr = f23909b;
            byte[] bArrA = a(strSubstring2, bArr, jVar);
            long jC = yp.c(bArrA) ^ j11;
            byte[] bytes2 = String.format("2:%s:%s:", a(bArr, jVar), strSubstring).getBytes();
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(16);
            byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate2.putLong(length);
            byteBufferAllocate2.putLong(jC);
            byteBufferAllocate2.flip();
            byte[] bArrA2 = a(yp.a(bytes), j11, bArrA);
            if (z11) {
                byte[] bytes3 = c(byteBufferAllocate2.array()).getBytes();
                byte[] bytes4 = c(bArrA2).getBytes();
                byteBufferAllocate = ByteBuffer.allocate(bytes2.length + bytes3.length + bytes4.length);
                byteBufferAllocate.put(bytes2);
                byteBufferAllocate.put(bytes3);
                byteBufferAllocate.put(bytes4);
            } else {
                byteBufferAllocate = ByteBuffer.allocate(bytes2.length + byteBufferAllocate2.remaining() + bArrA2.length);
                byteBufferAllocate.put(bytes2);
                byteBufferAllocate.put(byteBufferAllocate2);
                byteBufferAllocate.put(bArrA2);
            }
            byteBufferAllocate.flip();
            return byteBufferAllocate.array();
        } catch (UnsupportedEncodingException e11) {
            jVar.E().a("AppLovinSdk", "encode2", e11);
            throw new RuntimeException("UTF-8 encoding not found", e11);
        } catch (IOException e12) {
            jVar.E().a("AppLovinSdk", "encode2", e12);
            return null;
        }
    }

    private static byte[] a(String str, byte[] bArr, com.applovin.impl.sdk.j jVar) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256);
            messageDigest.update(bArr);
            messageDigest.update(str.getBytes("UTF-8"));
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e11) {
            jVar.E().a("AppLovinSdk", "SHA256", e11);
            throw new RuntimeException("SHA-256 algorithm not found", e11);
        }
    }

    private static byte[] a(byte[] bArr, long j11, byte[] bArr2) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        long j12 = j11;
        for (int i11 = 0; i11 < bArr.length; i11++) {
            int i12 = i11 % 8;
            if (i12 == 0) {
                long j13 = ((long) i11) + j11;
                long j14 = (j13 ^ (j13 >>> 33)) * (-4417276706812531889L);
                long j15 = (j14 ^ (j14 >>> 29)) * (-8796714831421723037L);
                j12 = j15 ^ (j15 >>> 32);
            }
            bArrCopyOf[i11] = (byte) (((long) bArrCopyOf[i11]) ^ (((j12 >> (i12 * 8)) & 255) ^ ((long) bArr2[i11 % bArr2.length])));
        }
        return bArrCopyOf;
    }

    public static a b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return a.NONE;
        }
        char c11 = (char) bArr[0];
        if (c11 == '2') {
            return a.V2;
        }
        return c11 == '{' ? a.NONE : a.DEFAULT;
    }

    public static String b(String str, long j11, a aVar, String str2, com.applovin.impl.sdk.j jVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("No SDK key specified");
        }
        if (str2.length() < 80) {
            throw new IllegalArgumentException("SDK key is too short");
        }
        if (TextUtils.isEmpty(str) || a.NONE == aVar) {
            return str;
        }
        byte[] bArrA = a.V2 == aVar ? a(str, j11, true, str2, jVar) : a(str, j11, str2, jVar);
        if (bArrA != null) {
            return new String(bArrA);
        }
        return null;
    }

    public static String b(byte[] bArr, String str, com.applovin.impl.sdk.j jVar) {
        if (str == null) {
            throw new IllegalArgumentException("No SDK key specified");
        }
        if (str.length() < 80) {
            throw new IllegalArgumentException("SDK key is too short");
        }
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        a aVarB = b(bArr);
        if (a.NONE == aVarB) {
            return new String(bArr);
        }
        return aVarB == a.V2 ? a(bArr, str, jVar) : a(new String(bArr), str, jVar);
    }

    private static byte[] b(String str) {
        return Base64.decode(a(str), 0);
    }

    private static int c(byte[] bArr, String str, com.applovin.impl.sdk.j jVar) {
        int iA;
        int i11;
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str) || (iA = a(bArr, (byte) 58)) < 0) {
            return 0;
        }
        byte[] bytes = a(f23909b, jVar).getBytes();
        int i12 = iA + 1;
        int length = bytes.length + i12;
        if (bArr.length <= length || bArr[length] != 58 || bArr.length <= (i11 = length + 55) || bArr[i11] != 58 || !Arrays.equals(Arrays.copyOfRange(bArr, i12, bytes.length + i12), bytes)) {
            return 0;
        }
        int i13 = length + 56;
        if (length + 64 > bArr.length) {
            return 0;
        }
        return i13;
    }

    private static String c(byte[] bArr) {
        return a(Base64.encode(bArr, 2));
    }
}
