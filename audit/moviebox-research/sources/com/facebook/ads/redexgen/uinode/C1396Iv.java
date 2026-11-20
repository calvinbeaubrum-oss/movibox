package com.facebook.ads.redexgen.uinode;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.ads.internal.api.AudienceNetworkExportedActivityApi;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Iv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1396Iv implements AudienceNetworkExportedActivityApi {
    public static byte[] A01;
    public static String[] A02 = {"lqcZKkXS6TgOyt76sZ5yjVO68Nd1QdQN", "bQWyI3suGbnh3U5StjCALiPIzXDV3Wa6", "hqk98641WxUvYLytASVEQqAqBzewRvKz", "WJUhx8cI8X6XmYecnMlLMKWkuLUkkXH9", "MP1e4gCZR", "1EPuqCSCyQ9J2YoomIIpPWX0Nb9xTOcz", "0suERcaSwAa0E2CxcbYZCTLc9cS16", "2TigNonfP4HCMPOeSAXXuXDynNOGBzuQ"};
    public final Activity A00;

    static {
        A01();
    }

    public C1396Iv(Activity activity) {
        this.A00 = activity;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {126, 121, 99, 104, 101, 97, 104, 118, 103, 103, 104, 120, 101, 126, 114, 121, 99, 118, 99, 126, 120, 121, 104, 124, 114, 110, 61, 58, 60, 49, 47, 42, 49, 39, 42, 49, 37, 43, 55};
        if (A02[2].charAt(23) != 'q') {
            throw new RuntimeException();
        }
        A02[2] = "wLiEtUSufX2SvKxRiuuw2ghqe6rTYyXA";
        A01 = bArr;
    }

    private void A02(int i11) {
        this.A00.setResult(i11);
        this.A00.finish();
    }

    private boolean A03(C1395Iu c1395Iu) {
        String callingPackage = this.A00.getCallingPackage();
        if (callingPackage != null && callingPackage.equals(c1395Iu.A03)) {
            return true;
        }
        A02(12);
        if (c1395Iu.A00 instanceof C1860aT) {
            ((C1860aT) c1395Iu.A00).A0F().A0E().AEj();
        }
        if (!(c1395Iu.A00 instanceof C1857aQ)) {
            return false;
        }
        ((C1857aQ) c1395Iu.A00).A0H().A0E().AEj();
        return false;
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkExportedActivityApi
    public final void onCreate(Bundle bundle) {
        C1795Yn c1795YnA05 = C10745c.A05(this.A00, UUID.randomUUID().toString());
        if (this.A00.isTaskRoot()) {
            c1795YnA05.A0E().AEc();
            A02(10);
            return;
        }
        String stringExtra = this.A00.getIntent().getStringExtra(A00(26, 13, 15));
        if (stringExtra == null) {
            c1795YnA05.A0E().AEf();
            A02(11);
            return;
        }
        C1395Iu c1395IuA04 = VW.A00().A04(stringExtra);
        AnonymousClass23 anonymousClass23 = c1395IuA04 != null ? c1395IuA04.A00 : null;
        if (A02[6].length() == 29) {
            A02[6] = "3hvfYctBGPg0BeMvR8jiqRXkEjCpv";
            if (c1395IuA04 == null || !(anonymousClass23 instanceof C1857aQ)) {
                if (c1395IuA04 != null) {
                    boolean z11 = anonymousClass23 instanceof C1860aT;
                    if (A02[1].charAt(21) == 'i') {
                        A02[2] = "XUW1n7Q8abvbP2RLETYRfIyqCZkI4d7q";
                        if (z11) {
                            if (!A03(c1395IuA04)) {
                                return;
                            }
                            C1860aT c1860aT = (C1860aT) anonymousClass23;
                            c1860aT.A0E().A05().A0I(this.A00);
                            c1860aT.A0J();
                        }
                    }
                }
                c1795YnA05.A0E().AF5();
                A02(13);
                return;
            }
            if (!A03(c1395IuA04)) {
                return;
            }
            C1857aQ c1857aQ = (C1857aQ) anonymousClass23;
            c1857aQ.A0G().A02().A0I(this.A00);
            c1857aQ.A0M(this.A00.getIntent().getIntExtra(A00(0, 26, 86), -1), 0L);
            this.A00.setResult(-1);
            this.A00.finish();
            return;
        }
        throw new RuntimeException();
    }
}
