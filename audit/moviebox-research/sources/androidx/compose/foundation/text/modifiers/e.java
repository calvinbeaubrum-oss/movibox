package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.a0;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.f0;
import androidx.compose.ui.text.style.p;
import androidx.compose.ui.text.t;
import androidx.compose.ui.text.z;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.u;

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
@SourceDebugExtension
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnnotatedString f2949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f2950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.compose.ui.text.font.i.b f2951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<AnnotatedString.b<t>> f2956h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f2957i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f2958j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public q2.e f2959k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MultiParagraphIntrinsics f2960l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LayoutDirection f2961m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a0 f2962n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2963o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2964p;

    public e(AnnotatedString annotatedString, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, int i11, boolean z11, int i12, int i13, List<AnnotatedString.b<t>> list) {
        this.f2949a = annotatedString;
        this.f2950b = e0Var;
        this.f2951c = bVar;
        this.f2952d = i11;
        this.f2953e = z11;
        this.f2954f = i12;
        this.f2955g = i13;
        this.f2956h = list;
        this.f2958j = a.f2935a.a();
        this.f2963o = -1;
        this.f2964p = -1;
    }

    public /* synthetic */ e(AnnotatedString annotatedString, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, int i11, boolean z11, int i12, int i13, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, e0Var, bVar, i11, z11, i12, i13, list);
    }

    public final q2.e a() {
        return this.f2959k;
    }

    public final a0 b() {
        return this.f2962n;
    }

    public final a0 c() {
        a0 a0Var = this.f2962n;
        if (a0Var != null) {
            return a0Var;
        }
        throw new IllegalStateException("You must call layoutWithConstraints first");
    }

    public final MultiParagraph d(long j11, LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics multiParagraphIntrinsicsI = i(layoutDirection);
        return new MultiParagraph(multiParagraphIntrinsicsI, b.a(j11, this.f2953e, this.f2952d, multiParagraphIntrinsicsI.a()), b.b(this.f2953e, this.f2952d, this.f2954f), p.e(this.f2952d, p.f6143a.b()), null);
    }

    public final boolean e(long j11, LayoutDirection layoutDirection) {
        if (this.f2955g > 1) {
            c.a aVar = c.f2937h;
            c cVar = this.f2957i;
            e0 e0Var = this.f2950b;
            q2.e eVar = this.f2959k;
            Intrinsics.d(eVar);
            c cVarA = aVar.a(cVar, layoutDirection, e0Var, eVar, this.f2951c);
            this.f2957i = cVarA;
            j11 = cVarA.c(j11, this.f2955g);
        }
        if (g(this.f2962n, j11, layoutDirection)) {
            this.f2962n = j(layoutDirection, j11, d(j11, layoutDirection));
            return true;
        }
        a0 a0Var = this.f2962n;
        Intrinsics.d(a0Var);
        if (q2.b.f(j11, a0Var.k().a())) {
            return false;
        }
        a0 a0Var2 = this.f2962n;
        Intrinsics.d(a0Var2);
        this.f2962n = j(layoutDirection, j11, a0Var2.v());
        return true;
    }

    public final void f() {
        this.f2960l = null;
        this.f2962n = null;
        this.f2964p = -1;
        this.f2963o = -1;
    }

    public final boolean g(a0 a0Var, long j11, LayoutDirection layoutDirection) {
        if (a0Var == null || a0Var.v().i().b() || layoutDirection != a0Var.k().d()) {
            return true;
        }
        if (q2.b.f(j11, a0Var.k().a())) {
            return false;
        }
        return q2.b.l(j11) != q2.b.l(a0Var.k().a()) || ((float) q2.b.k(j11)) < a0Var.v().h() || a0Var.v().f();
    }

    public final void h(q2.e eVar) {
        q2.e eVar2 = this.f2959k;
        long jD = eVar != null ? a.d(eVar) : a.f2935a.a();
        if (eVar2 == null) {
            this.f2959k = eVar;
            this.f2958j = jD;
        } else if (eVar == null || !a.e(this.f2958j, jD)) {
            this.f2959k = eVar;
            this.f2958j = jD;
            f();
        }
    }

    public final MultiParagraphIntrinsics i(LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.f2960l;
        if (multiParagraphIntrinsics == null || layoutDirection != this.f2961m || multiParagraphIntrinsics.b()) {
            this.f2961m = layoutDirection;
            AnnotatedString annotatedString = this.f2949a;
            e0 e0VarC = f0.c(this.f2950b, layoutDirection);
            q2.e eVar = this.f2959k;
            Intrinsics.d(eVar);
            androidx.compose.ui.text.font.i.b bVar = this.f2951c;
            List<AnnotatedString.b<t>> listL = this.f2956h;
            if (listL == null) {
                listL = kotlin.collections.g.l();
            }
            multiParagraphIntrinsics = new MultiParagraphIntrinsics(annotatedString, e0VarC, listL, eVar, bVar);
        }
        this.f2960l = multiParagraphIntrinsics;
        return multiParagraphIntrinsics;
    }

    public final a0 j(LayoutDirection layoutDirection, long j11, MultiParagraph multiParagraph) {
        float fMin = Math.min(multiParagraph.i().a(), multiParagraph.w());
        AnnotatedString annotatedString = this.f2949a;
        e0 e0Var = this.f2950b;
        List<AnnotatedString.b<t>> listL = this.f2956h;
        if (listL == null) {
            listL = kotlin.collections.g.l();
        }
        List<AnnotatedString.b<t>> list = listL;
        int i11 = this.f2954f;
        boolean z11 = this.f2953e;
        int i12 = this.f2952d;
        q2.e eVar = this.f2959k;
        Intrinsics.d(eVar);
        return new a0(new z(annotatedString, e0Var, list, i11, z11, i12, eVar, layoutDirection, this.f2951c, j11, (DefaultConstructorMarker) null), multiParagraph, q2.c.f(j11, u.a(androidx.compose.foundation.text.b.a(fMin), androidx.compose.foundation.text.b.a(multiParagraph.h()))), null);
    }

    public final void k(AnnotatedString annotatedString, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, int i11, boolean z11, int i12, int i13, List<AnnotatedString.b<t>> list) {
        this.f2949a = annotatedString;
        this.f2950b = e0Var;
        this.f2951c = bVar;
        this.f2952d = i11;
        this.f2953e = z11;
        this.f2954f = i12;
        this.f2955g = i13;
        this.f2956h = list;
        f();
    }
}
