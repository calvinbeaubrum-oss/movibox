package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.k0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tg.a0;
import tg.b0;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class r implements tg.l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f34225g = Pattern.compile("LOCAL:([^,]+)");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f34226h = Pattern.compile("MPEGTS:(-?\\d+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f34227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f34228b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public tg.n f34230d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f34232f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f34229c = new c0();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f34231e = new byte[1024];

    public r(@Nullable String str, k0 k0Var) {
        this.f34227a = str;
        this.f34228b = k0Var;
    }

    public final e0 a(long j11) {
        e0 e0VarTrack = this.f34230d.track(0, 3);
        e0VarTrack.e(new m1.b().e0(MimeTypes.TEXT_VTT).V(this.f34227a).i0(j11).E());
        this.f34230d.endTracks();
        return e0VarTrack;
    }

    @Override // tg.l
    public boolean b(tg.m mVar) throws IOException {
        mVar.peekFully(this.f34231e, 0, 6, false);
        this.f34229c.N(this.f34231e, 6);
        if (ei.i.b(this.f34229c)) {
            return true;
        }
        mVar.peekFully(this.f34231e, 6, 3, false);
        this.f34229c.N(this.f34231e, 9);
        return ei.i.b(this.f34229c);
    }

    @Override // tg.l
    public int c(tg.m mVar, a0 a0Var) throws IOException {
        com.google.android.exoplayer2.util.a.e(this.f34230d);
        int length = (int) mVar.getLength();
        int i11 = this.f34232f;
        byte[] bArr = this.f34231e;
        if (i11 == bArr.length) {
            this.f34231e = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f34231e;
        int i12 = this.f34232f;
        int i13 = mVar.read(bArr2, i12, bArr2.length - i12);
        if (i13 != -1) {
            int i14 = this.f34232f + i13;
            this.f34232f = i14;
            if (length == -1 || i14 != length) {
                return 0;
            }
        }
        e();
        return -1;
    }

    @Override // tg.l
    public void d(tg.n nVar) {
        this.f34230d = nVar;
        nVar.g(new b0.b(C.TIME_UNSET));
    }

    public final void e() throws ParserException {
        c0 c0Var = new c0(this.f34231e);
        ei.i.e(c0Var);
        long jF = 0;
        long jD = 0;
        for (String strP = c0Var.p(); !TextUtils.isEmpty(strP); strP = c0Var.p()) {
            if (strP.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f34225g.matcher(strP);
                if (!matcher.find()) {
                    throw ParserException.createForMalformedContainer("X-TIMESTAMP-MAP doesn't contain local timestamp: " + strP, null);
                }
                Matcher matcher2 = f34226h.matcher(strP);
                if (!matcher2.find()) {
                    throw ParserException.createForMalformedContainer("X-TIMESTAMP-MAP doesn't contain media timestamp: " + strP, null);
                }
                jD = ei.i.d((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
                jF = k0.f(Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher2.group(1))));
            }
        }
        Matcher matcherA = ei.i.a(c0Var);
        if (matcherA == null) {
            a(0L);
            return;
        }
        long jD2 = ei.i.d((String) com.google.android.exoplayer2.util.a.e(matcherA.group(1)));
        long jB = this.f34228b.b(k0.j((jF + jD2) - jD));
        e0 e0VarA = a(jB - jD2);
        this.f34229c.N(this.f34231e, this.f34232f);
        e0VarA.c(this.f34229c, this.f34232f);
        e0VarA.d(jB, 1, this.f34232f, 0, null);
    }

    @Override // tg.l
    public void release() {
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        throw new IllegalStateException();
    }
}
