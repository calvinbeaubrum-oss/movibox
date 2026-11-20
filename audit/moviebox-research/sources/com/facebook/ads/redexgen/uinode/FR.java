package com.facebook.ads.redexgen.uinode;

import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FR extends AbstractC1879am {
    public static byte[] A03;
    public long A00;
    public View A01;
    public EQ A02;

    static {
        A05();
    }

    public FR(EQ eq2, C09901u c09901u) {
        super(eq2, c09901u);
        this.A00 = 10000L;
        this.A02 = eq2;
    }

    private C1882ap A01(Runnable runnable) {
        return new C1882ap(this, runnable);
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 12);
        }
        return new String(bArrCopyOfRange);
    }

    private List<JSONObject> A04(C09911v c09911v) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectA03 = c09911v.A03();
        String strA03 = A03(22, 12, 107);
        if (jSONObjectA03.has(strA03)) {
            try {
                this.A00 = jSONObjectA03.getJSONObject(strA03).optInt(A03(3, 19, 71), 10000);
                JSONArray jSONArray = jSONObjectA03.getJSONArray(A03(0, 3, 81));
                if (jSONArray.length() > 0) {
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        arrayList.add((JSONObject) jSONArray.get(i11));
                    }
                }
            } catch (JSONException unused) {
                String strA04 = A03(36, 38, 4);
                this.A02.A0E().A4t(C1401Jb.A01(AdErrorType.UNKNOWN_ERROR, strA04).A03().getErrorCode(), strA04);
                return arrayList;
            }
        } else {
            arrayList.add(jSONObjectA03);
        }
        return arrayList;
    }

    public static void A05() {
        A03 = new byte[]{60, 57, 46, 41, 42, 37, 37, 46, 57, Ascii.DC4, 57, 46, 45, 57, 46, 56, 35, Ascii.DC4, Utf8.REPLACEMENT_BYTE, 34, 38, 46, 4, Ascii.SI, 6, Ascii.SO, 9, 56, Ascii.ETB, 6, Ascii.NAK, 6, 10, Ascii.DC4, 3, Ascii.DC4, 109, 122, 122, 103, 122, 40, Ascii.DEL, 96, 97, 100, 109, 40, 120, 105, 122, 123, 97, 102, 111, 40, 107, 96, 105, 97, 102, 109, 108, 40, 105, 108, 123, 40, 74, 105, 102, 102, 109, 122};
    }

    private void A06(C1916bN c1916bN, JSONObject jSONObject, C8T c8t) {
        this.A0C = false;
        C1881ao c1881ao = new C1881ao(this, c1916bN, LJ.A02(jSONObject, A03(34, 2, 108)));
        A0F().postDelayed(c1881ao, c8t.A05());
        c1916bN.A0J(this.A02, this.A08, this.A07.A08, A01(c1881ao), jSONObject, c8t);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1879am
    public final void A0M() {
        if (this.A01 == null) {
            this.A02.A0E().A3z();
        } else {
            this.A02.A0E().A3y();
            this.A06.A0E(this.A01);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1879am
    public final void A0O(InterfaceC09590p interfaceC09590p, C8S c8s, C8Q c8q, final C09911v c09911v) {
        this.A02.A0E().A3s();
        final C1916bN c1916bN = (C1916bN) interfaceC09590p;
        final List<JSONObject> listA04 = A04(c09911v);
        A06(c1916bN, listA04.get(0), c09911v.A01());
        if (listA04.size() > 1) {
            A0F().postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.1w
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0X(c1916bN, listA04, c09911v);
                }
            }, this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1879am
    public final void A0R(String str) {
        this.A02.A0E().A3x(str != null);
        super.A0R(str);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1879am
    public final void A0V(boolean z11) {
        super.A0V(z11);
        this.A01 = null;
    }

    public final /* synthetic */ void A0X(C1916bN c1916bN, List list, C09911v c09911v) {
        A06(c1916bN, (JSONObject) list.get(1), c09911v.A01());
    }
}
