package org.mvel2.templates;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class TemplateRuntimeError extends RuntimeException {
    public TemplateRuntimeError() {
    }

    public TemplateRuntimeError(String str) {
        super(str);
    }

    public TemplateRuntimeError(String str, Throwable th2) {
        super(str, th2);
    }

    public TemplateRuntimeError(Throwable th2) {
        super(th2);
    }
}
