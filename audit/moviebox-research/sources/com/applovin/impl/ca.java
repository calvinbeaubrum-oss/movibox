package com.applovin.impl;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ca {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set f18145b = new HashSet(32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set f18146c = new HashSet(16);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ca f18147d = a("ad_req");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ca f18148e = a("ad_imp");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ca f18149f = a("max_ad_imp");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ca f18150g = a("ad_session_start");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ca f18151h = a("ad_imp_session");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ca f18152i = a("max_ad_imp_session");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ca f18153j = a("cached_files_expired");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ca f18154k = a("cache_drop_count");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ca f18155l = a("sdk_reset_state_count", true);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ca f18156m = a("ad_response_process_failures", true);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ca f18157n = a("response_process_failures", true);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ca f18158o = a("incent_failed_to_display_count", true);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ca f18159p = a("app_paused_and_resumed");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ca f18160q = a("ad_rendered_with_mismatched_sdk_key", true);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ca f18161r = a("ad_shown_outside_app_count");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ca f18162s = a("med_ad_req");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ca f18163t = a("med_ad_response_process_failures", true);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ca f18164u = a("med_waterfall_ad_no_fill", true);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ca f18165v = a("med_waterfall_ad_adapter_load_failed", true);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ca f18166w = a("med_waterfall_ad_invalid_response", true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18167a;

    static {
        a("fullscreen_ad_nil_vc_count");
        a("applovin_bundle_missing");
    }

    private ca(String str) {
        this.f18167a = str;
    }

    private static ca a(String str) {
        return a(str, false);
    }

    private static ca a(String str, boolean z11) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No key name specified");
        }
        Set set = f18145b;
        if (set.contains(str)) {
            throw new IllegalArgumentException("Key has already been used: " + str);
        }
        set.add(str);
        ca caVar = new ca(str);
        if (z11) {
            f18146c.add(caVar);
        }
        return caVar;
    }

    public static Set a() {
        return f18146c;
    }

    public String b() {
        return this.f18167a;
    }
}
