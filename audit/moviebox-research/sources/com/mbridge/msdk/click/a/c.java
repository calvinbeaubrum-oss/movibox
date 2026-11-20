package com.mbridge.msdk.click.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c implements com.mbridge.msdk.foundation.same.a.c<String, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<String, b> f43100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f43101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f43102c;

    public c(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f43101b = i11;
        this.f43100a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private void a(int i11) {
        while (true) {
            synchronized (this) {
                try {
                    if (this.f43102c < 0 || (this.f43100a.isEmpty() && this.f43102c != 0)) {
                        break;
                    }
                    if (this.f43102c > i11 && !this.f43100a.isEmpty()) {
                        Map.Entry<String, b> next = this.f43100a.entrySet().iterator().next();
                        if (next == null) {
                            return;
                        }
                        String key = next.getKey();
                        next.getValue();
                        try {
                            this.f43100a.remove(key);
                            this.f43102c--;
                        } catch (Throwable unused) {
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        throw new IllegalStateException(c.class.getName() + ".sizeOf() is reporting inconsistent results!");
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final b b(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                b bVar = this.f43100a.get(str);
                if (bVar != null) {
                    return bVar;
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f43100a.keySet());
        }
        return hashSet;
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final boolean a(String str, b bVar) {
        if (str == null || bVar == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.f43102c++;
                if (this.f43100a.put(str, bVar) != null) {
                    this.f43102c--;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        a(this.f43101b);
        return true;
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final void b() {
        a(-1);
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final void a(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                if (this.f43100a.remove(str) != null) {
                    this.f43102c--;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.f43101b));
    }
}
