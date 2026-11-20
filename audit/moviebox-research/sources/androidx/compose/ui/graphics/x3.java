package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.colorspace.Rgb;
import java.util.function.DoubleUnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
@RequiresApi(26)
@Metadata
public final class x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x3 f4583a = new x3();

    @JvmStatic
    @RequiresApi(26)
    public static final ColorSpace e(androidx.compose.ui.graphics.colorspace.c cVar) {
        ColorSpace.Rgb.TransferParameters transferParametersA;
        ColorSpace.Rgb rgbA;
        androidx.compose.ui.graphics.colorspace.g gVar = androidx.compose.ui.graphics.colorspace.g.f4027a;
        if (Intrinsics.b(cVar, gVar.w())) {
            return ColorSpace.get(ColorSpace.Named.SRGB);
        }
        if (Intrinsics.b(cVar, gVar.e())) {
            return ColorSpace.get(ColorSpace.Named.ACES);
        }
        if (Intrinsics.b(cVar, gVar.f())) {
            return ColorSpace.get(ColorSpace.Named.ACESCG);
        }
        if (Intrinsics.b(cVar, gVar.g())) {
            return ColorSpace.get(ColorSpace.Named.ADOBE_RGB);
        }
        if (Intrinsics.b(cVar, gVar.h())) {
            return ColorSpace.get(ColorSpace.Named.BT2020);
        }
        if (Intrinsics.b(cVar, gVar.i())) {
            return ColorSpace.get(ColorSpace.Named.BT709);
        }
        if (Intrinsics.b(cVar, gVar.j())) {
            return ColorSpace.get(ColorSpace.Named.CIE_LAB);
        }
        if (Intrinsics.b(cVar, gVar.k())) {
            return ColorSpace.get(ColorSpace.Named.CIE_XYZ);
        }
        if (Intrinsics.b(cVar, gVar.m())) {
            return ColorSpace.get(ColorSpace.Named.DCI_P3);
        }
        if (Intrinsics.b(cVar, gVar.n())) {
            return ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
        }
        if (Intrinsics.b(cVar, gVar.o())) {
            return ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB);
        }
        if (Intrinsics.b(cVar, gVar.p())) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
        }
        if (Intrinsics.b(cVar, gVar.q())) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_SRGB);
        }
        if (Intrinsics.b(cVar, gVar.r())) {
            return ColorSpace.get(ColorSpace.Named.NTSC_1953);
        }
        if (Intrinsics.b(cVar, gVar.u())) {
            return ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB);
        }
        if (Intrinsics.b(cVar, gVar.v())) {
            return ColorSpace.get(ColorSpace.Named.SMPTE_C);
        }
        if (!(cVar instanceof Rgb)) {
            return ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Rgb rgb = (Rgb) cVar;
        float[] fArrC = rgb.R().c();
        androidx.compose.ui.graphics.colorspace.x xVarP = rgb.P();
        if (xVarP != null) {
            h3.a();
            transferParametersA = a2.a(xVarP.a(), xVarP.b(), xVarP.c(), xVarP.d(), xVarP.e(), xVarP.f(), xVarP.g());
        } else {
            transferParametersA = null;
        }
        if (transferParametersA != null) {
            n3.a();
            rgbA = l2.a(cVar.h(), ((Rgb) cVar).O(), fArrC, transferParametersA);
        } else {
            n3.a();
            String strH = cVar.h();
            Rgb rgb2 = (Rgb) cVar;
            float[] fArrO = rgb2.O();
            final Function1<Double, Double> function1L = rgb2.L();
            DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.t3
                @Override // java.util.function.DoubleUnaryOperator
                public final double applyAsDouble(double d11) {
                    return x3.f(function1L, d11);
                }
            };
            final Function1<Double, Double> function1H = rgb2.H();
            rgbA = w2.a(strH, fArrO, fArrC, doubleUnaryOperator, new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.u3
                @Override // java.util.function.DoubleUnaryOperator
                public final double applyAsDouble(double d11) {
                    return x3.g(function1H, d11);
                }
            }, cVar.f(0), cVar.e(0));
        }
        return k2.a(rgbA);
    }

    public static final double f(Function1 function1, double d11) {
        return ((Number) function1.invoke(Double.valueOf(d11))).doubleValue();
    }

    public static final double g(Function1 function1, double d11) {
        return ((Number) function1.invoke(Double.valueOf(d11))).doubleValue();
    }

    @JvmStatic
    @RequiresApi(26)
    public static final androidx.compose.ui.graphics.colorspace.c h(final ColorSpace colorSpace) {
        int id2 = colorSpace.getId();
        if (id2 == ColorSpace.Named.SRGB.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.w();
        }
        if (id2 == ColorSpace.Named.ACES.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.e();
        }
        if (id2 == ColorSpace.Named.ACESCG.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.f();
        }
        if (id2 == ColorSpace.Named.ADOBE_RGB.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.g();
        }
        if (id2 == ColorSpace.Named.BT2020.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.h();
        }
        if (id2 == ColorSpace.Named.BT709.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.i();
        }
        if (id2 == ColorSpace.Named.CIE_LAB.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.j();
        }
        if (id2 == ColorSpace.Named.CIE_XYZ.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.k();
        }
        if (id2 == ColorSpace.Named.DCI_P3.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.m();
        }
        if (id2 == ColorSpace.Named.DISPLAY_P3.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.n();
        }
        if (id2 == ColorSpace.Named.EXTENDED_SRGB.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.o();
        }
        if (id2 == ColorSpace.Named.LINEAR_EXTENDED_SRGB.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.p();
        }
        if (id2 == ColorSpace.Named.LINEAR_SRGB.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.q();
        }
        if (id2 == ColorSpace.Named.NTSC_1953.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.r();
        }
        if (id2 == ColorSpace.Named.PRO_PHOTO_RGB.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.u();
        }
        if (id2 == ColorSpace.Named.SMPTE_C.ordinal()) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.v();
        }
        if (!r2.a(colorSpace)) {
            return androidx.compose.ui.graphics.colorspace.g.f4027a.w();
        }
        ColorSpace.Rgb.TransferParameters transferParameters = s2.a(colorSpace).getTransferParameters();
        return new Rgb(s2.a(colorSpace).getName(), s2.a(colorSpace).getPrimaries(), s2.a(colorSpace).getWhitePoint().length == 3 ? new androidx.compose.ui.graphics.colorspace.y(s2.a(colorSpace).getWhitePoint()[0], s2.a(colorSpace).getWhitePoint()[1], s2.a(colorSpace).getWhitePoint()[2]) : new androidx.compose.ui.graphics.colorspace.y(s2.a(colorSpace).getWhitePoint()[0], s2.a(colorSpace).getWhitePoint()[1]), s2.a(colorSpace).getTransform(), new androidx.compose.ui.graphics.colorspace.j() { // from class: androidx.compose.ui.graphics.v3
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                return x3.i(colorSpace, d11);
            }
        }, new androidx.compose.ui.graphics.colorspace.j() { // from class: androidx.compose.ui.graphics.w3
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                return x3.j(colorSpace, d11);
            }
        }, colorSpace.getMinValue(0), colorSpace.getMaxValue(0), transferParameters != null ? new androidx.compose.ui.graphics.colorspace.x(transferParameters.g, transferParameters.a, transferParameters.b, transferParameters.c, transferParameters.d, transferParameters.e, transferParameters.f) : null, s2.a(colorSpace).getId());
    }

    public static final double i(ColorSpace colorSpace, double d11) {
        return s2.a(colorSpace).getOetf().applyAsDouble(d11);
    }

    public static final double j(ColorSpace colorSpace, double d11) {
        return s2.a(colorSpace).getEotf().applyAsDouble(d11);
    }
}
