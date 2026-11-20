package s6;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f76180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f76181b;

    public m(String workSpecId, int i11) {
        Intrinsics.g(workSpecId, "workSpecId");
        this.f76180a = workSpecId;
        this.f76181b = i11;
    }

    public final int a() {
        return this.f76181b;
    }

    public final String b() {
        return this.f76180a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return Intrinsics.b(this.f76180a, mVar.f76180a) && this.f76181b == mVar.f76181b;
    }

    public int hashCode() {
        return (this.f76180a.hashCode() * 31) + this.f76181b;
    }

    public String toString() {
        return "WorkGenerationalId(workSpecId=" + this.f76180a + ", generation=" + this.f76181b + ')';
    }
}
