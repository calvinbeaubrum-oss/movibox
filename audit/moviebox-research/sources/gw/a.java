package gw;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.publish.api.AudioEntity;
import io.reactivex.rxjava3.core.k;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f65596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContentResolver f65597b;

    public a(Context context) {
        Intrinsics.g(context, "context");
        this.f65596a = context;
        this.f65597b = context.getContentResolver();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0101  */
    @SuppressLint({"Range"})
    public final void a(k<AudioEntity> emitter) throws Throwable {
        String str = "duration";
        String str2 = "artist";
        Intrinsics.g(emitter, "emitter");
        if (Environment.getExternalStorageState().equals("mounted")) {
            Cursor cursorQuery = null;
            try {
                boolean z11 = false;
                String[] strArr = {"_id", "_data", "_size", "mime_type", CampaignEx.JSON_KEY_TITLE, "artist", "duration"};
                try {
                    try {
                        ContentResolver contentResolver = this.f65597b;
                        cursorQuery = contentResolver != null ? contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, strArr, null, null, "date_added DESC") : null;
                        while (cursorQuery != null && cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex(CampaignEx.JSON_KEY_TITLE));
                            Intrinsics.f(string, "cursor.getString(cursor.…Store.Audio.Media.TITLE))");
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                            Intrinsics.f(string2, "cursor.getString(cursor.…aStore.Audio.Media.DATA))");
                            long j11 = cursorQuery.getLong(cursorQuery.getColumnIndex("_size"));
                            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(str2));
                            Intrinsics.f(string3, "cursor.getString(cursor.…tore.Audio.Media.ARTIST))");
                            String str3 = str;
                            String str4 = str2;
                            long j12 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(str));
                            AudioEntity audioEntity = new AudioEntity();
                            audioEntity.setImageTitle(string);
                            audioEntity.setLocalPath(string2);
                            audioEntity.setSize(j11);
                            audioEntity.setThumbPath("");
                            audioEntity.setArtist(string3);
                            audioEntity.setDuration(Long.valueOf(j12));
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("size:");
                            sb2.append(j11);
                            sb2.append(",path:");
                            sb2.append(string2);
                            sb2.append(",duration:");
                            sb2.append(j12);
                            if (emitter.isDisposed()) {
                                cursorQuery.close();
                                return;
                            }
                            emitter.onNext(audioEntity);
                            str = str3;
                            str2 = str4;
                            z11 = true;
                        }
                        if (!z11) {
                            emitter.onNext(new AudioEntity());
                        }
                        if (cursorQuery == null) {
                            return;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        e.printStackTrace();
                        if (cursorQuery == null) {
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
            } catch (Throwable th3) {
                th = th3;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
            cursorQuery.close();
        }
    }
}
