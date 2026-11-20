package com.cloud.hisavana.sdk.common.tranmeasure;

import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.g2;
import com.cloud.hisavana.sdk.n;
import com.cloud.hisavana.sdk.o1;
import com.cloud.hisavana.sdk.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a<T> implements d.b<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.hisavana.sdk.common.tranmeasure.d.b
    public void a(T t11) {
        AdsDTO adItem;
        z.a().d("ssp", "-------------------------> onViewImpressed");
        if (t11 instanceof AdsDTO) {
            adItem = (AdsDTO) t11;
        } else {
            adItem = t11 instanceof TaNativeInfo ? ((TaNativeInfo) t11).getAdItem() : null;
        }
        if (adItem != null) {
            DownUpPointBean downUpPointBean = new DownUpPointBean(0.0f, 0.0f, 0.0f, 0.0f, adItem.getImageWidth().intValue(), adItem.getImageHeight().intValue());
            adItem.setClickid(g2.a());
            o1.n(adItem.getShowTrackingUrls(), adItem, downUpPointBean);
            n.f29890a.G(adItem);
        }
        n.f29890a.Q();
    }
}
