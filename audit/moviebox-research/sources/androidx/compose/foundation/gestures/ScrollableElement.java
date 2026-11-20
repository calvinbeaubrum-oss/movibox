package androidx.compose.foundation.gestures;

import androidx.compose.foundation.f0;
import androidx.compose.ui.node.l0;
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
final class ScrollableElement extends l0<ScrollableNode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f2320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Orientation f2321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f0 f2322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f2325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o1.i f2326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f2327i;

    public ScrollableElement(o oVar, Orientation orientation, f0 f0Var, boolean z11, boolean z12, g gVar, o1.i iVar, d dVar) {
        this.f2320b = oVar;
        this.f2321c = orientation;
        this.f2322d = f0Var;
        this.f2323e = z11;
        this.f2324f = z12;
        this.f2325g = gVar;
        this.f2326h = iVar;
        this.f2327i = dVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScrollableElement)) {
            return false;
        }
        ScrollableElement scrollableElement = (ScrollableElement) obj;
        return Intrinsics.b(this.f2320b, scrollableElement.f2320b) && this.f2321c == scrollableElement.f2321c && Intrinsics.b(this.f2322d, scrollableElement.f2322d) && this.f2323e == scrollableElement.f2323e && this.f2324f == scrollableElement.f2324f && Intrinsics.b(this.f2325g, scrollableElement.f2325g) && Intrinsics.b(this.f2326h, scrollableElement.f2326h) && Intrinsics.b(this.f2327i, scrollableElement.f2327i);
    }

    public int hashCode() {
        int iHashCode = ((this.f2320b.hashCode() * 31) + this.f2321c.hashCode()) * 31;
        f0 f0Var = this.f2322d;
        int iHashCode2 = (((((iHashCode + (f0Var != null ? f0Var.hashCode() : 0)) * 31) + androidx.compose.foundation.e.a(this.f2323e)) * 31) + androidx.compose.foundation.e.a(this.f2324f)) * 31;
        g gVar = this.f2325g;
        int iHashCode3 = (iHashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
        o1.i iVar = this.f2326h;
        int iHashCode4 = (iHashCode3 + (iVar != null ? iVar.hashCode() : 0)) * 31;
        d dVar = this.f2327i;
        return iHashCode4 + (dVar != null ? dVar.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public ScrollableNode a() {
        return new ScrollableNode(this.f2320b, this.f2322d, this.f2325g, this.f2321c, this.f2323e, this.f2324f, this.f2326h, this.f2327i);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(ScrollableNode scrollableNode) {
        scrollableNode.o2(this.f2320b, this.f2321c, this.f2322d, this.f2323e, this.f2324f, this.f2325g, this.f2326h, this.f2327i);
    }
}
