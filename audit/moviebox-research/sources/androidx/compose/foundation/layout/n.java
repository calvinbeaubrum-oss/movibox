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
public final class n implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f2511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f2512b;

    public n(h0 h0Var, h0 h0Var2) {
        this.f2511a = h0Var;
        this.f2512b = h0Var2;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int a(q2.e eVar) {
        return kotlin.ranges.a.d(this.f2511a.a(eVar) - this.f2512b.a(eVar), 0);
    }

    @Override // androidx.compose.foundation.layout.h0
    public int b(q2.e eVar) {
        return kotlin.ranges.a.d(this.f2511a.b(eVar) - this.f2512b.b(eVar), 0);
    }

    @Override // androidx.compose.foundation.layout.h0
    public int c(q2.e eVar, LayoutDirection layoutDirection) {
        return kotlin.ranges.a.d(this.f2511a.c(eVar, layoutDirection) - this.f2512b.c(eVar, layoutDirection), 0);
    }

    @Override // androidx.compose.foundation.layout.h0
    public int d(q2.e eVar, LayoutDirection layoutDirection) {
        return kotlin.ranges.a.d(this.f2511a.d(eVar, layoutDirection) - this.f2512b.d(eVar, layoutDirection), 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Intrinsics.b(nVar.f2511a, this.f2511a) && Intrinsics.b(nVar.f2512b, this.f2512b);
    }

    public int hashCode() {
        return (this.f2511a.hashCode() * 31) + this.f2512b.hashCode();
    }

    public String toString() {
        return '(' + this.f2511a + " - " + this.f2512b + ')';
    }
}
