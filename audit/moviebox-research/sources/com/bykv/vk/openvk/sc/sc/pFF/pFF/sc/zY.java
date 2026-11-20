package com.bykv.vk.openvk.sc.sc.pFF.pFF.sc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.openvk.sc.sc.pFF.pFF.We;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.Qj.TRI;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f26028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, File> f26029b = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantReadWriteLock f26030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantReadWriteLock.ReadLock f26031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReentrantReadWriteLock.WriteLock f26032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<b> f26033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f26034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile float f26035h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f26036i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Runnable f26037j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f26038k;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Integer> f26045a;

        public a() {
            this.f26045a = new HashMap();
        }

        public synchronized void a(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.f26045a.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.f26045a.remove(str);
                    return;
                }
                this.f26045a.put(str, Integer.valueOf(num.intValue() - 1));
            }
        }

        public synchronized void b(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.f26045a.get(str);
                if (num == null) {
                    this.f26045a.put(str, 1);
                    return;
                }
                this.f26045a.put(str, Integer.valueOf(num.intValue() + 1));
            }
        }

        public synchronized boolean c(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f26045a.containsKey(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(Set<String> set);

        void sc(String str);
    }

    public zY(File file) throws IOException {
        String str;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f26030c = reentrantReadWriteLock;
        this.f26031d = reentrantReadWriteLock.readLock();
        this.f26032e = reentrantReadWriteLock.writeLock();
        this.f26033f = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f26034g = 104857600L;
        this.f26035h = 0.5f;
        this.f26036i = new a();
        this.f26037j = new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY.1
            @Override // java.lang.Runnable
            public void run() {
                TRI.pFF(new Qj("cleanupCmd", 1) { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zY zYVar = zY.this;
                        zYVar.f(zYVar.f26034g);
                    }
                });
            }
        };
        this.f26038k = new Handler(Looper.getMainLooper());
        if (file != null && file.exists() && file.isDirectory() && file.canRead() && file.canWrite()) {
            this.f26028a = file;
            TRI.pFF(new Qj("DiskLruCache", 5) { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY.2
                @Override // java.lang.Runnable
                public void run() {
                    zY.this.e();
                }
            });
            return;
        }
        if (file == null) {
            str = " dir null";
        } else {
            str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
        }
        throw new IOException("dir error!  ".concat(String.valueOf(str)));
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.b
    public File a(String str) {
        if (!this.f26031d.tryLock()) {
            return null;
        }
        File file = this.f26029b.get(str);
        this.f26031d.unlock();
        return file;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.b
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f26036i.a(str);
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.b
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f26036i.b(str);
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.b
    public File d(String str) {
        this.f26031d.lock();
        File file = this.f26029b.get(str);
        this.f26031d.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.f26028a, str);
        this.f26032e.lock();
        this.f26029b.put(str, file2);
        this.f26032e.unlock();
        Iterator<b> it = this.f26033f.iterator();
        while (it.hasNext()) {
            it.next().sc(str);
        }
        n();
        return file2;
    }

    public final void e() {
        this.f26032e.lock();
        try {
            File[] fileArrListFiles = this.f26028a.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                final HashMap map = new HashMap(fileArrListFiles.length);
                ArrayList<File> arrayList = new ArrayList(fileArrListFiles.length);
                for (File file : fileArrListFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        map.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY.3
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long jLongValue = ((Long) map.get(file2)).longValue() - ((Long) map.get(file3)).longValue();
                        if (jLongValue < 0) {
                            return -1;
                        }
                        return jLongValue > 0 ? 1 : 0;
                    }
                });
                for (File file2 : arrayList) {
                    this.f26029b.put(i(file2), file2);
                }
            }
            this.f26032e.unlock();
            n();
        } catch (Throwable th2) {
            this.f26032e.unlock();
            throw th2;
        }
    }

    public final void f(long j11) {
        HashSet hashSet;
        final HashSet hashSet2 = new HashSet();
        this.f26032e.lock();
        try {
            Iterator<Map.Entry<String, File>> it = this.f26029b.entrySet().iterator();
            long length = 0;
            while (it.hasNext()) {
                length += it.next().getValue().length();
            }
            if (length <= j11) {
                this.f26032e.unlock();
                return;
            }
            long j12 = (long) (j11 * this.f26035h);
            hashSet = new HashSet();
            try {
                for (Map.Entry<String, File> entry : this.f26029b.entrySet()) {
                    File value = entry.getValue();
                    if (value == null || !value.exists()) {
                        hashSet.add(entry.getKey());
                    } else if (!this.f26036i.c(i(value))) {
                        long length2 = value.length();
                        File file = new File(value.getAbsolutePath() + "-tmp");
                        if (value.renameTo(file)) {
                            hashSet2.add(file);
                            length -= length2;
                            hashSet.add(entry.getKey());
                        }
                    }
                    if (length <= j12) {
                        break;
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    this.f26029b.remove((String) it2.next());
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            hashSet = null;
        }
        this.f26032e.unlock();
        Iterator<b> it3 = this.f26033f.iterator();
        while (it3.hasNext()) {
            it3.next().a(hashSet);
        }
        TRI.pFF(new Qj("trimSize", 1) { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it4 = hashSet2.iterator();
                while (it4.hasNext()) {
                    try {
                        ((File) it4.next()).delete();
                    } catch (Throwable unused3) {
                    }
                }
            }
        });
    }

    public final String i(File file) {
        return file.getName();
    }

    public void j() {
        We.o().a();
        Context contextD = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.d();
        if (contextD != null) {
            com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.zY.f(contextD).g(0);
        }
        this.f26038k.removeCallbacks(this.f26037j);
        TRI.pFF(new Qj("clear", 1) { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY.4
            @Override // java.lang.Runnable
            public void run() {
                zY.this.f(0L);
            }
        });
    }

    public void k(long j11) {
        this.f26034g = j11;
        n();
    }

    public void l(b bVar) {
        if (bVar != null) {
            this.f26033f.add(bVar);
        }
    }

    public final void n() {
        this.f26038k.removeCallbacks(this.f26037j);
        this.f26038k.postDelayed(this.f26037j, 10000L);
    }
}
