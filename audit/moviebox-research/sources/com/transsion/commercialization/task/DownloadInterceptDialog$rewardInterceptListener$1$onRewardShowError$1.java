package com.transsion.commercialization.task;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.widget.R$string;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "com.transsion.commercialization.task.DownloadInterceptDialog$rewardInterceptListener$1$onRewardShowError$1", f = "DownloadInterceptDialog.kt", l = {}, m = "invokeSuspend")
public final class DownloadInterceptDialog$rewardInterceptListener$1$onRewardShowError$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DownloadInterceptDialog this$0;
    final /* synthetic */ DownloadInterceptDialog$rewardInterceptListener$1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadInterceptDialog$rewardInterceptListener$1$onRewardShowError$1(DownloadInterceptDialog downloadInterceptDialog, DownloadInterceptDialog$rewardInterceptListener$1 downloadInterceptDialog$rewardInterceptListener$1, Continuation<? super DownloadInterceptDialog$rewardInterceptListener$1$onRewardShowError$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadInterceptDialog;
        this.this$1 = downloadInterceptDialog$rewardInterceptListener$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadInterceptDialog$rewardInterceptListener$1$onRewardShowError$1(this.this$0, this.this$1, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadInterceptDialog$rewardInterceptListener$1$onRewardShowError$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        os.e eVar;
        ConstraintLayout constraintLayout;
        os.f fVar;
        ConstraintLayout constraintLayout2;
        Context context;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String str = this.this$0.f51752s;
        if (Intrinsics.b(str, "DownloadInterceptRewarded")) {
            zp.b.a aVar = zp.b.f82110a;
            os.e eVar2 = this.this$0.f51739f;
            aVar.e((eVar2 == null || (fVar = eVar2.f73395k) == null || (constraintLayout2 = fVar.f73404c) == null || (context = constraintLayout2.getContext()) == null) ? null : context.getString(R$string.common_failed));
            if (this.this$0.f1()) {
                this.this$0.f51748o++;
                if (this.this$0.f51748o >= this.this$0.b1() && (eVar = this.this$0.f51739f) != null && (constraintLayout = eVar.f73387b) != null && !so.c.i(constraintLayout)) {
                    this.this$0.Y0();
                }
            } else {
                this.this$0.X0();
                this.this$0.l1();
            }
        } else if (Intrinsics.b(str, "DownloadInterceptInterstitial")) {
            this.this$1.p();
        }
        return Unit.f68710a;
    }
}
