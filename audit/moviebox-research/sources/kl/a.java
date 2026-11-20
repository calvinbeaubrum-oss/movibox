package kl;

import com.google.firebase.messaging.threads.ThreadPriority;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface a {
    ExecutorService a(ThreadFactory threadFactory, ThreadPriority threadPriority);
}
