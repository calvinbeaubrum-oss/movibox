package org.apache.tools.ant;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static /* synthetic */ Class f72670g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f72671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class f72672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class f72673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Class f72674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f72675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ClassLoader f72676f;

    public static /* synthetic */ Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public void a(Project project) {
        if (this.f72672b == null) {
            Class clsJ = j(project);
            this.f72672b = clsJ;
            if (clsJ == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unable to create class for ");
                stringBuffer.append(i());
                throw new BuildException(stringBuffer.toString());
            }
        }
        if (this.f72673c != null) {
            Class cls = this.f72674d;
            if (cls == null || !cls.isAssignableFrom(this.f72672b)) {
                b0 b0Var = (b0) d(project, this.f72673c);
                if (b0Var == null) {
                    throw new BuildException("Unable to create adapter object");
                }
                b0Var.b(this.f72672b);
            }
        }
    }

    public Object c(Project project) {
        return k(project);
    }

    public final Object d(Project project, Class cls) {
        try {
            return l(cls, project);
        } catch (IllegalAccessException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not create type ");
            stringBuffer.append(this.f72671a);
            stringBuffer.append(" as the constructor ");
            stringBuffer.append(cls);
            stringBuffer.append(" is not accessible");
            throw new BuildException(stringBuffer.toString());
        } catch (InstantiationException unused2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not create type ");
            stringBuffer2.append(this.f72671a);
            stringBuffer2.append(" as the class ");
            stringBuffer2.append(cls);
            stringBuffer2.append(" is abstract");
            throw new BuildException(stringBuffer2.toString());
        } catch (NoClassDefFoundError e11) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Type ");
            stringBuffer3.append(this.f72671a);
            stringBuffer3.append(": A class needed by class ");
            stringBuffer3.append(cls);
            stringBuffer3.append(" cannot be found: ");
            stringBuffer3.append(e11.getMessage());
            throw new BuildException(stringBuffer3.toString(), e11);
        } catch (NoSuchMethodException unused3) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Could not create type ");
            stringBuffer4.append(this.f72671a);
            stringBuffer4.append(" as the class ");
            stringBuffer4.append(cls);
            stringBuffer4.append(" has no compatible constructor");
            throw new BuildException(stringBuffer4.toString());
        } catch (InvocationTargetException e12) {
            Throwable targetException = e12.getTargetException();
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Could not create type ");
            stringBuffer5.append(this.f72671a);
            stringBuffer5.append(" due to ");
            stringBuffer5.append(targetException);
            throw new BuildException(stringBuffer5.toString(), targetException);
        } catch (Throwable th2) {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("Could not create type ");
            stringBuffer6.append(this.f72671a);
            stringBuffer6.append(" due to ");
            stringBuffer6.append(th2);
            throw new BuildException(stringBuffer6.toString(), th2);
        }
    }

    public final String e(Class cls) {
        return cls == null ? "<null>" : cls.getClass().getName();
    }

    public ClassLoader f() {
        return this.f72676f;
    }

    public String g() {
        return this.f72675e;
    }

    public Class h(Project project) {
        Class<?> clsJ;
        if (this.f72674d != null && ((clsJ = j(project)) == null || this.f72674d.isAssignableFrom(clsJ))) {
            return clsJ;
        }
        Class cls = this.f72673c;
        return cls == null ? j(project) : cls;
    }

    public String i() {
        return this.f72671a;
    }

    public Class j(Project project) {
        try {
            return m();
        } catch (ClassNotFoundException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not load class (");
            stringBuffer.append(this.f72675e);
            stringBuffer.append(") for type ");
            stringBuffer.append(this.f72671a);
            project.x(stringBuffer.toString(), 4);
            return null;
        } catch (NoClassDefFoundError e11) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not load a dependent class (");
            stringBuffer2.append(e11.getMessage());
            stringBuffer2.append(") for type ");
            stringBuffer2.append(this.f72671a);
            project.x(stringBuffer2.toString(), 4);
            return null;
        }
    }

    public final Object k(Project project) {
        Class clsJ = j(project);
        if (clsJ == null) {
            return null;
        }
        Object objD = d(project, clsJ);
        if (objD == null || this.f72673c == null) {
            return objD;
        }
        Class cls = this.f72674d;
        if (cls != null && cls.isAssignableFrom(objD.getClass())) {
            return objD;
        }
        b0 b0Var = (b0) d(project, this.f72673c);
        if (b0Var == null) {
            return null;
        }
        b0Var.a(objD);
        return b0Var;
    }

    public Object l(Class cls, Project project) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Constructor constructor;
        boolean z11;
        try {
            constructor = cls.getConstructor(new Class[0]);
            z11 = true;
        } catch (NoSuchMethodException unused) {
            Class<?>[] clsArr = new Class[1];
            Class<?> clsB = f72670g;
            if (clsB == null) {
                clsB = b("org.apache.tools.ant.Project");
                f72670g = clsB;
            }
            clsArr[0] = clsB;
            constructor = cls.getConstructor(clsArr);
            z11 = false;
        }
        Object objNewInstance = constructor.newInstance(z11 ? new Object[0] : new Object[]{project});
        project.K(objNewInstance);
        return objNewInstance;
    }

    public Class m() throws ClassNotFoundException {
        Class cls = this.f72672b;
        if (cls != null) {
            return cls;
        }
        ClassLoader classLoader = this.f72676f;
        if (classLoader == null) {
            this.f72672b = Class.forName(this.f72675e);
        } else {
            this.f72672b = classLoader.loadClass(this.f72675e);
        }
        return this.f72672b;
    }

    public boolean n(b bVar, Project project) {
        return bVar != null && bVar.getClass() == getClass() && bVar.j(project).equals(j(project)) && bVar.h(project).equals(h(project)) && bVar.f72673c == this.f72673c && bVar.f72674d == this.f72674d;
    }

    public void o(Class cls) {
        this.f72674d = cls;
    }

    public void p(Class cls) {
        this.f72673c = cls;
    }

    public void q(Class cls) {
        this.f72672b = cls;
        if (cls == null) {
            return;
        }
        ClassLoader classLoader = this.f72676f;
        if (classLoader == null) {
            classLoader = cls.getClassLoader();
        }
        this.f72676f = classLoader;
        String name = this.f72675e;
        if (name == null) {
            name = cls.getName();
        }
        this.f72675e = name;
    }

    public void r(ClassLoader classLoader) {
        this.f72676f = classLoader;
    }

    public void s(String str) {
        this.f72675e = str;
    }

    public void t(String str) {
        this.f72671a = str;
    }

    public boolean u(b bVar, Project project) {
        if (bVar == null || getClass() != bVar.getClass() || !g().equals(bVar.g()) || !e(this.f72673c).equals(e(bVar.f72673c)) || !e(this.f72674d).equals(e(bVar.f72674d))) {
            return false;
        }
        ClassLoader classLoaderF = bVar.f();
        ClassLoader classLoaderF2 = f();
        return classLoaderF == classLoaderF2 || ((classLoaderF instanceof a) && (classLoaderF2 instanceof a) && ((a) classLoaderF).s().equals(((a) classLoaderF2).s()));
    }
}
