package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.y1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public abstract class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f4023d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4026c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(String str, long j11, int i11) {
        this.f4024a = str;
        this.f4025b = j11;
        this.f4026c = i11;
        if (str.length() == 0) {
            throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
        }
        if (i11 < -1 || i11 > 63) {
            throw new IllegalArgumentException("The id must be between -1 and 63");
        }
    }

    public /* synthetic */ c(String str, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j11, i11);
    }

    public final float[] a(float f11, float f12, float f13) {
        float[] fArr = new float[b.f(this.f4025b)];
        fArr[0] = f11;
        fArr[1] = f12;
        fArr[2] = f13;
        return b(fArr);
    }

    public abstract float[] b(float[] fArr);

    public final int c() {
        return b.f(this.f4025b);
    }

    public final int d() {
        return this.f4026c;
    }

    public abstract float e(int i11);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f4026c == cVar.f4026c && Intrinsics.b(this.f4024a, cVar.f4024a)) {
            return b.e(this.f4025b, cVar.f4025b);
        }
        return false;
    }

    public abstract float f(int i11);

    public final long g() {
        return this.f4025b;
    }

    public final String h() {
        return this.f4024a;
    }

    public int hashCode() {
        return (((this.f4024a.hashCode() * 31) + b.g(this.f4025b)) * 31) + this.f4026c;
    }

    public boolean i() {
        return false;
    }

    public long j(float f11, float f12, float f13) {
        float[] fArrK = k(f11, f12, f13);
        float f14 = fArrK[0];
        float f15 = fArrK[1];
        return (((long) Float.floatToRawIntBits(f14)) << 32) | (((long) Float.floatToRawIntBits(f15)) & 4294967295L);
    }

    public final float[] k(float f11, float f12, float f13) {
        return l(new float[]{f11, f12, f13});
    }

    public abstract float[] l(float[] fArr);

    public float m(float f11, float f12, float f13) {
        return k(f11, f12, f13)[2];
    }

    public long n(float f11, float f12, float f13, float f14, c cVar) {
        float[] fArrA = a(f11, f12, f13);
        return y1.a(fArrA[0], fArrA[1], fArrA[2], f14, cVar);
    }

    public String toString() {
        return this.f4024a + " (id=" + this.f4026c + ", model=" + ((Object) b.h(this.f4025b)) + ')';
    }
}
