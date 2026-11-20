package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

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
public final class RandomKt {
    public static final String a(Object from, Object until) {
        Intrinsics.g(from, "from");
        Intrinsics.g(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void b(double d11, double d12) {
        if (d12 <= d11) {
            throw new IllegalArgumentException(a(Double.valueOf(d11), Double.valueOf(d12)).toString());
        }
    }

    public static final void c(int i11, int i12) {
        if (i12 <= i11) {
            throw new IllegalArgumentException(a(Integer.valueOf(i11), Integer.valueOf(i12)).toString());
        }
    }

    public static final void d(long j11, long j12) {
        if (j12 <= j11) {
            throw new IllegalArgumentException(a(Long.valueOf(j11), Long.valueOf(j12)).toString());
        }
    }

    public static final int e(int i11) {
        return 31 - Integer.numberOfLeadingZeros(i11);
    }

    @SinceKotlin
    public static final int f(Random random, IntRange range) {
        Intrinsics.g(random, "<this>");
        Intrinsics.g(range, "range");
        if (!range.isEmpty()) {
            if (range.i() < Integer.MAX_VALUE) {
                return random.nextInt(range.g(), range.i() + 1);
            }
            return range.g() > Integer.MIN_VALUE ? random.nextInt(range.g() - 1, range.i()) + 1 : random.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int g(int i11, int i12) {
        return (i11 >>> (32 - i12)) & ((-i12) >> 31);
    }
}
