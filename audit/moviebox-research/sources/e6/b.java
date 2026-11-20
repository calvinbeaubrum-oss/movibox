package e6;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import g6.g;
import g6.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

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
@JvmName
public final class b {
    public static final CancellationSignal a() {
        return g6.b.b();
    }

    public static final void b(g db2) {
        Intrinsics.g(db2, "db");
        List listC = kotlin.collections.f.c();
        Cursor cursorF0 = db2.f0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorF0.moveToNext()) {
            try {
                listC.add(cursorF0.getString(0));
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(cursorF0, th2);
                    throw th3;
                }
            }
        }
        Unit unit = Unit.f68710a;
        CloseableKt.a(cursorF0, null);
        for (String triggerName : kotlin.collections.f.a(listC)) {
            Intrinsics.f(triggerName, "triggerName");
            if (l.L(triggerName, "room_fts_content_sync_", false, 2, null)) {
                db2.E("DROP TRIGGER IF EXISTS " + triggerName);
            }
        }
    }

    public static final Cursor c(RoomDatabase db2, j sqLiteQuery, boolean z11, CancellationSignal cancellationSignal) {
        Intrinsics.g(db2, "db");
        Intrinsics.g(sqLiteQuery, "sqLiteQuery");
        Cursor cursorA = db2.A(sqLiteQuery, cancellationSignal);
        if (!z11 || !(cursorA instanceof AbstractWindowedCursor)) {
            return cursorA;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorA;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? a.a(cursorA) : cursorA;
    }

    public static final int d(File databaseFile) throws IOException {
        Intrinsics.g(databaseFile, "databaseFile");
        FileChannel channel = new FileInputStream(databaseFile).getChannel();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i11 = byteBufferAllocate.getInt();
            CloseableKt.a(channel, null);
            return i11;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(channel, th2);
                throw th3;
            }
        }
    }
}
