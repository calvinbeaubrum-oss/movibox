package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
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
public final class a0 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnnotatedString f5929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5930b;

    public a0(AnnotatedString annotatedString, int i11) {
        this.f5929a = annotatedString;
        this.f5930b = i11;
    }

    public a0(String str, int i11) {
        this(new AnnotatedString(str, null, null, 6, null), i11);
    }

    public final String a() {
        return this.f5929a.i();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Intrinsics.b(a(), a0Var.a()) && this.f5930b == a0Var.f5930b;
    }

    public int hashCode() {
        return (a().hashCode() * 31) + this.f5930b;
    }

    public String toString() {
        return "SetComposingTextCommand(text='" + a() + "', newCursorPosition=" + this.f5930b + ')';
    }
}
