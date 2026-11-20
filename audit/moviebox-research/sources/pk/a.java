package pk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f73872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d[] f73873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f73874c;

    public a(int i11, d... dVarArr) {
        this.f73872a = i11;
        this.f73873b = dVarArr;
        this.f73874c = new b(i11);
    }

    @Override // pk.d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f73872a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArrA = stackTraceElementArr;
        for (d dVar : this.f73873b) {
            if (stackTraceElementArrA.length <= this.f73872a) {
                break;
            }
            stackTraceElementArrA = dVar.a(stackTraceElementArr);
        }
        return stackTraceElementArrA.length > this.f73872a ? this.f73874c.a(stackTraceElementArrA) : stackTraceElementArrA;
    }
}
