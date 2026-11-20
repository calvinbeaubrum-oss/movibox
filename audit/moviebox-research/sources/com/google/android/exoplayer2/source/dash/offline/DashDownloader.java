package com.google.android.exoplayer2.source.dash.offline;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.DownloadException;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.cache.a;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import qh.b;
import qh.e;
import qh.f;
import qh.g;
import rh.c;
import rh.d;
import rh.i;
import rh.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class DashDownloader extends SegmentDownloader<c> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f33922k;

    public DashDownloader(u1 u1Var, b0.a<c> aVar, a.c cVar, Executor executor) {
        super(u1Var, aVar, cVar, executor);
        this.f33922k = new b();
    }

    public DashDownloader(u1 u1Var, a.c cVar, Executor executor) {
        this(u1Var, new d(), cVar, executor);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x00b8 A[SYNTHETIC] */
    public final void l(k kVar, rh.a aVar, long j11, long j12, boolean z11, ArrayList<SegmentDownloader.b> arrayList) throws InterruptedException, IOException {
        for (int i11 = 0; i11 < aVar.f75386c.size(); i11++) {
            j jVar = aVar.f75386c.get(i11);
            try {
                try {
                    e eVarN = n(kVar, aVar.f75385b, jVar, z11);
                    if (eVarN != null) {
                        long jF = eVarN.f(j12);
                        if (jF == -1) {
                            throw new DownloadException("Unbounded segment index");
                        }
                        String str = ((rh.b) o0.j(this.f33922k.j(jVar.f75445c))).f75390a;
                        i iVarM = jVar.m();
                        if (iVarM != null) {
                            arrayList.add(m(jVar, str, j11, iVarM));
                        }
                        i iVarL = jVar.l();
                        if (iVarL != null) {
                            arrayList.add(m(jVar, str, j11, iVarL));
                        }
                        long jH = eVarN.h();
                        long j13 = (jH + jF) - 1;
                        for (long j14 = jH; j14 <= j13; j14++) {
                            arrayList.add(m(jVar, str, j11 + eVarN.getTimeUs(j14), eVarN.d(j14)));
                        }
                    } else {
                        try {
                            throw new DownloadException("Missing segment index");
                        } catch (IOException e11) {
                            e = e11;
                            if (z11) {
                                throw e;
                            }
                        }
                    }
                } catch (IOException e12) {
                    e = e12;
                    if (z11) {
                        throw e;
                    }
                }
            } catch (IOException e13) {
                e = e13;
            }
        }
    }

    public final SegmentDownloader.b m(j jVar, String str, long j11, i iVar) {
        return new SegmentDownloader.b(j11, f.a(jVar, str, iVar, 0));
    }

    @Nullable
    public final e n(final k kVar, final int i11, final j jVar, boolean z11) throws InterruptedException, IOException {
        e eVarK = jVar.k();
        if (eVarK != null) {
            return eVarK;
        }
        tg.d dVar = (tg.d) e(new RunnableFutureTask<tg.d, IOException>(this) { // from class: com.google.android.exoplayer2.source.dash.offline.DashDownloader.1
            @Override // com.google.android.exoplayer2.util.RunnableFutureTask
            public tg.d doWork() throws IOException {
                return f.b(kVar, i11, jVar);
            }
        }, z11);
        if (dVar == null) {
            return null;
        }
        return new g(dVar, jVar.f75446d);
    }

    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public List<SegmentDownloader.b> h(k kVar, c cVar, boolean z11) throws InterruptedException, IOException {
        ArrayList<SegmentDownloader.b> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < cVar.d(); i11++) {
            rh.g gVarC = cVar.c(i11);
            long jC0 = o0.C0(gVarC.f75430b);
            long jF = cVar.f(i11);
            int i12 = 0;
            for (List<rh.a> list = gVarC.f75431c; i12 < list.size(); list = list) {
                l(kVar, list.get(i12), jC0, jF, z11, arrayList);
                i12++;
            }
        }
        return arrayList;
    }
}
