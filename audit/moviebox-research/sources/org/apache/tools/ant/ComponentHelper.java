package org.apache.tools.ant;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ComponentHelper {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Properties[] f72620j = new Properties[2];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static /* synthetic */ Class f72621k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AntTypeTable f72622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Hashtable f72623b = new Hashtable();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f72624c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Hashtable f72625d = new Hashtable();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f72626e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Set f72627f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Stack f72628g = new Stack();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f72629h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Project f72630i;

    /* JADX INFO: compiled from: source.java */
    public static class AntTypeTable extends Hashtable {
        private static final long serialVersionUID = -3060442320477772028L;
        private Project project;

        public AntTypeTable(Project project) {
            this.project = project;
        }

        @Override // java.util.Hashtable
        public boolean contains(Object obj) {
            boolean z11;
            if (!(obj instanceof Class)) {
                return false;
            }
            Iterator it = values().iterator();
            loop0: while (true) {
                while (true) {
                    if (!it.hasNext() || z11) {
                        break loop0;
                    }
                    z11 = ((b) it.next()).h(this.project) == obj;
                }
            }
            return z11;
        }

        @Override // java.util.Hashtable, java.util.Map
        public boolean containsValue(Object obj) {
            return contains(obj);
        }

        public Object create(String str) {
            b definition = getDefinition(str);
            if (definition == null) {
                return null;
            }
            return definition.c(this.project);
        }

        public List findMatches(String str) {
            ArrayList arrayList = new ArrayList();
            for (b bVar : values()) {
                if (bVar.i().startsWith(str)) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public Object get(Object obj) {
            return getTypeClass((String) obj);
        }

        public b getDefinition(String str) {
            return (b) super.get(str);
        }

        public Class getExposedClass(String str) {
            b definition = getDefinition(str);
            if (definition == null) {
                return null;
            }
            return definition.h(this.project);
        }

        public Class getTypeClass(String str) {
            b definition = getDefinition(str);
            if (definition == null) {
                return null;
            }
            return definition.j(this.project);
        }
    }

    public static /* synthetic */ Class c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static ComponentHelper j(Project project) {
        if (project == null) {
            return null;
        }
        ComponentHelper componentHelper = (ComponentHelper) project.t("ant.ComponentHelper");
        if (componentHelper != null) {
            return componentHelper;
        }
        ComponentHelper componentHelper2 = new ComponentHelper();
        componentHelper2.u(project);
        project.d("ant.ComponentHelper", componentHelper2);
        return componentHelper2;
    }

    public static String o(Project project, Object obj, boolean z11) {
        if (project == null) {
            project = Project.q(obj);
        }
        return project == null ? p(obj.getClass(), z11) : j(project).n(obj, z11);
    }

    public static String p(Class cls, boolean z11) {
        if (!z11) {
            return cls.toString();
        }
        String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    public void a(b bVar) {
        v(bVar);
    }

    public final synchronized void b(String str) {
        try {
            String strD = w.d(str);
            if ("".equals(strD)) {
                strD = "antlib:org.apache.tools.ant";
            }
            if (strD.startsWith("antlib:")) {
                if (this.f72627f.contains(strD)) {
                    return;
                }
                this.f72627f.add(strD);
                org.apache.tools.ant.taskdefs.o oVar = new org.apache.tools.ant.taskdefs.o();
                oVar.setProject(this.f72630i);
                oVar.m();
                oVar.z(strD);
                oVar.s(strD);
                oVar.S(org.apache.tools.ant.taskdefs.e.G(strD));
                oVar.R(new org.apache.tools.ant.taskdefs.e.a("ignore"));
                oVar.c();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public Object d(String str) {
        b bVarL = l(str);
        if (bVarL == null) {
            return null;
        }
        return bVarL.c(this.f72630i);
    }

    public Object e(c0 c0Var, String str, String str2) throws BuildException {
        Object objD = d(str2);
        if (objD instanceof z) {
            z zVar = (z) objD;
            zVar.setLocation(c0Var.getLocation());
            zVar.t(str2);
            zVar.s(c0Var.j());
            zVar.q(c0Var.d());
            zVar.m();
        }
        return objD;
    }

    public String f(String str, String str2) {
        String string;
        boolean z11;
        boolean z12;
        boolean z13;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Problem: failed to create ");
        stringBuffer.append(str2);
        stringBuffer.append(" ");
        stringBuffer.append(str);
        printWriter.println(stringBuffer.toString());
        File file = new File(System.getProperty("user.home"), u20.a.f78173a);
        String property = System.getProperty("ant.home");
        boolean z14 = true;
        boolean z15 = false;
        if (property != null) {
            string = new File(property, "lib").getAbsolutePath();
            z11 = false;
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("ANT_HOME");
            stringBuffer2.append(File.separatorChar);
            stringBuffer2.append("lib");
            string = stringBuffer2.toString();
            z11 = true;
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("        -");
        stringBuffer3.append(string);
        stringBuffer3.append('\n');
        if (z11) {
            stringBuffer3.append("        -");
            stringBuffer3.append("the IDE Ant configuration dialogs");
        } else {
            stringBuffer3.append("        -");
            stringBuffer3.append(file);
            stringBuffer3.append('\n');
            stringBuffer3.append("        -");
            stringBuffer3.append("a directory added on the command line with the -lib argument");
        }
        String string2 = stringBuffer3.toString();
        b bVarL = l(str);
        if (bVarL == null) {
            s(printWriter, str, string2);
        } else {
            String strG = bVarL.g();
            boolean zStartsWith = strG.startsWith("org.apache.tools.ant.");
            boolean zStartsWith2 = strG.startsWith("org.apache.tools.ant.taskdefs.optional") | strG.startsWith("org.apache.tools.ant.types.optional");
            Class clsM = null;
            try {
                clsM = bVarL.m();
                z12 = false;
            } catch (ClassNotFoundException unused) {
                z13 = !zStartsWith2;
                q(printWriter, strG, zStartsWith2, string2);
                z12 = true;
            } catch (NoClassDefFoundError e11) {
                r(printWriter, zStartsWith2, e11, string2);
                z12 = true;
            }
            z13 = false;
            if (clsM != null) {
                try {
                    bVarL.l(clsM, this.f72630i);
                    printWriter.println("The component could be instantiated.");
                } catch (IllegalAccessException unused2) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("Cause: The constructor for ");
                    stringBuffer4.append(strG);
                    stringBuffer4.append(" is private and cannot be invoked.");
                    printWriter.println(stringBuffer4.toString());
                    z14 = z12;
                    z15 = true;
                } catch (InstantiationException unused3) {
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append("Cause: The class ");
                    stringBuffer5.append(strG);
                    stringBuffer5.append(" is abstract and cannot be instantiated.");
                    printWriter.println(stringBuffer5.toString());
                    z14 = z12;
                    z15 = true;
                } catch (NoClassDefFoundError e12) {
                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append("Cause:  A class needed by class ");
                    stringBuffer6.append(strG);
                    stringBuffer6.append(" cannot be found: ");
                    printWriter.println(stringBuffer6.toString());
                    StringBuffer stringBuffer7 = new StringBuffer();
                    stringBuffer7.append("       ");
                    stringBuffer7.append(e12.getMessage());
                    printWriter.println(stringBuffer7.toString());
                    printWriter.println("Action: Determine what extra JAR files are needed, and place them in:");
                    printWriter.println(string2);
                } catch (NoSuchMethodException unused4) {
                    StringBuffer stringBuffer8 = new StringBuffer();
                    stringBuffer8.append("Cause: The class ");
                    stringBuffer8.append(strG);
                    stringBuffer8.append(" has no compatible constructor.");
                    printWriter.println(stringBuffer8.toString());
                    z14 = z12;
                    z15 = true;
                } catch (InvocationTargetException e13) {
                    Throwable targetException = e13.getTargetException();
                    printWriter.println("Cause: The constructor threw the exception");
                    printWriter.println(targetException.toString());
                    targetException.printStackTrace(printWriter);
                    z14 = z12;
                    z15 = true;
                }
            }
            z14 = z12;
            printWriter.println();
            printWriter.println("Do not panic, this is a common problem.");
            if (z13) {
                printWriter.println("It may just be a typographical error in the build file or the task/type declaration.");
            }
            if (z14) {
                printWriter.println("The commonest cause is a missing JAR.");
            }
            if (z15) {
                printWriter.println("This is quite a low level problem, which may need consultation with the author of the task.");
                if (zStartsWith) {
                    printWriter.println("This may be the Ant team. Please file a defect or contact the developer team.");
                } else {
                    printWriter.println("This does not appear to be a task bundled with Ant.");
                    StringBuffer stringBuffer9 = new StringBuffer();
                    stringBuffer9.append("Please take it up with the supplier of the third-party ");
                    stringBuffer9.append(str2);
                    stringBuffer9.append(InstructionFileId.DOT);
                    printWriter.println(stringBuffer9.toString());
                    printWriter.println("If you have written it yourself, you probably have a bug to fix.");
                }
            } else {
                printWriter.println();
                printWriter.println("This is not a bug; it is a configuration problem");
            }
        }
        printWriter.flush();
        printWriter.close();
        return stringWriter.toString();
    }

    public void g(String str) {
        this.f72629h = str;
        this.f72628g.push(str);
    }

    public void h() {
        this.f72628g.pop();
        this.f72629h = this.f72628g.size() == 0 ? null : (String) this.f72628g.peek();
    }

    public Class i(String str) {
        b bVarL = l(str);
        if (bVarL == null) {
            return null;
        }
        return bVarL.h(this.f72630i);
    }

    public String k() {
        return this.f72629h;
    }

    public b l(String str) {
        b(str);
        return this.f72622a.getDefinition(str);
    }

    public String m(Object obj) {
        return n(obj, false);
    }

    public String n(Object obj, boolean z11) {
        Class cls = obj.getClass();
        String name = cls.getName();
        for (b bVar : this.f72622a.values()) {
            if (name.equals(bVar.g()) && cls == bVar.h(this.f72630i)) {
                String strI = bVar.i();
                if (z11) {
                    return strI;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("The <");
                stringBuffer.append(strI);
                stringBuffer.append("> type");
                return stringBuffer.toString();
            }
        }
        return p(obj.getClass(), z11);
    }

    public final void q(PrintWriter printWriter, String str, boolean z11, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cause: the class ");
        stringBuffer.append(str);
        stringBuffer.append(" was not found.");
        printWriter.println(stringBuffer.toString());
        if (z11) {
            printWriter.println("        This looks like one of Ant's optional components.");
            printWriter.println("Action: Check that the appropriate optional JAR exists in");
            printWriter.println(str2);
        } else {
            printWriter.println("Action: Check that the component has been correctly declared");
            printWriter.println("        and that the implementing JAR is in one of:");
            printWriter.println(str2);
        }
    }

    public final void r(PrintWriter printWriter, boolean z11, NoClassDefFoundError noClassDefFoundError, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cause: Could not load a dependent class ");
        stringBuffer.append(noClassDefFoundError.getMessage());
        printWriter.println(stringBuffer.toString());
        if (z11) {
            printWriter.println("       It is not enough to have Ant's optional JARs");
            printWriter.println("       you need the JAR files that the optional tasks depend upon.");
            printWriter.println("       Ant's optional task dependencies are listed in the manual.");
        } else {
            printWriter.println("       This class may be in a separate JAR that is not installed.");
        }
        printWriter.println("Action: Determine what extra JAR files are needed, and place them in one of:");
        printWriter.println(str);
    }

    public final void s(PrintWriter printWriter, String str, String str2) {
        boolean z11 = str.indexOf("antlib:") == 0;
        String strD = w.d(str);
        printWriter.println("Cause: The name is undefined.");
        printWriter.println("Action: Check the spelling.");
        printWriter.println("Action: Check that any custom tasks/types have been declared.");
        printWriter.println("Action: Check that any <presetdef>/<macrodef> declarations have taken place.");
        if (strD.length() > 0) {
            List listFindMatches = this.f72622a.findMatches(strD);
            if (listFindMatches.size() <= 0) {
                printWriter.println("No types or tasks have been defined in this namespace yet");
                if (z11) {
                    printWriter.println();
                    printWriter.println("This appears to be an antlib declaration. ");
                    printWriter.println("Action: Check that the implementing library exists in one of:");
                    printWriter.println(str2);
                    return;
                }
                return;
            }
            printWriter.println();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The definitions in the namespace ");
            stringBuffer.append(strD);
            stringBuffer.append(" are:");
            printWriter.println(stringBuffer.toString());
            Iterator it = listFindMatches.iterator();
            while (it.hasNext()) {
                String strC = w.c(((b) it.next()).i());
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("    ");
                stringBuffer2.append(strC);
                printWriter.println(stringBuffer2.toString());
            }
        }
    }

    public final boolean t(b bVar, b bVar2) {
        boolean zW = w(bVar);
        return zW == w(bVar2) && (!zW || bVar.n(bVar2, this.f72630i));
    }

    public void u(Project project) {
        this.f72630i = project;
        this.f72622a = new AntTypeTable(project);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003a  */
    public final void v(b bVar) {
        boolean z11;
        String strI = bVar.i();
        synchronized (this.f72622a) {
            try {
                this.f72624c = true;
                this.f72626e = true;
                b definition = this.f72622a.getDefinition(strI);
                if (definition != null) {
                    if (t(bVar, definition)) {
                        return;
                    }
                    Class<?> exposedClass = this.f72622a.getExposedClass(strI);
                    if (exposedClass == null) {
                        z11 = false;
                    } else {
                        Class clsC = f72621k;
                        if (clsC == null) {
                            clsC = c("org.apache.tools.ant.Task");
                            f72621k = clsC;
                        }
                        if (clsC.isAssignableFrom(exposedClass)) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                    }
                    Project project = this.f72630i;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Trying to override old definition of ");
                    stringBuffer.append(z11 ? "task " : "datatype ");
                    stringBuffer.append(strI);
                    project.x(stringBuffer.toString(), bVar.u(definition, this.f72630i) ? 3 : 1);
                }
                Project project2 = this.f72630i;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(" +Datatype ");
                stringBuffer2.append(strI);
                stringBuffer2.append(" ");
                stringBuffer2.append(bVar.g());
                project2.x(stringBuffer2.toString(), 4);
                this.f72622a.put(strI, bVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean w(b bVar) {
        return (bVar.j(this.f72630i) == null || bVar.h(this.f72630i) == null) ? false : true;
    }
}
