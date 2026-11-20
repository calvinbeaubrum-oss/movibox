package androidx.graphics.path;

import android.graphics.Path;
import dalvik.annotation.optimization.FastNative;
import kotlin.Metadata;
import p3.a;

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
public final class PathIteratorPreApi34Impl extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8654b;

    private final native long createInternalPathIterator(Path path, int i11, float f11);

    private final native void destroyInternalPathIterator(long j11);

    @FastNative
    private final native boolean internalPathIteratorHasNext(long j11);

    @FastNative
    private final native int internalPathIteratorNext(long j11, float[] fArr, int i11);

    @FastNative
    private final native int internalPathIteratorPeek(long j11);

    @FastNative
    private final native int internalPathIteratorRawSize(long j11);

    @FastNative
    private final native int internalPathIteratorSize(long j11);

    public final void finalize() {
        destroyInternalPathIterator(this.f8654b);
    }
}
