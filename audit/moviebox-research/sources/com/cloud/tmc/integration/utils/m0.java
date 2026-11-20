package com.cloud.tmc.integration.utils;

import android.os.Bundle;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

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
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f31077a = new m0();

    @JvmStatic
    @JvmOverloads
    public static final void a(Page page, String navigationType, String str, String str2) {
        App app;
        Intrinsics.g(navigationType, "navigationType");
        try {
            boolean zContains = kotlin.collections.g.o("onStart", "hotReLaunch", "hotNavigateTo", "hotShellStart").contains(navigationType);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            String appId = (page == null || (app = page.getApp()) == null) ? null : app.getAppId();
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_OPEN_PAGE_ACTION;
            Bundle bundle = new Bundle();
            String str3 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
            String pagePath = page != null ? page.getPagePath() : null;
            if (pagePath == null) {
                pagePath = "";
            }
            bundle.putString(str3, xb.e.a(str, pagePath));
            bundle.putString("navigationType", navigationType);
            bundle.putBoolean("navigationIsFirstPage", zContains);
            if (str2 == null) {
                str2 = "null";
            }
            bundle.putString("pageRandomId", str2);
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.record(appId, pointAnalyseType, "", bundle);
        } catch (Throwable th2) {
            TmcLogger.g("TrackPointUtils", th2.getMessage(), th2);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void b(Page page) {
        e(page, null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001a  */
    @JvmStatic
    @JvmOverloads
    public static final void c(Page page, String str) {
        Bundle startParams;
        String string;
        App app;
        if (page != null) {
            try {
                App app2 = page.getApp();
                if (app2 == null || (startParams = app2.getStartParams()) == null) {
                    string = null;
                } else {
                    string = startParams.getString("uniqueChainID", "-1");
                }
            } catch (Throwable th2) {
                TmcLogger.g("TrackPointUtils", th2.getMessage(), th2);
                return;
            }
        } else {
            string = null;
        }
        String strA = xb.e.a(string, "-1");
        String appId = (page == null || (app = page.getApp()) == null) ? null : app.getAppId();
        String pagePath = page != null ? page.getPagePath() : null;
        if (pagePath == null) {
            pagePath = "";
        }
        d(appId, strA, xb.e.a(str, pagePath));
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(String str, String chainId, String str2) {
        Intrinsics.g(chainId, "chainId");
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_END;
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, chainId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, String.valueOf(str2));
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.record(str, pointAnalyseType, "21", bundle);
        } catch (Throwable th2) {
            TmcLogger.g("TrackPointUtils", th2.getMessage(), th2);
        }
    }

    public static /* synthetic */ void e(Page page, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        c(page, str);
    }

    @JvmStatic
    public static final void f(Page page, String navigationType) {
        String pageRandomIdByGAId;
        App app;
        App app2;
        Bundle startParams;
        Intrinsics.g(navigationType, "navigationType");
        if (page != null) {
            try {
                pageRandomIdByGAId = page.getPageRandomIdByGAId();
            } catch (Throwable th2) {
                TmcLogger.g("TrackPointUtils", th2.getMessage(), th2);
                return;
            }
        } else {
            pageRandomIdByGAId = null;
        }
        a(page, navigationType, null, pageRandomIdByGAId);
        g((page == null || (app = page.getApp()) == null) ? null : app.getAppId(), xb.e.a((page == null || (app2 = page.getApp()) == null || (startParams = app2.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1"), "-1"), String.valueOf(page != null ? page.getPagePath() : null), navigationType, page != null ? page.getPageRandomIdByGAId() : null);
    }

    @JvmStatic
    public static final void g(String str, String chainId, String pagePath, String navigationType, String str2) {
        Intrinsics.g(chainId, "chainId");
        Intrinsics.g(pagePath, "pagePath");
        Intrinsics.g(navigationType, "navigationType");
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_START;
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, chainId);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, pagePath);
            bundle.putString("navigationType", navigationType);
            bundle.putString("pageRandomId", String.valueOf(str2));
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.record(str, pointAnalyseType, "21", bundle);
        } catch (Throwable th2) {
            TmcLogger.g("TrackPointUtils", th2.getMessage(), th2);
        }
    }
}
