package androidx.compose.foundation.selection;

import androidx.compose.foundation.b0;
import androidx.compose.foundation.e;
import androidx.compose.ui.node.l0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o1.i;

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
final class ToggleableElement extends l0<ToggleableNode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f2846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0 f2847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.compose.ui.semantics.i f2849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<Boolean, Unit> f2850g;

    /* JADX WARN: Multi-variable type inference failed */
    public ToggleableElement(boolean z11, i iVar, b0 b0Var, boolean z12, androidx.compose.ui.semantics.i iVar2, Function1<? super Boolean, Unit> function1) {
        this.f2845b = z11;
        this.f2846c = iVar;
        this.f2847d = b0Var;
        this.f2848e = z12;
        this.f2849f = iVar2;
        this.f2850g = function1;
    }

    public /* synthetic */ ToggleableElement(boolean z11, i iVar, b0 b0Var, boolean z12, androidx.compose.ui.semantics.i iVar2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, iVar, b0Var, z12, iVar2, function1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ToggleableElement.class != obj.getClass()) {
            return false;
        }
        ToggleableElement toggleableElement = (ToggleableElement) obj;
        return this.f2845b == toggleableElement.f2845b && Intrinsics.b(this.f2846c, toggleableElement.f2846c) && Intrinsics.b(this.f2847d, toggleableElement.f2847d) && this.f2848e == toggleableElement.f2848e && Intrinsics.b(this.f2849f, toggleableElement.f2849f) && this.f2850g == toggleableElement.f2850g;
    }

    public int hashCode() {
        int iA = e.a(this.f2845b) * 31;
        i iVar = this.f2846c;
        int iHashCode = (iA + (iVar != null ? iVar.hashCode() : 0)) * 31;
        b0 b0Var = this.f2847d;
        int iHashCode2 = (((iHashCode + (b0Var != null ? b0Var.hashCode() : 0)) * 31) + e.a(this.f2848e)) * 31;
        androidx.compose.ui.semantics.i iVar2 = this.f2849f;
        return ((iHashCode2 + (iVar2 != null ? androidx.compose.ui.semantics.i.l(iVar2.n()) : 0)) * 31) + this.f2850g.hashCode();
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public ToggleableNode a() {
        return new ToggleableNode(this.f2845b, this.f2846c, this.f2847d, this.f2848e, this.f2849f, this.f2850g, null);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(ToggleableNode toggleableNode) {
        toggleableNode.k2(this.f2845b, this.f2846c, this.f2847d, this.f2848e, this.f2849f, this.f2850g);
    }
}
