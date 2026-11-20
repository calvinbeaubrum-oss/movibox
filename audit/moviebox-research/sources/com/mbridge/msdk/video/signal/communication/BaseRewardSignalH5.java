package com.mbridge.msdk.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class BaseRewardSignalH5 extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected IJSFactory f48118a;

    private String a(int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, i11);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            ad.b("JS-Reward-Communication", "code to string is error");
            return "";
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void cai(Object obj, String str) {
        ad.a("JS-Reward-Communication", "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                String strOptString = new JSONObject(str).optString("packageName");
                if (TextUtils.isEmpty(strOptString)) {
                    d.a(obj, "packageName is empty");
                }
                int i11 = ai.c(c.m().c(), strOptString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(TrackingKey.CODE, d.f45733b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i11);
                    jSONObject.put("data", jSONObject2);
                    g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e11) {
                    d.a(obj, e11.getMessage());
                    ad.a("JS-Reward-Communication", e11.getMessage());
                }
            } catch (Throwable th2) {
                d.a(obj, "exception: " + th2.getLocalizedMessage());
                ad.a("JS-Reward-Communication", "cai", th2);
            }
        } catch (JSONException e12) {
            d.a(obj, "exception: " + e12.getLocalizedMessage());
            ad.a("JS-Reward-Communication", "cai", e12);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void getEndScreenInfo(Object obj, String str) {
        String strEncodeToString;
        try {
            IJSFactory iJSFactory = this.f48118a;
            if (iJSFactory != null) {
                String strA = iJSFactory.getIJSRewardVideoV1().a();
                if (TextUtils.isEmpty(strA)) {
                    strEncodeToString = "";
                    ad.a("JS-Reward-Communication", "getEndScreenInfo failed");
                } else {
                    strEncodeToString = Base64.encodeToString(strA.getBytes(), 2);
                    ad.a("JS-Reward-Communication", "getEndScreenInfo success");
                }
                g.a().a(obj, strEncodeToString);
            }
        } catch (Throwable th2) {
            ad.a("JS-Reward-Communication", "getEndScreenInfo", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.f48118a == null || TextUtils.isEmpty(str)) {
                return;
            }
            String strOptString = new JSONObject(str).optString(NotificationCompat.CATEGORY_MESSAGE);
            ad.a("JS-Reward-Communication", "handlerPlayableException,msg:" + str);
            this.f48118a.getIJSRewardVideoV1().c(strOptString);
        } catch (Throwable th2) {
            ad.a("JS-Reward-Communication", "setOrientation", th2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        if (context instanceof IJSFactory) {
            this.f48118a = (IJSFactory) context;
        }
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        if (obj instanceof IJSFactory) {
            this.f48118a = (IJSFactory) obj;
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void install(Object obj, String str) {
        try {
            if (this.f48118a != null) {
                ad.a("JS-Reward-Communication", "install:" + str);
                if (this.f48118a.getJSContainerModule().endCardShowing()) {
                    this.f48118a.getJSCommon().click(3, str);
                } else {
                    this.f48118a.getJSCommon().click(1, str);
                }
            }
        } catch (Throwable th2) {
            ad.a("JS-Reward-Communication", "install", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.f48118a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("state");
            ad.a("JS-Reward-Communication", "notifyCloseBtn,state:" + str);
            this.f48118a.getIJSRewardVideoV1().notifyCloseBtn(iOptInt);
        } catch (Throwable th2) {
            ad.a("JS-Reward-Communication", "notifyCloseBtn", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        ad.b("JS-Reward-Communication", "openURL:" + str);
        Context contextC = c.m().c();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (contextC == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                    contextC = windVaneWebView.getContext();
                }
            } catch (Exception e11) {
                ad.b("JS-Reward-Communication", e11.getMessage());
            }
        }
        if (contextC == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt("type");
            if (iOptInt == 1) {
                com.mbridge.msdk.click.c.c(contextC, strOptString);
            } else if (iOptInt == 2) {
                com.mbridge.msdk.click.c.e(contextC, strOptString);
            }
        } catch (JSONException e12) {
            ad.b("JS-Reward-Communication", e12.getMessage());
        } catch (Throwable th2) {
            ad.b("JS-Reward-Communication", th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void setOrientation(Object obj, String str) {
        try {
            if (this.f48118a == null || TextUtils.isEmpty(str)) {
                return;
            }
            String strOptString = new JSONObject(str).optString("state");
            ad.a("JS-Reward-Communication", "setOrientation,state:" + str);
            this.f48118a.getIJSRewardVideoV1().b(strOptString);
        } catch (Throwable th2) {
            ad.a("JS-Reward-Communication", "setOrientation", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.f48118a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("state");
            ad.a("JS-Reward-Communication", "toggleCloseBtn,state:" + str);
            this.f48118a.getIJSRewardVideoV1().toggleCloseBtn(iOptInt);
        } catch (Throwable th2) {
            ad.a("JS-Reward-Communication", "toggleCloseBtn", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.f48118a == null || TextUtils.isEmpty(str)) {
                return;
            }
            g.a().a(obj, a(0));
            this.f48118a.getIJSRewardVideoV1().a(new JSONObject(str).optString("state"));
            ad.a("JS-Reward-Communication", "triggerCloseBtn,state:" + str);
        } catch (Throwable th2) {
            ad.a("JS-Reward-Communication", "triggerCloseBtn", th2);
            g.a().a(obj, a(-1));
        }
    }
}
