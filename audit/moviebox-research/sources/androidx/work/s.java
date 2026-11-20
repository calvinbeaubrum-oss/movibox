package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13585a = j.i("WorkerFactory");

    /* JADX INFO: compiled from: source.java */
    public class a extends s {
        @Override // androidx.work.s
        @Nullable
        public i a(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters) {
            return null;
        }
    }

    @NonNull
    public static s c() {
        return new a();
    }

    @Nullable
    public abstract i a(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters);

    @Nullable
    public final i b(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters) {
        Class clsAsSubclass;
        i iVarA = a(context, str, workerParameters);
        if (iVarA == null) {
            try {
                clsAsSubclass = Class.forName(str).asSubclass(i.class);
            } catch (Throwable th2) {
                j.e().d(f13585a, "Invalid class: " + str, th2);
                clsAsSubclass = null;
            }
            if (clsAsSubclass != null) {
                try {
                    iVarA = (i) clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
                } catch (Throwable th3) {
                    j.e().d(f13585a, "Could not instantiate " + str, th3);
                }
            }
        }
        if (iVarA == null || !iVarA.isUsed()) {
            return iVarA;
        }
        throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + str + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
