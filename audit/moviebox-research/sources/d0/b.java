package d0;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends ce.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f62853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Runnable f62854i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String uniqueId, Runnable execute) {
        super("NormalTask", 0L, 2, null);
        Intrinsics.g(uniqueId, "uniqueId");
        Intrinsics.g(execute, "execute");
        this.f62853h = uniqueId;
        this.f62854i = execute;
    }

    @Override // ce.b
    public String I() {
        return "normal";
    }

    @Override // ce.b
    public void P(Function1<? super yd.a<?>, Unit> function1) {
        this.f62854i.run();
    }
}
