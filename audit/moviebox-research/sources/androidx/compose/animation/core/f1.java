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
public final class f1<V extends o> implements z0<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f2078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c1<V> f2079d;

    public f1(int i11, int i12, z zVar) {
        this.f2076a = i11;
        this.f2077b = i12;
        this.f2078c = zVar;
        this.f2079d = new c1<>(new h0(d(), b(), zVar));
    }

    @Override // androidx.compose.animation.core.v0
    public /* synthetic */ boolean a() {
        return a1.a(this);
    }

    @Override // androidx.compose.animation.core.z0
    public int b() {
        return this.f2077b;
    }

    @Override // androidx.compose.animation.core.v0
    public /* synthetic */ o c(o oVar, o oVar2, o oVar3) {
        return u0.a(this, oVar, oVar2, oVar3);
    }

    @Override // androidx.compose.animation.core.z0
    public int d() {
        return this.f2076a;
    }

    @Override // androidx.compose.animation.core.v0
    public V e(long j11, V v11, V v12, V v13) {
        return (V) this.f2079d.e(j11, v11, v12, v13);
    }

    @Override // androidx.compose.animation.core.v0
    public /* synthetic */ long f(o oVar, o oVar2, o oVar3) {
        return y0.a(this, oVar, oVar2, oVar3);
    }

    @Override // androidx.compose.animation.core.v0
    public V g(long j11, V v11, V v12, V v13) {
        return (V) this.f2079d.g(j11, v11, v12, v13);
    }
}
