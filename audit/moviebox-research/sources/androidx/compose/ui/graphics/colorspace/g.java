package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;

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
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f4027a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f4028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float[] f4029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f4030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final x f4031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Rgb f4032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Rgb f4033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Rgb f4034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Rgb f4035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Rgb f4036j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Rgb f4037k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Rgb f4038l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Rgb f4039m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Rgb f4040n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Rgb f4041o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Rgb f4042p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Rgb f4043q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Rgb f4044r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Rgb f4045s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final c f4046t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final c f4047u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Rgb f4048v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final c f4049w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final c[] f4050x;

    static {
        float[] fArr = {0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f};
        f4028b = fArr;
        float[] fArr2 = {0.67f, 0.33f, 0.21f, 0.71f, 0.14f, 0.08f};
        f4029c = fArr2;
        x xVar = new x(2.4d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 0.0d, 0.0d, 96, null);
        f4030d = xVar;
        x xVar2 = new x(2.2d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 0.0d, 0.0d, 96, null);
        f4031e = xVar2;
        k kVar = k.f4062a;
        Rgb rgb = new Rgb("sRGB IEC61966-2.1", fArr, kVar.e(), xVar, 0);
        f4032f = rgb;
        Rgb rgb2 = new Rgb("sRGB IEC61966-2.1 (Linear)", fArr, kVar.e(), 1.0d, 0.0f, 1.0f, 1);
        f4033g = rgb2;
        Rgb rgb3 = new Rgb("scRGB-nl IEC 61966-2-2:2003", fArr, kVar.e(), null, new j() { // from class: androidx.compose.ui.graphics.colorspace.e
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                return g.c(d11);
            }
        }, new j() { // from class: androidx.compose.ui.graphics.colorspace.f
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                return g.d(d11);
            }
        }, -0.799f, 2.399f, xVar, 2);
        f4034h = rgb3;
        Rgb rgb4 = new Rgb("scRGB IEC 61966-2-2:2003", fArr, kVar.e(), 1.0d, -0.5f, 7.499f, 3);
        f4035i = rgb4;
        Rgb rgb5 = new Rgb("Rec. ITU-R BT.709-5", new float[]{0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f}, kVar.e(), new x(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 4);
        f4036j = rgb5;
        Rgb rgb6 = new Rgb("Rec. ITU-R BT.2020-1", new float[]{0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f}, kVar.e(), new x(2.2222222222222223d, 0.9096697898662786d, 0.09033021013372146d, 0.2222222222222222d, 0.08145d, 0.0d, 0.0d, 96, null), 5);
        f4037k = rgb6;
        Rgb rgb7 = new Rgb("SMPTE RP 431-2-2007 DCI (P3)", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, new y(0.314f, 0.351f), 2.6d, 0.0f, 1.0f, 6);
        f4038l = rgb7;
        Rgb rgb8 = new Rgb("Display P3", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, kVar.e(), xVar, 7);
        f4039m = rgb8;
        Rgb rgb9 = new Rgb("NTSC (1953)", fArr2, kVar.a(), new x(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 8);
        f4040n = rgb9;
        Rgb rgb10 = new Rgb("SMPTE-C RGB", new float[]{0.63f, 0.34f, 0.31f, 0.595f, 0.155f, 0.07f}, kVar.e(), new x(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 9);
        f4041o = rgb10;
        Rgb rgb11 = new Rgb("Adobe RGB (1998)", new float[]{0.64f, 0.33f, 0.21f, 0.71f, 0.15f, 0.06f}, kVar.e(), 2.2d, 0.0f, 1.0f, 10);
        f4042p = rgb11;
        Rgb rgb12 = new Rgb("ROMM RGB ISO 22028-2:2013", new float[]{0.7347f, 0.2653f, 0.1596f, 0.8404f, 0.0366f, 1.0E-4f}, kVar.b(), new x(1.8d, 1.0d, 0.0d, 0.0625d, 0.031248d, 0.0d, 0.0d, 96, null), 11);
        f4043q = rgb12;
        Rgb rgb13 = new Rgb("SMPTE ST 2065-1:2012 ACES", new float[]{0.7347f, 0.2653f, 0.0f, 1.0f, 1.0E-4f, -0.077f}, kVar.d(), 1.0d, -65504.0f, 65504.0f, 12);
        f4044r = rgb13;
        Rgb rgb14 = new Rgb("Academy S-2014-004 ACEScg", new float[]{0.713f, 0.293f, 0.165f, 0.83f, 0.128f, 0.044f}, kVar.d(), 1.0d, -65504.0f, 65504.0f, 13);
        f4045s = rgb14;
        z zVar = new z("Generic XYZ", 14);
        f4046t = zVar;
        l lVar = new l("Generic L*a*b*", 15);
        f4047u = lVar;
        Rgb rgb15 = new Rgb("None", fArr, kVar.e(), xVar2, 16);
        f4048v = rgb15;
        m mVar = new m("Oklab", 17);
        f4049w = mVar;
        f4050x = new c[]{rgb, rgb2, rgb3, rgb4, rgb5, rgb6, rgb7, rgb8, rgb9, rgb10, rgb11, rgb12, rgb13, rgb14, zVar, lVar, rgb15, mVar};
    }

    public static final double c(double d11) {
        return d.a(d11, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 2.4d);
    }

    public static final double d(double d11) {
        return d.b(d11, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 2.4d);
    }

    public final Rgb e() {
        return f4044r;
    }

    public final Rgb f() {
        return f4045s;
    }

    public final Rgb g() {
        return f4042p;
    }

    public final Rgb h() {
        return f4037k;
    }

    public final Rgb i() {
        return f4036j;
    }

    public final c j() {
        return f4047u;
    }

    public final c k() {
        return f4046t;
    }

    public final c[] l() {
        return f4050x;
    }

    public final Rgb m() {
        return f4038l;
    }

    public final Rgb n() {
        return f4039m;
    }

    public final Rgb o() {
        return f4034h;
    }

    public final Rgb p() {
        return f4035i;
    }

    public final Rgb q() {
        return f4033g;
    }

    public final Rgb r() {
        return f4040n;
    }

    public final float[] s() {
        return f4029c;
    }

    public final c t() {
        return f4049w;
    }

    public final Rgb u() {
        return f4043q;
    }

    public final Rgb v() {
        return f4041o;
    }

    public final Rgb w() {
        return f4032f;
    }

    public final float[] x() {
        return f4028b;
    }

    public final Rgb y() {
        return f4048v;
    }
}
