package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.s2;

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
public final class n<E> implements s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final CancellableContinuationImpl<e<? extends E>> f69261a;

    /* JADX WARN: Multi-variable type inference failed */
    public n(CancellableContinuationImpl<? super e<? extends E>> cancellableContinuationImpl) {
        this.f69261a = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.s2
    public void invokeOnCancellation(z<?> zVar, int i11) {
        this.f69261a.invokeOnCancellation(zVar, i11);
    }
}
