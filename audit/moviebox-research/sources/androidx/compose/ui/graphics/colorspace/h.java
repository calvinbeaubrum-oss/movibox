package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.y1;
import java.util.Arrays;
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
public class h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f4051g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f4053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f4054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f4055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f4057f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: androidx.compose.ui.graphics.colorspace.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0055a extends h {
            public C0055a(c cVar, int i11) {
                super(cVar, cVar, i11, null);
            }

            @Override // androidx.compose.ui.graphics.colorspace.h
            public long a(long j11) {
                return j11;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float[] b(c cVar, c cVar2, int i11) {
            if (!n.e(i11, n.f4079a.a())) {
                return null;
            }
            long jG = cVar.g();
            androidx.compose.ui.graphics.colorspace.b.a aVar = androidx.compose.ui.graphics.colorspace.b.f4018a;
            boolean zE = androidx.compose.ui.graphics.colorspace.b.e(jG, aVar.b());
            boolean zE2 = androidx.compose.ui.graphics.colorspace.b.e(cVar2.g(), aVar.b());
            if (zE && zE2) {
                return null;
            }
            if (!zE && !zE2) {
                return null;
            }
            if (!zE) {
                cVar = cVar2;
            }
            Intrinsics.e(cVar, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Rgb rgb = (Rgb) cVar;
            float[] fArrC = zE ? rgb.R().c() : k.f4062a.c();
            float[] fArrC2 = zE2 ? rgb.R().c() : k.f4062a.c();
            return new float[]{fArrC[0] / fArrC2[0], fArrC[1] / fArrC2[1], fArrC[2] / fArrC2[2]};
        }

        public final h c(c cVar) {
            return new C0055a(cVar, n.f4079a.c());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b extends h {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Rgb f4058h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Rgb f4059i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float[] f4060j;

        public b(Rgb rgb, Rgb rgb2, int i11) {
            super(rgb, rgb2, rgb, rgb2, i11, null, null);
            this.f4058h = rgb;
            this.f4059i = rgb2;
            this.f4060j = b(rgb, rgb2, i11);
        }

        public /* synthetic */ b(Rgb rgb, Rgb rgb2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(rgb, rgb2, i11);
        }

        @Override // androidx.compose.ui.graphics.colorspace.h
        public long a(long j11) {
            float fR = w1.r(j11);
            float fQ = w1.q(j11);
            float fO = w1.o(j11);
            float fN = w1.n(j11);
            float fA = (float) this.f4058h.I().a(fR);
            float fA2 = (float) this.f4058h.I().a(fQ);
            float fA3 = (float) this.f4058h.I().a(fO);
            float[] fArr = this.f4060j;
            return y1.a((float) this.f4059i.M().a((fArr[0] * fA) + (fArr[3] * fA2) + (fArr[6] * fA3)), (float) this.f4059i.M().a((fArr[1] * fA) + (fArr[4] * fA2) + (fArr[7] * fA3)), (float) this.f4059i.M().a((fArr[2] * fA) + (fArr[5] * fA2) + (fArr[8] * fA3)), fN, this.f4059i);
        }

        public final float[] b(Rgb rgb, Rgb rgb2, int i11) {
            if (d.f(rgb.R(), rgb2.R())) {
                return d.l(rgb2.K(), rgb.Q());
            }
            float[] fArrQ = rgb.Q();
            float[] fArrK = rgb2.K();
            float[] fArrC = rgb.R().c();
            float[] fArrC2 = rgb2.R().c();
            y yVarR = rgb.R();
            k kVar = k.f4062a;
            if (!d.f(yVarR, kVar.b())) {
                float[] fArrB = androidx.compose.ui.graphics.colorspace.a.f4013b.a().b();
                float[] fArrC3 = kVar.c();
                float[] fArrCopyOf = Arrays.copyOf(fArrC3, fArrC3.length);
                Intrinsics.f(fArrCopyOf, "copyOf(this, size)");
                fArrQ = d.l(d.e(fArrB, fArrC, fArrCopyOf), rgb.Q());
            }
            if (!d.f(rgb2.R(), kVar.b())) {
                float[] fArrB2 = androidx.compose.ui.graphics.colorspace.a.f4013b.a().b();
                float[] fArrC4 = kVar.c();
                float[] fArrCopyOf2 = Arrays.copyOf(fArrC4, fArrC4.length);
                Intrinsics.f(fArrCopyOf2, "copyOf(this, size)");
                fArrK = d.k(d.l(d.e(fArrB2, fArrC2, fArrCopyOf2), rgb2.Q()));
            }
            if (n.e(i11, n.f4079a.a())) {
                fArrQ = d.m(new float[]{fArrC[0] / fArrC2[0], fArrC[1] / fArrC2[1], fArrC[2] / fArrC2[2]}, fArrQ);
            }
            return d.l(fArrK, fArrQ);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public h(c cVar, c cVar2, int i11) {
        long jG = cVar.g();
        androidx.compose.ui.graphics.colorspace.b.a aVar = androidx.compose.ui.graphics.colorspace.b.f4018a;
        this(cVar, cVar2, androidx.compose.ui.graphics.colorspace.b.e(jG, aVar.b()) ? d.d(cVar, k.f4062a.b(), null, 2, null) : cVar, androidx.compose.ui.graphics.colorspace.b.e(cVar2.g(), aVar.b()) ? d.d(cVar2, k.f4062a.b(), null, 2, null) : cVar2, i11, f4051g.b(cVar, cVar2, i11), null);
    }

    public /* synthetic */ h(c cVar, c cVar2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, cVar2, i11);
    }

    public h(c cVar, c cVar2, c cVar3, c cVar4, int i11, float[] fArr) {
        this.f4052a = cVar;
        this.f4053b = cVar2;
        this.f4054c = cVar3;
        this.f4055d = cVar4;
        this.f4056e = i11;
        this.f4057f = fArr;
    }

    public /* synthetic */ h(c cVar, c cVar2, c cVar3, c cVar4, int i11, float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, cVar2, cVar3, cVar4, i11, fArr);
    }

    public long a(long j11) {
        float fR = w1.r(j11);
        float fQ = w1.q(j11);
        float fO = w1.o(j11);
        float fN = w1.n(j11);
        long j12 = this.f4054c.j(fR, fQ, fO);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j12 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j12 & 4294967295L));
        float fM = this.f4054c.m(fR, fQ, fO);
        float[] fArr = this.f4057f;
        if (fArr != null) {
            fIntBitsToFloat *= fArr[0];
            fIntBitsToFloat2 *= fArr[1];
            fM *= fArr[2];
        }
        float f11 = fIntBitsToFloat;
        return this.f4055d.n(f11, fIntBitsToFloat2, fM, fN, this.f4053b);
    }
}
