package com.tn.tranpay.helper;

import com.transsion.gslb.Worker;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "com.tn.tranpay.helper.PayUtils", f = "PayUtils.kt", l = {97, Worker.WHAT_QUIT}, m = "retryWithFixedIntervalAndTimeLimit")
public final class PayUtils$retryWithFixedIntervalAndTimeLimit$1<T> extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PayUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayUtils$retryWithFixedIntervalAndTimeLimit$1(PayUtils payUtils, Continuation<? super PayUtils$retryWithFixedIntervalAndTimeLimit$1> continuation) {
        super(continuation);
        this.this$0 = payUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(0L, 0L, null, this);
    }
}
