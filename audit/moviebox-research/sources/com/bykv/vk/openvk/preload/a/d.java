package com.bykv.vk.openvk.preload.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bykv.vk.openvk.preload.a.c.a<?> f25556a = com.bykv.vk.openvk.preload.a.c.a.a(Object.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadLocal<Map<com.bykv.vk.openvk.preload.a.c.a<?>, a<?>>> f25557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<com.bykv.vk.openvk.preload.a.c.a<?>, q<?>> f25558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f25559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.a.d f25560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<r> f25561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.a.b.c f25562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f25563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<Type, com.bykv.vk.openvk.preload.geckox.a.a.c<?>> f25564i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f25565j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f25566k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f25567l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f25568m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f25569n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f25570o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f25571p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f25572q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f25573r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f25574s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private p f25575t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private List<r> f25576u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private List<r> f25577v;

    /* JADX INFO: compiled from: source.java */
    public static class a<T> extends q<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private q<T> f25582a;

        @Override // com.bykv.vk.openvk.preload.a.q
        public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            q<T> qVar = this.f25582a;
            if (qVar != null) {
                return qVar.a(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // com.bykv.vk.openvk.preload.a.q
        public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t11) throws IOException {
            q<T> qVar = this.f25582a;
            if (qVar == null) {
                throw new IllegalStateException();
            }
            qVar.a(cVar, t11);
        }

        public final void a(q<T> qVar) {
            if (this.f25582a != null) {
                throw new AssertionError();
            }
            this.f25582a = qVar;
        }
    }

    public d() {
        this(com.bykv.vk.openvk.preload.a.b.c.f25508a, b.f25365a, Collections.emptyMap(), true, p.f25638a, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    public d(com.bykv.vk.openvk.preload.a.b.c cVar, c cVar2, Map<Type, com.bykv.vk.openvk.preload.geckox.a.a.c<?>> map, boolean z11, p pVar, int i11, int i12, List<r> list, List<r> list2, List<r> list3) {
        this.f25557b = new ThreadLocal<>();
        this.f25558c = new ConcurrentHashMap();
        this.f25562g = cVar;
        this.f25563h = cVar2;
        this.f25564i = map;
        com.bykv.vk.openvk.preload.a.b.b bVar = new com.bykv.vk.openvk.preload.a.b.b(map);
        this.f25559d = bVar;
        this.f25565j = false;
        this.f25566k = false;
        this.f25567l = false;
        this.f25568m = z11;
        this.f25569n = false;
        this.f25570o = false;
        this.f25571p = false;
        this.f25575t = pVar;
        this.f25572q = null;
        this.f25573r = i11;
        this.f25574s = i12;
        this.f25576u = list;
        this.f25577v = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.B);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.g.f25399a);
        arrayList.add(cVar);
        arrayList.addAll(list3);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25449p);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25440g);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25437d);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25438e);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25439f);
        final q<Number> qVar = pVar == p.f25638a ? com.bykv.vk.openvk.preload.a.b.a.m.f25444k : new q<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.3
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    return Long.valueOf(aVar.l());
                }
                aVar.j();
                return null;
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                Number number2 = number;
                if (number2 == null) {
                    cVar3.h();
                } else {
                    cVar3.b(number2.toString());
                }
            }
        };
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Long.TYPE, Long.class, qVar));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Double.TYPE, Double.class, new q<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.1
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    return Double.valueOf(aVar.k());
                }
                aVar.j();
                return null;
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                Number number2 = number;
                if (number2 == null) {
                    cVar3.h();
                } else {
                    d.a(number2.doubleValue());
                    cVar3.a(number2);
                }
            }
        }));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Float.TYPE, Float.class, new q<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.2
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    return Float.valueOf((float) aVar.k());
                }
                aVar.j();
                return null;
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                Number number2 = number;
                if (number2 == null) {
                    cVar3.h();
                } else {
                    d.a(number2.floatValue());
                    cVar3.a(number2);
                }
            }
        }));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25445l);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25441h);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25442i);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(AtomicLong.class, new q<AtomicLong>() { // from class: com.bykv.vk.openvk.preload.a.d.4
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ AtomicLong a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return new AtomicLong(((Number) qVar.a(aVar)).longValue());
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, AtomicLong atomicLong) throws IOException {
                qVar.a(cVar3, Long.valueOf(atomicLong.get()));
            }
        }.a()));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(AtomicLongArray.class, new q<AtomicLongArray>() { // from class: com.bykv.vk.openvk.preload.a.d.5
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ AtomicLongArray a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                ArrayList arrayList2 = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList2.add(Long.valueOf(((Number) qVar.a(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList2.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i13 = 0; i13 < size; i13++) {
                    atomicLongArray.set(i13, ((Long) arrayList2.get(i13)).longValue());
                }
                return atomicLongArray;
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, AtomicLongArray atomicLongArray) throws IOException {
                AtomicLongArray atomicLongArray2 = atomicLongArray;
                cVar3.d();
                int length = atomicLongArray2.length();
                for (int i13 = 0; i13 < length; i13++) {
                    qVar.a(cVar3, Long.valueOf(atomicLongArray2.get(i13)));
                }
                cVar3.e();
            }
        }.a()));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25443j);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25446m);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25450q);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25451r);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(BigDecimal.class, com.bykv.vk.openvk.preload.a.b.a.m.f25447n));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(BigInteger.class, com.bykv.vk.openvk.preload.a.b.a.m.f25448o));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25452s);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25453t);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25455v);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25456w);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25459z);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25454u);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25435b);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.c.f25385a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25458y);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.j.f25421a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.i.f25419a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25457x);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.a.f25378a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f25434a);
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.b(bVar));
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.f(bVar));
        com.bykv.vk.openvk.preload.a.b.a.d dVar = new com.bykv.vk.openvk.preload.a.b.a.d(bVar);
        this.f25560e = dVar;
        arrayList.add(dVar);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.C);
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.h(bVar, cVar2, cVar, dVar));
        this.f25561f = Collections.unmodifiableList(arrayList);
    }

    private static com.bykv.vk.openvk.preload.a.d.c a(Writer writer) throws IOException {
        com.bykv.vk.openvk.preload.a.d.c cVar = new com.bykv.vk.openvk.preload.a.d.c(writer);
        cVar.c(false);
        return cVar;
    }

    private <T> T a(com.bykv.vk.openvk.preload.a.d.a aVar, Type type) throws i, o {
        boolean zQ = aVar.q();
        boolean z11 = true;
        aVar.a(true);
        try {
            try {
                try {
                    aVar.f();
                    z11 = false;
                    T tA = a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(type)).a(aVar);
                    aVar.a(zQ);
                    return tA;
                } catch (EOFException e11) {
                    if (!z11) {
                        throw new o(e11);
                    }
                    aVar.a(zQ);
                    return null;
                } catch (IllegalStateException e12) {
                    throw new o(e12);
                }
            } catch (IOException e13) {
                throw new o(e13);
            } catch (AssertionError e14) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e14.getMessage());
                assertionError.initCause(e14);
                throw assertionError;
            }
        } catch (Throwable th2) {
            aVar.a(zQ);
            throw th2;
        }
    }

    public static void a(double d11) {
        if (Double.isNaN(d11) || Double.isInfinite(d11)) {
            throw new IllegalArgumentException(d11 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final <T> q<T> a(com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        boolean z11;
        q<T> qVar = (q) this.f25558c.get(aVar == null ? f25556a : aVar);
        if (qVar != null) {
            return qVar;
        }
        Map<com.bykv.vk.openvk.preload.a.c.a<?>, a<?>> map = this.f25557b.get();
        if (map == null) {
            map = new HashMap<>();
            this.f25557b.set(map);
            z11 = true;
        } else {
            z11 = false;
        }
        a<?> aVar2 = map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a<?> aVar3 = new a<>();
            map.put(aVar, aVar3);
            Iterator<r> it = this.f25561f.iterator();
            while (it.hasNext()) {
                q<T> qVarA = it.next().a(this, aVar);
                if (qVarA != null) {
                    aVar3.a((q<?>) qVarA);
                    this.f25558c.put(aVar, qVarA);
                    map.remove(aVar);
                    if (z11) {
                        this.f25557b.remove();
                    }
                    return qVarA;
                }
            }
            throw new IllegalArgumentException("GSON (pangle-v3200) cannot handle ".concat(String.valueOf(aVar)));
        } catch (Throwable th2) {
            map.remove(aVar);
            if (z11) {
                this.f25557b.remove();
            }
            throw th2;
        }
    }

    public final <T> q<T> a(r rVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        if (!this.f25561f.contains(rVar)) {
            rVar = this.f25560e;
        }
        boolean z11 = false;
        for (r rVar2 : this.f25561f) {
            if (z11) {
                q<T> qVarA = rVar2.a(this, aVar);
                if (qVarA != null) {
                    return qVarA;
                }
            } else if (rVar2 == rVar) {
                z11 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(aVar)));
    }

    public final <T> q<T> a(Class<T> cls) {
        return a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a((Class) cls));
    }

    public final <T> T a(Reader reader, Type type) throws i, o {
        com.bykv.vk.openvk.preload.a.d.a aVar = new com.bykv.vk.openvk.preload.a.d.a(reader);
        aVar.a(false);
        T t11 = (T) a(aVar, type);
        if (t11 != null) {
            try {
                if (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.END_DOCUMENT) {
                    throw new i("JSON document was not fully consumed.");
                }
            } catch (com.bykv.vk.openvk.preload.a.d.d e11) {
                throw new o(e11);
            } catch (IOException e12) {
                throw new i(e12);
            }
        }
        return t11;
    }

    public final String a(Object obj) {
        if (obj == null) {
            j jVar = j.f25635a;
            StringWriter stringWriter = new StringWriter();
            try {
                com.bykv.vk.openvk.preload.a.d.c cVarA = a((Writer) stringWriter);
                boolean zA = cVarA.a();
                cVarA.a(true);
                boolean zB = cVarA.b();
                cVarA.b(this.f25568m);
                boolean zC = cVarA.c();
                cVarA.c(false);
                try {
                    try {
                        com.bykv.vk.openvk.preload.falconx.a.a.a(jVar, cVarA);
                        cVarA.a(zA);
                        cVarA.b(zB);
                        cVarA.c(zC);
                        return stringWriter.toString();
                    } catch (Throwable th2) {
                        cVarA.a(zA);
                        cVarA.b(zB);
                        cVarA.c(zC);
                        throw th2;
                    }
                } catch (IOException e11) {
                    throw new i(e11);
                } catch (AssertionError e12) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e12.getMessage());
                    assertionError.initCause(e12);
                    throw assertionError;
                }
            } catch (IOException e13) {
                throw new i(e13);
            }
        }
        Class<?> cls = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            com.bykv.vk.openvk.preload.a.d.c cVarA2 = a((Writer) stringWriter2);
            q qVarA = a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a((Type) cls));
            boolean zA2 = cVarA2.a();
            cVarA2.a(true);
            boolean zB2 = cVarA2.b();
            cVarA2.b(this.f25568m);
            boolean zC2 = cVarA2.c();
            cVarA2.c(false);
            try {
                try {
                    qVarA.a(cVarA2, obj);
                    cVarA2.a(zA2);
                    cVarA2.b(zB2);
                    cVarA2.c(zC2);
                    return stringWriter2.toString();
                } catch (IOException e14) {
                    throw new i(e14);
                } catch (AssertionError e15) {
                    AssertionError assertionError2 = new AssertionError("AssertionError (GSON pangle-v3200): " + e15.getMessage());
                    assertionError2.initCause(e15);
                    throw assertionError2;
                }
            } catch (Throwable th3) {
                cVarA2.a(zA2);
                cVarA2.b(zB2);
                cVarA2.c(zC2);
                throw th3;
            }
        } catch (IOException e16) {
            throw new i(e16);
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.f25561f + ",instanceCreators:" + this.f25559d + "}";
    }
}
