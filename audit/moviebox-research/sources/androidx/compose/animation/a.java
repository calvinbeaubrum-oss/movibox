package androidx.compose.animation;

import kotlin.Metadata;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2009a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f2010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float[] f2011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f2012d;

    /* JADX INFO: renamed from: androidx.compose.animation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0036a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f2013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f2014b;

        public C0036a(float f11, float f12) {
            this.f2013a = f11;
            this.f2014b = f12;
        }

        public final float a() {
            return this.f2013a;
        }

        public final float b() {
            return this.f2014b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0036a)) {
                return false;
            }
            C0036a c0036a = (C0036a) obj;
            return Float.compare(this.f2013a, c0036a.f2013a) == 0 && Float.compare(this.f2014b, c0036a.f2014b) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f2013a) * 31) + Float.floatToIntBits(this.f2014b);
        }

        public String toString() {
            return "FlingResult(distanceCoefficient=" + this.f2013a + ", velocityCoefficient=" + this.f2014b + ')';
        }
    }

    static {
        float[] fArr = new float[101];
        f2010b = fArr;
        float[] fArr2 = new float[101];
        f2011c = fArr2;
        j.b(fArr, fArr2, 100);
        f2012d = 8;
    }

    public final double a(float f11, float f12) {
        return Math.log(((double) (Math.abs(f11) * 0.35f)) / ((double) f12));
    }

    public final C0036a b(float f11) {
        float f12 = 0.0f;
        float f13 = 1.0f;
        float fJ = kotlin.ranges.a.j(f11, 0.0f, 1.0f);
        float f14 = 100;
        int i11 = (int) (f14 * fJ);
        if (i11 < 100) {
            float f15 = i11 / f14;
            int i12 = i11 + 1;
            float f16 = i12 / f14;
            float[] fArr = f2010b;
            float f17 = fArr[i11];
            float f18 = (fArr[i12] - f17) / (f16 - f15);
            float f19 = ((fJ - f15) * f18) + f17;
            f12 = f18;
            f13 = f19;
        }
        return new C0036a(f13, f12);
    }
}
