package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdSettings;
import com.facebook.ads.RewardData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Q7 {
    public static byte[] A05;
    public static String[] A06 = {"4IoXmskrHF1p6dXqKQn3apqXXvi8", "1tZtBqJSVjxeNtOdqegUYYfHC8", "yIG7nuwjW", "6uVpGgk4XMyp6iT3bnZwHJmMch5uofQt", "GVQj", "RdXauxF0SpMDtL", "yOCZ", "m5Wr6psr3K5zQ"};
    public Executor A00 = ExecutorC1467Lt.A06;
    public final C1795Yn A01;
    public final MC A02;
    public final InterfaceC1483Mj A03;
    public final String A04;

    static {
        A04();
    }

    public Q7(C1795Yn c1795Yn, InterfaceC1483Mj interfaceC1483Mj, String str, MC mc2) {
        this.A01 = c1795Yn;
        this.A03 = interfaceC1483Mj;
        this.A04 = str;
        this.A02 = mc2;
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 42);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A03(RewardData rewardData, String str, String str2) {
        if (rewardData == null) {
            return null;
        }
        String urlPrefix = AdSettings.getUrlPrefix();
        Uri uriA00 = AbstractC1446Ky.A00((urlPrefix == null || urlPrefix.isEmpty()) ? A02(68, 60, 14) : String.format(Locale.US, A02(5, 63, 42), urlPrefix));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(uriA00.getScheme());
        builder.authority(uriA00.getAuthority());
        builder.path(uriA00.getPath());
        builder.query(uriA00.getQuery());
        builder.fragment(uriA00.getFragment());
        builder.appendQueryParameter(A02(TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 4, 59), rewardData.getUserID());
        builder.appendQueryParameter(A02(128, 2, 25), rewardData.getCurrency());
        builder.appendQueryParameter(A02(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 4, 34), str);
        builder.appendQueryParameter(A02(0, 5, 40), str2);
        return builder.build().toString();
    }

    public static void A04() {
        byte[] bArr = {99, 114, 114, 107, 102, 104, 116, 116, 112, 115, 58, 47, 47, 119, 119, 119, 46, 37, 115, 46, 102, 97, 99, 101, 98, 111, 111, 107, 46, 99, 111, 109, 47, 97, 117, 100, 105, 101, 110, 99, 101, 95, 110, 101, 116, 119, 111, 114, 107, 47, 115, 101, 114, 118, 101, 114, 95, 115, 105, 100, 101, 95, 114, 101, 119, 97, 114, 100, 76, 80, 80, 84, 87, Ascii.RS, Ascii.VT, Ascii.VT, 83, 83, 83, 10, 66, 69, 71, 65, 70, 75, 75, 79, 10, 71, 75, 73, Ascii.VT, 69, 81, 64, 77, 65, 74, 71, 65, 123, 74, 65, 80, 83, 75, 86, 79, Ascii.VT, 87, 65, 86, 82, 65, 86, 123, 87, 77, 64, 65, 123, 86, 65, 83, 69, 86, 64, 67, 80, 120, 124, 97, 108, 97, 100, 120, 117};
        String[] strArr = A06;
        if (strArr[4].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[0] = "UxdDTxCBISRzTQMngmIIdhyBS5kV";
        strArr2[5] = "aUHRRDOUc27Pb9";
        A05 = bArr;
    }

    public final void A05() {
        if (TextUtils.isEmpty(this.A04)) {
            return;
        }
        AsyncTaskC1608Re asyncTaskC1608Re = new AsyncTaskC1608Re(this.A01, new HashMap());
        asyncTaskC1608Re.A07(new SJ(this));
        asyncTaskC1608Re.executeOnExecutor(this.A00, this.A04);
    }
}
