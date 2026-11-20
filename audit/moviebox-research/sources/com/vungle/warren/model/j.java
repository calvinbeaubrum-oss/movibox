package com.vungle.warren.model;

import com.vungle.warren.VungleLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f62173a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, Boolean> f62174b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Integer> f62175c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Long> f62176d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f62177e;

    public j(String str) {
        this.f62177e = str;
    }

    public Boolean a(String str) {
        return Boolean.valueOf(this.f62174b.get(str) != null && this.f62174b.get(str).booleanValue());
    }

    public Boolean b(String str) {
        return this.f62174b.get(str);
    }

    public Long c(String str) {
        return Long.valueOf(this.f62176d.get(str) != null ? this.f62176d.get(str).longValue() : 0L);
    }

    public String d(String str) {
        return this.f62173a.get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void e(String str, T t11) {
        if (t11 == 0) {
            VungleLogger.a(true, j.class.getSimpleName(), "putValue", String.format("Value for key \"%s\" should not be null", str));
            return;
        }
        if (t11 instanceof String) {
            this.f62173a.put(str, (String) t11);
            return;
        }
        if (t11 instanceof Boolean) {
            this.f62174b.put(str, (Boolean) t11);
            return;
        }
        if (t11 instanceof Integer) {
            this.f62175c.put(str, (Integer) t11);
        } else if (t11 instanceof Long) {
            this.f62176d.put(str, (Long) t11);
        } else {
            VungleLogger.a(true, j.class.getSimpleName(), "putValue", "Value type is not supported!");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        Map<String, String> map = this.f62173a;
        if (map == null ? jVar.f62173a != null : !map.equals(jVar.f62173a)) {
            return false;
        }
        Map<String, Boolean> map2 = this.f62174b;
        if (map2 == null ? jVar.f62174b != null : !map2.equals(jVar.f62174b)) {
            return false;
        }
        Map<String, Integer> map3 = this.f62175c;
        if (map3 == null ? jVar.f62175c != null : !map3.equals(jVar.f62175c)) {
            return false;
        }
        Map<String, Long> map4 = this.f62176d;
        if (map4 == null ? jVar.f62176d != null : !map4.equals(jVar.f62176d)) {
            return false;
        }
        String str = this.f62177e;
        String str2 = jVar.f62177e;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        Map<String, String> map = this.f62173a;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<String, Boolean> map2 = this.f62174b;
        int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<String, Integer> map3 = this.f62175c;
        int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<String, Long> map4 = this.f62176d;
        int iHashCode4 = (iHashCode3 + (map4 != null ? map4.hashCode() : 0)) * 31;
        String str = this.f62177e;
        return iHashCode4 + (str != null ? str.hashCode() : 0);
    }
}
