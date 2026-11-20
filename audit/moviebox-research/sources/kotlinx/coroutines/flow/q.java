package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.q1;

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
public final /* synthetic */ class q {
    public static final <T> a<T> a(a<? extends T> aVar, int i11, BufferOverflow bufferOverflow) {
        int i12;
        BufferOverflow bufferOverflow2;
        if (i11 < 0 && i11 != -2 && i11 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i11).toString());
        }
        if (i11 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i11 == -1) {
            bufferOverflow2 = BufferOverflow.DROP_OLDEST;
            i12 = 0;
        } else {
            i12 = i11;
            bufferOverflow2 = bufferOverflow;
        }
        return aVar instanceof kotlinx.coroutines.flow.internal.j ? kotlinx.coroutines.flow.internal.j.a.a((kotlinx.coroutines.flow.internal.j) aVar, null, i12, bufferOverflow2, 1, null) : new kotlinx.coroutines.flow.internal.e(aVar, null, i12, bufferOverflow2, 2, null);
    }

    public static /* synthetic */ a b(a aVar, int i11, BufferOverflow bufferOverflow, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = -2;
        }
        if ((i12 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return c.c(aVar, i11, bufferOverflow);
    }

    public static final void c(CoroutineContext coroutineContext) {
        if (coroutineContext.get(q1.f69514j8) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> a<T> d(a<? extends T> aVar, CoroutineContext coroutineContext) {
        c(coroutineContext);
        if (Intrinsics.b(coroutineContext, EmptyCoroutineContext.INSTANCE)) {
            return aVar;
        }
        return aVar instanceof kotlinx.coroutines.flow.internal.j ? kotlinx.coroutines.flow.internal.j.a.a((kotlinx.coroutines.flow.internal.j) aVar, coroutineContext, 0, null, 6, null) : new kotlinx.coroutines.flow.internal.e(aVar, coroutineContext, 0, null, 12, null);
    }
}
