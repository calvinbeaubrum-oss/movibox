package com.transsion.transfer.wifi.create.adapter;

import com.transsion.transfer.wifi.util.WifiUtils;
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
@DebugMetadata(c = "com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$retryCreate$1", f = "P2PWifiAdapter.kt", l = {273, 275, 277}, m = "invokeSuspend")
public final class P2PWifiAdapter$retryCreate$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ P2PWifiAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P2PWifiAdapter$retryCreate$1(P2PWifiAdapter p2PWifiAdapter, Continuation<? super P2PWifiAdapter$retryCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = p2PWifiAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new P2PWifiAdapter$retryCreate$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((P2PWifiAdapter$retryCreate$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1 || i11 == 2) {
                ResultKt.b(obj);
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        this.this$0.x();
        if (WifiUtils.f59242a.r()) {
            this.label = 1;
            if (r0.a(1000L, this) == objE) {
                return objE;
            }
        } else {
            this.label = 2;
            if (r0.a(200L, this) == objE) {
                return objE;
            }
        }
        P2PWifiAdapter p2PWifiAdapter = this.this$0;
        this.label = 3;
        if (p2PWifiAdapter.a(this) == objE) {
            return objE;
        }
        return Unit.f68710a;
    }
}
