package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class g0 implements c1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m0 f41274b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f41275a;

    /* JADX INFO: compiled from: source.java */
    public static class a implements m0 {
        @Override // com.google.protobuf.m0
        public l0 a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // com.google.protobuf.m0
        public boolean b(Class<?> cls) {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m0[] f41276a;

        public b(m0... m0VarArr) {
            this.f41276a = m0VarArr;
        }

        @Override // com.google.protobuf.m0
        public l0 a(Class<?> cls) {
            for (m0 m0Var : this.f41276a) {
                if (m0Var.b(cls)) {
                    return m0Var.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // com.google.protobuf.m0
        public boolean b(Class<?> cls) {
            for (m0 m0Var : this.f41276a) {
                if (m0Var.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public g0() {
        this(b());
    }

    public g0(m0 m0Var) {
        this.f41275a = (m0) y.b(m0Var, "messageInfoFactory");
    }

    public static m0 b() {
        return new b(w.c(), c());
    }

    public static m0 c() {
        try {
            return (m0) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f41274b;
        }
    }

    public static boolean d(l0 l0Var) {
        return l0Var.c() == ProtoSyntax.PROTO2;
    }

    public static <T> b1<T> e(Class<T> cls, l0 l0Var) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            return d(l0Var) ? q0.R(cls, l0Var, u0.b(), e0.b(), d1.M(), s.b(), k0.b()) : q0.R(cls, l0Var, u0.b(), e0.b(), d1.M(), null, k0.b());
        }
        return d(l0Var) ? q0.R(cls, l0Var, u0.a(), e0.a(), d1.H(), s.a(), k0.a()) : q0.R(cls, l0Var, u0.a(), e0.a(), d1.I(), null, k0.a());
    }

    @Override // com.google.protobuf.c1
    public <T> b1<T> a(Class<T> cls) {
        d1.J(cls);
        l0 l0VarA = this.f41275a.a(cls);
        if (l0VarA.a()) {
            return GeneratedMessageLite.class.isAssignableFrom(cls) ? r0.m(d1.M(), s.b(), l0VarA.b()) : r0.m(d1.H(), s.a(), l0VarA.b());
        }
        return e(cls, l0VarA);
    }
}
