package androidx.compose.ui.input.pointer;

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
public final class PointerHoverIconModifierElement extends androidx.compose.ui.node.l0<PointerHoverIconModifierNode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f4634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4635c;

    public PointerHoverIconModifierElement(u uVar, boolean z11) {
        this.f4634b = uVar;
        this.f4635c = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointerHoverIconModifierElement)) {
            return false;
        }
        PointerHoverIconModifierElement pointerHoverIconModifierElement = (PointerHoverIconModifierElement) obj;
        return Intrinsics.b(this.f4634b, pointerHoverIconModifierElement.f4634b) && this.f4635c == pointerHoverIconModifierElement.f4635c;
    }

    public int hashCode() {
        return (this.f4634b.hashCode() * 31) + androidx.compose.foundation.e.a(this.f4635c);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointerHoverIconModifierNode a() {
        return new PointerHoverIconModifierNode(this.f4634b, this.f4635c);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(PointerHoverIconModifierNode pointerHoverIconModifierNode) {
        pointerHoverIconModifierNode.U1(this.f4634b);
        pointerHoverIconModifierNode.V1(this.f4635c);
    }

    public String toString() {
        return "PointerHoverIconModifierElement(icon=" + this.f4634b + ", overrideDescendants=" + this.f4635c + ')';
    }
}
