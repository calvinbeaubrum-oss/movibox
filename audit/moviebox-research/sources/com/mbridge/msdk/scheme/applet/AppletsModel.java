package com.mbridge.msdk.scheme.applet;

import android.net.Uri;
import android.text.TextUtils;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.b;
import com.mbridge.msdk.foundation.same.net.b.a;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.scheme.report.AppletsReport;
import com.mbridge.msdk.scheme.request.AppletSchemeRequest;
import com.mbridge.msdk.scheme.response.AppletSchemeResponse;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class AppletsModel implements Serializable {
    private static final String DYNAMIC_VIEW_WX_IS_REDIRECT_0 = "0";
    private static final String DYNAMIC_VIEW_WX_IS_REDIRECT_1 = "1";
    private static final String DYNAMIC_VIEW_WX_QUERY_PARAM_EVENT_CALLBACK = "event_callback";
    private static final String DYNAMIC_VIEW_WX_QUERY_PARAM_INSTALL_CALLBACK = "install_callback";
    public static final int REQUEST_TYPE_CLICK = 1;
    public static final int REQUEST_TYPE_SHOW = 0;
    private static String TAG = "AppletsModel";
    private static final String URL_ENCODE_UTF_8 = "UTF-8";
    private static final String WX_MINIPROGRAM = "wx_miniprogram";
    private static final int WX_SCHEME_REQUEST_ERROR_CODE_44993 = 44993;
    private volatile IAppletSchemeCallBack appletSchemeCallBack;
    private final CampaignEx campaignEx;
    private String deepLink = "";
    private volatile boolean isRequestSuccess = false;
    private boolean isRequestTimesMaxPerDay = false;
    private volatile boolean isRequesting = false;
    private boolean isSupportWxScheme = false;
    private boolean isUserClick = false;
    private int lastRequestType = -1;
    private Map<String, String> params;
    private String reBuildClickUrl;
    private final String requestId;
    private final String unitID;

    /* JADX INFO: compiled from: source.java */
    public static final class DefaultAppletSchemeResponse extends AppletSchemeResponse {
        private AppletsModel appletsModel;

        public DefaultAppletSchemeResponse(AppletsModel appletsModel) {
            this.appletsModel = appletsModel;
        }

        @Override // com.mbridge.msdk.scheme.response.AppletSchemeResponse, com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
        public final void onError(a aVar) {
            super.onError(aVar);
            AppletsModel appletsModel = this.appletsModel;
            if (appletsModel == null) {
                return;
            }
            appletsModel.changeRequestingState(false);
            this.appletsModel.handlerSchemeRequestNetworkError(aVar);
        }

        @Override // com.mbridge.msdk.scheme.response.AppletSchemeResponse, com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
        public final void onSuccess(k<JSONObject> kVar) {
            super.onSuccess(kVar);
            AppletsModel appletsModel = this.appletsModel;
            if (appletsModel == null) {
                return;
            }
            appletsModel.changeRequestingState(false);
            if (kVar == null || kVar.f44691c == null) {
                this.appletsModel.handlerRequestNetworkError();
                return;
            }
            try {
                this.appletsModel.handlerSchemeRequestResult(kVar);
            } catch (SchemeRequestException e11) {
                this.appletsModel.handlerSchemeRequestFailed(-2, e11.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class SchemeRequestException extends Exception {
        public SchemeRequestException(String str) {
            super(str);
        }
    }

    public AppletsModel(CampaignEx campaignEx, String str, String str2) {
        this.campaignEx = campaignEx;
        this.unitID = str;
        this.requestId = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeRequestingState(boolean z11) {
        this.isRequesting = z11;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00be A[Catch: Exception -> 0x0078, TRY_LEAVE, TryCatch #4 {Exception -> 0x0078, blocks: (B:14:0x0045, B:16:0x0054, B:21:0x0067, B:23:0x006f, B:35:0x00ab, B:37:0x00be, B:32:0x0088, B:34:0x008c, B:51:0x00e8, B:62:0x0102, B:73:0x011c, B:74:0x011f, B:83:0x013c, B:85:0x014a, B:86:0x0160, B:80:0x0132, B:82:0x0136, B:69:0x0111, B:71:0x0115, B:58:0x00f7, B:60:0x00fb, B:47:0x00dd, B:49:0x00e1, B:63:0x0105, B:41:0x00d1, B:28:0x007d, B:52:0x00eb), top: B:106:0x0045, inners: #0, #1, #3, #5, #6 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x01b4  */
    private Map<String, String> getAppletsParamsAndBuildRequest(CampaignEx campaignEx) {
        String queryParameter;
        String str;
        String str2;
        String str3;
        String str4 = MBridgeConstans.DYNAMIC_VIEW_WX_IS_REDIRECT;
        String str5 = "query";
        HashMap map = new HashMap();
        if (campaignEx == null) {
            return map;
        }
        try {
            Uri uri = Uri.parse(campaignEx.getClickURL());
            if (uri != null && uri.getQueryParameterNames() != null) {
                StringBuilder sb2 = new StringBuilder();
                Iterator<String> it = uri.getQueryParameterNames().iterator();
                int i11 = 0;
                try {
                    try {
                        try {
                            while (true) {
                                queryParameter = "";
                                if (!it.hasNext()) {
                                    break;
                                }
                                try {
                                    Iterator<String> it2 = it;
                                    String next = it.next();
                                    if (TextUtils.isEmpty(next) || TextUtils.equals(next, "wx_miniprogram")) {
                                        str4 = str4;
                                        str5 = str5;
                                    } else {
                                        try {
                                            queryParameter = uri.getQueryParameter(next);
                                        } catch (Exception unused) {
                                        }
                                        String strEncode = queryParameter;
                                        if (TextUtils.equals(next, DYNAMIC_VIEW_WX_QUERY_PARAM_EVENT_CALLBACK) || TextUtils.equals(next, DYNAMIC_VIEW_WX_QUERY_PARAM_INSTALL_CALLBACK)) {
                                            try {
                                                strEncode = URLEncoder.encode(strEncode, "UTF-8");
                                            } catch (Exception e11) {
                                                if (MBridgeConstans.DEBUG) {
                                                    ad.a(TAG, "encode url for " + strEncode + " failed", e11);
                                                }
                                                sb2.append(next);
                                                sb2.append("=");
                                                sb2.append(strEncode);
                                                if (i11 < uri.getQueryParameterNames().size()) {
                                                    sb2.append("&");
                                                }
                                                i11++;
                                                it = it2;
                                                str4 = str4;
                                                str5 = str5;
                                            }
                                        }
                                        sb2.append(next);
                                        sb2.append("=");
                                        sb2.append(strEncode);
                                        if (i11 < uri.getQueryParameterNames().size()) {
                                            sb2.append("&");
                                        }
                                        i11++;
                                    }
                                    it = it2;
                                    str4 = str4;
                                    str5 = str5;
                                } catch (Exception e12) {
                                    e = e12;
                                    if (MBridgeConstans.DEBUG) {
                                        ad.a(TAG, "create wechat app request param failed ", e);
                                    }
                                }
                                e = e12;
                                if (MBridgeConstans.DEBUG) {
                                    ad.a(TAG, "create wechat app request param failed ", e);
                                }
                                return map;
                            }
                            String queryParameter2 = uri.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                            if (queryParameter2 == null) {
                                queryParameter2 = "";
                            }
                            str2 = queryParameter2;
                        } catch (Exception e13) {
                            if (MBridgeConstans.DEBUG) {
                                ad.a(TAG, "create wechat app request param failed ", e13);
                            }
                            str2 = "";
                        }
                        String strEncode2 = URLEncoder.encode(sb2.toString(), "UTF-8");
                        if (strEncode2 != null) {
                            queryParameter = strEncode2;
                        }
                    } catch (UnsupportedEncodingException e14) {
                        if (MBridgeConstans.DEBUG) {
                            ad.a(TAG, "create wechat app request param failed ", e14);
                        }
                    }
                    String queryParameter3 = uri.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_WX_CLICKID);
                    if (queryParameter3 == null) {
                        queryParameter3 = "";
                    }
                    str3 = queryParameter3;
                } catch (Exception e15) {
                    if (MBridgeConstans.DEBUG) {
                        ad.a(TAG, "create wechat app request param failed ", e15);
                    }
                    str3 = "";
                }
                String str6 = str4;
                String str7 = str5;
                try {
                    String queryParameter4 = uri.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                    if (queryParameter4 == null) {
                        queryParameter4 = "";
                    }
                    str = queryParameter4;
                } catch (Exception e16) {
                    if (MBridgeConstans.DEBUG) {
                        ad.a(TAG, "create wechat app request param failed ", e16);
                    }
                    str = "";
                }
                map.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, str);
                map.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str2);
                map.put(MBridgeConstans.DYNAMIC_VIEW_WX_CLICKID, str3);
                String str8 = queryParameter;
                map.put(str7, str8);
                map.put(str6, "0");
                if (MBridgeConstans.DEBUG) {
                    ad.a(TAG, "query: " + str8);
                }
                this.reBuildClickUrl = reCreateClickUrl(MBridgeConstans.DYNAMIC_VIEW_WX_APP + "=" + str + "&" + MBridgeConstans.DYNAMIC_VIEW_WX_PATH + "=" + str2 + "&" + str7 + "=" + str8 + "&" + MBridgeConstans.DYNAMIC_VIEW_WX_CLICKID + "=" + str3 + "&" + str6 + "=1");
                return map;
            }
            return map;
        } catch (Exception e17) {
            e = e17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerRequestNetworkError() {
        if (this.appletSchemeCallBack == null) {
            return;
        }
        if (MBridgeConstans.DEBUG) {
            ad.a(TAG, "handlerRequestNetworkError response or result is null");
        }
        try {
            this.appletSchemeCallBack.onNetworkError(1, "response or result is null", this.reBuildClickUrl);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a(TAG, "handler request network error exception ", e11);
            }
        }
        AppletsReport.reportAppletsLoadState(c.m().c(), "response or result is null", this.unitID, this.requestId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerSchemeRequestFailed(int i11, String str) {
        if (this.appletSchemeCallBack == null) {
            return;
        }
        if (MBridgeConstans.DEBUG) {
            ad.a(TAG, String.format("handlerSchemeRequestFailed network error by code %s and %s", String.valueOf(i11), str));
        }
        try {
            this.appletSchemeCallBack.onAppletSchemeRequestFailed(i11, str, this.reBuildClickUrl);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a(TAG, "handler wx scheme failed exception  ", e11);
            }
        }
        AppletsReport.reportAppletsLoadState(c.m().c(), String.format("network error by code %s and %s", String.valueOf(i11), str), this.unitID, this.requestId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerSchemeRequestNetworkError(a aVar) {
        int i11;
        String message;
        if (this.appletSchemeCallBack == null) {
            return;
        }
        if (aVar != null) {
            i11 = aVar.f44551a;
            message = aVar.getMessage();
            if (i11 == 10) {
                message = "request timeout";
            }
        } else {
            i11 = -1;
            message = "unKnown";
        }
        if (MBridgeConstans.DEBUG) {
            ad.a(TAG, String.format("handlerSchemeRequestNetworkError network error by code %s and %s", String.valueOf(i11), message));
        }
        try {
            this.appletSchemeCallBack.onNetworkError(i11, "network error: " + message, this.reBuildClickUrl);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a(TAG, "handler wx scheme network error exception ", e11);
            }
        }
        AppletsReport.reportAppletsLoadState(c.m().c(), String.format("network error by code %s and %s", String.valueOf(i11), message), this.unitID, this.requestId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerSchemeRequestResult(k<JSONObject> kVar) throws SchemeRequestException {
        JSONObject jSONObject = kVar.f44691c;
        if (MBridgeConstans.DEBUG) {
            ad.a("AppletsModel", "result: " + jSONObject.toString());
        }
        if (jSONObject.has("wx_scheme")) {
            String strOptString = jSONObject.optString("wx_scheme", "");
            if (TextUtils.isEmpty(strOptString)) {
                throw new SchemeRequestException("wx_scheme value is null");
            }
            this.isRequestSuccess = true;
            handlerSchemeRequestSuccess(strOptString);
            return;
        }
        int iOptInt = jSONObject.optInt(TrackingKey.ERROR_CODE, -1);
        String strOptString2 = jSONObject.optString("error_msg", "");
        if (iOptInt == WX_SCHEME_REQUEST_ERROR_CODE_44993) {
            this.isRequestTimesMaxPerDay = true;
        }
        handlerSchemeRequestFailed(iOptInt, strOptString2);
    }

    private void handlerSchemeRequestStart() {
        if (this.appletSchemeCallBack == null) {
            return;
        }
        try {
            this.appletSchemeCallBack.onAppletSchemeRequestStart();
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a(TAG, "handler wx scheme start exception ", e11);
            }
        }
        AppletsReport.reportAppletsLoadState(c.m().c(), "start load wx scheme", this.unitID, this.requestId);
    }

    private void handlerSchemeRequestSuccess(String str) {
        if (this.appletSchemeCallBack == null) {
            return;
        }
        if (MBridgeConstans.DEBUG) {
            ad.a(TAG, "handlerSchemeRequestSuccess: " + str);
        }
        try {
            this.deepLink = str;
            this.appletSchemeCallBack.onAppletSchemeRequestSuccess(str);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a(TAG, "handler wx scheme success exception ", e11);
            }
        }
        AppletsReport.reportAppletsLoadState(c.m().c(), "request wx scheme success", this.unitID, this.requestId);
    }

    private boolean isCanRequestByClickUrl(String str) {
        try {
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx == null) {
                return false;
            }
            String clickURL = campaignEx.getClickURL();
            if (TextUtils.isEmpty(clickURL)) {
                return false;
            }
            return TextUtils.equals(ao.a(clickURL, "wx_miniprogram"), str);
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            ad.a(TAG, "query wx_miniprogram from click url exception ", e11);
            return false;
        }
    }

    private boolean isCanRequestByLinkType() {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx == null) {
            return false;
        }
        int linkType = campaignEx.getLinkType();
        return linkType == 8 || linkType == 9;
    }

    private boolean isCanRequestByTemplateUrl(String str) {
        CampaignEx.c rewardTemplateMode;
        try {
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx != null && (rewardTemplateMode = campaignEx.getRewardTemplateMode()) != null && !TextUtils.isEmpty(rewardTemplateMode.e())) {
                return TextUtils.equals(ao.a(rewardTemplateMode.e(), MBridgeConstans.DYNAMIC_VIEW_REQ_WX_URL), str);
            }
            return false;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            ad.a(TAG, "query reqwxurl from template url exception ", e11);
            return false;
        }
    }

    private String reCreateClickUrl(String str) {
        return d.f().f44618a + "?" + str;
    }

    public boolean can(int i11) {
        if (isRequesting() || !canRequestWxScheme(i11)) {
            return false;
        }
        if (this.lastRequestType == -1) {
            return true;
        }
        if (isRequestSuccess()) {
            return false;
        }
        int i12 = this.lastRequestType;
        return (i12 == 0 && i11 == 1) || (i12 == 1 && i11 == 1 && this.isUserClick);
    }

    public boolean canRequestWxScheme(int i11) {
        if (!isSupportWxScheme()) {
            return false;
        }
        if (i11 != 0) {
            return i11 == 1;
        }
        return isCanRequestByTemplateUrl("2");
    }

    public void clearRequestState() {
        this.isRequestSuccess = false;
        this.isRequesting = false;
        this.appletSchemeCallBack = null;
    }

    public String getDeepLink() {
        return this.deepLink;
    }

    public String getReBuildClickUrl() {
        return this.reBuildClickUrl;
    }

    public boolean isRequestSuccess() {
        return this.isRequestSuccess;
    }

    public boolean isRequestTimesMaxPerDay() {
        return this.isRequestTimesMaxPerDay;
    }

    public boolean isRequesting() {
        return this.isRequesting;
    }

    public boolean isSupportWxScheme() {
        if (!this.isSupportWxScheme) {
            this.isSupportWxScheme = isCanRequestByClickUrl("1") && isCanRequestByLinkType();
        }
        return this.isSupportWxScheme;
    }

    public void requestWxAppletsScheme(int i11, IAppletSchemeCallBack iAppletSchemeCallBack) {
        if (this.campaignEx == null || TextUtils.isEmpty(this.unitID)) {
            return;
        }
        if (MBridgeConstans.DEBUG) {
            ad.b(TAG, "start request wx scheme");
        }
        this.isRequesting = true;
        if (iAppletSchemeCallBack != null) {
            this.appletSchemeCallBack = iAppletSchemeCallBack;
        }
        handlerSchemeRequestStart();
        AppletSchemeRequest appletSchemeRequest = new AppletSchemeRequest(c.m().c());
        if (this.params == null) {
            this.params = getAppletsParamsAndBuildRequest(this.campaignEx);
        }
        if (this.params == null) {
            return;
        }
        if (isRequestTimesMaxPerDay()) {
            handlerSchemeRequestFailed(WX_SCHEME_REQUEST_ERROR_CODE_44993, "get wxscheme failed : request times is max");
            return;
        }
        this.lastRequestType = i11;
        appletSchemeRequest.get(1, d.f().f44618a, this.params, new b(5000, 5000, 5000, 6000, 0), new DefaultAppletSchemeResponse(this));
    }

    public void setAppletSchemeCallBack(IAppletSchemeCallBack iAppletSchemeCallBack) {
        this.appletSchemeCallBack = iAppletSchemeCallBack;
    }

    public void setRequestingFinish() {
        this.isRequesting = false;
    }

    public void setUserClick(boolean z11) {
        this.isUserClick = z11;
    }
}
