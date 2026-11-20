package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.d0;
import androidx.work.impl.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import s6.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class EnqueueRunnable implements Runnable {
    private static final String TAG = androidx.work.j.i("EnqueueRunnable");
    private final androidx.work.impl.o mOperation;
    private final w mWorkContinuation;

    public EnqueueRunnable(@NonNull w wVar) {
        this(wVar, new androidx.work.impl.o());
    }

    public EnqueueRunnable(@NonNull w wVar, @NonNull androidx.work.impl.o oVar) {
        this.mWorkContinuation = wVar;
        this.mOperation = oVar;
    }

    private static boolean enqueueContinuation(@NonNull w wVar) {
        boolean zEnqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(wVar.g(), wVar.f(), (String[]) w.l(wVar).toArray(new String[0]), wVar.d(), wVar.b());
        wVar.k();
        return zEnqueueWorkWithPrerequisites;
    }

    /* JADX WARN: Code duplicated, block: B:83:0x014e  */
    private static boolean enqueueWorkWithPrerequisites(d0 d0Var, @NonNull List<? extends androidx.work.r> list, String[] strArr, String str, ExistingWorkPolicy existingWorkPolicy) {
        boolean z11;
        boolean z12;
        boolean z13;
        String[] strArr2 = strArr;
        long jCurrentTimeMillis = System.currentTimeMillis();
        WorkDatabase workDatabaseU = d0Var.u();
        boolean z14 = true;
        boolean z15 = strArr2 != null && strArr2.length > 0;
        if (z15) {
            z11 = true;
            z12 = false;
            z13 = false;
            for (String str2 : strArr2) {
                s6.u uVarJ = workDatabaseU.N().j(str2);
                if (uVarJ == null) {
                    androidx.work.j.e().c(TAG, "Prerequisite " + str2 + " doesn't exist; not enqueuing");
                    return false;
                }
                WorkInfo.State state = uVarJ.f76200b;
                z11 &= state == WorkInfo.State.SUCCEEDED;
                if (state == WorkInfo.State.FAILED) {
                    z13 = true;
                } else if (state == WorkInfo.State.CANCELLED) {
                    z12 = true;
                }
            }
        } else {
            z11 = true;
            z12 = false;
            z13 = false;
        }
        boolean z16 = !TextUtils.isEmpty(str);
        if (!z16 || z15) {
            z14 = false;
        } else {
            List<s6.u.b> listS = workDatabaseU.N().s(str);
            if (!listS.isEmpty()) {
                if (existingWorkPolicy == ExistingWorkPolicy.APPEND || existingWorkPolicy == ExistingWorkPolicy.APPEND_OR_REPLACE) {
                    s6.b bVarH = workDatabaseU.H();
                    List arrayList = new ArrayList();
                    for (s6.u.b bVar : listS) {
                        if (!bVarH.d(bVar.f76219a)) {
                            WorkInfo.State state2 = bVar.f76220b;
                            boolean z17 = (state2 == WorkInfo.State.SUCCEEDED) & z11;
                            if (state2 == WorkInfo.State.FAILED) {
                                z13 = true;
                            } else if (state2 == WorkInfo.State.CANCELLED) {
                                z12 = true;
                            }
                            arrayList.add(bVar.f76219a);
                            z11 = z17;
                        }
                        bVarH = bVarH;
                    }
                    if (existingWorkPolicy == ExistingWorkPolicy.APPEND_OR_REPLACE && (z12 || z13)) {
                        v vVarN = workDatabaseU.N();
                        Iterator<s6.u.b> it = vVarN.s(str).iterator();
                        while (it.hasNext()) {
                            vVarN.a(it.next().f76219a);
                        }
                        arrayList = Collections.emptyList();
                        z12 = false;
                        z13 = false;
                    }
                    strArr2 = (String[]) arrayList.toArray(strArr2);
                    z15 = strArr2.length > 0;
                } else {
                    if (existingWorkPolicy == ExistingWorkPolicy.KEEP) {
                        Iterator<s6.u.b> it2 = listS.iterator();
                        while (it2.hasNext()) {
                            WorkInfo.State state3 = it2.next().f76220b;
                            if (state3 == WorkInfo.State.ENQUEUED || state3 == WorkInfo.State.RUNNING) {
                                return false;
                            }
                        }
                    }
                    CancelWorkRunnable.forName(str, d0Var, false).run();
                    v vVarN2 = workDatabaseU.N();
                    Iterator<s6.u.b> it3 = listS.iterator();
                    while (it3.hasNext()) {
                        vVarN2.a(it3.next().f76219a);
                    }
                }
            }
            z14 = false;
        }
        Iterator<? extends androidx.work.r> it4 = list.iterator();
        while (it4.hasNext()) {
            androidx.work.r next = it4.next();
            s6.u uVarD = next.d();
            if (!z15 || z11) {
                uVarD.f76212n = jCurrentTimeMillis;
            } else if (z13) {
                uVarD.f76200b = WorkInfo.State.FAILED;
            } else if (z12) {
                uVarD.f76200b = WorkInfo.State.CANCELLED;
            } else {
                uVarD.f76200b = WorkInfo.State.BLOCKED;
            }
            Iterator<? extends androidx.work.r> it5 = it4;
            if (uVarD.f76200b == WorkInfo.State.ENQUEUED) {
                z14 = true;
            }
            workDatabaseU.N().e(b.c(d0Var.s(), uVarD));
            if (z15) {
                int length = strArr2.length;
                int i11 = 0;
                while (i11 < length) {
                    workDatabaseU.H().c(new s6.a(next.b(), strArr2[i11]));
                    i11++;
                    length = length;
                    strArr2 = strArr2;
                }
            }
            String[] strArr3 = strArr2;
            workDatabaseU.O().d(next.b(), next.c());
            if (z16) {
                workDatabaseU.L().b(new s6.n(str, next.b()));
            }
            it4 = it5;
            strArr2 = strArr3;
        }
        return z14;
    }

    private static boolean processContinuation(@NonNull w wVar) {
        List<w> listE = wVar.e();
        boolean zProcessContinuation = false;
        if (listE != null) {
            for (w wVar2 : listE) {
                if (wVar2.j()) {
                    androidx.work.j.e().k(TAG, "Already enqueued work ids (" + TextUtils.join(", ", wVar2.c()) + ")");
                } else {
                    zProcessContinuation |= processContinuation(wVar2);
                }
            }
        }
        return enqueueContinuation(wVar) | zProcessContinuation;
    }

    public boolean addToDatabase() {
        WorkDatabase workDatabaseU = this.mWorkContinuation.g().u();
        workDatabaseU.e();
        try {
            boolean zProcessContinuation = processContinuation(this.mWorkContinuation);
            workDatabaseU.E();
            return zProcessContinuation;
        } finally {
            workDatabaseU.i();
        }
    }

    @NonNull
    public androidx.work.l getOperation() {
        return this.mOperation;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.mWorkContinuation.h()) {
                throw new IllegalStateException("WorkContinuation has cycles (" + this.mWorkContinuation + ")");
            }
            if (addToDatabase()) {
                n.a(this.mWorkContinuation.g().m(), RescheduleReceiver.class, true);
                scheduleWorkInBackground();
            }
            this.mOperation.a(androidx.work.l.f13572a);
        } catch (Throwable th2) {
            this.mOperation.a(new androidx.work.l.b.a(th2));
        }
    }

    public void scheduleWorkInBackground() {
        d0 d0VarG = this.mWorkContinuation.g();
        androidx.work.impl.t.b(d0VarG.n(), d0VarG.u(), d0VarG.s());
    }
}
