package com.cloud.hisavana.sdk.common.http;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.RequestParams;
import com.cloud.hisavana.net.impl.StringCallback;
import com.cloud.hisavana.sdk.R$string;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.request.AdxRequestBody;
import com.cloud.hisavana.sdk.h0;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.f;
import com.cloud.sdk.commonutil.util.i;
import com.cloud.sdk.commonutil.util.r;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.push.PushConstants;
import java.util.Locale;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Headers;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class AdServerRequest extends com.cloud.hisavana.sdk.common.http.b<CommonResponseListener> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f29414k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f29415l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f29416m = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f29417c = "0";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f29418d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f29419e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SSLSocketFactory f29420f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f29421g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f29422h = "0";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f29423i = "1";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AdxImpBean f29424j;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public class a extends StringCallback {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f29425e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z11, String str) {
            super(z11);
            this.f29425e = str;
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback, com.cloud.hisavana.net.impl.HttpCallbackImpl
        public void m(Headers headers) {
            super.m(headers);
            if (headers != null) {
                for (int i11 = 0; i11 < headers.size(); i11++) {
                    String strName = headers.name(i11);
                    if (!TextUtils.isEmpty(strName) && strName.toLowerCase(Locale.ROOT).contains("cloudcontrolversion")) {
                        String strValue = headers.value(i11);
                        com.cloud.sdk.commonutil.util.c.netLog("okhttp -> get new cloud control version from header,version: " + strValue);
                        if (!TextUtils.isEmpty(strValue) && !strValue.equals(AdServerRequest.f29414k)) {
                            String unused = AdServerRequest.f29414k = strValue;
                            boolean unused2 = AdServerRequest.f29416m = true;
                            com.cloud.sdk.commonutil.util.c.netLog("okhttp ->  cloud control version update");
                            da.a.d().p("new_config_ver", strValue);
                        }
                        da.a.d().o("last_req_config_time", System.currentTimeMillis());
                    }
                    if (!TextUtils.isEmpty(strName) && strName.toLowerCase(Locale.ROOT).contains("cloudcontrolofflineversion")) {
                        String strValue2 = headers.value(i11);
                        com.cloud.sdk.commonutil.util.c.netLog("okhttp -> get new hisavana cloud control version from header,version: " + strValue2);
                        if (!TextUtils.isEmpty(strValue2) && !strValue2.equals(AdServerRequest.f29415l)) {
                            String unused3 = AdServerRequest.f29415l = strValue2;
                            com.cloud.sdk.commonutil.util.c.netLog("okhttp -> hisavana cloud control version update");
                            da.a.d().p("new_hisavana_ver", strValue2);
                        }
                    }
                }
            }
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback
        public void y(int i11, String str, Throwable th2) {
            int iOptInt;
            if (h0.g(i11, str)) {
                AdServerRequest.this.j();
                return;
            }
            if (th2 != null && AdManager.h()) {
                com.cloud.sdk.commonutil.util.c.netLog(this.f29425e + " ----- error statusCode = " + i11 + " ----- error message = " + th2.getMessage() + " ----- response = " + str);
            }
            if (AdServerRequest.this.f29454b != 0) {
                try {
                    if (str != null) {
                        iOptInt = new JSONObject(str).optInt(TrackingKey.CODE);
                    } else {
                        com.cloud.sdk.commonutil.util.c.netLog("can't get code,response is null");
                        iOptInt = 0;
                    }
                } catch (Exception e11) {
                    com.cloud.sdk.commonutil.util.c.netLog("getCode error " + e11.getMessage());
                }
                if (iOptInt == 0) {
                    iOptInt = i11;
                }
                com.cloud.sdk.commonutil.util.c.netLog("statusCode = " + i11);
                ((CommonResponseListener) AdServerRequest.this.f29454b).c(iOptInt, str, th2);
            }
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback
        public void z(int i11, String str) {
            if (AdManager.h()) {
                com.cloud.sdk.commonutil.util.c.netLog(this.f29425e + "\n ----- status code = " + i11 + "\n ----- response = " + str);
            }
            if (TextUtils.isEmpty(str)) {
                T t11 = AdServerRequest.this.f29454b;
                if (t11 != 0) {
                    ((CommonResponseListener) t11).e(TaErrorCode.ERROR_RESPONSE_IS_NULL);
                }
                com.cloud.sdk.commonutil.util.c.netLog("TextUtils.isEmpty(response) == true ,  response is null ");
                return;
            }
            T t12 = AdServerRequest.this.f29454b;
            if (t12 != 0) {
                ((CommonResponseListener) t12).h(i11, str);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public interface b {
        String a();
    }

    @Override // com.cloud.hisavana.sdk.common.http.b
    public void b() {
        i.f30292a.e(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.AdServerRequest.1
            @Override // java.lang.Runnable
            public void run() {
                AdServerRequest.this.j();
            }
        });
    }

    public final void j() {
        String strA = this.f29421g.a();
        if (TextUtils.isEmpty(strA)) {
            T t11 = this.f29454b;
            if (t11 != 0) {
                ((CommonResponseListener) t11).c(-1, "TextUtils.isEmpty(postBodyString) == true ", null);
            }
            com.cloud.sdk.commonutil.util.c.netLog("sendRequestToServer() --> TextUtils.isEmpty(postBodyString) == true ");
            return;
        }
        AdxImpBean adxImpBean = this.f29424j;
        if (adxImpBean != null) {
            adxImpBean.requestTs = Long.valueOf(System.currentTimeMillis());
            AthenaTracker.h0(this.f29424j);
            if (AdManager.h() && !this.f29424j.offlineAd) {
                r.b(f.a().getString(R$string.ssp_log_msg3), 2);
            }
        }
        try {
            String str = "----- full url = " + this.f29418d + "\n ----- postBodyString = " + strA.trim();
            String strJ = da.a.d().j("cloudControlVersion", null);
            String strJ2 = da.a.d().j("hisavanaCurrentCloudControlVersion", null);
            if (TextUtils.isEmpty(this.f29418d)) {
                return;
            }
            T t12 = this.f29454b;
            if (t12 != 0) {
                ((CommonResponseListener) t12).f(1);
            }
            h0.f(aa.a.b() != 0);
            String strC = h0.c("post", "", "application/json", this.f29418d, strA);
            RequestParams requestParams = new RequestParams();
            requestParams.h("x-tr-signature", strC);
            requestParams.h("cloudControlVersion", strJ);
            requestParams.h("cloudControlOfflineVersion", strJ2);
            requestParams.h("defaultAd", "2");
            requestParams.h("offlineAd", this.f29422h);
            requestParams.h("Accept-Timezone", "UTC");
            requestParams.h("sdktype", this.f29423i);
            requestParams.h(PushConstants.PROVIDER_FIELD_PKG, f.a().getPackageName());
            requestParams.l((AdxRequestBody) GsonUtil.a(strA, AdxRequestBody.class));
            HttpRequest.j(this.f29418d, requestParams, new a(true, str));
        } catch (Throwable th2) {
            com.cloud.sdk.commonutil.util.c.netLog("AdServerRequest --> " + Log.getStackTraceString(th2));
            T t13 = this.f29454b;
            if (t13 != 0) {
                ((CommonResponseListener) t13).e(new TaErrorCode(-1, th2.getMessage()));
            }
        }
    }

    public AdServerRequest k(AdxImpBean adxImpBean) {
        this.f29424j = adxImpBean;
        return this;
    }

    public AdServerRequest l(boolean z11) {
        this.f29419e = z11;
        return this;
    }

    public AdServerRequest m(boolean z11) {
        this.f29422h = z11 ? "1" : "0";
        return this;
    }

    public AdServerRequest n(CommonResponseListener commonResponseListener) {
        this.f29454b = commonResponseListener;
        return this;
    }

    public AdServerRequest o(String str) {
        this.f29417c = str;
        return this;
    }

    public AdServerRequest p(b bVar) {
        this.f29421g = bVar;
        return this;
    }

    public AdServerRequest q(String str) {
        this.f29423i = str;
        return this;
    }

    public AdServerRequest r(String str) {
        this.f29418d = str;
        return this;
    }
}
