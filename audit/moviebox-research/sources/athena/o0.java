package athena;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class o0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ByteBuffer f13732b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f13733a;

    /* JADX WARN: Code duplicated, block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b0 A[Catch: IOException -> 0x00ac, TRY_LEAVE, TryCatch #3 {IOException -> 0x00ac, blocks: (B:39:0x00a8, B:43:0x00b0), top: B:87:0x00a8 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00da A[Catch: IOException -> 0x00d6, TRY_LEAVE, TryCatch #0 {IOException -> 0x00d6, blocks: (B:55:0x00d2, B:59:0x00da), top: B:83:0x00d2 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00e7 A[Catch: IOException -> 0x00c1, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IOException -> 0x00c1, blocks: (B:47:0x00bd, B:63:0x00e7), top: B:94:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x00ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x0101 A[Catch: IOException -> 0x00fd, TRY_LEAVE, TryCatch #9 {IOException -> 0x00fd, blocks: (B:70:0x00f9, B:74:0x0101), top: B:96:0x00f9 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public o0(String str) throws Throwable {
        FileChannel channel;
        Throwable th2;
        RandomAccessFile randomAccessFile;
        Exception e11;
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile2;
        FileLock fileLock;
        File file = new File(str);
        this.f13733a = file;
        if (!file.exists()) {
            try {
                if (this.f13733a.createNewFile()) {
                    a0.e("EncryptFile created");
                }
            } catch (Exception e12) {
                a0.c(Log.getStackTraceString(e12));
            }
        }
        if (f13732b == null) {
            f13732b = ByteBuffer.allocate(32808);
        }
        FileLock fileLockLock = null;
        fileLockLock = null;
        fileLockLock = null;
        FileChannel fileChannel2 = null;
        fileLockLock = null;
        fileLockLock = null;
        fileLockLock = null;
        try {
            try {
                if (this.f13733a.length() < PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                    randomAccessFile = new RandomAccessFile(this.f13733a, "rw");
                    try {
                        channel = randomAccessFile.getChannel();
                        try {
                            fileLockLock = channel.lock();
                            f13732b.putInt(0, 0);
                            f13732b.putInt(4, ((Integer) ar.b.a().t().first).intValue());
                            for (int i11 = 0; i11 < 8192; i11 += 4) {
                                f13732b.putInt((i11 + 10) * 4, i11);
                            }
                            randomAccessFile.seek(0L);
                            randomAccessFile.write(f13732b.array());
                        } catch (Exception e13) {
                            e11 = e13;
                            fileLock = fileLockLock;
                            fileChannel2 = channel;
                            fileChannel = fileChannel2;
                            fileLockLock = fileLock;
                            randomAccessFile2 = randomAccessFile;
                            try {
                                a0.c(Log.getStackTraceString(e11));
                                if (fileLockLock != null) {
                                    try {
                                        fileLockLock.release();
                                        if (fileChannel != null) {
                                            fileChannel.close();
                                        }
                                    } catch (IOException e14) {
                                        a0.c(Log.getStackTraceString(e14));
                                        if (randomAccessFile2 == null) {
                                            randomAccessFile2.close();
                                        }
                                        return;
                                    }
                                } else if (fileChannel != null) {
                                    fileChannel.close();
                                }
                                if (randomAccessFile2 == null) {
                                    return;
                                } else {
                                    randomAccessFile2.close();
                                }
                            } catch (Throwable th3) {
                                th2 = th3;
                                RandomAccessFile randomAccessFile3 = randomAccessFile2;
                                channel = fileChannel;
                                randomAccessFile = randomAccessFile3;
                                if (fileLockLock != null) {
                                    try {
                                        fileLockLock.release();
                                        if (channel != null) {
                                            channel.close();
                                        }
                                    } catch (IOException e15) {
                                        a0.c(Log.getStackTraceString(e15));
                                        if (randomAccessFile == null) {
                                            throw th2;
                                        }
                                        try {
                                            randomAccessFile.close();
                                            throw th2;
                                        } catch (IOException e16) {
                                            a0.c(Log.getStackTraceString(e16));
                                            throw th2;
                                        }
                                    }
                                } else if (channel != null) {
                                    channel.close();
                                }
                                if (randomAccessFile == null) {
                                    throw th2;
                                }
                                randomAccessFile.close();
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            if (fileLockLock != null) {
                                fileLockLock.release();
                                if (channel != null) {
                                    channel.close();
                                }
                            } else if (channel != null) {
                                channel.close();
                            }
                            if (randomAccessFile == null) {
                                throw th2;
                            }
                            randomAccessFile.close();
                            throw th2;
                        }
                    } catch (Exception e17) {
                        e11 = e17;
                        fileLock = null;
                    } catch (Throwable th5) {
                        th2 = th5;
                        channel = null;
                    }
                } else {
                    randomAccessFile = null;
                    channel = null;
                }
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                        if (channel != null) {
                            channel.close();
                        }
                    } catch (IOException e18) {
                        a0.c(Log.getStackTraceString(e18));
                    }
                } else if (channel != null) {
                    channel.close();
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e19) {
                a0.c(Log.getStackTraceString(e19));
            }
        } catch (Exception e21) {
            e11 = e21;
            fileChannel = null;
            randomAccessFile2 = null;
        } catch (Throwable th6) {
            channel = null;
            th2 = th6;
            randomAccessFile = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0118 A[Catch: IOException -> 0x0114, TRY_LEAVE, TryCatch #4 {IOException -> 0x0114, blocks: (B:64:0x0110, B:68:0x0118), top: B:96:0x0110 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0125 A[Catch: IOException -> 0x00e4, TRY_ENTER, TRY_LEAVE, TryCatch #11 {IOException -> 0x00e4, blocks: (B:44:0x00e0, B:72:0x0125), top: B:105:0x001c }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0140 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x0142 A[Catch: IOException -> 0x013e, TRY_LEAVE, TryCatch #13 {IOException -> 0x013e, blocks: (B:79:0x013a, B:83:0x0142), top: B:108:0x013a }] */
    /* JADX WARN: Code duplicated, block: B:94:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public String a() throws Throwable {
        FileChannel fileChannel;
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileLock fileLock2;
        byte[] bArr;
        StringBuilder sb2 = new StringBuilder();
        List<byte[]> listO = ar.b.a().o();
        if (br.d.m(listO)) {
            a0.a("readBuffer passwords is empty");
            return "";
        }
        RandomAccessFile randomAccessFile2 = null;
        fileLockLock = null;
        FileLock fileLockLock = null;
        fileChannel = null;
        FileChannel fileChannel2 = null;
        FileChannel fileChannel3 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(this.f13733a, "rw");
                try {
                    channel = randomAccessFile.getChannel();
                    try {
                        try {
                            fileLockLock = channel.lock();
                            randomAccessFile.seek(0L);
                            randomAccessFile.read(f13732b.array(), 0, 32808);
                            byte[] bArr2 = listO.get(f13732b.getInt(4));
                            if (bArr2 != null) {
                                n0 n0Var = new n0(bArr2);
                                boolean z11 = true;
                                for (int i11 = 0; i11 < f13732b.getInt(0); i11++) {
                                    if (i11 == 0) {
                                        int i12 = f13732b.getInt((i11 + 10) * 4);
                                        bArr = new byte[i12];
                                        randomAccessFile.read(bArr, 0, i12);
                                    } else {
                                        int i13 = f13732b.getInt((i11 + 10) * 4) - f13732b.getInt((i11 + 9) * 4);
                                        bArr = new byte[i13];
                                        randomAccessFile.read(bArr, 0, i13);
                                    }
                                    String str = new String(n0Var.b(bArr));
                                    try {
                                        try {
                                            JSONObject jSONObject = new JSONObject(str);
                                            if (jSONObject.has("tid") && jSONObject.has(NotificationCompat.CATEGORY_EVENT)) {
                                                if (!z11) {
                                                    sb2.append("\n");
                                                }
                                                sb2.append(str);
                                                z11 = false;
                                            }
                                        } catch (Exception e11) {
                                            a0.c(Log.getStackTraceString(e11));
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (fileLockLock != null) {
                                            try {
                                                fileLockLock.release();
                                                if (channel != null) {
                                                    channel.close();
                                                }
                                            } catch (IOException e12) {
                                                a0.c(Log.getStackTraceString(e12));
                                                if (randomAccessFile == null) {
                                                    throw th;
                                                }
                                                try {
                                                    randomAccessFile.close();
                                                    throw th;
                                                } catch (IOException e13) {
                                                    a0.c(Log.getStackTraceString(e13));
                                                    throw th;
                                                }
                                            }
                                        } else if (channel != null) {
                                            channel.close();
                                        }
                                        if (randomAccessFile == null) {
                                            throw th;
                                        }
                                        randomAccessFile.close();
                                        throw th;
                                    }
                                }
                            }
                            if (fileLockLock != null) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e14) {
                                    a0.c(Log.getStackTraceString(e14));
                                }
                            }
                            channel.close();
                            randomAccessFile.close();
                        } catch (Exception e15) {
                            e = e15;
                            fileLock = fileLockLock;
                            fileChannel3 = channel;
                            try {
                                a0.c(Log.getStackTraceString(e));
                                if (this.f13733a.delete()) {
                                    a0.e("file deleted");
                                }
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                        if (fileChannel3 != null) {
                                            fileChannel3.close();
                                        }
                                    } catch (IOException e16) {
                                        a0.c(Log.getStackTraceString(e16));
                                        if (randomAccessFile != null) {
                                            randomAccessFile.close();
                                        }
                                        return sb2.toString();
                                    }
                                } else if (fileChannel3 != null) {
                                    fileChannel3.close();
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                return sb2.toString();
                            } catch (Throwable th3) {
                                th = th3;
                                fileChannel = fileChannel3;
                                randomAccessFile2 = randomAccessFile;
                                randomAccessFile = randomAccessFile2;
                                fileLockLock = fileLock;
                                channel = fileChannel;
                                if (fileLockLock != null) {
                                    fileLockLock.release();
                                    if (channel != null) {
                                        channel.close();
                                    }
                                } else if (channel != null) {
                                    channel.close();
                                }
                                if (randomAccessFile == null) {
                                    throw th;
                                }
                                randomAccessFile.close();
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileLock2 = fileLockLock;
                        fileChannel2 = channel;
                        channel = fileChannel2;
                        fileLockLock = fileLock2;
                        if (fileLockLock != null) {
                            fileLockLock.release();
                            if (channel != null) {
                                channel.close();
                            }
                        } else if (channel != null) {
                            channel.close();
                        }
                        if (randomAccessFile == null) {
                            throw th;
                        }
                        randomAccessFile.close();
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                    fileLock = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileLock2 = null;
                }
            } catch (IOException e18) {
                a0.c(Log.getStackTraceString(e18));
            }
        } catch (Exception e19) {
            e = e19;
            randomAccessFile = null;
            fileLock = null;
        } catch (Throwable th6) {
            th = th6;
            fileChannel = null;
            fileLock = null;
            randomAccessFile = randomAccessFile2;
            fileLockLock = fileLock;
            channel = fileChannel;
            if (fileLockLock != null) {
                fileLockLock.release();
                if (channel != null) {
                    channel.close();
                }
            } else if (channel != null) {
                channel.close();
            }
            if (randomAccessFile == null) {
                throw th;
            }
            randomAccessFile.close();
            throw th;
        }
        return sb2.toString();
    }
}
