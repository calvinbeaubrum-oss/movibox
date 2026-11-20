package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.mediation.MaxAdFormat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class xe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f24310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f24311b;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        AD_UNIT_ID,
        AD_FORMAT,
        AD
    }

    private xe(a aVar, String str) {
        this.f24310a = aVar;
        this.f24311b = str;
    }

    public static xe a(ge geVar) {
        String strT = geVar.T();
        if (TextUtils.isEmpty(strT)) {
            return null;
        }
        return new xe(a.AD, strT);
    }

    public static xe a(MaxAdFormat maxAdFormat) {
        String label = maxAdFormat.getLabel();
        if (TextUtils.isEmpty(label)) {
            return null;
        }
        return new xe(a.AD_FORMAT, label);
    }

    public static xe a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new xe(a.AD_UNIT_ID, str);
    }

    public a a() {
        return this.f24310a;
    }

    public String b() {
        return this.f24311b;
    }
}
