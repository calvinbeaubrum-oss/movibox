package com.bytedance.adsdk.pFF;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SR<K, V> {
    private int ExN;
    private int Qj;
    private int TRI;
    private int We;
    private int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f26128qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final LinkedHashMap<K, V> f26129sc;
    private int zY;

    public SR(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.zY = i11;
        this.f26129sc = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int zY(K k11, V v11) {
        int iPFF = pFF(k11, v11);
        if (iPFF >= 0) {
            return iPFF;
        }
        throw new IllegalStateException("Negative size: " + k11 + "=" + v11);
    }

    public int pFF(K k11, V v11) {
        return 1;
    }

    public V pFF(K k11) {
        return null;
    }

    public final V sc(K k11) {
        V vPut;
        if (k11 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                V v11 = this.f26129sc.get(k11);
                if (v11 != null) {
                    this.f26128qr++;
                    return v11;
                }
                this.Qj++;
                V vPFF = pFF(k11);
                if (vPFF == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.ExN++;
                        vPut = this.f26129sc.put(k11, vPFF);
                        if (vPut != null) {
                            this.f26129sc.put(k11, vPut);
                        } else {
                            this.pFF += zY(k11, vPFF);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (vPut != null) {
                    return vPut;
                }
                sc(this.zY);
                return vPFF;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final V sc(K k11, V v11) {
        V vPut;
        if (k11 == null || v11 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.We++;
                this.pFF += zY(k11, v11);
                vPut = this.f26129sc.put(k11, v11);
                if (vPut != null) {
                    this.pFF -= zY(k11, vPut);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        sc(this.zY);
        return vPut;
    }

    public void sc(int i11) {
        while (true) {
            synchronized (this) {
                try {
                    if (this.pFF < 0 || (this.f26129sc.isEmpty() && this.pFF != 0)) {
                        break;
                    }
                    if (this.pFF > i11 && !this.f26129sc.isEmpty()) {
                        Map.Entry<K, V> next = this.f26129sc.entrySet().iterator().next();
                        K key = next.getKey();
                        V value = next.getValue();
                        this.f26129sc.remove(key);
                        this.pFF -= zY(key, value);
                        this.TRI++;
                    }
                    return;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    public final synchronized String toString() {
        int i11;
        int i12;
        try {
            i11 = this.f26128qr;
            i12 = this.Qj + i11;
        } catch (Throwable th2) {
            throw th2;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.zY), Integer.valueOf(this.f26128qr), Integer.valueOf(this.Qj), Integer.valueOf(i12 != 0 ? (i11 * 100) / i12 : 0));
    }
}
