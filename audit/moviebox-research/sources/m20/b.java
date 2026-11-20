package m20;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.gcm.Task;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.u;
import org.apache.commons.compress.archivers.zip.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b extends l20.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f70701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f70702d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f70703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f70704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f70705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f70706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final InputStream f70707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f70708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final u f70709l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f70710m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map<String, String> f70711n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f70712o;

    public b(InputStream inputStream) {
        this(inputStream, Task.EXTRAS_LIMIT_BYTES, 512);
    }

    public b(InputStream inputStream, int i11, int i12) {
        this(inputStream, i11, i12, null);
    }

    public b(InputStream inputStream, int i11, int i12, String str) {
        this(inputStream, i11, i12, str, false);
    }

    public b(InputStream inputStream, int i11, int i12, String str, boolean z11) {
        this.f70701c = new byte[256];
        this.f70711n = new HashMap();
        this.f70707j = inputStream;
        this.f70704g = false;
        this.f70710m = str;
        this.f70709l = v.a(str);
        this.f70702d = i12;
        this.f70703f = i11;
        this.f70712o = z11;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (m()) {
            return 0;
        }
        long j11 = this.f70705h;
        long j12 = this.f70706i;
        return j11 - j12 > 2147483647L ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) (j11 - j12);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f70707j.close();
    }

    public final void e(Map<String, String> map) {
        this.f70708k.C(map);
    }

    public final void g() throws IOException {
        long jC = c();
        int i11 = this.f70703f;
        long j11 = jC % ((long) i11);
        if (j11 > 0) {
            b(o20.c.c(this.f70707j, ((long) i11) - j11));
        }
    }

    public byte[] h() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i11 = read(this.f70701c);
            if (i11 < 0) {
                break;
            }
            byteArrayOutputStream.write(this.f70701c, 0, i11);
        }
        i();
        if (this.f70708k == null) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > 0 && byteArray[length - 1] == 0) {
            length--;
        }
        if (length == byteArray.length) {
            return byteArray;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 0, bArr, 0, length);
        return bArr;
    }

    public l20.a i() throws IOException {
        return j();
    }

    public a j() throws IOException {
        if (l()) {
            return null;
        }
        if (this.f70708k != null) {
            o20.c.c(this, Long.MAX_VALUE);
            w();
        }
        byte[] bArrK = k();
        if (bArrK == null) {
            this.f70708k = null;
            return null;
        }
        try {
            a aVar = new a(bArrK, this.f70709l, this.f70712o);
            this.f70708k = aVar;
            this.f70706i = 0L;
            this.f70705h = aVar.g();
            if (this.f70708k.j()) {
                byte[] bArrH = h();
                if (bArrH == null) {
                    return null;
                }
                this.f70708k.w(this.f70709l.a(bArrH));
            }
            if (this.f70708k.k()) {
                byte[] bArrH2 = h();
                if (bArrH2 == null) {
                    return null;
                }
                this.f70708k.y(this.f70709l.a(bArrH2));
            }
            if (this.f70708k.l()) {
                q();
            }
            if (this.f70708k.n()) {
                p();
            } else if (!this.f70711n.isEmpty()) {
                e(this.f70711n);
            }
            if (this.f70708k.m()) {
                r();
            }
            this.f70705h = this.f70708k.g();
            return this.f70708k;
        } catch (IllegalArgumentException e11) {
            throw new IOException("Error detected parsing the header", e11);
        }
    }

    public final byte[] k() throws IOException {
        byte[] bArrT = t();
        u(n(bArrT));
        if (!l() || bArrT == null) {
            return bArrT;
        }
        x();
        g();
        return null;
    }

    public final boolean l() {
        return this.f70704g;
    }

    public final boolean m() {
        a aVar = this.f70708k;
        return aVar != null && aVar.h();
    }

    @Override // java.io.InputStream
    public void mark(int i11) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public boolean n(byte[] bArr) {
        return bArr == null || o20.a.a(bArr, this.f70702d);
    }

    public Map<String, String> o(InputStream inputStream) throws IOException {
        int i11;
        int i12;
        HashMap map = new HashMap(this.f70711n);
        do {
            int i13 = 0;
            int i14 = 0;
            while (true) {
                i11 = inputStream.read();
                if (i11 == -1) {
                    break;
                }
                i13++;
                if (i11 == 10) {
                    break;
                }
                if (i11 == 32) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        i12 = inputStream.read();
                        if (i12 == -1) {
                            break;
                        }
                        i13++;
                        if (i12 == 61) {
                            String string = byteArrayOutputStream.toString("UTF-8");
                            int i15 = i14 - i13;
                            if (i15 == 1) {
                                map.remove(string);
                                break;
                            }
                            byte[] bArr = new byte[i15];
                            int iA = o20.c.a(inputStream, bArr);
                            if (iA == i15) {
                                map.put(string, new String(bArr, 0, i15 - 1, "UTF-8"));
                                break;
                            }
                            throw new IOException("Failed to read Paxheader. Expected " + i15 + " bytes, read " + iA);
                        }
                        byteArrayOutputStream.write((byte) i12);
                    }
                    i11 = i12;
                    break;
                }
                i14 = (i14 * 10) + (i11 - 48);
            }
        } while (i11 != -1);
        return map;
    }

    public final void p() throws IOException {
        Map<String, String> mapO = o(this);
        i();
        e(mapO);
    }

    public final void q() throws IOException {
        this.f70711n = o(this);
        i();
    }

    public final void r() throws IOException {
        byte[] bArrK;
        if (this.f70708k.i()) {
            do {
                bArrK = k();
                if (bArrK == null) {
                    this.f70708k = null;
                    return;
                }
            } while (new c(bArrK).a());
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (l() || m() || this.f70706i >= this.f70705h) {
            return -1;
        }
        if (this.f70708k == null) {
            throw new IllegalStateException("No current tar entry");
        }
        int iMin = Math.min(i12, available());
        int i13 = this.f70707j.read(bArr, i11, iMin);
        if (i13 != -1) {
            a(i13);
            this.f70706i += (long) i13;
        } else {
            if (iMin > 0) {
                throw new IOException("Truncated TAR archive");
            }
            u(true);
        }
        return i13;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
    }

    @Override // java.io.InputStream
    public long skip(long j11) throws IOException {
        if (j11 <= 0 || m()) {
            return 0L;
        }
        long jC = o20.c.c(this.f70707j, Math.min(j11, this.f70705h - this.f70706i));
        b(jC);
        this.f70706i += jC;
        return jC;
    }

    public byte[] t() throws IOException {
        byte[] bArr = new byte[this.f70702d];
        int iA = o20.c.a(this.f70707j, bArr);
        a(iA);
        if (iA != this.f70702d) {
            return null;
        }
        return bArr;
    }

    public final void u(boolean z11) {
        this.f70704g = z11;
    }

    public final void w() throws IOException {
        if (m()) {
            return;
        }
        long j11 = this.f70705h;
        if (j11 > 0) {
            int i11 = this.f70702d;
            if (j11 % ((long) i11) != 0) {
                b(o20.c.c(this.f70707j, (((j11 / ((long) i11)) + 1) * ((long) i11)) - j11));
            }
        }
    }

    public final void x() throws IOException {
        boolean zMarkSupported = this.f70707j.markSupported();
        if (zMarkSupported) {
            this.f70707j.mark(this.f70702d);
        }
        try {
            if ((!n(t())) && zMarkSupported) {
                d(this.f70702d);
                this.f70707j.reset();
            }
        } catch (Throwable th2) {
            if (zMarkSupported) {
                d(this.f70702d);
                this.f70707j.reset();
            }
            throw th2;
        }
    }
}
