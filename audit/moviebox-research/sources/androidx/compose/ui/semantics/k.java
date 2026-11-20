package androidx.compose.ui.semantics;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.a0;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class k {
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> A;
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> B;
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> C;
    public static final SemanticsPropertyKey<a<Function1<List<Float>, Boolean>>> D;
    public static final int E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f5661a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function1<List<a0>, Boolean>>> f5662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> f5663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> f5664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function2<Float, Float, Boolean>>> f5665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final SemanticsPropertyKey<Function2<y1.g, Continuation<? super y1.g>, Object>> f5666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function1<Integer, Boolean>>> f5667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function1<AnnotatedString, Boolean>>> f5668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function1<Float, Boolean>>> f5669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function3<Integer, Integer, Boolean, Boolean>>> f5670j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function1<AnnotatedString, Boolean>>> f5671k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function1<AnnotatedString, Boolean>>> f5672l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function1<Boolean, Boolean>>> f5673m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> f5674n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function1<AnnotatedString, Boolean>>> f5675o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> f5676p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> f5677q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> f5678r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> f5679s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> f5680t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> f5681u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> f5682v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> f5683w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> f5684x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final SemanticsPropertyKey<List<e>> f5685y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final SemanticsPropertyKey<a<Function0<Boolean>>> f5686z;

    static {
        SemanticsPropertiesKt$ActionPropertyKey$1 semanticsPropertiesKt$ActionPropertyKey$1 = new Function2<a<Function<? extends Boolean>>, a<Function<? extends Boolean>>, a<Function<? extends Boolean>>>() { // from class: androidx.compose.ui.semantics.SemanticsPropertiesKt$ActionPropertyKey$1
            @Override // kotlin.jvm.functions.Function2
            public final a<Function<? extends Boolean>> invoke(a<Function<? extends Boolean>> aVar, a<Function<? extends Boolean>> aVar2) {
                String strB;
                Function functionA;
                if (aVar == null || (strB = aVar.b()) == null) {
                    strB = aVar2.b();
                }
                if (aVar == null || (functionA = aVar.a()) == null) {
                    functionA = aVar2.a();
                }
                return new a<>(strB, functionA);
            }
        };
        f5662b = SemanticsPropertiesKt.b("GetTextLayoutResult", semanticsPropertiesKt$ActionPropertyKey$1);
        f5663c = SemanticsPropertiesKt.b("OnClick", semanticsPropertiesKt$ActionPropertyKey$1);
        f5664d = SemanticsPropertiesKt.b("OnLongClick", semanticsPropertiesKt$ActionPropertyKey$1);
        f5665e = SemanticsPropertiesKt.b("ScrollBy", semanticsPropertiesKt$ActionPropertyKey$1);
        f5666f = new SemanticsPropertyKey<>("ScrollByOffset", null, 2, null);
        f5667g = SemanticsPropertiesKt.b("ScrollToIndex", semanticsPropertiesKt$ActionPropertyKey$1);
        f5668h = SemanticsPropertiesKt.b("OnAutofillText", semanticsPropertiesKt$ActionPropertyKey$1);
        f5669i = SemanticsPropertiesKt.b("SetProgress", semanticsPropertiesKt$ActionPropertyKey$1);
        f5670j = SemanticsPropertiesKt.b("SetSelection", semanticsPropertiesKt$ActionPropertyKey$1);
        f5671k = SemanticsPropertiesKt.b("SetText", semanticsPropertiesKt$ActionPropertyKey$1);
        f5672l = SemanticsPropertiesKt.b("SetTextSubstitution", semanticsPropertiesKt$ActionPropertyKey$1);
        f5673m = SemanticsPropertiesKt.b("ShowTextSubstitution", semanticsPropertiesKt$ActionPropertyKey$1);
        f5674n = SemanticsPropertiesKt.b("ClearTextSubstitution", semanticsPropertiesKt$ActionPropertyKey$1);
        f5675o = SemanticsPropertiesKt.b("InsertTextAtCursor", semanticsPropertiesKt$ActionPropertyKey$1);
        f5676p = SemanticsPropertiesKt.b("PerformImeAction", semanticsPropertiesKt$ActionPropertyKey$1);
        f5677q = SemanticsPropertiesKt.b("PerformImeAction", semanticsPropertiesKt$ActionPropertyKey$1);
        f5678r = SemanticsPropertiesKt.b("CopyText", semanticsPropertiesKt$ActionPropertyKey$1);
        f5679s = SemanticsPropertiesKt.b("CutText", semanticsPropertiesKt$ActionPropertyKey$1);
        f5680t = SemanticsPropertiesKt.b("PasteText", semanticsPropertiesKt$ActionPropertyKey$1);
        f5681u = SemanticsPropertiesKt.b("Expand", semanticsPropertiesKt$ActionPropertyKey$1);
        f5682v = SemanticsPropertiesKt.b("Collapse", semanticsPropertiesKt$ActionPropertyKey$1);
        f5683w = SemanticsPropertiesKt.b("Dismiss", semanticsPropertiesKt$ActionPropertyKey$1);
        f5684x = SemanticsPropertiesKt.b("RequestFocus", semanticsPropertiesKt$ActionPropertyKey$1);
        f5685y = SemanticsPropertiesKt.a("CustomActions");
        f5686z = SemanticsPropertiesKt.b("PageUp", semanticsPropertiesKt$ActionPropertyKey$1);
        A = SemanticsPropertiesKt.b("PageLeft", semanticsPropertiesKt$ActionPropertyKey$1);
        B = SemanticsPropertiesKt.b("PageDown", semanticsPropertiesKt$ActionPropertyKey$1);
        C = SemanticsPropertiesKt.b("PageRight", semanticsPropertiesKt$ActionPropertyKey$1);
        D = SemanticsPropertiesKt.b("GetScrollViewportLength", semanticsPropertiesKt$ActionPropertyKey$1);
        E = 8;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> a() {
        return f5674n;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> b() {
        return f5682v;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> c() {
        return f5678r;
    }

    public final SemanticsPropertyKey<List<e>> d() {
        return f5685y;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> e() {
        return f5679s;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> f() {
        return f5683w;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> g() {
        return f5681u;
    }

    public final SemanticsPropertyKey<a<Function1<List<Float>, Boolean>>> h() {
        return D;
    }

    public final SemanticsPropertyKey<a<Function1<List<a0>, Boolean>>> i() {
        return f5662b;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> j() {
        return f5663c;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> k() {
        return f5676p;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> l() {
        return f5664d;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> m() {
        return B;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> n() {
        return A;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> o() {
        return C;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> p() {
        return f5686z;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> q() {
        return f5680t;
    }

    public final SemanticsPropertyKey<a<Function0<Boolean>>> r() {
        return f5684x;
    }

    public final SemanticsPropertyKey<a<Function2<Float, Float, Boolean>>> s() {
        return f5665e;
    }

    public final SemanticsPropertyKey<Function2<y1.g, Continuation<? super y1.g>, Object>> t() {
        return f5666f;
    }

    public final SemanticsPropertyKey<a<Function1<Integer, Boolean>>> u() {
        return f5667g;
    }

    public final SemanticsPropertyKey<a<Function1<Float, Boolean>>> v() {
        return f5669i;
    }

    public final SemanticsPropertyKey<a<Function3<Integer, Integer, Boolean, Boolean>>> w() {
        return f5670j;
    }

    public final SemanticsPropertyKey<a<Function1<AnnotatedString, Boolean>>> x() {
        return f5671k;
    }

    public final SemanticsPropertyKey<a<Function1<AnnotatedString, Boolean>>> y() {
        return f5672l;
    }

    public final SemanticsPropertyKey<a<Function1<Boolean, Boolean>>> z() {
        return f5673m;
    }
}
