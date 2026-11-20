package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.util.RunnableFutureTask;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class ProgressiveDownloader$1 extends RunnableFutureTask<Void, IOException> {
    final /* synthetic */ e this$0;

    public ProgressiveDownloader$1(e eVar) {
    }

    @Override // com.google.android.exoplayer2.util.RunnableFutureTask
    public void cancelWork() {
        e.b(null).b();
    }

    @Override // com.google.android.exoplayer2.util.RunnableFutureTask
    public Void doWork() throws IOException {
        e.b(null).a();
        return null;
    }
}
