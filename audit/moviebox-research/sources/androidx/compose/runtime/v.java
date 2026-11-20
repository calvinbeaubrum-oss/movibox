package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.PublishedApi;

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
@PublishedApi
public final class v implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.coroutines.k0 f3733a;

    public v(kotlinx.coroutines.k0 k0Var) {
        this.f3733a = k0Var;
    }

    public final kotlinx.coroutines.k0 a() {
        return this.f3733a;
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
        kotlinx.coroutines.l0.c(this.f3733a, new LeftCompositionCancellationException());
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        kotlinx.coroutines.l0.c(this.f3733a, new LeftCompositionCancellationException());
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
    }
}
