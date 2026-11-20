package athena;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class d0 extends y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f13627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f13628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final br.c f13629f;

    public d0(long j11, File file, br.c cVar) {
        this.f13627d = j11;
        this.f13628e = file;
        this.f13629f = cVar;
    }

    @Override // athena.y
    public void a() {
        String strA;
        int length;
        File file = this.f13628e;
        if (file != null && file.exists() && this.f13628e.isFile() && this.f13628e.getName().contains("upload")) {
            File file2 = this.f13628e;
            strA = !file2.exists() ? "" : new o0(file2.getPath()).a();
            length = strA.split("\n").length;
        } else {
            strA = null;
            length = 0;
        }
        if (TextUtils.isEmpty(strA) || length <= 0) {
            return;
        }
        if (v.a(this.f13627d, strA.getBytes(), length, this.f13629f).f13772a != 0) {
            a0.c("PostEventFileTask requestByPost error");
            return;
        }
        File file3 = this.f13628e;
        if (file3 != null) {
            a0.f("PostEventFileTask lines : %d, deleteFile : %s", Long.valueOf(this.f13627d), Integer.valueOf(length), Boolean.valueOf(v.l(file3)));
        }
    }

    @Override // athena.y
    public String d() {
        return "Upload-File";
    }
}
