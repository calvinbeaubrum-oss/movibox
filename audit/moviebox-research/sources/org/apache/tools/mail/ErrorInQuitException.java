package org.apache.tools.mail;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ErrorInQuitException extends IOException {
    public ErrorInQuitException(IOException iOException) {
        super(iOException.getMessage());
    }
}
