package com.cloud.tmc.miniapp.widget.popupview;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.ActivityHelper;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppAutoPopover;
import com.cloud.tmc.integration.model.MiniAppMultiLanguageConfig;
import com.cloud.tmc.integration.model.MiniAppMultiLanguageModel;
import com.cloud.tmc.integration.proxy.StartActivityProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.AddHomeToScreenUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.PopWindowManager;
import com.cloud.tmc.integration.utils.o;
import com.cloud.tmc.integration.utils.u;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.R$anim;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.ui.OooO0OO;
import com.cloud.tmc.miniapp.widget.popupview.MiniAddHomeTipDialogView;
import hd.j;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import xb.e;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class MiniAddHomeTipDialogView extends FrameLayout {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public final String f31924OooO;
    public final Lazy OooO00o;
    public final Lazy OooO0O0;
    public final Lazy OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final Lazy f31925OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public final Lazy f31926OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public final Lazy f31927OooO0o0;
    public final String OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public final String f31928OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public MiniAppAutoPopover f31929OooOO0;
    public boolean OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public long f31930OooOO0o;
    public String OooOOO;
    public int OooOOO0;
    public final a OooOOOO;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<TextView> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) MiniAddHomeTipDialogView.this.findViewById(R$id.tv_add_home_now_btn);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<ImageView> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) MiniAddHomeTipDialogView.this.findViewById(R$id.iv_add_home_tip_close);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<AppCompatImageView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) MiniAddHomeTipDialogView.this.findViewById(R$id.iv_dialog_mini_app_logo);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<TextView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) MiniAddHomeTipDialogView.this.findViewById(R$id.tv_add_home_later_btn);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<TextView> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) MiniAddHomeTipDialogView.this.findViewById(R$id.tv_dialog_content_info);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0O extends Lambda implements Function0<TextView> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) MiniAddHomeTipDialogView.this.findViewById(R$id.tv_dialog_mini_app_name);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements PopWindowManager.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f31931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MiniAddHomeTipDialogView f31932b;

        public a(Context context, MiniAddHomeTipDialogView miniAddHomeTipDialogView) {
            this.f31931a = context;
            this.f31932b = miniAddHomeTipDialogView;
        }

        @Override // com.cloud.tmc.integration.utils.PopWindowManager.a
        public void a(PopWindowManager.PopWindowData bean) {
            Intrinsics.g(bean, "bean");
            Context context = this.f31931a;
            OooO0OO oooO0OO = context instanceof OooO0OO ? (OooO0OO) context : null;
            if (oooO0OO == null) {
                return;
            }
            String str = this.f31932b.OooO0oO;
            StringBuilder sbA = j.a("onRefresh:");
            sbA.append(System.currentTimeMillis() - oooO0OO.f31733s);
            TmcLogger.c(str, sbA.toString());
            oooO0OO.k0(bean.getDelayTime() - (System.currentTimeMillis() - oooO0OO.f31733s));
        }

        @Override // com.cloud.tmc.integration.utils.PopWindowManager.a
        public void show(String appId) {
            Long delayDuration;
            Intrinsics.g(appId, "appId");
            Context context = this.f31931a;
            OooO0OO oooO0OO = context instanceof OooO0OO ? (OooO0OO) context : null;
            if (oooO0OO == null) {
                return;
            }
            TmcLogger.c(this.f31932b.OooO0oO, "showAddHomeTipDialogController");
            o oVar = o.f31082a;
            if (oVar.e(this.f31931a, appId)) {
                return;
            }
            try {
                MiniAppAutoPopover mMiniAppAutoPopover = this.f31932b.getMMiniAppAutoPopover();
                long jLongValue = (mMiniAppAutoPopover == null || (delayDuration = mMiniAppAutoPopover.getDelayDuration()) == null) ? 15000L : delayDuration.longValue();
                long jCurrentTimeMillis = oooO0OO.f31735u > oooO0OO.f31736v ? (System.currentTimeMillis() - oooO0OO.f31735u) + oooO0OO.f31734t : oooO0OO.f31734t;
                TmcLogger.c(this.f31932b.OooO0oO, "currentForegroundTime:->" + jCurrentTimeMillis);
                if (!oooO0OO.getMResumed()) {
                    this.f31932b.setShowAddHomeDialogStatus(true);
                    this.f31932b.setShowAddHomeDialogDelayTime(((System.currentTimeMillis() - oooO0OO.f31733s) + jLongValue) - jCurrentTimeMillis);
                    return;
                }
                if (jCurrentTimeMillis <= jLongValue) {
                    MiniAddHomeTipDialogView miniAddHomeTipDialogView = this.f31932b;
                    miniAddHomeTipDialogView.OooO00o(appId, miniAddHomeTipDialogView.getMMiniAppAutoPopover(), ((System.currentTimeMillis() - oooO0OO.f31733s) + jLongValue) - jCurrentTimeMillis);
                    return;
                }
                AddHomeToScreenUtils addHomeToScreenUtils = AddHomeToScreenUtils.f30986a;
                ActivityHelper activityHelper = oooO0OO.f31719d;
                if (addHomeToScreenUtils.i(83, activityHelper != null ? activityHelper.getApp() : null)) {
                    TmcLogger.c(this.f31932b.OooO0oO, "not allow show ,return ");
                    return;
                }
                App app = oooO0OO.f31719d.getApp();
                if (app != null) {
                    app.getBackPressedProcessor().addInterceptors(new m0.a());
                    oVar.f().put(appId, app);
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.f31932b.OooO0oO, th2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public MiniAddHomeTipDialogView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiniAddHomeTipDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.OooO00o = LazyKt__LazyJVMKt.b(new OooOO0());
        this.OooO0O0 = LazyKt__LazyJVMKt.b(new OooO0O0());
        this.OooO0OO = LazyKt__LazyJVMKt.b(new OooOO0O());
        this.f31925OooO0Oo = LazyKt__LazyJVMKt.b(new OooO());
        this.f31927OooO0o0 = LazyKt__LazyJVMKt.b(new OooO0o());
        this.f31926OooO0o = LazyKt__LazyJVMKt.b(new OooO00o());
        this.OooO0oO = "MiniAddHomeTipDialog";
        this.f31928OooO0oo = "key_latest_show_add_home_dialog_time";
        this.f31924OooO = "key_show_add_home_dialog_num";
        LayoutInflater.from(context).inflate(R$layout.mini_dialog_addhome_tip_layout, this);
        TextView tvAddHomeNowBtn = getTvAddHomeNowBtn();
        if (tvAddHomeNowBtn != null) {
            tvAddHomeNowBtn.setOnClickListener(new View.OnClickListener() { // from class: td.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniAddHomeTipDialogView.OooO00o(this.f76960a, view);
                }
            });
        }
        setOnClickListener(new View.OnClickListener() { // from class: td.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniAddHomeTipDialogView.OooO0O0(this.f76961a, view);
            }
        });
        TextView tvAddHomeLaterBtn = getTvAddHomeLaterBtn();
        if (tvAddHomeLaterBtn != null) {
            tvAddHomeLaterBtn.setOnClickListener(new View.OnClickListener() { // from class: td.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniAddHomeTipDialogView.OooO0OO(this.f76962a, view);
                }
            });
        }
        ImageView ivAddHomeTipClose = getIvAddHomeTipClose();
        if (ivAddHomeTipClose != null) {
            ivAddHomeTipClose.setOnClickListener(new View.OnClickListener() { // from class: td.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniAddHomeTipDialogView.OooO0Oo(this.f76963a, view);
                }
            });
        }
        this.OooOOOO = new a(context, this);
    }

    public /* synthetic */ MiniAddHomeTipDialogView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public static final void OooO00o(MiniAddHomeTipDialogView this$0, View view) {
        ActivityHelper activityHelper;
        App app;
        Intrinsics.g(this$0, "this$0");
        if (u.a()) {
            return;
        }
        Context context = this$0.getContext();
        OooO0OO oooO0OO = context instanceof OooO0OO ? (OooO0OO) context : null;
        if (oooO0OO != null && (activityHelper = oooO0OO.f31719d) != null && (app = activityHelper.getApp()) != null) {
            Context context2 = this$0.getContext();
            Intrinsics.f(context2, "getContext()");
            Class<?> launcherShortCutActivity = ((StartActivityProxy) tc.a.a(StartActivityProxy.class)).getLauncherShortCutActivity();
            Intrinsics.f(launcherShortCutActivity, "get(StartActivityProxy::….launcherShortCutActivity");
            o.a(context2, launcherShortCutActivity, app, PrepareException.ERROR_LOCAL_DATA_FILE_SCAN, (112 & 16) != 0 ? 0 : this$0.OooOOO0, (112 & 32) != 0 ? false : false, (112 & 64) != 0);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            String appId = app.getAppId();
            Bundle bundle = new Bundle();
            bundle.putString(RequestParameters.SUBRESOURCE_LOCATION, PrepareException.ERROR_LOCAL_DATA_FILE_SCAN);
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.recordForCommon(appId, "quit_pop_click", bundle);
        }
        this$0.OooO00o(true);
    }

    public static final void OooO0O0(MiniAddHomeTipDialogView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (u.a()) {
            return;
        }
        TmcLogger.c(this$0.OooO0oO, "");
    }

    public static final void OooO0OO(MiniAddHomeTipDialogView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (u.a()) {
            return;
        }
        this$0.OooO00o(true);
    }

    public static final void OooO0Oo(MiniAddHomeTipDialogView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (u.a()) {
            return;
        }
        this$0.OooO00o(false);
    }

    private final ImageView getIvAddHomeTipClose() {
        return (ImageView) this.f31926OooO0o.getValue();
    }

    private final ImageView getIvDialogMiniAppLogo() {
        return (ImageView) this.OooO0O0.getValue();
    }

    private final TextView getTvAddHomeLaterBtn() {
        return (TextView) this.f31927OooO0o0.getValue();
    }

    private final TextView getTvAddHomeNowBtn() {
        return (TextView) this.f31925OooO0Oo.getValue();
    }

    private final TextView getTvDialogContentInfo() {
        return (TextView) this.OooO00o.getValue();
    }

    private final TextView getTvDialogMiniAppName() {
        return (TextView) this.OooO0OO.getValue();
    }

    private final void setLogoResource(String str) {
        ImageView ivDialogMiniAppLogo;
        if (str != null) {
            try {
                if (str.length() == 0 || (ivDialogMiniAppLogo = getIvDialogMiniAppLogo()) == null) {
                    return;
                }
                ((ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class)).loadImg(getContext(), str, ivDialogMiniAppLogo);
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO0oO, th2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00bf  */
    private final void setTitleInfo(MiniAppMultiLanguageConfig miniAppMultiLanguageConfig) {
        MiniAppMultiLanguageModel en2;
        String title;
        MiniAppMultiLanguageModel id2;
        MiniAppMultiLanguageModel ru2;
        MiniAppMultiLanguageModel ar2;
        MiniAppMultiLanguageModel fr2;
        MiniAppMultiLanguageModel en3;
        MiniAppMultiLanguageModel zh2;
        try {
            String language = Locale.getDefault().getLanguage();
            if (Intrinsics.b(language, Locale.CHINESE.getLanguage())) {
                if (miniAppMultiLanguageConfig == null || (zh2 = miniAppMultiLanguageConfig.getZh()) == null) {
                    title = null;
                } else {
                    title = zh2.getTitle();
                }
            } else if (Intrinsics.b(language, Locale.ENGLISH.getLanguage())) {
                if (miniAppMultiLanguageConfig == null || (en3 = miniAppMultiLanguageConfig.getEn()) == null) {
                    title = null;
                } else {
                    title = en3.getTitle();
                }
            } else if (Intrinsics.b(language, Locale.FRANCE.getLanguage())) {
                if (miniAppMultiLanguageConfig == null || (fr2 = miniAppMultiLanguageConfig.getFr()) == null) {
                    title = null;
                } else {
                    title = fr2.getTitle();
                }
            } else if (Intrinsics.b(language, new Locale("ar").getLanguage())) {
                if (miniAppMultiLanguageConfig == null || (ar2 = miniAppMultiLanguageConfig.getAr()) == null) {
                    title = null;
                } else {
                    title = ar2.getTitle();
                }
            } else if (Intrinsics.b(language, new Locale("ru").getLanguage())) {
                if (miniAppMultiLanguageConfig == null || (ru2 = miniAppMultiLanguageConfig.getRu()) == null) {
                    title = null;
                } else {
                    title = ru2.getTitle();
                }
            } else if (Intrinsics.b(language, new Locale("in").getLanguage())) {
                if (miniAppMultiLanguageConfig == null || (id2 = miniAppMultiLanguageConfig.getId()) == null) {
                    title = null;
                } else {
                    title = id2.getTitle();
                }
            } else if (miniAppMultiLanguageConfig == null || (en2 = miniAppMultiLanguageConfig.getEn()) == null) {
                title = null;
            } else {
                title = en2.getTitle();
            }
            String string = getContext().getString(R$string.mini_add_home_tips_default);
            Intrinsics.f(string, "getContext().getString(R…ni_add_home_tips_default)");
            String strB = e.b(title, string);
            TmcLogger.c(this.OooO0oO, "setAddHomeBtnInfo: " + strB);
            TextView tvDialogContentInfo = getTvDialogContentInfo();
            if (tvDialogContentInfo == null) {
                return;
            }
            tvDialogContentInfo.setText(strB);
        } catch (Throwable th2) {
            TmcLogger.h(this.OooO0oO, th2);
        }
    }

    public final int OooO00o(Context context, String str) {
        return ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getInt(context, "miniappAddHomeToastData", this.f31924OooO + '_' + str);
    }

    public final void OooO00o(Context context, String str, boolean z11) {
        if (z11) {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putInt(context, "miniappAddHomeToastData", this.f31924OooO + '_' + str, 0);
            return;
        }
        int iOooO00o = OooO00o(context, str);
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putInt(context, "miniappAddHomeToastData", this.f31924OooO + '_' + str, iOooO00o + 1);
    }

    public final void OooO00o(String appId, MiniAppAutoPopover miniAppAutoPopover, long j11) {
        Long delayDuration;
        Intrinsics.g(appId, "it");
        Context context = getContext();
        OooO0OO oooO0OO = context instanceof OooO0OO ? (OooO0OO) context : null;
        if (oooO0OO == null) {
            return;
        }
        Context context2 = getContext();
        Intrinsics.f(context2, "context");
        Intrinsics.g(context2, "context");
        Intrinsics.g(appId, "appId");
        if (miniAppAutoPopover != null) {
            try {
                if (!Intrinsics.b(miniAppAutoPopover.getStatus(), Boolean.FALSE)) {
                    if (!MiniAppConfigHelper.f30370a.b("enableAddHomeBackDialogTip", true)) {
                        TmcLogger.c(this.OooO0oO, "checkAddHomeDialogTipIsNeedShow: backDialogEnable is false");
                        return;
                    }
                    if (AppUtils.f31011a.v(context2, appId)) {
                        TmcLogger.c(this.OooO0oO, "checkAddHomeDialogTipIsNeedShow addhomeStatus is true");
                        return;
                    }
                    long j12 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context2, "miniappAddHomeToastData", this.f31928OooO0oo + '_' + appId);
                    Integer perXDay = miniAppAutoPopover.getPerXDay();
                    long jIntValue = ((long) ((perXDay != null ? perXDay.intValue() : 1) * 86400)) * 1000;
                    int iOooO00o = OooO00o(context2, appId);
                    if (System.currentTimeMillis() - j12 > jIntValue) {
                        OooO00o(context2, appId, true);
                    } else {
                        Integer displayFrequency = miniAppAutoPopover.getDisplayFrequency();
                        if (iOooO00o >= (displayFrequency != null ? displayFrequency.intValue() : 1)) {
                            String str = this.OooO0oO;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("checkAddHomeDialogTipIsNeedShow showNum is ");
                            sb2.append(iOooO00o);
                            sb2.append(" >=");
                            Integer displayFrequency2 = miniAppAutoPopover.getDisplayFrequency();
                            sb2.append(displayFrequency2 != null ? displayFrequency2.intValue() : 1);
                            TmcLogger.c(str, sb2.toString());
                            return;
                        }
                    }
                    TmcLogger.c(this.OooO0oO, "showAddHomeDialog");
                    App app = oooO0OO.f31719d.getApp();
                    AppModel appModel = app != null ? app.getAppModel() : null;
                    if (miniAppAutoPopover != null) {
                        this.f31929OooOO0 = miniAppAutoPopover;
                        setTitleInfo(miniAppAutoPopover.getConfigs());
                    }
                    if (appModel != null) {
                        this.OooOOO = appModel.getAppId();
                        setLogoResource(appModel.getLogo());
                        TextView tvDialogMiniAppName = getTvDialogMiniAppName();
                        if (tvDialogMiniAppName != null) {
                            tvDialogMiniAppName.setText(appModel.getName());
                        }
                    }
                    PopWindowManager popWindowManager = PopWindowManager.f31020a;
                    String strY0 = oooO0OO.y0();
                    if (j11 == 0) {
                        j11 = (miniAppAutoPopover == null || (delayDuration = miniAppAutoPopover.getDelayDuration()) == null) ? 45000L : delayDuration.longValue();
                    }
                    popWindowManager.a(strY0, new PopWindowManager.PopWindowData(appId, j11, 1, this.OooOOOO, true));
                    return;
                }
            } catch (Throwable th2) {
                TmcLogger.g(this.OooO0oO, "checkAddHomeTopTipIsNeedShow error", th2);
            }
        }
        TmcLogger.c(this.OooO0oO, "checkAddHomeDialogTipIsNeedShow: bean is null or status is false");
    }

    public final void OooO00o(boolean z11) {
        OooO0OO oooO0OO;
        try {
            if (!i.a(this)) {
                TmcLogger.c(this.OooO0oO, "hideDialog: not visible");
                return;
            }
            if (z11) {
                int i11 = this.OooOOO0;
                if (i11 == 2) {
                    Context context = getContext();
                    oooO0OO = context instanceof OooO0OO ? (OooO0OO) context : null;
                    if (oooO0OO != null) {
                        oooO0OO.W(TmcFragment.ExitType.CLOSE_APP, false);
                    }
                } else if (i11 == 1) {
                    Context context2 = getContext();
                    oooO0OO = context2 instanceof OooO0OO ? (OooO0OO) context2 : null;
                    if (oooO0OO != null) {
                        oooO0OO.G0();
                    }
                }
            }
            this.OooOOO0 = 0;
            startAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.mini_view_toast_exit));
            i.c(this);
        } catch (Throwable th2) {
            TmcLogger.h(this.OooO0oO, th2);
        }
    }

    public final String getAppId() {
        return this.OooOOO;
    }

    public final int getBackFromType() {
        return this.OooOOO0;
    }

    public final MiniAppAutoPopover getMMiniAppAutoPopover() {
        return this.f31929OooOO0;
    }

    public final long getShowAddHomeDialogDelayTime() {
        return this.f31930OooOO0o;
    }

    public final boolean getShowAddHomeDialogStatus() {
        return this.OooOO0O;
    }

    public final void setAppId(String str) {
        this.OooOOO = str;
    }

    public final void setBackFromType(int i11) {
        this.OooOOO0 = i11;
    }

    public final void setMMiniAppAutoPopover(MiniAppAutoPopover miniAppAutoPopover) {
        this.f31929OooOO0 = miniAppAutoPopover;
    }

    public final void setShowAddHomeDialogDelayTime(long j11) {
        this.f31930OooOO0o = j11;
    }

    public final void setShowAddHomeDialogStatus(boolean z11) {
        this.OooOO0O = z11;
    }
}
