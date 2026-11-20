package org.apache.tools.ant.types;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class n extends e implements u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static n f72900c = new n(null, System.getProperty("java.class.path"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static n f72901d = new n(null, System.getProperty("sun.boot.class.path"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Iterator f72902f = Collections.EMPTY_SET.iterator();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static /* synthetic */ Class f72903g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f72904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w20.g f72905b;

    /* JADX INFO: compiled from: source.java */
    public class a implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String[] f72906a;

        public a() {
        }

        @Override // org.apache.tools.ant.types.u
        public boolean a() {
            return true;
        }

        public void b(File file) {
            this.f72906a = new String[]{n.y(file.getAbsolutePath())};
        }

        public void c(String str) {
            this.f72906a = n.A(n.this.getProject(), str);
        }

        @Override // org.apache.tools.ant.types.u
        public Iterator iterator() {
            return new w20.d(null, this.f72906a);
        }

        @Override // org.apache.tools.ant.types.u
        public int size() {
            String[] strArr = this.f72906a;
            if (strArr == null) {
                return 0;
            }
            return strArr.length;
        }
    }

    public n(Project project) {
        this.f72905b = null;
        setProject(project);
    }

    public n(Project project, String str) {
        this(project);
        q().c(str);
    }

    public static String[] A(Project project, String str) {
        Vector vector = new Vector();
        if (str == null) {
            return new String[0];
        }
        org.apache.tools.ant.u uVar = new org.apache.tools.ant.u(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (uVar.a()) {
            String strB = uVar.b();
            try {
                stringBuffer.append(v(project, strB).getPath());
            } catch (BuildException unused) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Dropping path element ");
                stringBuffer2.append(strB);
                stringBuffer2.append(" as it is not valid relative to the project");
                project.x(stringBuffer2.toString(), 3);
            }
            for (int i11 = 0; i11 < stringBuffer.length(); i11++) {
                z(stringBuffer, i11);
            }
            vector.addElement(stringBuffer.toString());
            stringBuffer = new StringBuffer();
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    public static /* synthetic */ Class m(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static File v(Project project, String str) {
        return org.apache.tools.ant.util.d.k().q(project == null ? null : project.m(), str);
    }

    public static String y(String str) {
        if (str == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i11 = 0; i11 < stringBuffer.length(); i11++) {
            z(stringBuffer, i11);
        }
        return stringBuffer.toString();
    }

    public static boolean z(StringBuffer stringBuffer, int i11) {
        if (stringBuffer.charAt(i11) != '/' && stringBuffer.charAt(i11) != '\\') {
            return false;
        }
        stringBuffer.setCharAt(i11, File.separatorChar);
        return true;
    }

    @Override // org.apache.tools.ant.types.u
    public synchronized boolean a() {
        if (isReference()) {
            return ((n) getCheckedRef()).a();
        }
        dieOnCircularReference();
        l(this.f72905b);
        return true;
    }

    public void c(n nVar) throws BuildException {
        if (nVar == this) {
            throw circularReference();
        }
        if (nVar.getProject() == null) {
            nVar.setProject(getProject());
        }
        d(nVar);
    }

    @Override // org.apache.tools.ant.types.e, org.apache.tools.ant.v
    public Object clone() {
        try {
            n nVar = (n) super.clone();
            w20.g gVar = this.f72905b;
            if (gVar != null) {
                gVar = (w20.g) gVar.clone();
            }
            nVar.f72905b = gVar;
            return nVar;
        } catch (CloneNotSupportedException e11) {
            throw new BuildException(e11);
        }
    }

    public void d(u uVar) {
        checkChildrenAllowed();
        if (uVar == null) {
            return;
        }
        if (this.f72905b == null) {
            w20.g gVar = new w20.g();
            this.f72905b = gVar;
            gVar.setProject(getProject());
            this.f72905b.l(false);
        }
        this.f72905b.c(uVar);
        setChecked(false);
    }

    @Override // org.apache.tools.ant.types.e
    public synchronized void dieOnCircularReference(Stack stack, Project project) throws BuildException {
        try {
            if (isChecked()) {
                return;
            }
            if (isReference()) {
                super.dieOnCircularReference(stack, project);
            } else {
                w20.g gVar = this.f72905b;
                if (gVar != null) {
                    stack.push(gVar);
                    e.invokeCircularReferenceCheck(this.f72905b, stack, project);
                    stack.pop();
                }
                setChecked(true);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void h(n nVar) {
        j(nVar, false);
    }

    @Override // org.apache.tools.ant.types.u
    public final synchronized Iterator iterator() {
        if (isReference()) {
            return ((n) getCheckedRef()).iterator();
        }
        dieOnCircularReference();
        if (s()) {
            return new w20.d(null, t());
        }
        w20.g gVar = this.f72905b;
        return gVar == null ? f72902f : l(gVar).iterator();
    }

    public void j(n nVar, boolean z11) {
        String[] strArrT = nVar.t();
        File file = z11 ? new File(System.getProperty("user.dir")) : null;
        for (int i11 = 0; i11 < strArrT.length; i11++) {
            File fileV = v(getProject(), strArrT[i11]);
            if (z11 && !fileV.exists()) {
                fileV = new File(file, strArrT[i11]);
            }
            if (fileV.exists()) {
                x(fileV);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("dropping ");
                stringBuffer.append(fileV);
                stringBuffer.append(" from path as it doesn't exist");
                log(stringBuffer.toString(), 3);
            }
        }
    }

    public void k(n nVar) {
        if (nVar == null) {
            return;
        }
        c(nVar);
    }

    public u l(u uVar) {
        if (uVar == null || uVar.a()) {
            return uVar;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getDataTypeName());
        stringBuffer.append(" allows only filesystem resources.");
        throw new BuildException(stringBuffer.toString());
    }

    public final n n(String str, n nVar) {
        String strS;
        n nVar2 = new n(getProject());
        if (getProject() != null && (strS = getProject().s("build.sysclasspath")) != null) {
            str = strS;
        }
        if (str.equals("only")) {
            nVar2.j(nVar, true);
        } else if (str.equals("first")) {
            nVar2.j(nVar, true);
            nVar2.h(this);
        } else if (str.equals("ignore")) {
            nVar2.h(this);
        } else {
            if (!str.equals("last")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("invalid value for build.sysclasspath: ");
                stringBuffer.append(str);
                log(stringBuffer.toString(), 1);
            }
            nVar2.h(this);
            nVar2.j(nVar, true);
        }
        return nVar2;
    }

    public n o(String str) {
        return n(str, f72901d);
    }

    public n p(String str) {
        return n(str, f72900c);
    }

    public a q() throws BuildException {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        a aVar = new a();
        d(aVar);
        return aVar;
    }

    public boolean r() {
        Class<?> cls = getClass();
        Class clsM = f72903g;
        if (clsM == null) {
            clsM = m("org.apache.tools.ant.types.Path");
            f72903g = clsM;
        }
        if (cls.equals(clsM)) {
            return false;
        }
        try {
            Class<?> declaringClass = getClass().getMethod("list", null).getDeclaringClass();
            Class clsM2 = f72903g;
            if (clsM2 == null) {
                clsM2 = m("org.apache.tools.ant.types.Path");
                f72903g = clsM2;
            }
            return !declaringClass.equals(clsM2);
        } catch (Exception unused) {
            return false;
        }
    }

    public final synchronized boolean s() {
        try {
            if (this.f72904a == null) {
                this.f72904a = r() ? Boolean.TRUE : Boolean.FALSE;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f72904a.booleanValue();
    }

    @Override // org.apache.tools.ant.types.e
    public void setRefid(r rVar) throws BuildException {
        if (this.f72905b != null) {
            throw tooManyAttributes();
        }
        super.setRefid(rVar);
    }

    @Override // org.apache.tools.ant.types.u
    public synchronized int size() {
        if (isReference()) {
            return ((n) getCheckedRef()).size();
        }
        dieOnCircularReference();
        w20.g gVar = this.f72905b;
        return gVar == null ? 0 : l(gVar).size();
    }

    public String[] t() {
        if (isReference()) {
            return ((n) getCheckedRef()).t();
        }
        return l(this.f72905b) == null ? new String[0] : this.f72905b.n();
    }

    @Override // org.apache.tools.ant.types.e
    public String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        w20.g gVar = this.f72905b;
        return gVar == null ? "" : gVar.toString();
    }

    public void x(File file) throws BuildException {
        checkAttributesAllowed();
        q().b(file);
    }
}
