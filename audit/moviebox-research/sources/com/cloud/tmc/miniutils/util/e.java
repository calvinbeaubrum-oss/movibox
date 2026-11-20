package com.cloud.tmc.miniutils.util;

import android.annotation.SuppressLint;
import android.support.v4.media.session.PlaybackStateCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f31988a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f31989b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @SuppressLint({"DefaultLocale"})
    public static String a(long j11, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("precision shouldn't be less than zero!");
        }
        if (j11 < 0) {
            throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
        }
        if (j11 < 1024) {
            return String.format("%." + i11 + "fB", Double.valueOf(j11));
        }
        if (j11 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return String.format("%." + i11 + "fKB", Double.valueOf(j11 / 1024.0d));
        }
        if (j11 < 1073741824) {
            return String.format("%." + i11 + "fMB", Double.valueOf(j11 / 1048576.0d));
        }
        return String.format("%." + i11 + "fGB", Double.valueOf(j11 / 1.073741824E9d));
    }

    public static String b(byte[] bArr) {
        return c(bArr, true);
    }

    public static String c(byte[] bArr, boolean z11) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = z11 ? f31988a : f31989b;
        int length = bArr.length;
        if (length <= 0) {
            return "";
        }
        char[] cArr2 = new char[length << 1];
        int i11 = 0;
        for (byte b11 : bArr) {
            int i12 = i11 + 1;
            cArr2[i11] = cArr[(b11 >> 4) & 15];
            i11 += 2;
            cArr2[i12] = cArr[b11 & Ascii.SI];
        }
        return new String(cArr2);
    }

    public static ByteArrayOutputStream d(InputStream inputStream) {
        try {
            if (inputStream == null) {
                return null;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i11 = inputStream.read(bArr, 0, 8192);
                        if (i11 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i11);
                    }
                    byteArrayOutputStream.close();
                    try {
                        inputStream.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                    return byteArrayOutputStream;
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (IOException e12) {
                e12.printStackTrace();
                try {
                    inputStream.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
                return null;
            }
        } catch (Throwable th4) {
            try {
                inputStream.close();
            } catch (IOException e14) {
                e14.printStackTrace();
            }
            throw th4;
        }
    }

    public static byte[] e(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStreamD = d(inputStream);
        return byteArrayOutputStreamD == null ? new byte[0] : byteArrayOutputStreamD.toByteArray();
    }
}
