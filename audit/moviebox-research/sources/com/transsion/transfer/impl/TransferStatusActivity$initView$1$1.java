package com.transsion.transfer.impl;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.transfer.impl.client.TransferClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
public final class TransferStatusActivity$initView$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ TransferStatusActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransferStatusActivity$initView$1$1(TransferStatusActivity transferStatusActivity) {
        super(1);
        this.this$0 = transferStatusActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TransferStatusActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.A0();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.f68710a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(boolean z11) {
        py.b.f74066a.l(TransferClient.f58969t.h());
        if (this.this$0.q0().m().isEmpty()) {
            this.this$0.f58953f = true;
            return;
        }
        ConstraintLayout root = ((ky.b) this.this$0.getMViewBinding()).getRoot();
        final TransferStatusActivity transferStatusActivity = this.this$0;
        root.post(new Runnable() { // from class: com.transsion.transfer.impl.l
            @Override // java.lang.Runnable
            public final void run() {
                TransferStatusActivity$initView$1$1.b(transferStatusActivity);
            }
        });
    }
}
