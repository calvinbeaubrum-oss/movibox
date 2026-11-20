package kotlin.ranges;

import b20.d;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
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
public class UIntProgression implements Iterable<UInt>, KMappedMarker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f68980d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f68981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f68982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f68983c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UIntProgression(int i11, int i12, int i13) {
        if (i13 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i13 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f68981a = i11;
        this.f68982b = UProgressionUtilKt.d(i11, i12, i13);
        this.f68983c = i13;
    }

    public /* synthetic */ UIntProgression(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, i13);
    }

    public boolean equals(Object obj) {
        if (obj instanceof UIntProgression) {
            if (!isEmpty() || !((UIntProgression) obj).isEmpty()) {
                UIntProgression uIntProgression = (UIntProgression) obj;
                if (this.f68981a != uIntProgression.f68981a || this.f68982b != uIntProgression.f68982b || this.f68983c != uIntProgression.f68983c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g() {
        return this.f68981a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f68981a * 31) + this.f68982b) * 31) + this.f68983c;
    }

    public final int i() {
        return this.f68982b;
    }

    public boolean isEmpty() {
        if (this.f68983c > 0) {
            if (Integer.compare(this.f68981a ^ Integer.MIN_VALUE, this.f68982b ^ Integer.MIN_VALUE) <= 0) {
                return false;
            }
        } else if (Integer.compare(this.f68981a ^ Integer.MIN_VALUE, this.f68982b ^ Integer.MIN_VALUE) >= 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator<UInt> iterator() {
        return new d(this.f68981a, this.f68982b, this.f68983c, null);
    }

    public String toString() {
        StringBuilder sb2;
        int i11;
        if (this.f68983c > 0) {
            sb2 = new StringBuilder();
            sb2.append((Object) UInt.e(this.f68981a));
            sb2.append("..");
            sb2.append((Object) UInt.e(this.f68982b));
            sb2.append(" step ");
            i11 = this.f68983c;
        } else {
            sb2 = new StringBuilder();
            sb2.append((Object) UInt.e(this.f68981a));
            sb2.append(" downTo ");
            sb2.append((Object) UInt.e(this.f68982b));
            sb2.append(" step ");
            i11 = -this.f68983c;
        }
        sb2.append(i11);
        return sb2.toString();
    }
}
