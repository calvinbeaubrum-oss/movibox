package jk;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e implements Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Logger f68043h = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f68044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f68045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f68046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f68047d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f68048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f68049g = new byte[16];

    /* JADX INFO: compiled from: source.java */
    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f68050a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f68051b;

        public a(StringBuilder sb2) {
            this.f68051b = sb2;
        }

        @Override // jk.e.d
        public void read(InputStream inputStream, int i11) throws IOException {
            if (this.f68050a) {
                this.f68050a = false;
            } else {
                this.f68051b.append(", ");
            }
            this.f68051b.append(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f68053c = new b(0, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f68054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f68055b;

        public b(int i11, int i12) {
            this.f68054a = i11;
            this.f68055b = i12;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f68054a + ", length = " + this.f68055b + "]";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f68056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f68057b;

        public c(b bVar) {
            this.f68056a = e.this.U(bVar.f68054a + 4);
            this.f68057b = bVar.f68055b;
        }

        public /* synthetic */ c(e eVar, b bVar, a aVar) {
            this(bVar);
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f68057b == 0) {
                return -1;
            }
            e.this.f68044a.seek(this.f68056a);
            int i11 = e.this.f68044a.read();
            this.f68056a = e.this.U(this.f68056a + 1);
            this.f68057b--;
            return i11;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) throws IOException {
            e.m(bArr, "buffer");
            if ((i11 | i12) < 0 || i12 > bArr.length - i11) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i13 = this.f68057b;
            if (i13 <= 0) {
                return -1;
            }
            if (i12 > i13) {
                i12 = i13;
            }
            e.this.u(this.f68056a, bArr, i11, i12);
            this.f68056a = e.this.U(this.f68056a + i12);
            this.f68057b -= i12;
            return i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void read(InputStream inputStream, int i11) throws IOException;
    }

    public e(File file) throws IOException {
        if (!file.exists()) {
            k(file);
        }
        this.f68044a = n(file);
        p();
    }

    public static void Z(byte[] bArr, int i11, int i12) {
        bArr[i11] = (byte) (i12 >> 24);
        bArr[i11 + 1] = (byte) (i12 >> 16);
        bArr[i11 + 2] = (byte) (i12 >> 8);
        bArr[i11 + 3] = (byte) i12;
    }

    public static void b0(byte[] bArr, int... iArr) {
        int i11 = 0;
        for (int i12 : iArr) {
            Z(bArr, i11, i12);
            i11 += 4;
        }
    }

    public static void k(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileN = n(file2);
        try {
            randomAccessFileN.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            randomAccessFileN.seek(0L);
            byte[] bArr = new byte[16];
            b0(bArr, 4096, 0, 0, 0);
            randomAccessFileN.write(bArr);
            randomAccessFileN.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th2) {
            randomAccessFileN.close();
            throw th2;
        }
    }

    public static <T> T m(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public static RandomAccessFile n(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    public static int q(byte[] bArr, int i11) {
        return ((bArr[i11] & 255) << 24) + ((bArr[i11 + 1] & 255) << 16) + ((bArr[i11 + 2] & 255) << 8) + (bArr[i11 + 3] & 255);
    }

    public final int U(int i11) {
        int i12 = this.f68045b;
        return i11 < i12 ? i11 : (i11 + 16) - i12;
    }

    public final void W(int i11, int i12, int i13, int i14) throws IOException {
        b0(this.f68049g, i11, i12, i13, i14);
        this.f68044a.seek(0L);
        this.f68044a.write(this.f68049g);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f68044a.close();
    }

    public void e(byte[] bArr) throws IOException {
        g(bArr, 0, bArr.length);
    }

    public synchronized void g(byte[] bArr, int i11, int i12) throws IOException {
        int iU;
        try {
            m(bArr, "buffer");
            if ((i11 | i12) < 0 || i12 > bArr.length - i11) {
                throw new IndexOutOfBoundsException();
            }
            i(i12);
            boolean zL = l();
            if (zL) {
                iU = 16;
            } else {
                b bVar = this.f68048f;
                iU = U(bVar.f68054a + 4 + bVar.f68055b);
            }
            b bVar2 = new b(iU, i12);
            Z(this.f68049g, 0, i12);
            w(bVar2.f68054a, this.f68049g, 0, 4);
            w(bVar2.f68054a + 4, bArr, i11, i12);
            W(this.f68045b, this.f68046c + 1, zL ? bVar2.f68054a : this.f68047d.f68054a, bVar2.f68054a);
            this.f68048f = bVar2;
            this.f68046c++;
            if (zL) {
                this.f68047d = bVar2;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void h() throws IOException {
        try {
            W(4096, 0, 0, 0);
            this.f68046c = 0;
            b bVar = b.f68053c;
            this.f68047d = bVar;
            this.f68048f = bVar;
            if (this.f68045b > 4096) {
                x(4096);
            }
            this.f68045b = 4096;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void i(int i11) throws IOException {
        int i12 = i11 + 4;
        int iR = r();
        if (iR >= i12) {
            return;
        }
        int i13 = this.f68045b;
        do {
            iR += i13;
            i13 <<= 1;
        } while (iR < i12);
        x(i13);
        b bVar = this.f68048f;
        int iU = U(bVar.f68054a + 4 + bVar.f68055b);
        if (iU < this.f68047d.f68054a) {
            FileChannel channel = this.f68044a.getChannel();
            channel.position(this.f68045b);
            long j11 = iU - 4;
            if (channel.transferTo(16L, j11, channel) != j11) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i14 = this.f68048f.f68054a;
        int i15 = this.f68047d.f68054a;
        if (i14 < i15) {
            int i16 = (this.f68045b + i14) - 16;
            W(i13, this.f68046c, i15, i16);
            this.f68048f = new b(i16, this.f68048f.f68055b);
        } else {
            W(i13, this.f68046c, i15, i14);
        }
        this.f68045b = i13;
    }

    public synchronized void j(d dVar) throws IOException {
        int iU = this.f68047d.f68054a;
        for (int i11 = 0; i11 < this.f68046c; i11++) {
            b bVarO = o(iU);
            dVar.read(new c(this, bVarO, null), bVarO.f68055b);
            iU = U(bVarO.f68054a + 4 + bVarO.f68055b);
        }
    }

    public synchronized boolean l() {
        return this.f68046c == 0;
    }

    public final b o(int i11) throws IOException {
        if (i11 == 0) {
            return b.f68053c;
        }
        this.f68044a.seek(i11);
        return new b(i11, this.f68044a.readInt());
    }

    public final void p() throws IOException {
        this.f68044a.seek(0L);
        this.f68044a.readFully(this.f68049g);
        int iQ = q(this.f68049g, 0);
        this.f68045b = iQ;
        if (iQ <= this.f68044a.length()) {
            this.f68046c = q(this.f68049g, 4);
            int iQ2 = q(this.f68049g, 8);
            int iQ3 = q(this.f68049g, 12);
            this.f68047d = o(iQ2);
            this.f68048f = o(iQ3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f68045b + ", Actual length: " + this.f68044a.length());
    }

    public final int r() {
        return this.f68045b - y();
    }

    public synchronized void t() throws IOException {
        try {
            if (l()) {
                throw new NoSuchElementException();
            }
            if (this.f68046c == 1) {
                h();
            } else {
                b bVar = this.f68047d;
                int iU = U(bVar.f68054a + 4 + bVar.f68055b);
                u(iU, this.f68049g, 0, 4);
                int iQ = q(this.f68049g, 0);
                W(this.f68045b, this.f68046c - 1, iU, this.f68048f.f68054a);
                this.f68046c--;
                this.f68047d = new b(iU, iQ);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append('[');
        sb2.append("fileLength=");
        sb2.append(this.f68045b);
        sb2.append(", size=");
        sb2.append(this.f68046c);
        sb2.append(", first=");
        sb2.append(this.f68047d);
        sb2.append(", last=");
        sb2.append(this.f68048f);
        sb2.append(", element lengths=[");
        try {
            j(new a(sb2));
        } catch (IOException e11) {
            f68043h.log(Level.WARNING, "read error", (Throwable) e11);
        }
        sb2.append("]]");
        return sb2.toString();
    }

    public final void u(int i11, byte[] bArr, int i12, int i13) throws IOException {
        int iU = U(i11);
        int i14 = iU + i13;
        int i15 = this.f68045b;
        if (i14 <= i15) {
            this.f68044a.seek(iU);
            this.f68044a.readFully(bArr, i12, i13);
            return;
        }
        int i16 = i15 - iU;
        this.f68044a.seek(iU);
        this.f68044a.readFully(bArr, i12, i16);
        this.f68044a.seek(16L);
        this.f68044a.readFully(bArr, i12 + i16, i13 - i16);
    }

    public final void w(int i11, byte[] bArr, int i12, int i13) throws IOException {
        int iU = U(i11);
        int i14 = iU + i13;
        int i15 = this.f68045b;
        if (i14 <= i15) {
            this.f68044a.seek(iU);
            this.f68044a.write(bArr, i12, i13);
            return;
        }
        int i16 = i15 - iU;
        this.f68044a.seek(iU);
        this.f68044a.write(bArr, i12, i16);
        this.f68044a.seek(16L);
        this.f68044a.write(bArr, i12 + i16, i13 - i16);
    }

    public final void x(int i11) throws IOException {
        this.f68044a.setLength(i11);
        this.f68044a.getChannel().force(true);
    }

    public int y() {
        if (this.f68046c == 0) {
            return 16;
        }
        b bVar = this.f68048f;
        int i11 = bVar.f68054a;
        int i12 = this.f68047d.f68054a;
        return i11 >= i12 ? (i11 - i12) + 4 + bVar.f68055b + 16 : (((i11 + 4) + bVar.f68055b) + this.f68045b) - i12;
    }
}
