package androidx.media3.exoplayer.dash.offline;

import androidx.annotation.Nullable;
import androidx.media3.common.b0;
import androidx.media3.common.util.RunnableFutureTask;
import androidx.media3.datasource.cache.a;
import androidx.media3.exoplayer.offline.DownloadException;
import androidx.media3.exoplayer.offline.SegmentDownloader;
import androidx.media3.exoplayer.upstream.o;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.common.collect.ImmutableMap;
import g4.b;
import g4.f;
import g4.g;
import h4.c;
import h4.d;
import h4.i;
import h4.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import u4.h;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class DashDownloader extends SegmentDownloader<c> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f10206l;

    public DashDownloader(b0 b0Var, a.c cVar, Executor executor) {
        this(b0Var, new d(), cVar, executor, DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT);
    }

    public DashDownloader(b0 b0Var, o.a<c> aVar, a.c cVar, Executor executor, long j11) {
        super(b0Var, aVar, cVar, executor, j11);
        this.f10206l = new b();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x00b8 A[SYNTHETIC] */
    public final void l(androidx.media3.datasource.a aVar, h4.a aVar2, long j11, long j12, boolean z11, ArrayList<SegmentDownloader.b> arrayList) throws InterruptedException, IOException {
        for (int i11 = 0; i11 < aVar2.f66244c.size(); i11++) {
            j jVar = aVar2.f66244c.get(i11);
            try {
                try {
                    f fVarN = n(aVar, aVar2.f66243b, jVar, z11);
                    if (fVarN != null) {
                        long jF = fVarN.f(j12);
                        if (jF == -1) {
                            throw new DownloadException("Unbounded segment index");
                        }
                        String str = ((h4.b) u0.i(this.f10206l.j(jVar.f66303c))).f66248a;
                        i iVarM = jVar.m();
                        if (iVarM != null) {
                            arrayList.add(m(jVar, str, j11, iVarM));
                        }
                        i iVarL = jVar.l();
                        if (iVarL != null) {
                            arrayList.add(m(jVar, str, j11, iVarL));
                        }
                        long jH = fVarN.h();
                        long j13 = (jH + jF) - 1;
                        for (long j14 = jH; j14 <= j13; j14++) {
                            arrayList.add(m(jVar, str, j11 + fVarN.getTimeUs(j14), fVarN.d(j14)));
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
        return new SegmentDownloader.b(j11, g.a(jVar, str, iVar, 0, ImmutableMap.of()));
    }

    @Nullable
    public final f n(final androidx.media3.datasource.a aVar, final int i11, final j jVar, boolean z11) throws InterruptedException, IOException {
        f fVarK = jVar.k();
        if (fVarK != null) {
            return fVarK;
        }
        h hVar = (h) e(new RunnableFutureTask<h, IOException>() { // from class: androidx.media3.exoplayer.dash.offline.DashDownloader.1
            @Override // androidx.media3.common.util.RunnableFutureTask
            public h doWork() throws IOException {
                return g.b(aVar, i11, jVar);
            }
        }, z11);
        if (hVar == null) {
            return null;
        }
        return new g4.h(hVar, jVar.f66304d);
    }

    @Override // androidx.media3.exoplayer.offline.SegmentDownloader
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public List<SegmentDownloader.b> h(androidx.media3.datasource.a aVar, c cVar, boolean z11) throws InterruptedException, IOException {
        ArrayList<SegmentDownloader.b> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < cVar.d(); i11++) {
            h4.g gVarC = cVar.c(i11);
            long jS0 = u0.S0(gVarC.f66288b);
            long jF = cVar.f(i11);
            int i12 = 0;
            for (List<h4.a> list = gVarC.f66289c; i12 < list.size(); list = list) {
                l(aVar, list.get(i12), jS0, jF, z11, arrayList);
                i12++;
            }
        }
        return arrayList;
    }
}
