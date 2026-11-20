package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import q2.a0;
import q2.z;

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
@SourceDebugExtension
public final class DraggableKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function3<k0, y1.g, Continuation<? super Unit>, Object> f2314a = new DraggableKt$NoOpOnDragStarted$1(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function3<k0, Float, Continuation<? super Unit>, Object> f2315b = new DraggableKt$NoOpOnDragStopped$1(null);

    public static final long b(long j11) {
        return a0.a(Float.isNaN(z.h(j11)) ? 0.0f : z.h(j11), Float.isNaN(z.i(j11)) ? 0.0f : z.i(j11));
    }
}
