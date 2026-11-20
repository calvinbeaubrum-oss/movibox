package androidx.compose.ui.graphics.vector;

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
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4470b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4472d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f4473e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f4474f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f4475g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f4476h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float f4477i;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(float f11, float f12, float f13, boolean z11, boolean z12, float f14, float f15) {
            boolean z13 = false;
            super(z13, z13, 3, null);
            this.f4471c = f11;
            this.f4472d = f12;
            this.f4473e = f13;
            this.f4474f = z11;
            this.f4475g = z12;
            this.f4476h = f14;
            this.f4477i = f15;
        }

        public final float c() {
            return this.f4476h;
        }

        public final float d() {
            return this.f4477i;
        }

        public final float e() {
            return this.f4471c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Float.compare(this.f4471c, aVar.f4471c) == 0 && Float.compare(this.f4472d, aVar.f4472d) == 0 && Float.compare(this.f4473e, aVar.f4473e) == 0 && this.f4474f == aVar.f4474f && this.f4475g == aVar.f4475g && Float.compare(this.f4476h, aVar.f4476h) == 0 && Float.compare(this.f4477i, aVar.f4477i) == 0;
        }

        public final float f() {
            return this.f4473e;
        }

        public final float g() {
            return this.f4472d;
        }

        public final boolean h() {
            return this.f4474f;
        }

        public int hashCode() {
            return (((((((((((Float.floatToIntBits(this.f4471c) * 31) + Float.floatToIntBits(this.f4472d)) * 31) + Float.floatToIntBits(this.f4473e)) * 31) + androidx.compose.foundation.e.a(this.f4474f)) * 31) + androidx.compose.foundation.e.a(this.f4475g)) * 31) + Float.floatToIntBits(this.f4476h)) * 31) + Float.floatToIntBits(this.f4477i);
        }

        public final boolean i() {
            return this.f4475g;
        }

        public String toString() {
            return "ArcTo(horizontalEllipseRadius=" + this.f4471c + ", verticalEllipseRadius=" + this.f4472d + ", theta=" + this.f4473e + ", isMoreThanHalf=" + this.f4474f + ", isPositiveArc=" + this.f4475g + ", arcStartX=" + this.f4476h + ", arcStartY=" + this.f4477i + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f4478c = new b();

        /* JADX WARN: Illegal instructions before constructor call */
        public b() {
            boolean z11 = false;
            super(z11, z11, 3, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4479c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4480d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f4481e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f4482f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f4483g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f4484h;

        public c(float f11, float f12, float f13, float f14, float f15, float f16) {
            super(true, false, 2, null);
            this.f4479c = f11;
            this.f4480d = f12;
            this.f4481e = f13;
            this.f4482f = f14;
            this.f4483g = f15;
            this.f4484h = f16;
        }

        public final float c() {
            return this.f4479c;
        }

        public final float d() {
            return this.f4481e;
        }

        public final float e() {
            return this.f4483g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Float.compare(this.f4479c, cVar.f4479c) == 0 && Float.compare(this.f4480d, cVar.f4480d) == 0 && Float.compare(this.f4481e, cVar.f4481e) == 0 && Float.compare(this.f4482f, cVar.f4482f) == 0 && Float.compare(this.f4483g, cVar.f4483g) == 0 && Float.compare(this.f4484h, cVar.f4484h) == 0;
        }

        public final float f() {
            return this.f4480d;
        }

        public final float g() {
            return this.f4482f;
        }

        public final float h() {
            return this.f4484h;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.f4479c) * 31) + Float.floatToIntBits(this.f4480d)) * 31) + Float.floatToIntBits(this.f4481e)) * 31) + Float.floatToIntBits(this.f4482f)) * 31) + Float.floatToIntBits(this.f4483g)) * 31) + Float.floatToIntBits(this.f4484h);
        }

        public String toString() {
            return "CurveTo(x1=" + this.f4479c + ", y1=" + this.f4480d + ", x2=" + this.f4481e + ", y2=" + this.f4482f + ", x3=" + this.f4483g + ", y3=" + this.f4484h + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4485c;

        /* JADX WARN: Illegal instructions before constructor call */
        public d(float f11) {
            boolean z11 = false;
            super(z11, z11, 3, null);
            this.f4485c = f11;
        }

        public final float c() {
            return this.f4485c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Float.compare(this.f4485c, ((d) obj).f4485c) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f4485c);
        }

        public String toString() {
            return "HorizontalTo(x=" + this.f4485c + ')';
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0057e extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4486c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4487d;

        /* JADX WARN: Illegal instructions before constructor call */
        public C0057e(float f11, float f12) {
            boolean z11 = false;
            super(z11, z11, 3, null);
            this.f4486c = f11;
            this.f4487d = f12;
        }

        public final float c() {
            return this.f4486c;
        }

        public final float d() {
            return this.f4487d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0057e)) {
                return false;
            }
            C0057e c0057e = (C0057e) obj;
            return Float.compare(this.f4486c, c0057e.f4486c) == 0 && Float.compare(this.f4487d, c0057e.f4487d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f4486c) * 31) + Float.floatToIntBits(this.f4487d);
        }

        public String toString() {
            return "LineTo(x=" + this.f4486c + ", y=" + this.f4487d + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4488c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4489d;

        /* JADX WARN: Illegal instructions before constructor call */
        public f(float f11, float f12) {
            boolean z11 = false;
            super(z11, z11, 3, null);
            this.f4488c = f11;
            this.f4489d = f12;
        }

        public final float c() {
            return this.f4488c;
        }

        public final float d() {
            return this.f4489d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return Float.compare(this.f4488c, fVar.f4488c) == 0 && Float.compare(this.f4489d, fVar.f4489d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f4488c) * 31) + Float.floatToIntBits(this.f4489d);
        }

        public String toString() {
            return "MoveTo(x=" + this.f4488c + ", y=" + this.f4489d + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4490c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4491d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f4492e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f4493f;

        public g(float f11, float f12, float f13, float f14) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f4490c = f11;
            this.f4491d = f12;
            this.f4492e = f13;
            this.f4493f = f14;
        }

        public final float c() {
            return this.f4490c;
        }

        public final float d() {
            return this.f4492e;
        }

        public final float e() {
            return this.f4491d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return Float.compare(this.f4490c, gVar.f4490c) == 0 && Float.compare(this.f4491d, gVar.f4491d) == 0 && Float.compare(this.f4492e, gVar.f4492e) == 0 && Float.compare(this.f4493f, gVar.f4493f) == 0;
        }

        public final float f() {
            return this.f4493f;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f4490c) * 31) + Float.floatToIntBits(this.f4491d)) * 31) + Float.floatToIntBits(this.f4492e)) * 31) + Float.floatToIntBits(this.f4493f);
        }

        public String toString() {
            return "QuadTo(x1=" + this.f4490c + ", y1=" + this.f4491d + ", x2=" + this.f4492e + ", y2=" + this.f4493f + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class h extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4494c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4495d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f4496e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f4497f;

        public h(float f11, float f12, float f13, float f14) {
            super(true, false, 2, null);
            this.f4494c = f11;
            this.f4495d = f12;
            this.f4496e = f13;
            this.f4497f = f14;
        }

        public final float c() {
            return this.f4494c;
        }

        public final float d() {
            return this.f4496e;
        }

        public final float e() {
            return this.f4495d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Float.compare(this.f4494c, hVar.f4494c) == 0 && Float.compare(this.f4495d, hVar.f4495d) == 0 && Float.compare(this.f4496e, hVar.f4496e) == 0 && Float.compare(this.f4497f, hVar.f4497f) == 0;
        }

        public final float f() {
            return this.f4497f;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f4494c) * 31) + Float.floatToIntBits(this.f4495d)) * 31) + Float.floatToIntBits(this.f4496e)) * 31) + Float.floatToIntBits(this.f4497f);
        }

        public String toString() {
            return "ReflectiveCurveTo(x1=" + this.f4494c + ", y1=" + this.f4495d + ", x2=" + this.f4496e + ", y2=" + this.f4497f + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class i extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4499d;

        public i(float f11, float f12) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f4498c = f11;
            this.f4499d = f12;
        }

        public final float c() {
            return this.f4498c;
        }

        public final float d() {
            return this.f4499d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Float.compare(this.f4498c, iVar.f4498c) == 0 && Float.compare(this.f4499d, iVar.f4499d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f4498c) * 31) + Float.floatToIntBits(this.f4499d);
        }

        public String toString() {
            return "ReflectiveQuadTo(x=" + this.f4498c + ", y=" + this.f4499d + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class j extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4500c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4501d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f4502e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f4503f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f4504g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f4505h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float f4506i;

        /* JADX WARN: Illegal instructions before constructor call */
        public j(float f11, float f12, float f13, boolean z11, boolean z12, float f14, float f15) {
            boolean z13 = false;
            super(z13, z13, 3, null);
            this.f4500c = f11;
            this.f4501d = f12;
            this.f4502e = f13;
            this.f4503f = z11;
            this.f4504g = z12;
            this.f4505h = f14;
            this.f4506i = f15;
        }

        public final float c() {
            return this.f4505h;
        }

        public final float d() {
            return this.f4506i;
        }

        public final float e() {
            return this.f4500c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return Float.compare(this.f4500c, jVar.f4500c) == 0 && Float.compare(this.f4501d, jVar.f4501d) == 0 && Float.compare(this.f4502e, jVar.f4502e) == 0 && this.f4503f == jVar.f4503f && this.f4504g == jVar.f4504g && Float.compare(this.f4505h, jVar.f4505h) == 0 && Float.compare(this.f4506i, jVar.f4506i) == 0;
        }

        public final float f() {
            return this.f4502e;
        }

        public final float g() {
            return this.f4501d;
        }

        public final boolean h() {
            return this.f4503f;
        }

        public int hashCode() {
            return (((((((((((Float.floatToIntBits(this.f4500c) * 31) + Float.floatToIntBits(this.f4501d)) * 31) + Float.floatToIntBits(this.f4502e)) * 31) + androidx.compose.foundation.e.a(this.f4503f)) * 31) + androidx.compose.foundation.e.a(this.f4504g)) * 31) + Float.floatToIntBits(this.f4505h)) * 31) + Float.floatToIntBits(this.f4506i);
        }

        public final boolean i() {
            return this.f4504g;
        }

        public String toString() {
            return "RelativeArcTo(horizontalEllipseRadius=" + this.f4500c + ", verticalEllipseRadius=" + this.f4501d + ", theta=" + this.f4502e + ", isMoreThanHalf=" + this.f4503f + ", isPositiveArc=" + this.f4504g + ", arcStartDx=" + this.f4505h + ", arcStartDy=" + this.f4506i + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class k extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4507c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4508d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f4509e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f4510f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f4511g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f4512h;

        public k(float f11, float f12, float f13, float f14, float f15, float f16) {
            super(true, false, 2, null);
            this.f4507c = f11;
            this.f4508d = f12;
            this.f4509e = f13;
            this.f4510f = f14;
            this.f4511g = f15;
            this.f4512h = f16;
        }

        public final float c() {
            return this.f4507c;
        }

        public final float d() {
            return this.f4509e;
        }

        public final float e() {
            return this.f4511g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return Float.compare(this.f4507c, kVar.f4507c) == 0 && Float.compare(this.f4508d, kVar.f4508d) == 0 && Float.compare(this.f4509e, kVar.f4509e) == 0 && Float.compare(this.f4510f, kVar.f4510f) == 0 && Float.compare(this.f4511g, kVar.f4511g) == 0 && Float.compare(this.f4512h, kVar.f4512h) == 0;
        }

        public final float f() {
            return this.f4508d;
        }

        public final float g() {
            return this.f4510f;
        }

        public final float h() {
            return this.f4512h;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.f4507c) * 31) + Float.floatToIntBits(this.f4508d)) * 31) + Float.floatToIntBits(this.f4509e)) * 31) + Float.floatToIntBits(this.f4510f)) * 31) + Float.floatToIntBits(this.f4511g)) * 31) + Float.floatToIntBits(this.f4512h);
        }

        public String toString() {
            return "RelativeCurveTo(dx1=" + this.f4507c + ", dy1=" + this.f4508d + ", dx2=" + this.f4509e + ", dy2=" + this.f4510f + ", dx3=" + this.f4511g + ", dy3=" + this.f4512h + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class l extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4513c;

        /* JADX WARN: Illegal instructions before constructor call */
        public l(float f11) {
            boolean z11 = false;
            super(z11, z11, 3, null);
            this.f4513c = f11;
        }

        public final float c() {
            return this.f4513c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof l) && Float.compare(this.f4513c, ((l) obj).f4513c) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f4513c);
        }

        public String toString() {
            return "RelativeHorizontalTo(dx=" + this.f4513c + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class m extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4514c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4515d;

        /* JADX WARN: Illegal instructions before constructor call */
        public m(float f11, float f12) {
            boolean z11 = false;
            super(z11, z11, 3, null);
            this.f4514c = f11;
            this.f4515d = f12;
        }

        public final float c() {
            return this.f4514c;
        }

        public final float d() {
            return this.f4515d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            return Float.compare(this.f4514c, mVar.f4514c) == 0 && Float.compare(this.f4515d, mVar.f4515d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f4514c) * 31) + Float.floatToIntBits(this.f4515d);
        }

        public String toString() {
            return "RelativeLineTo(dx=" + this.f4514c + ", dy=" + this.f4515d + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class n extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4517d;

        /* JADX WARN: Illegal instructions before constructor call */
        public n(float f11, float f12) {
            boolean z11 = false;
            super(z11, z11, 3, null);
            this.f4516c = f11;
            this.f4517d = f12;
        }

        public final float c() {
            return this.f4516c;
        }

        public final float d() {
            return this.f4517d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof n)) {
                return false;
            }
            n nVar = (n) obj;
            return Float.compare(this.f4516c, nVar.f4516c) == 0 && Float.compare(this.f4517d, nVar.f4517d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f4516c) * 31) + Float.floatToIntBits(this.f4517d);
        }

        public String toString() {
            return "RelativeMoveTo(dx=" + this.f4516c + ", dy=" + this.f4517d + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class o extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4518c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4519d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f4520e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f4521f;

        public o(float f11, float f12, float f13, float f14) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f4518c = f11;
            this.f4519d = f12;
            this.f4520e = f13;
            this.f4521f = f14;
        }

        public final float c() {
            return this.f4518c;
        }

        public final float d() {
            return this.f4520e;
        }

        public final float e() {
            return this.f4519d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof o)) {
                return false;
            }
            o oVar = (o) obj;
            return Float.compare(this.f4518c, oVar.f4518c) == 0 && Float.compare(this.f4519d, oVar.f4519d) == 0 && Float.compare(this.f4520e, oVar.f4520e) == 0 && Float.compare(this.f4521f, oVar.f4521f) == 0;
        }

        public final float f() {
            return this.f4521f;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f4518c) * 31) + Float.floatToIntBits(this.f4519d)) * 31) + Float.floatToIntBits(this.f4520e)) * 31) + Float.floatToIntBits(this.f4521f);
        }

        public String toString() {
            return "RelativeQuadTo(dx1=" + this.f4518c + ", dy1=" + this.f4519d + ", dx2=" + this.f4520e + ", dy2=" + this.f4521f + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class p extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4522c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4523d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f4524e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f4525f;

        public p(float f11, float f12, float f13, float f14) {
            super(true, false, 2, null);
            this.f4522c = f11;
            this.f4523d = f12;
            this.f4524e = f13;
            this.f4525f = f14;
        }

        public final float c() {
            return this.f4522c;
        }

        public final float d() {
            return this.f4524e;
        }

        public final float e() {
            return this.f4523d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            p pVar = (p) obj;
            return Float.compare(this.f4522c, pVar.f4522c) == 0 && Float.compare(this.f4523d, pVar.f4523d) == 0 && Float.compare(this.f4524e, pVar.f4524e) == 0 && Float.compare(this.f4525f, pVar.f4525f) == 0;
        }

        public final float f() {
            return this.f4525f;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f4522c) * 31) + Float.floatToIntBits(this.f4523d)) * 31) + Float.floatToIntBits(this.f4524e)) * 31) + Float.floatToIntBits(this.f4525f);
        }

        public String toString() {
            return "RelativeReflectiveCurveTo(dx1=" + this.f4522c + ", dy1=" + this.f4523d + ", dx2=" + this.f4524e + ", dy2=" + this.f4525f + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class q extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4526c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4527d;

        public q(float f11, float f12) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f4526c = f11;
            this.f4527d = f12;
        }

        public final float c() {
            return this.f4526c;
        }

        public final float d() {
            return this.f4527d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof q)) {
                return false;
            }
            q qVar = (q) obj;
            return Float.compare(this.f4526c, qVar.f4526c) == 0 && Float.compare(this.f4527d, qVar.f4527d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f4526c) * 31) + Float.floatToIntBits(this.f4527d);
        }

        public String toString() {
            return "RelativeReflectiveQuadTo(dx=" + this.f4526c + ", dy=" + this.f4527d + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class r extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4528c;

        /* JADX WARN: Illegal instructions before constructor call */
        public r(float f11) {
            boolean z11 = false;
            super(z11, z11, 3, null);
            this.f4528c = f11;
        }

        public final float c() {
            return this.f4528c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof r) && Float.compare(this.f4528c, ((r) obj).f4528c) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f4528c);
        }

        public String toString() {
            return "RelativeVerticalTo(dy=" + this.f4528c + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class s extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4529c;

        /* JADX WARN: Illegal instructions before constructor call */
        public s(float f11) {
            boolean z11 = false;
            super(z11, z11, 3, null);
            this.f4529c = f11;
        }

        public final float c() {
            return this.f4529c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof s) && Float.compare(this.f4529c, ((s) obj).f4529c) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f4529c);
        }

        public String toString() {
            return "VerticalTo(y=" + this.f4529c + ')';
        }
    }

    public e(boolean z11, boolean z12) {
        this.f4469a = z11;
        this.f4470b = z12;
    }

    public /* synthetic */ e(boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? false : z12, null);
    }

    public /* synthetic */ e(boolean z11, boolean z12, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, z12);
    }

    public final boolean a() {
        return this.f4469a;
    }

    public final boolean b() {
        return this.f4470b;
    }
}
