package com.vungle.warren.model;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.vungle.warren.AdConfig;
import com.vungle.warren.VungleLogger;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f62186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f62187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f62188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f62189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f62190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f62191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f62192g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f62193h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f62194i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AdConfig.AdSize f62195j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AdConfig.AdSize f62196k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f62197l;

    public m() {
        this.f62194i = 0;
        this.f62196k = AdConfig.AdSize.VUNGLE_DEFAULT;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:75:0x0157  */
    public m(JsonObject jsonObject) throws IllegalArgumentException {
        byte b11 = 0;
        this.f62194i = 0;
        this.f62196k = AdConfig.AdSize.VUNGLE_DEFAULT;
        if (!jsonObject.has("reference_id")) {
            throw new IllegalArgumentException("Missing placement reference ID, cannot use placement!");
        }
        this.f62186a = jsonObject.get("reference_id").getAsString();
        this.f62187b = jsonObject.has("is_auto_cached") && jsonObject.get("is_auto_cached").getAsBoolean();
        if (jsonObject.has("cache_priority") && this.f62187b) {
            try {
                int asInt = jsonObject.get("cache_priority").getAsInt();
                this.f62191f = asInt;
                if (asInt < 1) {
                    this.f62191f = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
            } catch (Exception unused) {
                this.f62191f = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
        } else {
            this.f62191f = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        this.f62188c = jsonObject.has("is_incentivized") && jsonObject.get("is_incentivized").getAsBoolean();
        this.f62190e = jsonObject.has("ad_refresh_duration") ? jsonObject.get("ad_refresh_duration").getAsInt() : 0;
        this.f62192g = jsonObject.has("header_bidding") && jsonObject.get("header_bidding").getAsBoolean();
        if (l.e(jsonObject, "max_hb_cache")) {
            try {
                int asInt2 = jsonObject.get("max_hb_cache").getAsInt();
                this.f62197l = asInt2;
                if (asInt2 < 0) {
                    asInt2 = Integer.MIN_VALUE;
                }
                this.f62197l = asInt2;
            } catch (NumberFormatException e11) {
                VungleLogger.d(true, "Placement", "Placement", String.format("Can't read int value from JSON: %s", e11.getLocalizedMessage()));
                this.f62197l = Integer.MIN_VALUE;
            }
        }
        if (l.e(jsonObject, "supported_template_types")) {
            Iterator<JsonElement> it = jsonObject.getAsJsonArray("supported_template_types").iterator();
            if (it.hasNext()) {
                String asString = it.next().getAsString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("SupportedTemplatesTypes : ");
                sb2.append(asString);
                if (asString.equals("banner")) {
                    this.f62194i = 1;
                } else if (asString.equals("flexfeed") || asString.equals("flexview")) {
                    this.f62194i = 2;
                } else if (asString.equals("mrec")) {
                    this.f62194i = 3;
                } else if (asString.equals("native")) {
                    this.f62194i = 4;
                } else {
                    this.f62194i = 0;
                }
            }
        }
        if (l.e(jsonObject, "ad_size") && this.f62194i == 1 && l()) {
            String asString2 = jsonObject.get("ad_size").getAsString();
            asString2.hashCode();
            switch (asString2.hashCode()) {
                case -1396342996:
                    if (!asString2.equals("banner")) {
                        b11 = -1;
                    }
                    break;
                case 557834986:
                    if (!asString2.equals("banner_leaderboard")) {
                        b11 = -1;
                    } else {
                        b11 = 1;
                    }
                    break;
                case 1017009577:
                    if (!asString2.equals("banner_short")) {
                        b11 = -1;
                    } else {
                        b11 = 2;
                    }
                    break;
                default:
                    b11 = -1;
                    break;
            }
            switch (b11) {
                case 0:
                    this.f62196k = AdConfig.AdSize.BANNER;
                    return;
                case 1:
                    this.f62196k = AdConfig.AdSize.BANNER_LEADERBOARD;
                    return;
                case 2:
                    this.f62196k = AdConfig.AdSize.BANNER_SHORT;
                    return;
                default:
                    this.f62196k = AdConfig.AdSize.VUNGLE_DEFAULT;
                    return;
            }
        }
    }

    public int a() {
        int i11 = this.f62190e;
        if (i11 <= 0) {
            return 0;
        }
        return i11;
    }

    public AdConfig.AdSize b() {
        AdConfig.AdSize adSize = this.f62195j;
        return adSize == null ? AdConfig.AdSize.VUNGLE_DEFAULT : adSize;
    }

    public int c() {
        return this.f62191f;
    }

    @NonNull
    public String d() {
        return this.f62186a;
    }

    public int e() {
        return this.f62197l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        String str = this.f62186a;
        if (str == null ? mVar.f62186a == null : str.equals(mVar.f62186a)) {
            return this.f62194i == mVar.f62194i && this.f62187b == mVar.f62187b && this.f62188c == mVar.f62188c && this.f62192g == mVar.f62192g && this.f62193h == mVar.f62193h;
        }
        return false;
    }

    public int f() {
        return this.f62194i;
    }

    @NonNull
    public AdConfig.AdSize g() {
        return this.f62196k;
    }

    public long h() {
        return this.f62189d;
    }

    public int hashCode() {
        String str = this.f62186a;
        return ((((((((((str != null ? str.hashCode() : 0) * 31) + this.f62194i) * 31) + (this.f62187b ? 1 : 0)) * 31) + (this.f62188c ? 1 : 0)) * 31) + (this.f62192g ? 1 : 0)) * 31) + (this.f62193h ? 1 : 0);
    }

    public boolean i() {
        if (this.f62197l == 0 && this.f62192g) {
            return false;
        }
        if (AdConfig.AdSize.isNonMrecBannerAdSize(this.f62195j)) {
            return true;
        }
        return this.f62187b;
    }

    public boolean j() {
        return this.f62192g;
    }

    public boolean k() {
        return this.f62188c;
    }

    public boolean l() {
        return this.f62192g && this.f62197l > 0;
    }

    public boolean m() {
        return this.f62192g && this.f62197l == 1;
    }

    public boolean n() {
        return this.f62193h;
    }

    public void o(AdConfig.AdSize adSize) {
        this.f62195j = adSize;
    }

    public void p(boolean z11) {
        this.f62193h = z11;
    }

    public void q(long j11) {
        this.f62189d = j11;
    }

    public void r(long j11) {
        this.f62189d = System.currentTimeMillis() + (j11 * 1000);
    }

    @NonNull
    public String toString() {
        return "Placement{identifier='" + this.f62186a + "', autoCached=" + this.f62187b + ", incentivized=" + this.f62188c + ", wakeupTime=" + this.f62189d + ", adRefreshDuration=" + this.f62190e + ", autoCachePriority=" + this.f62191f + ", headerBidding=" + this.f62192g + ", isValid=" + this.f62193h + ", placementAdType=" + this.f62194i + ", adSize=" + this.f62195j + ", maxHbCache=" + this.f62197l + ", adSize=" + this.f62195j + ", recommendedAdSize=" + this.f62196k + '}';
    }
}
