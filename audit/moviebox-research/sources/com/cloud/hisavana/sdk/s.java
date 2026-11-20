package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastIcon;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.AdServerRequest;
import com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdResponseBody;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.hisavana.sdk.data.bean.response.DataDTO;
import com.cloud.hisavana.sdk.data.bean.response.NativeBean;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdServerRequest f30013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f30014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f30015d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f30012a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<AdsDTO> f30016e = null;

    /* JADX INFO: compiled from: source.java */
    public class a implements AdServerRequest.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdxImpBean f30017a;

        public a(AdxImpBean adxImpBean) {
            this.f30017a = adxImpBean;
        }

        @Override // com.cloud.hisavana.sdk.common.http.AdServerRequest.b
        public String a() {
            return m0.c(this.f30017a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends CommonResponseListener<AdResponseBody> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdxImpBean f30019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ConfigCodeSeatDTO f30020c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z11, AdxImpBean adxImpBean, ConfigCodeSeatDTO configCodeSeatDTO) {
            super(z11);
            this.f30019b = adxImpBean;
            this.f30020c = configCodeSeatDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            s.this.j(null, taErrorCode, this.f30019b);
            if (taErrorCode != null) {
                z.a().d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "load ad error adError=" + taErrorCode.getErrorMessage());
            }
        }

        /* JADX WARN: Code duplicated, block: B:69:0x020b  */
        /* JADX WARN: Code duplicated, block: B:70:0x020d  */
        @Override // com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(int i11, AdResponseBody adResponseBody) {
            String str;
            AdxImpBean adxImpBean;
            z zVarA;
            String str2;
            int i12;
            com.cloud.hisavana.sdk.common.http.c.a(adResponseBody);
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
                zVarA2.d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, sb2.toString());
                if (adResponseBody != null) {
                    s.this.j(null, new TaErrorCode(adResponseBody.getCode().intValue(), adResponseBody.getMessage()), this.f30019b);
                    return;
                } else {
                    s.this.j(null, new TaErrorCode(-1, "response is null"), this.f30019b);
                    return;
                }
            }
            if (AdManager.h()) {
                z.a().d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "start load ad... \n -1-> impBean = " + this.f30019b + " \n -2-> got data from net, response is : " + adResponseBody);
            }
            DataDTO data = adResponseBody.getData();
            if (data == null) {
                z.a().d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "response.getData() is null");
                s.this.j(null, TaErrorCode.ERROR_AD_DATA_IS_NULL, this.f30019b);
                return;
            }
            boolean zBooleanValue = data.getTrackingUrlBool().booleanValue();
            List<AdsDTO> ads = data.getAds();
            if (ads == null || ads.isEmpty()) {
                z.a().d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "ads list is empty");
                s.this.j(null, TaErrorCode.ERROR_AD_DATA_IS_NULL, this.f30019b);
                return;
            }
            s.this.f30016e = ads;
            ArrayList arrayList = new ArrayList();
            List<String> scales = data.getScales();
            if (!TextUtils.equals(data.getCodeSeatId(), s.this.f30015d)) {
                z.a().d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "response pmid is diffrent with request's");
                s.this.j(ads, TaErrorCode.ERROR_PLACEMENT_ID_MISMATCH, this.f30019b);
                return;
            }
            if (s.this.f30014c != data.getCodeSeatType().intValue()) {
                z.a().d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "response adt is diffrent with request's");
                s.this.j(ads, TaErrorCode.ERROR_AD_TYPE_MISMATCH, this.f30019b);
                return;
            }
            q3.f30006a.a(data.getAbTest());
            ConfigCodeSeatDTO configCodeSeatDTO = this.f30020c;
            int adRequestVer = configCodeSeatDTO == null ? 0 : configCodeSeatDTO.getAdRequestVer() + 1;
            Iterator<AdsDTO> it = ads.iterator();
            String adSeatType = data.getAdSeatType();
            Integer fullScreenFlag = data.getFullScreenFlag();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            boolean zBooleanValue2 = data.getTestResponse().booleanValue();
            while (it.hasNext()) {
                AdsDTO next = it.next();
                if (next == null) {
                    zVarA = z.a();
                    str2 = "filter:ad is null,remove from list";
                } else {
                    next.setFill_ts(Long.valueOf(System.currentTimeMillis()));
                    if (w9.c.b(next)) {
                        zVarA = z.a();
                        str2 = "filter:CacheAdExpiredUtil.isCacheAdEnd";
                    } else if (w9.c.f(next)) {
                        List<AdsDTO> list = ads;
                        int iA = w9.s.a(next.getPullNewestLive().intValue(), next.getPsPackageName(), next.getPackageName());
                        int i13 = 1;
                        if (iA == 1) {
                            arrayList2.add(next.getAdCreativeId());
                            if (iA == i13) {
                                i12 = 1;
                            } else {
                                i12 = 2;
                            }
                            arrayList3.add(Integer.valueOf(i12));
                            z.a().d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "filter:filterResult == Constants.FilterResult.NEW_BUT_EXIT || filterResult == Constants.FilterResult.PULL_BUT_NOT_EXIT");
                            it.remove();
                        } else if (iA == 2) {
                            i13 = 1;
                            arrayList2.add(next.getAdCreativeId());
                            if (iA == i13) {
                                i12 = 1;
                            } else {
                                i12 = 2;
                            }
                            arrayList3.add(Integer.valueOf(i12));
                            z.a().d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "filter:filterResult == Constants.FilterResult.NEW_BUT_EXIT || filterResult == Constants.FilterResult.PULL_BUT_NOT_EXIT");
                            it.remove();
                        } else {
                            if (s.this.f30014c == 3 || s.this.f30014c == 2 || s.this.f30014c == 4) {
                                next.setInteractiveAd();
                            }
                            next.setTestResponse(Boolean.valueOf(zBooleanValue2));
                            next.setAbTest(data.getAbTest());
                            next.setExtInfo(data.getExtInfo());
                            next.setImpBeanRequest(this.f30019b);
                            next.setAdSeatType(adSeatType);
                            next.setAuctionSecondPrice(next.getSecondPrice());
                            next.setUuid(w9.a.f79345a.e(next, 0));
                            next.setFullScreenFlag(fullScreenFlag);
                            next.setOptimizeTracking(zBooleanValue);
                            next.setAdRequestVer(adRequestVer);
                            if (next.isOfflineAd()) {
                                arrayList.add(next);
                                if (!TextUtils.isEmpty(next.getOfflineH5Url())) {
                                    next.setFilePath(w9.q.c(next.getOfflineH5Url()));
                                }
                            }
                            next.setPslinkInfo(e1.v(next));
                            next.setScales(scales);
                            s.this.h(next, it);
                            next.setSource(1);
                        }
                        ads = list;
                    } else {
                        z.a().d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "filter:CacheAdExpiredUtil.isOfflineAdEfficient is false");
                        it.remove();
                        if (next.isOfflineAd()) {
                            arrayList.add(next);
                            if (!TextUtils.isEmpty(next.getOfflineH5Url())) {
                                next.setFilePath(w9.q.c(next.getOfflineH5Url()));
                            }
                        }
                    }
                }
                zVarA.d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, str2);
                it.remove();
            }
            List<AdsDTO> list2 = ads;
            ConfigCodeSeatDTO configCodeSeatDTO2 = this.f30020c;
            if (configCodeSeatDTO2 != null) {
                configCodeSeatDTO2.setLocalOfflineAdCacheCount(arrayList.size());
                this.f30020c.setAdRequestVer(adRequestVer);
                x.h().j(this.f30020c);
            }
            if (!arrayList2.isEmpty() && (adxImpBean = this.f30019b) != null) {
                AthenaTracker.y(adxImpBean.requestId, adxImpBean.triggerId, s.this.f30015d, arrayList2, arrayList3, false, 1);
            }
            if (list2.isEmpty()) {
                s.this.j(null, TaErrorCode.ERROR_ADS_ARE_FILTERED, this.f30019b);
            } else {
                z.a().d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "AD load success ---->onAdResponse");
                s.this.k(list2, this.f30019b);
                AthenaTracker.i0(list2, null, this.f30019b, arrayList.size());
                if (AdManager.h()) {
                    com.cloud.sdk.commonutil.util.r.b(String.format(com.cloud.sdk.commonutil.util.f.a().getString(R$string.ssp_log_msg4), Integer.valueOf(list2.size())), 2);
                }
            }
            b1.c().m(arrayList);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Preconditions.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f30022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaErrorCode f30023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AdxImpBean f30024c;

        public c(List list, TaErrorCode taErrorCode, AdxImpBean adxImpBean) {
            this.f30022a = list;
            this.f30023b = taErrorCode;
            this.f30024c = adxImpBean;
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            u uVar = s.this.f30012a;
            if (uVar != null) {
                uVar.a(this.f30022a, this.f30023b, this.f30024c);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Preconditions.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f30026a;

        public d(List list) {
            this.f30026a = list;
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            u uVar = s.this.f30012a;
            if (uVar != null) {
                uVar.a(this.f30026a);
            }
        }
    }

    public s(String str) {
        this.f30015d = str;
    }

    public void b() {
        m();
        z.a().d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "adx ad destroy");
    }

    public void f(@NonNull u uVar) {
        this.f30012a = uVar;
    }

    public final void g(AdsDTO adsDTO, VastData vastData) {
        ArrayList<String> arrayList;
        if (adsDTO == null || vastData == null) {
            z.a().e("OnlineAdFetch", "covertVastDataInAd,ads or vast is null");
            return;
        }
        if (adsDTO.getDspType().intValue() == 1) {
            List<String> showTrackingUrls = adsDTO.getShowTrackingUrls();
            if (showTrackingUrls == null) {
                arrayList = showTrackingUrls;
                ArrayList<String> arrayList2 = new ArrayList<>();
                adsDTO.setShowTrackingUrls(arrayList2);
                arrayList = arrayList2;
            }
            arrayList = showTrackingUrls;
            List<String> impression = vastData.getImpression();
            if (impression != null) {
                arrayList.addAll(impression);
            }
            w9.a aVar = w9.a.f79345a;
            List<String> listC = aVar.c(adsDTO, 0);
            List<String> clickTrackingUrls = adsDTO.getClickTrackingUrls();
            if (clickTrackingUrls == null) {
                clickTrackingUrls = new ArrayList<>();
                adsDTO.setClickTrackingUrls(clickTrackingUrls);
            }
            clickTrackingUrls.addAll(listC);
            String strD = aVar.d(adsDTO, 0);
            if (!TextUtils.isEmpty(strD)) {
                if (!strD.startsWith("https") && !strD.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    adsDTO.setDeepLinkUrl(strD);
                } else if (strD.contains("https://play.google.com/store/apps/") || strD.contains("http://play.google.com/store/apps/")) {
                    ArrayList<String> storeDeeplink = adsDTO.getStoreDeeplink();
                    if (storeDeeplink == null) {
                        storeDeeplink = new ArrayList<>();
                        adsDTO.setStoreDeeplink(storeDeeplink);
                    }
                    storeDeeplink.add(strD);
                } else {
                    adsDTO.setClickUrl(strD);
                }
            }
        }
        NativeBean nativeObject = adsDTO.getNativeObject();
        if (nativeObject == null) {
            nativeObject = new NativeBean();
            adsDTO.setNativeObject(nativeObject);
        }
        if (!TextUtils.isEmpty(vastData.getTitle())) {
            nativeObject.setTitle(new NativeBean.TitleDTO(vastData.getTitle()));
        }
        if (!TextUtils.isEmpty(vastData.getButtonTxt())) {
            nativeObject.setButton(new NativeBean.ButtonDTO(vastData.getButtonTxt()));
        }
        if (!TextUtils.isEmpty(vastData.getDescription())) {
            nativeObject.setDescript(new NativeBean.DescriptDTO(vastData.getDescription()));
        }
        VastIcon icon = vastData.getIcon();
        if (icon != null && !TextUtils.isEmpty(icon.getIconResource())) {
            nativeObject.setLogo(new NativeBean.LogoDTO(icon.getIconResource()));
        }
        if (vastData.getMainAd() != null) {
            adsDTO.setMaterialWith(vastData.getMainAd().getWidth());
            adsDTO.setMaterialHeight(vastData.getMainAd().getHeight());
        }
    }

    public final void h(AdsDTO adsDTO, Iterator<AdsDTO> it) {
        String rtbAdm = adsDTO.getRtbAdm();
        if (TextUtils.isEmpty(rtbAdm)) {
            return;
        }
        VastData vastDataM = w9.b0.f79346a.m(rtbAdm, adsDTO);
        if (vastDataM == null) {
            z.a().e("OnlineAdFetch", "vast parse fail");
            it.remove();
            return;
        }
        if (vastDataM.getMainAd() == null) {
            z.a().e("OnlineAdFetch", "mainAd is empty");
            it.remove();
            AthenaTracker.l0(adsDTO, TaErrorCode.NO_MAIN_VIDEO_DATA_ERROR, 3, vastDataM.getVersion());
        } else {
            if (adsDTO.getMaterialType().intValue() == 3) {
                adsDTO.setVastTypeAd(true);
                adsDTO.setVideoInfo(vastDataM);
                g(adsDTO, vastDataM);
                adsDTO.setRtbAdm(null);
                return;
            }
            z.a().e("OnlineAdFetch", "ad is not video type,creativeId " + adsDTO.getAdCreativeId());
            AthenaTracker.l0(adsDTO, TaErrorCode.MATERIAL_TYPE_IS_NOT_VIDEO_ERROR, 3, vastDataM.getVersion());
            it.remove();
        }
    }

    public void i(String str) {
        this.f30015d = str;
    }

    public final void j(List<AdsDTO> list, TaErrorCode taErrorCode, AdxImpBean adxImpBean) {
        Preconditions.d(new c(list, taErrorCode, adxImpBean));
        if (list == null || list.size() <= 0) {
            list = null;
        }
        AthenaTracker.i0(list, taErrorCode, adxImpBean, 0);
    }

    public final void k(List<AdsDTO> list, AdxImpBean adxImpBean) {
        if (list == null) {
            j(null, TaErrorCode.ERROR_AD_DATA_IS_NULL, adxImpBean);
        } else {
            Preconditions.d(new d(list));
        }
    }

    public boolean l(AdxImpBean adxImpBean, ConfigCodeSeatDTO configCodeSeatDTO) {
        m();
        n(adxImpBean, configCodeSeatDTO);
        return true;
    }

    public final void m() {
        if (this.f30013b != null) {
            z.a().d(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "Called AdxBannerView more than once. Auto reset request.");
            this.f30013b.a();
            this.f30013b = null;
        }
    }

    public final void n(AdxImpBean adxImpBean, ConfigCodeSeatDTO configCodeSeatDTO) {
        if (adxImpBean == null) {
            z.a().e("OnlineAdFetch", "loadAdByNet impBean is null");
            return;
        }
        if (configCodeSeatDTO != null) {
            z.a().i("OnlineAdFetch", "current cloud is default cloud ---> " + configCodeSeatDTO.getDefaultConfig());
        }
        this.f30014c = adxImpBean.adt;
        AdServerRequest adServerRequestK = new AdServerRequest().n(new b(true, adxImpBean, configCodeSeatDTO)).p(new a(adxImpBean)).l(AdManager.h()).r(v.p().s()).o(this.f30015d).k(adxImpBean);
        this.f30013b = adServerRequestK;
        if (adServerRequestK != null) {
            adServerRequestK.c();
        }
    }
}
