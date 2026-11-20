package com.cloud.tmc.integration.resource.processor;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.cloud.tmc.integration.resource.BaseResourceProcessor;
import com.cloud.tmc.integration.resource.ResourceAnalyseType;
import com.cloud.tmc.integration.resource.processor.OfflineDownloadResourceProcessor;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.OfflineDownloadAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.kernel.utils.r;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class OfflineDownloadResourceProcessor implements IResourceProcessor {
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void c(String str, String url, App app, Page page) {
        Intrinsics.g(url, "$url");
        if (str == null || str.length() == 0 || url.length() == 0) {
            TmcLogger.c("OfflineDownloadResource", "appId or url is null or empty");
            return;
        }
        if (!NetworkUtils.r()) {
            TmcLogger.c("OfflineDownloadResource", "网络未连接，无法完成校验。" + url);
            return;
        }
        if (((IOfflineManagerProxy) tc.a.a(IOfflineManagerProxy.class)).verifyServerFile(str, url)) {
            TmcLogger.c("OfflineDownloadResource", "文件校验通过，url: " + url);
            return;
        }
        TmcLogger.c("OfflineDownloadResource", "文件失效，lastModified and eTag not valid, url: " + url + ' ');
        if (app != null && app.getBooleanValue("disable_offline_processor")) {
            TmcLogger.c("OfflineDownloadResource", "app refreshing...");
            return;
        }
        if (app != null) {
            app.putBooleanValue("disable_offline_processor", true);
        }
        TmcLogger.c("OfflineDownloadResource", "app start refresh...");
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        OfflineDownloadAnalyseType offlineDownloadAnalyseType = OfflineDownloadAnalyseType.OFFLINE_RESOURCE_URL_CHANGE;
        Bundle bundle = new Bundle();
        bundle.putString("offline_pkg_appId", str);
        bundle.putString("offline_pkg_url", url);
        Unit unit = Unit.f68710a;
        performanceAnalyseProxy.record(str, offlineDownloadAnalyseType, "", bundle);
        if (page != null) {
            page.refreshApp();
        }
    }

    public final void b(final String str, final String str2, final App app, final Page page) {
        boolean zEnableVerifyServerFile = ((IOfflineManagerProxy) tc.a.a(IOfflineManagerProxy.class)).enableVerifyServerFile(str);
        TmcLogger.c("OfflineDownloadResource", "enableVerifyServerFile: " + zEnableVerifyServerFile);
        if (zEnableVerifyServerFile) {
            e.a(ExecutorType.NETWORK, new Runnable() { // from class: sb.a
                @Override // java.lang.Runnable
                public final void run() {
                    OfflineDownloadResourceProcessor.c(str, str2, app, page);
                }
            });
        }
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public List<String> fuzzySearch(String str, String str2) {
        return new ArrayList();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0036  */
    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public WebResourceResponse get(WebResourceRequest webResourceRequest, String str, Node node) {
        App app;
        Uri url = webResourceRequest != null ? webResourceRequest.getUrl() : null;
        if (url == null) {
            return null;
        }
        String string = url.toString();
        Intrinsics.f(string, "uri.toString()");
        if (string.length() == 0) {
            return null;
        }
        if (node instanceof App) {
            app = (App) node;
        } else {
            boolean z11 = node instanceof Page;
            if (z11) {
                Page page = z11 ? (Page) node : null;
                if (page != null) {
                    app = page.getApp();
                } else {
                    app = null;
                }
            } else {
                app = null;
            }
        }
        Page page2 = node instanceof Page ? (Page) node : null;
        boolean zL = h.f31061a.l(app != null ? app.getAppModel() : null);
        if (zL) {
            boolean booleanValue = app != null ? app.getBooleanValue("disable_offline_processor") : false;
            TmcLogger.c("OfflineDownloadResource", "是否关闭离线资源拦截器获取资源: " + booleanValue);
            if (booleanValue) {
                return null;
            }
        }
        File file = get(string, str);
        if (file == null) {
            return null;
        }
        if (zL) {
            b(str, string, app, page2);
        }
        try {
            return BaseResourceProcessor.addCommonWebRespHeaders(new WebResourceResponse(r.e(string), BaseResourceProcessor.getResourceResponseEncoding(), new FileInputStream(file)));
        } catch (Throwable th2) {
            TmcLogger.g("OfflineDownloadResource", "Failed to get resource", th2);
            return null;
        }
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public WebResourceResponse get(WebResourceRequest webResourceRequest, String str, String str2, Node node) {
        return get(webResourceRequest, str, node);
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public File get(String str, String str2) {
        String str3;
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            if (l.L(str, FileUtil.U("100000"), false, 2, null)) {
                TmcLogger.c("OfflineDownloadResource", "获取框架包离线资源：url=" + str);
                File offlineResources = ((IOfflineManagerProxy) tc.a.a(IOfflineManagerProxy.class)).getOfflineResources("100000", str);
                if (offlineResources != null) {
                    TmcLogger.c("OfflineDownloadResource", "框架包离线资源命中：url=" + str + "，vUrl=" + str + "，filePath=" + offlineResources.getAbsolutePath());
                } else {
                    offlineResources = null;
                }
                if (offlineResources != null) {
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(str2, ResourceAnalyseType.INTERCEPT_RESOURCE, offlineResources.getAbsolutePath());
                    return offlineResources;
                }
            }
            String strU = FileUtil.U(str2);
            try {
                String path = Uri.parse(str).getPath();
                if (path == null) {
                    return null;
                }
                if (l.L(path, "/", false, 2, null)) {
                    str3 = strU + path;
                } else {
                    str3 = strU + '/' + path;
                }
                TmcLogger.c("OfflineDownloadResource", "获取离线资源：url=" + str);
                File offlineResources2 = ((IOfflineManagerProxy) tc.a.a(IOfflineManagerProxy.class)).getOfflineResources(str2, str3);
                if (offlineResources2 == null) {
                    return null;
                }
                TmcLogger.c("OfflineDownloadResource", "离线资源命中：url=" + str + "，vUrl=" + str3 + "，filePath=" + offlineResources2.getAbsolutePath());
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(str2, ResourceAnalyseType.INTERCEPT_RESOURCE, offlineResources2.getAbsolutePath());
                return offlineResources2;
            } catch (Throwable th2) {
                TmcLogger.g("OfflineDownloadResource", "Failed to get resource", th2);
            }
        }
        return null;
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public File get(String str, String str2, String str3) {
        return get(str, str2);
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldIntercept(WebResourceRequest webResourceRequest, String str) {
        Uri url = webResourceRequest != null ? webResourceRequest.getUrl() : null;
        if (url == null) {
            return false;
        }
        String string = url.toString();
        Intrinsics.f(string, "uri.toString()");
        return string.length() > 0;
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldIntercept(String str, String str2) {
        return !(str == null || str.length() == 0);
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldInterceptFuzzySearch(String str) {
        return false;
    }
}
