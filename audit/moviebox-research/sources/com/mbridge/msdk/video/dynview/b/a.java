package com.mbridge.msdk.video.dynview.b;

import android.view.View;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.e.e;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f47540b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.mbridge.msdk.video.dynview.d.a f47541a;

    private a() {
    }

    public static a a() {
        a aVar;
        if (f47540b != null) {
            return f47540b;
        }
        synchronized (a.class) {
            try {
                if (f47540b == null) {
                    f47540b = new a();
                }
                aVar = f47540b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public final void a(View view, c cVar, Map map, e eVar) {
        int iH = cVar.h();
        if (iH == 1) {
            com.mbridge.msdk.video.dynview.j.a aVar = new com.mbridge.msdk.video.dynview.j.a();
            aVar.a(cVar, view, map, eVar);
            this.f47541a = aVar.f47639a;
        } else {
            if (iH == 2) {
                new com.mbridge.msdk.video.dynview.j.a().b(cVar, view, map, eVar);
                return;
            }
            if (iH == 4) {
                new com.mbridge.msdk.video.dynview.j.a().a(cVar, view, eVar);
            } else if (iH != 5) {
                eVar.a(view, new ArrayList());
            } else {
                new com.mbridge.msdk.video.dynview.j.a().c(cVar, view, map, eVar);
            }
        }
    }

    public final void b() {
        com.mbridge.msdk.video.dynview.d.a aVar = this.f47541a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
