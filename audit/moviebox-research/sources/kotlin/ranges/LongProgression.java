package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.LongIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

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
@Metadata
public class LongProgression implements Iterable<Long>, KMappedMarker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f68970d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f68971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f68972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f68973c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LongProgression(long j11, long j12, long j13) {
        if (j13 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j13 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f68971a = j11;
        this.f68972b = ProgressionUtilKt.d(j11, j12, j13);
        this.f68973c = j13;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LongProgression) {
            if (!isEmpty() || !((LongProgression) obj).isEmpty()) {
                LongProgression longProgression = (LongProgression) obj;
                if (this.f68971a != longProgression.f68971a || this.f68972b != longProgression.f68972b || this.f68973c != longProgression.f68973c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long g() {
        return this.f68971a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j11 = 31;
        long j12 = this.f68971a;
        long j13 = this.f68972b;
        long j14 = j11 * (((j12 ^ (j12 >>> 32)) * j11) + (j13 ^ (j13 >>> 32)));
        long j15 = this.f68973c;
        return (int) (j14 + (j15 ^ (j15 >>> 32)));
    }

    public final long i() {
        return this.f68972b;
    }

    public boolean isEmpty() {
        long j11 = this.f68973c;
        long j12 = this.f68971a;
        long j13 = this.f68972b;
        if (j11 > 0) {
            if (j12 <= j13) {
                return false;
            }
        } else if (j12 >= j13) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public LongIterator iterator() {
        return new LongProgressionIterator(this.f68971a, this.f68972b, this.f68973c);
    }

    public String toString() {
        StringBuilder sb2;
        long j11;
        if (this.f68973c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f68971a);
            sb2.append("..");
            sb2.append(this.f68972b);
            sb2.append(" step ");
            j11 = this.f68973c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f68971a);
            sb2.append(" downTo ");
            sb2.append(this.f68972b);
            sb2.append(" step ");
            j11 = -this.f68973c;
        }
        sb2.append(j11);
        return sb2.toString();
    }
}
