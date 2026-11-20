package m7;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class p implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f70914a = new p();

    @Override // m7.b2
    public int b() {
        return 12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        if (!(type instanceof GenericArrayType)) {
            return (!(type instanceof Class) || type == Object.class || type == Serializable.class || type == Cloneable.class || type == Closeable.class || type == Comparable.class) ? (T) aVar.y(obj) : (T) aVar.k0(type);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        if (genericComponentType instanceof TypeVariable) {
            genericComponentType = ((TypeVariable) genericComponentType).getBounds()[0];
        }
        ArrayList arrayList = new ArrayList();
        aVar.Z(genericComponentType, arrayList);
        T t11 = (T) ((Object[]) Array.newInstance(TypeUtils.i0(genericComponentType), arrayList.size()));
        arrayList.toArray((Object[]) t11);
        return t11;
    }
}
