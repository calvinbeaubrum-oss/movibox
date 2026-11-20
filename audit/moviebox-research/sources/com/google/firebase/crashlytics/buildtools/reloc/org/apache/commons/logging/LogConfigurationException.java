package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class LogConfigurationException extends RuntimeException {
    private static final long serialVersionUID = 8486587136871052495L;
    protected Throwable cause;

    public LogConfigurationException() {
        this.cause = null;
    }

    public LogConfigurationException(String str) {
        super(str);
        this.cause = null;
    }

    public LogConfigurationException(String str, Throwable th2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(" (Caused by ");
        stringBuffer.append(th2);
        stringBuffer.append(")");
        super(stringBuffer.toString());
        this.cause = th2;
    }

    public LogConfigurationException(Throwable th2) {
        this(th2 == null ? null : th2.toString(), th2);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
