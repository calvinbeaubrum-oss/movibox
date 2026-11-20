package s6;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final String f76170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f76171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final int f76172c;

    public i(String workSpecId, int i11, int i12) {
        Intrinsics.g(workSpecId, "workSpecId");
        this.f76170a = workSpecId;
        this.f76171b = i11;
        this.f76172c = i12;
    }

    public final int a() {
        return this.f76171b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.b(this.f76170a, iVar.f76170a) && this.f76171b == iVar.f76171b && this.f76172c == iVar.f76172c;
    }

    public int hashCode() {
        return (((this.f76170a.hashCode() * 31) + this.f76171b) * 31) + this.f76172c;
    }

    public String toString() {
        return "SystemIdInfo(workSpecId=" + this.f76170a + ", generation=" + this.f76171b + ", systemId=" + this.f76172c + ')';
    }
}
