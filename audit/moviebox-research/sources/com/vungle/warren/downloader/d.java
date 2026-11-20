package com.vungle.warren.downloader;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.transsion.api.gateway.utils.EncoderUtil;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.u;
import com.vungle.warren.utility.i;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.vungle.warren.persistence.a f61987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c<File> f61988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f61989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u f61990e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<File, Long> f61986a = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<File, Integer> f61991f = new ConcurrentHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashSet<File> f61992g = new HashSet<>();

    public d(@NonNull com.vungle.warren.persistence.a aVar, @NonNull c<File> cVar, @NonNull u uVar, long j11) {
        this.f61987b = aVar;
        this.f61988c = cVar;
        this.f61990e = uVar;
        this.f61989d = Math.max(0L, j11);
    }

    @Override // com.vungle.warren.downloader.f
    @NonNull
    public synchronized File a(@NonNull String str) throws IOException {
        File file;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256);
            messageDigest.update(str.getBytes("UTF-8"));
            file = new File(k(), Base64.encodeToString(messageDigest.digest(), 10));
            this.f61988c.b(file, 0L);
        } catch (UnsupportedEncodingException e11) {
            VungleLogger.c("CleverCache#getFile; loadAd sequence", "cannot encode url with charset = UTF-8");
            throw new IOException(e11);
        } catch (NoSuchAlgorithmException e12) {
            VungleLogger.c("CleverCache#getFile; loadAd sequence", "cannot get instance of MessageDigest with algorithm " + EncoderUtil.ALGORITHM_SHA_256);
            throw new IOException(e12);
        }
        return file;
    }

    @Override // com.vungle.warren.downloader.f
    public synchronized void b(@NonNull File file, long j11) {
        this.f61986a.put(file, Long.valueOf(j11));
        v();
    }

    @Override // com.vungle.warren.downloader.f
    public synchronized void c(@NonNull File file, long j11) {
        this.f61988c.b(file, j11);
        this.f61988c.d();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cache hit ");
        sb2.append(file);
        sb2.append(" cache touch updated");
        h();
    }

    @Override // com.vungle.warren.downloader.f
    public synchronized void clear() {
        try {
            List<File> listA = this.f61988c.a();
            q(listA);
            int i11 = 0;
            for (File file : listA) {
                if (file != null && !r(file) && deleteContents(file)) {
                    i11++;
                    this.f61988c.remove(file);
                    this.f61986a.remove(file);
                }
            }
            if (i11 > 0) {
                this.f61988c.d();
                v();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.vungle.warren.downloader.f
    @NonNull
    public synchronized File d(@NonNull File file) {
        return new File(o(), file.getName() + ".vng_meta");
    }

    @Override // com.vungle.warren.downloader.f
    public synchronized boolean deleteContents(@NonNull File file) {
        boolean z11;
        try {
            i.b(file);
            try {
                i.b(d(file));
                return true;
            } catch (IOException e11) {
                e = e11;
                z11 = true;
                Object[] objArr = new Object[3];
                objArr[0] = z11 ? "meta" : "file";
                objArr[1] = file.getPath();
                objArr[2] = e;
                VungleLogger.c("CleverCache#deleteContents; loadAd sequence", String.format("Cannot delete %1$s for file %2$s; Error %3$s occured", objArr));
                return false;
            }
        } catch (IOException e12) {
            e = e12;
            z11 = false;
        }
    }

    @Override // com.vungle.warren.downloader.f
    public synchronized void e(@NonNull File file) {
        Integer num = this.f61991f.get(file);
        if (num == null) {
            this.f61991f.remove(file);
            return;
        }
        Integer numValueOf = Integer.valueOf(num.intValue() - 1);
        if (numValueOf.intValue() <= 0) {
            this.f61991f.remove(file);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Stop tracking file: ");
        sb2.append(file);
        sb2.append(" ref count ");
        sb2.append(numValueOf);
    }

    @Override // com.vungle.warren.downloader.f
    public synchronized void f(@NonNull File file) {
        try {
            Integer num = this.f61991f.get(file);
            this.f61988c.b(file, 0L);
            this.f61988c.d();
            int iValueOf = (num == null || num.intValue() <= 0) ? 1 : Integer.valueOf(num.intValue() + 1);
            this.f61991f.put(file, iValueOf);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Start tracking file: ");
            sb2.append(file);
            sb2.append(" ref count ");
            sb2.append(iValueOf);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.vungle.warren.downloader.f
    public synchronized boolean g(@NonNull File file) {
        if (!deleteContents(file)) {
            this.f61992g.add(file);
            u();
            return false;
        }
        this.f61986a.remove(file);
        this.f61988c.remove(file);
        this.f61988c.d();
        v();
        this.f61992g.remove(file);
        u();
        return true;
    }

    @Override // com.vungle.warren.downloader.f
    @NonNull
    public synchronized List<File> h() {
        j();
        long jA = this.f61990e.a();
        long jH = i.h(k());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Purge check current cache total: ");
        sb2.append(jH);
        sb2.append(" target: ");
        sb2.append(jA);
        if (jH < jA) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        List<File> listA = this.f61988c.a();
        q(listA);
        long jH2 = i.h(k());
        if (jH2 < jA) {
            return Collections.emptyList();
        }
        for (File file : listA) {
            if (file != null && !r(file)) {
                long length = file.length();
                if (deleteContents(file)) {
                    jH2 -= length;
                    arrayList.add(file);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Deleted file: ");
                    sb3.append(file.getName());
                    sb3.append(" size: ");
                    sb3.append(length);
                    sb3.append(" total: ");
                    sb3.append(jH2);
                    sb3.append(" target: ");
                    sb3.append(jA);
                    this.f61988c.remove(file);
                    this.f61986a.remove(file);
                    if (jH2 < jA) {
                        jA = this.f61990e.a();
                        if (jH2 < jA) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("Cleaned enough total: ");
                            sb4.append(jH2);
                            sb4.append(" target: ");
                            sb4.append(jA);
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        if (arrayList.size() > 0) {
            this.f61988c.d();
            v();
        }
        return arrayList;
    }

    public final synchronized void i() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f61989d;
            File[] fileArrListFiles = k().listFiles();
            HashSet hashSet = new HashSet(this.f61986a.keySet());
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file : fileArrListFiles) {
                    long jM = m(file);
                    hashSet.remove(file);
                    if (!r(file) && (jM == 0 || jM <= jCurrentTimeMillis)) {
                        if (deleteContents(file)) {
                            this.f61986a.remove(file);
                            this.f61988c.remove(file);
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Deleted expired file ");
                        sb2.append(file);
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    this.f61986a.remove((File) it.next());
                }
                this.f61988c.d();
                v();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.vungle.warren.downloader.f
    public synchronized void init() {
        this.f61988c.load();
        t();
        i();
        s();
        j();
    }

    public final void j() {
        for (File file : new HashSet(this.f61992g)) {
            if (!r(file)) {
                g(file);
            }
        }
    }

    @NonNull
    public synchronized File k() {
        File file;
        try {
            file = new File(l(), "assets");
            if (!file.isDirectory() && file.exists()) {
                i.c(file);
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return file;
    }

    public final File l() {
        File file = new File(this.f61987b.g(), "clever_cache");
        if (!file.isDirectory()) {
            i.c(file);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public synchronized long m(@NonNull File file) {
        Long l11;
        try {
            l11 = this.f61986a.get(file);
        } catch (Throwable th2) {
            throw th2;
        }
        return l11 == null ? file.lastModified() : l11.longValue();
    }

    public final File n() {
        return new File(l(), "cache_failed_to_delete");
    }

    public synchronized File o() {
        File file;
        try {
            file = new File(k(), "meta");
            if (!file.isDirectory()) {
                i.c(file);
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return file;
    }

    public final File p() {
        return new File(l(), "cache_touch_timestamp");
    }

    public final void q(List<File> list) {
        File fileO = o();
        File[] fileArrListFiles = k().listFiles();
        if (fileArrListFiles != null) {
            ArrayList<File> arrayList = new ArrayList(Arrays.asList(fileArrListFiles));
            arrayList.removeAll(list);
            arrayList.remove(fileO);
            for (File file : arrayList) {
                deleteContents(file);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Deleted non tracked file ");
                sb2.append(file);
            }
        }
    }

    public final boolean r(@NonNull File file) {
        Integer num = this.f61991f.get(file);
        if (num == null || num.intValue() <= 0) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("File is tracked and protected : ");
        sb2.append(file);
        return true;
    }

    public final void s() {
        Serializable serializable = (Serializable) i.g(n());
        if (serializable instanceof HashSet) {
            try {
                this.f61992g.addAll((HashSet) serializable);
            } catch (ClassCastException e11) {
                VungleLogger.c("CleverCache#loadFailedToDelete;", String.format("Error %1$s occurred; old set is not set of File", e11));
                i.c(n());
            }
        }
    }

    public final void t() {
        Serializable serializable = (Serializable) i.g(p());
        if (serializable instanceof HashMap) {
            try {
                this.f61986a.putAll((HashMap) serializable);
            } catch (ClassCastException e11) {
                VungleLogger.c("CleverCache#loadTouchTimestamps; loadAd sequence", String.format("Error %1$s occurred; old map is not File -> Long", e11));
                i.c(p());
            }
        }
    }

    public final void u() throws Throwable {
        File fileN = n();
        if (!this.f61992g.isEmpty()) {
            i.j(fileN, new HashSet(this.f61992g));
        } else if (fileN.exists()) {
            i.c(fileN);
        }
    }

    public final void v() throws Throwable {
        i.j(p(), new HashMap(this.f61986a));
    }
}
