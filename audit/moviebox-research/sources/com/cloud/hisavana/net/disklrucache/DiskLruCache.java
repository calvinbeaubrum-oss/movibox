package com.cloud.hisavana.net.disklrucache;

import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.disklrucache.listener.LruCleanCallBack;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class DiskLruCache implements Closeable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Pattern f28957p = Pattern.compile("[a-z0-9_-]{1,120}");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final OutputStream f28958q = new OutputStream() { // from class: com.cloud.hisavana.net.disklrucache.DiskLruCache.2
        @Override // java.io.OutputStream
        public void write(int i11) throws IOException {
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f28959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f28960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f28961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f28962d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f28963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f28964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f28965h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Writer f28967j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap<String, Entry> f28968k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f28969l;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f28966i = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f28970m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ThreadPoolExecutor f28971n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Callable<Void> f28972o = new Callable<Void>() { // from class: com.cloud.hisavana.net.disklrucache.DiskLruCache.1
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                try {
                    if (DiskLruCache.this.f28967j == null) {
                        return null;
                    }
                    DiskLruCache.this.d0();
                    if (DiskLruCache.this.r()) {
                        DiskLruCache.this.W();
                        DiskLruCache.this.f28969l = 0;
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    };

    /* JADX INFO: compiled from: source.java */
    public final class Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Entry f28974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f28975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f28976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f28977d;

        /* JADX INFO: compiled from: source.java */
        public class FaultHidingOutputStream extends FilterOutputStream {
            public FaultHidingOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    Editor.this.f28976c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    Editor.this.f28976c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i11) {
                try {
                    ((FilterOutputStream) this).out.write(i11);
                } catch (IOException unused) {
                    Editor.this.f28976c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i11, int i12) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i11, i12);
                } catch (IOException unused) {
                    Editor.this.f28976c = true;
                }
            }
        }

        public Editor(Entry entry) {
            this.f28974a = entry;
            this.f28975b = entry.f28982c ? null : new boolean[DiskLruCache.this.f28965h];
        }

        public void a() throws IOException {
            DiskLruCache.this.l(this, false);
        }

        public void b() {
            if (this.f28977d) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void f() throws IOException {
            if (this.f28976c) {
                DiskLruCache.this.l(this, false);
                DiskLruCache.this.Z(this.f28974a.f28980a);
            } else {
                DiskLruCache.this.l(this, true);
            }
            this.f28977d = true;
        }

        public OutputStream g(int i11) throws IOException {
            FileOutputStream fileOutputStream;
            FaultHidingOutputStream faultHidingOutputStream;
            if (i11 < 0 || i11 >= DiskLruCache.this.f28965h) {
                throw new IllegalArgumentException("Expected index " + i11 + " to be greater than 0 and less than the maximum value count of " + DiskLruCache.this.f28965h);
            }
            synchronized (DiskLruCache.this) {
                try {
                    if (this.f28974a.f28983d != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f28974a.f28982c) {
                        this.f28975b[i11] = true;
                    }
                    File fileK = this.f28974a.k(i11);
                    try {
                        fileOutputStream = new FileOutputStream(fileK);
                    } catch (FileNotFoundException unused) {
                        DiskLruCache.this.f28959a.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(fileK);
                        } catch (FileNotFoundException unused2) {
                            return DiskLruCache.f28958q;
                        }
                    }
                    faultHidingOutputStream = new FaultHidingOutputStream(fileOutputStream);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return faultHidingOutputStream;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f28980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f28981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f28982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Editor f28983d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f28984e;

        public Entry(String str) {
            this.f28980a = str;
            this.f28981b = new long[DiskLruCache.this.f28965h];
        }

        public File j(int i11) {
            return new File(DiskLruCache.this.f28959a, this.f28980a + InstructionFileId.DOT + i11);
        }

        public File k(int i11) {
            return new File(DiskLruCache.this.f28959a, this.f28980a + InstructionFileId.DOT + i11 + ".tmp");
        }

        public String l() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long j11 : this.f28981b) {
                sb2.append(' ');
                sb2.append(j11);
            }
            return sb2.toString();
        }

        public final IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.f28965h) {
                throw m(strArr);
            }
            for (int i11 = 0; i11 < strArr.length; i11++) {
                try {
                    this.f28981b[i11] = Long.parseLong(strArr[i11]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class Snapshot implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f28986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f28987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InputStream[] f28988c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f28989d;

        public Snapshot(String str, long j11, InputStream[] inputStreamArr, long[] jArr) {
            this.f28986a = str;
            this.f28987b = j11;
            this.f28988c = inputStreamArr;
            this.f28989d = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f28988c) {
                DiskLruCacheUtil.b(inputStream);
            }
        }
    }

    public DiskLruCache(File file, int i11, int i12, long j11, boolean z11) {
        this.f28959a = file;
        this.f28963f = i11;
        this.f28960b = new File(file, "journal");
        this.f28961c = new File(file, "journal.tmp");
        this.f28962d = new File(file, "journal.bkp");
        this.f28965h = i12;
        this.f28964g = j11;
        this.f28968k = new LinkedHashMap<>(0, 0.75f, z11);
    }

    public static void b0(File file, File file2, boolean z11) throws IOException {
        if (z11) {
            n(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void n(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static DiskLruCache u(File file, int i11, int i12, long j11) throws IOException {
        return w(file, i11, i12, j11, true);
    }

    public static DiskLruCache w(File file, int i11, int i12, long j11, boolean z11) throws IOException {
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
                b0(file2, file3, false);
            }
        }
        DiskLruCache diskLruCache = new DiskLruCache(file, i11, i12, j11, z11);
        if (diskLruCache.f28960b.exists()) {
            try {
                diskLruCache.y();
                diskLruCache.x();
                return diskLruCache;
            } catch (IOException e11) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e11.getMessage() + ", removing");
                diskLruCache.m();
            }
        }
        file.mkdirs();
        DiskLruCache diskLruCache2 = new DiskLruCache(file, i11, i12, j11, z11);
        diskLruCache2.W();
        return diskLruCache2;
    }

    public final void U(String str) throws IOException {
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
                this.f28968k.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i11, iIndexOf2);
        }
        Entry entry = this.f28968k.get(strSubstring);
        if (entry == null) {
            entry = new Entry(strSubstring);
            this.f28968k.put(strSubstring, entry);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            entry.f28982c = true;
            entry.f28983d = null;
            entry.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            entry.f28983d = new Editor(entry);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final synchronized void W() throws IOException {
        try {
            Writer writer = this.f28967j;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f28961c), DiskLruCacheUtil.f29010a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f28963f));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f28965h));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (Entry entry : this.f28968k.values()) {
                    if (entry.f28983d != null) {
                        bufferedWriter.write("DIRTY " + entry.f28980a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + entry.f28980a + entry.l() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f28960b.exists()) {
                    b0(this.f28960b, this.f28962d, true);
                }
                b0(this.f28961c, this.f28960b, false);
                this.f28962d.delete();
                this.f28967j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f28960b, true), DiskLruCacheUtil.f29010a));
            } catch (Throwable th2) {
                bufferedWriter.close();
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public synchronized boolean Z(String str) throws IOException {
        try {
            k();
            e0(str);
            Entry entry = this.f28968k.get(str);
            if (entry != null && entry.f28983d == null) {
                for (int i11 = 0; i11 < this.f28965h; i11++) {
                    File fileJ = entry.j(i11);
                    if (fileJ.exists() && !fileJ.delete()) {
                        throw new IOException("failed to delete " + fileJ);
                    }
                    this.f28966i -= entry.f28981b[i11];
                    entry.f28981b[i11] = 0;
                }
                this.f28969l++;
                this.f28967j.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f28968k.remove(str);
                if (r()) {
                    this.f28971n.submit(this.f28972o);
                }
                return true;
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.f28967j == null) {
                return;
            }
            for (Entry entry : new ArrayList(this.f28968k.values())) {
                if (entry.f28983d != null) {
                    entry.f28983d.a();
                }
            }
            d0();
            this.f28967j.close();
            this.f28967j = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void d0() throws IOException {
        while (this.f28966i > this.f28964g) {
            Map.Entry<String, Entry> next = this.f28968k.entrySet().iterator().next();
            if (Z(next.getKey())) {
                t(next.getKey());
            }
        }
    }

    public final void e0(String str) {
        if (f28957p.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public synchronized void flush() throws IOException {
        k();
        d0();
        this.f28967j.flush();
    }

    public final void k() {
        if (this.f28967j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void l(Editor editor, boolean z11) throws IOException {
        Entry entry = editor.f28974a;
        if (entry.f28983d != editor) {
            throw new IllegalStateException();
        }
        if (z11 && !entry.f28982c) {
            for (int i11 = 0; i11 < this.f28965h; i11++) {
                if (!editor.f28975b[i11]) {
                    editor.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i11);
                }
                if (!entry.k(i11).exists()) {
                    editor.a();
                    return;
                }
            }
        }
        for (int i12 = 0; i12 < this.f28965h; i12++) {
            File fileK = entry.k(i12);
            if (!z11) {
                n(fileK);
            } else if (fileK.exists()) {
                File fileJ = entry.j(i12);
                fileK.renameTo(fileJ);
                long j11 = entry.f28981b[i12];
                long length = fileJ.length();
                entry.f28981b[i12] = length;
                this.f28966i = (this.f28966i - j11) + length;
            }
        }
        this.f28969l++;
        entry.f28983d = null;
        if (entry.f28982c || z11) {
            entry.f28982c = true;
            this.f28967j.write("CLEAN " + entry.f28980a + entry.l() + '\n');
            if (z11) {
                long j12 = this.f28970m;
                this.f28970m = 1 + j12;
                entry.f28984e = j12;
            }
        } else {
            this.f28968k.remove(entry.f28980a);
            this.f28967j.write("REMOVE " + entry.f28980a + '\n');
        }
        this.f28967j.flush();
        if (this.f28966i > this.f28964g || r()) {
            this.f28971n.submit(this.f28972o);
        }
    }

    public void m() throws IOException {
        close();
        DiskLruCacheUtil.c(this.f28959a);
    }

    public Editor o(String str) throws IOException {
        return p(str, -1L);
    }

    public final synchronized Editor p(String str, long j11) throws IOException {
        k();
        e0(str);
        Entry entry = this.f28968k.get(str);
        if (j11 != -1 && (entry == null || entry.f28984e != j11)) {
            return null;
        }
        if (entry == null) {
            entry = new Entry(str);
            this.f28968k.put(str, entry);
        } else if (entry.f28983d != null) {
            return null;
        }
        Editor editor = new Editor(entry);
        entry.f28983d = editor;
        this.f28967j.write("DIRTY " + str + '\n');
        this.f28967j.flush();
        return editor;
    }

    public synchronized Snapshot q(String str) throws IOException {
        InputStream inputStream;
        k();
        e0(str);
        Entry entry = this.f28968k.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.f28982c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f28965h];
        for (int i11 = 0; i11 < this.f28965h; i11++) {
            try {
                inputStreamArr[i11] = new FileInputStream(entry.j(i11));
            } catch (FileNotFoundException unused) {
                for (int i12 = 0; i12 < this.f28965h && (inputStream = inputStreamArr[i12]) != null; i12++) {
                    DiskLruCacheUtil.b(inputStream);
                }
                return null;
            }
        }
        this.f28969l++;
        this.f28967j.append((CharSequence) ("READ " + str + '\n'));
        if (r()) {
            this.f28971n.submit(this.f28972o);
        }
        return new Snapshot(str, entry.f28984e, inputStreamArr, entry.f28981b);
    }

    public final boolean r() {
        int i11 = this.f28969l;
        return i11 >= 2000 && i11 >= this.f28968k.size();
    }

    public final void t(String str) {
        HttpRequest httpRequest = HttpRequest.f28935a;
        if (httpRequest.g().isEmpty() || TextUtils.isEmpty(str)) {
            return;
        }
        for (LruCleanCallBack lruCleanCallBack : httpRequest.g()) {
            if (lruCleanCallBack != null) {
                lruCleanCallBack.onCallBack(str);
            }
        }
    }

    public final void x() throws IOException {
        n(this.f28961c);
        Iterator<Entry> it = this.f28968k.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i11 = 0;
            if (next.f28983d == null) {
                while (i11 < this.f28965h) {
                    this.f28966i += next.f28981b[i11];
                    i11++;
                }
            } else {
                next.f28983d = null;
                while (i11 < this.f28965h) {
                    n(next.j(i11));
                    n(next.k(i11));
                    i11++;
                }
                it.remove();
            }
        }
    }

    public final void y() throws IOException {
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.f28960b), DiskLruCacheUtil.f29010a);
        try {
            String strD = strictLineReader.d();
            String strD2 = strictLineReader.d();
            String strD3 = strictLineReader.d();
            String strD4 = strictLineReader.d();
            String strD5 = strictLineReader.d();
            if (!"libcore.io.DiskLruCache".equals(strD) || !"1".equals(strD2) || !Integer.toString(this.f28963f).equals(strD3) || !Integer.toString(this.f28965h).equals(strD4) || !"".equals(strD5)) {
                throw new IOException("unexpected journal header: [" + strD + ", " + strD2 + ", " + strD4 + ", " + strD5 + "]");
            }
            int i11 = 0;
            while (true) {
                try {
                    U(strictLineReader.d());
                    i11++;
                } catch (EOFException unused) {
                    this.f28969l = i11 - this.f28968k.size();
                    if (strictLineReader.c()) {
                        W();
                    } else {
                        this.f28967j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f28960b, true), DiskLruCacheUtil.f29010a));
                    }
                    DiskLruCacheUtil.b(strictLineReader);
                    return;
                }
            }
        } catch (Throwable th2) {
            DiskLruCacheUtil.b(strictLineReader);
            throw th2;
        }
    }
}
