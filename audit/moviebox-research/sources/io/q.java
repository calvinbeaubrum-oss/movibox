package io;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class q {
    public static /* synthetic */ int a(int i11, int i12, int i13) {
        if (i11 >= 0 && i12 >= 0 && i13 >= 0 && i11 <= i13 - i12) {
            return i11;
        }
        throw new IndexOutOfBoundsException("Range [" + i11 + ", " + i11 + " + " + i12 + ") out of bounds for length " + i13);
    }
}
