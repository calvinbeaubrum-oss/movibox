package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.net.NetGroup;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.AdServerRequest;
import com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigResponseBody;
import com.cloud.hisavana.sdk.data.bean.response.ConfigTotalDTO;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.MitNetUtil;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f30151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f30152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f30153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f30154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile String f30155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f30156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile ConfigTotalDTO.ExtInfo f30157g;

    /* JADX INFO: compiled from: source.java */
    public class a implements AdServerRequest.b {
        public a() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.AdServerRequest.b
        public String a() {
            return m0.b();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends CommonResponseListener<ConfigResponseBody> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f30159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f30160c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30161d;

        /* JADX INFO: compiled from: source.java */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ConfigResponseBody f30163a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ConfigTotalDTO f30164b;

            /* JADX INFO: renamed from: com.cloud.hisavana.sdk.v$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class RunnableC0333a implements Runnable {
                public RunnableC0333a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    v.this.f30152b = aVar.f30164b.getCloudControlVersion();
                    a aVar2 = a.this;
                    v.this.f30155e = aVar2.f30164b.getSspUrl();
                    boolean z11 = a.this.f30164b.getAbTestEnable().booleanValue() && NetGroup.a(v.this.f30155e);
                    da.a.d().m("abTestEnable", z11);
                    NetGroup.g(z11);
                    com.cloud.sdk.commonutil.util.c.netLog("NetGroup abTestEnable = " + z11);
                    da.a.d().p("hisavanaCurrentCloudControlVersion", v.this.f30152b);
                    da.a.d().p("new_hisavana_ver", v.this.f30152b);
                    da.a.d().p("hisavanaRequestUrl", v.this.f30155e);
                    if (a.this.f30164b.getPreConnectEnable() != null) {
                        da.a.d().m("preLoadNet", a.this.f30164b.getPreConnectEnable().booleanValue());
                    }
                    Boolean antifraudPowerEnable = a.this.f30164b.getAntifraudPowerEnable();
                    if (antifraudPowerEnable != null) {
                        ca.b.u0(antifraudPowerEnable.booleanValue());
                    }
                    String antifraudSubfunctionControl = a.this.f30164b.getAntifraudSubfunctionControl();
                    if (!TextUtils.isEmpty(antifraudSubfunctionControl)) {
                        try {
                            Integer.parseInt(antifraudSubfunctionControl, 2);
                            String strSubstring = antifraudSubfunctionControl.substring(antifraudSubfunctionControl.indexOf("1"));
                            if (!TextUtils.isEmpty(strSubstring)) {
                                ca.b.t0(strSubstring);
                            }
                        } catch (Exception e11) {
                            z.a().w(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "parsing AntifraudSubfunctionControl failed:" + Log.getStackTraceString(e11));
                        }
                    }
                    a aVar3 = a.this;
                    v.this.l(aVar3.f30163a.getData().getCodeSeats(), b.this.f30160c);
                }
            }

            public a(ConfigResponseBody configResponseBody, ConfigTotalDTO configTotalDTO) {
                this.f30163a = configResponseBody;
                this.f30164b = configTotalDTO;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!x.h().f(this.f30163a.getData().getCodeSeats()) || this.f30164b == null) {
                    return;
                }
                com.cloud.sdk.commonutil.util.i.f30292a.e(new RunnableC0333a());
            }
        }

        public b(long j11, int i11, String str) {
            this.f30159b = j11;
            this.f30160c = i11;
            this.f30161d = str;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            AthenaTracker.K(this.f30160c, this.f30161d, (int) (System.currentTimeMillis() - this.f30159b), 1, taErrorCode == null ? "request error" : taErrorCode.getErrorMessage(), "");
            v.this.f30151a.set(false);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(int i11, ConfigResponseBody configResponseBody) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f30159b;
            v.this.f30151a.set(false);
            z.a().d("ConfigManager", "onRequestSuccess statusCode " + i11);
            v.this.f30153c = System.currentTimeMillis();
            da.a.d().o("requestConfigTime", v.this.f30153c);
            if (configResponseBody == null || configResponseBody.getCode().intValue() != 0) {
                AthenaTracker.K(this.f30160c, this.f30161d, (int) jCurrentTimeMillis, 1, "response is null or responseCode is wrong", "");
                return;
            }
            ConfigTotalDTO data = configResponseBody.getData();
            AthenaTracker.K(this.f30160c, this.f30161d, (int) jCurrentTimeMillis, 0, "", v.this.f30152b);
            if (data != null) {
                int iIntValue = data.getCloudControlCacheInterval().intValue();
                if (iIntValue > 0) {
                    v.this.f30154d = ((long) iIntValue) * 3600000;
                    da.a.d().o("requestConfigInterval", v.this.f30154d);
                }
                v.this.f30156f = data.isShowRuStyle();
                da.a.d().m("show_ru_style", v.this.f30156f);
                if (data.getAdInternalBlackBrands() == null || data.getAdInternalBlackBrands().isEmpty()) {
                    da.a.d().q("ad_internal_black_brands");
                } else {
                    z.a().d("ConfigManager", " ad internal black brands：" + data.getAdInternalBlackBrands().toString());
                    da.a.d().p("ad_internal_black_brands", TextUtils.join(",", data.getAdInternalBlackBrands()));
                }
                da.a.d().m("polygamma_init_enable", data.isInitPolyGammaEnable());
                da.a.d().m("default_is_open", data.getAdInternalRequestEnable());
                a0.f29085a.o(data.getAdInternalRequestEnable());
                q1.b(data.getShowDataSyncTimeInterval(), data.getClickDataSyncTimeInterval());
                String extInfo = data.getExtInfo();
                da.a.d().p("cloudConfigExtInfo", extInfo);
                v.this.k(extInfo);
            }
            if (data == null || data.getCodeSeats() == null || data.getCodeSeats().isEmpty()) {
                return;
            }
            if (data.getCdnVersionAddressRequestTimeInterval().intValue() > 0) {
                da.a.d().o("default_interval", data.getCdnVersionAddressRequestTimeInterval().intValue() * 60000);
            }
            com.cloud.sdk.commonutil.util.i.f30292a.b(new a(configResponseBody, data));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f30167a = new v(null);
    }

    public v() {
        this.f30151a = new AtomicBoolean(false);
        this.f30156f = false;
        this.f30155e = da.a.d().i("hisavanaRequestUrl");
        this.f30156f = da.a.d().b("show_ru_style");
        k(da.a.d().i("cloudConfigExtInfo"));
    }

    public /* synthetic */ v(a aVar) {
        this();
    }

    public static v p() {
        return c.f30167a;
    }

    public ConfigTotalDTO.ExtInfo d() {
        return this.f30157g;
    }

    public void g(final int i11) {
        z.a().d("ConfigManager", "requestCloudControl type:" + i11);
        final String strN = DeviceUtil.n();
        com.cloud.sdk.commonutil.util.i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.m3
            @Override // java.lang.Runnable
            public final void run() {
                this.f29867a.h(i11, strN);
            }
        });
    }

    public final /* synthetic */ void h(final int i11, final String str) {
        final Map<String, ConfigCodeSeatDTO> mapD = x.h().d();
        if (mapD != null && !mapD.isEmpty()) {
            for (ConfigCodeSeatDTO configCodeSeatDTO : mapD.values()) {
                x.h().i(configCodeSeatDTO);
                x.h().b(configCodeSeatDTO);
            }
        }
        com.cloud.sdk.commonutil.util.i.f30292a.e(new Runnable() { // from class: com.cloud.hisavana.sdk.n3
            @Override // java.lang.Runnable
            public final void run() {
                this.f29936a.i(i11, str, mapD);
            }
        });
    }

    public final /* synthetic */ void i(int i11, String str, Map map) {
        boolean zC = MitNetUtil.c(com.cloud.sdk.commonutil.util.f.a());
        NetStateManager.setIsNetAvailable(zC);
        if (!zC || this.f30151a.get()) {
            if (i11 != 3) {
                AthenaTracker.k0(null, i11);
                AthenaTracker.Z(null, i11, 2);
            }
            z.a().e("ConfigManager", "requestCloudControl net is not available,or is requesting");
            return;
        }
        if (this.f30152b == null) {
            this.f30152b = da.a.d().j("hisavanaCurrentCloudControlVersion", null);
        }
        if (this.f30152b == null) {
            q(i11, str);
            return;
        }
        if (TextUtils.equals(da.a.d().i("new_hisavana_ver"), this.f30152b)) {
            if (this.f30153c == 0) {
                this.f30153c = da.a.d().h("requestConfigTime", 0L);
            }
            if (this.f30154d == 0) {
                this.f30154d = da.a.d().h("requestConfigInterval", 259200000L);
            }
            if (System.currentTimeMillis() - this.f30153c <= this.f30154d) {
                z.a().e("ConfigManager", "time is not ready");
                if (map != null) {
                    l(map.values(), i11);
                    return;
                } else {
                    z.a().e("ConfigManager", "requestCloudControl download material fail,config list is null");
                    return;
                }
            }
        }
        q(i11, str);
    }

    public final void k(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f30157g = null;
        } else {
            try {
                this.f30157g = (ConfigTotalDTO.ExtInfo) GsonUtil.a(str, ConfigTotalDTO.ExtInfo.class);
            } catch (Exception unused) {
            }
        }
    }

    public final void l(Collection<ConfigCodeSeatDTO> collection, int i11) {
        z0.t().o(collection, i11);
    }

    public final void q(int i11, String str) {
        if (this.f30151a.get()) {
            z.a().d("ConfigManager", "config is requesting");
            return;
        }
        z.a().d("ConfigManager", "request type " + i11);
        this.f30151a.set(true);
        AthenaTracker.J(i11, str);
        AdServerRequest adServerRequestR = new AdServerRequest().n(new b(System.currentTimeMillis(), i11, str)).p(new a()).l(AdManager.h()).r(aa.a.d() + aa.a.c());
        if (adServerRequestR != null) {
            adServerRequestR.c();
        }
    }

    public String s() {
        if (TextUtils.isEmpty(this.f30155e)) {
            this.f30155e = da.a.d().i("hisavanaRequestUrl");
        }
        if (TextUtils.isEmpty(this.f30155e)) {
            this.f30155e = aa.a.i() + aa.a.h();
        }
        return this.f30155e;
    }

    public boolean w() {
        return this.f30156f;
    }
}
