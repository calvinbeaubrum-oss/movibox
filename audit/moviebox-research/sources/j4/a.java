package j4;

import android.net.Uri;
import androidx.media3.common.b0;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser;
import androidx.media3.exoplayer.hls.playlist.b;
import androidx.media3.exoplayer.hls.playlist.c;
import androidx.media3.exoplayer.offline.SegmentDownloader;
import androidx.media3.exoplayer.upstream.o;
import c4.g;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import k4.e;
import z3.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends SegmentDownloader<e> {
    public a(b0 b0Var, androidx.media3.datasource.cache.a.c cVar, Executor executor) {
        this(b0Var, new HlsPlaylistParser(), cVar, executor, DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT);
    }

    public a(b0 b0Var, o.a<e> aVar, androidx.media3.datasource.cache.a.c cVar, Executor executor, long j11) {
        super(b0Var, aVar, cVar, executor, j11);
    }

    public final void l(List<Uri> list, List<g> list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            list2.add(SegmentDownloader.f(list.get(i11)));
        }
    }

    public final void m(b bVar, b.d dVar, HashSet<Uri> hashSet, ArrayList<SegmentDownloader.b> arrayList) {
        String str = bVar.f68239a;
        long j11 = bVar.f10528h + dVar.f10554f;
        String str2 = dVar.f10556h;
        if (str2 != null) {
            Uri uriF = k0.f(str, str2);
            if (hashSet.add(uriF)) {
                arrayList.add(new SegmentDownloader.b(j11, SegmentDownloader.f(uriF)));
            }
        }
        arrayList.add(new SegmentDownloader.b(j11, new g(k0.f(str, dVar.f10550a), dVar.f10558j, dVar.f10559k)));
    }

    @Override // androidx.media3.exoplayer.offline.SegmentDownloader
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public List<SegmentDownloader.b> h(androidx.media3.datasource.a aVar, e eVar, boolean z11) throws InterruptedException, IOException {
        ArrayList<g> arrayList = new ArrayList();
        if (eVar instanceof c) {
            l(((c) eVar).f10567d, arrayList);
        } else {
            arrayList.add(SegmentDownloader.f(Uri.parse(eVar.f68239a)));
        }
        ArrayList<SegmentDownloader.b> arrayList2 = new ArrayList<>();
        HashSet<Uri> hashSet = new HashSet<>();
        for (g gVar : arrayList) {
            arrayList2.add(new SegmentDownloader.b(0L, gVar));
            try {
                b bVar = (b) g(aVar, gVar, z11);
                List<b.d> list = bVar.f10538r;
                b.d dVar = null;
                for (int i11 = 0; i11 < list.size(); i11++) {
                    b.d dVar2 = list.get(i11);
                    b.d dVar3 = dVar2.f10551b;
                    if (dVar3 != null && dVar3 != dVar) {
                        m(bVar, dVar3, hashSet, arrayList2);
                        dVar = dVar3;
                    }
                    m(bVar, dVar2, hashSet, arrayList2);
                }
            } catch (IOException e11) {
                if (!z11) {
                    throw e11;
                }
            }
        }
        return arrayList2;
    }
}
