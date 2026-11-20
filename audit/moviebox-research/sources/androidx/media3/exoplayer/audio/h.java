package androidx.media3.exoplayer.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.f0;
import androidx.media3.common.g0;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.t1;
import androidx.media3.exoplayer.w2;
import androidx.media3.exoplayer.x2;
import androidx.media3.exoplayer.y1;
import com.google.common.collect.ImmutableList;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;
import z3.o;
import z3.r;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends MediaCodecRenderer implements y1 {
    public final Context H0;
    public final androidx.media3.exoplayer.audio.c.a I0;
    public final AudioSink J0;
    public int K0;
    public boolean L0;
    public boolean M0;

    @Nullable
    public y N0;

    @Nullable
    public y O0;
    public long P0;
    public boolean Q0;
    public boolean R0;

    @Nullable
    public w2.a S0;
    public boolean T0;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static final class b {
        public static void a(AudioSink audioSink, @Nullable Object obj) {
            audioSink.i(f4.h.a(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements AudioSink.b {
        public c() {
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void a(Exception exc) {
            o.d("MediaCodecAudioRenderer", "Audio sink error", exc);
            h.this.I0.n(exc);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void b(long j11) {
            h.this.I0.H(j11);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void c() {
            if (h.this.S0 != null) {
                h.this.S0.a();
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void d() {
            if (h.this.S0 != null) {
                h.this.S0.b();
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void e() {
            h.this.T0 = true;
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void f() {
            h.this.E();
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void k(AudioSink.a aVar) {
            h.this.I0.o(aVar);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void l(AudioSink.a aVar) {
            h.this.I0.p(aVar);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void onPositionDiscontinuity() {
            h.this.E1();
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void onSkipSilenceEnabledChanged(boolean z11) {
            h.this.I0.I(z11);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void onUnderrun(int i11, long j11, long j12) {
            h.this.I0.J(i11, j11, j12);
        }
    }

    public h(Context context, androidx.media3.exoplayer.mediacodec.c.b bVar, androidx.media3.exoplayer.mediacodec.f fVar, boolean z11, @Nullable Handler handler, @Nullable androidx.media3.exoplayer.audio.c cVar, AudioSink audioSink) {
        super(1, bVar, fVar, z11, 44100.0f);
        this.H0 = context.getApplicationContext();
        this.J0 = audioSink;
        this.I0 = new androidx.media3.exoplayer.audio.c.a(handler, cVar);
        audioSink.j(new c());
    }

    private int A1(androidx.media3.exoplayer.mediacodec.d dVar, y yVar) {
        int i11;
        if (!"OMX.google.raw.decoder".equals(dVar.f10756a) || (i11 = u0.f81838a) >= 24 || (i11 == 23 && u0.M0(this.H0))) {
            return yVar.f9502n;
        }
        return -1;
    }

    public static List<androidx.media3.exoplayer.mediacodec.d> C1(androidx.media3.exoplayer.mediacodec.f fVar, y yVar, boolean z11, AudioSink audioSink) throws MediaCodecUtil.DecoderQueryException {
        androidx.media3.exoplayer.mediacodec.d dVarX;
        if (yVar.f9501m == null) {
            return ImmutableList.of();
        }
        return (!audioSink.a(yVar) || (dVarX = MediaCodecUtil.x()) == null) ? MediaCodecUtil.v(fVar, yVar, z11, false) : ImmutableList.of(dVarX);
    }

    private void F1() {
        long currentPositionUs = this.J0.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.Q0) {
                currentPositionUs = Math.max(this.P0, currentPositionUs);
            }
            this.P0 = currentPositionUs;
            this.Q0 = false;
        }
    }

    public static boolean w1(String str) {
        if (u0.f81838a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(u0.f81840c)) {
            String str2 = u0.f81839b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    public static boolean x1(String str) {
        return str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder");
    }

    public static boolean y1() {
        if (u0.f81838a == 23) {
            String str = u0.f81841d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.m
    public void A(boolean z11, boolean z12) throws ExoPlaybackException {
        super.A(z11, z12);
        this.I0.t(this.C0);
        if (s().f11787b) {
            this.J0.e();
        } else {
            this.J0.disableTunneling();
        }
        this.J0.l(w());
        this.J0.d(r());
    }

    public int B1(androidx.media3.exoplayer.mediacodec.d dVar, y yVar, y[] yVarArr) {
        int iA1 = A1(dVar, yVar);
        if (yVarArr.length == 1) {
            return iA1;
        }
        for (y yVar2 : yVarArr) {
            if (dVar.e(yVar, yVar2).f10792d != 0) {
                iA1 = Math.max(iA1, A1(dVar, yVar2));
            }
        }
        return iA1;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.m
    public void C(long j11, boolean z11) throws ExoPlaybackException {
        super.C(j11, z11);
        this.J0.flush();
        this.P0 = j11;
        this.T0 = false;
        this.Q0 = true;
    }

    @Override // androidx.media3.exoplayer.m
    public void D() {
        this.J0.release();
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat D1(y yVar, String str, int i11, float f11) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", yVar.f9514z);
        mediaFormat.setInteger("sample-rate", yVar.A);
        r.e(mediaFormat, yVar.f9503o);
        r.d(mediaFormat, "max-input-size", i11);
        int i12 = u0.f81838a;
        if (i12 >= 23) {
            mediaFormat.setInteger(TrackingKey.PRIORITY, 0);
            if (f11 != -1.0f && !y1()) {
                mediaFormat.setFloat("operating-rate", f11);
            }
        }
        if (i12 <= 28 && "audio/ac4".equals(yVar.f9501m)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i12 >= 24 && this.J0.p(u0.k0(4, yVar.f9514z, yVar.A)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i12 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }

    @CallSuper
    public void E1() {
        this.Q0 = true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.m
    public void F() {
        this.T0 = false;
        try {
            super.F();
        } finally {
            if (this.R0) {
                this.R0 = false;
                this.J0.reset();
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.m
    public void G() {
        super.G();
        this.J0.play();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.m
    public void H() {
        F1();
        this.J0.pause();
        super.H();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void J0(Exception exc) {
        o.d("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.I0.m(exc);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void K0(String str, androidx.media3.exoplayer.mediacodec.c.a aVar, long j11, long j12) {
        this.I0.q(str, j11, j12);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void L0(String str) {
        this.I0.r(str);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    @Nullable
    public androidx.media3.exoplayer.o M0(t1 t1Var) throws ExoPlaybackException {
        y yVar = (y) z3.a.e(t1Var.f11382b);
        this.N0 = yVar;
        androidx.media3.exoplayer.o oVarM0 = super.M0(t1Var);
        this.I0.u(yVar, oVarM0);
        return oVarM0;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void N0(y yVar, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
        int iJ0;
        int i11;
        y yVar2 = this.O0;
        int[] iArrA = null;
        if (yVar2 != null) {
            yVar = yVar2;
        } else if (l0() != null) {
            z3.a.e(mediaFormat);
            if (MimeTypes.AUDIO_RAW.equals(yVar.f9501m)) {
                iJ0 = yVar.B;
            } else if (u0.f81838a < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                iJ0 = mediaFormat.containsKey("v-bits-per-sample") ? u0.j0(mediaFormat.getInteger("v-bits-per-sample")) : 2;
            } else {
                iJ0 = mediaFormat.getInteger("pcm-encoding");
            }
            y yVarI = new y.b().k0(MimeTypes.AUDIO_RAW).e0(iJ0).S(yVar.C).T(yVar.D).d0(yVar.f9499k).X(yVar.f9489a).Z(yVar.f9490b).a0(yVar.f9491c).b0(yVar.f9492d).m0(yVar.f9493e).i0(yVar.f9494f).L(mediaFormat.getInteger("channel-count")).l0(mediaFormat.getInteger("sample-rate")).I();
            if (this.L0 && yVarI.f9514z == 6 && (i11 = yVar.f9514z) < 6) {
                iArrA = new int[i11];
                for (int i12 = 0; i12 < yVar.f9514z; i12++) {
                    iArrA[i12] = i12;
                }
            } else if (this.M0) {
                iArrA = u4.u0.a(yVarI.f9514z);
            }
            yVar = yVarI;
        }
        try {
            if (u0.f81838a >= 29) {
                if (!B0() || s().f11786a == 0) {
                    this.J0.k(0);
                } else {
                    this.J0.k(s().f11786a);
                }
            }
            this.J0.m(yVar, 0, iArrA);
        } catch (AudioSink.ConfigurationException e11) {
            throw p(e11, e11.format, 5001);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void O0(long j11) {
        this.J0.o(j11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public androidx.media3.exoplayer.o P(androidx.media3.exoplayer.mediacodec.d dVar, y yVar, y yVar2) {
        androidx.media3.exoplayer.o oVarE = dVar.e(yVar, yVar2);
        int i11 = oVarE.f10793e;
        if (C0(yVar2)) {
            i11 |= 32768;
        }
        if (A1(dVar, yVar2) > this.K0) {
            i11 |= 64;
        }
        int i12 = i11;
        return new androidx.media3.exoplayer.o(dVar.f10756a, yVar, yVar2, i12 != 0 ? 0 : oVarE.f10792d, i12);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void Q0() {
        super.Q0();
        this.J0.handleDiscontinuity();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public boolean U0(long j11, long j12, @Nullable androidx.media3.exoplayer.mediacodec.c cVar, @Nullable ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, y yVar) throws ExoPlaybackException {
        z3.a.e(byteBuffer);
        if (this.O0 != null && (i12 & 2) != 0) {
            ((androidx.media3.exoplayer.mediacodec.c) z3.a.e(cVar)).k(i11, false);
            return true;
        }
        if (z11) {
            if (cVar != null) {
                cVar.k(i11, false);
            }
            this.C0.f10777f += i13;
            this.J0.handleDiscontinuity();
            return true;
        }
        try {
            if (!this.J0.c(byteBuffer, j13, i13)) {
                return false;
            }
            if (cVar != null) {
                cVar.k(i11, false);
            }
            this.C0.f10776e += i13;
            return true;
        } catch (AudioSink.InitializationException e11) {
            throw q(e11, this.N0, e11.isRecoverable, (!B0() || s().f11786a == 0) ? 5001 : PlaybackException.ERROR_CODE_AUDIO_TRACK_OFFLOAD_INIT_FAILED);
        } catch (AudioSink.WriteException e12) {
            throw q(e12, yVar, e12.isRecoverable, (!B0() || s().f11786a == 0) ? 5002 : PlaybackException.ERROR_CODE_AUDIO_TRACK_OFFLOAD_WRITE_FAILED);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void Z0() throws ExoPlaybackException {
        try {
            this.J0.playToEndOfStream();
        } catch (AudioSink.WriteException e11) {
            throw q(e11, e11.format, e11.isRecoverable, B0() ? PlaybackException.ERROR_CODE_AUDIO_TRACK_OFFLOAD_WRITE_FAILED : 5002);
        }
    }

    @Override // androidx.media3.exoplayer.y1
    public void b(g0 g0Var) {
        this.J0.b(g0Var);
    }

    @Override // androidx.media3.exoplayer.m, androidx.media3.exoplayer.w2
    @Nullable
    public y1 getMediaClock() {
        return this;
    }

    @Override // androidx.media3.exoplayer.w2, androidx.media3.exoplayer.y2
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // androidx.media3.exoplayer.y1
    public g0 getPlaybackParameters() {
        return this.J0.getPlaybackParameters();
    }

    @Override // androidx.media3.exoplayer.y1
    public long getPositionUs() {
        if (getState() == 2) {
            F1();
        }
        return this.P0;
    }

    @Override // androidx.media3.exoplayer.y1
    public boolean h() {
        boolean z11 = this.T0;
        this.T0 = false;
        return z11;
    }

    @Override // androidx.media3.exoplayer.m, androidx.media3.exoplayer.t2.b
    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
        if (i11 == 2) {
            this.J0.setVolume(((Float) z3.a.e(obj)).floatValue());
        }
        if (i11 == 3) {
            this.J0.g((androidx.media3.common.d) z3.a.e((androidx.media3.common.d) obj));
            return;
        }
        if (i11 == 6) {
            this.J0.q((androidx.media3.common.g) z3.a.e((androidx.media3.common.g) obj));
            return;
        }
        switch (i11) {
            case 9:
                this.J0.f(((Boolean) z3.a.e(obj)).booleanValue());
                break;
            case 10:
                this.J0.setAudioSessionId(((Integer) z3.a.e(obj)).intValue());
                break;
            case 11:
                this.S0 = (w2.a) obj;
                break;
            case 12:
                if (u0.f81838a >= 23) {
                    b.a(this.J0, obj);
                }
                break;
            default:
                super.handleMessage(i11, obj);
                break;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.w2
    public boolean isEnded() {
        return super.isEnded() && this.J0.isEnded();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.w2
    public boolean isReady() {
        return this.J0.hasPendingData() || super.isReady();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public boolean m1(y yVar) {
        if (s().f11786a != 0) {
            int iZ1 = z1(yVar);
            if ((iZ1 & 512) != 0) {
                if (s().f11786a == 2 || (iZ1 & 1024) != 0) {
                    return true;
                }
                if (yVar.C == 0 && yVar.D == 0) {
                    return true;
                }
            }
        }
        return this.J0.a(yVar);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public int n1(androidx.media3.exoplayer.mediacodec.f fVar, y yVar) throws MediaCodecUtil.DecoderQueryException {
        int i11;
        boolean z11;
        if (!f0.o(yVar.f9501m)) {
            return x2.a(0);
        }
        int i12 = u0.f81838a >= 21 ? 32 : 0;
        boolean z12 = true;
        boolean z13 = yVar.I != 0;
        boolean zO1 = MediaCodecRenderer.o1(yVar);
        if (!zO1 || (z13 && MediaCodecUtil.x() == null)) {
            i11 = 0;
        } else {
            int iZ1 = z1(yVar);
            if (this.J0.a(yVar)) {
                return x2.c(4, 8, i12, iZ1);
            }
            i11 = iZ1;
        }
        if ((!MimeTypes.AUDIO_RAW.equals(yVar.f9501m) || this.J0.a(yVar)) && this.J0.a(u0.k0(2, yVar.f9514z, yVar.A))) {
            List<androidx.media3.exoplayer.mediacodec.d> listC1 = C1(fVar, yVar, false, this.J0);
            if (listC1.isEmpty()) {
                return x2.a(1);
            }
            if (!zO1) {
                return x2.a(2);
            }
            androidx.media3.exoplayer.mediacodec.d dVar = listC1.get(0);
            boolean zN = dVar.n(yVar);
            if (!zN) {
                int i13 = 1;
                while (true) {
                    if (i13 >= listC1.size()) {
                        z12 = zN;
                        z11 = true;
                        break;
                    }
                    androidx.media3.exoplayer.mediacodec.d dVar2 = listC1.get(i13);
                    if (dVar2.n(yVar)) {
                        dVar = dVar2;
                        z11 = false;
                        break;
                    }
                    i13++;
                }
            } else {
                z12 = zN;
                z11 = true;
                break;
            }
            return x2.e(z12 ? 4 : 3, (z12 && dVar.q(yVar)) ? 16 : 8, i12, dVar.f10763h ? 64 : 0, z11 ? 128 : 0, i11);
        }
        return x2.a(1);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public float p0(float f11, y yVar, y[] yVarArr) {
        int iMax = -1;
        for (y yVar2 : yVarArr) {
            int i11 = yVar2.A;
            if (i11 != -1) {
                iMax = Math.max(iMax, i11);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return f11 * iMax;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public List<androidx.media3.exoplayer.mediacodec.d> r0(androidx.media3.exoplayer.mediacodec.f fVar, y yVar, boolean z11) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.w(C1(fVar, yVar, z11, this.J0), yVar);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public androidx.media3.exoplayer.mediacodec.c.a s0(androidx.media3.exoplayer.mediacodec.d dVar, y yVar, @Nullable MediaCrypto mediaCrypto, float f11) {
        this.K0 = B1(dVar, yVar, x());
        this.L0 = w1(dVar.f10756a);
        this.M0 = x1(dVar.f10756a);
        MediaFormat mediaFormatD1 = D1(yVar, dVar.f10758c, this.K0, f11);
        this.O0 = (!MimeTypes.AUDIO_RAW.equals(dVar.f10757b) || MimeTypes.AUDIO_RAW.equals(yVar.f9501m)) ? null : yVar;
        return androidx.media3.exoplayer.mediacodec.c.a.a(dVar, mediaFormatD1, yVar, mediaCrypto);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public void v0(DecoderInputBuffer decoderInputBuffer) {
        y yVar;
        if (u0.f81838a < 29 || (yVar = decoderInputBuffer.f9778a) == null || !Objects.equals(yVar.f9501m, MimeTypes.AUDIO_OPUS) || !B0()) {
            return;
        }
        ByteBuffer byteBuffer = (ByteBuffer) z3.a.e(decoderInputBuffer.f9783g);
        int i11 = ((y) z3.a.e(decoderInputBuffer.f9778a)).C;
        if (byteBuffer.remaining() == 8) {
            this.J0.n(i11, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / C.NANOS_PER_SECOND));
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.m
    public void z() {
        this.R0 = true;
        this.N0 = null;
        try {
            this.J0.flush();
            try {
                super.z();
            } finally {
                this.I0.s(this.C0);
            }
        } catch (Throwable th2) {
            try {
                super.z();
                throw th2;
            } finally {
                this.I0.s(this.C0);
            }
        }
    }

    public final int z1(y yVar) {
        androidx.media3.exoplayer.audio.b bVarH = this.J0.h(yVar);
        if (!bVarH.f9937a) {
            return 0;
        }
        int i11 = bVarH.f9938b ? 1536 : 512;
        return bVarH.f9939c ? i11 | 2048 : i11;
    }
}
