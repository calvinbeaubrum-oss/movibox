package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.CombinedClickableNodeImpl$clickPointerInput$4", f = "Clickable.kt", l = {787}, m = "invokeSuspend")
public final class CombinedClickableNodeImpl$clickPointerInput$4 extends SuspendLambda implements Function3<androidx.compose.foundation.gestures.i, y1.g, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CombinedClickableNodeImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombinedClickableNodeImpl$clickPointerInput$4(CombinedClickableNodeImpl combinedClickableNodeImpl, Continuation<? super CombinedClickableNodeImpl$clickPointerInput$4> continuation) {
        super(3, continuation);
        this.this$0 = combinedClickableNodeImpl;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(androidx.compose.foundation.gestures.i iVar, y1.g gVar, Continuation<? super Unit> continuation) {
        return m16invoked4ec7I(iVar, gVar.v(), continuation);
    }

    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
    public final Object m16invoked4ec7I(androidx.compose.foundation.gestures.i iVar, long j11, Continuation<? super Unit> continuation) {
        CombinedClickableNodeImpl$clickPointerInput$4 combinedClickableNodeImpl$clickPointerInput$4 = new CombinedClickableNodeImpl$clickPointerInput$4(this.this$0, continuation);
        combinedClickableNodeImpl$clickPointerInput$4.L$0 = iVar;
        combinedClickableNodeImpl$clickPointerInput$4.J$0 = j11;
        return combinedClickableNodeImpl$clickPointerInput$4.invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            androidx.compose.foundation.gestures.i iVar = (androidx.compose.foundation.gestures.i) this.L$0;
            long j11 = this.J$0;
            if (this.this$0.Z1()) {
                CombinedClickableNodeImpl combinedClickableNodeImpl = this.this$0;
                this.label = 1;
                if (combinedClickableNodeImpl.b2(iVar, j11, this) == objE) {
                    return objE;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
