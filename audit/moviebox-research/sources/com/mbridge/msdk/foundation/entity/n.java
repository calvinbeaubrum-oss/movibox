package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.z;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f44338a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f44339b;
    private String A;
    private String B;
    private String C;
    private String D;
    private int E;
    private String F;
    private String G;
    private String I;
    private String J;
    private String K;
    private int L;
    private long M;
    private String N;
    private int O;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f44341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f44342e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f44344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f44345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f44346i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f44347j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f44348k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f44349l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f44350m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f44351n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f44352o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f44353p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f44354q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f44355r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f44356s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f44357t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f44358u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f44360w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f44361x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f44362y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f44363z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f44340c = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f44343f = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f44359v = 0;
    private int H = 0;

    public n() {
    }

    public n(Context context, CampaignEx campaignEx, int i11, String str, long j11, int i12) {
        if (i12 == 1 || i12 == 287 || i12 == 94) {
            this.f44356s = "m_download_end";
        } else if (i12 == 95) {
            this.f44356s = "2000025";
        }
        int iL = z.l(context);
        this.f44360w = iL;
        this.f44361x = z.a(context, iL);
        this.L = campaignEx.getVideoLength();
        this.A = campaignEx.getRequestId();
        this.B = campaignEx.getRequestIdNotice();
        if (!TextUtils.isEmpty(this.f44362y)) {
            try {
                this.f44362y = URLEncoder.encode(campaignEx.getNoticeUrl() == null ? campaignEx.getClickURL() : campaignEx.getNoticeUrl(), "utf-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        this.E = i11;
        this.f44348k = str;
        this.M = j11 == 0 ? campaignEx.getVideoSize() : j11;
    }

    public n(String str) {
        this.f44353p = str;
    }

    public n(String str, int i11, int i12, int i13, int i14, String str2, String str3, int i15, String str4, int i16, String str5) {
        this.f44356s = str;
        this.f44360w = i11;
        this.f44361x = str5;
        this.f44355r = i12;
        this.O = i13;
        this.L = i14;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.f44362y = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
        }
        this.f44363z = str3;
        this.E = i15;
        this.f44348k = str4;
        this.M = i16;
    }

    public n(String str, int i11, int i12, String str2, int i13, String str3, int i14, String str4) {
        this.f44356s = str;
        this.f44360w = i11;
        this.f44361x = str4;
        this.L = i12;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.f44362y = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        this.E = i13;
        this.f44348k = str3;
        this.M = i14;
    }

    public n(String str, int i11, String str2, String str3, String str4) {
        this.f44356s = str;
        this.f44361x = str4;
        this.f44360w = i11;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.f44362y = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        this.f44363z = str3;
    }

    public n(String str, int i11, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f44356s = str;
        this.E = i11;
        this.f44348k = str2;
        try {
            if (!TextUtils.isEmpty(str3)) {
                this.f44350m = URLEncoder.encode(str3, "utf-8");
            }
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
        }
        this.f44345h = str4;
        this.K = str5;
        this.f44363z = str6;
        this.f44349l = str7;
        if (Integer.valueOf(str2).intValue() > com.mbridge.msdk.foundation.same.a.K) {
            this.E = 2;
        }
    }

    public n(String str, String str2, String str3, String str4, String str5, int i11) {
        this.f44356s = str;
        this.f44345h = str2;
        this.A = str3;
        this.B = str4;
        this.K = str5;
        this.f44360w = i11;
    }

    public n(String str, String str2, String str3, String str4, String str5, int i11, int i12, String str6) {
        this.f44356s = str;
        this.f44345h = str2;
        this.A = str3;
        this.B = str4;
        this.K = str5;
        this.f44360w = i11;
        this.f44363z = str6;
        this.f44344g = i12;
    }

    public n(String str, String str2, String str3, String str4, String str5, String str6, int i11, String str7) {
        this.f44356s = str;
        this.f44352o = str2;
        this.J = str3;
        this.f44357t = str4;
        this.K = str5;
        this.f44345h = str6;
        this.f44360w = i11;
        this.f44361x = str7;
    }

    public static String a(n nVar) {
        if (nVar == null) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + nVar.f44356s + "&");
                stringBuffer.append("event=" + ai.a(nVar.f44352o) + "&");
                stringBuffer.append("template=" + ai.a(nVar.J) + "&");
                stringBuffer.append("layout=" + ai.a(nVar.f44357t) + "&");
                stringBuffer.append("unit_id=" + ai.a(nVar.K) + "&");
                stringBuffer.append("cid=" + ai.a(nVar.f44345h) + "&");
                stringBuffer.append("network_str=" + nVar.f44361x + "&");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("network_type=");
                sb2.append(nVar.f44360w);
                stringBuffer.append(sb2.toString());
            } else {
                stringBuffer.append("key=" + nVar.f44356s + "&");
                stringBuffer.append("event=" + ai.a(nVar.f44352o) + "&");
                stringBuffer.append("template=" + ai.a(nVar.J) + "&");
                stringBuffer.append("layout=" + ai.a(nVar.f44357t) + "&");
                stringBuffer.append("unit_id=" + ai.a(nVar.K) + "&");
                stringBuffer.append("cid=" + ai.a(nVar.f44345h) + "&");
            }
            return stringBuffer.toString();
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static String a(List<n> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<n> it = list.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.C != null) {
                stringBuffer.append("resource_type=" + next.C + "&");
            }
            if (next.f44346i != null) {
                stringBuffer.append("creative=" + next.f44346i + "&");
            }
            Iterator<n> it2 = it;
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + next.f44356s + "&");
                stringBuffer.append("network_type=" + next.f44360w + "&");
                stringBuffer.append("network_str=" + next.f44361x + "&");
                stringBuffer.append("result=" + next.E + "&");
                stringBuffer.append("duration=" + next.f44348k + "&");
                stringBuffer.append("video_size=" + next.M + "&");
                stringBuffer.append("video_length=" + next.L + "&");
                stringBuffer.append("reason=" + next.h() + "&");
                stringBuffer.append("cid=" + next.f44345h + "&");
                stringBuffer.append("video_url=" + next.N + "&");
                stringBuffer.append("rid=" + next.A + "&");
                stringBuffer.append("rid_n=" + next.B + "&");
                stringBuffer.append("unit_id=" + next.K + "&");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("offer_url=");
                sb2.append(next.f44362y);
                stringBuffer.append(sb2.toString());
                stringBuffer.append("\n");
            } else {
                stringBuffer.append("key=" + next.f44356s + "&");
                stringBuffer.append("result=" + next.E + "&");
                stringBuffer.append("duration=" + next.f44348k + "&");
                stringBuffer.append("video_size=" + next.M + "&");
                stringBuffer.append("video_length=" + next.L + "&");
                stringBuffer.append("reason=" + next.h() + "&");
                stringBuffer.append("cid=" + next.f44345h + "&");
                stringBuffer.append("video_url=" + next.N + "&");
                stringBuffer.append("rid=" + next.A + "&");
                stringBuffer.append("rid_n=" + next.B + "&");
                stringBuffer.append("unit_id=" + next.K + "&");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("offer_url=");
                sb3.append(next.f44362y);
                stringBuffer.append(sb3.toString());
                stringBuffer.append("\n");
            }
            it = it2;
        }
        return stringBuffer.toString();
    }

    public static String b(n nVar) {
        if (nVar == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + nVar.f44356s + "&");
        stringBuffer.append("cid=" + nVar.f44345h + "&");
        stringBuffer.append("rid=" + nVar.A + "&");
        stringBuffer.append("rid_n=" + nVar.B + "&");
        stringBuffer.append("unit_id=" + nVar.K + "&");
        stringBuffer.append("network_type=" + nVar.f44360w + "&");
        stringBuffer.append("mraid_type=" + nVar.f44359v + "&");
        stringBuffer.append("platform=1");
        return stringBuffer.toString();
    }

    public static String b(List<n> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (n nVar : list) {
            stringBuffer.append("key=" + nVar.f44356s + "&");
            stringBuffer.append("result=" + nVar.E + "&");
            stringBuffer.append("duration=" + nVar.f44348k + "&");
            stringBuffer.append("endcard_url=" + nVar.f44350m + "&");
            stringBuffer.append("cid=" + nVar.f44345h + "&");
            stringBuffer.append("unit_id=" + nVar.K + "&");
            stringBuffer.append("reason=" + nVar.h() + "&");
            stringBuffer.append("ad_type=" + nVar.f44341d + "&");
            stringBuffer.append("rid=" + nVar.A + "&");
            stringBuffer.append("rid_n=" + nVar.B + "&");
            stringBuffer.append("type=" + nVar.f44349l + "&");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("adspace_t=");
            sb2.append(nVar.f44342e);
            stringBuffer.append(sb2.toString());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public static String c(n nVar) {
        if (nVar == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + nVar.f44356s + "&");
        stringBuffer.append("cid=" + nVar.f44345h + "&");
        stringBuffer.append("rid=" + nVar.A + "&");
        stringBuffer.append("rid_n=" + nVar.B + "&");
        stringBuffer.append("unit_id=" + nVar.K + "&");
        stringBuffer.append("reason=" + nVar.h() + "&");
        stringBuffer.append("case=" + nVar.f44344g + "&");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("network_type=");
        sb2.append(nVar.f44360w);
        stringBuffer.append(sb2.toString());
        return stringBuffer.toString();
    }

    public static String c(List<n> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<n> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().f44353p);
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        } catch (Throwable th2) {
            ad.a("VideoReportData", th2.getMessage(), th2);
            return null;
        }
    }

    public static String d(n nVar) {
        if (nVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + nVar.f44356s + "&");
        stringBuffer.append("cid=" + nVar.f44345h + "&");
        stringBuffer.append("unit_id=" + nVar.K + "&");
        stringBuffer.append("network_type=" + nVar.f44360w + "&");
        stringBuffer.append("rid=" + nVar.A + "&");
        stringBuffer.append("rid_n=" + nVar.B + "&");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("reason=");
        sb2.append(nVar.h());
        stringBuffer.append(sb2.toString());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public static String d(List<n> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (n nVar : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + nVar.f44356s + "&");
                stringBuffer.append("network_type=" + nVar.f44360w + "&");
                stringBuffer.append("cid=" + nVar.f44345h + "&");
                stringBuffer.append("image_url=" + nVar.f44354q + "&");
                stringBuffer.append("reason=" + nVar.h() + "&");
                stringBuffer.append("rid=" + nVar.A + "&");
                stringBuffer.append("rid_n=" + nVar.B + "&");
                stringBuffer.append("unit_id=" + nVar.K + "&");
                stringBuffer.append("\n");
            } else {
                stringBuffer.append("key=" + nVar.f44356s + "&");
                stringBuffer.append("cid=" + nVar.f44345h + "&");
                stringBuffer.append("image_url=" + nVar.f44354q + "&");
                stringBuffer.append("reason=" + nVar.h() + "&");
                stringBuffer.append("rid=" + nVar.A + "&");
                stringBuffer.append("rid_n=" + nVar.B + "&");
                stringBuffer.append("unit_id=" + nVar.K + "&");
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String e(n nVar) {
        if (nVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + nVar.f44356s + "&");
        stringBuffer.append("result=" + nVar.E + "&");
        stringBuffer.append("duration=" + nVar.f44348k + "&");
        stringBuffer.append("cid=" + nVar.f44345h + "&");
        stringBuffer.append("unit_id=" + nVar.K + "&");
        stringBuffer.append("reason=" + nVar.h() + "&");
        stringBuffer.append("ad_type=" + nVar.f44341d + "&");
        stringBuffer.append("rid=" + nVar.A + "&");
        stringBuffer.append("rid_n=" + nVar.B + "&");
        stringBuffer.append("network_type=" + nVar.f44360w + "&");
        stringBuffer.append("mraid_type=" + nVar.f44359v + "&");
        stringBuffer.append("devid=" + nVar.f44347j + "&");
        if (nVar.C != null) {
            stringBuffer.append("resource_type=" + nVar.C + "&");
        }
        if (!TextUtils.isEmpty(nVar.f44350m)) {
            stringBuffer.append("endcard_url=" + nVar.f44350m + "&");
        }
        stringBuffer.append("type=" + nVar.f44349l);
        return stringBuffer.toString();
    }

    public static String e(List<n> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (n nVar : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + nVar.f44356s + "&");
                stringBuffer.append("network_type=" + nVar.f44360w + "&");
                stringBuffer.append("network_str=" + nVar.f44361x + "&");
                stringBuffer.append("reason=" + nVar.h() + "&");
                stringBuffer.append("cid=" + nVar.f44345h + "&");
                stringBuffer.append("video_url=" + nVar.N + "&");
                stringBuffer.append("rid=" + nVar.A + "&");
                stringBuffer.append("rid_n=" + nVar.B + "&");
                stringBuffer.append("unit_id=" + nVar.K + "&");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("offer_url=");
                sb2.append(nVar.f44362y);
                stringBuffer.append(sb2.toString());
                stringBuffer.append("\n");
            } else {
                stringBuffer.append("key=" + nVar.f44356s + "&");
                stringBuffer.append("reason=" + nVar.h() + "&");
                stringBuffer.append("cid=" + nVar.f44345h + "&");
                stringBuffer.append("video_url=" + nVar.N + "&");
                stringBuffer.append("rid=" + nVar.A + "&");
                stringBuffer.append("rid_n=" + nVar.B + "&");
                stringBuffer.append("unit_id=" + nVar.K + "&");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("offer_url=");
                sb3.append(nVar.f44362y);
                stringBuffer.append(sb3.toString());
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String f(n nVar) {
        if (nVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + nVar.f44356s + "&");
        stringBuffer.append("cid=" + nVar.f44345h + "&");
        stringBuffer.append("unit_id=" + nVar.K + "&");
        stringBuffer.append("network_type=" + nVar.f44360w + "&");
        stringBuffer.append("mraid_type=" + nVar.f44359v + "&");
        stringBuffer.append("rid_n=" + nVar.B + "&");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rid=");
        sb2.append(nVar.A);
        stringBuffer.append(sb2.toString());
        return stringBuffer.toString();
    }

    public static String f(List<n> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (n nVar : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + nVar.f44356s + "&");
                stringBuffer.append("network_type=" + nVar.f44360w + "&");
                stringBuffer.append("result=" + nVar.E + "&");
                stringBuffer.append("cid=" + nVar.f44345h + "&");
                stringBuffer.append("template_url=" + nVar.I + "&");
                stringBuffer.append("reason=" + nVar.h() + "&");
                stringBuffer.append("rid=" + nVar.A + "&");
                stringBuffer.append("rid_n=" + nVar.B + "&");
                stringBuffer.append("unit_id=" + nVar.K + "&");
                stringBuffer.append("\n");
            } else {
                stringBuffer.append("key=" + nVar.f44356s + "&");
                stringBuffer.append("result=" + nVar.E + "&");
                stringBuffer.append("cid=" + nVar.f44345h + "&");
                stringBuffer.append("template_url=" + nVar.I + "&");
                stringBuffer.append("reason=" + nVar.h() + "&");
                stringBuffer.append("rid=" + nVar.A + "&");
                stringBuffer.append("rid_n=" + nVar.B + "&");
                stringBuffer.append("unit_id=" + nVar.K + "&");
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String g(n nVar) {
        if (nVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + nVar.f44356s + "&");
        stringBuffer.append("result=" + nVar.E + "&");
        stringBuffer.append("duration=" + nVar.f44348k + "&");
        stringBuffer.append("cid=" + nVar.f44345h + "&");
        stringBuffer.append("reason=" + nVar.h() + "&");
        stringBuffer.append("ad_type=" + nVar.f44341d + "&");
        stringBuffer.append("unit_id=" + nVar.K + "&");
        stringBuffer.append("devid=" + nVar.f44347j + "&");
        stringBuffer.append("mraid_type=" + nVar.f44359v + "&");
        stringBuffer.append("network_type=" + nVar.f44360w + "&");
        if (!TextUtils.isEmpty(nVar.f44350m)) {
            stringBuffer.append("endcard_url=" + nVar.f44350m + "&");
        }
        if (!TextUtils.isEmpty(nVar.f44349l)) {
            stringBuffer.append("type=" + nVar.f44349l + "&");
        }
        if (nVar.C != null) {
            stringBuffer.append("resource_type=" + nVar.C + "&");
        }
        stringBuffer.append("rid_n=" + nVar.B + "&");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rid=");
        sb2.append(nVar.A);
        stringBuffer.append(sb2.toString());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public static String h(n nVar) {
        if (nVar == null) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + nVar.f44356s + "&");
                stringBuffer.append("error=" + ai.a(nVar.f44351n) + "&");
                stringBuffer.append("template_url=" + ai.a(nVar.I) + "&");
                stringBuffer.append("unit_id=" + ai.a(nVar.K) + "&");
                stringBuffer.append("cid=" + ai.a(nVar.f44345h) + "&");
                stringBuffer.append("network_str=" + nVar.f44361x + "&");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("network_type=");
                sb2.append(nVar.f44360w);
                stringBuffer.append(sb2.toString());
            } else {
                stringBuffer.append("key=" + nVar.f44356s + "&");
                stringBuffer.append("error=" + ai.a(nVar.f44351n) + "&");
                stringBuffer.append("template_url=" + ai.a(nVar.I) + "&");
                stringBuffer.append("unit_id=" + ai.a(nVar.K) + "&");
                stringBuffer.append("cid=" + ai.a(nVar.f44345h) + "&");
            }
            return stringBuffer.toString();
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final int A() {
        return this.H;
    }

    public final String a() {
        return this.f44356s;
    }

    public final void a(int i11) {
        this.f44360w = i11;
    }

    public final void a(String str) {
        this.f44356s = str;
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f44340c == null) {
            this.f44340c = new HashMap();
        }
        try {
            this.f44340c.put(str, str2);
        } catch (Exception unused) {
        }
    }

    public final String b() {
        return this.C;
    }

    public final String b(String str, String str2) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.f44340c) == null) {
            return str2;
        }
        try {
            String str3 = map.get(str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Exception unused) {
            return str2;
        }
    }

    public final void b(int i11) {
        this.E = i11;
    }

    public final void b(String str) {
        this.C = str;
    }

    public final String c() {
        return this.K;
    }

    public final void c(int i11) {
        this.f44342e = i11;
    }

    public final void c(String str) {
        this.K = str;
    }

    public final String d() {
        return this.f44341d;
    }

    public final void d(int i11) {
        this.f44359v = i11;
    }

    public final void d(String str) {
        this.f44341d = str;
    }

    public final String e() {
        return this.f44345h;
    }

    public final void e(int i11) {
        this.H = i11;
    }

    public final void e(String str) {
        this.f44345h = str;
    }

    public final String f() {
        return this.A;
    }

    public final void f(String str) {
        this.A = str;
    }

    public final String g() {
        return this.B;
    }

    public final void g(String str) {
        this.B = str;
    }

    public final String h() {
        return TextUtils.isEmpty(this.f44363z) ? "" : this.f44363z;
    }

    public final void h(String str) {
        this.f44363z = str;
    }

    public final String i() {
        return this.f44346i;
    }

    public final void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f44346i = URLEncoder.encode(str);
    }

    public final String j() {
        return this.f44347j;
    }

    public final void j(String str) {
        this.f44347j = str;
    }

    public final int k() {
        return this.f44360w;
    }

    public final void k(String str) {
        this.f44361x = str;
    }

    public final String l() {
        return this.f44361x;
    }

    public final void l(String str) {
        this.f44348k = str;
    }

    public final int m() {
        return this.E;
    }

    public final void m(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.N = URLEncoder.encode(str, "utf-8");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final String n() {
        return this.f44348k;
    }

    public final void n(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f44350m = URLEncoder.encode(str, "utf-8");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final long o() {
        return this.M;
    }

    public final void o(String str) {
        this.f44349l = str;
    }

    public final int p() {
        return this.L;
    }

    public final void p(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f44354q = URLEncoder.encode(str, "utf-8");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final String q() {
        return this.N;
    }

    public final void q(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.I = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
        }
    }

    public final String r() {
        return this.f44362y;
    }

    public final void r(String str) {
        this.f44351n = str;
    }

    public final String s() {
        return this.f44350m;
    }

    public final void s(String str) {
        this.f44358u = str;
    }

    public final String t() {
        return this.f44349l;
    }

    public final void t(String str) {
        this.D = str;
    }

    public final String toString() {
        return "RewardReportData [key=" + this.f44356s + ", networkType=" + this.f44360w + ", isCompleteView=" + this.f44355r + ", watchedMillis=" + this.O + ", videoLength=" + this.L + ", offerUrl=" + this.f44362y + ", reason=" + this.f44363z + ", result=" + this.E + ", duration=" + this.f44348k + ", videoSize=" + this.M + "]";
    }

    public final int u() {
        return this.f44342e;
    }

    public final void u(String str) {
        this.F = str;
    }

    public final String v() {
        return this.f44354q;
    }

    public final void v(String str) {
        this.G = str;
    }

    public final int w() {
        return this.f44355r;
    }

    public final int x() {
        return this.O;
    }

    public final int y() {
        return this.f44359v;
    }

    public final String z() {
        return this.I;
    }
}
