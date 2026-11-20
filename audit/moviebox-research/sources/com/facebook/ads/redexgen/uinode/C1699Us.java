package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Us, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1699Us implements RL {
    public static byte[] A03;
    public final /* synthetic */ long A00;
    public final /* synthetic */ K1 A01;
    public final /* synthetic */ K4 A02;

    static {
        A01();
    }

    public C1699Us(K4 k11, K1 k12, long j11) {
        this.A02 = k11;
        this.A01 = k12;
        this.A00 = j11;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{103, 54, 102, 103, 100, 53, 105, 101, 109, 116, 104, 105, 98, 95, 68, 66, 87, 83, 78, 72, 73, Ascii.GS, 7, Ascii.CAN, 46, 57, 61, 46, 57, 107, 46, 57, 57, 36, 57, 107, 36, 40, 40, 62, 57, 57, 46, 47, 108, 90, 77, 73, 90, 77, Ascii.US, 77, 90, 79, 83, 86, 90, 91, Ascii.US, 76, 74, 92, 92, 90, 76, 76, 89, 74, 83, 83, 70, 122, 123, 32, 124, 123, 41, 47, 75, 74, 103, 75, 73, 84, 72, 65, 80, 65, 95, 94, 117, 66, 66, 95, 66};
    }

    private final void A02(RX rx2) {
        K0.A06(this.A01);
        try {
            RJ rjA00 = rx2.A00();
            if (rjA00 != null) {
                String strA69 = rjA00.A69();
                K7 k7A06 = this.A02.A05.A06(this.A02.A04, strA69, this.A00);
                if (k7A06.A01() == K6.A03) {
                    C1696Uo c1696Uo = (C1696Uo) k7A06;
                    String strA04 = c1696Uo.A04();
                    AdErrorType adErrorTypeAdErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(c1696Uo.A03(), AdErrorType.ERROR_MESSAGE);
                    if (strA04 != null) {
                        strA69 = strA04;
                    }
                    this.A02.A04.A0E().A2v(C1453Lf.A01(this.A02.A00), adErrorTypeAdErrorTypeFromCode.getErrorCode(), strA69, adErrorTypeAdErrorTypeFromCode.isPublicError());
                    this.A02.A0D(C1401Jb.A01(adErrorTypeAdErrorTypeFromCode, strA69));
                    return;
                }
            }
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String message = rx2.getMessage();
            this.A02.A04.A0E().A2v(C1453Lf.A01(this.A02.A00), adErrorType.getErrorCode(), message, adErrorType.isPublicError());
            this.A02.A0D(C1401Jb.A01(adErrorType, message));
        } catch (JSONException e11) {
            AdErrorType adErrorType2 = AdErrorType.NETWORK_ERROR;
            String message2 = rx2.getMessage();
            this.A02.A04.A0E().A2v(C1453Lf.A01(this.A02.A00), adErrorType2.getErrorCode(), A00(8, 15, 45) + e11.getMessage(), adErrorType2.isPublicError());
            this.A02.A0D(C1401Jb.A01(adErrorType2, message2));
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.RL
    public final void AB9(RJ rj2) {
        AbstractC1414Jp.A05(A00(78, 10, 46), A00(44, 27, 53), A00(0, 8, 90));
        if (rj2 != null) {
            String strA69 = rj2.A69();
            K0.A06(this.A01);
            this.A02.A0N(strA69, this.A00, this.A01);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.RL
    public final void ABS(Exception exc) {
        AbstractC1414Jp.A05(A00(88, 7, 58), A00(23, 21, 65), A00(71, 7, 18));
        if (RX.class.equals(exc.getClass())) {
            A02((RX) exc);
            return;
        }
        AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
        String message = exc.getMessage();
        this.A02.A04.A0E().A2v(C1453Lf.A01(this.A02.A00), adErrorType.getErrorCode(), message, adErrorType.isPublicError());
        this.A02.A0D(C1401Jb.A01(adErrorType, message));
    }
}
