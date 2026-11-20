package ul;

import android.app.ActivityManager;
import android.content.Context;
import com.google.firebase.perf.util.StorageUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ql.a f78587e = ql.a.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runtime f78588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActivityManager f78589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ActivityManager.MemoryInfo f78590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f78591d;

    public i(Context context) {
        this(Runtime.getRuntime(), context);
    }

    public i(Runtime runtime, Context context) {
        this.f78588a = runtime;
        this.f78591d = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.f78589b = activityManager;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.f78590c = memoryInfo;
        activityManager.getMemoryInfo(memoryInfo);
    }

    public int a() {
        return com.google.firebase.perf.util.k.c(StorageUnit.BYTES.toKilobytes(this.f78590c.totalMem));
    }

    public int b() {
        return com.google.firebase.perf.util.k.c(StorageUnit.BYTES.toKilobytes(this.f78588a.maxMemory()));
    }

    public int c() {
        return com.google.firebase.perf.util.k.c(StorageUnit.MEGABYTES.toKilobytes(this.f78589b.getMemoryClass()));
    }
}
