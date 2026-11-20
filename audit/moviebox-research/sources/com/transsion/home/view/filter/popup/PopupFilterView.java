package com.transsion.home.view.filter.popup;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.b0;
import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.layout.e0;
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
import androidx.compose.ui.layout.u;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.text.style.p;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.y0;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$drawable;
import com.transsion.home.R$mipmap;
import com.transsion.home.bean.Item;
import f6.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k2.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.x;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class PopupFilterView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t<String, String> f52726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Map<String, String>, Unit> f52727b;
    public static final a Companion = new a(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(float f11, float f12) {
            return ((int) f11) + "," + ((int) f12);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupFilterView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f52726a = new t<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        this.f52726a = new t<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupFilterView(Context context, AttributeSet attrs, int i11) {
        super(context, attrs, i11);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        this.f52726a = new t<>();
    }

    public static final String a(i1<String> i1Var) {
        return i1Var.getValue();
    }

    public static final void b(i1<String> i1Var, String str) {
        i1Var.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initSelectData$default(PopupFilterView popupFilterView, List list, HashMap map, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            map = null;
        }
        popupFilterView.initSelectData(list, map);
    }

    public final void FilterLinear(final List<Item> list, i iVar, final int i11) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i12;
        int i13;
        i iVar2;
        i1 i1Var;
        ArrayList arrayList3;
        int i14;
        long jA;
        long jA2;
        final i1 i1Var2;
        long jA3;
        i iVarG = iVar.g(541655127);
        if (k.J()) {
            k.S(541655127, i11, -1, "com.transsion.home.view.filter.popup.PopupFilterView.FilterLinear (PopupFilterView.kt:127)");
        }
        if (list != null) {
            arrayList = new ArrayList();
            for (Object obj : list) {
                Item item = (Item) obj;
                if (Intrinsics.b(item.getShowOut(), "true") && item.getRangeVals() == null) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        if (list != null) {
            arrayList2 = new ArrayList();
            for (Object obj2 : list) {
                if (Intrinsics.b(((Item) obj2).getShowOut(), "false")) {
                    arrayList2.add(obj2);
                }
            }
        } else {
            arrayList2 = new ArrayList();
        }
        ArrayList arrayList4 = arrayList2;
        Iterator it = arrayList4.iterator();
        while (true) {
            i12 = 1;
            i13 = 0;
            if (!it.hasNext()) {
                break;
            }
            Item item2 = (Item) it.next();
            if ((!item2.getFilterValsV2().isEmpty()) && this.f52726a.get(item2.getFilterType()) == null) {
                this.f52726a.put(item2.getFilterType(), item2.getFilterValsV2().get(0).getId());
            }
        }
        Object objY = iVarG.y();
        if (objY == i.f3413a.a()) {
            objY = u2.c("", null, 2, null);
            iVarG.p(objY);
        }
        final i1 i1Var3 = (i1) objY;
        f fVarP = SizeKt.p(SizeKt.d(f.f3863a, 0.0f, 1, null), null, false, 3, null);
        u uVarB = a0.b(androidx.compose.foundation.layout.b.f2478a.c(), androidx.compose.ui.b.f3770a.h(), iVarG, 48);
        int iA = g.a(iVarG, 0);
        s sVarN = iVarG.n();
        f fVarE = ComposedModifierKt.e(iVarG, fVarP);
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
        f3.b(iVarA, uVarB, companion.c());
        f3.b(iVarA, sVarN, companion.e());
        Function2<ComposeUiNode, Integer, Unit> function2B = companion.b();
        if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA))) {
            iVarA.p(Integer.valueOf(iA));
            iVarA.k(Integer.valueOf(iA), function2B);
        }
        f3.b(iVarA, fVarE, companion.d());
        d0 d0Var = d0.f2491a;
        int size = arrayList != null ? arrayList.size() : 1;
        float f11 = ((((Configuration) iVarG.l(AndroidCompositionLocals_androidKt.f())).screenWidthDp - ((size * 46) + 52.0f)) / size) + 2;
        iVarG.x(1426221333);
        int i15 = 8;
        if (arrayList == null) {
            iVar2 = iVarG;
            i1Var = i1Var3;
            arrayList3 = arrayList4;
            i14 = 0;
        } else {
            int i16 = 0;
            for (Object obj3 : arrayList) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    kotlin.collections.g.u();
                }
                final Item item3 = (Item) obj3;
                String title = this.f52726a.get(item3.getFilterType());
                if (title == null) {
                    title = item3.getFilterValsV2().get(i13).getId();
                }
                if (((Intrinsics.b(title, item3.getFilterValsV2().get(i13).getId()) ? 1 : 0) ^ i12) != 0) {
                    iVarG.x(-934050269);
                    jA = c.a(R$color.white, iVarG, i13);
                    jA2 = c.a(com.transsion.wrapperad.R$color.white_40, iVarG, i13);
                    iVarG.P();
                } else {
                    iVarG.x(-934050022);
                    jA = c.a(R$color.text_03, iVarG, i13);
                    jA2 = c.a(R$color.transparent, iVarG, i13);
                    title = item3.getTitle();
                    iVarG.P();
                }
                ArrayList arrayList5 = arrayList4;
                long j11 = jA2;
                String str = title;
                iVarG.x(1426222257);
                if (Intrinsics.b(a(i1Var3), item3.getFilterType())) {
                    SingleFilterPopupWindowKt.b(item3, str, new Function1<String, Unit>() { // from class: com.transsion.home.view.filter.popup.PopupFilterView$FilterLinear$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                            invoke2(str2);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String str2) {
                            if (str2 != null) {
                                PopupFilterView popupFilterView = this.this$0;
                                popupFilterView.f52726a.put(item3.getFilterType(), str2);
                                Function1 function1 = popupFilterView.f52727b;
                                if (function1 != null) {
                                    function1.invoke(popupFilterView.f52726a.j());
                                }
                            }
                            PopupFilterView.b(i1Var3, "");
                        }
                    }, iVarG, i15);
                }
                iVarG.P();
                androidx.compose.ui.b.c cVarH = androidx.compose.ui.b.f3770a.h();
                f.a aVar = f.f3863a;
                float f12 = i12;
                float f13 = 100;
                f fVarD = ClickableKt.d(BackgroundKt.a(BorderKt.e(SizeKt.e(aVar, q2.i.h(28)), q2.i.h(f12), jA, p1.g.c(q2.i.h(f13))), j11, p1.g.c(q2.i.h(f13))), false, null, null, new Function0<Unit>() { // from class: com.transsion.home.view.filter.popup.PopupFilterView$FilterLinear$2$1$2
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
                        PopupFilterView.b(i1Var3, item3.getFilterType());
                    }
                }, 7, null);
                u uVarB2 = a0.b(androidx.compose.foundation.layout.b.f2478a.c(), cVarH, iVarG, 48);
                int iA2 = g.a(iVarG, 0);
                s sVarN2 = iVarG.n();
                f fVarE2 = ComposedModifierKt.e(iVarG, fVarD);
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
                f3.b(iVarA2, uVarB2, companion2.c());
                f3.b(iVarA2, sVarN2, companion2.e());
                Function2<ComposeUiNode, Integer, Unit> function2B2 = companion2.b();
                if (iVarA2.e() || !Intrinsics.b(iVarA2.y(), Integer.valueOf(iA2))) {
                    iVarA2.p(Integer.valueOf(iA2));
                    iVarA2.k(Integer.valueOf(iA2), function2B2);
                }
                f3.b(iVarA2, fVarE2, companion2.d());
                d0 d0Var2 = d0.f2491a;
                e0.a(SizeKt.l(aVar, q2.i.h(12)), iVarG, 6);
                i iVar3 = iVarG;
                TextKt.a(str, SizeKt.n(aVar, 0.0f, q2.i.h(f11), 1, null), c.a(R$color.white, iVarG, 0), x.c(14), null, androidx.compose.ui.text.font.u.f5860b.c(), androidx.compose.ui.text.font.i.f5821b.b(), 0L, null, null, 0L, p.f6143a.b(), false, 1, 0, null, null, iVar3, 199680, 3120, 120720);
                IconKt.a(k2.f.c(R$drawable.ic_arrow_down, iVar3, 0), "open", PaddingKt.i(SizeKt.e(SizeKt.l(aVar, q2.i.h(16)), q2.i.h(17)), 0.0f, q2.i.h(f12), 0.0f, 0.0f, 13, null), c.a(R$color.white, iVar3, 0), iVar3, 440, 0);
                e0.a(SizeKt.l(aVar, q2.i.h(10)), iVar3, 6);
                iVar3.r();
                e0.a(SizeKt.l(aVar, q2.i.h(8)), iVar3, 6);
                arrayList4 = arrayList5;
                iVarG = iVar3;
                i16 = i17;
                i1Var3 = i1Var3;
                i15 = 8;
                i12 = 1;
                i13 = 0;
            }
            iVar2 = iVarG;
            i1Var = i1Var3;
            arrayList3 = arrayList4;
            i14 = 0;
            Unit unit = Unit.f68710a;
        }
        iVar2.P();
        f.a aVar2 = f.f3863a;
        e0.a(b0.a(d0Var, SizeKt.l(aVar2, q2.i.h(i14)), 1.0f, false, 2, null), iVar2, i14);
        iVar2.x(1426224651);
        if (!arrayList3.isEmpty()) {
            if (c(list)) {
                iVar2.x(1426224740);
                jA3 = c.a(R$color.brand, iVar2, i14);
                iVar2.P();
            } else {
                iVar2.x(1426224837);
                jA3 = c.a(R$color.white, iVar2, i14);
                iVar2.P();
            }
            long j12 = jA3;
            Painter painterC = k2.f.c(R$mipmap.ic_sub_operation_filter, iVar2, i14);
            float f14 = 24;
            f fVarE3 = SizeKt.e(SizeKt.l(aVar2, q2.i.h(f14)), q2.i.h(f14));
            i1Var2 = i1Var;
            boolean zQ = iVar2.Q(i1Var2);
            Object objY2 = iVar2.y();
            if (zQ || objY2 == i.f3413a.a()) {
                objY2 = new Function0<Unit>() { // from class: com.transsion.home.view.filter.popup.PopupFilterView$FilterLinear$2$2$1
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
                        PopupFilterView.b(i1Var2, "multi");
                    }
                };
                iVar2.p(objY2);
            }
            IconKt.a(painterC, "filter", ClickableKt.d(fVarE3, false, null, null, (Function0) objY2, 7, null), j12, iVar2, 56, 0);
        } else {
            i1Var2 = i1Var;
        }
        iVar2.P();
        iVar2.x(848671703);
        if (Intrinsics.b(a(i1Var2), "multi")) {
            MultiFilterPopupWindowKt.d(arrayList3, this.f52726a, new Function1<Boolean, Unit>() { // from class: com.transsion.home.view.filter.popup.PopupFilterView$FilterLinear$2$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    Function1 function1;
                    PopupFilterView.b(i1Var2, "");
                    if (!z11 || (function1 = this.this$0.f52727b) == null) {
                        return;
                    }
                    function1.invoke(this.this$0.f52726a.j());
                }
            }, iVar2, 8);
        }
        iVar2.P();
        iVar2.r();
        if (k.J()) {
            k.R();
        }
        g2 g2VarJ = iVar2.j();
        if (g2VarJ == null) {
            return;
        }
        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: com.transsion.home.view.filter.popup.PopupFilterView.FilterLinear.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i iVar4, Integer num) {
                invoke(iVar4, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(i iVar4, int i18) {
                PopupFilterView.this.FilterLinear(list, iVar4, v1.a(i11 | 1));
            }
        });
    }

    public final boolean c(List<Item> list) {
        if (list != null) {
            for (Item item : list) {
                String str = this.f52726a.get(item.getFilterType());
                if (item.getRangeVals() == null && Intrinsics.b(item.getShowOut(), "false")) {
                    if (str != null && !Intrinsics.b(str, item.getFilterValsV2().get(0).getId())) {
                        return true;
                    }
                } else if (item.getRangeVals() != null) {
                    String strA = Companion.a(item.getRangeVals().getMinVal(), item.getRangeVals().getMaxVal());
                    if (str != null && !Intrinsics.b(str, strA)) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public final void initSelectData(final List<Item> list, HashMap<String, String> map) {
        List<Item> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            so.c.g(this);
        } else {
            so.c.k(this);
        }
        removeAllViews();
        this.f52726a.clear();
        if (map != null) {
            this.f52726a.putAll(map);
        }
        Context context = getContext();
        Intrinsics.f(context, "context");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        Object context2 = composeView.getContext();
        ViewTreeLifecycleOwner.b(composeView, context2 instanceof androidx.lifecycle.u ? (androidx.lifecycle.u) context2 : null);
        Object context3 = composeView.getContext();
        ViewTreeViewModelStoreOwner.b(composeView, context3 instanceof y0 ? (y0) context3 : null);
        Object context4 = composeView.getContext();
        ViewTreeSavedStateRegistryOwner.b(composeView, context4 instanceof e ? (e) context4 : null);
        composeView.setContent(androidx.compose.runtime.internal.b.c(486758898, true, new Function2<i, Integer, Unit>() { // from class: com.transsion.home.view.filter.popup.PopupFilterView$initSelectData$composeView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i iVar, Integer num) {
                invoke(iVar, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(i iVar, int i11) {
                if ((i11 & 11) == 2 && iVar.h()) {
                    iVar.H();
                    return;
                }
                if (k.J()) {
                    k.S(486758898, i11, -1, "com.transsion.home.view.filter.popup.PopupFilterView.initSelectData.<anonymous>.<anonymous> (PopupFilterView.kt:93)");
                }
                this.this$0.FilterLinear(list, iVar, 72);
                if (k.J()) {
                    k.R();
                }
            }
        }));
        addView(composeView);
    }

    public final void setOnFilterListener(Function1<? super Map<String, String>, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f52727b = callback;
    }
}
