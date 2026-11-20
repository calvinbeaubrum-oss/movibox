package com.cloud.hisavana.sdk;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.RequestParams;
import com.cloud.hisavana.net.impl.StringCallback;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.DiskTrackingBean;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.MitNetUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class o1 {

    /* JADX INFO: compiled from: source.java */
    public class a extends com.cloud.hisavana.sdk.manager.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DiskTrackingBean f29944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.cloud.hisavana.sdk.manager.g.b f29945b;

        public a(DiskTrackingBean diskTrackingBean, com.cloud.hisavana.sdk.manager.g.b bVar) {
            this.f29944a = diskTrackingBean;
            this.f29945b = bVar;
        }

        @Override // com.cloud.hisavana.sdk.manager.g.c
        public void a(@NonNull String str) {
            com.cloud.hisavana.sdk.manager.g.f29881d.a().m(this.f29944a);
            com.cloud.hisavana.sdk.manager.g.b bVar = this.f29945b;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.cloud.hisavana.sdk.manager.g.c
        public void b(@NonNull String str, int i11) {
            if (i11 < 480) {
                com.cloud.hisavana.sdk.manager.g.f29881d.a().f(this.f29944a);
                a(str);
            } else {
                com.cloud.hisavana.sdk.manager.g.b bVar = this.f29945b;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DiskTrackingBean f29946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.cloud.hisavana.sdk.manager.g.c f29947b;

        public b(DiskTrackingBean diskTrackingBean, com.cloud.hisavana.sdk.manager.g.c cVar) {
            this.f29946a = diskTrackingBean;
            this.f29947b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o1.q(this.f29946a.getTrackingUrl(), null, this.f29946a, this.f29947b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends StringCallback {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.cloud.hisavana.sdk.manager.g.c f29948e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f29949f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29950g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ DiskTrackingBean f29951h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z11, com.cloud.hisavana.sdk.manager.g.c cVar, String str, AdsDTO adsDTO, DiskTrackingBean diskTrackingBean) {
            super(z11);
            this.f29948e = cVar;
            this.f29949f = str;
            this.f29950g = adsDTO;
            this.f29951h = diskTrackingBean;
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback
        public void y(int i11, String str, Throwable th2) {
            com.cloud.hisavana.sdk.manager.g.c cVar = this.f29948e;
            if (cVar != null) {
                if (i11 != 200) {
                    cVar.b(this.f29949f, i11);
                } else {
                    cVar.a(this.f29949f);
                }
            }
            AthenaTracker.j0(this.f29950g, this.f29951h, this.f29949f, i11, str, th2);
            z.a().d(com.cloud.sdk.commonutil.util.c.TRACK_TAG, "sendRequestToServer --> onFailure --> statusCode = " + i11 + ",url " + this.f29949f + ",throwable " + th2);
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback
        public void z(int i11, String str) {
            com.cloud.hisavana.sdk.manager.g.c cVar = this.f29948e;
            if (cVar != null) {
                cVar.a(this.f29949f);
            }
            AthenaTracker.j0(this.f29950g, this.f29951h, this.f29949f, i11, str, null);
            z.a().d(com.cloud.sdk.commonutil.util.c.TRACK_TAG, "sendRequestToServer - onSuccess - statusCode = " + i11 + " url " + this.f29949f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f29952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdsDTO f29953b;

        public d(String str, AdsDTO adsDTO) {
            this.f29952a = str;
            this.f29953b = adsDTO;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f29952a;
            AdsDTO adsDTO = this.f29953b;
            o1.q(str, adsDTO, null, new e(adsDTO));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends com.cloud.hisavana.sdk.manager.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AdsDTO f29954a;

        public e(AdsDTO adsDTO) {
            this.f29954a = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.manager.g.c
        public void a(@NonNull String str) {
        }

        @Override // com.cloud.hisavana.sdk.manager.g.c
        public void b(@NonNull String str, int i11) {
            DiskTrackingBean diskTrackingBean;
            AdsDTO adsDTO = this.f29954a;
            if (adsDTO == null) {
                return;
            }
            if (adsDTO.getDspType().intValue() == 2) {
                if (TextUtils.isEmpty(str) || !this.f29954a.isDownloadAd() || i11 < 480 || !this.f29954a.getAdxAscribeRetryEnable()) {
                    return;
                } else {
                    diskTrackingBean = new DiskTrackingBean(str);
                }
            } else if (TextUtils.isEmpty(str) || i11 < 480) {
                return;
            } else {
                diskTrackingBean = new DiskTrackingBean(str);
            }
            diskTrackingBean.setData(this.f29954a);
            com.cloud.hisavana.sdk.manager.g.f29881d.a().j(diskTrackingBean);
        }
    }

    public static String c(DownUpPointBean downUpPointBean, AdsDTO adsDTO, boolean z11, Boolean bool) {
        z zVarA = z.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TrackingManager --> processUrl --> 处理前 url = ");
        sb2.append(adsDTO == null ? "" : adsDTO.getClickUrl());
        zVarA.d(com.cloud.sdk.commonutil.util.c.TRACK_TAG, sb2.toString());
        if (adsDTO == null) {
            return null;
        }
        String clickUrl = z11 ? adsDTO.getClickUrl() : adsDTO.getImpressionUrl();
        if (TextUtils.isEmpty(clickUrl) || !clickUrl.contains("?")) {
            return clickUrl;
        }
        StringBuilder sb3 = new StringBuilder();
        if (z11 && downUpPointBean != null) {
            sb3.append("xd=" + downUpPointBean.getDownX());
            sb3.append("&yd=" + downUpPointBean.getDownY());
            sb3.append("&xu=" + downUpPointBean.getUpX());
            sb3.append("&yu=" + downUpPointBean.getUpY());
        }
        sb3.append("&ai=" + AdManager.f29117b);
        sb3.append("&pn=" + com.cloud.sdk.commonutil.util.f.c());
        sb3.append("&ve=" + com.cloud.sdk.commonutil.util.f.e());
        sb3.append("&sv=3.3.6.1");
        sb3.append("&ot=1");
        sb3.append("&ov=" + DeviceUtil.l());
        sb3.append("&nc=" + MitNetUtil.a(com.cloud.sdk.commonutil.util.f.a()).ordinal());
        if (ca.d.d() != null && ca.d.e() != null) {
            sb3.append("&op=" + ca.d.d() + ca.d.e());
        }
        sb3.append("&ga=" + DeviceUtil.e());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("&dt=");
        boolean z12 = true;
        sb4.append(ea.c.d() ? 2 : 1);
        sb3.append(sb4.toString());
        sb3.append("&br=" + Build.BRAND);
        sb3.append("&mo=" + Build.MODEL);
        sb3.append("&ma=" + Build.MANUFACTURER);
        sb3.append("&la=" + com.cloud.sdk.commonutil.util.e.d());
        sb3.append("&lo=" + com.cloud.sdk.commonutil.util.e.f());
        if (downUpPointBean != null) {
            sb3.append("&iw=" + downUpPointBean.getImageW());
            sb3.append("&ih=" + downUpPointBean.getImageH());
        }
        sb3.append("&ci=" + adsDTO.getClickid());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("&tr=");
        if (!AdManager.i() && !adsDTO.getTestResponse().booleanValue()) {
            z12 = false;
        }
        sb5.append(z12);
        sb3.append(sb5.toString());
        sb3.append("&ia=" + Integer.valueOf(adsDTO.getInstallApk()));
        if (z11) {
            sb3.append("&pt=" + adsDTO.getAdPsType());
        }
        AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest();
        if (impBeanRequest != null) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("&gan=");
            sb6.append(TextUtils.isEmpty(impBeanRequest.gameName) ? "" : impBeanRequest.gameName);
            sb3.append(sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("&gas=");
            sb7.append(TextUtils.isEmpty(impBeanRequest.gameScene) ? "" : impBeanRequest.gameScene);
            sb3.append(sb7.toString());
        }
        if (!adsDTO.isOfflineAd()) {
            sb3.append("&ta=" + DeviceUtil.f());
            sb3.append("&oi=" + DeviceUtil.j());
        }
        if (bool != null) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append("&ps=");
            sb8.append(bool.booleanValue() ? "1" : "0");
            sb3.append(sb8.toString());
        }
        z.a().d(com.cloud.sdk.commonutil.util.c.TRACK_TAG, "athena --> sb=" + ((Object) sb3));
        String str = clickUrl + "&p1=" + com.cloud.sdk.commonutil.util.a.a(sb3.toString()) + "&r1=" + com.cloud.sdk.commonutil.util.a.a(adsDTO.getNewPrice_Click());
        if (ca.b.h0()) {
            String strM = ca.b.m();
            if (!TextUtils.isEmpty(strM)) {
                str = str + "&a=" + strM;
            }
        }
        z.a().d(com.cloud.sdk.commonutil.util.c.TRACK_TAG, "TrackingManager --> processUrl --> process after url = " + str);
        return str;
    }

    public static String d(AdsDTO adsDTO) {
        int i11;
        String str = "";
        if (adsDTO == null) {
            return "";
        }
        if (adsDTO.getImpBeanRequest() == null || adsDTO.getImpBeanRequest().triggerId == null) {
            i11 = 0;
        } else {
            str = adsDTO.getImpBeanRequest().triggerId;
            i11 = adsDTO.getImpBeanRequest().mTriggerNetState;
        }
        return "&isOfflineAd=" + (adsDTO.isOfflineAd() ? 1 : 0) + "&clickTs=" + System.currentTimeMillis() + "&triggerId=" + str + "&adTriggerStatus=" + i11;
    }

    public static String e(String str, AdsDTO adsDTO, boolean z11) {
        String strH;
        if (TextUtils.isEmpty(str) || adsDTO == null) {
            return null;
        }
        String clickid = adsDTO.getClickid();
        if (str.contains("__CLICK_ID__") && clickid != null) {
            str = str.replace("__CLICK_ID__", clickid);
        }
        String uuid = adsDTO.getUuid();
        if (str.contains("__SHOW_ID__") && uuid != null) {
            str = str.replace("__SHOW_ID__", uuid);
        }
        if (str.contains("__CLICK_TS__")) {
            str = str.replace("__CLICK_TS__", String.valueOf(System.currentTimeMillis() - da.a.d().g("services_time_difference_value")));
        }
        if (str.contains("__AD_TRIGGER_STATUS__")) {
            str = str.replace("__AD_TRIGGER_STATUS__", String.valueOf(adsDTO.getImpBeanRequest() == null ? 0 : adsDTO.getImpBeanRequest().mTriggerNetState));
        }
        int source = adsDTO.getSource();
        String strE = DeviceUtil.e();
        if (source == 4 && str.contains("__GAID__") && !TextUtils.isEmpty(strE)) {
            str = str.replace("__GAID__", strE);
        }
        if (str.contains("__CLICK_IP__") && (strH = DeviceUtil.h()) != null) {
            str = str.replace("__CLICK_IP__", strH);
        }
        double dDoubleValue = z11 ? adsDTO.getAuctionSecondPrice().doubleValue() : 0.0d;
        String settlementRatio = z11 ? adsDTO.getSettlementRatio() : null;
        if (str.contains("${AUCTION_PRICE}")) {
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(dDoubleValue);
            if (settlementRatio != null) {
                try {
                    BigDecimal bigDecimal = new BigDecimal(settlementRatio);
                    if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                        bigDecimalValueOf = bigDecimalValueOf.divide(bigDecimal, 0, 2).add(new BigDecimal(1));
                    }
                } catch (Exception e11) {
                    z.a().d("ssp", Log.getStackTraceString(e11));
                }
            }
            str = str.replace("${AUCTION_PRICE}", String.valueOf(bigDecimalValueOf.divide(BigDecimal.valueOf(100L), 2, 2)));
        }
        String codeSeatId = adsDTO.getCodeSeatId();
        if (str.contains("__CODE_SEAT_ID__") && !TextUtils.isEmpty(codeSeatId)) {
            str = str.replace("__CODE_SEAT_ID__", codeSeatId);
        }
        if (str.contains("__CLICK_HALF_SCREEN_TYPE__")) {
            return str.replace("__CLICK_HALF_SCREEN_TYPE__", adsDTO.isHalfScreenAd() ? "1" : "0");
        }
        return str;
    }

    public static void f(DiskTrackingBean diskTrackingBean, com.cloud.hisavana.sdk.manager.g.b bVar) {
        z.a().d("TrackingManager", "resendUrl ");
        if (diskTrackingBean != null && !TextUtils.isEmpty(diskTrackingBean.getTrackingUrl())) {
            com.cloud.sdk.commonutil.util.i.f30292a.e(new b(diskTrackingBean, new a(diskTrackingBean, bVar)));
        } else if (bVar != null) {
            bVar.a();
        }
    }

    public static void g(DownUpPointBean downUpPointBean, AdsDTO adsDTO, Boolean bool) {
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getClickUrl()) || downUpPointBean == null) {
            z.a().d(com.cloud.sdk.commonutil.util.c.TRACK_TAG, "reportServerClick --> null == url || null == pointBean");
            return;
        }
        z.a().d(com.cloud.sdk.commonutil.util.c.TRACK_TAG, "TrackingManager --> processUrl --> pointBean = " + downUpPointBean);
        String clickUrl = adsDTO.getClickUrl();
        if (adsDTO.getDspType().intValue() != 1) {
            q(clickUrl, adsDTO, null, new e(adsDTO));
            return;
        }
        String strC = c(downUpPointBean, adsDTO, true, bool);
        if (!TextUtils.isEmpty(strC) && strC.contains("?")) {
            strC = strC + d(adsDTO);
        }
        AthenaTracker.H(strC, adsDTO, bool);
        q(strC, adsDTO, null, new e(adsDTO));
    }

    public static void h(AdsDTO adsDTO, DownUpPointBean downUpPointBean, com.cloud.hisavana.sdk.manager.g.c cVar) {
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getImpressionUrl()) || downUpPointBean == null) {
            z.a().d(com.cloud.sdk.commonutil.util.c.TRACK_TAG, "reportServerShow --> null == url || null == pointBean");
            return;
        }
        z.a().d(com.cloud.sdk.commonutil.util.c.TRACK_TAG, "TrackingManager --> processUrl --> pointBean = " + downUpPointBean);
        q(c(downUpPointBean, adsDTO, false, null), adsDTO, null, cVar);
    }

    public static /* synthetic */ void i(AdsDTO adsDTO, List list, DownUpPointBean downUpPointBean) {
        if (adsDTO == null) {
            return;
        }
        e eVar = new e(adsDTO);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!TextUtils.isEmpty(str)) {
                if (o(str)) {
                    adsDTO.setImpressionUrl(str);
                    h(adsDTO, downUpPointBean, eVar);
                } else {
                    q(e(str, adsDTO, true), adsDTO, null, eVar);
                }
            }
        }
    }

    public static void j(String str, AdsDTO adsDTO) {
        com.cloud.sdk.commonutil.util.i.f30292a.e(new d(str, adsDTO));
    }

    public static /* synthetic */ void l(String str, AdsDTO adsDTO, com.cloud.hisavana.sdk.manager.g.c cVar) {
        q(e(str, adsDTO, false), adsDTO, null, cVar);
    }

    public static void m(List<String> list, final AdsDTO adsDTO) {
        if (list == null || list.isEmpty() || adsDTO == null) {
            z.a().d(com.cloud.sdk.commonutil.util.c.TRACK_TAG, "clickTrackingUrls || showTrackingUrls --> urls==null || urls is empty --> return ");
            return;
        }
        final e eVar = new e(adsDTO);
        for (final String str : list) {
            if (!TextUtils.isEmpty(str)) {
                com.cloud.sdk.commonutil.util.i.f30292a.e(new Runnable() { // from class: com.cloud.hisavana.sdk.c2
                    @Override // java.lang.Runnable
                    public final void run() {
                        o1.l(str, adsDTO, eVar);
                    }
                });
            }
        }
    }

    public static void n(final List<String> list, final AdsDTO adsDTO, final DownUpPointBean downUpPointBean) {
        if (list == null || list.isEmpty() || adsDTO == null) {
            z.a().d(com.cloud.sdk.commonutil.util.c.TRACK_TAG, "clickTrackingUrls || showTrackingUrls --> urls==null || urls is empty --> return ");
        } else {
            com.cloud.sdk.commonutil.util.i.f30292a.e(new Runnable() { // from class: com.cloud.hisavana.sdk.d2
                @Override // java.lang.Runnable
                public final void run() {
                    o1.i(adsDTO, list, downUpPointBean);
                }
            });
        }
    }

    public static boolean o(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("api.test.eagllwin.com") || str.contains("api.eagllwin.com") || str.contains("api.pre.eagllwin.com") || str.contains("api.fat1.eagllwin.com"));
    }

    public static ArrayList<String> p(List<String> list, AdsDTO adsDTO) {
        if (list == null || list.isEmpty() || adsDTO == null) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>(0);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String strE = e(it.next(), adsDTO, true);
            if (!TextUtils.isEmpty(strE)) {
                arrayList.add(strE);
            }
        }
        return arrayList;
    }

    public static void q(String str, AdsDTO adsDTO, DiskTrackingBean diskTrackingBean, com.cloud.hisavana.sdk.manager.g.c cVar) {
        z.a().d(com.cloud.sdk.commonutil.util.c.TRACK_TAG, "sendRequestToServer - url = " + str);
        if (str == null) {
            return;
        }
        RequestParams requestParams = new RequestParams();
        requestParams.h("User-Agent", com.cloud.sdk.commonutil.util.s.c());
        requestParams.h("Accept-Timezone", "UTC");
        HttpRequest.f28935a.h(str, requestParams, new c(true, cVar, str, adsDTO, diskTrackingBean));
    }
}
