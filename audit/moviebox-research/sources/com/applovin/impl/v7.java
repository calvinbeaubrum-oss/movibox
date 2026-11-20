package com.applovin.impl;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class v7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f23768c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23766a = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f23769d = System.currentTimeMillis();

    public v7(String str, Map map) {
        this.f23767b = str;
        this.f23768c = map;
    }

    public long a() {
        return this.f23769d;
    }

    public String b() {
        return this.f23766a;
    }

    public String c() {
        return this.f23767b;
    }

    public Map d() {
        return this.f23768c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        v7 v7Var = (v7) obj;
        if (this.f23769d == v7Var.f23769d && Objects.equals(this.f23767b, v7Var.f23767b) && Objects.equals(this.f23768c, v7Var.f23768c)) {
            return Objects.equals(this.f23766a, v7Var.f23766a);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f23767b;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map map = this.f23768c;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        long j11 = this.f23769d;
        int i11 = (iHashCode2 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        String str2 = this.f23766a;
        return i11 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Event{name='" + this.f23767b + "', id='" + this.f23766a + "', creationTimestampMillis=" + this.f23769d + ", parameters=" + this.f23768c + '}';
    }
}
