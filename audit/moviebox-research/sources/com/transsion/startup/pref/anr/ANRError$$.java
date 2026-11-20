package com.transsion.startup.pref.anr;

import androidx.annotation.NonNull;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ANRError$$ implements Serializable {
    private final String _name;
    private final StackTraceElement[] _stackTrace;

    /* JADX INFO: compiled from: source.java */
    public class _Thread extends Throwable {
        public _Thread(_Thread _thread) {
            super(ANRError$$.this._name, _thread);
        }

        @Override // java.lang.Throwable
        @NonNull
        public Throwable fillInStackTrace() {
            setStackTrace(ANRError$$.this._stackTrace);
            return this;
        }
    }

    public ANRError$$(String str, StackTraceElement[] stackTraceElementArr) {
        this._name = str;
        this._stackTrace = stackTraceElementArr;
    }
}
