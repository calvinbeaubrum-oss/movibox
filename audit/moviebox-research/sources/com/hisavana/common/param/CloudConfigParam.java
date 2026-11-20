package com.hisavana.common.param;

import android.text.TextUtils;
import android.util.Log;
import ca.d;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.MitNetUtil;
import com.cloud.sdk.commonutil.util.b;
import com.cloud.sdk.commonutil.util.e;
import com.cloud.sdk.commonutil.util.f;
import com.hisavana.common.BuildConfig;
import com.hisavana.common.bean.AppStartInfo;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.utils.AdLogUtil;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class CloudConfigParam {
    private static final String TAG = "CloudConfigParam";
    private static CloudConfigPostBody requestParam;

    public static String getPostBody(String str, boolean z11, String str2, List<String> list) {
        boolean z12;
        DeviceDTO deviceDTO;
        try {
            if (requestParam == null) {
                CloudConfigPostBody cloudConfigPostBody = new CloudConfigPostBody();
                requestParam = cloudConfigPostBody;
                cloudConfigPostBody.applicationId = str;
                cloudConfigPostBody.testRequest = Boolean.valueOf(z11);
                requestParam.codeSeatFilterEnable = TextUtils.equals(str2, ComConstants.AHA_CHANNEL);
                Map<String, String> map = AppStartInfo.extInfo;
                if (map != null && !map.isEmpty()) {
                    Ext ext = new Ext();
                    ext.setTg(map);
                    requestParam.ext = ext;
                }
                ApplicationDTO applicationDTO = new ApplicationDTO();
                applicationDTO.setPackageName(f.c());
                applicationDTO.setInstallTime(b.a());
                applicationDTO.setVersion(d.r());
                applicationDTO.setSdkVersion(BuildConfig.VERSION_NAME);
                applicationDTO.setUserAgent(d.p());
                applicationDTO.setChannel(AppStartInfo.channel);
                applicationDTO.setFirstStart(AppStartInfo.isFirstStartToday);
                applicationDTO.setActiveTime(AppStartInfo.activeTime);
                requestParam.application = applicationDTO;
                DeviceDTO deviceDTO2 = new DeviceDTO();
                deviceDTO2.setType(d.o());
                deviceDTO2.setBrand(d.a());
                deviceDTO2.setModel(d.f());
                deviceDTO2.setMaker(d.c());
                z12 = true;
                deviceDTO2.setOsType(1);
                deviceDTO2.setOsVersion(d.h());
                deviceDTO2.setLanguage(Locale.getDefault().getLanguage());
                deviceDTO2.setNetworkConnectionType(String.valueOf(MitNetUtil.a(f.a()).ordinal()));
                deviceDTO2.setOperatorType(MitNetUtil.b());
                deviceDTO2.setIpAddress(DeviceUtil.h());
                deviceDTO2.setGaid(DeviceUtil.e());
                deviceDTO2.setImsi(d.d());
                deviceDTO2.setScreenWidth(d.k());
                deviceDTO2.setScreenHeight(d.j());
                deviceDTO2.setScreenDensity(d.i());
                deviceDTO2.setOneid(DeviceUtil.j());
                deviceDTO2.setTotalRam(Long.valueOf(DeviceUtil.m()));
                requestParam.device = deviceDTO2;
                requestParam.user = new UserDTO();
            } else {
                z12 = false;
            }
            CloudConfigPostBody cloudConfigPostBody2 = requestParam;
            if (cloudConfigPostBody2.codeSeatFilterEnable) {
                cloudConfigPostBody2.codeSeatFilterIds = list;
            }
            if (!z12 && (deviceDTO = cloudConfigPostBody2.device) != null && TextUtils.isEmpty(deviceDTO.getGaid())) {
                requestParam.device.setGaid(DeviceUtil.e());
            }
            requestParam.user.setBaseStation(DeviceUtil.g());
            requestParam.user.setLatitude(e.d());
            requestParam.user.setLongitude(e.f());
            requestParam.user.setCoordTime(e.b());
            return GsonUtil.d(requestParam);
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return "";
        }
    }
}
