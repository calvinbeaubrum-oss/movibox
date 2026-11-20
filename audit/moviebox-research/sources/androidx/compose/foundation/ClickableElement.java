package androidx.compose.foundation;

import androidx.compose.ui.node.l0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
final class ClickableElement extends l0<ClickableNode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o1.i f2207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f2208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.compose.ui.semantics.i f2211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f2212g;

    public ClickableElement(o1.i iVar, b0 b0Var, boolean z11, String str, androidx.compose.ui.semantics.i iVar2, Function0<Unit> function0) {
        this.f2207b = iVar;
        this.f2208c = b0Var;
        this.f2209d = z11;
        this.f2210e = str;
        this.f2211f = iVar2;
        this.f2212g = function0;
    }

    public /* synthetic */ ClickableElement(o1.i iVar, b0 b0Var, boolean z11, String str, androidx.compose.ui.semantics.i iVar2, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(iVar, b0Var, z11, str, iVar2, function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ClickableElement.class != obj.getClass()) {
            return false;
        }
        ClickableElement clickableElement = (ClickableElement) obj;
        return Intrinsics.b(this.f2207b, clickableElement.f2207b) && Intrinsics.b(this.f2208c, clickableElement.f2208c) && this.f2209d == clickableElement.f2209d && Intrinsics.b(this.f2210e, clickableElement.f2210e) && Intrinsics.b(this.f2211f, clickableElement.f2211f) && this.f2212g == clickableElement.f2212g;
    }

    public int hashCode() {
        o1.i iVar = this.f2207b;
        int iHashCode = (iVar != null ? iVar.hashCode() : 0) * 31;
        b0 b0Var = this.f2208c;
        int iHashCode2 = (((iHashCode + (b0Var != null ? b0Var.hashCode() : 0)) * 31) + e.a(this.f2209d)) * 31;
        String str = this.f2210e;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        androidx.compose.ui.semantics.i iVar2 = this.f2211f;
        return ((iHashCode3 + (iVar2 != null ? androidx.compose.ui.semantics.i.l(iVar2.n()) : 0)) * 31) + this.f2212g.hashCode();
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public ClickableNode a() {
        return new ClickableNode(this.f2207b, this.f2208c, this.f2209d, this.f2210e, this.f2211f, this.f2212g, null);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(ClickableNode clickableNode) {
        clickableNode.h2(this.f2207b, this.f2208c, this.f2209d, this.f2210e, this.f2211f, this.f2212g);
    }
}
