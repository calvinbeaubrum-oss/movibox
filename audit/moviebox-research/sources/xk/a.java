package xk;

import androidx.annotation.NonNull;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f80576a = 0;

    public long a() {
        return this.f80576a;
    }

    @Override // java.io.OutputStream
    public void write(int i11) {
        this.f80576a++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f80576a += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i11, int i12) {
        int i13;
        if (i11 < 0 || i11 > bArr.length || i12 < 0 || (i13 = i11 + i12) > bArr.length || i13 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.f80576a += (long) i12;
    }
}
