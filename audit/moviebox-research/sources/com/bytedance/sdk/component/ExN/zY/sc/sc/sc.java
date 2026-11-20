package com.bytedance.sdk.component.ExN.zY.sc.sc;

import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class sc implements Closeable {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    static final Pattern f26521sc = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream zY = new OutputStream() { // from class: com.bytedance.sdk.component.ExN.zY.sc.sc.sc.2
        @Override // java.io.OutputStream
        public void write(int i11) throws IOException {
        }
    };
    private final File ExN;
    private long Ol;
    private final int Qj;
    private int SR;
    private final File TRI;
    private Writer Tf;
    private final int WH;
    private final File We;
    final ExecutorService pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final File f26522qr;
    private long UFX = 0;
    private final LinkedHashMap<String, pFF> Ql = new LinkedHashMap<>(0, 0.75f, true);
    private long BT = -1;
    private long dE = 0;
    private final Callable<Void> Xc = new Callable<Void>() { // from class: com.bytedance.sdk.component.ExN.zY.sc.sc.sc.1
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (sc.this) {
                try {
                    if (sc.this.Tf == null) {
                        return null;
                    }
                    sc.this.Qj();
                    if (sc.this.TRI()) {
                        sc.this.ExN();
                        sc.this.SR = 0;
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    };

    /* JADX INFO: compiled from: source.java */
    public final class pFF {
        private C0242sc ExN;
        private long TRI;
        private boolean We;
        private final String pFF;
        private final long[] zY;

        private pFF(String str) {
            this.pFF = str;
            this.zY = new long[sc.this.WH];
        }

        private IOException pFF(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sc(String[] strArr) throws IOException {
            if (strArr.length != sc.this.WH) {
                throw pFF(strArr);
            }
            for (int i11 = 0; i11 < strArr.length; i11++) {
                try {
                    this.zY[i11] = Long.parseLong(strArr[i11]);
                } catch (NumberFormatException unused) {
                    throw pFF(strArr);
                }
            }
        }

        public File pFF(int i11) {
            return new File(sc.this.We, this.pFF + InstructionFileId.DOT + i11 + ".tmp");
        }

        public File sc(int i11) {
            return new File(sc.this.We, this.pFF + InstructionFileId.DOT + i11);
        }

        public String sc() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long j11 : this.zY) {
                sb2.append(' ');
                sb2.append(j11);
            }
            return sb2.toString();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.ExN.zY.sc.sc.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public final class C0242sc {
        private boolean ExN;
        private boolean We;
        private final pFF pFF;
        private final boolean[] zY;

        /* JADX INFO: renamed from: com.bytedance.sdk.component.ExN.zY.sc.sc.sc$sc$sc, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0243sc extends FilterOutputStream {
            private C0243sc(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0242sc.this.We = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0242sc.this.We = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i11) {
                try {
                    ((FilterOutputStream) this).out.write(i11);
                } catch (IOException unused) {
                    C0242sc.this.We = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i11, int i12) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i11, i12);
                } catch (IOException unused) {
                    C0242sc.this.We = true;
                }
            }
        }

        private C0242sc(pFF pff) {
            this.pFF = pff;
            this.zY = pff.We ? null : new boolean[sc.this.WH];
        }

        public void pFF() throws IOException {
            sc.this.sc(this, false);
        }

        public OutputStream sc(int i11) throws IOException {
            FileOutputStream fileOutputStream;
            C0243sc c0243sc;
            if (i11 < 0 || i11 >= sc.this.WH) {
                throw new IllegalArgumentException("Expected index " + i11 + " to be greater than 0 and less than the maximum value count of " + sc.this.WH);
            }
            synchronized (sc.this) {
                try {
                    if (this.pFF.ExN != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.pFF.We) {
                        this.zY[i11] = true;
                    }
                    File filePFF = this.pFF.pFF(i11);
                    try {
                        fileOutputStream = new FileOutputStream(filePFF);
                    } catch (FileNotFoundException unused) {
                        sc.this.We.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(filePFF);
                        } catch (FileNotFoundException unused2) {
                            return sc.zY;
                        }
                    }
                    c0243sc = new C0243sc(fileOutputStream);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return c0243sc;
        }

        public void sc() throws IOException {
            if (this.We) {
                sc.this.sc(this, false);
                sc.this.zY(this.pFF.pFF);
            } else {
                sc.this.sc(this, true);
            }
            this.ExN = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class zY implements Closeable {
        private final long[] ExN;
        private final InputStream[] We;
        private final String pFF;
        private final long zY;

        private zY(String str, long j11, InputStream[] inputStreamArr, long[] jArr) {
            this.pFF = str;
            this.zY = j11;
            this.We = inputStreamArr;
            this.ExN = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.We) {
                com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(inputStream);
            }
        }

        public InputStream sc(int i11) {
            return this.We[i11];
        }
    }

    private sc(File file, int i11, int i12, long j11, ExecutorService executorService) {
        this.We = file;
        this.Qj = i11;
        this.ExN = new File(file, "journal");
        this.TRI = new File(file, "journal.tmp");
        this.f26522qr = new File(file, "journal.bkp");
        this.WH = i12;
        this.Ol = j11;
        this.pFF = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ExN() throws IOException {
        try {
            Writer writer = this.Tf;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.TRI), We.f26519sc));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.Qj));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.WH));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (pFF pff : this.Ql.values()) {
                    if (pff.ExN != null) {
                        bufferedWriter.write("DIRTY " + pff.pFF + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + pff.pFF + pff.sc() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.ExN.exists()) {
                    sc(this.ExN, this.f26522qr, true);
                }
                sc(this.TRI, this.ExN, false);
                this.f26522qr.delete();
                this.Tf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.ExN, true), We.f26519sc));
            } catch (Throwable th2) {
                bufferedWriter.close();
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    private void ExN(String str) {
        if (f26521sc.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qj() throws IOException {
        long j11 = this.Ol;
        long j12 = this.BT;
        if (j12 >= 0) {
            j11 = j12;
        }
        while (this.UFX > j11) {
            zY(this.Ql.entrySet().iterator().next().getKey());
        }
        this.BT = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TRI() {
        int i11 = this.SR;
        return i11 >= 2000 && i11 >= this.Ql.size();
    }

    private void We() throws IOException {
        sc(this.TRI);
        Iterator<pFF> it = this.Ql.values().iterator();
        while (it.hasNext()) {
            pFF next = it.next();
            int i11 = 0;
            if (next.ExN == null) {
                while (i11 < this.WH) {
                    this.UFX += next.zY[i11];
                    i11++;
                }
            } else {
                next.ExN = null;
                while (i11 < this.WH) {
                    sc(next.sc(i11));
                    sc(next.pFF(i11));
                    i11++;
                }
                it.remove();
            }
        }
    }

    private void We(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i11 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i11);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i11);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.Ql.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i11, iIndexOf2);
        }
        pFF pff = this.Ql.get(strSubstring);
        if (pff == null) {
            pff = new pFF(strSubstring);
            this.Ql.put(strSubstring, pff);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            pff.We = true;
            pff.ExN = null;
            pff.sc(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            pff.ExN = new C0242sc(pff);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
    }

    private void qr() {
        if (this.Tf == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private synchronized C0242sc sc(String str, long j11) throws IOException {
        qr();
        ExN(str);
        pFF pff = this.Ql.get(str);
        if (j11 != -1 && (pff == null || pff.TRI != j11)) {
            return null;
        }
        if (pff == null) {
            pff = new pFF(str);
            this.Ql.put(str, pff);
        } else if (pff.ExN != null) {
            return null;
        }
        C0242sc c0242sc = new C0242sc(pff);
        pff.ExN = c0242sc;
        this.Tf.write("DIRTY " + str + '\n');
        this.Tf.flush();
        return c0242sc;
    }

    public static sc sc(File file, int i11, int i12, long j11, ExecutorService executorService) throws IOException {
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
                sc(file2, file3, false);
            }
        }
        sc scVar = new sc(file, i11, i12, j11, executorService);
        if (scVar.ExN.exists()) {
            try {
                scVar.zY();
                scVar.We();
                return scVar;
            } catch (IOException e11) {
                Log.w("DiskLruCache ", file + " is corrupt: " + e11.getMessage() + ", removing");
                scVar.pFF();
            }
        }
        file.mkdirs();
        sc scVar2 = new sc(file, i11, i12, j11, executorService);
        scVar2.ExN();
        return scVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void sc(C0242sc c0242sc, boolean z11) throws IOException {
        pFF pff = c0242sc.pFF;
        if (pff.ExN != c0242sc) {
            throw new IllegalStateException();
        }
        if (z11 && !pff.We) {
            for (int i11 = 0; i11 < this.WH; i11++) {
                if (!c0242sc.zY[i11]) {
                    c0242sc.pFF();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i11)));
                }
                if (!pff.pFF(i11).exists()) {
                    c0242sc.pFF();
                    return;
                }
            }
        }
        for (int i12 = 0; i12 < this.WH; i12++) {
            File filePFF = pff.pFF(i12);
            if (!z11) {
                sc(filePFF);
            } else if (filePFF.exists()) {
                File fileSc = pff.sc(i12);
                filePFF.renameTo(fileSc);
                long j11 = pff.zY[i12];
                long length = fileSc.length();
                pff.zY[i12] = length;
                this.UFX = (this.UFX - j11) + length;
            }
        }
        this.SR++;
        pff.ExN = null;
        if (pff.We || z11) {
            pff.We = true;
            this.Tf.write("CLEAN " + pff.pFF + pff.sc() + '\n');
            if (z11) {
                long j12 = this.dE;
                this.dE = 1 + j12;
                pff.TRI = j12;
            }
        } else {
            this.Ql.remove(pff.pFF);
            this.Tf.write("REMOVE " + pff.pFF + '\n');
        }
        this.Tf.flush();
        if (this.UFX > this.Ol || TRI()) {
            this.pFF.submit(this.Xc);
        }
    }

    private static void sc(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void sc(File file, File file2, boolean z11) throws IOException {
        if (z11) {
            sc(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void zY() throws IOException {
        com.bytedance.sdk.component.ExN.zY.sc.sc.zY zYVar = new com.bytedance.sdk.component.ExN.zY.sc.sc.zY(new FileInputStream(this.ExN), We.f26519sc);
        try {
            String strSc = zYVar.sc();
            String strSc2 = zYVar.sc();
            String strSc3 = zYVar.sc();
            String strSc4 = zYVar.sc();
            String strSc5 = zYVar.sc();
            if (!"libcore.io.DiskLruCache".equals(strSc) || !"1".equals(strSc2) || !Integer.toString(this.Qj).equals(strSc3) || !Integer.toString(this.WH).equals(strSc4) || !"".equals(strSc5)) {
                throw new IOException("unexpected journal header: [" + strSc + ", " + strSc2 + ", " + strSc4 + ", " + strSc5 + "]");
            }
            int i11 = 0;
            while (true) {
                try {
                    We(zYVar.sc());
                    i11++;
                } catch (EOFException unused) {
                    this.SR = i11 - this.Ql.size();
                    if (zYVar.pFF()) {
                        ExN();
                    } else {
                        this.Tf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.ExN, true), We.f26519sc));
                    }
                    com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(zYVar);
                    return;
                }
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(zYVar);
            throw th2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.Tf == null) {
                return;
            }
            for (pFF pff : new ArrayList(this.Ql.values())) {
                if (pff.ExN != null) {
                    pff.ExN.pFF();
                }
            }
            Qj();
            this.Tf.close();
            this.Tf = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public C0242sc pFF(String str) throws IOException {
        return sc(str, -1L);
    }

    public void pFF() throws IOException {
        close();
        We.sc(this.We);
    }

    public synchronized zY sc(String str) throws IOException {
        InputStream inputStream;
        qr();
        ExN(str);
        pFF pff = this.Ql.get(str);
        if (pff == null) {
            return null;
        }
        if (!pff.We) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.WH];
        for (int i11 = 0; i11 < this.WH; i11++) {
            try {
                inputStreamArr[i11] = new FileInputStream(pff.sc(i11));
            } catch (FileNotFoundException unused) {
                for (int i12 = 0; i12 < this.WH && (inputStream = inputStreamArr[i12]) != null; i12++) {
                    com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(inputStream);
                }
                return null;
            }
        }
        this.SR++;
        this.Tf.append((CharSequence) ("READ " + str + '\n'));
        if (TRI()) {
            this.pFF.submit(this.Xc);
        }
        return new zY(str, pff.TRI, inputStreamArr, pff.zY);
    }

    public synchronized void sc() throws IOException {
        qr();
        Qj();
        this.Tf.flush();
    }

    public synchronized boolean zY(String str) throws IOException {
        try {
            qr();
            ExN(str);
            pFF pff = this.Ql.get(str);
            if (pff != null && pff.ExN == null) {
                for (int i11 = 0; i11 < this.WH; i11++) {
                    File fileSc = pff.sc(i11);
                    if (fileSc.exists() && !fileSc.delete()) {
                        throw new IOException("failed to delete ".concat(String.valueOf(fileSc)));
                    }
                    this.UFX -= pff.zY[i11];
                    pff.zY[i11] = 0;
                }
                this.SR++;
                this.Tf.append((CharSequence) ("REMOVE " + str + '\n'));
                this.Ql.remove(str);
                if (TRI()) {
                    this.pFF.submit(this.Xc);
                }
                return true;
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
