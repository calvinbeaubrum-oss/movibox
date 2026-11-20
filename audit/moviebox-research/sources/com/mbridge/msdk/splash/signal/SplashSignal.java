package com.mbridge.msdk.splash.signal;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class SplashSignal extends AbsFeedBackForH5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f47184a = "SplashSignal";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f47185g = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f47186e;

    public void getFileInfo(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.a(obj, new JSONObject(str));
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        if (obj != null) {
            try {
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().a(windVaneWebView, 0, str.toString(), windVaneWebView.getUrl());
            } catch (Throwable th2) {
                ad.a(f47184a, "handlerH5Exception", th2);
            }
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            d.b(obj, new JSONObject(str));
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public void init(Object obj, String str) {
        ad.b(f47184a, "initialize" + str);
        c cVar = this.f47186e;
        if (cVar != null) {
            cVar.a(obj, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.h
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof c)) {
                return;
            }
            this.f47186e = (c) windVaneWebView.getObject();
        } catch (Throwable th2) {
            ad.a(f47184a, "initialize", th2);
        }
    }

    public void install(Object obj, String str) {
        c cVar = this.f47186e;
        if (cVar != null) {
            cVar.d(obj, str);
        }
    }

    public void onSignalCommunication(Object obj, String str) {
        try {
            ad.b(f47184a, "onSignalCommunication");
            c cVar = this.f47186e;
            if (cVar != null) {
                cVar.i(obj, str);
            }
        } catch (Throwable th2) {
            ad.a(f47184a, "onSignalCommunication", th2);
        }
    }

    public void openURL(Object obj, String str) {
        ad.b(f47184a, "openURL" + str);
        c cVar = this.f47186e;
        if (cVar != null) {
            cVar.e(obj, str);
        }
    }

    public void pauseCountDown(Object obj, String str) {
        try {
            ad.b(f47184a, "pauseCountDown");
            c cVar = this.f47186e;
            if (cVar != null) {
                cVar.j(obj, str);
            }
        } catch (Throwable th2) {
            ad.a(f47184a, "pauseCountDown", th2);
        }
    }

    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                int iOptInt = new JSONObject(str).optInt("isReady", 1);
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().a(windVaneWebView, iOptInt);
            } catch (Throwable th2) {
                ad.a(f47184a, "readyStatus", th2);
            }
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            ad.b(f47184a, "reportUrls");
            c cVar = this.f47186e;
            if (cVar != null) {
                cVar.h(obj, str);
            }
        } catch (Throwable th2) {
            ad.a(f47184a, "reportUrls", th2);
        }
    }

    public void resetCountdown(Object obj, String str) {
        ad.b(f47184a, "resetCountdown" + str);
        c cVar = this.f47186e;
        if (cVar != null) {
            cVar.f(obj, str);
        }
    }

    public void resumeCountDown(Object obj, String str) {
        try {
            ad.b(f47184a, "resumeCountDown");
            c cVar = this.f47186e;
            if (cVar != null) {
                cVar.k(obj, str);
            }
        } catch (Throwable th2) {
            ad.a(f47184a, "resumeCountDown", th2);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            ad.b(f47184a, "sendImpressions");
            c cVar = this.f47186e;
            if (cVar != null) {
                cVar.g(obj, str);
            }
        } catch (Throwable th2) {
            ad.a(f47184a, "sendImpressions", th2);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        ad.b(f47184a, "toggleCloseBtn" + str);
        c cVar = this.f47186e;
        if (cVar != null) {
            cVar.b(obj, str);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        ad.b(f47184a, "triggerCloseBtn" + str);
        c cVar = this.f47186e;
        if (cVar != null) {
            cVar.c(obj, str);
        }
    }
}
