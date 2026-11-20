package com.mbridge.msdk.foundation.same.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements c<String, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<String, JSONObject> f44394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f44395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f44396c;

    public b(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f44395b = i11;
        this.f44394a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private void a(int i11) {
        while (true) {
            synchronized (this) {
                try {
                    if (this.f44396c < 0 || (this.f44394a.isEmpty() && this.f44396c != 0)) {
                        break;
                    }
                    if (this.f44396c > i11 && !this.f44394a.isEmpty()) {
                        Map.Entry<String, JSONObject> next = this.f44394a.entrySet().iterator().next();
                        if (next == null) {
                            return;
                        }
                        String key = next.getKey();
                        next.getValue();
                        try {
                            this.f44394a.remove(key);
                            this.f44396c--;
                        } catch (Throwable unused) {
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        throw new IllegalStateException(b.class.getName() + ".sizeOf() is reporting inconsistent results!");
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f44394a.keySet());
        }
        return hashSet;
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final JSONObject b(String str) {
        JSONObject jSONObject;
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            jSONObject = this.f44394a.get(str);
        }
        return jSONObject;
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final /* synthetic */ void a(String str) {
        String str2 = str;
        if (str2 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                if (this.f44394a.remove(str2) != null) {
                    this.f44396c--;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final boolean a(String str, JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.f44396c++;
                if (this.f44394a.put(str, jSONObject) != null) {
                    this.f44396c--;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        a(this.f44395b);
        return true;
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final void b() {
        a(-1);
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.f44395b));
    }
}
