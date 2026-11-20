package com.mbridge.msdk.splash.c;

import android.content.Context;
import android.view.View;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.dycreator.listener.DyCountDownListener;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.wrapper.DyAdType;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class c extends com.mbridge.msdk.splash.c.a {

    /* JADX INFO: renamed from: com.mbridge.msdk.splash.c.c$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f47038a;

        static {
            int[] iArr = new int[EAction.values().length];
            f47038a = iArr;
            try {
                iArr[EAction.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47038a[EAction.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47038a[EAction.NOTICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47038a[EAction.FEEDBACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f47039a = new c();
    }

    private c() {
    }

    @Override // com.mbridge.msdk.splash.c.a
    public final void a(List<String> list, final MBSplashView mBSplashView, final com.mbridge.msdk.splash.a.d dVar, final com.mbridge.msdk.splash.b.a aVar) {
        h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        final DyOption dyOptionBuild = new DyOption.Builder().campaignEx(dVar.c()).fileDirs(list).dyAdType(DyAdType.SPLASH).canSkip(dVar.d()).isScreenClick(dVar.g() == 1).isClickButtonVisible(dVar.f() == 0).isShakeVisible(dVar.i() == 1).isApkInfoVisible(dVar.h() == 0).isLogoVisible(dVar.m() == 1).shakeStrenght(dVar.j()).shakeTime(dVar.k()).orientation(dVar.l()).countDownTime(dVar.e()).adChoiceLink(ai.a(dVar.c())).build();
        mBSplashView.setDyCountDownListener(new DyCountDownListener() { // from class: com.mbridge.msdk.splash.c.c.1
            @Override // com.mbridge.msdk.dycreator.listener.DyCountDownListener
            public final void getCountDownValue(int i11) {
                dyOptionBuild.setDyCountDownListener(i11);
            }
        });
        DynamicViewCreator.getInstance().createDynamicView(dyOptionBuild, new DynamicViewBackListener() { // from class: com.mbridge.msdk.splash.c.c.2
            /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
                jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.mbridge.msdk.splash.c.a.1.<init>(com.mbridge.msdk.splash.c.a, com.mbridge.msdk.splash.d.a, int):void, class status: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
                	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
                	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
                	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:224)
                	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
                	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:93)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
                	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
                	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
                */
            @Override // com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener
            public final void viewClicked(com.mbridge.msdk.dycreator.binding.response.base.BaseRespData r10) {
                /*
                    Method dump skipped, instruction units count: 271
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.c.c.AnonymousClass2.viewClicked(com.mbridge.msdk.dycreator.binding.response.base.BaseRespData):void");
            }

            @Override // com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener
            public final void viewCreateFail(com.mbridge.msdk.dycreator.b.a aVar2) {
                MBSplashView mBSplashView2 = mBSplashView;
                if (mBSplashView2 != null) {
                    Context context = mBSplashView2.getContext();
                    if (context == null) {
                        context = com.mbridge.msdk.foundation.controller.c.m().c();
                    }
                    c.this.a(context, mBSplashView, dVar, aVar);
                }
            }

            @Override // com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener
            public final void viewCreatedSuccess(View view) {
                com.mbridge.msdk.splash.b.a aVar2 = aVar;
                if (aVar2 != null) {
                    if (view != null) {
                        aVar2.a(view);
                    } else {
                        aVar2.a("View render error.");
                    }
                }
            }
        });
    }
}
