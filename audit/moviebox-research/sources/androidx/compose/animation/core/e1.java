package androidx.compose.animation.core;

import androidx.compose.animation.core.o;
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
public final class e1<V extends o> implements b1<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c1<V> f2066c;

    public e1(float f11, float f12, V v11) {
        this(f11, f12, w0.b(v11, f11, f12));
    }

    public e1(float f11, float f12, q qVar) {
        this.f2064a = f11;
        this.f2065b = f12;
        this.f2066c = new c1<>(qVar);
    }

    @Override // androidx.compose.animation.core.v0
    public boolean a() {
        return this.f2066c.a();
    }

    @Override // androidx.compose.animation.core.v0
    public V c(V v11, V v12, V v13) {
        return (V) this.f2066c.c(v11, v12, v13);
    }

    @Override // androidx.compose.animation.core.v0
    public V e(long j11, V v11, V v12, V v13) {
        return (V) this.f2066c.e(j11, v11, v12, v13);
    }

    @Override // androidx.compose.animation.core.v0
    public long f(V v11, V v12, V v13) {
        return this.f2066c.f(v11, v12, v13);
    }

    @Override // androidx.compose.animation.core.v0
    public V g(long j11, V v11, V v12, V v13) {
        return (V) this.f2066c.g(j11, v11, v12, v13);
    }
}
