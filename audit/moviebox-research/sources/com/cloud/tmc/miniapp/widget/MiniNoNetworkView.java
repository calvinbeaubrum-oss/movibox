package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.BidiFormatter;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.utils.i0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.offlineapps.ScanScene;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.j0;
import com.cloud.tmc.miniutils.util.x;
import com.cloud.tmc.miniutils.util.y;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class MiniNoNetworkView extends ConstraintLayout {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public final Lazy f31831OooO;
    public AppCompatImageView OooO00o;
    public TextView OooO0O0;
    public TextView OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public TextView f31832OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public StatusLayout.b f31833OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public TextView f31834OooO0o0;
    public final Lazy OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public final Lazy f31835OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public final Lazy f31836OooOO0;
    public final Lazy OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public final Lazy f31837OooOO0o;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<LinearLayout> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public LinearLayout invoke() {
            return (LinearLayout) MiniNoNetworkView.this.findViewById(R$id.ll_offline_apps);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<ConstraintLayout> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ConstraintLayout invoke() {
            return (ConstraintLayout) MiniNoNetworkView.this.findViewById(R$id.cl_offline_apps_container);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function1<View, Unit> {
        public OooO0O0() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            View it = view;
            Intrinsics.g(it, "it");
            try {
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                Bundle bundle = new Bundle();
                bundle.putString(RequestParameters.SUBRESOURCE_LOCATION, "0");
                Unit unit = Unit.f68710a;
                performanceAnalyseProxy.recordForCommon(null, "settings_click", bundle);
                if (NetworkUtils.w()) {
                    MiniNoNetworkView.this.getContext().getApplicationContext().startActivity(new Intent("android.settings.WIFI_SETTINGS").setFlags(ASTNode.DEOP));
                } else {
                    MiniNoNetworkView.this.getContext().getApplicationContext().startActivity(new Intent("android.settings.SETTINGS").setFlags(ASTNode.DEOP));
                }
            } catch (Throwable th2) {
                TmcLogger.h("MiniNoNetworkView", th2);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<ImageView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) MiniNoNetworkView.this.findViewById(R$id.iv_offline_apps_icon);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<ImageView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) MiniNoNetworkView.this.findViewById(R$id.iv_offline_apps_more);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<LinearLayout> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public LinearLayout invoke() {
            return (LinearLayout) MiniNoNetworkView.this.findViewById(R$id.ll_offline_apps_more);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0O extends Lambda implements Function0<TextView> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) MiniNoNetworkView.this.findViewById(R$id.tv_offline_apps_des);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiniNoNetworkView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiniNoNetworkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiniNoNetworkView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiniNoNetworkView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.g(context, "context");
        this.OooO0oO = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.f31835OooO0oo = LazyKt__LazyJVMKt.b(new OooOO0O());
        this.f31831OooO = LazyKt__LazyJVMKt.b(new OooOO0());
        this.f31836OooOO0 = LazyKt__LazyJVMKt.b(new OooO0o());
        this.OooOO0O = LazyKt__LazyJVMKt.b(new OooO());
        this.f31837OooOO0o = LazyKt__LazyJVMKt.b(new OooO00o());
    }

    public /* synthetic */ MiniNoNetworkView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public static final void OooO00o(MiniNoNetworkView this$0, View view) {
        StatusLayout.b bVar;
        Intrinsics.g(this$0, "this$0");
        if (com.cloud.tmc.integration.utils.u.a() || (bVar = this$0.f31833OooO0o) == null) {
            return;
        }
        bVar.a(null);
    }

    public final void OooO00o(Integer num) {
        if (num != null && num.intValue() == 2) {
            LayoutInflater.from(getContext()).inflate(R$layout.widget_mini_no_network_layout_normal_mode, this);
        } else {
            LayoutInflater.from(getContext()).inflate(R$layout.widget_mini_no_network_layout, this);
        }
        View viewFindViewById = findViewById(R$id.iv_error_logo);
        Intrinsics.f(viewFindViewById, "findViewById(R.id.iv_error_logo)");
        this.OooO00o = (AppCompatImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.tv_error_name);
        Intrinsics.f(viewFindViewById2, "findViewById(R.id.tv_error_name)");
        this.OooO0O0 = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.tv_error_app_intro);
        Intrinsics.f(viewFindViewById3, "findViewById(R.id.tv_error_app_intro)");
        this.OooO0OO = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R$id.tv_no_network_retry);
        Intrinsics.f(viewFindViewById4, "findViewById(R.id.tv_no_network_retry)");
        this.f31832OooO0Oo = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R$id.tv_no_network_info);
        Intrinsics.f(viewFindViewById5, "findViewById(R.id.tv_no_network_info)");
        this.f31834OooO0o0 = (TextView) viewFindViewById5;
        TextView textView = this.f31832OooO0Oo;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.y("mTvNoNetworkRetry");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniNoNetworkView.OooO00o(this.f31898a, view);
            }
        });
        try {
            TextView textView3 = this.f31834OooO0o0;
            if (textView3 == null) {
                Intrinsics.y("mTvNoNetworkInfo");
                textView3 = null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) y.c(R$string.mini_no_network_info));
            xb.d.b(spannableStringBuilder, BidiFormatter.getInstance().unicodeWrap(y.c(R$string.mini_network_go_setting)), Integer.valueOf(com.cloud.tmc.miniutils.util.d.a(R$color.mini_color_primary)), false, new OooO0O0());
            TextView textView4 = this.f31834OooO0o0;
            if (textView4 == null) {
                Intrinsics.y("mTvNoNetworkInfo");
                textView4 = null;
            }
            textView4.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView5 = this.f31834OooO0o0;
            if (textView5 == null) {
                Intrinsics.y("mTvNoNetworkInfo");
            } else {
                textView2 = textView5;
            }
            xb.h.b(textView2);
            textView3.setText(new SpannedString(spannableStringBuilder));
        } catch (Throwable th2) {
            TmcLogger.h("MiniNoNetworkView", th2);
        }
    }

    public final void OooO00o(String str, String str2, String str3) {
        AppCompatImageView appCompatImageView;
        setVisibility(0);
        TextView textView = this.OooO0O0;
        if (textView == null) {
            Intrinsics.y("mTvErrorName");
            textView = null;
        }
        textView.setText(str);
        TextView textView2 = this.OooO0OO;
        if (textView2 == null) {
            Intrinsics.y("mTvErrorAppIntro");
            textView2 = null;
        }
        textView2.setText(str3);
        if (!i0.b(str2)) {
            IPackageResourceManager iPackageResourceManager = (IPackageResourceManager) tc.a.a(IPackageResourceManager.class);
            str2 = iPackageResourceManager.getFilePath("1000886706715795456", iPackageResourceManager.getVhost("1000886706715795456") + str2);
        }
        ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class);
        Context context = getContext();
        if (str2 == null) {
            str2 = "";
        }
        String str4 = str2;
        AppCompatImageView appCompatImageView2 = this.OooO00o;
        if (appCompatImageView2 == null) {
            Intrinsics.y("mIvErrorLogo");
            appCompatImageView = null;
        } else {
            appCompatImageView = appCompatImageView2;
        }
        int iA = x.a(14.0f);
        Integer num = 1;
        int i11 = (num != null && num.intValue() == 2) ? R$drawable.drawable_app_icon_place_holder_normal_mode : R$drawable.drawable_app_icon_place_holder;
        Integer num2 = 1;
        imageLoaderProxy.loadImgRoundCorners(context, str4, appCompatImageView, iA, i11, (num2 != null && num2.intValue() == 2) ? R$drawable.drawable_app_icon_place_holder_normal_mode : R$drawable.drawable_app_icon_place_holder);
        ImageView ivOfflineAppsMore = getIvOfflineAppsMore();
        if (ivOfflineAppsMore != null) {
            ivOfflineAppsMore.setRotationY(j0.a() ? 180.0f : 0.0f);
        }
        ImageView ivOfflineAppsIcon = getIvOfflineAppsIcon();
        if (ivOfflineAppsIcon != null) {
            ivOfflineAppsIcon.setRotationY(j0.a() ? 180.0f : 0.0f);
        }
        Context context2 = getContext();
        Intrinsics.f(context2, "context");
        LinearLayout llOfflineAppsMore = getLlOfflineAppsMore();
        LinearLayout llOfflineApps = getLlOfflineApps();
        ConstraintLayout clOfflineAppsContainer = getClOfflineAppsContainer();
        Intrinsics.g(this, "<this>");
        Intrinsics.g(context2, "context");
        int iN = NetworkUtils.n();
        if (iN == 1) {
            if (clOfflineAppsContainer != null) {
                clOfflineAppsContainer.setVisibility(8);
            }
            TmcLogger.c("OfflineAppExtension", "NetworkUtils.getNetworkStatus:" + iN);
            return;
        }
        if (!((ConfigService) tc.a.a(ConfigService.class)).getConfigBoolean("offlineAppsSwitch", true)) {
            if (clOfflineAppsContainer != null) {
                clOfflineAppsContainer.setVisibility(8);
            }
            TmcLogger.c("OfflineAppExtension", "offlineAppsSwitch is close");
        } else {
            ScanScene scanScene = ScanScene.SCAN_PINFORLATER;
            h0.j jVar = new h0.j(clOfflineAppsContainer, llOfflineAppsMore, llOfflineApps, context2);
            Intrinsics.g(scanScene, "scanScene");
            p.d.f73467a.g(false, scanScene, jVar);
        }
    }

    public final ConstraintLayout getClOfflineAppsContainer() {
        return (ConstraintLayout) this.f31837OooOO0o.getValue();
    }

    public final ImageView getIvOfflineAppsIcon() {
        return (ImageView) this.OooO0oO.getValue();
    }

    public final ImageView getIvOfflineAppsMore() {
        return (ImageView) this.f31836OooOO0.getValue();
    }

    public final LinearLayout getLlOfflineApps() {
        return (LinearLayout) this.OooOO0O.getValue();
    }

    public final LinearLayout getLlOfflineAppsMore() {
        return (LinearLayout) this.f31831OooO.getValue();
    }

    public final TextView getTvOfflineAppsDes() {
        return (TextView) this.f31835OooO0oo.getValue();
    }

    public final void setOnPinForLaterListener(StatusLayout.a aVar) {
    }

    public final void setOnRetryListener(StatusLayout.b bVar) {
        this.f31833OooO0o = bVar;
    }
}
