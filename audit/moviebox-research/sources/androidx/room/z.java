package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class z implements g6.h, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f12918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callable<InputStream> f12919d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g6.h f12921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f12922h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f12923i;

    public z(Context context, String str, File file, Callable<InputStream> callable, int i11, g6.h delegate) {
        Intrinsics.g(context, "context");
        Intrinsics.g(delegate, "delegate");
        this.f12916a = context;
        this.f12917b = str;
        this.f12918c = file;
        this.f12919d = callable;
        this.f12920f = i11;
        this.f12921g = delegate;
    }

    public final void a(File file, boolean z11) throws IOException {
        ReadableByteChannel readableByteChannelNewChannel;
        if (this.f12917b != null) {
            readableByteChannelNewChannel = Channels.newChannel(this.f12916a.getAssets().open(this.f12917b));
            Intrinsics.f(readableByteChannelNewChannel, "newChannel(context.assets.open(copyFromAssetPath))");
        } else if (this.f12918c != null) {
            readableByteChannelNewChannel = new FileInputStream(this.f12918c).getChannel();
            Intrinsics.f(readableByteChannelNewChannel, "FileInputStream(copyFromFile).channel");
        } else {
            Callable<InputStream> callable = this.f12919d;
            if (callable == null) {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
            try {
                readableByteChannelNewChannel = Channels.newChannel(callable.call());
                Intrinsics.f(readableByteChannelNewChannel, "newChannel(inputStream)");
            } catch (Exception e11) {
                throw new IOException("inputStreamCallable exception on call", e11);
            }
        }
        File intermediateFile = File.createTempFile("room-copy-helper", ".tmp", this.f12916a.getCacheDir());
        intermediateFile.deleteOnExit();
        FileChannel output = new FileOutputStream(intermediateFile).getChannel();
        Intrinsics.f(output, "output");
        e6.c.a(readableByteChannelNewChannel, output);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        Intrinsics.f(intermediateFile, "intermediateFile");
        b(intermediateFile, z11);
        if (intermediateFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + intermediateFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    public final void b(File file, boolean z11) {
        f fVar = this.f12922h;
        if (fVar == null) {
            Intrinsics.y("databaseConfiguration");
            fVar = null;
        }
        fVar.getClass();
    }

    public final void c(f databaseConfiguration) {
        Intrinsics.g(databaseConfiguration, "databaseConfiguration");
        this.f12922h = databaseConfiguration;
    }

    @Override // g6.h, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        getDelegate().close();
        this.f12923i = false;
    }

    public final void d(boolean z11) {
        String databaseName = getDatabaseName();
        if (databaseName == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        File databaseFile = this.f12916a.getDatabasePath(databaseName);
        f fVar = this.f12922h;
        f fVar2 = null;
        if (fVar == null) {
            Intrinsics.y("databaseConfiguration");
            fVar = null;
        }
        h6.a aVar = new h6.a(databaseName, this.f12916a.getFilesDir(), fVar.f12858s);
        try {
            h6.a.c(aVar, false, 1, null);
            if (!databaseFile.exists()) {
                try {
                    Intrinsics.f(databaseFile, "databaseFile");
                    a(databaseFile, z11);
                    aVar.d();
                    return;
                } catch (IOException e11) {
                    throw new RuntimeException("Unable to copy database file.", e11);
                }
            }
            try {
                Intrinsics.f(databaseFile, "databaseFile");
                int iD = e6.b.d(databaseFile);
                if (iD == this.f12920f) {
                    aVar.d();
                    return;
                }
                f fVar3 = this.f12922h;
                if (fVar3 == null) {
                    Intrinsics.y("databaseConfiguration");
                } else {
                    fVar2 = fVar3;
                }
                if (fVar2.a(iD, this.f12920f)) {
                    aVar.d();
                    return;
                }
                if (this.f12916a.deleteDatabase(databaseName)) {
                    try {
                        a(databaseFile, z11);
                    } catch (IOException e12) {
                        Log.w("ROOM", "Unable to copy database file.", e12);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                aVar.d();
                return;
            } catch (IOException e13) {
                Log.w("ROOM", "Unable to read database version.", e13);
                aVar.d();
                return;
            }
        } catch (Throwable th2) {
            aVar.d();
            throw th2;
        }
        aVar.d();
        throw th2;
    }

    @Override // g6.h
    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    @Override // androidx.room.g
    public g6.h getDelegate() {
        return this.f12921g;
    }

    @Override // g6.h
    public g6.g getWritableDatabase() {
        if (!this.f12923i) {
            d(true);
            this.f12923i = true;
        }
        return getDelegate().getWritableDatabase();
    }

    @Override // g6.h
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z11) {
        getDelegate().setWriteAheadLoggingEnabled(z11);
    }
}
