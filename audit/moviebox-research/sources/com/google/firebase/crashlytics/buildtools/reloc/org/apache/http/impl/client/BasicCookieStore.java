package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.CookieIdentityComparator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class BasicCookieStore implements Serializable {
    private static final long serialVersionUID = -7581093305228232025L;
    private final TreeSet<bk.a> cookies = new TreeSet<>(new CookieIdentityComparator());
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addCookie(bk.a aVar) {
        if (aVar != null) {
            this.lock.writeLock().lock();
            try {
                this.cookies.remove(aVar);
                if (!aVar.isExpired(new Date())) {
                    this.cookies.add(aVar);
                }
            } finally {
                this.lock.writeLock().unlock();
            }
        }
    }

    public void addCookies(bk.a[] aVarArr) {
        if (aVarArr != null) {
            for (bk.a aVar : aVarArr) {
                addCookie(aVar);
            }
        }
    }

    public void clear() {
        this.lock.writeLock().lock();
        try {
            this.cookies.clear();
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public boolean clearExpired(Date date) {
        boolean z11 = false;
        if (date == null) {
            return false;
        }
        this.lock.writeLock().lock();
        try {
            Iterator<bk.a> it = this.cookies.iterator();
            while (it.hasNext()) {
                if (it.next().isExpired(date)) {
                    it.remove();
                    z11 = true;
                }
            }
            this.lock.writeLock().unlock();
            return z11;
        } catch (Throwable th2) {
            this.lock.writeLock().unlock();
            throw th2;
        }
    }

    public List<bk.a> getCookies() {
        this.lock.readLock().lock();
        try {
            return new ArrayList(this.cookies);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public String toString() {
        this.lock.readLock().lock();
        try {
            return this.cookies.toString();
        } finally {
            this.lock.readLock().unlock();
        }
    }
}
