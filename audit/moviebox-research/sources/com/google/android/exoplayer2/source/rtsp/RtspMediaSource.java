package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.k1;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import javax.net.SocketFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class RtspMediaSource extends com.google.android.exoplayer2.source.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u1 f34408i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c.a f34409j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f34410k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Uri f34411l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SocketFactory f34412m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f34413n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f34415p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f34416q;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f34414o = C.TIME_UNSET;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f34417r = true;

    /* JADX INFO: compiled from: source.java */
    public static final class Factory implements com.google.android.exoplayer2.source.i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f34418a = 8000;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f34419b = "ExoPlayerLib/2.18.1";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SocketFactory f34420c = SocketFactory.getDefault();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34421d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34422e;

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public RtspMediaSource a(u1 u1Var) {
            com.google.android.exoplayer2.util.a.e(u1Var.f34776b);
            return new RtspMediaSource(u1Var, this.f34421d ? new j0(this.f34418a) : new l0(this.f34418a), this.f34419b, this.f34420c, this.f34422e);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Factory b(sg.u uVar) {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory c(com.google.android.exoplayer2.upstream.z zVar) {
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class RtspPlaybackException extends IOException {
        public RtspPlaybackException(String str) {
            super(str);
        }

        public RtspPlaybackException(String str, Throwable th2) {
            super(str, th2);
        }

        public RtspPlaybackException(Throwable th2) {
            super(th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements p.c {
        public a() {
        }

        @Override // com.google.android.exoplayer2.source.rtsp.p.c
        public void a() {
            RtspMediaSource.this.f34415p = false;
            RtspMediaSource.this.J();
        }

        @Override // com.google.android.exoplayer2.source.rtsp.p.c
        public void b(d0 d0Var) {
            RtspMediaSource.this.f34414o = o0.C0(d0Var.a());
            RtspMediaSource.this.f34415p = !d0Var.c();
            RtspMediaSource.this.f34416q = d0Var.c();
            RtspMediaSource.this.f34417r = false;
            RtspMediaSource.this.J();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends nh.m {
        public b(RtspMediaSource rtspMediaSource, j3 j3Var) {
            super(j3Var);
        }

        @Override // nh.m, com.google.android.exoplayer2.j3
        public j3.b k(int i11, j3.b bVar, boolean z11) {
            super.k(i11, bVar, z11);
            bVar.f33367g = true;
            return bVar;
        }

        @Override // nh.m, com.google.android.exoplayer2.j3
        public j3.d s(int i11, j3.d dVar, long j11) {
            super.s(i11, dVar, j11);
            dVar.f33388m = true;
            return dVar;
        }
    }

    static {
        k1.a("goog.exo.rtsp");
    }

    public RtspMediaSource(u1 u1Var, c.a aVar, String str, SocketFactory socketFactory, boolean z11) {
        this.f34408i = u1Var;
        this.f34409j = aVar;
        this.f34410k = str;
        this.f34411l = ((u1.h) com.google.android.exoplayer2.util.a.e(u1Var.f34776b)).f34839a;
        this.f34412m = socketFactory;
        this.f34413n = z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        j3 f0Var = new nh.f0(this.f34414o, this.f34415p, false, this.f34416q, null, this.f34408i);
        if (this.f34417r) {
            f0Var = new b(this, f0Var);
        }
        C(f0Var);
    }

    @Override // com.google.android.exoplayer2.source.a
    public void B(@Nullable com.google.android.exoplayer2.upstream.k0 k0Var) {
        J();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void D() {
    }

    @Override // com.google.android.exoplayer2.source.i
    public u1 a() {
        return this.f34408i;
    }

    @Override // com.google.android.exoplayer2.source.i
    public com.google.android.exoplayer2.source.h e(com.google.android.exoplayer2.source.i.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        return new p(bVar2, this.f34409j, this.f34411l, new a(), this.f34410k, this.f34412m, this.f34413n);
    }

    @Override // com.google.android.exoplayer2.source.i
    public void k(com.google.android.exoplayer2.source.h hVar) {
        ((p) hVar).M();
    }

    @Override // com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() {
    }
}
