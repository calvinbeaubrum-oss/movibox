package org.apache.tools.ant.taskdefs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.tools.ant.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Exec extends z {

    /* JADX INFO: compiled from: source.java */
    public class StreamPumper extends Thread {
        private static final int SLEEP_TIME = 5;
        private BufferedReader din;
        private boolean endOfStream = false;
        private int messageLevel;
        private final /* synthetic */ Exec this$0;

        public StreamPumper(Exec exec, InputStream inputStream, int i11) {
            this.din = new BufferedReader(new InputStreamReader(inputStream));
            this.messageLevel = i11;
        }

        public void pumpStream() throws IOException {
            if (this.endOfStream) {
                return;
            }
            if (this.din.readLine() != null) {
                throw null;
            }
            this.endOfStream = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.endOfStream) {
                try {
                    try {
                        pumpStream();
                        Thread.sleep(5L);
                    } catch (IOException unused) {
                        return;
                    }
                } catch (InterruptedException unused2) {
                }
            }
            this.din.close();
        }
    }
}
