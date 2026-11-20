package com.bykv.vk.openvk.preload.geckox.f;

import com.bykv.vk.openvk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Lock> f25802a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FileLock f25803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f25804c;

    private a(String str, FileLock fileLock) {
        this.f25804c = str;
        this.f25803b = fileLock;
    }

    public static a a(String str) throws Exception {
        Map<String, Lock> map = f25802a;
        synchronized (map) {
            try {
                Lock reentrantLock = map.get(str);
                if (reentrantLock == null) {
                    reentrantLock = new ReentrantLock();
                    map.put(str, reentrantLock);
                }
                if (!reentrantLock.tryLock()) {
                    return null;
                }
                try {
                    FileLock fileLockC = FileLock.c(str);
                    if (fileLockC == null) {
                        reentrantLock.unlock();
                        return null;
                    }
                    return new a(str, fileLockC);
                } catch (Exception e11) {
                    reentrantLock.lock();
                    com.bykv.vk.openvk.preload.geckox.utils.a.a(new RuntimeException(e11));
                    return null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void a() {
        Map<String, Lock> map = f25802a;
        synchronized (map) {
            try {
                try {
                    this.f25803b.a();
                    this.f25803b.b();
                    map.get(this.f25804c).unlock();
                } catch (Throwable th2) {
                    f25802a.get(this.f25804c).unlock();
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
