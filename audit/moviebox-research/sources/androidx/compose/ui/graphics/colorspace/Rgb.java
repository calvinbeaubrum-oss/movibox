package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.y1;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
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
public final class Rgb extends c {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f3996t = new a(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final j f3997u = new j() { // from class: androidx.compose.ui.graphics.colorspace.q
        @Override // androidx.compose.ui.graphics.colorspace.j
        public final double a(double d11) {
            return Rgb.x(d11);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y f3998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f3999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f4000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x f4001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f4002i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f4003j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float[] f4004k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j f4005l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<Double, Double> f4006m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j f4007n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final j f4008o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function1<Double, Double> f4009p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final j f4010q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f4011r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f4012s;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float e(float[] fArr) {
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[2];
            float f14 = fArr[3];
            float f15 = fArr[4];
            float f16 = fArr[5];
            float f17 = ((((((f11 * f14) + (f12 * f15)) + (f13 * f16)) - (f14 * f15)) - (f12 * f13)) - (f11 * f16)) * 0.5f;
            return f17 < 0.0f ? -f17 : f17;
        }

        public final boolean f(double d11, j jVar, j jVar2) {
            return Math.abs(jVar.a(d11) - jVar2.a(d11)) <= 0.001d;
        }

        public final float[] g(float[] fArr, y yVar) {
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[2];
            float f14 = fArr[3];
            float f15 = fArr[4];
            float f16 = fArr[5];
            float fA = yVar.a();
            float fB = yVar.b();
            float f17 = 1;
            float f18 = (f17 - f11) / f12;
            float f19 = (f17 - f13) / f14;
            float f21 = (f17 - f15) / f16;
            float f22 = (f17 - fA) / fB;
            float f23 = f11 / f12;
            float f24 = (f13 / f14) - f23;
            float f25 = (fA / fB) - f23;
            float f26 = f19 - f18;
            float f27 = (f15 / f16) - f23;
            float f28 = (((f22 - f18) * f24) - (f25 * f26)) / (((f21 - f18) * f24) - (f26 * f27));
            float f29 = (f25 - (f27 * f28)) / f24;
            float f31 = (1.0f - f29) - f28;
            float f32 = f31 / f12;
            float f33 = f29 / f14;
            float f34 = f28 / f16;
            return new float[]{f32 * f11, f31, f32 * ((1.0f - f11) - f12), f33 * f13, f29, f33 * ((1.0f - f13) - f14), f34 * f15, f28, f34 * ((1.0f - f15) - f16)};
        }

        public final boolean h(float[] fArr, float[] fArr2) {
            float f11 = fArr[0] - fArr2[0];
            float f12 = fArr[1] - fArr2[1];
            float[] fArr3 = {f11, f12, fArr[2] - fArr2[2], fArr[3] - fArr2[3], fArr[4] - fArr2[4], fArr[5] - fArr2[5]};
            return i(f11, f12, fArr2[0] - fArr2[4], fArr2[1] - fArr2[5]) >= 0.0f && i(fArr2[0] - fArr2[2], fArr2[1] - fArr2[3], fArr3[0], fArr3[1]) >= 0.0f && i(fArr3[2], fArr3[3], fArr2[2] - fArr2[0], fArr2[3] - fArr2[1]) >= 0.0f && i(fArr2[2] - fArr2[4], fArr2[3] - fArr2[5], fArr3[2], fArr3[3]) >= 0.0f && i(fArr3[4], fArr3[5], fArr2[4] - fArr2[2], fArr2[5] - fArr2[3]) >= 0.0f && i(fArr2[4] - fArr2[0], fArr2[5] - fArr2[1], fArr3[4], fArr3[5]) >= 0.0f;
        }

        public final float i(float f11, float f12, float f13, float f14) {
            return (f11 * f14) - (f12 * f13);
        }

        public final boolean j(float[] fArr, y yVar, j jVar, j jVar2, float f11, float f12, int i11) {
            if (i11 == 0) {
                return true;
            }
            g gVar = g.f4027a;
            if (!d.g(fArr, gVar.x()) || !d.f(yVar, k.f4062a.e()) || f11 != 0.0f || f12 != 1.0f) {
                return false;
            }
            Rgb rgbW = gVar.w();
            for (double d11 = 0.0d; d11 <= 1.0d; d11 += 0.00392156862745098d) {
                if (!f(d11, jVar, rgbW.N()) || !f(d11, jVar2, rgbW.J())) {
                    return false;
                }
            }
            return true;
        }

        public final boolean k(float[] fArr, float f11, float f12) {
            float fE = e(fArr);
            g gVar = g.f4027a;
            return (fE / e(gVar.s()) > 0.9f && h(fArr, gVar.x())) || (f11 < 0.0f && f12 > 1.0f);
        }

        public final float[] l(float[] fArr) {
            float[] fArr2 = new float[6];
            if (fArr.length == 9) {
                float f11 = fArr[0];
                float f12 = fArr[1];
                float f13 = f11 + f12 + fArr[2];
                fArr2[0] = f11 / f13;
                fArr2[1] = f12 / f13;
                float f14 = fArr[3];
                float f15 = fArr[4];
                float f16 = f14 + f15 + fArr[5];
                fArr2[2] = f14 / f16;
                fArr2[3] = f15 / f16;
                float f17 = fArr[6];
                float f18 = fArr[7];
                float f19 = f17 + f18 + fArr[8];
                fArr2[4] = f17 / f19;
                fArr2[5] = f18 / f19;
            } else {
                ArraysKt___ArraysJvmKt.n(fArr, fArr2, 0, 0, 6, 6, null);
            }
            return fArr2;
        }
    }

    public Rgb(Rgb rgb, float[] fArr, y yVar) {
        this(rgb.h(), rgb.f4002i, yVar, fArr, rgb.f4005l, rgb.f4008o, rgb.f3999f, rgb.f4000g, rgb.f4001h, -1);
    }

    public Rgb(String str, float[] fArr, y yVar, final double d11, float f11, float f12, int i11) {
        this(str, fArr, yVar, null, d11 == 1.0d ? f3997u : new j() { // from class: androidx.compose.ui.graphics.colorspace.v
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d12) {
                return Rgb.y(d11, d12);
            }
        }, d11 == 1.0d ? f3997u : new j() { // from class: androidx.compose.ui.graphics.colorspace.w
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d12) {
                return Rgb.z(d11, d12);
            }
        }, f11, f12, new x(d11, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 96, null), i11);
    }

    public Rgb(String str, float[] fArr, y yVar, final x xVar, int i11) {
        this(str, fArr, yVar, null, (xVar.e() == 0.0d && xVar.f() == 0.0d) ? new j() { // from class: androidx.compose.ui.graphics.colorspace.r
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                return Rgb.A(xVar, d11);
            }
        } : new j() { // from class: androidx.compose.ui.graphics.colorspace.s
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                return Rgb.B(xVar, d11);
            }
        }, (xVar.e() == 0.0d && xVar.f() == 0.0d) ? new j() { // from class: androidx.compose.ui.graphics.colorspace.t
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                return Rgb.C(xVar, d11);
            }
        } : new j() { // from class: androidx.compose.ui.graphics.colorspace.u
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                return Rgb.D(xVar, d11);
            }
        }, 0.0f, 1.0f, xVar, i11);
    }

    public Rgb(String str, float[] fArr, y yVar, float[] fArr2, j jVar, j jVar2, float f11, float f12, x xVar, int i11) {
        super(str, b.f4018a.b(), i11, null);
        this.f3998e = yVar;
        this.f3999f = f11;
        this.f4000g = f12;
        this.f4001h = xVar;
        this.f4005l = jVar;
        this.f4006m = new Function1<Double, Double>() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$oetf$1
            {
                super(1);
            }

            public final Double invoke(double d11) {
                return Double.valueOf(kotlin.ranges.a.i(this.this$0.N().a(d11), this.this$0.f3999f, this.this$0.f4000g));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d11) {
                return invoke(d11.doubleValue());
            }
        };
        this.f4007n = new j() { // from class: androidx.compose.ui.graphics.colorspace.o
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                return Rgb.S(this.f4084a, d11);
            }
        };
        this.f4008o = jVar2;
        this.f4009p = new Function1<Double, Double>() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$eotf$1
            {
                super(1);
            }

            public final Double invoke(double d11) {
                return Double.valueOf(this.this$0.J().a(kotlin.ranges.a.i(d11, this.this$0.f3999f, this.this$0.f4000g)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d11) {
                return invoke(d11.doubleValue());
            }
        };
        this.f4010q = new j() { // from class: androidx.compose.ui.graphics.colorspace.p
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                return Rgb.G(this.f4085a, d11);
            }
        };
        if (fArr.length != 6 && fArr.length != 9) {
            throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        }
        if (f11 >= f12) {
            throw new IllegalArgumentException("Invalid range: min=" + f11 + ", max=" + f12 + "; min must be strictly < max");
        }
        a aVar = f3996t;
        float[] fArrL = aVar.l(fArr);
        this.f4002i = fArrL;
        if (fArr2 == null) {
            this.f4003j = aVar.g(fArrL, yVar);
        } else {
            if (fArr2.length != 9) {
                throw new IllegalArgumentException("Transform must have 9 entries! Has " + fArr2.length);
            }
            this.f4003j = fArr2;
        }
        this.f4004k = d.k(this.f4003j);
        this.f4011r = aVar.k(fArrL, f11, f12);
        this.f4012s = aVar.j(fArrL, yVar, jVar, jVar2, f11, f12, i11);
    }

    public static final double A(x xVar, double d11) {
        return d.o(d11, xVar.a(), xVar.b(), xVar.c(), xVar.d(), xVar.g());
    }

    public static final double B(x xVar, double d11) {
        return d.p(d11, xVar.a(), xVar.b(), xVar.c(), xVar.d(), xVar.e(), xVar.f(), xVar.g());
    }

    public static final double C(x xVar, double d11) {
        return d.q(d11, xVar.a(), xVar.b(), xVar.c(), xVar.d(), xVar.g());
    }

    public static final double D(x xVar, double d11) {
        return d.r(d11, xVar.a(), xVar.b(), xVar.c(), xVar.d(), xVar.e(), xVar.f(), xVar.g());
    }

    public static final double G(Rgb rgb, double d11) {
        return rgb.f4008o.a(kotlin.ranges.a.i(d11, rgb.f3999f, rgb.f4000g));
    }

    public static final double S(Rgb rgb, double d11) {
        return kotlin.ranges.a.i(rgb.f4005l.a(d11), rgb.f3999f, rgb.f4000g);
    }

    public static final double x(double d11) {
        return d11;
    }

    public static final double y(double d11, double d12) {
        if (d12 < 0.0d) {
            d12 = 0.0d;
        }
        return Math.pow(d12, 1.0d / d11);
    }

    public static final double z(double d11, double d12) {
        if (d12 < 0.0d) {
            d12 = 0.0d;
        }
        return Math.pow(d12, d11);
    }

    public final Function1<Double, Double> H() {
        return this.f4009p;
    }

    public final j I() {
        return this.f4010q;
    }

    public final j J() {
        return this.f4008o;
    }

    public final float[] K() {
        return this.f4004k;
    }

    public final Function1<Double, Double> L() {
        return this.f4006m;
    }

    public final j M() {
        return this.f4007n;
    }

    public final j N() {
        return this.f4005l;
    }

    public final float[] O() {
        return this.f4002i;
    }

    public final x P() {
        return this.f4001h;
    }

    public final float[] Q() {
        return this.f4003j;
    }

    public final y R() {
        return this.f3998e;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float[] b(float[] fArr) {
        d.n(this.f4004k, fArr);
        fArr[0] = (float) this.f4007n.a(fArr[0]);
        fArr[1] = (float) this.f4007n.a(fArr[1]);
        fArr[2] = (float) this.f4007n.a(fArr[2]);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float e(int i11) {
        return this.f4000g;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Rgb.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        Rgb rgb = (Rgb) obj;
        if (Float.compare(rgb.f3999f, this.f3999f) != 0 || Float.compare(rgb.f4000g, this.f4000g) != 0 || !Intrinsics.b(this.f3998e, rgb.f3998e) || !Arrays.equals(this.f4002i, rgb.f4002i)) {
            return false;
        }
        x xVar = this.f4001h;
        if (xVar != null) {
            return Intrinsics.b(xVar, rgb.f4001h);
        }
        if (rgb.f4001h == null) {
            return true;
        }
        if (Intrinsics.b(this.f4005l, rgb.f4005l)) {
            return Intrinsics.b(this.f4008o, rgb.f4008o);
        }
        return false;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float f(int i11) {
        return this.f3999f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public int hashCode() {
        int iHashCode = ((((super.hashCode() * 31) + this.f3998e.hashCode()) * 31) + Arrays.hashCode(this.f4002i)) * 31;
        float f11 = this.f3999f;
        int iFloatToIntBits = (iHashCode + (f11 == 0.0f ? 0 : Float.floatToIntBits(f11))) * 31;
        float f12 = this.f4000g;
        int iFloatToIntBits2 = (iFloatToIntBits + (f12 == 0.0f ? 0 : Float.floatToIntBits(f12))) * 31;
        x xVar = this.f4001h;
        int iHashCode2 = iFloatToIntBits2 + (xVar != null ? xVar.hashCode() : 0);
        return this.f4001h == null ? (((iHashCode2 * 31) + this.f4005l.hashCode()) * 31) + this.f4008o.hashCode() : iHashCode2;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public boolean i() {
        return this.f4012s;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public long j(float f11, float f12, float f13) {
        float fA = (float) this.f4010q.a(f11);
        float fA2 = (float) this.f4010q.a(f12);
        float fA3 = (float) this.f4010q.a(f13);
        float[] fArr = this.f4003j;
        return (((long) Float.floatToRawIntBits(((fArr[0] * fA) + (fArr[3] * fA2)) + (fArr[6] * fA3))) << 32) | (((long) Float.floatToRawIntBits((fArr[1] * fA) + (fArr[4] * fA2) + (fArr[7] * fA3))) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float[] l(float[] fArr) {
        fArr[0] = (float) this.f4010q.a(fArr[0]);
        fArr[1] = (float) this.f4010q.a(fArr[1]);
        fArr[2] = (float) this.f4010q.a(fArr[2]);
        return d.n(this.f4003j, fArr);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float m(float f11, float f12, float f13) {
        float fA = (float) this.f4010q.a(f11);
        float fA2 = (float) this.f4010q.a(f12);
        float fA3 = (float) this.f4010q.a(f13);
        float[] fArr = this.f4003j;
        return (fArr[2] * fA) + (fArr[5] * fA2) + (fArr[8] * fA3);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public long n(float f11, float f12, float f13, float f14, c cVar) {
        float[] fArr = this.f4004k;
        return y1.a((float) this.f4007n.a((fArr[0] * f11) + (fArr[3] * f12) + (fArr[6] * f13)), (float) this.f4007n.a((fArr[1] * f11) + (fArr[4] * f12) + (fArr[7] * f13)), (float) this.f4007n.a((fArr[2] * f11) + (fArr[5] * f12) + (fArr[8] * f13)), f14, cVar);
    }
}
