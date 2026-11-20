package m7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class k3 extends o {
    public k3(l7.h hVar, Class<?> cls) {
        super(hVar, cls, cls);
    }

    @Override // m7.o, m7.b2
    public int b() {
        return 12;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
    @Override // m7.o, m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) throws Throwable {
        Class<?> clsJ;
        Object obj2;
        l7.b bVar = aVar.f70077g;
        o oVar = null;
        if (bVar.k0() == 8) {
            bVar.w();
            return null;
        }
        if (aVar.r() == 2) {
            aVar.A0(0);
        } else if (bVar.k0() != 12) {
            throw new JSONException("syntax error");
        }
        if (type == null || !(type instanceof Class)) {
            clsJ = null;
        } else {
            clsJ = (Class) type;
            if (!Throwable.class.isAssignableFrom(clsJ)) {
                clsJ = null;
            }
        }
        HashMap map = null;
        Throwable th2 = null;
        String strG0 = null;
        StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            String strE0 = bVar.e0(aVar.t());
            if (strE0 == null) {
                if (bVar.k0() == 13) {
                    bVar.W(16);
                    break;
                }
                if (bVar.k0() != 16 || !bVar.g(Feature.AllowArbitraryCommas)) {
                }
            }
            bVar.j(4);
            if (com.alibaba.fastjson.a.DEFAULT_TYPE_KEY.equals(strE0)) {
                if (bVar.k0() != 4) {
                    throw new JSONException("syntax error");
                }
                clsJ = aVar.h().j(bVar.g0(), Throwable.class, bVar.m());
                bVar.W(16);
            } else if ("message".equals(strE0)) {
                if (bVar.k0() == 8) {
                    strG0 = null;
                } else {
                    if (bVar.k0() != 4) {
                        throw new JSONException("syntax error");
                    }
                    strG0 = bVar.g0();
                }
                bVar.w();
            } else if ("cause".equals(strE0)) {
                th2 = (Throwable) e(aVar, null, "cause");
            } else if ("stackTrace".equals(strE0)) {
                stackTraceElementArr = (StackTraceElement[]) aVar.j0(StackTraceElement[].class);
            } else {
                if (map == null) {
                    map = new HashMap();
                }
                map.put(strE0, aVar.x());
            }
            if (bVar.k0() == 13) {
                bVar.W(16);
                break;
            }
        }
        if (clsJ == null) {
            obj2 = (T) new Exception(strG0, th2);
        } else {
            if (!Throwable.class.isAssignableFrom(clsJ)) {
                throw new JSONException("type not match, not Throwable. " + clsJ.getName());
            }
            try {
                obj2 = (T) t(strG0, th2, clsJ);
                if (obj2 == null) {
                    obj2 = (T) new Exception(strG0, th2);
                }
            } catch (Exception e11) {
                throw new JSONException("create instance error", e11);
            }
        }
        if (stackTraceElementArr != null) {
            ((Throwable) obj2).setStackTrace(stackTraceElementArr);
        }
        if (map != null) {
            if (clsJ != null) {
                if (clsJ == this.f70906c) {
                    oVar = this;
                } else {
                    b2 b2VarP = aVar.h().p(clsJ);
                    if (b2VarP instanceof o) {
                        oVar = (o) b2VarP;
                    }
                }
            }
            if (oVar != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    l lVarK = oVar.k(str);
                    if (lVarK != null) {
                        com.alibaba.fastjson.util.d dVar = lVarK.f70900a;
                        if (!dVar.f15536f.isInstance(value)) {
                            value = TypeUtils.h(value, dVar.f15537g, aVar.h());
                        }
                        lVarK.h(obj2, value);
                    }
                }
            }
        }
        return (T) obj2;
    }

    public final Throwable t(String str, Throwable th2, Class<?> cls) throws Exception {
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th2);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(new Object[0]);
        }
        return null;
    }
}
