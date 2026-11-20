package kotlin.ranges;

import b20.c;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.random.RandomKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public class a extends c {
    public static float c(float f11, float f12) {
        return f11 < f12 ? f12 : f11;
    }

    public static int d(int i11, int i12) {
        return i11 < i12 ? i12 : i11;
    }

    public static long e(long j11, long j12) {
        return j11 < j12 ? j12 : j11;
    }

    public static float f(float f11, float f12) {
        return f11 > f12 ? f12 : f11;
    }

    public static int g(int i11, int i12) {
        return i11 > i12 ? i12 : i11;
    }

    public static long h(long j11, long j12) {
        return j11 > j12 ? j12 : j11;
    }

    public static double i(double d11, double d12, double d13) {
        if (d12 <= d13) {
            if (d11 < d12) {
                return d12;
            }
            return d11 > d13 ? d13 : d11;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d13 + " is less than minimum " + d12 + '.');
    }

    public static float j(float f11, float f12, float f13) {
        if (f12 <= f13) {
            if (f11 < f12) {
                return f12;
            }
            return f11 > f13 ? f13 : f11;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f13 + " is less than minimum " + f12 + '.');
    }

    public static int k(int i11, int i12, int i13) {
        if (i12 <= i13) {
            if (i11 < i12) {
                return i12;
            }
            return i11 > i13 ? i13 : i11;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i13 + " is less than minimum " + i12 + '.');
    }

    public static long l(long j11, long j12, long j13) {
        if (j12 <= j13) {
            if (j11 < j12) {
                return j12;
            }
            return j11 > j13 ? j13 : j11;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j13 + " is less than minimum " + j12 + '.');
    }

    @SinceKotlin
    public static <T extends Comparable<? super T>> T m(T t11, ClosedFloatingPointRange<T> range) {
        Intrinsics.g(t11, "<this>");
        Intrinsics.g(range, "range");
        if (!range.isEmpty()) {
            if (!range.a(t11, range.j()) || range.a(range.j(), t11)) {
                return (!range.a(range.f(), t11) || range.a(t11, range.f())) ? t11 : range.f();
            }
            return range.j();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static IntProgression n(int i11, int i12) {
        return IntProgression.f68960d.a(i11, i12, -1);
    }

    @SinceKotlin
    public static int o(IntRange intRange, Random random) {
        Intrinsics.g(intRange, "<this>");
        Intrinsics.g(random, "random");
        try {
            return RandomKt.f(random, intRange);
        } catch (IllegalArgumentException e11) {
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    public static IntProgression p(IntProgression intProgression) {
        Intrinsics.g(intProgression, "<this>");
        return IntProgression.f68960d.a(intProgression.i(), intProgression.g(), -intProgression.r());
    }

    public static IntProgression q(IntProgression intProgression, int i11) {
        Intrinsics.g(intProgression, "<this>");
        c.a(i11 > 0, Integer.valueOf(i11));
        IntProgression.Companion companion = IntProgression.f68960d;
        int iG = intProgression.g();
        int i12 = intProgression.i();
        if (intProgression.r() <= 0) {
            i11 = -i11;
        }
        return companion.a(iG, i12, i11);
    }

    public static IntRange r(int i11, int i12) {
        return i12 <= Integer.MIN_VALUE ? IntRange.f68968f.a() : new IntRange(i11, i12 - 1);
    }
}
