package androidx.compose.foundation;

import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.node.l0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class BorderModifierNodeElement extends l0<BorderModifierNode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l1 f2205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c5 f2206d;

    public BorderModifierNodeElement(float f11, l1 l1Var, c5 c5Var) {
        this.f2204b = f11;
        this.f2205c = l1Var;
        this.f2206d = c5Var;
    }

    public /* synthetic */ BorderModifierNodeElement(float f11, l1 l1Var, c5 c5Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, l1Var, c5Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderModifierNodeElement)) {
            return false;
        }
        BorderModifierNodeElement borderModifierNodeElement = (BorderModifierNodeElement) obj;
        return q2.i.j(this.f2204b, borderModifierNodeElement.f2204b) && Intrinsics.b(this.f2205c, borderModifierNodeElement.f2205c) && Intrinsics.b(this.f2206d, borderModifierNodeElement.f2206d);
    }

    public int hashCode() {
        return (((q2.i.k(this.f2204b) * 31) + this.f2205c.hashCode()) * 31) + this.f2206d.hashCode();
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public BorderModifierNode a() {
        return new BorderModifierNode(this.f2204b, this.f2205c, this.f2206d, null);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(BorderModifierNode borderModifierNode) {
        borderModifierNode.V1(this.f2204b);
        borderModifierNode.U1(this.f2205c);
        borderModifierNode.K0(this.f2206d);
    }

    public String toString() {
        return "BorderModifierNodeElement(width=" + ((Object) q2.i.l(this.f2204b)) + ", brush=" + this.f2205c + ", shape=" + this.f2206d + ')';
    }
}
