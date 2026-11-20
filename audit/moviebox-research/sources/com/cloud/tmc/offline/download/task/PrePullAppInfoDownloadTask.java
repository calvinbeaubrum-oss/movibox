package com.cloud.tmc.offline.download.task;

import android.util.Log;
import ce.b;
import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;
import com.cloud.tmc.integration.utils.x;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OfflineZipDownloadInfo;
import com.cloud.tmc.offline.download.utils.PrePullAppInfoUtils;
import com.cloud.tmc.offline.download.utils.e;
import com.cloud.tmc.offline.download.utils.f;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class PrePullAppInfoDownloadTask extends ce.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f32024j = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f32025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function2<? super b, ? super yd.a<?>, Unit> f32026i;

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
    public PrePullAppInfoDownloadTask(String previousStep, Function2<? super b, ? super yd.a<?>, Unit> function2) {
        super("PrePullAppInfoDownloadTask", 0L, 2, null);
        Intrinsics.g(previousStep, "previousStep");
        this.f32025h = previousStep;
        this.f32026i = function2;
    }

    @Override // ce.b
    public String I() {
        return "idle";
    }

    @Override // ce.a, ce.b
    public Function2<b, yd.a<?>, Unit> J() {
        return this.f32026i;
    }

    @Override // ce.b
    public void P(final Function1<? super yd.a<?>, Unit> function1) {
        TmcLogger.c("PrePullAppInfoDownloadTask", "previousStep: " + this.f32025h);
        if (!e.a()) {
            TmcLogger.c("PrePullAppInfoDownloadTask", "Network is not connected");
            return;
        }
        PrePullAppInfoUtils prePullAppInfoUtils = PrePullAppInfoUtils.f32085a;
        final OffPkgConfig offPkgConfigE = prePullAppInfoUtils.e();
        File fileD = prePullAppInfoUtils.d(offPkgConfigE);
        if (fileD == null) {
            TmcLogger.c("PrePullAppInfoDownloadTask", "Generating download file failed");
            return;
        }
        String pkgUrl = offPkgConfigE.getPkgUrl();
        String absolutePath = fileD.getAbsolutePath();
        Intrinsics.f(absolutePath, "targetFile.absolutePath");
        e(pkgUrl, absolutePath, new Function0<Unit>() { // from class: com.cloud.tmc.offline.download.task.PrePullAppInfoDownloadTask$run$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PrePullAppInfoUtils.f32085a.l(new OfflineZipDownloadInfo(offPkgConfigE.getPkgUrl(), null, 2, null, 10, null));
                f.f32092a.f("step_download", this.f32025h, 1, offPkgConfigE.getPkgUrl(), "200", "success");
                Function1<yd.a<?>, Unit> function2 = function1;
                if (function2 != null) {
                    function2.invoke(new yd.a.b("step_unzip", false, 2, null));
                }
            }
        }, new Function3<String, String, IOException, Unit>() { // from class: com.cloud.tmc.offline.download.task.PrePullAppInfoDownloadTask$run$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, IOException iOException) {
                invoke2(str, str2, iOException);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str, String str2, IOException iOException) {
                String str3;
                PrePullAppInfoUtils.f32085a.l(new OfflineZipDownloadInfo(offPkgConfigE.getPkgUrl(), null, 0, null, 10, null));
                String stackTraceString = Log.getStackTraceString(iOException);
                Intrinsics.f(stackTraceString, "getStackTraceString(e)");
                if (stackTraceString.length() == 0) {
                    if (str2 == null) {
                        str2 = "";
                    }
                    str3 = str2;
                } else {
                    str3 = stackTraceString;
                }
                f fVar = f.f32092a;
                fVar.f("step_download", this.f32025h, 0, offPkgConfigE.getPkgUrl(), str, str3);
                fVar.c();
            }
        });
    }

    public final void e(String str, String str2, Function0<Unit> function0, Function3<? super String, ? super String, ? super IOException, Unit> function3) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    String strA = x.f31135a.a();
                    ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).downloadPackage(strA, str, str2, new HashMap(), strA, new PrePullAppInfoDownloadTask$downloadFile$1(str, function3, function0, this, str2));
                    return;
                }
            } catch (Throwable th2) {
                TmcLogger.h("PrePullAppInfoDownloadTask", th2);
                return;
            }
        }
        TmcLogger.c("PrePullAppInfoDownloadTask", "下载链接为 null");
        if (function3 != null) {
            function3.invoke(StatisticData.ERROR_CODE_IO_ERROR, "下载链接为 null", null);
        }
    }
}
