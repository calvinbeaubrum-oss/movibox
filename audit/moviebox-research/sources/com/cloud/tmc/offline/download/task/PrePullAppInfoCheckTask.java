package com.cloud.tmc.offline.download.task;

import ce.b;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.utils.PrePullAppInfoUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class PrePullAppInfoCheckTask extends ce.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f32022i = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function2<? super b, ? super yd.a<?>, Unit> f32023h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PrePullAppInfoCheckTask(Function2<? super b, ? super yd.a<?>, Unit> function2) {
        super("PrePullAppInfoCheckTask", 0L, 2, null);
        this.f32023h = function2;
    }

    @Override // ce.b
    public String I() {
        return "idle";
    }

    @Override // ce.a, ce.b
    public Function2<b, yd.a<?>, Unit> J() {
        return this.f32023h;
    }

    @Override // ce.b
    public void P(final Function1<? super yd.a<?>, Unit> function1) {
        if (OfflineManager.a0()) {
            TmcLogger.c("PrePullAppInfoCheckTask", "开启了强制刷新精选 AppInfo，跳过检查步骤");
            if (function1 != null) {
                function1.invoke(new yd.a.b("step_download", false, 2, null));
                return;
            }
            return;
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.cloud.tmc.offline.download.task.PrePullAppInfoCheckTask$run$downloadStepBlock$1
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
                Function1<yd.a<?>, Unit> function2;
                boolean zG = PrePullAppInfoUtils.f32085a.g();
                TmcLogger.c("PrePullAppInfoCheckTask", "检查间隔时间是否允许: " + zG);
                if (!zG || (function2 = function1) == null) {
                    return;
                }
                function2.invoke(new yd.a.b("step_download", false, 2, null));
            }
        };
        PrePullAppInfoUtils prePullAppInfoUtils = PrePullAppInfoUtils.f32085a;
        if (!prePullAppInfoUtils.h()) {
            function0.invoke();
            return;
        }
        if (prePullAppInfoUtils.i()) {
            TmcLogger.c("PrePullAppInfoCheckTask", "已下载，检查不是合法 zip 包");
            function0.invoke();
        } else if (prePullAppInfoUtils.j()) {
            TmcLogger.c("PrePullAppInfoCheckTask", "已下载且已解析成功");
            function0.invoke();
        } else if (function1 != null) {
            function1.invoke(new yd.a.b("step_unzip", false, 2, null));
        }
    }
}
