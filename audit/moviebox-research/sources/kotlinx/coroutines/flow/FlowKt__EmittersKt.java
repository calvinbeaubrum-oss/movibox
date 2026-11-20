package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final /* synthetic */ class FlowKt__EmittersKt {
    public static final void b(b<?> bVar) throws Throwable {
        if (bVar instanceof i1) {
            throw ((i1) bVar).f69390a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object c(b<? super T> bVar, Function3<? super b<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3, Throwable th2, Continuation<? super Unit> continuation) throws Throwable {
        FlowKt__EmittersKt$invokeSafely$1 flowKt__EmittersKt$invokeSafely$1;
        if (continuation instanceof FlowKt__EmittersKt$invokeSafely$1) {
            flowKt__EmittersKt$invokeSafely$1 = (FlowKt__EmittersKt$invokeSafely$1) continuation;
            int i11 = flowKt__EmittersKt$invokeSafely$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                flowKt__EmittersKt$invokeSafely$1.label = i11 - Integer.MIN_VALUE;
            } else {
                flowKt__EmittersKt$invokeSafely$1 = new FlowKt__EmittersKt$invokeSafely$1(continuation);
            }
        } else {
            flowKt__EmittersKt$invokeSafely$1 = new FlowKt__EmittersKt$invokeSafely$1(continuation);
        }
        Object obj = flowKt__EmittersKt$invokeSafely$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = flowKt__EmittersKt$invokeSafely$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(obj);
                flowKt__EmittersKt$invokeSafely$1.L$0 = th2;
                flowKt__EmittersKt$invokeSafely$1.label = 1;
                if (function3.invoke(bVar, th2, flowKt__EmittersKt$invokeSafely$1) == objE) {
                    return objE;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th2 = (Throwable) flowKt__EmittersKt$invokeSafely$1.L$0;
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        } catch (Throwable th3) {
            if (th2 != null && th2 != th3) {
                v10.b.a(th3, th2);
            }
            throw th3;
        }
    }

    public static final <T> a<T> d(a<? extends T> aVar, Function3<? super b<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(aVar, function3);
    }
}
