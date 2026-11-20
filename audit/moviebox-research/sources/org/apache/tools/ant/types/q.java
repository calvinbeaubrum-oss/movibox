package org.apache.tools.ant.types;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class q extends e implements u {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static /* synthetic */ Class f72910h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set f72913c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f72911a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f72912b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Vector f72914d = new Vector();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Vector f72915f = new Vector();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f72916g = true;

    /* JADX INFO: compiled from: source.java */
    public static class a extends f {
        @Override // org.apache.tools.ant.types.f
        public String[] c() {
            return new String[]{"all", "system", "commandline"};
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f72917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f72918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f72919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f72920d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f72921e;

        public final void e(String str, String str2) {
            if (str2 == null || str2.length() < 1) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Invalid attribute: ");
                stringBuffer.append(str);
                throw new BuildException(stringBuffer.toString());
            }
            int i11 = this.f72917a + 1;
            this.f72917a = i11;
            if (i11 != 1) {
                throw new BuildException("Attributes name, regex, and prefix are mutually exclusive");
            }
        }

        public void f(a aVar) {
            String strB = aVar.b();
            e("builtin", strB);
            this.f72921e = strB;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("name=");
            stringBuffer.append(this.f72918b);
            stringBuffer.append(", regex=");
            stringBuffer.append(this.f72919c);
            stringBuffer.append(", prefix=");
            stringBuffer.append(this.f72920d);
            stringBuffer.append(", builtin=");
            stringBuffer.append(this.f72921e);
            return stringBuffer.toString();
        }
    }

    public static /* synthetic */ Class k(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    @Override // org.apache.tools.ant.types.u
    public boolean a() {
        return isReference() && p().a();
    }

    public final void c(Set set, Hashtable hashtable) {
        Enumeration enumerationElements = this.f72914d.elements();
        while (enumerationElements.hasMoreElements()) {
            b bVar = (b) enumerationElements.nextElement();
            if (bVar.f72918b != null) {
                if (hashtable.get(bVar.f72918b) != null) {
                    set.add(bVar.f72918b);
                }
            } else if (bVar.f72920d != null) {
                Enumeration enumerationKeys = hashtable.keys();
                while (enumerationKeys.hasMoreElements()) {
                    String str = (String) enumerationKeys.nextElement();
                    if (str.startsWith(bVar.f72920d)) {
                        set.add(str);
                    }
                }
            } else if (bVar.f72919c != null) {
                y20.a aVarC = new y20.b().c();
                aVarC.b(bVar.f72919c);
                Enumeration enumerationKeys2 = hashtable.keys();
                while (enumerationKeys2.hasMoreElements()) {
                    String str2 = (String) enumerationKeys2.nextElement();
                    if (aVarC.a(str2)) {
                        set.add(str2);
                    }
                }
            } else {
                if (bVar.f72921e == null) {
                    throw new BuildException("Impossible: Invalid PropertyRef!");
                }
                if (bVar.f72921e.equals("all")) {
                    set.addAll(hashtable.keySet());
                } else if (bVar.f72921e.equals("system")) {
                    set.addAll(System.getProperties().keySet());
                } else {
                    if (!bVar.f72921e.equals("commandline")) {
                        throw new BuildException("Impossible: Invalid builtin attribute!");
                    }
                    set.addAll(getProject().w().keySet());
                }
            }
        }
    }

    public void d(b bVar) {
        j();
        this.f72914d.addElement(bVar);
    }

    public void h(a aVar) {
        b bVar = new b();
        bVar.f(aVar);
        d(bVar);
    }

    @Override // org.apache.tools.ant.types.u
    public Iterator iterator() {
        return new p(this, o().propertyNames());
    }

    public final void j() {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.f72916g = false;
    }

    public final Hashtable l() {
        Hashtable hashtable = new Hashtable();
        Enumeration<?> enumerationPropertyNames = System.getProperties().propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            String str = (String) enumerationPropertyNames.nextElement();
            hashtable.put(str, System.getProperties().getProperty(str));
        }
        return hashtable;
    }

    public boolean m() {
        return isReference() ? p().f72911a : this.f72911a;
    }

    public k n() {
        if (!isReference()) {
            return null;
        }
        p().getClass();
        return null;
    }

    public Properties o() {
        Set<String> set;
        Set set2;
        if (isReference()) {
            return p().o();
        }
        Project project = getProject();
        Hashtable hashtableL = project == null ? l() : project.r();
        Enumeration enumerationElements = this.f72915f.elements();
        while (enumerationElements.hasMoreElements()) {
            hashtableL.putAll(((q) enumerationElements.nextElement()).o());
        }
        if (m() || (set2 = this.f72913c) == null) {
            set = set2;
            Set hashSet = new HashSet();
            c(hashSet, hashtableL);
            Enumeration enumerationElements2 = this.f72915f.elements();
            while (enumerationElements2.hasMoreElements()) {
                hashSet.addAll(((q) enumerationElements2.nextElement()).o().keySet());
            }
            Set set3 = hashSet;
            if (this.f72912b) {
                HashSet hashSet2 = new HashSet(hashtableL.keySet());
                hashSet2.removeAll(hashSet);
                set3 = hashSet2;
            }
            set = set3;
            if (!m()) {
                this.f72913c = set3;
                set = set3;
            }
        }
        set = set2;
        n();
        Properties properties = new Properties();
        for (String str : set) {
            String str2 = (String) hashtableL.get(str);
            if (str2 != null) {
                properties.setProperty(str, str2);
            }
        }
        return properties;
    }

    public q p() {
        Class clsK = f72910h;
        if (clsK == null) {
            clsK = k("org.apache.tools.ant.types.PropertySet");
            f72910h = clsK;
        }
        return (q) getCheckedRef(clsK, "propertyset");
    }

    @Override // org.apache.tools.ant.types.e
    public final void setRefid(r rVar) {
        if (!this.f72916g) {
            throw tooManyAttributes();
        }
        super.setRefid(rVar);
    }

    @Override // org.apache.tools.ant.types.u
    public int size() {
        return isReference() ? p().size() : o().size();
    }

    @Override // org.apache.tools.ant.types.e
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry entry : new TreeMap(o()).entrySet()) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(entry.getKey().toString());
            stringBuffer.append("=");
            stringBuffer.append(entry.getValue().toString());
        }
        return stringBuffer.toString();
    }
}
