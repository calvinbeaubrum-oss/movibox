package com.bykv.vk.openvk.preload.geckox.f;

import com.bykv.vk.openvk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Lock> f25805a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ReentrantLock f25806b = new ReentrantLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f25807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FileLock f25808d;

    private b(String str, FileLock fileLock) {
        this.f25807c = str;
        this.f25808d = fileLock;
    }

    public static b a(String str) throws Exception {
        f25806b.lock();
        try {
            FileLock fileLockA = FileLock.a(str);
            Map<String, Lock> map = f25805a;
            Lock reentrantLock = map.get(str);
            if (reentrantLock == null) {
                reentrantLock = new ReentrantLock();
                map.put(str, reentrantLock);
            }
            reentrantLock.lock();
            return new b(str, fileLockA);
        } catch (Exception e11) {
            f25806b.unlock();
            throw e11;
        }
    }

    public final void a() {
        try {
            this.f25808d.a();
            this.f25808d.b();
            Lock lock = f25805a.get(this.f25807c);
            if (lock != null) {
                lock.unlock();
            }
        } finally {
            f25806b.unlock();
        }
    }
}
