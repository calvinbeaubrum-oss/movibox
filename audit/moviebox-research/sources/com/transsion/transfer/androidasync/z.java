package com.transsion.transfer.androidasync;

import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class z implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Selector f58912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f58913b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Semaphore f58914c = new Semaphore(0);

    public z(Selector selector) {
        this.f58912a = selector;
    }

    public Selector a() {
        return this.f58912a;
    }

    public Set<SelectionKey> b() {
        return this.f58912a.keys();
    }

    public void c() throws IOException {
        d(0L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f58912a.close();
    }

    public void d(long j11) throws IOException {
        try {
            this.f58914c.drainPermits();
            this.f58912a.select(j11);
        } finally {
            this.f58914c.release(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }
    }

    public int e() throws IOException {
        return this.f58912a.selectNow();
    }

    public Set<SelectionKey> g() {
        return this.f58912a.selectedKeys();
    }

    public boolean h() {
        for (int i11 = 0; i11 < 100; i11++) {
            try {
                this.f58914c.tryAcquire(10L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        boolean z11 = !this.f58914c.tryAcquire();
        this.f58912a.wakeup();
        if (z11) {
            return;
        }
        if (this.f58913b.getAndSet(true)) {
            this.f58912a.wakeup();
            return;
        }
        try {
            h();
            this.f58912a.wakeup();
        } finally {
            this.f58913b.set(false);
        }
    }

    public boolean isOpen() {
        return this.f58912a.isOpen();
    }
}
