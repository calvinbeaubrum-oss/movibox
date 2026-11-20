package z1;

import androidx.compose.ui.graphics.e5;
import androidx.compose.ui.graphics.f5;
import androidx.compose.ui.graphics.r4;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class m extends h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f81717f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f81718g = e5.f4128a.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f81719h = f5.f4136a.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f81720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f81721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f81722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f81723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r4 f81724e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return m.f81718g;
        }
    }

    public m(float f11, float f12, int i11, int i12, r4 r4Var) {
        super(null);
        this.f81720a = f11;
        this.f81721b = f12;
        this.f81722c = i11;
        this.f81723d = i12;
        this.f81724e = r4Var;
    }

    public /* synthetic */ m(float f11, float f12, int i11, int i12, r4 r4Var, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0.0f : f11, (i13 & 2) != 0 ? 4.0f : f12, (i13 & 4) != 0 ? f81718g : i11, (i13 & 8) != 0 ? f81719h : i12, (i13 & 16) != 0 ? null : r4Var, null);
    }

    public /* synthetic */ m(float f11, float f12, int i11, int i12, r4 r4Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, i11, i12, r4Var);
    }

    public final int b() {
        return this.f81722c;
    }

    public final int c() {
        return this.f81723d;
    }

    public final float d() {
        return this.f81721b;
    }

    public final r4 e() {
        return this.f81724e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f81720a == mVar.f81720a && this.f81721b == mVar.f81721b && e5.e(this.f81722c, mVar.f81722c) && f5.e(this.f81723d, mVar.f81723d) && Intrinsics.b(this.f81724e, mVar.f81724e);
    }

    public final float f() {
        return this.f81720a;
    }

    public int hashCode() {
        int iFloatToIntBits = ((((((Float.floatToIntBits(this.f81720a) * 31) + Float.floatToIntBits(this.f81721b)) * 31) + e5.f(this.f81722c)) * 31) + f5.f(this.f81723d)) * 31;
        r4 r4Var = this.f81724e;
        return iFloatToIntBits + (r4Var != null ? r4Var.hashCode() : 0);
    }

    public String toString() {
        return "Stroke(width=" + this.f81720a + ", miter=" + this.f81721b + ", cap=" + ((Object) e5.g(this.f81722c)) + ", join=" + ((Object) f5.g(this.f81723d)) + ", pathEffect=" + this.f81724e + ')';
    }
}
