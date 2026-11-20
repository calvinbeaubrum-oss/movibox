package i0;

import com.cloud.tmc.integration.model.PrepareData;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import kotlin.jvm.internal.Intrinsics;
import p011Oooo00o.o00Ooo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s extends z.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f66862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ua.j f66863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f66864c;

    public s(String str, ua.j jVar, String str2) {
        this.f66862a = str;
        this.f66863b = jVar;
        this.f66864c = str2;
    }

    public static final void j(ua.j loadCheckCallback, String path) {
        Intrinsics.g(loadCheckCallback, "$loadCheckCallback");
        Intrinsics.g(path, "$path");
        n0.j.a();
        loadCheckCallback.a(path);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.r
    public void c() {
        o00Ooo.f223a.a().remove(this.f66862a);
        final ua.j jVar = this.f66863b;
        final String str = this.f66864c;
        com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: i0.r
            @Override // java.lang.Runnable
            public final void run() {
                s.j(jVar, str);
            }
        });
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.r
    public void f(PrepareData prepareData, PrepareException prepareException) {
        o00Ooo.f223a.a().remove(this.f66862a);
        n0.j.a();
    }
}
