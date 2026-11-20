package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class SimpleCache implements Cache {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final HashSet<File> f35275l = new HashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f35276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f35277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f35278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final d f35279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, ArrayList<Cache.a>> f35280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Random f35281f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f35282g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f35283h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f35284i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f35285j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Cache.CacheException f35286k;

    public SimpleCache(File file, b bVar, k kVar, @Nullable d dVar) {
        if (!t(file)) {
            throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
        }
        this.f35276a = file;
        this.f35277b = bVar;
        this.f35278c = kVar;
        this.f35279d = dVar;
        this.f35280e = new HashMap<>();
        this.f35281f = new Random();
        this.f35282g = bVar.a();
        this.f35283h = -1L;
        final ConditionVariable conditionVariable = new ConditionVariable();
        new Thread("ExoPlayer:SimpleCacheInit") { // from class: com.google.android.exoplayer2.upstream.cache.SimpleCache.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (SimpleCache.this) {
                    conditionVariable.open();
                    SimpleCache.this.q();
                    SimpleCache.this.f35277b.onCacheInitialized();
                }
            }
        }.start();
        conditionVariable.block();
    }

    public SimpleCache(File file, b bVar, rg.a aVar) {
        this(file, bVar, aVar, null, false, false);
    }

    public SimpleCache(File file, b bVar, @Nullable rg.a aVar, @Nullable byte[] bArr, boolean z11, boolean z12) {
        this(file, bVar, new k(aVar, file, bArr, z11, z12), (aVar == null || z12) ? null : new d(aVar));
    }

    public static void m(File file) throws Cache.CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        com.google.android.exoplayer2.util.s.c("SimpleCache", str);
        throw new Cache.CacheException(str);
    }

    public static long n(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, Long.toString(jAbs, 16) + ".uid");
        if (file2.createNewFile()) {
            return jAbs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    public static long s(File[] fileArr) {
        int length = fileArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            File file = fileArr[i11];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return x(name);
                } catch (NumberFormatException unused) {
                    com.google.android.exoplayer2.util.s.c("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    public static synchronized boolean t(File file) {
        return f35275l.add(file.getAbsoluteFile());
    }

    public static long x(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    public final s A(String str, s sVar) {
        boolean z11;
        if (!this.f35282g) {
            return sVar;
        }
        String name = ((File) com.google.android.exoplayer2.util.a.e(sVar.f35326f)).getName();
        long j11 = sVar.f35324c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        d dVar = this.f35279d;
        if (dVar != null) {
            try {
                dVar.h(name, j11, jCurrentTimeMillis);
            } catch (IOException unused) {
                com.google.android.exoplayer2.util.s.i("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z11 = false;
        } else {
            z11 = true;
        }
        s sVarL = this.f35278c.g(str).l(sVar, jCurrentTimeMillis, z11);
        w(sVar, sVarL);
        return sVarL;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long a(String str, long j11, long j12) {
        long j13;
        long j14 = j12 == -1 ? Long.MAX_VALUE : j12 + j11;
        long j15 = j14 >= 0 ? j14 : Long.MAX_VALUE;
        j13 = 0;
        while (j11 < j15) {
            long cachedLength = getCachedLength(str, j11, j15 - j11);
            if (cachedLength > 0) {
                j13 += cachedLength;
            } else {
                cachedLength = -cachedLength;
            }
            j11 += cachedLength;
        }
        return j13;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    @Nullable
    public synchronized h b(String str, long j11, long j12) throws Cache.CacheException {
        com.google.android.exoplayer2.util.a.g(!this.f35285j);
        l();
        s sVarP = p(str, j11, j12);
        if (sVarP.f35325d) {
            return A(str, sVarP);
        }
        if (this.f35278c.m(str).j(j11, sVarP.f35324c)) {
            return sVarP;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized h c(String str, long j11, long j12) throws InterruptedException, Cache.CacheException {
        h hVarB;
        com.google.android.exoplayer2.util.a.g(!this.f35285j);
        l();
        while (true) {
            hVarB = b(str, j11, j12);
            if (hVarB == null) {
                wait();
            }
        }
        return hVarB;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void d(File file, long j11) throws Cache.CacheException {
        com.google.android.exoplayer2.util.a.g(!this.f35285j);
        if (file.exists()) {
            if (j11 == 0) {
                file.delete();
                return;
            }
            s sVar = (s) com.google.android.exoplayer2.util.a.e(s.h(file, j11, this.f35278c));
            j jVar = (j) com.google.android.exoplayer2.util.a.e(this.f35278c.g(sVar.f35322a));
            com.google.android.exoplayer2.util.a.g(jVar.h(sVar.f35323b, sVar.f35324c));
            long jA = l.a(jVar.d());
            if (jA != -1) {
                com.google.android.exoplayer2.util.a.g(sVar.f35323b + sVar.f35324c <= jA);
            }
            if (this.f35279d == null) {
                k(sVar);
                this.f35278c.s();
                notifyAll();
                return;
            }
            try {
                this.f35279d.h(file.getName(), sVar.f35324c, sVar.f35327g);
                k(sVar);
                try {
                    this.f35278c.s();
                    notifyAll();
                    return;
                } catch (IOException e11) {
                    throw new Cache.CacheException(e11);
                }
            } catch (IOException e12) {
                throw new Cache.CacheException(e12);
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void e(String str) {
        com.google.android.exoplayer2.util.a.g(!this.f35285j);
        Iterator<h> it = o(str).iterator();
        while (it.hasNext()) {
            y(it.next());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void f(String str, n nVar) throws Cache.CacheException {
        com.google.android.exoplayer2.util.a.g(!this.f35285j);
        l();
        this.f35278c.e(str, nVar);
        try {
            this.f35278c.s();
        } catch (IOException e11) {
            throw new Cache.CacheException(e11);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void g(h hVar) {
        com.google.android.exoplayer2.util.a.g(!this.f35285j);
        j jVar = (j) com.google.android.exoplayer2.util.a.e(this.f35278c.g(hVar.f35322a));
        jVar.m(hVar.f35323b);
        this.f35278c.p(jVar.f35339b);
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCachedLength(String str, long j11, long j12) {
        j jVarG;
        com.google.android.exoplayer2.util.a.g(!this.f35285j);
        if (j12 == -1) {
            j12 = Long.MAX_VALUE;
        }
        jVarG = this.f35278c.g(str);
        return jVarG != null ? jVarG.c(j11, j12) : -j12;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized m getContentMetadata(String str) {
        com.google.android.exoplayer2.util.a.g(!this.f35285j);
        return this.f35278c.j(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void h(h hVar) {
        com.google.android.exoplayer2.util.a.g(!this.f35285j);
        y(hVar);
    }

    public final void k(s sVar) {
        this.f35278c.m(sVar.f35322a).a(sVar);
        this.f35284i += sVar.f35324c;
        u(sVar);
    }

    public synchronized void l() throws Cache.CacheException {
        Cache.CacheException cacheException = this.f35286k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public synchronized NavigableSet<h> o(String str) {
        j jVarG;
        try {
            com.google.android.exoplayer2.util.a.g(!this.f35285j);
            jVarG = this.f35278c.g(str);
        } catch (Throwable th2) {
            throw th2;
        }
        return (jVarG == null || jVarG.g()) ? new TreeSet() : new TreeSet((Collection) jVarG.f());
    }

    public final s p(String str, long j11, long j12) {
        s sVarE;
        j jVarG = this.f35278c.g(str);
        if (jVarG == null) {
            return s.i(str, j11, j12);
        }
        while (true) {
            sVarE = jVarG.e(j11, j12);
            if (!sVarE.f35325d || sVarE.f35326f.length() == sVarE.f35324c) {
                break;
            }
            z();
        }
        return sVarE;
    }

    public final void q() {
        if (!this.f35276a.exists()) {
            try {
                m(this.f35276a);
            } catch (Cache.CacheException e11) {
                this.f35286k = e11;
                return;
            }
        }
        File[] fileArrListFiles = this.f35276a.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + this.f35276a;
            com.google.android.exoplayer2.util.s.c("SimpleCache", str);
            this.f35286k = new Cache.CacheException(str);
            return;
        }
        long jS = s(fileArrListFiles);
        this.f35283h = jS;
        if (jS == -1) {
            try {
                this.f35283h = n(this.f35276a);
            } catch (IOException e12) {
                String str2 = "Failed to create cache UID: " + this.f35276a;
                com.google.android.exoplayer2.util.s.d("SimpleCache", str2, e12);
                this.f35286k = new Cache.CacheException(str2, e12);
                return;
            }
        }
        try {
            this.f35278c.n(this.f35283h);
            d dVar = this.f35279d;
            if (dVar != null) {
                dVar.e(this.f35283h);
                Map<String, c> mapB = this.f35279d.b();
                r(this.f35276a, true, fileArrListFiles, mapB);
                this.f35279d.g(mapB.keySet());
            } else {
                r(this.f35276a, true, fileArrListFiles, null);
            }
            this.f35278c.r();
            try {
                this.f35278c.s();
            } catch (IOException e13) {
                com.google.android.exoplayer2.util.s.d("SimpleCache", "Storing index file failed", e13);
            }
        } catch (IOException e14) {
            String str3 = "Failed to initialize cache indices: " + this.f35276a;
            com.google.android.exoplayer2.util.s.d("SimpleCache", str3, e14);
            this.f35286k = new Cache.CacheException(str3, e14);
        }
    }

    public final void r(File file, boolean z11, @Nullable File[] fileArr, @Nullable Map<String, c> map) {
        long j11;
        long j12;
        if (fileArr == null || fileArr.length == 0) {
            if (z11) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z11 && name.indexOf(46) == -1) {
                r(file2, false, file2.listFiles(), map);
            } else if (!z11 || (!k.o(name) && !name.endsWith(".uid"))) {
                c cVarRemove = map != null ? map.remove(name) : null;
                if (cVarRemove != null) {
                    j12 = cVarRemove.f35316a;
                    j11 = cVarRemove.f35317b;
                } else {
                    j11 = -9223372036854775807L;
                    j12 = -1;
                }
                s sVarE = s.e(file2, j12, j11, this.f35278c);
                if (sVarE != null) {
                    k(sVarE);
                } else {
                    file2.delete();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized File startFile(String str, long j11, long j12) throws Cache.CacheException {
        j jVarG;
        File file;
        try {
            com.google.android.exoplayer2.util.a.g(!this.f35285j);
            l();
            jVarG = this.f35278c.g(str);
            com.google.android.exoplayer2.util.a.e(jVarG);
            com.google.android.exoplayer2.util.a.g(jVarG.h(j11, j12));
            if (!this.f35276a.exists()) {
                m(this.f35276a);
                z();
            }
            this.f35277b.c(this, str, j11, j12);
            file = new File(this.f35276a, Integer.toString(this.f35281f.nextInt(10)));
            if (!file.exists()) {
                m(file);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return s.k(file, jVarG.f35338a, j11, System.currentTimeMillis());
    }

    public final void u(s sVar) {
        ArrayList<Cache.a> arrayList = this.f35280e.get(sVar.f35322a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).b(this, sVar);
            }
        }
        this.f35277b.b(this, sVar);
    }

    public final void v(h hVar) {
        ArrayList<Cache.a> arrayList = this.f35280e.get(hVar.f35322a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).d(this, hVar);
            }
        }
        this.f35277b.d(this, hVar);
    }

    public final void w(s sVar, h hVar) {
        ArrayList<Cache.a> arrayList = this.f35280e.get(sVar.f35322a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).e(this, sVar, hVar);
            }
        }
        this.f35277b.e(this, sVar, hVar);
    }

    public final void y(h hVar) {
        j jVarG = this.f35278c.g(hVar.f35322a);
        if (jVarG == null || !jVarG.k(hVar)) {
            return;
        }
        this.f35284i -= hVar.f35324c;
        if (this.f35279d != null) {
            String name = hVar.f35326f.getName();
            try {
                this.f35279d.f(name);
            } catch (IOException unused) {
                com.google.android.exoplayer2.util.s.i("SimpleCache", "Failed to remove file index entry for: " + name);
            }
        }
        this.f35278c.p(jVarG.f35339b);
        v(hVar);
    }

    public final void z() {
        ArrayList arrayList = new ArrayList();
        Iterator<j> it = this.f35278c.h().iterator();
        while (it.hasNext()) {
            for (s sVar : it.next().f()) {
                if (sVar.f35326f.length() != sVar.f35324c) {
                    arrayList.add(sVar);
                }
            }
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            y((h) arrayList.get(i11));
        }
    }
}
