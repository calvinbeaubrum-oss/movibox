package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class k extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WindVaneWebView f45812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f45813b;

    public k(WindVaneWebView windVaneWebView) {
        this.f45812a = windVaneWebView;
    }

    public final void a(d dVar) {
        this.f45813b = dVar;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.LOG) {
            return super.onConsoleMessage(consoleMessage);
        }
        c signalCommunication = this.f45812a.getSignalCommunication();
        if (signalCommunication != null) {
            String strMessage = consoleMessage.message();
            if (TextUtils.isEmpty(strMessage) || !strMessage.startsWith("mv://")) {
                return false;
            }
            ad.a("H5_ENTRY", "onConsoleMessage: message.length() = " + strMessage.length() + " " + strMessage);
            if (strMessage.contains("wv_hybrid:") && signalCommunication.a("wv_hybrid:")) {
                String strSubstring = strMessage.substring(0, strMessage.lastIndexOf(" ") + 1);
                ad.a("H5_ENTRY", "message = " + strSubstring);
                signalCommunication.b(strSubstring);
                return true;
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        ad.b("H5_ENTRY", str2 + "");
        c signalCommunication = this.f45812a.getSignalCommunication();
        if (signalCommunication == null || str3 == null || !signalCommunication.a(str3)) {
            return false;
        }
        signalCommunication.b(str2);
        jsPromptResult.confirm("");
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i11) {
        super.onProgressChanged(webView, i11);
        d dVar = this.f45813b;
        if (dVar != null) {
            dVar.b(webView, i11);
        }
    }
}
