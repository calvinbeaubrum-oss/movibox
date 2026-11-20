package y20;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.util.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static /* synthetic */ Class f81098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static /* synthetic */ Class f81099b;

    public static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static Throwable e(Throwable th2, BuildException buildException, boolean z11) {
        if (th2 != null) {
            return th2;
        }
        Throwable exception = buildException.getException();
        if (z11 && (exception instanceof ClassNotFoundException)) {
            return null;
        }
        return exception;
    }

    public a b(String str) throws BuildException {
        Class clsA = f81098a;
        if (clsA == null) {
            clsA = a("org.apache.tools.ant.util.regexp.RegexpMatcherFactory");
            f81098a = clsA;
        }
        ClassLoader classLoader = clsA.getClassLoader();
        Class clsA2 = f81099b;
        if (clsA2 == null) {
            clsA2 = a("org.apache.tools.ant.util.regexp.RegexpMatcher");
            f81099b = clsA2;
        }
        return (a) org.apache.tools.ant.util.a.f(str, classLoader, clsA2);
    }

    public a c() throws BuildException {
        return d(null);
    }

    public a d(Project project) throws BuildException {
        String string;
        String property = project == null ? System.getProperty("ant.regexp.regexpimpl") : project.s("ant.regexp.regexpimpl");
        if (property != null) {
            return b(property);
        }
        try {
            f("java.util.regex.Matcher");
            return b("org.apache.tools.ant.util.regexp.Jdk14RegexpMatcher");
        } catch (BuildException e11) {
            Throwable thE = e(null, e11, f.f() < 14);
            try {
                f("org.apache.oro.text.regex.Pattern");
                return b("org.apache.tools.ant.util.regexp.JakartaOroMatcher");
            } catch (BuildException e12) {
                Throwable thE2 = e(thE, e12, true);
                try {
                    f("org.apache.regexp.RE");
                    return b("org.apache.tools.ant.util.regexp.JakartaRegexpMatcher");
                } catch (BuildException e13) {
                    Throwable thE3 = e(thE2, e13, true);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("No supported regular expression matcher found");
                    if (thE3 != null) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(": ");
                        stringBuffer2.append(thE3);
                        string = stringBuffer2.toString();
                    } else {
                        string = "";
                    }
                    stringBuffer.append(string);
                    throw new BuildException(stringBuffer.toString(), thE3);
                }
            }
        }
    }

    public void f(String str) throws BuildException {
        try {
            Class.forName(str);
        } catch (Throwable th2) {
            throw new BuildException(th2);
        }
    }
}
