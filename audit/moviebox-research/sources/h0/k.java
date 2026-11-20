package h0;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.ui.OooO0OO;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static final StatusLayout.a a(OooO0OO oooO0OO) {
        Intrinsics.g(oooO0OO, "<this>");
        if (TextUtils.isEmpty(oooO0OO.H)) {
            return null;
        }
        TmcAppInfoManager tmcAppInfoManager = (TmcAppInfoManager) tc.a.a(TmcAppInfoManager.class);
        String str = oooO0OO.H;
        Intrinsics.d(str);
        if (tmcAppInfoManager.getAppModel(oooO0OO, new lb.a(str)) != null) {
            AppUtils appUtils = AppUtils.f31011a;
            String str2 = oooO0OO.H;
            Intrinsics.d(str2);
            if (!appUtils.v(oooO0OO, str2)) {
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                String str3 = oooO0OO.H;
                PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_PIN_FOR_LATER_EX;
                Bundle bundle = new Bundle();
                bundle.putString(CampaignEx.JSON_KEY_TITLE, "add_desktop");
                Unit unit = Unit.f68710a;
                performanceAnalyseProxy.record(str3, pointAnalyseType, "", bundle);
                return oooO0OO;
            }
        }
        if (TextUtils.isEmpty(oooO0OO.D) || TextUtils.isEmpty(oooO0OO.C)) {
            return null;
        }
        PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        String str4 = oooO0OO.H;
        PointAnalyseType pointAnalyseType2 = PointAnalyseType.POINT_PIN_FOR_LATER_EX;
        Bundle bundle2 = new Bundle();
        bundle2.putString(CampaignEx.JSON_KEY_TITLE, "add_desktop");
        Unit unit2 = Unit.f68710a;
        performanceAnalyseProxy2.record(str4, pointAnalyseType2, "", bundle2);
        return oooO0OO;
    }
}
