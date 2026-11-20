package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.z;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2", f = "TapGestureDetector.kt", l = {212}, m = "invokeSuspend")
public final class TapGestureDetectorKt$awaitSecondDown$2 extends RestrictedSuspendLambda implements Function2<androidx.compose.ui.input.pointer.e, Continuation<? super z>, Object> {
    final /* synthetic */ z $firstUp;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapGestureDetectorKt$awaitSecondDown$2(z zVar, Continuation<? super TapGestureDetectorKt$awaitSecondDown$2> continuation) {
        super(2, continuation);
        this.$firstUp = zVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TapGestureDetectorKt$awaitSecondDown$2 tapGestureDetectorKt$awaitSecondDown$2 = new TapGestureDetectorKt$awaitSecondDown$2(this.$firstUp, continuation);
        tapGestureDetectorKt$awaitSecondDown$2.L$0 = obj;
        return tapGestureDetectorKt$awaitSecondDown$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(androidx.compose.ui.input.pointer.e eVar, Continuation<? super z> continuation) {
        return ((TapGestureDetectorKt$awaitSecondDown$2) create(eVar, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x004c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x004d  */
    /* JADX WARN: Code duplicated, block: B:15:0x005c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:16:0x005d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x004d -> B:13:0x0052). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r1 = r12.label
            r2 = 1
            if (r1 == 0) goto L21
            if (r1 != r2) goto L19
            long r3 = r12.J$0
            java.lang.Object r1 = r12.L$0
            androidx.compose.ui.input.pointer.e r1 = (androidx.compose.ui.input.pointer.e) r1
            kotlin.ResultKt.b(r13)
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r12
            goto L52
        L19:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L21:
            kotlin.ResultKt.b(r13)
            java.lang.Object r13 = r12.L$0
            androidx.compose.ui.input.pointer.e r13 = (androidx.compose.ui.input.pointer.e) r13
            androidx.compose.ui.input.pointer.z r1 = r12.$firstUp
            long r3 = r1.o()
            androidx.compose.ui.platform.r2 r1 = r13.getViewConfiguration()
            long r5 = r1.b()
            long r3 = r3 + r5
            r1 = r13
            r9 = r3
            r13 = r12
        L3a:
            r4 = 0
            r5 = 0
            r7 = 3
            r8 = 0
            r13.L$0 = r1
            r13.J$0 = r9
            r13.label = r2
            r3 = r1
            r6 = r13
            java.lang.Object r3 = androidx.compose.foundation.gestures.TapGestureDetectorKt.e(r3, r4, r5, r6, r7, r8)
            if (r3 != r0) goto L4d
            return r0
        L4d:
            r11 = r0
            r0 = r13
            r13 = r3
            r3 = r1
            r1 = r11
        L52:
            androidx.compose.ui.input.pointer.z r13 = (androidx.compose.ui.input.pointer.z) r13
            long r4 = r13.o()
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 < 0) goto L5d
            return r13
        L5d:
            r13 = r0
            r0 = r1
            r1 = r3
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
