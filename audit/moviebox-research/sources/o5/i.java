package o5;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static int a(k kVar, s.b bVar) {
        long j11 = bVar.f72354a;
        if (j11 == C.TIME_UNSET) {
            return 0;
        }
        int nextEventTimeIndex = kVar.getNextEventTimeIndex(j11);
        if (nextEventTimeIndex == -1) {
            return kVar.getEventTimeCount();
        }
        return (nextEventTimeIndex <= 0 || kVar.getEventTime(nextEventTimeIndex + (-1)) != bVar.f72354a) ? nextEventTimeIndex : nextEventTimeIndex - 1;
    }

    public static void b(k kVar, int i11, z3.h<e> hVar) {
        long eventTime = kVar.getEventTime(i11);
        List<y3.a> cues = kVar.getCues(eventTime);
        if (cues.isEmpty()) {
            return;
        }
        if (i11 == kVar.getEventTimeCount() - 1) {
            throw new IllegalStateException();
        }
        long eventTime2 = kVar.getEventTime(i11 + 1) - kVar.getEventTime(i11);
        if (eventTime2 > 0) {
            hVar.accept(new e(cues, eventTime, eventTime2));
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0037  */
    public static void c(k kVar, s.b bVar, z3.h<e> hVar) {
        boolean z11;
        int iA = a(kVar, bVar);
        long j11 = bVar.f72354a;
        if (j11 != C.TIME_UNSET) {
            List<y3.a> cues = kVar.getCues(j11);
            long eventTime = kVar.getEventTime(iA);
            if (cues.isEmpty() || iA >= kVar.getEventTimeCount()) {
                z11 = false;
            } else {
                long j12 = bVar.f72354a;
                if (j12 < eventTime) {
                    hVar.accept(new e(cues, j12, eventTime - j12));
                    z11 = true;
                } else {
                    z11 = false;
                }
            }
        } else {
            z11 = false;
        }
        for (int i11 = iA; i11 < kVar.getEventTimeCount(); i11++) {
            b(kVar, i11, hVar);
        }
        if (bVar.f72355b) {
            if (z11) {
                iA--;
            }
            for (int i12 = 0; i12 < iA; i12++) {
                b(kVar, i12, hVar);
            }
            if (z11) {
                hVar.accept(new e(kVar.getCues(bVar.f72354a), kVar.getEventTime(iA), bVar.f72354a - kVar.getEventTime(iA)));
            }
        }
    }
}
