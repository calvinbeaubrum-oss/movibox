package r2;

import java.util.Arrays;
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
public final class c implements r2.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f75095c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f75096d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f75097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f75098b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float b(float f11, float[] fArr, float[] fArr2) {
            float f12;
            float f13;
            float f14;
            float fA;
            float fAbs = Math.abs(f11);
            float fSignum = Math.signum(f11);
            int iBinarySearch = Arrays.binarySearch(fArr, fAbs);
            if (iBinarySearch >= 0) {
                fA = fArr2[iBinarySearch];
            } else {
                int i11 = -(iBinarySearch + 1);
                int i12 = i11 - 1;
                float f15 = 0.0f;
                if (i12 >= fArr.length - 1) {
                    float f16 = fArr[fArr.length - 1];
                    float f17 = fArr2[fArr.length - 1];
                    if (f16 == 0.0f) {
                        return 0.0f;
                    }
                    return f11 * (f17 / f16);
                }
                if (i12 == -1) {
                    float f18 = fArr[0];
                    f14 = fArr2[0];
                    f13 = f18;
                    f12 = 0.0f;
                } else {
                    float f19 = fArr[i12];
                    float f21 = fArr[i11];
                    f12 = fArr2[i12];
                    f15 = f19;
                    f13 = f21;
                    f14 = fArr2[i11];
                }
                fA = d.f75099a.a(f12, f14, f15, f13, fAbs);
            }
            return fSignum * fA;
        }
    }

    public c(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length || fArr.length == 0) {
            throw new IllegalArgumentException("Array lengths must match and be nonzero".toString());
        }
        this.f75097a = fArr;
        this.f75098b = fArr2;
    }

    @Override // r2.a
    public float a(float f11) {
        return f75095c.b(f11, this.f75098b, this.f75097a);
    }

    @Override // r2.a
    public float b(float f11) {
        return f75095c.b(f11, this.f75097a, this.f75098b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Arrays.equals(this.f75097a, cVar.f75097a) && Arrays.equals(this.f75098b, cVar.f75098b);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f75097a) * 31) + Arrays.hashCode(this.f75098b);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontScaleConverter{fromSpValues=");
        String string = Arrays.toString(this.f75097a);
        Intrinsics.f(string, "toString(this)");
        sb2.append(string);
        sb2.append(", toDpValues=");
        String string2 = Arrays.toString(this.f75098b);
        Intrinsics.f(string2, "toString(this)");
        sb2.append(string2);
        sb2.append('}');
        return sb2.toString();
    }
}
