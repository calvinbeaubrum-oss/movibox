package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69553b = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "lastScheduledTask$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f69554c = AtomicIntegerFieldUpdater.newUpdater(k.class, "producerIndex$volatile");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f69555d = AtomicIntegerFieldUpdater.newUpdater(k.class, "consumerIndex$volatile");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f69556e = AtomicIntegerFieldUpdater.newUpdater(k.class, "blockingTasksInBuffer$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray<Task> f69557a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final Task a(Task task, boolean z11) {
        if (z11) {
            return b(task);
        }
        Task task2 = (Task) f69553b.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return b(task2);
    }

    public final Task b(Task task) {
        if (e() == 127) {
            return task;
        }
        if (task.taskContext.b() == 1) {
            f69556e.incrementAndGet(this);
        }
        int i11 = f69554c.get(this) & 127;
        while (this.f69557a.get(i11) != null) {
            Thread.yield();
        }
        this.f69557a.lazySet(i11, task);
        f69554c.incrementAndGet(this);
        return null;
    }

    public final void c(Task task) {
        if (task == null || task.taskContext.b() != 1) {
            return;
        }
        f69556e.decrementAndGet(this);
    }

    public final int e() {
        return f69554c.get(this) - f69555d.get(this);
    }

    public final int i() {
        return f69553b.get(this) != null ? e() + 1 : e();
    }

    public final void j(c cVar) {
        Task task = (Task) f69553b.getAndSet(this, null);
        if (task != null) {
            cVar.a(task);
        }
        while (o(cVar)) {
        }
    }

    public final Task k() {
        Task task = (Task) f69553b.getAndSet(this, null);
        return task == null ? m() : task;
    }

    public final Task l() {
        return p(true);
    }

    public final Task m() {
        Task andSet;
        while (true) {
            int i11 = f69555d.get(this);
            if (i11 - f69554c.get(this) == 0) {
                return null;
            }
            int i12 = i11 & 127;
            if (f69555d.compareAndSet(this, i11, i11 + 1) && (andSet = this.f69557a.getAndSet(i12, null)) != null) {
                c(andSet);
                return andSet;
            }
        }
    }

    public final Task n() {
        return p(false);
    }

    public final boolean o(c cVar) {
        Task taskM = m();
        if (taskM == null) {
            return false;
        }
        cVar.a(taskM);
        return true;
    }

    public final Task p(boolean z11) {
        Task task;
        do {
            task = (Task) f69553b.get(this);
            if (task != null) {
                if ((task.taskContext.b() == 1) == z11) {
                }
            }
            int i11 = f69555d.get(this);
            int i12 = f69554c.get(this);
            while (i11 != i12) {
                if (z11 && f69556e.get(this) == 0) {
                    return null;
                }
                i12--;
                Task taskR = r(i12, z11);
                if (taskR != null) {
                    return taskR;
                }
            }
            return null;
        } while (!androidx.concurrent.futures.a.a(f69553b, this, task, null));
        return task;
    }

    public final Task q(int i11) {
        int i12 = f69555d.get(this);
        int i13 = f69554c.get(this);
        boolean z11 = i11 == 1;
        while (i12 != i13) {
            if (z11 && f69556e.get(this) == 0) {
                return null;
            }
            int i14 = i12 + 1;
            Task taskR = r(i12, z11);
            if (taskR != null) {
                return taskR;
            }
            i12 = i14;
        }
        return null;
    }

    public final Task r(int i11, boolean z11) {
        int i12 = i11 & 127;
        Task task = this.f69557a.get(i12);
        if (task != null) {
            if ((task.taskContext.b() == 1) == z11 && kotlinx.coroutines.channels.f.a(this.f69557a, i12, task, null)) {
                if (z11) {
                    f69556e.decrementAndGet(this);
                }
                return task;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long s(int i11, Ref.ObjectRef<Task> objectRef) {
        Task taskQ;
        T t11;
        Task taskM;
        if (i11 == 3) {
            taskM = m();
        } else {
            taskQ = q(i11);
        }
        if (t11 == 0) {
            t11 = taskQ;
            t11 = taskM;
            return t(i11, objectRef);
        }
        t11 = taskQ;
        t11 = taskM;
        objectRef.element = t11;
        return -1L;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object, kotlinx.coroutines.scheduling.Task] */
    public final long t(int i11, Ref.ObjectRef<Task> objectRef) {
        ?? r11;
        do {
            r11 = (Task) f69553b.get(this);
            if (r11 == 0) {
                return -2L;
            }
            if (((r11.taskContext.b() != 1 ? 2 : 1) & i11) == 0) {
                return -2L;
            }
            long jA = i.f69549f.a() - r11.submissionTime;
            long j11 = i.f69545b;
            if (jA < j11) {
                return j11 - jA;
            }
        } while (!androidx.concurrent.futures.a.a(f69553b, this, r11, null));
        objectRef.element = r11;
        return -1L;
    }
}
