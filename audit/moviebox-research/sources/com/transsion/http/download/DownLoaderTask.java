package com.transsion.http.download;

import android.os.Looper;
import androidx.annotation.NonNull;
import au.g;
import bu.d;
import com.transsion.http.impl.p;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import vt.c;
import wt.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class DownLoaderTask implements Runnable, Comparable<DownLoaderTask> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final vt.b f52816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final p f52817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f52818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f52819d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f52822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f52823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f52824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f52825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private g f52826k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f52827l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final c f52828m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private b f52829n;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f52820e = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f52821f = new e();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f52830o = 0;

    public DownLoaderTask(vt.b bVar, p pVar) {
        this.f52816a = bVar;
        this.f52825j = bVar.c().k();
        this.f52822g = bVar.c().m();
        this.f52818c = bVar.c().i();
        String strN = bVar.c().n();
        this.f52823h = strN;
        this.f52828m = new c(strN);
    }

    private File a(g gVar) throws Throwable {
        this.f52821f.a(this.f52828m);
        this.f52819d = this.f52818c + ".tmp";
        File file = new File(this.f52819d);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("can not create dir: " + parentFile.getAbsolutePath());
            }
        } else if (this.f52825j) {
            this.f52830o = file.length();
        }
        this.f52816a.c().f().put("RANGE", "bytes=" + this.f52830o + "-");
        if (isCancelled()) {
            return null;
        }
        gVar.h();
        this.f52824i = gVar.b();
        InputStream inputStreamC = gVar.c();
        File file2 = new File(this.f52819d);
        FileOutputStream fileOutputStream = this.f52825j ? new FileOutputStream(file2, true) : new FileOutputStream(file2);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStreamC);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        if (isCancelled()) {
            return null;
        }
        byte[] bArr = new byte[4096];
        do {
            int i11 = bufferedInputStream.read(bArr);
            if (i11 == -1) {
                bufferedOutputStream.flush();
                d.a(bufferedInputStream);
                d.a(bufferedOutputStream);
                this.f52821f.b(this.f52828m);
                return autoRename(file2);
            }
            if (!file2.getParentFile().exists()) {
                d.a(bufferedInputStream);
                d.a(bufferedOutputStream);
                d.a(fileOutputStream);
                this.f52821f.b(this.f52828m);
                throw new IOException("parent be deleted!");
            }
            bufferedOutputStream.write(bArr, 0, i11);
        } while (!isCancelled());
        return null;
    }

    private void a() {
        if (this.f52826k != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(new a(this)).start();
            } else {
                this.f52826k.a();
            }
        }
    }

    private synchronized void b() {
        if (!this.f52827l) {
            this.f52820e.get();
        }
    }

    private synchronized void c() {
        if (!this.f52827l) {
            this.f52820e.get();
        }
    }

    public File autoRename(File file) {
        if (this.f52818c.equals(this.f52819d)) {
            return file;
        }
        File file2 = new File(this.f52818c);
        return file.renameTo(file2) ? file2 : file;
    }

    public boolean cancel() {
        zt.a.f82154a.d("book", "cancel by tag");
        this.f52820e.set(true);
        b();
        a();
        return isCancelled();
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull DownLoaderTask downLoaderTask) {
        return 0;
    }

    public Object getTag() {
        return this.f52822g;
    }

    public boolean isCancelled() {
        return this.f52820e.get();
    }

    public boolean isDone() {
        return isCancelled() || this.f52827l;
    }

    public boolean isPaused() {
        boolean z11 = this.f52820e.get();
        if (z11) {
            c();
        }
        return z11;
    }

    public boolean pause() {
        this.f52820e.set(true);
        a();
        return isPaused();
    }

    @Override // java.lang.Runnable
    public void run() {
        startLoad();
    }

    public void setListener(b bVar) {
    }

    public void startLoad() {
        if (isCancelled()) {
            return;
        }
        g gVarD = this.f52816a.d();
        this.f52826k = gVarD;
        try {
            try {
                File fileA = a(gVarD);
                if (fileA == null || !fileA.exists() || fileA.length() > 0) {
                    isCancelled();
                } else {
                    isCancelled();
                }
            } catch (Throwable th2) {
                gVarD.a();
                throw th2;
            }
        } catch (Throwable unused) {
            File file = new File(this.f52818c);
            if (!file.exists() || file.length() > 0) {
                isCancelled();
            } else {
                isCancelled();
            }
        }
        gVarD.a();
        if (isCancelled()) {
            return;
        }
        this.f52827l = true;
    }
}
