package org.apache.tools.ant;

import java.util.Vector;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Vector f72996a = new Vector();

    public static BuildException a(BuildException buildException, Location location) {
        if (buildException.getLocation() == null || buildException.getMessage() == null) {
            return buildException;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The following error occurred while executing this line:");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append(buildException.getLocation().toString());
        stringBuffer.append(buildException.getMessage());
        String string = stringBuffer.toString();
        return location == null ? new BuildException(string, buildException) : new BuildException(string, buildException, location);
    }

    public static void b(Project project, Object obj, String str) throws BuildException {
        if (str == null) {
            return;
        }
        if (obj instanceof b0) {
            obj = ((b0) obj).c();
        }
        t.k(project, obj.getClass()).b(project, obj, str);
    }

    public static String c(String str) {
        int iLastIndexOf = str.lastIndexOf(58);
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }

    public static String d(String str) {
        int iLastIndexOf;
        return (str == null || (iLastIndexOf = str.lastIndexOf(58)) == -1) ? "" : str.substring(0, iLastIndexOf);
    }

    public static String e(String str, String str2) {
        if (str == null || str.equals("") || str.equals("antlib:org.apache.tools.ant")) {
            return str2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(":");
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }
}
