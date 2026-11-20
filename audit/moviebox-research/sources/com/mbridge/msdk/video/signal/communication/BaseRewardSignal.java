package com.mbridge.msdk.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class BaseRewardSignal extends BaseRewardSignalDiff {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected BaseIRewardCommunication f48117a;

    private String a(int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, i11);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            ad.b("JS-Reward-Brigde", "code to string is error");
            return "";
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void cai(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
            return;
        }
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
                    ad.a("JS-Reward-Brigde", e11.getMessage());
                }
            } catch (JSONException e12) {
                d.a(obj, "exception: " + e12.getLocalizedMessage());
                ad.a("JS-Reward-Brigde", "cai", e12);
            }
        } catch (Throwable th2) {
            d.a(obj, "exception: " + th2.getLocalizedMessage());
            ad.a("JS-Reward-Brigde", "cai", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void getEndScreenInfo(Object obj, String str) {
        try {
            BaseIRewardCommunication baseIRewardCommunication = this.f48117a;
            if (baseIRewardCommunication != null) {
                baseIRewardCommunication.getEndScreenInfo(obj, str);
                ad.b("JS-Reward-Brigde", "getEndScreenInfo factory is true");
            } else {
                ad.b("JS-Reward-Brigde", "getEndScreenInfo factory is null");
                if (obj != null) {
                    WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b;
                    if ((windVaneWebView instanceof WindVaneWebView) && windVaneWebView.getWebViewListener() != null) {
                        ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(obj);
                    }
                }
            }
        } catch (Throwable th2) {
            ad.a("JS-Reward-Brigde", "getEndScreenInfo", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.f48117a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f48117a.handlerPlayableException(obj, str);
        } catch (Throwable th2) {
            ad.a("JS-Reward-Brigde", "handlerPlayableException", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.h
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            try {
                if (IJSFactory.class.isInstance(context)) {
                    this.f48117a = (BaseIRewardCommunication) BaseRewardSignalH5.class.newInstance();
                    BaseRewardSignalH5.class.getMethod("initialize", Context.class, WindVaneWebView.class).invoke(this.f48117a, context, windVaneWebView);
                } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof BaseIRewardCommunication)) {
                    this.f48117a = (BaseIRewardCommunication) windVaneWebView.getObject();
                }
            } catch (ClassNotFoundException e11) {
                e11.printStackTrace();
            }
        } catch (Exception e12) {
            if (MBridgeConstans.DEBUG) {
                e12.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.h
    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        super.initialize(obj, windVaneWebView);
        try {
            try {
                if (IJSFactory.class.isInstance(obj)) {
                    this.f48117a = (BaseIRewardCommunication) BaseRewardSignalH5.class.newInstance();
                    BaseRewardSignalH5.class.getMethod("initialize", Object.class, WindVaneWebView.class).invoke(this.f48117a, obj, windVaneWebView);
                } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof BaseIRewardCommunication)) {
                    this.f48117a = (BaseIRewardCommunication) windVaneWebView.getObject();
                }
            } catch (ClassNotFoundException e11) {
                e11.printStackTrace();
            }
        } catch (Exception e12) {
            if (MBridgeConstans.DEBUG) {
                e12.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void install(Object obj, String str) {
        try {
            BaseIRewardCommunication baseIRewardCommunication = this.f48117a;
            if (baseIRewardCommunication != null) {
                baseIRewardCommunication.install(obj, str);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (obj != null) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.f45774b.getObject() instanceof k) {
                    ((k) aVar.f45774b.getObject()).click(1, str);
                    ad.b("JS-Reward-Brigde", "JSCommon install jump success");
                }
            }
            ad.b("JS-Reward-Brigde", "JSCommon install failed");
        } catch (Throwable th2) {
            ad.a("JS-Reward-Brigde", "install", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.f48117a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f48117a.notifyCloseBtn(obj, str);
        } catch (Throwable th2) {
            ad.a("JS-Reward-Brigde", "notifyCloseBtn", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void openURL(Object obj, String str) {
        ad.b("JS-Reward-Brigde", "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt("type");
            if (iOptInt == 1) {
                com.mbridge.msdk.click.c.c(this.f45797b, strOptString);
            } else if (iOptInt == 2) {
                com.mbridge.msdk.click.c.e(this.f45797b, strOptString);
            }
        } catch (JSONException e11) {
            ad.b("JS-Reward-Brigde", e11.getMessage());
        } catch (Throwable th2) {
            ad.b("JS-Reward-Brigde", th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void setOrientation(Object obj, String str) {
        try {
            if (this.f48117a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f48117a.setOrientation(obj, str);
        } catch (Throwable th2) {
            ad.a("JS-Reward-Brigde", "setOrientation", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.f48117a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f48117a.toggleCloseBtn(obj, str);
        } catch (Throwable th2) {
            ad.a("JS-Reward-Brigde", "toggleCloseBtn", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.f48117a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f48117a.triggerCloseBtn(obj, str);
        } catch (Throwable th2) {
            ad.a("JS-Reward-Brigde", "triggerCloseBtn", th2);
            g.a().a(obj, a(-1));
        }
    }
}
