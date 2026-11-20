package com.mbridge.msdk.video.dynview;

import android.view.View;
import com.mbridge.msdk.video.dynview.e.g;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f47538b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, SoftReference<View>> f47539a = new HashMap();

    private b() {
    }

    public static b a() {
        b bVar;
        if (f47538b != null) {
            return f47538b;
        }
        synchronized (b.class) {
            try {
                if (f47538b == null) {
                    f47538b = new b();
                }
                bVar = f47538b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    public final void a(c cVar, g gVar) {
        new com.mbridge.msdk.video.dynview.h.a(cVar, gVar, new HashMap());
    }
}
