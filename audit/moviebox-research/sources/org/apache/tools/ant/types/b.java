package org.apache.tools.ant.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f72855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f72856b = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f72857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f72858b;

        public String a() {
            return this.f72858b;
        }

        public abstract String b();

        public String c() {
            return this.f72857a;
        }

        public String d() {
            if (c() != null && a() != null) {
                throw new BuildException("Both package and class have been set");
            }
            StringBuffer stringBuffer = new StringBuffer(b());
            if (c() != null) {
                stringBuffer.append(':');
                stringBuffer.append(c());
                if (!stringBuffer.toString().endsWith("...")) {
                    stringBuffer.append("...");
                }
            } else if (a() != null) {
                stringBuffer.append(':');
                stringBuffer.append(a());
            }
            return stringBuffer.toString();
        }
    }

    public void c(ListIterator listIterator) {
        getProject().x("Applying assertions", 4);
        b bVarD = d();
        if (Boolean.TRUE.equals(bVarD.f72855a)) {
            getProject().x("Enabling system assertions", 4);
            listIterator.add("-enablesystemassertions");
        } else if (Boolean.FALSE.equals(bVarD.f72855a)) {
            getProject().x("disabling system assertions", 4);
            listIterator.add("-disablesystemassertions");
        }
        Iterator it = bVarD.f72856b.iterator();
        while (it.hasNext()) {
            String strD = ((a) it.next()).d();
            Project project = getProject();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("adding assertion ");
            stringBuffer.append(strD);
            project.x(stringBuffer.toString(), 4);
            listIterator.add(strD);
        }
    }

    @Override // org.apache.tools.ant.types.e, org.apache.tools.ant.v
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.f72856b = (ArrayList) this.f72856b.clone();
        return bVar;
    }

    public final b d() {
        getRefid();
        return this;
    }

    @Override // org.apache.tools.ant.types.e
    public void setRefid(r rVar) {
        if (this.f72856b.size() > 0 || this.f72855a != null) {
            throw tooManyAttributes();
        }
        super.setRefid(rVar);
    }
}
