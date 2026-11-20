package com.facebook.ads.redexgen.uinode;

import androidx.core.view.InputDeviceCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.99, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass99 {
    public static byte[] A04;
    public static String[] A05 = {"btdqbIGvpTpBfKYFtTSeCpf2zLMSjWuW", "UCnuYN2i8QqDrL1bJqeLO8X", "17NvhMWZ0tgUY276aod4TAiq1Nnn8xCb", "9WADZ8HRW24X4wF7eQLzJL", "a4Ju2aEQ", "O93LY1dStxgWVIx73EEjx", "nsSUaFY8IV5Gr54AyiEebsH", "cDIMEtFnlSMThLiJ5sNUGjpBQHcP5mDb"};
    public int A00;
    public long A01;
    public final RandomAccessFile A02;
    public final long[] A03;

    static {
        A06();
    }

    public AnonymousClass99(RandomAccessFile randomAccessFile, long[] jArr, long j11) throws IOException {
        this.A02 = randomAccessFile;
        this.A03 = jArr;
        this.A01 = j11;
        for (int i11 = 0; i11 < jArr.length && jArr[i11] != 0; i11++) {
            this.A00++;
        }
        if (this.A00 > 0) {
            long jA01 = A01();
            if (jArr[0] != jA01) {
                throw new IOException(String.format(Locale.US, A05(373, 43, 23), Long.valueOf(jA01), Long.valueOf(jArr[0])));
            }
        }
        for (int i12 = this.A00; i12 < jArr.length; i12++) {
            if (jArr[i12] != 0) {
                throw new IOException(String.format(Locale.US, A05(InputDeviceCompat.SOURCE_KEYBOARD, 66, 53), Integer.valueOf(i12), Integer.valueOf(this.A00), Long.valueOf(jArr[i12])));
            }
        }
        int i13 = 1;
        while (true) {
            int i14 = this.A00;
            if (i13 >= i14) {
                if (i14 > 0 && jArr[i14 - 1] > j11) {
                    throw new IOException(String.format(Locale.US, A05(323, 50, 51), Integer.valueOf(this.A00 - 1), Long.valueOf(jArr[this.A00 - 1]), Long.valueOf(j11)));
                }
                return;
            } else {
                if (jArr[i13 - 1] > jArr[i13]) {
                    throw new IOException(String.format(Locale.US, A05(207, 50, 45), Integer.valueOf(i13 - 1), Long.valueOf(jArr[i13 - 1]), Integer.valueOf(i13), Long.valueOf(jArr[i13])));
                }
                i13++;
            }
        }
    }

    public static long A00() {
        return 16L;
    }

    private final long A01() {
        return A00() + ((long) (this.A03.length * 8));
    }

    public static long A02(int i11) {
        return A00() + ((long) (i11 * 8));
    }

    public static AnonymousClass99 A03(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, A05(TTAdConstant.PACKAGE_NAME_CODE, 3, 41));
        try {
            randomAccessFile.writeLong(-360011992771067903L);
            randomAccessFile.writeLong(C9A.A03);
            randomAccessFile.write(new byte[C9A.A03 * 8]);
            randomAccessFile.getFD().sync();
            return new AnonymousClass99(randomAccessFile, new long[C9A.A03], randomAccessFile.length());
        } catch (IOException unused) {
            A07(randomAccessFile);
            throw new IOException(String.format(Locale.US, A05(0, 26, 85), file.getCanonicalPath()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
    
        if (r3 <= 100000) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
    
        if (r3 <= 100000) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007a, code lost:
    
        if (r1.length() < A02((int) r3)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007c, code lost:
    
        r3 = new long[(int) r3];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0081, code lost:
    
        if (r2 >= r3.length) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0083, code lost:
    
        r3[r2] = r1.readLong();
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0095, code lost:
    
        return new com.facebook.ads.redexgen.uinode.AnonymousClass99(r1, r3, r1.length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bd, code lost:
    
        throw new java.io.IOException(java.lang.String.format(java.util.Locale.US, A05(117, 63, 43), java.lang.Long.valueOf(r3), java.lang.Long.valueOf(r13.length())));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AnonymousClass99 A04(File file) throws IOException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, A05(TTAdConstant.PACKAGE_NAME_CODE, 3, 41));
            if (file.length() < A00()) {
                throw new IOException(String.format(Locale.US, A05(50, 27, 73), Long.valueOf(file.length()), Long.valueOf(A00())));
            }
            long j11 = randomAccessFile.readLong();
            if (j11 != -360011992771067903L) {
                throw new IOException(String.format(Locale.US, A05(180, 27, 8), Long.valueOf(j11), -360011992771067903L));
            }
            long j12 = randomAccessFile.readLong();
            if (A05[2].charAt(6) != 'W') {
                throw new RuntimeException();
            }
            A05[4] = "xlElL";
            if (j12 >= 0) {
                if (A05[0].length() != 14) {
                    A05[2] = "q6ESdMWTrdGbOlYuWryMU6DvzsK1NaJy";
                }
            }
            throw new IOException(String.format(Locale.US, A05(77, 40, 47), Long.valueOf(j12)));
        } catch (IOException unused) {
            if (0 != 0) {
                A07(null);
            }
            throw new IOException(String.format(Locale.US, A05(26, 24, 0), file.getCanonicalPath()));
        }
    }

    public static String A05(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A04 = new byte[]{-57, -30, -22, -19, -26, -27, -95, -11, -16, -95, -28, -13, -26, -30, -11, -26, -95, -25, -22, -19, -26, -95, -88, -90, -12, -88, 114, -115, -107, -104, -111, -112, 76, -96, -101, 76, -101, -100, -111, -102, 76, -110, -107, -104, -111, 76, 83, 81, -97, 83, -69, -34, -31, -38, -107, -102, -39, -107, -41, -18, -23, -38, -24, -95, -107, -31, -38, -24, -24, -107, -23, -35, -42, -29, -107, -102, -39, -95, -60, -57, -64, 123, -65, -64, -66, -57, -68, -51, -64, -50, 123, -68, 123, -49, -54, -49, -68, -57, 123, -54, -63, 123, -128, -65, 123, -51, -64, -66, -54, -51, -65, 123, -50, -57, -54, -49, -50, -99, -64, -61, -68, 119, -69, -68, -70, -61, -72, -55, -68, -54, 119, -72, 119, -53, -58, -53, -72, -61, 119, -58, -67, 119, 124, -69, 119, -55, -68, -70, -58, -55, -69, 119, -54, -61, -58, -53, -54, -125, 119, -71, -52, -53, 119, -58, -59, -61, -48, 119, -65, -72, -54, 119, 124, -69, 119, -71, -48, -53, -68, -54, 122, -99, -96, -103, 84, -95, -107, -101, -99, -105, 84, 89, -104, 84, -99, -94, -89, -88, -103, -107, -104, 84, -93, -102, 84, 89, -104, -85, -66, -68, -56, -53, -67, 121, 126, -67, 121, -56, -65, -65, -52, -66, -51, 121, -62, -52, 121, 126, -67, -123, 121, -69, -50, -51, 121, -53, -66, -68, -56, -53, -67, 121, 126, -67, 121, -56, -65, -65, -52, -66, -51, 121, -62, -52, 121, 126, -67, -77, -58, -60, -48, -45, -59, -127, -122, -59, -127, -48, -57, -57, -44, -58, -43, -127, -44, -55, -48, -42, -51, -59, -127, -61, -58, -127, -111, -127, -61, -58, -60, -62, -42, -44, -58, -127, -45, -58, -60, -48, -45, -59, -127, -60, -48, -42, -49, -43, -127, -54, -44, -127, -122, -59, -115, -127, -61, -42, -43, -127, -54, -44, -127, -122, -59, -79, -60, -62, -50, -47, -61, Ascii.DEL, -124, -61, Ascii.DEL, -46, -45, -64, -47, -45, -46, Ascii.DEL, -64, -45, Ascii.DEL, -50, -59, -59, -46, -60, -45, Ascii.DEL, -124, -61, -117, Ascii.DEL, -63, -44, -45, Ascii.DEL, -59, -56, -53, -60, Ascii.DEL, -46, -56, -39, -60, Ascii.DEL, -56, -46, Ascii.DEL, -124, -61, -107, -88, -90, -78, -75, -89, 99, 115, 99, -78, -87, -87, -74, -88, -73, 99, -88, -69, -77, -88, -90, -73, -88, -89, 99, -92, -73, 99, 104, -89, 99, -91, -72, -73, 99, -84, -74, 99, -92, -73, 99, 104, -89, -57, -52, -56};
    }

    public static void A07(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }
}
