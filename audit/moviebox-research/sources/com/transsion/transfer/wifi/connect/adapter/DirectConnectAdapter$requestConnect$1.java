package com.transsion.transfer.wifi.connect.adapter;

import com.transsion.transfer.wifi.util.g;
import com.transsion.transfer.wifi.util.i;
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
@DebugMetadata(c = "com.transsion.transfer.wifi.connect.adapter.DirectConnectAdapter$requestConnect$1", f = "DirectConnectAdapter.kt", l = {185}, m = "invokeSuspend")
public final class DirectConnectAdapter$requestConnect$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DirectConnectAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectConnectAdapter$requestConnect$1(DirectConnectAdapter directConnectAdapter, Continuation<? super DirectConnectAdapter$requestConnect$1> continuation) {
        super(2, continuation);
        this.this$0 = directConnectAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DirectConnectAdapter$requestConnect$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DirectConnectAdapter$requestConnect$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            i.f59253a.d(this.this$0.y(), this.this$0.f59150g, (60 & 4) != 0, (60 & 8) != 0, (60 & 16) != 0, (60 & 32) != 0);
            this.label = 1;
            if (r0.a(1000L, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        g.b(g.f59252a, this.this$0.e() + " --> requestConnect() --> connectRetry = " + this.this$0.f59154k + " --> retryCount = " + this.this$0.f59155l + " --> delay 500", false, 2, null);
        this.this$0.x();
        return Unit.f68710a;
    }
}
