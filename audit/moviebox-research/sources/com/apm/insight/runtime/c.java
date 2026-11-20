package com.apm.insight.runtime;

import androidx.annotation.NonNull;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.IOOMCallback;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ICrashCallback> f17060a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<ICrashCallback> f17061b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<ICrashCallback> f17062c = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<ICrashCallback> f17063d = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<IOOMCallback> f17064e = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: com.apm.insight.runtime.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17065a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f17065a = iArr;
            try {
                iArr[CrashType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17065a[CrashType.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17065a[CrashType.JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17065a[CrashType.LAUNCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17065a[CrashType.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @NonNull
    public final List<IOOMCallback> a() {
        return this.f17064e;
    }

    public final void a(ICrashCallback iCrashCallback, CrashType crashType) {
        int i11 = AnonymousClass1.f17065a[crashType.ordinal()];
        if (i11 == 1) {
            this.f17060a.add(iCrashCallback);
            this.f17061b.add(iCrashCallback);
            this.f17062c.add(iCrashCallback);
            this.f17063d.add(iCrashCallback);
            return;
        }
        if (i11 == 2) {
            this.f17063d.add(iCrashCallback);
            return;
        }
        if (i11 == 3) {
            this.f17061b.add(iCrashCallback);
        } else if (i11 == 4) {
            this.f17060a.add(iCrashCallback);
        } else {
            if (i11 != 5) {
                return;
            }
            this.f17062c.add(iCrashCallback);
        }
    }

    public final void a(IOOMCallback iOOMCallback) {
        this.f17064e.add(iOOMCallback);
    }

    @NonNull
    public final List<ICrashCallback> b() {
        return this.f17060a;
    }

    public final void b(ICrashCallback iCrashCallback, CrashType crashType) {
        int i11 = AnonymousClass1.f17065a[crashType.ordinal()];
        if (i11 == 1) {
            this.f17060a.remove(iCrashCallback);
            this.f17061b.remove(iCrashCallback);
            this.f17062c.remove(iCrashCallback);
            this.f17063d.remove(iCrashCallback);
            return;
        }
        if (i11 == 2) {
            this.f17063d.remove(iCrashCallback);
            return;
        }
        if (i11 == 3) {
            this.f17061b.remove(iCrashCallback);
        } else if (i11 == 4) {
            this.f17060a.remove(iCrashCallback);
        } else {
            if (i11 != 5) {
                return;
            }
            this.f17062c.remove(iCrashCallback);
        }
    }

    public final void b(IOOMCallback iOOMCallback) {
        this.f17064e.remove(iOOMCallback);
    }

    @NonNull
    public final List<ICrashCallback> c() {
        return this.f17061b;
    }

    @NonNull
    public final List<ICrashCallback> d() {
        return this.f17062c;
    }

    @NonNull
    public final List<ICrashCallback> e() {
        return this.f17063d;
    }
}
