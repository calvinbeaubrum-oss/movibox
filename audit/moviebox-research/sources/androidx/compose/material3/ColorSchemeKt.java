package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.s1;
import com.vungle.warren.error.VungleException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.mvel2.ast.ASTNode;

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
public final class ColorSchemeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s1<b> f3191a = CompositionLocalKt.f(new Function0<b>() { // from class: androidx.compose.material3.ColorSchemeKt$LocalColorScheme$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return ColorSchemeKt.d(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 536870911, null);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3192a;

        static {
            int[] iArr = new int[ColorSchemeKeyTokens.values().length];
            try {
                iArr[ColorSchemeKeyTokens.Background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            f3192a = iArr;
        }
    }

    public static final long a(b bVar, ColorSchemeKeyTokens value) {
        Intrinsics.g(bVar, "<this>");
        Intrinsics.g(value, "value");
        switch (a.f3192a[value.ordinal()]) {
            case 1:
                return bVar.a();
            case 2:
                return bVar.b();
            case 3:
                return bVar.c();
            case 4:
                return bVar.d();
            case 5:
                return bVar.e();
            case 6:
                return bVar.f();
            case 7:
                return bVar.g();
            case 8:
                return bVar.h();
            case 9:
                return bVar.i();
            case 10:
                return bVar.j();
            case 11:
                return bVar.k();
            case 12:
                return bVar.l();
            case 13:
                return bVar.m();
            case 14:
                return bVar.n();
            case 15:
                return bVar.o();
            case 16:
                return bVar.z();
            case 17:
                return bVar.p();
            case 18:
                return bVar.q();
            case 19:
                return bVar.r();
            case 20:
                return bVar.s();
            case 21:
                return bVar.t();
            case 22:
                return bVar.u();
            case 23:
                return bVar.v();
            case 24:
                return bVar.w();
            case 25:
                return bVar.x();
            case 26:
                return bVar.y();
            case 27:
                return bVar.A();
            case 28:
                return bVar.B();
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                return bVar.C();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final s1<b> b() {
        return f3191a;
    }

    public static final b c(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41) {
        return new b(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, j24, j25, j26, j27, j28, j29, j31, j32, j33, j34, j35, j36, j37, j38, j39, j40, j41, null);
    }

    public static /* synthetic */ b d(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, int i11, Object obj) {
        long jT = (i11 & 1) != 0 ? q1.a.f74121a.t() : j11;
        return c(jT, (i11 & 2) != 0 ? q1.a.f74121a.j() : j12, (i11 & 4) != 0 ? q1.a.f74121a.u() : j13, (i11 & 8) != 0 ? q1.a.f74121a.k() : j14, (i11 & 16) != 0 ? q1.a.f74121a.e() : j15, (i11 & 32) != 0 ? q1.a.f74121a.w() : j16, (i11 & 64) != 0 ? q1.a.f74121a.l() : j17, (i11 & 128) != 0 ? q1.a.f74121a.x() : j18, (i11 & 256) != 0 ? q1.a.f74121a.m() : j19, (i11 & 512) != 0 ? q1.a.f74121a.A() : j21, (i11 & 1024) != 0 ? q1.a.f74121a.p() : j22, (i11 & 2048) != 0 ? q1.a.f74121a.B() : j23, (i11 & 4096) != 0 ? q1.a.f74121a.q() : j24, (i11 & 8192) != 0 ? q1.a.f74121a.a() : j25, (i11 & 16384) != 0 ? q1.a.f74121a.g() : j26, (i11 & 32768) != 0 ? q1.a.f74121a.y() : j27, (i11 & 65536) != 0 ? q1.a.f74121a.n() : j28, (i11 & 131072) != 0 ? q1.a.f74121a.z() : j29, (i11 & 262144) != 0 ? q1.a.f74121a.o() : j31, (i11 & 524288) != 0 ? jT : j32, (i11 & 1048576) != 0 ? q1.a.f74121a.f() : j33, (i11 & 2097152) != 0 ? q1.a.f74121a.d() : j34, (i11 & 4194304) != 0 ? q1.a.f74121a.b() : j35, (i11 & 8388608) != 0 ? q1.a.f74121a.h() : j36, (i11 & 16777216) != 0 ? q1.a.f74121a.c() : j37, (i11 & ASTNode.PCTX_STORED) != 0 ? q1.a.f74121a.i() : j38, (i11 & 67108864) != 0 ? q1.a.f74121a.r() : j39, (i11 & ASTNode.NOJIT) != 0 ? q1.a.f74121a.s() : j40, (i11 & ASTNode.DEOP) != 0 ? q1.a.f74121a.v() : j41);
    }

    public static final long e(ColorSchemeKeyTokens colorSchemeKeyTokens, androidx.compose.runtime.i iVar, int i11) {
        Intrinsics.g(colorSchemeKeyTokens, "<this>");
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(1330949347, i11, -1, "androidx.compose.material3.toColor (ColorScheme.kt:611)");
        }
        long jA = a(f.f3225a.a(iVar, 6), colorSchemeKeyTokens);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return jA;
    }
}
