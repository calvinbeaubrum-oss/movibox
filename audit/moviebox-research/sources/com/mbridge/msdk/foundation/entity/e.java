package com.mbridge.msdk.foundation.entity;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f44261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f44262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f44263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f44264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f44265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f44266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f44267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f44268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f44269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f44270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f44271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f44272l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f44273m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f44274n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f44275o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f44276p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f44277q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f44278r;

    public e() {
    }

    public e(String str, String str2, String str3, String str4, String str5, int i11, String str6, String str7, String str8, int i12, int i13, String str9, int i14, int i15, String str10, int i16, int i17, String str11) {
        this.f44275o = str;
        this.f44276p = str2;
        this.f44261a = str3;
        this.f44262b = str4;
        this.f44270j = str5;
        this.f44265e = i11;
        this.f44267g = str6;
        this.f44268h = str7;
        this.f44266f = str8;
        this.f44277q = i12;
        this.f44264d = i13;
        this.f44278r = str9;
        this.f44269i = i14;
        this.f44271k = i15;
        this.f44263c = str10;
        this.f44274n = i16;
        this.f44273m = str11;
        this.f44272l = i17;
    }

    public static String a(e eVar) {
        if (eVar == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        String str = eVar.f44270j;
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            sb2.append("rid=" + eVar.f44275o);
            sb2.append("&rid_n=" + eVar.f44276p);
            sb2.append("&network_type=" + eVar.f44274n);
            sb2.append("&network_str=" + eVar.f44273m);
            sb2.append("&click_type=" + eVar.f44264d);
            sb2.append("&type=" + eVar.f44277q);
            sb2.append("&cid=" + eVar.f44261a);
            sb2.append("&click_duration=" + eVar.f44262b);
            sb2.append("&key=2000012");
            sb2.append("&unit_id=" + eVar.f44278r);
            sb2.append("&last_url=" + str);
            sb2.append("&code=" + eVar.f44265e);
            sb2.append("&exception=" + eVar.f44267g);
            sb2.append("&landing_type=" + eVar.f44269i);
            sb2.append("&link_type=" + eVar.f44271k);
            sb2.append("&click_time=" + eVar.f44263c + "\n");
        } else {
            sb2.append("rid=" + eVar.f44275o);
            sb2.append("&rid_n=" + eVar.f44276p);
            sb2.append("&click_type=" + eVar.f44264d);
            sb2.append("&type=" + eVar.f44277q);
            sb2.append("&cid=" + eVar.f44261a);
            sb2.append("&click_duration=" + eVar.f44262b);
            sb2.append("&key=2000012");
            sb2.append("&unit_id=" + eVar.f44278r);
            sb2.append("&last_url=" + str);
            sb2.append("&code=" + eVar.f44265e);
            sb2.append("&exception=" + eVar.f44267g);
            sb2.append("&landing_type=" + eVar.f44269i);
            sb2.append("&link_type=" + eVar.f44271k);
            sb2.append("&click_time=" + eVar.f44263c + "\n");
        }
        return sb2.toString();
    }

    public static String a(List<e> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<e> it = list.iterator();
        while (it.hasNext()) {
            e next = it.next();
            String str = next.f44278r;
            if (!TextUtils.isEmpty(str)) {
                String str2 = com.mbridge.msdk.foundation.controller.a.f44041b.get(str);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("u_stid=");
                if (str2 == null) {
                    str2 = "";
                }
                sb3.append(str2);
                sb3.append("&");
                sb2.append(sb3.toString());
            }
            Iterator<e> it2 = it;
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                sb2.append("rid=" + next.f44275o);
                sb2.append("&rid_n=" + next.f44276p);
                sb2.append("&network_type=" + next.f44274n);
                sb2.append("&network_str=" + next.f44273m);
                sb2.append("&cid=" + next.f44261a);
                sb2.append("&click_type=" + next.f44264d);
                sb2.append("&type=" + next.f44277q);
                sb2.append("&click_duration=" + next.f44262b);
                sb2.append("&key=2000013");
                sb2.append("&unit_id=" + next.f44278r);
                sb2.append("&last_url=" + next.f44270j);
                sb2.append("&content=" + next.f44266f);
                sb2.append("&code=" + next.f44265e);
                sb2.append("&exception=" + next.f44267g);
                sb2.append("&header=" + next.f44268h);
                sb2.append("&landing_type=" + next.f44269i);
                sb2.append("&link_type=" + next.f44271k);
                sb2.append("&click_time=" + next.f44263c + "\n");
            } else {
                sb2.append("rid=" + next.f44275o);
                sb2.append("&rid_n=" + next.f44276p);
                sb2.append("&cid=" + next.f44261a);
                sb2.append("&click_type=" + next.f44264d);
                sb2.append("&type=" + next.f44277q);
                sb2.append("&click_duration=" + next.f44262b);
                sb2.append("&key=2000013");
                sb2.append("&unit_id=" + next.f44278r);
                sb2.append("&last_url=" + next.f44270j);
                sb2.append("&content=" + next.f44266f);
                sb2.append("&code=" + next.f44265e);
                sb2.append("&exception=" + next.f44267g);
                sb2.append("&header=" + next.f44268h);
                sb2.append("&landing_type=" + next.f44269i);
                sb2.append("&link_type=" + next.f44271k);
                sb2.append("&click_time=" + next.f44263c + "\n");
            }
            it = it2;
        }
        return sb2.toString();
    }

    public final void a(int i11) {
        this.f44274n = i11;
    }

    public final void a(String str) {
        this.f44278r = str;
    }

    public final void b(int i11) {
        this.f44264d = i11;
    }

    public final void b(String str) {
        this.f44275o = str;
    }

    public final void c(int i11) {
        this.f44277q = i11;
    }

    public final void c(String str) {
        this.f44273m = str;
    }

    public final void d(int i11) {
        this.f44269i = i11;
    }

    public final void d(String str) {
        this.f44267g = str;
    }

    public final void e(int i11) {
        this.f44271k = i11;
    }

    public final void e(String str) {
        this.f44263c = str;
    }

    public final void f(int i11) {
        this.f44265e = i11;
    }

    public final void f(String str) {
        this.f44268h = str;
    }

    public final void g(String str) {
        this.f44266f = str;
    }

    public final void h(String str) {
        this.f44270j = str;
    }

    public final void i(String str) {
        this.f44262b = str;
    }

    public final void j(String str) {
        this.f44261a = str;
    }

    public final void k(String str) {
        this.f44276p = str;
    }

    public final String toString() {
        return "ClickTime [campaignId=" + this.f44261a + ", click_duration=" + this.f44262b + ", lastUrl=" + this.f44270j + ", code=" + this.f44265e + ", excepiton=" + this.f44267g + ", header=" + this.f44268h + ", content=" + this.f44266f + ", type=" + this.f44277q + ", click_type=" + this.f44264d + "]";
    }
}
