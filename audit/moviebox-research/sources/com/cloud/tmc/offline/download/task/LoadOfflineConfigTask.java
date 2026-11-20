package com.cloud.tmc.offline.download.task;

import android.content.Context;
import android.os.SystemClock;
import ce.b;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.bean.BaseResponse;
import com.cloud.h5update.bean.UpdateEntity;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.OfflineDownloadAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.th5update.UpdateChecker;
import com.cloud.tmc.offline.download.utils.OfflineStoreCache;
import com.cloud.tmc.offline.download.utils.OfflineUtils;
import com.cloud.tmc.offline.download.utils.e;
import com.google.gson.reflect.TypeToken;
import com.transsion.gslb.Worker;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class LoadOfflineConfigTask extends ce.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f32014l = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f32015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f32016i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function2<? super b, ? super yd.a<?>, Unit> f32017j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f32018k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadOfflineConfigTask(String _packageName, int i11, String trigger, Function2<? super b, ? super yd.a<?>, Unit> function2) {
        super("LoadOfflineConfigTask-" + _packageName, 0L, 2, null);
        Intrinsics.g(_packageName, "_packageName");
        Intrinsics.g(trigger, "trigger");
        this.f32015h = _packageName;
        this.f32016i = trigger;
        this.f32017j = function2;
        this.f32018k = i11;
    }

    @Override // ce.b
    public String I() {
        return this.f32016i;
    }

    @Override // ce.a, ce.b
    public Function2<b, yd.a<?>, Unit> J() {
        return this.f32017j;
    }

    @Override // ce.a, ce.b
    public boolean M() {
        return true;
    }

    @Override // ce.b
    public void P(final Function1<? super yd.a<?>, Unit> function1) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jL = jElapsedRealtime - L();
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(null, OfflineDownloadAnalyseType.QUEUE_TIME, this + "，耗时：" + jL + "ms", OfflineUtils.Q(OfflineUtils.f32081a, null, I(), Boolean.valueOf(M()), Long.valueOf(jL), this, 1, null));
        if (!e.a()) {
            TmcLogger.c("TmcOfflineDownload: LoadOfflineConfigTask", "Network connection is not connected!");
            if (function1 != null) {
                function1.invoke(new yd.a.C0915a(107, "Network connection is not connected!", true));
                return;
            }
            return;
        }
        TmcLogger.c("TmcOfflineDownload: LoadOfflineConfigTask", "request config _packageName: " + this.f32015h);
        TH5Update.a aVar = TH5Update.f28868c;
        TH5Update.a.m(aVar, this.f32015h, null, 0, 6, null);
        Context contextA = OfflineManager.A();
        if (contextA != null) {
            aVar.k(contextA).c(new UpdateChecker(new vd.a() { // from class: com.cloud.tmc.offline.download.task.LoadOfflineConfigTask$run$1
                @Override // vd.a
                public void a(String url, int i11, String str) {
                    Intrinsics.g(url, "url");
                    TmcLogger.f("TmcOfflineDownload: LoadOfflineConfigTask", "onFailure: " + url + ' ' + i11 + ' ' + str);
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(null, OfflineDownloadAnalyseType.DOWNLOAD_TIME, this + "，耗时：" + jElapsedRealtime2 + "ms", OfflineUtils.Q(OfflineUtils.f32081a, null, this.I(), Boolean.valueOf(this.M()), Long.valueOf(jElapsedRealtime2), this, 1, null));
                    Function1<yd.a<?>, Unit> function2 = function1;
                    if (function2 != null) {
                        function2.invoke(new yd.a.C0915a(112, "errCode: " + i11 + " errMsg: " + str, true));
                    }
                }

                @Override // vd.a
                public boolean onSuccess(String responseStr) {
                    Intrinsics.g(responseStr, "responseStr");
                    TmcLogger.c("TmcOfflineDownload: LoadOfflineConfigTask", "responseStr: " + responseStr);
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                    OfflineDownloadAnalyseType offlineDownloadAnalyseType = OfflineDownloadAnalyseType.DOWNLOAD_TIME;
                    String str = this + "，耗时：" + jElapsedRealtime2 + "ms";
                    OfflineUtils offlineUtils = OfflineUtils.f32081a;
                    performanceAnalyseProxy.record(null, offlineDownloadAnalyseType, str, OfflineUtils.Q(offlineUtils, null, this.I(), Boolean.valueOf(this.M()), Long.valueOf(jElapsedRealtime2), this, 1, null));
                    if (responseStr.length() == 0) {
                        Function1<yd.a<?>, Unit> function2 = function1;
                        if (function2 != null) {
                            function2.invoke(new yd.a.C0915a(108, "responseStr is empty!", true));
                        }
                        return true;
                    }
                    try {
                        Type type = new TypeToken<BaseResponse<UpdateEntity>>() { // from class: com.cloud.tmc.offline.download.task.LoadOfflineConfigTask$run$1$onSuccess$response$1
                        }.getType();
                        Intrinsics.f(type, "object :\n               …<UpdateEntity>>() {}.type");
                        BaseResponse baseResponse = (BaseResponse) TmcGsonUtils.e(responseStr, type);
                        if (baseResponse.getCode() != 0) {
                            Function1<yd.a<?>, Unit> function3 = function1;
                            if (function3 != null) {
                                function3.invoke(new yd.a.C0915a(109, "request failed with code: " + baseResponse.getCode() + " and message: " + baseResponse.getMessage(), true));
                            }
                            return true;
                        }
                        OffPkgConfig offPkgConfigR = offlineUtils.r((UpdateEntity) baseResponse.getData());
                        if (offPkgConfigR == null) {
                            Function1<yd.a<?>, Unit> function4 = function1;
                            if (function4 != null) {
                                function4.invoke(new yd.a.C0915a(Worker.WHAT_QUIT, "TH5Update configure conversion offPkgConfig failed!", true));
                            }
                            return true;
                        }
                        if (offlineUtils.K(offPkgConfigR)) {
                            OfflineStoreCache.f32077a.p(offPkgConfigR);
                            TmcLogger.c("TmcOfflineDownload: LoadOfflineConfigTask", "Load offline configuration successfully");
                            Function1<yd.a<?>, Unit> function5 = function1;
                            if (function5 != null) {
                                function5.invoke(new yd.a.b(offPkgConfigR, true));
                            }
                            return true;
                        }
                        offlineUtils.o(offPkgConfigR);
                        Function1<yd.a<?>, Unit> function6 = function1;
                        if (function6 != null) {
                            StringBuilder sb2 = new StringBuilder();
                            String group = offPkgConfigR.getGroup();
                            if (group == null) {
                                group = "It";
                            }
                            sb2.append(group);
                            sb2.append(" doesn't require a download");
                            function6.invoke(new yd.a.C0915a(111, sb2.toString(), true));
                        }
                        return true;
                    } catch (Throwable th2) {
                        TmcLogger.g("TmcOfflineDownload: LoadOfflineConfigTask", "Exception json parse error", th2);
                        Function1<yd.a<?>, Unit> function7 = function1;
                        if (function7 != null) {
                            function7.invoke(new yd.a.C0915a(1000, th2.getMessage(), true));
                        }
                    }
                }
            })).b();
            return;
        }
        TmcLogger.c("TmcOfflineDownload: LoadOfflineConfigTask", "context is null!");
        if (function1 != null) {
            function1.invoke(new yd.a.C0915a(0, "context is null!", false, 5, null));
        }
    }

    @Override // ce.a, ce.b
    public int getPriority() {
        return this.f32018k;
    }
}
