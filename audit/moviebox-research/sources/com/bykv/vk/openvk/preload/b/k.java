package com.bykv.vk.openvk.preload.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k<IN, OUT> extends d<IN, OUT> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IN f25668d;

    private Object a(b<OUT> bVar, Throwable th2) throws Throwable {
        while (a(th2)) {
            try {
                return bVar.a(a());
            } catch (i.a e11) {
                th2 = e11.getCause();
            }
        }
        throw th2;
    }

    public OUT a() {
        return this.f25668d;
    }

    @Override // com.bykv.vk.openvk.preload.b.d
    public final Object a(b<OUT> bVar, IN in2) throws Throwable {
        this.f25668d = in2;
        try {
            return bVar.a(a());
        } catch (i.a e11) {
            return a((b) bVar, e11.getCause());
        } catch (Throwable th2) {
            return a((b) bVar, th2);
        }
    }

    public abstract boolean a(Throwable th2);

    public final IN g() {
        return this.f25668d;
    }
}
