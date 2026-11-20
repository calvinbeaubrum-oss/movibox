package com.applovin.impl;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ve extends sj {
    public static final sj A7;
    public static final sj B7;
    public static final sj C7;
    public static final sj D7;
    public static final sj E7;
    public static final sj F7;
    public static final sj G6 = sj.a("afi", "");
    public static final sj G7;
    public static final sj H6;
    public static final sj H7;
    public static final sj I6;
    public static final sj I7;
    public static final sj J6;
    public static final sj J7;
    public static final sj K6;
    public static final sj K7;
    public static final sj L6;
    public static final sj L7;
    public static final sj M6;
    public static final sj M7;
    public static final sj N6;
    public static final sj N7;
    public static final sj O6;
    public static final sj O7;
    public static final sj P6;
    public static final sj P7;
    public static final sj Q6;
    public static final sj Q7;
    public static final sj R6;
    public static final sj R7;
    public static final sj S6;
    public static final sj S7;
    public static final sj T6;
    public static final sj T7;
    public static final sj U6;
    public static final sj V6;
    public static final sj W6;
    public static final sj X6;
    public static final sj Y6;
    public static final sj Z6;

    /* JADX INFO: renamed from: a7, reason: collision with root package name */
    public static final sj f23878a7;

    /* JADX INFO: renamed from: b7, reason: collision with root package name */
    public static final sj f23879b7;

    /* JADX INFO: renamed from: c7, reason: collision with root package name */
    public static final sj f23880c7;

    /* JADX INFO: renamed from: d7, reason: collision with root package name */
    public static final sj f23881d7;

    /* JADX INFO: renamed from: e7, reason: collision with root package name */
    public static final sj f23882e7;

    /* JADX INFO: renamed from: f7, reason: collision with root package name */
    public static final sj f23883f7;

    /* JADX INFO: renamed from: g7, reason: collision with root package name */
    public static final sj f23884g7;

    /* JADX INFO: renamed from: h7, reason: collision with root package name */
    public static final sj f23885h7;

    /* JADX INFO: renamed from: i7, reason: collision with root package name */
    public static final sj f23886i7;

    /* JADX INFO: renamed from: j7, reason: collision with root package name */
    public static final sj f23887j7;

    /* JADX INFO: renamed from: k7, reason: collision with root package name */
    public static final sj f23888k7;

    /* JADX INFO: renamed from: l7, reason: collision with root package name */
    public static final sj f23889l7;

    /* JADX INFO: renamed from: m7, reason: collision with root package name */
    public static final sj f23890m7;

    /* JADX INFO: renamed from: n7, reason: collision with root package name */
    public static final sj f23891n7;

    /* JADX INFO: renamed from: o7, reason: collision with root package name */
    public static final sj f23892o7;

    /* JADX INFO: renamed from: p7, reason: collision with root package name */
    public static final sj f23893p7;

    /* JADX INFO: renamed from: q7, reason: collision with root package name */
    public static final sj f23894q7;

    /* JADX INFO: renamed from: r7, reason: collision with root package name */
    public static final sj f23895r7;

    /* JADX INFO: renamed from: s7, reason: collision with root package name */
    public static final sj f23896s7;

    /* JADX INFO: renamed from: t7, reason: collision with root package name */
    public static final sj f23897t7;

    /* JADX INFO: renamed from: u7, reason: collision with root package name */
    public static final sj f23898u7;

    /* JADX INFO: renamed from: v7, reason: collision with root package name */
    public static final sj f23899v7;

    /* JADX INFO: renamed from: w7, reason: collision with root package name */
    public static final sj f23900w7;

    /* JADX INFO: renamed from: x7, reason: collision with root package name */
    public static final sj f23901x7;

    /* JADX INFO: renamed from: y7, reason: collision with root package name */
    public static final sj f23902y7;

    /* JADX INFO: renamed from: z7, reason: collision with root package name */
    public static final sj f23903z7;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        H6 = sj.a("afi_ms", Long.valueOf(timeUnit.toMillis(5L)));
        I6 = sj.a("mediation_endpoint", "https://ms.applovin.com/");
        J6 = sj.a("mediation_backup_endpoint", "https://ms.applvn.com/");
        K6 = sj.a("fetch_next_ad_retry_delay_ms", Long.valueOf(timeUnit.toMillis(2L)));
        L6 = sj.a("fetch_next_ad_timeout_ms", Long.valueOf(timeUnit.toMillis(30L)));
        M6 = sj.a("fetch_mediation_debugger_info_timeout_ms", Long.valueOf(timeUnit.toMillis(7L)));
        Boolean bool = Boolean.TRUE;
        N6 = sj.a("auto_init_mediation_debugger", bool);
        O6 = sj.a("postback_macros", "{\"{MCODE}\":\"mcode\",\"{BCODE}\":\"bcode\",\"{ICODE}\":\"icode\",\"{SCODE}\":\"scode\"}");
        P6 = sj.a("max_signal_provider_latency_ms", Long.valueOf(timeUnit.toMillis(30L)));
        Boolean bool2 = Boolean.FALSE;
        Q6 = sj.a("fix_signal_collection_timeout_signal_providers_count", bool2);
        R6 = sj.a("default_adapter_timeout_ms", Long.valueOf(timeUnit.toMillis(10L)));
        S6 = sj.a("ad_refresh_ms", Long.valueOf(timeUnit.toMillis(30L)));
        T6 = sj.a("ad_load_failure_refresh_ms", Long.valueOf(timeUnit.toMillis(30L)));
        U6 = sj.a("ad_load_failure_refresh_ignore_error_codes", "204");
        V6 = sj.a("refresh_ad_on_app_resume_elapsed_threshold_ms", 0L);
        W6 = sj.a("refresh_ad_view_timer_responds_to_background", bool);
        X6 = sj.a("refresh_ad_view_timer_responds_to_store_kit", bool);
        Y6 = sj.a("refresh_ad_view_timer_responds_to_window_visibility_changed", bool2);
        Z6 = sj.a("avrsponse", bool2);
        f23878a7 = sj.a("allow_pause_auto_refresh_immediately", bool2);
        f23879b7 = sj.a("fullscreen_display_delay_ms", 0L);
        f23880c7 = sj.a("susaode", bool2);
        f23881d7 = sj.a("ahdm", 500L);
        f23882e7 = sj.a("ad_view_refresh_precache_request_viewability_undesired_flags", 246L);
        f23883f7 = sj.a("ad_view_refresh_precache_request_enabled", bool);
        f23884g7 = sj.a("famttl_ms", 0L);
        f23885h7 = sj.a("signal_expiration_ms", -1L);
        f23886i7 = sj.a("signal_cache_level", Integer.valueOf(xj.b.AD_FORMAT.ordinal()));
        TimeUnit timeUnit2 = TimeUnit.HOURS;
        f23887j7 = sj.a("ad_expiration_ms", Long.valueOf(timeUnit2.toMillis(4L)));
        f23888k7 = sj.a("native_ad_expiration_ms", Long.valueOf(timeUnit2.toMillis(4L)));
        f23889l7 = sj.a("rena", bool);
        f23890m7 = sj.a("fullscreen_ad_displayed_timeout_ms", -1L);
        f23891n7 = sj.a("freast_ms", -1L);
        f23892o7 = sj.a("ad_hidden_timeout_ms", -1L);
        f23893p7 = sj.a("schedule_ad_hidden_on_ad_dismiss", bool2);
        f23894q7 = sj.a("schedule_ad_hidden_on_single_task_app_relaunch", bool2);
        f23895r7 = sj.a("ad_hidden_on_ad_dismiss_callback_delay_ms", Long.valueOf(timeUnit.toMillis(1L)));
        f23896s7 = sj.a("proe", bool2);
        f23897t7 = sj.a("mute_state", 2);
        f23898u7 = sj.a("saf", "");
        f23899v7 = sj.a("saui", "");
        f23900w7 = sj.a("mra", -1);
        f23901x7 = sj.a("mra_af", "INTER,REWARDED,REWARDED_INTER,BANNER,LEADER,MREC");
        f23902y7 = sj.a("svadfr", bool2);
        f23903z7 = sj.a("mwalra", -1);
        A7 = sj.a("walrad_ms", Long.valueOf(timeUnit.toMillis(1L)));
        B7 = sj.a("walriec", "");
        C7 = sj.a("fadiafase", bool);
        D7 = sj.a("fadwvcv", bool);
        E7 = sj.a("bfarud", bool2);
        F7 = sj.a("inacc", Boolean.valueOf(yp.b(Arrays.asList("com.textmeinc.textme", "com.textmeinc.freetone", "com.textmeinc.textme3", "com.jaumo", "com.jaumo.casual", "com.pinkapp", "com.jaumo.mature", "com.jaumo.prime", "com.jaumo.gay", "com.jaumo.lesbian"))));
        G7 = sj.a("pbataipaf", "");
        H7 = sj.a("bwt_ms", Long.valueOf(timeUnit.toMillis(30L)));
        I7 = sj.a("twt_ms", Long.valueOf(timeUnit.toMillis(30L)));
        J7 = sj.a("adiets_sec", Long.valueOf(TimeUnit.MINUTES.toSeconds(1L)));
        K7 = sj.a("faomq", bool2);
        L7 = sj.a("siflcfbt", bool2);
        M7 = sj.a("rahcnct_sec", -1);
        N7 = sj.a("uabta", bool2);
        O7 = sj.a("use_initialization_spec_during_init", bool2);
        P7 = sj.a("use_promises_during_init", bool2);
        Q7 = sj.a("report_cimp_after_ierr", bool2);
        R7 = sj.a("fail_collection_for_empty_signal", bool2);
        S7 = sj.a("fetch_mediated_ad_gzip", bool);
        T7 = sj.a("max_postback_gzip", bool);
    }
}
