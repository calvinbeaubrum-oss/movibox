package org.apache.tools.ant;

import java.util.EventObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class BuildEvent extends EventObject {
    private static final long serialVersionUID = 4538050075952288486L;
    private Throwable exception;
    private String message;
    private int priority;
    private Project project;
    private y target;
    private z task;

    public BuildEvent(Project project) {
        super(project);
        this.priority = 3;
        this.project = project;
        this.target = null;
        this.task = null;
    }

    public BuildEvent(y yVar) {
        super(yVar);
        this.priority = 3;
        this.project = yVar.e();
        this.target = yVar;
        this.task = null;
    }

    public BuildEvent(z zVar) {
        super(zVar);
        this.priority = 3;
        this.project = zVar.getProject();
        this.target = zVar.d();
        this.task = zVar;
    }

    public Throwable getException() {
        return this.exception;
    }

    public String getMessage() {
        return this.message;
    }

    public int getPriority() {
        return this.priority;
    }

    public Project getProject() {
        return this.project;
    }

    public y getTarget() {
        return this.target;
    }

    public z getTask() {
        return this.task;
    }

    public void setException(Throwable th2) {
        this.exception = th2;
    }

    public void setMessage(String str, int i11) {
        this.message = str;
        this.priority = i11;
    }
}
