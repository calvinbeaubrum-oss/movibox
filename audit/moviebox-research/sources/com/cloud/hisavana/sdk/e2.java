package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdsDTO f29690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l0 f29691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtomicInteger f29692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f29693d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f29694e;

    /* JADX INFO: compiled from: source.java */
    public class a extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29695b;

        public a(AdsDTO adsDTO) {
            this.f29695b = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            this.f29695b.setACReady(Boolean.FALSE);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            this.f29695b.setACReady(Boolean.TRUE);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29697b;

        public b(AdsDTO adsDTO) {
            this.f29697b = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            z.a().e("BannerDownload", "onRequestError " + taErrorCode);
            e2.this.c(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            e2.this.d(this.f29697b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f29699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29700c;

        /* JADX INFO: compiled from: source.java */
        public class a implements w9.g {
            public a() {
            }

            @Override // w9.g
            public void a(boolean z11) {
                c cVar = c.this;
                e2.this.d(cVar.f29700c);
            }
        }

        public c(int i11, AdsDTO adsDTO) {
            this.f29699b = i11;
            this.f29700c = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            if (this.f29700c.isInteractiveAd()) {
                AthenaTracker.U(e2.this.f29690a, 1);
            }
            e2.this.c(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (this.f29699b == 1 && e2.this.f29690a.getPslinkInfo() != null && !TextUtils.isEmpty(adImage.getFilePath())) {
                e2.this.f29690a.getPslinkInfo().setIconUri(w9.f.d(adImage.getFilePath()));
            }
            if (!this.f29700c.isInteractiveAd()) {
                e2.this.d(this.f29700c);
                return;
            }
            AthenaTracker.U(e2.this.f29690a, 0);
            if (adImage != null) {
                w9.p.f79382a.h(this.f29700c, adImage.getFilePath(), new a());
            } else {
                e2.this.c(TaErrorCode.ERROR_ZIP_MATERIAL_DECOMPRESS_FAILED);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends DrawableResponseListener {
        public d() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            z.a().e("BannerDownload", "onRequestError " + taErrorCode);
            e2.this.c(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            e2 e2Var = e2.this;
            e2Var.d(e2Var.f29690a);
        }
    }

    public e2(AdsDTO adsDTO, int i11, l0 l0Var) {
        this.f29690a = adsDTO;
        this.f29694e = i11;
        this.f29691b = l0Var;
    }

    public final void b() {
        AdsDTO adsDTO = this.f29690a;
        if (adsDTO == null) {
            return;
        }
        if (TextUtils.isEmpty(adsDTO.getAdChoiceImageUrl())) {
            z.a().d("BannerDownload", "Not found adChoiceImageUrl");
        } else {
            z.a().d("ssp", "textView impression");
            DownLoadRequest.l(adsDTO.getAdChoiceImageUrl(), adsDTO, 3, false, new a(adsDTO));
        }
    }

    public final void c(TaErrorCode taErrorCode) {
        if (this.f29693d) {
            return;
        }
        this.f29693d = true;
        l0 l0Var = this.f29691b;
        if (l0Var != null) {
            l0Var.a(taErrorCode);
        }
    }

    public final void d(AdsDTO adsDTO) {
        z zVarA = z.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("calculateDownloadCount imageCounter ");
        AtomicInteger atomicInteger = this.f29692c;
        sb2.append(atomicInteger == null ? "null" : Integer.valueOf(atomicInteger.get()));
        zVarA.d("BannerDownload", sb2.toString());
        AtomicInteger atomicInteger2 = this.f29692c;
        if (atomicInteger2 == null || atomicInteger2.decrementAndGet() > 0) {
            return;
        }
        l0 l0Var = this.f29691b;
        if (l0Var != null) {
            l0Var.b(adsDTO);
        }
        if (this.f29694e == 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(adsDTO);
            b1.c().p(arrayList);
        }
        e1.D(adsDTO);
    }

    public final void g() {
        AdsDTO adsDTO;
        if (!NetStateManager.checkNetworkState() || (adsDTO = this.f29690a) == null || this.f29691b == null) {
            return;
        }
        if (TextUtils.isEmpty(adsDTO.getAdm())) {
            z.a().e("BannerDownload", "getAdmView,adm is null");
            c(TaErrorCode.ERROR_AD_MATERIAL_TAKE_FAILED);
            return;
        }
        List<String> scales = this.f29690a.getScales();
        if (scales == null || scales.isEmpty()) {
            c(TaErrorCode.ERROR_ADM_SCALE_TAKE_FAILED);
            return;
        }
        String str = scales.get(0);
        str.hashCode();
        if (!str.equals("3:2") && !str.equals("20:3")) {
            c(TaErrorCode.ERROR_ADM_SCALE_TAKE_FAILED);
            z.a().e("BannerDownload", "getAdmView adm scale is not fit");
            return;
        }
        if (this.f29690a.getExt() == null || this.f29690a.getExt().getStoreFlag().intValue() <= 0) {
            l0 l0Var = this.f29691b;
            if (l0Var != null) {
                l0Var.b(this.f29690a);
                return;
            }
            return;
        }
        AdsProtocolBean.Ext ext = this.f29690a.getExt();
        this.f29692c = new AtomicInteger(1);
        if (TextUtils.isEmpty(ext.getStoreImageurl())) {
            c(TaErrorCode.ERROR_STORE_MATERIAL_TAKE_FAILED);
        } else {
            DownLoadRequest.l(ext.getStoreImageurl(), this.f29690a, 6, false, new d());
        }
    }

    public void h() {
        this.f29693d = false;
        AdsDTO adsDTO = this.f29690a;
        if (adsDTO != null) {
            int i11 = this.f29694e;
            if (i11 == 3 || i11 == 2) {
                l0 l0Var = this.f29691b;
                if (l0Var != null) {
                    l0Var.b(adsDTO);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(adsDTO.getAdm())) {
                i();
            } else {
                g();
            }
        }
    }

    public final void i() {
        int i11;
        boolean z11;
        AdsDTO adsDTO = this.f29690a;
        if (adsDTO == null) {
            return;
        }
        String adImgUrl = adsDTO.getAdImgUrl();
        if ((TextUtils.equals(adsDTO.getMaterialStyle(), "B20301") || TextUtils.equals(adsDTO.getMaterialStyle(), "B20302") || TextUtils.equals(adsDTO.getMaterialStyle(), "B20303")) && adsDTO.getNativeObject() != null) {
            adImgUrl = adsDTO.getNativeObject().getLogoUrl();
            i11 = 1;
            z11 = true;
        } else {
            i11 = 2;
            z11 = false;
        }
        if (adsDTO.isInteractiveAd()) {
            adImgUrl = adsDTO.getAdImgUrl();
            i11 = 8;
            z11 = true;
        }
        if (TextUtils.isEmpty(adImgUrl)) {
            z.a().d("BannerDownload", "Not found the render type");
            return;
        }
        AdsProtocolBean.Ext ext = adsDTO.getExt();
        if (ext == null || ext.getStoreFlag().intValue() <= 0) {
            this.f29692c = new AtomicInteger(1);
        } else {
            this.f29692c = new AtomicInteger(2);
            if (TextUtils.isEmpty(ext.getStoreImageurl())) {
                c(TaErrorCode.ERROR_STORE_MATERIAL_TAKE_FAILED);
                return;
            }
            DownLoadRequest.l(ext.getStoreImageurl(), adsDTO, 6, false, new b(adsDTO));
        }
        DownLoadRequest.l(adImgUrl, adsDTO, i11, z11, new c(i11, adsDTO));
        if (DownLoadRequest.f29427p) {
            return;
        }
        b();
    }

    public void j() {
        this.f29691b = null;
    }
}
