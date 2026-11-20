package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.IntIterator;
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
public class IntProgression implements Iterable<Integer>, KMappedMarker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f68960d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f68961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f68962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f68963c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntProgression a(int i11, int i12, int i13) {
            return new IntProgression(i11, i12, i13);
        }
    }

    public IntProgression(int i11, int i12, int i13) {
        if (i13 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i13 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f68961a = i11;
        this.f68962b = ProgressionUtilKt.c(i11, i12, i13);
        this.f68963c = i13;
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntProgression) {
            if (!isEmpty() || !((IntProgression) obj).isEmpty()) {
                IntProgression intProgression = (IntProgression) obj;
                if (this.f68961a != intProgression.f68961a || this.f68962b != intProgression.f68962b || this.f68963c != intProgression.f68963c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g() {
        return this.f68961a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f68961a * 31) + this.f68962b) * 31) + this.f68963c;
    }

    public final int i() {
        return this.f68962b;
    }

    public boolean isEmpty() {
        if (this.f68963c > 0) {
            if (this.f68961a <= this.f68962b) {
                return false;
            }
        } else if (this.f68961a >= this.f68962b) {
            return false;
        }
        return true;
    }

    public final int r() {
        return this.f68963c;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public IntIterator iterator() {
        return new IntProgressionIterator(this.f68961a, this.f68962b, this.f68963c);
    }

    public String toString() {
        StringBuilder sb2;
        int i11;
        if (this.f68963c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f68961a);
            sb2.append("..");
            sb2.append(this.f68962b);
            sb2.append(" step ");
            i11 = this.f68963c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f68961a);
            sb2.append(" downTo ");
            sb2.append(this.f68962b);
            sb2.append(" step ");
            i11 = -this.f68963c;
        }
        sb2.append(i11);
        return sb2.toString();
    }
}
