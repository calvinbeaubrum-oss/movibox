package androidx.compose.runtime;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public final class y2 implements w1.b, Iterable<w1.b>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j2 f3757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l0 f3759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x2 f3760d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f3761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Iterable<w1.b> f3762g = this;

    public y2(j2 j2Var, int i11, l0 l0Var, x2 x2Var) {
        this.f3757a = j2Var;
        this.f3758b = i11;
        this.f3759c = l0Var;
        this.f3760d = x2Var;
        this.f3761f = Integer.valueOf(l0Var.d());
    }

    @Override // java.lang.Iterable
    public Iterator<w1.b> iterator() {
        return new w2(this.f3757a, this.f3758b, this.f3759c, this.f3760d);
    }
}
