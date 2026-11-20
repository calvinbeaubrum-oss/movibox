package kotlin.time;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DurationUnit f69154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f69155b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements ComparableTimeMark {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f69156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractLongTimeSource f69157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f69158c;

        public a(long j11, AbstractLongTimeSource timeSource, long j12) {
            Intrinsics.g(timeSource, "timeSource");
            this.f69156a = j11;
            this.f69157b = timeSource;
            this.f69158c = j12;
        }

        public /* synthetic */ a(long j11, AbstractLongTimeSource abstractLongTimeSource, long j12, DefaultConstructorMarker defaultConstructorMarker) {
            this(j11, abstractLongTimeSource, j12);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.a(this, comparableTimeMark);
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && Intrinsics.b(this.f69157b, ((a) obj).f69157b) && Duration.l(g((ComparableTimeMark) obj), Duration.f69159b.c());
        }

        @Override // kotlin.time.ComparableTimeMark
        public long g(ComparableTimeMark other) {
            Intrinsics.g(other, "other");
            if (other instanceof a) {
                a aVar = (a) other;
                if (Intrinsics.b(this.f69157b, aVar.f69157b)) {
                    return Duration.E(LongSaturatedMathKt.c(this.f69156a, aVar.f69156a, this.f69157b.b()), Duration.D(this.f69158c, aVar.f69158c));
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        public int hashCode() {
            return (Duration.x(this.f69158c) * 37) + p.a(this.f69156a);
        }

        public String toString() {
            return "LongTimeMark(" + this.f69156a + DurationUnitKt__DurationUnitKt.c(this.f69157b.b()) + " + " + ((Object) Duration.G(this.f69158c)) + ", " + this.f69157b + ')';
        }
    }

    public AbstractLongTimeSource(DurationUnit unit) {
        Intrinsics.g(unit, "unit");
        this.f69154a = unit;
        this.f69155b = LazyKt__LazyJVMKt.b(new Function0<Long>() { // from class: kotlin.time.AbstractLongTimeSource$zero$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(this.this$0.e());
            }
        });
    }

    public final long a() {
        return e() - c();
    }

    public final DurationUnit b() {
        return this.f69154a;
    }

    public final long c() {
        return ((Number) this.f69155b.getValue()).longValue();
    }

    public ComparableTimeMark d() {
        return new a(a(), this, Duration.f69159b.c(), null);
    }

    public abstract long e();
}
