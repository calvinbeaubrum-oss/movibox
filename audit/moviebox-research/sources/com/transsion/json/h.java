package com.transsion.json;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends T> f52948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f52949b;

    public h(Class<? extends T> cls) {
        this.f52948a = cls;
    }

    public synchronized T a() throws IllegalAccessException, InstantiationException {
        try {
            if (this.f52949b == null) {
                this.f52949b = this.f52948a.newInstance();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f52949b;
    }
}
