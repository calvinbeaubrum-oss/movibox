package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
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
public final class f1 extends x1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4134d;

    public f1(long j11, int i11) {
        this(j11, i11, i0.a(j11, i11), null);
    }

    public f1(long j11, int i11, ColorFilter colorFilter) {
        super(colorFilter);
        this.f4133c = j11;
        this.f4134d = i11;
    }

    public /* synthetic */ f1(long j11, int i11, ColorFilter colorFilter, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, i11, colorFilter);
    }

    public /* synthetic */ f1(long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, i11);
    }

    public final int b() {
        return this.f4134d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f1)) {
            return false;
        }
        f1 f1Var = (f1) obj;
        return w1.m(this.f4133c, f1Var.f4133c) && e1.E(this.f4134d, f1Var.f4134d);
    }

    public int hashCode() {
        return (w1.s(this.f4133c) * 31) + e1.F(this.f4134d);
    }

    public String toString() {
        return "BlendModeColorFilter(color=" + ((Object) w1.t(this.f4133c)) + ", blendMode=" + ((Object) e1.G(this.f4134d)) + ')';
    }
}
