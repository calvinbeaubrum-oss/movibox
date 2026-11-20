package w9;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.bean.ImgListDTO;
import com.cloud.hisavana.sdk.common.bean.PslinkInfo;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import com.cloud.hisavana.sdk.e1;
import com.hisavana.common.constant.ComConstants;
import java.io.File;
import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static boolean a(AdsDTO adsDTO, int i11) {
        if (adsDTO == null) {
            return false;
        }
        PslinkInfo pslinkInfo = adsDTO.getPslinkInfo();
        Uri uriU = e1.u(pslinkInfo.getIconUrl(), i11);
        if (uriU == null) {
            return false;
        }
        pslinkInfo.setIconUri(uriU);
        for (ImgListDTO imgListDTO : pslinkInfo.getImgList()) {
            if (imgListDTO != null && !TextUtils.isEmpty(imgListDTO.getUrl())) {
                Uri uriU2 = e1.u(imgListDTO.getUrl(), i11);
                if (uriU2 == null) {
                    return false;
                }
                imgListDTO.setUri(uriU2);
            }
        }
        return true;
    }

    public static boolean b(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return true;
        }
        if (adsDTO.getSource() == 4) {
            return false;
        }
        if (adsDTO.getAdLaunchTypes().intValue() == 1) {
            return !com.cloud.hisavana.sdk.api.config.a.a(adsDTO);
        }
        if (adsDTO.getOfflineAdStartDate() != null && adsDTO.getOfflineAdLaunchDate() != null) {
            try {
                long time = new SimpleDateFormat("yyyy-MM-dd").parse(adsDTO.getOfflineAdStartDate()).getTime();
                adsDTO.setOfflineAdStartDateLong(Long.valueOf(time));
                String binaryString = Long.toBinaryString(adsDTO.getOfflineAdLaunchDate().longValue());
                adsDTO.setOfflineAdLaunchDateStr(binaryString);
                adsDTO.setOfflineAdExpireTime(Long.valueOf(time + (((long) (binaryString.lastIndexOf("1") + 1)) * ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED)));
                if (System.currentTimeMillis() <= adsDTO.getOfflineAdExpireTime().longValue()) {
                    return false;
                }
            } catch (Exception e11) {
                com.cloud.hisavana.sdk.z.a().e("OfflineAdExpiredUtil", e11.getMessage());
            }
        }
        return true;
    }

    public static int c(AdsDTO adsDTO, boolean z11) {
        if (adsDTO == null || b(adsDTO)) {
            return 1;
        }
        if (!f(adsDTO)) {
            return 2;
        }
        if (e(adsDTO, z11)) {
            return (adsDTO.isReachedDisplayTimes() && adsDTO.isOfflineAd()) ? 3 : 0;
        }
        return 4;
    }

    public static boolean d(AdsDTO adsDTO) {
        String offlineH5Url = adsDTO.getOfflineH5Url();
        if (TextUtils.isEmpty(offlineH5Url)) {
            return true;
        }
        if (!adsDTO.isH5Zip()) {
            return !TextUtils.isEmpty(offlineH5Url) && e1.t(offlineH5Url);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f.b(com.cloud.sdk.commonutil.util.f.a()));
        String str = File.separator;
        sb2.append(str);
        sb2.append("offline_zip");
        sb2.append(str);
        sb2.append(q.c(offlineH5Url));
        return new File(sb2.toString()).exists();
    }

    public static boolean e(AdsDTO adsDTO, boolean z11) {
        if (adsDTO == null) {
            return false;
        }
        String adImgUrl = adsDTO.getAdImgUrl();
        if (adsDTO.getImpBeanRequest() != null && adsDTO.getImpBeanRequest().adt == 2 && (TextUtils.equals(adsDTO.getMaterialStyle(), "B20301") || TextUtils.equals(adsDTO.getMaterialStyle(), "B20302") || TextUtils.equals(adsDTO.getMaterialStyle(), "B20303"))) {
            adImgUrl = adsDTO.getLogoUrl();
        }
        if (adsDTO.getImpBeanRequest() != null && adsDTO.getImpBeanRequest().adt == 6) {
            adImgUrl = adsDTO.getLogoUrl();
        }
        adsDTO.setACReady(Boolean.valueOf(e1.t(adsDTO.getAdChoiceImageUrl())));
        if (!e1.t(adImgUrl)) {
            return false;
        }
        AdsProtocolBean.Ext ext = adsDTO.getExt();
        if (ext != null && ext.getStoreFlag().intValue() > 0 && adsDTO.getImpBeanRequest() != null && adsDTO.getImpBeanRequest().adt != 6 && (TextUtils.isEmpty(ext.getStoreImageurl()) || !e1.t(ext.getStoreImageurl()))) {
            return false;
        }
        if (adsDTO.getPslinkInfoStatus()) {
            return !z11 || a(adsDTO, 1);
        }
        if (adsDTO.isH5Zip()) {
            return d(adsDTO);
        }
        return !z11 || d(adsDTO);
    }

    public static boolean f(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return false;
        }
        if (!adsDTO.isOfflineAd()) {
            return true;
        }
        try {
            return adsDTO.getOfflineAdLaunchDateStr().charAt((int) ((System.currentTimeMillis() - adsDTO.getOfflineAdStartDateLong().longValue()) / ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED)) == '1';
        } catch (Exception e11) {
            com.cloud.hisavana.sdk.z.a().e("OfflineAdExpiredUtil", e11.getMessage());
        }
    }
}
