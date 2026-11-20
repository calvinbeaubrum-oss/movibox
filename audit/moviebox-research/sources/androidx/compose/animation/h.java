package androidx.compose.animation;

import androidx.compose.runtime.b2;
import androidx.compose.runtime.c1;
import androidx.compose.runtime.i1;
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
public final class h implements f, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1 f2163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i1 f2164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f2165c;

    public h a() {
        return this.f2165c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final g b() {
        return (g) this.f2164b.getValue();
    }

    @Override // androidx.compose.animation.f
    public float getZIndex() {
        return this.f2163a.getFloatValue();
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        b().a();
        throw null;
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
        b().a();
        throw null;
    }
}
