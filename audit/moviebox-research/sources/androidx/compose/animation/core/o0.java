package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class o0<T> implements c0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f2121c;

    public o0() {
        this(0.0f, 0.0f, null, 7, null);
    }

    public o0(float f11, float f12, T t11) {
        this.f2119a = f11;
        this.f2120b = f12;
        this.f2121c = t11;
    }

    public /* synthetic */ o0(float f11, float f12, Object obj, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 1.0f : f11, (i11 & 2) != 0 ? 1500.0f : f12, (i11 & 4) != 0 ? null : obj);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return o0Var.f2119a == this.f2119a && o0Var.f2120b == this.f2120b && Intrinsics.b(o0Var.f2121c, this.f2121c);
    }

    @Override // androidx.compose.animation.core.g
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public <V extends o> e1<V> a(s0<T, V> s0Var) {
        return new e1<>(this.f2119a, this.f2120b, h.b(s0Var, this.f2121c));
    }

    public int hashCode() {
        T t11 = this.f2121c;
        return ((((t11 != null ? t11.hashCode() : 0) * 31) + Float.floatToIntBits(this.f2119a)) * 31) + Float.floatToIntBits(this.f2120b);
    }
}
