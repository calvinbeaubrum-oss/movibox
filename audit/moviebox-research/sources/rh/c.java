package rh;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c implements com.google.android.exoplayer2.offline.c<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f75394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f75395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f75396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f75397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f75398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f75399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f75400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f75401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final o f75402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final l f75403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final Uri f75404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final h f75405l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<g> f75406m;

    public c(long j11, long j12, long j13, boolean z11, long j14, long j15, long j16, long j17, @Nullable h hVar, @Nullable o oVar, @Nullable l lVar, @Nullable Uri uri, List<g> list) {
        this.f75394a = j11;
        this.f75395b = j12;
        this.f75396c = j13;
        this.f75397d = z11;
        this.f75398e = j14;
        this.f75399f = j15;
        this.f75400g = j16;
        this.f75401h = j17;
        this.f75405l = hVar;
        this.f75402i = oVar;
        this.f75404k = uri;
        this.f75403j = lVar;
        this.f75406m = list == null ? Collections.emptyList() : list;
    }

    public static ArrayList<a> b(List<a> list, LinkedList<StreamKey> linkedList) {
        StreamKey streamKeyPoll = linkedList.poll();
        int i11 = streamKeyPoll.periodIndex;
        ArrayList<a> arrayList = new ArrayList<>();
        do {
            int i12 = streamKeyPoll.groupIndex;
            a aVar = list.get(i12);
            List<j> list2 = aVar.f75386c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(streamKeyPoll.streamIndex));
                streamKeyPoll = linkedList.poll();
                if (streamKeyPoll.periodIndex != i11) {
                    break;
                }
            } while (streamKeyPoll.groupIndex == i12);
            arrayList.add(new a(aVar.f75384a, aVar.f75385b, arrayList2, aVar.f75387d, aVar.f75388e, aVar.f75389f));
        } while (streamKeyPoll.periodIndex == i11);
        linkedList.addFirst(streamKeyPoll);
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.offline.c
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
                arrayList.add(new g(gVarC.f75429a, gVarC.f75430b - j12, b(gVarC.f75431c, linkedList), gVarC.f75432d));
            }
            i11++;
        }
        long j13 = this.f75395b;
        if (j13 != C.TIME_UNSET) {
            j11 = j13 - j12;
        }
        return new c(this.f75394a, j11, this.f75396c, this.f75397d, this.f75398e, this.f75399f, this.f75400g, this.f75401h, this.f75405l, this.f75402i, this.f75403j, this.f75404k, arrayList);
    }

    public final g c(int i11) {
        return this.f75406m.get(i11);
    }

    public final int d() {
        return this.f75406m.size();
    }

    public final long e(int i11) {
        long j11;
        long j12;
        if (i11 == this.f75406m.size() - 1) {
            j11 = this.f75395b;
            if (j11 == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            j12 = this.f75406m.get(i11).f75430b;
        } else {
            j11 = this.f75406m.get(i11 + 1).f75430b;
            j12 = this.f75406m.get(i11).f75430b;
        }
        return j11 - j12;
    }

    public final long f(int i11) {
        return o0.C0(e(i11));
    }
}
