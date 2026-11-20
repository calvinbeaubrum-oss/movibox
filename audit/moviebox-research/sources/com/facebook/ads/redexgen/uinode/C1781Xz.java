package com.facebook.ads.redexgen.uinode;

import android.os.SystemClock;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1781Xz implements InterfaceC1207As {
    public static byte[] A01;
    public static String[] A02 = {"uFnK", "23brwyJGPu3ZknDoMNdw3hVXVLFEULQy", "FtMR8ROvDO4Zz8SuhvbrIDHAZ1hbcqSx", "4tDbtxEkY45WyXaQwFKWRvOHK17MthWz", "P3L0", "jQPyzSgXTRUrKPul", "L4bq6z2eevSU7Qg95t0o6YCr4fHdh5", "Io3idew6HPzrUVEIzO8xEfp6xkmYSMtW"};
    public final /* synthetic */ C1780Xy A00;

    static {
        A01();
    }

    public C1781Xz(C1780Xy c1780Xy) {
        this.A00 = c1780Xy;
    }

    public /* synthetic */ C1781Xz(C1780Xy c1780Xy, C1210Av c1210Av) {
        this(c1780Xy);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A02[5].length() == 27) {
                throw new RuntimeException();
            }
            A02[5] = "3SKjhf7gYf6c2NzhB";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 109);
            i14++;
        }
    }

    public static void A01() {
        A01 = new byte[]{109, 97, 92, 104, 121, 116, 114, 73, 111, 124, 126, 118, Ascii.DC2, 60, 53, 52, 41, 50, 53, 60, 123, 50, 54, 43, 52, 40, 40, 50, 57, 55, 34, 123, 55, 58, 41, 60, 62, 123, 58, 46, Utf8.REPLACEMENT_BYTE, 50, 52, 123, 55, 58, 47, 62, 53, 56, 34, 97, 123, 35, 0, 5, 2, Ascii.EM, Ascii.US, 5, 3, 80, 17, 5, Ascii.DC4, Ascii.EM, Ascii.US, 80, 4, Ascii.EM, Ascii.GS, Ascii.NAK, 3, 4, 17, Ascii.GS, 0, 80, 88, Ascii.SYN, 2, 17, Ascii.GS, Ascii.NAK, 80, 0, Ascii.US, 3, Ascii.EM, 4, Ascii.EM, Ascii.US, Ascii.RS, 80, Ascii.GS, Ascii.EM, 3, Ascii.GS, 17, 4, 19, Ascii.CAN, 89, 74, 80, 79, 108, 105, 110, 117, 115, 105, 111, 60, 125, 105, 120, 117, 115, 60, 104, 117, 113, 121, 111, 104, 125, 113, 108, 60, 52, 111, 101, 111, 104, 121, 113, 60, Ascii.DEL, 112, 115, Ascii.DEL, 119, 60, 113, 117, 111, 113, 125, 104, Ascii.DEL, 116, 53, 38, 60};
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1207As
    public final void ABv(long j11) {
        Log.w(A00(2, 10, 112), A00(12, 41, 54) + j11);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1207As
    public final void ACi(long j11, long j12, long j13, long j14) {
        StringBuilder sbAppend = new StringBuilder().append(A00(53, 52, 29)).append(j11);
        String strA00 = A00(0, 2, 44);
        String string = sbAppend.append(strA00).append(j12).append(strA00).append(j13).append(strA00).append(j14).append(strA00).append(this.A00.A03()).append(strA00).append(this.A00.A04()).toString();
        if (C1780Xy.A0q) {
            throw new C1213Ay(string, null);
        }
        Log.w(A00(2, 10, 112), string);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1207As
    public final void ADH(long j11, long j12, long j13, long j14) {
        StringBuilder sbAppend = new StringBuilder().append(A00(105, 50, 113)).append(j11);
        String strA00 = A00(0, 2, 44);
        String string = sbAppend.append(strA00).append(j12).append(strA00).append(j13).append(strA00).append(j14).append(strA00).append(this.A00.A03()).append(strA00).append(this.A00.A04()).toString();
        if (C1780Xy.A0q) {
            throw new C1213Ay(string, null);
        }
        String[] strArr = A02;
        if (strArr[4].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        A02[3] = "q4b4TTgkvPPQBYTsQFxk23ASltXkXf65";
        Log.w(A00(2, 10, 112), string);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1207As
    public final void ADQ(int i11, long j11) {
        if (this.A00.A0R != null) {
            this.A00.A0R.ADR(i11, j11, SystemClock.elapsedRealtime() - this.A00.A0E);
        }
    }
}
