package h4;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.StreamKey;
import androidx.media3.exoplayer.offline.q;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements q<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f66252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f66253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f66254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f66255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f66256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f66257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f66258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f66259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final o f66260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final l f66261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final Uri f66262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final h f66263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<g> f66264m;

    public c(long j11, long j12, long j13, boolean z11, long j14, long j15, long j16, long j17, @Nullable h hVar, @Nullable o oVar, @Nullable l lVar, @Nullable Uri uri, List<g> list) {
        this.f66252a = j11;
        this.f66253b = j12;
        this.f66254c = j13;
        this.f66255d = z11;
        this.f66256e = j14;
        this.f66257f = j15;
        this.f66258g = j16;
        this.f66259h = j17;
        this.f66263l = hVar;
        this.f66260i = oVar;
        this.f66262k = uri;
        this.f66261j = lVar;
        this.f66264m = list == null ? Collections.emptyList() : list;
    }

    public static ArrayList<a> b(List<a> list, LinkedList<StreamKey> linkedList) {
        StreamKey streamKeyPoll = linkedList.poll();
        int i11 = streamKeyPoll.periodIndex;
        ArrayList<a> arrayList = new ArrayList<>();
        do {
            int i12 = streamKeyPoll.groupIndex;
            a aVar = list.get(i12);
            List<j> list2 = aVar.f66244c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(streamKeyPoll.streamIndex));
                streamKeyPoll = linkedList.poll();
                if (streamKeyPoll.periodIndex != i11) {
                    break;
                }
            } while (streamKeyPoll.groupIndex == i12);
            arrayList.add(new a(aVar.f66242a, aVar.f66243b, arrayList2, aVar.f66245d, aVar.f66246e, aVar.f66247f));
        } while (streamKeyPoll.periodIndex == i11);
        linkedList.addFirst(streamKeyPoll);
        return arrayList;
    }

    @Override // androidx.media3.exoplayer.offline.q
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final c copy(List<StreamKey> list) {
        long j11;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j12 = 0;
        int i11 = 0;
        while (true) {
            int iD = d();
            j11 = C.TIME_UNSET;
            if (i11 >= iD) {
                break;
            }
            if (((StreamKey) linkedList.peek()).periodIndex != i11) {
                long jE = e(i11);
                if (jE != C.TIME_UNSET) {
                    j12 += jE;
                }
            } else {
                g gVarC = c(i11);
                arrayList.add(new g(gVarC.f66287a, gVarC.f66288b - j12, b(gVarC.f66289c, linkedList), gVarC.f66290d));
            }
            i11++;
        }
        long j13 = this.f66253b;
        if (j13 != C.TIME_UNSET) {
            j11 = j13 - j12;
        }
        return new c(this.f66252a, j11, this.f66254c, this.f66255d, this.f66256e, this.f66257f, this.f66258g, this.f66259h, this.f66263l, this.f66260i, this.f66261j, this.f66262k, arrayList);
    }

    public final g c(int i11) {
        return this.f66264m.get(i11);
    }

    public final int d() {
        return this.f66264m.size();
    }

    public final long e(int i11) {
        long j11;
        long j12;
        if (i11 == this.f66264m.size() - 1) {
            j11 = this.f66253b;
            if (j11 == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            j12 = this.f66264m.get(i11).f66288b;
        } else {
            j11 = this.f66264m.get(i11 + 1).f66288b;
            j12 = this.f66264m.get(i11).f66288b;
        }
        return j11 - j12;
    }

    public final long f(int i11) {
        return u0.S0(e(i11));
    }
}
