package com.facebook.ads.redexgen.uinode;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UC implements MD {
    public static byte[] A02;
    public static String[] A03 = {"aBntnUcGkPsHn32", "P4RcL0jDchydoovBiSoLIuxgLfrPrb6w", "mkuNE8OtHtyShCJf5aoxKrL8UBpqEuyM", "UhCp0DvERhIRIFEAVdlvvAHyWhzVDXme", "Bn", "", "xG", ""};
    public final C5V A00;
    public final C1795Yn A01;

    static {
        A01();
    }

    public UC(C1795Yn c1795Yn, C5V c5v) {
        this.A01 = c1795Yn;
        this.A00 = c5v;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 59);
            String[] strArr = A03;
            if (strArr[1].charAt(10) != strArr[2].charAt(10)) {
                throw new RuntimeException();
            }
            A03[0] = "eCFHYnXZJROSM8T";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{106, 109, 119, 124, 113, 117, 124, 98, 115, 115, 124, 108, 113, 106, 102, 109, 119, 98, 119, 106, 108, 109, 124, 104, 102, 122, 73, 78, 72, 69, 91, 94, 69, 83, 94, 69, 81, 95, 67, 104, 100, 102, 37, 109, 106, 104, 110, 105, 100, 100, 96, 37, 106, 111, 120, 37, 98, 101, Ascii.DEL, 110, 121, 101, 106, 103, 37, 98, 123, 104, 37, 74, 126, 111, 98, 110, 101, 104, 110, 69, 110, Ascii.DEL, 124, 100, 121, 96, 78, 115, 123, 100, 121, Ascii.DEL, 110, 111, 74, 104, Ascii.DEL, 98, 125, 98, Ascii.DEL, 114};
    }

    private final void A02() {
        Object objA0G = this.A01.A0G();
        if (objA0G instanceof C2F) {
            C2F c2f = (C2F) objA0G;
            if (A03[3].charAt(1) != 'h') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[1] = "Y2WnI7kTNoyl8yrnl5OB1Dl5fHFssRe6";
            strArr[2] = "w1APvk8HFOytJ5hAXEfuvXVYTJSuGWRL";
            Ad adA00 = c2f.A00();
            if (adA00 != null && c2f.A01() != null) {
                c2f.A01().onError(adA00, AdError.AD_PRESENTATION_ERROR);
            }
        }
        this.A00.A0J().finish();
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void A9Q(Intent intent, Bundle bundle, C5V c5v) {
        ComponentName componentName = new ComponentName(AbstractC1386Ik.A04(AbstractC1386Ik.A01.get()), A00(39, 61, 48));
        Intent intent2 = new Intent();
        intent2.setComponent(componentName);
        String strA00 = A00(26, 13, 33);
        intent2.putExtra(strA00, intent.getStringExtra(strA00));
        String strA01 = A00(0, 26, 24);
        intent2.putExtra(strA01, intent.getIntExtra(strA01, -1));
        try {
            this.A01.A0E().AF1();
            C1433Kj.A08(c5v.A0J(), intent2);
        } catch (C1431Kh unused) {
            A02();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void ACW(boolean z11) {
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void ACu(boolean z11) {
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void AFT(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final String getCurrentClientToken() {
        return A00(0, 0, 108);
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final boolean onActivityResult(int i11, int i12, Intent intent) {
        this.A01.A0E().AEe();
        if (i12 == -1) {
            this.A00.A0J().finish();
            return false;
        }
        C1795Yn c1795Yn = this.A01;
        String[] strArr = A03;
        if (strArr[1].charAt(10) != strArr[2].charAt(10)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[6] = "Lp";
        strArr2[4] = "Ys";
        c1795Yn.A0E().AEd(i12);
        A02();
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void onDestroy() {
    }
}
