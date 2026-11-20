package com.transsnet.downloader.manager;

import com.transsion.baselib.db.download.DownloadBean;
import java.util.concurrent.ConcurrentHashMap;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$onPreDownloadSuccess$1", f = "DownloadManagerImpl.kt", l = {}, m = "invokeSuspend")
public final class DownloadManagerImpl$onPreDownloadSuccess$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $downloadInfo;
    int label;
    final /* synthetic */ DownloadManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadManagerImpl$onPreDownloadSuccess$1(DownloadManagerImpl downloadManagerImpl, DownloadBean downloadBean, Continuation<? super DownloadManagerImpl$onPreDownloadSuccess$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadManagerImpl;
        this.$downloadInfo = downloadBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerImpl$onPreDownloadSuccess$1(this.this$0, this.$downloadInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerImpl$onPreDownloadSuccess$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        uo.b.a aVar = uo.b.f78622a;
        aVar.r(this.this$0.f61020a, "preDownload success, change to wait, name = " + this.$downloadInfo.getTotalTitleName() + "， progress = " + this.$downloadInfo.getProgress() + " ,status:" + this.$downloadInfo.getStatus(), true);
        if (this.$downloadInfo.getStatus() == 4) {
            aVar.t(this.this$0.f61020a, "preDownload success, but pause~， break-----", true);
            return Unit.f68710a;
        }
        this.$downloadInfo.setStatus(3);
        this.$downloadInfo.setPreDownload(false);
        com.transsnet.downloader.core.a aVar2 = this.this$0.f61023d;
        if (aVar2 != null) {
            aVar2.a(this.$downloadInfo);
        }
        ConcurrentHashMap concurrentHashMap = this.this$0.f61027h;
        String resourceId = this.$downloadInfo.getResourceId();
        if (resourceId == null) {
            resourceId = this.$downloadInfo.getUrl();
        }
        concurrentHashMap.remove(resourceId);
        ConcurrentHashMap concurrentHashMap2 = this.this$0.f61028i;
        String resourceId2 = this.$downloadInfo.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = this.$downloadInfo.getUrl();
        }
        concurrentHashMap2.remove(resourceId2);
        this.this$0.w0();
        return Unit.f68710a;
    }
}
