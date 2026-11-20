package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okio.BufferedSource;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver.1
        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver
        public boolean onData(int i11, BufferedSource bufferedSource, int i12, boolean z11) throws IOException {
            bufferedSource.skip(i12);
            return true;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver
        public boolean onHeaders(int i11, List<Header> list, boolean z11) {
            return true;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver
        public boolean onRequest(int i11, List<Header> list) {
            return true;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver
        public void onReset(int i11, ErrorCode errorCode) {
        }
    };

    boolean onData(int i11, BufferedSource bufferedSource, int i12, boolean z11) throws IOException;

    boolean onHeaders(int i11, List<Header> list, boolean z11);

    boolean onRequest(int i11, List<Header> list);

    void onReset(int i11, ErrorCode errorCode);
}
