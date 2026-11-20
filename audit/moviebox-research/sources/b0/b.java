package b0;

import android.content.Context;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.prestrategy.PreStrategyManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f13870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f13871d;

    /* JADX WARN: Multi-variable type inference failed */
    public b(String str, String str2, Context context, Function1<? super Boolean, Unit> function1) {
        this.f13870c = context;
        this.f13871d = function1;
        this.f13868a = str;
        this.f13869b = str2;
    }

    public static final void b(Context context, b this$0, Function1 function1) {
        Intrinsics.g(this$0, "this$0");
        try {
            PreStrategyManager.f31651a.a(context, this$0.f13868a, this$0.f13869b, function1);
        } catch (Throwable th2) {
            PreStrategyManager preStrategyManager = PreStrategyManager.f31651a;
            TmcLogger.h("Prefetch:PreStrategyManager", th2);
        }
    }

    @Override // i.a
    public void a(Integer num, Throwable th2) {
        PreStrategyManager preStrategyManager = PreStrategyManager.f31651a;
        TmcLogger.h("Prefetch:PreStrategyManager", th2);
    }

    public void c(boolean z11) {
        if (z11) {
            return;
        }
        try {
            ExecutorType executorType = ExecutorType.IO;
            final Context context = this.f13870c;
            final Function1<Boolean, Unit> function1 = this.f13871d;
            com.cloud.tmc.kernel.utils.e.a(executorType, new Runnable() { // from class: b0.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.b(context, this, function1);
                }
            });
        } catch (Throwable th2) {
            PreStrategyManager preStrategyManager = PreStrategyManager.f31651a;
            TmcLogger.h("Prefetch:PreStrategyManager", th2);
        }
    }
}
