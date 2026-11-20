package org.apache.tools.ant.types;

import java.util.Stack;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.ComponentHelper;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.util.IdentityStack;
import org.apache.tools.ant.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class e extends v {
    protected boolean checked = true;
    protected r ref;

    public static void invokeCircularReferenceCheck(e eVar, Stack stack, Project project) {
        eVar.dieOnCircularReference(stack, project);
    }

    public void checkAttributesAllowed() {
        if (isReference()) {
            throw tooManyAttributes();
        }
    }

    public void checkChildrenAllowed() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
    }

    public BuildException circularReference() {
        return new BuildException("This data type contains a circular reference.");
    }

    @Override // org.apache.tools.ant.v
    public Object clone() throws CloneNotSupportedException {
        e eVar = (e) super.clone();
        eVar.setDescription(getDescription());
        getRefid();
        eVar.setChecked(isChecked());
        return eVar;
    }

    public void dieOnCircularReference() {
        dieOnCircularReference(getProject());
    }

    public void dieOnCircularReference(Stack stack, Project project) throws BuildException {
        if (!this.checked && isReference()) {
            throw null;
        }
    }

    public void dieOnCircularReference(Project project) {
        if (this.checked || !isReference()) {
            return;
        }
        dieOnCircularReference(new IdentityStack(this), project);
    }

    public Object getCheckedRef() {
        return getCheckedRef(getProject());
    }

    public Object getCheckedRef(Class cls, String str) {
        return getCheckedRef(cls, str, getProject());
    }

    public Object getCheckedRef(Class cls, String str, Project project) {
        if (project == null) {
            throw new BuildException("No Project specified");
        }
        dieOnCircularReference(project);
        throw null;
    }

    public Object getCheckedRef(Project project) {
        return getCheckedRef(getClass(), getDataTypeName(), project);
    }

    public String getDataTypeName() {
        return ComponentHelper.o(getProject(), this, true);
    }

    public r getRefid() {
        return null;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public boolean isReference() {
        return false;
    }

    public BuildException noChildrenAllowed() {
        return new BuildException("You must not specify nested elements when using refid");
    }

    public void setChecked(boolean z11) {
        this.checked = z11;
    }

    public void setRefid(r rVar) {
        this.checked = false;
    }

    public String toString() {
        String description = getDescription();
        if (description == null) {
            return getDataTypeName();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getDataTypeName());
        stringBuffer.append(" ");
        stringBuffer.append(description);
        return stringBuffer.toString();
    }

    public BuildException tooManyAttributes() {
        return new BuildException("You must not specify more than one attribute when using refid");
    }
}
