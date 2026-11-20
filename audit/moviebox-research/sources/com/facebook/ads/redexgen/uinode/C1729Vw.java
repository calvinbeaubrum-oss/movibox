package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1729Vw implements InterfaceC1346Gu {
    public static byte[] A05;
    public static String[] A06 = {"2AQ", "PKEE8tvP1F9G5CS2asOfHv5i9NmL9OD8", "nghUlW0EKiCso94RSH6SGDaiGhOOZ9vR", "y3nJ4vSOM9HwnTFSw", "dDA", "lgpDjnw", "z3SCjqWwobuDiPiZI", "K1NyJtZzbkl5fIhEU"};
    public long A00;
    public Uri A01;
    public RandomAccessFile A02;
    public boolean A03;
    public final HG<? super C1729Vw> A04;

    static {
        A01();
    }

    public C1729Vw() {
        this(null);
    }

    public C1729Vw(HG<? super C1729Vw> hg2) {
        this.A04 = hg2;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-23};
        if (A06[3].length() == 0) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[2] = "0CNdTW9yzTlkWk7IYlaLkwwChYLMq6mo";
        strArr[1] = "0Hm8psTbLgTGmvvfzx0WFuRjr22Bb9pe";
        A05 = bArr;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final Uri A8E() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final long ADl(C1350Gy c1350Gy) throws H1 {
        try {
            this.A01 = c1350Gy.A04;
            RandomAccessFile randomAccessFile = new RandomAccessFile(c1350Gy.A04.getPath(), A00(0, 1, 20));
            this.A02 = randomAccessFile;
            randomAccessFile.seek(c1350Gy.A03);
            long length = c1350Gy.A02 == -1 ? this.A02.length() - c1350Gy.A03 : c1350Gy.A02;
            this.A00 = length;
            if (length < 0) {
                throw new EOFException();
            }
            this.A03 = true;
            HG<? super C1729Vw> hg2 = this.A04;
            if (hg2 != null) {
                hg2.ADP(this, c1350Gy);
            }
            return this.A00;
        } catch (IOException e11) {
            throw new H1(e11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final void close() throws H1 {
        this.A01 = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.A02;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.A02 = null;
                if (this.A03) {
                    this.A03 = false;
                    HG<? super C1729Vw> hg2 = this.A04;
                    if (hg2 != null) {
                        hg2.ADO(this);
                    }
                }
            } catch (IOException e11) {
                throw new H1(e11);
            }
        } catch (Throwable th2) {
            this.A02 = null;
            if (this.A03) {
                this.A03 = false;
                HG<? super C1729Vw> hg3 = this.A04;
                if (hg3 != null) {
                    hg3.ADO(this);
                }
            }
            throw th2;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final int read(byte[] bArr, int i11, int i12) throws H1 {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.A00;
        if (j11 == 0) {
            return -1;
        }
        try {
            int i13 = this.A02.read(bArr, i11, (int) Math.min(j11, i12));
            if (i13 > 0) {
                this.A00 -= (long) i13;
                HG<? super C1729Vw> hg2 = this.A04;
                if (hg2 != null) {
                    hg2.AB1(this, i13);
                }
            }
            return i13;
        } catch (IOException e11) {
            throw new H1(e11);
        }
    }
}
