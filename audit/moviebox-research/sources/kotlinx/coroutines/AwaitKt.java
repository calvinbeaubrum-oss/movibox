package kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
public final class AwaitKt {
    public static final <T> Object a(Collection<? extends o0<? extends T>> collection, Continuation<? super List<? extends T>> continuation) {
        return collection.isEmpty() ? kotlin.collections.g.l() : new e((o0[]) collection.toArray(new o0[0])).c(continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object b(Collection<? extends q1> collection, Continuation<? super Unit> continuation) throws Throwable {
        AwaitKt$joinAll$3 awaitKt$joinAll$3;
        Iterator it;
        if (continuation instanceof AwaitKt$joinAll$3) {
            awaitKt$joinAll$3 = (AwaitKt$joinAll$3) continuation;
            int i11 = awaitKt$joinAll$3.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                awaitKt$joinAll$3.label = i11 - Integer.MIN_VALUE;
            } else {
                awaitKt$joinAll$3 = new AwaitKt$joinAll$3(continuation);
            }
        } else {
            awaitKt$joinAll$3 = new AwaitKt$joinAll$3(continuation);
        }
        Object obj = awaitKt$joinAll$3.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = awaitKt$joinAll$3.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            it = collection.iterator();
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) awaitKt$joinAll$3.L$0;
            ResultKt.b(obj);
        }
        while (it.hasNext()) {
            q1 q1Var = (q1) it.next();
            awaitKt$joinAll$3.L$0 = it;
            awaitKt$joinAll$3.label = 1;
            if (q1Var.join(awaitKt$joinAll$3) == objE) {
                return objE;
            }
        }
        return Unit.f68710a;
    }
}
