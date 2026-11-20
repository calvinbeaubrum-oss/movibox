package com.cloud.hisavana.sdk;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.request.AdxRequestBody;
import com.cloud.hisavana.sdk.data.bean.request.ApplicationDTO;
import com.cloud.hisavana.sdk.data.bean.request.ConfigRequestBody;
import com.cloud.hisavana.sdk.data.bean.request.DeviceDTO;
import com.cloud.hisavana.sdk.data.bean.request.UserDTO;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.MitNetUtil;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AdxRequestBody f29854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AdxRequestBody f29855b;

    public static AdxRequestBody a(boolean z11) {
        AdxRequestBody adxRequestBody = new AdxRequestBody();
        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setPackageName(com.cloud.sdk.commonutil.util.f.c());
        applicationDTO.setInstallTime(com.cloud.sdk.commonutil.util.b.a());
        applicationDTO.setVersionInt(ca.d.q());
        applicationDTO.setVersion(ca.d.r());
        applicationDTO.setSdkVersion(ca.d.l());
        applicationDTO.setSdkVersionCode(336100);
        applicationDTO.setUserAgent(ca.d.p());
        PackageInfo packageInfoC = w9.x.c(com.cloud.sdk.commonutil.util.f.a());
        applicationDTO.setPsVersion(packageInfoC == null ? 0L : packageInfoC.versionCode);
        applicationDTO.setPsChannel("Online");
        applicationDTO.setPsApiVersion("1.0.7");
        adxRequestBody.application = applicationDTO;
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setType(ca.d.o());
        deviceDTO.setBrand(ca.d.a());
        deviceDTO.setModel(ca.d.f());
        deviceDTO.setMaker(ca.d.c());
        deviceDTO.setOsType(1);
        deviceDTO.setOsVersion(ca.d.h());
        deviceDTO.setScreenWidth(ca.d.k());
        deviceDTO.setScreenHeight(ca.d.j());
        deviceDTO.setScreenDensity(ca.d.i());
        deviceDTO.setTurnOffPerAds(DeviceUtil.f());
        deviceDTO.setCpu(DeviceUtil.c());
        deviceDTO.setOsApiLevel("" + ca.d.g());
        if (!z11 && ca.b.h0()) {
            String strM = ca.b.m();
            if (!TextUtils.isEmpty(strM)) {
                deviceDTO.setAntifraud(strM);
            }
        }
        deviceDTO.setTotalRam(Long.valueOf(DeviceUtil.m()));
        adxRequestBody.device = deviceDTO;
        return adxRequestBody;
    }

    public static String b() {
        DeviceDTO deviceDTO;
        try {
            boolean zE = e();
            ConfigRequestBody configRequestBody = new ConfigRequestBody();
            AdxRequestBody adxRequestBody = f29855b;
            configRequestBody.application = adxRequestBody.application;
            configRequestBody.device = adxRequestBody.device;
            configRequestBody.user = new UserDTO();
            configRequestBody.applicationId = AdManager.f29117b;
            configRequestBody.testRequest = AdManager.i();
            if (!zE && (deviceDTO = configRequestBody.device) != null && TextUtils.isEmpty(deviceDTO.getGaid())) {
                configRequestBody.device.setGaid(DeviceUtil.e());
            }
            configRequestBody.user.setBaseStation(DeviceUtil.g());
            configRequestBody.user.setLatitude(com.cloud.sdk.commonutil.util.e.d());
            configRequestBody.user.setLongitude(com.cloud.sdk.commonutil.util.e.f());
            configRequestBody.user.setCoordTime(com.cloud.sdk.commonutil.util.e.c());
            configRequestBody.ascribeEnable = w9.x.f(com.cloud.sdk.commonutil.util.f.a());
            return GsonUtil.d(configRequestBody);
        } catch (Throwable th2) {
            z.a().e(Log.getStackTraceString(th2));
            return "";
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static String c(AdxImpBean adxImpBean) {
        try {
            boolean zD = d();
            AdxRequestBody adxRequestBodyCopy = AdxRequestBody.copy(f29854a);
            adxRequestBodyCopy.requestId = !TextUtils.isEmpty(adxImpBean.requestId) ? adxImpBean.requestId : DeviceUtil.n();
            adxRequestBodyCopy.testRequest = Boolean.valueOf(AdManager.i());
            adxRequestBodyCopy.applicationId = AdManager.f29117b;
            adxRequestBodyCopy.apiType = 1;
            adxRequestBodyCopy.defaultAd = false;
            adxRequestBodyCopy.offlineAd = adxImpBean.offlineAd;
            adxRequestBodyCopy.cachedAdCount = adxImpBean.cacheAdCount;
            adxRequestBodyCopy.codeSeat.setId(adxImpBean.pmid);
            adxRequestBodyCopy.codeSeat.setType(adxImpBean.adt);
            adxRequestBodyCopy.codeSeat.setAdCount(adxImpBean.mAdCount);
            adxRequestBodyCopy.codeSeat.setWidth(0);
            adxRequestBodyCopy.codeSeat.setHeight(0);
            adxRequestBodyCopy.codeSeat.setGameName(adxImpBean.gameName);
            adxRequestBodyCopy.codeSeat.setGameScene(adxImpBean.gameScene);
            adxRequestBodyCopy.codeSeat.setExtInfo(adxImpBean.extInfo);
            adxRequestBodyCopy.codeSeat.setAdPriority(adxImpBean.supportEw ? 1 : 0);
            adxRequestBodyCopy.codeSeat.setOfflineAdEnable(adxImpBean.offlineAdEnable);
            DeviceDTO deviceDTO = adxRequestBodyCopy.device;
            if (zD && deviceDTO != null) {
                deviceDTO.setIpAddress(DeviceUtil.h());
                deviceDTO.setOneid(DeviceUtil.j());
            }
            if (deviceDTO != null) {
                deviceDTO.setImsi(ca.d.d());
                deviceDTO.setLanguage(Locale.getDefault().getLanguage());
                deviceDTO.setOperatorType(ca.d.e() + ca.d.d());
                deviceDTO.setGaid(DeviceUtil.e());
                deviceDTO.setNetworkConnectionType(String.valueOf(MitNetUtil.a(com.cloud.sdk.commonutil.util.f.a()).ordinal()));
                deviceDTO.setPsCountryCode(DeviceUtil.d());
            }
            adxRequestBodyCopy.user.setBaseStation(DeviceUtil.g());
            adxRequestBodyCopy.user.setLatitude(com.cloud.sdk.commonutil.util.e.d());
            adxRequestBodyCopy.user.setLongitude(com.cloud.sdk.commonutil.util.e.f());
            adxRequestBodyCopy.user.setCoordTime(com.cloud.sdk.commonutil.util.e.c());
            return GsonUtil.d(adxRequestBodyCopy);
        } catch (Throwable th2) {
            z.a().e(Log.getStackTraceString(th2));
            return "";
        }
    }

    public static synchronized boolean d() {
        AdxRequestBody adxRequestBody = f29854a;
        if (adxRequestBody == null) {
            f29854a = a(false);
            return true;
        }
        DeviceDTO deviceDTO = adxRequestBody.device;
        if (deviceDTO != null && TextUtils.isEmpty(deviceDTO.getAntifraud()) && ca.b.h0()) {
            String strM = ca.b.m();
            if (!TextUtils.isEmpty(strM)) {
                f29854a.device.setAntifraud(strM);
            }
        }
        return false;
    }

    public static synchronized boolean e() {
        if (f29855b != null) {
            return false;
        }
        f29855b = a(true);
        return true;
    }
}
