package com.transsion.baseui.util;

import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.baseui.util.TimeUtilKt$countdownByFlow$1", f = "TimeUtil.kt", l = {315, 316}, m = "invokeSuspend")
public final class TimeUtilKt$countdownByFlow$1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b<? super Integer>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $max;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeUtilKt$countdownByFlow$1(int i11, Continuation<? super TimeUtilKt$countdownByFlow$1> continuation) {
        super(2, continuation);
        this.$max = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TimeUtilKt$countdownByFlow$1 timeUtilKt$countdownByFlow$1 = new TimeUtilKt$countdownByFlow$1(this.$max, continuation);
        timeUtilKt$countdownByFlow$1.L$0 = obj;
        return timeUtilKt$countdownByFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.flow.b<? super Integer> bVar, Continuation<? super Unit> continuation) {
        return ((TimeUtilKt$countdownByFlow$1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003b  */
    /* JADX WARN: Code duplicated, block: B:15:0x004c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x004e  */
    /* JADX WARN: Code duplicated, block: B:18:0x005c A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005a -> B:19:0x005d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r1 = r8.label
            r2 = -1
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2f
            if (r1 == r4) goto L23
            if (r1 != r3) goto L1b
            int r1 = r8.I$0
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.flow.b r5 = (kotlinx.coroutines.flow.b) r5
            kotlin.ResultKt.b(r9)
            r9 = r5
            r5 = r8
            goto L5d
        L1b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L23:
            int r1 = r8.I$0
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.flow.b r5 = (kotlinx.coroutines.flow.b) r5
            kotlin.ResultKt.b(r9)
            r9 = r5
            r5 = r8
            goto L4c
        L2f:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.flow.b r9 = (kotlinx.coroutines.flow.b) r9
            int r1 = r8.$max
            r5 = r8
        L39:
            if (r2 >= r1) goto L5f
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.d(r1)
            r5.L$0 = r9
            r5.I$0 = r1
            r5.label = r4
            java.lang.Object r6 = r9.emit(r6, r5)
            if (r6 != r0) goto L4c
            return r0
        L4c:
            if (r1 == 0) goto L5d
            r5.L$0 = r9
            r5.I$0 = r1
            r5.label = r3
            r6 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r6 = kotlinx.coroutines.r0.a(r6, r5)
            if (r6 != r0) goto L5d
            return r0
        L5d:
            int r1 = r1 + r2
            goto L39
        L5f:
            kotlin.Unit r9 = kotlin.Unit.f68710a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.baseui.util.TimeUtilKt$countdownByFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
