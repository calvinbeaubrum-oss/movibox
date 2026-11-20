package m4;

import android.media.MediaCodec;
import android.os.Bundle;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
public class d0 implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f70755a;

    public d0(MediaCodec mediaCodec) {
        this.f70755a = mediaCodec;
    }

    @Override // m4.l
    public void a(int i11, int i12, int i13, long j11, int i14) {
        this.f70755a.queueInputBuffer(i11, i12, i13, j11, i14);
    }

    @Override // m4.l
    public void b(Bundle bundle) {
        this.f70755a.setParameters(bundle);
    }

    @Override // m4.l
    public void c() {
    }

    @Override // m4.l
    public void f(int i11, int i12, androidx.media3.decoder.c cVar, long j11, int i13) {
        this.f70755a.queueSecureInputBuffer(i11, i12, cVar.a(), j11, i13);
    }

    @Override // m4.l
    public void flush() {
    }

    @Override // m4.l
    public void shutdown() {
    }

    @Override // m4.l
    public void start() {
    }
}
