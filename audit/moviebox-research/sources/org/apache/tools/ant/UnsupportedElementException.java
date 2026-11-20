package org.apache.tools.ant;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class UnsupportedElementException extends BuildException {
    private String element;

    public UnsupportedElementException(String str, String str2) {
        super(str);
        this.element = str2;
    }

    public String getElement() {
        return this.element;
    }
}
