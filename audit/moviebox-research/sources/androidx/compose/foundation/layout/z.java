package androidx.compose.foundation.layout;

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
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f2530c;

    public z() {
        this(0.0f, false, null, null, 15, null);
    }

    public z(float f11, boolean z11, m mVar, p pVar) {
        this.f2528a = f11;
        this.f2529b = z11;
        this.f2530c = mVar;
    }

    public /* synthetic */ z(float f11, boolean z11, m mVar, p pVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0.0f : f11, (i11 & 2) != 0 ? true : z11, (i11 & 4) != 0 ? null : mVar, (i11 & 8) != 0 ? null : pVar);
    }

    public final m a() {
        return this.f2530c;
    }

    public final boolean b() {
        return this.f2529b;
    }

    public final p c() {
        return null;
    }

    public final float d() {
        return this.f2528a;
    }

    public final void e(m mVar) {
        this.f2530c = mVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return Float.compare(this.f2528a, zVar.f2528a) == 0 && this.f2529b == zVar.f2529b && Intrinsics.b(this.f2530c, zVar.f2530c) && Intrinsics.b(null, null);
    }

    public final void f(boolean z11) {
        this.f2529b = z11;
    }

    public final void g(float f11) {
        this.f2528a = f11;
    }

    public int hashCode() {
        int iFloatToIntBits = ((Float.floatToIntBits(this.f2528a) * 31) + androidx.compose.foundation.e.a(this.f2529b)) * 31;
        m mVar = this.f2530c;
        return (iFloatToIntBits + (mVar == null ? 0 : mVar.hashCode())) * 31;
    }

    public String toString() {
        return "RowColumnParentData(weight=" + this.f2528a + ", fill=" + this.f2529b + ", crossAxisAlignment=" + this.f2530c + ", flowLayoutData=" + ((Object) null) + ')';
    }
}
