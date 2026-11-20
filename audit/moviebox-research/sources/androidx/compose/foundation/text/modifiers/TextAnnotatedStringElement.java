package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.z1;
import androidx.compose.ui.node.l0;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.a0;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.style.p;
import androidx.compose.ui.text.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class TextAnnotatedStringElement extends l0<TextAnnotatedStringNode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnnotatedString f2882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0 f2883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.ui.text.font.i.b f2884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<a0, Unit> f2885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f2889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<AnnotatedString.b<t>> f2890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<List<y1.i>, Unit> f2891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SelectionController f2892l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final z1 f2893m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function1<TextAnnotatedStringNode.a, Unit> f2894n;

    /* JADX WARN: Multi-variable type inference failed */
    public TextAnnotatedStringElement(AnnotatedString annotatedString, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, Function1<? super a0, Unit> function1, int i11, boolean z11, int i12, int i13, List<AnnotatedString.b<t>> list, Function1<? super List<y1.i>, Unit> function2, SelectionController selectionController, z1 z1Var, Function1<? super TextAnnotatedStringNode.a, Unit> function3) {
        this.f2882b = annotatedString;
        this.f2883c = e0Var;
        this.f2884d = bVar;
        this.f2885e = function1;
        this.f2886f = i11;
        this.f2887g = z11;
        this.f2888h = i12;
        this.f2889i = i13;
        this.f2890j = list;
        this.f2891k = function2;
        this.f2892l = selectionController;
        this.f2893m = z1Var;
        this.f2894n = function3;
    }

    public /* synthetic */ TextAnnotatedStringElement(AnnotatedString annotatedString, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, Function1 function1, int i11, boolean z11, int i12, int i13, List list, Function1 function2, SelectionController selectionController, z1 z1Var, Function1 function3, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, e0Var, bVar, function1, i11, z11, i12, i13, list, function2, selectionController, z1Var, function3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextAnnotatedStringElement)) {
            return false;
        }
        TextAnnotatedStringElement textAnnotatedStringElement = (TextAnnotatedStringElement) obj;
        return Intrinsics.b(this.f2893m, textAnnotatedStringElement.f2893m) && Intrinsics.b(this.f2882b, textAnnotatedStringElement.f2882b) && Intrinsics.b(this.f2883c, textAnnotatedStringElement.f2883c) && Intrinsics.b(this.f2890j, textAnnotatedStringElement.f2890j) && Intrinsics.b(this.f2884d, textAnnotatedStringElement.f2884d) && this.f2885e == textAnnotatedStringElement.f2885e && this.f2894n == textAnnotatedStringElement.f2894n && p.e(this.f2886f, textAnnotatedStringElement.f2886f) && this.f2887g == textAnnotatedStringElement.f2887g && this.f2888h == textAnnotatedStringElement.f2888h && this.f2889i == textAnnotatedStringElement.f2889i && this.f2891k == textAnnotatedStringElement.f2891k && Intrinsics.b(this.f2892l, textAnnotatedStringElement.f2892l);
    }

    public int hashCode() {
        int iHashCode = ((((this.f2882b.hashCode() * 31) + this.f2883c.hashCode()) * 31) + this.f2884d.hashCode()) * 31;
        Function1<a0, Unit> function1 = this.f2885e;
        int iHashCode2 = (((((((((iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31) + p.f(this.f2886f)) * 31) + androidx.compose.foundation.e.a(this.f2887g)) * 31) + this.f2888h) * 31) + this.f2889i) * 31;
        List<AnnotatedString.b<t>> list = this.f2890j;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Function1<List<y1.i>, Unit> function2 = this.f2891k;
        int iHashCode4 = (iHashCode3 + (function2 != null ? function2.hashCode() : 0)) * 31;
        SelectionController selectionController = this.f2892l;
        int iHashCode5 = (iHashCode4 + (selectionController != null ? selectionController.hashCode() : 0)) * 31;
        z1 z1Var = this.f2893m;
        int iHashCode6 = (iHashCode5 + (z1Var != null ? z1Var.hashCode() : 0)) * 31;
        Function1<TextAnnotatedStringNode.a, Unit> function3 = this.f2894n;
        return iHashCode6 + (function3 != null ? function3.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public TextAnnotatedStringNode a() {
        return new TextAnnotatedStringNode(this.f2882b, this.f2883c, this.f2884d, this.f2885e, this.f2886f, this.f2887g, this.f2888h, this.f2889i, this.f2890j, this.f2891k, this.f2892l, this.f2893m, this.f2894n, null);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(TextAnnotatedStringNode textAnnotatedStringNode) {
        textAnnotatedStringNode.O1(textAnnotatedStringNode.X1(this.f2893m, this.f2883c), textAnnotatedStringNode.Z1(this.f2882b), textAnnotatedStringNode.Y1(this.f2883c, this.f2890j, this.f2889i, this.f2888h, this.f2887g, this.f2884d, this.f2886f), textAnnotatedStringNode.W1(this.f2885e, this.f2891k, this.f2892l, this.f2894n));
    }
}
