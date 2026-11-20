package q9;

import com.google.common.base.m;
import java.util.concurrent.Executors;
import org.chromium.net.CronetEngine;
import q9.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h<SubBuilderT extends h<?, ? extends ObjectBeingBuiltT>, ObjectBeingBuiltT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CronetEngine f74478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f74479b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f74480c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SubBuilderT f74481d;

    /* JADX WARN: Multi-variable type inference failed */
    public h(CronetEngine cronetEngine, Class<SubBuilderT> cls) {
        this.f74478a = (CronetEngine) m.p(cronetEngine);
        m.d(getClass().equals(cls));
        this.f74481d = this;
    }

    public ObjectBeingBuiltT a() {
        if (this.f74480c == null) {
            this.f74480c = d.a();
        }
        return b(new g(this.f74478a, Executors.newFixedThreadPool(this.f74479b), com.cloud.hisavana.protocol.okhttptransport.a.b(Executors.newCachedThreadPool()), new i(), this.f74480c));
    }

    public abstract ObjectBeingBuiltT b(g gVar);
}
