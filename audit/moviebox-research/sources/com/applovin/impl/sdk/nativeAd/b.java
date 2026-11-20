package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import com.applovin.impl.aq;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.zm;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends yl implements a.InterfaceC0201a, AppLovinAdLoadListener {
    private final List A;
    private final List B;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JSONObject f22693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final JSONObject f22694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AppLovinNativeAdLoadListener f22695j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f22696k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f22697l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f22698m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Double f22699n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f22700o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Uri f22701p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Uri f22702q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private aq f22703r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Uri f22704s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Uri f22705t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Uri f22706u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Uri f22707v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final List f22708w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final List f22709x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final List f22710y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final List f22711z;

    public b(JSONObject jSONObject, JSONObject jSONObject2, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, j jVar) {
        super("TaskRenderNativeAd", jVar);
        this.f22696k = "";
        this.f22697l = "";
        this.f22698m = "";
        this.f22699n = null;
        this.f22700o = "";
        this.f22701p = null;
        this.f22702q = null;
        this.f22704s = null;
        this.f22705t = null;
        this.f22706u = null;
        this.f22707v = null;
        this.f22708w = new ArrayList();
        this.f22709x = new ArrayList();
        this.f22710y = new ArrayList();
        this.f22711z = new ArrayList();
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.f22693h = jSONObject;
        this.f22694i = jSONObject2;
        this.f22695j = appLovinNativeAdLoadListener;
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String string = JsonUtils.getString(jSONObject, "url", null);
        if (StringUtils.isValidString(string)) {
            this.f22706u = Uri.parse(string);
            if (n.a()) {
                this.f24691c.a(this.f24690b, "Processed click destination URL: " + this.f22706u);
            }
        }
        String string2 = JsonUtils.getString(jSONObject, "fallback", null);
        if (StringUtils.isValidString(string2)) {
            this.f22707v = Uri.parse(string2);
            if (n.a()) {
                this.f24691c.a(this.f24690b, "Processed click destination backup URL: " + this.f22707v);
            }
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "clicktrackers", null);
        if (jSONArray != null) {
            try {
                this.f22708w.addAll(JsonUtils.toList(jSONArray));
                if (n.a()) {
                    this.f24691c.a(this.f24690b, "Processed click tracking URLs: " + this.f22708w);
                }
            } catch (Throwable th2) {
                if (n.a()) {
                    this.f24691c.a(this.f24690b, "Failed to render click tracking URLs", th2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        if (n.a()) {
            this.f24691c.a(this.f24690b, "Preparing native ad view components...");
        }
        try {
            appLovinNativeAdImpl.setUpNativeAdViewComponents();
            if (n.a()) {
                this.f24691c.a(this.f24690b, "Successfully prepared native ad view components");
            }
            appLovinNativeAdImpl.getAdEventTracker().h();
            this.f22695j.onNativeAdLoaded(appLovinNativeAdImpl);
        } catch (Throwable th2) {
            if (n.a()) {
                this.f24691c.a(this.f24690b, "Failed to prepare native ad view components", th2);
            }
            b(th2.getMessage());
            this.f24689a.E().a(this.f24690b, "prepareNativeComponents", th2);
        }
    }

    private void b(String str) {
        this.f22695j.onNativeAdLoadFailed(new AppLovinError(-6, str));
    }

    private void c(final AppLovinNativeAdImpl appLovinNativeAdImpl) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.nativeAd.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f22717a.b(appLovinNativeAdImpl);
            }
        });
    }

    private void e() {
        AppLovinNativeAdImpl appLovinNativeAdImplBuild = new AppLovinNativeAdImpl.Builder(JsonUtils.shallowCopy(this.f22693h), JsonUtils.shallowCopy(this.f22694i), this.f24689a).setTitle(this.f22696k).setAdvertiser(this.f22697l).setBody(this.f22698m).setCallToAction(this.f22700o).setStarRating(this.f22699n).setIconUri(this.f22701p).setMainImageUri(this.f22702q).setPrivacyIconUri(this.f22704s).setVastAd(this.f22703r).setPrivacyDestinationUri(this.f22705t).setClickDestinationUri(this.f22706u).setClickDestinationBackupUri(this.f22707v).setClickTrackingUrls(this.f22708w).setJsTrackers(this.f22709x).setImpressionRequests(this.f22710y).setViewableMRC50Requests(this.f22711z).setViewableMRC100Requests(this.A).setViewableVideo50Requests(this.B).build();
        appLovinNativeAdImplBuild.getAdEventTracker().e();
        if (n.a()) {
            this.f24691c.a(this.f24690b, "Starting cache task for type: " + appLovinNativeAdImplBuild.getType() + "...");
        }
        this.f24689a.j0().a((yl) new a(appLovinNativeAdImplBuild, this.f24689a, this), tm.b.CORE);
    }

    @Override // com.applovin.impl.sdk.nativeAd.a.InterfaceC0201a
    public void a(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        if (n.a()) {
            this.f24691c.a(this.f24690b, "Successfully cached and loaded ad");
        }
        c(appLovinNativeAdImpl);
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        if (n.a()) {
            this.f24691c.a(this.f24690b, "VAST ad rendered successfully");
        }
        this.f22703r = (aq) appLovinAd;
        e();
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i11) {
        if (n.a()) {
            this.f24691c.b(this.f24690b, "VAST ad failed to render");
        }
        e();
    }

    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.String, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v63 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // java.lang.Runnable
    public void run() {
        ?? r11 = 0;
        String string = JsonUtils.getString(this.f22693h, "privacy_icon_url", null);
        if (URLUtil.isValidUrl(string)) {
            this.f22704s = Uri.parse(string);
        }
        String string2 = JsonUtils.getString(this.f22693h, CampaignEx.JSON_KEY_PRIVACY_URL, null);
        if (URLUtil.isValidUrl(string2)) {
            this.f22705t = Uri.parse(string2);
        }
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f22693h, "ortb_response", (JSONObject) null);
        if (jSONObject == null || jSONObject.length() == 0) {
            if (n.a()) {
                this.f24691c.b(this.f24690b, "No oRtb response provided: " + this.f22693h);
            }
            b("No oRtb response provided");
            return;
        }
        String string3 = JsonUtils.getString(jSONObject, "version", null);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, AppMeasurementSdk.ConditionalUserProperty.VALUE, (JSONObject) null);
        if (n.a()) {
            this.f24691c.a(this.f24690b, "Rendering native ad for oRTB version: " + string3);
        }
        JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, "native", jSONObject2);
        a(JsonUtils.getJSONObject(jSONObject3, "link", (JSONObject) null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject3, "assets", null);
        if (jSONArray == null || jSONArray.length() == 0) {
            if (n.a()) {
                this.f24691c.b(this.f24690b, "Unable to retrieve assets - failing ad load: " + this.f22693h);
            }
            b("Unable to retrieve assets");
            return;
        }
        String str = "";
        int i11 = 0;
        while (i11 < jSONArray.length()) {
            JSONObject jSONObject4 = JsonUtils.getJSONObject(jSONArray, i11, (JSONObject) r11);
            if (jSONObject4.has(CampaignEx.JSON_KEY_TITLE)) {
                this.f22696k = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, CampaignEx.JSON_KEY_TITLE, (JSONObject) r11), MimeTypes.BASE_TYPE_TEXT, r11);
                if (n.a()) {
                    this.f24691c.a(this.f24690b, "Processed title: " + this.f22696k);
                }
            } else if (jSONObject4.has("link")) {
                a(JsonUtils.getJSONObject(jSONObject4, "link", (JSONObject) r11));
            } else if (jSONObject4.has("img")) {
                int i12 = JsonUtils.getInt(jSONObject4, "id", -1);
                JSONObject jSONObject5 = JsonUtils.getJSONObject(jSONObject4, "img", (JSONObject) r11);
                int i13 = JsonUtils.getInt(jSONObject5, "type", -1);
                String string4 = JsonUtils.getString(jSONObject5, "url", r11);
                if (i13 == 1 || 3 == i12) {
                    this.f22701p = Uri.parse(string4);
                    if (n.a()) {
                        this.f24691c.a(this.f24690b, "Processed icon URL: " + this.f22701p);
                    }
                } else if (i13 == 3 || 2 == i12) {
                    this.f22702q = Uri.parse(string4);
                    if (n.a()) {
                        this.f24691c.a(this.f24690b, "Processed main image URL: " + this.f22702q);
                    }
                } else {
                    if (n.a()) {
                        this.f24691c.k(this.f24690b, "Unrecognized image: " + jSONObject4);
                    }
                    int i14 = JsonUtils.getInt(jSONObject5, "w", -1);
                    int i15 = JsonUtils.getInt(jSONObject5, "h", -1);
                    if (i14 <= 0 || i15 <= 0) {
                        if (n.a()) {
                            this.f24691c.k(this.f24690b, "Skipping...");
                        }
                    } else if (i14 / i15 > 1.0d) {
                        if (n.a()) {
                            this.f24691c.a(this.f24690b, "Inferring main image from " + i14 + "x" + i15 + "...");
                        }
                        this.f22702q = Uri.parse(string4);
                    } else {
                        if (n.a()) {
                            this.f24691c.a(this.f24690b, "Inferring icon image from " + i14 + "x" + i15 + "...");
                        }
                        this.f22701p = Uri.parse(string4);
                    }
                }
            } else if (jSONObject4.has("video")) {
                String string5 = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, "video", (JSONObject) null), "vasttag", null);
                if (StringUtils.isValidString(string5)) {
                    if (n.a()) {
                        this.f24691c.a(this.f24690b, "Processed VAST video");
                    }
                } else if (n.a()) {
                    this.f24691c.k(this.f24690b, "Ignoring invalid \"vasttag\" for video: " + jSONObject4);
                }
                str = string5;
            } else if (jSONObject4.has("data")) {
                int i16 = JsonUtils.getInt(jSONObject4, "id", -1);
                JSONObject jSONObject6 = JsonUtils.getJSONObject(jSONObject4, "data", (JSONObject) null);
                int i17 = JsonUtils.getInt(jSONObject6, "type", -1);
                String string6 = JsonUtils.getString(jSONObject6, AppMeasurementSdk.ConditionalUserProperty.VALUE, null);
                if (i17 == 1 || i16 == 8) {
                    this.f22697l = string6;
                    if (n.a()) {
                        this.f24691c.a(this.f24690b, "Processed advertiser: " + this.f22697l);
                    }
                } else if (i17 == 2 || i16 == 4) {
                    this.f22698m = string6;
                    if (n.a()) {
                        this.f24691c.a(this.f24690b, "Processed body: " + this.f22698m);
                    }
                } else if (i17 == 12 || i16 == 5) {
                    this.f22700o = string6;
                    if (n.a()) {
                        this.f24691c.a(this.f24690b, "Processed cta: " + this.f22700o);
                    }
                } else if (i17 == 3 || i16 == 6) {
                    double dA = yp.a(string6, -1.0d);
                    if (dA != -1.0d) {
                        this.f22699n = Double.valueOf(dA);
                        if (n.a()) {
                            this.f24691c.a(this.f24690b, "Processed star rating: " + this.f22699n);
                        }
                    } else if (n.a()) {
                        this.f24691c.a(this.f24690b, "Received invalid star rating: " + string6);
                    }
                } else if (n.a()) {
                    this.f24691c.k(this.f24690b, "Skipping unsupported data: " + jSONObject4);
                }
            } else if (n.a()) {
                this.f24691c.b(this.f24690b, "Unsupported asset object: " + jSONObject4);
            }
            i11++;
            r11 = 0;
        }
        String string7 = JsonUtils.getString(jSONObject3, "jstracker", null);
        if (StringUtils.isValidString(string7)) {
            this.f22709x.add(string7);
            if (n.a()) {
                this.f24691c.a(this.f24690b, "Processed jstracker: " + string7);
            }
        }
        Object obj = null;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject3, "imptrackers", null);
        if (jSONArray2 != null) {
            int i18 = 0;
            while (i18 < jSONArray2.length()) {
                Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray2, i18, obj);
                if (objectAtIndex instanceof String) {
                    String str2 = (String) objectAtIndex;
                    if (!TextUtils.isEmpty(str2)) {
                        this.f22710y.add(new com.applovin.impl.sdk.network.e.a(this.f24689a).b(str2).b(false).a(false).a());
                        if (n.a()) {
                            this.f24691c.a(this.f24690b, "Processed imptracker URL: " + str2);
                        }
                    }
                }
                i18++;
                obj = null;
            }
        }
        ?? r12 = 0;
        JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject3, "eventtrackers", null);
        if (jSONArray3 != null) {
            int i19 = 0;
            while (i19 < jSONArray3.length()) {
                JSONObject jSONObject7 = JsonUtils.getJSONObject(jSONArray3, i19, (JSONObject) r12);
                int i21 = JsonUtils.getInt(jSONObject7, NotificationCompat.CATEGORY_EVENT, -1);
                int i22 = JsonUtils.getInt(jSONObject7, "method", -1);
                String string8 = JsonUtils.getString(jSONObject7, "url", r12);
                if (!TextUtils.isEmpty(string8)) {
                    if (i22 == 1 || i22 == 2) {
                        if (i22 == 2 && string8.startsWith("<script")) {
                            this.f22709x.add(string8);
                        } else {
                            com.applovin.impl.sdk.network.e eVarA = new com.applovin.impl.sdk.network.e.a(this.f24689a).b(string8).b(false).a(false).h(i22 == 2).a();
                            if (i21 == 1) {
                                this.f22710y.add(eVarA);
                                if (n.a()) {
                                    this.f24691c.a(this.f24690b, "Processed impression URL: " + string8);
                                }
                            } else if (i21 == 2) {
                                this.f22711z.add(eVarA);
                                if (n.a()) {
                                    this.f24691c.a(this.f24690b, "Processed viewable MRC50 URL: " + string8);
                                }
                            } else if (i21 == 3) {
                                this.A.add(eVarA);
                                if (n.a()) {
                                    this.f24691c.a(this.f24690b, "Processed viewable MRC100 URL: " + string8);
                                }
                            } else if (i21 == 4) {
                                this.B.add(eVarA);
                                if (n.a()) {
                                    this.f24691c.a(this.f24690b, "Processed viewable video 50 URL: " + string8);
                                }
                            } else if (i21 == 555) {
                                if (n.a()) {
                                    this.f24691c.a(this.f24690b, "Ignoring processing of OMID URL: " + string8);
                                }
                            } else if (n.a()) {
                                this.f24691c.b(this.f24690b, "Unsupported event tracker: " + jSONObject7);
                            }
                        }
                    } else if (n.a()) {
                        this.f24691c.b(this.f24690b, "Unsupported method for event tracker: " + jSONObject7);
                    }
                }
                i19++;
                r12 = 0;
            }
        }
        if (!StringUtils.isValidString(str)) {
            e();
            return;
        }
        if (n.a()) {
            this.f24691c.a(this.f24690b, "Processing VAST video...");
        }
        this.f24689a.j0().a(zm.a(str, JsonUtils.shallowCopy(this.f22693h), JsonUtils.shallowCopy(this.f22694i), this, this.f24689a));
    }
}
