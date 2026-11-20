package pk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f73875a;

    public b(int i11) {
        this.f73875a = i11;
    }

    @Override // pk.d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i11 = this.f73875a;
        if (length <= i11) {
            return stackTraceElementArr;
        }
        int i12 = i11 / 2;
        int i13 = i11 - i12;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i11];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i13);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i12, stackTraceElementArr2, i13, i12);
        return stackTraceElementArr2;
    }
}
