package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.hisavana.common.constant.ComConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class la {
    public static final la A;
    public static final la B;
    public static final la C;
    public static final la D;
    public static final la E;
    public static final la F;
    public static final la G;
    public static final la H;
    public static final la I;
    public static final la J;
    public static final la K;
    public static final la L;
    public static final la M;
    public static final la N;
    public static final la O;
    public static final la P;
    public static final la Q;
    public static final la R;
    public static final la S;
    public static final la T;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static JSONObject f20374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final la f20375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final la f20376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final la f20377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final la f20378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final la f20379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final la f20380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final la f20381j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final la f20382k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final la f20383l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final la f20384m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final la f20385n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final la f20386o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final la f20387p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final la f20388q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final la f20389r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final la f20390s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final la f20391t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final la f20392u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final la f20393v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final la f20394w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final la f20395x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final la f20396y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final la f20397z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f20399b;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f20400a;

        static {
            int[] iArr = new int[b.values().length];
            f20400a = iArr;
            try {
                iArr[b.AD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20400a[b.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20400a[b.USER_SESSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum b {
        AD,
        ERROR,
        USER_SESSION
    }

    static {
        b bVar = b.ERROR;
        f20375d = new la("generic", bVar);
        f20376e = new la(ComConstants.SDK_INIT, b.USER_SESSION);
        b bVar2 = b.AD;
        f20377f = new la("ad_requested", bVar2);
        f20378g = new la("ad_request_success", bVar2);
        f20379h = new la("ad_request_failure", bVar2);
        f20380i = new la("ad_load_success", bVar2);
        f20381j = new la("ad_load_failure", bVar2);
        f20382k = new la("ad_displayed", bVar2);
        f20383l = new la("ad_hidden", bVar2);
        f20384m = new la("adapter_init_started", bVar2);
        f20385n = new la("adapter_init_success", bVar2);
        f20386o = new la("adapter_init_failure", bVar2);
        f20387p = new la("signal_collection_success", bVar2);
        f20388q = new la("signal_collection_failure", bVar2);
        f20389r = new la("mediated_ad_requested", bVar2);
        f20390s = new la("mediated_ad_success", bVar2);
        f20391t = new la("mediated_ad_failure", bVar2);
        f20392u = new la("mediated_ad_load_started", bVar2);
        f20393v = new la("mediated_ad_load_success", bVar2);
        f20394w = new la("mediated_ad_load_failure", bVar2);
        f20395x = new la("waterfall_processing_complete", bVar2);
        f20396y = new la("mediated_ad_displayed", bVar2);
        f20397z = new la("mediated_ad_display_failure", bVar2);
        A = new la("mediated_ad_hidden", bVar2);
        B = new la("mediated_ad_hidden_callback_not_called", bVar2);
        C = new la("anr", bVar);
        D = new la("app_killed_during_ad", bVar);
        E = new la("auto_redirect", bVar);
        F = new la("black_view", bVar);
        G = new la("cache_error", bVar);
        H = new la("caught_exception", bVar);
        I = new la("consent_flow_error", bVar);
        J = new la(AppMeasurement.CRASH_ORIGIN, bVar);
        K = new la("file_error", bVar);
        L = new la("integration_error", bVar);
        M = new la("media_error", bVar);
        N = new la("native_error", bVar);
        O = new la("network_error", bVar);
        P = new la("task_exception", bVar);
        Q = new la("task_latency_alert", bVar);
        R = new la("template_error", bVar);
        S = new la("unexpected_state", bVar);
        T = new la("web_view_error", bVar);
    }

    public la(String str, b bVar) {
        this.f20398a = str;
        this.f20399b = bVar;
    }

    private double a(b bVar, com.applovin.impl.sdk.j jVar) {
        float fFloatValue;
        int i11 = a.f20400a[bVar.ordinal()];
        if (i11 == 1) {
            fFloatValue = ((Float) jVar.a(sj.M)).floatValue();
        } else if (i11 == 2) {
            fFloatValue = ((Float) jVar.a(sj.N)).floatValue();
        } else {
            if (i11 != 3) {
                return -1.0d;
            }
            fFloatValue = ((Float) jVar.a(sj.O)).floatValue();
        }
        return fFloatValue;
    }

    private double a(String str, com.applovin.impl.sdk.j jVar) {
        if (f20374c == null) {
            f20374c = JsonUtils.deserialize((String) jVar.a(sj.L));
        }
        Double d11 = JsonUtils.getDouble(f20374c, str, (Double) null);
        if (d11 != null) {
            return d11.doubleValue();
        }
        return -1.0d;
    }

    public double a(com.applovin.impl.sdk.j jVar) {
        if (yp.i(com.applovin.impl.sdk.j.l())) {
            return 100.0d;
        }
        double dA = a(this.f20398a, jVar);
        if (dA >= 0.0d) {
            return dA;
        }
        double dA2 = a(this.f20399b, jVar);
        return dA2 >= 0.0d ? dA2 : ((Float) jVar.a(sj.P)).floatValue();
    }

    public b a() {
        return this.f20399b;
    }

    public String b() {
        return this.f20398a;
    }
}
