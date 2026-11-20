package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import com.mbridge.msdk.mbsignalcommon.communication.BannerSignalPlugin;
import com.mbridge.msdk.mbsignalcommon.mraid.MraidSignalCommunication;
import com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebGLCheckSignal;
import com.mbridge.msdk.splash.signal.SplashSignal;
import com.mbridge.msdk.video.signal.communication.RewardSignal;
import com.mbridge.msdk.video.signal.communication.VideoCommunication;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, Class> f45792a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f45793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f45794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WindVaneWebView f45795d;

    public f(Context context, WindVaneWebView windVaneWebView) {
        this.f45793b = context;
        this.f45795d = windVaneWebView;
        try {
            a(com.mbridge.msdk.mbsignalcommon.base.e.f45663a, Class.forName("com.mbridge.msdk.interstitial.signalcommon.interstitial"));
        } catch (ClassNotFoundException unused) {
        }
        try {
            int i11 = RewardSignal.f48121g;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f45664b, RewardSignal.class);
        } catch (ClassNotFoundException unused2) {
        }
        try {
            int i12 = VideoCommunication.f48147g;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f45665c, VideoCommunication.class);
        } catch (ClassNotFoundException unused3) {
        }
        try {
            int i13 = MraidSignalCommunication.f45736g;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f45667e, MraidSignalCommunication.class);
        } catch (ClassNotFoundException unused4) {
        }
        try {
            int i14 = BannerSignalPlugin.f45728g;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f45668f, BannerSignalPlugin.class);
        } catch (ClassNotFoundException unused5) {
        }
        try {
            int i15 = SplashSignal.f47185g;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f45669g, SplashSignal.class);
        } catch (ClassNotFoundException unused6) {
        }
        try {
            int i16 = WebGLCheckSignal.f45748g;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f45670h, WebGLCheckSignal.class);
        } catch (ClassNotFoundException unused7) {
        }
        try {
            if (com.mbridge.msdk.f.b.a()) {
                Class<?> cls = Class.forName("com.mbridge.msdk.mbsignalcommon.confirmation.bridge.ConfirmationJsBridgePlugin");
                a(cls.getSimpleName(), cls);
            }
        } catch (Exception unused8) {
        }
    }

    private Object a(String str, WindVaneWebView windVaneWebView, Context context) {
        Class cls = f45792a.get(str);
        if (cls == null) {
            return null;
        }
        try {
            if (!h.class.isAssignableFrom(cls)) {
                return null;
            }
            h hVar = (h) cls.newInstance();
            hVar.initialize(context, windVaneWebView);
            hVar.initialize(this.f45794c, windVaneWebView);
            return hVar;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final Object a(String str) {
        if (f45792a == null) {
            f45792a = new HashMap<>();
        }
        return a(str, this.f45795d, this.f45793b);
    }

    public final void a(Context context) {
        this.f45793b = context;
    }

    public final void a(Object obj) {
        this.f45794c = obj;
    }

    public final void a(String str, Class cls) {
        if (f45792a == null) {
            f45792a = new HashMap<>();
        }
        f45792a.put(str, cls);
    }
}
