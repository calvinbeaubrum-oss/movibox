package org.jsoup.parser;

import androidx.core.app.NotificationCompat;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map<String, f> f73179j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f73180k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f73181l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f73182m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f73183n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f73184o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f73185p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String[] f73186q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f73187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f73188b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f73189c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f73190d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f73191e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f73192f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f73193g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f73194h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f73195i = false;

    static {
        String[] strArr = {"html", TtmlNode.TAG_HEAD, TtmlNode.TAG_BODY, "frameset", "script", "noscript", TtmlNode.TAG_STYLE, "meta", "link", CampaignEx.JSON_KEY_TITLE, "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", TtmlNode.TAG_P, "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", TtmlNode.TAG_DIV, "blockquote", "hr", PlaceTypes.ADDRESS, "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", MimeTypes.BASE_TYPE_AUDIO, "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math"};
        f73180k = strArr;
        f73181l = new String[]{"object", "base", "font", TtmlNode.TAG_TT, "i", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "u", "big", "small", "em", "strong", "dfn", TrackingKey.CODE, "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", TtmlNode.TAG_BR, "wbr", "map", CampaignEx.JSON_KEY_AD_Q, "sub", "sup", "bdo", "iframe", "embed", TtmlNode.TAG_SPAN, "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", NotificationCompat.CATEGORY_PROGRESS, "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", "s"};
        f73182m = new String[]{"meta", "link", "base", "frame", "img", TtmlNode.TAG_BR, "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
        f73183n = new String[]{CampaignEx.JSON_KEY_TITLE, "a", TtmlNode.TAG_P, "h1", "h2", "h3", "h4", "h5", "h6", "pre", PlaceTypes.ADDRESS, "li", "th", "td", "script", TtmlNode.TAG_STYLE, "ins", "del", "s"};
        f73184o = new String[]{"pre", "plaintext", CampaignEx.JSON_KEY_TITLE, "textarea"};
        f73185p = new String[]{"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
        f73186q = new String[]{"input", "keygen", "object", "select", "textarea"};
        for (String str : strArr) {
            i(new f(str));
        }
        for (String str2 : f73181l) {
            f fVar = new f(str2);
            fVar.f73188b = false;
            fVar.f73189c = false;
            i(fVar);
        }
        for (String str3 : f73182m) {
            f fVar2 = f73179j.get(str3);
            d30.d.j(fVar2);
            fVar2.f73190d = false;
            fVar2.f73191e = true;
        }
        for (String str4 : f73183n) {
            f fVar3 = f73179j.get(str4);
            d30.d.j(fVar3);
            fVar3.f73189c = false;
        }
        for (String str5 : f73184o) {
            f fVar4 = f73179j.get(str5);
            d30.d.j(fVar4);
            fVar4.f73193g = true;
        }
        for (String str6 : f73185p) {
            f fVar5 = f73179j.get(str6);
            d30.d.j(fVar5);
            fVar5.f73194h = true;
        }
        for (String str7 : f73186q) {
            f fVar6 = f73179j.get(str7);
            d30.d.j(fVar6);
            fVar6.f73195i = true;
        }
    }

    public f(String str) {
        this.f73187a = str;
    }

    public static void i(f fVar) {
        f73179j.put(fVar.f73187a, fVar);
    }

    public static f k(String str) {
        return l(str, d.f73172d);
    }

    public static f l(String str, d dVar) {
        d30.d.j(str);
        Map<String, f> map = f73179j;
        f fVar = map.get(str);
        if (fVar != null) {
            return fVar;
        }
        String strB = dVar.b(str);
        d30.d.h(strB);
        f fVar2 = map.get(strB);
        if (fVar2 != null) {
            return fVar2;
        }
        f fVar3 = new f(strB);
        fVar3.f73188b = false;
        return fVar3;
    }

    public boolean a() {
        return this.f73189c;
    }

    public String b() {
        return this.f73187a;
    }

    public boolean c() {
        return this.f73188b;
    }

    public boolean d() {
        return this.f73191e;
    }

    public boolean e() {
        return this.f73194h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f73187a.equals(fVar.f73187a) && this.f73190d == fVar.f73190d && this.f73191e == fVar.f73191e && this.f73189c == fVar.f73189c && this.f73188b == fVar.f73188b && this.f73193g == fVar.f73193g && this.f73192f == fVar.f73192f && this.f73194h == fVar.f73194h && this.f73195i == fVar.f73195i;
    }

    public boolean f() {
        return f73179j.containsKey(this.f73187a);
    }

    public boolean g() {
        return this.f73191e || this.f73192f;
    }

    public boolean h() {
        return this.f73193g;
    }

    public int hashCode() {
        return (((((((((((((((this.f73187a.hashCode() * 31) + (this.f73188b ? 1 : 0)) * 31) + (this.f73189c ? 1 : 0)) * 31) + (this.f73190d ? 1 : 0)) * 31) + (this.f73191e ? 1 : 0)) * 31) + (this.f73192f ? 1 : 0)) * 31) + (this.f73193g ? 1 : 0)) * 31) + (this.f73194h ? 1 : 0)) * 31) + (this.f73195i ? 1 : 0);
    }

    public f j() {
        this.f73192f = true;
        return this;
    }

    public String toString() {
        return this.f73187a;
    }
}
