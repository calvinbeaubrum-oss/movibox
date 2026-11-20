package com.cloud.tmc.miniapp.nativewebview.interfaces;

import OooOO0.OooO0o;
import android.webkit.JavascriptInterface;
import com.cloud.tmc.integration.proxy.IKeyboardProxy;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import l.c;
import pc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class NativeWebviewInterface {
    @JavascriptInterface
    public final void onScrollChanged(String viewId) {
        OooO0o oooO0o;
        Intrinsics.g(viewId, "viewId");
        try {
            a aVarC = kb.a.f68517a.c(viewId);
            c cVar = aVarC instanceof c ? (c) aVarC : null;
            if (cVar == null || (oooO0o = cVar.f69726h) == null) {
                return;
            }
            try {
                if (oooO0o.OooOOo) {
                    ((IKeyboardProxy) tc.a.a(IKeyboardProxy.class)).hideKeyboard(oooO0o);
                }
            } catch (Throwable th2) {
                TmcLogger.h(oooO0o.OooO0OO, th2);
            }
        } catch (Throwable th3) {
            TmcLogger.h("receiveUrlIcon", th3);
        }
    }

    @JavascriptInterface
    public final void receiveUrlIcon(String iconUrl, String viewId) {
        OooO0o oooO0o;
        Intrinsics.g(iconUrl, "icon");
        Intrinsics.g(viewId, "viewId");
        try {
            a aVarC = kb.a.f68517a.c(viewId);
            c cVar = aVarC instanceof c ? (c) aVarC : null;
            if (cVar == null || (oooO0o = cVar.f69726h) == null) {
                return;
            }
            Intrinsics.g(iconUrl, "iconUrl");
            JsonObject jsonObjectE = z.a().d("type", "onReceivedIcon").d("favicon", iconUrl).e();
            Intrinsics.f(jsonObjectE, "create().addProperty(KEY…FAVICON, iconUrl).build()");
            m.a aVar = oooO0o.f169OooO0o;
            if (aVar != null) {
                aVar.a("onReceivedIcon", jsonObjectE);
            }
        } catch (Throwable th2) {
            TmcLogger.h("receiveUrlIcon", th2);
        }
    }
}
