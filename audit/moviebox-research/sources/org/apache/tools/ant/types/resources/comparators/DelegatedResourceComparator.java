package org.apache.tools.ant.types.resources.comparators;

import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.e;
import org.apache.tools.ant.types.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class DelegatedResourceComparator extends ResourceComparator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Vector f72922v = null;

    public synchronized void add(ResourceComparator resourceComparator) {
        try {
            if (isReference()) {
                throw noChildrenAllowed();
            }
            if (resourceComparator == null) {
                return;
            }
            Vector vector = this.f72922v;
            if (vector == null) {
                vector = new Vector();
            }
            this.f72922v = vector;
            vector.add(resourceComparator);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // org.apache.tools.ant.types.e
    public void dieOnCircularReference(Stack stack, Project project) throws BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
            return;
        }
        Vector vector = this.f72922v;
        if (vector != null && !vector.isEmpty()) {
            for (Object obj : this.f72922v) {
                if (obj instanceof e) {
                    stack.push(obj);
                    e.invokeCircularReferenceCheck((e) obj, stack, project);
                }
            }
        }
        setChecked(true);
    }

    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator, java.util.Comparator
    public synchronized boolean equals(Object obj) {
        boolean zEquals = true;
        if (obj == this) {
            return true;
        }
        if (isReference()) {
            return getCheckedRef().equals(obj);
        }
        if (!(obj instanceof DelegatedResourceComparator)) {
            return false;
        }
        Vector vector = ((DelegatedResourceComparator) obj).f72922v;
        Vector vector2 = this.f72922v;
        if (vector2 != null) {
            zEquals = vector2.equals(vector);
        } else if (vector != null) {
            zEquals = false;
        }
        return zEquals;
    }

    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public synchronized int hashCode() {
        if (isReference()) {
            return getCheckedRef().hashCode();
        }
        Vector vector = this.f72922v;
        return vector == null ? 0 : vector.hashCode();
    }

    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public synchronized int resourceCompare(t tVar, t tVar2) {
        Vector vector = this.f72922v;
        if (vector != null && !vector.isEmpty()) {
            Iterator it = this.f72922v.iterator();
            int iResourceCompare = 0;
            while (iResourceCompare == 0 && it.hasNext()) {
                iResourceCompare = ((ResourceComparator) it.next()).resourceCompare(tVar, tVar2);
            }
            return iResourceCompare;
        }
        return tVar.compareTo(tVar2);
    }
}
