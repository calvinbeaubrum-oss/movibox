package com.cloud.tmc.offline.download.task;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import ce.b;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.proxy.IAppInfoManagerProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OfflineZipDownloadInfo;
import com.cloud.tmc.offline.download.model.PrePullAppInfo;
import com.cloud.tmc.offline.download.utils.PrePullAppInfoUtils;
import com.cloud.tmc.offline.download.utils.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class PrePullAppInfoParseTask extends ce.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f32034j = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f32035h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function2<? super b, ? super yd.a<?>, Unit> f32036i;

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
    public PrePullAppInfoParseTask(String previousStep, Function2<? super b, ? super yd.a<?>, Unit> function2) {
        super("PrePullAppInfoParseTask", 0L, 2, null);
        Intrinsics.g(previousStep, "previousStep");
        this.f32035h = previousStep;
        this.f32036i = function2;
    }

    @Override // ce.b
    public String I() {
        return "idle";
    }

    @Override // ce.a, ce.b
    public Function2<b, yd.a<?>, Unit> J() {
        return this.f32036i;
    }

    @Override // ce.b
    public void P(final Function1<? super yd.a<?>, Unit> function1) {
        TmcLogger.c("PrePullAppInfoParseTask", "previousStep: " + this.f32035h);
        PrePullAppInfoUtils prePullAppInfoUtils = PrePullAppInfoUtils.f32085a;
        if (!prePullAppInfoUtils.h()) {
            TmcLogger.c("PrePullAppInfoParseTask", "当前尚未下载，不执行解析");
            j(function1);
            return;
        }
        final OffPkgConfig offPkgConfigE = prePullAppInfoUtils.e();
        final File fileD = prePullAppInfoUtils.d(offPkgConfigE);
        if (fileD == null) {
            TmcLogger.c("PrePullAppInfoParseTask", "Generating download file failed");
            j(function1);
            return;
        }
        File parentFile = fileD.getParentFile();
        if (parentFile == null) {
            TmcLogger.c("PrePullAppInfoParseTask", "parentFile is null");
            j(function1);
            return;
        }
        if (!parentFile.exists()) {
            TmcLogger.c("PrePullAppInfoParseTask", "unzip path is not exists");
            parentFile.mkdirs();
        }
        prePullAppInfoUtils.l(new OfflineZipDownloadInfo(offPkgConfigE.getPkgUrl(), null, 3, null, 10, null));
        String absolutePath = parentFile.getAbsolutePath();
        Intrinsics.f(absolutePath, "parentFile.absolutePath");
        prePullAppInfoUtils.a(absolutePath);
        String absolutePath2 = parentFile.getAbsolutePath();
        Intrinsics.f(absolutePath2, "parentFile.absolutePath");
        prePullAppInfoUtils.m(fileD, absolutePath2, new Function3<Boolean, String, Throwable, Unit>() { // from class: com.cloud.tmc.offline.download.task.PrePullAppInfoParseTask$run$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str, Throwable th2) {
                invoke(bool.booleanValue(), str, th2);
                return Unit.f68710a;
            }

            public final void invoke(boolean z11, String zipUnCompressPath, Throwable th2) {
                Intrinsics.g(zipUnCompressPath, "zipUnCompressPath");
                f.f32092a.f("step_unzip", this.this$0.f32035h, z11 ? 1 : 0, offPkgConfigE.getPkgUrl(), z11 ? "200" : "105", Log.getStackTraceString(th2));
                if (!z11) {
                    PrePullAppInfoUtils.f32085a.l(new OfflineZipDownloadInfo(offPkgConfigE.getPkgUrl(), null, 5, null, 10, null));
                    TmcLogger.c("PrePullAppInfoParseTask", "解压文件失败，targetFile: " + fileD);
                    this.this$0.j(function1);
                    return;
                }
                PrePullAppInfoUtils.f32085a.l(new OfflineZipDownloadInfo(offPkgConfigE.getPkgUrl(), null, 4, null, 10, null));
                TmcLogger.c("PrePullAppInfoParseTask", "解压成功，zipUnCompressPath is " + zipUnCompressPath);
                try {
                    this.this$0.i(offPkgConfigE, zipUnCompressPath, function1);
                } catch (Throwable th3) {
                    TmcLogger.g("PrePullAppInfoParseTask", "解析失败", th3);
                    this.this$0.j(function1);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(OffPkgConfig offPkgConfig, String str, Function1<? super yd.a<?>, Unit> function1) {
        PrePullAppInfoUtils prePullAppInfoUtils = PrePullAppInfoUtils.f32085a;
        prePullAppInfoUtils.l(new OfflineZipDownloadInfo(offPkgConfig.getPkgUrl(), null, 6, null, 10, null));
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ArrayList<PrePullAppInfo> arrayListK = prePullAppInfoUtils.k(str, new Function1<Throwable, Unit>() { // from class: com.cloud.tmc.offline.download.task.PrePullAppInfoParseTask$parseAppInfo$loadCdnAppInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                invoke2(th2);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable e11) {
                Intrinsics.g(e11, "e");
                objectRef.element = e11;
            }
        });
        int i11 = arrayListK == null ? 0 : 1;
        String str2 = arrayListK == null ? "107" : "200";
        String stackTraceString = arrayListK == null ? Log.getStackTraceString((Throwable) objectRef.element) : "success";
        Intrinsics.f(stackTraceString, "if (loadCdnAppInfo == nu…arseError) else \"success\"");
        f.f32092a.f("step_parse", this.f32035h, i11, offPkgConfig.getPkgUrl(), str2, stackTraceString);
        if (arrayListK == null) {
            prePullAppInfoUtils.l(new OfflineZipDownloadInfo(offPkgConfig.getPkgUrl(), null, 5, null, 10, null));
            TmcLogger.c("PrePullAppInfoParseTask", "loadCdnAppInfo is not valid");
            j(function1);
            return;
        }
        if (Build.VERSION.SDK_INT != 29 || MiniAppConfigHelper.f30370a.b("eofflineafq", true)) {
            Iterator<PrePullAppInfo> it = arrayListK.iterator();
            Intrinsics.f(it, "loadCdnAppInfo.iterator()");
            while (it.hasNext()) {
                PrePullAppInfo next = it.next();
                Intrinsics.f(next, "iterator.next()");
                PrePullAppInfo prePullAppInfo = next;
                String appId = prePullAppInfo.getAppId();
                AppModel appInfo = prePullAppInfo.getAppInfo();
                if (appId != null && appId.length() != 0) {
                    TmcLogger.c("PrePullAppInfoParseTask", "解析存储 appId: " + appId);
                    Context contextA = OfflineManager.A();
                    if (contextA != null) {
                        ((IAppInfoManagerProxy) tc.a.a(IAppInfoManagerProxy.class)).updateAppModelByOffline(contextA, appInfo, appId + "_cdn");
                    }
                }
            }
        }
        TmcLogger.c("PrePullAppInfoParseTask", "解析完成，解析数量：" + arrayListK.size());
        PrePullAppInfoUtils.f32085a.l(new OfflineZipDownloadInfo(offPkgConfig.getPkgUrl(), null, 7, null, 10, null));
        f.f32092a.c();
    }

    public final void j(Function1<? super yd.a<?>, Unit> function1) {
        if (!Intrinsics.b(this.f32035h, "step_check")) {
            f.f32092a.c();
            return;
        }
        boolean zG = PrePullAppInfoUtils.f32085a.g();
        TmcLogger.c("PrePullAppInfoParseTask", "检查间隔时间是否允许: " + zG);
        if (!zG || function1 == null) {
            return;
        }
        function1.invoke(new yd.a.b("step_download", false, 2, null));
    }
}
