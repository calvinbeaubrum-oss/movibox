package retrofit2;

import java.io.IOException;
import okhttp3.Request;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface b<T> extends Cloneable {
    void cancel();

    /* JADX INFO: renamed from: clone */
    b<T> mo332clone();

    void e(d<T> dVar);

    b0<T> execute() throws IOException;

    boolean isCanceled();

    Request request();
}
