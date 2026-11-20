package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdsDTO f29621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicInteger f29622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l0 f29623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f29624d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f29625e;

    /* JADX INFO: compiled from: source.java */
    public class a implements w9.c0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29626a;

        public a(AdsDTO adsDTO) {
            this.f29626a = adsDTO;
        }

        @Override // w9.c0.b
        public void a(@NonNull TaErrorCode taErrorCode) {
            d1.this.d(this.f29626a, false);
            d1.this.b(taErrorCode);
        }

        @Override // w9.c0.b
        public void onSuccess() {
            d1.this.d(this.f29626a, true);
            d1.this.m();
            e1.D(this.f29626a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29628b;

        public b(AdsDTO adsDTO) {
            this.f29628b = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            z.a().e("SplashLoadManager", "load store url error," + taErrorCode);
            d1.this.b(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            d1.this.c(this.f29628b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29630b;

        /* JADX INFO: compiled from: source.java */
        public class a implements w9.g {
            public a() {
            }

            @Override // w9.g
            public void a(boolean z11) {
                if (!z11) {
                    d1.this.b(TaErrorCode.ERROR_ZIP_MATERIAL_DECOMPRESS_FAILED);
                } else {
                    c cVar = c.this;
                    d1.this.c(cVar.f29630b);
                }
            }
        }

        public c(AdsDTO adsDTO) {
            this.f29630b = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            AthenaTracker.U(d1.this.f29621a, 1);
            d1.this.b(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            AthenaTracker.U(d1.this.f29621a, 0);
            if (!this.f29630b.isInteractiveAd()) {
                d1.this.c(this.f29630b);
            } else if (adImage != null) {
                w9.p.f79382a.h(this.f29630b, adImage.getFilePath(), new a());
            } else {
                d1.this.b(TaErrorCode.ERROR_ZIP_MATERIAL_TAKE_FAILED);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends DrawableResponseListener {
        public d() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            z.a().e("SplashLoadManager", "load store url error," + taErrorCode);
            d1.this.b(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            d1 d1Var = d1.this;
            d1Var.c(d1Var.f29621a);
        }
    }

    public d1(AdsDTO adsDTO, int i11, l0 l0Var) {
        this.f29621a = adsDTO;
        this.f29625e = i11;
        this.f29623c = l0Var;
    }

    public void a() {
        AdsDTO adsDTO = this.f29621a;
        if (adsDTO == null) {
            b(TaErrorCode.ERROR_AD_DATA_IS_NULL);
            return;
        }
        if (this.f29624d) {
            return;
        }
        this.f29624d = true;
        int i11 = this.f29625e;
        if (i11 == 3 || i11 == 2) {
            m();
            return;
        }
        if (adsDTO.isVastTypeAd()) {
            l();
        } else if (TextUtils.isEmpty(this.f29621a.getAdm())) {
            k();
        } else {
            j();
        }
    }

    public final void b(TaErrorCode taErrorCode) {
        this.f29624d = false;
        l0 l0Var = this.f29623c;
        if (l0Var != null) {
            l0Var.a(taErrorCode);
        }
    }

    public final void c(AdsDTO adsDTO) {
        z zVarA = z.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("calculateDownloadCount imageCounter ");
        AtomicInteger atomicInteger = this.f29622b;
        sb2.append(atomicInteger == null ? "null" : Integer.valueOf(atomicInteger.get()));
        zVarA.d("SplashLoadManager", sb2.toString());
        AtomicInteger atomicInteger2 = this.f29622b;
        if (atomicInteger2 == null || atomicInteger2.decrementAndGet() > 0) {
            return;
        }
        m();
        e1.D(adsDTO);
    }

    public final void d(AdsDTO adsDTO, boolean z11) {
        VastData videoInfo = adsDTO.getVideoInfo();
        if (videoInfo != null) {
            videoInfo.setCached(Boolean.valueOf(z11));
        }
    }

    public final void j() {
        AdsDTO adsDTO;
        z.a().d("SplashLoadManager", "interstitial loadAdmAd");
        if (!NetStateManager.checkNetworkState() || (adsDTO = this.f29621a) == null || TextUtils.isEmpty(adsDTO.getAdm())) {
            return;
        }
        if (this.f29621a.getExt() == null || this.f29621a.getExt().getStoreFlag().intValue() <= 0) {
            m();
            return;
        }
        AdsProtocolBean.Ext ext = this.f29621a.getExt();
        if (ext == null || ext.getStoreFlag().intValue() <= 0) {
            return;
        }
        this.f29622b = new AtomicInteger(1);
        if (TextUtils.isEmpty(ext.getStoreImageurl())) {
            b(TaErrorCode.ERROR_STORE_MATERIAL_TAKE_FAILED);
        } else {
            DownLoadRequest.l(ext.getStoreImageurl(), this.f29621a, 6, false, new d());
        }
    }

    public final void k() {
        AdsProtocolBean.Ext ext;
        z.a().d("SplashLoadManager", "interstitial loadNormalAd");
        AdsDTO adsDTO = this.f29621a;
        if (adsDTO == null) {
            return;
        }
        if (TextUtils.isEmpty(adsDTO.getAdImgUrl())) {
            b(TaErrorCode.ERROR_AD_MATERIAL_TAKE_FAILED);
            return;
        }
        this.f29622b = new AtomicInteger(1);
        if (adsDTO.getExt() != null && adsDTO.getExt().getStoreFlag().intValue() > 0 && (ext = adsDTO.getExt()) != null && ext.getStoreFlag().intValue() > 0) {
            this.f29622b.addAndGet(1);
            if (TextUtils.isEmpty(ext.getStoreImageurl())) {
                b(TaErrorCode.ERROR_STORE_MATERIAL_TAKE_FAILED);
                return;
            }
            DownLoadRequest.l(ext.getStoreImageurl(), this.f29621a, 6, false, new b(adsDTO));
        }
        DownLoadRequest.l(adsDTO.getAdImgUrl(), adsDTO, adsDTO.isInteractiveAd() ? 8 : 2, adsDTO.isInteractiveAd(), new c(adsDTO));
    }

    public final void l() {
        z.a().d("SplashLoadManager", "interstitial loadVastAd");
        AdsDTO adsDTO = this.f29621a;
        if (adsDTO == null) {
            b(TaErrorCode.ERROR_AD_DATA_IS_NULL);
        } else {
            w9.c0.f79347a.c(new a(adsDTO), adsDTO);
        }
    }

    public final void m() {
        AdsDTO adsDTO;
        this.f29624d = false;
        l0 l0Var = this.f29623c;
        if (l0Var != null && (adsDTO = this.f29621a) != null) {
            l0Var.b(adsDTO);
        }
        if (this.f29625e == 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f29621a);
            b1.c().p(arrayList);
        }
    }

    public void n() {
        this.f29623c = null;
    }
}
