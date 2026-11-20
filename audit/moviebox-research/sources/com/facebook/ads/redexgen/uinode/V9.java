package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.transsion.gslb.Worker;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class V9 implements C6U {
    public static byte[] A03;
    public static String[] A04 = {"WE91vPqiHLcyJwrbQHRJcIvZwn5D9l", "3LK2x46Pp3Ld9onr8DyN9Ggm", "60IU9PqapOW3gkaytJRkZEg3", "UqNMzTGRyBNLAx", "QjYmXRpW4", "DeQ01HErfJf7NLfnuVX6corDAbYDzPur", "bhlqPTI7mETXQlgoFXHPJBBhjQPpzoup", "oYTMQ3SHL"};
    public final /* synthetic */ C1913bK A00;
    public final /* synthetic */ V2 A01;
    public final /* synthetic */ boolean A02;

    static {
        A01();
    }

    public V9(V2 v11, C1913bK c1913bK, boolean z11) {
        this.A01 = v11;
        this.A00 = c1913bK;
        this.A02 = z11;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 60);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-16, Ascii.VT, 19, Ascii.SYN, Ascii.SI, Ascii.SO, -54, Ascii.RS, Ascii.EM, -54, Ascii.SO, Ascii.EM, 33, Ascii.CAN, Ascii.SYN, Ascii.EM, Ascii.VT, Ascii.SO, -54, Ascii.VT, -54, Ascii.ETB, Ascii.SI, Ascii.SO, 19, Ascii.VT, -40};
    }

    @Override // com.facebook.ads.redexgen.uinode.C6U
    public final void AB2() {
        if (this.A01.A0a != null) {
            this.A01.A0a.A0J();
            this.A01.A0a = null;
        }
        AdErrorType adErrorType = AdErrorType.CACHE_FAILURE_ERROR;
        String strA00 = A00(0, 27, Worker.WHAT_QUIT);
        this.A01.A0c.A0E().A2m(C1453Lf.A01(this.A01.A00), adErrorType.getErrorCode(), strA00);
        if (this.A01.A0G != null) {
            V2 v11 = this.A01;
            String[] strArr = A04;
            if (strArr[4].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A04[6] = "7cQ3648pyLFx7h83cxUuTBVDS0jRS450";
            v11.A0G.ABR(C1401Jb.A01(adErrorType, strA00));
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.C6U
    public final void ABB() {
        this.A01.A0a = this.A00;
        if (this.A02 && this.A01.A0A != null) {
            FO fo2 = this.A01.A0A;
            String[] strArr = A04;
            if (strArr[4].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[4] = "vb7V14ygc";
            strArr2[7] = "eJXYUqUMt";
            fo2.A0I();
        }
        if (this.A01.A0G != null) {
            if (this.A01.A0E.equals(JL.A04) && !this.A01.A0q()) {
                this.A01.A0G.ACF();
            }
            if (this.A02) {
                if (!C1384Ih.A1Q(this.A01.A0c) || this.A01.A0z() == null || !this.A01.A0z().A0m()) {
                    this.A01.A0G.AAg();
                } else {
                    V2 v11 = this.A01;
                    v11.A0M = PC.A01(v11.A0c, this.A01.A0z(), 4, new VA(this));
                }
            }
        }
    }
}
