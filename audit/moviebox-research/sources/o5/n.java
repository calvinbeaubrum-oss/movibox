package o5;

import androidx.media3.common.ParserException;
import androidx.media3.common.y;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import u4.i0;
import u4.l0;
import u4.r0;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class n implements u4.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f72335a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f72337c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r0 f72341g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f72342h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f72336b = new d();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f72340f = u0.f81843f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0 f72339e = new c0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b> f72338d = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f72343i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long[] f72344j = u0.f81844g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f72345k = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public static class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f72346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f72347b;

        public b(long j11, byte[] bArr) {
            this.f72346a = j11;
            this.f72347b = bArr;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            return Long.compare(this.f72346a, bVar.f72346a);
        }
    }

    public n(s sVar, y yVar) {
        this.f72335a = sVar;
        this.f72337c = yVar.b().k0("application/x-media3-cues").M(yVar.f9501m).Q(sVar.d()).I();
    }

    @Override // u4.s
    public boolean b(u4.t tVar) throws IOException {
        return true;
    }

    @Override // u4.s
    public /* synthetic */ u4.s c() {
        return u4.r.a(this);
    }

    @Override // u4.s
    public int d(u4.t tVar, l0 l0Var) throws IOException {
        int i11 = this.f72343i;
        z3.a.g((i11 == 0 || i11 == 5) ? false : true);
        if (this.f72343i == 1) {
            int iD = tVar.getLength() != -1 ? Ints.d(tVar.getLength()) : 1024;
            if (iD > this.f72340f.length) {
                this.f72340f = new byte[iD];
            }
            this.f72342h = 0;
            this.f72343i = 2;
        }
        if (this.f72343i == 2 && h(tVar)) {
            g();
            this.f72343i = 4;
        }
        if (this.f72343i == 3 && i(tVar)) {
            j();
            this.f72343i = 4;
        }
        return this.f72343i == 4 ? -1 : 0;
    }

    public final /* synthetic */ void e(e eVar) {
        b bVar = new b(eVar.f72326b, this.f72336b.a(eVar.f72325a, eVar.f72327c));
        this.f72338d.add(bVar);
        long j11 = this.f72345k;
        if (j11 == C.TIME_UNSET || eVar.f72326b >= j11) {
            k(bVar);
        }
    }

    @Override // u4.s
    public void f(u4.u uVar) {
        z3.a.g(this.f72343i == 0);
        r0 r0VarTrack = uVar.track(0, 3);
        this.f72341g = r0VarTrack;
        r0VarTrack.b(this.f72337c);
        uVar.endTracks();
        uVar.f(new i0(new long[]{0}, new long[]{0}, C.TIME_UNSET));
        this.f72343i = 1;
    }

    public final void g() throws IOException {
        try {
            long j11 = this.f72345k;
            this.f72335a.a(this.f72340f, j11 != C.TIME_UNSET ? s.b.c(j11) : s.b.b(), new z3.h() { // from class: o5.m
                @Override // z3.h
                public final void accept(Object obj) {
                    this.f72334a.e((e) obj);
                }
            });
            Collections.sort(this.f72338d);
            this.f72344j = new long[this.f72338d.size()];
            for (int i11 = 0; i11 < this.f72338d.size(); i11++) {
                this.f72344j[i11] = this.f72338d.get(i11).f72346a;
            }
            this.f72340f = u0.f81843f;
        } catch (RuntimeException e11) {
            throw ParserException.createForMalformedContainer("SubtitleParser failed.", e11);
        }
    }

    public final boolean h(u4.t tVar) throws IOException {
        byte[] bArr = this.f72340f;
        if (bArr.length == this.f72342h) {
            this.f72340f = Arrays.copyOf(bArr, bArr.length + 1024);
        }
        byte[] bArr2 = this.f72340f;
        int i11 = this.f72342h;
        int i12 = tVar.read(bArr2, i11, bArr2.length - i11);
        if (i12 != -1) {
            this.f72342h += i12;
        }
        long length = tVar.getLength();
        return (length != -1 && ((long) this.f72342h) == length) || i12 == -1;
    }

    public final boolean i(u4.t tVar) throws IOException {
        return tVar.skip((tVar.getLength() > (-1L) ? 1 : (tVar.getLength() == (-1L) ? 0 : -1)) != 0 ? Ints.d(tVar.getLength()) : 1024) == -1;
    }

    public final void j() {
        long j11 = this.f72345k;
        for (int iH = j11 == C.TIME_UNSET ? 0 : u0.h(this.f72344j, j11, true, true); iH < this.f72338d.size(); iH++) {
            k(this.f72338d.get(iH));
        }
    }

    public final void k(b bVar) {
        z3.a.i(this.f72341g);
        int length = bVar.f72347b.length;
        this.f72339e.R(bVar.f72347b);
        this.f72341g.c(this.f72339e, length);
        this.f72341g.f(bVar.f72346a, 1, length, 0, null);
    }

    @Override // u4.s
    public void release() {
        if (this.f72343i == 5) {
            return;
        }
        this.f72335a.reset();
        this.f72343i = 5;
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        int i11 = this.f72343i;
        z3.a.g((i11 == 0 || i11 == 5) ? false : true);
        this.f72345k = j12;
        if (this.f72343i == 2) {
            this.f72343i = 1;
        }
        if (this.f72343i == 4) {
            this.f72343i = 3;
        }
    }
}
