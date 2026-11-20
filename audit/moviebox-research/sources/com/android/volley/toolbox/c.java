package com.android.volley.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements com.android.volley.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f16557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f16558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0164c f16559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16560d;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f16561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f16562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f16563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f16564d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f16565e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f16566f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f16567g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<com.android.volley.e> f16568h;

        public a(String str, com.android.volley.c.a aVar) {
            this(str, aVar.f16491b, aVar.f16492c, aVar.f16493d, aVar.f16494e, aVar.f16495f, a(aVar));
        }

        public a(String str, String str2, long j11, long j12, long j13, long j14, List<com.android.volley.e> list) {
            this.f16562b = str;
            this.f16563c = "".equals(str2) ? null : str2;
            this.f16564d = j11;
            this.f16565e = j12;
            this.f16566f = j13;
            this.f16567g = j14;
            this.f16568h = list;
        }

        public static List<com.android.volley.e> a(com.android.volley.c.a aVar) {
            List<com.android.volley.e> list = aVar.f16497h;
            return list != null ? list : d.h(aVar.f16496g);
        }

        public static a b(b bVar) throws IOException {
            if (c.m(bVar) == 538247942) {
                return new a(c.o(bVar), c.o(bVar), c.n(bVar), c.n(bVar), c.n(bVar), c.n(bVar), c.l(bVar));
            }
            throw new IOException();
        }

        public com.android.volley.c.a c(byte[] bArr) {
            com.android.volley.c.a aVar = new com.android.volley.c.a();
            aVar.f16490a = bArr;
            aVar.f16491b = this.f16563c;
            aVar.f16492c = this.f16564d;
            aVar.f16493d = this.f16565e;
            aVar.f16494e = this.f16566f;
            aVar.f16495f = this.f16567g;
            aVar.f16496g = d.i(this.f16568h);
            aVar.f16497h = Collections.unmodifiableList(this.f16568h);
            return aVar;
        }

        public boolean d(OutputStream outputStream) {
            try {
                c.t(outputStream, 538247942);
                c.v(outputStream, this.f16562b);
                String str = this.f16563c;
                if (str == null) {
                    str = "";
                }
                c.v(outputStream, str);
                c.u(outputStream, this.f16564d);
                c.u(outputStream, this.f16565e);
                c.u(outputStream, this.f16566f);
                c.u(outputStream, this.f16567g);
                c.s(this.f16568h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e11) {
                com.android.volley.l.b("%s", e11.toString());
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f16569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f16570b;

        public b(InputStream inputStream, long j11) {
            super(inputStream);
            this.f16569a = j11;
        }

        public long a() {
            return this.f16569a - this.f16570b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i11 = super.read();
            if (i11 != -1) {
                this.f16570b++;
            }
            return i11;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) throws IOException {
            int i13 = super.read(bArr, i11, i12);
            if (i13 != -1) {
                this.f16570b += (long) i13;
            }
            return i13;
        }
    }

    /* JADX INFO: renamed from: com.android.volley.toolbox.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0164c {
        File get();
    }

    public c(InterfaceC0164c interfaceC0164c) {
        this(interfaceC0164c, 5242880);
    }

    public c(InterfaceC0164c interfaceC0164c, int i11) {
        this.f16557a = new LinkedHashMap(16, 0.75f, true);
        this.f16558b = 0L;
        this.f16559c = interfaceC0164c;
        this.f16560d = i11;
    }

    public static int k(InputStream inputStream) throws IOException {
        int i11 = inputStream.read();
        if (i11 != -1) {
            return i11;
        }
        throw new EOFException();
    }

    public static List<com.android.volley.e> l(b bVar) throws IOException {
        int iM = m(bVar);
        if (iM < 0) {
            throw new IOException("readHeaderList size=" + iM);
        }
        List<com.android.volley.e> listEmptyList = iM == 0 ? Collections.emptyList() : new ArrayList<>();
        for (int i11 = 0; i11 < iM; i11++) {
            listEmptyList.add(new com.android.volley.e(o(bVar).intern(), o(bVar).intern()));
        }
        return listEmptyList;
    }

    public static int m(InputStream inputStream) throws IOException {
        return (k(inputStream) << 24) | k(inputStream) | (k(inputStream) << 8) | (k(inputStream) << 16);
    }

    public static long n(InputStream inputStream) throws IOException {
        return (((long) k(inputStream)) & 255) | ((((long) k(inputStream)) & 255) << 8) | ((((long) k(inputStream)) & 255) << 16) | ((((long) k(inputStream)) & 255) << 24) | ((((long) k(inputStream)) & 255) << 32) | ((((long) k(inputStream)) & 255) << 40) | ((((long) k(inputStream)) & 255) << 48) | ((255 & ((long) k(inputStream))) << 56);
    }

    public static String o(b bVar) throws IOException {
        return new String(r(bVar, n(bVar)), "UTF-8");
    }

    public static byte[] r(b bVar, long j11) throws IOException {
        long jA = bVar.a();
        if (j11 >= 0 && j11 <= jA) {
            int i11 = (int) j11;
            if (i11 == j11) {
                byte[] bArr = new byte[i11];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j11 + ", maxLength=" + jA);
    }

    public static void s(List<com.android.volley.e> list, OutputStream outputStream) throws IOException {
        if (list == null) {
            t(outputStream, 0);
            return;
        }
        t(outputStream, list.size());
        for (com.android.volley.e eVar : list) {
            v(outputStream, eVar.a());
            v(outputStream, eVar.b());
        }
    }

    public static void t(OutputStream outputStream, int i11) throws IOException {
        outputStream.write(i11 & 255);
        outputStream.write((i11 >> 8) & 255);
        outputStream.write((i11 >> 16) & 255);
        outputStream.write((i11 >> 24) & 255);
    }

    public static void u(OutputStream outputStream, long j11) throws IOException {
        outputStream.write((byte) j11);
        outputStream.write((byte) (j11 >>> 8));
        outputStream.write((byte) (j11 >>> 16));
        outputStream.write((byte) (j11 >>> 24));
        outputStream.write((byte) (j11 >>> 32));
        outputStream.write((byte) (j11 >>> 40));
        outputStream.write((byte) (j11 >>> 48));
        outputStream.write((byte) (j11 >>> 56));
    }

    public static void v(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        u(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    @Override // com.android.volley.c
    public synchronized com.android.volley.c.a a(String str) {
        a aVar = this.f16557a.get(str);
        if (aVar == null) {
            return null;
        }
        File fileF = f(str);
        try {
            b bVar = new b(new BufferedInputStream(d(fileF)), fileF.length());
            try {
                a aVarB = a.b(bVar);
                if (TextUtils.equals(str, aVarB.f16562b)) {
                    com.android.volley.c.a aVarC = aVar.c(r(bVar, bVar.a()));
                    bVar.close();
                    return aVarC;
                }
                com.android.volley.l.b("%s: key=%s, found=%s", fileF.getAbsolutePath(), str, aVarB.f16562b);
                q(str);
                bVar.close();
                return null;
            } catch (Throwable th2) {
                bVar.close();
                throw th2;
            }
        } catch (IOException e11) {
            com.android.volley.l.b("%s: %s", fileF.getAbsolutePath(), e11.toString());
            p(str);
            return null;
        }
    }

    @Override // com.android.volley.c
    public synchronized void b(String str, boolean z11) {
        try {
            com.android.volley.c.a aVarA = a(str);
            if (aVarA != null) {
                aVarA.f16495f = 0L;
                if (z11) {
                    aVarA.f16494e = 0L;
                }
                c(str, aVarA);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.android.volley.c
    public synchronized void c(String str, com.android.volley.c.a aVar) {
        long j11 = this.f16558b;
        byte[] bArr = aVar.f16490a;
        long length = j11 + ((long) bArr.length);
        int i11 = this.f16560d;
        if (length > i11 && bArr.length > i11 * 0.9f) {
            return;
        }
        File fileF = f(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(e(fileF));
            a aVar2 = new a(str, aVar);
            if (!aVar2.d(bufferedOutputStream)) {
                bufferedOutputStream.close();
                com.android.volley.l.b("Failed to write header for %s", fileF.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(aVar.f16490a);
            bufferedOutputStream.close();
            aVar2.f16561a = fileF.length();
            j(str, aVar2);
            i();
        } catch (IOException unused) {
            if (!fileF.delete()) {
                com.android.volley.l.b("Could not clean up file %s", fileF.getAbsolutePath());
            }
            h();
        }
    }

    public InputStream d(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    public OutputStream e(File file) throws FileNotFoundException {
        return new FileOutputStream(file);
    }

    public File f(String str) {
        return new File(this.f16559c.get(), g(str));
    }

    public final String g(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    public final void h() {
        if (this.f16559c.get().exists()) {
            return;
        }
        com.android.volley.l.b("Re-initializing cache after external clearing.", new Object[0]);
        this.f16557a.clear();
        this.f16558b = 0L;
        initialize();
    }

    public final void i() {
        if (this.f16558b < this.f16560d) {
            return;
        }
        if (com.android.volley.l.f16526b) {
            com.android.volley.l.e("Pruning old cache entries.", new Object[0]);
        }
        long j11 = this.f16558b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f16557a.entrySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (f(value.f16562b).delete()) {
                this.f16558b -= value.f16561a;
            } else {
                String str = value.f16562b;
                com.android.volley.l.b("Could not delete cache entry for key=%s, filename=%s", str, g(str));
            }
            it.remove();
            i11++;
            if (this.f16558b < this.f16560d * 0.9f) {
                break;
            }
        }
        if (com.android.volley.l.f16526b) {
            com.android.volley.l.e("pruned %d files, %d bytes, %d ms", Integer.valueOf(i11), Long.valueOf(this.f16558b - j11), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    @Override // com.android.volley.c
    public synchronized void initialize() {
        File file = this.f16559c.get();
        if (!file.exists()) {
            if (!file.mkdirs()) {
                com.android.volley.l.c("Unable to create cache dir %s", file.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            try {
                long length = file2.length();
                b bVar = new b(new BufferedInputStream(d(file2)), length);
                try {
                    a aVarB = a.b(bVar);
                    aVarB.f16561a = length;
                    j(aVarB.f16562b, aVarB);
                    bVar.close();
                } catch (Throwable th2) {
                    bVar.close();
                    throw th2;
                }
            } catch (IOException unused) {
                file2.delete();
            }
        }
    }

    public final void j(String str, a aVar) {
        if (this.f16557a.containsKey(str)) {
            this.f16558b += aVar.f16561a - this.f16557a.get(str).f16561a;
        } else {
            this.f16558b += aVar.f16561a;
        }
        this.f16557a.put(str, aVar);
    }

    public synchronized void p(String str) {
        boolean zDelete = f(str).delete();
        q(str);
        if (!zDelete) {
            com.android.volley.l.b("Could not delete cache entry for key=%s, filename=%s", str, g(str));
        }
    }

    public final void q(String str) {
        a aVarRemove = this.f16557a.remove(str);
        if (aVarRemove != null) {
            this.f16558b -= aVarRemove.f16561a;
        }
    }
}
