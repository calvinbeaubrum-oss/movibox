package com.facebook.ads.redexgen.uinode;

import android.content.SharedPreferences;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class VO extends KT {
    public static byte[] A01;
    public final /* synthetic */ C11237f A00;

    static {
        A02();
    }

    public VO(C11237f c11237f) {
        this.A00 = c11237f;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 51);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{111, 99, 97, 34, 106, 109, 111, 105, 110, 99, 99, 103, 34, 109, 104, Ascii.DEL, 34, 64, 67, 79, 77, 64, 83, 79, 67, 89, 66, 88, 73, 94, 95, 88, 91, 87, 85, 88, 107, 87, 91, 65, 90, 64, 81, 70, 71, 84, 92, 88, 74, 76, 75, 92, 93, 102, 74, 92, 74, 74, 80, 86, 87, 102, 80, 93, 108, 100, 96, 114, 116, 115, 100, 101, 94, 114, 100, 114, 114, 104, 110, 111, 94, 117, 104, 108, 100};
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        SharedPreferences sharedPreferences = null;
        try {
            sharedPreferences = this.A00.getApplicationContext().getSharedPreferences(ProcessUtils.getProcessSpecificName(A00(0, 31, 63), this.A00), 0);
            Map<String, ?> all = sharedPreferences.getAll();
            if (all.size() > 1) {
                C11237f c11237f = this.A00;
                JD.A06(c11237f, C1606Rc.A00(c11237f), all);
            }
            sharedPreferences.edit().clear().apply();
            sharedPreferences.edit().putString(A00(45, 19, 10), this.A00.A08().A02()).putString(A00(64, 21, 50), C1453Lf.A02(this.A00.A08().A01())).apply();
        } catch (JSONException e11) {
            this.A00.A07().A9a(A00(31, 14, 7), 3502, new C8B(e11));
            sharedPreferences.edit().clear().apply();
        }
        synchronized (JD.class) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            for (Map.Entry entry : JD.A02().entrySet()) {
                editorEdit.putInt((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
            }
            editorEdit.apply();
            JD.A04.set(2);
        }
    }
}
