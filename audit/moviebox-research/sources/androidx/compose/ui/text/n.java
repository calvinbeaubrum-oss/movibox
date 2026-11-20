package androidx.compose.ui.text;

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
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f5996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5998c;

    public n(o oVar, int i11, int i12) {
        this.f5996a = oVar;
        this.f5997b = i11;
        this.f5998c = i12;
    }

    public final int a() {
        return this.f5998c;
    }

    public final o b() {
        return this.f5996a;
    }

    public final int c() {
        return this.f5997b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Intrinsics.b(this.f5996a, nVar.f5996a) && this.f5997b == nVar.f5997b && this.f5998c == nVar.f5998c;
    }

    public int hashCode() {
        return (((this.f5996a.hashCode() * 31) + this.f5997b) * 31) + this.f5998c;
    }

    public String toString() {
        return "ParagraphIntrinsicInfo(intrinsics=" + this.f5996a + ", startIndex=" + this.f5997b + ", endIndex=" + this.f5998c + ')';
    }
}
