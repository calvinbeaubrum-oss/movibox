package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class wp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f24154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f24155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24156c = a(uj.f23592i, (String) vj.a(uj.f23591h, (Object) null, com.applovin.impl.sdk.j.l()));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f24157d;

    public wp(com.applovin.impl.sdk.j jVar) {
        this.f24154a = jVar;
        this.f24157d = a(uj.f23593j, (String) jVar.a(sj.f22956g));
        a(d());
    }

    public static String a(com.applovin.impl.sdk.j jVar) {
        uj ujVar = uj.f23594k;
        String str = (String) jVar.a(ujVar);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strValueOf = String.valueOf(((int) (Math.random() * 100.0d)) + 1);
        jVar.b(ujVar, strValueOf);
        return strValueOf;
    }

    private String a(uj ujVar, String str) {
        String str2 = (String) vj.a(ujVar, (Object) null, com.applovin.impl.sdk.j.l());
        if (StringUtils.isValidString(str2)) {
            return str2;
        }
        if (!StringUtils.isValidString(str)) {
            str = UUID.randomUUID().toString().toLowerCase(Locale.US);
        }
        vj.b(ujVar, str, com.applovin.impl.sdk.j.l());
        return str;
    }

    private String d() {
        if (!((Boolean) this.f24154a.a(sj.T3)).booleanValue()) {
            this.f24154a.c(uj.f23590g);
        }
        String str = (String) this.f24154a.a(uj.f23590g);
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        this.f24154a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f24154a.J().a("AppLovinSdk", "Using identifier (" + str + ") from previous session");
        }
        return str;
    }

    public String a() {
        return this.f24157d;
    }

    public void a(String str) {
        if (((Boolean) this.f24154a.a(sj.T3)).booleanValue()) {
            this.f24154a.b(uj.f23590g, str);
        }
        this.f24155b = str;
        this.f24154a.p().b(str, a());
    }

    public String b() {
        return this.f24156c;
    }

    public String c() {
        return this.f24155b;
    }
}
