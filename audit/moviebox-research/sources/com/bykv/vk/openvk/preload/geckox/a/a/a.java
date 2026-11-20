package com.bykv.vk.openvk.preload.geckox.a.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f25698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f25699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f25700c;

    /* JADX INFO: renamed from: com.bykv.vk.openvk.preload.geckox.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0214a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f25701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f25702b = b.f25703a;

        public final C0214a a() {
            this.f25701a = 20;
            return this;
        }

        public final C0214a a(b bVar) {
            if (bVar == null) {
                bVar = b.f25703a;
            }
            this.f25702b = bVar;
            return this;
        }

        public final a b() {
            return new a(this, (byte) 0);
        }
    }

    private a(C0214a c0214a) {
        this.f25698a = c0214a.f25701a;
        this.f25699b = c0214a.f25702b;
        this.f25700c = null;
    }

    public /* synthetic */ a(C0214a c0214a, byte b11) {
        this(c0214a);
    }

    public final b a() {
        return this.f25699b;
    }
}
