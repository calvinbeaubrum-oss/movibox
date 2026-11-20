package n20;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class b extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f71492a;

    public b() {
        this(null);
    }

    public b(OutputStream outputStream) {
        super(outputStream);
        this.f71492a = new Object();
    }
}
