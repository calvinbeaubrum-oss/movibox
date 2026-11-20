package h6;

import android.annotation.SuppressLint;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0693a f66343e = new C0693a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Lock> f66344f = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f66345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f66346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SuppressLint({"SyntheticAccessor"})
    public final Lock f66347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FileChannel f66348d;

    /* JADX INFO: renamed from: h6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0693a {
        public C0693a() {
        }

        public /* synthetic */ C0693a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Lock b(String str) {
            Lock lock;
            synchronized (a.f66344f) {
                try {
                    Map map = a.f66344f;
                    Object reentrantLock = map.get(str);
                    if (reentrantLock == null) {
                        reentrantLock = new ReentrantLock();
                        map.put(str, reentrantLock);
                    }
                    lock = (Lock) reentrantLock;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return lock;
        }
    }

    public a(String name, File file, boolean z11) {
        File file2;
        Intrinsics.g(name, "name");
        this.f66345a = z11;
        if (file != null) {
            file2 = new File(file, name + ".lck");
        } else {
            file2 = null;
        }
        this.f66346b = file2;
        this.f66347c = f66343e.b(name);
    }

    public static /* synthetic */ void c(a aVar, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = aVar.f66345a;
        }
        aVar.b(z11);
    }

    public final void b(boolean z11) {
        this.f66347c.lock();
        if (z11) {
            try {
                File file = this.f66346b;
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(this.f66346b).getChannel();
                channel.lock();
                this.f66348d = channel;
            } catch (IOException e11) {
                this.f66348d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e11);
            }
        }
    }

    public final void d() {
        try {
            FileChannel fileChannel = this.f66348d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f66347c.unlock();
    }
}
