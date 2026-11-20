package com.transsion.json.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f52924a;

    public o(n nVar) {
        this.f52924a = nVar;
    }

    @Override // com.transsion.json.b.a, com.transsion.json.b.g
    public Boolean a() {
        n nVar = this.f52924a;
        return Boolean.valueOf((nVar instanceof g) && ((g) nVar).a().booleanValue());
    }

    @Override // com.transsion.json.b.n
    public void a(Object obj) {
        b().t().addFirst(obj);
        this.f52924a.a(obj);
        b().t().removeFirst();
    }
}
