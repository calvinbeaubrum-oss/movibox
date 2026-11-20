package com.transsion.member.task;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Build;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.b0;
import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.layout.e0;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.h2;
import androidx.compose.runtime.k;
import androidx.compose.runtime.s;
import androidx.compose.runtime.v1;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.u;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.y0;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.member.R$mipmap;
import com.transsion.member.R$string;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class TaskCompleteTips {
    public final void a(final int i11, final int i12, androidx.compose.runtime.i iVar, final int i13) {
        int i14;
        androidx.compose.runtime.i iVar2;
        androidx.compose.runtime.i iVarG = iVar.g(-1799667828);
        if ((i13 & 14) == 0) {
            i14 = (iVarG.c(i11) ? 4 : 2) | i13;
        } else {
            i14 = i13;
        }
        if ((i13 & 112) == 0) {
            i14 |= iVarG.c(i12) ? 32 : 16;
        }
        if ((i14 & 91) == 18 && iVarG.h()) {
            iVarG.H();
            iVar2 = iVarG;
        } else {
            if (k.J()) {
                k.S(-1799667828, i13, -1, "com.transsion.member.task.TaskCompleteTips.TaskCompleteView (TaskCompleteTips.kt:99)");
            }
            Painter painterC = k2.f.c(R$mipmap.ic_succeed, iVarG, 0);
            androidx.compose.ui.b.a aVar = androidx.compose.ui.b.f3770a;
            androidx.compose.ui.b.c cVarH = aVar.h();
            androidx.compose.ui.f.a aVar2 = androidx.compose.ui.f.f3863a;
            float f11 = 8;
            androidx.compose.ui.f fVarA = BackgroundKt.a(SizeKt.l(aVar2, q2.i.h(i11)), k2.c.a(R$color.white_90, iVarG, 0), p1.g.c(q2.i.h(f11)));
            iVarG.x(693286680);
            u uVarB = a0.b(androidx.compose.foundation.layout.b.f2478a.c(), cVarH, iVarG, 48);
            iVarG.x(-1323940314);
            int iA = androidx.compose.runtime.g.a(iVarG, 0);
            s sVarN = iVarG.n();
            ComposeUiNode.Companion companion = ComposeUiNode.f4919a8;
            Function0<ComposeUiNode> function0A = companion.a();
            Function3<h2<ComposeUiNode>, androidx.compose.runtime.i, Integer, Unit> function3A = LayoutKt.a(fVarA);
            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVarG.D();
            if (iVarG.e()) {
                iVarG.G(function0A);
            } else {
                iVarG.o();
            }
            androidx.compose.runtime.i iVarA = f3.a(iVarG);
            f3.b(iVarA, uVarB, companion.c());
            f3.b(iVarA, sVarN, companion.e());
            Function2<ComposeUiNode, Integer, Unit> function2B = companion.b();
            if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA))) {
                iVarA.p(Integer.valueOf(iA));
                iVarA.k(Integer.valueOf(iA), function2B);
            }
            function3A.invoke(h2.a(h2.b(iVarG)), iVarG, 0);
            iVarG.x(2058660585);
            d0 d0Var = d0.f2491a;
            float f12 = 16;
            e0.a(SizeKt.l(aVar2, q2.i.h(f12)), iVarG, 6);
            ImageKt.a(painterC, null, SizeKt.j(aVar2, q2.i.h(32)), null, null, 0.0f, null, iVarG, 440, 120);
            e0.a(SizeKt.l(aVar2, q2.i.h(f11)), iVarG, 6);
            String strB = k2.i.b(R$string.member_task_claim_toast, new Object[]{String.valueOf(i12)}, iVarG, 64);
            long jA = k2.c.a(R$color.gray_light_80, iVarG, 0);
            long jC = x.c(14);
            androidx.compose.ui.text.font.i.a aVar3 = androidx.compose.ui.text.font.i.f5821b;
            androidx.compose.ui.text.font.x xVarB = aVar3.b();
            androidx.compose.ui.text.font.u.a aVar4 = androidx.compose.ui.text.font.u.f5860b;
            TextKt.a(strB, b0.a(d0Var, PaddingKt.i(aVar2, 0.0f, q2.i.h(f12), 0.0f, q2.i.h(f12), 5, null), 1.0f, false, 2, null), jA, jC, null, aVar4.c(), xVarB, 0L, null, null, 0L, 0, false, 0, 0, null, null, iVarG, 199680, 0, 130960);
            e0.a(SizeKt.l(aVar2, q2.i.h(f11)), iVarG, 6);
            androidx.compose.ui.f fVarD = ClickableKt.d(BackgroundKt.a(SizeKt.e(SizeKt.l(aVar2, q2.i.h(64)), q2.i.h(28)), k2.c.a(R$color.yellow_light_50, iVarG, 0), p1.g.c(q2.i.h(6))), false, null, null, new Function0<Unit>() { // from class: com.transsion.member.task.TaskCompleteTips$TaskCompleteView$1$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (com.transsion.baseui.util.c.f51452a.a(0, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
                        return;
                    }
                    com.alibaba.android.arouter.launcher.a.d().b("/member/MemberActivity").withBoolean("extra_member_scroll_bottom", true).navigation();
                }
            }, 7, null);
            androidx.compose.ui.b bVarD = aVar.d();
            iVarG.x(733328855);
            u uVarJ = BoxKt.j(bVarD, false, iVarG, 6);
            iVarG.x(-1323940314);
            int iA2 = androidx.compose.runtime.g.a(iVarG, 0);
            s sVarN2 = iVarG.n();
            Function0<ComposeUiNode> function0A2 = companion.a();
            Function3<h2<ComposeUiNode>, androidx.compose.runtime.i, Integer, Unit> function3A2 = LayoutKt.a(fVarD);
            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVarG.D();
            if (iVarG.e()) {
                iVarG.G(function0A2);
            } else {
                iVarG.o();
            }
            androidx.compose.runtime.i iVarA2 = f3.a(iVarG);
            f3.b(iVarA2, uVarJ, companion.c());
            f3.b(iVarA2, sVarN2, companion.e());
            Function2<ComposeUiNode, Integer, Unit> function2B2 = companion.b();
            if (iVarA2.e() || !Intrinsics.b(iVarA2.y(), Integer.valueOf(iA2))) {
                iVarA2.p(Integer.valueOf(iA2));
                iVarA2.k(Integer.valueOf(iA2), function2B2);
            }
            function3A2.invoke(h2.a(h2.b(iVarG)), iVarG, 0);
            iVarG.x(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f2386a;
            iVar2 = iVarG;
            TextKt.a(k2.i.a(R$string.member_claim, iVarG, 0), null, k2.c.a(R$color.gray_dark_00, iVarG, 0), x.c(14), null, aVar4.d(), aVar3.b(), 0L, null, null, 0L, 0, false, 0, 0, null, null, iVar2, 199680, 0, 130962);
            iVar2.P();
            iVar2.r();
            iVar2.P();
            iVar2.P();
            e0.a(SizeKt.l(aVar2, q2.i.h(f12)), iVar2, 6);
            iVar2.P();
            iVar2.r();
            iVar2.P();
            iVar2.P();
            if (k.J()) {
                k.R();
            }
        }
        g2 g2VarJ = iVar2.j();
        if (g2VarJ == null) {
            return;
        }
        g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: com.transsion.member.task.TaskCompleteTips$TaskCompleteView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar3, Integer num) {
                invoke(iVar3, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(androidx.compose.runtime.i iVar3, int i15) {
                this.$tmp0_rcvr.a(i11, i12, iVar3, v1.a(i13 | 1));
            }
        });
    }

    public final boolean b(Activity activity) {
        return com.blankj.utilcode.util.d0.d(activity) > 0;
    }

    public final void c(final int i11) {
        boolean z11;
        RoomActivityLifecycleCallbacks roomActivityLifecycleCallbacks = RoomActivityLifecycleCallbacks.f51239a;
        Activity activityG = roomActivityLifecycleCallbacks.g();
        if (Build.VERSION.SDK_INT >= 24 && activityG != null && activityG.isInPictureInPictureMode()) {
            try {
                Result.Companion companion = Result.Companion;
                activityG = roomActivityLifecycleCallbacks.h(roomActivityLifecycleCallbacks.a() - 1);
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
        if (activityG == null || activityG.isDestroyed() || !((z11 = activityG instanceof androidx.lifecycle.u))) {
            return;
        }
        final int i12 = b(activityG) ? LogSeverity.WARNING_VALUE : activityG.getResources().getConfiguration().screenWidthDp - 32;
        ComposeView composeView = new ComposeView(activityG, null, 0, 6, null);
        ViewTreeLifecycleOwner.b(composeView, z11 ? (androidx.lifecycle.u) activityG : null);
        ViewTreeViewModelStoreOwner.b(composeView, activityG instanceof y0 ? (y0) activityG : null);
        ViewTreeSavedStateRegistryOwner.b(composeView, activityG instanceof f6.e ? (f6.e) activityG : null);
        composeView.setContent(androidx.compose.runtime.internal.b.c(1875731887, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: com.transsion.member.task.TaskCompleteTips$showTips$composeView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar, Integer num) {
                invoke(iVar, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(androidx.compose.runtime.i iVar, int i13) {
                if ((i13 & 11) == 2 && iVar.h()) {
                    iVar.H();
                    return;
                }
                if (k.J()) {
                    k.S(1875731887, i13, -1, "com.transsion.member.task.TaskCompleteTips.showTips.<anonymous>.<anonymous> (TaskCompleteTips.kt:76)");
                }
                this.this$0.a(i12, i11, iVar, 0);
                if (k.J()) {
                    k.R();
                }
            }
        }));
        composeView.setTag(Integer.valueOf(i12));
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(composeView, "translationY", -92.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(500L);
        com.tn.lib.widget.toast.core.b bVar = new com.tn.lib.widget.toast.core.b(activityG);
        bVar.c(composeView);
        bVar.setDuration(1);
        bVar.setGravity(48, 0, 62);
        bVar.show();
        objectAnimatorOfFloat.start();
    }
}
