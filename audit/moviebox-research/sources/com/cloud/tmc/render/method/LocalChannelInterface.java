package com.cloud.tmc.render.method;

import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.render.ILocalChannelProxy;
import com.cloud.tmc.render.IPageChainCallback;
import com.cloud.tmc.render.proxy.SessionUtilProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class LocalChannelInterface {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f32099c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IPageChainCallback f32100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f32101b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int i11, String msg) {
            Intrinsics.g(msg, "msg");
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("reportForH5Fail", i11);
                bundle.putString("reportForH5FailReason", msg);
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).recordForCommon("", "miniapp_auto_close_record", bundle);
            } catch (Throwable unused) {
            }
        }
    }

    public LocalChannelInterface(IPageChainCallback iPageChainCallback) {
        this.f32100a = iPageChainCallback;
    }

    @JavascriptInterface
    public final String callBridgeApi(String str) {
        IPageChainCallback iPageChainCallback;
        if (str != null) {
            try {
                if (str.length() != 0 && (iPageChainCallback = this.f32100a) != null) {
                    iPageChainCallback.onConsoleMessage("__TmcRenderToWorkerMsg:" + str);
                }
            } catch (Throwable th2) {
                TmcLogger.h("callBridgeApi", th2);
            }
        }
        return "";
    }

    public final void clear() {
        this.f32100a = null;
    }

    @JavascriptInterface
    public final String gamePerformanceMonitorGetSessionId() {
        String id2;
        try {
            id2 = ((SessionUtilProxy) tc.a.a(SessionUtilProxy.class)).getId(this.f32101b);
        } catch (Throwable unused) {
            id2 = "";
        }
        TmcLogger.c("LocalChannelInterface", "gamePerformanceMonitorGetSessionId:" + id2);
        return id2;
    }

    @JavascriptInterface
    public final String gamePerformanceMonitorGetStr() {
        String strGamePerformanceMonitorGetStr;
        try {
            strGamePerformanceMonitorGetStr = ((ILocalChannelProxy) tc.a.a(ILocalChannelProxy.class)).gamePerformanceMonitorGetStr();
        } catch (Throwable unused) {
            strGamePerformanceMonitorGetStr = "";
        }
        TmcLogger.c("LocalChannelInterface", "gamePerformanceMonitorGetStr:" + strGamePerformanceMonitorGetStr);
        return strGamePerformanceMonitorGetStr;
    }

    public final IPageChainCallback getCallback() {
        return this.f32100a;
    }

    @JavascriptInterface
    public final String getMiniAppId() {
        String str = this.f32101b;
        return str == null ? "" : str;
    }

    @JavascriptInterface
    public final void onPageFinished(String params) {
        Intrinsics.g(params, "params");
        TmcLogger.c("LocalChannelInterface", "onPageFinised params:" + params);
        try {
            IPageChainCallback iPageChainCallback = this.f32100a;
            if (iPageChainCallback != null) {
                iPageChainCallback.onPageFinished(params);
            }
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public final void report(String tag, String reportData, int i11, int i12) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(reportData, "reportData");
        try {
            TmcLogger.c("LocalChannelInterface", "report tag:" + tag + ", reportData:" + reportData + ", reportType:" + i11 + ", athenaAppId:" + i12);
            ((ILocalChannelProxy) tc.a.a(ILocalChannelProxy.class)).report(tag, reportData, Integer.valueOf(i11), Integer.valueOf(i12));
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public final void reportForH5(String tag, String reportData, int i11, int i12) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(reportData, "reportData");
        try {
            ((ILocalChannelProxy) tc.a.a(ILocalChannelProxy.class)).reportForH5(tag, reportData, Integer.valueOf(i11), Integer.valueOf(i12));
        } catch (Throwable th2) {
            f32099c.a(1, String.valueOf(th2));
        }
    }

    public final void setAppId(String str) {
        this.f32101b = str;
    }

    public final void setCallback(IPageChainCallback iPageChainCallback) {
        this.f32100a = iPageChainCallback;
    }
}
