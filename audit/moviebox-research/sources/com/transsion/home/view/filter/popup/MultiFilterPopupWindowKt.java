package com.transsion.home.view.filter.popup;

import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.b0;
import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.layout.e0;
import androidx.compose.foundation.layout.j;
import androidx.compose.foundation.layout.l;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.SliderKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.i;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.k;
import androidx.compose.runtime.s;
import androidx.compose.runtime.snapshots.t;
import androidx.compose.runtime.u2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.layout.u;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.style.p;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import com.blankj.utilcode.util.k0;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import com.tn.lib.widget.R$color;
import com.transsion.home.R$string;
import com.transsion.home.bean.FilterVal;
import com.transsion.home.bean.Item;
import com.transsion.home.bean.RangeValue;
import com.transsion.videodetail.R$drawable;
import java.util.List;
import java.util.Map;
import k2.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.text.StringsKt__StringsKt;
import q2.x;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class MultiFilterPopupWindowKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f52723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static float f52724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f52725c;

    public static final void b(final Item item, final t<String, String> tVar, i iVar, final int i11) {
        i iVar2;
        i iVarG = iVar.g(1506355035);
        if (k.J()) {
            k.S(1506355035, i11, -1, "com.transsion.home.view.filter.popup.FilterItemView (MultiFilterPopupWindow.kt:242)");
        }
        f.a aVar = f.f3863a;
        int i12 = 0;
        u uVarA = androidx.compose.foundation.layout.i.a(androidx.compose.foundation.layout.b.f2478a.d(), androidx.compose.ui.b.f3770a.i(), iVarG, 0);
        int iA = g.a(iVarG, 0);
        s sVarN = iVarG.n();
        f fVarE = ComposedModifierKt.e(iVarG, aVar);
        ComposeUiNode.Companion companion = ComposeUiNode.f4919a8;
        Function0<ComposeUiNode> function0A = companion.a();
        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
            g.b();
        }
        iVarG.D();
        if (iVarG.e()) {
            iVarG.G(function0A);
        } else {
            iVarG.o();
        }
        i iVarA = f3.a(iVarG);
        f3.b(iVarA, uVarA, companion.c());
        f3.b(iVarA, sVarN, companion.e());
        Function2<ComposeUiNode, Integer, Unit> function2B = companion.b();
        if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA))) {
            iVarA.p(Integer.valueOf(iA));
            iVarA.k(Integer.valueOf(iA), function2B);
        }
        f3.b(iVarA, fVarE, companion.d());
        l lVar = l.f2502a;
        TextKt.a(item.getTitle(), null, c.a(R$color.white, iVarG, 0), x.c(16), null, androidx.compose.ui.text.font.u.f5860b.c(), androidx.compose.ui.text.font.i.f5821b.b(), 0L, null, null, 0L, 0, false, 0, 0, null, null, iVarG, 199680, 0, 130962);
        if (item.getRangeVals() == null) {
            iVarG.x(-1087289923);
            List<List> listW = CollectionsKt___CollectionsKt.W(item.getFilterValsV2(), 2);
            int i13 = (((Configuration) iVarG.l(AndroidCompositionLocals_androidKt.f())).screenWidthDp - 44) / 2;
            for (List<FilterVal> list : listW) {
                f fVarI = PaddingKt.i(SizeKt.d(f.f3863a, 0.0f, 1, null), 0.0f, q2.i.h(12), 0.0f, 0.0f, 13, null);
                u uVarB = a0.b(androidx.compose.foundation.layout.b.f2478a.c(), androidx.compose.ui.b.f3770a.j(), iVarG, i12);
                int iA2 = g.a(iVarG, i12);
                s sVarN2 = iVarG.n();
                f fVarE2 = ComposedModifierKt.e(iVarG, fVarI);
                ComposeUiNode.Companion companion2 = ComposeUiNode.f4919a8;
                Function0<ComposeUiNode> function0A2 = companion2.a();
                if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVarG.D();
                if (iVarG.e()) {
                    iVarG.G(function0A2);
                } else {
                    iVarG.o();
                }
                i iVarA2 = f3.a(iVarG);
                f3.b(iVarA2, uVarB, companion2.c());
                f3.b(iVarA2, sVarN2, companion2.e());
                Function2<ComposeUiNode, Integer, Unit> function2B2 = companion2.b();
                if (iVarA2.e() || !Intrinsics.b(iVarA2.y(), Integer.valueOf(iA2))) {
                    iVarA2.p(Integer.valueOf(iA2));
                    iVarA2.k(Integer.valueOf(iA2), function2B2);
                }
                f3.b(iVarA2, fVarE2, companion2.d());
                d0 d0Var = d0.f2491a;
                iVarG.x(-1087289491);
                for (FilterVal filterVal : list) {
                    f.a aVar2 = f.f3863a;
                    int i14 = i13;
                    i iVar3 = iVarG;
                    c(item, filterVal, tVar, SizeKt.l(aVar2, q2.i.h(i13)), iVarG, ((i11 << 3) & 896) | 8);
                    iVar3.x(-2146449217);
                    if (!Intrinsics.b(filterVal, CollectionsKt___CollectionsKt.q0(list))) {
                        e0.a(b0.a(d0Var, aVar2, 1.0f, false, 2, null), iVar3, 0);
                    }
                    iVar3.P();
                    iVarG = iVar3;
                    i13 = i14;
                }
                int i15 = i13;
                i iVar4 = iVarG;
                iVar4.P();
                iVar4.r();
                i12 = 0;
                i13 = i15;
            }
            iVar2 = iVarG;
            iVar2.P();
        } else {
            iVar2 = iVarG;
            iVar2.x(-1087289120);
            f(item, tVar, iVar2, (i11 & 112) | 8);
            iVar2.P();
        }
        e0.a(SizeKt.e(f.f3863a, q2.i.h(32)), iVar2, 6);
        iVar2.r();
        if (k.J()) {
            k.R();
        }
        g2 g2VarJ = iVar2.j();
        if (g2VarJ == null) {
            return;
        }
        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$FilterItemView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i iVar5, Integer num) {
                invoke(iVar5, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(i iVar5, int i16) {
                MultiFilterPopupWindowKt.b(item, tVar, iVar5, v1.a(i11 | 1));
            }
        });
    }

    public static final void c(final Item item, final FilterVal filterVal, final t<String, String> tVar, final f fVar, i iVar, final int i11) {
        long jA;
        long jA2;
        i iVarG = iVar.g(973616320);
        if (k.J()) {
            k.S(973616320, i11, -1, "com.transsion.home.view.filter.popup.GridItem (MultiFilterPopupWindow.kt:285)");
        }
        if (Intrinsics.b(tVar.get(item.getFilterType()), filterVal.getId())) {
            iVarG.x(-1478940177);
            jA = c.a(R$color.white, iVarG, 0);
            jA2 = c.a(com.transsion.wrapperad.R$color.white_40, iVarG, 0);
            iVarG.P();
        } else {
            iVarG.x(-1478940027);
            jA = c.a(R$color.text_03, iVarG, 0);
            jA2 = c.a(R$color.transparent, iVarG, 0);
            iVarG.P();
        }
        androidx.compose.ui.b bVarD = androidx.compose.ui.b.f3770a.d();
        float f11 = 100;
        f fVarD = ClickableKt.d(BackgroundKt.a(BorderKt.e(SizeKt.e(fVar, q2.i.h(32)), q2.i.h(1), jA, p1.g.c(q2.i.h(f11))), jA2, p1.g.c(q2.i.h(f11))), false, null, null, new Function0<Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$GridItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                tVar.put(item.getFilterType(), filterVal.getId());
            }
        }, 7, null);
        u uVarH = BoxKt.h(bVarD, false);
        int iA = g.a(iVarG, 0);
        s sVarN = iVarG.n();
        f fVarE = ComposedModifierKt.e(iVarG, fVarD);
        ComposeUiNode.Companion companion = ComposeUiNode.f4919a8;
        Function0<ComposeUiNode> function0A = companion.a();
        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
            g.b();
        }
        iVarG.D();
        if (iVarG.e()) {
            iVarG.G(function0A);
        } else {
            iVarG.o();
        }
        i iVarA = f3.a(iVarG);
        f3.b(iVarA, uVarH, companion.c());
        f3.b(iVarA, sVarN, companion.e());
        Function2<ComposeUiNode, Integer, Unit> function2B = companion.b();
        if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA))) {
            iVarA.p(Integer.valueOf(iA));
            iVarA.k(Integer.valueOf(iA), function2B);
        }
        f3.b(iVarA, fVarE, companion.d());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.f2386a;
        TextKt.a(filterVal.getName(), null, c.a(R$color.white, iVarG, 0), x.c(14), null, androidx.compose.ui.text.font.u.f5860b.c(), androidx.compose.ui.text.font.i.f5821b.b(), 0L, null, null, 0L, 0, false, 0, 0, null, null, iVarG, 199680, 0, 130962);
        iVarG.r();
        if (k.J()) {
            k.R();
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ == null) {
            return;
        }
        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$GridItem$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                invoke(iVar2, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(i iVar2, int i12) {
                MultiFilterPopupWindowKt.c(item, filterVal, tVar, fVar, iVar2, v1.a(i11 | 1));
            }
        });
    }

    public static final void d(final List<Item> filterItems, final t<String, String> selectItems, final Function1<? super Boolean, Unit> dismiss, i iVar, final int i11) {
        Intrinsics.g(filterItems, "filterItems");
        Intrinsics.g(selectItems, "selectItems");
        Intrinsics.g(dismiss, "dismiss");
        i iVarG = iVar.g(1096788014);
        if (k.J()) {
            k.S(1096788014, i11, -1, "com.transsion.home.view.filter.popup.MultiFilterPopup (MultiFilterPopupWindow.kt:57)");
        }
        final ag.c cVarE = SystemUiControllerKt.e(null, iVarG, 0, 1);
        final long jA = c.a(R$color.black_80, iVarG, 0);
        Handler handler = new Handler(Looper.getMainLooper());
        w1 w1VarG = w1.g(jA);
        boolean zQ = iVarG.Q(w1VarG) | iVarG.Q(cVarE);
        Object objY = iVarG.y();
        if (zQ || objY == i.f3413a.a()) {
            objY = new Function0<Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$MultiFilterPopup$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ag.b.b(cVarE, jA, false, false, null, 14, null);
                }
            };
            iVarG.p(objY);
        }
        final Function0 function0 = (Function0) objY;
        handler.postDelayed(new Runnable() { // from class: com.transsion.home.view.filter.popup.a
            @Override // java.lang.Runnable
            public final void run() {
                MultiFilterPopupWindowKt.e(function0);
            }
        }, 100L);
        boolean zQ2 = iVarG.Q(cVarE) | iVarG.Q(dismiss);
        Object objY2 = iVarG.y();
        if (zQ2 || objY2 == i.f3413a.a()) {
            objY2 = new Function1<Boolean, Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$MultiFilterPopup$closePopup$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    ag.b.b(cVarE, w1.f4564b.d(), false, false, null, 14, null);
                    dismiss.invoke(Boolean.valueOf(z11));
                }
            };
            iVarG.p(objY2);
        }
        final Function1 function1 = (Function1) objY2;
        final t tVar = new t();
        tVar.putAll(selectItems);
        boolean zQ3 = iVarG.Q(function1);
        Object objY3 = iVarG.y();
        if (zQ3 || objY3 == i.f3413a.a()) {
            objY3 = new Function0<Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$MultiFilterPopup$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    function1.invoke(Boolean.FALSE);
                }
            };
            iVarG.p(objY3);
        }
        AndroidDialog_androidKt.a((Function0) objY3, new androidx.compose.ui.window.c(false, false, false, 3, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.b.b(iVarG, -1419240635, true, new Function2<i, Integer, Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$MultiFilterPopup$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                invoke(iVar2, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(i iVar2, int i12) {
                if ((i12 & 11) == 2 && iVar2.h()) {
                    iVar2.H();
                    return;
                }
                if (k.J()) {
                    k.S(-1419240635, i12, -1, "com.transsion.home.view.filter.popup.MultiFilterPopup.<anonymous> (MultiFilterPopupWindow.kt:85)");
                }
                f.a aVar = f.f3863a;
                f fVarB = SizeKt.b(BackgroundKt.b(aVar, jA, null, 2, null), 0.0f, 1, null);
                final Function1<Boolean, Unit> function2 = function1;
                final List<Item> list = filterItems;
                final t<String, String> tVar2 = tVar;
                final t<String, String> tVar3 = selectItems;
                androidx.compose.ui.b.a aVar2 = androidx.compose.ui.b.f3770a;
                u uVarH = BoxKt.h(aVar2.m(), false);
                int iA = g.a(iVar2, 0);
                s sVarN = iVar2.n();
                f fVarE = ComposedModifierKt.e(iVar2, fVarB);
                ComposeUiNode.Companion companion = ComposeUiNode.f4919a8;
                Function0<ComposeUiNode> function0A = companion.a();
                if (!(iVar2.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVar2.D();
                if (iVar2.e()) {
                    iVar2.G(function0A);
                } else {
                    iVar2.o();
                }
                i iVarA = f3.a(iVar2);
                f3.b(iVarA, uVarH, companion.c());
                f3.b(iVarA, sVarN, companion.e());
                Function2<ComposeUiNode, Integer, Unit> function2B = companion.b();
                if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA))) {
                    iVarA.p(Integer.valueOf(iA));
                    iVarA.k(Integer.valueOf(iA), function2B);
                }
                f3.b(iVarA, fVarE, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f2386a;
                androidx.compose.foundation.layout.b bVar = androidx.compose.foundation.layout.b.f2478a;
                u uVarA = androidx.compose.foundation.layout.i.a(bVar.d(), aVar2.i(), iVar2, 0);
                int iA2 = g.a(iVar2, 0);
                s sVarN2 = iVar2.n();
                f fVarE2 = ComposedModifierKt.e(iVar2, aVar);
                Function0<ComposeUiNode> function0A2 = companion.a();
                if (!(iVar2.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVar2.D();
                if (iVar2.e()) {
                    iVar2.G(function0A2);
                } else {
                    iVar2.o();
                }
                i iVarA2 = f3.a(iVar2);
                f3.b(iVarA2, uVarA, companion.c());
                f3.b(iVarA2, sVarN2, companion.e());
                Function2<ComposeUiNode, Integer, Unit> function2B2 = companion.b();
                if (iVarA2.e() || !Intrinsics.b(iVarA2.y(), Integer.valueOf(iA2))) {
                    iVarA2.p(Integer.valueOf(iA2));
                    iVarA2.k(Integer.valueOf(iA2), function2B2);
                }
                f3.b(iVarA2, fVarE2, companion.d());
                l lVar = l.f2502a;
                float f11 = 12;
                float f12 = 16;
                f fVarF = PaddingKt.f(aVar, q2.i.h(f12), q2.i.h(f11));
                u uVarB = a0.b(bVar.c(), aVar2.j(), iVar2, 0);
                int iA3 = g.a(iVar2, 0);
                s sVarN3 = iVar2.n();
                f fVarE3 = ComposedModifierKt.e(iVar2, fVarF);
                Function0<ComposeUiNode> function0A3 = companion.a();
                if (!(iVar2.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVar2.D();
                if (iVar2.e()) {
                    iVar2.G(function0A3);
                } else {
                    iVar2.o();
                }
                i iVarA3 = f3.a(iVar2);
                f3.b(iVarA3, uVarB, companion.c());
                f3.b(iVarA3, sVarN3, companion.e());
                Function2<ComposeUiNode, Integer, Unit> function2B3 = companion.b();
                if (iVarA3.e() || !Intrinsics.b(iVarA3.y(), Integer.valueOf(iA3))) {
                    iVarA3.p(Integer.valueOf(iA3));
                    iVarA3.k(Integer.valueOf(iA3), function2B3);
                }
                f3.b(iVarA3, fVarE3, companion.d());
                d0 d0Var = d0.f2491a;
                String strA = k2.i.a(R$string.filter_more_title, iVar2, 0);
                androidx.compose.ui.text.font.i.a aVar3 = androidx.compose.ui.text.font.i.f5821b;
                androidx.compose.ui.text.font.x xVarB = aVar3.b();
                androidx.compose.ui.text.font.u.a aVar4 = androidx.compose.ui.text.font.u.f5860b;
                androidx.compose.ui.text.font.u uVarE = aVar4.e();
                int iB = p.f6143a.b();
                TextKt.a(strA, b0.a(d0Var, SizeKt.l(aVar, q2.i.h(0)), 1.0f, false, 2, null), w1.f4564b.f(), x.c(18), null, uVarE, xVarB, 0L, null, null, 0L, iB, false, 0, 0, null, null, iVar2, 200064, 48, 128912);
                e0.a(SizeKt.l(aVar, q2.i.h(f11)), iVar2, 6);
                Painter painterC = k2.f.c(R$drawable.music_iv_close, iVar2, 0);
                long jA2 = c.a(R$color.white, iVar2, 0);
                float f13 = 21;
                f fVarE4 = SizeKt.e(SizeKt.l(aVar, q2.i.h(f13)), q2.i.h(f13));
                boolean zQ4 = iVar2.Q(function2);
                Object objY4 = iVar2.y();
                if (zQ4 || objY4 == i.f3413a.a()) {
                    objY4 = new Function0<Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$MultiFilterPopup$3$1$1$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function2.invoke(Boolean.FALSE);
                        }
                    };
                    iVar2.p(objY4);
                }
                IconKt.a(painterC, "open", ClickableKt.d(fVarE4, false, null, null, (Function0) objY4, 7, null), jA2, iVar2, 56, 0);
                iVar2.r();
                float f14 = 1;
                DividerKt.a(null, c.a(R$color.white_10, iVar2, 0), q2.i.h(f14), 0.0f, iVar2, 384, 9);
                e0.a(SizeKt.e(aVar, q2.i.h(f11)), iVar2, 6);
                LazyDslKt.a(SizeKt.d(PaddingKt.g(j.a(lVar, aVar, 1.0f, false, 2, null), q2.i.h(f12), 0.0f, 2, null), 0.0f, 1, null), null, null, false, null, null, null, false, new Function1<androidx.compose.foundation.lazy.u, Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$MultiFilterPopup$3$1$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.u uVar) {
                        invoke2(uVar);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(androidx.compose.foundation.lazy.u LazyColumn) {
                        Intrinsics.g(LazyColumn, "$this$LazyColumn");
                        List<Item> list2 = list;
                        final t<String, String> tVar4 = tVar2;
                        for (final Item item : list2) {
                            androidx.compose.foundation.lazy.t.a(LazyColumn, item.getFilterType(), null, androidx.compose.runtime.internal.b.c(807301957, true, new Function3<androidx.compose.foundation.lazy.b, i, Integer, Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$MultiFilterPopup$3$1$1$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.b bVar2, i iVar3, Integer num) {
                                    invoke(bVar2, iVar3, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(androidx.compose.foundation.lazy.b item2, i iVar3, int i13) {
                                    Intrinsics.g(item2, "$this$item");
                                    if ((i13 & 81) == 16 && iVar3.h()) {
                                        iVar3.H();
                                        return;
                                    }
                                    if (k.J()) {
                                        k.S(807301957, i13, -1, "com.transsion.home.view.filter.popup.MultiFilterPopup.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultiFilterPopupWindow.kt:136)");
                                    }
                                    MultiFilterPopupWindowKt.b(item, tVar4, iVar3, 8);
                                    if (k.J()) {
                                        k.R();
                                    }
                                }
                            }), 2, null);
                        }
                    }
                }, iVar2, 0, 254);
                DividerKt.a(null, c.a(R$color.white_10, iVar2, 0), q2.i.h(f14), 0.0f, iVar2, 384, 9);
                e0.a(SizeKt.e(aVar, q2.i.h(f11)), iVar2, 6);
                f fVarG = PaddingKt.g(aVar, q2.i.h(f12), 0.0f, 2, null);
                u uVarB2 = a0.b(bVar.c(), aVar2.j(), iVar2, 0);
                int iA4 = g.a(iVar2, 0);
                s sVarN4 = iVar2.n();
                f fVarE5 = ComposedModifierKt.e(iVar2, fVarG);
                Function0<ComposeUiNode> function0A4 = companion.a();
                if (!(iVar2.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVar2.D();
                if (iVar2.e()) {
                    iVar2.G(function0A4);
                } else {
                    iVar2.o();
                }
                i iVarA4 = f3.a(iVar2);
                f3.b(iVarA4, uVarB2, companion.c());
                f3.b(iVarA4, sVarN4, companion.e());
                Function2<ComposeUiNode, Integer, Unit> function2B4 = companion.b();
                if (iVarA4.e() || !Intrinsics.b(iVarA4.y(), Integer.valueOf(iA4))) {
                    iVarA4.p(Integer.valueOf(iA4));
                    iVarA4.k(Integer.valueOf(iA4), function2B4);
                }
                f3.b(iVarA4, fVarE5, companion.d());
                androidx.compose.ui.b.InterfaceC0052b interfaceC0052bF = aVar2.f();
                androidx.compose.foundation.layout.b.e eVarB = bVar.b();
                float f15 = 48;
                float f16 = 100;
                f fVarD = ClickableKt.d(BorderKt.e(SizeKt.e(aVar, q2.i.h(f15)), q2.i.h(f14), c.a(R$color.white, iVar2, 0), p1.g.c(q2.i.h(f16))), false, null, null, new Function0<Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$MultiFilterPopup$3$1$1$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MultiFilterPopupWindowKt.u(list, tVar2);
                    }
                }, 7, null);
                u uVarA2 = androidx.compose.foundation.layout.i.a(eVarB, interfaceC0052bF, iVar2, 54);
                int iA5 = g.a(iVar2, 0);
                s sVarN5 = iVar2.n();
                f fVarE6 = ComposedModifierKt.e(iVar2, fVarD);
                Function0<ComposeUiNode> function0A5 = companion.a();
                if (!(iVar2.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVar2.D();
                if (iVar2.e()) {
                    iVar2.G(function0A5);
                } else {
                    iVar2.o();
                }
                i iVarA5 = f3.a(iVar2);
                f3.b(iVarA5, uVarA2, companion.c());
                f3.b(iVarA5, sVarN5, companion.e());
                Function2<ComposeUiNode, Integer, Unit> function2B5 = companion.b();
                if (iVarA5.e() || !Intrinsics.b(iVarA5.y(), Integer.valueOf(iA5))) {
                    iVarA5.p(Integer.valueOf(iA5));
                    iVarA5.k(Integer.valueOf(iA5), function2B5);
                }
                f3.b(iVarA5, fVarE6, companion.d());
                String strA2 = k2.i.a(R$string.filter_reset, iVar2, 0);
                long jC = x.c(18);
                androidx.compose.ui.text.font.x xVarB2 = aVar3.b();
                TextKt.a(strA2, PaddingKt.g(aVar, q2.i.h(24), 0.0f, 2, null), c.a(R$color.white, iVar2, 0), jC, null, aVar4.e(), xVarB2, 0L, null, null, 0L, 0, false, 0, 0, null, null, iVar2, 199728, 0, 130960);
                iVar2.r();
                e0.a(SizeKt.l(aVar, q2.i.h(f11)), iVar2, 6);
                androidx.compose.ui.b.InterfaceC0052b interfaceC0052bF2 = aVar2.f();
                androidx.compose.foundation.layout.b.e eVarB2 = bVar.b();
                f fVarA = BackgroundKt.a(b0.a(d0Var, SizeKt.e(aVar, q2.i.h(f15)), 1.0f, false, 2, null), c.a(R$color.white, iVar2, 0), p1.g.c(q2.i.h(f16)));
                boolean zQ5 = iVar2.Q(tVar3) | iVar2.Q(tVar2) | iVar2.Q(function2);
                Object objY5 = iVar2.y();
                if (zQ5 || objY5 == i.f3413a.a()) {
                    objY5 = new Function0<Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$MultiFilterPopup$3$1$1$3$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function2.invoke(Boolean.valueOf(MultiFilterPopupWindowKt.t(tVar3, tVar2)));
                        }
                    };
                    iVar2.p(objY5);
                }
                f fVarD2 = ClickableKt.d(fVarA, false, null, null, (Function0) objY5, 7, null);
                u uVarA3 = androidx.compose.foundation.layout.i.a(eVarB2, interfaceC0052bF2, iVar2, 54);
                int iA6 = g.a(iVar2, 0);
                s sVarN6 = iVar2.n();
                f fVarE7 = ComposedModifierKt.e(iVar2, fVarD2);
                Function0<ComposeUiNode> function0A6 = companion.a();
                if (!(iVar2.i() instanceof androidx.compose.runtime.f)) {
                    g.b();
                }
                iVar2.D();
                if (iVar2.e()) {
                    iVar2.G(function0A6);
                } else {
                    iVar2.o();
                }
                i iVarA6 = f3.a(iVar2);
                f3.b(iVarA6, uVarA3, companion.c());
                f3.b(iVarA6, sVarN6, companion.e());
                Function2<ComposeUiNode, Integer, Unit> function2B6 = companion.b();
                if (iVarA6.e() || !Intrinsics.b(iVarA6.y(), Integer.valueOf(iA6))) {
                    iVarA6.p(Integer.valueOf(iA6));
                    iVarA6.k(Integer.valueOf(iA6), function2B6);
                }
                f3.b(iVarA6, fVarE7, companion.d());
                TextKt.a(k2.i.a(R$string.filter_confirm, iVar2, 0), null, c.a(R$color.black, iVar2, 0), x.c(18), null, aVar4.e(), aVar3.b(), 0L, null, null, 0L, 0, false, 0, 0, null, null, iVar2, 199680, 0, 130962);
                iVar2.r();
                iVar2.r();
                e0.a(SizeKt.e(aVar, q2.i.h(f11)), iVar2, 6);
                iVar2.r();
                iVar2.r();
                if (k.J()) {
                    k.R();
                }
            }
        }), iVarG, 432, 0);
        if (k.J()) {
            k.R();
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ == null) {
            return;
        }
        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$MultiFilterPopup$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                invoke(iVar2, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(i iVar2, int i12) {
                MultiFilterPopupWindowKt.d(filterItems, selectItems, dismiss, iVar2, v1.a(i11 | 1));
            }
        });
    }

    public static final void e(Function0 tmp0) {
        Intrinsics.g(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static final void f(final Item item, final t<String, String> tVar, i iVar, final int i11) {
        String str;
        Float fK;
        String str2;
        Float fK2;
        i iVarG = iVar.g(-945657323);
        if (k.J()) {
            k.S(-945657323, i11, -1, "com.transsion.home.view.filter.popup.StepRangeSlider (MultiFilterPopupWindow.kt:337)");
        }
        RangeValue rangeVals = item.getRangeVals();
        Intrinsics.d(rangeVals);
        float minVal = rangeVals.getMinVal();
        float maxVal = rangeVals.getMaxVal();
        String str3 = tVar.get(item.getFilterType());
        List listE0 = str3 != null ? StringsKt__StringsKt.E0(str3, new String[]{","}, false, 0, 6, null) : null;
        if (listE0 != null && listE0.size() >= 2) {
            minVal = (listE0 == null || (str2 = (String) listE0.get(0)) == null || (fK2 = kotlin.text.j.k(str2)) == null) ? rangeVals.getMinVal() : fK2.floatValue();
            maxVal = (listE0 == null || (str = (String) listE0.get(1)) == null || (fK = kotlin.text.j.k(str)) == null) ? rangeVals.getMaxVal() : fK.floatValue();
        }
        Object objY = iVarG.y();
        i.a aVar = i.f3413a;
        if (objY == aVar.a()) {
            objY = u2.c(b20.c.b(minVal, maxVal), null, 2, null);
            iVarG.p(objY);
        }
        final i1 i1Var = (i1) objY;
        if (f52725c) {
            h(i1Var, b20.c.b(minVal, maxVal));
            f52725c = false;
        }
        f.a aVar2 = f.f3863a;
        androidx.compose.foundation.layout.b bVar = androidx.compose.foundation.layout.b.f2478a;
        androidx.compose.foundation.layout.b.k kVarD = bVar.d();
        androidx.compose.ui.b.a aVar3 = androidx.compose.ui.b.f3770a;
        u uVarA = androidx.compose.foundation.layout.i.a(kVarD, aVar3.i(), iVarG, 0);
        int iA = g.a(iVarG, 0);
        s sVarN = iVarG.n();
        f fVarE = ComposedModifierKt.e(iVarG, aVar2);
        ComposeUiNode.Companion companion = ComposeUiNode.f4919a8;
        Function0<ComposeUiNode> function0A = companion.a();
        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
            g.b();
        }
        iVarG.D();
        if (iVarG.e()) {
            iVarG.G(function0A);
        } else {
            iVarG.o();
        }
        i iVarA = f3.a(iVarG);
        f3.b(iVarA, uVarA, companion.c());
        f3.b(iVarA, sVarN, companion.e());
        Function2<ComposeUiNode, Integer, Unit> function2B = companion.b();
        if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA))) {
            iVarA.p(Integer.valueOf(iA));
            iVarA.k(Integer.valueOf(iA), function2B);
        }
        f3.b(iVarA, fVarE, companion.d());
        l lVar = l.f2502a;
        int iD = a20.b.d(g(i1Var).j().floatValue());
        int iD2 = a20.b.d(g(i1Var).f().floatValue());
        ClosedFloatingPointRange<Float> closedFloatingPointRangeG = g(i1Var);
        ClosedFloatingPointRange closedFloatingPointRangeB = b20.c.b(rangeVals.getMinVal(), rangeVals.getMaxVal());
        int maxVal2 = ((int) rangeVals.getMaxVal()) - 1;
        androidx.compose.material.j jVarA = androidx.compose.material.k.f3095a.a(c.a(R$color.white, iVarG, 0), 0L, c.a(R$color.white, iVarG, 0), 0L, c.a(R$color.white_40, iVarG, 0), 0L, c.a(R$color.transparent, iVarG, 0), c.a(R$color.transparent, iVarG, 0), 0L, 0L, iVarG, 0, androidx.compose.material.k.f3096b, 810);
        boolean zQ = iVarG.Q(i1Var);
        Object objY2 = iVarG.y();
        if (zQ || objY2 == aVar.a()) {
            objY2 = new Function1<ClosedFloatingPointRange<Float>, Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$StepRangeSlider$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
                    invoke2(closedFloatingPointRange);
                    return Unit.f68710a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ClosedFloatingPointRange<Float> it) {
                    Intrinsics.g(it, "it");
                    float fFloatValue = it.j().floatValue() == ((Number) MultiFilterPopupWindowKt.g(i1Var).j()).floatValue() ? it.f().floatValue() : it.j().floatValue();
                    if (((int) fFloatValue) != ((int) MultiFilterPopupWindowKt.f52724b)) {
                        k0.b(20L);
                    }
                    MultiFilterPopupWindowKt.f52724b = fFloatValue;
                    MultiFilterPopupWindowKt.h(i1Var, it);
                    if (it.j().floatValue() == it.f().floatValue()) {
                        MultiFilterPopupWindowKt.f52723a = it.j().floatValue();
                    }
                }
            };
            iVarG.p(objY2);
        }
        SliderKt.b(closedFloatingPointRangeG, (Function1) objY2, null, false, closedFloatingPointRangeB, maxVal2, new Function0<Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$StepRangeSlider$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (((Number) MultiFilterPopupWindowKt.g(i1Var).j()).floatValue() > ((Number) MultiFilterPopupWindowKt.g(i1Var).f()).floatValue()) {
                    MultiFilterPopupWindowKt.h(i1Var, b20.c.b(MultiFilterPopupWindowKt.f52723a, MultiFilterPopupWindowKt.f52723a));
                }
                tVar.put(item.getFilterType(), PopupFilterView.Companion.a(((Number) MultiFilterPopupWindowKt.g(i1Var).j()).floatValue(), ((Number) MultiFilterPopupWindowKt.g(i1Var).f()).floatValue()));
            }
        }, jVarA, iVarG, 0, 12);
        u uVarB = a0.b(bVar.c(), aVar3.j(), iVarG, 0);
        int iA2 = g.a(iVarG, 0);
        s sVarN2 = iVarG.n();
        f fVarE2 = ComposedModifierKt.e(iVarG, aVar2);
        Function0<ComposeUiNode> function0A2 = companion.a();
        if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
            g.b();
        }
        iVarG.D();
        if (iVarG.e()) {
            iVarG.G(function0A2);
        } else {
            iVarG.o();
        }
        i iVarA2 = f3.a(iVarG);
        f3.b(iVarA2, uVarB, companion.c());
        f3.b(iVarA2, sVarN2, companion.e());
        Function2<ComposeUiNode, Integer, Unit> function2B2 = companion.b();
        if (iVarA2.e() || !Intrinsics.b(iVarA2.y(), Integer.valueOf(iA2))) {
            iVarA2.p(Integer.valueOf(iA2));
            iVarA2.k(Integer.valueOf(iA2), function2B2);
        }
        f3.b(iVarA2, fVarE2, companion.d());
        d0 d0Var = d0.f2491a;
        String strValueOf = String.valueOf(iD);
        long jC = x.c(12);
        androidx.compose.ui.text.font.i.a aVar4 = androidx.compose.ui.text.font.i.f5821b;
        androidx.compose.ui.text.font.x xVarB = aVar4.b();
        androidx.compose.ui.text.font.u.a aVar5 = androidx.compose.ui.text.font.u.f5860b;
        TextKt.a(strValueOf, PaddingKt.i(aVar2, q2.i.h(5), 0.0f, 0.0f, 0.0f, 14, null), c.a(R$color.white, iVarG, 0), jC, null, aVar5.e(), xVarB, 0L, null, null, 0L, 0, false, 0, 0, null, null, iVarG, 199728, 0, 130960);
        e0.a(b0.a(d0Var, aVar2, 1.0f, false, 2, null), iVarG, 0);
        TextKt.a(String.valueOf(iD2), null, c.a(R$color.white, iVarG, 0), x.c(12), null, aVar5.e(), aVar4.b(), 0L, null, null, 0L, 0, false, 0, 0, null, null, iVarG, 199680, 0, 130962);
        iVarG.r();
        iVarG.r();
        if (k.J()) {
            k.R();
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ == null) {
            return;
        }
        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: com.transsion.home.view.filter.popup.MultiFilterPopupWindowKt$StepRangeSlider$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                invoke(iVar2, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(i iVar2, int i12) {
                MultiFilterPopupWindowKt.f(item, tVar, iVar2, v1.a(i11 | 1));
            }
        });
    }

    public static final ClosedFloatingPointRange<Float> g(i1<ClosedFloatingPointRange<Float>> i1Var) {
        return i1Var.getValue();
    }

    public static final void h(i1<ClosedFloatingPointRange<Float>> i1Var, ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        i1Var.setValue(closedFloatingPointRange);
    }

    public static final boolean t(t<String, String> tVar, t<String, String> tVar2) {
        boolean z11 = false;
        for (Map.Entry<String, String> entry : tVar2.entrySet()) {
            if (!Intrinsics.b(tVar.get(entry.getKey()), entry.getValue())) {
                tVar.put(entry.getKey(), entry.getValue());
                z11 = true;
            }
        }
        return z11;
    }

    public static final void u(List<Item> list, t<String, String> tVar) {
        f52725c = true;
        for (Item item : list) {
            if (item.getRangeVals() != null) {
                tVar.put(item.getFilterType(), PopupFilterView.Companion.a(item.getRangeVals().getMinVal(), item.getRangeVals().getMaxVal()));
            } else if (!item.getFilterValsV2().isEmpty()) {
                tVar.put(item.getFilterType(), item.getFilterValsV2().get(0).getId());
            }
        }
    }
}
