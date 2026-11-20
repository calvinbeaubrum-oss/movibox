package pk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f73877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f73878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StackTraceElement[] f73879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f73880d;

    public e(Throwable th2, d dVar) {
        this.f73877a = th2.getLocalizedMessage();
        this.f73878b = th2.getClass().getName();
        this.f73879c = dVar.a(th2.getStackTrace());
        Throwable cause = th2.getCause();
        this.f73880d = cause != null ? new e(cause, dVar) : null;
    }
}
