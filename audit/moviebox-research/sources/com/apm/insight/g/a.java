package com.apm.insight.g;

import android.os.Looper;
import android.os.SystemClock;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.ICrashFilter;
import com.apm.insight.IOOMCallback;
import com.apm.insight.e;
import com.apm.insight.k.h;
import com.apm.insight.l.j;
import com.apm.insight.l.m;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.a.f;
import com.apm.insight.runtime.k;
import com.apm.insight.runtime.n;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f16795a = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile boolean f16796i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile ThreadLocal<Boolean> f16797j = new ThreadLocal<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static ArrayList<b> f16798l = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f16799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f16800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f16801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile int f16802e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile int f16803f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f16804g = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f16805h = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private JSONArray f16806k;

    private a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            this.f16799b = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public static a a() {
        if (f16795a == null) {
            f16795a = new a();
        }
        return f16795a;
    }

    private String a(File file, Throwable th2, Thread thread, boolean z11) {
        String absolutePath = file.getAbsolutePath();
        this.f16805h.put(file.getName(), file);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            NativeImpl.c(absolutePath);
        } catch (Throwable unused) {
        }
        String strA = null;
        if (z11) {
            int iH = NativeImpl.h(absolutePath);
            if (iH > 0) {
                try {
                    NativeImpl.a(iH, com.apm.insight.l.a.d(e.g()));
                    NativeImpl.a(iH, "\n");
                    NativeImpl.a(iH, th2.getMessage());
                    NativeImpl.a(iH, "\n");
                    NativeImpl.a(iH, th2.getClass().getName());
                    if (th2.getMessage() != null) {
                        NativeImpl.a(iH, ": ");
                        NativeImpl.a(iH, th2.getMessage());
                    }
                    NativeImpl.a(iH, "\n");
                    NativeImpl.a(iH, thread.getName());
                    NativeImpl.a(iH, "\n");
                } catch (Throwable unused2) {
                }
                try {
                    NativeImpl.a(iH, "stack:");
                    NativeImpl.a(iH, "\n");
                } catch (Throwable unused3) {
                }
                m.a(th2, iH);
                NativeImpl.b(iH);
            }
        } else {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                try {
                    fileOutputStream.write((com.apm.insight.l.a.d(e.g()) + "\n").getBytes());
                    fileOutputStream.write((th2.getMessage() + "\n").getBytes());
                    fileOutputStream.write((th2 + "\n").getBytes());
                    fileOutputStream.write((thread.getName() + "\n").getBytes());
                } catch (Throwable unused4) {
                }
                try {
                    fileOutputStream.write("stack:\n".getBytes());
                } catch (Throwable unused5) {
                }
                try {
                    strA = m.a(th2, new PrintStream(fileOutputStream), Looper.getMainLooper() == Looper.myLooper() ? new com.apm.insight.l.e.a() { // from class: com.apm.insight.g.a.1

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        private boolean f16807a = false;

                        @Override // com.apm.insight.l.e.a
                        public final boolean a(String str) {
                            if (!this.f16807a && str.contains("android.os.Looper.loop")) {
                                this.f16807a = true;
                            }
                            return !this.f16807a;
                        }
                    } : new com.apm.insight.l.e.a());
                    com.apm.insight.a.a((Closeable) fileOutputStream);
                } catch (Throwable th3) {
                    try {
                        th2.printStackTrace(new PrintStream(fileOutputStream));
                    } catch (Throwable th4) {
                        try {
                            fileOutputStream.write("err:\n".getBytes());
                            fileOutputStream.write((th3 + "\n").getBytes());
                            fileOutputStream.write((th4 + "\n").getBytes());
                        } catch (Throwable unused6) {
                        }
                    }
                }
                com.apm.insight.a.a((Closeable) fileOutputStream);
            } catch (Throwable unused7) {
            }
        }
        return strA;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 5821. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private java.lang.Throwable a(java.lang.Thread r22, java.lang.Throwable r23) {
        /*
            Method dump skipped, instruction units count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.g.a.a(java.lang.Thread, java.lang.Throwable):java.lang.Throwable");
    }

    private void a(Thread thread, Throwable th2, boolean z11, long j11) {
        List<IOOMCallback> listA = com.apm.insight.runtime.m.a().a();
        CrashType crashType = z11 ? CrashType.LAUNCH : CrashType.JAVA;
        for (IOOMCallback iOOMCallback : listA) {
            try {
                if (iOOMCallback instanceof com.apm.insight.b) {
                    ((com.apm.insight.b) iOOMCallback).a(crashType, th2, thread, j11, this.f16806k);
                } else {
                    iOOMCallback.onCrash(crashType, th2, thread, j11);
                }
            } catch (Throwable th3) {
                com.apm.insight.a.b(th3);
            }
        }
    }

    public static void a(final Throwable th2) {
        if (th2 == null) {
            return;
        }
        try {
            n.a().a(new Runnable() { // from class: com.apm.insight.g.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.apm.insight.entity.a aVarA = com.apm.insight.entity.a.a(System.currentTimeMillis(), e.g(), th2);
                        aVarA.a("userdefine", (Object) 1);
                        com.apm.insight.entity.a aVarA2 = f.a().a(CrashType.CUSTOM_JAVA, aVarA);
                        if (aVarA2 != null) {
                            com.apm.insight.k.d.a().c(aVarA2.c());
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static boolean b() {
        return f16796i;
    }

    private static boolean b(Thread thread, Throwable th2) {
        ICrashFilter iCrashFilterB = e.b().b();
        if (iCrashFilterB != null) {
            try {
                if (!iCrashFilterB.onJavaCrashFilter(th2, thread)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public static void c(final String str) {
        if (str == null) {
            return;
        }
        try {
            n.a().a(new Runnable() { // from class: com.apm.insight.g.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
                        aVar.a("data", (Object) str);
                        aVar.a("userdefine", (Object) 1);
                        com.apm.insight.entity.a aVarA = f.a().a(CrashType.CUSTOM_JAVA, aVar);
                        if (aVarA != null) {
                            com.apm.insight.k.d.a().c(aVarA.c());
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private void c(Thread thread, Throwable th2) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f16799b;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th2);
    }

    public static boolean c() {
        Boolean bool = f16797j.get();
        return bool != null && bool.booleanValue();
    }

    private void d() {
        synchronized (this) {
            this.f16803f--;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (this.f16803f != 0 && SystemClock.uptimeMillis() - jUptimeMillis < 10000) {
            SystemClock.sleep(50L);
        }
    }

    private static void e() {
        File fileA = j.a(e.g());
        File fileA2 = j.a();
        if (com.apm.insight.l.f.b(fileA) && com.apm.insight.l.f.b(fileA2)) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (!h.a() && SystemClock.uptimeMillis() - jUptimeMillis < 10000) {
            try {
                SystemClock.sleep(500L);
            } catch (Throwable unused) {
            }
        }
    }

    private static int f() {
        int iA = 0;
        for (int i11 = 0; i11 < f16798l.size(); i11++) {
            try {
                try {
                    iA |= f16798l.get(i11).a();
                } catch (Throwable th2) {
                    com.apm.insight.c.a();
                    k.a(th2, "NPTH_CATCH");
                }
            } catch (Throwable unused) {
            }
        }
        return iA;
    }

    private static Throwable g() {
        for (int i11 = 0; i11 < f16798l.size(); i11++) {
            try {
                f16798l.get(i11);
            } catch (Throwable unused) {
            }
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return null;
        }
        try {
            Looper.loop();
            return null;
        } catch (Throwable th2) {
            return th2;
        }
    }

    public final void a(c cVar) {
        this.f16800c = cVar;
    }

    public final void a(String str) {
        this.f16804g.put(str, new Object());
    }

    public final void a(Thread thread, Throwable th2, boolean z11, com.apm.insight.entity.a aVar) {
        List<ICrashCallback> listC;
        CrashType crashType;
        if (z11) {
            listC = com.apm.insight.runtime.m.a().b();
            crashType = CrashType.LAUNCH;
        } else {
            listC = com.apm.insight.runtime.m.a().c();
            crashType = CrashType.JAVA;
        }
        for (ICrashCallback iCrashCallback : listC) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                if (iCrashCallback instanceof com.apm.insight.b) {
                    ((com.apm.insight.b) iCrashCallback).a(crashType, m.a(th2), thread, this.f16806k);
                } else {
                    iCrashCallback.onCrash(crashType, m.a(th2), thread);
                }
                aVar.b("callback_cost_" + iCrashCallback.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            } catch (Throwable th3) {
                com.apm.insight.a.b(th3);
                aVar.b("callback_err_" + iCrashCallback.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            }
        }
    }

    public final void b(c cVar) {
        this.f16801d = cVar;
    }

    public final boolean b(String str) {
        return this.f16804g.containsKey(str);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th2) {
        do {
            th2 = a(thread, th2);
        } while (th2 != null);
    }
}
