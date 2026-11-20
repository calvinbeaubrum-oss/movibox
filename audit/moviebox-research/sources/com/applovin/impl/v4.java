package com.applovin.impl;

import android.os.Handler;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f23741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f23742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f23743c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInteger f23744d = new AtomicInteger();

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a();

        boolean b();
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f23746b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f23747c;

        private c(String str, long j11, b bVar) {
            this.f23745a = str;
            this.f23747c = j11;
            this.f23746b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b a() {
            return this.f23746b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long b() {
            return this.f23747c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String c() {
            return this.f23745a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            String str = this.f23745a;
            String str2 = ((c) obj).f23745a;
            if (str != null) {
                return str.equalsIgnoreCase(str2);
            }
            return str2 == null;
        }

        public int hashCode() {
            String str = this.f23745a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "CountdownProxy{identifier='" + this.f23745a + "', countdownStepMillis=" + this.f23747c + '}';
        }
    }

    public v4(Handler handler, com.applovin.impl.sdk.j jVar) {
        if (handler == null) {
            throw new IllegalArgumentException("No handler specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f23742b = handler;
        this.f23741a = jVar.J();
    }

    private void a(final c cVar, final int i11) {
        this.f23742b.postDelayed(new Runnable() { // from class: com.applovin.impl.f70
            @Override // java.lang.Runnable
            public final void run() {
                this.f18882a.b(cVar, i11);
            }
        }, cVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(c cVar, int i11) {
        b bVarA = cVar.a();
        if (!bVarA.b()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f23741a.a("CountdownManager", "Ending countdown for " + cVar.c());
                return;
            }
            return;
        }
        if (this.f23744d.get() != i11) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f23741a.k("CountdownManager", "Killing duplicate countdown from previous generation: " + cVar.c());
                return;
            }
            return;
        }
        try {
            bVarA.a();
            a(cVar, i11);
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f23741a.a("CountdownManager", "Encountered error on countdown step for: " + cVar.c(), th2);
            }
            a();
        }
    }

    public void a() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f23741a.a("CountdownManager", "Removing all countdowns...");
        }
        c();
        this.f23743c.clear();
    }

    public void a(String str, long j11, b bVar) {
        if (j11 <= 0) {
            throw new IllegalArgumentException("Invalid step specified.");
        }
        if (this.f23742b == null) {
            throw new IllegalArgumentException("No handler specified.");
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f23741a.a("CountdownManager", "Adding countdown: " + str);
        }
        this.f23743c.add(new c(str, j11, bVar));
    }

    public void b() {
        HashSet<c> hashSet = new HashSet(this.f23743c);
        if (com.applovin.impl.sdk.n.a()) {
            this.f23741a.a("CountdownManager", "Starting " + hashSet.size() + " countdowns...");
        }
        int iIncrementAndGet = this.f23744d.incrementAndGet();
        for (c cVar : hashSet) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f23741a.a("CountdownManager", "Starting countdown: " + cVar.c() + " for generation " + iIncrementAndGet + "...");
            }
            a(cVar, iIncrementAndGet);
        }
    }

    public void c() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f23741a.a("CountdownManager", "Stopping countdowns...");
        }
        this.f23744d.incrementAndGet();
        this.f23742b.removeCallbacksAndMessages(null);
    }
}
