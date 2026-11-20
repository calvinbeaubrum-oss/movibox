package wt;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f79605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f79606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f79607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f79608d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f79609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f79610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f79611h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Writer f79613j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f79615l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f79619p;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f79612i = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap<String, d> f79614k = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f79616m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ThreadPoolExecutor f79617n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Callable<Void> f79618o = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<Void> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (f.this) {
                try {
                    if (f.this.f79613j == null) {
                        return null;
                    }
                    f.this.y();
                    if (f.this.n()) {
                        f.this.w();
                        f.this.f79615l = 0;
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements ThreadFactory {
        public /* synthetic */ b(a aVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f79621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f79622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f79623c;

        public /* synthetic */ c(d dVar, a aVar) {
            this.f79621a = dVar;
            this.f79622b = dVar.f79629e ? null : new boolean[f.this.f79611h];
        }

        public File a(int i11) throws IOException {
            File file;
            synchronized (f.this) {
                try {
                    if (this.f79621a.f79630f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f79621a.f79629e) {
                        this.f79622b[i11] = true;
                    }
                    file = this.f79621a.f79628d[i11];
                    if (!f.this.f79605a.exists()) {
                        f.this.f79605a.mkdirs();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return file;
        }

        public void c() throws IOException {
            f.this.j(this, false);
        }

        public void d() {
            if (this.f79623c) {
                return;
            }
            try {
                c();
            } catch (IOException unused) {
            }
        }

        public void f() throws IOException {
            f.this.j(this, true);
            this.f79623c = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f79625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f79626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public File[] f79627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public File[] f79628d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f79629e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f79630f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f79631g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f79632h;

        public /* synthetic */ d(String str, a aVar) {
            this.f79625a = str;
            this.f79626b = new long[f.this.f79611h];
            this.f79627c = new File[f.this.f79611h];
            this.f79628d = new File[f.this.f79611h];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i11 = 0; i11 < f.this.f79611h; i11++) {
                sb2.append(i11);
                this.f79627c[i11] = new File(f.this.f79605a, sb2.toString());
                sb2.append(".tmp");
                this.f79628d[i11] = new File(f.this.f79605a, sb2.toString());
                sb2.setLength(length);
            }
        }

        public File c(int i11) {
            return this.f79627c[i11];
        }

        public final IOException d(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public String e() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long j11 : this.f79626b) {
                sb2.append(' ');
                sb2.append(j11);
            }
            return sb2.toString();
        }

        public File j(int i11) {
            return this.f79628d[i11];
        }

        public final void k(String[] strArr) throws IOException {
            if (strArr.length != f.this.f79611h) {
                d(strArr);
                throw null;
            }
            for (int i11 = 0; i11 < strArr.length; i11++) {
                try {
                    this.f79626b[i11] = Long.parseLong(strArr[i11]);
                } catch (NumberFormatException unused) {
                    d(strArr);
                    throw null;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File[] f79634a;

        public /* synthetic */ e(f fVar, String str, long j11, File[] fileArr, long[] jArr, a aVar) {
            this.f79634a = fileArr;
        }

        public File a(int i11) {
            return this.f79634a[i11];
        }
    }

    public f(File file, int i11, int i12, long j11, long j12) {
        this.f79605a = file;
        this.f79609f = i11;
        this.f79606b = new File(file, "journal");
        this.f79607c = new File(file, "journal.tmp");
        this.f79608d = new File(file, "journal.bkp");
        this.f79611h = i12;
        this.f79610g = j11;
        this.f79619p = j12;
    }

    public static f e(File file, int i11, int i12, long j11, long j12) throws IOException {
        if (j11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i12 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                i(file2, file3, false);
            }
        }
        f fVar = new f(file, i11, i12, j11, j12);
        if (fVar.f79606b.exists()) {
            try {
                fVar.t();
                fVar.p();
                return fVar;
            } catch (IOException e11) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e11.getMessage() + ", removing");
                fVar.close();
                wt.d.c(fVar.f79605a);
            }
        }
        file.mkdirs();
        f fVar2 = new f(file, i11, i12, j11, j12);
        fVar2.w();
        return fVar2;
    }

    public static void h(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void i(File file, File file2, boolean z11) throws IOException {
        if (z11) {
            h(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public c c(String str) throws IOException {
        return d(str, -1L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.f79613j == null) {
                return;
            }
            for (d dVar : new ArrayList(this.f79614k.values())) {
                if (dVar.f79630f != null) {
                    dVar.f79630f.c();
                }
            }
            y();
            this.f79613j.close();
            this.f79613j = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized c d(String str, long j11) throws IOException {
        g();
        d dVar = this.f79614k.get(str);
        a aVar = null;
        if (j11 != -1 && (dVar == null || dVar.f79631g != j11)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(str, aVar);
            this.f79614k.put(str, dVar);
        } else if (dVar.f79630f != null) {
            return null;
        }
        c cVar = new c(dVar, aVar);
        dVar.f79630f = cVar;
        this.f79613j.append((CharSequence) "DIRTY");
        this.f79613j.append(' ');
        this.f79613j.append((CharSequence) str);
        this.f79613j.append('\n');
        this.f79613j.flush();
        return cVar;
    }

    public final void g() {
        if (this.f79613j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void j(c cVar, boolean z11) throws IOException {
        d dVar = cVar.f79621a;
        if (dVar.f79630f != cVar) {
            throw new IllegalStateException();
        }
        if (z11 && !dVar.f79629e) {
            for (int i11 = 0; i11 < this.f79611h; i11++) {
                if (!cVar.f79622b[i11]) {
                    cVar.c();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i11);
                }
                if (!dVar.j(i11).exists()) {
                    cVar.c();
                    return;
                }
            }
        }
        for (int i12 = 0; i12 < this.f79611h; i12++) {
            File fileJ = dVar.j(i12);
            if (!z11) {
                h(fileJ);
            } else if (fileJ.exists()) {
                File fileC = dVar.c(i12);
                fileJ.renameTo(fileC);
                long j11 = dVar.f79626b[i12];
                long length = fileC.length();
                dVar.f79626b[i12] = length;
                this.f79612i = (this.f79612i - j11) + length;
            }
        }
        this.f79615l++;
        dVar.f79630f = null;
        if (dVar.f79629e || z11) {
            dVar.f79629e = true;
            this.f79613j.append((CharSequence) "CLEAN");
            this.f79613j.append(' ');
            this.f79613j.append((CharSequence) dVar.f79625a);
            this.f79613j.append((CharSequence) dVar.e());
            this.f79613j.append(' ');
            this.f79613j.append((CharSequence) "STAMP_");
            this.f79613j.append((CharSequence) String.valueOf(System.currentTimeMillis()));
            this.f79613j.append('\n');
            if (z11) {
                long j12 = this.f79616m;
                this.f79616m = 1 + j12;
                dVar.f79631g = j12;
            }
        } else {
            this.f79614k.remove(dVar.f79625a);
            this.f79613j.append((CharSequence) "REMOVE");
            this.f79613j.append(' ');
            this.f79613j.append((CharSequence) dVar.f79625a);
            this.f79613j.append('\n');
        }
        this.f79613j.flush();
        if (this.f79612i > this.f79610g || n()) {
            this.f79617n.submit(this.f79618o);
        }
    }

    public synchronized e l(String str) throws IOException {
        g();
        d dVar = this.f79614k.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f79629e) {
            return null;
        }
        for (File file : dVar.f79627c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f79615l++;
        this.f79613j.append((CharSequence) "READ");
        this.f79613j.append(' ');
        this.f79613j.append((CharSequence) str);
        this.f79613j.append('\n');
        if (n()) {
            this.f79617n.submit(this.f79618o);
        }
        return new e(this, str, dVar.f79631g, dVar.f79627c, dVar.f79626b, null);
    }

    public final boolean n() {
        int i11 = this.f79615l;
        return i11 >= 2000 && i11 >= this.f79614k.size();
    }

    public final void p() throws IOException {
        h(this.f79607c);
        Iterator<d> it = this.f79614k.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i11 = 0;
            if (next.f79630f == null) {
                while (i11 < this.f79611h) {
                    this.f79612i += next.f79626b[i11];
                    i11++;
                }
            } else {
                next.f79630f = null;
                while (i11 < this.f79611h) {
                    h(next.c(i11));
                    h(next.j(i11));
                    i11++;
                }
                it.remove();
            }
        }
    }

    public synchronized boolean q(String str) throws IOException {
        try {
            g();
            d dVar = this.f79614k.get(str);
            if (dVar != null && dVar.f79630f == null) {
                for (int i11 = 0; i11 < this.f79611h; i11++) {
                    File fileC = dVar.c(i11);
                    if (fileC.exists() && !fileC.delete()) {
                        throw new IOException("failed to delete " + fileC);
                    }
                    this.f79612i -= dVar.f79626b[i11];
                    dVar.f79626b[i11] = 0;
                }
                this.f79615l++;
                this.f79613j.append((CharSequence) "REMOVE");
                this.f79613j.append(' ');
                this.f79613j.append((CharSequence) str);
                this.f79613j.append('\n');
                this.f79614k.remove(str);
                if (n()) {
                    this.f79617n.submit(this.f79618o);
                }
                return true;
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void t() throws IOException {
        l lVar = new l(new FileInputStream(this.f79606b), wt.d.f79597a);
        try {
            String strC = lVar.c();
            String strC2 = lVar.c();
            String strC3 = lVar.c();
            String strC4 = lVar.c();
            String strC5 = lVar.c();
            if (!"libcore.io.DiskLruCache".equals(strC) || !"1".equals(strC2) || !Integer.toString(this.f79609f).equals(strC3) || !Integer.toString(this.f79611h).equals(strC4) || !"".equals(strC5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unexpected journal header: [");
                sb2.append(strC);
                sb2.append(", ");
                sb2.append(strC2);
                sb2.append(", ");
                sb2.append(strC4);
                sb2.append(", ");
                sb2.append(strC5);
                sb2.append("]");
                throw new IOException(sb2.toString());
            }
            int i11 = 0;
            while (true) {
                try {
                    u(lVar.c());
                    i11++;
                } catch (EOFException unused) {
                    this.f79615l = i11 - this.f79614k.size();
                    if (lVar.b()) {
                        w();
                    } else {
                        this.f79613j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f79606b, true), wt.d.f79597a));
                    }
                    wt.d.b(lVar);
                    return;
                }
            }
        } catch (Throwable th2) {
            wt.d.b(lVar);
            throw th2;
        }
    }

    public final void u(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i11 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i11);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i11);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f79614k.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i11, iIndexOf2);
        }
        d dVar = this.f79614k.get(strSubstring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(strSubstring, aVar);
            this.f79614k.put(strSubstring, dVar);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f79630f = new c(dVar, aVar);
                return;
            }
            if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
        dVar.f79629e = true;
        dVar.f79630f = null;
        if (!strArrSplit[strArrSplit.length - 1].startsWith("STAMP_")) {
            dVar.f79632h = System.currentTimeMillis();
            dVar.k(strArrSplit);
            return;
        }
        String[] strArr = new String[strArrSplit.length - 1];
        for (int i12 = 0; i12 < strArrSplit.length - 1; i12++) {
            strArr[i12] = strArrSplit[i12];
        }
        dVar.k(strArr);
        dVar.f79632h = Long.parseLong(strArrSplit[strArrSplit.length - 1].substring(6));
        if (Math.abs(System.currentTimeMillis() - dVar.f79632h) > this.f79619p) {
            dVar.f79630f = new c(dVar, aVar);
        }
    }

    public final synchronized void w() throws IOException {
        try {
            Writer writer = this.f79613j;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f79607c), wt.d.f79597a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f79609f));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f79611h));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.f79614k.values()) {
                    if (dVar.f79630f != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("DIRTY ");
                        sb2.append(dVar.f79625a);
                        sb2.append('\n');
                        bufferedWriter.write(sb2.toString());
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("CLEAN ");
                        sb3.append(dVar.f79625a);
                        sb3.append(dVar.e());
                        sb3.append(' ');
                        sb3.append("STAMP_");
                        sb3.append(dVar.f79632h);
                        sb3.append('\n');
                        bufferedWriter.write(sb3.toString());
                    }
                }
                bufferedWriter.close();
                if (this.f79606b.exists()) {
                    i(this.f79606b, this.f79608d, true);
                }
                i(this.f79607c, this.f79606b, false);
                this.f79608d.delete();
                this.f79613j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f79606b, true), wt.d.f79597a));
            } catch (Throwable th2) {
                bufferedWriter.close();
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public final void y() throws IOException {
        while (this.f79612i > this.f79610g) {
            q(this.f79614k.entrySet().iterator().next().getKey());
        }
    }
}
