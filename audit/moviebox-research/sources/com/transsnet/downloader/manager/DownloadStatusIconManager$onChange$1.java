package com.transsnet.downloader.manager;

import com.tn.lib.util.networkinfo.f;
import com.transsnet.downloader.callback.DownloadTaskStat;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadStatusIconManager$onChange$1", f = "DownloadStatusIconManager.kt", l = {}, m = "invokeSuspend")
public final class DownloadStatusIconManager$onChange$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadTaskStat $downloadTaskStat;
    int label;
    final /* synthetic */ DownloadStatusIconManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadStatusIconManager$onChange$1(DownloadStatusIconManager downloadStatusIconManager, DownloadTaskStat downloadTaskStat, Continuation<? super DownloadStatusIconManager$onChange$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadStatusIconManager;
        this.$downloadTaskStat = downloadTaskStat;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadStatusIconManager$onChange$1(this.this$0, this.$downloadTaskStat, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadStatusIconManager$onChange$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.this$0.f61053e = this.$downloadTaskStat.getLoadingCount();
        this.this$0.f61051c = this.$downloadTaskStat.getErrorCount();
        this.this$0.f61052d = this.$downloadTaskStat.getDoneCount();
        this.this$0.f61054f = this.$downloadTaskStat.getWaitCount();
        if (this.this$0.f61055g) {
            this.this$0.f61052d = 0;
        }
        int i11 = this.this$0.f61053e + this.this$0.f61054f;
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, "DownloadStatus", "on download change, errorCount = " + this.this$0.f61051c + ", doneCount = " + this.this$0.f61052d + ", loadingCount = " + this.this$0.f61053e + ",  waitCount = " + this.$downloadTaskStat.getWaitCount(), false, 4, null);
        if (!f.f49475a.e()) {
            if (this.this$0.f61054f <= 0 || this.this$0.f61051c != 0) {
                DownloadStatusIconManager downloadStatusIconManager = this.this$0;
                DownloadStatusIconManager.q(downloadStatusIconManager, (downloadStatusIconManager.f61051c == 0 && this.this$0.f61052d == 0 && this.this$0.f61053e == 0) ? 0 : 2, 0, 2, null);
            } else {
                this.this$0.p(4, i11);
            }
            uo.b.a.f(aVar, "DownloadStatus", "no net, show error~", false, 4, null);
            return Unit.f68710a;
        }
        if (this.this$0.f61051c > 0) {
            DownloadStatusIconManager downloadStatusIconManager2 = this.this$0;
            DownloadStatusIconManager.q(downloadStatusIconManager2, downloadStatusIconManager2.f61053e > 0 ? 3 : 2, 0, 2, null);
        } else if (i11 > 0) {
            DownloadStatusIconManager downloadStatusIconManager3 = this.this$0;
            downloadStatusIconManager3.p(downloadStatusIconManager3.f61053e > 0 ? 5 : 4, i11);
        } else if (this.this$0.f61052d > 0) {
            DownloadStatusIconManager.q(this.this$0, 1, 0, 2, null);
        } else if (this.this$0.f61051c == 0 && this.this$0.f61052d == 0 && this.this$0.f61053e == 0) {
            DownloadStatusIconManager.q(this.this$0, 0, 0, 2, null);
        }
        return Unit.f68710a;
    }
}
