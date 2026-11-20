package androidx.compose.ui.text.style;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6126c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f6127d = new m(1.0f, 0.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f6128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f6129b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final m a() {
            return m.f6127d;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public m() {
        float f11 = 0.0f;
        this(f11, f11, 3, null);
    }

    public m(float f11, float f12) {
        this.f6128a = f11;
        this.f6129b = f12;
    }

    public /* synthetic */ m(float f11, float f12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 1.0f : f11, (i11 & 2) != 0 ? 0.0f : f12);
    }

    public final float b() {
        return this.f6128a;
    }

    public final float c() {
        return this.f6129b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f6128a == mVar.f6128a && this.f6129b == mVar.f6129b;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f6128a) * 31) + Float.floatToIntBits(this.f6129b);
    }

    public String toString() {
        return "TextGeometricTransform(scaleX=" + this.f6128a + ", skewX=" + this.f6129b + ')';
    }
}
