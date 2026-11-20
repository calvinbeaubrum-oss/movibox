package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public class CharProgression implements Iterable<Character>, KMappedMarker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f68950d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f68951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f68952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f68953c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CharProgression(char c11, char c12, int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i11 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f68951a = c11;
        this.f68952b = (char) ProgressionUtilKt.c(c11, c12, i11);
        this.f68953c = i11;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CharProgression) {
            if (!isEmpty() || !((CharProgression) obj).isEmpty()) {
                CharProgression charProgression = (CharProgression) obj;
                if (this.f68951a != charProgression.f68951a || this.f68952b != charProgression.f68952b || this.f68953c != charProgression.f68953c) {
                }
            }
            return true;
        }
        return false;
    }

    public final char g() {
        return this.f68951a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f68951a * 31) + this.f68952b) * 31) + this.f68953c;
    }

    public final char i() {
        return this.f68952b;
    }

    public boolean isEmpty() {
        if (this.f68953c > 0) {
            if (Intrinsics.i(this.f68951a, this.f68952b) <= 0) {
                return false;
            }
        } else if (Intrinsics.i(this.f68951a, this.f68952b) >= 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public CharIterator iterator() {
        return new CharProgressionIterator(this.f68951a, this.f68952b, this.f68953c);
    }

    public String toString() {
        StringBuilder sb2;
        int i11;
        if (this.f68953c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f68951a);
            sb2.append("..");
            sb2.append(this.f68952b);
            sb2.append(" step ");
            i11 = this.f68953c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f68951a);
            sb2.append(" downTo ");
            sb2.append(this.f68952b);
            sb2.append(" step ");
            i11 = -this.f68953c;
        }
        sb2.append(i11);
        return sb2.toString();
    }
}
