package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class FileCleaningTracker {

    /* JADX INFO: compiled from: source.java */
    public final class Reaper extends Thread {
        final /* synthetic */ FileCleaningTracker this$0;

        public Reaper(FileCleaningTracker fileCleaningTracker) {
            super("File Reaper");
            setPriority(10);
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            throw null;
        }
    }
}
