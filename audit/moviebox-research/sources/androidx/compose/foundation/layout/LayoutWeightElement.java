package androidx.compose.foundation.layout;

import androidx.compose.ui.node.l0;
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
public final class LayoutWeightElement extends l0<s> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2400c;

    public LayoutWeightElement(float f11, boolean z11) {
        this.f2399b = f11;
        this.f2400c = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        LayoutWeightElement layoutWeightElement = obj instanceof LayoutWeightElement ? (LayoutWeightElement) obj : null;
        return layoutWeightElement != null && this.f2399b == layoutWeightElement.f2399b && this.f2400c == layoutWeightElement.f2400c;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f2399b) * 31) + androidx.compose.foundation.e.a(this.f2400c);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public s a() {
        return new s(this.f2399b, this.f2400c);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(s sVar) {
        sVar.J1(this.f2399b);
        sVar.I1(this.f2400c);
    }
}
