package com.cloud.tmc.offline.download.task;

import android.util.Log;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.j;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OfflineZipDownloadInfo;
import com.cloud.tmc.offline.download.utils.OfflineStoreCache;
import com.cloud.tmc.offline.download.utils.PrePullAppInfoUtils;
import com.cloud.tmc.offline.download.utils.f;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.MediaType;
import wc.d;
import wc.e;

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
public final class PrePullAppInfoDownloadTask$downloadFile$1 implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OffPkgConfig f32027a = PrePullAppInfoUtils.f32085a.e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f32028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f32029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function3<String, String, IOException, Unit> f32030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ PrePullAppInfoDownloadTask f32032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f32033g;

    /* JADX WARN: Multi-variable type inference failed */
    public PrePullAppInfoDownloadTask$downloadFile$1(String str, Function3<? super String, ? super String, ? super IOException, Unit> function3, Function0<Unit> function0, PrePullAppInfoDownloadTask prePullAppInfoDownloadTask, String str2) {
        this.f32029c = str;
        this.f32030d = function3;
        this.f32031e = function0;
        this.f32032f = prePullAppInfoDownloadTask;
        this.f32033g = str2;
    }

    @Override // wc.f
    public /* synthetic */ void a(String str, int i11, String str2, long j11, long j12) {
        e.a(this, str, i11, str2, j11, j12);
    }

    @Override // wc.f
    public void b(String str, String str2, String str3, IOException iOException, String str4) {
        TmcLogger.f("PrePullAppInfoDownloadTask", "onFailed url: " + str + " errorCode: " + str2 + " errorMsg: " + str3 + " callbackId: " + str4);
        if (!CollectionsKt___CollectionsKt.X(g.o("D008", "D009"), str2)) {
            j.n(this.f32033g);
            Function3<String, String, IOException, Unit> function3 = this.f32030d;
            if (function3 != null) {
                function3.invoke(str2, str3, iOException);
                return;
            }
            return;
        }
        OfflineStoreCache.f32077a.n(this.f32027a);
        String stackTraceString = Log.getStackTraceString(iOException);
        Intrinsics.f(stackTraceString, "getStackTraceString(e)");
        if (stackTraceString.length() == 0) {
            stackTraceString = xb.e.a(str3, "No new version available");
        }
        String str5 = stackTraceString;
        f fVar = f.f32092a;
        fVar.f("step_download", this.f32032f.f32025h, 2, this.f32027a.getPkgUrl(), "102", str5);
        fVar.c();
    }

    @Override // wc.f
    public void c(String str, String str2) {
        TmcLogger.c("PrePullAppInfoDownloadTask", "onFinish url: " + str + " callbackId: " + str2);
        String str3 = this.f32028b;
        if (str3 != null) {
            OfflineStoreCache.f32077a.m(this.f32027a, str3);
        }
        Function0<Unit> function0 = this.f32031e;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // wc.d
    public boolean d(MediaType mediaType) {
        TmcLogger.c("PrePullAppInfoDownloadTask", "contentType: " + mediaType);
        return true;
    }

    @Override // wc.d
    public boolean e(Headers headers) {
        Intrinsics.g(headers, "headers");
        PrePullAppInfoUtils prePullAppInfoUtils = PrePullAppInfoUtils.f32085a;
        boolean zB = prePullAppInfoUtils.b(headers, new Function1<String, Unit>() { // from class: com.cloud.tmc.offline.download.task.PrePullAppInfoDownloadTask$downloadFile$1$responseHeader$isEquals$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String serverLastModify) {
                Intrinsics.g(serverLastModify, "serverLastModify");
                this.this$0.h(serverLastModify);
            }
        });
        if (!zB) {
            prePullAppInfoUtils.l(new OfflineZipDownloadInfo(this.f32029c, null, 1, null, 10, null));
        }
        return !zB;
    }

    @Override // wc.f
    public void f(String str, int i11, String str2) {
        TmcLogger.c("PrePullAppInfoDownloadTask", "onProgress url: " + str + " progress: " + i11 + " callbackId: " + str2);
    }

    @Override // wc.f
    public void g(String str, String str2) {
        TmcLogger.c("PrePullAppInfoDownloadTask", "onCancel url: " + str + " callbackId: " + str2);
        Function3<String, String, IOException, Unit> function3 = this.f32030d;
        if (function3 != null) {
            function3.invoke("106", "cancel download", null);
        }
    }

    public final void h(String str) {
        this.f32028b = str;
    }
}
