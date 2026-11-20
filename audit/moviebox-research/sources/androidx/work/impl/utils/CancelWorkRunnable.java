package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.d0;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import s6.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class CancelWorkRunnable implements Runnable {
    private final androidx.work.impl.o mOperation = new androidx.work.impl.o();

    @NonNull
    public static CancelWorkRunnable forAll(@NonNull final d0 d0Var) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.4
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            public void runInternal() {
                WorkDatabase workDatabaseU = d0Var.u();
                workDatabaseU.e();
                try {
                    Iterator<String> it = workDatabaseU.N().x().iterator();
                    while (it.hasNext()) {
                        cancel(d0Var, it.next());
                    }
                    new o(d0Var.u()).e(System.currentTimeMillis());
                    workDatabaseU.E();
                } finally {
                    workDatabaseU.i();
                }
            }
        };
    }

    @NonNull
    public static CancelWorkRunnable forId(@NonNull final UUID uuid, @NonNull final d0 d0Var) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.1
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            public void runInternal() {
                WorkDatabase workDatabaseU = d0Var.u();
                workDatabaseU.e();
                try {
                    cancel(d0Var, uuid.toString());
                    workDatabaseU.E();
                    workDatabaseU.i();
                    reschedulePendingWorkers(d0Var);
                } catch (Throwable th2) {
                    workDatabaseU.i();
                    throw th2;
                }
            }
        };
    }

    @NonNull
    public static CancelWorkRunnable forName(@NonNull final String str, @NonNull final d0 d0Var, final boolean z11) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.3
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            public void runInternal() {
                WorkDatabase workDatabaseU = d0Var.u();
                workDatabaseU.e();
                try {
                    Iterator<String> it = workDatabaseU.N().g(str).iterator();
                    while (it.hasNext()) {
                        cancel(d0Var, it.next());
                    }
                    workDatabaseU.E();
                    workDatabaseU.i();
                    if (z11) {
                        reschedulePendingWorkers(d0Var);
                    }
                } catch (Throwable th2) {
                    workDatabaseU.i();
                    throw th2;
                }
            }
        };
    }

    @NonNull
    public static CancelWorkRunnable forTag(@NonNull final String str, @NonNull final d0 d0Var) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.2
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            public void runInternal() {
                WorkDatabase workDatabaseU = d0Var.u();
                workDatabaseU.e();
                try {
                    Iterator<String> it = workDatabaseU.N().l(str).iterator();
                    while (it.hasNext()) {
                        cancel(d0Var, it.next());
                    }
                    workDatabaseU.E();
                    workDatabaseU.i();
                    reschedulePendingWorkers(d0Var);
                } catch (Throwable th2) {
                    workDatabaseU.i();
                    throw th2;
                }
            }
        };
    }

    private void iterativelyCancelWorkAndDependents(WorkDatabase workDatabase, String str) {
        v vVarN = workDatabase.N();
        s6.b bVarH = workDatabase.H();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State stateI = vVarN.i(str2);
            if (stateI != WorkInfo.State.SUCCEEDED && stateI != WorkInfo.State.FAILED) {
                vVarN.u(WorkInfo.State.CANCELLED, str2);
            }
            linkedList.addAll(bVarH.a(str2));
        }
    }

    public void cancel(d0 d0Var, String str) {
        iterativelyCancelWorkAndDependents(d0Var.u(), str);
        d0Var.r().r(str);
        Iterator<androidx.work.impl.s> it = d0Var.s().iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
    }

    @NonNull
    public androidx.work.l getOperation() {
        return this.mOperation;
    }

    public void reschedulePendingWorkers(d0 d0Var) {
        androidx.work.impl.t.b(d0Var.n(), d0Var.u(), d0Var.s());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            runInternal();
            this.mOperation.a(androidx.work.l.f13572a);
        } catch (Throwable th2) {
            this.mOperation.a(new androidx.work.l.b.a(th2));
        }
    }

    public abstract void runInternal();
}
