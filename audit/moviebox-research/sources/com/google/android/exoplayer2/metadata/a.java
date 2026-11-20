package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.x2;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import gh.b;
import gh.c;
import gh.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends e implements Handler.Callback {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f33568o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final gh.e f33569p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public final Handler f33570q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final d f33571r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public b f33572s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f33573t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f33574u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f33575v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f33576w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public Metadata f33577x;

    public a(gh.e eVar, @Nullable Looper looper) {
        this(eVar, looper, c.f65500a);
    }

    public a(gh.e eVar, @Nullable Looper looper, c cVar) {
        super(5);
        this.f33569p = (gh.e) com.google.android.exoplayer2.util.a.e(eVar);
        this.f33570q = looper == null ? null : o0.v(looper, this);
        this.f33568o = (c) com.google.android.exoplayer2.util.a.e(cVar);
        this.f33571r = new d();
        this.f33576w = C.TIME_UNSET;
    }

    public final void A(Metadata metadata) {
        Handler handler = this.f33570q;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            B(metadata);
        }
    }

    public final void B(Metadata metadata) {
        this.f33569p.onMetadata(metadata);
    }

    public final boolean C(long j11) {
        boolean z11;
        Metadata metadata = this.f33577x;
        if (metadata == null || this.f33576w > j11) {
            z11 = false;
        } else {
            A(metadata);
            this.f33577x = null;
            this.f33576w = C.TIME_UNSET;
            z11 = true;
        }
        if (this.f33573t && this.f33577x == null) {
            this.f33574u = true;
        }
        return z11;
    }

    public final void D() {
        if (this.f33573t || this.f33577x != null) {
            return;
        }
        this.f33571r.b();
        n1 n1VarK = k();
        int iW = w(n1VarK, this.f33571r, 0);
        if (iW != -4) {
            if (iW == -5) {
                this.f33575v = ((m1) com.google.android.exoplayer2.util.a.e(n1VarK.f33603b)).f33449q;
                return;
            }
            return;
        }
        if (this.f33571r.i()) {
            this.f33573t = true;
            return;
        }
        d dVar = this.f33571r;
        dVar.f65501j = this.f33575v;
        dVar.o();
        Metadata metadataA = ((b) o0.j(this.f33572s)).a(this.f33571r);
        if (metadataA != null) {
            ArrayList arrayList = new ArrayList(metadataA.length());
            z(metadataA, arrayList);
            if (arrayList.isEmpty()) {
                return;
            }
            this.f33577x = new Metadata(arrayList);
            this.f33576w = this.f33571r.f33032f;
        }
    }

    @Override // com.google.android.exoplayer2.y2
    public int a(m1 m1Var) {
        if (this.f33568o.a(m1Var)) {
            return x2.a(m1Var.F == 0 ? 4 : 2);
        }
        return x2.a(0);
    }

    @Override // com.google.android.exoplayer2.w2, com.google.android.exoplayer2.y2
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        B((Metadata) message.obj);
        return true;
    }

    @Override // com.google.android.exoplayer2.w2
    public boolean isEnded() {
        return this.f33574u;
    }

    @Override // com.google.android.exoplayer2.w2
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.e
    public void p() {
        this.f33577x = null;
        this.f33576w = C.TIME_UNSET;
        this.f33572s = null;
    }

    @Override // com.google.android.exoplayer2.e
    public void r(long j11, boolean z11) {
        this.f33577x = null;
        this.f33576w = C.TIME_UNSET;
        this.f33573t = false;
        this.f33574u = false;
    }

    @Override // com.google.android.exoplayer2.w2
    public void render(long j11, long j12) {
        boolean zC = true;
        while (zC) {
            D();
            zC = C(j11);
        }
    }

    @Override // com.google.android.exoplayer2.e
    public void v(m1[] m1VarArr, long j11, long j12) {
        this.f33572s = this.f33568o.b(m1VarArr[0]);
    }

    public final void z(Metadata metadata, List<Metadata.Entry> list) {
        for (int i11 = 0; i11 < metadata.length(); i11++) {
            m1 wrappedMetadataFormat = metadata.get(i11).getWrappedMetadataFormat();
            if (wrappedMetadataFormat == null || !this.f33568o.a(wrappedMetadataFormat)) {
                list.add(metadata.get(i11));
            } else {
                b bVarB = this.f33568o.b(wrappedMetadataFormat);
                byte[] bArr = (byte[]) com.google.android.exoplayer2.util.a.e(metadata.get(i11).getWrappedMetadataBytes());
                this.f33571r.b();
                this.f33571r.n(bArr.length);
                ((ByteBuffer) o0.j(this.f33571r.f33030c)).put(bArr);
                this.f33571r.o();
                Metadata metadataA = bVarB.a(this.f33571r);
                if (metadataA != null) {
                    z(metadataA, list);
                }
            }
        }
    }
}
