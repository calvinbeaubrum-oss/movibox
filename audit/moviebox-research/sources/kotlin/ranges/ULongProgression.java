package kotlin.ranges;

import b20.e;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtilKt;
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
@SinceKotlin
@Metadata
@WasExperimental
public class ULongProgression implements Iterable<ULong>, KMappedMarker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f68986d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f68987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f68988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f68989c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ULongProgression(long j11, long j12, long j13) {
        if (j13 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j13 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f68987a = j11;
        this.f68988b = UProgressionUtilKt.c(j11, j12, j13);
        this.f68989c = j13;
    }

    public /* synthetic */ ULongProgression(long j11, long j12, long j13, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ULongProgression) {
            if (!isEmpty() || !((ULongProgression) obj).isEmpty()) {
                ULongProgression uLongProgression = (ULongProgression) obj;
                if (this.f68987a != uLongProgression.f68987a || this.f68988b != uLongProgression.f68988b || this.f68989c != uLongProgression.f68989c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long g() {
        return this.f68987a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j11 = this.f68987a;
        int iB = ((int) ULong.b(j11 ^ ULong.b(j11 >>> 32))) * 31;
        long j12 = this.f68988b;
        int iB2 = (iB + ((int) ULong.b(j12 ^ ULong.b(j12 >>> 32)))) * 31;
        long j13 = this.f68989c;
        return ((int) (j13 ^ (j13 >>> 32))) + iB2;
    }

    public final long i() {
        return this.f68988b;
    }

    public boolean isEmpty() {
        long j11 = this.f68989c;
        long j12 = this.f68987a;
        long j13 = this.f68988b;
        if (j11 > 0) {
            if (Long.compare(j12 ^ Long.MIN_VALUE, j13 ^ Long.MIN_VALUE) <= 0) {
                return false;
            }
        } else if (Long.compare(j12 ^ Long.MIN_VALUE, j13 ^ Long.MIN_VALUE) >= 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator<ULong> iterator() {
        return new e(this.f68987a, this.f68988b, this.f68989c, null);
    }

    public String toString() {
        StringBuilder sb2;
        long j11;
        if (this.f68989c > 0) {
            sb2 = new StringBuilder();
            sb2.append((Object) ULong.h(this.f68987a));
            sb2.append("..");
            sb2.append((Object) ULong.h(this.f68988b));
            sb2.append(" step ");
            j11 = this.f68989c;
        } else {
            sb2 = new StringBuilder();
            sb2.append((Object) ULong.h(this.f68987a));
            sb2.append(" downTo ");
            sb2.append((Object) ULong.h(this.f68988b));
            sb2.append(" step ");
            j11 = -this.f68989c;
        }
        sb2.append(j11);
        return sb2.toString();
    }
}
