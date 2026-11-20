package androidx.constraintlayout.core.parser;

import com.applovin.sdk.AppLovinMediationProvider;
import t2.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class CLParsingException extends Exception {
    private final String mElementClass = AppLovinMediationProvider.UNKNOWN;
    private final int mLineNumber = 0;
    private final String mReason;

    public CLParsingException(String str, a aVar) {
        this.mReason = str;
    }

    public String reason() {
        return this.mReason + " (" + this.mElementClass + " at line " + this.mLineNumber + ")";
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}
