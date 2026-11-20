package pl.droidsonroids.gif;

import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class GifIOException extends IOException {
    private static final long serialVersionUID = 13038402904505L;
    private final String mErrnoMessage;

    @NonNull
    public final GifError reason;

    public GifIOException(int i11, String str) {
        this.reason = GifError.fromCode(i11);
        this.mErrnoMessage = str;
    }

    public static GifIOException fromCode(int i11) {
        if (i11 == GifError.NO_ERROR.errorCode) {
            return null;
        }
        return new GifIOException(i11, null);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.mErrnoMessage == null) {
            return this.reason.getFormattedDescription();
        }
        return this.reason.getFormattedDescription() + ": " + this.mErrnoMessage;
    }
}
