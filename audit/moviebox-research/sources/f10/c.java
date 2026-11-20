package f10;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f64513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f64515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f64516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f64517e;

    public c(int i11, String str, String codecName, String str2, int i12) {
        Intrinsics.g(codecName, "codecName");
        this.f64513a = i11;
        this.f64514b = str;
        this.f64515c = codecName;
        this.f64516d = str2;
        this.f64517e = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f64513a == cVar.f64513a && Intrinsics.b(this.f64514b, cVar.f64514b) && Intrinsics.b(this.f64515c, cVar.f64515c) && Intrinsics.b(this.f64516d, cVar.f64516d) && this.f64517e == cVar.f64517e;
    }

    public int hashCode() {
        int i11 = this.f64513a * 31;
        String str = this.f64514b;
        int iHashCode = (((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.f64515c.hashCode()) * 31;
        String str2 = this.f64516d;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f64517e;
    }

    public String toString() {
        return "SubtitleStream(index=" + this.f64513a + ", title=" + this.f64514b + ", codecName=" + this.f64515c + ", language=" + this.f64516d + ", disposition=" + this.f64517e + ")";
    }
}
