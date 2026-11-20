package androidx.compose.ui.semantics;

import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.c0;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import x1.e0;
import x1.f0;

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
public final class SemanticsProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SemanticsProperties f5594a = new SemanticsProperties();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SemanticsPropertyKey<List<String>> f5595b = SemanticsPropertiesKt.b("ContentDescription", new Function2<List<? extends String>, List<? extends String>, List<? extends String>>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentDescription$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ List<? extends String> invoke(List<? extends String> list, List<? extends String> list2) {
            return invoke2((List<String>) list, (List<String>) list2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<String> invoke2(List<String> list, List<String> list2) {
            List<String> listM0;
            if (list == null || (listM0 = CollectionsKt___CollectionsKt.M0(list)) == null) {
                return list2;
            }
            listM0.addAll(list2);
            return listM0;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SemanticsPropertyKey<String> f5596c = SemanticsPropertiesKt.a("StateDescription");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SemanticsPropertyKey<h> f5597d = SemanticsPropertiesKt.a("ProgressBarRangeInfo");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SemanticsPropertyKey<String> f5598e = SemanticsPropertiesKt.b("PaneTitle", new Function2<String, String, String>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$PaneTitle$1
        @Override // kotlin.jvm.functions.Function2
        public final String invoke(String str, String str2) {
            throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final SemanticsPropertyKey<Unit> f5599f = SemanticsPropertiesKt.a("SelectableGroup");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final SemanticsPropertyKey<b> f5600g = SemanticsPropertiesKt.a("CollectionInfo");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final SemanticsPropertyKey<c> f5601h = SemanticsPropertiesKt.a("CollectionItemInfo");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final SemanticsPropertyKey<Unit> f5602i = SemanticsPropertiesKt.a("Heading");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final SemanticsPropertyKey<Unit> f5603j = SemanticsPropertiesKt.a(BucketLifecycleConfiguration.DISABLED);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final SemanticsPropertyKey<g> f5604k = SemanticsPropertiesKt.a("LiveRegion");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final SemanticsPropertyKey<Boolean> f5605l = SemanticsPropertiesKt.a("Focused");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final SemanticsPropertyKey<Boolean> f5606m = SemanticsPropertiesKt.a("IsTraversalGroup");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final SemanticsPropertyKey<Unit> f5607n = new SemanticsPropertyKey<>("InvisibleToUser", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$InvisibleToUser$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Unit unit, Unit unit2) {
            return unit;
        }
    });

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final SemanticsPropertyKey<f0> f5608o = new SemanticsPropertyKey<>("ContentType", new Function2<f0, f0, f0>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentType$1
        @Override // kotlin.jvm.functions.Function2
        public final f0 invoke(f0 f0Var, f0 f0Var2) {
            return f0Var;
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final SemanticsPropertyKey<e0> f5609p = new SemanticsPropertyKey<>("ContentDataType", new Function2<e0, e0, e0>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentDataType$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ e0 invoke(e0 e0Var, e0 e0Var2) {
            return m76invokex33U9Dw(e0Var, e0Var2.f());
        }

        /* JADX INFO: renamed from: invoke-x33U9Dw, reason: not valid java name */
        public final e0 m76invokex33U9Dw(e0 e0Var, int i11) {
            return e0Var;
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final SemanticsPropertyKey<Float> f5610q = SemanticsPropertiesKt.b("TraversalIndex", new Function2<Float, Float, Float>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TraversalIndex$1
        public final Float invoke(Float f11, float f12) {
            return f11;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Float invoke(Float f11, Float f12) {
            return invoke(f11, f12.floatValue());
        }
    });

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final SemanticsPropertyKey<j> f5611r = SemanticsPropertiesKt.a("HorizontalScrollAxisRange");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final SemanticsPropertyKey<j> f5612s = SemanticsPropertiesKt.a("VerticalScrollAxisRange");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final SemanticsPropertyKey<Unit> f5613t = SemanticsPropertiesKt.b("IsPopup", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsPopup$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Unit unit, Unit unit2) {
            throw new IllegalStateException("merge function called on unmergeable property IsPopup. A popup should not be a child of a clickable/focusable node.");
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final SemanticsPropertyKey<Unit> f5614u = SemanticsPropertiesKt.b("IsDialog", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsDialog$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Unit unit, Unit unit2) {
            throw new IllegalStateException("merge function called on unmergeable property IsDialog. A dialog should not be a child of a clickable/focusable node.");
        }
    });

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final SemanticsPropertyKey<i> f5615v = SemanticsPropertiesKt.b("Role", new Function2<i, i, i>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Role$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ i invoke(i iVar, i iVar2) {
            return m77invokeqtAw6s(iVar, iVar2.n());
        }

        /* JADX INFO: renamed from: invoke-qtA-w6s, reason: not valid java name */
        public final i m77invokeqtAw6s(i iVar, int i11) {
            return iVar;
        }
    });

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final SemanticsPropertyKey<String> f5616w = new SemanticsPropertyKey<>("TestTag", false, new Function2<String, String, String>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TestTag$1
        @Override // kotlin.jvm.functions.Function2
        public final String invoke(String str, String str2) {
            return str;
        }
    });

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final SemanticsPropertyKey<List<AnnotatedString>> f5617x = SemanticsPropertiesKt.b("Text", new Function2<List<? extends AnnotatedString>, List<? extends AnnotatedString>, List<? extends AnnotatedString>>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Text$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ List<? extends AnnotatedString> invoke(List<? extends AnnotatedString> list, List<? extends AnnotatedString> list2) {
            return invoke2((List<AnnotatedString>) list, (List<AnnotatedString>) list2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<AnnotatedString> invoke2(List<AnnotatedString> list, List<AnnotatedString> list2) {
            List<AnnotatedString> listM0;
            if (list == null || (listM0 = CollectionsKt___CollectionsKt.M0(list)) == null) {
                return list2;
            }
            listM0.addAll(list2);
            return listM0;
        }
    });

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final SemanticsPropertyKey<AnnotatedString> f5618y = new SemanticsPropertyKey<>("TextSubstitution", null, 2, null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final SemanticsPropertyKey<Boolean> f5619z = new SemanticsPropertyKey<>("IsShowingTextSubstitution", null, 2, null);
    public static final SemanticsPropertyKey<AnnotatedString> A = SemanticsPropertiesKt.a("EditableText");
    public static final SemanticsPropertyKey<c0> B = SemanticsPropertiesKt.a("TextSelectionRange");
    public static final SemanticsPropertyKey<androidx.compose.ui.text.input.o> C = SemanticsPropertiesKt.a("ImeAction");
    public static final SemanticsPropertyKey<Boolean> D = SemanticsPropertiesKt.a("Selected");
    public static final SemanticsPropertyKey<ToggleableState> E = SemanticsPropertiesKt.a("ToggleableState");
    public static final SemanticsPropertyKey<Unit> F = SemanticsPropertiesKt.a("Password");
    public static final SemanticsPropertyKey<String> G = SemanticsPropertiesKt.a("Error");
    public static final SemanticsPropertyKey<Function1<Object, Integer>> H = new SemanticsPropertyKey<>("IndexForKey", null, 2, null);
    public static final SemanticsPropertyKey<Boolean> I = new SemanticsPropertyKey<>("IsEditable", null, 2, null);
    public static final SemanticsPropertyKey<Integer> J = new SemanticsPropertyKey<>("MaxTextLength", null, 2, null);
    public static final int K = 8;

    public final SemanticsPropertyKey<String> A() {
        return f5596c;
    }

    public final SemanticsPropertyKey<String> B() {
        return f5616w;
    }

    public final SemanticsPropertyKey<List<AnnotatedString>> C() {
        return f5617x;
    }

    public final SemanticsPropertyKey<c0> D() {
        return B;
    }

    public final SemanticsPropertyKey<AnnotatedString> E() {
        return f5618y;
    }

    public final SemanticsPropertyKey<ToggleableState> F() {
        return E;
    }

    public final SemanticsPropertyKey<Float> G() {
        return f5610q;
    }

    public final SemanticsPropertyKey<j> H() {
        return f5612s;
    }

    public final SemanticsPropertyKey<b> a() {
        return f5600g;
    }

    public final SemanticsPropertyKey<c> b() {
        return f5601h;
    }

    public final SemanticsPropertyKey<e0> c() {
        return f5609p;
    }

    public final SemanticsPropertyKey<List<String>> d() {
        return f5595b;
    }

    public final SemanticsPropertyKey<f0> e() {
        return f5608o;
    }

    public final SemanticsPropertyKey<Unit> f() {
        return f5603j;
    }

    public final SemanticsPropertyKey<AnnotatedString> g() {
        return A;
    }

    public final SemanticsPropertyKey<String> h() {
        return G;
    }

    public final SemanticsPropertyKey<Boolean> i() {
        return f5605l;
    }

    public final SemanticsPropertyKey<Unit> j() {
        return f5602i;
    }

    public final SemanticsPropertyKey<j> k() {
        return f5611r;
    }

    public final SemanticsPropertyKey<androidx.compose.ui.text.input.o> l() {
        return C;
    }

    public final SemanticsPropertyKey<Function1<Object, Integer>> m() {
        return H;
    }

    public final SemanticsPropertyKey<Unit> n() {
        return f5607n;
    }

    public final SemanticsPropertyKey<Unit> o() {
        return f5614u;
    }

    public final SemanticsPropertyKey<Boolean> p() {
        return I;
    }

    public final SemanticsPropertyKey<Boolean> q() {
        return f5619z;
    }

    public final SemanticsPropertyKey<Boolean> r() {
        return f5606m;
    }

    public final SemanticsPropertyKey<g> s() {
        return f5604k;
    }

    public final SemanticsPropertyKey<Integer> t() {
        return J;
    }

    public final SemanticsPropertyKey<String> u() {
        return f5598e;
    }

    public final SemanticsPropertyKey<Unit> v() {
        return F;
    }

    public final SemanticsPropertyKey<h> w() {
        return f5597d;
    }

    public final SemanticsPropertyKey<i> x() {
        return f5615v;
    }

    public final SemanticsPropertyKey<Unit> y() {
        return f5599f;
    }

    public final SemanticsPropertyKey<Boolean> z() {
        return D;
    }
}
