package com.cloud.tmc.miniapp.defaultimpl;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.ui.p000native.NativeTabComponent;
import com.cloud.tmc.integration.ui.p000native.d;
import com.cloud.tmc.kernel.minicover.NativeComponentProxy;
import hd.k;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;
import l.c;
import tc.a;
import ua.f;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class NativeComponentProxyImp implements NativeComponentProxy {
    @Override // com.cloud.tmc.kernel.minicover.NativeComponentProxy
    public boolean checkResumedStatus(String str) {
        f appLifecycleCallback;
        try {
            App appFindApp = ((AppManager) a.a(AppManager.class)).findApp(str);
            if (appFindApp == null || (appLifecycleCallback = appFindApp.getAppLifecycleCallback()) == null) {
                return true;
            }
            return appLifecycleCallback.B();
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.NativeComponentProxy
    public pc.a getComponentNativeImgInstance(Context context, String renderId, String viewId, i render) {
        Intrinsics.g(context, "context");
        Intrinsics.g(renderId, "renderId");
        Intrinsics.g(viewId, "viewId");
        Intrinsics.g(render, "render");
        return new d(context, renderId, viewId, render);
    }

    @Override // com.cloud.tmc.kernel.minicover.NativeComponentProxy
    public pc.a getComponentNativeTabInstance(Context context, String renderId, String viewId, i render) {
        Intrinsics.g(context, "context");
        Intrinsics.g(renderId, "renderId");
        Intrinsics.g(viewId, "viewId");
        Intrinsics.g(render, "render");
        return new NativeTabComponent(context, renderId, viewId, render);
    }

    @Override // com.cloud.tmc.kernel.minicover.NativeComponentProxy
    public pc.a getComponentNativeWebViewInstance(Context context, String renderId, String viewId, i render) {
        Intrinsics.g(context, "context");
        Intrinsics.g(renderId, "renderId");
        Intrinsics.g(viewId, "viewId");
        Intrinsics.g(render, "render");
        l.d dVar = l.d.f69729a;
        Intrinsics.g(context, "context");
        Intrinsics.g(renderId, "renderId");
        Intrinsics.g(viewId, "viewId");
        Intrinsics.g(render, "render");
        String appId = render.getAppId();
        ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> concurrentHashMap = l.d.f69730b;
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = concurrentHashMap.get(appId);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        }
        if (concurrentLinkedQueue.size() >= MiniAppConfigHelper.f30370a.c("maxNativeWebviewNum", 5)) {
            String removeViewId = concurrentLinkedQueue.poll();
            View view = render.getView();
            WebView webView = view instanceof WebView ? (WebView) view : null;
            k.a("webviewQueue size >= 5,remove ", removeViewId, "NativeWebviewManager");
            kb.a aVar = kb.a.f68517a;
            Intrinsics.f(removeViewId, "removeViewId");
            aVar.k(webView, removeViewId, renderId);
        }
        c cVar = new c(context, renderId, viewId, render);
        concurrentLinkedQueue.add(viewId);
        Intrinsics.f(appId, "appId");
        concurrentHashMap.put(appId, concurrentLinkedQueue);
        return cVar;
    }
}
