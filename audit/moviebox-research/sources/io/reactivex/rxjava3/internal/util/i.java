package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class i {
    public static <T, U> boolean a(boolean z11, boolean z12, o<?> oVar, boolean z13, m10.g<?> gVar, h10.b bVar, e<T, U> eVar) {
        if (eVar.cancelled()) {
            gVar.clear();
            bVar.dispose();
            return true;
        }
        if (!z11) {
            return false;
        }
        if (z13) {
            if (!z12) {
                return false;
            }
            if (bVar != null) {
                bVar.dispose();
            }
            Throwable thError = eVar.error();
            if (thError != null) {
                oVar.onError(thError);
            } else {
                oVar.onComplete();
            }
            return true;
        }
        Throwable thError2 = eVar.error();
        if (thError2 != null) {
            gVar.clear();
            if (bVar != null) {
                bVar.dispose();
            }
            oVar.onError(thError2);
            return true;
        }
        if (!z12) {
            return false;
        }
        if (bVar != null) {
            bVar.dispose();
        }
        oVar.onComplete();
        return true;
    }

    public static <T, U> boolean b(boolean z11, boolean z12, u30.c<?> cVar, boolean z13, m10.g<?> gVar, h<T, U> hVar) {
        if (hVar.cancelled()) {
            gVar.clear();
            return true;
        }
        if (!z11) {
            return false;
        }
        if (z13) {
            if (!z12) {
                return false;
            }
            Throwable thError = hVar.error();
            if (thError != null) {
                cVar.onError(thError);
            } else {
                cVar.onComplete();
            }
            return true;
        }
        Throwable thError2 = hVar.error();
        if (thError2 != null) {
            gVar.clear();
            cVar.onError(thError2);
            return true;
        }
        if (!z12) {
            return false;
        }
        cVar.onComplete();
        return true;
    }

    public static <T> m10.g<T> c(int i11) {
        return i11 < 0 ? new io.reactivex.rxjava3.internal.queue.a(-i11) : new SpscArrayQueue(i11);
    }

    public static <T, U> void d(m10.f<T> fVar, o<? super U> oVar, boolean z11, h10.b bVar, e<T, U> eVar) {
        int iLeave = 1;
        while (!a(eVar.done(), fVar.isEmpty(), oVar, z11, fVar, bVar, eVar)) {
            while (true) {
                boolean zDone = eVar.done();
                T tPoll = fVar.poll();
                boolean z12 = tPoll == null;
                if (a(zDone, z12, oVar, z11, fVar, bVar, eVar)) {
                    return;
                }
                if (z12) {
                    break;
                } else {
                    eVar.accept(oVar, tPoll);
                }
            }
            iLeave = eVar.leave(-iLeave);
            if (iLeave == 0) {
                return;
            }
        }
    }

    public static <T, U> void e(m10.f<T> fVar, u30.c<? super U> cVar, boolean z11, h10.b bVar, h<T, U> hVar) {
        int iLeave = 1;
        while (true) {
            boolean zDone = hVar.done();
            T tPoll = fVar.poll();
            boolean z12 = tPoll == null;
            if (b(zDone, z12, cVar, z11, fVar, hVar)) {
                if (bVar != null) {
                    bVar.dispose();
                    return;
                }
                return;
            } else if (z12) {
                iLeave = hVar.leave(-iLeave);
                if (iLeave == 0) {
                    return;
                }
            } else {
                long jRequested = hVar.requested();
                if (jRequested == 0) {
                    fVar.clear();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    cVar.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
                    return;
                }
                if (hVar.accept(cVar, tPoll) && jRequested != Long.MAX_VALUE) {
                    hVar.produced(1L);
                }
            }
        }
    }

    public static void f(u30.d dVar, int i11) {
        dVar.request(i11 < 0 ? Long.MAX_VALUE : i11);
    }
}
