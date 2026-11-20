package com.vungle.warren.model;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.AdConfig;
import com.vungle.warren.VungleLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c implements Comparable<c> {
    public static final Collection<String> Y = Arrays.asList(CampaignEx.JSON_NATIVE_VIDEO_PLAY_PERCENTAGE, "checkpoint.0", "checkpoint.25", "checkpoint.50", "checkpoint.75", "checkpoint.100");
    public static final String[] Z = new String[0];
    public String A;
    public Map<String, String> B;
    public Map<String, String> C;
    public Map<String, Pair<String, String>> D;
    public Map<String, String> E;
    public String F;
    public String G;
    public boolean H;

    @Nullable
    public String I;
    public boolean J;
    public String K;
    public String L;
    public boolean M;
    public int N;
    public String O;
    public long P;
    public String Q;
    public long R;
    public long S;
    public long T;
    public long U;
    public boolean V;
    public boolean W;
    public List<String> X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Gson f62135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f62136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f62137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f62138d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f62139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<a> f62140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, ArrayList<String>> f62141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f62142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f62143j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f62144k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f62145l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f62146m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f62147n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f62148o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f62149p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f62150q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f62151r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f62152s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f62153t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f62154u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f62155v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AdConfig f62156w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f62157x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f62158y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f62159z;

    /* JADX INFO: compiled from: source.java */
    public static class a implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("percentage")
        private byte f62160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("urls")
        private String[] f62161b;

        public a(JsonArray jsonArray, byte b11) {
            if (jsonArray.size() == 0) {
                throw new IllegalArgumentException("Empty URLS!");
            }
            this.f62161b = new String[jsonArray.size()];
            for (int i11 = 0; i11 < jsonArray.size(); i11++) {
                this.f62161b[i11] = jsonArray.get(i11).getAsString();
            }
            this.f62160a = b11;
        }

        public a(JsonObject jsonObject) throws IllegalArgumentException {
            if (!l.e(jsonObject, "checkpoint")) {
                throw new IllegalArgumentException("Checkpoint missing percentage!");
            }
            this.f62160a = (byte) (jsonObject.get("checkpoint").getAsFloat() * 100.0f);
            if (!l.e(jsonObject, "urls")) {
                throw new IllegalArgumentException("Checkpoint missing reporting URL!");
            }
            JsonArray asJsonArray = jsonObject.getAsJsonArray("urls");
            this.f62161b = new String[asJsonArray.size()];
            for (int i11 = 0; i11 < asJsonArray.size(); i11++) {
                if (asJsonArray.get(i11) == null || "null".equalsIgnoreCase(asJsonArray.get(i11).toString())) {
                    this.f62161b[i11] = "";
                } else {
                    this.f62161b[i11] = asJsonArray.get(i11).getAsString();
                }
            }
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull a aVar) {
            return Float.compare(this.f62160a, aVar.f62160a);
        }

        public byte b() {
            return this.f62160a;
        }

        public String[] c() {
            return (String[]) this.f62161b.clone();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (aVar.f62160a != this.f62160a || aVar.f62161b.length != this.f62161b.length) {
                return false;
            }
            int i11 = 0;
            while (true) {
                String[] strArr = this.f62161b;
                if (i11 >= strArr.length) {
                    return true;
                }
                if (!aVar.f62161b[i11].equals(strArr[i11])) {
                    return false;
                }
                i11++;
            }
        }

        public int hashCode() {
            int i11 = this.f62160a * Ascii.US;
            String[] strArr = this.f62161b;
            return ((i11 + strArr.length) * 31) + Arrays.hashCode(strArr);
        }
    }

    public c() {
        this.f62135a = new Gson();
        this.f62141h = new LinkedTreeMap();
        this.f62153t = true;
        this.C = new HashMap();
        this.D = new HashMap();
        this.E = new HashMap();
        this.N = 0;
        this.W = false;
        this.X = new ArrayList();
    }

    public c(@NonNull JsonObject jsonObject) throws IllegalArgumentException {
        String asString;
        this.f62135a = new Gson();
        this.f62141h = new LinkedTreeMap();
        this.f62153t = true;
        this.C = new HashMap();
        this.D = new HashMap();
        this.E = new HashMap();
        this.N = 0;
        this.W = false;
        this.X = new ArrayList();
        if (!l.e(jsonObject, "ad_markup")) {
            throw new IllegalArgumentException("JSON does not contain ad markup!");
        }
        JsonObject asJsonObject = jsonObject.getAsJsonObject("ad_markup");
        if (!l.e(asJsonObject, "adType")) {
            throw new IllegalArgumentException("Advertisement did not contain an adType!");
        }
        String asString2 = asJsonObject.get("adType").getAsString();
        asString2.hashCode();
        if (asString2.equals("vungle_local")) {
            this.f62136b = 0;
            this.f62151r = l.e(asJsonObject, "postBundle") ? asJsonObject.get("postBundle").getAsString() : "";
            asString = l.e(asJsonObject, "url") ? asJsonObject.get("url").getAsString() : "";
            this.B = new HashMap();
            this.A = "";
            this.F = "";
            this.G = "";
        } else {
            if (!asString2.equals("vungle_mraid")) {
                throw new IllegalArgumentException("Unknown Ad Type " + asString2 + "! Please add this ad type");
            }
            this.f62136b = 1;
            this.f62151r = "";
            if (!l.e(asJsonObject, "templateSettings")) {
                throw new IllegalArgumentException("Missing template adConfig!");
            }
            this.B = new HashMap();
            JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("templateSettings");
            if (l.e(asJsonObject2, "normal_replacements")) {
                for (Map.Entry<String, JsonElement> entry : asJsonObject2.getAsJsonObject("normal_replacements").entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        this.B.put(entry.getKey(), (entry.getValue() == null || entry.getValue().isJsonNull()) ? null : entry.getValue().getAsString());
                    }
                }
            }
            if (l.e(asJsonObject2, "cacheable_replacements")) {
                asString = "";
                for (Map.Entry<String, JsonElement> entry2 : asJsonObject2.getAsJsonObject("cacheable_replacements").entrySet()) {
                    if (!TextUtils.isEmpty(entry2.getKey()) && entry2.getValue() != null && l.e(entry2.getValue(), "url") && l.e(entry2.getValue(), "extension")) {
                        String asString3 = entry2.getValue().getAsJsonObject().get("url").getAsString();
                        this.D.put(entry2.getKey(), new Pair<>(asString3, entry2.getValue().getAsJsonObject().get("extension").getAsString()));
                        if (entry2.getKey().equalsIgnoreCase("MAIN_VIDEO")) {
                            asString = asString3;
                        }
                    }
                }
            } else {
                asString = "";
            }
            if (!l.e(asJsonObject, "templateId")) {
                throw new IllegalArgumentException("Missing templateID!");
            }
            this.F = asJsonObject.get("templateId").getAsString();
            if (!l.e(asJsonObject, "template_type")) {
                throw new IllegalArgumentException("Template Type missing!");
            }
            this.G = asJsonObject.get("template_type").getAsString();
            if (!W()) {
                if (!l.e(asJsonObject, "templateURL")) {
                    throw new IllegalArgumentException("Template URL missing!");
                }
                this.A = asJsonObject.get("templateURL").getAsString();
            }
        }
        if (TextUtils.isEmpty(asString)) {
            this.f62147n = "";
        } else {
            this.f62147n = asString;
        }
        if (l.e(asJsonObject, "deeplinkUrl")) {
            this.Q = asJsonObject.get("deeplinkUrl").getAsString();
        }
        if (!l.e(asJsonObject, "id")) {
            throw new IllegalArgumentException("Missing identifier, cannot process advertisement!");
        }
        this.f62137c = asJsonObject.get("id").getAsString();
        if (!l.e(asJsonObject, "campaign")) {
            throw new IllegalArgumentException("Missing campaign information, cannot process advertisement!");
        }
        this.f62143j = asJsonObject.get("campaign").getAsString();
        if (!l.e(asJsonObject, "app_id")) {
            throw new IllegalArgumentException("Missing app Id, cannot process advertisement!");
        }
        this.f62138d = asJsonObject.get("app_id").getAsString();
        if (!l.e(asJsonObject, "expiry") || asJsonObject.get("expiry").isJsonNull()) {
            this.f62139f = System.currentTimeMillis() / 1000;
        } else {
            long asLong = asJsonObject.get("expiry").getAsLong();
            if (asLong > 0) {
                this.f62139f = asLong;
            } else {
                this.f62139f = System.currentTimeMillis() / 1000;
            }
        }
        if (l.e(asJsonObject, "notification")) {
            Iterator<JsonElement> it = asJsonObject.getAsJsonArray("notification").iterator();
            while (it.hasNext()) {
                this.X.add(it.next().getAsString());
            }
        }
        if (l.e(asJsonObject, "tpat")) {
            JsonObject asJsonObject3 = asJsonObject.getAsJsonObject("tpat");
            this.f62140g = new ArrayList(5);
            int i11 = this.f62136b;
            if (i11 != 0) {
                if (i11 != 1) {
                    throw new IllegalArgumentException("Unknown Ad Type!");
                }
                for (int i12 = 0; i12 < 5; i12++) {
                    int i13 = i12 * 25;
                    String str = String.format(Locale.ENGLISH, "checkpoint.%d", Integer.valueOf(i13));
                    this.f62140g.add(i12, l.e(asJsonObject3, str) ? new a(asJsonObject3.getAsJsonArray(str), (byte) i13) : null);
                }
            } else if (l.e(asJsonObject3, CampaignEx.JSON_NATIVE_VIDEO_PLAY_PERCENTAGE)) {
                JsonArray asJsonArray = asJsonObject3.getAsJsonArray(CampaignEx.JSON_NATIVE_VIDEO_PLAY_PERCENTAGE);
                for (int i14 = 0; i14 < asJsonArray.size(); i14++) {
                    if (asJsonArray.get(i14) != null) {
                        this.f62140g.add(new a(asJsonArray.get(i14).getAsJsonObject()));
                    }
                }
                Collections.sort(this.f62140g);
            }
            TreeSet<String> treeSet = new TreeSet(asJsonObject3.keySet());
            treeSet.remove("moat");
            treeSet.removeAll(Y);
            if (!treeSet.isEmpty()) {
                for (String str2 : treeSet) {
                    JsonArray asJsonArray2 = asJsonObject3.get(str2).getAsJsonArray();
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (int i15 = 0; i15 < asJsonArray2.size(); i15++) {
                        if (asJsonArray2.get(i15) == null || "null".equalsIgnoreCase(asJsonArray2.get(i15).toString())) {
                            arrayList.add(i15, "");
                        } else {
                            arrayList.add(i15, asJsonArray2.get(i15).getAsString());
                        }
                    }
                    this.f62141h.put(str2, arrayList);
                }
            }
        } else {
            this.f62140g = new ArrayList();
        }
        if (l.e(asJsonObject, "delay")) {
            this.f62142i = asJsonObject.get("delay").getAsInt();
        } else {
            this.f62142i = 0;
        }
        if (l.e(asJsonObject, "showClose")) {
            this.f62144k = asJsonObject.get("showClose").getAsInt();
        } else {
            this.f62144k = 0;
        }
        if (l.e(asJsonObject, "showCloseIncentivized")) {
            this.f62145l = asJsonObject.get("showCloseIncentivized").getAsInt();
        } else {
            this.f62145l = 0;
        }
        if (l.e(asJsonObject, "countdown")) {
            this.f62146m = asJsonObject.get("countdown").getAsInt();
        } else {
            this.f62146m = 0;
        }
        if (!l.e(asJsonObject, "videoWidth")) {
            throw new IllegalArgumentException("Missing video width!");
        }
        this.f62148o = asJsonObject.get("videoWidth").getAsInt();
        if (!l.e(asJsonObject, "videoHeight")) {
            throw new IllegalArgumentException("Missing video height!");
        }
        this.f62149p = asJsonObject.get("videoHeight").getAsInt();
        if (l.e(asJsonObject, "md5")) {
            this.f62150q = asJsonObject.get("md5").getAsString();
        } else {
            this.f62150q = "";
        }
        if (l.e(asJsonObject, "cta_overlay")) {
            JsonObject asJsonObject4 = asJsonObject.getAsJsonObject("cta_overlay");
            if (l.e(asJsonObject4, "enabled")) {
                this.f62152s = asJsonObject4.get("enabled").getAsBoolean();
            } else {
                this.f62152s = false;
            }
            if (l.e(asJsonObject4, "click_area") && !asJsonObject4.get("click_area").getAsString().isEmpty() && asJsonObject4.get("click_area").getAsDouble() == 0.0d) {
                this.f62153t = false;
            }
        } else {
            this.f62152s = false;
        }
        this.f62154u = l.e(asJsonObject, "callToActionDest") ? asJsonObject.get("callToActionDest").getAsString() : "";
        String asString4 = l.e(asJsonObject, "callToActionUrl") ? asJsonObject.get("callToActionUrl").getAsString() : "";
        this.f62155v = asString4;
        if (TextUtils.isEmpty(asString4)) {
            this.f62155v = this.B.get("CTA_BUTTON_URL");
        }
        if (l.e(asJsonObject, "retryCount")) {
            this.f62157x = asJsonObject.get("retryCount").getAsInt();
        } else {
            this.f62157x = 1;
        }
        if (!l.e(asJsonObject, "ad_token")) {
            throw new IllegalArgumentException("AdToken missing!");
        }
        this.f62158y = asJsonObject.get("ad_token").getAsString();
        if (l.e(asJsonObject, "video_object_id")) {
            this.f62159z = asJsonObject.get("video_object_id").getAsString();
        } else {
            this.f62159z = "";
        }
        if (l.e(asJsonObject, "requires_sideloading")) {
            this.J = asJsonObject.get("requires_sideloading").getAsBoolean();
        } else {
            this.J = false;
        }
        if (l.e(asJsonObject, "ad_market_id")) {
            this.K = asJsonObject.get("ad_market_id").getAsString();
        } else {
            this.K = "";
        }
        if (l.e(asJsonObject, "bid_token")) {
            this.L = asJsonObject.get("bid_token").getAsString();
        } else {
            this.L = "";
        }
        if (l.e(asJsonObject, CampaignEx.JSON_KEY_TIMESTAMP)) {
            this.U = asJsonObject.get(CampaignEx.JSON_KEY_TIMESTAMP).getAsLong();
        } else {
            this.U = 1L;
        }
        JsonObject jsonObjectC = l.c(l.c(asJsonObject, "viewability"), "om");
        this.H = l.a(jsonObjectC, "is_enabled", false);
        this.I = l.d(jsonObjectC, "extra_vast", null);
        this.V = l.a(asJsonObject, "click_coordinates_enabled", false);
        this.f62156w = new AdConfig();
    }

    public String A() {
        return this.B.get("VUNGLE_PRIVACY_URL");
    }

    public long B() {
        return this.U;
    }

    public int C(boolean z11) {
        return (z11 ? this.f62145l : this.f62144k) * 1000;
    }

    public int D() {
        return this.N;
    }

    public String E() {
        return this.F;
    }

    public String F() {
        return this.G;
    }

    public String[] G(@NonNull String str) {
        String str2 = "Unknown TPAT Event " + str;
        ArrayList<String> arrayList = this.f62141h.get(str);
        int i11 = this.f62136b;
        if (i11 == 0) {
            if (arrayList != null) {
                return (String[]) arrayList.toArray(Z);
            }
            VungleLogger.j(c.class.getSimpleName() + "#getTpatUrls", str2);
            return Z;
        }
        if (i11 != 1) {
            throw new IllegalStateException("Unknown Advertisement Type!");
        }
        if (str.startsWith("checkpoint")) {
            String[] strArr = Z;
            a aVar = this.f62140g.get(Integer.parseInt(str.split("\\.")[1]) / 25);
            return aVar != null ? aVar.c() : strArr;
        }
        if (arrayList != null) {
            return (String[]) arrayList.toArray(Z);
        }
        VungleLogger.j(c.class.getSimpleName() + "#getTpatUrls", str2);
        return Z;
    }

    public long H() {
        return this.P;
    }

    public String R() {
        return this.f62147n;
    }

    @NonNull
    public List<String> S() {
        return this.X;
    }

    public boolean T() {
        return !TextUtils.isEmpty(this.f62151r);
    }

    public boolean U() {
        return this.V;
    }

    public boolean V() {
        return this.f62152s;
    }

    public boolean W() {
        return "native".equals(this.G);
    }

    public final boolean X(String str) {
        return (TextUtils.isEmpty(str) || HttpUrl.parse(str) == null) ? false : true;
    }

    public void Y(long j11) {
        this.T = j11;
    }

    public void Z(long j11) {
        this.R = j11;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        if (cVar == null) {
            return 1;
        }
        String str = cVar.f62137c;
        if (str == null) {
            return this.f62137c == null ? 0 : 1;
        }
        String str2 = this.f62137c;
        if (str2 == null) {
            return -1;
        }
        return str2.compareTo(str);
    }

    public void a0(long j11) {
        this.S = j11 - this.R;
        this.P = j11 - this.T;
    }

    public void b(AdConfig adConfig) {
        if (adConfig == null) {
            this.f62156w = new AdConfig();
        } else {
            this.f62156w = adConfig;
        }
    }

    public void b0(boolean z11) {
        this.M = z11;
    }

    public JsonObject c() {
        Map<String, String> mapW = w();
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, String> entry : mapW.entrySet()) {
            jsonObject.addProperty(entry.getKey(), entry.getValue());
        }
        VungleLogger.i(true, "Advertisement", "mraid_args", jsonObject.toString());
        return jsonObject;
    }

    public void c0(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        if (!TextUtils.isEmpty(str)) {
            this.E.put("INCENTIVIZED_TITLE_TEXT", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.E.put("INCENTIVIZED_BODY_TEXT", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.E.put("INCENTIVIZED_CONTINUE_TEXT", str3);
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        this.E.put("INCENTIVIZED_CLOSE_TEXT", str4);
    }

    public AdConfig d() {
        return this.f62156w;
    }

    public void d0(File file) {
        for (Map.Entry<String, Pair<String, String>> entry : this.D.entrySet()) {
            String str = (String) entry.getValue().first;
            if (X(str)) {
                File file2 = new File(file, URLUtil.guessFileName(str, null, null));
                if (file2.exists()) {
                    this.C.put(entry.getKey(), "file://" + file2.getPath());
                }
            }
        }
        this.W = true;
    }

    public String e() {
        return this.f62158y;
    }

    public void e0(String str) {
        this.O = str;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (cVar.f62136b != this.f62136b || cVar.f62142i != this.f62142i || cVar.f62144k != this.f62144k || cVar.f62145l != this.f62145l || cVar.f62146m != this.f62146m || cVar.f62148o != this.f62148o || cVar.f62149p != this.f62149p || cVar.f62152s != this.f62152s || cVar.f62153t != this.f62153t || cVar.f62157x != this.f62157x || cVar.H != this.H || cVar.J != this.J || cVar.N != this.N || (str = cVar.f62137c) == null || (str2 = this.f62137c) == null || !str.equals(str2) || !cVar.f62143j.equals(this.f62143j) || !cVar.f62147n.equals(this.f62147n) || !cVar.f62150q.equals(this.f62150q) || !cVar.f62151r.equals(this.f62151r) || !cVar.f62154u.equals(this.f62154u) || !cVar.f62155v.equals(this.f62155v) || !cVar.f62158y.equals(this.f62158y) || !cVar.f62159z.equals(this.f62159z)) {
            return false;
        }
        String str3 = cVar.I;
        if (str3 == null ? this.I != null : !str3.equals(this.I)) {
            return false;
        }
        if (!cVar.K.equals(this.K) || !cVar.L.equals(this.L) || cVar.f62140g.size() != this.f62140g.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.f62140g.size(); i11++) {
            if (!cVar.f62140g.get(i11).equals(this.f62140g.get(i11))) {
                return false;
            }
        }
        return this.f62141h.equals(cVar.f62141h) && cVar.U == this.U && cVar.V == this.V && cVar.M == this.M;
    }

    public void f0(int i11) {
        this.N = i11;
    }

    public void g0(List<String> list) {
        if (list == null) {
            this.X.clear();
        } else {
            this.X = list;
        }
    }

    public int h() {
        return this.f62136b;
    }

    public void h0(List<com.vungle.warren.model.a> list) {
        for (Map.Entry<String, Pair<String, String>> entry : this.D.entrySet()) {
            String str = (String) entry.getValue().first;
            for (com.vungle.warren.model.a aVar : list) {
                if (!TextUtils.isEmpty(aVar.f62128d) && aVar.f62128d.equals(str)) {
                    File file = new File(aVar.f62129e);
                    if (!file.exists()) {
                        break;
                    }
                    this.C.put(entry.getKey(), "file://" + file.getPath());
                    break;
                }
            }
        }
    }

    public int hashCode() {
        return (((((int) (((long) (((((((((((((((((((((((((((((((((((((((((((((((((((((((this.f62136b * 31) + com.vungle.warren.utility.k.a(this.f62137c)) * 31) + com.vungle.warren.utility.k.a(this.f62140g)) * 31) + com.vungle.warren.utility.k.a(this.f62141h)) * 31) + this.f62142i) * 31) + com.vungle.warren.utility.k.a(this.f62143j)) * 31) + this.f62144k) * 31) + this.f62145l) * 31) + this.f62146m) * 31) + com.vungle.warren.utility.k.a(this.f62147n)) * 31) + this.f62148o) * 31) + this.f62149p) * 31) + com.vungle.warren.utility.k.a(this.f62150q)) * 31) + com.vungle.warren.utility.k.a(this.f62151r)) * 31) + (this.f62152s ? 1 : 0)) * 31) + (this.f62153t ? 1 : 0)) * 31) + com.vungle.warren.utility.k.a(this.f62154u)) * 31) + com.vungle.warren.utility.k.a(this.f62155v)) * 31) + this.f62157x) * 31) + com.vungle.warren.utility.k.a(this.f62158y)) * 31) + com.vungle.warren.utility.k.a(this.f62159z)) * 31) + com.vungle.warren.utility.k.a(this.X)) * 31) + (this.H ? 1 : 0)) * 31) + com.vungle.warren.utility.k.a(this.I)) * 31) + (this.J ? 1 : 0)) * 31) + com.vungle.warren.utility.k.a(this.K)) * 31) + com.vungle.warren.utility.k.a(this.L)) * 31) + this.N) * 31)) + this.U)) * 31) + (this.V ? 1 : 0)) * 31) + (this.M ? 1 : 0);
    }

    public String i() {
        String strJ = j();
        String strJ2 = j();
        if (strJ2 != null && strJ2.length() > 3) {
            try {
                JSONObject jSONObject = new JSONObject(strJ2.substring(3));
                strJ = jSONObject.isNull("app_id") ? null : jSONObject.optString("app_id", null);
            } catch (JSONException e11) {
                Log.e("Advertisement", "JsonException : ", e11);
            }
        }
        return TextUtils.isEmpty(strJ) ? AppLovinMediationProvider.UNKNOWN : strJ;
    }

    public String j() {
        return this.f62138d;
    }

    public long k() {
        return this.S;
    }

    public String l() {
        return this.L;
    }

    @Nullable
    public String m(boolean z11) {
        int i11 = this.f62136b;
        if (i11 == 0) {
            return z11 ? this.f62155v : this.f62154u;
        }
        if (i11 == 1) {
            return this.f62155v;
        }
        throw new IllegalArgumentException("Unknown AdType " + this.f62136b);
    }

    public String n() {
        return this.f62143j;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public String o() {
        String str;
        String strN = n();
        if (TextUtils.isEmpty(strN)) {
            str = null;
        } else {
            String[] strArrSplit = strN.split("\\|");
            if (strArrSplit.length >= 1) {
                str = strArrSplit[0];
            } else {
                str = null;
            }
        }
        return TextUtils.isEmpty(str) ? AppLovinMediationProvider.UNKNOWN : str;
    }

    public List<a> p() {
        return this.f62140g;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public String q() {
        String str;
        String strN = n();
        if (TextUtils.isEmpty(strN)) {
            str = null;
        } else {
            String[] strArrSplit = strN.split("\\|");
            if (strArrSplit.length >= 2) {
                str = strArrSplit[1];
            } else {
                str = null;
            }
        }
        return TextUtils.isEmpty(str) ? AppLovinMediationProvider.UNKNOWN : str;
    }

    public boolean r() {
        return this.f62153t;
    }

    @Nullable
    public String s() {
        return this.Q;
    }

    public Map<String, String> t() {
        HashMap map = new HashMap();
        int i11 = this.f62136b;
        if (i11 == 0) {
            map.put("video", this.f62147n);
            if (!TextUtils.isEmpty(this.f62151r)) {
                map.put("postroll", this.f62151r);
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("Advertisement created without adType!");
            }
            if (!W()) {
                map.put("template", this.A);
            }
            Iterator<Map.Entry<String, Pair<String, String>>> it = this.D.entrySet().iterator();
            while (it.hasNext()) {
                String str = (String) it.next().getValue().first;
                if (X(str)) {
                    map.put(URLUtil.guessFileName(str, null, null), str);
                }
            }
        }
        return map;
    }

    @NonNull
    public String toString() {
        return "Advertisement{adType=" + this.f62136b + ", identifier='" + this.f62137c + "', appID='" + this.f62138d + "', expireTime=" + this.f62139f + ", checkpoints=" + this.f62135a.toJson(this.f62140g, AdvertisementDBAdapter.f62100f) + ", winNotifications='" + TextUtils.join(",", this.X) + ", dynamicEventsAndUrls=" + this.f62135a.toJson(this.f62141h, AdvertisementDBAdapter.f62101g) + ", delay=" + this.f62142i + ", campaign='" + this.f62143j + "', showCloseDelay=" + this.f62144k + ", showCloseIncentivized=" + this.f62145l + ", countdown=" + this.f62146m + ", videoUrl='" + this.f62147n + "', videoWidth=" + this.f62148o + ", videoHeight=" + this.f62149p + ", md5='" + this.f62150q + "', postrollBundleUrl='" + this.f62151r + "', ctaOverlayEnabled=" + this.f62152s + ", ctaClickArea=" + this.f62153t + ", ctaDestinationUrl='" + this.f62154u + "', ctaUrl='" + this.f62155v + "', adConfig=" + this.f62156w + ", retryCount=" + this.f62157x + ", adToken='" + this.f62158y + "', videoIdentifier='" + this.f62159z + "', templateUrl='" + this.A + "', templateSettings=" + this.B + ", mraidFiles=" + this.C + ", cacheableAssets=" + this.D + ", templateId='" + this.F + "', templateType='" + this.G + "', enableOm=" + this.H + ", oMSDKExtraVast='" + this.I + "', requiresNonMarketInstall=" + this.J + ", adMarketId='" + this.K + "', bidToken='" + this.L + "', state=" + this.N + "', assetDownloadStartTime='" + this.R + "', assetDownloadDuration='" + this.S + "', adRequestStartTime='" + this.T + "', requestTimestamp='" + this.U + "', headerBidding='" + this.M + '}';
    }

    public long u() {
        return this.f62139f * 1000;
    }

    @NonNull
    public String v() {
        String str = this.f62137c;
        return str == null ? "" : str;
    }

    public Map<String, String> w() {
        if (this.B == null) {
            throw new IllegalArgumentException("Advertisement does not have MRAID Arguments!");
        }
        HashMap map = new HashMap(this.B);
        for (Map.Entry<String, Pair<String, String>> entry : this.D.entrySet()) {
            map.put(entry.getKey(), entry.getValue().first);
        }
        if (!this.C.isEmpty()) {
            map.putAll(this.C);
        }
        if (!this.E.isEmpty()) {
            map.putAll(this.E);
        }
        if (!"true".equalsIgnoreCase((String) map.get("START_MUTED"))) {
            map.put("START_MUTED", (d().b() & 1) == 0 ? "false" : "true");
        }
        return map;
    }

    public boolean x() {
        return this.H;
    }

    public int y() {
        return this.f62148o > this.f62149p ? 1 : 0;
    }

    public String z() {
        return this.O;
    }
}
