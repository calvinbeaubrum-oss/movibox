package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.LongRange;
import kotlin.ranges.a;

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
public final class DurationKt {
    public static final long h(long j11, int i11) {
        return Duration.j((j11 << 1) + ((long) i11));
    }

    public static final long i(long j11) {
        return Duration.j((j11 << 1) + 1);
    }

    public static final long j(long j11) {
        return new LongRange(-4611686018426L, 4611686018426L).s(j11) ? k(m(j11)) : i(a.l(j11, -4611686018427387903L, 4611686018427387903L));
    }

    public static final long k(long j11) {
        return Duration.j(j11 << 1);
    }

    public static final long l(long j11) {
        return new LongRange(-4611686018426999999L, 4611686018426999999L).s(j11) ? k(j11) : i(n(j11));
    }

    public static final long m(long j11) {
        return j11 * ((long) 1000000);
    }

    public static final long n(long j11) {
        return j11 / ((long) 1000000);
    }

    @SinceKotlin
    @WasExperimental
    public static final long o(long j11, DurationUnit unit) {
        Intrinsics.g(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long jB = DurationUnitKt__DurationUnitJvmKt.b(4611686018426999999L, durationUnit, unit);
        return new LongRange(-jB, jB).s(j11) ? k(DurationUnitKt__DurationUnitJvmKt.b(j11, unit, durationUnit)) : i(a.l(DurationUnitKt__DurationUnitJvmKt.a(j11, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }
}
