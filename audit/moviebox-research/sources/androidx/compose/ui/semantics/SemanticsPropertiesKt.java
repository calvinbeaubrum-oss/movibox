package androidx.compose.ui.semantics;

import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.a0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

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
public final class SemanticsPropertiesKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f5623a = {Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isContainer", "isContainer(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isTraversalGroup", "isTraversalGroup(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "contentType", "getContentType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "contentDataType", "getContentDataType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "traversalIndex", "getTraversalIndex(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "textSubstitution", "getTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isShowingTextSubstitution", "isShowingTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isEditable", "isEditable(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "maxTextLength", "getMaxTextLength(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", 1))};

    static {
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        semanticsProperties.A();
        semanticsProperties.w();
        semanticsProperties.u();
        semanticsProperties.s();
        semanticsProperties.i();
        semanticsProperties.r();
        semanticsProperties.r();
        semanticsProperties.e();
        semanticsProperties.c();
        semanticsProperties.G();
        semanticsProperties.k();
        semanticsProperties.H();
        semanticsProperties.x();
        semanticsProperties.B();
        semanticsProperties.E();
        semanticsProperties.q();
        semanticsProperties.g();
        semanticsProperties.D();
        semanticsProperties.l();
        semanticsProperties.z();
        semanticsProperties.a();
        semanticsProperties.b();
        semanticsProperties.F();
        semanticsProperties.p();
        semanticsProperties.t();
        k.f5661a.d();
    }

    public static final void A(q qVar, h hVar) {
        SemanticsProperties.f5594a.w().d(qVar, f5623a[1], hVar);
    }

    public static final void B(q qVar, int i11) {
        SemanticsProperties.f5594a.x().d(qVar, f5623a[12], i.h(i11));
    }

    public static final void C(q qVar, boolean z11) {
        SemanticsProperties.f5594a.z().d(qVar, f5623a[19], Boolean.valueOf(z11));
    }

    public static final void D(q qVar, boolean z11) {
        SemanticsProperties.f5594a.q().d(qVar, f5623a[15], Boolean.valueOf(z11));
    }

    public static final void E(q qVar, AnnotatedString annotatedString) {
        qVar.a(SemanticsProperties.f5594a.C(), kotlin.collections.f.e(annotatedString));
    }

    public static final void F(q qVar, AnnotatedString annotatedString) {
        SemanticsProperties.f5594a.E().d(qVar, f5623a[14], annotatedString);
    }

    public static final void G(q qVar, String str, Function1<? super AnnotatedString, Boolean> function1) {
        qVar.a(k.f5661a.y(), new a(str, function1));
    }

    public static /* synthetic */ void H(q qVar, String str, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        G(qVar, str, function1);
    }

    public static final void I(q qVar, ToggleableState toggleableState) {
        SemanticsProperties.f5594a.F().d(qVar, f5623a[22], toggleableState);
    }

    public static final void J(q qVar, boolean z11) {
        SemanticsProperties.f5594a.r().d(qVar, f5623a[6], Boolean.valueOf(z11));
    }

    public static final void K(q qVar, j jVar) {
        SemanticsProperties.f5594a.H().d(qVar, f5623a[11], jVar);
    }

    public static final void L(q qVar, String str, Function1<? super Boolean, Boolean> function1) {
        qVar.a(k.f5661a.z(), new a(str, function1));
    }

    public static /* synthetic */ void M(q qVar, String str, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        L(qVar, str, function1);
    }

    public static final <T> SemanticsPropertyKey<T> a(String str) {
        return new SemanticsPropertyKey<>(str, true);
    }

    public static final <T> SemanticsPropertyKey<T> b(String str, Function2<? super T, ? super T, ? extends T> function2) {
        return new SemanticsPropertyKey<>(str, true, function2);
    }

    public static final void c(q qVar, String str, Function0<Boolean> function0) {
        qVar.a(k.f5661a.a(), new a(str, function0));
    }

    public static /* synthetic */ void d(q qVar, String str, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        c(qVar, str, function0);
    }

    public static final void e(q qVar) {
        qVar.a(SemanticsProperties.f5594a.o(), Unit.f68710a);
    }

    public static final void f(q qVar) {
        qVar.a(SemanticsProperties.f5594a.f(), Unit.f68710a);
    }

    public static final void g(q qVar, String str, final Function0<Float> function0) {
        qVar.a(k.f5661a.h(), new a(str, new Function1<List<Float>, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsPropertiesKt$getScrollViewportLength$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<Float> list) {
                boolean z11;
                Float fInvoke = function0.invoke();
                if (fInvoke == null) {
                    z11 = false;
                } else {
                    list.add(fInvoke);
                    z11 = true;
                }
                return Boolean.valueOf(z11);
            }
        }));
    }

    public static /* synthetic */ void h(q qVar, String str, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        g(qVar, str, function0);
    }

    public static final void i(q qVar, String str, Function1<? super List<a0>, Boolean> function1) {
        qVar.a(k.f5661a.i(), new a(str, function1));
    }

    public static /* synthetic */ void j(q qVar, String str, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        i(qVar, str, function1);
    }

    public static final void k(q qVar, Function1<Object, Integer> function1) {
        qVar.a(SemanticsProperties.f5594a.m(), function1);
    }

    public static final void l(q qVar, String str, Function0<Boolean> function0) {
        qVar.a(k.f5661a.j(), new a(str, function0));
    }

    public static final void m(q qVar, String str, Function0<Boolean> function0) {
        qVar.a(k.f5661a.l(), new a(str, function0));
    }

    public static final void n(q qVar, String str, Function0<Boolean> function0) {
        qVar.a(k.f5661a.r(), new a(str, function0));
    }

    public static /* synthetic */ void o(q qVar, String str, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        n(qVar, str, function0);
    }

    public static final void p(q qVar, String str, Function2<? super Float, ? super Float, Boolean> function2) {
        qVar.a(k.f5661a.s(), new a(str, function2));
    }

    public static /* synthetic */ void q(q qVar, String str, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        p(qVar, str, function2);
    }

    public static final void r(q qVar, Function2<? super y1.g, ? super Continuation<? super y1.g>, ? extends Object> function2) {
        qVar.a(k.f5661a.t(), function2);
    }

    public static final void s(q qVar, String str, Function1<? super Integer, Boolean> function1) {
        qVar.a(k.f5661a.u(), new a(str, function1));
    }

    public static /* synthetic */ void t(q qVar, String str, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        s(qVar, str, function1);
    }

    public static final void u(q qVar, b bVar) {
        SemanticsProperties.f5594a.a().d(qVar, f5623a[20], bVar);
    }

    public static final void v(q qVar, String str) {
        qVar.a(SemanticsProperties.f5594a.d(), kotlin.collections.f.e(str));
    }

    public static final void w(q qVar, boolean z11) {
        SemanticsProperties.f5594a.i().d(qVar, f5623a[4], Boolean.valueOf(z11));
    }

    public static final void x(q qVar, j jVar) {
        SemanticsProperties.f5594a.k().d(qVar, f5623a[10], jVar);
    }

    public static final void y(q qVar, String str, Function1<? super Float, Boolean> function1) {
        qVar.a(k.f5661a.v(), new a(str, function1));
    }

    public static /* synthetic */ void z(q qVar, String str, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        y(qVar, str, function1);
    }
}
