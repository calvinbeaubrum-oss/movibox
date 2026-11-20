package androidx.media3.datasource.cache;

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
/* JADX INFO: loaded from: classes2.dex */
public final class SimpleCache implements Cache {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final HashSet<File> f9635l = new HashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f9636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f9637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f9638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final d f9639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, ArrayList<Cache.a>> f9640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Random f9641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f9642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f9643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f9644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Cache.CacheException f9646k;

    public SimpleCache(File file, b bVar, k kVar, @Nullable d dVar) {
        if (!t(file)) {
            throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
        }
        this.f9636a = file;
        this.f9637b = bVar;
        this.f9638c = kVar;
        this.f9639d = dVar;
        this.f9640e = new HashMap<>();
        this.f9641f = new Random();
        this.f9642g = bVar.a();
        this.f9643h = -1L;
        final ConditionVariable conditionVariable = new ConditionVariable();
        new Thread("ExoPlayer:SimpleCacheInit") { // from class: androidx.media3.datasource.cache.SimpleCache.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (SimpleCache.this) {
                    conditionVariable.open();
                    SimpleCache.this.q();
                    SimpleCache.this.f9637b.onCacheInitialized();
                }
            }
        }.start();
        conditionVariable.block();
    }

    public SimpleCache(File file, b bVar, b4.a aVar) {
        this(file, bVar, aVar, null, false, false);
    }

    public SimpleCache(File file, b bVar, @Nullable b4.a aVar, @Nullable byte[] bArr, boolean z11, boolean z12) {
        this(file, bVar, new k(aVar, file, bArr, z11, z12), (aVar == null || z12) ? null : new d(aVar));
    }

    public static void m(File file) throws Cache.CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        z3.o.c("SimpleCache", str);
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
                    z3.o.c("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    public static synchronized boolean t(File file) {
        return f9635l.add(file.getAbsoluteFile());
    }

    public static long x(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    public final s A(String str, s sVar) {
        boolean z11;
        if (!this.f9642g) {
            return sVar;
        }
        String name = ((File) z3.a.e(sVar.f9686f)).getName();
        long j11 = sVar.f9684c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        d dVar = this.f9639d;
        if (dVar != null) {
            try {
                dVar.h(name, j11, jCurrentTimeMillis);
            } catch (IOException unused) {
                z3.o.h("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z11 = false;
        } else {
            z11 = true;
        }
        s sVarL = ((j) z3.a.e(this.f9638c.g(str))).l(sVar, jCurrentTimeMillis, z11);
        w(sVar, sVarL);
        return sVarL;
    }

    @Override // androidx.media3.datasource.cache.Cache
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

    @Override // androidx.media3.datasource.cache.Cache
    @Nullable
    public synchronized h b(String str, long j11, long j12) throws Cache.CacheException {
        z3.a.g(!this.f9645j);
        l();
        s sVarP = p(str, j11, j12);
        if (sVarP.f9685d) {
            return A(str, sVarP);
        }
        if (this.f9638c.m(str).j(j11, sVarP.f9684c)) {
            return sVarP;
        }
        return null;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized h c(String str, long j11, long j12) throws InterruptedException, Cache.CacheException {
        h hVarB;
        z3.a.g(!this.f9645j);
        l();
        while (true) {
            hVarB = b(str, j11, j12);
            if (hVarB == null) {
                wait();
            }
        }
        return hVarB;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void d(File file, long j11) throws Cache.CacheException {
        z3.a.g(!this.f9645j);
        if (file.exists()) {
            if (j11 == 0) {
                file.delete();
                return;
            }
            s sVar = (s) z3.a.e(s.h(file, j11, this.f9638c));
            j jVar = (j) z3.a.e(this.f9638c.g(sVar.f9682a));
            z3.a.g(jVar.h(sVar.f9683b, sVar.f9684c));
            long jA = l.a(jVar.d());
            if (jA != -1) {
                z3.a.g(sVar.f9683b + sVar.f9684c <= jA);
            }
            if (this.f9639d == null) {
                k(sVar);
                this.f9638c.s();
                notifyAll();
                return;
            }
            try {
                this.f9639d.h(file.getName(), sVar.f9684c, sVar.f9687g);
                k(sVar);
                try {
                    this.f9638c.s();
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

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void e(String str) {
        z3.a.g(!this.f9645j);
        Iterator<h> it = o(str).iterator();
        while (it.hasNext()) {
            y(it.next());
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void f(h hVar) {
        z3.a.g(!this.f9645j);
        y(hVar);
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void g(h hVar) {
        z3.a.g(!this.f9645j);
        j jVar = (j) z3.a.e(this.f9638c.g(hVar.f9682a));
        jVar.m(hVar.f9683b);
        this.f9638c.p(jVar.f9699b);
        notifyAll();
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized long getCachedLength(String str, long j11, long j12) {
        j jVarG;
        z3.a.g(!this.f9645j);
        if (j12 == -1) {
            j12 = Long.MAX_VALUE;
        }
        jVarG = this.f9638c.g(str);
        return jVarG != null ? jVarG.c(j11, j12) : -j12;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized m getContentMetadata(String str) {
        z3.a.g(!this.f9645j);
        return this.f9638c.j(str);
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void h(String str, n nVar) throws Cache.CacheException {
        z3.a.g(!this.f9645j);
        l();
        this.f9638c.e(str, nVar);
        try {
            this.f9638c.s();
        } catch (IOException e11) {
            throw new Cache.CacheException(e11);
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized boolean isCached(String str, long j11, long j12) {
        boolean z11;
        z11 = false;
        z3.a.g(!this.f9645j);
        j jVarG = this.f9638c.g(str);
        if (jVarG != null && jVarG.c(j11, j12) >= j12) {
            z11 = true;
        }
        return z11;
    }

    public final void k(s sVar) {
        this.f9638c.m(sVar.f9682a).a(sVar);
        this.f9644i += sVar.f9684c;
        u(sVar);
    }

    public synchronized void l() throws Cache.CacheException {
        Cache.CacheException cacheException = this.f9646k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public synchronized NavigableSet<h> o(String str) {
        j jVarG;
        try {
            z3.a.g(!this.f9645j);
            jVarG = this.f9638c.g(str);
        } catch (Throwable th2) {
            throw th2;
        }
        return (jVarG == null || jVarG.g()) ? new TreeSet() : new TreeSet((Collection) jVarG.f());
    }

    public final s p(String str, long j11, long j12) {
        s sVarE;
        j jVarG = this.f9638c.g(str);
        if (jVarG == null) {
            return s.i(str, j11, j12);
        }
        while (true) {
            sVarE = jVarG.e(j11, j12);
            if (!sVarE.f9685d || ((File) z3.a.e(sVarE.f9686f)).length() == sVarE.f9684c) {
                break;
            }
            z();
        }
        return sVarE;
    }

    public final void q() {
        if (!this.f9636a.exists()) {
            try {
                m(this.f9636a);
            } catch (Cache.CacheException e11) {
                this.f9646k = e11;
                return;
            }
        }
        File[] fileArrListFiles = this.f9636a.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + this.f9636a;
            z3.o.c("SimpleCache", str);
            this.f9646k = new Cache.CacheException(str);
            return;
        }
        long jS = s(fileArrListFiles);
        this.f9643h = jS;
        if (jS == -1) {
            try {
                this.f9643h = n(this.f9636a);
            } catch (IOException e12) {
                String str2 = "Failed to create cache UID: " + this.f9636a;
                z3.o.d("SimpleCache", str2, e12);
                this.f9646k = new Cache.CacheException(str2, e12);
                return;
            }
        }
        try {
            this.f9638c.n(this.f9643h);
            d dVar = this.f9639d;
            if (dVar != null) {
                dVar.e(this.f9643h);
                Map<String, c> mapB = this.f9639d.b();
                r(this.f9636a, true, fileArrListFiles, mapB);
                this.f9639d.g(mapB.keySet());
            } else {
                r(this.f9636a, true, fileArrListFiles, null);
            }
            this.f9638c.r();
            try {
                this.f9638c.s();
            } catch (IOException e13) {
                z3.o.d("SimpleCache", "Storing index file failed", e13);
            }
        } catch (IOException e14) {
            String str3 = "Failed to initialize cache indices: " + this.f9636a;
            z3.o.d("SimpleCache", str3, e14);
            this.f9646k = new Cache.CacheException(str3, e14);
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
                    j12 = cVarRemove.f9676a;
                    j11 = cVarRemove.f9677b;
                } else {
                    j11 = -9223372036854775807L;
                    j12 = -1;
                }
                s sVarE = s.e(file2, j12, j11, this.f9638c);
                if (sVarE != null) {
                    k(sVarE);
                } else {
                    file2.delete();
                }
            }
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized File startFile(String str, long j11, long j12) throws Cache.CacheException {
        j jVarG;
        File file;
        try {
            z3.a.g(!this.f9645j);
            l();
            jVarG = this.f9638c.g(str);
            z3.a.e(jVarG);
            z3.a.g(jVarG.h(j11, j12));
            if (!this.f9636a.exists()) {
                m(this.f9636a);
                z();
            }
            this.f9637b.d(this, str, j11, j12);
            file = new File(this.f9636a, Integer.toString(this.f9641f.nextInt(10)));
            if (!file.exists()) {
                m(file);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return s.k(file, jVarG.f9698a, j11, System.currentTimeMillis());
    }

    public final void u(s sVar) {
        ArrayList<Cache.a> arrayList = this.f9640e.get(sVar.f9682a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).c(this, sVar);
            }
        }
        this.f9637b.c(this, sVar);
    }

    public final void v(h hVar) {
        ArrayList<Cache.a> arrayList = this.f9640e.get(hVar.f9682a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).e(this, hVar);
            }
        }
        this.f9637b.e(this, hVar);
    }

    public final void w(s sVar, h hVar) {
        ArrayList<Cache.a> arrayList = this.f9640e.get(sVar.f9682a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).b(this, sVar, hVar);
            }
        }
        this.f9637b.b(this, sVar, hVar);
    }

    public final void y(h hVar) {
        j jVarG = this.f9638c.g(hVar.f9682a);
        if (jVarG == null || !jVarG.k(hVar)) {
            return;
        }
        this.f9644i -= hVar.f9684c;
        if (this.f9639d != null) {
            String name = ((File) z3.a.e(hVar.f9686f)).getName();
            try {
                this.f9639d.f(name);
            } catch (IOException unused) {
                z3.o.h("SimpleCache", "Failed to remove file index entry for: " + name);
            }
        }
        this.f9638c.p(jVarG.f9699b);
        v(hVar);
    }

    public final void z() {
        ArrayList arrayList = new ArrayList();
        Iterator<j> it = this.f9638c.h().iterator();
        while (it.hasNext()) {
            for (s sVar : it.next().f()) {
                if (((File) z3.a.e(sVar.f9686f)).length() != sVar.f9684c) {
                    arrayList.add(sVar);
                }
            }
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            y((h) arrayList.get(i11));
        }
    }
}
