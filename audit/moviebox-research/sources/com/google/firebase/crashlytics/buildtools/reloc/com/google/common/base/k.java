package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.util.Iterator;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f39090a = Logger.getLogger(k.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f39091b = b();

    /* JADX INFO: compiled from: source.java */
    public static final class b implements j {
        public b() {
        }
    }

    public static String a(double d11) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d11));
    }

    public static j b() {
        try {
            Iterator it = ServiceLoader.load(j.class).iterator();
            while (it.hasNext()) {
                try {
                    return (j) it.next();
                } catch (ServiceConfigurationError e11) {
                    c(e11);
                }
            }
        } catch (ServiceConfigurationError e12) {
            c(e12);
        }
        return new b();
    }

    public static void c(ServiceConfigurationError serviceConfigurationError) {
        f39090a.log(Level.WARNING, "Error loading regex compiler, falling back to next option", (Throwable) serviceConfigurationError);
    }

    public static boolean d(String str) {
        return str == null || str.isEmpty();
    }

    public static long e() {
        return System.nanoTime();
    }
}
