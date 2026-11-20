package kotlin;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import v10.c;

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
public final class KotlinVersion implements Comparable<KotlinVersion> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f68681f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public static final KotlinVersion f68682g = c.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f68683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f68684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f68685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f68686d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KotlinVersion(int i11, int i12, int i13) {
        this.f68683a = i11;
        this.f68684b = i12;
        this.f68685c = i13;
        this.f68686d = b(i11, i12, i13);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(KotlinVersion other) {
        Intrinsics.g(other, "other");
        return this.f68686d - other.f68686d;
    }

    public final int b(int i11, int i12, int i13) {
        if (new IntRange(0, 255).v(i11) && new IntRange(0, 255).v(i12) && new IntRange(0, 255).v(i13)) {
            return (i11 << 16) + (i12 << 8) + i13;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i11 + '.' + i12 + '.' + i13).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        KotlinVersion kotlinVersion = obj instanceof KotlinVersion ? (KotlinVersion) obj : null;
        return kotlinVersion != null && this.f68686d == kotlinVersion.f68686d;
    }

    public int hashCode() {
        return this.f68686d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f68683a);
        sb2.append('.');
        sb2.append(this.f68684b);
        sb2.append('.');
        sb2.append(this.f68685c);
        return sb2.toString();
    }
}
