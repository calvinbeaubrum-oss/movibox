package androidx.media3.exoplayer.hls;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import u4.l0;
import u4.m0;
import u4.r0;
import u4.t;
import u4.u;
import z3.c0;
import z3.i0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements u4.s {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f10621i = Pattern.compile("LOCAL:([^,]+)");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f10622j = Pattern.compile("MPEGTS:(-?\\d+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f10623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f10624b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o5.s.a f10626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u f10628f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10630h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f10625c = new c0();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f10629g = new byte[1024];

    public s(@Nullable String str, i0 i0Var, o5.s.a aVar, boolean z11) {
        this.f10623a = str;
        this.f10624b = i0Var;
        this.f10626d = aVar;
        this.f10627e = z11;
    }

    public final r0 a(long j11) {
        r0 r0VarTrack = this.f10628f.track(0, 3);
        r0VarTrack.b(new y.b().k0(MimeTypes.TEXT_VTT).b0(this.f10623a).o0(j11).I());
        this.f10628f.endTracks();
        return r0VarTrack;
    }

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        tVar.peekFully(this.f10629g, 0, 6, false);
        this.f10625c.S(this.f10629g, 6);
        if (w5.h.b(this.f10625c)) {
            return true;
        }
        tVar.peekFully(this.f10629g, 6, 3, false);
        this.f10625c.S(this.f10629g, 9);
        return w5.h.b(this.f10625c);
    }

    @Override // u4.s
    public /* synthetic */ u4.s c() {
        return u4.r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        z3.a.e(this.f10628f);
        int length = (int) tVar.getLength();
        int i11 = this.f10630h;
        byte[] bArr = this.f10629g;
        if (i11 == bArr.length) {
            this.f10629g = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f10629g;
        int i12 = this.f10630h;
        int i13 = tVar.read(bArr2, i12, bArr2.length - i12);
        if (i13 != -1) {
            int i14 = this.f10630h + i13;
            this.f10630h = i14;
            if (length == -1 || i14 != length) {
                return 0;
            }
        }
        e();
        return -1;
    }

    public final void e() throws ParserException {
        c0 c0Var = new c0(this.f10629g);
        w5.h.e(c0Var);
        long jH = 0;
        long jD = 0;
        for (String strS = c0Var.s(); !TextUtils.isEmpty(strS); strS = c0Var.s()) {
            if (strS.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f10621i.matcher(strS);
                if (!matcher.find()) {
                    throw ParserException.createForMalformedContainer("X-TIMESTAMP-MAP doesn't contain local timestamp: " + strS, null);
                }
                Matcher matcher2 = f10622j.matcher(strS);
                if (!matcher2.find()) {
                    throw ParserException.createForMalformedContainer("X-TIMESTAMP-MAP doesn't contain media timestamp: " + strS, null);
                }
                jD = w5.h.d((String) z3.a.e(matcher.group(1)));
                jH = i0.h(Long.parseLong((String) z3.a.e(matcher2.group(1))));
            }
        }
        Matcher matcherA = w5.h.a(c0Var);
        if (matcherA == null) {
            a(0L);
            return;
        }
        long jD2 = w5.h.d((String) z3.a.e(matcherA.group(1)));
        long jB = this.f10624b.b(i0.l((jH + jD2) - jD));
        r0 r0VarA = a(jB - jD2);
        this.f10625c.S(this.f10629g, this.f10630h);
        r0VarA.c(this.f10625c, this.f10630h);
        r0VarA.f(jB, 1, this.f10630h, 0, null);
    }

    @Override // u4.s
    public void f(u uVar) {
        this.f10628f = this.f10627e ? new o5.u(uVar, this.f10626d) : uVar;
        uVar.f(new m0.b(C.TIME_UNSET));
    }

    @Override // u4.s
    public void release() {
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        throw new IllegalStateException();
    }
}
