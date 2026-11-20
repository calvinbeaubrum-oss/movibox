package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.m2;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w2;
import com.google.android.exoplayer2.x2;
import com.google.common.collect.ImmutableList;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a0 extends MediaCodecRenderer implements com.google.android.exoplayer2.util.u {
    public final Context H0;
    public final r.a I0;
    public final AudioSink J0;
    public int K0;
    public boolean L0;

    @Nullable
    public m1 M0;
    public long N0;
    public boolean O0;
    public boolean P0;
    public boolean Q0;
    public boolean R0;

    @Nullable
    public w2.a S0;

    /* JADX INFO: compiled from: source.java */
    public final class b implements AudioSink.a {
        public b() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void a(Exception exc) {
            com.google.android.exoplayer2.util.s.d("MediaCodecAudioRenderer", "Audio sink error", exc);
            a0.this.I0.l(exc);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void b(long j11) {
            a0.this.I0.B(j11);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void c() {
            if (a0.this.S0 != null) {
                a0.this.S0.a();
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void d() {
            if (a0.this.S0 != null) {
                a0.this.S0.b();
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onPositionDiscontinuity() {
            a0.this.f1();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onSkipSilenceEnabledChanged(boolean z11) {
            a0.this.I0.C(z11);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onUnderrun(int i11, long j11, long j12) {
            a0.this.I0.D(i11, j11, j12);
        }
    }

    public a0(Context context, com.google.android.exoplayer2.mediacodec.c.b bVar, com.google.android.exoplayer2.mediacodec.e eVar, boolean z11, @Nullable Handler handler, @Nullable r rVar, AudioSink audioSink) {
        super(1, bVar, eVar, z11, 44100.0f);
        this.H0 = context.getApplicationContext();
        this.J0 = audioSink;
        this.I0 = new r.a(handler, rVar);
        audioSink.h(new b());
    }

    public static boolean Z0(String str) {
        if (o0.f35608a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(o0.f35610c)) {
            String str2 = o0.f35609b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    public static boolean a1() {
        if (o0.f35608a == 23) {
            String str = o0.f35611d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int b1(com.google.android.exoplayer2.mediacodec.d dVar, m1 m1Var) {
        int i11;
        if (!"OMX.google.raw.decoder".equals(dVar.f33553a) || (i11 = o0.f35608a) >= 24 || (i11 == 23 && o0.x0(this.H0))) {
            return m1Var.f33446n;
        }
        return -1;
    }

    public static List<com.google.android.exoplayer2.mediacodec.d> d1(com.google.android.exoplayer2.mediacodec.e eVar, m1 m1Var, boolean z11, AudioSink audioSink) throws MediaCodecUtil.DecoderQueryException {
        com.google.android.exoplayer2.mediacodec.d dVarV;
        String str = m1Var.f33445m;
        if (str == null) {
            return ImmutableList.of();
        }
        if (audioSink.a(m1Var) && (dVarV = MediaCodecUtil.v()) != null) {
            return ImmutableList.of(dVarV);
        }
        List<com.google.android.exoplayer2.mediacodec.d> listA = eVar.a(str, z11, false);
        String strM = MediaCodecUtil.m(m1Var);
        return strM == null ? ImmutableList.copyOf((Collection) listA) : ImmutableList.builder().k(listA).k(eVar.a(strM, z11, false)).m();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean A0(long j11, long j12, @Nullable com.google.android.exoplayer2.mediacodec.c cVar, @Nullable ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, m1 m1Var) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.e(byteBuffer);
        if (this.M0 != null && (i12 & 2) != 0) {
            ((com.google.android.exoplayer2.mediacodec.c) com.google.android.exoplayer2.util.a.e(cVar)).k(i11, false);
            return true;
        }
        if (z11) {
            if (cVar != null) {
                cVar.k(i11, false);
            }
            this.C0.f33067f += i13;
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
            this.C0.f33066e += i13;
            return true;
        } catch (AudioSink.InitializationException e11) {
            throw i(e11, e11.format, e11.isRecoverable, 5001);
        } catch (AudioSink.WriteException e12) {
            throw i(e12, m1Var, e12.isRecoverable, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public com.google.android.exoplayer2.decoder.g B(com.google.android.exoplayer2.mediacodec.d dVar, m1 m1Var, m1 m1Var2) {
        com.google.android.exoplayer2.decoder.g gVarE = dVar.e(m1Var, m1Var2);
        int i11 = gVarE.f33080e;
        if (b1(dVar, m1Var2) > this.K0) {
            i11 |= 64;
        }
        int i12 = i11;
        return new com.google.android.exoplayer2.decoder.g(dVar.f33553a, m1Var, m1Var2, i12 != 0 ? 0 : gVarE.f33079d, i12);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void F0() throws ExoPlaybackException {
        try {
            this.J0.playToEndOfStream();
        } catch (AudioSink.WriteException e11) {
            throw i(e11, e11.format, e11.isRecoverable, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean R0(m1 m1Var) {
        return this.J0.a(m1Var);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int S0(com.google.android.exoplayer2.mediacodec.e eVar, m1 m1Var) throws MediaCodecUtil.DecoderQueryException {
        boolean z11;
        if (!com.google.android.exoplayer2.util.w.o(m1Var.f33445m)) {
            return x2.a(0);
        }
        int i11 = o0.f35608a >= 21 ? 32 : 0;
        boolean z12 = true;
        boolean z13 = m1Var.F != 0;
        boolean zT0 = MediaCodecRenderer.T0(m1Var);
        int i12 = 8;
        if (zT0 && this.J0.a(m1Var) && (!z13 || MediaCodecUtil.v() != null)) {
            return x2.b(4, 8, i11);
        }
        if ((!MimeTypes.AUDIO_RAW.equals(m1Var.f33445m) || this.J0.a(m1Var)) && this.J0.a(o0.d0(2, m1Var.f33458z, m1Var.A))) {
            List<com.google.android.exoplayer2.mediacodec.d> listD1 = d1(eVar, m1Var, false, this.J0);
            if (listD1.isEmpty()) {
                return x2.a(1);
            }
            if (!zT0) {
                return x2.a(2);
            }
            com.google.android.exoplayer2.mediacodec.d dVar = listD1.get(0);
            boolean zM = dVar.m(m1Var);
            if (!zM) {
                int i13 = 1;
                while (true) {
                    if (i13 >= listD1.size()) {
                        z12 = zM;
                        z11 = true;
                        break;
                    }
                    com.google.android.exoplayer2.mediacodec.d dVar2 = listD1.get(i13);
                    if (dVar2.m(m1Var)) {
                        dVar = dVar2;
                        z11 = false;
                        break;
                    }
                    i13++;
                }
            } else {
                z12 = zM;
                z11 = true;
                break;
            }
            int i14 = z12 ? 4 : 3;
            if (z12 && dVar.p(m1Var)) {
                i12 = 16;
            }
            return x2.c(i14, i12, i11, dVar.f33560h ? 64 : 0, z11 ? 128 : 0);
        }
        return x2.a(1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float a0(float f11, m1 m1Var, m1[] m1VarArr) {
        int iMax = -1;
        for (m1 m1Var2 : m1VarArr) {
            int i11 = m1Var2.A;
            if (i11 != -1) {
                iMax = Math.max(iMax, i11);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return f11 * iMax;
    }

    @Override // com.google.android.exoplayer2.util.u
    public void b(m2 m2Var) {
        this.J0.b(m2Var);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<com.google.android.exoplayer2.mediacodec.d> c0(com.google.android.exoplayer2.mediacodec.e eVar, m1 m1Var, boolean z11) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.u(d1(eVar, m1Var, z11, this.J0), m1Var);
    }

    public int c1(com.google.android.exoplayer2.mediacodec.d dVar, m1 m1Var, m1[] m1VarArr) {
        int iB1 = b1(dVar, m1Var);
        if (m1VarArr.length == 1) {
            return iB1;
        }
        for (m1 m1Var2 : m1VarArr) {
            if (dVar.e(m1Var, m1Var2).f33079d != 0) {
                iB1 = Math.max(iB1, b1(dVar, m1Var2));
            }
        }
        return iB1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public com.google.android.exoplayer2.mediacodec.c.a e0(com.google.android.exoplayer2.mediacodec.d dVar, m1 m1Var, @Nullable MediaCrypto mediaCrypto, float f11) {
        this.K0 = c1(dVar, m1Var, n());
        this.L0 = Z0(dVar.f33553a);
        MediaFormat mediaFormatE1 = e1(m1Var, dVar.f33555c, this.K0, f11);
        this.M0 = (!MimeTypes.AUDIO_RAW.equals(dVar.f33554b) || MimeTypes.AUDIO_RAW.equals(m1Var.f33445m)) ? null : m1Var;
        return com.google.android.exoplayer2.mediacodec.c.a.a(dVar, mediaFormatE1, m1Var, mediaCrypto);
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat e1(m1 m1Var, String str, int i11, float f11) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", m1Var.f33458z);
        mediaFormat.setInteger("sample-rate", m1Var.A);
        com.google.android.exoplayer2.util.v.e(mediaFormat, m1Var.f33447o);
        com.google.android.exoplayer2.util.v.d(mediaFormat, "max-input-size", i11);
        int i12 = o0.f35608a;
        if (i12 >= 23) {
            mediaFormat.setInteger(TrackingKey.PRIORITY, 0);
            if (f11 != -1.0f && !a1()) {
                mediaFormat.setFloat("operating-rate", f11);
            }
        }
        if (i12 <= 28 && "audio/ac4".equals(m1Var.f33445m)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i12 >= 24 && this.J0.i(o0.d0(4, m1Var.f33458z, m1Var.A)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i12 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }

    @CallSuper
    public void f1() {
        this.P0 = true;
    }

    public final void g1() {
        long currentPositionUs = this.J0.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.P0) {
                currentPositionUs = Math.max(this.N0, currentPositionUs);
            }
            this.N0 = currentPositionUs;
            this.P0 = false;
        }
    }

    @Override // com.google.android.exoplayer2.e, com.google.android.exoplayer2.w2
    @Nullable
    public com.google.android.exoplayer2.util.u getMediaClock() {
        return this;
    }

    @Override // com.google.android.exoplayer2.w2, com.google.android.exoplayer2.y2
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.util.u
    public m2 getPlaybackParameters() {
        return this.J0.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.u
    public long getPositionUs() {
        if (getState() == 2) {
            g1();
        }
        return this.N0;
    }

    @Override // com.google.android.exoplayer2.e, com.google.android.exoplayer2.r2.b
    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
        if (i11 == 2) {
            this.J0.setVolume(((Float) obj).floatValue());
        }
        if (i11 == 3) {
            this.J0.g((e) obj);
            return;
        }
        if (i11 == 6) {
            this.J0.k((u) obj);
            return;
        }
        switch (i11) {
            case 9:
                this.J0.f(((Boolean) obj).booleanValue());
                break;
            case 10:
                this.J0.setAudioSessionId(((Integer) obj).intValue());
                break;
            case 11:
                this.S0 = (w2.a) obj;
                break;
            default:
                super.handleMessage(i11, obj);
                break;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.w2
    public boolean isEnded() {
        return super.isEnded() && this.J0.isEnded();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.w2
    public boolean isReady() {
        return this.J0.hasPendingData() || super.isReady();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void p() {
        this.Q0 = true;
        try {
            this.J0.flush();
            try {
                super.p();
            } finally {
                this.I0.o(this.C0);
            }
        } catch (Throwable th2) {
            try {
                super.p();
                throw th2;
            } finally {
                this.I0.o(this.C0);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void q(boolean z11, boolean z12) throws ExoPlaybackException {
        super.q(z11, z12);
        this.I0.p(this.C0);
        if (j().f35982a) {
            this.J0.e();
        } else {
            this.J0.disableTunneling();
        }
        this.J0.d(m());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void r(long j11, boolean z11) throws ExoPlaybackException {
        super.r(j11, z11);
        if (this.R0) {
            this.J0.j();
        } else {
            this.J0.flush();
        }
        this.N0 = j11;
        this.O0 = true;
        this.P0 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void r0(Exception exc) {
        com.google.android.exoplayer2.util.s.d("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.I0.k(exc);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void s() {
        try {
            super.s();
        } finally {
            if (this.Q0) {
                this.Q0 = false;
                this.J0.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void s0(String str, com.google.android.exoplayer2.mediacodec.c.a aVar, long j11, long j12) {
        this.I0.m(str, j11, j12);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void t() {
        super.t();
        this.J0.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void t0(String str) {
        this.I0.n(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void u() {
        g1();
        this.J0.pause();
        super.u();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public com.google.android.exoplayer2.decoder.g u0(n1 n1Var) throws ExoPlaybackException {
        com.google.android.exoplayer2.decoder.g gVarU0 = super.u0(n1Var);
        this.I0.q(n1Var.f33603b, gVarU0);
        return gVarU0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void v0(m1 m1Var, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
        int iC0;
        int i11;
        m1 m1Var2 = this.M0;
        int[] iArr = null;
        if (m1Var2 != null) {
            m1Var = m1Var2;
        } else if (X() != null) {
            if (MimeTypes.AUDIO_RAW.equals(m1Var.f33445m)) {
                iC0 = m1Var.B;
            } else if (o0.f35608a < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                iC0 = mediaFormat.containsKey("v-bits-per-sample") ? o0.c0(mediaFormat.getInteger("v-bits-per-sample")) : 2;
            } else {
                iC0 = mediaFormat.getInteger("pcm-encoding");
            }
            m1 m1VarE = new m1.b().e0(MimeTypes.AUDIO_RAW).Y(iC0).N(m1Var.C).O(m1Var.D).H(mediaFormat.getInteger("channel-count")).f0(mediaFormat.getInteger("sample-rate")).E();
            if (this.L0 && m1VarE.f33458z == 6 && (i11 = m1Var.f33458z) < 6) {
                iArr = new int[i11];
                for (int i12 = 0; i12 < m1Var.f33458z; i12++) {
                    iArr[i12] = i12;
                }
            }
            m1Var = m1VarE;
        }
        try {
            this.J0.l(m1Var, 0, iArr);
        } catch (AudioSink.ConfigurationException e11) {
            throw e(e11, e11.format, 5001);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void x0() {
        super.x0();
        this.J0.handleDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void y0(DecoderInputBuffer decoderInputBuffer) {
        if (!this.O0 || decoderInputBuffer.h()) {
            return;
        }
        if (Math.abs(decoderInputBuffer.f33032f - this.N0) > 500000) {
            this.N0 = decoderInputBuffer.f33032f;
        }
        this.O0 = false;
    }
}
