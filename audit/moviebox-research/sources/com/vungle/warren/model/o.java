package com.vungle.warren.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.vungle.warren.AdConfig;
import com.vungle.warren.SessionTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f62198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f62199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f62200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f62201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f62202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f62203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f62204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f62205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f62206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f62207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f62208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f62209l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f62210m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f62211n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f62212o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<a> f62213p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<String> f62214q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<String> f62215r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f62216s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f62217t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f62218u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f62219v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f62220w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f62221x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f62222y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f62223z;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("action")
        private String f62224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)
        private String f62225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName(CampaignEx.JSON_KEY_TIMESTAMP)
        private long f62226c;

        public a(String str, String str2, long j11) {
            this.f62224a = str;
            this.f62225b = str2;
            this.f62226c = j11;
        }

        public JsonObject a() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("action", this.f62224a);
            String str = this.f62225b;
            if (str != null && !str.isEmpty()) {
                jsonObject.addProperty(AppMeasurementSdk.ConditionalUserProperty.VALUE, this.f62225b);
            }
            jsonObject.addProperty("timestamp_millis", Long.valueOf(this.f62226c));
            return jsonObject;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.f62224a.equals(this.f62224a) && aVar.f62225b.equals(this.f62225b) && aVar.f62226c == this.f62226c;
        }

        public int hashCode() {
            int iHashCode = ((this.f62224a.hashCode() * 31) + this.f62225b.hashCode()) * 31;
            long j11 = this.f62226c;
            return iHashCode + ((int) (j11 ^ (j11 >>> 32)));
        }
    }

    public o() {
        this.f62198a = 0;
        this.f62213p = new ArrayList();
        this.f62214q = new ArrayList();
        this.f62215r = new ArrayList();
    }

    public o(@NonNull c cVar, @NonNull m mVar, long j11, @Nullable String str) {
        this.f62198a = 0;
        this.f62213p = new ArrayList();
        this.f62214q = new ArrayList();
        this.f62215r = new ArrayList();
        this.f62199b = mVar.d();
        this.f62200c = cVar.e();
        this.f62211n = cVar.v();
        this.f62201d = cVar.j();
        this.f62202e = mVar.k();
        this.f62203f = mVar.j();
        this.f62205h = j11;
        this.f62206i = cVar.R();
        this.f62209l = -1L;
        this.f62210m = cVar.n();
        this.f62222y = SessionTracker.l().k();
        this.f62223z = cVar.k();
        int iH = cVar.h();
        if (iH == 0) {
            this.f62216s = "vungle_local";
        } else {
            if (iH != 1) {
                throw new IllegalArgumentException("Unknown ad type, cannot process!");
            }
            this.f62216s = "vungle_mraid";
        }
        this.f62217t = cVar.E();
        if (str == null) {
            this.f62218u = "";
        } else {
            this.f62218u = str;
        }
        this.f62219v = cVar.d().f();
        AdConfig.AdSize adSizeA = cVar.d().a();
        if (AdConfig.AdSize.isNonMrecBannerAdSize(adSizeA)) {
            this.f62220w = adSizeA.getName();
        }
    }

    public long a() {
        return this.f62208k;
    }

    public long b() {
        return this.f62205h;
    }

    @NonNull
    public String c() {
        return this.f62199b + "_" + this.f62205h;
    }

    public String d() {
        return this.f62218u;
    }

    public boolean e() {
        return this.f62221x;
    }

    public synchronized boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                o oVar = (o) obj;
                if (!oVar.f62199b.equals(this.f62199b)) {
                    return false;
                }
                if (!oVar.f62200c.equals(this.f62200c)) {
                    return false;
                }
                if (!oVar.f62201d.equals(this.f62201d)) {
                    return false;
                }
                if (oVar.f62202e != this.f62202e) {
                    return false;
                }
                if (oVar.f62203f != this.f62203f) {
                    return false;
                }
                if (oVar.f62205h != this.f62205h) {
                    return false;
                }
                if (!oVar.f62206i.equals(this.f62206i)) {
                    return false;
                }
                if (oVar.f62207j != this.f62207j) {
                    return false;
                }
                if (oVar.f62208k != this.f62208k) {
                    return false;
                }
                if (oVar.f62209l != this.f62209l) {
                    return false;
                }
                if (!oVar.f62210m.equals(this.f62210m)) {
                    return false;
                }
                if (!oVar.f62216s.equals(this.f62216s)) {
                    return false;
                }
                if (!oVar.f62217t.equals(this.f62217t)) {
                    return false;
                }
                if (oVar.f62221x != this.f62221x) {
                    return false;
                }
                if (!oVar.f62218u.equals(this.f62218u)) {
                    return false;
                }
                if (oVar.f62222y != this.f62222y) {
                    return false;
                }
                if (oVar.f62223z != this.f62223z) {
                    return false;
                }
                if (oVar.f62214q.size() != this.f62214q.size()) {
                    return false;
                }
                for (int i11 = 0; i11 < this.f62214q.size(); i11++) {
                    if (!oVar.f62214q.get(i11).equals(this.f62214q.get(i11))) {
                        return false;
                    }
                }
                if (oVar.f62215r.size() != this.f62215r.size()) {
                    return false;
                }
                for (int i12 = 0; i12 < this.f62215r.size(); i12++) {
                    if (!oVar.f62215r.get(i12).equals(this.f62215r.get(i12))) {
                        return false;
                    }
                }
                if (oVar.f62213p.size() != this.f62213p.size()) {
                    return false;
                }
                for (int i13 = 0; i13 < this.f62213p.size(); i13++) {
                    if (!oVar.f62213p.get(i13).equals(this.f62213p.get(i13))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public synchronized void f(String str, String str2, long j11) {
        this.f62213p.add(new a(str, str2, j11));
        this.f62214q.add(str);
        if (str.equals(DownloadBaseRunnable.TAG)) {
            this.f62221x = true;
        }
    }

    public synchronized void g(String str) {
        this.f62215r.add(str);
    }

    public void h(int i11) {
        this.f62212o = i11;
    }

    public synchronized int hashCode() {
        int i11;
        long j11;
        int iA = ((((((((com.vungle.warren.utility.k.a(this.f62199b) * 31) + com.vungle.warren.utility.k.a(this.f62200c)) * 31) + com.vungle.warren.utility.k.a(this.f62201d)) * 31) + (this.f62202e ? 1 : 0)) * 31) + (this.f62203f ? 1 : 0)) * 31;
        long j12 = this.f62205h;
        int iA2 = (((iA + ((int) (j12 ^ (j12 >>> 32)))) * 31) + com.vungle.warren.utility.k.a(this.f62206i)) * 31;
        long j13 = this.f62207j;
        int i12 = (iA2 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
        long j14 = this.f62208k;
        int i13 = (i12 + ((int) (j14 ^ (j14 >>> 32)))) * 31;
        long j15 = this.f62209l;
        int i14 = (i13 + ((int) (j15 ^ (j15 >>> 32)))) * 31;
        long j16 = this.f62222y;
        i11 = (i14 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        j11 = this.f62223z;
        return ((((((((((((((((i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + com.vungle.warren.utility.k.a(this.f62210m)) * 31) + com.vungle.warren.utility.k.a(this.f62213p)) * 31) + com.vungle.warren.utility.k.a(this.f62214q)) * 31) + com.vungle.warren.utility.k.a(this.f62215r)) * 31) + com.vungle.warren.utility.k.a(this.f62216s)) * 31) + com.vungle.warren.utility.k.a(this.f62217t)) * 31) + com.vungle.warren.utility.k.a(this.f62218u)) * 31) + (this.f62221x ? 1 : 0);
    }

    public void i(long j11) {
        this.f62208k = j11;
    }

    public void j(boolean z11) {
        this.f62204g = !z11;
    }

    public void k(int i11) {
        this.f62198a = i11;
    }

    public void l(long j11) {
        this.f62209l = j11;
    }

    public void m(long j11) {
        this.f62207j = j11;
    }

    public synchronized JsonObject n() {
        JsonObject jsonObject;
        try {
            jsonObject = new JsonObject();
            jsonObject.addProperty("placement_reference_id", this.f62199b);
            jsonObject.addProperty("ad_token", this.f62200c);
            jsonObject.addProperty("app_id", this.f62201d);
            jsonObject.addProperty("incentivized", Integer.valueOf(this.f62202e ? 1 : 0));
            jsonObject.addProperty("header_bidding", Boolean.valueOf(this.f62203f));
            jsonObject.addProperty("play_remote_assets", Boolean.valueOf(this.f62204g));
            jsonObject.addProperty("adStartTime", Long.valueOf(this.f62205h));
            if (!TextUtils.isEmpty(this.f62206i)) {
                jsonObject.addProperty("url", this.f62206i);
            }
            jsonObject.addProperty("adDuration", Long.valueOf(this.f62208k));
            jsonObject.addProperty("ttDownload", Long.valueOf(this.f62209l));
            jsonObject.addProperty("campaign", this.f62210m);
            jsonObject.addProperty("adType", this.f62216s);
            jsonObject.addProperty("templateId", this.f62217t);
            jsonObject.addProperty("init_timestamp", Long.valueOf(this.f62222y));
            jsonObject.addProperty("asset_download_duration", Long.valueOf(this.f62223z));
            if (!TextUtils.isEmpty(this.f62220w)) {
                jsonObject.addProperty("ad_size", this.f62220w);
            }
            JsonArray jsonArray = new JsonArray();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("startTime", Long.valueOf(this.f62205h));
            int i11 = this.f62212o;
            if (i11 > 0) {
                jsonObject2.addProperty("videoViewed", Integer.valueOf(i11));
            }
            long j11 = this.f62207j;
            if (j11 > 0) {
                jsonObject2.addProperty("videoLength", Long.valueOf(j11));
            }
            JsonArray jsonArray2 = new JsonArray();
            Iterator<a> it = this.f62213p.iterator();
            while (it.hasNext()) {
                jsonArray2.add(it.next().a());
            }
            jsonObject2.add("userActions", jsonArray2);
            jsonArray.add(jsonObject2);
            jsonObject.add("plays", jsonArray);
            JsonArray jsonArray3 = new JsonArray();
            Iterator<String> it2 = this.f62215r.iterator();
            while (it2.hasNext()) {
                jsonArray3.add(it2.next());
            }
            jsonObject.add("errors", jsonArray3);
            JsonArray jsonArray4 = new JsonArray();
            Iterator<String> it3 = this.f62214q.iterator();
            while (it3.hasNext()) {
                jsonArray4.add(it3.next());
            }
            jsonObject.add("clickedThrough", jsonArray4);
            if (this.f62202e && !TextUtils.isEmpty(this.f62218u)) {
                jsonObject.addProperty("user", this.f62218u);
            }
            int i12 = this.f62219v;
            if (i12 > 0) {
                jsonObject.addProperty("ordinal_view", Integer.valueOf(i12));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return jsonObject;
    }
}
