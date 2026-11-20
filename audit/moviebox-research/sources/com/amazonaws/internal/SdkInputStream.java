package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import com.amazonaws.logging.LogFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SdkInputStream extends InputStream implements MetricAware {
    @Override // com.amazonaws.internal.MetricAware
    @Deprecated
    public final boolean a() {
        Closeable closeableD = d();
        if (closeableD instanceof MetricAware) {
            return ((MetricAware) closeableD).a();
        }
        return false;
    }

    public void b() throws IOException {
    }

    public final void c() {
        if (Thread.interrupted()) {
            try {
                b();
            } catch (IOException e11) {
                LogFactory.b(getClass()).g("FYI", e11);
            }
            throw new AbortedException();
        }
    }

    public abstract InputStream d();
}
