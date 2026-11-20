package m7;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class z1 extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static z1 f70936a = new z1();

    public static Object j(l7.a aVar, Map<Object, Object> map, Type type, Type type2, Object obj) {
        Object objE;
        l7.b bVar = aVar.f70077g;
        if (bVar.k0() != 12 && bVar.k0() != 16) {
            throw new JSONException("syntax error, expect {, actual " + bVar.q());
        }
        b2 b2VarP = aVar.h().p(type);
        b2 b2VarP2 = aVar.h().p(type2);
        bVar.W(b2VarP.b());
        l7.g gVarI = aVar.i();
        while (bVar.k0() != 13) {
            try {
                Object obj2 = null;
                if (bVar.k0() == 4 && bVar.r() && !bVar.g(Feature.DisableSpecialKeyDetect)) {
                    bVar.j(4);
                    if (bVar.k0() != 4) {
                        throw new JSONException("illegal ref, " + l7.f.a(bVar.k0()));
                    }
                    String strG0 = bVar.g0();
                    if ("..".equals(strG0)) {
                        obj2 = gVarI.f70118b.f70117a;
                    } else if ("$".equals(strG0)) {
                        l7.g gVar = gVarI;
                        while (true) {
                            l7.g gVar2 = gVar.f70118b;
                            if (gVar2 == null) {
                                break;
                            }
                            gVar = gVar2;
                        }
                        obj2 = gVar.f70117a;
                    } else {
                        aVar.d(new l7.a.C0751a(gVarI, strG0));
                        aVar.A0(1);
                    }
                    bVar.W(13);
                    if (bVar.k0() != 13) {
                        throw new JSONException("illegal ref");
                    }
                    bVar.W(16);
                    aVar.x0(gVarI);
                    return obj2;
                }
                if (map.size() == 0 && bVar.k0() == 4 && com.alibaba.fastjson.a.DEFAULT_TYPE_KEY.equals(bVar.g0()) && !bVar.g(Feature.DisableSpecialKeyDetect)) {
                    bVar.j(4);
                    bVar.W(16);
                    if (bVar.k0() == 13) {
                        bVar.w();
                        aVar.x0(gVarI);
                        return map;
                    }
                    bVar.W(b2VarP.b());
                }
                if (bVar.k0() == 4 && (b2VarP instanceof o)) {
                    String strG1 = bVar.g0();
                    bVar.w();
                    l7.a aVar2 = new l7.a(strG1, aVar.h(), aVar.p().m());
                    aVar2.y0(aVar.j());
                    objE = b2VarP.e(aVar2, type, null);
                } else {
                    objE = b2VarP.e(aVar, type, null);
                }
                if (bVar.k0() != 17) {
                    throw new JSONException("syntax error, expect :, actual " + bVar.k0());
                }
                bVar.W(b2VarP2.b());
                Object objE2 = b2VarP2.e(aVar, type2, objE);
                aVar.g(map, objE);
                map.put(objE, objE2);
                if (bVar.k0() == 16) {
                    bVar.W(b2VarP.b());
                }
            } catch (Throwable th2) {
                aVar.x0(gVarI);
                throw th2;
            }
        }
        bVar.W(16);
        aVar.x0(gVarI);
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:131:0x0220 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x0227 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x01ec A[Catch: all -> 0x00c3, TRY_ENTER, TryCatch #0 {all -> 0x00c3, blocks: (B:25:0x00a5, B:29:0x00b8, B:35:0x00d0, B:60:0x0165, B:62:0x0177, B:64:0x017f, B:66:0x0185, B:70:0x019c, B:73:0x01a7, B:76:0x01ae, B:77:0x01b6, B:79:0x01be, B:81:0x01c7, B:84:0x01ce, B:86:0x01db, B:88:0x01df, B:89:0x01e2, B:92:0x01ec, B:94:0x01f1, B:95:0x01f4, B:97:0x01fc, B:99:0x0205, B:105:0x0220, B:98:0x0201, B:38:0x00e3, B:39:0x00fb, B:42:0x0100, B:47:0x0113, B:49:0x011b, B:52:0x012d, B:53:0x0145, B:54:0x0146, B:55:0x014b, B:56:0x014c, B:58:0x0154, B:111:0x022f, B:112:0x024f, B:113:0x0250, B:114:0x0255), top: B:118:0x00a5 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01f1 A[Catch: all -> 0x00c3, TryCatch #0 {all -> 0x00c3, blocks: (B:25:0x00a5, B:29:0x00b8, B:35:0x00d0, B:60:0x0165, B:62:0x0177, B:64:0x017f, B:66:0x0185, B:70:0x019c, B:73:0x01a7, B:76:0x01ae, B:77:0x01b6, B:79:0x01be, B:81:0x01c7, B:84:0x01ce, B:86:0x01db, B:88:0x01df, B:89:0x01e2, B:92:0x01ec, B:94:0x01f1, B:95:0x01f4, B:97:0x01fc, B:99:0x0205, B:105:0x0220, B:98:0x0201, B:38:0x00e3, B:39:0x00fb, B:42:0x0100, B:47:0x0113, B:49:0x011b, B:52:0x012d, B:53:0x0145, B:54:0x0146, B:55:0x014b, B:56:0x014c, B:58:0x0154, B:111:0x022f, B:112:0x024f, B:113:0x0250, B:114:0x0255), top: B:118:0x00a5 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x01fc A[Catch: all -> 0x00c3, TryCatch #0 {all -> 0x00c3, blocks: (B:25:0x00a5, B:29:0x00b8, B:35:0x00d0, B:60:0x0165, B:62:0x0177, B:64:0x017f, B:66:0x0185, B:70:0x019c, B:73:0x01a7, B:76:0x01ae, B:77:0x01b6, B:79:0x01be, B:81:0x01c7, B:84:0x01ce, B:86:0x01db, B:88:0x01df, B:89:0x01e2, B:92:0x01ec, B:94:0x01f1, B:95:0x01f4, B:97:0x01fc, B:99:0x0205, B:105:0x0220, B:98:0x0201, B:38:0x00e3, B:39:0x00fb, B:42:0x0100, B:47:0x0113, B:49:0x011b, B:52:0x012d, B:53:0x0145, B:54:0x0146, B:55:0x014b, B:56:0x014c, B:58:0x0154, B:111:0x022f, B:112:0x024f, B:113:0x0250, B:114:0x0255), top: B:118:0x00a5 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0201 A[Catch: all -> 0x00c3, TryCatch #0 {all -> 0x00c3, blocks: (B:25:0x00a5, B:29:0x00b8, B:35:0x00d0, B:60:0x0165, B:62:0x0177, B:64:0x017f, B:66:0x0185, B:70:0x019c, B:73:0x01a7, B:76:0x01ae, B:77:0x01b6, B:79:0x01be, B:81:0x01c7, B:84:0x01ce, B:86:0x01db, B:88:0x01df, B:89:0x01e2, B:92:0x01ec, B:94:0x01f1, B:95:0x01f4, B:97:0x01fc, B:99:0x0205, B:105:0x0220, B:98:0x0201, B:38:0x00e3, B:39:0x00fb, B:42:0x0100, B:47:0x0113, B:49:0x011b, B:52:0x012d, B:53:0x0145, B:54:0x0146, B:55:0x014b, B:56:0x014c, B:58:0x0154, B:111:0x022f, B:112:0x024f, B:113:0x0250, B:114:0x0255), top: B:118:0x00a5 }] */
    public static Map k(l7.a aVar, Map<String, Object> map, Type type, Object obj, int i11) {
        String strY;
        Object objL0;
        int iK0;
        l7.b bVar = aVar.f70077g;
        int iK1 = bVar.k0();
        int i12 = 0;
        if (iK1 != 12) {
            if (iK1 == 4) {
                String strG0 = bVar.g0();
                if (strG0.length() == 0 || strG0.equals("null")) {
                    return null;
                }
            }
            String str = "syntax error, expect {, actual " + bVar.q();
            if (obj instanceof String) {
                str = (str + ", fieldName ") + obj;
            }
            String str2 = (str + ", ") + bVar.c();
            if (iK1 != 4) {
                JSONArray jSONArray = new JSONArray();
                aVar.e0(jSONArray, obj);
                if (jSONArray.size() == 1) {
                    Object obj2 = jSONArray.get(0);
                    if (obj2 instanceof JSONObject) {
                        return (JSONObject) obj2;
                    }
                }
            }
            throw new JSONException(str2);
        }
        l7.g gVarI = aVar.i();
        while (true) {
            try {
                bVar.p0();
                char cA = bVar.a();
                if (bVar.g(Feature.AllowArbitraryCommas)) {
                    while (cA == ',') {
                        bVar.next();
                        bVar.p0();
                        cA = bVar.a();
                    }
                }
                if (cA == '\"') {
                    strY = bVar.l(aVar.t(), '\"');
                    bVar.p0();
                    if (bVar.a() != ':') {
                        throw new JSONException("expect ':' at " + bVar.b());
                    }
                } else {
                    if (cA == '}') {
                        bVar.next();
                        bVar.q0();
                        bVar.W(16);
                        aVar.x0(gVarI);
                        return map;
                    }
                    if (cA == '\'') {
                        if (!bVar.g(Feature.AllowSingleQuotes)) {
                            throw new JSONException("syntax error");
                        }
                        strY = bVar.l(aVar.t(), '\'');
                        bVar.p0();
                        if (bVar.a() != ':') {
                            throw new JSONException("expect ':' at " + bVar.b());
                        }
                    } else {
                        if (!bVar.g(Feature.AllowUnQuotedFieldNames)) {
                            throw new JSONException("syntax error");
                        }
                        strY = bVar.y(aVar.t());
                        bVar.p0();
                        char cA2 = bVar.a();
                        if (cA2 != ':') {
                            throw new JSONException("expect ':' at " + bVar.b() + ", actual " + cA2);
                        }
                    }
                }
                bVar.next();
                bVar.p0();
                bVar.a();
                bVar.q0();
                if (strY != com.alibaba.fastjson.a.DEFAULT_TYPE_KEY) {
                    bVar.w();
                    if (i12 != 0) {
                        aVar.x0(gVarI);
                    }
                    if (bVar.k0() == 8) {
                        bVar.w();
                        objL0 = null;
                    } else {
                        objL0 = aVar.l0(type, strY);
                    }
                    map.put(strY, objL0);
                    aVar.g(map, strY);
                    aVar.w0(gVarI, objL0, strY);
                    aVar.x0(gVarI);
                    iK0 = bVar.k0();
                    if (iK0 != 20) {
                        if (iK0 == 13) {
                            bVar.w();
                            aVar.x0(gVarI);
                            return map;
                        }
                    }
                    aVar.x0(gVarI);
                    return map;
                }
                Feature feature = Feature.DisableSpecialKeyDetect;
                if (bVar.g(feature) || Feature.isEnabled(i11, feature)) {
                    bVar.w();
                    if (i12 != 0) {
                        aVar.x0(gVarI);
                    }
                    if (bVar.k0() == 8) {
                        bVar.w();
                        objL0 = null;
                    } else {
                        objL0 = aVar.l0(type, strY);
                    }
                    map.put(strY, objL0);
                    aVar.g(map, strY);
                    aVar.w0(gVarI, objL0, strY);
                    aVar.x0(gVarI);
                    iK0 = bVar.k0();
                    if (iK0 != 20 && iK0 != 15) {
                        if (iK0 == 13) {
                            bVar.w();
                            aVar.x0(gVarI);
                            return map;
                        }
                    }
                    aVar.x0(gVarI);
                    return map;
                }
                String strL = bVar.l(aVar.t(), '\"');
                l7.h hVarH = aVar.h();
                Class<?> clsJ = HashMap.class;
                if (!strL.equals("java.util.HashMap")) {
                    if (strL.equals("java.util.LinkedHashMap")) {
                        clsJ = LinkedHashMap.class;
                    } else if (!hVarH.x()) {
                        try {
                            clsJ = hVarH.j(strL, null, bVar.m());
                        } catch (JSONException unused) {
                        }
                    }
                }
                if (!Map.class.isAssignableFrom(clsJ)) {
                    b2 b2VarP = hVarH.p(clsJ);
                    bVar.W(16);
                    aVar.A0(2);
                    if (gVarI != null && !(obj instanceof Integer)) {
                        aVar.t0();
                    }
                    Map map2 = (Map) b2VarP.e(aVar, clsJ, obj);
                    aVar.x0(gVarI);
                    return map2;
                }
                bVar.W(16);
                if (bVar.k0() == 13) {
                    bVar.W(16);
                    aVar.x0(gVarI);
                    return map;
                }
                i12++;
            } catch (Throwable th2) {
                aVar.x0(gVarI);
                throw th2;
            }
        }
    }

    @Override // m7.b2
    public int b() {
        return 12;
    }

    @Override // m7.e
    public <T> T f(l7.a aVar, Type type, Object obj, String str, int i11) {
        if (type == JSONObject.class && aVar.n() == null) {
            return (T) aVar.i0();
        }
        l7.b bVar = aVar.f70077g;
        if (bVar.k0() == 8) {
            bVar.W(16);
            return null;
        }
        boolean z11 = (type instanceof Class) && "java.util.Collections$UnmodifiableMap".equals(((Class) type).getName());
        Map<Object, Object> mapH = (bVar.m() & Feature.OrderedField.mask) != 0 ? h(type, bVar.m()) : g(type);
        l7.g gVarI = aVar.i();
        try {
            aVar.w0(gVarI, mapH, obj);
            Map map = (T) i(aVar, type, obj, mapH, i11);
            if (z11) {
                map = (T) Collections.unmodifiableMap(map);
            }
            return (T) map;
        } finally {
            aVar.x0(gVarI);
        }
    }

    public Map<Object, Object> g(Type type) {
        return h(type, com.alibaba.fastjson.a.DEFAULT_GENERATE_FEATURE);
    }

    public Map<Object, Object> h(Type type, int i11) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class) {
            return (Feature.OrderedField.mask & i11) != 0 ? new LinkedHashMap() : new HashMap();
        }
        if (type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return EnumMap.class.equals(rawType) ? new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]) : h(rawType, i11);
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new JSONException("unsupport type " + type);
        }
        if ("java.util.Collections$UnmodifiableMap".equals(cls.getName())) {
            return new HashMap();
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e11) {
            throw new JSONException("unsupport type " + type, e11);
        }
    }

    public Object i(l7.a aVar, Type type, Object obj, Map map, int i11) {
        if (!(type instanceof ParameterizedType)) {
            return aVar.q0(map, obj);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type2 = parameterizedType.getActualTypeArguments()[0];
        Type type3 = map.getClass().getName().equals("org.springframework.util.LinkedMultiValueMap") ? List.class : parameterizedType.getActualTypeArguments()[1];
        return String.class == type2 ? k(aVar, map, type3, obj, i11) : j(aVar, map, type2, type3, obj);
    }
}
