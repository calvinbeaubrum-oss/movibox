package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;
import java.io.InputStream;
import java.io.Reader;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import m7.b2;
import m7.o;
import n7.f1;
import n7.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TypeUtils {
    public static volatile Map<Class, String[]> A;
    public static volatile boolean B;
    public static Class<?> D;
    public static Class N;
    public static com.alibaba.fastjson.util.e<Class, Boolean> O;
    public static com.alibaba.fastjson.util.e<Object, Object> P;
    public static com.alibaba.fastjson.util.e<Object, Object> Q;
    public static com.alibaba.fastjson.util.e<Object, Object> R;
    public static com.alibaba.fastjson.util.c<Object, Class, Object> S;
    public static com.alibaba.fastjson.util.e<Map<String, Class<?>>, Void> T;
    public static final Map U;
    public static final Set<String> V;
    public static Object W;
    public static boolean X;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f15503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f15504c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f15507f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Method f15509h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Class<?> f15511j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Class<? extends Annotation> f15513l;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile Class f15520s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile boolean f15521t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile boolean f15522u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static volatile Constructor f15523v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static volatile Method f15524w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static volatile Method f15525x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static volatile Method f15526y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static volatile boolean f15527z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f15502a = Pattern.compile("\\.0*$");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f15505d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f15506e = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f15508g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f15510i = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f15512k = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Class<? extends Annotation> f15514m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f15515n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Class<? extends Annotation> f15516o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f15517p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static Method f15518q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f15519r = false;
    public static ConcurrentMap<String, Class<?>> C = new ConcurrentHashMap(256, 0.75f, 1);
    public static boolean E = false;
    public static Class<? extends Annotation> F = null;
    public static boolean G = false;
    public static volatile Class H = null;
    public static volatile Class I = null;
    public static volatile boolean J = false;
    public static volatile Method K = null;
    public static volatile Field L = null;
    public static volatile Object M = null;

    /* JADX INFO: compiled from: source.java */
    public static class MethodInheritanceComparator implements Comparator<Method> {
        @Override // java.util.Comparator
        public int compare(Method method, Method method2) {
            int iCompareTo = method.getName().compareTo(method2.getName());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            Class<?> returnType = method.getReturnType();
            Class<?> returnType2 = method2.getReturnType();
            if (returnType.equals(returnType2)) {
                return 0;
            }
            if (returnType.isAssignableFrom(returnType2)) {
                return -1;
            }
            return returnType2.isAssignableFrom(returnType) ? 1 : 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a implements com.alibaba.fastjson.util.e<Class, Boolean> {
        @Override // com.alibaba.fastjson.util.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Class cls) {
            return Boolean.valueOf(Clob.class.isAssignableFrom(cls));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements com.alibaba.fastjson.util.e<Object, Object> {
        @Override // com.alibaba.fastjson.util.e
        public Object apply(Object obj) {
            long jLongValue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Date) {
                return (Date) obj;
            }
            if (obj instanceof java.util.Date) {
                return new Date(((java.util.Date) obj).getTime());
            }
            if (obj instanceof Calendar) {
                return new Date(((Calendar) obj).getTimeInMillis());
            }
            if (obj instanceof BigDecimal) {
                jLongValue = TypeUtils.E0((BigDecimal) obj);
            } else {
                jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                    return null;
                }
                if (TypeUtils.v0(str)) {
                    jLongValue = Long.parseLong(str);
                } else {
                    l7.e eVar = new l7.e(str);
                    if (!eVar.q1(false)) {
                        throw new JSONException("can not cast to Timestamp, value : " + str);
                    }
                    jLongValue = eVar.C0().getTime().getTime();
                }
            }
            if (jLongValue > 0) {
                return new Date(jLongValue);
            }
            throw new JSONException("can not cast to Date, value : " + obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements com.alibaba.fastjson.util.e<Object, Object> {
        @Override // com.alibaba.fastjson.util.e
        public Object apply(Object obj) {
            long jLongValue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Time) {
                return (Time) obj;
            }
            if (obj instanceof java.util.Date) {
                return new Time(((java.util.Date) obj).getTime());
            }
            if (obj instanceof Calendar) {
                return new Time(((Calendar) obj).getTimeInMillis());
            }
            if (obj instanceof BigDecimal) {
                jLongValue = TypeUtils.E0((BigDecimal) obj);
            } else {
                jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equalsIgnoreCase(str)) {
                    return null;
                }
                if (TypeUtils.v0(str)) {
                    jLongValue = Long.parseLong(str);
                } else {
                    if (str.length() == 8 && str.charAt(2) == ':' && str.charAt(5) == ':') {
                        return Time.valueOf(str);
                    }
                    l7.e eVar = new l7.e(str);
                    if (!eVar.q1(false)) {
                        throw new JSONException("can not cast to Timestamp, value : " + str);
                    }
                    jLongValue = eVar.C0().getTime().getTime();
                }
            }
            if (jLongValue > 0) {
                return new Time(jLongValue);
            }
            throw new JSONException("can not cast to Date, value : " + obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements com.alibaba.fastjson.util.e<Object, Object> {
        @Override // com.alibaba.fastjson.util.e
        public Object apply(Object obj) {
            long jLongValue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Calendar) {
                return new Timestamp(((Calendar) obj).getTimeInMillis());
            }
            if (obj instanceof Timestamp) {
                return (Timestamp) obj;
            }
            if (obj instanceof java.util.Date) {
                return new Timestamp(((java.util.Date) obj).getTime());
            }
            if (obj instanceof BigDecimal) {
                jLongValue = TypeUtils.E0((BigDecimal) obj);
            } else {
                jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
            }
            if (obj instanceof String) {
                String strSubstring = (String) obj;
                if (strSubstring.length() == 0 || "null".equals(strSubstring) || "NULL".equals(strSubstring)) {
                    return null;
                }
                if (strSubstring.endsWith(".000000000")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 10);
                } else if (strSubstring.endsWith(".000000")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 7);
                }
                if (strSubstring.length() == 29 && strSubstring.charAt(4) == '-' && strSubstring.charAt(7) == '-' && strSubstring.charAt(10) == ' ' && strSubstring.charAt(13) == ':' && strSubstring.charAt(16) == ':' && strSubstring.charAt(19) == '.') {
                    return new Timestamp(TypeUtils.H0(strSubstring.charAt(0), strSubstring.charAt(1), strSubstring.charAt(2), strSubstring.charAt(3)) - 1900, TypeUtils.G0(strSubstring.charAt(5), strSubstring.charAt(6)) - 1, TypeUtils.G0(strSubstring.charAt(8), strSubstring.charAt(9)), TypeUtils.G0(strSubstring.charAt(11), strSubstring.charAt(12)), TypeUtils.G0(strSubstring.charAt(14), strSubstring.charAt(15)), TypeUtils.G0(strSubstring.charAt(17), strSubstring.charAt(18)), TypeUtils.I0(strSubstring.charAt(20), strSubstring.charAt(21), strSubstring.charAt(22), strSubstring.charAt(23), strSubstring.charAt(24), strSubstring.charAt(25), strSubstring.charAt(26), strSubstring.charAt(27), strSubstring.charAt(28)));
                }
                if (TypeUtils.v0(strSubstring)) {
                    jLongValue = Long.parseLong(strSubstring);
                } else {
                    l7.e eVar = new l7.e(strSubstring);
                    if (!eVar.q1(false)) {
                        throw new JSONException("can not cast to Timestamp, value : " + strSubstring);
                    }
                    jLongValue = eVar.C0().getTime().getTime();
                }
            }
            return new Timestamp(jLongValue);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements com.alibaba.fastjson.util.c<Object, Class, Object> {
        @Override // com.alibaba.fastjson.util.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object obj, Class cls) {
            if (cls == Date.class) {
                return TypeUtils.y(obj);
            }
            if (cls == Time.class) {
                return TypeUtils.z(obj);
            }
            if (cls == Timestamp.class) {
                return TypeUtils.B(obj);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f implements com.alibaba.fastjson.util.e<Map<String, Class<?>>, Void> {
        @Override // com.alibaba.fastjson.util.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void apply(Map<String, Class<?>> map) {
            Class<?>[] clsArr = {Time.class, Date.class, Timestamp.class};
            for (int i11 = 0; i11 < 3; i11++) {
                Class<?> cls = clsArr[i11];
                if (cls != null) {
                    map.put(cls.getName(), cls);
                }
            }
            return null;
        }
    }

    static {
        f15503b = false;
        f15504c = false;
        N = null;
        try {
            f15503b = "true".equals(com.alibaba.fastjson.util.f.k("fastjson.compatibleWithJavaBean"));
            f15504c = "true".equals(com.alibaba.fastjson.util.f.k("fastjson.compatibleWithFieldName"));
        } catch (Throwable unused) {
        }
        try {
            N = Deque.class;
        } catch (Throwable unused2) {
        }
        O = new a();
        P = new b();
        Q = new c();
        R = new d();
        S = new e();
        T = new f();
        a();
        U = new HashMap<Class, String>(8) { // from class: com.alibaba.fastjson.util.TypeUtils.7
            {
                put(Boolean.TYPE, "Z");
                put(Character.TYPE, "C");
                put(Byte.TYPE, "B");
                put(Short.TYPE, "S");
                put(Integer.TYPE, "I");
                put(Long.TYPE, "J");
                put(Float.TYPE, "F");
                put(Double.TYPE, "D");
            }
        };
        V = new HashSet<String>(6) { // from class: com.alibaba.fastjson.util.TypeUtils.8
            {
                add("net.sf.cglib.proxy.Factory");
                add("org.springframework.cglib.proxy.Factory");
                add("javassist.util.proxy.ProxyObject");
                add("org.apache.ibatis.javassist.util.proxy.ProxyObject");
                add("org.hibernate.proxy.HibernateProxy");
                add("org.springframework.context.annotation.ConfigurationClassEnhancer$EnhancedConfiguration");
            }
        };
        X = false;
    }

    public static String A(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static Class<?> A0(String str) {
        return B0(str, null);
    }

    public static Object B(Object obj) {
        return i.b(R, obj);
    }

    public static Class<?> B0(String str, ClassLoader classLoader) {
        return C0(str, classLoader, false);
    }

    public static void C(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, Map<String, com.alibaba.fastjson.util.d> map2, Field[] fieldArr) {
        String strLabel;
        int i11;
        int i12;
        int i13;
        for (Field field : fieldArr) {
            if (!Modifier.isStatic(field.getModifiers())) {
                j7.b bVar = (j7.b) O(field, j7.b.class);
                String name = field.getName();
                if (bVar == null) {
                    strLabel = null;
                    i11 = 0;
                    i12 = 0;
                    i13 = 0;
                } else if (bVar.serialize()) {
                    int iOrdinal = bVar.ordinal();
                    int iOf = SerializerFeature.of(bVar.serialzeFeatures());
                    int iOf2 = Feature.of(bVar.parseFeatures());
                    if (bVar.name().length() != 0) {
                        name = bVar.name();
                    }
                    strLabel = bVar.label().length() != 0 ? bVar.label() : null;
                    i11 = iOrdinal;
                    i12 = iOf;
                    i13 = iOf2;
                }
                if (map == null || (name = map.get(name)) != null) {
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    String str = name;
                    if (!map2.containsKey(str)) {
                        map2.put(str, new com.alibaba.fastjson.util.d(str, null, field, cls, null, i11, i12, i13, null, bVar, strLabel));
                    }
                }
            }
        }
    }

    public static Class<?> C0(String str, ClassLoader classLoader, boolean z11) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() > 198) {
            throw new JSONException("illegal className : " + str);
        }
        Class<?> clsLoadClass = C.get(str);
        if (clsLoadClass != null) {
            return clsLoadClass;
        }
        if (str.charAt(0) == '[') {
            return Array.newInstance(B0(str.substring(1), classLoader), 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(";")) {
            return B0(str.substring(1, str.length() - 1), classLoader);
        }
        if (classLoader != null) {
            try {
                clsLoadClass = classLoader.loadClass(str);
                if (z11) {
                    C.put(str, clsLoadClass);
                }
                return clsLoadClass;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null && contextClassLoader != classLoader) {
            clsLoadClass = contextClassLoader.loadClass(str);
            if (z11) {
                C.put(str, clsLoadClass);
            }
            return clsLoadClass;
        }
        try {
            clsLoadClass = Class.forName(str);
            if (z11) {
                C.put(str, clsLoadClass);
            }
        } catch (Throwable unused) {
        }
        return clsLoadClass;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01ff A[PHI: r15 r32 r33
  0x01ff: PHI (r15v14 java.util.LinkedHashMap) = 
  (r15v4 java.util.LinkedHashMap)
  (r15v4 java.util.LinkedHashMap)
  (r15v4 java.util.LinkedHashMap)
  (r15v4 java.util.LinkedHashMap)
  (r15v4 java.util.LinkedHashMap)
  (r15v4 java.util.LinkedHashMap)
  (r15v18 java.util.LinkedHashMap)
 binds: [B:110:0x0238, B:113:0x0241, B:150:0x02c9, B:168:0x0307, B:142:0x02ac, B:118:0x0250, B:101:0x01cf] A[DONT_GENERATE, DONT_INLINE]
  0x01ff: PHI (r32v2 int) = (r32v1 int), (r32v1 int), (r32v1 int), (r32v1 int), (r32v1 int), (r32v1 int), (r32v5 int) binds: [B:110:0x0238, B:113:0x0241, B:150:0x02c9, B:168:0x0307, B:142:0x02ac, B:118:0x0250, B:101:0x01cf] A[DONT_GENERATE, DONT_INLINE]
  0x01ff: PHI (r33v2 java.lang.reflect.Method[]) = 
  (r33v1 java.lang.reflect.Method[])
  (r33v1 java.lang.reflect.Method[])
  (r33v1 java.lang.reflect.Method[])
  (r33v1 java.lang.reflect.Method[])
  (r33v1 java.lang.reflect.Method[])
  (r33v1 java.lang.reflect.Method[])
  (r33v5 java.lang.reflect.Method[])
 binds: [B:110:0x0238, B:113:0x0241, B:150:0x02c9, B:168:0x0307, B:142:0x02ac, B:118:0x0250, B:101:0x01cf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:152:0x02cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:153:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:155:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:163:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:165:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:167:0x0303  */
    /* JADX WARN: Code duplicated, block: B:170:0x030b  */
    /* JADX WARN: Code duplicated, block: B:172:0x0329  */
    /* JADX WARN: Code duplicated, block: B:174:0x0333  */
    /* JADX WARN: Code duplicated, block: B:176:0x033b A[PHI: r4
  0x033b: PHI (r4v9 java.util.Map<java.lang.String, java.lang.String>) = (r4v7 java.util.Map<java.lang.String, java.lang.String>), (r4v13 java.util.Map<java.lang.String, java.lang.String>) binds: [B:186:0x037c, B:175:0x0339] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:177:0x0341  */
    /* JADX WARN: Code duplicated, block: B:180:0x034f  */
    /* JADX WARN: Code duplicated, block: B:182:0x035b  */
    /* JADX WARN: Code duplicated, block: B:183:0x0367  */
    /* JADX WARN: Code duplicated, block: B:185:0x0375  */
    /* JADX WARN: Code duplicated, block: B:190:0x0384  */
    /* JADX WARN: Code duplicated, block: B:199:0x03db  */
    /* JADX WARN: Code duplicated, block: B:200:0x03dd A[PHI: r12
  0x03dd: PHI (r12v5 java.lang.Class<?>) = (r12v4 java.lang.Class<?>), (r12v7 java.lang.Class<?>), (r12v7 java.lang.Class<?>) binds: [B:199:0x03db, B:233:0x0468, B:244:0x048b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:235:0x046c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:236:0x046e  */
    /* JADX WARN: Code duplicated, block: B:238:0x0474  */
    /* JADX WARN: Code duplicated, block: B:239:0x047a  */
    /* JADX WARN: Code duplicated, block: B:241:0x047d  */
    /* JADX WARN: Code duplicated, block: B:243:0x0487  */
    /* JADX WARN: Code duplicated, block: B:246:0x048e  */
    /* JADX WARN: Code duplicated, block: B:248:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:253:0x04c1  */
    /* JADX WARN: Code duplicated, block: B:256:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:257:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:258:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:260:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:262:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:267:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:270:0x0503  */
    /* JADX WARN: Code duplicated, block: B:271:0x0506  */
    /* JADX WARN: Code duplicated, block: B:8:0x003a  */
    public static List<com.alibaba.fastjson.util.d> D(Class<?> cls, j7.d dVar, Map<String, String> map, Map<String, Field> map2, boolean z11, PropertyNamingStrategy propertyNamingStrategy) {
        String[] strArr;
        int i11;
        Constructor<?>[] constructorArr;
        Annotation[][] annotationArr;
        j7.b bVar;
        short[] sArr;
        int i12;
        Method[] methodArr;
        LinkedHashMap linkedHashMap;
        int iOrdinal;
        int iOf;
        int iOf2;
        LinkedHashMap linkedHashMap2;
        int i13;
        Map<String, String> map3;
        PropertyNamingStrategy propertyNamingStrategy2;
        LinkedHashMap linkedHashMap3;
        Map<String, Field> map4;
        String strSubstring;
        Field fieldS;
        Field fieldS2;
        j7.b bVar2;
        int i14;
        String str;
        j7.b bVar3;
        int iOrdinal2;
        int iOf3;
        int iOf4;
        String strG0;
        Field fieldS3;
        Field field;
        Map<String, String> map5;
        String str2;
        Boolean bool;
        int i15;
        int i16;
        j7.b bVar4;
        j7.b bVar5;
        char cCharAt;
        Field fieldS4;
        String[] strArrA0;
        short[] sArr2;
        Field fieldS5;
        Constructor constructorB0;
        Class<?> cls2 = cls;
        Map<String, String> map6 = map;
        PropertyNamingStrategy propertyNamingStrategy3 = propertyNamingStrategy;
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        boolean zT0 = t0(cls);
        Method[] methods = cls.getMethods();
        try {
            Arrays.sort(methods, new MethodInheritanceComparator());
        } catch (Throwable unused) {
        }
        int length = methods.length;
        Constructor<?>[] declaredConstructors = null;
        String[] strArr2 = null;
        short[] sArr3 = null;
        Annotation[][] annotationArrD0 = null;
        int i17 = 0;
        while (i17 < length) {
            Method method = methods[i17];
            String name = method.getName();
            String strLabel = null;
            if (Modifier.isStatic(method.getModifiers())) {
                strArr = strArr2;
                i11 = i17;
                i12 = length;
                methodArr = methods;
                linkedHashMap3 = linkedHashMap4;
                propertyNamingStrategy2 = propertyNamingStrategy3;
                map3 = map6;
            } else {
                Class<?> returnType = method.getReturnType();
                if (returnType.equals(Void.TYPE) || method.getParameterTypes().length != 0 || returnType == ClassLoader.class || returnType == InputStream.class || returnType == Reader.class) {
                    strArr = strArr2;
                } else {
                    if (name.equals("getMetaClass")) {
                        strArr = strArr2;
                        if (returnType.getName().equals("groovy.lang.MetaClass")) {
                        }
                    } else {
                        strArr = strArr2;
                    }
                    if ((!name.equals("getSuppressed") || method.getDeclaringClass() != Throwable.class) && (!zT0 || !u0(cls2, name))) {
                        Boolean bool2 = Boolean.FALSE;
                        j7.b bVarJ0 = (j7.b) P(method, j7.b.class);
                        if (bVarJ0 == null) {
                            bVarJ0 = j0(cls2, method);
                        }
                        LinkedHashMap linkedHashMap5 = linkedHashMap4;
                        if (bVarJ0 == null && zT0) {
                            if (declaredConstructors != null || (constructorB0 = b0((declaredConstructors = cls.getDeclaredConstructors()))) == null) {
                                strArrA0 = strArr;
                            } else {
                                annotationArrD0 = d0(constructorB0);
                                strArrA0 = a0(cls);
                                if (strArrA0 != null) {
                                    String[] strArr3 = new String[strArrA0.length];
                                    System.arraycopy(strArrA0, 0, strArr3, 0, strArrA0.length);
                                    Arrays.sort(strArr3);
                                    short[] sArr4 = new short[strArrA0.length];
                                    for (short s11 = 0; s11 < strArrA0.length; s11 = (short) (s11 + 1)) {
                                        sArr4[Arrays.binarySearch(strArr3, strArrA0[s11])] = s11;
                                    }
                                    strArrA0 = strArr3;
                                    annotationArrD0 = annotationArrD0;
                                    sArr3 = sArr4;
                                    declaredConstructors = declaredConstructors;
                                }
                            }
                            if (strArrA0 == null || sArr3 == null || !name.startsWith("get")) {
                                constructorArr = declaredConstructors;
                                sArr2 = sArr3;
                                annotationArr = annotationArrD0;
                                i11 = i17;
                            } else {
                                String strI = I(name.substring(3));
                                int iBinarySearch = Arrays.binarySearch(strArrA0, strI);
                                constructorArr = declaredConstructors;
                                i11 = i17;
                                if (iBinarySearch < 0) {
                                    for (int i18 = 0; i18 < strArrA0.length; i18++) {
                                        if (strI.equalsIgnoreCase(strArrA0[i18])) {
                                            iBinarySearch = i18;
                                            break;
                                        }
                                    }
                                }
                                if (iBinarySearch >= 0) {
                                    Annotation[] annotationArr2 = annotationArrD0[sArr3[iBinarySearch]];
                                    if (annotationArr2 != null) {
                                        int length2 = annotationArr2.length;
                                        sArr2 = sArr3;
                                        int i19 = 0;
                                        while (true) {
                                            annotationArr = annotationArrD0;
                                            if (i19 >= length2) {
                                                break;
                                            }
                                            Annotation annotation = annotationArr2[i19];
                                            Annotation[] annotationArr3 = annotationArr2;
                                            if (annotation instanceof j7.b) {
                                                bVarJ0 = (j7.b) annotation;
                                                break;
                                            }
                                            i19++;
                                            annotationArrD0 = annotationArr;
                                            annotationArr2 = annotationArr3;
                                        }
                                    } else {
                                        sArr2 = sArr3;
                                        annotationArr = annotationArrD0;
                                    }
                                    if (bVarJ0 == null && (fieldS5 = l7.h.s(strI, map2)) != null) {
                                        bVar = (j7.b) O(fieldS5, j7.b.class);
                                    }
                                    sArr = sArr2;
                                    strArr = strArrA0;
                                } else {
                                    sArr2 = sArr3;
                                    annotationArr = annotationArrD0;
                                }
                            }
                            bVar = bVarJ0;
                            sArr = sArr2;
                            strArr = strArrA0;
                        } else {
                            returnType = returnType;
                            i11 = i17;
                            constructorArr = declaredConstructors;
                            annotationArr = annotationArrD0;
                            bVar = bVarJ0;
                            sArr = sArr3;
                        }
                        if (bVar != null) {
                            if (bVar.serialize()) {
                                iOrdinal = bVar.ordinal();
                                iOf = SerializerFeature.of(bVar.serialzeFeatures());
                                iOf2 = Feature.of(bVar.parseFeatures());
                                if (bVar.name().length() != 0) {
                                    String strName = bVar.name();
                                    if (map6 == null || (strName = map6.get(strName)) != null) {
                                        String str3 = strName;
                                        i12 = length;
                                        methodArr = methods;
                                        linkedHashMap = linkedHashMap5;
                                        linkedHashMap.put(str3, new com.alibaba.fastjson.util.d(str3, method, null, cls, null, iOrdinal, iOf, iOf2, bVar, null, null));
                                    }
                                    sArr3 = sArr;
                                    declaredConstructors = constructorArr;
                                    annotationArrD0 = annotationArr;
                                } else {
                                    i12 = length;
                                    methodArr = methods;
                                    linkedHashMap = linkedHashMap5;
                                    if (bVar.label().length() != 0) {
                                        strLabel = bVar.label();
                                    }
                                }
                                propertyNamingStrategy2 = propertyNamingStrategy;
                                linkedHashMap3 = linkedHashMap;
                                map3 = map;
                                sArr3 = sArr;
                                declaredConstructors = constructorArr;
                                annotationArrD0 = annotationArr;
                            }
                            i12 = length;
                            methodArr = methods;
                            propertyNamingStrategy2 = propertyNamingStrategy3;
                            linkedHashMap3 = linkedHashMap5;
                            map3 = map6;
                            sArr3 = sArr;
                            declaredConstructors = constructorArr;
                            annotationArrD0 = annotationArr;
                        } else {
                            i12 = length;
                            methodArr = methods;
                            linkedHashMap = linkedHashMap5;
                            iOrdinal = 0;
                            iOf = 0;
                            iOf2 = 0;
                        }
                        if (name.startsWith("get")) {
                            if (name.length() < 4 || name.equals("getClass") || (name.equals("getDeclaringClass") && cls.isEnum())) {
                                propertyNamingStrategy2 = propertyNamingStrategy;
                                linkedHashMap3 = linkedHashMap;
                                map3 = map;
                            } else {
                                char cCharAt2 = name.charAt(3);
                                if (Character.isUpperCase(cCharAt2) || cCharAt2 > 512) {
                                    strG0 = g0(map2, name, f15503b ? I(name.substring(3)) : h0(name), 3);
                                } else {
                                    if (cCharAt2 == '_') {
                                        strG0 = name.substring(3);
                                        fieldS3 = map2.get(strG0);
                                        if (fieldS3 == null) {
                                            String strSubstring2 = name.substring(4);
                                            fieldS4 = l7.h.s(strSubstring2, map2);
                                            if (fieldS4 != null) {
                                                strG0 = strSubstring2;
                                            }
                                        } else if (r0(cls2, strG0)) {
                                            propertyNamingStrategy2 = propertyNamingStrategy;
                                            linkedHashMap3 = linkedHashMap;
                                            map3 = map;
                                        } else {
                                            if (fieldS3 == null) {
                                                fieldS3 = l7.h.s(strG0, map2);
                                            }
                                            if (fieldS3 != null && strG0.length() > 1 && (cCharAt = strG0.charAt(1)) >= 'A' && cCharAt <= 'Z') {
                                                fieldS3 = l7.h.s(I(name.substring(3)), map2);
                                            }
                                            field = fieldS3;
                                            if (field != null) {
                                                bVar5 = (j7.b) O(field, j7.b.class);
                                                if (bVar5 == null) {
                                                    map5 = map;
                                                    str2 = strLabel;
                                                    i15 = iOrdinal;
                                                    i16 = iOf;
                                                    bVar4 = bVar5;
                                                } else if (bVar5.serialize()) {
                                                    int iOrdinal3 = bVar5.ordinal();
                                                    int iOf5 = SerializerFeature.of(bVar5.serialzeFeatures());
                                                    iOf2 = Feature.of(bVar5.parseFeatures());
                                                    if (bVar5.name().length() != 0) {
                                                        bool = Boolean.TRUE;
                                                        strG0 = bVar5.name();
                                                        map5 = map;
                                                        if (map5 == null && (strG0 = map5.get(strG0)) == null) {
                                                            propertyNamingStrategy2 = propertyNamingStrategy;
                                                            linkedHashMap3 = linkedHashMap;
                                                            map3 = map5;
                                                        }
                                                    } else {
                                                        map5 = map;
                                                        bool = bool2;
                                                    }
                                                    if (bVar5.label().length() != 0) {
                                                        strLabel = bVar5.label();
                                                    }
                                                    i16 = iOf5;
                                                    str2 = strLabel;
                                                    bVar4 = bVar5;
                                                    i15 = iOrdinal3;
                                                } else {
                                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                                    linkedHashMap3 = linkedHashMap;
                                                    map3 = map;
                                                }
                                            } else {
                                                map5 = map;
                                                str2 = strLabel;
                                                i15 = iOrdinal;
                                                i16 = iOf;
                                                bVar4 = null;
                                            }
                                            if (map5 != null) {
                                                bool = bool2;
                                                bool = bool2;
                                                strG0 = map5.get(strG0);
                                                if (strG0 == null) {
                                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                                    linkedHashMap3 = linkedHashMap;
                                                    map3 = map5;
                                                }
                                            }
                                            bool = bool2;
                                            bool = bool2;
                                            LinkedHashMap linkedHashMap6 = linkedHashMap;
                                            if (propertyNamingStrategy != null && !bool.booleanValue()) {
                                                strG0 = propertyNamingStrategy.translate(strG0);
                                            }
                                            i13 = 3;
                                            linkedHashMap2 = linkedHashMap6;
                                            linkedHashMap2.put(strG0, new com.alibaba.fastjson.util.d(strG0, method, field, cls, null, i15, i16, iOf2, bVar, bVar4, str2));
                                            iOrdinal = i15;
                                            iOf = i16;
                                            strLabel = str2;
                                        }
                                    } else if (cCharAt2 == 'f') {
                                        strG0 = name.substring(3);
                                    } else {
                                        if (name.length() < 5 || !Character.isUpperCase(name.charAt(4))) {
                                            strG0 = name.substring(3);
                                            fieldS4 = l7.h.s(strG0, map2);
                                            if (fieldS4 == null) {
                                            }
                                        } else {
                                            strG0 = I(name.substring(3));
                                        }
                                        propertyNamingStrategy2 = propertyNamingStrategy;
                                        linkedHashMap3 = linkedHashMap;
                                        map3 = map;
                                    }
                                    fieldS3 = fieldS4;
                                    if (r0(cls2, strG0)) {
                                        if (fieldS3 == null) {
                                            fieldS3 = l7.h.s(strG0, map2);
                                        }
                                        if (fieldS3 != null) {
                                        }
                                        field = fieldS3;
                                        if (field != null) {
                                            bVar5 = (j7.b) O(field, j7.b.class);
                                            if (bVar5 == null) {
                                                map5 = map;
                                                str2 = strLabel;
                                                i15 = iOrdinal;
                                                i16 = iOf;
                                                bVar4 = bVar5;
                                            } else if (bVar5.serialize()) {
                                                propertyNamingStrategy2 = propertyNamingStrategy;
                                                linkedHashMap3 = linkedHashMap;
                                                map3 = map;
                                            } else {
                                                int iOrdinal4 = bVar5.ordinal();
                                                int iOf6 = SerializerFeature.of(bVar5.serialzeFeatures());
                                                iOf2 = Feature.of(bVar5.parseFeatures());
                                                if (bVar5.name().length() != 0) {
                                                    bool = Boolean.TRUE;
                                                    strG0 = bVar5.name();
                                                    map5 = map;
                                                    if (map5 == null) {
                                                    }
                                                } else {
                                                    map5 = map;
                                                    bool = bool2;
                                                }
                                                if (bVar5.label().length() != 0) {
                                                    strLabel = bVar5.label();
                                                }
                                                i16 = iOf6;
                                                str2 = strLabel;
                                                bVar4 = bVar5;
                                                i15 = iOrdinal4;
                                            }
                                        } else {
                                            map5 = map;
                                            str2 = strLabel;
                                            i15 = iOrdinal;
                                            i16 = iOf;
                                            bVar4 = null;
                                        }
                                        if (map5 != null) {
                                            bool = bool2;
                                            bool = bool2;
                                            strG0 = map5.get(strG0);
                                            if (strG0 == null) {
                                                propertyNamingStrategy2 = propertyNamingStrategy;
                                                linkedHashMap3 = linkedHashMap;
                                                map3 = map5;
                                            }
                                        }
                                        bool = bool2;
                                        bool = bool2;
                                        LinkedHashMap linkedHashMap7 = linkedHashMap;
                                        if (propertyNamingStrategy != null) {
                                            strG0 = propertyNamingStrategy.translate(strG0);
                                        }
                                        i13 = 3;
                                        linkedHashMap2 = linkedHashMap7;
                                        linkedHashMap2.put(strG0, new com.alibaba.fastjson.util.d(strG0, method, field, cls, null, i15, i16, iOf2, bVar, bVar4, str2));
                                        iOrdinal = i15;
                                        iOf = i16;
                                        strLabel = str2;
                                    } else {
                                        propertyNamingStrategy2 = propertyNamingStrategy;
                                        linkedHashMap3 = linkedHashMap;
                                        map3 = map;
                                    }
                                }
                                fieldS3 = null;
                                if (r0(cls2, strG0)) {
                                    if (fieldS3 == null) {
                                        fieldS3 = l7.h.s(strG0, map2);
                                    }
                                    if (fieldS3 != null) {
                                    }
                                    field = fieldS3;
                                    if (field != null) {
                                        bVar5 = (j7.b) O(field, j7.b.class);
                                        if (bVar5 == null) {
                                            map5 = map;
                                            str2 = strLabel;
                                            i15 = iOrdinal;
                                            i16 = iOf;
                                            bVar4 = bVar5;
                                        } else if (bVar5.serialize()) {
                                            propertyNamingStrategy2 = propertyNamingStrategy;
                                            linkedHashMap3 = linkedHashMap;
                                            map3 = map;
                                        } else {
                                            int iOrdinal5 = bVar5.ordinal();
                                            int iOf7 = SerializerFeature.of(bVar5.serialzeFeatures());
                                            iOf2 = Feature.of(bVar5.parseFeatures());
                                            if (bVar5.name().length() != 0) {
                                                bool = Boolean.TRUE;
                                                strG0 = bVar5.name();
                                                map5 = map;
                                                if (map5 == null) {
                                                }
                                            } else {
                                                map5 = map;
                                                bool = bool2;
                                            }
                                            if (bVar5.label().length() != 0) {
                                                strLabel = bVar5.label();
                                            }
                                            i16 = iOf7;
                                            str2 = strLabel;
                                            bVar4 = bVar5;
                                            i15 = iOrdinal5;
                                        }
                                    } else {
                                        map5 = map;
                                        str2 = strLabel;
                                        i15 = iOrdinal;
                                        i16 = iOf;
                                        bVar4 = null;
                                    }
                                    if (map5 != null) {
                                        bool = bool2;
                                        bool = bool2;
                                        strG0 = map5.get(strG0);
                                        if (strG0 == null) {
                                            propertyNamingStrategy2 = propertyNamingStrategy;
                                            linkedHashMap3 = linkedHashMap;
                                            map3 = map5;
                                        }
                                    }
                                    bool = bool2;
                                    bool = bool2;
                                    LinkedHashMap linkedHashMap8 = linkedHashMap;
                                    if (propertyNamingStrategy != null) {
                                        strG0 = propertyNamingStrategy.translate(strG0);
                                    }
                                    i13 = 3;
                                    linkedHashMap2 = linkedHashMap8;
                                    linkedHashMap2.put(strG0, new com.alibaba.fastjson.util.d(strG0, method, field, cls, null, i15, i16, iOf2, bVar, bVar4, str2));
                                    iOrdinal = i15;
                                    iOf = i16;
                                    strLabel = str2;
                                } else {
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    linkedHashMap3 = linkedHashMap;
                                    map3 = map;
                                }
                            }
                            sArr3 = sArr;
                            declaredConstructors = constructorArr;
                            annotationArrD0 = annotationArr;
                        } else {
                            linkedHashMap2 = linkedHashMap;
                            i13 = 3;
                        }
                        if (name.startsWith("is") && name.length() >= i13 && (returnType == Boolean.TYPE || returnType == Boolean.class)) {
                            char cCharAt3 = name.charAt(2);
                            if (Character.isUpperCase(cCharAt3)) {
                                map4 = map2;
                                strSubstring = g0(map4, name, f15503b ? I(name.substring(2)) : Character.toLowerCase(name.charAt(2)) + name.substring(i13), 2);
                            } else {
                                map4 = map2;
                                if (cCharAt3 == '_') {
                                    String strSubstring3 = name.substring(3);
                                    fieldS = map4.get(strSubstring3);
                                    if (fieldS != null || (fieldS = l7.h.s((strSubstring = name.substring(2)), map4)) == null) {
                                        strSubstring = strSubstring3;
                                    }
                                } else if (cCharAt3 == 'f') {
                                    strSubstring = name.substring(2);
                                } else {
                                    strSubstring = name.substring(2);
                                    fieldS = l7.h.s(strSubstring, map4);
                                    if (fieldS == null) {
                                        cls2 = cls;
                                    }
                                    map3 = map;
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    linkedHashMap3 = linkedHashMap2;
                                }
                                cls2 = cls;
                                if (r0(cls2, strSubstring)) {
                                    map3 = map;
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    linkedHashMap3 = linkedHashMap2;
                                } else {
                                    if (fieldS == null) {
                                        fieldS = l7.h.s(strSubstring, map4);
                                    }
                                    if (fieldS == null) {
                                        fieldS2 = l7.h.s(name, map4);
                                    } else {
                                        fieldS2 = fieldS;
                                    }
                                    if (fieldS2 != null) {
                                        bVar3 = (j7.b) O(fieldS2, j7.b.class);
                                        if (bVar3 != null) {
                                            if (bVar3.serialize()) {
                                                iOrdinal2 = bVar3.ordinal();
                                                iOf3 = SerializerFeature.of(bVar3.serialzeFeatures());
                                                iOf4 = Feature.of(bVar3.parseFeatures());
                                                if (bVar3.name().length() != 0) {
                                                    strSubstring = bVar3.name();
                                                    map = map;
                                                    if (map != null || (strSubstring = map.get(strSubstring)) != null) {
                                                    }
                                                } else {
                                                    map = map;
                                                }
                                                if (bVar3.label().length() != 0) {
                                                    bVar2 = bVar3;
                                                    iOf = iOf3;
                                                    i14 = iOf4;
                                                    strLabel = bVar3.label();
                                                    iOrdinal = iOrdinal2;
                                                } else {
                                                    bVar2 = bVar3;
                                                    iOrdinal = iOrdinal2;
                                                    iOf = iOf3;
                                                    i14 = iOf4;
                                                }
                                                if (map != null || (strSubstring = map.get(strSubstring)) != null) {
                                                    map3 = map;
                                                    if (propertyNamingStrategy != null) {
                                                        strSubstring = propertyNamingStrategy.translate(strSubstring);
                                                    }
                                                    str = strSubstring;
                                                    if (linkedHashMap2.containsKey(str)) {
                                                        propertyNamingStrategy2 = propertyNamingStrategy;
                                                    } else {
                                                        LinkedHashMap linkedHashMap9 = linkedHashMap2;
                                                        j7.b bVar6 = bVar2;
                                                        propertyNamingStrategy2 = propertyNamingStrategy;
                                                        linkedHashMap3 = linkedHashMap9;
                                                        linkedHashMap3.put(str, new com.alibaba.fastjson.util.d(str, method, fieldS2, cls, null, iOrdinal, iOf, i14, bVar, bVar6, strLabel));
                                                    }
                                                }
                                            } else {
                                                map3 = map;
                                                propertyNamingStrategy2 = propertyNamingStrategy;
                                            }
                                            linkedHashMap3 = linkedHashMap2;
                                        } else {
                                            bVar2 = bVar3;
                                        }
                                        propertyNamingStrategy2 = propertyNamingStrategy;
                                        map3 = map;
                                        linkedHashMap3 = linkedHashMap2;
                                    } else {
                                        bVar2 = null;
                                    }
                                    i14 = iOf2;
                                    if (map != null) {
                                    }
                                    map3 = map;
                                    if (propertyNamingStrategy != null) {
                                        strSubstring = propertyNamingStrategy.translate(strSubstring);
                                    }
                                    str = strSubstring;
                                    if (linkedHashMap2.containsKey(str)) {
                                        propertyNamingStrategy2 = propertyNamingStrategy;
                                        linkedHashMap3 = linkedHashMap2;
                                    } else {
                                        LinkedHashMap linkedHashMap10 = linkedHashMap2;
                                        j7.b bVar7 = bVar2;
                                        propertyNamingStrategy2 = propertyNamingStrategy;
                                        linkedHashMap3 = linkedHashMap10;
                                        linkedHashMap3.put(str, new com.alibaba.fastjson.util.d(str, method, fieldS2, cls, null, iOrdinal, iOf, i14, bVar, bVar7, strLabel));
                                    }
                                }
                            }
                            fieldS = null;
                            cls2 = cls;
                            if (r0(cls2, strSubstring)) {
                                if (fieldS == null) {
                                    fieldS = l7.h.s(strSubstring, map4);
                                }
                                if (fieldS == null) {
                                    fieldS2 = l7.h.s(name, map4);
                                } else {
                                    fieldS2 = fieldS;
                                }
                                if (fieldS2 != null) {
                                    bVar3 = (j7.b) O(fieldS2, j7.b.class);
                                    if (bVar3 != null) {
                                        if (bVar3.serialize()) {
                                            map3 = map;
                                            propertyNamingStrategy2 = propertyNamingStrategy;
                                        } else {
                                            iOrdinal2 = bVar3.ordinal();
                                            iOf3 = SerializerFeature.of(bVar3.serialzeFeatures());
                                            iOf4 = Feature.of(bVar3.parseFeatures());
                                            if (bVar3.name().length() != 0) {
                                                strSubstring = bVar3.name();
                                                map = map;
                                                if (map != null) {
                                                }
                                            } else {
                                                map = map;
                                            }
                                            if (bVar3.label().length() != 0) {
                                                bVar2 = bVar3;
                                                iOf = iOf3;
                                                i14 = iOf4;
                                                strLabel = bVar3.label();
                                                iOrdinal = iOrdinal2;
                                            } else {
                                                bVar2 = bVar3;
                                                iOrdinal = iOrdinal2;
                                                iOf = iOf3;
                                                i14 = iOf4;
                                            }
                                            if (map != null) {
                                            }
                                            map3 = map;
                                            if (propertyNamingStrategy != null) {
                                                strSubstring = propertyNamingStrategy.translate(strSubstring);
                                            }
                                            str = strSubstring;
                                            if (linkedHashMap2.containsKey(str)) {
                                                propertyNamingStrategy2 = propertyNamingStrategy;
                                            } else {
                                                LinkedHashMap linkedHashMap11 = linkedHashMap2;
                                                j7.b bVar8 = bVar2;
                                                propertyNamingStrategy2 = propertyNamingStrategy;
                                                linkedHashMap3 = linkedHashMap11;
                                                linkedHashMap3.put(str, new com.alibaba.fastjson.util.d(str, method, fieldS2, cls, null, iOrdinal, iOf, i14, bVar, bVar8, strLabel));
                                            }
                                        }
                                        linkedHashMap3 = linkedHashMap2;
                                    } else {
                                        bVar2 = bVar3;
                                    }
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    map3 = map;
                                    linkedHashMap3 = linkedHashMap2;
                                } else {
                                    bVar2 = null;
                                }
                                i14 = iOf2;
                                if (map != null) {
                                }
                                map3 = map;
                                if (propertyNamingStrategy != null) {
                                    strSubstring = propertyNamingStrategy.translate(strSubstring);
                                }
                                str = strSubstring;
                                if (linkedHashMap2.containsKey(str)) {
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    linkedHashMap3 = linkedHashMap2;
                                } else {
                                    LinkedHashMap linkedHashMap12 = linkedHashMap2;
                                    j7.b bVar9 = bVar2;
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    linkedHashMap3 = linkedHashMap12;
                                    linkedHashMap3.put(str, new com.alibaba.fastjson.util.d(str, method, fieldS2, cls, null, iOrdinal, iOf, i14, bVar, bVar9, strLabel));
                                }
                            } else {
                                map3 = map;
                                propertyNamingStrategy2 = propertyNamingStrategy;
                                linkedHashMap3 = linkedHashMap2;
                            }
                        } else {
                            cls2 = cls;
                            map3 = map;
                            propertyNamingStrategy2 = propertyNamingStrategy;
                            linkedHashMap3 = linkedHashMap2;
                        }
                        sArr3 = sArr;
                        declaredConstructors = constructorArr;
                        annotationArrD0 = annotationArr;
                    }
                }
                i11 = i17;
                i12 = length;
                methodArr = methods;
                linkedHashMap3 = linkedHashMap4;
                propertyNamingStrategy2 = propertyNamingStrategy3;
                map3 = map6;
            }
            i17 = i11 + 1;
            linkedHashMap4 = linkedHashMap3;
            map6 = map3;
            strArr2 = strArr;
            length = i12;
            methods = methodArr;
            propertyNamingStrategy3 = propertyNamingStrategy2;
        }
        LinkedHashMap linkedHashMap13 = linkedHashMap4;
        C(cls2, map6, propertyNamingStrategy3, linkedHashMap13, cls.getFields());
        return Y(cls2, z11, linkedHashMap13);
    }

    public static long D0(Number number) {
        return number instanceof BigDecimal ? ((BigDecimal) number).longValueExact() : number.longValue();
    }

    public static List<com.alibaba.fastjson.util.d> E(Class<?> cls, Map<String, String> map, boolean z11, PropertyNamingStrategy propertyNamingStrategy) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            C(superclass, map, propertyNamingStrategy, linkedHashMap, superclass.getDeclaredFields());
        }
        return Y(cls, z11, linkedHashMap);
    }

    public static long E0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0L;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.longValueExact() : bigDecimal.longValue();
    }

    public static Map<TypeVariable, Type> F(TypeVariable[] typeVariableArr, Type[] typeArr) {
        int length = typeVariableArr.length;
        HashMap map = new HashMap(length);
        for (int i11 = 0; i11 < length; i11++) {
            map.put(typeVariableArr[i11], typeArr[i11]);
        }
        return map;
    }

    public static ParameterizedType F0(Class<?> cls, Type[] typeArr, Map<TypeVariable, Type> map) {
        int length = typeArr.length;
        Type[] typeArr2 = new Type[length];
        for (int i11 = 0; i11 < length; i11++) {
            typeArr2[i11] = M(typeArr[i11], map);
        }
        return new ParameterizedTypeImpl(typeArr2, null, cls);
    }

    public static Collection G(Type type) {
        Class<?> cls;
        Class<?> clsI0 = i0(type);
        if (clsI0 == AbstractCollection.class || clsI0 == Collection.class) {
            return new ArrayList();
        }
        if (clsI0.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (clsI0.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (clsI0.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (clsI0.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (clsI0.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        }
        if (clsI0.isAssignableFrom(Queue.class) || ((cls = N) != null && clsI0.isAssignableFrom(cls))) {
            return new LinkedList();
        }
        try {
            return (Collection) clsI0.newInstance();
        } catch (Exception unused) {
            throw new JSONException("create instance error, class " + clsI0.getName());
        }
    }

    public static int G0(char c11, char c12) {
        if (c11 < '0' || c11 > '9' || c12 < '0' || c12 > '9') {
            return -1;
        }
        return ((c11 - '0') * 10) + (c12 - '0');
    }

    public static Set H(Type type) {
        Class<?> clsI0 = i0(type);
        if (clsI0 == AbstractCollection.class || clsI0 == Collection.class) {
            return new HashSet();
        }
        if (clsI0.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (clsI0.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (clsI0.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (clsI0.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        }
        try {
            return (Set) clsI0.newInstance();
        } catch (Exception unused) {
            throw new JSONException("create instance error, class " + clsI0.getName());
        }
    }

    public static int H0(char c11, char c12, char c13, char c14) {
        if (c11 < '0' || c11 > '9' || c12 < '0' || c12 > '9' || c13 < '0' || c13 > '9' || c14 < '0' || c14 > '9') {
            return -1;
        }
        return ((c11 - '0') * 1000) + ((c12 - '0') * 100) + ((c13 - '0') * 10) + (c14 - '0');
    }

    public static String I(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static int I0(char c11, char c12, char c13, char c14, char c15, char c16, char c17, char c18, char c19) {
        if (c11 < '0' || c11 > '9' || c12 < '0' || c12 > '9' || c13 < '0' || c13 > '9' || c14 < '0' || c14 > '9' || c15 < '0' || c15 > '9' || c16 < '0' || c16 > '9' || c17 < '0' || c17 > '9' || c18 < '0' || c18 > '9' || c19 < '0' || c19 > '9') {
            return -1;
        }
        return ((c11 - '0') * 100000000) + ((c12 - '0') * 10000000) + ((c13 - '0') * 1000000) + ((c14 - '0') * DefaultOggSeeker.MATCH_BYTE_RANGE) + ((c15 - '0') * 10000) + ((c16 - '0') * 1000) + ((c17 - '0') * 100) + ((c18 - '0') * 10) + (c19 - '0');
    }

    public static long J(String str) {
        long jCharAt = -3750763034362895579L;
        for (int i11 = 0; i11 < str.length(); i11++) {
            jCharAt = (jCharAt ^ ((long) str.charAt(i11))) * 1099511628211L;
        }
        return jCharAt;
    }

    public static Object J0(Type type) {
        Class<?> clsQ;
        if (X || (clsQ = Q(type)) == null) {
            return null;
        }
        String name = clsQ.getName();
        if (!"java.util.Optional".equals(name)) {
            return null;
        }
        if (W == null) {
            try {
                W = Class.forName(name).getMethod("empty", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused) {
                X = true;
            }
        }
        return W;
    }

    public static long K(String str) {
        long j11 = -3750763034362895579L;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt != '_' && cCharAt != '-') {
                if (cCharAt >= 'A' && cCharAt <= 'Z') {
                    cCharAt = (char) (cCharAt + ' ');
                }
                j11 = (j11 ^ ((long) cCharAt)) * 1099511628211L;
            }
        }
        return j11;
    }

    public static double K0(String str) {
        double d11;
        double d12;
        int length = str.length();
        if (length > 10) {
            return Double.parseDouble(str);
        }
        long j11 = 0;
        boolean z11 = false;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt == '-' && i12 == 0) {
                z11 = true;
            } else if (cCharAt == '.') {
                if (i11 != 0) {
                    return Double.parseDouble(str);
                }
                i11 = (length - i12) - 1;
            } else {
                if (cCharAt < '0' || cCharAt > '9') {
                    return Double.parseDouble(str);
                }
                j11 = (j11 * 10) + ((long) (cCharAt - '0'));
            }
        }
        if (z11) {
            j11 = -j11;
        }
        switch (i11) {
            case 0:
                return j11;
            case 1:
                d11 = j11;
                d12 = 10.0d;
                break;
            case 2:
                d11 = j11;
                d12 = 100.0d;
                break;
            case 3:
                d11 = j11;
                d12 = 1000.0d;
                break;
            case 4:
                d11 = j11;
                d12 = 10000.0d;
                break;
            case 5:
                d11 = j11;
                d12 = 100000.0d;
                break;
            case 6:
                d11 = j11;
                d12 = 1000000.0d;
                break;
            case 7:
                d11 = j11;
                d12 = 1.0E7d;
                break;
            case 8:
                d11 = j11;
                d12 = 1.0E8d;
                break;
            case 9:
                d11 = j11;
                d12 = 1.0E9d;
                break;
            default:
                return Double.parseDouble(str);
        }
        return d11 / d12;
    }

    public static long L(String str) {
        long j11 = -3750763034362895579L;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                cCharAt = (char) (cCharAt + ' ');
            }
            j11 = (j11 ^ ((long) cCharAt)) * 1099511628211L;
        }
        return j11;
    }

    public static float L0(String str) {
        float f11;
        float f12;
        int length = str.length();
        if (length >= 10) {
            return Float.parseFloat(str);
        }
        long j11 = 0;
        boolean z11 = false;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt == '-' && i12 == 0) {
                z11 = true;
            } else if (cCharAt == '.') {
                if (i11 != 0) {
                    return Float.parseFloat(str);
                }
                i11 = (length - i12) - 1;
            } else {
                if (cCharAt < '0' || cCharAt > '9') {
                    return Float.parseFloat(str);
                }
                j11 = (j11 * 10) + ((long) (cCharAt - '0'));
            }
        }
        if (z11) {
            j11 = -j11;
        }
        switch (i11) {
            case 0:
                return j11;
            case 1:
                f11 = j11;
                f12 = 10.0f;
                break;
            case 2:
                f11 = j11;
                f12 = 100.0f;
                break;
            case 3:
                f11 = j11;
                f12 = 1000.0f;
                break;
            case 4:
                f11 = j11;
                f12 = 10000.0f;
                break;
            case 5:
                f11 = j11;
                f12 = 100000.0f;
                break;
            case 6:
                f11 = j11;
                f12 = 1000000.0f;
                break;
            case 7:
                f11 = j11;
                f12 = 1.0E7f;
                break;
            case 8:
                f11 = j11;
                f12 = 1.0E8f;
                break;
            case 9:
                f11 = j11;
                f12 = 1.0E9f;
                break;
            default:
                return Float.parseFloat(str);
        }
        return f11 / f12;
    }

    public static Type M(Type type, Map<TypeVariable, Type> map) {
        if (type instanceof TypeVariable) {
            return map.get(type);
        }
        if (type instanceof ParameterizedType) {
            return F0(i0(type), ((ParameterizedType) type).getActualTypeArguments(), map);
        }
        return type instanceof GenericArrayType ? new GenericArrayTypeImpl(M(((GenericArrayType) type).getGenericComponentType(), map)) : type;
    }

    public static void M0(AccessibleObject accessibleObject) {
        if (f15505d && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (Throwable unused) {
                f15505d = false;
            }
        }
    }

    public static <A extends Annotation> A N(Class<?> cls, Class<A> cls2) {
        A a11 = (A) cls.getAnnotation(cls2);
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(cls);
        Class cls3 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls3 != null) {
            A a12 = (A) cls3.getAnnotation(cls2);
            Annotation[] annotations = cls3.getAnnotations();
            if (a12 == null && annotations.length > 0) {
                for (Annotation annotation : annotations) {
                    a12 = (A) annotation.annotationType().getAnnotation(cls2);
                    if (a12 != null) {
                        break;
                    }
                }
            }
            if (a12 != null) {
                return a12;
            }
        }
        Annotation[] annotations2 = cls.getAnnotations();
        if (a11 == null && annotations2.length > 0) {
            for (Annotation annotation2 : annotations2) {
                a11 = (A) annotation2.annotationType().getAnnotation(cls2);
                if (a11 != null) {
                    break;
                }
            }
        }
        return a11;
    }

    public static short N0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return (short) 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.shortValueExact() : bigDecimal.shortValue();
    }

    public static <A extends Annotation> A O(Field field, Class<A> cls) {
        A a11;
        A a12 = (A) field.getAnnotation(cls);
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(field.getDeclaringClass());
        Field declaredField = null;
        Class superclass = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (superclass != null) {
            String name = field.getName();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredField = superclass.getDeclaredField(name);
                    break;
                } catch (NoSuchFieldException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredField != null && (a11 = (A) declaredField.getAnnotation(cls)) != null) {
                return a11;
            }
        }
        return a12;
    }

    public static Locale O0(String str) {
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length == 1) {
            return new Locale(strArrSplit[0]);
        }
        return strArrSplit.length == 2 ? new Locale(strArrSplit[0], strArrSplit[1]) : new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
    }

    public static <A extends Annotation> A P(Method method, Class<A> cls) {
        A a11;
        A a12 = (A) method.getAnnotation(cls);
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(method.getDeclaringClass());
        Method declaredMethod = null;
        Class superclass = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (superclass != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredMethod = superclass.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredMethod != null && (a11 = (A) declaredMethod.getAnnotation(cls)) != null) {
                return a11;
            }
        }
        return a12;
    }

    public static Type P0(Type type) {
        if (!f15510i) {
            try {
                f15511j = Class.forName("java.util.Optional");
            } catch (Exception unused) {
            } finally {
                f15510i = true;
            }
        }
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getRawType() == f15511j ? parameterizedType.getActualTypeArguments()[0] : type;
    }

    public static Class<?> Q(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return Q(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            Type type2 = ((TypeVariable) type).getBounds()[0];
            return type2 instanceof Class ? (Class) type2 : Q(type2);
        }
        if (!(type instanceof WildcardType)) {
            return Object.class;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length == 1 ? Q(upperBounds[0]) : Object.class;
    }

    public static Class<?> R(String str) {
        return C.get(str);
    }

    public static Class<?> S(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        if (!(type2 instanceof Class)) {
            throw new JSONException("can not create ASMParser");
        }
        Class<?> cls = (Class) type2;
        if (Modifier.isPublic(cls.getModifiers())) {
            return cls;
        }
        throw new JSONException("can not create ASMParser");
    }

    public static Type T(Class<?> cls) {
        return cls.getName().startsWith("java.") ? Object.class : V(W(cls));
    }

    public static Type U(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (rawType == Collection.class) {
            return k0(actualTypeArguments[0]);
        }
        Class cls = (Class) rawType;
        Map<TypeVariable, Type> mapF = F(cls.getTypeParameters(), actualTypeArguments);
        Type typeW = W(cls);
        if (!(typeW instanceof ParameterizedType)) {
            return T((Class) typeW);
        }
        Class<?> clsI0 = i0(typeW);
        Type[] actualTypeArguments2 = ((ParameterizedType) typeW).getActualTypeArguments();
        return actualTypeArguments2.length > 0 ? U(F0(clsI0, actualTypeArguments2, mapF)) : T(clsI0);
    }

    public static Type V(Type type) {
        if (type instanceof ParameterizedType) {
            return U((ParameterizedType) type);
        }
        return type instanceof Class ? T((Class) type) : Object.class;
    }

    public static Type W(Class<?> cls) {
        Type type = null;
        for (Type type2 : cls.getGenericInterfaces()) {
            Class<?> clsI0 = i0(type2);
            if (clsI0 == Collection.class) {
                return type2;
            }
            if (Collection.class.isAssignableFrom(clsI0)) {
                type = type2;
            }
        }
        return type == null ? cls.getGenericSuperclass() : type;
    }

    public static Field X(Class<?> cls, String str, Field[] fieldArr) {
        char cCharAt;
        char cCharAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2 && (cCharAt = str.charAt(0)) >= 'a' && cCharAt <= 'z' && (cCharAt2 = str.charAt(1)) >= 'A' && cCharAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return X(superclass, str, superclass.getDeclaredFields());
    }

    public static List<com.alibaba.fastjson.util.d> Y(Class<?> cls, boolean z11, Map<String, com.alibaba.fastjson.util.d> map) {
        ArrayList arrayList = new ArrayList();
        j7.d dVar = (j7.d) N(cls, j7.d.class);
        String[] strArrOrders = dVar != null ? dVar.orders() : null;
        if (strArrOrders == null || strArrOrders.length <= 0) {
            arrayList.addAll(map.values());
            if (z11) {
                Collections.sort(arrayList);
            }
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
            for (com.alibaba.fastjson.util.d dVar2 : map.values()) {
                linkedHashMap.put(dVar2.f15532a, dVar2);
            }
            for (String str : strArrOrders) {
                com.alibaba.fastjson.util.d dVar3 = (com.alibaba.fastjson.util.d) linkedHashMap.get(str);
                if (dVar3 != null) {
                    arrayList.add(dVar3);
                    linkedHashMap.remove(str);
                }
            }
            arrayList.addAll(linkedHashMap.values());
        }
        return arrayList;
    }

    public static Type Z(Type type) {
        return (!(type instanceof ParameterizedType) && (type instanceof Class)) ? Z(((Class) type).getGenericSuperclass()) : type;
    }

    public static void a() {
        C.put("byte", Byte.TYPE);
        C.put("short", Short.TYPE);
        C.put("int", Integer.TYPE);
        C.put("long", Long.TYPE);
        C.put("float", Float.TYPE);
        C.put("double", Double.TYPE);
        C.put("boolean", Boolean.TYPE);
        C.put("char", Character.TYPE);
        C.put("[byte", byte[].class);
        C.put("[short", short[].class);
        C.put("[int", int[].class);
        C.put("[long", long[].class);
        C.put("[float", float[].class);
        C.put("[double", double[].class);
        C.put("[boolean", boolean[].class);
        C.put("[char", char[].class);
        C.put("[B", byte[].class);
        C.put("[S", short[].class);
        C.put("[I", int[].class);
        C.put("[J", long[].class);
        C.put("[F", float[].class);
        C.put("[D", double[].class);
        C.put("[C", char[].class);
        C.put("[Z", boolean[].class);
        Class<?>[] clsArr = {Object.class, Cloneable.class, A0("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, LinkedHashMap.class, Hashtable.class, TreeMap.class, IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, ArrayList.class, TimeUnit.class, ConcurrentHashMap.class, AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Number.class, String.class, BigDecimal.class, BigInteger.class, BitSet.class, Calendar.class, java.util.Date.class, Locale.class, UUID.class, SimpleDateFormat.class, JSONObject.class, com.alibaba.fastjson.c.class, JSONArray.class};
        for (int i11 = 0; i11 < 69; i11++) {
            Class<?> cls = clsArr[i11];
            if (cls != null) {
                C.put(cls.getName(), cls);
            }
        }
        i.b(T, C);
    }

    public static String[] a0(Class cls) {
        if (f15523v == null && !f15522u) {
            try {
                f15523v = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getConstructor(Class.class);
            } catch (Throwable unused) {
                f15522u = true;
            }
        }
        if (f15523v == null) {
            return null;
        }
        if (f15524w == null && !f15522u) {
            try {
                f15524w = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getMethod("getConstructors", new Class[0]);
            } catch (Throwable unused2) {
                f15522u = true;
            }
        }
        if (f15525x == null && !f15522u) {
            try {
                f15525x = KFunction.class.getMethod("getParameters", new Class[0]);
            } catch (Throwable unused3) {
                f15522u = true;
            }
        }
        if (f15526y == null && !f15522u) {
            try {
                f15526y = KParameter.class.getMethod("getName", new Class[0]);
            } catch (Throwable unused4) {
                f15522u = true;
            }
        }
        if (f15527z) {
            return null;
        }
        try {
            Iterator it = ((Iterable) f15524w.invoke(f15523v.newInstance(cls), new Object[0])).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) f15525x.invoke(next, new Object[0]);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            if (obj == null) {
                return null;
            }
            List list2 = (List) f15525x.invoke(obj, new Object[0]);
            String[] strArr = new String[list2.size()];
            for (int i11 = 0; i11 < list2.size(); i11++) {
                strArr[i11] = (String) f15526y.invoke(list2.get(i11), new Object[0]);
            }
            return strArr;
        } catch (Throwable th2) {
            th2.printStackTrace();
            f15527z = true;
            return null;
        }
    }

    public static void b(String str, Class<?> cls) {
        C.put(str, cls);
    }

    public static Constructor b0(Constructor[] constructorArr) {
        return c0(constructorArr, null);
    }

    public static f1 c(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy) {
        return d(cls, map, propertyNamingStrategy, false);
    }

    public static Constructor c0(Constructor[] constructorArr, String[] strArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if ((strArr == null || parameterTypes.length == strArr.length) && ((parameterTypes.length <= 0 || !parameterTypes[parameterTypes.length - 1].getName().equals("kotlin.jvm.internal.DefaultConstructorMarker")) && (constructor == null || constructor.getParameterTypes().length < parameterTypes.length))) {
                constructor = constructor2;
            }
        }
        return constructor;
    }

    public static f1 d(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, boolean z11) {
        PropertyNamingStrategy propertyNamingStrategy2;
        String[] strArr;
        String str;
        String str2;
        int i11;
        List<com.alibaba.fastjson.util.d> listE;
        j7.d dVar = (j7.d) N(cls, j7.d.class);
        if (dVar != null) {
            String[] strArrOrders = dVar.orders();
            String strTypeName = dVar.typeName();
            if (strTypeName.length() == 0) {
                strTypeName = null;
            }
            PropertyNamingStrategy propertyNamingStrategyNaming = dVar.naming();
            if (propertyNamingStrategyNaming == PropertyNamingStrategy.NeverUseThisValueExceptDefaultValue) {
                propertyNamingStrategyNaming = propertyNamingStrategy;
            }
            int iOf = SerializerFeature.of(dVar.serialzeFeatures());
            String strTypeKey = null;
            for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                j7.d dVar2 = (j7.d) N(superclass, j7.d.class);
                if (dVar2 == null) {
                    break;
                }
                strTypeKey = dVar2.typeKey();
                if (strTypeKey.length() != 0) {
                    break;
                }
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                j7.d dVar3 = (j7.d) N(cls2, j7.d.class);
                if (dVar3 != null) {
                    strTypeKey = dVar3.typeKey();
                    if (strTypeKey.length() != 0) {
                        break;
                    }
                }
            }
            str2 = (strTypeKey == null || strTypeKey.length() != 0) ? strTypeKey : null;
            str = strTypeName;
            propertyNamingStrategy2 = propertyNamingStrategyNaming;
            i11 = iOf;
            strArr = strArrOrders;
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy;
            strArr = null;
            str = null;
            str2 = null;
            i11 = 0;
        }
        HashMap map2 = new HashMap();
        l7.h.y(cls, map2);
        List<com.alibaba.fastjson.util.d> listE2 = z11 ? E(cls, map, false, propertyNamingStrategy2) : D(cls, dVar, map, map2, false, propertyNamingStrategy2);
        com.alibaba.fastjson.util.d[] dVarArr = new com.alibaba.fastjson.util.d[listE2.size()];
        listE2.toArray(dVarArr);
        if (strArr == null || strArr.length == 0) {
            ArrayList arrayList = new ArrayList(listE2);
            Collections.sort(arrayList);
            listE = arrayList;
        } else {
            listE = z11 ? E(cls, map, true, propertyNamingStrategy2) : D(cls, dVar, map, map2, true, propertyNamingStrategy2);
        }
        com.alibaba.fastjson.util.d[] dVarArr2 = new com.alibaba.fastjson.util.d[listE.size()];
        listE.toArray(dVarArr2);
        return new f1(cls, dVar, str, str2, i11, dVarArr, Arrays.equals(dVarArr2, dVarArr) ? dVarArr : dVarArr2);
    }

    public static Annotation[][] d0(Constructor constructor) {
        Annotation[][] parameterAnnotations;
        Constructor declaredConstructor;
        Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(constructor.getDeclaringClass());
        Constructor constructor2 = null;
        Class cls = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls != null) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            ArrayList arrayList = new ArrayList(2);
            for (Class<?> enclosingClass = cls.getEnclosingClass(); enclosingClass != null; enclosingClass = enclosingClass.getEnclosingClass()) {
                arrayList.add(enclosingClass);
            }
            int size = arrayList.size();
            for (Class superclass = cls; superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                try {
                    if (size != 0) {
                        Class<?>[] clsArr = new Class[parameterTypes.length + size];
                        System.arraycopy(parameterTypes, 0, clsArr, size, parameterTypes.length);
                        for (int i11 = size; i11 > 0; i11--) {
                            int i12 = i11 - 1;
                            clsArr[i12] = (Class) arrayList.get(i12);
                        }
                        declaredConstructor = cls.getDeclaredConstructor(clsArr);
                    } else {
                        declaredConstructor = cls.getDeclaredConstructor(parameterTypes);
                    }
                    constructor2 = declaredConstructor;
                    break;
                } catch (NoSuchMethodException unused) {
                    size--;
                }
            }
            if (constructor2 != null && (parameterAnnotations = constructor2.getParameterAnnotations()) != null) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    public static byte e(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return (byte) 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.byteValueExact() : bigDecimal.byteValue();
    }

    public static Annotation[][] e0(Method method) {
        Annotation[][] parameterAnnotations;
        Annotation[][] parameterAnnotations2 = method.getParameterAnnotations();
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(method.getDeclaringClass());
        Method declaredMethod = null;
        Class superclass = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (superclass != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredMethod = superclass.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredMethod != null && (parameterAnnotations = declaredMethod.getParameterAnnotations()) != null) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T f(Object obj, Class<T> cls, l7.h hVar) {
        Object obj2;
        int i11 = 0;
        if (obj == 0) {
            if (cls == Integer.TYPE) {
                return (T) 0;
            }
            if (cls == Long.TYPE) {
                return (T) 0L;
            }
            if (cls == Short.TYPE) {
                return (T) (short) 0;
            }
            if (cls == Byte.TYPE) {
                return (T) (byte) 0;
            }
            if (cls == Float.TYPE) {
                return (T) Float.valueOf(0.0f);
            }
            if (cls == Double.TYPE) {
                return (T) Double.valueOf(0.0d);
            }
            if (cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls == obj.getClass()) {
            return obj;
        }
        if (obj instanceof Map) {
            if (cls == Map.class) {
                return obj;
            }
            Map map = (Map) obj;
            return (cls != Object.class || map.containsKey(com.alibaba.fastjson.a.DEFAULT_TYPE_KEY)) ? (T) v(map, cls, hVar) : obj;
        }
        if (cls.isArray()) {
            if (obj instanceof Collection) {
                Collection collection = (Collection) obj;
                T t11 = (T) Array.newInstance(cls.getComponentType(), collection.size());
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Array.set(t11, i11, f(it.next(), cls.getComponentType(), hVar));
                    i11++;
                }
                return t11;
            }
            if (cls == byte[].class) {
                return (T) m(obj);
            }
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return (T) k(obj);
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return (T) l(obj);
        }
        if (cls == Character.TYPE || cls == Character.class) {
            return (T) n(obj);
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return (T) x(obj);
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return (T) t(obj);
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return (T) w(obj);
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return (T) s(obj);
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return (T) q(obj);
        }
        if (cls == String.class) {
            return (T) A(obj);
        }
        if (cls == BigDecimal.class) {
            return (T) i(obj);
        }
        if (cls == BigInteger.class) {
            return (T) j(obj);
        }
        if (cls == java.util.Date.class) {
            return (T) o(obj);
        }
        T t12 = (T) i.a(S, obj, cls);
        if (t12 != null) {
            return t12;
        }
        if (cls.isEnum()) {
            return (T) r(obj, cls, hVar);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            java.util.Date dateO = o(obj);
            if (cls == Calendar.class) {
                obj2 = (T) Calendar.getInstance(com.alibaba.fastjson.a.defaultTimeZone, com.alibaba.fastjson.a.defaultLocale);
            } else {
                try {
                    obj2 = (T) ((Calendar) cls.newInstance());
                } catch (Exception e11) {
                    throw new JSONException("can not cast to : " + cls.getName(), e11);
                }
            }
            ((Calendar) obj2).setTime(dateO);
            return (T) obj2;
        }
        String name = cls.getName();
        if (name.equals("javax.xml.datatype.XMLGregorianCalendar")) {
            java.util.Date dateO2 = o(obj);
            Calendar calendar = Calendar.getInstance(com.alibaba.fastjson.a.defaultTimeZone, com.alibaba.fastjson.a.defaultLocale);
            calendar.setTime(dateO2);
            return (T) v.f71756b.g(calendar);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (cls == Currency.class) {
                return (T) Currency.getInstance(str);
            }
            if (cls == Locale.class) {
                return (T) O0(str);
            }
            if (name.startsWith("java.time.")) {
                return (T) com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(str), cls);
            }
        }
        if (hVar.m(cls) != null) {
            return (T) com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(obj), cls);
        }
        throw new JSONException("can not cast to : " + cls.getName());
    }

    public static int f0(Class<?> cls) {
        j7.d dVar = (j7.d) N(cls, j7.d.class);
        if (dVar == null) {
            return 0;
        }
        return Feature.of(dVar.parseFeatures());
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [T, java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v6, types: [T, java.util.HashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v14, types: [T, java.util.Map$Entry] */
    public static <T> T g(Object obj, ParameterizedType parameterizedType, l7.h hVar) {
        Type rawType = parameterizedType.getRawType();
        if (rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List list = (List) obj;
                ?? r11 = (T) new ArrayList(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    r11.add(type instanceof Class ? (next == null || next.getClass() != JSONObject.class) ? f(next, (Class) type, hVar) : ((JSONObject) next).toJavaObject((Class) type, hVar, 0) : h(next, type, hVar));
                }
                return r11;
            }
        }
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == Collection.class || rawType == List.class || rawType == ArrayList.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                T t11 = (rawType == Set.class || rawType == HashSet.class) ? (T) new HashSet() : rawType == TreeSet.class ? (T) new TreeSet() : (T) new ArrayList();
                Iterator<T> it2 = ((Iterable) obj).iterator();
                while (it2.hasNext()) {
                    T next2 = it2.next();
                    ((Collection) t11).add(type2 instanceof Class ? (next2 == null || next2.getClass() != JSONObject.class) ? f(next2, (Class) type2, hVar) : ((JSONObject) next2).toJavaObject((Class) type2, hVar, 0) : h(next2, type2, hVar));
                }
                return t11;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type3 = parameterizedType.getActualTypeArguments()[0];
            Type type4 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r12 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r12.put(h(entry.getKey(), type3, hVar), h(entry.getValue(), type4, hVar));
                }
                return r12;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments.length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) h(obj, rawType, hVar);
        }
        if (rawType == Map.Entry.class && (obj instanceof Map)) {
            Map map = (Map) obj;
            if (map.size() == 1) {
                ?? r13 = (T) ((Map.Entry) map.entrySet().iterator().next());
                Object value = r13.getValue();
                if (actualTypeArguments.length == 2 && (value instanceof Map)) {
                    r13.setValue(h(value, actualTypeArguments[1], hVar));
                }
                return r13;
            }
        }
        if (rawType instanceof Class) {
            if (hVar == null) {
                hVar = l7.h.f70129z;
            }
            b2 b2VarP = hVar.p(rawType);
            if (b2VarP != null) {
                return (T) b2VarP.e(new l7.a(com.alibaba.fastjson.a.toJSONString(obj), hVar), parameterizedType, null);
            }
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }

    public static String g0(Map<String, Field> map, String str, String str2, int i11) {
        if (!f15504c || map.containsKey(str2)) {
            return str2;
        }
        String strSubstring = str.substring(i11);
        return map.containsKey(strSubstring) ? strSubstring : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T h(Object obj, Type type, l7.h hVar) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) f(obj, (Class) type, hVar);
        }
        if (type instanceof ParameterizedType) {
            return (T) g(obj, (ParameterizedType) type, hVar);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    public static String h0(String str) {
        return Character.toLowerCase(str.charAt(3)) + str.substring(4);
    }

    public static BigDecimal i(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Float) {
            Float f11 = (Float) obj;
            if (Float.isNaN(f11.floatValue()) || Float.isInfinite(f11.floatValue())) {
                return null;
            }
        } else if (obj instanceof Double) {
            Double d11 = (Double) obj;
            if (Double.isNaN(d11.doubleValue()) || Double.isInfinite(d11.doubleValue())) {
                return null;
            }
        } else {
            if (obj instanceof BigDecimal) {
                return (BigDecimal) obj;
            }
            if (obj instanceof BigInteger) {
                return new BigDecimal((BigInteger) obj);
            }
            if ((obj instanceof Map) && ((Map) obj).size() == 0) {
                return null;
            }
        }
        String string = obj.toString();
        if (string.length() == 0 || string.equalsIgnoreCase("null")) {
            return null;
        }
        if (string.length() <= 65535) {
            return new BigDecimal(string);
        }
        throw new JSONException("decimal overflow");
    }

    public static Class<?> i0(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return i0(((ParameterizedType) type).getRawType());
        }
        if (!(type instanceof WildcardType)) {
            throw new JSONException("TODO");
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        if (upperBounds.length == 1) {
            return i0(upperBounds[0]);
        }
        throw new JSONException("TODO");
    }

    public static BigInteger j(Object obj) {
        BigDecimal bigDecimal;
        int iScale;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Float) {
            Float f11 = (Float) obj;
            if (Float.isNaN(f11.floatValue()) || Float.isInfinite(f11.floatValue())) {
                return null;
            }
            return BigInteger.valueOf(f11.longValue());
        }
        if (obj instanceof Double) {
            Double d11 = (Double) obj;
            if (Double.isNaN(d11.doubleValue()) || Double.isInfinite(d11.doubleValue())) {
                return null;
            }
            return BigInteger.valueOf(d11.longValue());
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof BigDecimal) && (iScale = (bigDecimal = (BigDecimal) obj).scale()) > -1000 && iScale < 1000) {
            return bigDecimal.toBigInteger();
        }
        String string = obj.toString();
        if (string.length() == 0 || string.equalsIgnoreCase("null")) {
            return null;
        }
        if (string.length() <= 65535) {
            return new BigInteger(string);
        }
        throw new JSONException("decimal overflow");
    }

    public static j7.b j0(Class<?> cls, Method method) {
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> cls2 : interfaces) {
                for (Method method2 : cls2.getMethods()) {
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i11 = 0;
                        while (true) {
                            if (i11 >= parameterTypes.length) {
                                j7.b bVar = (j7.b) P(method2, j7.b.class);
                                if (bVar == null) {
                                    break;
                                }
                                return bVar;
                            }
                            if (!parameterTypes2[i11].equals(parameterTypes[i11])) {
                                break;
                            }
                            i11++;
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i12 = 0;
                    while (true) {
                        if (i12 >= parameterTypes3.length) {
                            j7.b bVar2 = (j7.b) P(method3, j7.b.class);
                            if (bVar2 == null) {
                                break;
                            }
                            return bVar2;
                        }
                        if (!parameterTypes4[i12].equals(parameterTypes3[i12])) {
                            break;
                        }
                        i12++;
                    }
                }
            }
        }
        return null;
    }

    public static Boolean k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof BigDecimal) {
            return Boolean.valueOf(l0((BigDecimal) obj) == 1);
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
            if ("Y".equalsIgnoreCase(str) || RequestConfiguration.MAX_AD_CONTENT_RATING_T.equals(str)) {
                return Boolean.TRUE;
            }
            if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new JSONException("can not cast to boolean, value : " + obj);
    }

    public static Type k0(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length > 0 ? upperBounds[0] : Object.class;
    }

    public static Byte l(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Byte.valueOf(e((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        if (obj instanceof Boolean) {
            return Byte.valueOf(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static int l0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.intValueExact() : bigDecimal.intValue();
    }

    public static byte[] m(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return com.alibaba.fastjson.util.f.c((String) obj);
        }
        throw new JSONException("can not cast to byte[], value : " + obj);
    }

    public static boolean m0(Method method) {
        if (method == null) {
            return false;
        }
        if (f15516o == null && !f15517p) {
            try {
                f15516o = Class.forName("javax.persistence.ManyToMany");
            } catch (Throwable unused) {
                f15517p = true;
            }
        }
        if (f15516o != null) {
            return method.isAnnotationPresent(f15514m) || method.isAnnotationPresent(f15516o);
        }
        return false;
    }

    public static Character n(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to char, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new JSONException("can not cast to char, value : " + obj);
    }

    public static boolean n0(Method method) {
        if (method == null) {
            return false;
        }
        if (f15514m == null && !f15515n) {
            try {
                f15514m = Class.forName("javax.persistence.OneToMany");
            } catch (Throwable unused) {
                f15515n = true;
            }
        }
        Class<? extends Annotation> cls = f15514m;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static java.util.Date o(Object obj) {
        return p(obj, null);
    }

    public static boolean o0(Class cls) {
        Boolean bool = (Boolean) i.b(O, cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static java.util.Date p(Object obj, String str) {
        long j11;
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.util.Date) {
            return (java.util.Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof BigDecimal) {
            return new java.util.Date(E0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            long jLongValue = ((Number) obj).longValue();
            if ("unixtime".equals(str)) {
                jLongValue *= 1000;
            }
            return new java.util.Date(jLongValue);
        }
        if (obj instanceof String) {
            String strSubstring = (String) obj;
            l7.e eVar = new l7.e(strSubstring);
            try {
                if (eVar.q1(false)) {
                    java.util.Date time = eVar.C0().getTime();
                    eVar.close();
                    return time;
                }
                eVar.close();
                if (strSubstring.startsWith("/Date(") && strSubstring.endsWith(")/")) {
                    strSubstring = strSubstring.substring(6, strSubstring.length() - 2);
                }
                if (strSubstring.indexOf(45) > 0 || strSubstring.indexOf(43) > 0 || str != null) {
                    if (str == null) {
                        int length = strSubstring.length();
                        if (length == com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT.length() || (length == 22 && com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT.equals("yyyyMMddHHmmssSSSZ"))) {
                            str = com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT;
                        } else if (length == 10) {
                            str = "yyyy-MM-dd";
                        } else if (length == 19) {
                            str = "yyyy-MM-dd HH:mm:ss";
                        } else if (length == 29 && strSubstring.charAt(26) == ':' && strSubstring.charAt(28) == '0') {
                            str = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
                        } else {
                            str = (length == 23 && strSubstring.charAt(19) == ',') ? "yyyy-MM-dd HH:mm:ss,SSS" : "yyyy-MM-dd HH:mm:ss.SSS";
                        }
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, com.alibaba.fastjson.a.defaultLocale);
                    simpleDateFormat.setTimeZone(com.alibaba.fastjson.a.defaultTimeZone);
                    try {
                        return simpleDateFormat.parse(strSubstring);
                    } catch (ParseException unused) {
                        throw new JSONException("can not cast to Date, value : " + strSubstring);
                    }
                }
                if (strSubstring.length() == 0) {
                    return null;
                }
                j11 = Long.parseLong(strSubstring);
            } catch (Throwable th2) {
                eVar.close();
                throw th2;
            }
        } else {
            j11 = -1;
        }
        if (j11 != -1) {
            return new java.util.Date(j11);
        }
        Class<?> cls = obj.getClass();
        if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
            if (f15507f == null && !f15506e) {
                try {
                    f15507f = cls.getMethod("toJdbc", new Class[0]);
                } catch (NoSuchMethodException unused2) {
                } finally {
                    f15506e = true;
                }
            }
            try {
                return (java.util.Date) f15507f.invoke(obj, new Object[0]);
            } catch (Exception e11) {
                throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e11);
            }
        }
        if (!"oracle.sql.DATE".equals(cls.getName())) {
            throw new JSONException("can not cast to Date, value : " + obj);
        }
        if (f15509h == null && !f15508g) {
            try {
                f15509h = cls.getMethod("toJdbc", new Class[0]);
            } catch (NoSuchMethodException unused3) {
            } finally {
                f15508g = true;
            }
        }
        try {
            return (java.util.Date) f15509h.invoke(obj, new Object[0]);
        } catch (Exception e12) {
            throw new JSONException("can not cast oracle.sql.DATE to Date", e12);
        }
    }

    public static boolean p0(Type type) {
        Type genericSuperclass;
        if (type instanceof ParameterizedType) {
            return true;
        }
        return (type instanceof Class) && (genericSuperclass = ((Class) type).getGenericSuperclass()) != Object.class && p0(genericSuperclass);
    }

    public static Double q(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                return Double.valueOf(((Boolean) obj).booleanValue() ? 1.0d : 0.0d);
            }
            throw new JSONException("can not cast to double, value : " + obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
            return null;
        }
        if (string.indexOf(44) != -1) {
            string = string.replaceAll(",", "");
        }
        return Double.valueOf(Double.parseDouble(string));
    }

    public static boolean q0(Object obj) {
        if (obj == null) {
            return false;
        }
        if (f15518q == null && !f15519r) {
            try {
                f15518q = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", Object.class);
            } catch (Throwable unused) {
                f15519r = true;
            }
        }
        Method method = f15518q;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(null, obj)).booleanValue();
            } catch (Throwable unused2) {
            }
        }
        return true;
    }

    public static <T> T r(Object obj, Class<T> cls, l7.h hVar) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                if (hVar == null) {
                    hVar = l7.h.t();
                }
                b2 b2VarP = hVar.p(cls);
                return b2VarP instanceof m7.h ? (T) ((m7.h) b2VarP).c(J(str)) : (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof BigDecimal) {
                int iL0 = l0((BigDecimal) obj);
                T[] enumConstants = cls.getEnumConstants();
                if (iL0 < enumConstants.length) {
                    return enumConstants[iL0];
                }
            }
            if (obj instanceof Number) {
                int iIntValue = ((Number) obj).intValue();
                T[] enumConstants2 = cls.getEnumConstants();
                if (iIntValue < enumConstants2.length) {
                    return enumConstants2[iIntValue];
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e11) {
            throw new JSONException("can not cast to : " + cls.getName(), e11);
        }
    }

    public static boolean r0(Class<?> cls, String str) {
        j7.d dVar = (j7.d) N(cls, j7.d.class);
        if (dVar != null) {
            String[] strArrIncludes = dVar.includes();
            if (strArrIncludes.length > 0) {
                for (String str2 : strArrIncludes) {
                    if (str.equals(str2)) {
                        return false;
                    }
                }
                return true;
            }
            for (String str3 : dVar.ignores()) {
                if (str.equals(str3)) {
                    return true;
                }
            }
        }
        if (cls.getSuperclass() == Object.class || cls.getSuperclass() == null) {
            return false;
        }
        return r0(cls.getSuperclass(), str);
    }

    public static Float s(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                return Float.valueOf(((Boolean) obj).booleanValue() ? 1.0f : 0.0f);
            }
            throw new JSONException("can not cast to float, value : " + obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
            return null;
        }
        if (string.indexOf(44) != -1) {
            string = string.replaceAll(",", "");
        }
        return Float.valueOf(Float.parseFloat(string));
    }

    public static boolean s0(Method method) {
        if (method == null) {
            return false;
        }
        if (F == null && !G) {
            try {
                F = Class.forName("com.fasterxml.jackson.annotation.JsonCreator");
            } catch (Throwable unused) {
                G = true;
            }
        }
        Class<? extends Annotation> cls = F;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static Integer t(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof BigDecimal) {
            return Integer.valueOf(l0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String strReplaceAll = (String) obj;
            if (strReplaceAll.length() == 0 || "null".equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != -1) {
                strReplaceAll = strReplaceAll.replaceAll(",", "");
            }
            Matcher matcher = f15502a.matcher(strReplaceAll);
            if (matcher.find()) {
                strReplaceAll = matcher.replaceAll("");
            }
            return Integer.valueOf(Integer.parseInt(strReplaceAll));
        }
        if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return t(it.next());
            }
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static boolean t0(Class cls) {
        if (f15520s == null && !f15521t) {
            try {
                f15520s = Metadata.class;
            } catch (Throwable unused) {
                f15521t = true;
            }
        }
        return f15520s != null && cls.isAnnotationPresent(f15520s);
    }

    public static <T> T u(Object obj, Class<T> cls) {
        return (T) f(obj, cls, l7.h.t());
    }

    public static boolean u0(Class cls, String str) {
        String[] strArr;
        if (A == null && !B) {
            try {
                HashMap map = new HashMap();
                CharRange.Companion companion = CharRange.f68958f;
                map.put(CharRange.class, new String[]{"getEndInclusive", "isEmpty"});
                IntRange.Companion companion2 = IntRange.f68968f;
                map.put(IntRange.class, new String[]{"getEndInclusive", "isEmpty"});
                LongRange.Companion companion3 = LongRange.f68978f;
                map.put(LongRange.class, new String[]{"getEndInclusive", "isEmpty"});
                map.put(b20.b.class, new String[]{"getEndInclusive", "isEmpty"});
                map.put(b20.a.class, new String[]{"getEndInclusive", "isEmpty"});
                A = map;
            } catch (Throwable unused) {
                B = true;
            }
        }
        return (A == null || (strArr = A.get(cls)) == null || Arrays.binarySearch(strArr, str) < 0) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T v(Map<String, Object> map, Class<T> cls, l7.h hVar) {
        int iIntValueExact = 0;
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    iIntValueExact = number instanceof BigDecimal ? ((BigDecimal) number).intValueExact() : number.intValue();
                }
                return (T) new StackTraceElement(str, str2, str3, iIntValueExact);
            }
            Object obj = map.get(com.alibaba.fastjson.a.DEFAULT_TYPE_KEY);
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (hVar == null) {
                    hVar = l7.h.f70129z;
                }
                Class<?> clsI = hVar.i(str4, null);
                if (clsI == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                }
                if (!clsI.equals(cls)) {
                    return (T) v(map, clsI, hVar);
                }
            }
            if (cls.isInterface()) {
                JSONObject jSONObject = map instanceof JSONObject ? (JSONObject) map : new JSONObject(map);
                if (hVar == null) {
                    hVar = l7.h.t();
                }
                return hVar.m(cls) != null ? (T) com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(jSONObject), cls) : (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
            }
            if (cls == Locale.class) {
                Object obj2 = map.get("language");
                Object obj3 = map.get(PlaceTypes.COUNTRY);
                if (obj2 instanceof String) {
                    String str5 = (String) obj2;
                    if (obj3 instanceof String) {
                        return (T) new Locale(str5, (String) obj3);
                    }
                    if (obj3 == null) {
                        return (T) new Locale(str5);
                    }
                }
            }
            if (cls == String.class && (map instanceof JSONObject)) {
                return (T) map.toString();
            }
            if (cls == com.alibaba.fastjson.a.class && (map instanceof JSONObject)) {
                return map;
            }
            if (cls == LinkedHashMap.class && (map instanceof JSONObject)) {
                T t11 = (T) ((JSONObject) map).getInnerMap();
                if (t11 instanceof LinkedHashMap) {
                    return t11;
                }
            }
            if (cls.isInstance(map)) {
                return map;
            }
            if (cls == JSONObject.class) {
                return (T) new JSONObject(map);
            }
            if (hVar == null) {
                hVar = l7.h.t();
            }
            b2 b2VarP = hVar.p(cls);
            o oVar = b2VarP instanceof o ? (o) b2VarP : null;
            if (oVar != null) {
                return (T) oVar.f(map, hVar);
            }
            throw new JSONException("can not get javaBeanDeserializer. " + cls.getName());
        } catch (Exception e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }

    public static boolean v0(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '+' || cCharAt == '-') {
                if (i11 != 0) {
                    return false;
                }
            } else if (cCharAt < '0' || cCharAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static Long w(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Long.valueOf(E0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String strReplaceAll = (String) obj;
            if (strReplaceAll.length() == 0 || "null".equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != -1) {
                strReplaceAll = strReplaceAll.replaceAll(",", "");
            }
            try {
                return Long.valueOf(Long.parseLong(strReplaceAll));
            } catch (NumberFormatException unused) {
                l7.e eVar = new l7.e(strReplaceAll);
                Calendar calendarC0 = eVar.q1(false) ? eVar.C0() : null;
                eVar.close();
                if (calendarC0 != null) {
                    return Long.valueOf(calendarC0.getTimeInMillis());
                }
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return w(it.next());
            }
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        throw new JSONException("can not cast to long, value : " + obj);
    }

    public static boolean w0(Class<?> cls) {
        if (D == null && !E) {
            try {
                D = Class.forName("java.nio.file.Path");
            } catch (Throwable unused) {
                E = true;
            }
        }
        Class<?> cls2 = D;
        if (cls2 != null) {
            return cls2.isAssignableFrom(cls);
        }
        return false;
    }

    public static Short x(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Short.valueOf(N0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        if (obj instanceof Boolean) {
            return Short.valueOf(((Boolean) obj).booleanValue() ? (short) 1 : (short) 0);
        }
        throw new JSONException("can not cast to short, value : " + obj);
    }

    public static boolean x0(Class<?> cls) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (V.contains(cls2.getName())) {
                return true;
            }
        }
        return false;
    }

    public static Object y(Object obj) {
        return i.b(P, obj);
    }

    public static boolean y0(Method method) {
        if (method == null) {
            return false;
        }
        if (!f15512k) {
            try {
                f15513l = Class.forName("java.beans.Transient");
            } catch (Exception unused) {
            } finally {
                f15512k = true;
            }
        }
        Class<? extends Annotation> cls = f15513l;
        return (cls == null || P(method, cls) == null) ? false : true;
    }

    public static Object z(Object obj) {
        return i.b(Q, obj);
    }

    public static boolean z0(Class cls) {
        Annotation annotationN;
        Object objInvoke;
        if (I == null && !J) {
            try {
                I = Class.forName("javax.xml.bind.annotation.XmlAccessorType");
            } catch (Throwable unused) {
                J = true;
            }
        }
        if (I == null || (annotationN = N(cls, I)) == null) {
            return false;
        }
        if (K == null && !J) {
            try {
                K = I.getMethod(AppMeasurementSdk.ConditionalUserProperty.VALUE, new Class[0]);
            } catch (Throwable unused2) {
                J = true;
            }
        }
        if (K == null) {
            return false;
        }
        if (J) {
            objInvoke = null;
        } else {
            try {
                objInvoke = K.invoke(annotationN, new Object[0]);
            } catch (Throwable unused3) {
                J = true;
                objInvoke = null;
            }
        }
        if (objInvoke == null) {
            return false;
        }
        if (H == null && !J) {
            try {
                H = Class.forName("javax.xml.bind.annotation.XmlAccessType");
                L = H.getField("FIELD");
                M = L.get(null);
            } catch (Throwable unused4) {
                J = true;
            }
        }
        return objInvoke == M;
    }
}
