package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class d {
    public static Class<?> a(String str) throws ParseException {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            throw new ParseException("Unable to find the class: " + str);
        }
    }

    public static Date b(String str) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static File c(String str) {
        return new File(str);
    }

    public static File[] d(String str) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static Number e(String str) throws ParseException {
        try {
            return str.indexOf(46) != -1 ? Double.valueOf(str) : Long.valueOf(str);
        } catch (NumberFormatException e11) {
            throw new ParseException(e11.getMessage());
        }
    }

    public static Object f(String str) throws ParseException {
        try {
            try {
                return Class.forName(str).newInstance();
            } catch (Exception e11) {
                throw new ParseException(e11.getClass().getName() + "; Unable to create an instance of: " + str);
            }
        } catch (ClassNotFoundException unused) {
            throw new ParseException("Unable to find the class: " + str);
        }
    }

    public static URL g(String str) throws ParseException {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            throw new ParseException("Unable to parse the URL: " + str);
        }
    }

    public static Object h(String str, Class<?> cls) throws ParseException {
        if (c.f40056a == cls) {
            return str;
        }
        if (c.f40057b == cls) {
            return f(str);
        }
        if (c.f40058c == cls) {
            return e(str);
        }
        if (c.f40059d == cls) {
            return b(str);
        }
        if (c.f40060e == cls) {
            return a(str);
        }
        if (c.f40062g != cls && c.f40061f != cls) {
            if (c.f40063h == cls) {
                return d(str);
            }
            if (c.f40064i == cls) {
                return g(str);
            }
            return null;
        }
        return c(str);
    }

    public static Object i(String str, Object obj) throws ParseException {
        return h(str, (Class) obj);
    }
}
