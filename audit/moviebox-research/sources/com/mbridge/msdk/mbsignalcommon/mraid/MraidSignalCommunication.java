package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MraidSignalCommunication extends BaseMraidSignalCommunication {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f45736g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f45737a;

    public void close(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0501a.f45738a.a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b, CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        }
        try {
            ad.b("MraidSignalCommunication", "MRAID close");
            b bVar = this.f45737a;
            if (bVar != null) {
                bVar.close();
            }
        } catch (Throwable th2) {
            ad.a("MraidSignalCommunication", "MRAID close", th2);
        }
    }

    public void expand(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0501a.f45738a.a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b, "expand");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            String strOptString2 = jSONObject.optString("shouldUseCustomClose");
            ad.b("MraidSignalCommunication", "MRAID expand " + strOptString + " " + strOptString2);
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || this.f45737a == null) {
                return;
            }
            this.f45737a.expand(strOptString, strOptString2.toLowerCase().equals("true"));
        } catch (Throwable th2) {
            ad.a("MraidSignalCommunication", "MRAID expand", th2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.mbridge.msdk.mbsignalcommon.windvane.h
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof b) {
                this.f45737a = (b) context;
                return;
            }
            if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof b)) {
                this.f45737a = (b) windVaneWebView.getObject();
            }
            if (windVaneWebView.getMraidObject() == null || !(windVaneWebView.getMraidObject() instanceof b)) {
                return;
            }
            this.f45737a = (b) windVaneWebView.getMraidObject();
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public void open(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
            windVaneWebView = aVar.f45774b;
            a.C0501a.f45738a.a(aVar.f45774b, "open");
        } else {
            windVaneWebView = null;
        }
        try {
            String strOptString = new JSONObject(str).optString("url");
            ad.b("MraidSignalCommunication", "MRAID Open " + strOptString);
            if (this.f45737a == null || TextUtils.isEmpty(strOptString)) {
                return;
            }
            if (windVaneWebView == null || System.currentTimeMillis() - windVaneWebView.lastTouchTime <= com.mbridge.msdk.click.b.a.f43105c || !com.mbridge.msdk.click.b.a.a(this.f45737a.getMraidCampaign(), windVaneWebView.getUrl(), com.mbridge.msdk.click.b.a.f43103a)) {
                this.f45737a.open(strOptString);
            }
        } catch (Throwable th2) {
            ad.a("MraidSignalCommunication", "MRAID Open", th2);
        }
    }

    public void setOrientationProperties(Object obj, String str) {
        String str2;
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0501a.f45738a.a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b, "setOrientationProperties");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("allowOrientationChange");
            String strOptString2 = jSONObject.optString("forceOrientation");
            ad.b("MraidSignalCommunication", "MRAID setOrientationProperties");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || this.f45737a == null) {
                return;
            }
            strOptString.toLowerCase().equals("true");
            String lowerCase = strOptString2.toLowerCase();
            int iHashCode = lowerCase.hashCode();
            if (iHashCode == 729267099) {
                str2 = "portrait";
            } else if (iHashCode != 1430647483) {
                return;
            } else {
                str2 = "landscape";
            }
            lowerCase.equals(str2);
        } catch (Throwable th2) {
            ad.a("MraidSignalCommunication", "MRAID setOrientationProperties", th2);
        }
    }

    public void unload(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0501a.f45738a.a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b, "unload");
        }
        try {
            ad.b("MraidSignalCommunication", "MRAID unload");
            b bVar = this.f45737a;
            if (bVar != null) {
                bVar.unload();
            }
        } catch (Throwable th2) {
            ad.a("MraidSignalCommunication", "MRAID unload", th2);
        }
    }

    public void useCustomClose(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0501a.f45738a.a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b, "useCustomClose");
        }
        try {
            String strOptString = new JSONObject(str).optString("shouldUseCustomClose");
            ad.b("MraidSignalCommunication", "MRAID useCustomClose " + strOptString);
            if (TextUtils.isEmpty(strOptString) || this.f45737a == null) {
                return;
            }
            this.f45737a.useCustomClose(strOptString.toLowerCase().equals("true"));
        } catch (Throwable th2) {
            ad.a("MraidSignalCommunication", "MRAID useCustomClose", th2);
        }
    }
}
