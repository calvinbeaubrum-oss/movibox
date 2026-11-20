package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io;

import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class TaggedIOException extends IOExceptionWithCause {
    private static final long serialVersionUID = -6994123481142850163L;
    private final Serializable tag;

    public TaggedIOException(IOException iOException, Serializable serializable) {
        super(iOException.getMessage(), iOException);
        this.tag = serializable;
    }

    public static boolean isTaggedWith(Throwable th2, Object obj) {
        return obj != null && (th2 instanceof TaggedIOException) && obj.equals(((TaggedIOException) th2).tag);
    }

    public static void throwCauseIfTaggedWith(Throwable th2, Object obj) throws IOException {
        if (isTaggedWith(th2, obj)) {
            throw ((TaggedIOException) th2).getCause();
        }
    }

    @Override // java.lang.Throwable
    public IOException getCause() {
        return (IOException) super.getCause();
    }

    public Serializable getTag() {
        return this.tag;
    }
}
