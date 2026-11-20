package com.apm.insight.b;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f16701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Printer f16702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CopyOnWriteArrayList<e> f16703c = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f16704d = false;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        @Nullable
        String a();

        String b();

        String c();
    }

    public static void a() {
        if (f16701a) {
            return;
        }
        f16701a = true;
        f16702b = new Printer() { // from class: com.apm.insight.b.h.1
            @Override // android.util.Printer
            public final void println(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.charAt(0) == '>') {
                    h.a(true, str);
                } else if (str.charAt(0) == '<') {
                    h.a(false, str);
                }
            }
        };
        i.a();
        i.a(f16702b);
    }

    public static void a(e eVar) {
        CopyOnWriteArrayList<e> copyOnWriteArrayList = f16703c;
        synchronized (copyOnWriteArrayList) {
            copyOnWriteArrayList.add(eVar);
        }
    }

    public static void a(boolean z11, String str) {
        e.f16645a = System.nanoTime() / 1000000;
        e.f16646b = SystemClock.currentThreadTimeMillis();
        CopyOnWriteArrayList<e> copyOnWriteArrayList = f16703c;
        for (int i11 = 0; i11 < copyOnWriteArrayList.size(); i11++) {
            e eVar = copyOnWriteArrayList.get(i11);
            if (eVar == null || !eVar.a()) {
                if (!z11 && eVar.f16647c) {
                    eVar.b("");
                }
            } else if (z11) {
                if (!eVar.f16647c) {
                    eVar.a(str);
                }
            } else if (eVar.f16647c) {
                eVar.b(str);
            }
        }
    }
}
