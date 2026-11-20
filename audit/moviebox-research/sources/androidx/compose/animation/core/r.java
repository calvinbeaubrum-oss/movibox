package androidx.compose.animation.core;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class r {
    public static /* synthetic */ int a(double d11) {
        long jDoubleToLongBits = Double.doubleToLongBits(d11);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }
}
