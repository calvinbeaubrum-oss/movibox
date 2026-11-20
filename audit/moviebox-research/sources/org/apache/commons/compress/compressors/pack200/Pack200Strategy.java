package org.apache.commons.compress.compressors.pack200;

import java.io.IOException;
import n20.a;
import n20.b;
import n20.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public enum Pack200Strategy {
    IN_MEMORY { // from class: org.apache.commons.compress.compressors.pack200.Pack200Strategy.1
        @Override // org.apache.commons.compress.compressors.pack200.Pack200Strategy
        public b newStreamBridge() {
            return new a();
        }
    },
    TEMP_FILE { // from class: org.apache.commons.compress.compressors.pack200.Pack200Strategy.2
        @Override // org.apache.commons.compress.compressors.pack200.Pack200Strategy
        public b newStreamBridge() throws IOException {
            return new c();
        }
    };

    public abstract b newStreamBridge() throws IOException;
}
