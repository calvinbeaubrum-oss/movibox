package com.mbridge.msdk.video.signal.a;

import android.util.Base64;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f48113a;

    public n(WebView webView) {
        this.f48113a = webView;
    }

    private String a(int i11, int i12) {
        if (i12 != 0) {
            try {
                return ai.a(Double.valueOf(i11 / i12)) + "";
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return i12 + "";
    }

    @Override // com.mbridge.msdk.video.signal.a.f, com.mbridge.msdk.video.signal.g
    public final void a(int i11) {
        super.a(i11);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i11);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.f48113a, "onVideoStatusNotify", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.f, com.mbridge.msdk.video.signal.g
    public final void a(int i11, int i12, int i13, int i14) {
        super.a(i11, i12, i13, i14);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            String str = "landscape";
            if (i11 != 2 ? i12 != 2 : i12 == 1) {
                str = "portrait";
            }
            jSONObject2.put("orientation", str);
            jSONObject2.put("screen_width", i13);
            jSONObject2.put("screen_height", i14);
            jSONObject.put("data", jSONObject2);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.f48113a, "showDataInfo", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.f, com.mbridge.msdk.video.signal.g
    public final void a(int i11, String str) {
        super.a(i11, str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", i11);
            jSONObject.put("pt", str);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.f48113a, "onJSClick", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.f, com.mbridge.msdk.video.signal.g
    public final void a(MBridgeVideoView.b bVar) {
        super.a(bVar);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, a(bVar.f47992a, bVar.f47993b));
            jSONObject.put("time", String.valueOf(bVar.f47992a));
            jSONObject.put("duration", String.valueOf(bVar.f47993b));
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.f48113a, "onVideoProgressNotify", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.f, com.mbridge.msdk.video.signal.g
    public final void a(Object obj) {
        super.a(obj);
        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.f48113a, "webviewshow", (obj == null || !(obj instanceof String)) ? "" : Base64.encodeToString(obj.toString().getBytes(), 2));
    }
}
