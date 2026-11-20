package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PH extends InputStream {
    public static byte[] A04;
    public static String[] A05 = {"5FxkjmViipfuOEmeGZRh1rWuAhi58BIY", "P0uDFh8HOwAWvDVGkGeATzc", "FQ2HPVuJ9Fju5P7EfteSFhbDkCSiUGCr", "lMnDCDrcSzZtU6RMhKfYe1rO633Hkzz8", "BZaCeAJ4mpNw1z6aTzzGkvXJAvKgKDg7", "gl5vlYV0aCgrCc0s0sEnhviYHRKbo8Yg", "Tgc0UJMQxUN8PgOF6KJ9ZKrej2a3tpw", "OSPCme8ftb56UzOVrw2bgiBSvmZFYlRk"};
    public MessageDigest A00;
    public final C1794Ym A01;
    public final PG A02;
    public final FileInputStream A03;

    static {
        A01();
    }

    public PH(C1794Ym c1794Ym, FileInputStream fileInputStream, PG pg2) {
        this.A03 = fileInputStream;
        this.A02 = pg2;
        this.A01 = c1794Ym;
        try {
            this.A00 = MessageDigest.getInstance(A00(0, 3, 30));
        } catch (NoSuchAlgorithmException unused) {
            this.A00 = null;
        }
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A05[7].charAt(24) == 'i') {
                break;
            }
            A05[7] = "wkBtkBfOXubsKwfKzYpxBJzZI93GSJMw";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            byte b11 = bArrCopyOfRange[i14];
            String[] strArr = A05;
            if (strArr[0].charAt(11) == strArr[3].charAt(11)) {
                break;
            }
            String[] strArr2 = A05;
            strArr2[1] = "6MRboz4pfSS0DylRcsmX7nz";
            strArr2[6] = "Z3yJOYkAPU5AGas9ZlGFYfEzislvm9u";
            bArrCopyOfRange[i14] = (byte) ((b11 - i13) - 45);
            i14++;
        }
        throw new RuntimeException();
    }

    public static void A01() {
        A04 = new byte[]{-104, -113, -128, Ascii.VT, Ascii.SUB, 19};
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.A03.available();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return read(new byte[1]);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = this.A03.read(bArr, i11, i12);
        MessageDigest messageDigest = this.A00;
        if (messageDigest != null) {
            if (A05[7].charAt(24) == 'i') {
                throw new RuntimeException();
            }
            A05[2] = "wFnf9K6AarqF2rYbRIkm3wGElU25UaCd";
            try {
                if (i13 > 0) {
                    messageDigest.update(bArr, i11, i13);
                } else if (i13 == -1) {
                    this.A02.A8d(LG.A05(messageDigest.digest()));
                    this.A00 = null;
                }
            } catch (Exception e11) {
                this.A00 = null;
                this.A01.A07().AA2(A00(3, 3, 122), C8A.A13, new C8B(e11));
            }
        }
        return i13;
    }

    @Override // java.io.InputStream
    public final long skip(long j11) throws IOException {
        int i11 = (int) j11;
        byte[] bArr = new byte[1024];
        long j12 = 0;
        while (i11 > 0) {
            int i12 = read(bArr, 0, Math.min(i11, 1024));
            if (i12 <= 0) {
                break;
            }
            i11 -= i12;
            j12 += (long) i12;
        }
        return j12;
    }
}
