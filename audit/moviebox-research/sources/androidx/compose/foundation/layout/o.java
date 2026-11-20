package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.LayoutDirection;
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
public final class o implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2516d;

    public o(int i11, int i12, int i13, int i14) {
        this.f2513a = i11;
        this.f2514b = i12;
        this.f2515c = i13;
        this.f2516d = i14;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int a(q2.e eVar) {
        return this.f2516d;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int b(q2.e eVar) {
        return this.f2514b;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int c(q2.e eVar, LayoutDirection layoutDirection) {
        return this.f2513a;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int d(q2.e eVar, LayoutDirection layoutDirection) {
        return this.f2515c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f2513a == oVar.f2513a && this.f2514b == oVar.f2514b && this.f2515c == oVar.f2515c && this.f2516d == oVar.f2516d;
    }

    public int hashCode() {
        return (((((this.f2513a * 31) + this.f2514b) * 31) + this.f2515c) * 31) + this.f2516d;
    }

    public String toString() {
        return "Insets(left=" + this.f2513a + ", top=" + this.f2514b + ", right=" + this.f2515c + ", bottom=" + this.f2516d + ')';
    }
}
