package x8;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f80420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f80421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f80422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f80423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f80424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f80425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f80426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f80427h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f80428i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f80429j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f80430k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f80431l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f80432m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f80433n = -1.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f80434o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f80435p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f80436q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f80437r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f80438s = 307200;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f80439t = 1;

    public void A(int i11) {
        this.f80420a = i11;
    }

    public void B(String str) {
        this.f80425f = str;
    }

    public double C() {
        return this.f80430k;
    }

    public void D(int i11) {
        this.f80437r = i11;
    }

    public int E() {
        return this.f80431l;
    }

    public void F(double d11) {
        this.f80423d = d11;
    }

    public void G(int i11) {
        this.f80431l = i11;
    }

    public void H(long j11) {
        this.f80422c = j11;
    }

    public void I(String str) {
        this.f80424e = str;
    }

    public int J() {
        return this.f80439t;
    }

    public JSONObject K() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", z());
            jSONObject.put("cover_url", r());
            jSONObject.put("cover_width", L());
            jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, p());
            jSONObject.put("file_hash", k());
            jSONObject.put("resolution", f());
            jSONObject.put("size", c());
            jSONObject.put("video_duration", m());
            jSONObject.put(CampaignEx.JSON_KEY_VIDEO_URL, q());
            jSONObject.put("playable_download_url", j());
            jSONObject.put("if_playable_loading_show", l());
            jSONObject.put("remove_loading_page_type", x());
            jSONObject.put("fallback_endcard_judge", E());
            jSONObject.put("video_preload_size", a());
            jSONObject.put("reward_video_cached_type", y());
            jSONObject.put("execute_cached_type", w());
            jSONObject.put("endcard_render", t());
            jSONObject.put("replay_time", J());
            jSONObject.put("play_speed_ratio", h());
            if (C() > 0.0d) {
                jSONObject.put("start", C());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int L() {
        return this.f80421b;
    }

    public void M(int i11) {
        this.f80421b = i11;
    }

    public void N(String str) {
        this.f80426g = str;
    }

    public int a() {
        if (this.f80438s < 0) {
            this.f80438s = 307200;
        }
        long j11 = this.f80438s;
        long j12 = this.f80422c;
        if (j11 > j12) {
            this.f80438s = (int) j12;
        }
        return this.f80438s;
    }

    public boolean b() {
        return this.f80436q == 0;
    }

    public long c() {
        return this.f80422c;
    }

    public void d(int i11) {
        this.f80438s = i11;
    }

    public void e(String str) {
        this.f80428i = str;
    }

    public String f() {
        return this.f80424e;
    }

    public void g(int i11) {
        this.f80435p = i11;
    }

    public float h() {
        return this.f80433n;
    }

    public void i(int i11) {
        this.f80434o = i11;
    }

    public String j() {
        return this.f80428i;
    }

    public String k() {
        if (TextUtils.isEmpty(this.f80429j)) {
            this.f80429j = v8.a.a(this.f80426g);
        }
        return this.f80429j;
    }

    public int l() {
        return this.f80434o;
    }

    public double m() {
        return this.f80423d;
    }

    public void n(int i11) {
        this.f80436q = i11;
    }

    public void o(String str) {
        this.f80429j = str;
    }

    public String p() {
        return this.f80427h;
    }

    public String q() {
        return this.f80426g;
    }

    public String r() {
        return this.f80425f;
    }

    public void s(int i11) {
        this.f80439t = Math.min(4, Math.max(1, i11));
    }

    public int t() {
        return this.f80432m;
    }

    public void u(int i11) {
        this.f80432m = i11;
    }

    public void v(String str) {
        this.f80427h = str;
    }

    public int w() {
        return this.f80437r;
    }

    public int x() {
        return this.f80435p;
    }

    public int y() {
        return this.f80436q;
    }

    public int z() {
        return this.f80420a;
    }
}
