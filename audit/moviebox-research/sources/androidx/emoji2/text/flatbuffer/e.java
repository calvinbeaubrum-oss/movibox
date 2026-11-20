package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f8323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f8326e = f.a();

    public int a(int i11) {
        return i11 + this.f8323b.getInt(i11);
    }

    public int b(int i11) {
        if (i11 < this.f8325d) {
            return this.f8323b.getShort(this.f8324c + i11);
        }
        return 0;
    }

    public void c(int i11, ByteBuffer byteBuffer) {
        this.f8323b = byteBuffer;
        if (byteBuffer == null) {
            this.f8322a = 0;
            this.f8324c = 0;
            this.f8325d = 0;
        } else {
            this.f8322a = i11;
            int i12 = i11 - byteBuffer.getInt(i11);
            this.f8324c = i12;
            this.f8325d = this.f8323b.getShort(i12);
        }
    }

    public int d(int i11) {
        int i12 = i11 + this.f8322a;
        return i12 + this.f8323b.getInt(i12) + 4;
    }

    public int e(int i11) {
        int i12 = i11 + this.f8322a;
        return this.f8323b.getInt(i12 + this.f8323b.getInt(i12));
    }

    public int f(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }
}
