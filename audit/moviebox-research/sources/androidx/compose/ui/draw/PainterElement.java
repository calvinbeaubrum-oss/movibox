package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.node.a0;
import androidx.compose.ui.node.l0;
import androidx.compose.ui.node.o;
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
final class PainterElement extends l0<PainterNode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Painter f3834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.ui.b f3836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.compose.ui.layout.f f3837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f3838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x1 f3839g;

    public PainterElement(Painter painter, boolean z11, androidx.compose.ui.b bVar, androidx.compose.ui.layout.f fVar, float f11, x1 x1Var) {
        this.f3834b = painter;
        this.f3835c = z11;
        this.f3836d = bVar;
        this.f3837e = fVar;
        this.f3838f = f11;
        this.f3839g = x1Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PainterElement)) {
            return false;
        }
        PainterElement painterElement = (PainterElement) obj;
        return Intrinsics.b(this.f3834b, painterElement.f3834b) && this.f3835c == painterElement.f3835c && Intrinsics.b(this.f3836d, painterElement.f3836d) && Intrinsics.b(this.f3837e, painterElement.f3837e) && Float.compare(this.f3838f, painterElement.f3838f) == 0 && Intrinsics.b(this.f3839g, painterElement.f3839g);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.f3834b.hashCode() * 31) + androidx.compose.foundation.e.a(this.f3835c)) * 31) + this.f3836d.hashCode()) * 31) + this.f3837e.hashCode()) * 31) + Float.floatToIntBits(this.f3838f)) * 31;
        x1 x1Var = this.f3839g;
        return iHashCode + (x1Var == null ? 0 : x1Var.hashCode());
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public PainterNode a() {
        return new PainterNode(this.f3834b, this.f3835c, this.f3836d, this.f3837e, this.f3838f, this.f3839g);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(PainterNode painterNode) {
        boolean zJ1 = painterNode.J1();
        boolean z11 = this.f3835c;
        boolean z12 = zJ1 != z11 || (z11 && !y1.m.f(painterNode.I1().h(), this.f3834b.h()));
        painterNode.R1(this.f3834b);
        painterNode.S1(this.f3835c);
        painterNode.O1(this.f3836d);
        painterNode.Q1(this.f3837e);
        painterNode.setAlpha(this.f3838f);
        painterNode.P1(this.f3839g);
        if (z12) {
            a0.b(painterNode);
        }
        o.a(painterNode);
    }

    public String toString() {
        return "PainterElement(painter=" + this.f3834b + ", sizeToIntrinsics=" + this.f3835c + ", alignment=" + this.f3836d + ", contentScale=" + this.f3837e + ", alpha=" + this.f3838f + ", colorFilter=" + this.f3839g + ')';
    }
}
