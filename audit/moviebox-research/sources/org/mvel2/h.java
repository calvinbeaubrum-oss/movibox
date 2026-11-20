package org.mvel2;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.mvel2.ast.InvokationContextFactory;
import org.mvel2.ast.Proto;
import org.mvel2.ast.TypeDescriptor;
import org.mvel2.compiler.AbstractParser;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.ImmutableDefaultFactory;
import org.mvel2.util.MethodStub;
import t30.m;
import t30.n;
import t30.p;
import t30.s;
import t30.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object[] f73315o = new Object[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Map<Class, WeakHashMap<Integer, WeakReference<Member>>> f73316p = Collections.synchronizedMap(new WeakHashMap(10));

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Map<Class, WeakHashMap<Integer, WeakReference<Member>>> f73317q = Collections.synchronizedMap(new WeakHashMap(10));

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Map<Class, WeakHashMap<Integer, WeakReference<Object[]>>> f73318r = Collections.synchronizedMap(new WeakHashMap(10));

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Map<Member, WeakReference<Class[]>> f73319s = Collections.synchronizedMap(new WeakHashMap(10));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f73320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f73321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f73322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public char[] f73323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f73324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f73325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f73326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f73327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f73328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Class f73329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f73330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f73331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VariableResolverFactory f73332m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ParserContext f73333n;

    public h(String str, Object obj) {
        this.f73320a = 0;
        this.f73321b = 0;
        this.f73329j = null;
        this.f73330k = true;
        this.f73331l = false;
        char[] charArray = str.toCharArray();
        this.f73323d = charArray;
        int length = charArray.length;
        this.f73325f = length;
        this.f73324e = length;
        this.f73327h = obj;
        this.f73332m = new ImmutableDefaultFactory();
    }

    public h(char[] cArr, int i11, int i12, Object obj, VariableResolverFactory variableResolverFactory, Object obj2, ParserContext parserContext) {
        this.f73329j = null;
        this.f73330k = true;
        this.f73331l = false;
        this.f73323d = cArr;
        this.f73320a = i11;
        this.f73322c = i11;
        this.f73321b = i11;
        this.f73324e = i12;
        this.f73325f = i11 + i12;
        this.f73327h = obj;
        this.f73332m = variableResolverFactory;
        this.f73326g = obj2;
        this.f73333n = parserContext;
    }

    public h(char[] cArr, Object obj, VariableResolverFactory variableResolverFactory, Object obj2, ParserContext parserContext) {
        this.f73320a = 0;
        this.f73321b = 0;
        this.f73329j = null;
        this.f73330k = true;
        this.f73331l = false;
        this.f73323d = cArr;
        int length = cArr.length;
        this.f73325f = length;
        this.f73324e = length;
        this.f73327h = obj;
        this.f73332m = variableResolverFactory;
        this.f73326g = obj2;
        this.f73333n = parserContext;
    }

    public static void A(Object obj, VariableResolverFactory variableResolverFactory, String str, Object obj2, ParserContext parserContext) {
        new h(str.toCharArray(), obj, variableResolverFactory, null, parserContext).y(obj2);
    }

    public static void a(Class cls, Integer num, Method method) {
        Map<Class, WeakHashMap<Integer, WeakReference<Object[]>>> map = f73318r;
        synchronized (map) {
            try {
                WeakHashMap<Integer, WeakReference<Object[]>> weakHashMap = map.get(cls);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap<>();
                    map.put(cls, weakHashMap);
                }
                weakHashMap.put(num, new WeakReference<>(new Object[]{method, method.getParameterTypes()}));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void b(Class cls, Integer num, Member member) {
        Map<Class, WeakHashMap<Integer, WeakReference<Member>>> map = f73316p;
        synchronized (map) {
            try {
                WeakHashMap<Integer, WeakReference<Member>> weakHashMap = map.get(cls);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap<>();
                    map.put(cls, weakHashMap);
                }
                weakHashMap.put(num, new WeakReference<>(member));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void c(Class cls, Integer num, Member member) {
        Map<Class, WeakHashMap<Integer, WeakReference<Member>>> map = f73317q;
        synchronized (map) {
            try {
                WeakHashMap<Integer, WeakReference<Member>> weakHashMap = map.get(cls);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap<>();
                    map.put(cls, weakHashMap);
                }
                weakHashMap.put(num, new WeakReference<>(member));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static Object[] e(Class cls, Integer num) {
        WeakReference<Object[]> weakReference;
        WeakHashMap<Integer, WeakReference<Object[]>> weakHashMap = f73318r.get(cls);
        if (weakHashMap == null || (weakReference = weakHashMap.get(num)) == null) {
            return null;
        }
        return weakReference.get();
    }

    public static Class[] f(Method method) {
        Class[] clsArr;
        Map<Member, WeakReference<Class[]>> map = f73319s;
        WeakReference<Class[]> weakReference = map.get(method);
        if (weakReference != null && (clsArr = weakReference.get()) != null) {
            return clsArr;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        map.put(method, new WeakReference<>(parameterTypes));
        return parameterTypes;
    }

    public static Member g(Class cls, Integer num) {
        WeakReference<Member> weakReference;
        WeakHashMap<Integer, WeakReference<Member>> weakHashMap = f73316p.get(cls);
        if (weakHashMap == null || (weakReference = weakHashMap.get(num)) == null) {
            return null;
        }
        return weakReference.get();
    }

    public static Member h(Class cls, Integer num) {
        WeakReference<Member> weakReference;
        WeakHashMap<Integer, WeakReference<Member>> weakHashMap = f73317q.get(cls);
        if (weakHashMap == null || (weakReference = weakHashMap.get(num)) == null) {
            return null;
        }
        return weakReference.get();
    }

    public static int i(String str, String str2) {
        return str.hashCode() + str2.hashCode();
    }

    public static Object k(String str, Object obj) {
        return new h(str, obj).j();
    }

    public static Object l(String str, Object obj, VariableResolverFactory variableResolverFactory, Object obj2, ParserContext parserContext) {
        return new h(str.toCharArray(), obj, variableResolverFactory, obj2, parserContext).j();
    }

    public static Object m(char[] cArr, int i11, int i12, Object obj, VariableResolverFactory variableResolverFactory, Object obj2, ParserContext parserContext) {
        return new h(cArr, i11, i12, obj, variableResolverFactory, obj2, parserContext).j();
    }

    public static void z(Object obj, String str, Object obj2) {
        new h(str, obj).y(obj2);
    }

    public int B(int i11) {
        while (i11 > 0 && m.q0(this.f73323d[i11 - 1])) {
            i11--;
        }
        return i11;
    }

    /* JADX WARN: Code duplicated, block: B:128:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00d9 A[Catch: Exception -> 0x011e, TryCatch #0 {Exception -> 0x011e, blocks: (B:3:0x0003, B:4:0x0009, B:6:0x000d, B:17:0x002a, B:20:0x0030, B:27:0x003f, B:28:0x0042, B:30:0x0047, B:32:0x004d, B:36:0x0058, B:38:0x0064, B:40:0x006c, B:41:0x0076, B:43:0x007f, B:44:0x009f, B:46:0x00a4, B:48:0x00ab, B:51:0x00b8, B:54:0x00c0, B:57:0x00c7, B:59:0x00cd, B:69:0x00e8, B:61:0x00d1, B:62:0x00d4, B:64:0x00d9, B:66:0x00df, B:68:0x00e5, B:70:0x00eb, B:71:0x00f2, B:73:0x00f6, B:75:0x00fc, B:80:0x0107, B:82:0x010b, B:84:0x0111), top: B:91:0x0003, inners: #1, #2 }] */
    public Object C() {
        int i11;
        char[] cArr;
        int i12 = this.f73321b;
        try {
            int i13 = this.f73325f;
            int i14 = i13 - 1;
            boolean z11 = false;
            while (true) {
                int i15 = this.f73320a;
                if (i14 > i15) {
                    char[] cArr2 = this.f73323d;
                    char c11 = cArr2[i14];
                    if (c11 != '\"') {
                        if (c11 != '\'') {
                            int i16 = 1;
                            if (c11 == ')') {
                                int i17 = i14 - 1;
                                int i18 = 1;
                                while (i17 > 0 && i18 != 0) {
                                    char c12 = this.f73323d[i17];
                                    if (c12 == '\"') {
                                        while (i17 > 0) {
                                            cArr = this.f73323d;
                                            if (cArr[i17] == c12) {
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                    switch (c12) {
                                        case '\'':
                                            while (i17 > 0) {
                                                cArr = this.f73323d;
                                                if (cArr[i17] == c12 || cArr[i17 - 1] == '\\') {
                                                }
                                                i17--;
                                                break;
                                            }
                                            break;
                                        case '(':
                                            i18--;
                                            break;
                                        case ')':
                                            i18++;
                                            break;
                                    }
                                    i17--;
                                }
                                z11 = true;
                                int i19 = i17;
                                i14 = i17 + 1;
                                i13 = i19;
                            } else if (c11 == '.') {
                                if (!z11) {
                                    try {
                                        this.f73321b = i13;
                                        String str = new String(cArr2, i15, i13 - i15);
                                        if (d.f73310j && str.endsWith(".class")) {
                                            str = str.substring(0, str.length() - 6);
                                        }
                                        return q().loadClass(str);
                                    } catch (ClassNotFoundException unused) {
                                        ClassLoader classLoaderQ = q();
                                        char[] cArr3 = this.f73323d;
                                        int i21 = this.f73320a;
                                        Class<?> clsLoadClass = classLoaderQ.loadClass(new String(cArr3, i21, i14 - i21));
                                        String str2 = new String(this.f73323d, i14 + 1, (this.f73325f - i14) - 1);
                                        try {
                                            return clsLoadClass.getField(str2);
                                        } catch (NoSuchFieldException unused2) {
                                            for (Method method : clsLoadClass.getMethods()) {
                                                if (str2.equals(method.getName())) {
                                                    return method;
                                                }
                                            }
                                            return null;
                                        }
                                    }
                                }
                                i13 = i14;
                                z11 = false;
                            } else if (c11 == '}') {
                                while (true) {
                                    i14--;
                                    if (i14 <= 0 || i16 == 0) {
                                        break;
                                    }
                                    char c13 = this.f73323d[i14];
                                    if (c13 == '\"' || c13 == '\'') {
                                        while (i14 > 0) {
                                            char[] cArr4 = this.f73323d;
                                            if (cArr4[i14] == c13 || cArr4[i14 - 1] == '\\') {
                                                break;
                                            }
                                            i14--;
                                        }
                                    } else if (c13 == '{') {
                                        i16--;
                                    } else if (c13 == '}') {
                                        i16++;
                                    }
                                }
                            }
                        } else {
                            while (true) {
                                i11 = i14 - 1;
                                if (i11 > 0) {
                                    char[] cArr5 = this.f73323d;
                                    if (cArr5[i11] != '\'' || cArr5[i14 - 2] == '\\') {
                                        i14 = i11;
                                    }
                                }
                            }
                        }
                        i14--;
                    } else {
                        while (true) {
                            i11 = i14 - 1;
                            if (i11 > 0) {
                                char[] cArr6 = this.f73323d;
                                if (cArr6[i11] != '\"' || cArr6[i14 - 2] == '\\') {
                                    i14 = i11;
                                }
                            }
                        }
                    }
                    i14 = i11;
                    i14--;
                }
            }
        } catch (Exception unused3) {
            this.f73321b = i12;
        }
        return null;
    }

    public final void D() {
        if (this.f73321b < this.f73325f) {
            while (m.q0(this.f73323d[this.f73321b])) {
                int i11 = this.f73321b + 1;
                this.f73321b = i11;
                if (i11 >= this.f73325f) {
                    return;
                }
            }
        }
    }

    public final String d() {
        return new String(this.f73323d, this.f73322c, B(this.f73321b) - this.f73322c);
    }

    public final Object j() {
        this.f73328i = this.f73327h;
        try {
            return !d.f73308h ? u() : n();
        } catch (IllegalAccessException e11) {
            throw new PropertyAccessException("could not access property", this.f73323d, this.f73321b, e11, this.f73333n);
        } catch (IndexOutOfBoundsException e12) {
            int i11 = this.f73321b;
            int i12 = this.f73324e;
            if (i11 >= i12) {
                this.f73321b = i12 - 1;
            }
            throw new PropertyAccessException("array or collections index out of bounds in property: " + new String(this.f73323d, this.f73321b, this.f73324e), this.f73323d, this.f73321b, e12, this.f73333n);
        } catch (NullPointerException e13) {
            throw new PropertyAccessException("null pointer exception in property: " + new String(this.f73323d), this.f73323d, this.f73321b, e13, this.f73333n);
        } catch (InvocationTargetException e14) {
            throw new PropertyAccessException("could not access property", this.f73323d, this.f73321b, e14, this.f73333n);
        } catch (CompileException e15) {
            throw t30.f.a(e15, this.f73323d, this.f73322c);
        } catch (Exception e16) {
            throw new PropertyAccessException("unknown exception in expression: " + new String(this.f73323d), this.f73323d, this.f73321b, e16, this.f73333n);
        }
    }

    public final Object n() throws Exception {
        while (this.f73321b < this.f73325f) {
            int iW = w();
            if (iW == 0) {
                Object objP = p(this.f73328i, d());
                this.f73328i = objP;
                if (objP == null && l30.e.e()) {
                    this.f73328i = l30.e.b().b(d(), this.f73327h, this.f73332m);
                }
            } else if (iW == 1) {
                Object objT = t(this.f73328i, d());
                this.f73328i = objT;
                if (objT == null && l30.e.d()) {
                    this.f73328i = l30.e.a().b(d(), this.f73327h, this.f73332m);
                }
            } else if (iW == 2) {
                this.f73328i = s(this.f73328i, d());
            } else if (iW == 3) {
                this.f73328i = v(this.f73328i);
            }
            if (this.f73331l) {
                if (this.f73328i == null) {
                    return null;
                }
                this.f73331l = false;
            } else if (this.f73328i == null && this.f73321b < this.f73325f) {
                throw null;
            }
            this.f73330k = false;
        }
        return this.f73328i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x021a, code lost:
    
        return t(r8, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object o(Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        Class<?> cls;
        if (this.f73330k) {
            if ("this".equals(str)) {
                return this.f73327h;
            }
            if (AbstractParser.LITERALS.containsKey(str)) {
                return AbstractParser.LITERALS.get(str);
            }
            VariableResolverFactory variableResolverFactory = this.f73332m;
            if (variableResolverFactory != null && variableResolverFactory.isResolveable(str)) {
                return this.f73332m.getVariableResolver(str).getValue();
            }
        }
        if (obj != null) {
            boolean z11 = obj instanceof Class;
            if (!z11) {
                cls = obj.getClass();
            } else {
                if (d.f73310j && "class".equals(str)) {
                    return obj;
                }
                cls = (Class) obj;
            }
            Member memberG = g(cls, Integer.valueOf(str.hashCode()));
            if (memberG == null) {
                Integer numValueOf = Integer.valueOf(str.hashCode());
                Member memberA = n.a(cls, str);
                b(cls, numValueOf, memberA);
                memberG = memberA;
            }
            boolean z12 = false;
            if (memberG instanceof Method) {
                try {
                    return ((Method) memberG).invoke(obj, f73315o);
                } catch (IllegalAccessException unused) {
                    synchronized (memberG) {
                        try {
                            try {
                                ((Method) memberG).setAccessible(true);
                                return ((Method) memberG).invoke(obj, f73315o);
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        } finally {
                            ((Method) memberG).setAccessible(false);
                        }
                    }
                } catch (IllegalArgumentException e11) {
                    if (memberG.getDeclaringClass().equals(obj)) {
                        try {
                            throw new CompileException("name collision between innerclass: " + Class.forName(memberG.getDeclaringClass().getName() + "$" + str).getCanonicalName() + "; and bean accessor: " + str + " (" + memberG.toString() + ")", this.f73323d, this.f73322c);
                        } catch (ClassNotFoundException unused2) {
                            throw e11;
                        }
                    }
                    throw e11;
                }
            }
            if (memberG != null) {
                Field field = (Field) memberG;
                this.f73329j = p.i(field.getType());
                return field.get(obj);
            }
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.containsKey(str) || this.f73331l) {
                    return obj instanceof Proto.b ? ((Proto.b) obj).get(str).c(null, this.f73326g, this.f73332m, m.f76821a) : map.get(str);
                }
            }
            if ("length".equals(str) && obj.getClass().isArray()) {
                return Integer.valueOf(Array.getLength(obj));
            }
            if (z11) {
                Class cls2 = (Class) obj;
                for (Method method : cls2.getMethods()) {
                    if (str.equals(method.getName())) {
                        ParserContext parserContext = this.f73333n;
                        return (parserContext == null || parserContext.getParserConfiguration() == null ? !d.f73307g : !this.f73333n.getParserConfiguration().isAllowNakedMethCall()) ? method : method.invoke(obj, m.f76821a);
                    }
                }
                try {
                    return m.D(this.f73332m, cls2.getName() + "$" + str, this.f73333n);
                } catch (ClassNotFoundException unused3) {
                }
            } else {
                if (l30.e.f(cls)) {
                    return l30.e.c(cls).b(str, obj, this.f73332m);
                }
                if (obj instanceof org.mvel2.ast.b) {
                    return ((org.mvel2.ast.d) obj).c().getVariableResolver(str).getValue();
                }
            }
        }
        Object objC = C();
        if (objC != null) {
            return ((objC instanceof Class) || (objC instanceof Method)) ? objC : ((Field) objC).get(null);
        }
        if ((r0 = this.f73333n) != null) {
        }
        if (obj == null) {
            throw new PropertyAccessException("unresolvable property or identifier: " + str, this.f73323d, this.f73322c, this.f73333n);
        }
        throw new PropertyAccessException("could not access: " + str + "; in class: " + obj.getClass().getName(), this.f73323d, this.f73322c, this.f73333n);
    }

    public final Object p(Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        if (obj != null && l30.e.f(obj.getClass())) {
            return l30.e.c(obj.getClass()).b(str, obj, this.f73332m);
        }
        l30.a.c(obj, str, this.f73332m);
        return o(obj, str);
    }

    public final ClassLoader q() {
        ParserContext parserContext = this.f73333n;
        return parserContext != null ? parserContext.getClassLoader() : Thread.currentThread().getContextClassLoader();
    }

    public final Object r(Object obj, String str) throws Exception {
        if (str.length() != 0 && (obj = o(obj, str)) == null) {
            throw new NullPointerException("null pointer on indexed access for: " + str);
        }
        this.f73329j = null;
        int i11 = this.f73321b + 1;
        this.f73321b = i11;
        D();
        if (this.f73321b == this.f73325f || x(']')) {
            throw new PropertyAccessException("unterminated '['", this.f73323d, this.f73321b, this.f73333n);
        }
        char[] cArr = this.f73323d;
        int i12 = this.f73321b;
        this.f73321b = i12 + 1;
        String str2 = new String(cArr, i11, i12 - i11);
        if (obj instanceof Map) {
            return ((Map) obj).get(d.l(str2, obj, this.f73332m));
        }
        if (obj instanceof List) {
            return ((List) obj).get(((Integer) d.l(str2, obj, this.f73332m)).intValue());
        }
        if (!(obj instanceof Collection)) {
            if (obj.getClass().isArray()) {
                return Array.get(obj, ((Integer) d.l(str2, obj, this.f73332m)).intValue());
            }
            if (obj instanceof CharSequence) {
                return Character.valueOf(((CharSequence) obj).charAt(((Integer) d.l(str2, obj, this.f73332m)).intValue()));
            }
            try {
                return TypeDescriptor.getClassReference(this.f73333n, (Class) obj, new TypeDescriptor(this.f73323d, this.f73320a, this.f73324e, 0));
            } catch (Exception e11) {
                throw new PropertyAccessException("illegal use of []: unknown type: " + obj.getClass().getName(), this.f73323d, this.f73322c, e11, this.f73333n);
            }
        }
        int iIntValue = ((Integer) d.l(str2, obj, this.f73332m)).intValue();
        Collection collection = (Collection) obj;
        if (iIntValue <= collection.size()) {
            Iterator it = collection.iterator();
            for (int i13 = 0; i13 < iIntValue; i13++) {
                it.next();
            }
            return it.next();
        }
        throw new PropertyAccessException("index [" + iIntValue + "] out of bounds on collections", this.f73323d, this.f73321b, this.f73333n);
    }

    public final Object s(Object obj, String str) throws Exception {
        if (str.length() != 0) {
            obj = o(obj, str);
        }
        this.f73329j = null;
        if (obj == null) {
            return null;
        }
        int i11 = this.f73321b + 1;
        this.f73321b = i11;
        D();
        if (this.f73321b == this.f73325f || x(']')) {
            throw new PropertyAccessException("unterminated '['", this.f73323d, this.f73321b, this.f73333n);
        }
        char[] cArr = this.f73323d;
        int i12 = this.f73321b;
        this.f73321b = i12 + 1;
        String str2 = new String(cArr, i11, i12 - i11);
        if (obj instanceof Map) {
            return l30.e.f(Map.class) ? l30.e.c(Map.class).b(str2, obj, this.f73332m) : ((Map) obj).get(d.l(str2, obj, this.f73332m));
        }
        if (obj instanceof List) {
            return l30.e.f(List.class) ? l30.e.c(List.class).b(str2, obj, this.f73332m) : ((List) obj).get(((Integer) d.l(str2, obj, this.f73332m)).intValue());
        }
        if (!(obj instanceof Collection)) {
            if (obj.getClass().isArray()) {
                return l30.e.f(Array.class) ? l30.e.c(Array.class).b(str2, obj, this.f73332m) : Array.get(obj, ((Integer) d.l(str2, obj, this.f73332m)).intValue());
            }
            if (obj instanceof CharSequence) {
                return l30.e.f(CharSequence.class) ? l30.e.c(CharSequence.class).b(str2, obj, this.f73332m) : Character.valueOf(((CharSequence) obj).charAt(((Integer) d.l(str2, obj, this.f73332m)).intValue()));
            }
            try {
                char[] cArr2 = this.f73323d;
                int i13 = this.f73320a;
                return TypeDescriptor.getClassReference(this.f73333n, (Class) obj, new TypeDescriptor(cArr2, i13, this.f73325f - i13, 0));
            } catch (Exception unused) {
                throw new PropertyAccessException("illegal use of []: unknown type: " + obj.getClass().getName(), this.f73323d, this.f73322c, this.f73333n);
            }
        }
        if (l30.e.f(Collection.class)) {
            return l30.e.c(Collection.class).b(str2, obj, this.f73332m);
        }
        int iIntValue = ((Integer) d.l(str2, obj, this.f73332m)).intValue();
        Collection collection = (Collection) obj;
        if (iIntValue <= collection.size()) {
            Iterator it = collection.iterator();
            for (int i14 = 0; i14 < iIntValue; i14++) {
                it.next();
            }
            return it.next();
        }
        throw new PropertyAccessException("index [" + iIntValue + "] out of bounds on collections", this.f73323d, this.f73321b, this.f73333n);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0027  */
    public final Object t(Object obj, String str) {
        String str2;
        Object[] objArr;
        Class<?>[] parameterTypes;
        Method methodL;
        VariableResolverFactory variableResolverFactory;
        int i11 = this.f73321b;
        if (i11 != this.f73325f) {
            char[] cArr = this.f73323d;
            if (cArr[i11] == '(') {
                int iC = m.c(cArr, i11, '(');
                this.f73321b = iC;
                if (iC - i11 > 1) {
                    str2 = new String(this.f73323d, i11 + 1, (iC - i11) - 1);
                } else {
                    str2 = "";
                }
            } else {
                str2 = "";
            }
        } else {
            str2 = "";
        }
        this.f73321b++;
        int i12 = 0;
        if (str2.length() == 0) {
            objArr = m.f76821a;
        } else {
            List<char[]> listY0 = m.y0(str2.toCharArray(), 0, -1);
            Object[] objArr2 = new Object[listY0.size()];
            for (int i13 = 0; i13 < listY0.size(); i13++) {
                objArr2[i13] = d.q(listY0.get(i13), this.f73326g, this.f73332m);
            }
            objArr = objArr2;
        }
        if (this.f73330k && (variableResolverFactory = this.f73332m) != null && variableResolverFactory.isResolveable(str)) {
            Object value = this.f73332m.getVariableResolver(str).getValue();
            if (value instanceof Method) {
                Method method = (Method) value;
                obj = method.getDeclaringClass();
                str = method.getName();
            } else {
                if (!(value instanceof MethodStub)) {
                    if (value instanceof org.mvel2.ast.b) {
                        org.mvel2.ast.b bVar = (org.mvel2.ast.b) value;
                        bVar.b().checkArgumentCount(objArr.length);
                        return bVar.a(null, this.f73326g, this.f73332m, objArr);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("attempt to optimize a method call for a reference that does not point to a method: ");
                    sb2.append(str);
                    sb2.append(" (reference is type: ");
                    sb2.append(obj != null ? obj.getClass().getName() : null);
                    sb2.append(")");
                    throw new OptimizationFailure(sb2.toString());
                }
                MethodStub methodStub = (MethodStub) value;
                obj = methodStub.getClassReference();
                str = methodStub.getMethodName();
            }
            this.f73330k = false;
        }
        if (obj == null) {
            throw new CompileException("no such method or function: " + str, this.f73323d, this.f73321b);
        }
        Class<?> cls = this.f73329j;
        if (cls == null) {
            cls = obj instanceof Class ? (Class) obj : obj.getClass();
        }
        this.f73329j = null;
        if (cls == Proto.b.class) {
            return ((Proto.b) obj).get(str).c(null, this.f73326g, this.f73332m, objArr);
        }
        Object[] objArrE = e(cls, Integer.valueOf(i(str, str2)));
        if (objArrE != null) {
            methodL = (Method) objArrE[0];
            parameterTypes = (Class[]) objArrE[1];
        } else {
            parameterTypes = null;
            methodL = null;
        }
        if (methodL == null) {
            methodL = m.L(objArr, str, cls, cls.getMethods(), false);
            if (methodL != null) {
                a(cls, Integer.valueOf(i(str, str2)), methodL);
                parameterTypes = methodL.getParameterTypes();
            }
            if (methodL == null && (methodL = m.L(objArr, str, cls, cls.getDeclaredMethods(), false)) != null) {
                a(cls, Integer.valueOf(i(str, str2)), methodL);
                parameterTypes = methodL.getParameterTypes();
            }
        }
        if (methodL == null && cls != obj.getClass() && !(obj instanceof Class)) {
            cls = obj.getClass();
            methodL = m.L(objArr, str, cls, cls.getDeclaredMethods(), false);
            if (methodL != null) {
                a(cls, Integer.valueOf(i(str, str2)), methodL);
                parameterTypes = methodL.getParameterTypes();
            }
        }
        if (obj instanceof org.mvel2.ast.d) {
            VariableResolverFactory variableResolverFactoryC = ((org.mvel2.ast.d) obj).c();
            Object value2 = variableResolverFactoryC.getVariableResolver(str).getValue();
            if (value2 instanceof org.mvel2.ast.d) {
                return ((org.mvel2.ast.d) value2).a(obj, this.f73326g, new InvokationContextFactory(this.f73332m, variableResolverFactoryC), objArr);
            }
        }
        if (methodL != null) {
            while (i12 < objArr.length) {
                objArr[i12] = b.b(objArr[i12], t.b(parameterTypes, i12, methodL.isVarArgs()));
                i12++;
            }
            this.f73329j = p.i(methodL.getReturnType());
            try {
                try {
                    return methodL.invoke(obj, t.a(parameterTypes, objArr, methodL.isVarArgs()));
                } catch (Exception e11) {
                    throw new PropertyAccessException("unable to invoke method: " + str, this.f73323d, this.f73321b, e11, this.f73333n);
                }
            } catch (IllegalAccessException unused) {
                Integer numValueOf = Integer.valueOf(i(str, str2));
                Method methodV = m.V(methodL);
                a(cls, numValueOf, methodV);
                return methodV.invoke(obj, objArr);
            } catch (RuntimeException e12) {
                throw e12;
            } catch (Exception e13) {
                throw new PropertyAccessException("unable to invoke method: " + str, this.f73323d, this.f73321b, e13, this.f73333n);
            }
        }
        s sVar = new s();
        while (i12 < objArr.length) {
            Object obj2 = objArr[i12];
            sVar.d(obj2 != null ? obj2.getClass().getName() : null);
            if (i12 < objArr.length - 1) {
                sVar.d(", ");
            }
            i12++;
        }
        if ("size".equals(str) && objArr.length == 0 && cls.isArray()) {
            return Integer.valueOf(Array.getLength(obj));
        }
        throw new PropertyAccessException("unable to resolve method: " + cls.getName() + InstructionFileId.DOT + str + "(" + sVar.toString() + ") [arglength=" + objArr.length + "]", this.f73323d, this.f73322c, this.f73333n);
    }

    public final Object u() throws Exception {
        while (this.f73321b < this.f73325f) {
            int iW = w();
            if (iW == 0) {
                this.f73328i = o(this.f73328i, d());
            } else if (iW == 1) {
                this.f73328i = t(this.f73328i, d());
            } else if (iW == 2) {
                this.f73328i = r(this.f73328i, d());
            } else if (iW == 3) {
                this.f73328i = v(this.f73328i);
            }
            if (this.f73331l) {
                if (this.f73328i == null) {
                    return null;
                }
                this.f73331l = false;
            }
            this.f73330k = false;
        }
        return this.f73328i;
    }

    public final Object v(Object obj) {
        int i11 = this.f73320a;
        int i12 = this.f73321b;
        String strTrim = i11 == i12 ? null : new String(this.f73323d, i11, (i12 - i11) - 1).trim();
        char[] cArr = this.f73323d;
        int i13 = this.f73321b;
        int i14 = i13 + 1;
        int iE = m.e(cArr, i13, this.f73325f, '{', this.f73333n);
        this.f73321b = iE;
        m.z0(strTrim, cArr, i14, iE - i14, obj, this.f73332m);
        this.f73321b++;
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0099  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ab A[LOOP:2: B:46:0x00ab->B:48:0x00b7, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:48:0x00b7 A[LOOP:2: B:46:0x00ab->B:48:0x00b7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:51:0x00c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00c9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x00ca A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x00cb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x00cc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x00a4 A[EDGE_INSN: B:65:0x00a4->B:44:0x00a4 BREAK  A[LOOP:1: B:39:0x0090->B:67:?], SYNTHETIC] */
    public final int w() {
        int i11;
        int i12;
        int i13;
        char c11;
        char[] cArr = this.f73323d;
        int i14 = this.f73321b;
        this.f73322c = i14;
        char c12 = cArr[i14];
        if (c12 != '.') {
            if (c12 != '?') {
                if (c12 == '[') {
                    return 2;
                }
                if (c12 == '{' && cArr[i14 - 1] == '.') {
                    return 3;
                }
            }
            while (true) {
                i11 = this.f73321b;
                if (i11 < this.f73325f || !m.q0(this.f73323d[i11])) {
                    i12 = this.f73321b;
                    if (i12 >= this.f73325f || this.f73323d[i12] != '.') {
                        break;
                    }
                    this.f73321b = i12 + 1;
                } else {
                    this.f73321b++;
                }
            }
            this.f73322c = i12;
            do {
                i13 = this.f73321b + 1;
                this.f73321b = i13;
                if (i13 < this.f73325f) {
                    break;
                }
            } while (Character.isJavaIdentifierPart(this.f73323d[i13]));
            if (this.f73321b < this.f73325f) {
                return 0;
            }
            while (m.q0(this.f73323d[this.f73321b])) {
                this.f73321b++;
            }
            c11 = this.f73323d[this.f73321b];
            if (c11 != '(') {
                return 1;
            }
            if (c11 != '[') {
                return 0;
            }
            return 2;
        }
        while (true) {
            int i15 = this.f73321b;
            if (i15 >= this.f73325f || !m.q0(this.f73323d[i15])) {
                break;
            }
            this.f73321b++;
        }
        int i16 = this.f73322c;
        if (i16 + 1 != this.f73325f) {
            char[] cArr2 = this.f73323d;
            int i17 = i16 + 1;
            this.f73322c = i17;
            this.f73321b = i17;
            char c13 = cArr2[i17];
            if (c13 == '?') {
                int i18 = i16 + 2;
                this.f73322c = i18;
                this.f73321b = i18;
                this.f73331l = true;
            } else if (c13 == '{') {
                return 3;
            }
        }
        if (this.f73321b == this.f73320a) {
            int i19 = this.f73322c + 1;
            this.f73322c = i19;
            this.f73321b = i19;
            this.f73331l = true;
        }
        while (true) {
            i11 = this.f73321b;
            if (i11 < this.f73325f) {
            }
            i12 = this.f73321b;
            if (i12 >= this.f73325f) {
                break;
            }
            break;
            break;
        }
        this.f73322c = i12;
        do {
            i13 = this.f73321b + 1;
            this.f73321b = i13;
            if (i13 < this.f73325f) {
                break;
                break;
            }
        } while (Character.isJavaIdentifierPart(this.f73323d[i13]));
        if (this.f73321b < this.f73325f) {
            return 0;
        }
        while (m.q0(this.f73323d[this.f73321b])) {
            this.f73321b++;
        }
        c11 = this.f73323d[this.f73321b];
        if (c11 != '(') {
            return 1;
        }
        if (c11 != '[') {
            return 0;
        }
        return 2;
    }

    public final boolean x(char c11) {
        while (true) {
            int i11 = this.f73321b;
            int i12 = this.f73325f;
            if (i11 >= i12) {
                return true;
            }
            char[] cArr = this.f73323d;
            char c12 = cArr[i11];
            if (c12 == '\"' || c12 == '\'') {
                this.f73321b = m.h(c12, cArr, i11, i12);
            }
            char[] cArr2 = this.f73323d;
            int i13 = this.f73321b;
            if (cArr2[i13] == c11) {
                return false;
            }
            this.f73321b = i13 + 1;
        }
    }

    public final void y(Object obj) {
        this.f73328i = this.f73327h;
        try {
            int i11 = this.f73325f;
            this.f73325f = m.C(this.f73323d);
            Object objJ = j();
            this.f73328i = objJ;
            if (objJ == null) {
                throw new PropertyAccessException("cannot bind to null context: " + new String(this.f73323d, this.f73321b, this.f73324e), this.f73323d, this.f73321b, this.f73333n);
            }
            this.f73325f = i11;
            if (w() == 2) {
                int i12 = this.f73321b + 1;
                this.f73321b = i12;
                D();
                if (this.f73321b == this.f73324e || x(']')) {
                    throw new PropertyAccessException("unterminated '['", this.f73323d, this.f73321b, this.f73333n);
                }
                String str = new String(this.f73323d, i12, this.f73321b - i12);
                if (!d.f73308h) {
                    Object obj2 = this.f73328i;
                    if (obj2 instanceof Map) {
                        ((Map) obj2).put(d.l(str, this.f73327h, this.f73332m), obj);
                        return;
                    }
                    if (obj2 instanceof List) {
                        ((List) obj2).set(((Integer) d.m(str, this.f73327h, this.f73332m, Integer.class)).intValue(), obj);
                        return;
                    }
                    if (l30.e.f(obj2.getClass())) {
                        l30.e.c(this.f73328i.getClass()).a(str, this.f73327h, this.f73332m, obj);
                        return;
                    }
                    if (this.f73328i.getClass().isArray()) {
                        Array.set(this.f73328i, ((Integer) d.m(str, this.f73327h, this.f73332m, Integer.class)).intValue(), b.b(obj, m.I(this.f73328i.getClass())));
                        return;
                    }
                    throw new PropertyAccessException("cannot bind to collection property: " + new String(this.f73323d) + ": not a recognized collection type: " + this.f73327h.getClass(), this.f73323d, this.f73321b, this.f73333n);
                }
                l30.a.d(this.f73327h, str, this.f73332m, obj);
                Object obj3 = this.f73328i;
                if (obj3 instanceof Map) {
                    if (l30.e.f(Map.class)) {
                        l30.e.c(Map.class).a(str, this.f73328i, this.f73332m, obj);
                        return;
                    } else {
                        ((Map) this.f73328i).put(d.l(str, this.f73327h, this.f73332m), obj);
                        return;
                    }
                }
                if (obj3 instanceof List) {
                    if (l30.e.f(List.class)) {
                        l30.e.c(List.class).a(str, this.f73328i, this.f73332m, obj);
                        return;
                    } else {
                        ((List) this.f73328i).set(((Integer) d.m(str, this.f73327h, this.f73332m, Integer.class)).intValue(), obj);
                        return;
                    }
                }
                if (obj3.getClass().isArray()) {
                    if (l30.e.f(Array.class)) {
                        l30.e.c(Array.class).a(str, this.f73328i, this.f73332m, obj);
                        return;
                    } else {
                        Array.set(this.f73328i, ((Integer) d.m(str, this.f73327h, this.f73332m, Integer.class)).intValue(), b.b(obj, m.I(this.f73328i.getClass())));
                        return;
                    }
                }
                if (l30.e.f(this.f73328i.getClass())) {
                    l30.e.c(this.f73328i.getClass()).a(str, this.f73328i, this.f73332m, obj);
                    return;
                }
                throw new PropertyAccessException("cannot bind to collection property: " + new String(this.f73323d) + ": not a recognized collection type: " + this.f73327h.getClass(), this.f73323d, this.f73321b, this.f73333n);
            }
            if (d.f73308h && l30.e.f(this.f73328i.getClass())) {
                l30.e.c(this.f73328i.getClass()).a(d(), this.f73328i, this.f73332m, obj);
                return;
            }
            String strD = d();
            Member memberH = h(this.f73328i.getClass(), Integer.valueOf(strD == null ? 0 : strD.hashCode()));
            if (memberH == null) {
                Class<?> cls = this.f73328i.getClass();
                Integer numValueOf = Integer.valueOf(strD != null ? strD.hashCode() : -1);
                Member memberC = obj != null ? n.c(this.f73328i.getClass(), strD, obj.getClass()) : n.b(this.f73328i.getClass(), strD);
                c(cls, numValueOf, memberC);
                memberH = memberC;
            }
            if (memberH instanceof Method) {
                Method method = (Method) memberH;
                Class[] clsArrF = f(method);
                if (obj == null || clsArrF[0].isAssignableFrom(obj.getClass())) {
                    method.invoke(this.f73328i, obj);
                    return;
                }
                if (b.a(clsArrF[0], obj.getClass())) {
                    method.invoke(this.f73328i, b.b(obj, clsArrF[0]));
                    return;
                }
                throw new CompileException("cannot convert type: " + obj.getClass() + ": to " + method.getParameterTypes()[0], this.f73323d, this.f73321b);
            }
            if (memberH != null) {
                Field field = (Field) memberH;
                if (obj == null || field.getType().isAssignableFrom(obj.getClass())) {
                    field.set(this.f73328i, obj);
                    return;
                }
                if (b.a(field.getType(), obj.getClass())) {
                    field.set(this.f73328i, b.b(obj, field.getType()));
                    return;
                }
                throw new CompileException("cannot convert type: " + obj.getClass() + ": to " + field.getType(), this.f73323d, this.f73321b);
            }
            Object obj4 = this.f73328i;
            if (obj4 instanceof Map) {
                ((Map) obj4).put(d.l(strD, this.f73327h, this.f73332m), obj);
                return;
            }
            if (obj4 instanceof org.mvel2.ast.b) {
                ((org.mvel2.ast.d) obj4).c().getVariableResolver(strD).setValue(obj);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("could not access/write property (");
            sb2.append(strD);
            sb2.append(") in: ");
            Object obj5 = this.f73328i;
            sb2.append(obj5 == null ? "Unknown" : obj5.getClass().getName());
            throw new PropertyAccessException(sb2.toString(), this.f73323d, this.f73321b, this.f73333n);
        } catch (IllegalAccessException e11) {
            throw new PropertyAccessException("could not access property", this.f73323d, this.f73322c, e11, this.f73333n);
        } catch (InvocationTargetException e12) {
            throw new PropertyAccessException("could not access property", this.f73323d, this.f73322c, e12, this.f73333n);
        }
    }
}
