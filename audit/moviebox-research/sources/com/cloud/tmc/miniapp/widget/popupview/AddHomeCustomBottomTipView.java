package com.cloud.tmc.miniapp.widget.popupview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.ActivityHelper;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppAutoPopover;
import com.cloud.tmc.integration.model.MiniAppMultiLanguageConfig;
import com.cloud.tmc.integration.model.MiniAppMultiLanguageModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.AddHomeToScreenUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.PopWindowManager;
import com.cloud.tmc.integration.utils.e0;
import com.cloud.tmc.integration.utils.o;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.R$anim;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.bridge.PermissionScopeBridge;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.widget.popupview.AddHomeCustomBottomTipView;
import com.cloud.tmc.miniutils.util.x;
import com.google.android.gms.location.DeviceOrientationRequest;
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
public final class AddHomeCustomBottomTipView extends LinearLayout {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public MiniAppAutoPopover f31908OooO;
    public final Lazy OooO00o;
    public final Lazy OooO0O0;
    public final Lazy OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final Lazy f31909OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public final String f31910OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public final String f31911OooO0o0;
    public final String OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public final Lazy f31912OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public boolean f31913OooOO0;
    public long OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public final a f31914OooOO0o;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<TextView> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) AddHomeCustomBottomTipView.this.findViewById(R$id.btn_add_home);
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
    public static final class OooO0O0 extends Lambda implements Function0<AppCompatImageView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) AddHomeCustomBottomTipView.this.findViewById(R$id.iv_mini_logo);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<ImageView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) AddHomeCustomBottomTipView.this.findViewById(R$id.iv_mini_tips_x);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<TextView> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) AddHomeCustomBottomTipView.this.findViewById(R$id.tv_content_info);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements PopWindowManager.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f31916b;

        public a(Context context) {
            this.f31916b = context;
        }

        @Override // com.cloud.tmc.integration.utils.PopWindowManager.a
        public void a(PopWindowManager.PopWindowData bean) {
            Intrinsics.g(bean, "bean");
            Context context = this.f31916b;
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
            if (oooO0OO == null) {
                return;
            }
            String str = AddHomeCustomBottomTipView.this.OooO0oO;
            StringBuilder sbA = j.a("onRefresh:");
            sbA.append(System.currentTimeMillis() - oooO0OO.f31733s);
            TmcLogger.c(str, sbA.toString());
            oooO0OO.k0(bean.getDelayTime() - (System.currentTimeMillis() - oooO0OO.f31733s));
        }

        @Override // com.cloud.tmc.integration.utils.PopWindowManager.a
        public void show(String appId) {
            App app;
            Long delayDuration;
            Intrinsics.g(appId, "appId");
            TmcLogger.c(AddHomeCustomBottomTipView.this.OooO0oO, "showAddHomeBottomTipsController");
            Context context = this.f31916b;
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
            if (oooO0OO == null || o.f31082a.e(context, appId)) {
                return;
            }
            try {
                MiniAppAutoPopover mMiniAppAutoPopover = AddHomeCustomBottomTipView.this.getMMiniAppAutoPopover();
                long jLongValue = (mMiniAppAutoPopover == null || (delayDuration = mMiniAppAutoPopover.getDelayDuration()) == null) ? 15000L : delayDuration.longValue();
                long jCurrentTimeMillis = oooO0OO.f31735u > oooO0OO.f31736v ? (System.currentTimeMillis() - oooO0OO.f31735u) + oooO0OO.f31734t : oooO0OO.f31734t;
                TmcLogger.c(AddHomeCustomBottomTipView.this.OooO0oO, "currentForegroundTime:->" + jCurrentTimeMillis);
                if (!oooO0OO.getMResumed()) {
                    AddHomeCustomBottomTipView.this.setShowAddHomeBottomTipsStatus(true);
                    AddHomeCustomBottomTipView.this.setShowAddHomeBottomTipsDelayTime(((System.currentTimeMillis() - oooO0OO.f31733s) + jLongValue) - jCurrentTimeMillis);
                    return;
                }
                if (jCurrentTimeMillis <= jLongValue) {
                    AddHomeCustomBottomTipView addHomeCustomBottomTipView = AddHomeCustomBottomTipView.this;
                    addHomeCustomBottomTipView.OooO00o(appId, addHomeCustomBottomTipView.getMMiniAppAutoPopover(), ((System.currentTimeMillis() - oooO0OO.f31733s) + jLongValue) - jCurrentTimeMillis);
                    return;
                }
                AddHomeToScreenUtils addHomeToScreenUtils = AddHomeToScreenUtils.f30986a;
                ActivityHelper activityHelper = oooO0OO.f31719d;
                if (addHomeToScreenUtils.i(82, activityHelper != null ? activityHelper.getApp() : null)) {
                    TmcLogger.c(AddHomeCustomBottomTipView.this.OooO0oO, "not allow show, return");
                    return;
                }
                if (PermissionScopeBridge.Companion.a(appId)) {
                    TmcLogger.c(AddHomeCustomBottomTipView.this.OooO0oO, "dev dialog is showing, return");
                    return;
                }
                AddHomeCustomBottomTipView.this.OooO00o();
                AddHomeCustomBottomTipView.this.OooO00o(this.f31916b, appId, false);
                AddHomeCustomBottomTipView.this.OooO0O0(this.f31916b, appId);
                ActivityHelper activityHelper2 = AddHomeCustomBottomTipView.this.getActivityHelper();
                if (activityHelper2 == null || (app = activityHelper2.getApp()) == null) {
                    return;
                }
                app.updateAddHomeShowStatus(82);
            } catch (Throwable th2) {
                TmcLogger.h(AddHomeCustomBottomTipView.this.OooO0oO, th2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public AddHomeCustomBottomTipView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddHomeCustomBottomTipView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.OooO00o = LazyKt__LazyJVMKt.b(new OooO0O0());
        this.OooO0O0 = LazyKt__LazyJVMKt.b(new OooOO0());
        this.OooO0OO = LazyKt__LazyJVMKt.b(new OooO());
        this.f31909OooO0Oo = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.f31911OooO0o0 = "key_latest_show_bottom_toast_time";
        this.f31910OooO0o = "key_show_bottom_toast_num";
        this.OooO0oO = "AddHomeCustomBottomTipView";
        this.f31912OooO0oo = LazyKt__LazyJVMKt.b(new OooO00o(context));
        LayoutInflater.from(context).inflate(R$layout.mini_layout_custom_addhome_bottom_tip_view, this);
        if (!isInEditMode()) {
            setTranslationY(getTranslationY() + e0.a());
        }
        setOnClickListener(new View.OnClickListener() { // from class: td.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddHomeCustomBottomTipView.OooO00o(this.f76955a, view);
            }
        });
        getTvAddHome().setOnClickListener(new View.OnClickListener() { // from class: td.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddHomeCustomBottomTipView.OooO00o(this.f76956a, context, view);
            }
        });
        getIvMiniTipsX().setOnClickListener(new View.OnClickListener() { // from class: td.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddHomeCustomBottomTipView.OooO0O0(this.f76958a, view);
            }
        });
        this.f31914OooOO0o = new a(context);
    }

    public /* synthetic */ AddHomeCustomBottomTipView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public static final void OooO00o(AddHomeCustomBottomTipView this$0, Context context, View view) {
        App app;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(context, "$context");
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        ActivityHelper activityHelper = this$0.getActivityHelper();
        String appId = (activityHelper == null || (app = activityHelper.getApp()) == null) ? null : app.getAppId();
        Bundle bundle = new Bundle();
        bundle.putString(RequestParameters.SUBRESOURCE_LOCATION, PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION);
        Unit unit = Unit.f68710a;
        performanceAnalyseProxy.recordForCommon(appId, "bottom_banner_click", bundle);
        com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
        if (oooO0OO != null) {
            oooO0OO.m0(PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION);
        }
    }

    public static final void OooO00o(AddHomeCustomBottomTipView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        TmcLogger.c(this$0.OooO0oO, "AddHomeCustomBottomTipView click");
    }

    public static final void OooO0O0(AddHomeCustomBottomTipView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.getClass();
        i.c(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityHelper getActivityHelper() {
        return (ActivityHelper) this.f31912OooO0oo.getValue();
    }

    private final AppCompatImageView getIvMiniLogo() {
        Object value = this.OooO00o.getValue();
        Intrinsics.f(value, "<get-ivMiniLogo>(...)");
        return (AppCompatImageView) value;
    }

    private final ImageView getIvMiniTipsX() {
        Object value = this.f31909OooO0Oo.getValue();
        Intrinsics.f(value, "<get-ivMiniTipsX>(...)");
        return (ImageView) value;
    }

    private final TextView getTvAddHome() {
        Object value = this.OooO0OO.getValue();
        Intrinsics.f(value, "<get-tvAddHome>(...)");
        return (TextView) value;
    }

    private final TextView getTvContentInfo() {
        Object value = this.OooO0O0.getValue();
        Intrinsics.f(value, "<get-tvContentInfo>(...)");
        return (TextView) value;
    }

    public final int OooO00o(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        return ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getInt(context, "miniappAddHomeToastData", this.f31910OooO0o + '_' + appId);
    }

    public final void OooO00o() {
        App app;
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            ActivityHelper activityHelper = getActivityHelper();
            performanceAnalyseProxy.recordForCommon((activityHelper == null || (app = activityHelper.getApp()) == null) ? null : app.getAppId(), "bottom_banner_ex", new Bundle());
            startAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.mini_view_toast_enter));
            i.e(this);
        } catch (Throwable th2) {
            TmcLogger.g(this.OooO0oO, "toAddCustomBottomVisible error", th2);
        }
    }

    public final void OooO00o(Context context, String appId, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        if (z11) {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putInt(context, "miniappAddHomeToastData", this.f31910OooO0o + '_' + appId, 0);
            return;
        }
        int iOooO00o = OooO00o(context, appId);
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putInt(context, "miniappAddHomeToastData", this.f31910OooO0o + '_' + appId, iOooO00o + 1);
    }

    /* JADX WARN: Code duplicated, block: B:151:0x030e  */
    /* JADX WARN: Code duplicated, block: B:87:0x01d8  */
    public final void OooO00o(String appId, MiniAppAutoPopover miniAppAutoPopover, long j11) {
        long jLongValue;
        Long delayDuration;
        MiniAppMultiLanguageModel en2;
        String buttonText;
        MiniAppMultiLanguageModel id2;
        MiniAppMultiLanguageModel ru2;
        MiniAppMultiLanguageModel ar2;
        MiniAppMultiLanguageModel fr2;
        MiniAppMultiLanguageModel en3;
        MiniAppMultiLanguageModel zh2;
        App app;
        AppModel appModel;
        MiniAppMultiLanguageModel en4;
        String title;
        MiniAppMultiLanguageModel id3;
        MiniAppMultiLanguageModel ru3;
        MiniAppMultiLanguageModel ar3;
        MiniAppMultiLanguageModel fr3;
        MiniAppMultiLanguageModel en5;
        MiniAppMultiLanguageModel zh3;
        Intrinsics.g(appId, "miniappId");
        Context context = getContext();
        com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
        if (oooO0OO == null) {
            return;
        }
        Context context2 = getContext();
        Intrinsics.f(context2, "context");
        Intrinsics.g(context2, "context");
        Intrinsics.g(appId, "appId");
        boolean z11 = true;
        if (miniAppAutoPopover != null) {
            try {
                if (Intrinsics.b(miniAppAutoPopover.getStatus(), Boolean.FALSE)) {
                    TmcLogger.c(this.OooO0oO, "checkAddHomeBottomTipIsNeedShow: bean is null or status is false");
                    z11 = false;
                } else {
                    if (!MiniAppConfigHelper.f30370a.b("enableAddHomeBottomTip", true)) {
                        TmcLogger.c(this.OooO0oO, "checkAddHomeBottomTipIsNeedShow: bottomTipsEnable is false");
                    } else if (AppUtils.f31011a.v(context2, appId)) {
                        TmcLogger.c(this.OooO0oO, "checkAddHomeBottomTipIsNeedShow addhomeStatus is true");
                    } else {
                        long j12 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context2, "miniappAddHomeToastData", this.f31911OooO0o0 + '_' + appId);
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
                                sb2.append("checkAddHomeBottomTipIsNeedShow showNum is ");
                                sb2.append(iOooO00o);
                                sb2.append(" >=");
                                Integer displayFrequency2 = miniAppAutoPopover.getDisplayFrequency();
                                sb2.append(displayFrequency2 != null ? displayFrequency2.intValue() : 1);
                                TmcLogger.c(str, sb2.toString());
                            }
                        }
                    }
                    z11 = false;
                }
            } catch (Throwable th2) {
                TmcLogger.g(this.OooO0oO, "checkAddHomeTopTipIsNeedShow error", th2);
            }
        } else {
            TmcLogger.c(this.OooO0oO, "checkAddHomeBottomTipIsNeedShow: bean is null or status is false");
            z11 = false;
        }
        TmcLogger.c(this.OooO0oO, "showAddHomeBottomTips enableShowStatus->" + z11);
        if (z11) {
            if (miniAppAutoPopover != null) {
                this.f31908OooO = miniAppAutoPopover;
                MiniAppMultiLanguageConfig configs = miniAppAutoPopover.getConfigs();
                try {
                    String language = Locale.getDefault().getLanguage();
                    if (Intrinsics.b(language, Locale.CHINESE.getLanguage())) {
                        if (configs == null || (zh3 = configs.getZh()) == null) {
                            title = null;
                        } else {
                            title = zh3.getTitle();
                        }
                    } else if (Intrinsics.b(language, Locale.ENGLISH.getLanguage())) {
                        if (configs == null || (en5 = configs.getEn()) == null) {
                            title = null;
                        } else {
                            title = en5.getTitle();
                        }
                    } else if (Intrinsics.b(language, Locale.FRANCE.getLanguage())) {
                        if (configs == null || (fr3 = configs.getFr()) == null) {
                            title = null;
                        } else {
                            title = fr3.getTitle();
                        }
                    } else if (Intrinsics.b(language, new Locale("ar").getLanguage())) {
                        if (configs == null || (ar3 = configs.getAr()) == null) {
                            title = null;
                        } else {
                            title = ar3.getTitle();
                        }
                    } else if (Intrinsics.b(language, new Locale("ru").getLanguage())) {
                        if (configs == null || (ru3 = configs.getRu()) == null) {
                            title = null;
                        } else {
                            title = ru3.getTitle();
                        }
                    } else if (Intrinsics.b(language, new Locale("in").getLanguage())) {
                        if (configs == null || (id3 = configs.getId()) == null) {
                            title = null;
                        } else {
                            title = id3.getTitle();
                        }
                    } else if (configs == null || (en4 = configs.getEn()) == null) {
                        title = null;
                    } else {
                        title = en4.getTitle();
                    }
                    String string = getContext().getString(R$string.mini_add_home_tips_default);
                    Intrinsics.f(string, "context.getString(R.stri…ni_add_home_tips_default)");
                    String strB = e.b(title, string);
                    TmcLogger.c(this.OooO0oO, "setAddHomeContentInfo: " + strB);
                    getTvContentInfo().setText(strB);
                } catch (Throwable th3) {
                    TmcLogger.h(this.OooO0oO, th3);
                }
                try {
                    ActivityHelper activityHelper = getActivityHelper();
                    String logo = (activityHelper == null || (app = activityHelper.getApp()) == null || (appModel = app.getAppModel()) == null) ? null : appModel.getLogo();
                    if (logo != null && logo.length() != 0) {
                        ((ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class)).loadImgRoundCorners(getContext(), logo, getIvMiniLogo(), x.a(6.0f));
                    }
                } catch (Throwable th4) {
                    TmcLogger.h(this.OooO0oO, th4);
                }
                MiniAppMultiLanguageConfig configs2 = miniAppAutoPopover.getConfigs();
                try {
                    String language2 = Locale.getDefault().getLanguage();
                    if (Intrinsics.b(language2, Locale.CHINESE.getLanguage())) {
                        if (configs2 == null || (zh2 = configs2.getZh()) == null) {
                            buttonText = null;
                        } else {
                            buttonText = zh2.getButtonText();
                        }
                    } else if (Intrinsics.b(language2, Locale.ENGLISH.getLanguage())) {
                        if (configs2 == null || (en3 = configs2.getEn()) == null) {
                            buttonText = null;
                        } else {
                            buttonText = en3.getButtonText();
                        }
                    } else if (Intrinsics.b(language2, Locale.FRANCE.getLanguage())) {
                        if (configs2 == null || (fr2 = configs2.getFr()) == null) {
                            buttonText = null;
                        } else {
                            buttonText = fr2.getButtonText();
                        }
                    } else if (Intrinsics.b(language2, new Locale("ar").getLanguage())) {
                        if (configs2 == null || (ar2 = configs2.getAr()) == null) {
                            buttonText = null;
                        } else {
                            buttonText = ar2.getButtonText();
                        }
                    } else if (Intrinsics.b(language2, new Locale("ru").getLanguage())) {
                        if (configs2 == null || (ru2 = configs2.getRu()) == null) {
                            buttonText = null;
                        } else {
                            buttonText = ru2.getButtonText();
                        }
                    } else if (Intrinsics.b(language2, new Locale("in").getLanguage())) {
                        if (configs2 == null || (id2 = configs2.getId()) == null) {
                            buttonText = null;
                        } else {
                            buttonText = id2.getButtonText();
                        }
                    } else if (configs2 == null || (en2 = configs2.getEn()) == null) {
                        buttonText = null;
                    } else {
                        buttonText = en2.getButtonText();
                    }
                    String string2 = getContext().getString(R$string.mini_addhome_dialog_btn_add);
                    Intrinsics.f(string2, "context.getString(R.stri…i_addhome_dialog_btn_add)");
                    String strB2 = e.b(buttonText, string2);
                    TmcLogger.c(this.OooO0oO, "setAddHomeBtnInfo: " + strB2);
                    getTvAddHome().setText(strB2);
                } catch (Throwable th5) {
                    TmcLogger.h(this.OooO0oO, th5);
                }
                String buttonBackgroundColor = miniAppAutoPopover.getButtonBackgroundColor();
                if (buttonBackgroundColor == null) {
                    buttonBackgroundColor = "";
                }
                String buttonTextColor = miniAppAutoPopover.getButtonTextColor();
                String str2 = buttonTextColor != null ? buttonTextColor : "";
                try {
                    if (buttonBackgroundColor.length() > 0) {
                        Drawable background = getTvAddHome().getBackground();
                        GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
                        if (gradientDrawable != null) {
                            gradientDrawable.setColor(Color.parseColor(buttonBackgroundColor));
                        }
                    }
                } catch (Throwable th6) {
                    TmcLogger.h(this.OooO0oO, th6);
                }
                try {
                    if (str2.length() > 0) {
                        getTvAddHome().setTextColor(Color.parseColor(str2));
                    }
                } catch (Throwable th7) {
                    TmcLogger.h(this.OooO0oO, th7);
                }
            }
            PopWindowManager popWindowManager = PopWindowManager.f31020a;
            String strY0 = oooO0OO.y0();
            if (j11 == 0) {
                jLongValue = (miniAppAutoPopover == null || (delayDuration = miniAppAutoPopover.getDelayDuration()) == null) ? DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT : delayDuration.longValue();
            } else {
                jLongValue = j11;
            }
            popWindowManager.a(strY0, new PopWindowManager.PopWindowData(appId, jLongValue, 1, this.f31914OooOO0o, true));
        }
    }

    public final void OooO0O0(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, "miniappAddHomeToastData", this.f31911OooO0o0 + '_' + appId, System.currentTimeMillis());
    }

    public final MiniAppAutoPopover getMMiniAppAutoPopover() {
        return this.f31908OooO;
    }

    public final long getShowAddHomeBottomTipsDelayTime() {
        return this.OooOO0O;
    }

    public final boolean getShowAddHomeBottomTipsStatus() {
        return this.f31913OooOO0;
    }

    public final void setMMiniAppAutoPopover(MiniAppAutoPopover miniAppAutoPopover) {
        this.f31908OooO = miniAppAutoPopover;
    }

    public final void setShowAddHomeBottomTipsDelayTime(long j11) {
        this.OooOO0O = j11;
    }

    public final void setShowAddHomeBottomTipsStatus(boolean z11) {
        this.f31913OooOO0 = z11;
    }
}
