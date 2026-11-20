package com.vungle.warren.model;

import android.content.ContentValues;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.push.PushConstants;
import com.vungle.warren.AdConfig;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class AdvertisementDBAdapter implements com.vungle.warren.persistence.c<c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Type f62100f = new TypeToken<List<c.a>>() { // from class: com.vungle.warren.model.AdvertisementDBAdapter.3
    }.getType();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Type f62101g = new TypeToken<Map<String, ArrayList<String>>>() { // from class: com.vungle.warren.model.AdvertisementDBAdapter.4
    }.getType();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Gson f62102a = new GsonBuilder().create();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Type f62103b = new TypeToken<String[]>() { // from class: com.vungle.warren.model.AdvertisementDBAdapter.1
    }.getType();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Type f62104c = new TypeToken<Map<String, String>>() { // from class: com.vungle.warren.model.AdvertisementDBAdapter.2
    }.getType();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Type f62105d = new TypeToken<Map<String, Pair<String, String>>>() { // from class: com.vungle.warren.model.AdvertisementDBAdapter.5
    }.getType();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Type f62106e = new TypeToken<List<String>>() { // from class: com.vungle.warren.model.AdvertisementDBAdapter.6
    }.getType();

    @Override // com.vungle.warren.persistence.c
    public String b() {
        return "advertisement";
    }

    @Override // com.vungle.warren.persistence.c
    @NonNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public c c(ContentValues contentValues) {
        c cVar = new c();
        cVar.f62137c = contentValues.getAsString("item_id");
        cVar.f62136b = contentValues.getAsInteger("ad_type").intValue();
        cVar.f62139f = contentValues.getAsLong("expire_time").longValue();
        cVar.f62142i = contentValues.getAsInteger("delay").intValue();
        cVar.f62144k = contentValues.getAsInteger("show_close_delay").intValue();
        cVar.f62145l = contentValues.getAsInteger("show_close_incentivized").intValue();
        cVar.f62146m = contentValues.getAsInteger("countdown").intValue();
        cVar.f62148o = contentValues.getAsInteger("video_width").intValue();
        cVar.f62149p = contentValues.getAsInteger("video_height").intValue();
        cVar.f62157x = contentValues.getAsInteger(PushConstants.SP_KEY_RETRY_COUNT).intValue();
        cVar.J = com.vungle.warren.persistence.b.a(contentValues, "requires_non_market_install");
        cVar.f62138d = contentValues.getAsString("app_id");
        cVar.f62143j = contentValues.getAsString("campaign");
        cVar.f62147n = contentValues.getAsString(CampaignEx.JSON_KEY_VIDEO_URL);
        cVar.f62150q = contentValues.getAsString("md5");
        cVar.f62151r = contentValues.getAsString("postroll_bundle_url");
        cVar.f62154u = contentValues.getAsString("cta_destination_url");
        cVar.f62155v = contentValues.getAsString("cta_url");
        cVar.f62158y = contentValues.getAsString("ad_token");
        cVar.f62159z = contentValues.getAsString("video_identifier");
        cVar.A = contentValues.getAsString("template_url");
        cVar.F = contentValues.getAsString("TEMPLATE_ID");
        cVar.G = contentValues.getAsString("TEMPLATE_TYPE");
        cVar.K = contentValues.getAsString("ad_market_id");
        cVar.L = contentValues.getAsString("bid_token");
        cVar.N = contentValues.getAsInteger("state").intValue();
        cVar.O = contentValues.getAsString("placement_id");
        cVar.f62152s = com.vungle.warren.persistence.b.a(contentValues, "cta_overlay_enabled");
        cVar.f62153t = com.vungle.warren.persistence.b.a(contentValues, "cta_click_area");
        cVar.f62156w = (AdConfig) this.f62102a.fromJson(contentValues.getAsString("ad_config"), AdConfig.class);
        cVar.f62140g = (List) this.f62102a.fromJson(contentValues.getAsString("checkpoints"), f62100f);
        cVar.f62141h = (Map) this.f62102a.fromJson(contentValues.getAsString("dynamic_events_and_urls"), f62101g);
        cVar.B = (Map) this.f62102a.fromJson(contentValues.getAsString("template_settings"), this.f62104c);
        cVar.C = (Map) this.f62102a.fromJson(contentValues.getAsString("mraid_files"), this.f62104c);
        cVar.D = (Map) this.f62102a.fromJson(contentValues.getAsString("cacheable_assets"), this.f62105d);
        cVar.P = contentValues.getAsLong("tt_download").longValue();
        cVar.R = contentValues.getAsLong("asset_download_timestamp").longValue();
        cVar.S = contentValues.getAsLong("asset_download_duration").longValue();
        cVar.T = contentValues.getAsLong("ad_request_start_time").longValue();
        cVar.H = com.vungle.warren.persistence.b.a(contentValues, "column_enable_om_sdk");
        cVar.g0((List) this.f62102a.fromJson(contentValues.getAsString("column_notifications"), this.f62106e));
        cVar.I = contentValues.getAsString("column_om_sdk_extra_vast");
        cVar.U = contentValues.getAsLong("column_request_timestamp").longValue();
        cVar.V = contentValues.getAsBoolean("column_click_coordinates_enabled").booleanValue();
        cVar.W = com.vungle.warren.persistence.b.a(contentValues, "column_assets_fully_downloaded");
        cVar.Q = contentValues.getAsString("column_deep_link");
        cVar.M = contentValues.getAsBoolean("column_header_bidding").booleanValue();
        return cVar;
    }

    @Override // com.vungle.warren.persistence.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ContentValues a(c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", cVar.f62137c);
        contentValues.put("ad_type", Integer.valueOf(cVar.h()));
        contentValues.put("expire_time", Long.valueOf(cVar.f62139f));
        contentValues.put("delay", Integer.valueOf(cVar.f62142i));
        contentValues.put("show_close_delay", Integer.valueOf(cVar.f62144k));
        contentValues.put("show_close_incentivized", Integer.valueOf(cVar.f62145l));
        contentValues.put("countdown", Integer.valueOf(cVar.f62146m));
        contentValues.put("video_width", Integer.valueOf(cVar.f62148o));
        contentValues.put("video_height", Integer.valueOf(cVar.f62149p));
        contentValues.put("cta_overlay_enabled", Boolean.valueOf(cVar.f62152s));
        contentValues.put("cta_click_area", Boolean.valueOf(cVar.f62153t));
        contentValues.put(PushConstants.SP_KEY_RETRY_COUNT, Integer.valueOf(cVar.f62157x));
        contentValues.put("requires_non_market_install", Boolean.valueOf(cVar.J));
        contentValues.put("app_id", cVar.f62138d);
        contentValues.put("campaign", cVar.f62143j);
        contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, cVar.f62147n);
        contentValues.put("md5", cVar.f62150q);
        contentValues.put("postroll_bundle_url", cVar.f62151r);
        contentValues.put("cta_destination_url", cVar.f62154u);
        contentValues.put("cta_url", cVar.f62155v);
        contentValues.put("ad_token", cVar.f62158y);
        contentValues.put("video_identifier", cVar.f62159z);
        contentValues.put("template_url", cVar.A);
        contentValues.put("TEMPLATE_ID", cVar.F);
        contentValues.put("TEMPLATE_TYPE", cVar.G);
        contentValues.put("ad_market_id", cVar.K);
        contentValues.put("bid_token", cVar.L);
        contentValues.put("state", Integer.valueOf(cVar.N));
        contentValues.put("placement_id", cVar.O);
        contentValues.put("ad_config", this.f62102a.toJson(cVar.f62156w));
        contentValues.put("checkpoints", this.f62102a.toJson(cVar.f62140g, f62100f));
        contentValues.put("dynamic_events_and_urls", this.f62102a.toJson(cVar.f62141h, f62101g));
        contentValues.put("template_settings", this.f62102a.toJson(cVar.B, this.f62104c));
        contentValues.put("mraid_files", this.f62102a.toJson(cVar.C, this.f62104c));
        contentValues.put("cacheable_assets", this.f62102a.toJson(cVar.D, this.f62105d));
        contentValues.put("column_notifications", this.f62102a.toJson(cVar.S(), this.f62106e));
        contentValues.put("tt_download", Long.valueOf(cVar.P));
        contentValues.put("asset_download_timestamp", Long.valueOf(cVar.R));
        contentValues.put("asset_download_duration", Long.valueOf(cVar.S));
        contentValues.put("ad_request_start_time", Long.valueOf(cVar.T));
        contentValues.put("column_enable_om_sdk", Boolean.valueOf(cVar.H));
        contentValues.put("column_om_sdk_extra_vast", cVar.I);
        contentValues.put("column_request_timestamp", Long.valueOf(cVar.U));
        contentValues.put("column_click_coordinates_enabled", Boolean.valueOf(cVar.V));
        contentValues.put("column_assets_fully_downloaded", Boolean.valueOf(cVar.W));
        contentValues.put("column_deep_link", cVar.Q);
        contentValues.put("column_header_bidding", Boolean.valueOf(cVar.M));
        return contentValues;
    }
}
