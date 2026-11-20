package androidx.compose.animation;

import kotlin.Metadata;
import l.p;

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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q2.e f2157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f2158c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f2159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f2160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f2161c;

        public a(float f11, float f12, long j11) {
            this.f2159a = f11;
            this.f2160b = f12;
            this.f2161c = j11;
        }

        public final float a(long j11) {
            long j12 = this.f2161c;
            return this.f2160b * Math.signum(this.f2159a) * androidx.compose.animation.a.f2009a.b(j12 > 0 ? j11 / j12 : 1.0f).a();
        }

        public final float b(long j11) {
            long j12 = this.f2161c;
            return (((androidx.compose.animation.a.f2009a.b(j12 > 0 ? j11 / j12 : 1.0f).b() * Math.signum(this.f2159a)) * this.f2160b) / this.f2161c) * 1000.0f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Float.compare(this.f2159a, aVar.f2159a) == 0 && Float.compare(this.f2160b, aVar.f2160b) == 0 && this.f2161c == aVar.f2161c;
        }

        public int hashCode() {
            return (((Float.floatToIntBits(this.f2159a) * 31) + Float.floatToIntBits(this.f2160b)) * 31) + p.a(this.f2161c);
        }

        public String toString() {
            return "FlingInfo(initialVelocity=" + this.f2159a + ", distance=" + this.f2160b + ", duration=" + this.f2161c + ')';
        }
    }

    public d(float f11, q2.e eVar) {
        this.f2156a = f11;
        this.f2157b = eVar;
        this.f2158c = a(eVar);
    }

    public final float a(q2.e eVar) {
        return e.c(0.84f, eVar.getDensity());
    }

    public final float b(float f11) {
        return (float) (((double) (this.f2156a * this.f2158c)) * Math.exp((((double) e.f2162a) / (((double) e.f2162a) - 1.0d)) * e(f11)));
    }

    public final long c(float f11) {
        return (long) (Math.exp(e(f11) / (((double) e.f2162a) - 1.0d)) * 1000.0d);
    }

    public final a d(float f11) {
        double dE = e(f11);
        double d11 = ((double) e.f2162a) - 1.0d;
        return new a(f11, (float) (((double) (this.f2156a * this.f2158c)) * Math.exp((((double) e.f2162a) / d11) * dE)), (long) (Math.exp(dE / d11) * 1000.0d));
    }

    public final double e(float f11) {
        return androidx.compose.animation.a.f2009a.a(f11, this.f2156a * this.f2158c);
    }
}
