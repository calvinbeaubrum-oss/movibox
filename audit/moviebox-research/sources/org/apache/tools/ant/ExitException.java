package org.apache.tools.ant;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ExitException extends SecurityException {
    private static final long serialVersionUID = 2772487854280543363L;
    private int status;

    public ExitException(int i11) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExitException: status ");
        stringBuffer.append(i11);
        super(stringBuffer.toString());
        this.status = i11;
    }

    public ExitException(String str, int i11) {
        super(str);
        this.status = i11;
    }

    public int getStatus() {
        return this.status;
    }
}
