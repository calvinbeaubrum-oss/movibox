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
@DebugMetadata(c = "com.transsnet.downloader.fragment.TransferInnerMainFragment$onClientDisconnect$1", f = "TransferInnerMainFragment.kt", l = {}, m = "invokeSuspend")
public final class TransferInnerMainFragment$onClientDisconnect$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TransferInnerMainFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransferInnerMainFragment$onClientDisconnect$1(TransferInnerMainFragment transferInnerMainFragment, Continuation<? super TransferInnerMainFragment$onClientDisconnect$1> continuation) {
        super(2, continuation);
        this.this$0 = transferInnerMainFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransferInnerMainFragment$onClientDisconnect$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((TransferInnerMainFragment$onClientDisconnect$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        TransferBottomToolsView transferBottomToolsView;
        TransferBottomToolsView transferBottomToolsView2;
        TransferBottomToolsView transferBottomToolsView3;
        TransferBottomToolsView transferBottomToolsView4;
        TransferBottomToolsView transferBottomToolsView5;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        com.transsion.transfer.impl.a aVar = this.this$0.f60860u;
        String strJ = aVar != null ? aVar.j() : null;
        if (strJ == null || strJ.length() == 0) {
            strJ = this.this$0.f60861v;
        }
        uo.b.a.s(uo.b.f78622a, TransferBottomToolsView.TAG, this.this$0.f60853n + " TransferMainFragment 客户端 ,onSocketLost, 断开连接， serverInfo:" + strJ, false, 4, null);
        h00.m0 m0Var = (h00.m0) this.this$0.getMViewBinding();
        if (m0Var != null && (transferBottomToolsView5 = m0Var.f65953d) != null) {
            transferBottomToolsView5.changeStatus(TransferBottomToolsView.STATUS_DEFAULT);
        }
        h00.m0 m0Var2 = (h00.m0) this.this$0.getMViewBinding();
        if (m0Var2 != null && (transferBottomToolsView4 = m0Var2.f65953d) != null) {
            transferBottomToolsView4.setLeftIconStatus(TransferBottomToolsView.LEFT_STATUS_CLOSE);
        }
        h00.m0 m0Var3 = (h00.m0) this.this$0.getMViewBinding();
        if (m0Var3 != null && (transferBottomToolsView3 = m0Var3.f65953d) != null) {
            TransferBottomToolsView.setSendIconStatus$default(transferBottomToolsView3, TransferBottomToolsView.SEND_STATUS_NONE, 0, 2, null);
        }
        h00.m0 m0Var4 = (h00.m0) this.this$0.getMViewBinding();
        if (m0Var4 != null && (transferBottomToolsView2 = m0Var4.f65953d) != null) {
            transferBottomToolsView2.showConnectUI(true);
        }
        h00.m0 m0Var5 = (h00.m0) this.this$0.getMViewBinding();
        if (m0Var5 != null && (transferBottomToolsView = m0Var5.f65953d) != null) {
            transferBottomToolsView.showConnectContent(false, strJ);
        }
        return Unit.f68710a;
    }
}
