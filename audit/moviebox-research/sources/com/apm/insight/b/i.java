package com.apm.insight.b;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f16705a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f16706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f16707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Printer f16708d;

    /* JADX INFO: compiled from: source.java */
    public interface a {
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<Printer> f16709a = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<Printer> f16712d = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<Printer> f16710b = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f16713e = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f16711c = false;

        @Override // android.util.Printer
        public final void println(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            i.b();
            if (str.charAt(0) == '>' && this.f16711c) {
                for (Printer printer : this.f16710b) {
                    if (!this.f16709a.contains(printer)) {
                        this.f16709a.add(printer);
                    }
                }
                this.f16710b.clear();
                this.f16711c = false;
            }
            if (this.f16709a.size() > i.f16705a) {
                Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
            }
            for (Printer printer2 : this.f16709a) {
                if (printer2 != null) {
                    printer2.println(str);
                }
            }
            str.charAt(0);
            i.b();
        }
    }

    public static void a() {
        if (f16707c) {
            return;
        }
        f16707c = true;
        f16706b = new b();
        Printer printerD = d();
        f16708d = printerD;
        if (printerD != null) {
            f16706b.f16709a.add(printerD);
        }
        if (com.apm.insight.e.s()) {
            Looper.getMainLooper().setMessageLogging(f16706b);
        }
    }

    public static void a(Printer printer) {
        if (printer == null || f16706b.f16710b.contains(printer)) {
            return;
        }
        f16706b.f16710b.add(printer);
        f16706b.f16711c = true;
    }

    public static /* synthetic */ a b() {
        return null;
    }

    private static Printer d() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception unused) {
            return null;
        }
    }
}
