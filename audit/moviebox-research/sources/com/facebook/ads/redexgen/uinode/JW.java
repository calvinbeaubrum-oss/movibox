package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class JW implements Runnable {
    public static byte[] A03;
    public final /* synthetic */ C11237f A00;
    public final /* synthetic */ JZ A01;
    public final /* synthetic */ String A02;

    static {
        A01();
    }

    public JW(JZ jz2, String str, C11237f c11237f) {
        this.A01 = jz2;
        this.A02 = str;
        this.A00 = c11237f;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 121);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{3, Ascii.ESC, 5, 60, 61, 39, 32, 59, 38, 45, 89, 78, 91, 68, 89, 95, 66, 69, 76, 54, 33, 53, 49, 33, 55, 48, Ascii.ESC, 45, 32};
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        ArrayList<JY> arrayList;
        if (KL.A02(this)) {
            return;
        }
        try {
            C8B c8b = new C8B(A00(0, 3, 52));
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put(A00(3, 7, 45), jSONArray);
            jSONObject.put(A00(19, 10, 61), this.A02);
            synchronized (this.A01.A0D) {
                arrayList = new ArrayList(this.A01.A0D);
                this.A01.A0D.clear();
            }
            for (JY jy2 : arrayList) {
                jSONArray.put(A00(0, 0, 60) + jy2.A00 + ';' + jy2.A02 + ';' + jy2.A01);
            }
            c8b.A07(jSONObject);
            c8b.A05(1);
            this.A00.A07().A9b(A00(10, 9, 82), C8A.A2R, c8b);
        } catch (JSONException unused) {
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
