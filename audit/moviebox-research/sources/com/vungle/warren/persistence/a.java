package com.vungle.warren.persistence;

import android.content.Context;
import android.os.Environment;
import android.os.FileObserver;
import android.os.StatFs;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.utility.i;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f62312h = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f62313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FilePreferences f62314b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f62316d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f62318f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<c> f62315c = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<File> f62317e = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<FileObserver> f62319g = new ArrayList();

    /* JADX INFO: renamed from: com.vungle.warren.persistence.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class FileObserverC0632a extends FileObserver {
        public FileObserverC0632a(String str, int i11) {
            super(str, i11);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i11, @Nullable String str) {
            stopWatching();
            a.this.k();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends FileObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f62321a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, int i11, String str2) {
            super(str, i11);
            this.f62321a = str2;
        }

        @Override // android.os.FileObserver
        public void onEvent(int i11, @Nullable String str) {
            stopWatching();
            if (this.f62321a.equals(str)) {
                a.this.k();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void b();
    }

    public a(@NonNull Context context, @NonNull FilePreferences filePreferences) {
        this.f62313a = context;
        this.f62314b = filePreferences;
        filePreferences.b("cache_path", "cache_paths").c();
    }

    public static void d(File file) {
        if (file.exists() && file.isFile()) {
            i.c(file);
        }
    }

    public synchronized void b(c cVar) {
        c();
        this.f62315c.add(cVar);
        if (this.f62318f) {
            cVar.b();
        }
    }

    public final void c() {
        File file = this.f62316d;
        if (file != null && file.exists() && this.f62316d.isDirectory() && this.f62316d.canWrite()) {
            return;
        }
        k();
    }

    public long e() {
        return f(1);
    }

    public final long f(int i11) {
        StatFs statFs;
        File fileG = g();
        if (fileG == null) {
            return -1L;
        }
        try {
            statFs = new StatFs(fileG.getPath());
        } catch (IllegalArgumentException e11) {
            Log.w(f62312h, "Failed to get available bytes", e11);
            if (i11 > 0) {
                return f(i11 - 1);
            }
            statFs = null;
        }
        if (statFs != null) {
            return statFs.getAvailableBytes();
        }
        return -1L;
    }

    @Nullable
    public synchronized File g() {
        c();
        return this.f62316d;
    }

    public synchronized List<File> h() {
        c();
        return this.f62317e;
    }

    public final synchronized void i(File file) {
        if (file == null) {
            return;
        }
        try {
            this.f62319g.clear();
            this.f62319g.add(new FileObserverC0632a(file.getPath(), 1024));
            while (file.getParent() != null) {
                this.f62319g.add(new b(file.getParent(), 256, file.getName()));
                file = file.getParentFile();
            }
            Iterator<FileObserver> it = this.f62319g.iterator();
            while (it.hasNext()) {
                try {
                    it.next().startWatching();
                } catch (Exception e11) {
                    VungleLogger.k(true, f62312h, "ExceptionContext", Log.getStackTraceString(e11));
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void j(c cVar) {
        this.f62315c.remove(cVar);
    }

    public final synchronized void k() {
        File file;
        boolean z11;
        File parentFile;
        try {
            File file2 = null;
            if (this.f62316d == null) {
                String strF = this.f62314b.f("cache_path", null);
                this.f62316d = strF != null ? new File(strF) : null;
            }
            File externalFilesDir = this.f62313a.getExternalFilesDir(null);
            File filesDir = this.f62313a.getFilesDir();
            boolean z12 = Environment.getExternalStorageState().equals("mounted") && externalFilesDir != null;
            ArrayList arrayList = new ArrayList();
            if (z12 && (parentFile = externalFilesDir.getParentFile()) != null) {
                arrayList.add(new File(parentFile, "no_backup"));
            }
            arrayList.add(this.f62313a.getNoBackupFilesDir());
            if (z12) {
                arrayList.add(externalFilesDir);
            }
            arrayList.add(filesDir);
            Iterator it = arrayList.iterator();
            boolean zMkdirs = false;
            while (it.hasNext()) {
                File file3 = new File((File) it.next(), "vungle_cache");
                d(file3);
                if (file3.exists()) {
                    z11 = file3.isDirectory() && file3.canWrite();
                } else {
                    zMkdirs = file3.mkdirs();
                    z11 = zMkdirs;
                }
                if (z11) {
                    file2 = file3;
                    break;
                }
            }
            File cacheDir = this.f62313a.getCacheDir();
            HashSet<String> hashSetG = this.f62314b.g("cache_paths", new HashSet<>());
            if (file2 != null) {
                com.vungle.warren.utility.c.a(hashSetG, file2.getPath());
            }
            com.vungle.warren.utility.c.a(hashSetG, cacheDir.getPath());
            this.f62314b.k("cache_paths", hashSetG).c();
            this.f62317e.clear();
            for (String str : hashSetG) {
                if (file2 == null || !file2.getPath().equals(str)) {
                    this.f62317e.add(new File(str));
                }
            }
            if (zMkdirs || ((file2 != null && !file2.equals(this.f62316d)) || ((file = this.f62316d) != null && !file.equals(file2)))) {
                this.f62316d = file2;
                if (file2 != null) {
                    this.f62314b.j("cache_path", file2.getPath()).c();
                }
                Iterator<c> it2 = this.f62315c.iterator();
                while (it2.hasNext()) {
                    it2.next().b();
                }
                this.f62318f = true;
                for (File file4 : this.f62317e) {
                    if (!file4.equals(cacheDir)) {
                        try {
                            i.b(file4);
                        } catch (IOException unused) {
                            VungleLogger.d(true, f62312h, "CacheManager", "Can't remove old cache:" + file4.getPath());
                        }
                    }
                }
            }
            i(externalFilesDir);
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
