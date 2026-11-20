package wt;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f79589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f79590b = new e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f79591c = new i();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f79592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f79593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f79594f;

    public b(File file, long j11, long j12) {
        this.f79592d = file;
        this.f79593e = j11;
        this.f79594f = j12;
    }

    public File a(vt.e eVar) {
        try {
            f.e eVarL = d().l(this.f79591c.a(eVar));
            if (eVarL != null) {
                return eVarL.a(0);
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        return null;
    }

    public String b(vt.e eVar, h.a aVar) {
        this.f79590b.a(eVar);
        String strA = this.f79591c.a(eVar);
        String path = null;
        try {
            try {
                if (d().l(strA) != null) {
                    this.f79590b.b(eVar);
                    return null;
                }
                f.c cVarC = this.f79589a.c(strA);
                if (cVarC == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Had two simultaneous puts for: ");
                    sb2.append(strA);
                    throw new IllegalStateException(sb2.toString());
                }
                try {
                    File fileA = cVarC.a(0);
                    if (((j) aVar).a(fileA)) {
                        cVarC.f();
                    }
                    path = fileA.getPath();
                    cVarC.d();
                    this.f79590b.b(eVar);
                    return path;
                } catch (Throwable th2) {
                    cVarC.d();
                    throw th2;
                }
            } catch (Throwable th3) {
                this.f79590b.b(eVar);
                throw th3;
            }
        } catch (IOException e11) {
            e11.printStackTrace();
            this.f79590b.b(eVar);
        }
    }

    public void c() {
        try {
            d().close();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public final f d() throws IOException {
        if (this.f79589a == null) {
            synchronized (b.class) {
                try {
                    if (this.f79589a == null) {
                        File fileA = this.f79592d;
                        if (fileA == null) {
                            fileA = bu.i.a(ws.a.a());
                        }
                        File file = fileA;
                        this.f79592d = file;
                        this.f79589a = f.e(file, 1, 1, this.f79593e, this.f79594f);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f79589a;
    }
}
