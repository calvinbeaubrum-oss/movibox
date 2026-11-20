package com.bykv.vk.openvk.preload.b;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j<IN, OUT> extends l<IN, OUT> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f25667d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.preload.b.d
    public final Object a(b<OUT> bVar, IN in2) throws Throwable {
        new c(bVar);
        this.f25667d = a(in2);
        l.a aVar = a().get(this.f25667d);
        while (aVar != null) {
            List<h> list = aVar.f25670a;
            try {
                Object objA = c.a(list, bVar.f25663a, this).a(in2);
                return !l.a(list) ? objA : bVar.a(objA);
            } catch (i.a e11) {
                Throwable cause = e11.getCause();
                new c(bVar);
                this.f25667d = a(in2, cause, this.f25667d);
                aVar = a().get(this.f25667d);
            } catch (Throwable th2) {
                new c(bVar);
                this.f25667d = a(in2, th2, this.f25667d);
                aVar = a().get(this.f25667d);
            }
        }
        throw new IllegalArgumentException("can not found branch，branch name is：" + this.f25667d);
    }

    public abstract String a(IN in2);

    public abstract String a(IN in2, Throwable th2, String str);
}
