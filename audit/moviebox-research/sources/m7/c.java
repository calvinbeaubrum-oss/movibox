package m7;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f70877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f70878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b2 f70879e;

    public c(l7.h hVar, Class<?> cls, com.alibaba.fastjson.util.d dVar) {
        super(cls, dVar);
        Type type = dVar.f15537g;
        if (!(type instanceof ParameterizedType)) {
            this.f70877c = Object.class;
            return;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        this.f70877c = type2;
    }

    @Override // m7.l
    public int b() {
        return 14;
    }

    @Override // m7.l
    public void d(l7.a aVar, Object obj, Type type, Map<String, Object> map) {
        l7.b bVar = aVar.f70077g;
        int iK0 = bVar.k0();
        if (iK0 == 8 || (iK0 == 4 && bVar.g0().length() == 0)) {
            if (obj == null) {
                map.put(this.f70900a.f15532a, null);
                return;
            } else {
                i(obj, null);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        l7.g gVarI = aVar.i();
        aVar.w0(gVarI, obj, this.f70900a.f15532a);
        k(aVar, type, arrayList);
        aVar.x0(gVarI);
        if (obj == null) {
            map.put(this.f70900a.f15532a, arrayList);
        } else {
            h(obj, arrayList);
        }
    }

    public final void k(l7.a aVar, Type type, Collection collection) {
        Class cls;
        int i11;
        int i12;
        Type typeB = this.f70877c;
        b2 b2VarP = this.f70879e;
        int i13 = 0;
        if (type instanceof ParameterizedType) {
            if (typeB instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) typeB;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                cls = parameterizedType.getRawType() instanceof Class ? (Class) parameterizedType.getRawType() : null;
                if (cls == null) {
                    i12 = -1;
                    break;
                }
                int length = cls.getTypeParameters().length;
                i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        i12 = -1;
                        break;
                    } else if (cls.getTypeParameters()[i12].getName().equals(typeVariable.getName())) {
                        break;
                    } else {
                        i12++;
                    }
                }
                if (i12 != -1) {
                    typeB = parameterizedType.getActualTypeArguments()[i12];
                    if (!typeB.equals(this.f70877c)) {
                        b2VarP = aVar.h().p(typeB);
                    }
                }
            } else if (typeB instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) typeB;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1) {
                    Type type2 = actualTypeArguments[0];
                    if (type2 instanceof TypeVariable) {
                        TypeVariable typeVariable2 = (TypeVariable) type2;
                        ParameterizedType parameterizedType3 = (ParameterizedType) type;
                        cls = parameterizedType3.getRawType() instanceof Class ? (Class) parameterizedType3.getRawType() : null;
                        if (cls == null) {
                            i11 = -1;
                            break;
                        }
                        int length2 = cls.getTypeParameters().length;
                        i11 = 0;
                        while (true) {
                            if (i11 >= length2) {
                                i11 = -1;
                                break;
                            } else if (cls.getTypeParameters()[i11].getName().equals(typeVariable2.getName())) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                        if (i11 != -1) {
                            actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i11];
                            typeB = com.alibaba.fastjson.g.b(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType()));
                        }
                    }
                }
            }
        } else if ((typeB instanceof TypeVariable) && (type instanceof Class)) {
            Class cls2 = (Class) type;
            TypeVariable typeVariable3 = (TypeVariable) typeB;
            cls2.getTypeParameters();
            int length3 = cls2.getTypeParameters().length;
            for (int i14 = 0; i14 < length3; i14++) {
                TypeVariable typeVariable4 = cls2.getTypeParameters()[i14];
                if (typeVariable4.getName().equals(typeVariable3.getName())) {
                    Type[] bounds = typeVariable4.getBounds();
                    if (bounds.length != 1) {
                        break;
                    }
                    typeB = bounds[0];
                    break;
                }
            }
        }
        l7.b bVar = aVar.f70077g;
        int iK0 = bVar.k0();
        if (iK0 != 14) {
            if (iK0 == 4 && this.f70900a.f15550t) {
                String strG0 = bVar.g0();
                bVar.w();
                new l7.a(strG0).d0(collection);
                return;
            } else {
                if (b2VarP == null) {
                    b2VarP = aVar.h().p(typeB);
                    this.f70879e = b2VarP;
                }
                collection.add(b2VarP.e(aVar, typeB, 0));
                aVar.e(collection);
                return;
            }
        }
        if (b2VarP == null) {
            b2VarP = aVar.h().p(typeB);
            this.f70879e = b2VarP;
            this.f70878d = b2VarP.b();
        }
        b2 b2Var = b2VarP;
        bVar.W(this.f70878d);
        while (true) {
            if (bVar.g(Feature.AllowArbitraryCommas)) {
                while (bVar.k0() == 16) {
                    bVar.w();
                }
            }
            if (bVar.k0() == 15) {
                bVar.W(16);
                return;
            }
            collection.add(b2Var.e(aVar, typeB, Integer.valueOf(i13)));
            aVar.e(collection);
            if (bVar.k0() == 16) {
                bVar.W(this.f70878d);
            }
            i13++;
        }
    }
}
