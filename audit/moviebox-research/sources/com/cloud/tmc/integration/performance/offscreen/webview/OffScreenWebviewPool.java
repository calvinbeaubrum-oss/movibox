package com.cloud.tmc.integration.performance.offscreen.webview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.OffScreenRender;
import com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool;
import com.cloud.tmc.integration.proxy.PreHtmStrategyProxy;
import com.cloud.tmc.kernel.constants.PageType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.miniutils.util.h;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.render.system.ShellWebView;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.push.PushConstants;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lb.g;
import zc.i;
import zc.l;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class OffScreenWebviewPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OffScreenWebviewPool f30871a = new OffScreenWebviewPool();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f30872b = "OffScreenWebviewPool";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList<i> f30873c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<i> f30874d = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static AtomicBoolean f30875e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f30876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static PageType f30877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f30878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f30879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static float f30880j;

    public static final void n(Function0 render) {
        Intrinsics.g(render, "$render");
        render.invoke();
    }

    public void h(i iVar) {
        TmcLogger.c(f30872b, PushConstants.PROVIDER_FIELD_DESTROY);
        if (iVar == null) {
            return;
        }
        try {
            Iterator<i> it = f30873c.iterator();
            Intrinsics.f(it, "usedOffScreenRenderList.iterator()");
            while (it.hasNext()) {
                i next = it.next();
                Intrinsics.f(next, "iterator.next()");
                i iVar2 = next;
                if (iVar2.hashCode() == iVar.hashCode()) {
                    iVar2.destroy();
                    it.remove();
                    return;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public i i(String url) {
        Intrinsics.g(url, "url");
        TmcLogger.c(f30872b, "getOffScreenRender -> " + url + ", enable: " + f30878h);
        i iVar = null;
        if (!f30878h) {
            return null;
        }
        try {
            Iterator<i> it = f30874d.iterator();
            Intrinsics.f(it, "unUsedOffScreenRenderQueue.iterator()");
            while (it.hasNext()) {
                i next = it.next();
                if (Intrinsics.b(next.v(), String.valueOf(url))) {
                    try {
                        f30873c.add(next);
                        it.remove();
                        return next;
                    } catch (Throwable th2) {
                        th = th2;
                        iVar = next;
                        TmcLogger.c(f30872b, "getOffScreenRender -> " + th);
                        return iVar;
                    }
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final boolean j(String str) {
        Iterator<i> it = f30874d.iterator();
        Intrinsics.f(it, "unUsedOffScreenRenderQueue.iterator()");
        while (it.hasNext()) {
            if (Intrinsics.b(it.next().v(), str)) {
                return true;
            }
        }
        return false;
    }

    public void k(final String url, final PageType pageType, final Activity activity, final g gVar) {
        Intrinsics.g(url, "url");
        Intrinsics.g(pageType, "pageType");
        Intrinsics.g(activity, "activity");
        OffScreenRender offScreenRender = (OffScreenRender) k.d(((ConfigService) tc.a.a(ConfigService.class)).getConfigString("offScreenRender", "{\"enable\":false,\"maxSize\":0,\"grayScale\":0}"), OffScreenRender.class);
        if (offScreenRender != null) {
            f30878h = offScreenRender.getEnable();
            f30879i = offScreenRender.getMaxSize();
            f30880j = offScreenRender.getGrayScale();
        }
        String str = f30872b;
        TmcLogger.c(str, "offScreenRender -> url:" + url + ", pageType:" + pageType + ", enable: " + f30878h + ", maxSize: " + f30879i + ", grayScale:" + f30880j);
        if (f30878h) {
            double dNextDouble = new SecureRandom().nextDouble();
            TmcLogger.c(str, "offScreenRender -> createGrayNum:" + dNextDouble);
            float f11 = f30880j;
            if (f11 == 0.0f || dNextDouble > f11) {
                TmcLogger.c(str, "offScreenRender -> 未命中灰度测试");
                return;
            }
            if (f30875e.getAndSet(true)) {
                TmcLogger.c(str, "offScreenRender -> 正在离屏渲染中，本次操作不再继续执行");
            } else if (!j(url)) {
                m(new Function0<Unit>() { // from class: com.cloud.tmc.integration.performance.offscreen.webview.OffScreenWebviewPool$offScreenRender$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX WARN: Code duplicated, block: B:43:0x0152  */
                    /* JADX WARN: Code duplicated, block: B:45:0x0163  */
                    /* JADX WARN: Code duplicated, block: B:46:0x0166  */
                    /* JADX WARN: Code duplicated, block: B:49:0x016a  */
                    /* JADX WARN: Code duplicated, block: B:51:0x0177  */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        String str2;
                        boolean z11;
                        View view;
                        ShellWebView shellWebView;
                        Bundle bundleQ;
                        i webview = ((IInnerH5WebviewPool) tc.a.a(IInnerH5WebviewPool.class)).getWebview(activity);
                        if (webview == null) {
                            TmcLogger.c(OffScreenWebviewPool.f30872b, "offScreenRender -> 获取预热webview失败，本次操作不再继续执行");
                            OffScreenWebviewPool.f30876f = url;
                            OffScreenWebviewPool.f30877g = pageType;
                            OffScreenWebviewPool.f30875e.set(false);
                            return;
                        }
                        if (OffScreenWebviewPool.f30874d.size() > OffScreenWebviewPool.f30879i) {
                            OffScreenWebviewPool.f30874d.remove();
                        }
                        OffScreenWebviewPool.f30874d.add(webview);
                        ((IInnerH5WebviewPool) tc.a.a(IInnerH5WebviewPool.class)).removeWebview(webview, false);
                        l lVar = new l();
                        String str3 = url;
                        lVar.f81893a = str3;
                        lVar.f81894b = str3;
                        boolean zB = MiniAppConfigHelper.f30370a.b("enableShellPreRequest", true);
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31218j0, true);
                        cb.a aVar = new cb.a(bundle);
                        g gVar2 = gVar;
                        aVar.f(gVar2 != null ? gVar2.b() : null);
                        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                        String str4 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
                        g gVar3 = gVar;
                        bundle.putString(str4, (gVar3 == null || (bundleQ = gVar3.q()) == null) ? null : bundleQ.getString("uniqueChainID", "-1"));
                        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                        g gVar4 = gVar;
                        String str5 = "";
                        performanceAnalyseProxy.record(gVar4 != null ? gVar4.c() : null, PointAnalyseType.POINT_CHAIN_INSERT, "", bundle);
                        TmcLogger.c(OffScreenWebviewPool.f30872b, "offScreenRender -> enablePreRequest:" + zB);
                        if (zB) {
                            String md5 = h.b(lVar.f81893a);
                            TmcLogger.c(OffScreenWebviewPool.f30872b, "offScreenRender -> getHtml key:" + md5);
                            PageType pageType2 = pageType;
                            if (pageType2 == PageType.H5) {
                                String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(activity, "miniSyncSharpNews", md5);
                                str5 = string != null ? string : "";
                                if (str5.length() > 0) {
                                    str2 = str5;
                                    if (z11) {
                                        TmcLogger.c(OffScreenWebviewPool.f30872b, "offScreenRender -> loadDataWithBaseURL");
                                        view = webview.getView();
                                        if (view instanceof ShellWebView) {
                                            shellWebView = (ShellWebView) view;
                                        } else {
                                            shellWebView = null;
                                        }
                                        if (shellWebView != null) {
                                            shellWebView.setLoadDataWithBaseURL(true);
                                        }
                                        webview.n(lVar, str2, "text/html", "UTF-8", null);
                                    } else {
                                        TmcLogger.c(OffScreenWebviewPool.f30872b, "offScreenRender -> loadUrl: getLocalHtml fail ");
                                        webview.k(lVar);
                                    }
                                }
                                str2 = str5;
                                if (z11) {
                                    TmcLogger.c(OffScreenWebviewPool.f30872b, "offScreenRender -> loadDataWithBaseURL");
                                    view = webview.getView();
                                    if (view instanceof ShellWebView) {
                                        shellWebView = (ShellWebView) view;
                                    } else {
                                        shellWebView = null;
                                    }
                                    if (shellWebView != null) {
                                        shellWebView.setLoadDataWithBaseURL(true);
                                    }
                                    webview.n(lVar, str2, "text/html", "UTF-8", null);
                                } else {
                                    TmcLogger.c(OffScreenWebviewPool.f30872b, "offScreenRender -> loadUrl: getLocalHtml fail ");
                                    webview.k(lVar);
                                }
                            } else {
                                if (pageType2 == PageType.H5_SHELL) {
                                    PreHtmStrategyProxy preHtmStrategyProxy = (PreHtmStrategyProxy) tc.a.a(PreHtmStrategyProxy.class);
                                    Activity activity2 = activity;
                                    Intrinsics.f(md5, "md5");
                                    String preHtmlCache = preHtmStrategyProxy.getPreHtmlCache(activity2, md5, 1, true);
                                    TmcLogger.c(OffScreenWebviewPool.f30872b, "offScreenRender -> H5_SHELL check preHtml :" + preHtmlCache);
                                    str2 = preHtmlCache;
                                    z11 = preHtmlCache.length() > 0;
                                    if (z11) {
                                        TmcLogger.c(OffScreenWebviewPool.f30872b, "offScreenRender -> loadDataWithBaseURL");
                                        view = webview.getView();
                                        if (view instanceof ShellWebView) {
                                            shellWebView = (ShellWebView) view;
                                        } else {
                                            shellWebView = null;
                                        }
                                        if (shellWebView != null) {
                                            shellWebView.setLoadDataWithBaseURL(true);
                                        }
                                        webview.n(lVar, str2, "text/html", "UTF-8", null);
                                    } else {
                                        TmcLogger.c(OffScreenWebviewPool.f30872b, "offScreenRender -> loadUrl: getLocalHtml fail ");
                                        webview.k(lVar);
                                    }
                                } else {
                                    str2 = str5;
                                }
                                if (z11) {
                                    TmcLogger.c(OffScreenWebviewPool.f30872b, "offScreenRender -> loadDataWithBaseURL");
                                    view = webview.getView();
                                    if (view instanceof ShellWebView) {
                                        shellWebView = (ShellWebView) view;
                                    } else {
                                        shellWebView = null;
                                    }
                                    if (shellWebView != null) {
                                        shellWebView.setLoadDataWithBaseURL(true);
                                    }
                                    webview.n(lVar, str2, "text/html", "UTF-8", null);
                                } else {
                                    TmcLogger.c(OffScreenWebviewPool.f30872b, "offScreenRender -> loadUrl: getLocalHtml fail ");
                                    webview.k(lVar);
                                }
                            }
                        } else {
                            TmcLogger.c(OffScreenWebviewPool.f30872b, "offScreenRender -> loadUrl ");
                            webview.k(lVar);
                        }
                        View view2 = webview.getView();
                        ShellWebView shellWebView2 = view2 instanceof ShellWebView ? (ShellWebView) view2 : null;
                        if (shellWebView2 != null) {
                            shellWebView2.setOffScreenRender(true);
                        }
                        OffScreenWebviewPool.f30875e.set(false);
                    }
                });
            } else {
                TmcLogger.c(str, "offScreenRender -> 当前url已被离屏渲染过，本次操作不再继续执行");
                f30875e.set(false);
            }
        }
    }

    public void l(Activity activity, Object tag, g gVar) {
        PageType pageType;
        Intrinsics.g(activity, "activity");
        Intrinsics.g(tag, "tag");
        String str = f30872b;
        TmcLogger.c(str, "retryOffScreenRender -> " + tag + ", enable: " + f30878h);
        if (!f30878h) {
            f30876f = null;
            f30877g = null;
            return;
        }
        String str2 = f30876f;
        if (str2 == null || (pageType = f30877g) == null) {
            return;
        }
        f30876f = null;
        f30877g = null;
        TmcLogger.c(str, "real retryOffScreenRender -> " + tag);
        k(str2, pageType, activity, gVar);
    }

    public final void m(final Function0<Unit> function0) {
        if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
            function0.invoke();
        } else {
            e.f(new Runnable() { // from class: com.cloud.tmc.integration.performance.offscreen.webview.a
                @Override // java.lang.Runnable
                public final void run() {
                    OffScreenWebviewPool.n(function0);
                }
            });
        }
    }
}
