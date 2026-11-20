package com.hisavana.mediation.config;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.AdServerRequest;
import com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.f;
import com.cloud.sdk.commonutil.util.i;
import com.cloud.sdk.commonutil.util.p;
import com.cloud.sdk.commonutil.util.t;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.param.CloudConfigParam;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.tracking.TrackingManager;
import com.hisavana.common.tracking.TrackingUtil;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.common.utils.NetUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import hn.l;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class CloudControlConfigSync {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Handler f41897c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f41895a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f41896b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Runnable f41898d = new Runnable() { // from class: com.hisavana.mediation.config.CloudControlConfigSync.5
        @Override // java.lang.Runnable
        public void run() {
            CloudControlConfigSync.l(TAdErrorCode.CODE_REQUEST_CLOUD_TIME_OUT, "The cloud control reaches 15s timeout");
        }
    };

    /* JADX INFO: renamed from: com.hisavana.mediation.config.CloudControlConfigSync$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass2 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            InputStream inputStreamOpen;
            StringBuilder sb2 = new StringBuilder();
            try {
                inputStreamOpen = f.a().getAssets().open("mediation.json");
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb2.append(line);
                        }
                    }
                    String string = sb2.toString();
                    if (!TextUtils.isEmpty(string)) {
                        CloudControlConfigSync.i((CloudControlConfig) GsonUtil.a(string, CloudControlConfig.class));
                    }
                    da.a.d().n(ComConstants.Pref.LAST_MODE, 1);
                    if (inputStreamOpen == null) {
                        return;
                    }
                } catch (Throwable unused) {
                    if (inputStreamOpen == null) {
                        return;
                    }
                }
            } catch (Throwable unused2) {
                inputStreamOpen = null;
            }
            try {
                inputStreamOpen.close();
            } catch (IOException e11) {
                AdLogUtil.Log().e("CloudControlConfigSync", Log.getStackTraceString(e11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements AdServerRequest.b {
        @Override // com.cloud.hisavana.sdk.common.http.AdServerRequest.b
        public String a() {
            return CloudConfigParam.getPostBody(TAdManager.getAppId(), TAdManager.isTestDevice(), TAdManager.getAhaChannel(), TAdManager.getCodeSeatIds());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Preconditions.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f41902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f41903b;

        public b(int i11, String str) {
            this.f41902a = i11;
            this.f41903b = str;
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            TAdManager.OnCloudCompleteListener cloudCompleteListener = TAdManager.getCloudCompleteListener();
            if (cloudCompleteListener != null) {
                cloudCompleteListener.onCloudComplete(this.f41902a, this.f41903b);
                TAdManager.releaseCloudListener();
            }
        }
    }

    public static void b(int i11) {
        String triggerId = TrackingUtil.getTriggerId();
        f41896b = 0;
        String strJ = da.a.d().j("cloudControlVersion", null);
        if (TextUtils.isEmpty(strJ)) {
            n(i11, triggerId);
            return;
        }
        if (TextUtils.equals(TAdManager.getAhaChannel(), ComConstants.AHA_CHANNEL)) {
            if (i11 == 1 || i11 == 5) {
                AdLogUtil.Log().d(ComConstants.SDK_INIT, "aha渠道请求云控 triggerType " + i11 + " ids= " + TAdManager.getCodeSeatIds());
                if (TAdManager.getCodeSeatIds() == null || TAdManager.getCodeSeatIds().size() <= 0) {
                    return;
                }
                n(i11, triggerId);
                return;
            }
            return;
        }
        String strI = da.a.d().i("new_config_ver");
        RecordTestInfo.record("CloudControlConfigSync - newVersion = " + strI + ",current version=" + strJ);
        if (!TextUtils.isEmpty(strI) && !TextUtils.equals(strJ, strI)) {
            n(i11, triggerId);
            return;
        }
        if (System.currentTimeMillis() - da.a.d().h("last_req_config_time", 0L) <= da.a.d().h(ComConstants.Pref.REQ_CONFIG_INTERVAL, ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED)) {
            AdLogUtil.Log().d(ComConstants.SDK_INIT, "*----> new cloud config version is empty or is the same as current,don't send config request");
        } else if (NetUtil.checkNetworkState()) {
            AdLogUtil.Log().d(ComConstants.SDK_INIT, "request cloud config because of out of time");
            n(i11, triggerId);
        }
    }

    public static void d(long j11, String str, int i11) {
        Bundle bundle = new Bundle();
        bundle.putString(TrackingKey.CLD_APP_ID, TAdManager.getAppId());
        bundle.putInt(TrackingKey.TRIGGER_TYPE, i11);
        bundle.putString(TrackingKey.CLD_REQUEST_ID, str);
        bundle.putLong(TrackingKey.CLD_REQUEST_TS, j11);
        TrackingManager.trackingADCldRequest(bundle);
    }

    public static void i(CloudControlConfig cloudControlConfig) {
        if (cloudControlConfig == null) {
            return;
        }
        if (cloudControlConfig.getData() == null || cloudControlConfig.getData().getCodeSeats() == null) {
            AdLogUtil.Log().d(ComConstants.SDK_INIT, "CloudControlConfigSync --> extracted --> 数据为空 无法保存");
            return;
        }
        ConfigContentHelper.g().b();
        boolean zI = ConfigContentHelper.g().i(cloudControlConfig.getData().getCodeSeats());
        if (ConfigContentHelper.g().f() > 0) {
            l(0, "get cloud data success");
        }
        if (!zI) {
            AdLogUtil.Log().d(ComConstants.SDK_INIT, "*----> CloudControlConfigSync --> save data 2 sqlite failed!!!");
            return;
        }
        da.a.d().p("cloudControlVersion", cloudControlConfig.getData().getCloudControlVersion());
        da.a.d().p("new_config_ver", cloudControlConfig.getData().getCloudControlVersion());
        AdLogUtil.Log().i(ComConstants.SDK_INIT, "*----> CloudControlConfigSync --> save data 2 sqlite --> 持久化当前云控版本：" + cloudControlConfig.getData().getCloudControlVersion());
    }

    public static void j(boolean z11, String str, String str2, long j11, String str3, int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt(TrackingKey.TRIGGER_TYPE, i11);
        bundle.putString(TrackingKey.CLD_REQUEST_ID, str3);
        bundle.putLong(TrackingKey.CLD_RETURN_TS, System.currentTimeMillis());
        try {
            bundle.putInt(TrackingKey.CLD_RETURN_TIME_INTERVAL, (int) (System.currentTimeMillis() - j11));
        } catch (Exception unused) {
        }
        if (z11) {
            bundle.putInt(TrackingKey.CODE, 0);
        } else {
            bundle.putInt(TrackingKey.CODE, 1);
        }
        if (TextUtils.isEmpty(str)) {
            bundle.putString("message", "");
        } else {
            bundle.putString("message", str);
        }
        bundle.putString("data", str2);
        TrackingManager.trackingCldReturn(bundle);
    }

    public static void l(int i11, String str) {
        Preconditions.d(new b(i11, str));
    }

    public static /* synthetic */ int m() {
        int i11 = f41896b;
        f41896b = i11 + 1;
        return i11;
    }

    public static void n(final int i11, final String str) {
        if (NetUtil.checkNetworkState()) {
            AtomicBoolean atomicBoolean = f41895a;
            if (!atomicBoolean.get()) {
                if (TextUtils.equals(TAdManager.getAhaChannel(), ComConstants.AHA_CHANNEL) && (TAdManager.getCodeSeatIds() == null || TAdManager.getCodeSeatIds().isEmpty())) {
                    AdLogUtil.Log().d(ComConstants.SDK_INIT, "requestCloudControl channel is aha,but codeSeatIds is empty,stop requestCloudControl");
                    return;
                }
                atomicBoolean.set(true);
                final long jCurrentTimeMillis = System.currentTimeMillis();
                d(jCurrentTimeMillis, str, i11);
                RecordTestInfo.record("CloudControlConfigSync - send cloud control request");
                AdServerRequest adServerRequestQ = new AdServerRequest().n(new CommonResponseListener<CloudControlConfig>() { // from class: com.hisavana.mediation.config.CloudControlConfigSync.4
                    @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
                    public void a(TaErrorCode taErrorCode) {
                        String str2;
                        CloudControlConfigSync.f41895a.set(false);
                        AdLogUtil adLogUtilLog = AdLogUtil.Log();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("CloudControlConfigSync --> error msg ");
                        if (taErrorCode != null) {
                            str2 = taErrorCode.getErrorMessage() + "，" + taErrorCode.getErrorCode();
                        } else {
                            str2 = "";
                        }
                        sb2.append(str2);
                        adLogUtilLog.w(ComConstants.SDK_INIT, sb2.toString());
                        String strI = da.a.d().i("cloudControlVersion");
                        da.a.d().n(ComConstants.Pref.CLOUD_CONFIG_ERROR_CODE, taErrorCode != null ? taErrorCode.getErrorCode() : -1);
                        if (taErrorCode != null) {
                            CloudControlConfigSync.j(false, taErrorCode.getErrorMessage(), strI, jCurrentTimeMillis, str, i11);
                        } else {
                            CloudControlConfigSync.j(false, "no message", strI, jCurrentTimeMillis, str, i11);
                        }
                        if (CloudControlConfigSync.f41896b >= 1 && taErrorCode != null) {
                            CloudControlConfigSync.t();
                            if (taErrorCode.getErrorCode() == 481) {
                                CloudControlConfigSync.l(481, "request cloud network time out");
                            } else if (taErrorCode.getErrorCode() == 484) {
                                CloudControlConfigSync.l(484, "request cloud is host fail ");
                            }
                        }
                        if (taErrorCode != null) {
                            AdLogUtil.Log().i(ComConstants.SDK_INIT, "currentCloudRetryCount = " + CloudControlConfigSync.f41896b + " , errorCode = " + taErrorCode.getErrorCode());
                            if (CloudControlConfigSync.f41896b == 0) {
                                if (taErrorCode.getErrorCode() == 481 || taErrorCode.getErrorCode() == 484) {
                                    CloudControlConfigSync.m();
                                    CloudControlConfigSync.n(i11, str);
                                }
                            }
                        }
                    }

                    @Override // com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener
                    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
                    public void g(int i12, final CloudControlConfig cloudControlConfig) {
                        List<Network> networks;
                        CloudControlConfigSync.t();
                        da.a.d().n(ComConstants.Pref.CLOUD_CONFIG_ERROR_CODE, 0);
                        if (cloudControlConfig == null) {
                            CloudControlConfigSync.f41895a.set(false);
                            return;
                        }
                        if (LogSwitch.isDebug) {
                            AdLogUtil.Log().d(ComConstants.SDK_INIT, "CloudControlConfigSync --> CloudControl is: " + GsonUtil.d(cloudControlConfig));
                        }
                        da.a.d().o("last_req_config_time", System.currentTimeMillis());
                        CloudControlConfig.ConfigData data = cloudControlConfig.getData();
                        if (data != null) {
                            int iIntValue = data.getCloudControlCacheInterval().intValue();
                            if (iIntValue > 0) {
                                da.a.d().o(ComConstants.Pref.REQ_CONFIG_INTERVAL, ((long) iIntValue) * 3600000);
                            }
                            ArrayList<CloudControlConfig.CodeSeat> codeSeats = data.getCodeSeats();
                            if (codeSeats != null && !codeSeats.isEmpty()) {
                                int size = codeSeats.size();
                                for (int i13 = 0; i13 < size; i13++) {
                                    CloudControlConfig.CodeSeat codeSeat = codeSeats.get(i13);
                                    if (codeSeat != null && (networks = codeSeat.getNetworks()) != null && !networks.isEmpty()) {
                                        for (Network network : networks) {
                                            if (network != null) {
                                                network.setTempPrice(network.getPrice().doubleValue());
                                                AdUtil.overwriteAdmobNetworkPrice(network);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i.f30292a.e(new Runnable() { // from class: com.hisavana.mediation.config.CloudControlConfigSync.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        CloudControlConfigSync.i(cloudControlConfig);
                                    } catch (Exception e11) {
                                        AdLogUtil.Log().e(ComConstants.SDK_INIT, "CloudControlConfigSync --> 保存本地数据失败 " + Log.getStackTraceString(e11));
                                    }
                                } finally {
                                    CloudControlConfigSync.f41895a.set(false);
                                }
                            }
                        });
                        if (cloudControlConfig.getData() != null) {
                            CloudControlConfigSync.j(true, cloudControlConfig.getMessage(), cloudControlConfig.getData().getCloudControlVersion(), jCurrentTimeMillis, str, i11);
                        }
                    }
                }).p(new a()).r(l.a()).q("2");
                if (adServerRequestQ != null) {
                    adServerRequestQ.c();
                    return;
                }
                return;
            }
        }
        AdLogUtil.Log().w(ComConstants.SDK_INIT, "CloudControlConfigSync --> network error or requesting");
    }

    public static void p() {
        if (TAdManager.isTestDevice() && da.a.d().f(ComConstants.Pref.LAST_MODE, -1) == 1) {
            AdLogUtil.Log().d(ComConstants.SDK_INIT, "clear relase config when change mode to test_device");
            ConfigContentHelper.g().c();
            da.a.d().a();
        }
    }

    public static void q() {
        AdLogUtil adLogUtilLog = AdLogUtil.Log();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Current mode,testDevice: ");
        sb2.append(TAdManager.isTestDevice());
        sb2.append(",debug: ");
        sb2.append(TAdManager.isDebug());
        sb2.append(",server: ");
        sb2.append(aa.a.b() == 1 ? "Test" : "Release");
        adLogUtilLog.d(ComConstants.SDK_INIT, sb2.toString());
        p();
        f41897c = new Handler(Looper.getMainLooper());
        t.a().c(new Runnable() { // from class: com.hisavana.mediation.config.CloudControlConfigSync.1
            @Override // java.lang.Runnable
            public void run() {
                CloudControlConfigSync.u();
                CloudControlConfigSync.b(1);
            }
        }, 500L);
        if (r()) {
            AdLogUtil.Log().i("CloudControlConfigSync", "no need to load asset config");
            return;
        }
        s();
        if (r()) {
            AdLogUtil.Log().i("CloudControlConfigSync", "load asset config success");
        } else {
            AdLogUtil.Log().e("CloudControlConfigSync", "load asset config failed");
        }
    }

    public static boolean r() {
        if (ConfigContentHelper.g().f() <= 0) {
            AdLogUtil.Log().i("CloudControlConfigSync", "no cloud data in db");
            return false;
        }
        t();
        ConfigContentHelper.g().h();
        l(0, "get cloud data success");
        return true;
    }

    public static void s() {
        try {
            String strJ = p.j("mediation.json");
            if (TextUtils.isEmpty(strJ)) {
                AdLogUtil.Log().e("CloudControlConfigSync", "get nothing from mediation.json");
            } else {
                i((CloudControlConfig) GsonUtil.a(strJ, CloudControlConfig.class));
            }
        } catch (Throwable th2) {
            AdLogUtil.Log().e("CloudControlConfigSync", Log.getStackTraceString(th2));
        }
    }

    public static void t() {
        Handler handler = f41897c;
        if (handler != null) {
            handler.removeCallbacks(f41898d);
        }
    }

    public static void u() {
        Handler handler = f41897c;
        if (handler != null) {
            handler.postDelayed(f41898d, 15000L);
        }
    }
}
