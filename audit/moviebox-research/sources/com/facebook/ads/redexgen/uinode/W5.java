package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class W5 implements InterfaceC1346Gu {
    public static byte[] A06;
    public static String[] A07 = {"LZDHzUEPY8huLib8qPH1v7czaaxlCYVW", "Hfajs1uaSYD8XiY9EEWii1aSJKbCXH1k", "56ilEDtV1sbTjQDLh", "Yd2dmsZ5", "tr3yrs0rtPd5aa0L", "Zl3VJckSqinxve9JbD33GDfHo4YeuNba", "", ""};
    public long A00;
    public Uri A01;
    public InputStream A02;
    public boolean A03;
    public final AssetManager A04;
    public final HG<? super W5> A05;

    static {
        A01();
    }

    public W5(Context context, HG<? super W5> hg2) {
        this.A04 = context.getAssets();
        this.A05 = hg2;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A07;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A07[3] = "kcdTjQCUlglhSnU2yukjc";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 41);
            i14++;
        }
    }

    public static void A01() {
        A06 = new byte[]{100, 107, -99, -86, -96, -82, -85, -91, -96, -101, -99, -81, -81, -95, -80, 107};
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final Uri A8E() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final long ADl(C1350Gy c1350Gy) throws C1339Gn {
        try {
            Uri uri = c1350Gy.A04;
            this.A01 = uri;
            String path = uri.getPath();
            if (path.startsWith(A00(1, 15, 19))) {
                path = path.substring(15);
            } else if (path.startsWith(A00(0, 1, 12))) {
                path = path.substring(1);
            }
            InputStream inputStreamOpen = this.A04.open(path, 1);
            this.A02 = inputStreamOpen;
            if (inputStreamOpen.skip(c1350Gy.A03) < c1350Gy.A03) {
                throw new EOFException();
            }
            if (c1350Gy.A02 != -1) {
                this.A00 = c1350Gy.A02;
            } else {
                long jAvailable = this.A02.available();
                this.A00 = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.A00 = -1L;
                }
            }
            this.A03 = true;
            HG<? super W5> hg2 = this.A05;
            if (hg2 != null) {
                hg2.ADP(this, c1350Gy);
            }
            return this.A00;
        } catch (IOException e11) {
            throw new C1339Gn(e11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final void close() throws C1339Gn {
        this.A01 = null;
        try {
            try {
                InputStream inputStream = this.A02;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.A02 = null;
                if (this.A03) {
                    this.A03 = false;
                    HG<? super W5> hg2 = this.A05;
                    if (hg2 != null) {
                        hg2.ADO(this);
                    }
                }
            } catch (IOException e11) {
                throw new C1339Gn(e11);
            }
        } catch (Throwable th2) {
            this.A02 = null;
            if (this.A03) {
                this.A03 = false;
                HG<? super W5> hg3 = this.A05;
                if (hg3 != null) {
                    hg3.ADO(this);
                }
            }
            throw th2;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final int read(byte[] bArr, int i11, int i12) throws C1339Gn {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.A00;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, i12);
            } catch (IOException e11) {
                throw new C1339Gn(e11);
            }
        }
        int i13 = this.A02.read(bArr, i11, i12);
        if (i13 == -1) {
            if (this.A00 == -1) {
                return -1;
            }
            throw new C1339Gn(new EOFException());
        }
        long j12 = this.A00;
        if (j12 != -1) {
            long j13 = i13;
            if (A07[3].length() == 13) {
                throw new RuntimeException();
            }
            A07[4] = "Doxe12teItAf98KBLMhQOs4gzgBHzz";
            this.A00 = j12 - j13;
        }
        HG<? super W5> hg2 = this.A05;
        if (hg2 != null) {
            hg2.AB1(this, i13);
        }
        return i13;
    }
}
