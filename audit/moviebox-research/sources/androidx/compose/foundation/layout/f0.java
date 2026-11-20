package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.LayoutDirection;
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
public final class f0 implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f2494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f2495b;

    public f0(h0 h0Var, h0 h0Var2) {
        this.f2494a = h0Var;
        this.f2495b = h0Var2;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int a(q2.e eVar) {
        return Math.max(this.f2494a.a(eVar), this.f2495b.a(eVar));
    }

    @Override // androidx.compose.foundation.layout.h0
    public int b(q2.e eVar) {
        return Math.max(this.f2494a.b(eVar), this.f2495b.b(eVar));
    }

    @Override // androidx.compose.foundation.layout.h0
    public int c(q2.e eVar, LayoutDirection layoutDirection) {
        return Math.max(this.f2494a.c(eVar, layoutDirection), this.f2495b.c(eVar, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.h0
    public int d(q2.e eVar, LayoutDirection layoutDirection) {
        return Math.max(this.f2494a.d(eVar, layoutDirection), this.f2495b.d(eVar, layoutDirection));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return Intrinsics.b(f0Var.f2494a, this.f2494a) && Intrinsics.b(f0Var.f2495b, this.f2495b);
    }

    public int hashCode() {
        return this.f2494a.hashCode() + (this.f2495b.hashCode() * 31);
    }

    public String toString() {
        return '(' + this.f2494a + " ∪ " + this.f2495b + ')';
    }
}
