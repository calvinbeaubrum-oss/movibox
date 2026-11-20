package com.cloud.tmc.kernel.coreimpl.eventcenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uc.b;
import uc.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<c>> f31185a = new HashMap(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0341a f31186b;

    /* JADX INFO: renamed from: com.cloud.tmc.kernel.coreimpl.eventcenter.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0341a {
        void onDestroy();
    }

    public a(InterfaceC0341a interfaceC0341a) {
        this.f31186b = interfaceC0341a;
    }

    @Override // uc.b
    public void a(String str) {
        if (this.f31185a.get(str) == null) {
            return;
        }
        this.f31185a.get(str).clear();
    }

    @Override // uc.b
    public void b(String str, c cVar) {
        if (this.f31185a.get(str) == null) {
            this.f31185a.put(str, new ArrayList());
        }
        this.f31185a.get(str).add(cVar);
    }

    @Override // uc.b
    public void c(String str, c cVar) {
        if (this.f31185a.get(str) == null) {
            return;
        }
        this.f31185a.get(str).remove(cVar);
    }

    @Override // uc.b
    public void d(String str, uc.a aVar) {
        List<c> list;
        if (!this.f31185a.containsKey(str) || (list = this.f31185a.get(str)) == null) {
            return;
        }
        for (int i11 = 0; i11 < list.size() && !list.get(i11).O(aVar); i11++) {
        }
    }

    @Override // uc.b
    public void destroy() {
        this.f31185a.clear();
        InterfaceC0341a interfaceC0341a = this.f31186b;
        if (interfaceC0341a != null) {
            interfaceC0341a.onDestroy();
        }
    }

    @Override // uc.b
    public boolean e(String str) {
        return this.f31185a.containsKey(str);
    }
}
