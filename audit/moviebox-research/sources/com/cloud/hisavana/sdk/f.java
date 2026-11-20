package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {
    public static void a(AdsDTO adsDTO) {
        if (adsDTO == null) {
            z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "exposureInvalid --> null == info");
            return;
        }
        adsDTO.setIsEffectiveShow(0);
        z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "invalid exposure --> to server info = " + adsDTO);
        if (adsDTO.getSource() == 4) {
            AthenaTracker.P(adsDTO);
        } else {
            AthenaTracker.b0(adsDTO);
        }
    }

    public static void b(AdsDTO adsDTO) {
        if (adsDTO == null) {
            z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "exposureInvalid --> null == info");
            return;
        }
        adsDTO.setIsEffectiveShow(1);
        z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "valid exposure --> to server info = " + adsDTO);
        if (adsDTO.getSource() == 4) {
            AthenaTracker.P(adsDTO);
        } else {
            AthenaTracker.b0(adsDTO);
        }
    }
}
