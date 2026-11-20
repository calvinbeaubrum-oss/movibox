package s20;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.apache.tools.ant.Location;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.RuntimeConfigurable;
import org.apache.tools.ant.y;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Project f75928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f75929b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f75931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f75932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Locator f75933f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Vector f75930c = new Vector();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public y f75934g = new y();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public y f75935h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Vector f75936i = new Vector();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f75937j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map f75938k = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map f75939l = null;

    public a(Project project) {
        this.f75928a = project;
        this.f75934g.m(project);
        this.f75934g.l("");
        this.f75930c.addElement(this.f75934g);
    }

    public void a(y yVar) {
        this.f75930c.addElement(yVar);
        this.f75935h = yVar;
    }

    public void b(Object obj, Attributes attributes) {
        String value = attributes.getValue("id");
        if (value != null) {
            this.f75928a.b(value, obj);
        }
    }

    public RuntimeConfigurable c() {
        if (this.f75936i.size() < 1) {
            return null;
        }
        Vector vector = this.f75936i;
        return (RuntimeConfigurable) vector.elementAt(vector.size() - 1);
    }

    public void d(String str) {
        List list = (List) this.f75938k.get(str);
        if (list == null || list.size() == 0) {
            return;
        }
        list.remove(list.size() - 1);
    }

    public File e() {
        return this.f75929b;
    }

    public File f() {
        return this.f75931d;
    }

    public String g() {
        return this.f75932e;
    }

    public y h() {
        return this.f75935h;
    }

    public Map i() {
        return this.f75939l;
    }

    public y j() {
        return this.f75934g;
    }

    public Locator k() {
        return this.f75933f;
    }

    public String l(String str) {
        List list = (List) this.f75938k.get(str);
        if (list == null || list.size() == 0) {
            return null;
        }
        return (String) list.get(list.size() - 1);
    }

    public Project m() {
        return this.f75928a;
    }

    public boolean n() {
        return this.f75937j;
    }

    public void o() {
        if (this.f75936i.size() > 0) {
            Vector vector = this.f75936i;
            vector.removeElementAt(vector.size() - 1);
        }
    }

    public void p(RuntimeConfigurable runtimeConfigurable) {
        this.f75936i.addElement(runtimeConfigurable);
    }

    public void q(File file) {
        this.f75929b = file;
        this.f75931d = new File(file.getParent());
        this.f75934g.k(new Location(file.getAbsolutePath()));
    }

    public void r(String str) {
        this.f75932e = str;
    }

    public void s(y yVar) {
        this.f75935h = yVar;
    }

    public void t(y yVar) {
        this.f75934g = yVar;
    }

    public void u(Locator locator) {
        this.f75933f = locator;
    }

    public void v(String str, String str2) {
        List arrayList = (List) this.f75938k.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f75938k.put(str, arrayList);
        }
        arrayList.add(str2);
    }
}
