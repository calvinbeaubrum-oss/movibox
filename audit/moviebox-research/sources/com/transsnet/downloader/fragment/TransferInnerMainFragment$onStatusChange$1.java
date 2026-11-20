package com.transsnet.downloader.fragment;

import com.transsnet.downloader.widget.TransferBottomToolsView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "com.transsnet.downloader.fragment.TransferInnerMainFragment$onStatusChange$1", f = "TransferInnerMainFragment.kt", l = {}, m = "invokeSuspend")
public final class TransferInnerMainFragment$onStatusChange$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $failCount;
    final /* synthetic */ int $transmittingCount;
    int label;
    final /* synthetic */ TransferInnerMainFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransferInnerMainFragment$onStatusChange$1(TransferInnerMainFragment transferInnerMainFragment, int i11, int i12, Continuation<? super TransferInnerMainFragment$onStatusChange$1> continuation) {
        super(2, continuation);
        this.this$0 = transferInnerMainFragment;
        this.$transmittingCount = i11;
        this.$failCount = i12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(TransferInnerMainFragment transferInnerMainFragment, int i11, int i12) {
        TransferBottomToolsView transferBottomToolsView;
        TransferBottomToolsView transferBottomToolsView2;
        h00.m0 m0Var = (h00.m0) transferInnerMainFragment.getMViewBinding();
        if (m0Var != null && (transferBottomToolsView2 = m0Var.f65953d) != null) {
            transferBottomToolsView2.changeStatus(TransferBottomToolsView.STATUS_SEND);
        }
        h00.m0 m0Var2 = (h00.m0) transferInnerMainFragment.getMViewBinding();
        if (m0Var2 != null && (transferBottomToolsView = m0Var2.f65953d) != null) {
            transferBottomToolsView.setLeftIconStatus(TransferBottomToolsView.LEFT_STATUS_SEND);
        }
        uo.b.a.s(uo.b.f78622a, TransferBottomToolsView.TAG, transferInnerMainFragment.f60853n + " ====== onStatusChange ,连接成功onTaskStateChange, transmittingCount：" + i11 + ",failCount:" + i12 + " ", false, 4, null);
        transferInnerMainFragment.V0(i11, i12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransferInnerMainFragment$onStatusChange$1(this.this$0, this.$transmittingCount, this.$failCount, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((TransferInnerMainFragment$onStatusChange$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        TransferBottomToolsView transferBottomToolsView;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        h00.m0 m0Var = (h00.m0) this.this$0.getMViewBinding();
        if (m0Var != null && (transferBottomToolsView = m0Var.f65953d) != null) {
            final TransferInnerMainFragment transferInnerMainFragment = this.this$0;
            final int i11 = this.$transmittingCount;
            final int i12 = this.$failCount;
            Boxing.a(transferBottomToolsView.post(new Runnable() { // from class: com.transsnet.downloader.fragment.v1
                @Override // java.lang.Runnable
                public final void run() {
                    TransferInnerMainFragment$onStatusChange$1.d(transferInnerMainFragment, i11, i12);
                }
            }));
        }
        return Unit.f68710a;
    }
}
