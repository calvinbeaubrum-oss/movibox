package f10;

import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f64509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f64510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f64511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f64512d;

    public b(int i11, long j11, long j12, String str) {
        this.f64509a = i11;
        this.f64510b = j11;
        this.f64511c = j12;
        this.f64512d = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f64509a == bVar.f64509a && this.f64510b == bVar.f64510b && this.f64511c == bVar.f64511c && Intrinsics.b(this.f64512d, bVar.f64512d);
    }

    public int hashCode() {
        int iA = ((((this.f64509a * 31) + p.a(this.f64510b)) * 31) + p.a(this.f64511c)) * 31;
        String str = this.f64512d;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Chapter(index=" + this.f64509a + ", start=" + this.f64510b + ", end=" + this.f64511c + ", title=" + this.f64512d + ")";
    }
}
