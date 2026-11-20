package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.z1;
import androidx.compose.ui.node.l0;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.style.p;
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
public final class TextStringSimpleElement extends l0<TextStringSimpleNode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0 f2912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.ui.text.font.i.b f2913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z1 f2918i;

    public TextStringSimpleElement(String str, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, int i11, boolean z11, int i12, int i13, z1 z1Var) {
        this.f2911b = str;
        this.f2912c = e0Var;
        this.f2913d = bVar;
        this.f2914e = i11;
        this.f2915f = z11;
        this.f2916g = i12;
        this.f2917h = i13;
        this.f2918i = z1Var;
    }

    public /* synthetic */ TextStringSimpleElement(String str, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, int i11, boolean z11, int i12, int i13, z1 z1Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, e0Var, bVar, i11, z11, i12, i13, z1Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStringSimpleElement)) {
            return false;
        }
        TextStringSimpleElement textStringSimpleElement = (TextStringSimpleElement) obj;
        return Intrinsics.b(this.f2918i, textStringSimpleElement.f2918i) && Intrinsics.b(this.f2911b, textStringSimpleElement.f2911b) && Intrinsics.b(this.f2912c, textStringSimpleElement.f2912c) && Intrinsics.b(this.f2913d, textStringSimpleElement.f2913d) && p.e(this.f2914e, textStringSimpleElement.f2914e) && this.f2915f == textStringSimpleElement.f2915f && this.f2916g == textStringSimpleElement.f2916g && this.f2917h == textStringSimpleElement.f2917h;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.f2911b.hashCode() * 31) + this.f2912c.hashCode()) * 31) + this.f2913d.hashCode()) * 31) + p.f(this.f2914e)) * 31) + androidx.compose.foundation.e.a(this.f2915f)) * 31) + this.f2916g) * 31) + this.f2917h) * 31;
        z1 z1Var = this.f2918i;
        return iHashCode + (z1Var != null ? z1Var.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public TextStringSimpleNode a() {
        return new TextStringSimpleNode(this.f2911b, this.f2912c, this.f2913d, this.f2914e, this.f2915f, this.f2916g, this.f2917h, this.f2918i, null);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(TextStringSimpleNode textStringSimpleNode) {
        textStringSimpleNode.P1(textStringSimpleNode.U1(this.f2918i, this.f2912c), textStringSimpleNode.W1(this.f2911b), textStringSimpleNode.V1(this.f2912c, this.f2917h, this.f2916g, this.f2915f, this.f2913d, this.f2914e));
    }
}
