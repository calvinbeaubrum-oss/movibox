package n7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;
import m7.d3;
import m7.y1;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class g1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g1 f71628j = new g1();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f71629k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f71630l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f71631m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f71632n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f71633o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f71634p = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f71635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f71636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f71637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PropertyNamingStrategy f71638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.alibaba.fastjson.util.g<Type, z0> f71639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.alibaba.fastjson.util.g<Type, com.alibaba.fastjson.util.g<Type, z0>> f71640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f71641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long[] f71642h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<o7.a> f71643i;

    public g1() {
        this(8192);
    }

    public g1(int i11) {
        this(i11, false);
    }

    public g1(int i11, boolean z11) {
        this.f71635a = !com.alibaba.fastjson.util.b.f15531b;
        this.f71637c = com.alibaba.fastjson.a.DEFAULT_TYPE_KEY;
        this.f71642h = new long[]{4165360493669296979L, 4446674157046724083L};
        this.f71643i = new ArrayList();
        this.f71641g = z11;
        this.f71639e = new com.alibaba.fastjson.util.g<>(i11);
        this.f71640f = new com.alibaba.fastjson.util.g<>(16);
        try {
            if (this.f71635a) {
                this.f71636b = new a();
            }
        } catch (Throwable unused) {
            this.f71635a = false;
        }
        j();
    }

    public static Member f(Class cls) {
        Field field = null;
        for (Method method : cls.getMethods()) {
            if (method.getReturnType() != Void.class && ((j7.b) method.getAnnotation(j7.b.class)) != null) {
                if (field != null) {
                    return null;
                }
                field = method;
            }
        }
        for (Field field2 : cls.getFields()) {
            if (((j7.b) field2.getAnnotation(j7.b.class)) != null) {
                if (field != null) {
                    return null;
                }
                field = field2;
            }
        }
        return field;
    }

    public static g1 g() {
        return f71628j;
    }

    public final p0 a(f1 f1Var) throws Exception {
        p0 p0VarZ = this.f71636b.z(f1Var);
        int i11 = 0;
        while (true) {
            g0[] g0VarArr = p0VarZ.f71715k;
            if (i11 >= g0VarArr.length) {
                return p0VarZ;
            }
            Class<?> cls = g0VarArr[i11].f71611a.f15536f;
            if (cls.isEnum() && !(h(cls) instanceof e0)) {
                p0VarZ.f71659i = false;
            }
            i11++;
        }
    }

    public final z0 b(Class<?> cls) {
        String name = cls.getName();
        if (Arrays.binarySearch(this.f71642h, TypeUtils.J(name)) < 0) {
            f1 f1VarD = TypeUtils.d(cls, null, this.f71638d, this.f71641g);
            return (f1VarD.f71608e.length == 0 && Iterable.class.isAssignableFrom(cls)) ? w0.f71761b : c(f1VarD);
        }
        throw new JSONException("not support class : " + name);
    }

    /* JADX WARN: Code duplicated, block: B:123:0x0164 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:137:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public z0 c(f1 f1Var) {
        p0 p0VarA;
        Method method;
        j7.d dVar = f1Var.f71607d;
        boolean z11 = this.f71635a && !this.f71641g;
        if (dVar != null) {
            Class<?> clsSerializer = dVar.serializer();
            if (clsSerializer != Void.class) {
                try {
                    Object objNewInstance = clsSerializer.newInstance();
                    if (objNewInstance instanceof z0) {
                        return (z0) objNewInstance;
                    }
                } catch (Throwable unused) {
                }
            }
            if (!dVar.asm()) {
                z11 = false;
            }
            if (z11) {
                for (SerializerFeature serializerFeature : dVar.serialzeFeatures()) {
                    if (SerializerFeature.WriteNonStringValueAsString == serializerFeature || SerializerFeature.WriteEnumUsingToString == serializerFeature || SerializerFeature.NotWriteDefaultValue == serializerFeature || SerializerFeature.BrowserCompatible == serializerFeature) {
                        z11 = false;
                        break;
                    }
                }
            }
            if (z11 && dVar.serialzeFilters().length != 0) {
                z11 = false;
            }
        }
        Class<?> cls = f1Var.f71604a;
        if (!Modifier.isPublic(cls.getModifiers())) {
            return new p0(f1Var);
        }
        if ((z11 && this.f71636b.f71580a.c(cls)) || cls == Serializable.class || cls == Object.class) {
            z11 = false;
        }
        if (z11 && !com.alibaba.fastjson.util.b.a(cls.getSimpleName())) {
            z11 = false;
        }
        if (z11 && f1Var.f71604a.isInterface()) {
            z11 = false;
        }
        if (z11) {
            for (com.alibaba.fastjson.util.d dVar2 : f1Var.f71608e) {
                Field field = dVar2.f15534c;
                if ((field == null || field.getType().equals(dVar2.f15536f)) && (((method = dVar2.f15533b) == null || method.getReturnType().equals(dVar2.f15536f)) && (!dVar2.f15536f.isEnum() || d(dVar2.f15536f) == e0.f71597b))) {
                    j7.b bVarD = dVar2.d();
                    if (bVarD != null) {
                        String str = bVarD.format();
                        if ((str.length() == 0 || (dVar2.f15536f == String.class && "trim".equals(str))) && com.alibaba.fastjson.util.b.a(bVarD.name()) && !bVarD.jsonDirect() && bVarD.serializeUsing() == Void.class && !bVarD.unwrapped()) {
                            for (SerializerFeature serializerFeature2 : bVarD.serialzeFeatures()) {
                                if (SerializerFeature.WriteNonStringValueAsString == serializerFeature2 || SerializerFeature.WriteEnumUsingToString == serializerFeature2 || SerializerFeature.NotWriteDefaultValue == serializerFeature2 || SerializerFeature.BrowserCompatible == serializerFeature2 || SerializerFeature.WriteClassName == serializerFeature2) {
                                    z11 = false;
                                    break;
                                }
                            }
                            if (TypeUtils.n0(method) || TypeUtils.m0(method) || (bVarD.defaultValue() != null && !"".equals(bVarD.defaultValue()))) {
                            }
                        }
                    }
                }
            }
            if (z11) {
                try {
                    p0VarA = a(f1Var);
                    if (p0VarA != null) {
                        return p0VarA;
                    }
                } catch (ClassCastException | ClassFormatError | ClassNotFoundException unused2) {
                } catch (OutOfMemoryError e11) {
                    if (e11.getMessage().indexOf("Metaspace") != -1) {
                        throw e11;
                    }
                } catch (Throwable th2) {
                    throw new JSONException("create asm serializer error, verson 1.2.83, class " + cls, th2);
                }
            }
        } else if (z11) {
            p0VarA = a(f1Var);
            if (p0VarA != null) {
                return p0VarA;
            }
        }
        return new p0(f1Var);
    }

    public final z0 d(Type type) {
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            return this.f71639e.b(type);
        }
        com.alibaba.fastjson.util.g<Type, z0> gVarB = this.f71640f.b(type);
        if (gVarB == null) {
            return null;
        }
        return gVarB.b(mixInAnnotations);
    }

    public z0 e() {
        return e0.f71597b;
    }

    public z0 h(Class<?> cls) {
        return i(cls, true);
    }

    /* JADX WARN: Code duplicated, block: B:274:0x050c  */
    /* JADX WARN: Code duplicated, block: B:330:? A[RETURN, SYNTHETIC] */
    public z0 i(Class<?> cls, boolean z11) {
        z0 z0VarB;
        Class<?> cls2;
        ClassLoader classLoader;
        z0 z0VarD = d(cls);
        if (z0VarD != null) {
            return z0VarD;
        }
        try {
            for (Object obj : com.alibaba.fastjson.util.l.a(n.class, Thread.currentThread().getContextClassLoader())) {
                if (obj instanceof n) {
                    n nVar = (n) obj;
                    Iterator<Type> it = nVar.a().iterator();
                    while (it.hasNext()) {
                        k(it.next(), nVar);
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        z0 z0VarD2 = d(cls);
        if (z0VarD2 == null && (classLoader = com.alibaba.fastjson.a.class.getClassLoader()) != Thread.currentThread().getContextClassLoader()) {
            try {
                for (Object obj2 : com.alibaba.fastjson.util.l.a(n.class, classLoader)) {
                    if (obj2 instanceof n) {
                        n nVar2 = (n) obj2;
                        Iterator<Type> it2 = nVar2.a().iterator();
                        while (it2.hasNext()) {
                            k(it2.next(), nVar2);
                        }
                    }
                }
            } catch (ClassCastException unused2) {
            }
            z0VarD2 = d(cls);
        }
        Iterator<o7.a> it3 = this.f71643i.iterator();
        while (it3.hasNext()) {
            z0VarD2 = it3.next().b(this, cls);
            if (z0VarD2 != null) {
                k(cls, z0VarD2);
                return z0VarD2;
            }
        }
        if (z0VarD2 != null) {
            return z0VarD2;
        }
        String name = cls.getName();
        if (Map.class.isAssignableFrom(cls)) {
            z0VarB = v0.f71758j;
            k(cls, z0VarB);
        } else if (List.class.isAssignableFrom(cls)) {
            z0VarB = t0.f71750a;
            k(cls, z0VarB);
        } else if (Collection.class.isAssignableFrom(cls)) {
            z0VarB = z.f71767a;
            k(cls, z0VarB);
        } else if (Date.class.isAssignableFrom(cls)) {
            z0VarB = c0.f71593a;
            k(cls, z0VarB);
        } else if (com.alibaba.fastjson.b.class.isAssignableFrom(cls)) {
            z0VarB = k0.f71691a;
            k(cls, z0VarB);
        } else if (m0.class.isAssignableFrom(cls)) {
            z0VarB = n0.f71698a;
            k(cls, z0VarB);
        } else if (com.alibaba.fastjson.e.class.isAssignableFrom(cls)) {
            z0VarB = w0.f71761b;
            k(cls, z0VarB);
        } else {
            Member memberF = null;
            if (cls.isEnum()) {
                Class cls3 = (Class) com.alibaba.fastjson.a.getMixInAnnotations(cls);
                j7.d dVar = cls3 != null ? (j7.d) TypeUtils.N(cls3, j7.d.class) : (j7.d) TypeUtils.N(cls, j7.d.class);
                if (dVar == null || !dVar.serializeEnumAsJavaBean()) {
                    if (cls3 != null) {
                        Member memberF2 = f(cls3);
                        if (memberF2 != null) {
                            try {
                                if (memberF2 instanceof Method) {
                                    Method method = (Method) memberF2;
                                    memberF = cls.getMethod(method.getName(), method.getParameterTypes());
                                }
                            } catch (Exception unused3) {
                            }
                        }
                    } else {
                        memberF = f(cls);
                    }
                    if (memberF != null) {
                        z0VarB = new e0(memberF);
                        k(cls, z0VarB);
                    } else {
                        z0VarB = e();
                        k(cls, z0VarB);
                    }
                } else {
                    z0VarB = b(cls);
                    k(cls, z0VarB);
                }
            } else {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == null || !superclass.isEnum()) {
                    if (cls.isArray()) {
                        Class<?> componentType = cls.getComponentType();
                        z0 lVar = new l(componentType, h(componentType));
                        k(cls, lVar);
                        z0VarD2 = lVar;
                    } else if (Throwable.class.isAssignableFrom(cls)) {
                        f1 f1VarC = TypeUtils.c(cls, null, this.f71638d);
                        f1VarC.f71610g |= SerializerFeature.WriteClassName.mask;
                        z0VarD2 = new p0(f1VarC);
                        k(cls, z0VarD2);
                    } else if (TimeZone.class.isAssignableFrom(cls) || Map.Entry.class.isAssignableFrom(cls)) {
                        z0VarB = w0.f71761b;
                        k(cls, z0VarB);
                    } else if (Appendable.class.isAssignableFrom(cls)) {
                        z0VarB = k.f71690a;
                        k(cls, z0VarB);
                    } else if (Charset.class.isAssignableFrom(cls)) {
                        z0VarB = l1.f71696a;
                        k(cls, z0VarB);
                    } else if (Enumeration.class.isAssignableFrom(cls)) {
                        z0VarB = f0.f71603a;
                        k(cls, z0VarB);
                    } else if (Calendar.class.isAssignableFrom(cls) || XMLGregorianCalendar.class.isAssignableFrom(cls)) {
                        z0VarB = v.f71756b;
                        k(cls, z0VarB);
                    } else if (TypeUtils.o0(cls)) {
                        z0VarB = y.f71765a;
                        k(cls, z0VarB);
                    } else if (TypeUtils.w0(cls)) {
                        z0VarB = l1.f71696a;
                        k(cls, z0VarB);
                    } else if (Iterator.class.isAssignableFrom(cls)) {
                        z0VarB = w0.f71761b;
                        k(cls, z0VarB);
                    } else if (Node.class.isAssignableFrom(cls)) {
                        z0VarB = w0.f71761b;
                        k(cls, z0VarB);
                    } else {
                        int i11 = 0;
                        if (name.startsWith("java.awt.") && o.k(cls) && !f71629k) {
                            try {
                                String[] strArr = {"java.awt.Color", "java.awt.Font", "java.awt.Point", "java.awt.Rectangle"};
                                for (int i12 = 0; i12 < 4; i12++) {
                                    String str = strArr[i12];
                                    if (str.equals(name)) {
                                        Type cls4 = Class.forName(str);
                                        z0VarD2 = o.f71699a;
                                        k(cls4, z0VarD2);
                                        return z0VarD2;
                                    }
                                }
                            } catch (Throwable unused4) {
                                f71629k = true;
                            }
                        }
                        if (!f71630l && (name.startsWith("java.time.") || name.startsWith("java.util.Optional") || name.equals("java.util.concurrent.atomic.LongAdder") || name.equals("java.util.concurrent.atomic.DoubleAdder"))) {
                            try {
                                String[] strArr2 = {"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.Period", "java.time.Duration", "java.time.Instant"};
                                for (int i13 = 0; i13 < 11; i13++) {
                                    String str2 = strArr2[i13];
                                    if (str2.equals(name)) {
                                        Type cls5 = Class.forName(str2);
                                        z0 z0Var = y1.f70915a;
                                        k(cls5, z0Var);
                                        return z0Var;
                                    }
                                }
                                String[] strArr3 = {"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"};
                                for (int i14 = 0; i14 < 4; i14++) {
                                    String str3 = strArr3[i14];
                                    if (str3.equals(name)) {
                                        Type cls6 = Class.forName(str3);
                                        z0 z0Var2 = d3.f70880a;
                                        k(cls6, z0Var2);
                                        return z0Var2;
                                    }
                                }
                                String[] strArr4 = {"java.util.concurrent.atomic.LongAdder", "java.util.concurrent.atomic.DoubleAdder"};
                                for (int i15 = 0; i15 < 2; i15++) {
                                    String str4 = strArr4[i15];
                                    if (str4.equals(name)) {
                                        Type cls7 = Class.forName(str4);
                                        z0 z0Var3 = h.f71644a;
                                        k(cls7, z0Var3);
                                        return z0Var3;
                                    }
                                }
                            } catch (Throwable unused5) {
                                f71630l = true;
                            }
                        }
                        if (!f71631m && name.startsWith("oracle.sql.")) {
                            try {
                                String[] strArr5 = {"oracle.sql.DATE", "oracle.sql.TIMESTAMP"};
                                for (int i16 = 0; i16 < 2; i16++) {
                                    String str5 = strArr5[i16];
                                    if (str5.equals(name)) {
                                        Type cls8 = Class.forName(str5);
                                        z0VarD2 = c0.f71593a;
                                        k(cls8, z0VarD2);
                                        return z0VarD2;
                                    }
                                }
                            } catch (Throwable unused6) {
                                f71631m = true;
                            }
                        }
                        if (!f71632n && name.equals("springfox.documentation.spring.web.json.Json")) {
                            try {
                                Type cls9 = Class.forName("springfox.documentation.spring.web.json.Json");
                                z0VarD2 = s7.a.f76259a;
                                k(cls9, z0VarD2);
                                return z0VarD2;
                            } catch (ClassNotFoundException unused7) {
                                f71632n = true;
                            }
                        }
                        if (!f71633o && name.startsWith("com.google.common.collect.")) {
                            try {
                                String[] strArr6 = {"com.google.common.collect.HashMultimap", "com.google.common.collect.LinkedListMultimap", "com.google.common.collect.LinkedHashMultimap", "com.google.common.collect.ArrayListMultimap", "com.google.common.collect.TreeMultimap"};
                                for (int i17 = 0; i17 < 5; i17++) {
                                    String str6 = strArr6[i17];
                                    if (str6.equals(name)) {
                                        Type cls10 = Class.forName(str6);
                                        z0VarD2 = i0.f71650a;
                                        k(cls10, z0VarD2);
                                        return z0VarD2;
                                    }
                                }
                            } catch (ClassNotFoundException unused8) {
                                f71633o = true;
                            }
                        }
                        if (name.equals("net.sf.json.JSONNull")) {
                            z0 z0Var4 = w0.f71761b;
                            k(cls, z0Var4);
                            return z0Var4;
                        }
                        if (name.equals("org.json.JSONObject")) {
                            z0 z0Var5 = l0.f71695a;
                            k(cls, z0Var5);
                            return z0Var5;
                        }
                        if (!f71634p && name.startsWith("org.joda.")) {
                            try {
                                String[] strArr7 = {"org.joda.time.LocalDate", "org.joda.time.LocalDateTime", "org.joda.time.LocalTime", "org.joda.time.Instant", "org.joda.time.DateTime", "org.joda.time.Period", "org.joda.time.Duration", "org.joda.time.DateTimeZone", "org.joda.time.UTCDateTimeZone", "org.joda.time.tz.CachedDateTimeZone", "org.joda.time.tz.FixedDateTimeZone"};
                                for (int i18 = 0; i18 < 11; i18++) {
                                    String str7 = strArr7[i18];
                                    if (str7.equals(name)) {
                                        Type cls11 = Class.forName(str7);
                                        z0VarD2 = q0.f71722a;
                                        k(cls11, z0VarD2);
                                        return z0VarD2;
                                    }
                                }
                            } catch (ClassNotFoundException unused9) {
                                f71634p = true;
                            }
                        }
                        if ("java.nio.HeapByteBuffer".equals(name)) {
                            z0 z0Var6 = u.f71751a;
                            k(cls, z0Var6);
                            return z0Var6;
                        }
                        if ("org.javamoney.moneta.Money".equals(name)) {
                            z0 z0Var7 = r7.a.f75164a;
                            k(cls, z0Var7);
                            return z0Var7;
                        }
                        if ("com.google.protobuf.Descriptors$FieldDescriptor".equals(name)) {
                            z0 z0Var8 = l1.f71696a;
                            k(cls, z0Var8);
                            return z0Var8;
                        }
                        Class<?>[] interfaces = cls.getInterfaces();
                        if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
                            k(cls, j.f71664e);
                            return j.f71664e;
                        }
                        if (TypeUtils.x0(cls)) {
                            z0 z0VarH = h(cls.getSuperclass());
                            k(cls, z0VarH);
                            return z0VarH;
                        }
                        if (Proxy.isProxyClass(cls)) {
                            if (interfaces.length != 2) {
                                int length = interfaces.length;
                                Class<?> cls12 = null;
                                while (true) {
                                    if (i11 >= length) {
                                        cls2 = cls12;
                                        break;
                                    }
                                    Class<?> cls13 = interfaces[i11];
                                    if (!cls13.getName().startsWith("org.springframework.aop.")) {
                                        if (cls12 != null) {
                                            cls2 = null;
                                            break;
                                        }
                                        cls12 = cls13;
                                    }
                                    i11++;
                                }
                            } else {
                                cls2 = interfaces[1];
                            }
                            if (cls2 != null) {
                                z0 z0VarH2 = h(cls2);
                                k(cls, z0VarH2);
                                return z0VarH2;
                            }
                        }
                        if (z11) {
                            z0VarB = b(cls);
                            k(cls, z0VarB);
                        }
                    }
                    if (z0VarD2 == null) {
                        return d(cls);
                    }
                    return z0VarD2;
                }
                j7.d dVar2 = (j7.d) TypeUtils.N(superclass, j7.d.class);
                if (dVar2 == null || !dVar2.serializeEnumAsJavaBean()) {
                    z0VarB = e();
                    k(cls, z0VarB);
                } else {
                    z0VarB = b(cls);
                    k(cls, z0VarB);
                }
            }
        }
        z0VarD2 = z0VarB;
        if (z0VarD2 == null) {
            return d(cls);
        }
        return z0VarD2;
    }

    public final void j() {
        k(Boolean.class, t.f71749a);
        k(Character.class, x.f71764a);
        k(Byte.class, j0.f71665a);
        k(Short.class, j0.f71665a);
        k(Integer.class, j0.f71665a);
        k(Long.class, u0.f71755a);
        k(Float.class, h0.f71645b);
        k(Double.class, d0.f71594b);
        k(BigDecimal.class, r.f71745c);
        k(BigInteger.class, s.f71748c);
        k(String.class, k1.f71692a);
        k(byte[].class, a1.f71592a);
        k(short[].class, a1.f71592a);
        k(int[].class, a1.f71592a);
        k(long[].class, a1.f71592a);
        k(float[].class, a1.f71592a);
        k(double[].class, a1.f71592a);
        k(boolean[].class, a1.f71592a);
        k(char[].class, a1.f71592a);
        k(Object[].class, y0.f71766a);
        w0 w0Var = w0.f71761b;
        k(Class.class, w0Var);
        k(SimpleDateFormat.class, w0Var);
        k(Currency.class, new w0());
        k(TimeZone.class, w0Var);
        k(InetAddress.class, w0Var);
        k(Inet4Address.class, w0Var);
        k(Inet6Address.class, w0Var);
        k(InetSocketAddress.class, w0Var);
        k(File.class, w0Var);
        k kVar = k.f71690a;
        k(Appendable.class, kVar);
        k(StringBuffer.class, kVar);
        k(StringBuilder.class, kVar);
        l1 l1Var = l1.f71696a;
        k(Charset.class, l1Var);
        k(Pattern.class, l1Var);
        k(Locale.class, l1Var);
        k(URI.class, l1Var);
        k(URL.class, l1Var);
        k(UUID.class, l1Var);
        m mVar = m.f71697a;
        k(AtomicBoolean.class, mVar);
        k(AtomicInteger.class, mVar);
        k(AtomicLong.class, mVar);
        d1 d1Var = d1.f71596a;
        k(AtomicReference.class, d1Var);
        k(AtomicIntegerArray.class, mVar);
        k(AtomicLongArray.class, mVar);
        k(WeakReference.class, d1Var);
        k(SoftReference.class, d1Var);
        k(LinkedList.class, z.f71767a);
    }

    public boolean k(Type type, z0 z0Var) {
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            return this.f71639e.c(type, z0Var);
        }
        com.alibaba.fastjson.util.g<Type, z0> gVarB = this.f71640f.b(type);
        if (gVarB == null) {
            gVarB = new com.alibaba.fastjson.util.g<>(4);
            this.f71640f.c(type, gVarB);
        }
        return gVarB.c(mixInAnnotations, z0Var);
    }

    public void l(boolean z11) {
        if (com.alibaba.fastjson.util.b.f15531b) {
            return;
        }
        this.f71635a = z11;
    }
}
