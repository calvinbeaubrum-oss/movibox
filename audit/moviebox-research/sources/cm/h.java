package cm;

import cm.h;
import com.google.common.base.m;
import java.util.concurrent.Executors;
import org.chromium.net.CronetEngine;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class h<SubBuilderT extends h<?, ? extends ObjectBeingBuiltT>, ObjectBeingBuiltT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CronetEngine f14993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14994b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f14995c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SubBuilderT f14996d;

    /* JADX WARN: Multi-variable type inference failed */
    public h(CronetEngine cronetEngine, Class<SubBuilderT> cls) {
        this.f14993a = (CronetEngine) m.p(cronetEngine);
        m.d(getClass().equals(cls));
        this.f14996d = this;
    }

    public ObjectBeingBuiltT a() {
        if (this.f14995c == null) {
            this.f14995c = d.a();
        }
        return b(new g(this.f14993a, Executors.newFixedThreadPool(this.f14994b), com.google.net.cronet.okhttptransport.a.b(Executors.newCachedThreadPool()), new i(), this.f14995c));
    }

    public abstract ObjectBeingBuiltT b(g gVar);
}
