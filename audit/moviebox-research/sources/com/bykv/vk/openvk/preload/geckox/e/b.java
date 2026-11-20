package com.bykv.vk.openvk.preload.geckox.e;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f25799b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f25801d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, a> f25798a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f25800c = new AtomicBoolean(false);

    public b(Context context, String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key empty");
        }
        this.f25799b = str;
        if (file != null) {
            this.f25801d = new File(file, str).getAbsolutePath();
            return;
        }
        this.f25801d = new File(context.getFilesDir(), "gecko_offline_res_x" + File.separator + str).getAbsolutePath();
    }

    private a d(String str) {
        a aVar;
        int iIndexOf = str.indexOf("/");
        if (iIndexOf == -1) {
            new RuntimeException("channel：".concat(str));
        }
        String strSubstring = str.substring(0, iIndexOf);
        synchronized (this.f25798a) {
            try {
                aVar = this.f25798a.get(strSubstring);
                if (aVar == null) {
                    aVar = new a(this.f25801d, strSubstring);
                    this.f25798a.put(strSubstring, aVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public final InputStream a(String str) throws Exception {
        if (this.f25800c.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).a(str);
    }

    public final String a() {
        return this.f25801d;
    }

    public final int b(String str) throws Exception {
        if (this.f25800c.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).c(str);
    }

    public final Map<String, Long> b() {
        HashMap map = new HashMap();
        synchronized (this.f25798a) {
            try {
                Collection<a> collectionValues = this.f25798a.values();
                if (collectionValues == null) {
                    return map;
                }
                for (a aVar : collectionValues) {
                    map.put(aVar.b(), aVar.a());
                }
                return map;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c() throws Exception {
        if (this.f25800c.getAndSet(true)) {
            return;
        }
        GeckoLogger.d("Loader", "release version res loader");
        synchronized (this.f25798a) {
            try {
                Iterator<a> it = this.f25798a.values().iterator();
                while (it.hasNext()) {
                    it.next().c();
                }
                this.f25798a.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean c(String str) throws Exception {
        if (this.f25800c.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).b(str);
    }
}
