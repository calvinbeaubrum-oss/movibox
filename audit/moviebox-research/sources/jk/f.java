package jk;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class f implements jk.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f68059d = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f68060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f68061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f68062c;

    /* JADX INFO: compiled from: source.java */
    public class a implements e.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f68063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f68064b;

        public a(byte[] bArr, int[] iArr) {
            this.f68063a = bArr;
            this.f68064b = iArr;
        }

        @Override // jk.e.d
        public void read(InputStream inputStream, int i11) throws IOException {
            try {
                inputStream.read(this.f68063a, this.f68064b[0], i11);
                int[] iArr = this.f68064b;
                iArr[0] = iArr[0] + i11;
            } finally {
                inputStream.close();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f68066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f68067b;

        public b(byte[] bArr, int i11) {
            this.f68066a = bArr;
            this.f68067b = i11;
        }
    }

    public f(File file, int i11) {
        this.f68060a = file;
        this.f68061b = i11;
    }

    @Override // jk.a
    public void a() {
        CommonUtils.e(this.f68062c, "There was a problem closing the Crashlytics log file.");
        this.f68062c = null;
    }

    @Override // jk.a
    public String b() {
        byte[] bArrC = c();
        if (bArrC != null) {
            return new String(bArrC, f68059d);
        }
        return null;
    }

    @Override // jk.a
    public byte[] c() {
        b bVarG = g();
        if (bVarG == null) {
            return null;
        }
        int i11 = bVarG.f68067b;
        byte[] bArr = new byte[i11];
        System.arraycopy(bVarG.f68066a, 0, bArr, 0, i11);
        return bArr;
    }

    @Override // jk.a
    public void d() {
        a();
        this.f68060a.delete();
    }

    @Override // jk.a
    public void e(long j11, String str) {
        h();
        f(j11, str);
    }

    public final void f(long j11, String str) {
        if (this.f68062c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i11 = this.f68061b / 4;
            if (str.length() > i11) {
                str = "..." + str.substring(str.length() - i11);
            }
            this.f68062c.e(String.format(Locale.US, "%d %s%n", Long.valueOf(j11), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f68059d));
            while (!this.f68062c.l() && this.f68062c.y() > this.f68061b) {
                this.f68062c.t();
            }
        } catch (IOException e11) {
            gk.f.f().e("There was a problem writing to the Crashlytics log.", e11);
        }
    }

    public final b g() {
        if (!this.f68060a.exists()) {
            return null;
        }
        h();
        e eVar = this.f68062c;
        if (eVar == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[eVar.y()];
        try {
            this.f68062c.j(new a(bArr, iArr));
        } catch (IOException e11) {
            gk.f.f().e("A problem occurred while reading the Crashlytics log file.", e11);
        }
        return new b(bArr, iArr[0]);
    }

    public final void h() {
        if (this.f68062c == null) {
            try {
                this.f68062c = new e(this.f68060a);
            } catch (IOException e11) {
                gk.f.f().e("Could not open log file: " + this.f68060a, e11);
            }
        }
    }
}
