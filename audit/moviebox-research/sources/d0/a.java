package d0;

import java.util.LinkedList;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<b> f62852a = new LinkedList<>();

    public final void a() {
        while (!this.f62852a.isEmpty()) {
            b bVarPoll = this.f62852a.poll();
            if (bVarPoll != null) {
                bVarPoll.f62854i.run();
            }
        }
    }

    public final void b(b task) {
        Intrinsics.g(task, "task");
        ListIterator<b> listIterator = this.f62852a.listIterator();
        Intrinsics.f(listIterator, "queue.listIterator()");
        while (listIterator.hasNext()) {
            if (listIterator.next().f62853h == task.f62853h) {
                listIterator.set(task);
                return;
            }
        }
        this.f62852a.add(task);
    }
}
