package androidx.compose.foundation.selection;

import androidx.compose.foundation.b0;
import androidx.compose.foundation.e;
import androidx.compose.ui.node.l0;
import androidx.compose.ui.state.ToggleableState;
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
final class TriStateToggleableElement extends l0<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ToggleableState f2851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f2852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0 f2853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.compose.ui.semantics.i f2855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f2856g;

    public TriStateToggleableElement(ToggleableState toggleableState, i iVar, b0 b0Var, boolean z11, androidx.compose.ui.semantics.i iVar2, Function0<Unit> function0) {
        this.f2851b = toggleableState;
        this.f2852c = iVar;
        this.f2853d = b0Var;
        this.f2854e = z11;
        this.f2855f = iVar2;
        this.f2856g = function0;
    }

    public /* synthetic */ TriStateToggleableElement(ToggleableState toggleableState, i iVar, b0 b0Var, boolean z11, androidx.compose.ui.semantics.i iVar2, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(toggleableState, iVar, b0Var, z11, iVar2, function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TriStateToggleableElement.class != obj.getClass()) {
            return false;
        }
        TriStateToggleableElement triStateToggleableElement = (TriStateToggleableElement) obj;
        return this.f2851b == triStateToggleableElement.f2851b && Intrinsics.b(this.f2852c, triStateToggleableElement.f2852c) && Intrinsics.b(this.f2853d, triStateToggleableElement.f2853d) && this.f2854e == triStateToggleableElement.f2854e && Intrinsics.b(this.f2855f, triStateToggleableElement.f2855f) && this.f2856g == triStateToggleableElement.f2856g;
    }

    public int hashCode() {
        int iHashCode = this.f2851b.hashCode() * 31;
        i iVar = this.f2852c;
        int iHashCode2 = (iHashCode + (iVar != null ? iVar.hashCode() : 0)) * 31;
        b0 b0Var = this.f2853d;
        int iHashCode3 = (((iHashCode2 + (b0Var != null ? b0Var.hashCode() : 0)) * 31) + e.a(this.f2854e)) * 31;
        androidx.compose.ui.semantics.i iVar2 = this.f2855f;
        return ((iHashCode3 + (iVar2 != null ? androidx.compose.ui.semantics.i.l(iVar2.n()) : 0)) * 31) + this.f2856g.hashCode();
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public b a() {
        return new b(this.f2851b, this.f2852c, this.f2853d, this.f2854e, this.f2855f, this.f2856g, null);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(b bVar) {
        bVar.i2(this.f2851b, this.f2852c, this.f2853d, this.f2854e, this.f2855f, this.f2856g);
    }
}
