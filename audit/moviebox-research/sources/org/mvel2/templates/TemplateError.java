package org.mvel2.templates;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class TemplateError extends RuntimeException {
    public TemplateError() {
    }

    public TemplateError(String str) {
        super(str);
    }

    public TemplateError(String str, Throwable th2) {
        super(str, th2);
    }

    public TemplateError(Throwable th2) {
        super(th2);
    }
}
