package com.applovin.impl.sdk.ad;

import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import com.applovin.impl.e5;
import com.applovin.impl.fh;
import com.applovin.impl.mg;
import com.applovin.impl.qq;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.sr;
import com.applovin.impl.tl;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends AppLovinAdImpl {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f22416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f22417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f22418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicReference f22419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Bundle f22420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private d f22421k;

    /* JADX INFO: renamed from: com.applovin.impl.sdk.ad.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public enum EnumC0200b {
        UNSPECIFIED,
        DISMISS,
        DO_NOT_DISMISS
    }

    /* JADX INFO: compiled from: source.java */
    public enum c {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    /* JADX INFO: compiled from: source.java */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f22430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f22431b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f22432c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f22433d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f22434e;

        private d() {
            this.f22430a = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.l(), b.this.m());
            this.f22431b = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.l(), b.this.o());
            this.f22432c = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.l(), b.this.k());
            this.f22433d = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.l(), ((Integer) ((AppLovinAdBase) b.this).sdk.a(sj.C1)).intValue());
            this.f22434e = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.l(), ((Integer) ((AppLovinAdBase) b.this).sdk.a(sj.B1)).intValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum e {
        RESIZE_ASPECT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public b(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jSONObject2, jVar);
        this.f22416f = CollectionUtils.synchronizedList();
        this.f22417g = new AtomicBoolean();
        this.f22418h = new AtomicBoolean();
        this.f22419i = new AtomicReference();
        this.f22420j = new Bundle();
    }

    private List J() {
        return getIntegerListFromAdObject("multi_close_style", null);
    }

    private com.applovin.impl.adview.e.a a(boolean z11) {
        return z11 ? com.applovin.impl.adview.e.a.WHITE_ON_TRANSPARENT : com.applovin.impl.adview.e.a.WHITE_ON_BLACK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(MotionEvent motionEvent, boolean z11, tl tlVar) {
        return yp.a(tlVar.a("video_click_tracking_urls", new JSONObject()), a(motionEvent, true, z11), null, Q(), R0(), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(MotionEvent motionEvent, boolean z11, boolean z12, tl tlVar) {
        return yp.a(tlVar.a("click_tracking_urls", new JSONObject()), a(motionEvent, z11, z12), c(motionEvent, z11, z12), Q(), R0(), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(tl tlVar) {
        return yp.a(tlVar.a("ad_closed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    private Map a(MotionEvent motionEvent, boolean z11, boolean z12) {
        Point pointB = z3.b(com.applovin.impl.sdk.j.l());
        HashMap map = new HashMap(7);
        map.put("{CLCODE}", getClCode());
        map.put("{CLICK_X}", String.valueOf(motionEvent != null ? motionEvent.getRawX() : -1.0f));
        map.put("{CLICK_Y}", String.valueOf(motionEvent != null ? motionEvent.getRawY() : -1.0f));
        map.put("{SCREEN_WIDTH}", String.valueOf(pointB.x));
        map.put("{SCREEN_HEIGHT}", String.valueOf(pointB.y));
        map.put("{IS_VIDEO_CLICK}", String.valueOf(z11));
        map.put("{IS_INSTALL}", String.valueOf(z12));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, tl tlVar) {
        JsonUtils.putString(tlVar.a("video_button_properties", (JSONObject) null), "video_button_html", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List b(tl tlVar) {
        return yp.a(tlVar.a("app_killed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    private String c(MotionEvent motionEvent, boolean z11, boolean z12) {
        String stringFromAdObject = getStringFromAdObject("click_tracking_url", null);
        Map mapA = a(motionEvent, z11, z12);
        if (stringFromAdObject != null) {
            return StringUtils.replace(stringFromAdObject, mapA);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map c(tl tlVar) {
        try {
            return JsonUtils.toStringMap(tlVar.a("custom_tabs_http_headers", new JSONObject()));
        } catch (JSONException e11) {
            this.sdk.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.sdk.J().a("DirectAd", "Failed to retrieve http headers for Custom Tabs", e11);
            }
            return new HashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List d(tl tlVar) {
        return yp.a(tlVar.a("custom_tabs_navigation_aborted_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List e(tl tlVar) {
        return yp.a(tlVar.a("custom_tabs_navigation_failed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List f(tl tlVar) {
        return yp.a(tlVar.a("custom_tabs_navigation_finished_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List g(tl tlVar) {
        return yp.a(tlVar.a("custom_tabs_navigation_started_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e5 h(tl tlVar) {
        JSONObject jSONObjectA = tlVar.a("custom_tabs_settings", (JSONObject) null);
        if (jSONObjectA != null) {
            return new e5(jSONObjectA);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List i(tl tlVar) {
        return yp.a(tlVar.a("custom_tabs_tab_hidden_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List j(tl tlVar) {
        return yp.a(tlVar.a("custom_tabs_tab_shown_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle k(tl tlVar) {
        return JsonUtils.toBundle(tlVar.a("ah_parameters", (JSONObject) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List l(tl tlVar) {
        return yp.a(tlVar.a("imp_urls", new JSONObject()), getClCode(), null, null, Q(), R0(), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$getOpenMeasurementVerificationScriptResources$1(JSONArray jSONArray) {
        if (jSONArray == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i11, (JSONObject) null);
            try {
                URL url = new URL(JsonUtils.getString(jSONObject, "url", null));
                String string = JsonUtils.getString(jSONObject, "vendor_key", null);
                String string2 = JsonUtils.getString(jSONObject, "parameters", null);
                if (StringUtils.isValidString(string) && StringUtils.isValidString(string2)) {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(string, url, string2));
                } else {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url));
                }
            } catch (Throwable th2) {
                this.sdk.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.sdk.J().a("DirectAd", "Failed to parse OMID verification script resource", th2);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getOpenMeasurementVerificationScriptResources$2(j1.a aVar, tl tlVar) {
        return (List) aVar.apply(tlVar.a("omid_verification_script_resources", (JSONArray) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map m(tl tlVar) {
        try {
            return JsonUtils.toStringMap(tlVar.a("http_headers_for_postbacks", new JSONObject()));
        } catch (JSONException e11) {
            throw new RuntimeException(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String n(tl tlVar) {
        return JsonUtils.getString(tlVar.a("video_button_properties", (JSONObject) null), "video_button_base_url", "/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String o(tl tlVar) {
        return JsonUtils.getString(tlVar.a("video_button_properties", (JSONObject) null), "video_button_html", "");
    }

    private String o0() {
        String stringFromAdObject = getStringFromAdObject("video_end_url", null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String p(tl tlVar) {
        return JsonUtils.getString(tlVar.a("video_button_properties", (JSONObject) null), "video_button_html_url", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qq q(tl tlVar) {
        return new qq(tlVar.a("video_button_properties", (JSONObject) null), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List r(tl tlVar) {
        return yp.a(tlVar.a("video_end_urls", new JSONObject()), getClCode(), o0(), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.applovin.impl.adview.m s(tl tlVar) {
        JSONObject jSONObjectA = tlVar.a("web_view_settings", (JSONObject) null);
        if (jSONObjectA != null) {
            return new com.applovin.impl.adview.m(jSONObjectA);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean t(tl tlVar) {
        return JsonUtils.getBoolean(tlVar.a("video_button_properties", (JSONObject) null), "should_cache_video_button_html_assets", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean u(tl tlVar) {
        return JsonUtils.getBoolean(tlVar.a("video_button_properties", (JSONObject) null), "should_cache_video_button_html_url_contents", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean v(tl tlVar) {
        return JsonUtils.getBoolean(tlVar.a("video_button_properties", (JSONObject) null), "should_respect_whitelist_when_retrieving_video_button_html_from_url", Boolean.FALSE);
    }

    public List A() {
        return getStringListFromAdObject("custom_tabs_warmup_urls", Collections.emptyList());
    }

    public boolean A0() {
        return getBooleanFromAdObject("custom_tabs_enabled", Boolean.FALSE);
    }

    public boolean B() {
        return getBooleanFromAdObject("dismiss_on_skip", Boolean.FALSE);
    }

    public boolean B0() {
        return getBooleanFromAdObject("forward_lifecycle_events_to_webview", Boolean.FALSE);
    }

    public int C() {
        return getIntFromAdObject("poststitial_dismiss_forward_delay_millis", -1);
    }

    public boolean C0() {
        return getBooleanFromAdObject("gase", Boolean.FALSE);
    }

    public int D() {
        return getIntFromAdObject("poststitial_shown_forward_delay_millis", -1);
    }

    public boolean D0() {
        return getBooleanFromAdObject("lock_current_orientation", Boolean.FALSE);
    }

    public int E() {
        return yp.a(getIntFromAdObject("graphic_completion_percent", -1), 90);
    }

    public AtomicBoolean E0() {
        return this.f22417g;
    }

    public List F() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.s
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f22463a.l((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("imp_urls", new JSONObject()), getClCode(), null, null, Q(), R0(), this.sdk);
        }
        return listA;
    }

    public boolean F0() {
        return getBooleanFromAdObject("lhs_skip_button", (Boolean) this.sdk.a(sj.f23047r2));
    }

    public boolean G() {
        return getBooleanFromAdObject("playback_requires_user_action", Boolean.TRUE);
    }

    public boolean G0() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE);
    }

    public String H() {
        return getStringFromFullResponse("event_id", null);
    }

    public abstract boolean H0();

    public List I() {
        List listJ = J();
        if (listJ == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(listJ.size());
        Iterator it = listJ.iterator();
        while (it.hasNext()) {
            arrayList.add(a(((Integer) it.next()).intValue()));
        }
        return arrayList;
    }

    public boolean I0() {
        return getBooleanFromAdObject("web_contents_debugging_enabled", Boolean.valueOf(yp.h(com.applovin.impl.sdk.j.l()) || yp.f(com.applovin.impl.sdk.j.l()) || ((Boolean) this.sdk.a(sj.f22995k6)).booleanValue()));
    }

    public boolean J0() {
        return getBooleanFromAdObject("web_video", Boolean.FALSE);
    }

    public List K() {
        return getIntegerListFromAdObject("multi_close_delay_graphic", null);
    }

    public abstract void K0();

    public Uri L() {
        String stringFromAdObject = getStringFromAdObject("mute_image", "https://assets.applovin.com/sound_off.png");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public boolean L0() {
        return getBooleanFromAdObject("should_apply_mute_setting_to_poststitial", Boolean.FALSE);
    }

    public String M() {
        return getStringFromAdObject("nia_button_title", "");
    }

    public boolean M0() {
        return getBooleanFromAdObject("should_apply_web_view_settings_to_web_view_button", (Boolean) this.sdk.a(sj.f23027o6));
    }

    public String N() {
        return getStringFromAdObject("nia_message", "");
    }

    public boolean N0() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? ((Boolean) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.m
            @Override // j1.a
            public final Object apply(Object obj) {
                return b.t((tl) obj);
            }
        })).booleanValue() : JsonUtils.getBoolean(getJsonObjectFromAdObject("video_button_properties", null), "should_cache_video_button_html_assets", Boolean.FALSE).booleanValue();
    }

    public String O() {
        return getStringFromAdObject("nia_title", "");
    }

    public boolean O0() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? ((Boolean) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.n
            @Override // j1.a
            public final Object apply(Object obj) {
                return b.u((tl) obj);
            }
        })).booleanValue() : JsonUtils.getBoolean(getJsonObjectFromAdObject("video_button_properties", null), "should_cache_video_button_html_url_contents", Boolean.FALSE).booleanValue();
    }

    public abstract String P();

    public boolean P0() {
        return this.f22418h.get();
    }

    public Map Q() {
        HashMap map = new HashMap();
        try {
            tl tlVar = this.synchronizedAdObject;
            map.putAll(tlVar != null ? (Map) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.t
                @Override // j1.a
                public final Object apply(Object obj) {
                    return b.m((tl) obj);
                }
            }) : JsonUtils.toStringMap(getJsonObjectFromAdObject("http_headers_for_postbacks", new JSONObject())));
        } catch (JSONException e11) {
            this.sdk.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.sdk.J().a("DirectAd", "Failed to retrieve http headers for postbacks", e11);
            }
        }
        if (getBooleanFromAdObject("use_webview_ua_for_postbacks", Boolean.FALSE)) {
            map.put("User-Agent", sr.a());
        }
        return map;
    }

    public boolean Q0() {
        return getBooleanFromAdObject("custom_tabs_should_track_events", Boolean.FALSE);
    }

    public EnumC0200b R() {
        String stringFromAdObject = getStringFromAdObject("poststitial_dismiss_type", null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            if ("dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return EnumC0200b.DISMISS;
            }
            if ("no_dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return EnumC0200b.DO_NOT_DISMISS;
            }
        }
        return EnumC0200b.UNSPECIFIED;
    }

    public boolean R0() {
        return getBooleanFromAdObject("fire_postbacks_from_webview", Boolean.FALSE);
    }

    public int S() {
        return getColorFromAdObject("postitial_progress_bar_color", -922746881);
    }

    public boolean S0() {
        return getBooleanFromAdObject("should_forward_close_button_tapped_to_poststitial", Boolean.FALSE);
    }

    public long T() {
        return getLongFromAdObject("postitial_progress_bar_total_ms", -1L);
    }

    public boolean T0() {
        return getBooleanFromAdObject("fmsstwvoar", Boolean.FALSE);
    }

    public long U() {
        long longFromAdObject = getLongFromAdObject("report_reward_duration", -1L);
        if (longFromAdObject >= 0) {
            return TimeUnit.SECONDS.toMillis(longFromAdObject);
        }
        return -1L;
    }

    public boolean U0() {
        return getBooleanFromAdObject("avoms", Boolean.FALSE);
    }

    public int V() {
        return getIntFromAdObject("report_reward_percent", -1);
    }

    public boolean V0() {
        return getBooleanFromAdObject("report_reward_percent_include_close_delay", Boolean.TRUE);
    }

    public List W() {
        String stringFromAdObject = getStringFromAdObject("required_html_resources", null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : Collections.emptyList();
    }

    public boolean W0() {
        return getBooleanFromAdObject("require_interaction_for_click", Boolean.FALSE);
    }

    public List X() {
        String stringFromAdObject = getStringFromAdObject("resource_cache_prefix", null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : this.sdk.c(sj.f22912a1);
    }

    public boolean X0() {
        return getBooleanFromAdObject("sruifwvc", Boolean.FALSE);
    }

    public String Y() {
        return getStringFromAdObject("text_rewarded_inter_alert_body", "");
    }

    public boolean Y0() {
        return getBooleanFromAdObject("respect_adview_fully_watched", Boolean.FALSE);
    }

    public String Z() {
        return getStringFromAdObject("text_rewarded_inter_alert_ok_action", "OK!");
    }

    public boolean Z0() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? ((Boolean) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.v
            @Override // j1.a
            public final Object apply(Object obj) {
                return b.v((tl) obj);
            }
        })).booleanValue() : JsonUtils.getBoolean(getJsonObjectFromAdObject("video_button_properties", null), "should_respect_whitelist_when_retrieving_video_button_html_from_url", Boolean.FALSE).booleanValue();
    }

    public com.applovin.impl.adview.e.a a(int i11) {
        if (i11 == 1) {
            return com.applovin.impl.adview.e.a.WHITE_ON_TRANSPARENT;
        }
        if (i11 == 2) {
            return com.applovin.impl.adview.e.a.INVISIBLE;
        }
        return i11 == 3 ? com.applovin.impl.adview.e.a.TRANSPARENT_SKIP : com.applovin.impl.adview.e.a.WHITE_ON_BLACK;
    }

    public List a(final MotionEvent motionEvent, final boolean z11) {
        List listA;
        List list;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            list = (List) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.c0
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f22445a.a(motionEvent, z11, (tl) obj);
                }
            });
        } else {
            synchronized (this.adObjectLock) {
                listA = yp.a(getJsonObjectFromAdObject("video_click_tracking_urls", new JSONObject()), a(motionEvent, true, z11), null, Q(), R0(), this.sdk);
            }
            list = listA;
        }
        return list.isEmpty() ? b(motionEvent, true, z11) : list;
    }

    public void a(Uri uri) {
        this.f22416f.add(uri);
    }

    public void a(fh fhVar) {
        this.f22419i.set(fhVar);
    }

    public void a(final String str) {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.a(new androidx.core.util.a() { // from class: com.applovin.impl.sdk.ad.l
                @Override // androidx.core.util.a
                public final void accept(Object obj) {
                    b.a(str, (tl) obj);
                }
            });
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_html", str);
        }
    }

    public String a0() {
        return getStringFromAdObject("text_rewarded_inter_alert_title", "Watch a video to earn a reward!");
    }

    public boolean a1() {
        return getBooleanFromAdObject("show_nia", Boolean.FALSE);
    }

    public List b(final MotionEvent motionEvent, final boolean z11, final boolean z12) {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.f0
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f22453a.a(motionEvent, z11, z12, (tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("click_tracking_urls", new JSONObject()), a(motionEvent, z11, z12), c(motionEvent, z11, z12), Q(), R0(), this.sdk);
        }
        return listA;
    }

    public void b() {
        this.f22418h.set(true);
    }

    public void b(Uri uri) {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.b("mute_image", uri.toString());
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "mute_image", uri.toString());
        }
    }

    public void b(boolean z11) {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.a("html_resources_cached", z11);
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putBoolean(this.adObject, "html_resources_cached", z11);
        }
    }

    public com.applovin.impl.adview.e.a b0() {
        int intFromAdObject = getIntFromAdObject("skip_style", -1);
        return intFromAdObject == -1 ? n() : a(intFromAdObject);
    }

    public boolean b1() {
        return getBooleanFromAdObject("show_rewarded_interstitial_overlay_alert", Boolean.valueOf(AppLovinAdType.AUTO_INCENTIVIZED == getType()));
    }

    public List c() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.i
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f22458a.a((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("ad_closed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public void c(Uri uri) {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.b("unmute_image", uri.toString());
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "unmute_image", uri.toString());
        }
    }

    public List c0() {
        return getStringListFromAdObject("substrings_for_disabled_click_logic", Collections.emptyList());
    }

    public boolean c1() {
        return getBooleanFromAdObject("sscomt", Boolean.FALSE);
    }

    public long d() {
        return getLongFromAdObject("ad_reshow_delay_on_app_launch_ms", -1L);
    }

    public List d(MotionEvent motionEvent, boolean z11, boolean z12) {
        List<String> stringListFromAdObject = getStringListFromAdObject("privacy_sandbox_click_attribution_urls", Collections.emptyList());
        if (stringListFromAdObject.isEmpty()) {
            return stringListFromAdObject;
        }
        Map mapA = a(motionEvent, z11, z12);
        ArrayList arrayList = new ArrayList(stringListFromAdObject.size());
        Iterator<String> it = stringListFromAdObject.iterator();
        while (it.hasNext()) {
            arrayList.add(StringUtils.replace(it.next(), mapA));
        }
        return arrayList;
    }

    public c d0() {
        c cVar = c.DEFAULT;
        String upperCase = getStringFromAdObject("ad_target", cVar.toString()).toUpperCase(Locale.ENGLISH);
        if ("ACTIVITY_PORTRAIT".equalsIgnoreCase(upperCase)) {
            return c.ACTIVITY_PORTRAIT;
        }
        return "ACTIVITY_LANDSCAPE".equalsIgnoreCase(upperCase) ? c.ACTIVITY_LANDSCAPE : cVar;
    }

    public boolean d1() {
        return getBooleanFromAdObject("track_auto_redirects", Boolean.FALSE);
    }

    public Bundle e() {
        return this.f22420j;
    }

    public Uri e0() {
        String stringFromAdObject = getStringFromAdObject("unmute_image", "https://assets.applovin.com/sound_on.png");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public boolean e1() {
        String str = this.sdk.g0().getExtraParameters().get("should_use_exoplayer_if_available");
        return StringUtils.isValidString(str) ? Boolean.parseBoolean(str) : getBooleanFromAdObject("suep", Boolean.FALSE);
    }

    public fh f() {
        return (fh) this.f22419i.getAndSet(null);
    }

    public String f0() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? (String) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.o
            @Override // j1.a
            public final Object apply(Object obj) {
                return b.n((tl) obj);
            }
        }) : JsonUtils.getString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_base_url", "/");
    }

    public boolean f1() {
        return getBooleanFromAdObject("upiosp", Boolean.FALSE);
    }

    public List g() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.p
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f22461a.b((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("app_killed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public String g0() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? (String) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.e0
            @Override // j1.a
            public final Object apply(Object obj) {
                return b.o((tl) obj);
            }
        }) : JsonUtils.getString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_html", "");
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.lg
    public abstract mg getAdEventTracker();

    public String getCachePrefix() {
        return getStringFromAdObject("cache_prefix", null);
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public Bundle getDirectDownloadParameters() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? (Bundle) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.g
            @Override // j1.a
            public final Object apply(Object obj) {
                return b.k((tl) obj);
            }
        }) : JsonUtils.toBundle(getJsonObjectFromAdObject("ah_parameters", null));
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public String getDirectDownloadToken() {
        return getStringFromAdObject("ah_dd_token", null);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.lg
    public String getOpenMeasurementContentUrl() {
        return getStringFromAdObject("omid_content_url", null);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.lg
    public String getOpenMeasurementCustomReferenceData() {
        return getStringFromAdObject("omid_custom_ref_data", "");
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.lg
    public List getOpenMeasurementVerificationScriptResources() {
        List list;
        final j1.a aVar = new j1.a() { // from class: com.applovin.impl.sdk.ad.f
            @Override // j1.a
            public final Object apply(Object obj) {
                return this.f22452a.lambda$getOpenMeasurementVerificationScriptResources$1((JSONArray) obj);
            }
        };
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.q
                @Override // j1.a
                public final Object apply(Object obj) {
                    return b.lambda$getOpenMeasurementVerificationScriptResources$2(aVar, (tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            list = (List) aVar.apply(getJsonArrayFromAdObject("omid_verification_script_resources", null));
        }
        return list;
    }

    public List getPrivacySandboxImpressionAttributionUrls() {
        List<String> stringListFromAdObject = getStringListFromAdObject("privacy_sandbox_impression_attribution_urls", Collections.emptyList());
        if (stringListFromAdObject.isEmpty()) {
            return stringListFromAdObject;
        }
        ArrayList arrayList = new ArrayList(stringListFromAdObject.size());
        String clCode = getClCode();
        Iterator<String> it = stringListFromAdObject.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().replace("{CLCODE}", clCode));
        }
        return arrayList;
    }

    public String h() {
        String stringFromAdObject = getStringFromAdObject("base_url", "/");
        if ("null".equalsIgnoreCase(stringFromAdObject)) {
            return null;
        }
        return stringFromAdObject;
    }

    public String h0() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? (String) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.r
            @Override // j1.a
            public final Object apply(Object obj) {
                return b.p((tl) obj);
            }
        }) : JsonUtils.getString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_html_url", "");
    }

    public List i() {
        return this.f22416f;
    }

    public qq i0() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? (qq) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.d0
            @Override // j1.a
            public final Object apply(Object obj) {
                return this.f22450a.q((tl) obj);
            }
        }) : new qq(getJsonObjectFromAdObject("video_button_properties", null), this.sdk);
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public boolean isDirectDownloadEnabled() {
        return StringUtils.isValidString(getDirectDownloadToken());
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.lg
    public abstract boolean isOpenMeasurementEnabled();

    public abstract Uri j();

    public abstract Uri j0();

    public int k() {
        return getIntFromAdObject("close_button_horizontal_margin", ((Integer) this.sdk.a(sj.f22951f2)).intValue());
    }

    public long k0() {
        return getLongFromAdObject("close_delay", 0L);
    }

    public d l() {
        if (this.f22421k == null) {
            this.f22421k = new d();
        }
        return this.f22421k;
    }

    public long l0() {
        return TimeUnit.SECONDS.toMillis(getLongFromAdObject("close_delay_max_buffering_time_seconds", 5L));
    }

    public int m() {
        return getIntFromAdObject("close_button_size", ((Integer) this.sdk.a(sj.f22959g2)).intValue());
    }

    public int m0() {
        return yp.a(getIntFromAdObject("video_completion_percent", -1));
    }

    public com.applovin.impl.adview.e.a n() {
        List listJ = J();
        int intFromAdObject = getIntFromAdObject("close_style", (listJ == null || listJ.size() <= 0) ? -1 : ((Integer) listJ.get(0)).intValue());
        return intFromAdObject == -1 ? a(hasVideoUrl()) : a(intFromAdObject);
    }

    public List n0() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.z
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f22467a.r((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("video_end_urls", new JSONObject()), getClCode(), o0(), this.sdk);
        }
        return listA;
    }

    public int o() {
        return getIntFromAdObject("close_button_top_margin", ((Integer) this.sdk.a(sj.f22967h2)).intValue());
    }

    public long p() {
        List listK = K();
        long longFromAdObject = getLongFromAdObject("close_delay_graphic", (listK == null || listK.size() <= 0) ? 0L : ((Integer) listK.get(0)).intValue());
        if (longFromAdObject == -1 || longFromAdObject == -2) {
            return 0L;
        }
        return longFromAdObject;
    }

    public e p0() {
        String stringFromAdObject = getStringFromAdObject("video_gravity", null);
        if ("top".equals(stringFromAdObject)) {
            return e.TOP;
        }
        if ("bottom".equals(stringFromAdObject)) {
            return e.BOTTOM;
        }
        if (TtmlNode.LEFT.equals(stringFromAdObject)) {
            return e.LEFT;
        }
        return TtmlNode.RIGHT.equals(stringFromAdObject) ? e.RIGHT : e.RESIZE_ASPECT;
    }

    public int q() {
        return getColorFromAdObject("countdown_color", -922746881);
    }

    public int q0() {
        return getColorFromAdObject("progress_bar_color", -922746881);
    }

    public int r() {
        return getIntFromAdObject("countdown_length", 0);
    }

    public boolean r0() {
        return getBooleanFromAdObject("progress_bar_enabled", Boolean.FALSE);
    }

    public Bundle s() {
        Map map;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            map = (Map) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.a0
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f22415a.c((tl) obj);
                }
            });
        } else {
            try {
                map = JsonUtils.toStringMap(getJsonObjectFromAdObject("custom_tabs_http_headers", new JSONObject()));
            } catch (JSONException e11) {
                this.sdk.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.sdk.J().a("DirectAd", "Failed to retrieve http headers for Custom Tabs", e11);
                }
                map = new HashMap();
            }
        }
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        if (getBooleanFromAdObject("custom_tabs_should_use_webview_ua", Boolean.FALSE)) {
            bundle.putString("User-Agent", sr.a());
        }
        return bundle;
    }

    public abstract Uri s0();

    public List t() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.h
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f22457a.d((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("custom_tabs_navigation_aborted_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public int t0() {
        int i11;
        if (yp.a(getSize())) {
            i11 = 1;
        } else {
            i11 = ((Boolean) this.sdk.a(sj.Q5)).booleanValue() ? 0 : -1;
        }
        return getIntFromAdObject("whalt", i11);
    }

    public List u() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.b0
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f22442a.e((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("custom_tabs_navigation_failed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public com.applovin.impl.adview.m u0() {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (com.applovin.impl.adview.m) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.k
                @Override // j1.a
                public final Object apply(Object obj) {
                    return b.s((tl) obj);
                }
            });
        }
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("web_view_settings", null);
        if (jsonObjectFromAdObject != null) {
            return new com.applovin.impl.adview.m(jsonObjectFromAdObject);
        }
        return null;
    }

    public List v() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.w
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f22465a.f((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("custom_tabs_navigation_finished_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List v0() {
        return CollectionUtils.explode(getStringFromAdObject("wlh", null));
    }

    public List w() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.j
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f22459a.g((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("custom_tabs_navigation_started_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List w0() {
        return CollectionUtils.explode(getStringFromAdObject("wls", ""));
    }

    public e5 x() {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (e5) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.y
                @Override // j1.a
                public final Object apply(Object obj) {
                    return b.h((tl) obj);
                }
            });
        }
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("custom_tabs_settings", null);
        if (jsonObjectFromAdObject != null) {
            return new e5(jsonObjectFromAdObject);
        }
        return null;
    }

    public boolean x0() {
        return getBooleanFromAdObject("bvde", (Boolean) this.sdk.a(sj.W5));
    }

    public List y() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.u
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f22464a.i((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("custom_tabs_tab_hidden_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public boolean y0() {
        return getBooleanFromAdObject("lhs_close_button", (Boolean) this.sdk.a(sj.f22943e2));
    }

    public List z() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new j1.a() { // from class: com.applovin.impl.sdk.ad.x
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f22466a.j((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("custom_tabs_tab_shown_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public boolean z0() {
        return getBooleanFromAdObject("custom_tabs_client_warmup_enabled", Boolean.FALSE);
    }
}
