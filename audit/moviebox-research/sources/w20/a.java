package w20;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a extends org.apache.tools.ant.types.e implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f79200a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Collection f79201b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f79202c = true;

    @Override // org.apache.tools.ant.types.u
    public synchronized boolean a() {
        if (isReference()) {
            return ((a) getCheckedRef()).a();
        }
        dieOnCircularReference();
        Iterator it = this.f79200a.iterator();
        boolean zA = true;
        while (zA && it.hasNext()) {
            zA = ((u) it.next()).a();
        }
        if (zA) {
            return true;
        }
        Iterator it2 = d().iterator();
        while (it2.hasNext()) {
            if (!(it2.next() instanceof c)) {
                return false;
            }
        }
        return true;
    }

    public synchronized void c(u uVar) throws BuildException {
        Project project;
        try {
            if (isReference()) {
                throw noChildrenAllowed();
            }
            if (uVar == null) {
                return;
            }
            if (Project.q(uVar) == null && (project = getProject()) != null) {
                project.K(uVar);
            }
            this.f79200a.add(uVar);
            b.c(this);
            this.f79201b = null;
            setChecked(false);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // org.apache.tools.ant.types.e, org.apache.tools.ant.v
    public Object clone() {
        try {
            a aVar = (a) super.clone();
            aVar.f79200a = new ArrayList(this.f79200a);
            aVar.f79201b = null;
            return aVar;
        } catch (CloneNotSupportedException e11) {
            throw new BuildException(e11);
        }
    }

    public final synchronized Collection d() {
        try {
            if (this.f79201b == null || !k()) {
                this.f79201b = h();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f79201b;
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
                for (Object obj : this.f79200a) {
                    if (obj instanceof org.apache.tools.ant.types.e) {
                        stack.push(obj);
                        org.apache.tools.ant.types.e.invokeCircularReferenceCheck((org.apache.tools.ant.types.e) obj, stack, project);
                        stack.pop();
                    }
                }
                setChecked(true);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public abstract Collection h();

    @Override // org.apache.tools.ant.types.u
    public final synchronized Iterator iterator() {
        if (isReference()) {
            return ((a) getCheckedRef()).iterator();
        }
        dieOnCircularReference();
        return new b(this, d().iterator());
    }

    public final synchronized List j() {
        dieOnCircularReference();
        return Collections.unmodifiableList(this.f79200a);
    }

    public synchronized boolean k() {
        return this.f79202c;
    }

    public synchronized void l(boolean z11) {
        this.f79202c = z11;
    }

    @Override // org.apache.tools.ant.types.u
    public synchronized int size() {
        if (isReference()) {
            return ((a) getCheckedRef()).size();
        }
        dieOnCircularReference();
        return d().size();
    }

    @Override // org.apache.tools.ant.types.e
    public synchronized String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        if (d().size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.f79201b.iterator();
        while (it.hasNext()) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(File.pathSeparatorChar);
            }
            stringBuffer.append(it.next());
        }
        return stringBuffer.toString();
    }
}
