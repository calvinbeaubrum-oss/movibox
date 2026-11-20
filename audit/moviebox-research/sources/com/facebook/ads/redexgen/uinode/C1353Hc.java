package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1353Hc {
    public static byte[] A02;
    public final File A00;
    public final File A01;

    static {
        A02();
    }

    public C1353Hc(File file) {
        this.A01 = file;
        this.A00 = new File(file.getPath() + A00(16, 4, 42));
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 96);
        }
        return new String(bArrCopyOfRange);
    }

    private void A01() {
        if (this.A00.exists()) {
            this.A01.delete();
            this.A00.renameTo(this.A01);
        }
    }

    public static void A02() {
        A02 = new byte[]{-63, Ascii.NAK, Ascii.DLE, -63, 3, 2, 4, Ascii.FF, Ascii.SYN, 17, -63, 7, 10, Ascii.CR, 6, -63, -72, -20, -21, -11, -31, Ascii.DC4, Ascii.SI, Ascii.CR, 9, 3, -26, 9, Ascii.FF, 5, -20, Ascii.CAN, Ascii.RS, Ascii.NAK, Ascii.CR, Ascii.ETB, -48, Ascii.GS, -55, Ascii.FF, Ascii.ESC, Ascii.SO, 10, Ascii.GS, Ascii.SO, -55, -79, -35, -29, -38, -46, -36, -107, -30, -114, -47, -32, -45, -49, -30, -45, -114, -46, -41, -32, -45, -47, -30, -35, -32, -25, -114, -1, 43, 49, 40, 32, 42, -29, 48, -36, 46, 33, 42, Ascii.GS, 41, 33, -36, 34, 37, 40, 33, -36};
    }

    public final C1352Hb A03() throws IOException {
        if (this.A01.exists()) {
            if (this.A00.exists()) {
                this.A01.delete();
            } else if (!this.A01.renameTo(this.A00)) {
                Log.w(A00(20, 10, 64), A00(72, 21, 92) + this.A01 + A00(0, 16, 65) + this.A00);
            }
        }
        try {
            return new C1352Hb(this.A01);
        } catch (FileNotFoundException e11) {
            if (!this.A01.getParentFile().mkdirs()) {
                throw new IOException(A00(46, 26, 14) + this.A01, e11);
            }
            try {
                return new C1352Hb(this.A01);
            } catch (FileNotFoundException e12) {
                throw new IOException(A00(30, 16, 73) + this.A01, e12);
            }
        }
    }

    public final InputStream A04() throws FileNotFoundException {
        A01();
        return new FileInputStream(this.A01);
    }

    public final void A05() {
        this.A01.delete();
        this.A00.delete();
    }

    public final void A06(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.A00.delete();
    }
}
