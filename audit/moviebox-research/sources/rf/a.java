package rf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f75381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f75382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BufferedWriter f75383c;

    @Override // rf.b
    public void a(String str) {
        try {
            this.f75383c.write(str);
            this.f75383c.newLine();
            this.f75383c.flush();
        } catch (Exception e11) {
            kf.b.e().g("append log failed: " + e11.getMessage());
        }
    }

    @Override // rf.b
    public boolean b() {
        BufferedWriter bufferedWriter = this.f75383c;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        this.f75383c = null;
        this.f75381a = null;
        this.f75382b = null;
        return true;
    }

    @Override // rf.b
    public File c() {
        return this.f75382b;
    }

    @Override // rf.b
    public String d() {
        return this.f75381a;
    }

    @Override // rf.b
    public boolean e() {
        return this.f75383c != null && this.f75382b.exists();
    }

    @Override // rf.b
    public boolean f(File file) {
        boolean z11;
        this.f75381a = file.getName();
        this.f75382b = file;
        if (file.exists()) {
            z11 = false;
        } else {
            try {
                File parentFile = this.f75382b.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f75382b.createNewFile();
                z11 = true;
            } catch (Exception e11) {
                e11.printStackTrace();
                b();
                return false;
            }
        }
        try {
            this.f75383c = new BufferedWriter(new FileWriter(this.f75382b, true));
            if (z11) {
                g(this.f75382b);
            }
            return true;
        } catch (Exception e12) {
            e12.printStackTrace();
            b();
            return false;
        }
    }

    public void g(File file) {
    }
}
