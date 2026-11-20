package com.transsnet.downloader.manager;

import com.transsion.baselib.db.download.DownloadBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
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
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadByResId$2", f = "DownloadManagerImpl.kt", l = {952}, m = "invokeSuspend")
public final class DownloadManagerImpl$getDownloadByResId$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<DownloadBean, Unit> $callback;
    final /* synthetic */ Ref.ObjectRef<DownloadBean> $downloadInfo;
    final /* synthetic */ String $resourceId;
    Object L$0;
    int label;
    final /* synthetic */ DownloadManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadManagerImpl$getDownloadByResId$2(Ref.ObjectRef<DownloadBean> objectRef, String str, Function1<? super DownloadBean, Unit> function1, DownloadManagerImpl downloadManagerImpl, Continuation<? super DownloadManagerImpl$getDownloadByResId$2> continuation) {
        super(2, continuation);
        this.$downloadInfo = objectRef;
        this.$resourceId = str;
        this.$callback = function1;
        this.this$0 = downloadManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerImpl$getDownloadByResId$2(this.$downloadInfo, this.$resourceId, this.$callback, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerImpl$getDownloadByResId$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0058  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.ObjectRef<DownloadBean> objectRef;
        T t11;
        Ref.ObjectRef<DownloadBean> objectRef2;
        DownloadBean downloadBean;
        DownloadManagerImpl downloadManagerImpl;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            objectRef = this.$downloadInfo;
            if (objectRef.element == null) {
                String str = this.$resourceId;
                if (str != null) {
                    DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
                    this.L$0 = objectRef;
                    this.label = 1;
                    Object objK = downloadEsHelperA.k(str, this);
                    if (objK == objE) {
                        return objE;
                    }
                    objectRef2 = objectRef;
                    obj = objK;
                } else {
                    t11 = 0;
                }
                objectRef.element = t11;
                downloadBean = this.$downloadInfo.element;
                if (downloadBean != null) {
                    downloadManagerImpl = this.this$0;
                    if (!downloadManagerImpl.f61022c.contains(downloadBean)) {
                        downloadManagerImpl.f61022c.add(downloadBean);
                    }
                }
            }
            this.$callback.invoke(this.$downloadInfo.element);
            return Unit.f68710a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef2 = (Ref.ObjectRef) this.L$0;
        ResultKt.b(obj);
        Ref.ObjectRef<DownloadBean> objectRef3 = objectRef2;
        t11 = (DownloadBean) obj;
        objectRef = objectRef3;
        objectRef.element = t11;
        downloadBean = this.$downloadInfo.element;
        if (downloadBean != null) {
            downloadManagerImpl = this.this$0;
            if (!downloadManagerImpl.f61022c.contains(downloadBean)) {
                downloadManagerImpl.f61022c.add(downloadBean);
            }
        }
        this.$callback.invoke(this.$downloadInfo.element);
        return Unit.f68710a;
    }
}
