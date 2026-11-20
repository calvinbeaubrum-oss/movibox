package com.bykv.vk.openvk.preload.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Class<? extends d> f25657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.b.b.a f25658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f25659c;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Class<? extends d> f25660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bykv.vk.openvk.preload.b.b.a f25661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object[] f25662c;

        private a() {
        }

        public static a a() {
            return new a();
        }

        public final a a(com.bykv.vk.openvk.preload.b.b.a aVar) {
            this.f25661b = aVar;
            return this;
        }

        public final a a(Class<? extends d> cls) {
            if (cls == null) {
                throw new IllegalArgumentException("interceptor class == null");
            }
            this.f25660a = cls;
            return this;
        }

        public final a a(Object... objArr) {
            this.f25662c = objArr;
            return this;
        }

        public final h b() {
            return new h(this, (byte) 0);
        }
    }

    private h(a aVar) {
        this.f25657a = aVar.f25660a;
        this.f25658b = aVar.f25661b;
        this.f25659c = aVar.f25662c;
        if (this.f25657a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }

    public /* synthetic */ h(a aVar, byte b11) {
        this(aVar);
    }

    public final com.bykv.vk.openvk.preload.b.b.a a() {
        return this.f25658b;
    }

    public final Object[] b() {
        return this.f25659c;
    }
}
