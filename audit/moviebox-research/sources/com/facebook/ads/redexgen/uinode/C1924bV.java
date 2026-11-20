package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1924bV extends KT {
    public static byte[] A02;
    public final /* synthetic */ C09660w A00;
    public final /* synthetic */ JSONObject A01;

    static {
        A02();
    }

    public C1924bV(C09660w c09660w, JSONObject jSONObject) {
        this.A00 = c09660w;
        this.A01 = jSONObject;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 21);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{7, 19, 4, Ascii.DLE, Ascii.DC4, 4, Ascii.SI, 2, Ascii.CAN, 62, 2, 0, 17, 17, 8, Ascii.SI, 6};
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        try {
            this.A00.A05.await();
            synchronized (this.A00.A02) {
                try {
                    this.A00.A02.A0B(this.A01);
                    this.A00.A06.countDown();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (InterruptedException e11) {
            this.A00.A03.A07().A9a(A00(0, 17, 116), C8A.A1B, new C8B(e11));
        } catch (JSONException e12) {
            this.A00.A0M();
            this.A00.A03.A07().A9a(A00(0, 17, 116), C8A.A1A, new C8B(e12));
        }
    }
}
