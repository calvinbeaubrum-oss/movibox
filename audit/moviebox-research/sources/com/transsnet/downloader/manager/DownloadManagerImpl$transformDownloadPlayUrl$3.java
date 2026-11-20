package com.transsnet.downloader.manager;

import com.transsion.baselib.db.download.DownloadBean;
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
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$transformDownloadPlayUrl$3", f = "DownloadManagerImpl.kt", l = {1598}, m = "invokeSuspend")
public final class DownloadManagerImpl$transformDownloadPlayUrl$3 extends SuspendLambda implements Function2<k0, Continuation<? super String>, Object> {
    final /* synthetic */ int $ep;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ DownloadManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadManagerImpl$transformDownloadPlayUrl$3(String str, int i11, String str2, DownloadManagerImpl downloadManagerImpl, Continuation<? super DownloadManagerImpl$transformDownloadPlayUrl$3> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.$ep = i11;
        this.$url = str2;
        this.this$0 = downloadManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerImpl$transformDownloadPlayUrl$3(this.$subjectId, this.$ep, this.$url, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super String> continuation) {
        return ((DownloadManagerImpl$transformDownloadPlayUrl$3) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0040  */
    /* JADX WARN: Code duplicated, block: B:16:0x0043  */
    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Code duplicated, block: B:25:0x005e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        DownloadBean downloadBeanS;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            DownloadEsHelper.a aVar = DownloadEsHelper.f60994m;
            downloadBeanS = aVar.a().s(this.$subjectId, this.$ep);
            if (downloadBeanS == null) {
                DownloadEsHelper downloadEsHelperA = aVar.a();
                String str = this.$subjectId;
                int i12 = this.$ep;
                this.label = 1;
                obj = downloadEsHelperA.r(str, i12, this);
                if (obj == objE) {
                    return objE;
                }
            }
            if (downloadBeanS == null) {
                return this.$url;
            }
            if (downloadBeanS.isCompleted()) {
                String path = downloadBeanS.getPath();
                return (path != null || path.length() == 0) ? this.$url : downloadBeanS.getPath();
            }
            this.this$0.j(downloadBeanS);
            return this.$url;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        downloadBeanS = (DownloadBean) obj;
        if (downloadBeanS == null) {
            return this.$url;
        }
        if (downloadBeanS.isCompleted()) {
            String path2 = downloadBeanS.getPath();
            if (path2 != null) {
            }
        }
        this.this$0.j(downloadBeanS);
        return this.$url;
    }
}
