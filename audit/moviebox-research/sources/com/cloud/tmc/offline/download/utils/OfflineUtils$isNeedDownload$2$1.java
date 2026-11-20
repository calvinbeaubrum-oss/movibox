package com.cloud.tmc.offline.download.utils;

import com.cloud.h5update.bean.UpdateEntity;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "com.cloud.tmc.offline.download.utils.OfflineUtils$isNeedDownload$2$1", f = "OfflineUtils.kt", l = {}, m = "invokeSuspend")
public final class OfflineUtils$isNeedDownload$2$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ UpdateEntity $diffUpdateEntity;
    final /* synthetic */ OffPkgConfig $offPkgConfigCache;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineUtils$isNeedDownload$2$1(OffPkgConfig offPkgConfig, UpdateEntity updateEntity, Continuation<? super OfflineUtils$isNeedDownload$2$1> continuation) {
        super(2, continuation);
        this.$offPkgConfigCache = offPkgConfig;
        this.$diffUpdateEntity = updateEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineUtils$isNeedDownload$2$1(this.$offPkgConfigCache, this.$diffUpdateEntity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((OfflineUtils$isNeedDownload$2$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        try {
            OfflineUtils offlineUtils = OfflineUtils.f32081a;
            String group = this.$offPkgConfigCache.getGroup();
            String version = this.$offPkgConfigCache.getVersion();
            if (version == null) {
                version = "";
            }
            offlineUtils.n(group, version, this.$diffUpdateEntity);
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineUtils", "Error deleting", th2);
        }
        return Unit.f68710a;
    }
}
