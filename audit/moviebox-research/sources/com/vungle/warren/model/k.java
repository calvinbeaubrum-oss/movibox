package com.vungle.warren.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.gson.JsonObject;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.u;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f62178c = "consent_status";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f62179d = "consent_source";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f62180e = "no_interaction";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f62181f = "timestamp";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f62182g = "consent_message_version";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f62183h = "unknown";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f62184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Repository f62185b;

    public k(@NonNull j jVar) {
        this.f62184a = jVar;
    }

    public k(@NonNull Repository repository, u uVar) {
        this.f62185b = repository;
        j jVar = (j) repository.T("consentIsImportantToVungle", j.class).get(uVar.a(), TimeUnit.MILLISECONDS);
        this.f62184a = jVar == null ? a() : jVar;
    }

    public final j a() {
        j jVar = new j("consentIsImportantToVungle");
        jVar.e(f62182g, "");
        jVar.e(f62178c, f62183h);
        jVar.e(f62179d, f62180e);
        jVar.e(f62181f, 0L);
        return jVar;
    }

    public String b() {
        j jVar = this.f62184a;
        return jVar != null ? jVar.d(f62178c) : AppLovinMediationProvider.UNKNOWN;
    }

    public j c() {
        return this.f62184a;
    }

    public String d() {
        j jVar = this.f62184a;
        return jVar != null ? jVar.d(f62182g) : "";
    }

    public String e() {
        j jVar = this.f62184a;
        return jVar != null ? jVar.d(f62179d) : f62180e;
    }

    public Long f() {
        j jVar = this.f62184a;
        return Long.valueOf(jVar != null ? jVar.c(f62181f).longValue() : 0L);
    }

    public void g(JsonObject jsonObject) throws DatabaseHelper.DBException {
        if (this.f62185b == null) {
            return;
        }
        boolean z11 = l.e(jsonObject, "is_country_data_protected") && jsonObject.get("is_country_data_protected").getAsBoolean();
        String asString = l.e(jsonObject, "consent_title") ? jsonObject.get("consent_title").getAsString() : "";
        String asString2 = l.e(jsonObject, "consent_message") ? jsonObject.get("consent_message").getAsString() : "";
        String asString3 = l.e(jsonObject, "consent_message_version") ? jsonObject.get("consent_message_version").getAsString() : "";
        String asString4 = l.e(jsonObject, "button_accept") ? jsonObject.get("button_accept").getAsString() : "";
        String asString5 = l.e(jsonObject, "button_deny") ? jsonObject.get("button_deny").getAsString() : "";
        this.f62184a.e("is_country_data_protected", Boolean.valueOf(z11));
        j jVar = this.f62184a;
        if (TextUtils.isEmpty(asString)) {
            asString = "Targeted Ads";
        }
        jVar.e("consent_title", asString);
        j jVar2 = this.f62184a;
        if (TextUtils.isEmpty(asString2)) {
            asString2 = "To receive more relevant ad content based on your interactions with our ads, click \"I Consent\" below. Either way, you will see the same amount of ads.";
        }
        jVar2.e("consent_message", asString2);
        if (!"publisher".equalsIgnoreCase(this.f62184a.d(f62179d))) {
            this.f62184a.e(f62182g, TextUtils.isEmpty(asString3) ? "" : asString3);
        }
        j jVar3 = this.f62184a;
        if (TextUtils.isEmpty(asString4)) {
            asString4 = "I Consent";
        }
        jVar3.e("button_accept", asString4);
        j jVar4 = this.f62184a;
        if (TextUtils.isEmpty(asString5)) {
            asString5 = "I Do Not Consent";
        }
        jVar4.e("button_deny", asString5);
        this.f62185b.h0(this.f62184a);
    }
}
