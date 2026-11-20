package com.applovin.impl.sdk;

import android.os.Bundle;
import android.view.View;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.af;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.ge;
import com.applovin.impl.he;
import com.applovin.impl.ie;
import com.applovin.impl.io;
import com.applovin.impl.je;
import com.applovin.impl.ne;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.v3;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.zq;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements AppLovinCommunicatorSubscriber, AppLovinCommunicatorPublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f22529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppLovinCommunicator f22530b;

    public g(j jVar) {
        this.f22529a = jVar;
        AppLovinCommunicator appLovinCommunicator = AppLovinCommunicator.getInstance(j.l());
        this.f22530b = appLovinCommunicator;
        if (((Boolean) jVar.a(sj.E6)).booleanValue()) {
            appLovinCommunicator.a(jVar);
            appLovinCommunicator.subscribe(this, io.f19760a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00c3  */
    private Bundle a(ge geVar) {
        View viewR0;
        Bundle bundle = new Bundle();
        bundle.putString("id", geVar.T());
        bundle.putString("network_name", geVar.c());
        bundle.putString("max_ad_unit_id", geVar.getAdUnitId());
        bundle.putString("third_party_ad_placement_id", geVar.V());
        bundle.putString("ad_format", geVar.getFormat().getLabel());
        BundleUtils.putStringIfValid(CampaignEx.JSON_KEY_CREATIVE_ID, geVar.getCreativeId(), bundle);
        BundleUtils.putStringIfValid("adomain", geVar.w(), bundle);
        BundleUtils.putStringIfValid("dsp_name", geVar.getDspName(), bundle);
        if (geVar.b0()) {
            BundleUtils.putStringIfValid("hybrid_ad_format", geVar.J().getLabel(), bundle);
        }
        if (geVar.c0()) {
            bundle.putString("custom_js_network_name", geVar.getNetworkName());
        } else if ("CUSTOM_NETWORK_SDK".equalsIgnoreCase(geVar.c())) {
            bundle.putString("custom_sdk_network_name", geVar.getNetworkName());
        }
        bundle.putAll(JsonUtils.toBundle(geVar.y()));
        if (geVar instanceof ne) {
            if (geVar instanceof he) {
                viewR0 = ((he) geVar).z();
            } else if (geVar instanceof je) {
                je jeVar = (je) geVar;
                if (jeVar.x0()) {
                    viewR0 = null;
                } else {
                    viewR0 = jeVar.r0() != null ? jeVar.r0() : jeVar.s0();
                }
            } else {
                viewR0 = null;
            }
            bundle.putString("ad_view", viewR0 != null ? zq.a(viewR0) : "N/A");
        } else if (geVar instanceof ie) {
            Bundle bundle2 = ((ie) geVar).p0().getBundle("applovin_ad_view_info");
            bundle.putString("ad_view", BundleUtils.getString("ad_view_address", "N/A", bundle2));
            bundle.putString("video_view", BundleUtils.getString("video_view_address", "N/A", bundle2));
        }
        return bundle;
    }

    public void a() {
        if (((Boolean) this.f22529a.a(sj.E6)).booleanValue() && this.f22530b.hasSubscriber("privacy_setting_updated")) {
            a(new Bundle(), "privacy_setting_updated");
        }
    }

    public void a(Bundle bundle, String str) {
        if (((Boolean) this.f22529a.a(sj.E6)).booleanValue() && this.f22530b.hasSubscriber(str)) {
            this.f22530b.getMessagingService().publish(CommunicatorMessageImpl.create(bundle, str, this));
        }
    }

    public void a(ge geVar, String str) {
        if (((Boolean) this.f22529a.a(sj.E6)).booleanValue() && this.f22530b.hasSubscriber("ad_callback_blocked_after_hidden")) {
            Bundle bundleA = a(geVar);
            bundleA.putString("callback_name", str);
            a(bundleA, "ad_callback_blocked_after_hidden");
        }
    }

    public void a(MaxAdapter.InitializationStatus initializationStatus, String str) {
        if (((Boolean) this.f22529a.a(sj.E6)).booleanValue() && this.f22530b.hasSubscriber("adapter_initialization_status")) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter_class", str);
            bundle.putInt("init_status", initializationStatus.getCode());
            a(bundle, "adapter_initialization_status");
        }
    }

    public void a(String str, String str2) {
        if (((Boolean) this.f22529a.a(sj.E6)).booleanValue() && this.f22530b.hasSubscriber("network_sdk_version_updated")) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter_class", str2);
            bundle.putString("sdk_version", str);
            a(bundle, "network_sdk_version_updated");
        }
    }

    public void a(String str, String str2, int i11, Object obj, String str3, boolean z11) {
        if (((Boolean) this.f22529a.a(sj.E6)).booleanValue() && this.f22530b.hasSubscriber("receive_http_response")) {
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putString("url", str2);
            bundle.putInt(TrackingKey.CODE, i11);
            bundle.putBundle(TtmlNode.TAG_BODY, JsonUtils.toBundle(obj));
            bundle.putBoolean("success", z11);
            BundleUtils.putString(TrackingKey.ERROR_MESSAGE, str3, bundle);
            a(bundle, "receive_http_response");
        }
    }

    public void a(String str, String str2, String str3) {
        if (((Boolean) this.f22529a.a(sj.E6)).booleanValue() && this.f22530b.hasSubscriber("responses")) {
            String strMaybeConvertToIndentedString = JsonUtils.maybeConvertToIndentedString(str3, 2);
            String strMaybeConvertToIndentedString2 = JsonUtils.maybeConvertToIndentedString(str, 2);
            Bundle bundle = new Bundle();
            bundle.putString("request_url", str2);
            bundle.putString("request_body", strMaybeConvertToIndentedString);
            bundle.putString("response", strMaybeConvertToIndentedString2);
            a(bundle, "responses");
        }
    }

    public void a(List list) {
        if (((Boolean) this.f22529a.a(sj.E6)).booleanValue() && this.f22530b.hasSubscriber("live_networks_updated")) {
            if (list == null || list.isEmpty()) {
                a(Bundle.EMPTY, "live_networks_updated");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("live_networks", new ArrayList<>(list));
            a(bundle, "live_networks_updated");
        }
    }

    public void a(JSONObject jSONObject, boolean z11) {
        if (((Boolean) this.f22529a.a(sj.E6)).booleanValue() && this.f22530b.hasSubscriber("safedk_init")) {
            Bundle bundle = new Bundle();
            bundle.putString(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f22529a.b0());
            bundle.putString("applovin_random_token", this.f22529a.a0());
            bundle.putString("compass_random_token", this.f22529a.q());
            bundle.putString("device_type", AppLovinSdkUtils.isTablet(j.l()) ? "tablet" : "phone");
            bundle.putString("init_success", String.valueOf(z11));
            bundle.putParcelableArrayList("installed_mediation_adapters", JsonUtils.toBundle(af.a(this.f22529a)));
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "communicator_settings", (JSONObject) null);
            Bundle bundle2 = (Bundle) bundle.clone();
            bundle2.putString("user_id", this.f22529a.q0().c());
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, "safedk_settings", new JSONObject());
            if (!((Boolean) this.f22529a.a(sj.F6)).booleanValue()) {
                JSONObject jSONObject4 = new JSONObject();
                JsonUtils.putBoolean(jSONObject4, "deactivated", true);
                JsonUtils.putJSONObject(jSONObject3, "safeDKDeactivation", jSONObject4);
            }
            bundle2.putBundle("settings", JsonUtils.toBundle(jSONObject3));
            this.f22529a.J();
            if (n.a()) {
                this.f22529a.J().a("CommunicatorService", "Sending \"safedk_init\" message: " + bundle);
            }
            a(bundle2, "safedk_init");
        }
    }

    public boolean a(String str) {
        return io.f19760a.contains(str);
    }

    public void b(ge geVar) {
        if (((Boolean) this.f22529a.a(sj.E6)).booleanValue() && this.f22530b.hasSubscriber("max_revenue_events")) {
            Bundle bundleA = a(geVar);
            bundleA.putAll(JsonUtils.toBundle(geVar.S()));
            bundleA.putString("country_code", this.f22529a.r().getCountryCode());
            a(bundleA, "max_revenue_events");
        }
    }

    public void b(ge geVar, String str) {
        if (((Boolean) this.f22529a.a(sj.E6)).booleanValue() && this.f22530b.hasSubscriber("max_ad_events")) {
            Bundle bundleA = a(geVar);
            bundleA.putString("type", str);
            this.f22529a.J();
            if (n.a()) {
                this.f22529a.J().a("CommunicatorService", "Sending \"max_ad_events\" message: " + bundleA);
            }
            a(bundleA, "max_ad_events");
        }
    }

    public void b(String str, String str2) {
        if (((Boolean) this.f22529a.a(sj.E6)).booleanValue() && this.f22530b.hasSubscriber("user_info")) {
            Bundle bundle = new Bundle(2);
            bundle.putString("user_id", StringUtils.emptyIfNull(str));
            bundle.putString("applovin_random_token", str2);
            a(bundle, "user_info");
        }
    }

    public void b(List list) {
        if (((Boolean) this.f22529a.a(sj.E6)).booleanValue() && this.f22530b.hasSubscriber("test_mode_networks_updated")) {
            if (list == null || list.isEmpty()) {
                a(Bundle.EMPTY, "test_mode_networks_updated");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("test_mode_networks", new ArrayList<>(list));
            a(bundle, "test_mode_networks_updated");
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "applovin_sdk";
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        Map<String, Object> map;
        if (((Boolean) this.f22529a.a(sj.E6)).booleanValue()) {
            if ("send_http_request".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                Bundle messageData = appLovinCommunicatorMessage.getMessageData();
                Map<String, String> stringMap = BundleUtils.toStringMap(messageData.getBundle("query_params"));
                Map<String, Object> map2 = BundleUtils.toMap(messageData.getBundle("post_body"));
                Map<String, String> stringMap2 = BundleUtils.toStringMap(messageData.getBundle("headers"));
                String string = messageData.getString("id", "");
                if (!map2.containsKey(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY)) {
                    map2.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f22529a.b0());
                }
                this.f22529a.X().e(new com.applovin.impl.sdk.network.d.b().d(messageData.getString("url")).a(messageData.getString("backup_url")).b(stringMap).c(map2).a(stringMap2).a(((Boolean) this.f22529a.a(sj.f22970h5)).booleanValue()).b(string).a());
                return;
            }
            if (!"send_http_request_v2".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                if ("set_ad_request_query_params".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                    this.f22529a.i().addCustomQueryParams(yp.a((Map) BundleUtils.toMap(appLovinCommunicatorMessage.getMessageData())));
                    return;
                } else if ("set_ad_request_post_body".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                    this.f22529a.i().setCustomPostBody(BundleUtils.toJSONObject(appLovinCommunicatorMessage.getMessageData()));
                    return;
                } else {
                    if ("set_mediate_request_post_body_data".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                        this.f22529a.Q().setCustomPostBodyData(BundleUtils.toJSONObject(appLovinCommunicatorMessage.getMessageData()));
                        return;
                    }
                    return;
                }
            }
            Bundle messageData2 = appLovinCommunicatorMessage.getMessageData();
            String string2 = messageData2.getString("http_method", "POST");
            long millis = messageData2.containsKey("timeout_sec") ? TimeUnit.SECONDS.toMillis(messageData2.getLong("timeout_sec")) : ((Long) this.f22529a.a(sj.f23072u3)).longValue();
            int i11 = messageData2.getInt(PushConstants.SP_KEY_RETRY_COUNT, ((Integer) this.f22529a.a(sj.f23080v3)).intValue());
            long millis2 = messageData2.containsKey("retry_delay_sec") ? TimeUnit.SECONDS.toMillis(messageData2.getLong("retry_delay_sec")) : ((Long) this.f22529a.a(sj.f23088w3)).longValue();
            Map<String, String> stringMap3 = BundleUtils.toStringMap(messageData2.getBundle("query_params"));
            long j11 = millis2;
            if ("GET".equalsIgnoreCase(string2)) {
                if (messageData2.getBoolean("include_data_collector_info", true)) {
                    stringMap3.putAll(BundleUtils.toStringMap(CollectionUtils.toBundle(this.f22529a.y().a(null, false, false))));
                }
                millis = millis;
                i11 = i11;
                map = null;
            } else {
                map = BundleUtils.toMap(messageData2.getBundle("post_body"));
                if (messageData2.getBoolean("include_data_collector_info", true)) {
                    Map mapA = this.f22529a.y().A();
                    Map mapL = this.f22529a.y().l();
                    if (mapL.containsKey("idfv") && mapL.containsKey("idfv_scope")) {
                        String str = (String) mapL.get("idfv");
                        Integer num = (Integer) mapL.get("idfv_scope");
                        num.intValue();
                        mapL.remove("idfv");
                        mapL.remove("idfv_scope");
                        mapA.put("idfv", str);
                        mapA.put("idfv_scope", num);
                    }
                    mapA.put("server_installed_at", this.f22529a.a(sj.f23028p));
                    mapA.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f22529a.b0());
                    map.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, mapA);
                    map.put("device", mapL);
                } else {
                    millis = millis;
                    i11 = i11;
                }
            }
            this.f22529a.j0().a((yl) new v3(appLovinCommunicatorMessage.getPublisherId(), com.applovin.impl.sdk.network.a.a(this.f22529a).b(messageData2.getString("url")).a(messageData2.getString("backup_url")).b(stringMap3).c(string2).a((Map) BundleUtils.toStringMap(messageData2.getBundle("headers"))).a(map != null ? new JSONObject(map) : null).c((int) millis).a(i11).b((int) j11).a((Object) new JSONObject()).a(messageData2.getBoolean("is_encoding_enabled", false)).a(), this.f22529a), tm.b.OTHER);
        }
    }
}
