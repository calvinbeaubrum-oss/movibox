package androidx.compose.animation;

import java.util.Comparator;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class SharedTransitionScopeImpl$drawInOverlay$$inlined$sortBy$1<T> implements Comparator {
    @Override // java.util.Comparator
    public final int compare(T t11, T t12) {
        f fVar = (f) t11;
        f fVar2 = (f) t12;
        return kotlin.comparisons.b.d(Float.valueOf((fVar.getZIndex() == 0.0f && (fVar instanceof h) && ((h) fVar).a() == null) ? -1.0f : fVar.getZIndex()), Float.valueOf((fVar2.getZIndex() == 0.0f && (fVar2 instanceof h) && ((h) fVar2).a() == null) ? -1.0f : fVar2.getZIndex()));
    }
}
