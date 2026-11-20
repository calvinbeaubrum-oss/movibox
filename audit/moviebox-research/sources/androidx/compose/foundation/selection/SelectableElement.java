package androidx.compose.foundation.selection;

import androidx.compose.foundation.b0;
import androidx.compose.foundation.e;
import androidx.compose.ui.node.l0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
final class SelectableElement extends l0<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f2840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0 f2841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.compose.ui.semantics.i f2843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f2844g;

    public SelectableElement(boolean z11, i iVar, b0 b0Var, boolean z12, androidx.compose.ui.semantics.i iVar2, Function0<Unit> function0) {
        this.f2839b = z11;
        this.f2840c = iVar;
        this.f2841d = b0Var;
        this.f2842e = z12;
        this.f2843f = iVar2;
        this.f2844g = function0;
    }

    public /* synthetic */ SelectableElement(boolean z11, i iVar, b0 b0Var, boolean z12, androidx.compose.ui.semantics.i iVar2, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, iVar, b0Var, z12, iVar2, function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SelectableElement.class != obj.getClass()) {
            return false;
        }
        SelectableElement selectableElement = (SelectableElement) obj;
        return this.f2839b == selectableElement.f2839b && Intrinsics.b(this.f2840c, selectableElement.f2840c) && Intrinsics.b(this.f2841d, selectableElement.f2841d) && this.f2842e == selectableElement.f2842e && Intrinsics.b(this.f2843f, selectableElement.f2843f) && this.f2844g == selectableElement.f2844g;
    }

    public int hashCode() {
        int iA = e.a(this.f2839b) * 31;
        i iVar = this.f2840c;
        int iHashCode = (iA + (iVar != null ? iVar.hashCode() : 0)) * 31;
        b0 b0Var = this.f2841d;
        int iHashCode2 = (((iHashCode + (b0Var != null ? b0Var.hashCode() : 0)) * 31) + e.a(this.f2842e)) * 31;
        androidx.compose.ui.semantics.i iVar2 = this.f2843f;
        return ((iHashCode2 + (iVar2 != null ? androidx.compose.ui.semantics.i.l(iVar2.n()) : 0)) * 31) + this.f2844g.hashCode();
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public a a() {
        return new a(this.f2839b, this.f2840c, this.f2841d, this.f2842e, this.f2843f, this.f2844g, null);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(a aVar) {
        aVar.i2(this.f2839b, this.f2840c, this.f2841d, this.f2842e, this.f2843f, this.f2844g);
    }
}
