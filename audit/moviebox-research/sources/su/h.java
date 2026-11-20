package su;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class h {
    public static /* synthetic */ int a(double d11) {
        long jDoubleToLongBits = Double.doubleToLongBits(d11);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }
}
