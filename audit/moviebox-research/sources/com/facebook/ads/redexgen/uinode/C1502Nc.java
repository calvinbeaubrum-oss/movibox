package com.facebook.ads.redexgen.uinode;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1502Nc extends WebChromeClient {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 68);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-91, -47, -48, -43, -47, -50, -57, -126, -49, -57, -43, -43, -61, -55, -57, -100, -126, -102, -67, -81, -78, -73, -68, -75, 110, -66, -64, -67, -75, -64, -77, -63, -63, -120, 110};
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (!BuildConfigApi.isDebug()) {
            return true;
        }
        String str = A00(0, 17, 30) + consoleMessage.message();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i11) {
        if (BuildConfigApi.isDebug()) {
            String str = A00(17, 18, 10) + i11;
        }
    }
}
