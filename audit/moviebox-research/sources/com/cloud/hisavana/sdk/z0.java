package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.AdServerRequest;
import com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdResponseBody;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f30230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<ConfigCodeSeatDTO> f30231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConfigCodeSeatDTO f30232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f30233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.cloud.hisavana.sdk.e.c f30234e;

    /* JADX INFO: compiled from: source.java */
    public class a implements com.cloud.hisavana.sdk.e.c {
        public a() {
        }

        @Override // com.cloud.hisavana.sdk.e.c
        public void a(AdxImpBean adxImpBean, List<AdsDTO> list, TaErrorCode taErrorCode) {
            if (list == null || list.size() <= 0) {
                AthenaTracker.i0(null, taErrorCode, adxImpBean, 0);
            } else {
                AthenaTracker.i0(list, taErrorCode, adxImpBean, list.size());
            }
            a(null);
        }

        @Override // com.cloud.hisavana.sdk.e.c
        public void a(List<AdsDTO> list) {
            if (list != null) {
                ArrayList arrayList = new ArrayList(list);
                if (!arrayList.isEmpty()) {
                    for (int i11 = 0; i11 < arrayList.size(); i11++) {
                        try {
                            AdsDTO adsDTO = (AdsDTO) arrayList.get(i11);
                            if (w9.c.e(adsDTO, true)) {
                                b1.c().o(adsDTO);
                                break;
                            }
                        } catch (Exception e11) {
                            z.a().e("OfflineAdManager", "deleteOldOfflineAd error " + Log.getStackTraceString(e11));
                        }
                    }
                }
            }
            if (z0.this.f30231b != null) {
                z0.this.f30231b.remove(z0.this.f30232c);
                if (!z0.this.f30231b.isEmpty()) {
                    z0.this.f();
                    return;
                }
                z0.this.f30231b = null;
                z0.this.f30232c = null;
                z0.this.r();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements AdServerRequest.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdxImpBean f30236a;

        public b(AdxImpBean adxImpBean) {
            this.f30236a = adxImpBean;
        }

        @Override // com.cloud.hisavana.sdk.common.http.AdServerRequest.b
        public String a() {
            return m0.c(this.f30236a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends CommonResponseListener<AdResponseBody> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConfigCodeSeatDTO f30238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AdxImpBean f30239c;

        public c(ConfigCodeSeatDTO configCodeSeatDTO, AdxImpBean adxImpBean) {
            this.f30238b = configCodeSeatDTO;
            this.f30239c = adxImpBean;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            z0.this.j(this.f30238b, true);
            if (taErrorCode != null) {
                z.a().d("OfflineAdManager", "load ad error adError=" + taErrorCode.getErrorMessage());
            }
            z0.this.f30234e.a(this.f30239c, null, taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void g(int i11, AdResponseBody adResponseBody) {
            String str;
            TaErrorCode taErrorCode;
            com.cloud.hisavana.sdk.e.c cVar;
            AdxImpBean adxImpBean;
            TaErrorCode taErrorCode2;
            AdxImpBean adxImpBean2;
            z zVarA;
            String str2;
            com.cloud.hisavana.sdk.e.c cVar2;
            AdxImpBean adxImpBean3;
            TaErrorCode taErrorCode3;
            com.cloud.hisavana.sdk.common.http.c.a(adResponseBody);
            z0.this.j(this.f30238b, false);
            if (adResponseBody == null || adResponseBody.getCode().intValue() != 0) {
                z zVarA2 = z.a();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("业务错误 --> ");
                if (adResponseBody != null) {
                    str = "error,response code is :" + adResponseBody.getCode() + ",response msg is " + adResponseBody.getMessage() + " ******";
                } else {
                    str = " error, response is null";
                }
                sb2.append(str);
                zVarA2.d("OfflineAdManager", sb2.toString());
                z zVarA3 = z.a();
                if (adResponseBody != null) {
                    zVarA3.d("OfflineAdManager", "loadAd() - error,response code is :" + adResponseBody.getCode() + ",response msg is " + adResponseBody.getMessage());
                    taErrorCode = new TaErrorCode(adResponseBody.getCode().intValue(), adResponseBody.getMessage());
                } else {
                    zVarA3.d("OfflineAdManager", "loadAd() - load ad error,null == response");
                    taErrorCode = new TaErrorCode(-1, "response is null");
                }
                z0.this.f30234e.a(this.f30239c, null, taErrorCode);
                return;
            }
            if (adResponseBody.getData() != null && adResponseBody.getData().getAds() != null && adResponseBody.getData().getAds().size() > 0 && adResponseBody.getData().getOfflineAd().booleanValue()) {
                List<AdsDTO> ads = adResponseBody.getData().getAds();
                List<String> scales = adResponseBody.getData().getScales();
                if (!TextUtils.equals(adResponseBody.getData().getCodeSeatId(), this.f30238b.getCodeSeatId())) {
                    z.a().d("OfflineAdManager", "response pmid is diffrent with request's");
                    cVar2 = z0.this.f30234e;
                    adxImpBean3 = this.f30239c;
                    taErrorCode3 = TaErrorCode.ERROR_PLACEMENT_ID_MISMATCH;
                } else if (this.f30238b.getCodeSeatType().equals(adResponseBody.getData().getCodeSeatType())) {
                    q3.f30006a.a(adResponseBody.getData().getAbTest());
                    Iterator<AdsDTO> it = ads.iterator();
                    String adSeatType = adResponseBody.getData().getAdSeatType();
                    boolean zBooleanValue = adResponseBody.getData().getTestResponse().booleanValue();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int adRequestVer = this.f30238b.getAdRequestVer() + 1;
                    this.f30238b.setAdRequestVer(adRequestVer);
                    x.h().j(this.f30238b);
                    while (it.hasNext()) {
                        AdsDTO next = it.next();
                        if (next == null || !next.isOfflineAd()) {
                            zVarA = z.a();
                            str2 = "ad is null or ad is not offline,remove from list";
                            zVarA.d("OfflineAdManager", str2);
                            it.remove();
                        } else {
                            int iA = w9.s.a(next.getPullNewestLive().intValue(), next.getPsPackageName(), next.getPackageName());
                            if (iA == 1 || iA == 2) {
                                arrayList.add(next.getAdCreativeId());
                                arrayList2.add(Integer.valueOf(iA == 1 ? 1 : 2));
                                it.remove();
                            } else if (next.getCodeSeatType().intValue() == 1 && (next.getNativeObject() == null || next.getNativeObject().getMainImages() == null || next.getNativeObject().getMainImages().size() == 0 || TextUtils.isEmpty(next.getNativeObject().getMainImages().get(0).getUrl()))) {
                                zVarA = z.a();
                                str2 = "Native ad's image is empty,remove from list";
                                zVarA.d("OfflineAdManager", str2);
                                it.remove();
                            } else {
                                if (!TextUtils.isEmpty(next.getOfflineH5Url())) {
                                    next.setFilePath(w9.q.c(next.getOfflineH5Url()));
                                }
                                next.setFill_ts(Long.valueOf(System.currentTimeMillis()));
                                next.setAbTest(adResponseBody.getData().getAbTest());
                                next.setExtInfo(adResponseBody.getData().getExtInfo());
                                next.setImpBeanRequest(this.f30239c);
                                next.setTestResponse(Boolean.valueOf(zBooleanValue));
                                next.setAdSeatType(adSeatType);
                                next.setAdRequestVer(adRequestVer);
                                next.setUuid(w9.a.f79345a.e(next, 0));
                                next.setPslinkInfo(e1.v(next));
                                next.setScales(scales);
                            }
                        }
                    }
                    if (!arrayList.isEmpty() && (adxImpBean2 = this.f30239c) != null) {
                        AthenaTracker.y(adxImpBean2.requestId, adxImpBean2.triggerId, adxImpBean2.pmid, arrayList, arrayList2, true, 2);
                    }
                    if (ads.size() > 0) {
                        AthenaTracker.i0(ads, null, this.f30239c, ads.size());
                        z.a().d("OfflineAdManager", "download ad before" + ads.size());
                        this.f30238b.setLocalOfflineAdCacheCount(ads.size());
                        b1.c().m(ads);
                        com.cloud.sdk.commonutil.util.i iVar = com.cloud.sdk.commonutil.util.i.f30292a;
                        final ConfigCodeSeatDTO configCodeSeatDTO = this.f30238b;
                        iVar.b(new Runnable() { // from class: com.cloud.hisavana.sdk.v3
                            @Override // java.lang.Runnable
                            public final void run() throws Throwable {
                                this.f30180a.m(configCodeSeatDTO);
                            }
                        });
                        return;
                    }
                    cVar = z0.this.f30234e;
                    adxImpBean = this.f30239c;
                    taErrorCode2 = TaErrorCode.ERROR_ADS_ARE_FILTERED;
                } else {
                    z.a().d("OfflineAdManager", "response adt is diffrent with request's");
                    cVar2 = z0.this.f30234e;
                    adxImpBean3 = this.f30239c;
                    taErrorCode3 = TaErrorCode.ERROR_AD_TYPE_MISMATCH;
                }
                cVar2.a(adxImpBean3, ads, taErrorCode3);
                return;
            }
            z.a().d("OfflineAdManager", "ads list is empty");
            cVar = z0.this.f30234e;
            adxImpBean = this.f30239c;
            taErrorCode2 = TaErrorCode.ERROR_AD_DATA_IS_NULL;
            cVar.a(adxImpBean, null, taErrorCode2);
        }

        public final /* synthetic */ void m(final ConfigCodeSeatDTO configCodeSeatDTO) throws Throwable {
            final List<AdsDTO> listE = b1.c().e(configCodeSeatDTO.getCodeSeatId(), true, null, true);
            com.cloud.sdk.commonutil.util.i.f30292a.e(new Runnable() { // from class: com.cloud.hisavana.sdk.w3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30187a.n(listE, configCodeSeatDTO);
                }
            });
        }

        public final /* synthetic */ void n(List list, ConfigCodeSeatDTO configCodeSeatDTO) {
            z0.this.p(list, configCodeSeatDTO);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] list;
            z.a().d("OfflineAdManager", "clearZipFile，ad download logic is done.");
            String str = w9.f.b(com.cloud.sdk.commonutil.util.f.a()) + File.separator + "offline_zip";
            File file = new File(str);
            try {
                if (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0) {
                    for (String str2 : list) {
                        if (!b1.c().q(str2)) {
                            if (AdManager.h()) {
                                z.a().d("OfflineAdManager", "clearZipFile，delete file:" + str2);
                            }
                            File file2 = new File(str + File.separator + str2);
                            if (file2.exists()) {
                                if (file2.isDirectory()) {
                                    w9.f.a(file2);
                                } else {
                                    file2.delete();
                                }
                            }
                        }
                    }
                }
            } catch (Exception e11) {
                z.a().e("OfflineAdManager", Log.getStackTraceString(e11));
            }
            z0.this.f30230a.set(false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z0 f30242a = new z0(null);
    }

    public z0() {
        this.f30230a = new AtomicBoolean(false);
        this.f30234e = new a();
    }

    public /* synthetic */ z0(a aVar) {
        this();
    }

    public static z0 t() {
        return e.f30242a;
    }

    public final void f() {
        List<ConfigCodeSeatDTO> list = this.f30231b;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<ConfigCodeSeatDTO> it = this.f30231b.iterator();
        while (it.hasNext()) {
            ConfigCodeSeatDTO next = it.next();
            if (next != null) {
                if (next.isPriorityH5Ad().booleanValue() && w9.a0.f(next.getH5AdUrl())) {
                    d0.f29612a.e(next.getH5AdUrl());
                }
                m(next.getCodeSeatId());
                if (next.isOfflineAdEnable()) {
                    g(next);
                    break;
                } else {
                    it.remove();
                    n(next.getCodeSeatId(), 3);
                }
            } else {
                it.remove();
            }
        }
        List<ConfigCodeSeatDTO> list2 = this.f30231b;
        if (list2 == null || !list2.isEmpty()) {
            return;
        }
        this.f30234e.a(null);
    }

    public final void g(final ConfigCodeSeatDTO configCodeSeatDTO) {
        if (configCodeSeatDTO == null) {
            z.a().d("OfflineAdManager", "judgeRequestAd codeSeat is null");
            this.f30234e.a(null);
        } else {
            this.f30232c = configCodeSeatDTO;
            com.cloud.sdk.commonutil.util.i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.t3
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f30124a.s(configCodeSeatDTO);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    public final void h(ConfigCodeSeatDTO configCodeSeatDTO, int i11, String str) {
        int i12;
        AdServerRequest adServerRequestK;
        if (configCodeSeatDTO == null) {
            this.f30234e.a(null);
            return;
        }
        z.a().d("OfflineAdManager", "requestAds config id " + configCodeSeatDTO.getCodeSeatId());
        AdxImpBean adxImpBean = new AdxImpBean();
        adxImpBean.adt = configCodeSeatDTO.getCodeSeatType().intValue();
        adxImpBean.pmid = configCodeSeatDTO.getCodeSeatId();
        adxImpBean.mAdCount = configCodeSeatDTO.getOfflineAdCacheCount().intValue();
        adxImpBean.requestId = str;
        if (i11 == 1) {
            i12 = 5;
        } else {
            if (i11 != 2) {
                if (i11 == 3) {
                    i12 = 7;
                }
                adxImpBean.offlineAd = true;
                adxImpBean.triggerId = w9.z.b();
                adxImpBean.offlineAdEnable = configCodeSeatDTO.isOfflineAdEnable();
                adxImpBean.cacheAdCount = configCodeSeatDTO.getLocalOfflineAdCacheCount();
                adServerRequestK = new AdServerRequest().n(new c(configCodeSeatDTO, adxImpBean)).p(new b(adxImpBean)).l(AdManager.h()).r(v.p().s()).o(adxImpBean.pmid).m(true).k(adxImpBean);
                if (adServerRequestK != null) {
                    adServerRequestK.c();
                }
            }
            i12 = 6;
        }
        adxImpBean.requestType = i12;
        adxImpBean.offlineAd = true;
        adxImpBean.triggerId = w9.z.b();
        adxImpBean.offlineAdEnable = configCodeSeatDTO.isOfflineAdEnable();
        adxImpBean.cacheAdCount = configCodeSeatDTO.getLocalOfflineAdCacheCount();
        adServerRequestK = new AdServerRequest().n(new c(configCodeSeatDTO, adxImpBean)).p(new b(adxImpBean)).l(AdManager.h()).r(v.p().s()).o(adxImpBean.pmid).m(true).k(adxImpBean);
        if (adServerRequestK != null) {
            adServerRequestK.c();
        }
    }

    public final /* synthetic */ void i(ConfigCodeSeatDTO configCodeSeatDTO, List list) {
        if (!configCodeSeatDTO.getLastOfflineAdEnable().booleanValue()) {
            p(list, configCodeSeatDTO);
            n(configCodeSeatDTO.getCodeSeatId(), 4);
            return;
        }
        if (this.f30233d == 3) {
            p(list, configCodeSeatDTO);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jIntValue = (configCodeSeatDTO.isAdRequestFail() ? configCodeSeatDTO.getOfflineAdRequestTimeInterval() : configCodeSeatDTO.getOfflineAdRequestTimeIntervalNoAd()).intValue();
        if (jIntValue <= 0) {
            jIntValue = 60;
        }
        if (list != null && list.size() > 0) {
            p(list, configCodeSeatDTO);
            n(configCodeSeatDTO.getCodeSeatId(), 5);
        } else if (jCurrentTimeMillis - configCodeSeatDTO.getLastRequestAdTime() <= jIntValue * 1000) {
            p(list, configCodeSeatDTO);
            n(configCodeSeatDTO.getCodeSeatId(), 6);
        } else {
            String strN = DeviceUtil.n();
            n(configCodeSeatDTO.getCodeSeatId(), 1);
            h(this.f30232c, this.f30233d, strN);
        }
    }

    public final void j(ConfigCodeSeatDTO configCodeSeatDTO, boolean z11) {
        if (configCodeSeatDTO == null) {
            return;
        }
        configCodeSeatDTO.setLastRequestAdTime(System.currentTimeMillis());
        configCodeSeatDTO.setAdRequestFail(z11);
        x.h().j(configCodeSeatDTO);
    }

    public final void m(String str) {
        int i11 = this.f30233d;
        if (i11 == 3) {
            return;
        }
        AthenaTracker.k0(str, i11);
    }

    public final void n(String str, int i11) {
        int i12 = this.f30233d;
        if (i12 == 3) {
            return;
        }
        AthenaTracker.Z(str, i12, i11);
    }

    public void o(Collection<ConfigCodeSeatDTO> collection, int i11) {
        z.a().d("OfflineAdManager", "startDownloadAd triggerType " + i11 + ",isDownloading " + this.f30230a);
        if (collection == null || collection.isEmpty() || this.f30230a.get()) {
            z.a().d("OfflineAdManager", "startDownloadAd fail,configList is empty or it is downloading");
            return;
        }
        this.f30231b = new ArrayList(collection);
        this.f30230a.set(true);
        this.f30233d = i11;
        f();
    }

    public final void p(List<AdsDTO> list, ConfigCodeSeatDTO configCodeSeatDTO) {
        if (list == null || list.isEmpty() || configCodeSeatDTO == null) {
            this.f30234e.a(null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (AdsDTO adsDTO : list) {
            if (!w9.c.e(adsDTO, true)) {
                arrayList.add(adsDTO);
            }
        }
        if (arrayList.isEmpty()) {
            this.f30234e.a(list);
            return;
        }
        z.a().d("OfflineAdManager", "current code seat is " + configCodeSeatDTO.getCodeSeatId());
        com.cloud.hisavana.sdk.e.a().i(arrayList, this.f30234e);
    }

    public final void r() {
        com.cloud.sdk.commonutil.util.i.f30292a.e(new d());
    }

    public final /* synthetic */ void s(final ConfigCodeSeatDTO configCodeSeatDTO) throws Throwable {
        final List<AdsDTO> listE = b1.c().e(configCodeSeatDTO.getCodeSeatId(), true, null, true);
        com.cloud.sdk.commonutil.util.i.f30292a.e(new Runnable() { // from class: com.cloud.hisavana.sdk.u3
            @Override // java.lang.Runnable
            public final void run() {
                this.f30148a.i(configCodeSeatDTO, listE);
            }
        });
    }
}
