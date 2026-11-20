package org.apache.tools.ant.util;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: org.apache.tools.ant.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0787a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v f72936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public org.apache.tools.ant.types.n f72937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f72938c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f72939d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f72940e = false;

        public C0787a(v vVar) {
            this.f72936a = vVar;
        }

        public String a() {
            String str = this.f72939d;
            if (str != null || this.f72938c == null) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ant.loader.");
            stringBuffer.append(this.f72938c);
            return stringBuffer.toString();
        }

        public ClassLoader b() {
            return a.b(c(), this.f72937b, a(), this.f72940e, this.f72939d != null || a.e(c()));
        }

        public final Project c() {
            return this.f72936a.getProject();
        }
    }

    public static ClassLoader b(Project project, org.apache.tools.ant.types.n nVar, String str, boolean z11, boolean z12) {
        ClassLoader classLoaderD;
        if (str == null || !z12) {
            classLoaderD = null;
        } else {
            Object objT = project.t(str);
            if (objT != null && !(objT instanceof ClassLoader)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("The specified loader id ");
                stringBuffer.append(str);
                stringBuffer.append(" does not reference a class loader");
                throw new BuildException(stringBuffer.toString());
            }
            classLoaderD = (ClassLoader) objT;
        }
        if (classLoaderD == null) {
            classLoaderD = d(project, nVar, z11);
            if (str != null && z12) {
                project.d(str, classLoaderD);
            }
        }
        return classLoaderD;
    }

    public static C0787a c(v vVar) {
        return new C0787a(vVar);
    }

    public static ClassLoader d(Project project, org.apache.tools.ant.types.n nVar, boolean z11) {
        org.apache.tools.ant.a aVarG = project.g(nVar);
        if (z11) {
            aVarG.G(false);
            aVarG.e();
        }
        return aVarG;
    }

    public static boolean e(Project project) {
        return project.s("ant.reuse.loader") != null;
    }

    public static Object f(String str, ClassLoader classLoader, Class cls) {
        try {
            Object objNewInstance = Class.forName(str, true, classLoader).newInstance();
            if (cls.isInstance(objNewInstance)) {
                return objNewInstance;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Class of unexpected Type: ");
            stringBuffer.append(str);
            stringBuffer.append(" expected :");
            stringBuffer.append(cls);
            throw new BuildException(stringBuffer.toString());
        } catch (ClassNotFoundException e11) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Class not found: ");
            stringBuffer2.append(str);
            throw new BuildException(stringBuffer2.toString(), e11);
        } catch (IllegalAccessException e12) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Could not instantiate ");
            stringBuffer3.append(str);
            stringBuffer3.append(". Specified class should have a ");
            stringBuffer3.append("public constructor.");
            throw new BuildException(stringBuffer3.toString(), e12);
        } catch (InstantiationException e13) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Could not instantiate ");
            stringBuffer4.append(str);
            stringBuffer4.append(". Specified class should have a no ");
            stringBuffer4.append("argument constructor.");
            throw new BuildException(stringBuffer4.toString(), e13);
        } catch (LinkageError e14) {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Class ");
            stringBuffer5.append(str);
            stringBuffer5.append(" could not be loaded because of an invalid dependency.");
            throw new BuildException(stringBuffer5.toString(), e14);
        }
    }
}
