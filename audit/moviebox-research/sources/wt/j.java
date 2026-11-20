package wt;

import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class j<DataType> implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataType f79641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f79642b;

    /* JADX WARN: Multi-variable type inference failed */
    public j(a aVar, Object obj) {
        this.f79641a = obj;
        this.f79642b = aVar;
    }

    public boolean a(File file) {
        return this.f79642b.a(this.f79641a, file, 0L);
    }
}
