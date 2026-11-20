package com.mbridge.msdk.newreward.function.g;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.same.net.h.e;
import com.mbridge.msdk.foundation.same.net.h.f;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.newreward.function.d.b.g;
import java.net.URLEncoder;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f46491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f46492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f46493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f46494d;

    public final void a(int i11) {
        this.f46492b = i11;
    }

    public final void a(String str) {
        this.f46491a = str;
    }

    public final String b() {
        return this.f46491a;
    }

    public final void b(int i11) {
        this.f46494d = i11;
    }

    public final void b(String str) {
        this.f46493c = str;
    }

    public final Map<String, String> c() {
        e eVar = new e(a());
        if (this.f46494d == g.f46338b && !TextUtils.isEmpty(this.f46491a)) {
            eVar.a("unit_ids", String.format("[%s]", this.f46491a));
        }
        eVar.a("vtag", TextUtils.isEmpty(this.f46493c) ? "" : this.f46493c);
        if (com.mbridge.msdk.f.b.a()) {
            String strB = Aa.b();
            if (!TextUtils.isEmpty(strB)) {
                eVar.a("keyword", strB);
            }
        }
        com.mbridge.msdk.c.a.d.a(com.mbridge.msdk.foundation.controller.c.m().c(), eVar);
        f.d(eVar);
        f.f(eVar);
        return eVar.a();
    }

    public final String d() {
        StringBuilder sb2 = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : c().entrySet()) {
                if (sb2.length() > 0) {
                    sb2.append('&');
                }
                sb2.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb2.append("=");
                sb2.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
        } catch (Throwable th2) {
            ad.b("RewardSettingReqParameters", th2.getMessage());
        }
        return sb2.toString();
    }
}
