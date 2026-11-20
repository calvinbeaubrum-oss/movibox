package org.apache.tools.ant;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Project {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f72631r = System.getProperty("line.separator");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final org.apache.tools.ant.util.d f72632s = org.apache.tools.ant.util.d.k();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static /* synthetic */ Class f72633t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f72634a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f72638e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.apache.tools.ant.types.i f72640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public org.apache.tools.ant.types.j f72641h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f72642i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Vector f72643j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ClassLoader f72644k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map f72645l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map f72646m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public t20.b f72647n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public InputStream f72648o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f72649p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f72650q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Hashtable f72635b = new AntRefTable();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f72636c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Project f72637d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Hashtable f72639f = new Hashtable();

    /* JADX INFO: compiled from: source.java */
    public static class AntRefTable extends Hashtable {
        public final Object a(Object obj) {
            return super.get(obj);
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public Object get(Object obj) {
            Object objA = a(obj);
            if (!(objA instanceof c0)) {
                return objA;
            }
            c0 c0Var = (c0) objA;
            c0Var.n();
            return c0Var.F();
        }
    }

    public Project() {
        org.apache.tools.ant.types.i iVar = new org.apache.tools.ant.types.i();
        this.f72640g = iVar;
        iVar.setProject(this);
        this.f72641h = new org.apache.tools.ant.types.j(this.f72640g);
        this.f72643j = new Vector();
        this.f72644k = null;
        this.f72645l = Collections.synchronizedMap(new WeakHashMap());
        this.f72646m = Collections.synchronizedMap(new WeakHashMap());
        this.f72647n = null;
        this.f72648o = null;
        this.f72649p = false;
        this.f72650q = false;
        this.f72647n = new t20.a();
    }

    public static boolean N(String str) {
        return "on".equalsIgnoreCase(str) || "true".equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str);
    }

    public static /* synthetic */ Class f(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static Project q(Object obj) {
        if (obj instanceof v) {
            return ((v) obj).getProject();
        }
        try {
            Method method = obj.getClass().getMethod("getProject", null);
            Class<?> clsF = f72633t;
            if (clsF == null) {
                clsF = f("org.apache.tools.ant.Project");
                f72633t = clsF;
            }
            if (clsF == method.getReturnType()) {
                return (Project) method.invoke(obj, null);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public synchronized void A(Thread thread, z zVar) {
        try {
            if (zVar != null) {
                this.f72645l.put(thread, zVar);
                this.f72646m.put(thread.getThreadGroup(), zVar);
            } else {
                this.f72645l.remove(thread);
                this.f72646m.remove(thread.getThreadGroup());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void B(c cVar) {
        Vector vectorN = n();
        vectorN.removeElement(cVar);
        this.f72643j = vectorN;
    }

    public String C(String str) throws BuildException {
        return x.d(this).i(null, str, null);
    }

    public File D(String str) {
        return f72632s.q(this.f72642i, str);
    }

    public final Object E(String str, Project project) {
        c0 c0Var = (c0) this.f72636c.get(str);
        if (c0Var == null) {
            Project project2 = this.f72637d;
            if (project2 == null) {
                return null;
            }
            return project2.E(str, project);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Warning: Reference ");
        stringBuffer.append(str);
        stringBuffer.append(" has not been set at runtime,");
        stringBuffer.append(" but was found during");
        String str2 = f72631r;
        stringBuffer.append(str2);
        stringBuffer.append("build file parsing, attempting to resolve.");
        stringBuffer.append(" Future versions of Ant may support");
        stringBuffer.append(str2);
        stringBuffer.append(" referencing ids defined in non-executed targets.");
        project.x(stringBuffer.toString(), 1);
        c0 c0VarZ = c0Var.z(project);
        c0VarZ.n();
        return c0VarZ.F();
    }

    public void F(File file) throws BuildException {
        File fileO = f72632s.o(file.getAbsolutePath());
        if (!fileO.exists()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Basedir ");
            stringBuffer.append(fileO.getAbsolutePath());
            stringBuffer.append(" does not exist");
            throw new BuildException(stringBuffer.toString());
        }
        if (!fileO.isDirectory()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Basedir ");
            stringBuffer2.append(fileO.getAbsolutePath());
            stringBuffer2.append(" is not a directory");
            throw new BuildException(stringBuffer2.toString());
        }
        this.f72642i = fileO;
        L("basedir", fileO.getPath());
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Project base dir set to: ");
        stringBuffer3.append(this.f72642i);
        x(stringBuffer3.toString(), 3);
    }

    public void G(String str) throws BuildException {
        F(new File(str));
    }

    public void H(String str) {
        this.f72638e = str;
    }

    public void I(String str) {
        M("ant.project.name", str);
        this.f72634a = str;
    }

    public void J(String str, String str2) {
        x.d(this).j(null, str, str2);
    }

    public final void K(Object obj) {
        if (obj instanceof v) {
            ((v) obj).setProject(this);
            return;
        }
        try {
            Class<?> cls = obj.getClass();
            Class<?>[] clsArr = new Class[1];
            Class<?> clsF = f72633t;
            if (clsF == null) {
                clsF = f("org.apache.tools.ant.Project");
                f72633t = clsF;
            }
            clsArr[0] = clsF;
            Method method = cls.getMethod("setProject", clsArr);
            if (method != null) {
                method.invoke(obj, this);
            }
        } catch (Throwable unused) {
        }
    }

    public final void L(String str, String str2) {
        x.d(this).l(null, str, str2, false);
    }

    public void M(String str, String str2) {
        x.d(this).n(null, str, str2);
    }

    public synchronized void a(c cVar) {
        if (this.f72643j.contains(cVar)) {
            return;
        }
        Vector vectorN = n();
        vectorN.addElement(cVar);
        this.f72643j = vectorN;
    }

    public void b(String str, Object obj) {
        this.f72636c.put(str, obj);
    }

    public void c(String str, y yVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" +Target: ");
        stringBuffer.append(str);
        x(stringBuffer.toString(), 4);
        yVar.m(this);
        this.f72639f.put(str, yVar);
    }

    public void d(String str, Object obj) {
        synchronized (this.f72635b) {
            try {
                Object objA = ((AntRefTable) this.f72635b).a(str);
                if (objA == obj) {
                    return;
                }
                if (objA != null && !(objA instanceof c0)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Overriding previous definition of reference to ");
                    stringBuffer.append(str);
                    x(stringBuffer.toString(), 3);
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Adding reference: ");
                stringBuffer2.append(str);
                x(stringBuffer2.toString(), 4);
                this.f72635b.put(str, obj);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void e(String str, y yVar) throws BuildException {
        if (this.f72639f.get(str) == null) {
            c(str, yVar);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Duplicate target: `");
        stringBuffer.append(str);
        stringBuffer.append("'");
        throw new BuildException(stringBuffer.toString());
    }

    public a g(org.apache.tools.ant.types.n nVar) {
        return new a(getClass().getClassLoader(), this, nVar);
    }

    public void h(Project project, String str, Throwable th2, int i11) {
        BuildEvent buildEvent = new BuildEvent(project);
        buildEvent.setException(th2);
        j(buildEvent, str, i11);
    }

    public void i(z zVar, String str, Throwable th2, int i11) {
        BuildEvent buildEvent = new BuildEvent(zVar);
        buildEvent.setException(th2);
        j(buildEvent, str, i11);
    }

    public final void j(BuildEvent buildEvent, String str, int i11) {
        String str2 = org.apache.tools.ant.util.p.f72993a;
        if (str.endsWith(str2)) {
            buildEvent.setMessage(str.substring(0, str.length() - str2.length()), i11);
        } else {
            buildEvent.setMessage(str, i11);
        }
        synchronized (this) {
            if (this.f72650q) {
                return;
            }
            try {
                this.f72650q = true;
                Iterator it = this.f72643j.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(buildEvent);
                }
                this.f72650q = false;
            } catch (Throwable th2) {
                this.f72650q = false;
                throw th2;
            }
        }
    }

    public void k(z zVar, Throwable th2) {
        A(Thread.currentThread(), null);
        System.out.flush();
        System.err.flush();
        BuildEvent buildEvent = new BuildEvent(zVar);
        buildEvent.setException(th2);
        Iterator it = this.f72643j.iterator();
        while (it.hasNext()) {
            ((c) it.next()).c(buildEvent);
        }
    }

    public void l(z zVar) {
        A(Thread.currentThread(), zVar);
        BuildEvent buildEvent = new BuildEvent(zVar);
        Iterator it = this.f72643j.iterator();
        while (it.hasNext()) {
            ((c) it.next()).b(buildEvent);
        }
    }

    public File m() {
        if (this.f72642i == null) {
            try {
                G(InstructionFileId.DOT);
            } catch (BuildException e11) {
                e11.printStackTrace();
            }
        }
        return this.f72642i;
    }

    public Vector n() {
        return (Vector) this.f72643j.clone();
    }

    public ClassLoader o() {
        return this.f72644k;
    }

    public String p(Object obj) {
        return ComponentHelper.j(this).m(obj);
    }

    public Hashtable r() {
        return x.d(this).b();
    }

    public String s(String str) {
        return (String) x.d(this).c(null, str);
    }

    public Object t(String str) {
        Object obj = this.f72635b.get(str);
        if (obj != null) {
            return obj;
        }
        Object objE = E(str, this);
        if (objE == null && !str.equals("ant.PropertyHelper")) {
            Vector vector = new Vector();
            x.d(this).g(str, new Vector(), vector);
            if (vector.size() == 1) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unresolvable reference ");
                stringBuffer.append(str);
                stringBuffer.append(" might be a misuse of property expansion syntax.");
                x(stringBuffer.toString(), 1);
            }
        }
        return objE;
    }

    public Hashtable u() {
        return this.f72639f;
    }

    public z v(Thread thread) {
        z zVar = (z) this.f72645l.get(thread);
        if (zVar == null) {
            for (ThreadGroup threadGroup = thread.getThreadGroup(); zVar == null && threadGroup != null; threadGroup = threadGroup.getParent()) {
                zVar = (z) this.f72646m.get(threadGroup);
            }
        }
        return zVar;
    }

    public Hashtable w() {
        return x.d(this).f();
    }

    public void x(String str, int i11) {
        y(str, null, i11);
    }

    public void y(String str, Throwable th2, int i11) {
        h(this, str, th2, i11);
    }

    public void z(z zVar, String str, int i11) {
        i(zVar, str, null, i11);
    }
}
