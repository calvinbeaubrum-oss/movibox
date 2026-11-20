package w20;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.types.r;
import org.apache.tools.ant.types.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c extends t {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final org.apache.tools.ant.util.d f79206k = org.apache.tools.ant.util.d.k();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f79207l = t.h("null file".getBytes());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f79208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public File f79209j;

    public c() {
    }

    public c(File file, String str) {
        y(f79206k.q(file, str));
        x(file);
    }

    @Override // org.apache.tools.ant.types.t, org.apache.tools.ant.types.u
    public boolean a() {
        return !isReference() || ((c) getCheckedRef()).a();
    }

    @Override // org.apache.tools.ant.types.t
    public InputStream c() throws IOException {
        return isReference() ? ((t) getCheckedRef()).c() : new FileInputStream(v());
    }

    @Override // org.apache.tools.ant.types.t, java.lang.Comparable
    public int compareTo(Object obj) {
        if (isReference()) {
            return ((Comparable) getCheckedRef()).compareTo(obj);
        }
        if (equals(obj)) {
            return 0;
        }
        if (!obj.getClass().equals(getClass())) {
            return super.compareTo(obj);
        }
        c cVar = (c) obj;
        File fileT = t();
        if (fileT == null) {
            return -1;
        }
        File fileT2 = cVar.t();
        if (fileT2 == null) {
            return 1;
        }
        return fileT.compareTo(fileT2);
    }

    @Override // org.apache.tools.ant.types.t
    public long d() {
        return isReference() ? ((t) getCheckedRef()).d() : v().lastModified();
    }

    @Override // org.apache.tools.ant.types.t
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (isReference()) {
            return getCheckedRef().equals(obj);
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        c cVar = (c) obj;
        if (t() == null) {
            return cVar.t() == null;
        }
        return t().equals(cVar.t());
    }

    @Override // org.apache.tools.ant.types.t
    public int hashCode() {
        if (isReference()) {
            return getCheckedRef().hashCode();
        }
        return t.f72925g * (t() == null ? f79207l : t().hashCode());
    }

    @Override // org.apache.tools.ant.types.t
    public String j() {
        if (isReference()) {
            return ((t) getCheckedRef()).j();
        }
        File fileS = s();
        return fileS == null ? v().getName() : f79206k.p(fileS, v());
    }

    @Override // org.apache.tools.ant.types.t
    public long k() {
        return isReference() ? ((t) getCheckedRef()).k() : v().length();
    }

    @Override // org.apache.tools.ant.types.t
    public boolean l() {
        return isReference() ? ((t) getCheckedRef()).l() : v().isDirectory();
    }

    @Override // org.apache.tools.ant.types.t
    public boolean m() {
        return isReference() ? ((t) getCheckedRef()).m() : v().exists();
    }

    public File s() {
        return isReference() ? ((c) getCheckedRef()).s() : this.f79209j;
    }

    @Override // org.apache.tools.ant.types.t, org.apache.tools.ant.types.e
    public void setRefid(r rVar) {
        if (this.f79208i != null || this.f79209j != null) {
            throw tooManyAttributes();
        }
        super.setRefid(rVar);
    }

    public File t() {
        return isReference() ? ((c) getCheckedRef()).t() : this.f79208i;
    }

    @Override // org.apache.tools.ant.types.t, org.apache.tools.ant.types.e
    public String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        File file = this.f79208i;
        if (file == null) {
            return "(unbound file resource)";
        }
        return f79206k.o(file.getAbsolutePath()).getAbsolutePath();
    }

    public File v() {
        if (t() != null) {
            return t();
        }
        throw new BuildException("file attribute is null!");
    }

    public void x(File file) {
        checkAttributesAllowed();
        this.f79209j = file;
    }

    public void y(File file) {
        checkAttributesAllowed();
        this.f79208i = file;
    }
}
