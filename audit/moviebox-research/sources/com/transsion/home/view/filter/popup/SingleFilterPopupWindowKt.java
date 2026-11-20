package com.transsion.home.view.filter.popup;

import ag.c;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.lazy.t;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.s;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.layout.u;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.x;
import androidx.compose.ui.text.style.p;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import com.tn.lib.widget.R$color;
import com.transsion.home.bean.FilterVal;
import com.transsion.home.bean.Item;
import com.transsion.videodetail.R$drawable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class SingleFilterPopupWindowKt {
    public static final void b(final Item filterItem, final String title, final Function1<? super String, Unit> dismiss, i iVar, final int i11) {
        Intrinsics.g(filterItem, "filterItem");
        Intrinsics.g(title, "title");
        Intrinsics.g(dismiss, "dismiss");
        i iVarG = iVar.g(666133991);
        if (k.J()) {
            k.S(666133991, i11, -1, "com.transsion.home.view.filter.popup.SingleSelectFilter (SingleFilterPopupWindow.kt:40)");
        }
        final c cVarE = SystemUiControllerKt.e(null, iVarG, 0, 1);
        final long jA = k2.c.a(R$color.black_80, iVarG, 0);
        Handler handler = new Handler(Looper.getMainLooper());
        w1 w1VarG = w1.g(jA);
        boolean zQ = iVarG.Q(w1VarG) | iVarG.Q(cVarE);
        Object objY = iVarG.y();
        if (zQ || objY == i.f3413a.a()) {
            objY = new Function0<Unit>() { // from class: com.transsion.home.view.filter.popup.SingleFilterPopupWindowKt$SingleSelectFilter$1$1
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
        handler.postDelayed(new Runnable() { // from class: com.transsion.home.view.filter.popup.b
            @Override // java.lang.Runnable
            public final void run() {
                SingleFilterPopupWindowKt.c(function0);
            }
        }, 100L);
        boolean zQ2 = iVarG.Q(cVarE) | iVarG.Q(dismiss);
        Object objY2 = iVarG.y();
        if (zQ2 || objY2 == i.f3413a.a()) {
            objY2 = new Function1<String, Unit>() { // from class: com.transsion.home.view.filter.popup.SingleFilterPopupWindowKt$SingleSelectFilter$closePopup$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    ag.b.b(cVarE, w1.f4564b.d(), false, false, null, 14, null);
                    dismiss.invoke(str);
                }
            };
            iVarG.p(objY2);
        }
        final Function1 function1 = (Function1) objY2;
        boolean zQ3 = iVarG.Q(function1);
        Object objY3 = iVarG.y();
        if (zQ3 || objY3 == i.f3413a.a()) {
            objY3 = new Function0<Unit>() { // from class: com.transsion.home.view.filter.popup.SingleFilterPopupWindowKt$SingleSelectFilter$2$1
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
                    function1.invoke(null);
                }
            };
            iVarG.p(objY3);
        }
        AndroidDialog_androidKt.a((Function0) objY3, new androidx.compose.ui.window.c(false, false, false, 3, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.b.b(iVarG, -800641360, true, new Function2<i, Integer, Unit>() { // from class: com.transsion.home.view.filter.popup.SingleFilterPopupWindowKt$SingleSelectFilter$3
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
                    k.S(-800641360, i12, -1, "com.transsion.home.view.filter.popup.SingleSelectFilter.<anonymous> (SingleFilterPopupWindow.kt:64)");
                }
                f.a aVar = f.f3863a;
                f fVarB = SizeKt.b(BackgroundKt.b(aVar, jA, null, 2, null), 0.0f, 1, null);
                String str = title;
                int i13 = i11;
                final Function1<String, Unit> function2 = function1;
                final Item item = filterItem;
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
                final l lVar = l.f2502a;
                float f11 = 12;
                f fVarF = PaddingKt.f(aVar, q2.i.h(16), q2.i.h(f11));
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
                x xVarB = androidx.compose.ui.text.font.i.f5821b.b();
                androidx.compose.ui.text.font.u uVarE = androidx.compose.ui.text.font.u.f5860b.e();
                int iB = p.f6143a.b();
                TextKt.a(str, b0.a(d0Var, SizeKt.l(aVar, q2.i.h(0)), 1.0f, false, 2, null), w1.f4564b.f(), q2.x.c(18), null, uVarE, xVarB, 0L, null, null, 0L, iB, false, 0, 0, null, null, iVar2, ((i13 >> 3) & 14) | 200064, 48, 128912);
                e0.a(SizeKt.l(aVar, q2.i.h(f11)), iVar2, 6);
                Painter painterC = k2.f.c(R$drawable.music_iv_close, iVar2, 0);
                long jA2 = k2.c.a(R$color.white, iVar2, 0);
                float f12 = 21;
                f fVarE4 = SizeKt.e(SizeKt.l(aVar, q2.i.h(f12)), q2.i.h(f12));
                boolean zQ4 = iVar2.Q(function2);
                Object objY4 = iVar2.y();
                if (zQ4 || objY4 == i.f3413a.a()) {
                    objY4 = new Function0<Unit>() { // from class: com.transsion.home.view.filter.popup.SingleFilterPopupWindowKt$SingleSelectFilter$3$1$1$1$1$1
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
                            function2.invoke(null);
                        }
                    };
                    iVar2.p(objY4);
                }
                IconKt.a(painterC, "open", ClickableKt.d(fVarE4, false, null, null, (Function0) objY4, 7, null), jA2, iVar2, 56, 0);
                iVar2.r();
                DividerKt.a(null, q2.i.h(1), k2.c.a(R$color.white_10, iVar2, 0), iVar2, 48, 1);
                e0.a(SizeKt.e(aVar, q2.i.h(23)), iVar2, 6);
                LazyDslKt.a(SizeKt.d(j.a(lVar, aVar, 1.0f, false, 2, null), 0.0f, 1, null), null, null, false, null, null, null, false, new Function1<androidx.compose.foundation.lazy.u, Unit>() { // from class: com.transsion.home.view.filter.popup.SingleFilterPopupWindowKt$SingleSelectFilter$3$1$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        List<FilterVal> filterValsV2 = item.getFilterValsV2();
                        final androidx.compose.foundation.layout.k kVar = lVar;
                        final Function1<String, Unit> function3 = function2;
                        for (final FilterVal filterVal : filterValsV2) {
                            t.a(LazyColumn, filterVal.getId(), null, androidx.compose.runtime.internal.b.c(860266798, true, new Function3<androidx.compose.foundation.lazy.b, i, Integer, Unit>() { // from class: com.transsion.home.view.filter.popup.SingleFilterPopupWindowKt$SingleSelectFilter$3$1$1$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.b bVar2, i iVar3, Integer num) {
                                    invoke(bVar2, iVar3, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(androidx.compose.foundation.lazy.b item2, i iVar3, int i14) {
                                    Intrinsics.g(item2, "$this$item");
                                    if ((i14 & 81) == 16 && iVar3.h()) {
                                        iVar3.H();
                                        return;
                                    }
                                    if (k.J()) {
                                        k.S(860266798, i14, -1, "com.transsion.home.view.filter.popup.SingleSelectFilter.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SingleFilterPopupWindow.kt:113)");
                                    }
                                    String name = filterVal.getName();
                                    x xVarB2 = androidx.compose.ui.text.font.i.f5821b.b();
                                    androidx.compose.ui.text.font.u uVarB2 = androidx.compose.ui.text.font.u.f5860b.b();
                                    int iB2 = p.f6143a.b();
                                    long jC = q2.x.c(16);
                                    long jF = w1.f4564b.f();
                                    androidx.compose.foundation.layout.k kVar2 = kVar;
                                    f.a aVar3 = f.f3863a;
                                    f fVarB2 = kVar2.b(PaddingKt.g(SizeKt.d(aVar3, 0.0f, 1, null), q2.i.h(16), 0.0f, 2, null), androidx.compose.ui.b.f3770a.f());
                                    final Function1<String, Unit> function4 = function3;
                                    final FilterVal filterVal2 = filterVal;
                                    boolean zQ5 = iVar3.Q(function4) | iVar3.Q(filterVal2);
                                    Object objY5 = iVar3.y();
                                    if (zQ5 || objY5 == i.f3413a.a()) {
                                        objY5 = new Function0<Unit>() { // from class: com.transsion.home.view.filter.popup.SingleFilterPopupWindowKt$SingleSelectFilter$3$1$1$2$1$1$1$1
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
                                                function4.invoke(filterVal2.getId());
                                            }
                                        };
                                        iVar3.p(objY5);
                                    }
                                    TextKt.a(name, ClickableKt.d(fVarB2, false, null, null, (Function0) objY5, 7, null), jF, jC, null, uVarB2, xVarB2, 0L, null, null, 0L, iB2, false, 0, 0, null, null, iVar3, 200064, 48, 128912);
                                    e0.a(SizeKt.e(aVar3, q2.i.h(37)), iVar3, 6);
                                    if (k.J()) {
                                        k.R();
                                    }
                                }
                            }), 2, null);
                        }
                    }
                }, iVar2, 0, 254);
                e0.a(SizeKt.e(aVar, q2.i.h(40)), iVar2, 6);
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
        g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: com.transsion.home.view.filter.popup.SingleFilterPopupWindowKt$SingleSelectFilter$4
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
                SingleFilterPopupWindowKt.b(filterItem, title, dismiss, iVar2, v1.a(i11 | 1));
            }
        });
    }

    public static final void c(Function0 tmp0) {
        Intrinsics.g(tmp0, "$tmp0");
        tmp0.invoke();
    }
}
