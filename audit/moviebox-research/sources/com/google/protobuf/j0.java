package com.google.protobuf;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class j0 implements i0 {
    public static <K, V> int i(int i11, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        h0 h0Var = (h0) obj2;
        int iA = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (Map.Entry<K, V> entry : mapFieldLite.entrySet()) {
            iA += h0Var.a(i11, entry.getKey(), entry.getValue());
        }
        return iA;
    }

    public static <K, V> MapFieldLite<K, V> j(Object obj, Object obj2) {
        MapFieldLite<K, V> mapFieldLiteMutableCopy = (MapFieldLite) obj;
        MapFieldLite<K, V> mapFieldLite = (MapFieldLite) obj2;
        if (!mapFieldLite.isEmpty()) {
            if (!mapFieldLiteMutableCopy.isMutable()) {
                mapFieldLiteMutableCopy = mapFieldLiteMutableCopy.mutableCopy();
            }
            mapFieldLiteMutableCopy.mergeFrom(mapFieldLite);
        }
        return mapFieldLiteMutableCopy;
    }

    @Override // com.google.protobuf.i0
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // com.google.protobuf.i0
    public h0.a<?, ?> b(Object obj) {
        return ((h0) obj).c();
    }

    @Override // com.google.protobuf.i0
    public Map<?, ?> c(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // com.google.protobuf.i0
    public Object d(Object obj) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    @Override // com.google.protobuf.i0
    public Map<?, ?> e(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // com.google.protobuf.i0
    public Object f(Object obj) {
        ((MapFieldLite) obj).makeImmutable();
        return obj;
    }

    @Override // com.google.protobuf.i0
    public int g(int i11, Object obj, Object obj2) {
        return i(i11, obj, obj2);
    }

    @Override // com.google.protobuf.i0
    public boolean h(Object obj) {
        return !((MapFieldLite) obj).isMutable();
    }
}
