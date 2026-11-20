package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniutils.util.x;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class OfflineAppView extends LinearLayout {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public String f31846OooO;
    public final String OooO00o;
    public ImageView OooO0O0;
    public TextView OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public TextView f31847OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public String f31848OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public boolean f31849OooO0o0;
    public String OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public String f31850OooO0oo;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OfflineAppView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OfflineAppView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OfflineAppView(final Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.OooO00o = "OfflineAppExtension";
        this.f31848OooO0o = "";
        this.OooO0oO = "";
        this.f31850OooO0oo = "";
        this.f31846OooO = "";
        LayoutInflater.from(context).inflate(R$layout.mini_view_offlineapp, this);
        View viewFindViewById = findViewById(R$id.iv_icon);
        Intrinsics.f(viewFindViewById, "findViewById(R.id.iv_icon)");
        this.OooO0O0 = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.tv_name);
        Intrinsics.f(viewFindViewById2, "findViewById(R.id.tv_name)");
        this.OooO0OO = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.tv_button);
        Intrinsics.f(viewFindViewById3, "findViewById(R.id.tv_button)");
        this.f31847OooO0Oo = (TextView) viewFindViewById3;
        try {
            this.OooO0O0.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OfflineAppView.OooO00o(this.f31902a, context, view);
                }
            });
            this.f31847OooO0Oo.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OfflineAppView.OooO0O0(this.f31904a, context, view);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g(this.OooO00o, "init fail:", th2);
        }
    }

    public /* synthetic */ OfflineAppView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static final void OooO00o(OfflineAppView this$0) {
        Intrinsics.g(this$0, "this$0");
        ((ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class)).loadImgRoundCorners(this$0.getContext(), new File(this$0.f31846OooO), this$0.OooO0O0, x.a(12.0f), R$drawable.mini_icon_placeholder);
    }

    public static final void OooO00o(OfflineAppView this$0, Context context, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(context, "$context");
        if (TextUtils.isEmpty(this$0.f31848OooO0o)) {
            return;
        }
        Bundle bundle = new Bundle();
        if (this$0.f31849OooO0o0) {
            bundle.putString("mfah", "1");
        }
        ByteAppManager.launchMiniAppForId(context, this$0.f31848OooO0o, "120011", bundle);
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_LATER_OFFLINE_CLICK;
        Bundle bundle2 = new Bundle();
        bundle2.putString("type", RewardPlus.ICON);
        bundle2.putString("miniappid", this$0.f31848OooO0o);
        Unit unit = Unit.f68710a;
        performanceAnalyseProxy.record("", pointAnalyseType, "", bundle2);
    }

    public static final void OooO0O0(OfflineAppView this$0, Context context, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(context, "$context");
        if (TextUtils.isEmpty(this$0.f31848OooO0o)) {
            return;
        }
        if (!this$0.f31849OooO0o0) {
            ByteAppManager.launchMiniAppForId$default(context, this$0.f31848OooO0o, "120011", null, 8, null);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_LATER_OFFLINE_CLICK;
            Bundle bundle = new Bundle();
            bundle.putString("type", "open");
            bundle.putString("miniappid", this$0.f31848OooO0o);
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.record("", pointAnalyseType, "", bundle);
            return;
        }
        new lb.e(this$0.f31848OooO0o, this$0.OooO0oO, null, this$0.f31850OooO0oo, this$0.f31846OooO);
        this$0.OooO00o(null, null);
        PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        PointAnalyseType pointAnalyseType2 = PointAnalyseType.POINT_LATER_OFFLINE_CLICK;
        Bundle bundle2 = new Bundle();
        bundle2.putString("type", "get");
        bundle2.putString("miniappid", this$0.f31848OooO0o);
        Unit unit2 = Unit.f68710a;
        performanceAnalyseProxy2.record("", pointAnalyseType2, "", bundle2);
    }

    public final void OooO00o() {
        try {
            com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: com.cloud.tmc.miniapp.widget.o
                @Override // java.lang.Runnable
                public final void run() {
                    OfflineAppView.OooO00o(this.f31906a);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g(this.OooO00o, "updateImage fail:", th2);
        }
    }

    public final void OooO00o(String appId, String logoUrl, String appName, String logoPath) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(logoUrl, "logoUrl");
        Intrinsics.g(appName, "appName");
        Intrinsics.g(logoPath, "logoPath");
        this.f31848OooO0o = appId;
        this.f31850OooO0oo = logoUrl;
        this.OooO0oO = appName;
        File file = ((IResourceProcessor) tc.a.a(IResourceProcessor.class)).get(logoPath, "1000886706715795456");
        String absolutePath = file != null ? file.getAbsolutePath() : null;
        if (absolutePath == null) {
            absolutePath = "";
        }
        this.f31846OooO = absolutePath;
    }

    public final void OooO00o(String str, Function3<? super String, ? super String, ? super String, Unit> function3) {
        Intrinsics.b(null, this.f31848OooO0o);
        String str2 = this.f31848OooO0o;
        Context context = getContext();
        Intrinsics.f(context, "context");
        this.f31849OooO0o0 = !AppUtils.f31011a.v(context, str2);
        if (!((ConfigService) tc.a.a(ConfigService.class)).getConfigBoolean("addHomeSwitch", false)) {
            TmcLogger.c(this.OooO00o, "addHomeSwitch close");
            this.f31849OooO0o0 = false;
        }
        if (this.f31849OooO0o0) {
            this.f31847OooO0Oo.setText(getResources().getText(R$string.mini_offlineapps_get));
        } else {
            this.f31847OooO0Oo.setText(getResources().getText(R$string.mini_offlineapps_open));
        }
    }
}
