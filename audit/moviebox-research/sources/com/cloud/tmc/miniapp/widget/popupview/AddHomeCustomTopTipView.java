package com.cloud.tmc.miniapp.widget.popupview;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cloud.tmc.integration.ActivityHelper;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.MiniAppAutoPopover;
import com.cloud.tmc.integration.model.MiniAppMultiLanguageConfig;
import com.cloud.tmc.integration.model.MiniAppMultiLanguageModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.integration.utils.AddHomeToScreenUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.PopWindowManager;
import com.cloud.tmc.integration.utils.e0;
import com.cloud.tmc.integration.utils.o;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.R$anim;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.bridge.PermissionScopeBridge;
import com.cloud.tmc.miniapp.widget.popupview.AddHomeCustomTopTipView;
import hd.j;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import xb.e;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class AddHomeCustomTopTipView extends LinearLayout {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public long f31917OooO;
    public final Lazy OooO00o;
    public final Lazy OooO0O0;
    public final Lazy OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final String f31918OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public final String f31919OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public final String f31920OooO0o0;
    public MiniAppAutoPopover OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public boolean f31921OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public final Lazy f31922OooOO0;
    public final a OooOO0O;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<View> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return AddHomeCustomTopTipView.this.findViewById(R$id.view_click_close);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<ActivityHelper> {
        public final /* synthetic */ Context OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO00o(Context context) {
            super(0);
            this.OooO00o = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public ActivityHelper invoke() {
            Context context = this.OooO00o;
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
            if (oooO0OO != null) {
                return oooO0OO.f31719d;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<TextView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) AddHomeCustomTopTipView.this.findViewById(R$id.add_home_toast);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<ImageView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) AddHomeCustomTopTipView.this.findViewById(R$id.iv_images);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements PopWindowManager.a {
        public a() {
        }

        @Override // com.cloud.tmc.integration.utils.PopWindowManager.a
        public void a(PopWindowManager.PopWindowData bean) {
            Intrinsics.g(bean, "bean");
            Context context = AddHomeCustomTopTipView.this.getContext();
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
            if (oooO0OO == null) {
                return;
            }
            String str = AddHomeCustomTopTipView.this.f31919OooO0o;
            StringBuilder sbA = j.a("onRefresh:");
            sbA.append(System.currentTimeMillis() - oooO0OO.f31733s);
            TmcLogger.c(str, sbA.toString());
            oooO0OO.k0(bean.getDelayTime() - (System.currentTimeMillis() - oooO0OO.f31733s));
        }

        @Override // com.cloud.tmc.integration.utils.PopWindowManager.a
        public void show(String appId) {
            App app;
            Long delayDuration;
            App app2;
            Intrinsics.g(appId, "appId");
            TmcLogger.c(AddHomeCustomTopTipView.this.f31919OooO0o, "AddHomeToast");
            Context context = AddHomeCustomTopTipView.this.getContext();
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
            if (oooO0OO == null) {
                return;
            }
            o oVar = o.f31082a;
            Context context2 = AddHomeCustomTopTipView.this.getContext();
            Intrinsics.f(context2, "getContext()");
            if (oVar.e(context2, appId)) {
                return;
            }
            try {
                ActivityHelper activityHelper = AddHomeCustomTopTipView.this.getActivityHelper();
                Page activePage = (activityHelper == null || (app2 = activityHelper.getApp()) == null) ? null : app2.getActivePage();
                PageNode pageNode = activePage instanceof PageNode ? (PageNode) activePage : null;
                if (pageNode != null && pageNode.getAddScreenVisibleStatus()) {
                    try {
                        MiniAppAutoPopover mMiniAppAutoPopover = AddHomeCustomTopTipView.this.getMMiniAppAutoPopover();
                        long jLongValue = (mMiniAppAutoPopover == null || (delayDuration = mMiniAppAutoPopover.getDelayDuration()) == null) ? 15000L : delayDuration.longValue();
                        long jCurrentTimeMillis = oooO0OO.f31735u > oooO0OO.f31736v ? (System.currentTimeMillis() - oooO0OO.f31735u) + oooO0OO.f31734t : oooO0OO.f31734t;
                        TmcLogger.c(AddHomeCustomTopTipView.this.f31919OooO0o, "currentForegroundTime:->" + jCurrentTimeMillis);
                        if (!oooO0OO.getMResumed()) {
                            AddHomeCustomTopTipView.this.setShowAddHomeTopTipsStatus(true);
                            AddHomeCustomTopTipView.this.setShowAddHomeTopTipsDelayTime(((System.currentTimeMillis() - oooO0OO.f31733s) + jLongValue) - jCurrentTimeMillis);
                            return;
                        }
                        if (jCurrentTimeMillis <= jLongValue) {
                            AddHomeCustomTopTipView addHomeCustomTopTipView = AddHomeCustomTopTipView.this;
                            addHomeCustomTopTipView.OooO00o(appId, addHomeCustomTopTipView.getMMiniAppAutoPopover(), ((System.currentTimeMillis() - oooO0OO.f31733s) + jLongValue) - jCurrentTimeMillis);
                            return;
                        }
                        AddHomeToScreenUtils addHomeToScreenUtils = AddHomeToScreenUtils.f30986a;
                        ActivityHelper activityHelper2 = oooO0OO.f31719d;
                        if (addHomeToScreenUtils.i(81, activityHelper2 != null ? activityHelper2.getApp() : null)) {
                            TmcLogger.c(AddHomeCustomTopTipView.this.f31919OooO0o, "not allow return");
                            return;
                        }
                        if (PermissionScopeBridge.Companion.a(appId)) {
                            TmcLogger.c(AddHomeCustomTopTipView.this.f31919OooO0o, "dev dialog is showing, return top topview");
                            return;
                        }
                        AddHomeCustomTopTipView.this.OooO0O0();
                        AddHomeCustomTopTipView addHomeCustomTopTipView2 = AddHomeCustomTopTipView.this;
                        Context context3 = addHomeCustomTopTipView2.getContext();
                        Intrinsics.f(context3, "getContext()");
                        addHomeCustomTopTipView2.OooO00o(context3, appId, false);
                        AddHomeCustomTopTipView addHomeCustomTopTipView3 = AddHomeCustomTopTipView.this;
                        Context context4 = addHomeCustomTopTipView3.getContext();
                        Intrinsics.f(context4, "getContext()");
                        addHomeCustomTopTipView3.OooO0O0(context4, appId);
                        ActivityHelper activityHelper3 = AddHomeCustomTopTipView.this.getActivityHelper();
                        if (activityHelper3 == null || (app = activityHelper3.getApp()) == null) {
                            return;
                        }
                        app.updateAddHomeShowStatus(81);
                        return;
                    } catch (Throwable th2) {
                        TmcLogger.h(AddHomeCustomTopTipView.this.f31919OooO0o, th2);
                        return;
                    }
                }
            } catch (Throwable unused) {
            }
            TmcLogger.c(AddHomeCustomTopTipView.this.f31919OooO0o, "addScreenVisibleStatus is false");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public AddHomeCustomTopTipView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddHomeCustomTopTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.OooO00o = LazyKt__LazyJVMKt.b(new OooO0O0());
        this.OooO0O0 = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.OooO0OO = LazyKt__LazyJVMKt.b(new OooO());
        this.f31918OooO0Oo = "key_latest_show_top_toast_time";
        this.f31920OooO0o0 = "key_show_top_toast_num";
        this.f31919OooO0o = "AddHomeCustomTopTipView";
        this.f31922OooOO0 = LazyKt__LazyJVMKt.b(new OooO00o(context));
        LayoutInflater.from(context).inflate(R$layout.mini_layout_custom_addhome_top_tip_view, this);
        if (!isInEditMode()) {
            setTranslationY(getTranslationY() + e0.a());
        }
        setOnClickListener(new View.OnClickListener() { // from class: td.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddHomeCustomTopTipView.OooO00o(this.f76959a, view);
            }
        });
        this.OooOO0O = new a();
    }

    public /* synthetic */ AddHomeCustomTopTipView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public static final void OooO00o(AddHomeCustomTopTipView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.getClass();
        i.c(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityHelper getActivityHelper() {
        return (ActivityHelper) this.f31922OooOO0.getValue();
    }

    private final TextView getAddHomeToast() {
        return (TextView) this.OooO00o.getValue();
    }

    private final ImageView getIvImages() {
        return (ImageView) this.OooO0O0.getValue();
    }

    private final View getViewClickClose() {
        return (View) this.OooO0OO.getValue();
    }

    public final int OooO00o(Context context, String str) {
        return ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getInt(context, "miniappAddHomeToastData", this.f31920OooO0o0 + '_' + str);
    }

    public final void OooO00o() {
        try {
            if (i.a(this)) {
                startAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.mini_view_toast_exit));
                i.d(this);
            }
        } catch (Throwable th2) {
            TmcLogger.g(this.f31919OooO0o, "toAddCustomTopTopVisible error", th2);
        }
    }

    public final void OooO00o(Context context, String appId, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        if (z11) {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putInt(context, "miniappAddHomeToastData", this.f31920OooO0o0 + '_' + appId, 0);
            return;
        }
        int iOooO00o = OooO00o(context, appId);
        TmcLogger.c(this.f31919OooO0o, "updateShowNum->" + iOooO00o);
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putInt(context, "miniappAddHomeToastData", this.f31920OooO0o0 + '_' + appId, iOooO00o + 1);
    }

    public final void OooO00o(String miniappId, MiniAppAutoPopover miniAppAutoPopover, long j11) {
        Long delayDuration;
        MiniAppMultiLanguageModel en2;
        MiniAppMultiLanguageModel id2;
        MiniAppMultiLanguageModel ru2;
        MiniAppMultiLanguageModel ar2;
        MiniAppMultiLanguageModel fr2;
        MiniAppMultiLanguageModel en3;
        MiniAppMultiLanguageModel zh2;
        Intrinsics.g(miniappId, "miniappId");
        Context context = getContext();
        String title = null;
        com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
        if (oooO0OO == null) {
            return;
        }
        Context context2 = getContext();
        Intrinsics.f(context2, "context");
        if (miniAppAutoPopover != null) {
            try {
                if (!Intrinsics.b(miniAppAutoPopover.getStatus(), Boolean.FALSE)) {
                    if (!MiniAppConfigHelper.f30370a.b("enableAddHomeTopTip", true)) {
                        TmcLogger.c(this.f31919OooO0o, "checkAddHomeTopTipIsNeedShow: topTipsEnable is false");
                        return;
                    }
                    if (AppUtils.f31011a.v(context2, miniappId)) {
                        TmcLogger.c(this.f31919OooO0o, "checkAddHomeTopTipIsNeedShow addhomeStatus is true");
                        return;
                    }
                    long j12 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context2, "miniappAddHomeToastData", this.f31918OooO0Oo + '_' + miniappId);
                    Integer perXDay = miniAppAutoPopover.getPerXDay();
                    long jIntValue = ((long) ((perXDay != null ? perXDay.intValue() : 1) * 86400)) * 1000;
                    int iOooO00o = OooO00o(context2, miniappId);
                    if (System.currentTimeMillis() - j12 > jIntValue) {
                        OooO00o(context2, miniappId, true);
                    } else {
                        Integer displayFrequency = miniAppAutoPopover.getDisplayFrequency();
                        if (iOooO00o >= (displayFrequency != null ? displayFrequency.intValue() : 1)) {
                            String str = this.f31919OooO0o;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("checkAddHomeTopTipIsNeedShow showNum is ");
                            sb2.append(iOooO00o);
                            sb2.append(" >=");
                            Integer displayFrequency2 = miniAppAutoPopover.getDisplayFrequency();
                            sb2.append(displayFrequency2 != null ? displayFrequency2.intValue() : 1);
                            TmcLogger.c(str, sb2.toString());
                            return;
                        }
                    }
                    if (miniAppAutoPopover != null) {
                        this.OooO0oO = miniAppAutoPopover;
                        MiniAppMultiLanguageConfig configs = miniAppAutoPopover.getConfigs();
                        String language = Locale.getDefault().getLanguage();
                        if (Intrinsics.b(language, Locale.CHINESE.getLanguage())) {
                            if (configs != null && (zh2 = configs.getZh()) != null) {
                                title = zh2.getTitle();
                            }
                        } else if (Intrinsics.b(language, Locale.ENGLISH.getLanguage())) {
                            if (configs != null && (en3 = configs.getEn()) != null) {
                                title = en3.getTitle();
                            }
                        } else if (Intrinsics.b(language, Locale.FRANCE.getLanguage())) {
                            if (configs != null && (fr2 = configs.getFr()) != null) {
                                title = fr2.getTitle();
                            }
                        } else if (Intrinsics.b(language, new Locale("ar").getLanguage())) {
                            if (configs != null && (ar2 = configs.getAr()) != null) {
                                title = ar2.getTitle();
                            }
                        } else if (Intrinsics.b(language, new Locale("ru").getLanguage())) {
                            if (configs != null && (ru2 = configs.getRu()) != null) {
                                title = ru2.getTitle();
                            }
                        } else if (Intrinsics.b(language, new Locale("in").getLanguage())) {
                            if (configs != null && (id2 = configs.getId()) != null) {
                                title = id2.getTitle();
                            }
                        } else if (configs != null && (en2 = configs.getEn()) != null) {
                            title = en2.getTitle();
                        }
                        String string = getContext().getString(R$string.mini_add_home_tips_default);
                        Intrinsics.f(string, "context.getString(R.stri…ni_add_home_tips_default)");
                        String strB = e.b(title, string);
                        TextView addHomeToast = getAddHomeToast();
                        if (addHomeToast != null) {
                            addHomeToast.setText(strB);
                        }
                    }
                    PopWindowManager popWindowManager = PopWindowManager.f31020a;
                    String strY0 = oooO0OO.y0();
                    if (j11 == 0) {
                        j11 = (miniAppAutoPopover == null || (delayDuration = miniAppAutoPopover.getDelayDuration()) == null) ? 15000L : delayDuration.longValue();
                    }
                    popWindowManager.a(strY0, new PopWindowManager.PopWindowData(miniappId, j11, 1, this.OooOO0O, true));
                    return;
                }
            } catch (Throwable th2) {
                TmcLogger.g(this.f31919OooO0o, "checkAddHomeTopTipIsNeedShow error", th2);
            }
        }
        TmcLogger.c(this.f31919OooO0o, "checkAddHomeTopTipIsNeedShow: bean is null or status is false");
    }

    public final void OooO0O0() {
        App app;
        try {
            startAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.mini_view_toast_enter));
            i.e(this);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            ActivityHelper activityHelper = getActivityHelper();
            performanceAnalyseProxy.recordForCommon((activityHelper == null || (app = activityHelper.getApp()) == null) ? null : app.getAppId(), "upper_pop_ex", new Bundle());
        } catch (Throwable th2) {
            TmcLogger.g(this.f31919OooO0o, "toAddCustomTopTopVisible error", th2);
        }
    }

    public final void OooO0O0(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, "miniappAddHomeToastData", this.f31918OooO0Oo + '_' + appId, System.currentTimeMillis());
    }

    public final MiniAppAutoPopover getMMiniAppAutoPopover() {
        return this.OooO0oO;
    }

    public final long getShowAddHomeTopTipsDelayTime() {
        return this.f31917OooO;
    }

    public final boolean getShowAddHomeTopTipsStatus() {
        return this.f31921OooO0oo;
    }

    public final void setMMiniAppAutoPopover(MiniAppAutoPopover miniAppAutoPopover) {
        this.OooO0oO = miniAppAutoPopover;
    }

    public final void setShowAddHomeTopTipsDelayTime(long j11) {
        this.f31917OooO = j11;
    }

    public final void setShowAddHomeTopTipsStatus(boolean z11) {
        this.f31921OooO0oo = z11;
    }
}
