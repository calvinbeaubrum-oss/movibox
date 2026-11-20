package com.mbridge.msdk.foundation.same.a;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements c<String, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<String, Bitmap> f44391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f44392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f44393c;

    public a(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f44392b = i11;
        this.f44391a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.mbridge.msdk.foundation.same.a.c
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Bitmap b(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                Bitmap bitmap = this.f44391a.get(str);
                if (bitmap == null || bitmap.isRecycled()) {
                    return null;
                }
                return bitmap;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void a(int i11) {
        while (true) {
            synchronized (this) {
                try {
                    if (this.f44393c < 0 || (this.f44391a.isEmpty() && this.f44393c != 0)) {
                        break;
                    }
                    if (this.f44393c > i11 && !this.f44391a.isEmpty()) {
                        Map.Entry<String, Bitmap> next = this.f44391a.entrySet().iterator().next();
                        if (next == null) {
                            return;
                        }
                        String key = next.getKey();
                        try {
                            int iB = b(key, next.getValue());
                            this.f44391a.remove(key).recycle();
                            this.f44393c -= iB;
                        } catch (Throwable unused) {
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        throw new IllegalStateException(a.class.getName() + ".sizeOf() is reporting inconsistent results!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.mbridge.msdk.foundation.same.a.c
    public boolean a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.f44393c += b(str, bitmap);
                Bitmap bitmapPut = this.f44391a.put(str, bitmap);
                if (bitmapPut != null) {
                    this.f44393c -= b(str, bitmapPut);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        a(this.f44392b);
        return true;
    }

    private int b(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f44391a.keySet());
        }
        return hashSet;
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final /* synthetic */ void a(String str) {
        String str2 = str;
        if (str2 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                Bitmap bitmapRemove = this.f44391a.remove(str2);
                if (bitmapRemove != null) {
                    this.f44393c -= b(str2, bitmapRemove);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final void b() {
        a(-1);
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.f44392b));
    }
}
