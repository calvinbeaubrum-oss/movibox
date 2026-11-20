package com.cloud.tmc.miniapp.defaultimpl;

import android.content.Context;
import android.view.View;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.render.IWebViewFactory;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.render.system.ShellWebView;
import com.cloud.tmc.render.system.SystemWebView;
import kotlin.jvm.internal.Intrinsics;
import tc.a;
import zc.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class WebViewImp implements IWebViewFactory {
    /* JADX WARN: Multi-variable type inference failed */
    public final k OooO00o(k kVar) {
        if (((ConfigService) a.a(ConfigService.class)).getConfigBoolean("layerHardware", MiniAppConfigHelper.f30370a.f())) {
            ((View) kVar).setLayerType(2, null);
        }
        return kVar;
    }

    @Override // com.cloud.tmc.kernel.proxy.render.IWebViewFactory
    public void clear() {
    }

    @Override // com.cloud.tmc.kernel.proxy.render.IWebViewFactory
    public k createWebView(Context context) {
        Intrinsics.g(context, "context");
        try {
            SystemWebView systemWebView = new SystemWebView(context, null, 2, null);
            OooO00o(systemWebView);
            return systemWebView;
        } catch (Throwable th2) {
            TmcLogger.k("miniapp", "miniapp create webview fail : " + th2);
            return null;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.render.IWebViewFactory
    public k createWebView(Context context, int i11) {
        k systemWebView;
        Intrinsics.g(context, "context");
        try {
            if (h.f31061a.k(i11)) {
                systemWebView = new ShellWebView(context, null, 2, null);
                OooO00o(systemWebView);
            } else {
                systemWebView = new SystemWebView(context, null, 2, null);
                OooO00o(systemWebView);
            }
            return systemWebView;
        } catch (Throwable th2) {
            TmcLogger.k("miniapp", "miniapp create webview fail : " + th2);
            return null;
        }
    }
}
