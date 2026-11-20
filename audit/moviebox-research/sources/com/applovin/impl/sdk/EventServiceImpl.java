package com.applovin.impl.sdk;

import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.applovin.impl.jn;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.v7;
import com.applovin.impl.vi;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class EventServiceImpl implements AppLovinEventService {
    public static final List<String> ALLOW_PRE_INIT_EVENT_TYPES = Arrays.asList("landing", "paused", "resumed", "cf_start", "tos_ok", "gdpr_ok");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f22382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f22383b = new AtomicBoolean();

    public EventServiceImpl(j jVar) {
        this.f22382a = jVar;
    }

    private String a() {
        return ((String) this.f22382a.a(sj.S0)) + "4.0/pix";
    }

    private Map a(v7 v7Var, Map map) {
        Map map2 = CollectionUtils.map(map);
        boolean zContains = this.f22382a.c(sj.V0).contains(v7Var.c());
        map2.put("AppLovin-Event", zContains ? v7Var.c() : "postinstall");
        if (!zContains) {
            map2.put("AppLovin-Sub-Event", v7Var.c());
        }
        return map2;
    }

    private Map a(v7 v7Var, boolean z11) {
        boolean zContains = this.f22382a.c(sj.V0).contains(v7Var.c());
        Map mapA = this.f22382a.y().a(null, z11, false);
        mapA.put(NotificationCompat.CATEGORY_EVENT, zContains ? v7Var.c() : "postinstall");
        mapA.put("event_id", v7Var.b());
        mapA.put("ts", Long.toString(v7Var.a()));
        if (!zContains) {
            mapA.put("sub_event", v7Var.c());
        }
        return yp.a(mapA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(v7 v7Var, Map map, boolean z11) {
        Map mapA = a(v7Var, false);
        HashMap map2 = new HashMap(v7Var.d());
        if (((Boolean) this.f22382a.a(sj.f23114z5)).booleanValue() || ((Boolean) this.f22382a.a(sj.f23074u5)).booleanValue()) {
            map2.putAll(mapA);
            mapA = null;
        }
        this.f22382a.X().e(com.applovin.impl.sdk.network.d.b().d(b()).a(a()).b(mapA).c(map2).a(a(v7Var, map)).c(((Boolean) this.f22382a.a(sj.J5)).booleanValue()).a(((Boolean) this.f22382a.a(sj.f22970h5)).booleanValue()).d(z11).a(vi.a.a(((Integer) this.f22382a.a(sj.f23050r5)).intValue())).a());
    }

    private String b() {
        return ((String) this.f22382a.a(sj.R0)) + "4.0/pix";
    }

    public void maybeTrackAppOpenEvent() {
        if (this.f22383b.compareAndSet(false, true)) {
            this.f22382a.A().trackEvent("landing");
        }
    }

    public String toString() {
        return "EventService{}";
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackCheckout(String str, Map<String, String> map) {
        Map<String, String> map2 = CollectionUtils.map(map);
        map2.put(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, map2);
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackEvent(String str, Map<String, String> map) {
        trackEvent(str, map, null);
    }

    public void trackEvent(String str, Map<String, String> map, final Map<String, String> map2) {
        this.f22382a.J();
        if (n.a()) {
            this.f22382a.J().a("AppLovinEventService", "Tracking event: \"" + str + "\" with parameters: " + map);
        }
        final v7 v7Var = new v7(str, map);
        final boolean zContains = ALLOW_PRE_INIT_EVENT_TYPES.contains(str);
        try {
            this.f22382a.j0().a((yl) new jn(this.f22382a, zContains, "submitTrackEventPostback", new Runnable() { // from class: com.applovin.impl.sdk.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22873a.a(v7Var, map2, zContains);
                }
            }), tm.b.OTHER);
        } catch (Throwable th2) {
            this.f22382a.J();
            if (n.a()) {
                this.f22382a.J().a("AppLovinEventService", "Unable to track event: " + v7Var, th2);
            }
            this.f22382a.E().a("AppLovinEventService", "trackEvent", th2);
        }
    }

    public void trackEventSynchronously(String str) {
        this.f22382a.J();
        if (n.a()) {
            this.f22382a.J().a("AppLovinEventService", "Tracking event: \"" + str + "\" synchronously");
        }
        v7 v7Var = new v7(str, new HashMap());
        Map mapA = a(v7Var, true);
        HashMap map = new HashMap(v7Var.d());
        if (((Boolean) this.f22382a.a(sj.f23114z5)).booleanValue() || ((Boolean) this.f22382a.a(sj.f23074u5)).booleanValue()) {
            map.putAll(mapA);
            mapA = null;
        }
        this.f22382a.X().e(com.applovin.impl.sdk.network.d.b().d(b()).a(a()).b(mapA).c(map).a(a(v7Var, (Map) null)).c(((Boolean) this.f22382a.a(sj.J5)).booleanValue()).a(((Boolean) this.f22382a.a(sj.f22970h5)).booleanValue()).a());
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        Map<String, String> map2 = CollectionUtils.map(map);
        try {
            map2.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra("INAPP_PURCHASE_DATA"));
            map2.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        } catch (Throwable th2) {
            n.c("AppLovinEventService", "Unable to track in app purchase - invalid purchase intent", th2);
            this.f22382a.E().a("AppLovinEventService", "trackIAP", th2);
        }
        trackEvent(AppLovinEventTypes.USER_COMPLETED_IN_APP_PURCHASE, map2);
    }
}
