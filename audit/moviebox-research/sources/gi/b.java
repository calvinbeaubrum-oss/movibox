package gi;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.x2;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends com.google.android.exoplayer2.e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DecoderInputBuffer f65502o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c0 f65503p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f65504q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public a f65505r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f65506s;

    public b() {
        super(6);
        this.f65502o = new DecoderInputBuffer(1);
        this.f65503p = new c0();
    }

    public final void A() {
        a aVar = this.f65505r;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.google.android.exoplayer2.y2
    public int a(m1 m1Var) {
        return MimeTypes.APPLICATION_CAMERA_MOTION.equals(m1Var.f33445m) ? x2.a(4) : x2.a(0);
    }

    @Override // com.google.android.exoplayer2.w2, com.google.android.exoplayer2.y2
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // com.google.android.exoplayer2.e, com.google.android.exoplayer2.r2.b
    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
        if (i11 == 8) {
            this.f65505r = (a) obj;
        } else {
            super.handleMessage(i11, obj);
        }
    }

    @Override // com.google.android.exoplayer2.w2
    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    @Override // com.google.android.exoplayer2.w2
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.e
    public void p() {
        A();
    }

    @Override // com.google.android.exoplayer2.e
    public void r(long j11, boolean z11) {
        this.f65506s = Long.MIN_VALUE;
        A();
    }

    @Override // com.google.android.exoplayer2.w2
    public void render(long j11, long j12) {
        while (!hasReadStreamToEnd() && this.f65506s < 100000 + j11) {
            this.f65502o.b();
            if (w(k(), this.f65502o, 0) != -4 || this.f65502o.i()) {
                return;
            }
            DecoderInputBuffer decoderInputBuffer = this.f65502o;
            this.f65506s = decoderInputBuffer.f33032f;
            if (this.f65505r != null && !decoderInputBuffer.h()) {
                this.f65502o.o();
                float[] fArrZ = z((ByteBuffer) o0.j(this.f65502o.f33030c));
                if (fArrZ != null) {
                    ((a) o0.j(this.f65505r)).a(this.f65506s - this.f65504q, fArrZ);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.e
    public void v(m1[] m1VarArr, long j11, long j12) {
        this.f65504q = j12;
    }

    @Nullable
    public final float[] z(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f65503p.N(byteBuffer.array(), byteBuffer.limit());
        this.f65503p.P(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i11 = 0; i11 < 3; i11++) {
            fArr[i11] = Float.intBitsToFloat(this.f65503p.q());
        }
        return fArr;
    }
}
