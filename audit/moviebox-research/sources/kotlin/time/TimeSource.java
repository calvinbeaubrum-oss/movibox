package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
/* JADX INFO: loaded from: classes8.dex */
@SinceKotlin
@Metadata
@WasExperimental
public interface TimeSource {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f69171a = new Companion();

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Monotonic implements WithComparableMarks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Monotonic f69172a = new Monotonic();

        /* JADX INFO: compiled from: source.java */
        @SinceKotlin
        @Metadata
        @JvmInline
        @WasExperimental
        public static final class ValueTimeMark implements ComparableTimeMark {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f69173a;

            public static boolean b(long j11, Object obj) {
                return (obj instanceof ValueTimeMark) && j11 == ((ValueTimeMark) obj).i();
            }

            public static int c(long j11) {
                return p.a(j11);
            }

            public static final long d(long j11, long j12) {
                return MonotonicTimeSource.f69168a.a(j11, j12);
            }

            public static long e(long j11, ComparableTimeMark other) {
                Intrinsics.g(other, "other");
                if (other instanceof ValueTimeMark) {
                    return d(j11, ((ValueTimeMark) other).i());
                }
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) h(j11)) + " and " + other);
            }

            public static String h(long j11) {
                return "ValueTimeMark(reading=" + j11 + ')';
            }

            @Override // java.lang.Comparable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compareTo(ComparableTimeMark comparableTimeMark) {
                return ComparableTimeMark.DefaultImpls.a(this, comparableTimeMark);
            }

            public boolean equals(Object obj) {
                return b(this.f69173a, obj);
            }

            @Override // kotlin.time.ComparableTimeMark
            public long g(ComparableTimeMark other) {
                Intrinsics.g(other, "other");
                return e(this.f69173a, other);
            }

            public int hashCode() {
                return c(this.f69173a);
            }

            public final /* synthetic */ long i() {
                return this.f69173a;
            }

            public String toString() {
                return h(this.f69173a);
            }
        }

        private Monotonic() {
        }

        public String toString() {
            return MonotonicTimeSource.f69168a.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @SinceKotlin
    @Metadata
    @WasExperimental
    public interface WithComparableMarks extends TimeSource {
    }
}
