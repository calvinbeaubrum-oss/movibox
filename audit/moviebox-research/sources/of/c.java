package of;

import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f72414a;

    public c(long j11) {
        this.f72414a = j11;
    }

    @Override // of.b
    public boolean b(File file) {
        return file.length() > this.f72414a;
    }
}
