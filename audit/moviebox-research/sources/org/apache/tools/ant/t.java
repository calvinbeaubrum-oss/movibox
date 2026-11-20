package org.apache.tools.ant;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class t {
    public static /* synthetic */ Class A;
    public static /* synthetic */ Class B;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map f72713h = new Hashtable();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map f72714i = new HashMap(8);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static /* synthetic */ Class f72715j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static /* synthetic */ Class f72716k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static /* synthetic */ Class f72717l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static /* synthetic */ Class f72718m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static /* synthetic */ Class f72719n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static /* synthetic */ Class f72720o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static /* synthetic */ Class f72721p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static /* synthetic */ Class f72722q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static /* synthetic */ Class f72723r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static /* synthetic */ Class f72724s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static /* synthetic */ Class f72725t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static /* synthetic */ Class f72726u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static /* synthetic */ Class f72727v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static /* synthetic */ Class f72728w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static /* synthetic */ Class f72729x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static /* synthetic */ Class f72730y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static /* synthetic */ Class f72731z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable f72732a = new Hashtable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Hashtable f72733b = new Hashtable();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Hashtable f72734c = new Hashtable();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Hashtable f72735d = new Hashtable();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f72736e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Method f72737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Class f72738g;

    /* JADX INFO: compiled from: source.java */
    public static class a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Constructor f72739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f72740c;

        public a(Method method, Constructor constructor, int i11) {
            super(method);
            this.f72739b = constructor;
            this.f72740c = i11;
        }

        @Override // org.apache.tools.ant.t.e
        public Object a(Project project, Object obj, Object obj2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            if (obj2 == null) {
                Constructor constructor = this.f72739b;
                obj2 = constructor.newInstance(constructor.getParameterTypes().length == 0 ? new Object[0] : new Object[]{project});
            }
            if (obj2 instanceof org.apache.tools.ant.taskdefs.l) {
                obj2 = ((org.apache.tools.ant.taskdefs.l) obj2).v(project);
            }
            if (this.f72740c == 1) {
                f(obj, obj2);
            }
            return obj2;
        }

        @Override // org.apache.tools.ant.t.e
        public boolean d() {
            return true;
        }

        @Override // org.apache.tools.ant.t.e
        public void e(Object obj, Object obj2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            if (this.f72740c == 2) {
                f(obj, obj2);
            }
        }

        public final void f(Object obj, Object obj2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            b().invoke(obj, obj2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f72741a;

        public b(Method method) {
            this.f72741a = method;
        }

        public abstract void a(Project project, Object obj, String str) throws IllegalAccessException, BuildException, InvocationTargetException;
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends e {
        public c(Method method) {
            super(method);
        }

        @Override // org.apache.tools.ant.t.e
        public Object a(Project project, Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
            return b().invoke(obj, new Object[0]);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f72742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f72743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Project f72744c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f72745d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f72746e;

        public d(Project project, Object obj, e eVar) {
            this.f72744c = project;
            this.f72743b = obj;
            this.f72742a = eVar;
        }

        public /* synthetic */ d(Project project, Object obj, e eVar, k kVar) {
            this(project, obj, eVar);
        }

        public Object a() {
            if (this.f72746e != null) {
                if (!this.f72742a.d()) {
                    throw new BuildException("Not allowed to use the polymorphic form for this element");
                }
                Object objD = ComponentHelper.j(this.f72744c).d(this.f72746e);
                this.f72745d = objD;
                if (objD == null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unable to create object of type ");
                    stringBuffer.append(this.f72746e);
                    throw new BuildException(stringBuffer.toString());
                }
            }
            try {
                Object objA = this.f72742a.a(this.f72744c, this.f72743b, this.f72745d);
                this.f72745d = objA;
                Project project = this.f72744c;
                if (project != null) {
                    project.K(objA);
                }
                return this.f72745d;
            } catch (IllegalAccessException e11) {
                throw new BuildException(e11);
            } catch (IllegalArgumentException e12) {
                if (this.f72746e == null) {
                    throw e12;
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Invalid type used ");
                stringBuffer2.append(this.f72746e);
                throw new BuildException(stringBuffer2.toString());
            } catch (InstantiationException e13) {
                throw new BuildException(e13);
            } catch (InvocationTargetException e14) {
                throw t.g(e14);
            }
        }

        public Object b() {
            return this.f72742a.c();
        }

        public void c(String str) {
            this.f72746e = str;
        }

        public void d() {
            try {
                this.f72742a.e(this.f72743b, this.f72745d);
            } catch (IllegalAccessException e11) {
                throw new BuildException(e11);
            } catch (IllegalArgumentException e12) {
                if (this.f72746e == null) {
                    throw e12;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Invalid type used ");
                stringBuffer.append(this.f72746e);
                throw new BuildException(stringBuffer.toString());
            } catch (InstantiationException e13) {
                throw new BuildException(e13);
            } catch (InvocationTargetException e14) {
                throw t.g(e14);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f72747a;

        public e(Method method) {
            this.f72747a = method;
        }

        public abstract Object a(Project project, Object obj, Object obj2) throws IllegalAccessException, InstantiationException, InvocationTargetException;

        public Method b() {
            return this.f72747a;
        }

        public Object c() {
            return null;
        }

        public boolean d() {
            return false;
        }

        public void e(Object obj, Object obj2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        }
    }

    static {
        Class[] clsArr = {Boolean.TYPE, Byte.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
        Class[] clsArr2 = new Class[8];
        Class clsC = f72715j;
        if (clsC == null) {
            clsC = c("java.lang.Boolean");
            f72715j = clsC;
        }
        clsArr2[0] = clsC;
        Class clsC2 = f72716k;
        if (clsC2 == null) {
            clsC2 = c("java.lang.Byte");
            f72716k = clsC2;
        }
        clsArr2[1] = clsC2;
        Class clsC3 = f72717l;
        if (clsC3 == null) {
            clsC3 = c("java.lang.Character");
            f72717l = clsC3;
        }
        clsArr2[2] = clsC3;
        Class clsC4 = f72718m;
        if (clsC4 == null) {
            clsC4 = c("java.lang.Short");
            f72718m = clsC4;
        }
        clsArr2[3] = clsC4;
        Class clsC5 = f72719n;
        if (clsC5 == null) {
            clsC5 = c("java.lang.Integer");
            f72719n = clsC5;
        }
        clsArr2[4] = clsC5;
        Class clsC6 = f72720o;
        if (clsC6 == null) {
            clsC6 = c("java.lang.Long");
            f72720o = clsC6;
        }
        clsArr2[5] = clsC6;
        Class clsC7 = f72721p;
        if (clsC7 == null) {
            clsC7 = c("java.lang.Float");
            f72721p = clsC7;
        }
        clsArr2[6] = clsC7;
        Class clsC8 = f72722q;
        if (clsC8 == null) {
            clsC8 = c("java.lang.Double");
            f72722q = clsC8;
        }
        clsArr2[7] = clsC8;
        for (int i11 = 0; i11 < 8; i11++) {
            f72714i.put(clsArr[i11], clsArr2[i11]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:103:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:139:0x0232 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x0232 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:50:0x00de  */
    /* JADX WARN: Code duplicated, block: B:64:0x0111  */
    /* JADX WARN: Code duplicated, block: B:66:0x0119  */
    /* JADX WARN: Code duplicated, block: B:67:0x0127  */
    /* JADX WARN: Code duplicated, block: B:69:0x012f  */
    /* JADX WARN: Code duplicated, block: B:78:0x015b  */
    /* JADX WARN: Code duplicated, block: B:80:0x0163  */
    public t(Class cls) throws NoSuchMethodException {
        Constructor<?> constructor;
        Constructor<?> constructor2;
        b bVarF;
        this.f72737f = null;
        this.f72738g = cls;
        Method[] methods = cls.getMethods();
        for (int i11 = 0; i11 < methods.length; i11++) {
            Method method = methods[i11];
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1 && Void.TYPE.equals(returnType) && ("add".equals(name) || "addConfigured".equals(name))) {
                n(method);
            } else {
                Class clsC = f72723r;
                if (clsC == null) {
                    clsC = c("org.apache.tools.ant.ProjectComponent");
                    f72723r = clsC;
                }
                if (!clsC.isAssignableFrom(cls) || parameterTypes.length != 1 || !q(name, parameterTypes[0])) {
                    if (o() && parameterTypes.length == 1 && "addTask".equals(name)) {
                        Class clsC2 = f72724s;
                        if (clsC2 == null) {
                            clsC2 = c("org.apache.tools.ant.Task");
                            f72724s = clsC2;
                        }
                        if (!clsC2.equals(parameterTypes[0])) {
                            if (!"addText".equals(name)) {
                                if (!name.startsWith("set")) {
                                    if (!name.startsWith("create")) {
                                        if (!name.startsWith("addConfigured")) {
                                            if (!name.startsWith("add")) {
                                            }
                                        } else if (!name.startsWith("add")) {
                                        }
                                    } else if (!name.startsWith("addConfigured")) {
                                        if (!name.startsWith("add")) {
                                        }
                                    } else if (!name.startsWith("add")) {
                                    }
                                } else if (!name.startsWith("create")) {
                                    if (!name.startsWith("addConfigured")) {
                                        if (!name.startsWith("add")) {
                                        }
                                    } else if (!name.startsWith("add")) {
                                    }
                                } else if (!name.startsWith("addConfigured")) {
                                    if (!name.startsWith("add")) {
                                    }
                                } else if (!name.startsWith("add")) {
                                }
                            } else if (!name.startsWith("set")) {
                                if (!name.startsWith("create")) {
                                    if (!name.startsWith("addConfigured")) {
                                        if (!name.startsWith("add")) {
                                        }
                                    } else if (!name.startsWith("add")) {
                                    }
                                } else if (!name.startsWith("addConfigured")) {
                                    if (!name.startsWith("add")) {
                                    }
                                } else if (!name.startsWith("add")) {
                                }
                            } else if (!name.startsWith("create")) {
                                if (!name.startsWith("addConfigured")) {
                                    if (!name.startsWith("add")) {
                                    }
                                } else if (!name.startsWith("add")) {
                                }
                            } else if (!name.startsWith("addConfigured")) {
                                if (!name.startsWith("add")) {
                                }
                            } else if (!name.startsWith("add")) {
                            }
                        }
                    } else if (!"addText".equals(name) && Void.TYPE.equals(returnType) && parameterTypes.length == 1) {
                        Class clsC3 = f72725t;
                        if (clsC3 == null) {
                            clsC3 = c("java.lang.String");
                            f72725t = clsC3;
                        }
                        if (clsC3.equals(parameterTypes[0])) {
                            this.f72737f = methods[i11];
                        } else if (!name.startsWith("set")) {
                            if (!name.startsWith("create")) {
                                if (!name.startsWith("addConfigured")) {
                                    if (!name.startsWith("add")) {
                                    }
                                } else if (!name.startsWith("add")) {
                                }
                            } else if (!name.startsWith("addConfigured")) {
                                if (!name.startsWith("add")) {
                                }
                            } else if (!name.startsWith("add")) {
                            }
                        } else if (!name.startsWith("create")) {
                            if (!name.startsWith("addConfigured")) {
                                if (!name.startsWith("add")) {
                                }
                            } else if (!name.startsWith("add")) {
                            }
                        } else if (!name.startsWith("addConfigured")) {
                            if (!name.startsWith("add")) {
                            }
                        } else if (!name.startsWith("add")) {
                        }
                    } else if (!name.startsWith("set") && Void.TYPE.equals(returnType) && parameterTypes.length == 1 && !parameterTypes[0].isArray()) {
                        String strM = m(name, "set");
                        if (this.f72733b.get(strM) == null) {
                            bVarF = f(method, parameterTypes[0], strM);
                            if (bVarF != null) {
                                this.f72732a.put(strM, parameterTypes[0]);
                                this.f72733b.put(strM, bVarF);
                            }
                        } else {
                            Class clsC4 = f72725t;
                            if (clsC4 == null) {
                                clsC4 = c("java.lang.String");
                                f72725t = clsC4;
                            }
                            if (!clsC4.equals(parameterTypes[0])) {
                                bVarF = f(method, parameterTypes[0], strM);
                                if (bVarF != null) {
                                    this.f72732a.put(strM, parameterTypes[0]);
                                    this.f72733b.put(strM, bVarF);
                                }
                            }
                        }
                    } else if (!name.startsWith("create") && !returnType.isArray() && !returnType.isPrimitive() && parameterTypes.length == 0) {
                        String strM2 = m(name, "create");
                        if (this.f72735d.get(strM2) == null) {
                            this.f72734c.put(strM2, returnType);
                            this.f72735d.put(strM2, new c(method));
                        }
                    } else if (!name.startsWith("addConfigured") && Void.TYPE.equals(returnType) && parameterTypes.length == 1) {
                        Class clsC5 = f72725t;
                        if (clsC5 == null) {
                            clsC5 = c("java.lang.String");
                            f72725t = clsC5;
                        }
                        if (!clsC5.equals(parameterTypes[0]) && !parameterTypes[0].isArray() && !parameterTypes[0].isPrimitive()) {
                            try {
                                constructor2 = parameterTypes[0].getConstructor(new Class[0]);
                            } catch (NoSuchMethodException unused) {
                                Class<?> cls2 = parameterTypes[0];
                                Class<?>[] clsArr = new Class[1];
                                Class<?> clsC6 = f72726u;
                                if (clsC6 == null) {
                                    clsC6 = c("org.apache.tools.ant.Project");
                                    f72726u = clsC6;
                                }
                                clsArr[0] = clsC6;
                                constructor2 = cls2.getConstructor(clsArr);
                            }
                            try {
                                String strM3 = m(name, "addConfigured");
                                this.f72734c.put(strM3, parameterTypes[0]);
                                this.f72735d.put(strM3, new a(method, constructor2, 2));
                            } catch (NoSuchMethodException unused2) {
                            }
                        } else if (!name.startsWith("add")) {
                        }
                    } else if (!name.startsWith("add") && Void.TYPE.equals(returnType) && parameterTypes.length == 1) {
                        Class clsC7 = f72725t;
                        if (clsC7 == null) {
                            clsC7 = c("java.lang.String");
                            f72725t = clsC7;
                        }
                        if (!clsC7.equals(parameterTypes[0]) && !parameterTypes[0].isArray() && !parameterTypes[0].isPrimitive()) {
                            try {
                                constructor = parameterTypes[0].getConstructor(new Class[0]);
                            } catch (NoSuchMethodException unused3) {
                                Class<?> cls3 = parameterTypes[0];
                                Class<?>[] clsArr2 = new Class[1];
                                Class<?> clsC8 = f72726u;
                                if (clsC8 == null) {
                                    clsC8 = c("org.apache.tools.ant.Project");
                                    f72726u = clsC8;
                                }
                                clsArr2[0] = clsC8;
                                constructor = cls3.getConstructor(clsArr2);
                            }
                            String strM4 = m(name, "add");
                            if (this.f72734c.get(strM4) == null) {
                                this.f72734c.put(strM4, parameterTypes[0]);
                                this.f72735d.put(strM4, new a(method, constructor, 1));
                            }
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ Class c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static BuildException g(InvocationTargetException invocationTargetException) {
        Throwable targetException = invocationTargetException.getTargetException();
        return targetException instanceof BuildException ? (BuildException) targetException : new BuildException(targetException);
    }

    public static t k(Project project, Class cls) {
        Map map = f72713h;
        t tVar = (t) map.get(cls.getName());
        if (tVar == null || tVar.f72738g != cls) {
            tVar = new t(cls);
            if (project != null) {
                map.put(cls.getName(), tVar);
            }
        }
        return tVar;
    }

    public static String m(String str, String str2) {
        return str.substring(str2.length()).toLowerCase(Locale.US);
    }

    public void b(Project project, Object obj, String str) throws BuildException {
        Method method = this.f72737f;
        if (method != null) {
            try {
                method.invoke(obj, str);
                return;
            } catch (IllegalAccessException e11) {
                throw new BuildException(e11);
            } catch (InvocationTargetException e12) {
                throw g(e12);
            }
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(project.p(obj));
        stringBuffer.append(" doesn't support nested text data (\"");
        stringBuffer.append(d(strTrim));
        stringBuffer.append("\").");
        throw new BuildException(stringBuffer.toString());
    }

    public final String d(String str) {
        return str.length() <= 20 ? str : new StringBuffer(str).replace(8, str.length() - 8, "...").toString();
    }

    public final e e(Project project, Object obj, String str) throws BuildException {
        ComponentHelper componentHelperJ;
        Class clsI;
        Method methodH;
        Object objD;
        if (this.f72736e.size() == 0 || (clsI = (componentHelperJ = ComponentHelper.j(project)).i(str)) == null || (methodH = h(clsI, this.f72736e)) == null || (objD = componentHelperJ.d(str)) == null) {
            return null;
        }
        return new j(this, methodH, objD instanceof org.apache.tools.ant.taskdefs.l ? ((org.apache.tools.ant.taskdefs.l) objD).v(project) : objD, objD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    public final b f(Method method, Class cls, String str) throws NoSuchMethodException {
        Class cls2;
        Constructor constructor;
        boolean z11;
        Map map = f72714i;
        if (map.containsKey(cls)) {
            cls = (Class) map.get(cls);
        }
        Class clsC = f72725t;
        if (clsC == null) {
            clsC = c("java.lang.String");
            f72725t = clsC;
        }
        if (clsC.equals(cls)) {
            return new m(this, method, method);
        }
        Class clsC2 = f72717l;
        if (clsC2 == null) {
            clsC2 = c("java.lang.Character");
            f72717l = clsC2;
        }
        if (clsC2.equals(cls)) {
            return new n(this, method, str, method);
        }
        Class clsC3 = f72715j;
        if (clsC3 == null) {
            clsC3 = c("java.lang.Boolean");
            f72715j = clsC3;
        }
        if (clsC3.equals(cls)) {
            return new o(this, method, method);
        }
        Class clsC4 = f72731z;
        if (clsC4 == null) {
            clsC4 = c("java.lang.Class");
            f72731z = clsC4;
        }
        if (clsC4.equals(cls)) {
            return new p(this, method, method);
        }
        Class clsC5 = A;
        if (clsC5 == null) {
            clsC5 = c("java.io.File");
            A = clsC5;
        }
        if (clsC5.equals(cls)) {
            return new q(this, method, method);
        }
        Class cls3 = B;
        if (cls3 == null) {
            cls2 = cls3;
            Class clsC6 = c("org.apache.tools.ant.types.EnumeratedAttribute");
            B = clsC6;
            cls2 = clsC6;
        }
        cls2 = cls3;
        if (cls2.isAssignableFrom(cls)) {
            return new r(this, method, cls, method);
        }
        if (Enum.class != 0 && Enum.class.isAssignableFrom(cls)) {
            return new s(this, method, method, cls);
        }
        Class clsC7 = f72720o;
        if (clsC7 == null) {
            clsC7 = c("java.lang.Long");
            f72720o = clsC7;
        }
        if (clsC7.equals(cls)) {
            return new h(this, method, method);
        }
        try {
            try {
                Class<?>[] clsArr = new Class[2];
                Class<?> clsC8 = f72726u;
                if (clsC8 == null) {
                    clsC8 = c("org.apache.tools.ant.Project");
                    f72726u = clsC8;
                }
                clsArr[0] = clsC8;
                Class<?> clsC9 = f72725t;
                if (clsC9 == null) {
                    clsC9 = c("java.lang.String");
                    f72725t = clsC9;
                }
                clsArr[1] = clsC9;
                constructor = cls.getConstructor(clsArr);
                z11 = true;
            } catch (NoSuchMethodException unused) {
                return null;
            }
        } catch (NoSuchMethodException unused2) {
            Class<?>[] clsArr2 = new Class[1];
            Class<?> clsC10 = f72725t;
            if (clsC10 == null) {
                clsC10 = c("java.lang.String");
                f72725t = clsC10;
            }
            clsArr2[0] = clsC10;
            constructor = cls.getConstructor(clsArr2);
            z11 = false;
        }
        return new i(this, method, z11, constructor, method);
    }

    public final Method h(Class cls, List list) {
        Method method = null;
        Class<?> cls2 = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            Method method2 = (Method) list.get(i11);
            Class<?> cls3 = method2.getParameterTypes()[0];
            if (cls3.isAssignableFrom(cls)) {
                if (cls2 == null) {
                    method = method2;
                    cls2 = cls3;
                } else if (!cls3.isAssignableFrom(cls2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("ambiguous: types ");
                    stringBuffer.append(cls2.getName());
                    stringBuffer.append(" and ");
                    stringBuffer.append(cls3.getName());
                    stringBuffer.append(" match ");
                    stringBuffer.append(cls.getName());
                    throw new BuildException(stringBuffer.toString());
                }
            }
        }
        return method;
    }

    public d i(Project project, String str, Object obj, String str2, c0 c0Var) {
        return new d(project, obj, l(project, str, obj, str2, c0Var), null);
    }

    public final String j(Project project, Object obj) {
        return project.p(obj);
    }

    public final e l(Project project, String str, Object obj, String str2, c0 c0Var) throws BuildException {
        Object objA;
        String strD = w.d(str2);
        String strC = w.c(str2);
        if (strD.equals("antlib:org.apache.tools.ant")) {
            strD = "";
        }
        if (str.equals("antlib:org.apache.tools.ant")) {
            str = "";
        }
        e lVar = (strD.equals(str) || strD.length() == 0) ? (e) this.f72735d.get(strC.toLowerCase(Locale.US)) : null;
        if (lVar == null) {
            lVar = e(project, obj, str2);
        }
        if (lVar == null && (obj instanceof g)) {
            Object objA2 = ((g) obj).a(c0Var != null ? c0Var.C() : "", strC, c0Var == null ? strC : c0Var.E());
            if (objA2 != null) {
                lVar = new k(this, null, objA2);
            }
        }
        if (lVar == null && (obj instanceof f) && (objA = ((f) obj).a(strC.toLowerCase(Locale.US))) != null) {
            lVar = new l(this, null, objA);
        }
        if (lVar == null) {
            t(project, obj, str2);
        }
        return lVar;
    }

    public final void n(Method method) {
        Class<?> cls = method.getParameterTypes()[0];
        for (int i11 = 0; i11 < this.f72736e.size(); i11++) {
            Method method2 = (Method) this.f72736e.get(i11);
            if (method2.getParameterTypes()[0].equals(cls)) {
                if (method.getName().equals("addConfigured")) {
                    this.f72736e.set(i11, method);
                    return;
                }
                return;
            } else {
                if (method2.getParameterTypes()[0].isAssignableFrom(cls)) {
                    this.f72736e.add(i11, method);
                    return;
                }
            }
        }
        this.f72736e.add(method);
    }

    public boolean o() {
        Class clsC = f72730y;
        if (clsC == null) {
            clsC = c("org.apache.tools.ant.TaskContainer");
            f72730y = clsC;
        }
        return clsC.isAssignableFrom(this.f72738g);
    }

    public boolean p() {
        Class clsC = f72728w;
        if (clsC == null) {
            clsC = c("org.apache.tools.ant.DynamicElement");
            f72728w = clsC;
        }
        if (!clsC.isAssignableFrom(this.f72738g)) {
            Class clsC2 = f72729x;
            if (clsC2 == null) {
                clsC2 = c("org.apache.tools.ant.DynamicElementNS");
                f72729x = clsC2;
            }
            if (!clsC2.isAssignableFrom(this.f72738g)) {
                return false;
            }
        }
        return true;
    }

    public final boolean q(String str, Class cls) {
        if ("setLocation".equals(str)) {
            Class clsC = f72727v;
            if (clsC == null) {
                clsC = c("org.apache.tools.ant.Location");
                f72727v = clsC;
            }
            if (clsC.equals(cls)) {
                return true;
            }
        }
        if (!"setTaskType".equals(str)) {
            return false;
        }
        Class clsC2 = f72725t;
        if (clsC2 == null) {
            clsC2 = c("java.lang.String");
            f72725t = clsC2;
        }
        return clsC2.equals(cls);
    }

    public void r(Project project, Object obj, String str, String str2) throws BuildException {
        String string;
        Hashtable hashtable = this.f72733b;
        Locale locale = Locale.US;
        b bVar = (b) hashtable.get(str.toLowerCase(locale));
        if (bVar != null) {
            try {
                bVar.a(project, obj, str2);
                return;
            } catch (IllegalAccessException e11) {
                throw new BuildException(e11);
            } catch (InvocationTargetException e12) {
                throw g(e12);
            }
        }
        if (!(obj instanceof org.apache.tools.ant.e)) {
            if (obj instanceof org.apache.tools.ant.d) {
                ((org.apache.tools.ant.d) obj).a(str.toLowerCase(locale), str2);
                return;
            }
            if (str.indexOf(58) != -1) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(j(project, obj));
            stringBuffer.append(" doesn't support the \"");
            stringBuffer.append(str);
            stringBuffer.append("\" attribute.");
            throw new UnsupportedAttributeException(stringBuffer.toString(), str);
        }
        org.apache.tools.ant.e eVar = (org.apache.tools.ant.e) obj;
        String strD = w.d(w.d(str));
        String strC = w.c(str);
        if ("".equals(strD)) {
            string = strC;
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(strD);
            stringBuffer2.append(":");
            stringBuffer2.append(strC);
            string = stringBuffer2.toString();
        }
        eVar.a(strD, strC, string, str2);
    }

    public boolean s(String str, String str2) {
        if (p() || this.f72736e.size() > 0) {
            return true;
        }
        if (!this.f72735d.containsKey(w.c(str2).toLowerCase(Locale.US))) {
            return false;
        }
        String strD = w.d(str2);
        if (strD.equals("antlib:org.apache.tools.ant")) {
            strD = "";
        }
        if ("".equals(strD)) {
            return true;
        }
        if (str.equals("antlib:org.apache.tools.ant")) {
            str = "";
        }
        return strD.equals(str);
    }

    public void t(Project project, Object obj, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(project.p(obj));
        stringBuffer.append(" doesn't support the nested \"");
        stringBuffer.append(str);
        stringBuffer.append("\" element.");
        throw new UnsupportedElementException(stringBuffer.toString(), str);
    }
}
