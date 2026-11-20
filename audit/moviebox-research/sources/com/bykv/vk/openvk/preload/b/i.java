package com.bykv.vk.openvk.preload.b;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected e f25663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f25664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<h> f25665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f25666d;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends Exception {
        public a(Throwable th2) {
            super(th2);
        }
    }

    public i(List<h> list, int i11, e eVar, d dVar) {
        this.f25665c = list;
        this.f25664b = i11;
        this.f25663a = eVar;
        this.f25666d = dVar;
    }

    private d c(Class cls) {
        d dVar = this.f25666d;
        while (dVar != null && dVar.getClass() != cls) {
            dVar = dVar.f25645a;
        }
        return dVar;
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object a(Class cls) {
        d dVarC = c(cls);
        if (dVarC != null) {
            return dVarC.f25646b;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:".concat(String.valueOf(cls)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object a(Object obj) throws Exception {
        d dVar = this.f25666d;
        if (dVar != null) {
            dVar.f25647c = obj;
            dVar.e();
        }
        if (this.f25664b >= this.f25665c.size()) {
            return obj;
        }
        h hVar = this.f25665c.get(this.f25664b);
        Class<? extends d> cls = hVar.f25657a;
        d dVar2 = (d) this.f25663a.a(cls);
        if (dVar2 == null) {
            throw new IllegalArgumentException("interceptor == null , index = " + obj + " , class: " + cls);
        }
        com.bykv.vk.openvk.preload.b.b.a aVarA = hVar.a();
        i iVar = new i(this.f25665c, this.f25664b + 1, this.f25663a, dVar2);
        dVar2.a(iVar, this.f25666d, obj, aVarA, hVar.b());
        dVar2.c();
        try {
            Object objA = dVar2.a(iVar, obj);
            dVar2.d();
            return objA;
        } catch (a e11) {
            dVar2.c(e11.getCause());
            throw e11;
        } catch (Throwable th2) {
            dVar2.b(th2);
            throw new a(th2);
        }
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object b(Class cls) {
        d dVarC = c(cls);
        if (dVarC != null) {
            return dVarC.f25647c;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:".concat(String.valueOf(cls)));
    }
}
