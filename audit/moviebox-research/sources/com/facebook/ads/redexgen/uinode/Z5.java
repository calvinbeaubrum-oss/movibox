package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class Z5 extends KT {
    public static byte[] A01;
    public final /* synthetic */ AnonymousClass62 A00;

    static {
        A02();
    }

    public Z5(AnonymousClass62 anonymousClass62) {
        this.A00 = anonymousClass62;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{62, 44, 44, 58, 43, 44};
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        try {
            JSONArray jSONArray = this.A00.A05.getJSONArray(A00(0, 6, 77));
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                AnonymousClass60 anonymousClass60A00 = AnonymousClass60.A00(jSONArray.getJSONObject(i11));
                this.A00.A09(anonymousClass60A00.A04, anonymousClass60A00);
            }
            this.A00.A02.A0W(new Z7(this), new C6V(this.A00.A04, this.A00.A03));
        } catch (JSONException unused) {
            this.A00.A00.post(new Z6(this));
        }
    }
}
