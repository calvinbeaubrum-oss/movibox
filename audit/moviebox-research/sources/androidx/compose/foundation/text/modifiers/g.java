package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.z1;
import androidx.compose.ui.layout.w;
import androidx.compose.ui.layout.y;
import androidx.compose.ui.node.m;
import androidx.compose.ui.node.n;
import androidx.compose.ui.node.p;
import androidx.compose.ui.node.x;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.a0;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.t;
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class g extends androidx.compose.ui.node.i implements x, n, p {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SelectionController f2983q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function1<? super TextAnnotatedStringNode.a, Unit> f2984r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextAnnotatedStringNode f2985s;

    public g(AnnotatedString annotatedString, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, Function1<? super a0, Unit> function1, int i11, boolean z11, int i12, int i13, List<AnnotatedString.b<t>> list, Function1<? super List<y1.i>, Unit> function2, SelectionController selectionController, z1 z1Var, Function1<? super TextAnnotatedStringNode.a, Unit> function3) {
        this.f2983q = selectionController;
        this.f2984r = function3;
        this.f2985s = (TextAnnotatedStringNode) H1(new TextAnnotatedStringNode(annotatedString, e0Var, bVar, function1, i11, z11, i12, i13, list, function2, this.f2983q, z1Var, this.f2984r, null));
        if (this.f2983q == null) {
            throw new IllegalArgumentException("Do not use SelectionCapableStaticTextModifier unless selectionController != null".toString());
        }
    }

    public /* synthetic */ g(AnnotatedString annotatedString, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, Function1 function1, int i11, boolean z11, int i12, int i13, List list, Function1 function2, SelectionController selectionController, z1 z1Var, Function1 function3, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, e0Var, bVar, (i14 & 8) != 0 ? null : function1, (i14 & 16) != 0 ? androidx.compose.ui.text.style.p.f6143a.a() : i11, (i14 & 32) != 0 ? true : z11, (i14 & 64) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i12, (i14 & 128) != 0 ? 1 : i13, (i14 & 256) != 0 ? null : list, (i14 & 512) != 0 ? null : function2, (i14 & 1024) != 0 ? null : selectionController, (i14 & 2048) != 0 ? null : z1Var, (i14 & 4096) != 0 ? null : function3, null);
    }

    public /* synthetic */ g(AnnotatedString annotatedString, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, Function1 function1, int i11, boolean z11, int i12, int i13, List list, Function1 function2, SelectionController selectionController, z1 z1Var, Function1 function3, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, e0Var, bVar, function1, i11, z11, i12, i13, list, function2, selectionController, z1Var, function3);
    }

    @Override // androidx.compose.ui.node.n
    public void A(z1.c cVar) {
        this.f2985s.P1(cVar);
    }

    @Override // androidx.compose.ui.node.x
    public w C(y yVar, androidx.compose.ui.layout.t tVar, long j11) {
        return this.f2985s.U1(yVar, tVar, j11);
    }

    @Override // androidx.compose.ui.node.n
    public /* synthetic */ void F0() {
        m.a(this);
    }

    public final void N1(AnnotatedString annotatedString, e0 e0Var, List<AnnotatedString.b<t>> list, int i11, int i12, boolean z11, androidx.compose.ui.text.font.i.b bVar, int i13, Function1<? super a0, Unit> function1, Function1<? super List<y1.i>, Unit> function2, SelectionController selectionController, z1 z1Var) {
        TextAnnotatedStringNode textAnnotatedStringNode = this.f2985s;
        textAnnotatedStringNode.O1(textAnnotatedStringNode.X1(z1Var, e0Var), this.f2985s.Z1(annotatedString), this.f2985s.Y1(e0Var, list, i11, i12, z11, bVar, i13), this.f2985s.W1(function1, function2, selectionController, this.f2984r));
        this.f2983q = selectionController;
        androidx.compose.ui.node.a0.b(this);
    }

    @Override // androidx.compose.ui.node.p
    public void x(androidx.compose.ui.layout.m mVar) {
        SelectionController selectionController = this.f2983q;
        if (selectionController != null) {
            selectionController.d(mVar);
        }
    }
}
