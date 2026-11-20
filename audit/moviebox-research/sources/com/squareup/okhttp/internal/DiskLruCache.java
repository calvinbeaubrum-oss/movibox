package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class DiskLruCache implements Closeable {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Pattern f49021t = Pattern.compile("[a-z0-9_-]{1,120}");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Sink f49022u = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileSystem f49023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f49024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f49025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f49026d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final File f49027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f49028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f49029h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f49030i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BufferedSink f49032k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f49034m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f49035n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f49036o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f49037p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Executor f49039r;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f49031j = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedHashMap<String, e> f49033l = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f49038q = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Runnable f49040s = new Runnable() { // from class: com.squareup.okhttp.internal.DiskLruCache.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DiskLruCache.this) {
                if ((!DiskLruCache.this.f49036o) || DiskLruCache.this.f49037p) {
                    return;
                }
                try {
                    DiskLruCache.this.s0();
                    if (DiskLruCache.this.d0()) {
                        DiskLruCache.this.j0();
                        DiskLruCache.this.f49034m = 0;
                    }
                } catch (IOException e11) {
                    throw new RuntimeException(e11);
                }
            }
        }
    };

    /* JADX INFO: compiled from: source.java */
    public class a extends com.squareup.okhttp.internal.b {
        public a(Sink sink) {
            super(sink);
        }

        @Override // com.squareup.okhttp.internal.b
        public void a(IOException iOException) {
            DiskLruCache.this.f49035n = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Iterator<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<e> f49042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f f49043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f f49044c;

        public b() {
            this.f49042a = new ArrayList(DiskLruCache.this.f49033l.values()).iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            f fVar = this.f49043b;
            this.f49044c = fVar;
            this.f49043b = null;
            return fVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f49043b != null) {
                return true;
            }
            synchronized (DiskLruCache.this) {
                try {
                    if (DiskLruCache.this.f49037p) {
                        return false;
                    }
                    while (this.f49042a.hasNext()) {
                        f fVarN = this.f49042a.next().n();
                        if (fVarN != null) {
                            this.f49043b = fVarN;
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            f fVar = this.f49044c;
            if (fVar == null) {
                throw new IllegalStateException("remove() before next()");
            }
            try {
                DiskLruCache.this.k0(fVar.f49060a);
            } catch (IOException unused) {
            } finally {
                this.f49044c = null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements Sink {
        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j11) throws IOException {
            buffer.skip(j11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f49046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f49047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f49048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f49049d;

        /* JADX INFO: compiled from: source.java */
        public class a extends com.squareup.okhttp.internal.b {
            public a(Sink sink) {
                super(sink);
            }

            @Override // com.squareup.okhttp.internal.b
            public void a(IOException iOException) {
                synchronized (DiskLruCache.this) {
                    d.this.f49048c = true;
                }
            }
        }

        public d(e eVar) {
            this.f49046a = eVar;
            this.f49047b = eVar.f49056e ? null : new boolean[DiskLruCache.this.f49030i];
        }

        public void a() throws IOException {
            synchronized (DiskLruCache.this) {
                DiskLruCache.this.r(this, false);
            }
        }

        public void e() throws IOException {
            synchronized (DiskLruCache.this) {
                try {
                    if (this.f49048c) {
                        DiskLruCache.this.r(this, false);
                        DiskLruCache.this.l0(this.f49046a);
                    } else {
                        DiskLruCache.this.r(this, true);
                    }
                    this.f49049d = true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public Sink f(int i11) throws IOException {
            a aVar;
            synchronized (DiskLruCache.this) {
                try {
                    if (this.f49046a.f49057f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f49046a.f49056e) {
                        this.f49047b[i11] = true;
                    }
                    try {
                        aVar = new a(DiskLruCache.this.f49023a.sink(this.f49046a.f49055d[i11]));
                    } catch (FileNotFoundException unused) {
                        return DiskLruCache.f49022u;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return aVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f49052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f49053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final File[] f49054c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final File[] f49055d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f49056e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public d f49057f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f49058g;

        public e(String str) {
            this.f49052a = str;
            this.f49053b = new long[DiskLruCache.this.f49030i];
            this.f49054c = new File[DiskLruCache.this.f49030i];
            this.f49055d = new File[DiskLruCache.this.f49030i];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i11 = 0; i11 < DiskLruCache.this.f49030i; i11++) {
                sb2.append(i11);
                this.f49054c[i11] = new File(DiskLruCache.this.f49024b, sb2.toString());
                sb2.append(".tmp");
                this.f49055d[i11] = new File(DiskLruCache.this.f49024b, sb2.toString());
                sb2.setLength(length);
            }
        }

        public final IOException l(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void m(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.f49030i) {
                throw l(strArr);
            }
            for (int i11 = 0; i11 < strArr.length; i11++) {
                try {
                    this.f49053b[i11] = Long.parseLong(strArr[i11]);
                } catch (NumberFormatException unused) {
                    throw l(strArr);
                }
            }
        }

        public f n() {
            Source source;
            if (!Thread.holdsLock(DiskLruCache.this)) {
                throw new AssertionError();
            }
            Source[] sourceArr = new Source[DiskLruCache.this.f49030i];
            long[] jArr = (long[]) this.f49053b.clone();
            for (int i11 = 0; i11 < DiskLruCache.this.f49030i; i11++) {
                try {
                    sourceArr[i11] = DiskLruCache.this.f49023a.source(this.f49054c[i11]);
                } catch (FileNotFoundException unused) {
                    for (int i12 = 0; i12 < DiskLruCache.this.f49030i && (source = sourceArr[i12]) != null; i12++) {
                        g.c(source);
                    }
                    return null;
                }
            }
            return new f(this.f49052a, this.f49058g, sourceArr, jArr);
        }

        public void o(BufferedSink bufferedSink) throws IOException {
            for (long j11 : this.f49053b) {
                bufferedSink.writeByte(32).writeDecimalLong(j11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class f implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f49060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f49061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Source[] f49062c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f49063d;

        public f(String str, long j11, Source[] sourceArr, long[] jArr) {
            this.f49060a = str;
            this.f49061b = j11;
            this.f49062c = sourceArr;
            this.f49063d = jArr;
        }

        public d b() throws IOException {
            return DiskLruCache.this.x(this.f49060a, this.f49061b);
        }

        public Source c(int i11) {
            return this.f49062c[i11];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.f49062c) {
                g.c(source);
            }
        }
    }

    public DiskLruCache(FileSystem fileSystem, File file, int i11, int i12, long j11, Executor executor) {
        this.f49023a = fileSystem;
        this.f49024b = file;
        this.f49028g = i11;
        this.f49025c = new File(file, "journal");
        this.f49026d = new File(file, "journal.tmp");
        this.f49027f = new File(file, "journal.bkp");
        this.f49030i = i12;
        this.f49029h = j11;
        this.f49039r = executor;
    }

    public static DiskLruCache t(FileSystem fileSystem, File file, int i11, int i12, long j11) {
        if (j11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i12 > 0) {
            return new DiskLruCache(fileSystem, file, i11, i12, j11, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), g.s("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    public synchronized f U(String str) throws IOException {
        b0();
        q();
        t0(str);
        e eVar = this.f49033l.get(str);
        if (eVar != null && eVar.f49056e) {
            f fVarN = eVar.n();
            if (fVarN == null) {
                return null;
            }
            this.f49034m++;
            this.f49032k.writeUtf8("READ").writeByte(32).writeUtf8(str).writeByte(10);
            if (d0()) {
                this.f49039r.execute(this.f49040s);
            }
            return fVarN;
        }
        return null;
    }

    public File W() {
        return this.f49024b;
    }

    public synchronized long Z() {
        return this.f49029h;
    }

    public synchronized void b0() throws IOException {
        try {
            if (this.f49036o) {
                return;
            }
            if (this.f49023a.exists(this.f49027f)) {
                if (this.f49023a.exists(this.f49025c)) {
                    this.f49023a.delete(this.f49027f);
                } else {
                    this.f49023a.rename(this.f49027f, this.f49025c);
                }
            }
            if (this.f49023a.exists(this.f49025c)) {
                try {
                    h0();
                    g0();
                    this.f49036o = true;
                    return;
                } catch (IOException e11) {
                    com.squareup.okhttp.internal.e.f().i("DiskLruCache " + this.f49024b + " is corrupt: " + e11.getMessage() + ", removing");
                    u();
                    this.f49037p = false;
                }
            }
            j0();
            this.f49036o = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.f49036o && !this.f49037p) {
                for (e eVar : (e[]) this.f49033l.values().toArray(new e[this.f49033l.size()])) {
                    if (eVar.f49057f != null) {
                        eVar.f49057f.a();
                    }
                }
                s0();
                this.f49032k.close();
                this.f49032k = null;
                this.f49037p = true;
                return;
            }
            this.f49037p = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final boolean d0() {
        int i11 = this.f49034m;
        return i11 >= 2000 && i11 >= this.f49033l.size();
    }

    public final BufferedSink e0() throws FileNotFoundException {
        return Okio.buffer(new a(this.f49023a.appendingSink(this.f49025c)));
    }

    public synchronized void flush() throws IOException {
        if (this.f49036o) {
            q();
            s0();
            this.f49032k.flush();
        }
    }

    public final void g0() throws IOException {
        this.f49023a.delete(this.f49026d);
        Iterator<e> it = this.f49033l.values().iterator();
        while (it.hasNext()) {
            e next = it.next();
            int i11 = 0;
            if (next.f49057f == null) {
                while (i11 < this.f49030i) {
                    this.f49031j += next.f49053b[i11];
                    i11++;
                }
            } else {
                next.f49057f = null;
                while (i11 < this.f49030i) {
                    this.f49023a.delete(next.f49054c[i11]);
                    this.f49023a.delete(next.f49055d[i11]);
                    i11++;
                }
                it.remove();
            }
        }
    }

    public final void h0() throws IOException {
        BufferedSource bufferedSourceBuffer = Okio.buffer(this.f49023a.source(this.f49025c));
        try {
            String utf8LineStrict = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict2 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict3 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict4 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict5 = bufferedSourceBuffer.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(utf8LineStrict) || !"1".equals(utf8LineStrict2) || !Integer.toString(this.f49028g).equals(utf8LineStrict3) || !Integer.toString(this.f49030i).equals(utf8LineStrict4) || !"".equals(utf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + utf8LineStrict + ", " + utf8LineStrict2 + ", " + utf8LineStrict4 + ", " + utf8LineStrict5 + "]");
            }
            int i11 = 0;
            while (true) {
                try {
                    i0(bufferedSourceBuffer.readUtf8LineStrict());
                    i11++;
                } catch (EOFException unused) {
                    this.f49034m = i11 - this.f49033l.size();
                    if (bufferedSourceBuffer.exhausted()) {
                        this.f49032k = e0();
                    } else {
                        j0();
                    }
                    g.c(bufferedSourceBuffer);
                    return;
                }
            }
        } catch (Throwable th2) {
            g.c(bufferedSourceBuffer);
            throw th2;
        }
    }

    public final void i0(String str) throws IOException {
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
                this.f49033l.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i11, iIndexOf2);
        }
        e eVar = this.f49033l.get(strSubstring);
        if (eVar == null) {
            eVar = new e(strSubstring);
            this.f49033l.put(strSubstring, eVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            eVar.f49056e = true;
            eVar.f49057f = null;
            eVar.m(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            eVar.f49057f = new d(eVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public synchronized boolean isClosed() {
        return this.f49037p;
    }

    public final synchronized void j0() throws IOException {
        try {
            BufferedSink bufferedSink = this.f49032k;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink bufferedSinkBuffer = Okio.buffer(this.f49023a.sink(this.f49026d));
            try {
                bufferedSinkBuffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
                bufferedSinkBuffer.writeUtf8("1").writeByte(10);
                bufferedSinkBuffer.writeDecimalLong(this.f49028g).writeByte(10);
                bufferedSinkBuffer.writeDecimalLong(this.f49030i).writeByte(10);
                bufferedSinkBuffer.writeByte(10);
                for (e eVar : this.f49033l.values()) {
                    if (eVar.f49057f != null) {
                        bufferedSinkBuffer.writeUtf8("DIRTY").writeByte(32);
                        bufferedSinkBuffer.writeUtf8(eVar.f49052a);
                        bufferedSinkBuffer.writeByte(10);
                    } else {
                        bufferedSinkBuffer.writeUtf8("CLEAN").writeByte(32);
                        bufferedSinkBuffer.writeUtf8(eVar.f49052a);
                        eVar.o(bufferedSinkBuffer);
                        bufferedSinkBuffer.writeByte(10);
                    }
                }
                bufferedSinkBuffer.close();
                if (this.f49023a.exists(this.f49025c)) {
                    this.f49023a.rename(this.f49025c, this.f49027f);
                }
                this.f49023a.rename(this.f49026d, this.f49025c);
                this.f49023a.delete(this.f49027f);
                this.f49032k = e0();
                this.f49035n = false;
            } catch (Throwable th2) {
                bufferedSinkBuffer.close();
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public synchronized boolean k0(String str) throws IOException {
        b0();
        q();
        t0(str);
        e eVar = this.f49033l.get(str);
        if (eVar == null) {
            return false;
        }
        return l0(eVar);
    }

    public final boolean l0(e eVar) throws IOException {
        if (eVar.f49057f != null) {
            eVar.f49057f.f49048c = true;
        }
        for (int i11 = 0; i11 < this.f49030i; i11++) {
            this.f49023a.delete(eVar.f49054c[i11]);
            this.f49031j -= eVar.f49053b[i11];
            eVar.f49053b[i11] = 0;
        }
        this.f49034m++;
        this.f49032k.writeUtf8("REMOVE").writeByte(32).writeUtf8(eVar.f49052a).writeByte(10);
        this.f49033l.remove(eVar.f49052a);
        if (d0()) {
            this.f49039r.execute(this.f49040s);
        }
        return true;
    }

    public synchronized long p0() throws IOException {
        b0();
        return this.f49031j;
    }

    public final synchronized void q() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized Iterator<f> q0() throws IOException {
        b0();
        return new b();
    }

    public final synchronized void r(d dVar, boolean z11) throws IOException {
        e eVar = dVar.f49046a;
        if (eVar.f49057f != dVar) {
            throw new IllegalStateException();
        }
        if (z11 && !eVar.f49056e) {
            for (int i11 = 0; i11 < this.f49030i; i11++) {
                if (!dVar.f49047b[i11]) {
                    dVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i11);
                }
                if (!this.f49023a.exists(eVar.f49055d[i11])) {
                    dVar.a();
                    return;
                }
            }
        }
        for (int i12 = 0; i12 < this.f49030i; i12++) {
            File file = eVar.f49055d[i12];
            if (!z11) {
                this.f49023a.delete(file);
            } else if (this.f49023a.exists(file)) {
                File file2 = eVar.f49054c[i12];
                this.f49023a.rename(file, file2);
                long j11 = eVar.f49053b[i12];
                long size = this.f49023a.size(file2);
                eVar.f49053b[i12] = size;
                this.f49031j = (this.f49031j - j11) + size;
            }
        }
        this.f49034m++;
        eVar.f49057f = null;
        if (eVar.f49056e || z11) {
            eVar.f49056e = true;
            this.f49032k.writeUtf8("CLEAN").writeByte(32);
            this.f49032k.writeUtf8(eVar.f49052a);
            eVar.o(this.f49032k);
            this.f49032k.writeByte(10);
            if (z11) {
                long j12 = this.f49038q;
                this.f49038q = 1 + j12;
                eVar.f49058g = j12;
            }
        } else {
            this.f49033l.remove(eVar.f49052a);
            this.f49032k.writeUtf8("REMOVE").writeByte(32);
            this.f49032k.writeUtf8(eVar.f49052a);
            this.f49032k.writeByte(10);
        }
        this.f49032k.flush();
        if (this.f49031j > this.f49029h || d0()) {
            this.f49039r.execute(this.f49040s);
        }
    }

    public final void s0() throws IOException {
        while (this.f49031j > this.f49029h) {
            l0(this.f49033l.values().iterator().next());
        }
    }

    public final void t0(String str) {
        if (f49021t.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public void u() throws IOException {
        close();
        this.f49023a.deleteContents(this.f49024b);
    }

    public d w(String str) throws IOException {
        return x(str, -1L);
    }

    public final synchronized d x(String str, long j11) throws IOException {
        b0();
        q();
        t0(str);
        e eVar = this.f49033l.get(str);
        if (j11 != -1 && (eVar == null || eVar.f49058g != j11)) {
            return null;
        }
        if (eVar != null && eVar.f49057f != null) {
            return null;
        }
        this.f49032k.writeUtf8("DIRTY").writeByte(32).writeUtf8(str).writeByte(10);
        this.f49032k.flush();
        if (this.f49035n) {
            return null;
        }
        if (eVar == null) {
            eVar = new e(str);
            this.f49033l.put(str, eVar);
        }
        d dVar = new d(eVar);
        eVar.f49057f = dVar;
        return dVar;
    }

    public synchronized void y() throws IOException {
        b0();
        for (e eVar : (e[]) this.f49033l.values().toArray(new e[this.f49033l.size()])) {
            l0(eVar);
        }
    }
}
