package com.applovin.impl.adview;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.j3;
import com.applovin.impl.rr;
import com.applovin.impl.z3;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends j3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f17617c;

    public l(String str, com.applovin.impl.sdk.ad.b bVar, rr rrVar, Context context) {
        super(context);
        this.f17617c = str;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        if (bVar.M0()) {
            applySettings(bVar);
        } else {
            settings.setAllowFileAccess(true);
            if (z3.e() && bVar.I0()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
        }
        setWebViewClient(rrVar);
        setWebChromeClient(new WebChromeClient());
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(ASTNode.PCTX_STORED);
    }

    public void a(String str) {
        loadDataWithBaseURL(this.f17617c, str, "text/html", null, "");
    }
}
