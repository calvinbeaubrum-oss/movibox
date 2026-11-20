package com.vungle.warren.utility;

import android.graphics.Bitmap;
import android.util.LruCache;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f62602b = "l";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f62603c = new l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<String, Bitmap> f62604a = new a(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);

    /* JADX INFO: compiled from: source.java */
    public class a extends LruCache<String, Bitmap> {
        public a(int i11) {
            super(i11);
        }

        @Override // android.util.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
    }
}
