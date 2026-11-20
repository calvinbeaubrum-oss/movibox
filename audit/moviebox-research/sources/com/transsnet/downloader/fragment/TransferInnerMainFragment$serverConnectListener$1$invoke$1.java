package com.transsnet.downloader.fragment;

import com.transsnet.downloader.widget.TransferBottomToolsView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "com.transsnet.downloader.fragment.TransferInnerMainFragment$serverConnectListener$1$invoke$1", f = "TransferInnerMainFragment.kt", l = {}, m = "invokeSuspend")
public final class TransferInnerMainFragment$serverConnectListener$1$invoke$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isConnect;
    int label;
    final /* synthetic */ TransferInnerMainFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransferInnerMainFragment$serverConnectListener$1$invoke$1(TransferInnerMainFragment transferInnerMainFragment, boolean z11, Continuation<? super TransferInnerMainFragment$serverConnectListener$1$invoke$1> continuation) {
        super(2, continuation);
        this.this$0 = transferInnerMainFragment;
        this.$isConnect = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransferInnerMainFragment$serverConnectListener$1$invoke$1(this.this$0, this.$isConnect, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((TransferInnerMainFragment$serverConnectListener$1$invoke$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        uo.b.a.s(uo.b.f78622a, TransferBottomToolsView.TAG, this.this$0.f60853n + " TransferConnect listener, isConnect:" + this.$isConnect, false, 4, null);
        this.this$0.f60858s = this.$isConnect;
        if (this.$isConnect) {
            this.this$0.Q0();
        } else {
            this.this$0.S0();
        }
        return Unit.f68710a;
    }
}
