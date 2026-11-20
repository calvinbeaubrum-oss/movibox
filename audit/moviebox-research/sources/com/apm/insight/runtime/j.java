package com.apm.insight.runtime;

import android.os.SystemClock;
import android.util.Printer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static j f17081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f17082b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Printer> f17083c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Printer> f17084d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f17085e = false;

    static {
        new Printer() { // from class: com.apm.insight.runtime.j.1
            @Override // android.util.Printer
            public final void println(String str) {
                if (str == null) {
                    return;
                }
                if (str.charAt(0) == '>') {
                    j.a().a(str);
                } else if (str.charAt(0) == '<') {
                    j.a().b(str);
                }
                j.c();
            }
        };
    }

    private j() {
    }

    public static j a() {
        if (f17081a == null) {
            synchronized (j.class) {
                try {
                    if (f17081a == null) {
                        f17081a = new j();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f17081a;
    }

    private static void a(List<? extends Printer> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                Printer printer = list.get(i11);
                if (printer == null) {
                    return;
                }
                printer.println(str);
            }
        } catch (Throwable th2) {
            com.apm.insight.a.a(th2);
        }
    }

    public static /* synthetic */ Printer c() {
        return null;
    }

    public final void a(String str) {
        this.f17082b = -1L;
        try {
            a(this.f17083c, str);
        } catch (Exception e11) {
            com.apm.insight.a.a((Throwable) e11);
        }
    }

    public final void b(String str) {
        this.f17082b = SystemClock.uptimeMillis();
        try {
            a(this.f17084d, str);
        } catch (Exception e11) {
            com.apm.insight.a.b((Throwable) e11);
        }
    }

    public final boolean b() {
        return this.f17082b != -1 && SystemClock.uptimeMillis() - this.f17082b > 5000;
    }
}
