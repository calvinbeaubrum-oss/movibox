package cl;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileChannel f14957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileLock f14958b;

    public b(FileChannel fileChannel, FileLock fileLock) {
        this.f14957a = fileChannel;
        this.f14958b = fileLock;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static b a(Context context, String str) {
        FileChannel channel;
        FileLock fileLockLock;
        try {
            channel = new RandomAccessFile(new File(context.getFilesDir(), str), "rw").getChannel();
            try {
                fileLockLock = channel.lock();
                try {
                    return new b(channel, fileLockLock);
                } catch (IOException e11) {
                    e = e11;
                    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (Error e12) {
                    e = e12;
                    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                    if (fileLockLock != null) {
                        fileLockLock.release();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    return null;
                } catch (OverlappingFileLockException e13) {
                    e = e13;
                    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                    if (fileLockLock != null) {
                        fileLockLock.release();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    return null;
                }
            } catch (IOException | Error | OverlappingFileLockException e14) {
                e = e14;
                fileLockLock = null;
            }
        } catch (IOException | Error | OverlappingFileLockException e15) {
            e = e15;
            channel = null;
            fileLockLock = null;
        }
    }

    public void b() {
        try {
            this.f14958b.release();
            this.f14957a.close();
        } catch (IOException e11) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e11);
        }
    }
}
