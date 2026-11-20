package androidx.compose.ui.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
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
public final class f0 {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4132a;

        static {
            int[] iArr = new int[BlendMode.values().length];
            try {
                iArr[BlendMode.CLEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BlendMode.SRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BlendMode.DST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BlendMode.SRC_OVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BlendMode.DST_OVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BlendMode.SRC_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BlendMode.DST_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BlendMode.SRC_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BlendMode.DST_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BlendMode.SRC_ATOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BlendMode.DST_ATOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[BlendMode.XOR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[BlendMode.PLUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[BlendMode.MODULATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[BlendMode.SCREEN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[BlendMode.OVERLAY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[BlendMode.DARKEN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[BlendMode.LIGHTEN.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[BlendMode.COLOR_DODGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[BlendMode.COLOR_BURN.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[BlendMode.HARD_LIGHT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[BlendMode.SOFT_LIGHT.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[BlendMode.DIFFERENCE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[BlendMode.EXCLUSION.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[BlendMode.MULTIPLY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[BlendMode.HUE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[BlendMode.SATURATION.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[BlendMode.COLOR.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[BlendMode.LUMINOSITY.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            f4132a = iArr;
        }
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static final BlendMode a(int i11) {
        e1.a aVar = e1.f4102a;
        if (e1.E(i11, aVar.a())) {
            return BlendMode.CLEAR;
        }
        if (e1.E(i11, aVar.x())) {
            return BlendMode.SRC;
        }
        if (e1.E(i11, aVar.g())) {
            return BlendMode.DST;
        }
        if (e1.E(i11, aVar.B())) {
            return BlendMode.SRC_OVER;
        }
        if (e1.E(i11, aVar.k())) {
            return BlendMode.DST_OVER;
        }
        if (e1.E(i11, aVar.z())) {
            return BlendMode.SRC_IN;
        }
        if (e1.E(i11, aVar.i())) {
            return BlendMode.DST_IN;
        }
        if (e1.E(i11, aVar.A())) {
            return BlendMode.SRC_OUT;
        }
        if (e1.E(i11, aVar.j())) {
            return BlendMode.DST_OUT;
        }
        if (e1.E(i11, aVar.y())) {
            return BlendMode.SRC_ATOP;
        }
        if (e1.E(i11, aVar.h())) {
            return BlendMode.DST_ATOP;
        }
        if (e1.E(i11, aVar.C())) {
            return BlendMode.XOR;
        }
        if (e1.E(i11, aVar.t())) {
            return BlendMode.PLUS;
        }
        if (e1.E(i11, aVar.q())) {
            return BlendMode.MODULATE;
        }
        if (e1.E(i11, aVar.v())) {
            return BlendMode.SCREEN;
        }
        if (e1.E(i11, aVar.s())) {
            return BlendMode.OVERLAY;
        }
        if (e1.E(i11, aVar.e())) {
            return BlendMode.DARKEN;
        }
        if (e1.E(i11, aVar.o())) {
            return BlendMode.LIGHTEN;
        }
        if (e1.E(i11, aVar.d())) {
            return BlendMode.COLOR_DODGE;
        }
        if (e1.E(i11, aVar.c())) {
            return BlendMode.COLOR_BURN;
        }
        if (e1.E(i11, aVar.m())) {
            return BlendMode.HARD_LIGHT;
        }
        if (e1.E(i11, aVar.w())) {
            return BlendMode.SOFT_LIGHT;
        }
        if (e1.E(i11, aVar.f())) {
            return BlendMode.DIFFERENCE;
        }
        if (e1.E(i11, aVar.l())) {
            return BlendMode.EXCLUSION;
        }
        if (e1.E(i11, aVar.r())) {
            return BlendMode.MULTIPLY;
        }
        if (e1.E(i11, aVar.n())) {
            return BlendMode.HUE;
        }
        if (e1.E(i11, aVar.u())) {
            return BlendMode.SATURATION;
        }
        if (e1.E(i11, aVar.b())) {
            return BlendMode.COLOR;
        }
        return e1.E(i11, aVar.p()) ? BlendMode.LUMINOSITY : BlendMode.SRC_OVER;
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static final int b(BlendMode blendMode) {
        switch (a.f4132a[blendMode.ordinal()]) {
            case 1:
                return e1.f4102a.a();
            case 2:
                return e1.f4102a.x();
            case 3:
                return e1.f4102a.g();
            case 4:
                return e1.f4102a.B();
            case 5:
                return e1.f4102a.k();
            case 6:
                return e1.f4102a.z();
            case 7:
                return e1.f4102a.i();
            case 8:
                return e1.f4102a.A();
            case 9:
                return e1.f4102a.j();
            case 10:
                return e1.f4102a.y();
            case 11:
                return e1.f4102a.h();
            case 12:
                return e1.f4102a.C();
            case 13:
                return e1.f4102a.t();
            case 14:
                return e1.f4102a.q();
            case 15:
                return e1.f4102a.v();
            case 16:
                return e1.f4102a.s();
            case 17:
                return e1.f4102a.e();
            case 18:
                return e1.f4102a.o();
            case 19:
                return e1.f4102a.d();
            case 20:
                return e1.f4102a.c();
            case 21:
                return e1.f4102a.m();
            case 22:
                return e1.f4102a.w();
            case 23:
                return e1.f4102a.f();
            case 24:
                return e1.f4102a.l();
            case 25:
                return e1.f4102a.r();
            case 26:
                return e1.f4102a.n();
            case 27:
                return e1.f4102a.u();
            case 28:
                return e1.f4102a.b();
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                return e1.f4102a.p();
            default:
                return e1.f4102a.B();
        }
    }

    public static final PorterDuff.Mode c(int i11) {
        e1.a aVar = e1.f4102a;
        if (e1.E(i11, aVar.a())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (e1.E(i11, aVar.x())) {
            return PorterDuff.Mode.SRC;
        }
        if (e1.E(i11, aVar.g())) {
            return PorterDuff.Mode.DST;
        }
        if (e1.E(i11, aVar.B())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (e1.E(i11, aVar.k())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (e1.E(i11, aVar.z())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (e1.E(i11, aVar.i())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (e1.E(i11, aVar.A())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (e1.E(i11, aVar.j())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (e1.E(i11, aVar.y())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (e1.E(i11, aVar.h())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (e1.E(i11, aVar.C())) {
            return PorterDuff.Mode.XOR;
        }
        if (e1.E(i11, aVar.t())) {
            return PorterDuff.Mode.ADD;
        }
        if (e1.E(i11, aVar.v())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (e1.E(i11, aVar.s())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (e1.E(i11, aVar.e())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (e1.E(i11, aVar.o())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        return e1.E(i11, aVar.q()) ? PorterDuff.Mode.MULTIPLY : PorterDuff.Mode.SRC_OVER;
    }
}
