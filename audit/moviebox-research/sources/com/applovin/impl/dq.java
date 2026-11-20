package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class dq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f18497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private iq f18498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f18499e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f18500f = new HashMap();

    private dq() {
    }

    public static dq a(es esVar, dq dqVar, eq eqVar, com.applovin.impl.sdk.j jVar) {
        es esVarC;
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (dqVar == null) {
            try {
                dqVar = new dq();
            } catch (Throwable th2) {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().a("VastCompanionAd", "Error occurred while initializing", th2);
                }
                jVar.E().a("VastCompanionAd", th2);
                return null;
            }
        }
        if (dqVar.f18495a == 0 && dqVar.f18496b == 0) {
            int i11 = StringUtils.parseInt((String) esVar.a().get("width"));
            int i12 = StringUtils.parseInt((String) esVar.a().get("height"));
            if (i11 > 0 && i12 > 0) {
                dqVar.f18495a = i11;
                dqVar.f18496b = i12;
            }
        }
        dqVar.f18498d = iq.a(esVar, dqVar.f18498d, jVar);
        if (dqVar.f18497c == null && (esVarC = esVar.c("CompanionClickThrough")) != null) {
            String strD = esVarC.d();
            if (StringUtils.isValidString(strD)) {
                dqVar.f18497c = Uri.parse(strD);
            }
        }
        mq.a(esVar.a("CompanionClickTracking"), dqVar.f18499e, eqVar, jVar);
        mq.a(esVar, dqVar.f18500f, eqVar, jVar);
        return dqVar;
    }

    public Set a() {
        return this.f18499e;
    }

    public Uri b() {
        return this.f18497c;
    }

    public Map c() {
        return this.f18500f;
    }

    public iq d() {
        return this.f18498d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dq)) {
            return false;
        }
        dq dqVar = (dq) obj;
        if (this.f18495a != dqVar.f18495a || this.f18496b != dqVar.f18496b) {
            return false;
        }
        Uri uri = this.f18497c;
        if (uri == null ? dqVar.f18497c != null : !uri.equals(dqVar.f18497c)) {
            return false;
        }
        iq iqVar = this.f18498d;
        if (iqVar == null ? dqVar.f18498d != null : !iqVar.equals(dqVar.f18498d)) {
            return false;
        }
        Set set = this.f18499e;
        if (set == null ? dqVar.f18499e != null : !set.equals(dqVar.f18499e)) {
            return false;
        }
        Map map = this.f18500f;
        Map map2 = dqVar.f18500f;
        if (map != null) {
            return map.equals(map2);
        }
        return map2 == null;
    }

    public int hashCode() {
        int i11 = ((this.f18495a * 31) + this.f18496b) * 31;
        Uri uri = this.f18497c;
        int iHashCode = (i11 + (uri != null ? uri.hashCode() : 0)) * 31;
        iq iqVar = this.f18498d;
        int iHashCode2 = (iHashCode + (iqVar != null ? iqVar.hashCode() : 0)) * 31;
        Set set = this.f18499e;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map map = this.f18500f;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "VastCompanionAd{width=" + this.f18495a + ", height=" + this.f18496b + ", destinationUri=" + this.f18497c + ", nonVideoResource=" + this.f18498d + ", clickTrackers=" + this.f18499e + ", eventTrackers=" + this.f18500f + '}';
    }
}
