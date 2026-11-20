package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.a0;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.f0;
import androidx.compose.ui.text.l;
import androidx.compose.ui.text.o;
import androidx.compose.ui.text.q;
import androidx.compose.ui.text.style.p;
import androidx.compose.ui.text.z;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.t;
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
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f2966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.compose.ui.text.font.i.b f2967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public q2.e f2973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l f2974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2975k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f2976l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f2977m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o f2978n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LayoutDirection f2979o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f2980p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2981q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f2982r;

    public f(String str, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, int i11, boolean z11, int i12, int i13) {
        this.f2965a = str;
        this.f2966b = e0Var;
        this.f2967c = bVar;
        this.f2968d = i11;
        this.f2969e = z11;
        this.f2970f = i12;
        this.f2971g = i13;
        this.f2972h = a.f2935a.a();
        this.f2976l = u.a(0, 0);
        this.f2980p = q2.b.f74225b.c(0, 0);
        this.f2981q = -1;
        this.f2982r = -1;
    }

    public /* synthetic */ f(String str, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, int i11, boolean z11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, e0Var, bVar, i11, z11, i12, i13);
    }

    public final q2.e a() {
        return this.f2973i;
    }

    public final boolean b() {
        return this.f2975k;
    }

    public final long c() {
        return this.f2976l;
    }

    public final Unit d() {
        o oVar = this.f2978n;
        if (oVar != null) {
            oVar.b();
        }
        return Unit.f68710a;
    }

    public final l e() {
        return this.f2974j;
    }

    public final l f(long j11, LayoutDirection layoutDirection) {
        o oVarK = k(layoutDirection);
        return q.c(oVarK, b.a(j11, this.f2969e, this.f2968d, oVarK.a()), b.b(this.f2969e, this.f2968d, this.f2970f), p.e(this.f2968d, p.f6143a.b()));
    }

    public final boolean g(long j11, LayoutDirection layoutDirection) {
        boolean z11 = true;
        if (this.f2971g > 1) {
            c.a aVar = c.f2937h;
            c cVar = this.f2977m;
            e0 e0Var = this.f2966b;
            q2.e eVar = this.f2973i;
            Intrinsics.d(eVar);
            c cVarA = aVar.a(cVar, layoutDirection, e0Var, eVar, this.f2967c);
            this.f2977m = cVarA;
            j11 = cVarA.c(j11, this.f2971g);
        }
        boolean z12 = false;
        if (i(j11, layoutDirection)) {
            l lVarF = f(j11, layoutDirection);
            this.f2980p = j11;
            long jF = q2.c.f(j11, u.a(androidx.compose.foundation.text.b.a(lVarF.getWidth()), androidx.compose.foundation.text.b.a(lVarF.getHeight())));
            this.f2976l = jF;
            if (!p.e(this.f2968d, p.f6143a.c()) && (t.g(jF) < lVarF.getWidth() || t.f(jF) < lVarF.getHeight())) {
                z12 = true;
            }
            this.f2975k = z12;
            this.f2974j = lVarF;
            return true;
        }
        if (!q2.b.f(j11, this.f2980p)) {
            l lVar = this.f2974j;
            Intrinsics.d(lVar);
            long jF2 = q2.c.f(j11, u.a(androidx.compose.foundation.text.b.a(Math.min(lVar.a(), lVar.getWidth())), androidx.compose.foundation.text.b.a(lVar.getHeight())));
            this.f2976l = jF2;
            if (p.e(this.f2968d, p.f6143a.c()) || (t.g(jF2) >= lVar.getWidth() && t.f(jF2) >= lVar.getHeight())) {
                z11 = false;
            }
            this.f2975k = z11;
            this.f2980p = j11;
        }
        return false;
    }

    public final void h() {
        this.f2974j = null;
        this.f2978n = null;
        this.f2979o = null;
        this.f2981q = -1;
        this.f2982r = -1;
        this.f2980p = q2.b.f74225b.c(0, 0);
        this.f2976l = u.a(0, 0);
        this.f2975k = false;
    }

    public final boolean i(long j11, LayoutDirection layoutDirection) {
        o oVar;
        l lVar = this.f2974j;
        if (lVar == null || (oVar = this.f2978n) == null || oVar.b() || layoutDirection != this.f2979o) {
            return true;
        }
        if (q2.b.f(j11, this.f2980p)) {
            return false;
        }
        return q2.b.l(j11) != q2.b.l(this.f2980p) || ((float) q2.b.k(j11)) < lVar.getHeight() || lVar.k();
    }

    public final void j(q2.e eVar) {
        q2.e eVar2 = this.f2973i;
        long jD = eVar != null ? a.d(eVar) : a.f2935a.a();
        if (eVar2 == null) {
            this.f2973i = eVar;
            this.f2972h = jD;
        } else if (eVar == null || !a.e(this.f2972h, jD)) {
            this.f2973i = eVar;
            this.f2972h = jD;
            h();
        }
    }

    public final o k(LayoutDirection layoutDirection) {
        o oVarB = this.f2978n;
        if (oVarB == null || layoutDirection != this.f2979o || oVarB.b()) {
            this.f2979o = layoutDirection;
            String str = this.f2965a;
            e0 e0VarC = f0.c(this.f2966b, layoutDirection);
            q2.e eVar = this.f2973i;
            Intrinsics.d(eVar);
            oVarB = androidx.compose.ui.text.p.b(str, e0VarC, null, null, eVar, this.f2967c, 12, null);
        }
        this.f2978n = oVarB;
        return oVarB;
    }

    public final a0 l(e0 e0Var) {
        q2.e eVar;
        LayoutDirection layoutDirection = this.f2979o;
        if (layoutDirection == null || (eVar = this.f2973i) == null) {
            return null;
        }
        AnnotatedString annotatedString = new AnnotatedString(this.f2965a, null, null, 6, null);
        if (this.f2974j == null || this.f2978n == null) {
            return null;
        }
        long jD = q2.b.d(this.f2980p, 0, 0, 0, 0, 10, null);
        return new a0(new z(annotatedString, e0Var, kotlin.collections.g.l(), this.f2970f, this.f2969e, this.f2968d, eVar, layoutDirection, this.f2967c, jD, (DefaultConstructorMarker) null), new MultiParagraph(new MultiParagraphIntrinsics(annotatedString, e0Var, kotlin.collections.g.l(), eVar, this.f2967c), jD, this.f2970f, p.e(this.f2968d, p.f6143a.b()), null), this.f2976l, null);
    }

    public final void m(String str, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, int i11, boolean z11, int i12, int i13) {
        this.f2965a = str;
        this.f2966b = e0Var;
        this.f2967c = bVar;
        this.f2968d = i11;
        this.f2969e = z11;
        this.f2970f = i12;
        this.f2971g = i13;
        h();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ParagraphLayoutCache(paragraph=");
        sb2.append(this.f2974j != null ? "<paragraph>" : "null");
        sb2.append(", lastDensity=");
        sb2.append((Object) a.h(this.f2972h));
        sb2.append(')');
        return sb2.toString();
    }
}
