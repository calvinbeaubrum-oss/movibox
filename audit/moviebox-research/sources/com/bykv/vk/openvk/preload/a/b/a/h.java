package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.o;
import com.bykv.vk.openvk.preload.a.q;
import com.bykv.vk.openvk.preload.a.r;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f25402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.c f25403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.c f25404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f25405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b.b f25406e = com.bykv.vk.openvk.preload.a.b.b.b.a();

    /* JADX INFO: compiled from: source.java */
    public static final class a<T> extends q<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bykv.vk.openvk.preload.a.b.h<T> f25414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, b> f25415b;

        public a(com.bykv.vk.openvk.preload.a.b.h<T> hVar, Map<String, b> map) {
            this.f25414a = hVar;
            this.f25415b = map;
        }

        @Override // com.bykv.vk.openvk.preload.a.q
        public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            T tA = this.f25414a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = this.f25415b.get(aVar.g());
                    if (bVar == null || !bVar.f25418c) {
                        aVar.n();
                    } else {
                        bVar.a(aVar, tA);
                    }
                }
                aVar.d();
                return tA;
            } catch (IllegalAccessException e11) {
                throw new AssertionError(e11);
            } catch (IllegalStateException e12) {
                throw new o(e12);
            }
        }

        @Override // com.bykv.vk.openvk.preload.a.q
        public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t11) throws IOException {
            if (t11 == null) {
                cVar.h();
                return;
            }
            cVar.f();
            try {
                for (b bVar : this.f25415b.values()) {
                    if (bVar.a(t11)) {
                        cVar.a(bVar.f25416a);
                        bVar.a(cVar, t11);
                    }
                }
                cVar.g();
            } catch (IllegalAccessException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f25416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f25417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f25418c;

        public b(String str, boolean z11, boolean z12) {
            this.f25416a = str;
            this.f25417b = z11;
            this.f25418c = z12;
        }

        public abstract void a(com.bykv.vk.openvk.preload.a.d.a aVar, Object obj) throws IllegalAccessException, IOException;

        public abstract void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IllegalAccessException, IOException;

        public abstract boolean a(Object obj) throws IllegalAccessException, IOException;
    }

    public h(com.bykv.vk.openvk.preload.a.b.b bVar, com.bykv.vk.openvk.preload.a.c cVar, com.bykv.vk.openvk.preload.a.b.c cVar2, d dVar) {
        this.f25402a = bVar;
        this.f25403b = cVar;
        this.f25404c = cVar2;
        this.f25405d = dVar;
    }

    private List<String> a(Field field) {
        com.bykv.vk.openvk.preload.a.a.b bVar = (com.bykv.vk.openvk.preload.a.a.b) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.b.class);
        if (bVar == null) {
            return Collections.singletonList(this.f25403b.a(field));
        }
        String strA = bVar.a();
        String[] strArrB = bVar.b();
        if (strArrB.length == 0) {
            return Collections.singletonList(strA);
        }
        ArrayList arrayList = new ArrayList(strArrB.length + 1);
        arrayList.add(strA);
        for (String str : strArrB) {
            arrayList.add(str);
        }
        return arrayList;
    }

    private Map<String, b> a(final com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<?> aVar, Class<?> cls) {
        int i11;
        int i12;
        Field[] fieldArr;
        Class<?> cls2;
        Type type;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type typeB = aVar.b();
        com.bykv.vk.openvk.preload.a.c.a<?> aVarA = aVar;
        Class<?> clsA = cls;
        while (clsA != Object.class) {
            Field[] declaredFields = clsA.getDeclaredFields();
            int length = declaredFields.length;
            boolean z11 = false;
            int i13 = 0;
            while (i13 < length) {
                final Field field = declaredFields[i13];
                boolean zA = this.a(field, true);
                boolean zA2 = this.a(field, z11);
                if (zA || zA2) {
                    this.f25406e.a(field);
                    Type typeA = com.bykv.vk.openvk.preload.a.b.a.a(aVarA.b(), clsA, field.getGenericType());
                    List<String> listA = this.a(field);
                    int size = listA.size();
                    b bVar = null;
                    int i14 = 0;
                    while (i14 < size) {
                        Type type2 = typeB;
                        String str = listA.get(i14);
                        boolean z12 = i14 != 0 ? false : zA;
                        final com.bykv.vk.openvk.preload.a.c.a<?> aVarA2 = com.bykv.vk.openvk.preload.a.c.a.a(typeA);
                        Class<? super Object> clsA2 = aVarA2.a();
                        boolean z13 = (clsA2 instanceof Class) && clsA2.isPrimitive();
                        com.bykv.vk.openvk.preload.a.a.a aVar2 = (com.bykv.vk.openvk.preload.a.a.a) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.a.class);
                        q<?> qVarA = aVar2 != null ? d.a(this.f25402a, dVar, aVarA2, aVar2) : null;
                        boolean z14 = qVarA != null;
                        if (qVarA == null) {
                            qVarA = dVar.a((com.bykv.vk.openvk.preload.a.c.a) aVarA2);
                        }
                        final q<?> qVar = qVarA;
                        int i15 = i14;
                        int i16 = size;
                        List<String> list = listA;
                        Field field2 = field;
                        int i17 = i13;
                        final boolean z15 = z14;
                        int i18 = length;
                        Field[] fieldArr2 = declaredFields;
                        Class<?> cls3 = clsA;
                        final boolean z16 = z13;
                        b bVar2 = (b) linkedHashMap.put(str, new b(str, z12, zA2) { // from class: com.bykv.vk.openvk.preload.a.b.a.h.1
                            @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                            public final void a(com.bykv.vk.openvk.preload.a.d.a aVar3, Object obj) throws IllegalAccessException, IOException {
                                Object objA = qVar.a(aVar3);
                                if (objA == null && z16) {
                                    return;
                                }
                                field.set(obj, objA);
                            }

                            @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                            public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IllegalAccessException, IOException {
                                (z15 ? qVar : new l(dVar, qVar, aVarA2.b())).a(cVar, field.get(obj));
                            }

                            @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                            public final boolean a(Object obj) throws IllegalAccessException, IOException {
                                return this.f25417b && field.get(obj) != obj;
                            }
                        });
                        if (bVar == null) {
                            bVar = bVar2;
                        }
                        i14 = i15 + 1;
                        this = this;
                        clsA = cls3;
                        zA = z12;
                        typeB = type2;
                        length = i18;
                        size = i16;
                        listA = list;
                        field = field2;
                        i13 = i17;
                        declaredFields = fieldArr2;
                    }
                    i11 = i13;
                    i12 = length;
                    fieldArr = declaredFields;
                    cls2 = clsA;
                    type = typeB;
                    if (bVar != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + bVar.f25416a);
                    }
                } else {
                    i11 = i13;
                    i12 = length;
                    fieldArr = declaredFields;
                    cls2 = clsA;
                    type = typeB;
                }
                i13 = i11 + 1;
                this = this;
                aVarA = aVarA;
                clsA = cls2;
                typeB = type;
                length = i12;
                declaredFields = fieldArr;
                z11 = false;
            }
            Class<?> cls4 = clsA;
            aVarA = com.bykv.vk.openvk.preload.a.c.a.a(com.bykv.vk.openvk.preload.a.b.a.a(aVarA.b(), cls4, cls4.getGenericSuperclass()));
            clsA = aVarA.a();
        }
        return linkedHashMap;
    }

    private boolean a(Field field, boolean z11) {
        com.bykv.vk.openvk.preload.a.b.c cVar = this.f25404c;
        return (cVar.a(field.getType(), z11) || cVar.a(field, z11)) ? false : true;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final <T> q<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        Class<? super T> clsA = aVar.a();
        if (Object.class.isAssignableFrom(clsA)) {
            return new a(this.f25402a.a(aVar), a(dVar, aVar, clsA));
        }
        return null;
    }
}
