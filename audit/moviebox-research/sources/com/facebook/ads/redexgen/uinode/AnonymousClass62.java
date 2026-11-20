package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.Looper;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.62, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass62 {
    public static byte[] A07;
    public static String[] A08 = {"QC6ROF3GbFPL6U2BchtfuOIlWA", "mAXyphBg0ZoA2", "nmk1i7vNQUMlLTVPnMJLcVhB6M", "xf2dPS9SncVtV17kxTxgHOfrSuJpis3", "Y24xgR3", "pU5dMF2zEzzc2yzou8JPWDE5BQxzeO1x", "dnQEZ1usH0f6s5VsA3sVBX2XHmBfQenJ", "5qnsTvKOcggfe9NlhRnI8aAzom1PIzJ"};
    public final Handler A00;
    public final AnonymousClass61 A01;
    public final C11006c A02;
    public final String A03;
    public final String A04;
    public final JSONObject A05;
    public final boolean A06;

    static {
        A07();
    }

    public AnonymousClass62(C11006c c11006c, JSONObject jSONObject, String str, String str2, boolean z11, AnonymousClass61 anonymousClass61) {
        this.A02 = c11006c;
        this.A05 = jSONObject;
        this.A03 = str;
        this.A04 = str2;
        this.A06 = z11 && A0A(jSONObject);
        this.A01 = anonymousClass61;
        this.A00 = new Handler(Looper.getMainLooper());
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{72, 90, 90, 76, 93, 90, 78, 65, 68, 77, 105, 109, 97, 103, 101, 0, Ascii.US, Ascii.DC2, 19, Ascii.EM};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(boolean z11, AnonymousClass60 anonymousClass60) {
        String strA03 = A03(6, 4, 28);
        String strA04 = A03(15, 5, 66);
        String strA05 = A03(10, 5, 52);
        if (!z11) {
            if (strA05.equals(anonymousClass60.A02)) {
                this.A02.A0b(new C10986a(anonymousClass60.A03, -1, -1, this.A04, this.A03));
                return;
            } else if (strA04.equals(anonymousClass60.A02)) {
                this.A02.A0a(new C6Y(anonymousClass60.A03, this.A04, this.A03));
                return;
            } else {
                if (strA03.equals(anonymousClass60.A02)) {
                    this.A02.A0X(new C6Y(anonymousClass60.A03, this.A04, this.A03));
                    return;
                }
                return;
            }
        }
        boolean zEquals = strA05.equals(anonymousClass60.A02);
        if (A08[6].charAt(22) == 'q') {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[3] = "Ngd5gA2SMQ4Pqx2mjoy1oHjbJUKCicI";
        strArr[7] = "LorLYeRbgteEMpgZiQ82pTGbH7n24yI";
        if (zEquals) {
            this.A02.A0c(new C10986a(anonymousClass60.A03, -1, -1, this.A04, this.A03));
        } else if (strA04.equals(anonymousClass60.A02)) {
            this.A02.A0Z(new C6Y(anonymousClass60.A03, this.A04, this.A03));
        } else if (strA03.equals(anonymousClass60.A02)) {
            this.A02.A0Y(new C6Y(anonymousClass60.A03, this.A04, this.A03));
        }
    }

    public static boolean A0A(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.has(A03(0, 6, 29));
    }

    public final void A0B() {
        if (!this.A06) {
            this.A01.AAm();
        }
        ExecutorC1467Lt.A06.execute(new Z5(this));
    }
}
