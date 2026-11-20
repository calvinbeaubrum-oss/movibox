package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl;

import java.io.Serializable;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class Log4JLogger implements Serializable {
    private static final String FQCN = null;
    static /* synthetic */ Class class$org$apache$commons$logging$impl$Log4JLogger = null;
    static /* synthetic */ Class class$org$apache$log4j$Level = null;
    static /* synthetic */ Class class$org$apache$log4j$Priority = null;
    private static final long serialVersionUID = 5160705895411730424L;
    private static final Priority traceLevel = null;
    private volatile transient Logger logger;
    private final String name;

    static {
        throw null;
    }

    public Log4JLogger() {
        this.logger = null;
        this.name = null;
    }

    public Log4JLogger(String str) {
        this.logger = null;
        this.name = str;
        this.logger = getLogger();
    }

    public Log4JLogger(Logger logger) {
        this.logger = null;
        if (logger == null) {
            throw new IllegalArgumentException("Warning - null logger in constructor; possible log4j misconfiguration.");
        }
        this.name = logger.getName();
        this.logger = logger;
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public void debug(Object obj) {
        getLogger().log(FQCN, Level.DEBUG, obj, (Throwable) null);
    }

    public void debug(Object obj, Throwable th2) {
        getLogger().log(FQCN, Level.DEBUG, obj, th2);
    }

    public void error(Object obj) {
        getLogger().log(FQCN, Level.ERROR, obj, (Throwable) null);
    }

    public void error(Object obj, Throwable th2) {
        getLogger().log(FQCN, Level.ERROR, obj, th2);
    }

    public void fatal(Object obj) {
        getLogger().log(FQCN, Level.FATAL, obj, (Throwable) null);
    }

    public void fatal(Object obj, Throwable th2) {
        getLogger().log(FQCN, Level.FATAL, obj, th2);
    }

    public Logger getLogger() {
        Logger logger = this.logger;
        if (logger == null) {
            synchronized (this) {
                try {
                    logger = this.logger;
                    if (logger == null) {
                        logger = Logger.getLogger(this.name);
                        this.logger = logger;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return logger;
    }

    public void info(Object obj) {
        getLogger().log(FQCN, Level.INFO, obj, (Throwable) null);
    }

    public void info(Object obj, Throwable th2) {
        getLogger().log(FQCN, Level.INFO, obj, th2);
    }

    public boolean isDebugEnabled() {
        return getLogger().isDebugEnabled();
    }

    public boolean isErrorEnabled() {
        return getLogger().isEnabledFor(Level.ERROR);
    }

    public boolean isFatalEnabled() {
        return getLogger().isEnabledFor(Level.FATAL);
    }

    public boolean isInfoEnabled() {
        return getLogger().isInfoEnabled();
    }

    public boolean isTraceEnabled() {
        return getLogger().isEnabledFor(traceLevel);
    }

    public boolean isWarnEnabled() {
        return getLogger().isEnabledFor(Level.WARN);
    }

    public void trace(Object obj) {
        getLogger().log(FQCN, traceLevel, obj, (Throwable) null);
    }

    public void trace(Object obj, Throwable th2) {
        getLogger().log(FQCN, traceLevel, obj, th2);
    }

    public void warn(Object obj) {
        getLogger().log(FQCN, Level.WARN, obj, (Throwable) null);
    }

    public void warn(Object obj, Throwable th2) {
        getLogger().log(FQCN, Level.WARN, obj, th2);
    }
}
