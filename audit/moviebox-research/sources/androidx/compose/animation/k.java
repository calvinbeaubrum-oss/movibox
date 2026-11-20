package androidx.compose.animation;

import androidx.compose.animation.core.f0;
import kotlin.Metadata;

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
public final class k implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f2166a;

    public k(q2.e eVar) {
        this.f2166a = new d(l.a(), eVar);
    }

    @Override // androidx.compose.animation.core.f0
    public float a() {
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.f0
    public float b(long j11, float f11, float f12) {
        return this.f2166a.d(f12).b(j11 / 1000000);
    }

    @Override // androidx.compose.animation.core.f0
    public long c(float f11, float f12) {
        return this.f2166a.c(f12) * 1000000;
    }

    @Override // androidx.compose.animation.core.f0
    public float d(float f11, float f12) {
        return f11 + f(f12);
    }

    @Override // androidx.compose.animation.core.f0
    public float e(long j11, float f11, float f12) {
        return f11 + this.f2166a.d(f12).a(j11 / 1000000);
    }

    public final float f(float f11) {
        return this.f2166a.b(f11) * Math.signum(f11);
    }
}
