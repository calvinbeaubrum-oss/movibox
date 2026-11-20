package com.bytedance.sdk.openadsdk.pFF;

import com.bytedance.sdk.component.utils.TRI;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected boolean f28660sc = false;
    private final ExecutorService pFF = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.pFF.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class CallableC0313sc implements Callable<Void> {
        private final File pFF;

        private CallableC0313sc(File file) {
            this.pFF = file;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            sc.this.pFF(this.pFF);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(File file) throws IOException {
        if (!this.f28660sc) {
            try {
                TRI.pFF(file);
            } catch (Throwable unused) {
            }
            sc(TRI.sc(file.getParentFile()));
        } else {
            List<File> listSc = TRI.sc(file);
            listSc.toString();
            sc(listSc);
        }
    }

    public long pFF(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    public void sc(File file) throws IOException {
        this.pFF.submit(new CallableC0313sc(file));
    }

    public abstract void sc(List<File> list);

    public abstract boolean sc(long j11, int i11);

    public abstract boolean sc(File file, long j11, int i11);
}
