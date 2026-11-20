package com.bytedance.sdk.component.ExN.zY.sc;

import android.util.Log;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY<K, V> {
    private int ExN;
    private int Qj;
    private int TRI;
    private int We;
    private int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f26530qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final LinkedHashMap<K, SoftReference<V>> f26531sc;
    private int zY;

    public zY(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.zY = i11;
        this.f26531sc = new LinkedHashMap<>(0, 0.75f, true);
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
        V v11;
        if (k11 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                SoftReference<V> softReference = this.f26531sc.get(k11);
                if (softReference != null) {
                    v11 = softReference.get();
                    if (v11 != null) {
                        this.f26530qr++;
                        return v11;
                    }
                    this.f26531sc.remove(k11);
                } else {
                    v11 = null;
                }
                this.Qj++;
                V vPFF = pFF(k11);
                if (vPFF == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.ExN++;
                        SoftReference<V> softReferencePut = this.f26531sc.put(k11, new SoftReference<>(vPFF));
                        if (softReferencePut != null) {
                            v11 = softReferencePut.get();
                        }
                        if (v11 != null) {
                            this.f26531sc.put(k11, softReferencePut);
                        } else {
                            this.pFF += zY(k11, vPFF);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (v11 != null) {
                    return v11;
                }
                sc(this.zY);
                return vPFF;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final V sc(K k11, V v11) {
        V v12;
        if (k11 == null || v11 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.We++;
                this.pFF += zY(k11, v11);
                SoftReference<V> softReferencePut = this.f26531sc.put(k11, new SoftReference<>(v11));
                if (softReferencePut != null) {
                    v12 = softReferencePut.get();
                    if (v12 != null) {
                        this.pFF -= zY(k11, v12);
                    }
                } else {
                    v12 = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        sc(this.zY);
        return v12;
    }

    public void sc(int i11) {
        while (true) {
            synchronized (this) {
                try {
                    if (this.pFF < 0 || (this.f26531sc.isEmpty() && this.pFF != 0)) {
                        break;
                        break;
                    }
                    if (this.pFF <= i11) {
                        return;
                    }
                    Map.Entry<K, SoftReference<V>> next = this.f26531sc.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    K key = next.getKey();
                    SoftReference<V> value = next.getValue();
                    this.f26531sc.remove(key);
                    if (value != null) {
                        this.pFF -= zY(key, value.get());
                    }
                    this.TRI++;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        Log.e("LruCache", "oom maybe occured, clear cache. size= " + this.pFF + ", maxSize: " + i11);
        this.pFF = 0;
        this.f26531sc.clear();
    }

    public final synchronized String toString() {
        int i11;
        int i12;
        try {
            i11 = this.f26530qr;
            i12 = this.Qj + i11;
        } catch (Throwable th2) {
            throw th2;
        }
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.zY), Integer.valueOf(this.f26530qr), Integer.valueOf(this.Qj), Integer.valueOf(i12 != 0 ? (i11 * 100) / i12 : 0));
    }
}
