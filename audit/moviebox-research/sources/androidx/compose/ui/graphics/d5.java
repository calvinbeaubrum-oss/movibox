package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class d5 extends l1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4101c;

    public d5(long j11) {
        super(null);
        this.f4101c = j11;
    }

    public /* synthetic */ d5(long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11);
    }

    @Override // androidx.compose.ui.graphics.l1
    public void a(long j11, o4 o4Var, float f11) {
        long jK;
        o4Var.setAlpha(1.0f);
        if (f11 == 1.0f) {
            jK = this.f4101c;
        } else {
            long j12 = this.f4101c;
            jK = w1.k(j12, w1.n(j12) * f11, 0.0f, 0.0f, 0.0f, 14, null);
        }
        o4Var.t(jK);
        if (o4Var.z() != null) {
            o4Var.y(null);
        }
    }

    public final long b() {
        return this.f4101c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d5) && w1.m(this.f4101c, ((d5) obj).f4101c);
    }

    public int hashCode() {
        return w1.s(this.f4101c);
    }

    public String toString() {
        return "SolidColor(value=" + ((Object) w1.t(this.f4101c)) + ')';
    }
}
