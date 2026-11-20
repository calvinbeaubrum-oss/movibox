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
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdsDTO f29976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicInteger f29977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l0 f29978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f29979d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f29980e;

    /* JADX INFO: compiled from: source.java */
    public class a extends DrawableResponseListener {
        public a() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            p1.this.b(TaErrorCode.ERROR_STORE_MATERIAL_TAKE_FAILED);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            p1.this.a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29982b;

        /* JADX INFO: compiled from: source.java */
        public class a implements w9.g {
            public a() {
            }

            @Override // w9.g
            public void a(boolean z11) {
                if (z11) {
                    p1.this.a();
                } else {
                    p1.this.b(new TaErrorCode(1, ""));
                }
            }
        }

        public b(AdsDTO adsDTO) {
            this.f29982b = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            z.a().d("SplashLoadManager", "onRequestError " + taErrorCode.getErrorMessage());
            if (this.f29982b.isInteractiveAd()) {
                AthenaTracker.U(this.f29982b, 1);
            }
            p1.this.b(taErrorCode);
            r0.e().a();
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (adImage != null) {
                if (!this.f29982b.isInteractiveAd()) {
                    p1.this.a();
                } else {
                    AthenaTracker.U(this.f29982b, 0);
                    w9.p.f79382a.h(this.f29982b, adImage.getFilePath(), new a());
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements w9.c0.b {
        public c() {
        }

        @Override // w9.c0.b
        public void a(@NonNull TaErrorCode taErrorCode) {
            VastData videoInfo;
            if (p1.this.f29976a != null && (videoInfo = p1.this.f29976a.getVideoInfo()) != null) {
                videoInfo.setCached(Boolean.FALSE);
            }
            p1.this.b(taErrorCode);
        }

        @Override // w9.c0.b
        public void onSuccess() {
            VastData videoInfo;
            z.a().d("SplashLoadManager", "loadVideo() -----> onSuccess");
            if (p1.this.f29976a != null && (videoInfo = p1.this.f29976a.getVideoInfo()) != null) {
                videoInfo.setCached(Boolean.TRUE);
            }
            p1.this.a();
        }
    }

    public p1(AdsDTO adsDTO, int i11, l0 l0Var) {
        this.f29976a = adsDTO;
        this.f29980e = i11;
        this.f29978c = l0Var;
    }

    public final void a() {
        z zVarA = z.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("calculateDownloadCount imageCounter ");
        AtomicInteger atomicInteger = this.f29977b;
        sb2.append(atomicInteger == null ? "null" : Integer.valueOf(atomicInteger.get()));
        zVarA.d("SplashLoadManager", sb2.toString());
        AtomicInteger atomicInteger2 = this.f29977b;
        if (atomicInteger2 == null || atomicInteger2.decrementAndGet() > 0) {
            return;
        }
        h();
    }

    public final void b(TaErrorCode taErrorCode) {
        this.f29979d = false;
        l0 l0Var = this.f29978c;
        if (l0Var != null) {
            this.f29979d = false;
            l0Var.a(taErrorCode);
        }
    }

    public final void c(AdsDTO adsDTO, String str) {
        if (adsDTO == null || TextUtils.isEmpty(str)) {
            return;
        }
        b bVar = new b(adsDTO);
        if (adsDTO.isVastTypeAd()) {
            j();
        } else {
            DownLoadRequest.l(str, adsDTO, adsDTO.isInteractiveAd() ? 8 : 2, adsDTO.isInteractiveAd(), bVar);
        }
    }

    public final boolean f(AdsDTO adsDTO) {
        AdsProtocolBean.Ext ext;
        if (adsDTO == null || (ext = adsDTO.getExt()) == null || ext.getStoreFlag().intValue() <= 0) {
            return false;
        }
        if (TextUtils.isEmpty(ext.getStoreImageurl())) {
            b(TaErrorCode.ERROR_STORE_MATERIAL_TAKE_FAILED);
            return true;
        }
        DownLoadRequest.l(ext.getStoreImageurl(), adsDTO, 6, false, new a());
        return true;
    }

    public final void h() {
        AdsDTO adsDTO;
        this.f29979d = false;
        l0 l0Var = this.f29978c;
        if (l0Var != null && (adsDTO = this.f29976a) != null) {
            this.f29979d = false;
            l0Var.b(adsDTO);
        }
        if (this.f29980e == 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f29976a);
            b1.c().p(arrayList);
        }
    }

    public void i() {
        AdsDTO adsDTO = this.f29976a;
        if (adsDTO == null) {
            b(TaErrorCode.ERROR_AD_DATA_IS_NULL);
            return;
        }
        if (this.f29979d) {
            return;
        }
        this.f29979d = true;
        int i11 = this.f29980e;
        if (i11 == 3 || i11 == 2) {
            h();
            return;
        }
        String strA = w9.a.f79345a.a(adsDTO);
        this.f29977b = new AtomicInteger(2);
        if (!f(this.f29976a)) {
            this.f29977b.decrementAndGet();
        }
        c(this.f29976a, strA);
    }

    public final void j() {
        z.a().d("SplashLoadManager", "loadVideo");
        w9.c0.f79347a.c(new c(), this.f29976a);
    }

    public void k() {
        this.f29978c = null;
    }
}
