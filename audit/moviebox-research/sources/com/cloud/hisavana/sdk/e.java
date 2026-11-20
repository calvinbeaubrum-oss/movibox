package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.ImgListDTO;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f29648a;

    /* JADX INFO: compiled from: source.java */
    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f29649a;

        public a(List list) {
            this.f29649a = list;
        }

        @Override // com.cloud.hisavana.sdk.e.d
        public void a() {
            e.this.h(this.f29649a);
            e.this.l(this.f29649a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f29651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f29652c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f29653d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ n0 f29654e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ d f29655f;

        public b(String str, boolean z11, AtomicInteger atomicInteger, n0 n0Var, d dVar) {
            this.f29651b = str;
            this.f29652c = z11;
            this.f29653d = atomicInteger;
            this.f29654e = n0Var;
            this.f29655f = dVar;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            z.a().d("OfflineDownload", "下载失败 == " + this.f29651b);
            e.this.j(this.f29653d, this.f29654e, this.f29655f);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            z.a().d("OfflineDownload", "下载成功 == " + this.f29651b);
            if (this.f29652c && adImage != null) {
                e.this.g(adImage.getFilePath(), this.f29651b);
            }
            e.this.j(this.f29653d, this.f29654e, this.f29655f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(AdxImpBean adxImpBean, List<AdsDTO> list, TaErrorCode taErrorCode);

        void a(List<AdsDTO> list);
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a();
    }

    /* JADX INFO: renamed from: com.cloud.hisavana.sdk.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0328e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f29657a = new e();
    }

    public static e a() {
        return C0328e.f29657a;
    }

    public final void e(AdsDTO adsDTO, String str, int i11, boolean z11, n0 n0Var, AtomicInteger atomicInteger, d dVar) {
        if (TextUtils.isEmpty(str)) {
            j(atomicInteger, n0Var, dVar);
        } else {
            DownLoadRequest.l(str, adsDTO, i11, z11, new b(str, z11, atomicInteger, n0Var, dVar));
        }
    }

    public final void f(n0 n0Var, d dVar) {
        String logoUrl;
        int i11;
        if (n0Var == null) {
            dVar.a();
            return;
        }
        AdsDTO adsDTOA = n0Var.a();
        if (adsDTOA != null) {
            String adImgUrl = adsDTOA.getAdImgUrl();
            if (adsDTOA.getImpBeanRequest() != null && adsDTOA.getImpBeanRequest().adt == 2 && (TextUtils.equals(adsDTOA.getMaterialStyle(), "B20301") || TextUtils.equals(adsDTOA.getMaterialStyle(), "B20302") || TextUtils.equals(adsDTOA.getMaterialStyle(), "B20303"))) {
                logoUrl = adsDTOA.getLogoUrl();
                i11 = 1;
            } else {
                logoUrl = adImgUrl;
                i11 = 2;
            }
            if (!TextUtils.isEmpty(logoUrl) || adsDTOA.getCodeSeatType().intValue() == 6) {
                AtomicInteger atomicInteger = new AtomicInteger(3);
                if (adsDTOA.getPslinkInfoStatus()) {
                    String iconUrl = adsDTOA.getPslinkInfo().getIconUrl();
                    List<ImgListDTO> imgList = adsDTOA.getPslinkInfo().getImgList();
                    if (!TextUtils.isEmpty(iconUrl)) {
                        atomicInteger.set(atomicInteger.get() + 1 + imgList.size());
                        z.a().d("OfflineDownload", "开始下载Pslink Half素材 ==" + iconUrl + " ,psImgUrl.size() == " + imgList.size());
                        e(adsDTOA, iconUrl, 4, false, n0Var, atomicInteger, dVar);
                        for (ImgListDTO imgListDTO : imgList) {
                            if (imgListDTO != null && !TextUtils.isEmpty(imgListDTO.getUrl())) {
                                e(adsDTOA, imgListDTO.getUrl(), 4, false, n0Var, atomicInteger, dVar);
                            }
                        }
                    }
                }
                AdsProtocolBean.Ext ext = adsDTOA.getExt();
                if (ext == null || ext.getStoreFlag().intValue() <= 0 || TextUtils.isEmpty(ext.getStoreImageurl())) {
                    j(atomicInteger, n0Var, dVar);
                } else {
                    e(adsDTOA, ext.getStoreImageurl(), 6, false, n0Var, atomicInteger, dVar);
                }
                e(adsDTOA, logoUrl, i11, false, n0Var, atomicInteger, dVar);
                String offlineH5Url = adsDTOA.getOfflineH5Url();
                if (TextUtils.isEmpty(offlineH5Url)) {
                    j(atomicInteger, n0Var, dVar);
                    return;
                } else {
                    e(adsDTOA, offlineH5Url, 5, adsDTOA.isH5Zip(), n0Var, atomicInteger, dVar);
                    return;
                }
            }
        }
        f(n0Var.c(), dVar);
    }

    public final void g(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(w9.f.b(com.cloud.sdk.commonutil.util.f.a()));
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append("offline_zip");
        sb2.append(str3);
        sb2.append(w9.q.c(str2));
        String string = sb2.toString();
        if (new File(string).exists()) {
            return;
        }
        w9.e0.b(str, string);
    }

    public final void h(List<AdsDTO> list) {
        for (AdsDTO adsDTO : list) {
            if (adsDTO != null) {
                if (!DownLoadRequest.f29427p && adsDTO.getAdChoiceImageUrl() != null) {
                    DownLoadRequest.l(adsDTO.getAdChoiceImageUrl(), adsDTO, 3, false, null);
                }
                String logoUrl = adsDTO.getLogoUrl();
                if (adsDTO.getImpBeanRequest() != null && adsDTO.getImpBeanRequest().adt == 2 && (TextUtils.equals(adsDTO.getMaterialStyle(), "B20301") || TextUtils.equals(adsDTO.getMaterialStyle(), "B20302") || TextUtils.equals(adsDTO.getMaterialStyle(), "B20303"))) {
                    return;
                } else {
                    DownLoadRequest.l(logoUrl, adsDTO, 1, false, null);
                }
            }
        }
    }

    public void i(List<AdsDTO> list, c cVar) {
        this.f29648a = cVar;
        if (list == null || list.isEmpty()) {
            z.a().d("OfflineDownload", "广告list为空");
            l(null);
            return;
        }
        n0 n0Var = null;
        n0 n0Var2 = null;
        for (AdsDTO adsDTO : list) {
            if (adsDTO != null) {
                n0 n0Var3 = new n0(adsDTO);
                if (n0Var2 == null) {
                    n0Var = n0Var3;
                } else {
                    n0Var2.b(n0Var3);
                }
                n0Var2 = n0Var3;
            }
        }
        if (n0Var != null) {
            f(n0Var, new a(list));
        } else {
            z.a().d("OfflineDownload", "下载失败");
            l(null);
        }
    }

    public final void j(AtomicInteger atomicInteger, n0 n0Var, d dVar) {
        if (atomicInteger != null) {
            atomicInteger.decrementAndGet();
        }
        if (atomicInteger == null || atomicInteger.get() <= 0) {
            f(n0Var == null ? null : n0Var.c(), dVar);
        }
    }

    public final void l(List<AdsDTO> list) {
        c cVar = this.f29648a;
        if (cVar != null) {
            cVar.a(list);
        }
    }
}
