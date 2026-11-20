package t4;

import androidx.annotation.Nullable;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.m;
import androidx.media3.exoplayer.source.l;
import androidx.media3.exoplayer.x2;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends m {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DecoderInputBuffer f76857s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c0 f76858t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f76859u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public a f76860v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f76861w;

    public b() {
        super(6);
        this.f76857s = new DecoderInputBuffer(1);
        this.f76858t = new c0();
    }

    @Override // androidx.media3.exoplayer.m
    public void C(long j11, boolean z11) {
        this.f76861w = Long.MIN_VALUE;
        O();
    }

    @Override // androidx.media3.exoplayer.m
    public void I(y[] yVarArr, long j11, long j12, l.b bVar) {
        this.f76859u = j12;
    }

    @Nullable
    public final float[] N(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f76858t.S(byteBuffer.array(), byteBuffer.limit());
        this.f76858t.U(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i11 = 0; i11 < 3; i11++) {
            fArr[i11] = Float.intBitsToFloat(this.f76858t.u());
        }
        return fArr;
    }

    public final void O() {
        a aVar = this.f76860v;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // androidx.media3.exoplayer.y2
    public int a(y yVar) {
        return MimeTypes.APPLICATION_CAMERA_MOTION.equals(yVar.f9501m) ? x2.a(4) : x2.a(0);
    }

    @Override // androidx.media3.exoplayer.w2, androidx.media3.exoplayer.y2
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // androidx.media3.exoplayer.m, androidx.media3.exoplayer.t2.b
    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
        if (i11 == 8) {
            this.f76860v = (a) obj;
        } else {
            super.handleMessage(i11, obj);
        }
    }

    @Override // androidx.media3.exoplayer.w2
    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    @Override // androidx.media3.exoplayer.w2
    public boolean isReady() {
        return true;
    }

    @Override // androidx.media3.exoplayer.w2
    public void render(long j11, long j12) {
        while (!hasReadStreamToEnd() && this.f76861w < 100000 + j11) {
            this.f76857s.clear();
            if (K(t(), this.f76857s, 0) != -4 || this.f76857s.isEndOfStream()) {
                return;
            }
            long j13 = this.f76857s.f9782f;
            this.f76861w = j13;
            boolean z11 = j13 < v();
            if (this.f76860v != null && !z11) {
                this.f76857s.c();
                float[] fArrN = N((ByteBuffer) u0.i(this.f76857s.f9780c));
                if (fArrN != null) {
                    ((a) u0.i(this.f76860v)).a(this.f76861w - this.f76859u, fArrN);
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.m
    public void z() {
        O();
    }
}
