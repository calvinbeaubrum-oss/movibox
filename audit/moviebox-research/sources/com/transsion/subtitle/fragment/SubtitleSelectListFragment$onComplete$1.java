package com.transsion.subtitle.fragment;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;

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
@DebugMetadata(c = "com.transsion.subtitle.fragment.SubtitleSelectListFragment$onComplete$1", f = "SubtitleSelectListFragment.kt", l = {234}, m = "invokeSuspend")
public final class SubtitleSelectListFragment$onComplete$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SubtitleSelectListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleSelectListFragment$onComplete$1(SubtitleSelectListFragment subtitleSelectListFragment, Continuation<? super SubtitleSelectListFragment$onComplete$1> continuation) {
        super(2, continuation);
        this.this$0 = subtitleSelectListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SubtitleSelectListFragment$onComplete$1 subtitleSelectListFragment$onComplete$1 = new SubtitleSelectListFragment$onComplete$1(this.this$0, continuation);
        subtitleSelectListFragment$onComplete$1.L$0 = obj;
        return subtitleSelectListFragment$onComplete$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubtitleSelectListFragment$onComplete$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        k0 k0Var;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            k0 k0Var2 = (k0) this.L$0;
            this.L$0 = k0Var2;
            this.label = 1;
            if (r0.a(500L, this) == objE) {
                return objE;
            }
            k0Var = k0Var2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k0Var = (k0) this.L$0;
            ResultKt.b(obj);
        }
        com.transsion.subtitle.a.f58119a.a(k0Var.getClass().getSimpleName() + " --> onComplete() --> 刷新列表 --> 刷新状态");
        this.this$0.onHiddenChanged(false);
        return Unit.f68710a;
    }
}
