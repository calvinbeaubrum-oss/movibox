package com.mbridge.msdk.video.dynview.b;

import android.view.View;
import com.mbridge.msdk.video.dynview.c;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f47542a;

    private b() {
    }

    public static b a() {
        b bVar;
        if (f47542a != null) {
            return f47542a;
        }
        synchronized (b.class) {
            try {
                if (f47542a == null) {
                    f47542a = new b();
                }
                bVar = f47542a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    public final void a(View view, c cVar, Map<String, Object> map) {
        if (cVar == null) {
            return;
        }
        int iH = cVar.h();
        if (iH == 1) {
            new com.mbridge.msdk.video.dynview.j.b().a(view, map);
            return;
        }
        if (iH == 2) {
            new com.mbridge.msdk.video.dynview.j.b().a(view, cVar, map);
            return;
        }
        if (iH == 3) {
            new com.mbridge.msdk.video.dynview.j.b().a(view, cVar);
        } else if (iH == 4) {
            new com.mbridge.msdk.video.dynview.j.b().b(view, cVar, map);
        } else {
            if (iH != 5) {
                return;
            }
            new com.mbridge.msdk.video.dynview.j.b();
        }
    }
}
