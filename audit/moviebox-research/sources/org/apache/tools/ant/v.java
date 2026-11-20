package org.apache.tools.ant;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class v implements Cloneable {
    protected String description;
    protected Location location = Location.UNKNOWN_LOCATION;
    protected Project project;

    public Object clone() throws CloneNotSupportedException {
        v vVar = (v) super.clone();
        vVar.setLocation(getLocation());
        vVar.setProject(getProject());
        return vVar;
    }

    public String getDescription() {
        return this.description;
    }

    public Location getLocation() {
        return this.location;
    }

    public Project getProject() {
        return this.project;
    }

    public void log(String str) {
        log(str, 2);
    }

    public void log(String str, int i11) {
        if (getProject() != null) {
            getProject().x(str, i11);
        } else if (i11 <= 2) {
            System.err.println(str);
        }
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
