package com.mbridge.msdk.newreward.function.d.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c extends d<String> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Boolean f46349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f46350c;

    public c(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.a.a aVar) {
        super(bVar, aVar);
        this.f46349b = null;
    }

    public final void a(String str) {
        this.f46350c = str;
    }

    public abstract boolean a_();

    @Override // com.mbridge.msdk.newreward.function.d.c.d
    public final boolean f() {
        return false;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.o
    public final boolean g() {
        Boolean bool = this.f46349b;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean boolValueOf = Boolean.valueOf(a_());
        this.f46349b = boolValueOf;
        return boolValueOf.booleanValue();
    }
}
