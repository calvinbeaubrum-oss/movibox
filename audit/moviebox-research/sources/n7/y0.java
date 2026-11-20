package n7;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import m7.b2;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class y0 implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f71766a = new y0();

    @Override // m7.b2
    public int b() {
        return 14;
    }

    @Override // n7.z0
    public final void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        Object[] objArr = (Object[]) obj;
        if (obj == null) {
            j1Var.i0(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int length = objArr.length;
        int i12 = length - 1;
        if (i12 == -1) {
            j1Var.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        e1 e1Var = o0Var.f71708r;
        o0Var.D(e1Var, obj, obj2, 0);
        try {
            j1Var.append('[');
            if (j1Var.k(SerializerFeature.PrettyFormat)) {
                o0Var.z();
                o0Var.C();
                for (int i13 = 0; i13 < length; i13++) {
                    if (i13 != 0) {
                        j1Var.write(44);
                        o0Var.C();
                    }
                    o0Var.L(objArr[i13], Integer.valueOf(i13));
                }
                o0Var.s();
                o0Var.C();
                j1Var.write(93);
                return;
            }
            Class<?> cls = null;
            z0 z0VarX = null;
            for (int i14 = 0; i14 < i12; i14++) {
                Object obj3 = objArr[i14];
                if (obj3 == null) {
                    j1Var.append("null,");
                } else {
                    if (o0Var.r(obj3)) {
                        o0Var.K(obj3);
                    } else {
                        Class<?> cls2 = obj3.getClass();
                        if (cls2 == cls) {
                            z0VarX.d(o0Var, obj3, Integer.valueOf(i14), null, 0);
                        } else {
                            z0VarX = o0Var.x(cls2);
                            z0VarX.d(o0Var, obj3, Integer.valueOf(i14), null, 0);
                            cls = cls2;
                        }
                    }
                    j1Var.append(',');
                }
            }
            Object obj4 = objArr[i12];
            if (obj4 == null) {
                j1Var.append("null]");
            } else {
                if (o0Var.r(obj4)) {
                    o0Var.K(obj4);
                } else {
                    o0Var.L(obj4, Integer.valueOf(i12));
                }
                j1Var.append(']');
            }
        } finally {
            o0Var.f71708r = e1Var;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, byte[]] */
    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        Type componentType;
        Class clsQ;
        l7.b bVar = aVar.f70077g;
        int iK0 = bVar.k0();
        Type type2 = null;
        if (iK0 == 8) {
            bVar.W(16);
            return null;
        }
        if (iK0 == 4 || iK0 == 26) {
            ?? r11 = (T) bVar.d0();
            bVar.W(16);
            if (r11.length != 0 || type == byte[].class) {
                return r11;
            }
            return null;
        }
        if (type instanceof GenericArrayType) {
            componentType = ((GenericArrayType) type).getGenericComponentType();
            if (componentType instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) componentType;
                Type type3 = aVar.i().f70121e;
                if (type3 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type3;
                    Type rawType = parameterizedType.getRawType();
                    if (rawType instanceof Class) {
                        TypeVariable<Class<T>>[] typeParameters = ((Class) rawType).getTypeParameters();
                        for (int i11 = 0; i11 < typeParameters.length; i11++) {
                            if (typeParameters[i11].getName().equals(typeVariable.getName())) {
                                type2 = parameterizedType.getActualTypeArguments()[i11];
                            }
                        }
                    }
                    clsQ = type2 instanceof Class ? (Class) type2 : Object.class;
                } else {
                    clsQ = TypeUtils.Q(typeVariable.getBounds()[0]);
                }
            } else {
                clsQ = TypeUtils.Q(componentType);
            }
        } else {
            componentType = ((Class) type).getComponentType();
            clsQ = componentType;
        }
        JSONArray jSONArray = new JSONArray();
        aVar.b0(componentType, jSONArray, obj);
        return (T) f(aVar, clsQ, jSONArray);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    public final <T> T f(l7.a aVar, Class<?> cls, JSONArray jSONArray) {
        Object objF;
        if (jSONArray == null) {
            return null;
        }
        int size = jSONArray.size();
        T t11 = (T) Array.newInstance(cls, size);
        for (int i11 = 0; i11 < size; i11++) {
            Object objF2 = jSONArray.get(i11);
            if (objF2 == jSONArray) {
                Array.set(t11, i11, t11);
            } else if (cls.isArray()) {
                if (!cls.isInstance(objF2)) {
                    objF2 = f(aVar, cls, (JSONArray) objF2);
                }
                Array.set(t11, i11, objF2);
            } else {
                if (objF2 instanceof JSONArray) {
                    JSONArray jSONArray2 = (JSONArray) objF2;
                    int size2 = jSONArray2.size();
                    boolean z11 = false;
                    for (int i12 = 0; i12 < size2; i12++) {
                        if (jSONArray2.get(i12) == jSONArray) {
                            jSONArray2.set(i11, t11);
                            z11 = true;
                        }
                    }
                    if (z11) {
                        objF = jSONArray2.toArray();
                    } else {
                        objF = null;
                    }
                } else {
                    objF = null;
                }
                if (objF == null) {
                    objF = TypeUtils.f(objF2, cls, aVar.h());
                }
                Array.set(t11, i11, objF);
            }
        }
        jSONArray.setRelatedArray(t11);
        jSONArray.setComponentType(cls);
        return t11;
    }
}
