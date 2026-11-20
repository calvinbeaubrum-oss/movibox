package j00;

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
    public final String f67809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f67810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f67811c;

    public c(String subjectId, boolean z11, String str) {
        Intrinsics.g(subjectId, "subjectId");
        this.f67809a = subjectId;
        this.f67810b = z11;
        this.f67811c = str;
    }

    public final boolean a() {
        return this.f67810b;
    }

    public final String b() {
        return this.f67811c;
    }

    public final String c() {
        return this.f67809a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.b(this.f67809a, cVar.f67809a) && this.f67810b == cVar.f67810b && Intrinsics.b(this.f67811c, cVar.f67811c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = this.f67809a.hashCode() * 31;
        boolean z11 = this.f67810b;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode + r11) * 31;
        String str = this.f67811c;
        return i11 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FavoriteEvent(subjectId=" + this.f67809a + ", favorite=" + this.f67810b + ", favoriteNum=" + this.f67811c + ")";
    }
}
