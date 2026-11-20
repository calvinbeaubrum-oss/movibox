package h0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewGroupKt;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.offlineapps.OfflineAppBean;
import com.cloud.tmc.miniapp.widget.OfflineAppView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements p.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f65701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f65702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f65703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f65704d;

    public j(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, Context context) {
        this.f65701a = constraintLayout;
        this.f65702b = linearLayout;
        this.f65703c = linearLayout2;
        this.f65704d = context;
    }

    public static final void b(Context context, View view) {
        Intrinsics.g(context, "$context");
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_LATER_OFFLINE_CLICK;
        Bundle bundle = new Bundle();
        bundle.putString("type", "more");
        Unit unit = Unit.f68710a;
        performanceAnalyseProxy.record("", pointAnalyseType, "", bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putString("openMCScene", "1");
        ByteAppManager.launchMiniAppForId(context, "1000886706715795456", "120011", bundle2);
    }

    public static final void c(List offlineApps, ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, final Context context) {
        Intrinsics.g(offlineApps, "$offlineApps");
        Intrinsics.g(context, "$context");
        try {
            if (offlineApps.isEmpty()) {
                if (constraintLayout == null) {
                    return;
                }
                constraintLayout.setVisibility(8);
                return;
            }
            Bundle bundle = new Bundle();
            int i11 = 0;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            if (offlineApps.size() > 4) {
                bundle.putString(NotificationCompat.CATEGORY_STATUS, "more");
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            } else if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", PointAnalyseType.POINT_LATER_OFFLINE_EX, "", bundle);
            ArrayList arrayList = new ArrayList();
            int i12 = 0;
            while (i12 < 4) {
                if (i12 >= offlineApps.size()) {
                    View view = linearLayout2 != null ? ViewGroupKt.get(linearLayout2, i12) : null;
                    if (view != null) {
                        view.setVisibility(4);
                    }
                } else {
                    OfflineAppBean offlineAppBean = (OfflineAppBean) offlineApps.get(i12);
                    View view2 = linearLayout2 != null ? ViewGroupKt.get(linearLayout2, i12) : null;
                    if (view2 != null) {
                        view2.setVisibility(i11);
                    }
                    View view3 = linearLayout2 != null ? ViewGroupKt.get(linearLayout2, i12) : null;
                    OfflineAppView offlineAppView = view3 instanceof OfflineAppView ? (OfflineAppView) view3 : null;
                    if (offlineAppView != null) {
                        String appId = offlineAppBean.getAppId();
                        String logoUrl = offlineAppBean.getLogoUrl();
                        if (logoUrl == null) {
                            logoUrl = "";
                        }
                        String name = offlineAppBean.getName();
                        if (name == null) {
                            name = "";
                        }
                        String logoPath = offlineAppBean.getLogoPath();
                        offlineAppView.OooO00o(appId, logoUrl, name, logoPath == null ? "" : logoPath);
                        offlineAppView.OooO00o();
                        offlineAppView.OooO0OO.setText(offlineAppView.OooO0oO);
                        offlineAppView.OooO00o(null, null);
                    }
                    arrayList.add(offlineAppBean.getAppId());
                }
                i12++;
                i11 = 0;
            }
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_LATER_OFFLINE_APP_EX;
            Bundle bundle2 = new Bundle();
            bundle2.putString("miniappid", arrayList.toString());
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.record("", pointAnalyseType, "", bundle2);
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: h0.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        j.b(context, view4);
                    }
                });
            }
        } catch (Throwable th2) {
            TmcLogger.g("OfflineAppExtension", "offlineAppUpdate fail:", th2);
        }
    }

    @Override // p.a
    public void a(final List<OfflineAppBean> offlineApps) {
        Intrinsics.g(offlineApps, "offlineApps");
        final ConstraintLayout constraintLayout = this.f65701a;
        final LinearLayout linearLayout = this.f65702b;
        final LinearLayout linearLayout2 = this.f65703c;
        final Context context = this.f65704d;
        com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: h0.h
            @Override // java.lang.Runnable
            public final void run() {
                j.c(offlineApps, constraintLayout, linearLayout, linearLayout2, context);
            }
        });
    }
}
