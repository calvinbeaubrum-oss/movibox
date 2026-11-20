package ba;

import android.view.View;
import com.cloud.hisavana.sdk.b1;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.tranmeasure.e;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.g2;
import com.cloud.hisavana.sdk.o1;
import com.cloud.hisavana.sdk.x;
import com.cloud.hisavana.sdk.z;
import s9.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: ba.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0141a extends com.cloud.hisavana.sdk.common.tranmeasure.a<AdsDTO> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f14080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaNativeInfo f14081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f14082c;

        public C0141a(b bVar, TaNativeInfo taNativeInfo, AdsDTO adsDTO) {
            this.f14080a = bVar;
            this.f14081b = taNativeInfo;
            this.f14082c = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.a, com.cloud.hisavana.sdk.common.tranmeasure.d.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AdsDTO adsDTO) {
            super.a(adsDTO);
            b bVar = this.f14080a;
            if (bVar != null) {
                bVar.p(this.f14081b);
            }
            AdsDTO adsDTO2 = this.f14082c;
            if (adsDTO2 == null || adsDTO2.getImpBeanRequest() == null) {
                return;
            }
            x.h().k(this.f14082c.getImpBeanRequest().pmid);
            if (this.f14082c.isOfflineAd()) {
                AdsDTO adsDTO3 = this.f14082c;
                adsDTO3.setShowNum(Integer.valueOf(adsDTO3.getShowNum().intValue() + 1));
                b1.c().s(this.f14082c);
            }
        }
    }

    public static void a(TaNativeInfo taNativeInfo) {
        if (taNativeInfo != null && taNativeInfo.isRegister()) {
            e.c().g(taNativeInfo);
            taNativeInfo.setRegister(false);
        }
    }

    public static void b(TaNativeInfo taNativeInfo) {
        AdsDTO adItem;
        if (taNativeInfo == null || (adItem = taNativeInfo.getAdItem()) == null) {
            return;
        }
        adItem.setClickid(g2.a());
        o1.g(new DownUpPointBean(0.0f, 0.0f, 0.0f, 0.0f, adItem.getImageWidth().intValue(), adItem.getImageHeight().intValue()), adItem, null);
        o1.m(adItem.getClickTrackingUrls(), adItem);
        if ((adItem.getClickTrackingUrls() == null || adItem.getClickTrackingUrls().isEmpty()) && !adItem.isPsAd()) {
            z.a().d("LUtil", "startLandingPage2,click tracking url is null and ad is not ps ad");
            o1.m(adItem.getPsClickTrackingUrls(), adItem);
        }
    }

    public static void c(TaNativeInfo taNativeInfo, View view, b bVar) {
        AdsDTO adItem;
        if (taNativeInfo == null || (adItem = taNativeInfo.getAdItem()) == null) {
            return;
        }
        C0141a c0141a = new C0141a(bVar, taNativeInfo, adItem);
        taNativeInfo.setRegister(true);
        e.c().e(adItem, view, c0141a);
    }
}
