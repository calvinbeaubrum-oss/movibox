package com.transsion.commercialization.task;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.commercialization.task.DownloadInterceptDialog$rewardInterceptListener$1$onAdRewarded$1", f = "DownloadInterceptDialog.kt", l = {}, m = "invokeSuspend")
public final class DownloadInterceptDialog$rewardInterceptListener$1$onAdRewarded$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DownloadInterceptDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadInterceptDialog$rewardInterceptListener$1$onAdRewarded$1(DownloadInterceptDialog downloadInterceptDialog, Continuation<? super DownloadInterceptDialog$rewardInterceptListener$1$onAdRewarded$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadInterceptDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DownloadInterceptDialog$rewardInterceptListener$1$onAdRewarded$1 downloadInterceptDialog$rewardInterceptListener$1$onAdRewarded$1 = new DownloadInterceptDialog$rewardInterceptListener$1$onAdRewarded$1(this.this$0, continuation);
        downloadInterceptDialog$rewardInterceptListener$1$onAdRewarded$1.L$0 = obj;
        return downloadInterceptDialog$rewardInterceptListener$1$onAdRewarded$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadInterceptDialog$rewardInterceptListener$1$onAdRewarded$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.this$0.f51755v = true;
        this.this$0.f51741h = 2;
        Function1 function1 = this.this$0.f51740g;
        if (function1 != null) {
        }
        if (!this.this$0.isAdded() || this.this$0.isDetached() || this.this$0.isRemoving()) {
            return Unit.f68710a;
        }
        DownloadInterceptDialog downloadInterceptDialog = this.this$0;
        try {
            Result.Companion companion = Result.Companion;
            downloadInterceptDialog.dismissAllowingStateLoss();
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        this.this$0.w1();
        return Unit.f68710a;
    }
}
