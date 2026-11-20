package com.bykv.vk.openvk.preload.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l<IN, OUT> extends d<IN, OUT> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, a> f25669d;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<h> f25670a = new ArrayList();

        public final a a(h hVar) {
            this.f25670a.add(hVar);
            return this;
        }

        public final a a(List<h> list) {
            this.f25670a.addAll(list);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, a> f25671a = new HashMap();

        public final h a(Class<? extends l> cls) {
            return h.a.a().a(cls).a(this.f25671a).a((com.bykv.vk.openvk.preload.b.b.a) null).b();
        }

        public final a a(String str) {
            if (this.f25671a.containsKey(str)) {
                throw new IllegalArgumentException("duplicated branch name");
            }
            a aVar = new a();
            this.f25671a.put(str, aVar);
            return aVar;
        }
    }

    public static boolean a(List<h> list) {
        return !list.isEmpty() && list.get(list.size() - 1).f25657a == f.class;
    }

    public final Map<String, a> a() {
        return this.f25669d;
    }

    @Override // com.bykv.vk.openvk.preload.b.d
    public final void a(Object... objArr) {
        Object obj;
        super.a(objArr);
        if (objArr == null || objArr.length != 1 || (obj = objArr[0]) == null) {
            throw new IllegalStateException("args error");
        }
        try {
            this.f25669d = (Map) obj;
        } catch (ClassCastException e11) {
            throw new IllegalArgumentException(e11);
        }
    }
}
