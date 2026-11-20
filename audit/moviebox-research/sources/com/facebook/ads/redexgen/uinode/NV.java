package com.facebook.ads.redexgen.uinode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import okio.Utf8;
import org.mvel2.ast.ASTNode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class NV extends WebViewClient {
    public static byte[] A05;
    public NR A00 = new NR() { // from class: com.facebook.ads.redexgen.X.U2
        @Override // com.facebook.ads.redexgen.uinode.NR
        public final boolean A9D(String str) {
            return NV.A04(str);
        }
    };
    public WeakReference<NT> A01 = new WeakReference<>(null);
    public final WeakReference<C1795Yn> A02;
    public final WeakReference<NS> A03;
    public final WeakReference<NO> A04;

    static {
        A01();
    }

    public NV(WeakReference<C1795Yn> weakReference, WeakReference<NS> weakReference2, WeakReference<NO> weakReference3) {
        this.A02 = weakReference;
        this.A03 = weakReference2;
        this.A04 = weakReference3;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{54, 55, 68, 74, 73, Ascii.SI, 55, 65, 54, 67, 64, 39, 52, 37, 39, 41, 58, 47, 60, 47, 58, Utf8.REPLACEMENT_BYTE, 51, 64, 54, 68, 65, 59, 54, 0, 59, 64, 70, 55, 64, 70, 0, 51, 53, 70, 59, 65, 64, 0, 40, Ascii.ESC, Ascii.ETB, 41, 9, Ascii.SYN, Ascii.FF, Ascii.SUB, Ascii.ETB, 17, Ascii.FF, -42, 17, Ascii.SYN, Ascii.FS, Ascii.CR, Ascii.SYN, Ascii.FS, -42, Ascii.VT, 9, Ascii.FS, Ascii.CR, Ascii.SI, Ascii.ETB, Ascii.SUB, 33, -42, -22, -6, -9, -1, -5, -23, -22, -12, -19, 7, Ascii.ETB, Ascii.DC4, Ascii.FS, Ascii.CAN, 10, Ascii.ETB, 4, Ascii.VT, 6, 17, 17, 7, 6, 8, Ascii.DLE, 4, Ascii.SUB, Ascii.ETB, 17, -54, -57, -38, -57, 49, 54, 60, 45, 54, 60, -36, -39, -45, -95, -121, -30, -48, -51, -54, -31, -44, -48, -30};
    }

    private void A02(String str, C1795Yn c1795Yn) {
        c1795Yn.A07().A9a(A00(11, 11, 101), C8A.A09, new C8B(A00(111, 5, 6) + str));
    }

    private boolean A03(WebView webView, String str) {
        Intent intent;
        String strA00 = A00(116, 8, 10);
        C1795Yn c1795Yn = this.A02.get();
        if (c1795Yn == null) {
            return false;
        }
        if ((U1.A0A && (TextUtils.isEmpty(str) || A00(0, 11, 116).equals(str))) || !this.A00.A9D(str)) {
            return true;
        }
        try {
            Uri uriA00 = AbstractC1446Ky.A00(str);
            String scheme = uriA00.getScheme();
            try {
                boolean zA0w = C1384Ih.A0w(c1795Yn);
                String strA01 = A00(48, 33, 71);
                String strA02 = A00(22, 26, 113);
                String strA03 = A00(105, 6, Worker.WHAT_SYNC_DATA);
                if (zA0w) {
                    if (!U1.A0D.contains(scheme) && !A00(101, 4, 5).equals(scheme)) {
                        if (strA03.equalsIgnoreCase(scheme)) {
                            intent = Intent.parseUri(str, 1);
                            intent.setComponent(null);
                            intent.setSelector(null);
                        } else {
                            intent = new Intent(strA02, uriA00);
                        }
                        intent.addCategory(strA01);
                        if (Build.VERSION.SDK_INT >= 30) {
                            intent.setFlags(268436480);
                        } else {
                            intent.setFlags(ASTNode.DEOP);
                        }
                        try {
                            if (!C1433Kj.A0C(c1795Yn, intent)) {
                                A02(str, c1795Yn);
                            }
                            return true;
                        } catch (C1431Kh unused) {
                            if (strA03.equals(scheme)) {
                                String stringExtra = intent.getStringExtra(A00(81, 20, 68));
                                if (!TextUtils.isEmpty(stringExtra)) {
                                    if (!C1433Kj.A0C(c1795Yn, new Intent(strA02, AbstractC1446Ky.A00(stringExtra)))) {
                                        A02(str, c1795Yn);
                                    }
                                    return true;
                                }
                            }
                            C8B c8b = new C8B(A00(111, 5, 6) + str);
                            c8b.A05(1);
                            c1795Yn.A07().A9b(A00(11, 11, 101), C8A.A06, c8b);
                            return true;
                        }
                    }
                    return false;
                }
                if (U1.A0A && strA03.equalsIgnoreCase(scheme)) {
                    Intent uri = Intent.parseUri(str, 1);
                    uri.addCategory(strA01);
                    uri.setComponent(null);
                    uri.setSelector(null);
                    if (c1795Yn.getPackageManager().resolveActivity(uri, 65536) != null && C1433Kj.A0C(c1795Yn, uri)) {
                        webView.goBack();
                        return true;
                    }
                } else if ((U1.A0A && LH.A04(str)) || !U1.A0D.contains(scheme)) {
                    return C1433Kj.A0C(c1795Yn, new Intent(strA02, uriA00));
                }
            } catch (Exception e11) {
                c1795Yn.A07().A9b(strA00, C8A.A2b, new C8B(e11));
                c1795Yn.A0E().A8k(e11.toString());
            }
            return false;
        } catch (SecurityException e12) {
            c1795Yn.A07().A9b(strA00, C8A.A2b, new C8B(e12));
            return true;
        }
    }

    public static /* synthetic */ boolean A04(String str) {
        return true;
    }

    public final void A05(NR nr2) {
        this.A00 = nr2;
    }

    public final void A06(WeakReference<NT> weakReference) {
        this.A01 = weakReference;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        NO no2 = this.A04.get();
        if (no2 != null) {
            no2.A03();
        }
        NS ns2 = this.A03.get();
        if (ns2 != null) {
            ns2.ACT(str);
        }
        NT nt2 = this.A01.get();
        if (nt2 != null) {
            nt2.AAv(webView.canGoBack());
            nt2.ABZ(webView.canGoForward());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        NS ns2 = this.A03.get();
        if (ns2 != null) {
            ns2.ACV(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i11, String str, String str2) {
        super.onReceivedError(webView, i11, str, str2);
        C1795Yn c1795Yn = this.A02.get();
        if (c1795Yn != null) {
            StringBuilder sb2 = new StringBuilder();
            String strA00 = A00(0, 0, 27);
            c1795Yn.A0E().A8h(LH.A01(i11, sb2.append(strA00).append(str).toString(), strA00 + str2));
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        C1795Yn c1795Yn = this.A02.get();
        if (c1795Yn != null) {
            int errorCode = webResourceError.getErrorCode();
            StringBuilder sb2 = new StringBuilder();
            String strA00 = A00(0, 0, 27);
            c1795Yn.A0E().A8h(LH.A01(errorCode, sb2.append(strA00).append((Object) webResourceError.getDescription()).toString(), strA00 + webResourceRequest.getUrl()));
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        C1795Yn c1795Yn = this.A02.get();
        if (c1795Yn != null) {
            c1795Yn.A0E().A8i();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        C1795Yn c1795Yn = this.A02.get();
        if (c1795Yn != null) {
            c1795Yn.A0E().A8j();
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        NY.A02(C8A.A2c);
        NS ns2 = this.A03.get();
        if (ns2 == null) {
            return true;
        }
        ns2.ACs();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return A03(webView, webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return A03(webView, str);
    }
}
