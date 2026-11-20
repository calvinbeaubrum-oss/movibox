package n4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.y;
import androidx.media3.exoplayer.m;
import androidx.media3.exoplayer.source.l;
import androidx.media3.exoplayer.t1;
import androidx.media3.exoplayer.x2;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends m implements Handler.Callback {
    public long A;

    @Nullable
    public Metadata B;
    public long C;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final a f71562s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f71563t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public final Handler f71564u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c5.b f71565v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f71566w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public c5.a f71567x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f71568y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f71569z;

    public c(b bVar, @Nullable Looper looper) {
        this(bVar, looper, a.f71561a);
    }

    public c(b bVar, @Nullable Looper looper, a aVar) {
        this(bVar, looper, aVar, false);
    }

    public c(b bVar, @Nullable Looper looper, a aVar, boolean z11) {
        super(5);
        this.f71563t = (b) z3.a.e(bVar);
        this.f71564u = looper == null ? null : u0.z(looper, this);
        this.f71562s = (a) z3.a.e(aVar);
        this.f71566w = z11;
        this.f71565v = new c5.b();
        this.C = C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.m
    public void C(long j11, boolean z11) {
        this.B = null;
        this.f71568y = false;
        this.f71569z = false;
    }

    @Override // androidx.media3.exoplayer.m
    public void I(y[] yVarArr, long j11, long j12, l.b bVar) {
        this.f71567x = this.f71562s.b(yVarArr[0]);
        Metadata metadata = this.B;
        if (metadata != null) {
            this.B = metadata.copyWithPresentationTimeUs((metadata.presentationTimeUs + this.C) - j12);
        }
        this.C = j12;
    }

    public final void N(Metadata metadata, List<Metadata.Entry> list) {
        for (int i11 = 0; i11 < metadata.length(); i11++) {
            y wrappedMetadataFormat = metadata.get(i11).getWrappedMetadataFormat();
            if (wrappedMetadataFormat == null || !this.f71562s.a(wrappedMetadataFormat)) {
                list.add(metadata.get(i11));
            } else {
                c5.a aVarB = this.f71562s.b(wrappedMetadataFormat);
                byte[] bArr = (byte[]) z3.a.e(metadata.get(i11).getWrappedMetadataBytes());
                this.f71565v.clear();
                this.f71565v.b(bArr.length);
                ((ByteBuffer) u0.i(this.f71565v.f9780c)).put(bArr);
                this.f71565v.c();
                Metadata metadataA = aVarB.a(this.f71565v);
                if (metadataA != null) {
                    N(metadataA, list);
                }
            }
        }
    }

    public final long O(long j11) {
        z3.a.g(j11 != C.TIME_UNSET);
        z3.a.g(this.C != C.TIME_UNSET);
        return j11 - this.C;
    }

    public final void P(Metadata metadata) {
        Handler handler = this.f71564u;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            Q(metadata);
        }
    }

    public final void Q(Metadata metadata) {
        this.f71563t.onMetadata(metadata);
    }

    public final boolean R(long j11) {
        boolean z11;
        Metadata metadata = this.B;
        if (metadata == null || (!this.f71566w && metadata.presentationTimeUs > O(j11))) {
            z11 = false;
        } else {
            P(this.B);
            this.B = null;
            z11 = true;
        }
        if (this.f71568y && this.B == null) {
            this.f71569z = true;
        }
        return z11;
    }

    public final void S() {
        if (this.f71568y || this.B != null) {
            return;
        }
        this.f71565v.clear();
        t1 t1VarT = t();
        int iK = K(t1VarT, this.f71565v, 0);
        if (iK != -4) {
            if (iK == -5) {
                this.A = ((y) z3.a.e(t1VarT.f11382b)).f9505q;
                return;
            }
            return;
        }
        if (this.f71565v.isEndOfStream()) {
            this.f71568y = true;
            return;
        }
        if (this.f71565v.f9782f >= v()) {
            c5.b bVar = this.f71565v;
            bVar.f14632j = this.A;
            bVar.c();
            Metadata metadataA = ((c5.a) u0.i(this.f71567x)).a(this.f71565v);
            if (metadataA != null) {
                ArrayList arrayList = new ArrayList(metadataA.length());
                N(metadataA, arrayList);
                if (arrayList.isEmpty()) {
                    return;
                }
                this.B = new Metadata(O(this.f71565v.f9782f), arrayList);
            }
        }
    }

    @Override // androidx.media3.exoplayer.y2
    public int a(y yVar) {
        if (this.f71562s.a(yVar)) {
            return x2.a(yVar.I == 0 ? 4 : 2);
        }
        return x2.a(0);
    }

    @Override // androidx.media3.exoplayer.w2, androidx.media3.exoplayer.y2
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        Q((Metadata) message.obj);
        return true;
    }

    @Override // androidx.media3.exoplayer.w2
    public boolean isEnded() {
        return this.f71569z;
    }

    @Override // androidx.media3.exoplayer.w2
    public boolean isReady() {
        return true;
    }

    @Override // androidx.media3.exoplayer.w2
    public void render(long j11, long j12) {
        boolean zR = true;
        while (zR) {
            S();
            zR = R(j11);
        }
    }

    @Override // androidx.media3.exoplayer.m
    public void z() {
        this.B = null;
        this.f71567x = null;
        this.C = C.TIME_UNSET;
    }
}
