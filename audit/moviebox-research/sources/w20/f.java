package w20;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f extends t {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f79213i = t.h("PropertyResource".getBytes());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final InputStream f79214j = new e();

    public f(Project project, String str) {
        super(str);
        setProject(project);
    }

    @Override // org.apache.tools.ant.types.t
    public InputStream c() throws IOException {
        if (isReference()) {
            return ((t) getCheckedRef()).c();
        }
        return m() ? new ByteArrayInputStream(s().getBytes()) : f79214j;
    }

    @Override // org.apache.tools.ant.types.t
    public int hashCode() {
        return isReference() ? getCheckedRef().hashCode() : super.hashCode() * f79213i;
    }

    @Override // org.apache.tools.ant.types.t
    public long k() {
        if (isReference()) {
            return ((t) getCheckedRef()).k();
        }
        if (m()) {
            return s().length();
        }
        return 0L;
    }

    @Override // org.apache.tools.ant.types.t
    public boolean m() {
        return s() != null;
    }

    public String s() {
        Project project = getProject();
        if (project == null) {
            return null;
        }
        return project.s(j());
    }

    @Override // org.apache.tools.ant.types.t, org.apache.tools.ant.types.e
    public String toString() {
        return isReference() ? getCheckedRef().toString() : String.valueOf(s());
    }
}
