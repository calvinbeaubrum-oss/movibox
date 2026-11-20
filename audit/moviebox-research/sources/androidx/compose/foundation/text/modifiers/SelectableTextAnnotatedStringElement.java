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
public final class SelectableTextAnnotatedStringElement extends l0<g> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnnotatedString f2864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0 f2865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.ui.text.font.i.b f2866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<a0, Unit> f2867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2870h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f2871i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<AnnotatedString.b<t>> f2872j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<List<y1.i>, Unit> f2873k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SelectionController f2874l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final z1 f2875m;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, Function1<? super a0, Unit> function1, int i11, boolean z11, int i12, int i13, List<AnnotatedString.b<t>> list, Function1<? super List<y1.i>, Unit> function2, SelectionController selectionController, z1 z1Var) {
        this.f2864b = annotatedString;
        this.f2865c = e0Var;
        this.f2866d = bVar;
        this.f2867e = function1;
        this.f2868f = i11;
        this.f2869g = z11;
        this.f2870h = i12;
        this.f2871i = i13;
        this.f2872j = list;
        this.f2873k = function2;
        this.f2874l = selectionController;
        this.f2875m = z1Var;
    }

    public /* synthetic */ SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, Function1 function1, int i11, boolean z11, int i12, int i13, List list, Function1 function2, SelectionController selectionController, z1 z1Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, e0Var, bVar, function1, i11, z11, i12, i13, list, function2, selectionController, z1Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectableTextAnnotatedStringElement)) {
            return false;
        }
        SelectableTextAnnotatedStringElement selectableTextAnnotatedStringElement = (SelectableTextAnnotatedStringElement) obj;
        return Intrinsics.b(this.f2875m, selectableTextAnnotatedStringElement.f2875m) && Intrinsics.b(this.f2864b, selectableTextAnnotatedStringElement.f2864b) && Intrinsics.b(this.f2865c, selectableTextAnnotatedStringElement.f2865c) && Intrinsics.b(this.f2872j, selectableTextAnnotatedStringElement.f2872j) && Intrinsics.b(this.f2866d, selectableTextAnnotatedStringElement.f2866d) && this.f2867e == selectableTextAnnotatedStringElement.f2867e && p.e(this.f2868f, selectableTextAnnotatedStringElement.f2868f) && this.f2869g == selectableTextAnnotatedStringElement.f2869g && this.f2870h == selectableTextAnnotatedStringElement.f2870h && this.f2871i == selectableTextAnnotatedStringElement.f2871i && this.f2873k == selectableTextAnnotatedStringElement.f2873k && Intrinsics.b(this.f2874l, selectableTextAnnotatedStringElement.f2874l);
    }

    public int hashCode() {
        int iHashCode = ((((this.f2864b.hashCode() * 31) + this.f2865c.hashCode()) * 31) + this.f2866d.hashCode()) * 31;
        Function1<a0, Unit> function1 = this.f2867e;
        int iHashCode2 = (((((((((iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31) + p.f(this.f2868f)) * 31) + androidx.compose.foundation.e.a(this.f2869g)) * 31) + this.f2870h) * 31) + this.f2871i) * 31;
        List<AnnotatedString.b<t>> list = this.f2872j;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Function1<List<y1.i>, Unit> function2 = this.f2873k;
        int iHashCode4 = (iHashCode3 + (function2 != null ? function2.hashCode() : 0)) * 31;
        SelectionController selectionController = this.f2874l;
        int iHashCode5 = (iHashCode4 + (selectionController != null ? selectionController.hashCode() : 0)) * 31;
        z1 z1Var = this.f2875m;
        return iHashCode5 + (z1Var != null ? z1Var.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public g a() {
        return new g(this.f2864b, this.f2865c, this.f2866d, this.f2867e, this.f2868f, this.f2869g, this.f2870h, this.f2871i, this.f2872j, this.f2873k, this.f2874l, this.f2875m, null, 4096, null);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(g gVar) {
        gVar.N1(this.f2864b, this.f2865c, this.f2872j, this.f2871i, this.f2870h, this.f2869g, this.f2866d, this.f2868f, this.f2867e, this.f2873k, this.f2874l, this.f2875m);
    }

    public String toString() {
        return "SelectableTextAnnotatedStringElement(text=" + ((Object) this.f2864b) + ", style=" + this.f2865c + ", fontFamilyResolver=" + this.f2866d + ", onTextLayout=" + this.f2867e + ", overflow=" + ((Object) p.g(this.f2868f)) + ", softWrap=" + this.f2869g + ", maxLines=" + this.f2870h + ", minLines=" + this.f2871i + ", placeholders=" + this.f2872j + ", onPlaceholderLayout=" + this.f2873k + ", selectionController=" + this.f2874l + ", color=" + this.f2875m + ')';
    }
}
