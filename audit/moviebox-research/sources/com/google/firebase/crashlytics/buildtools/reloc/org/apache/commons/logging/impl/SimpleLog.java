package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.LogConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class SimpleLog implements Serializable {
    protected static final String DEFAULT_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss:SSS zzz";
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_ERROR = 5;
    public static final int LOG_LEVEL_FATAL = 6;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_OFF = 7;
    public static final int LOG_LEVEL_TRACE = 1;
    public static final int LOG_LEVEL_WARN = 4;
    static /* synthetic */ Class class$java$lang$Thread = null;
    static /* synthetic */ Class class$org$apache$commons$logging$impl$SimpleLog = null;
    protected static DateFormat dateFormatter = null;
    protected static volatile String dateTimeFormat = null;
    private static final long serialVersionUID = 136942970684951178L;
    protected static volatile boolean showDateTime = false;
    protected static volatile boolean showLogName = false;
    protected static volatile boolean showShortName = false;
    protected static final Properties simpleLogProps;
    protected static final String systemPrefix = "com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.simplelog.";
    protected volatile int currentLogLevel;
    protected volatile String logName;
    private volatile String shortLogName = null;

    static {
        Properties properties = new Properties();
        simpleLogProps = properties;
        showLogName = false;
        showShortName = true;
        showDateTime = false;
        dateTimeFormat = DEFAULT_DATE_TIME_FORMAT;
        dateFormatter = null;
        InputStream resourceAsStream = getResourceAsStream("simplelog.properties");
        if (resourceAsStream != null) {
            try {
                properties.load(resourceAsStream);
                resourceAsStream.close();
            } catch (IOException unused) {
            }
        }
        showLogName = getBooleanProperty("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.simplelog.showlogname", showLogName);
        showShortName = getBooleanProperty("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.simplelog.showShortLogname", showShortName);
        showDateTime = getBooleanProperty("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.simplelog.showdatetime", showDateTime);
        if (showDateTime) {
            dateTimeFormat = getStringProperty("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.simplelog.dateTimeFormat", dateTimeFormat);
            try {
                dateFormatter = new SimpleDateFormat(dateTimeFormat);
            } catch (IllegalArgumentException unused2) {
                dateTimeFormat = DEFAULT_DATE_TIME_FORMAT;
                dateFormatter = new SimpleDateFormat(dateTimeFormat);
            }
        }
    }

    public SimpleLog(String str) {
        this.logName = null;
        this.logName = str;
        setLevel(3);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.simplelog.log.");
        stringBuffer.append(this.logName);
        String stringProperty = getStringProperty(stringBuffer.toString());
        int iLastIndexOf = String.valueOf(str).lastIndexOf(InstructionFileId.DOT);
        while (stringProperty == null && iLastIndexOf > -1) {
            str = str.substring(0, iLastIndexOf);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.simplelog.log.");
            stringBuffer2.append(str);
            stringProperty = getStringProperty(stringBuffer2.toString());
            iLastIndexOf = String.valueOf(str).lastIndexOf(InstructionFileId.DOT);
        }
        stringProperty = stringProperty == null ? getStringProperty("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.simplelog.defaultlog") : stringProperty;
        if ("all".equalsIgnoreCase(stringProperty)) {
            setLevel(0);
            return;
        }
        if ("trace".equalsIgnoreCase(stringProperty)) {
            setLevel(1);
            return;
        }
        if ("debug".equalsIgnoreCase(stringProperty)) {
            setLevel(2);
            return;
        }
        if ("info".equalsIgnoreCase(stringProperty)) {
            setLevel(3);
            return;
        }
        if ("warn".equalsIgnoreCase(stringProperty)) {
            setLevel(4);
            return;
        }
        if ("error".equalsIgnoreCase(stringProperty)) {
            setLevel(5);
        } else if ("fatal".equalsIgnoreCase(stringProperty)) {
            setLevel(6);
        } else if ("off".equalsIgnoreCase(stringProperty)) {
            setLevel(7);
        }
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    private static boolean getBooleanProperty(String str, boolean z11) {
        String stringProperty = getStringProperty(str);
        return stringProperty == null ? z11 : "true".equalsIgnoreCase(stringProperty);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ClassLoader getContextClassLoader() {
        ClassLoader classLoader = null;
        try {
            Class clsClass$ = class$java$lang$Thread;
            if (clsClass$ == null) {
                clsClass$ = class$("java.lang.Thread");
                class$java$lang$Thread = clsClass$;
            }
            try {
                classLoader = (ClassLoader) clsClass$.getMethod("getContextClassLoader", null).invoke(Thread.currentThread(), null);
            } catch (InvocationTargetException e11) {
                if (!(e11.getTargetException() instanceof SecurityException)) {
                    throw new LogConfigurationException("Unexpected InvocationTargetException", e11.getTargetException());
                }
            }
        } catch (IllegalAccessException | NoSuchMethodException unused) {
        }
        if (classLoader != null) {
            return classLoader;
        }
        Class clsClass$2 = class$org$apache$commons$logging$impl$SimpleLog;
        if (clsClass$2 == null) {
            clsClass$2 = class$("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.SimpleLog");
            class$org$apache$commons$logging$impl$SimpleLog = clsClass$2;
        }
        return clsClass$2.getClassLoader();
    }

    private static InputStream getResourceAsStream(String str) {
        return (InputStream) AccessController.doPrivileged(new a(str));
    }

    private static String getStringProperty(String str) {
        String property;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        return property == null ? simpleLogProps.getProperty(str) : property;
    }

    private static String getStringProperty(String str, String str2) {
        String stringProperty = getStringProperty(str);
        return stringProperty == null ? str2 : stringProperty;
    }

    public final void debug(Object obj) {
        if (isLevelEnabled(2)) {
            log(2, obj, null);
        }
    }

    public final void debug(Object obj, Throwable th2) {
        if (isLevelEnabled(2)) {
            log(2, obj, th2);
        }
    }

    public final void error(Object obj) {
        if (isLevelEnabled(5)) {
            log(5, obj, null);
        }
    }

    public final void error(Object obj, Throwable th2) {
        if (isLevelEnabled(5)) {
            log(5, obj, th2);
        }
    }

    public final void fatal(Object obj) {
        if (isLevelEnabled(6)) {
            log(6, obj, null);
        }
    }

    public final void fatal(Object obj, Throwable th2) {
        if (isLevelEnabled(6)) {
            log(6, obj, th2);
        }
    }

    public int getLevel() {
        return this.currentLogLevel;
    }

    public final void info(Object obj) {
        if (isLevelEnabled(3)) {
            log(3, obj, null);
        }
    }

    public final void info(Object obj, Throwable th2) {
        if (isLevelEnabled(3)) {
            log(3, obj, th2);
        }
    }

    public final boolean isDebugEnabled() {
        return isLevelEnabled(2);
    }

    public final boolean isErrorEnabled() {
        return isLevelEnabled(5);
    }

    public final boolean isFatalEnabled() {
        return isLevelEnabled(6);
    }

    public final boolean isInfoEnabled() {
        return isLevelEnabled(3);
    }

    public boolean isLevelEnabled(int i11) {
        return i11 >= this.currentLogLevel;
    }

    public final boolean isTraceEnabled() {
        return isLevelEnabled(1);
    }

    public final boolean isWarnEnabled() {
        return isLevelEnabled(4);
    }

    public void log(int i11, Object obj, Throwable th2) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        if (showDateTime) {
            Date date = new Date();
            synchronized (dateFormatter) {
                str = dateFormatter.format(date);
            }
            stringBuffer.append(str);
            stringBuffer.append(" ");
        }
        switch (i11) {
            case 1:
                stringBuffer.append("[TRACE] ");
                break;
            case 2:
                stringBuffer.append("[DEBUG] ");
                break;
            case 3:
                stringBuffer.append("[INFO] ");
                break;
            case 4:
                stringBuffer.append("[WARN] ");
                break;
            case 5:
                stringBuffer.append("[ERROR] ");
                break;
            case 6:
                stringBuffer.append("[FATAL] ");
                break;
        }
        if (showShortName) {
            if (this.shortLogName == null) {
                String strSubstring = this.logName.substring(this.logName.lastIndexOf(InstructionFileId.DOT) + 1);
                this.shortLogName = strSubstring.substring(strSubstring.lastIndexOf("/") + 1);
            }
            stringBuffer.append(String.valueOf(this.shortLogName));
            stringBuffer.append(" - ");
        } else if (showLogName) {
            stringBuffer.append(String.valueOf(this.logName));
            stringBuffer.append(" - ");
        }
        stringBuffer.append(String.valueOf(obj));
        if (th2 != null) {
            stringBuffer.append(" <");
            stringBuffer.append(th2.toString());
            stringBuffer.append(">");
            StringWriter stringWriter = new StringWriter(1024);
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th2.printStackTrace(printWriter);
            printWriter.close();
            stringBuffer.append(stringWriter.toString());
        }
        write(stringBuffer);
    }

    public void setLevel(int i11) {
        this.currentLogLevel = i11;
    }

    public final void trace(Object obj) {
        if (isLevelEnabled(1)) {
            log(1, obj, null);
        }
    }

    public final void trace(Object obj, Throwable th2) {
        if (isLevelEnabled(1)) {
            log(1, obj, th2);
        }
    }

    public final void warn(Object obj) {
        if (isLevelEnabled(4)) {
            log(4, obj, null);
        }
    }

    public final void warn(Object obj, Throwable th2) {
        if (isLevelEnabled(4)) {
            log(4, obj, th2);
        }
    }

    public void write(StringBuffer stringBuffer) {
        System.err.println(stringBuffer.toString());
    }
}
