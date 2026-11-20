package com.transsion.api.gateway.dns;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f50730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CopyOnWriteArrayList<d> f50731b = new CopyOnWriteArrayList<>();

    public b(b bVar) {
        this.f50730a = bVar.f50730a;
        Iterator<d> it = bVar.f50731b.iterator();
        while (it.hasNext()) {
            this.f50731b.add(new d(it.next()));
        }
    }

    public b(String str) {
        this.f50730a = str;
    }

    public void a(String str, int i11) {
        d next;
        synchronized (b.class) {
            try {
                Iterator<d> it = this.f50731b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (next.f50734b.equals(str)) {
                            break;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        synchronized (b.class) {
            if (next == null) {
                try {
                    this.f50731b.add(new d(str, i11));
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }
}
