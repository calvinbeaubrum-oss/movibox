package androidx.compose.ui.text.input;

import kotlin.Metadata;

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
public final class b0 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5932b;

    public b0(int i11, int i12) {
        this.f5931a = i11;
        this.f5932b = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f5931a == b0Var.f5931a && this.f5932b == b0Var.f5932b;
    }

    public int hashCode() {
        return (this.f5931a * 31) + this.f5932b;
    }

    public String toString() {
        return "SetSelectionCommand(start=" + this.f5931a + ", end=" + this.f5932b + ')';
    }
}
