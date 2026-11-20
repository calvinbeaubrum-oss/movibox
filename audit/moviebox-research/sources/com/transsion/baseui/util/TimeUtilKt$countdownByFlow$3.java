package com.transsion.baseui.util;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

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
@DebugMetadata(c = "com.transsion.baseui.util.TimeUtilKt$countdownByFlow$3", f = "TimeUtil.kt", l = {}, m = "invokeSuspend")
public final class TimeUtilKt$countdownByFlow$3 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b<? super Integer>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onFinish;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeUtilKt$countdownByFlow$3(Function0<Unit> function0, Continuation<? super TimeUtilKt$countdownByFlow$3> continuation) {
        super(3, continuation);
        this.$onFinish = function0;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(kotlinx.coroutines.flow.b<? super Integer> bVar, Throwable th2, Continuation<? super Unit> continuation) {
        TimeUtilKt$countdownByFlow$3 timeUtilKt$countdownByFlow$3 = new TimeUtilKt$countdownByFlow$3(this.$onFinish, continuation);
        timeUtilKt$countdownByFlow$3.L$0 = th2;
        return timeUtilKt$countdownByFlow$3.invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Function0<Unit> function0;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (((Throwable) this.L$0) == null && (function0 = this.$onFinish) != null) {
            function0.invoke();
        }
        return Unit.f68710a;
    }
}
