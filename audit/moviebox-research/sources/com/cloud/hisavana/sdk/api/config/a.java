package com.cloud.hisavana.sdk.api.config;

import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static boolean a(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return false;
        }
        if (adsDTO.isOfflineAd() || adsDTO.getSource() == 4) {
            return true;
        }
        boolean z11 = System.currentTimeMillis() - adsDTO.getFill_ts().longValue() <= ((long) (adsDTO.getCacheTime().intValue() * 60000));
        z.a().d("ssp", "isAdValid-" + z11 + " -now-" + System.currentTimeMillis() + "-load-" + adsDTO.getFill_ts() + "-cachetime-" + (adsDTO.getCacheTime().intValue() * 60000));
        return z11;
    }
}
