package gw;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore;
import com.transsion.publish.api.PhotoEntity;
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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f65598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContentResolver f65599b;

    public b(Context context) {
        Intrinsics.g(context, "context");
        this.f65598a = context;
        this.f65599b = context.getContentResolver();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0112 A[Catch: all -> 0x0116, Exception -> 0x011a, PHI: r3 r9 r18 r19
  0x0112: PHI (r3v8 android.database.Cursor) = (r3v3 android.database.Cursor), (r3v13 android.database.Cursor) binds: [B:57:0x0129, B:46:0x0110] A[DONT_GENERATE, DONT_INLINE]
  0x0112: PHI (r9v15 boolean) = (r9v13 boolean), (r9v20 boolean) binds: [B:57:0x0129, B:46:0x0110] A[DONT_GENERATE, DONT_INLINE]
  0x0112: PHI (r18v2 java.lang.String) = (r18v0 java.lang.String), (r18v4 java.lang.String) binds: [B:57:0x0129, B:46:0x0110] A[DONT_GENERATE, DONT_INLINE]
  0x0112: PHI (r19v3 java.lang.String) = (r19v1 java.lang.String), (r19v8 java.lang.String) binds: [B:57:0x0129, B:46:0x0110] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #11 {Exception -> 0x011a, all -> 0x0116, blocks: (B:16:0x0074, B:18:0x007a, B:47:0x0112, B:59:0x012c, B:61:0x0178, B:66:0x0188, B:67:0x018b, B:69:0x018e), top: B:94:0x0074 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0178 A[Catch: all -> 0x0116, Exception -> 0x011a, TRY_LEAVE, TryCatch #11 {Exception -> 0x011a, all -> 0x0116, blocks: (B:16:0x0074, B:18:0x007a, B:47:0x0112, B:59:0x012c, B:61:0x0178, B:66:0x0188, B:67:0x018b, B:69:0x018e), top: B:94:0x0074 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:97:0x0182 A[SYNTHETIC] */
    @SuppressLint({"Range"})
    public final void a(k<PhotoEntity> emitter) throws Throwable {
        Cursor cursor;
        boolean z11;
        Cursor cursorQuery;
        String str;
        Cursor cursorQuery2;
        Cursor cursor2;
        PhotoEntity photoEntity;
        b bVar = this;
        String str2 = "_display_name";
        Intrinsics.g(emitter, "emitter");
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return;
        }
        try {
            String[] strArr = {"_id", "_data", "_size", "mime_type", "height", "width", "_display_name"};
            ContentResolver contentResolver = bVar.f65599b;
            if (contentResolver != null) {
                z11 = true;
                cursorQuery = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "mime_type=? or mime_type=? or mime_type=? or mime_type =?", new String[]{"image/jpeg", "image/png", "image/gif", "image/webp"}, "date_added DESC");
            } else {
                z11 = true;
                cursorQuery = null;
            }
            boolean z12 = false;
            while (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext() != z11) {
                        break;
                    }
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex(str2));
                    Intrinsics.f(string, "photoCursor.getString(ph…ages.Media.DISPLAY_NAME))");
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                    Intrinsics.f(string2, "photoCursor.getString(ph…Store.Images.Media.DATA))");
                    int i11 = cursorQuery.getInt(cursorQuery.getColumnIndex("_size")) / 1024;
                    int i12 = cursorQuery.getInt(cursorQuery.getColumnIndex("width"));
                    int i13 = cursorQuery.getInt(cursorQuery.getColumnIndex("height"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("_id"));
                    String str3 = "";
                    try {
                        try {
                            ContentResolver contentResolver2 = bVar.f65599b;
                            if (contentResolver2 != null) {
                                try {
                                    str = str2;
                                    try {
                                        cursorQuery2 = contentResolver2.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_data", "image_id"}, "image_id=?", new String[]{string3}, null);
                                    } catch (Exception e11) {
                                        e = e11;
                                        cursorQuery2 = null;
                                        z11 = true;
                                        e.printStackTrace();
                                        if (cursorQuery2 != null) {
                                            cursorQuery2.close();
                                        }
                                        String str4 = str3;
                                        uo.b.a.f(uo.b.f78622a, "SelectVideoManager", "size:" + i11 + ",path:" + string2 + ",thumbPath:" + str4, false, 4, null);
                                        photoEntity = new PhotoEntity();
                                        photoEntity.setImageTitle(string);
                                        photoEntity.setLocalPath(string2);
                                        photoEntity.setImageSize((long) i11);
                                        photoEntity.setThumbPath(str4);
                                        photoEntity.setHeight(i13);
                                        photoEntity.setWidth(i12);
                                        if (!emitter.isDisposed()) {
                                            cursorQuery.close();
                                            return;
                                        }
                                        emitter.onNext(photoEntity);
                                        z12 = true;
                                        bVar = this;
                                        str2 = str;
                                    }
                                } catch (Exception e12) {
                                    e = e12;
                                    str = str2;
                                }
                            } else {
                                str = str2;
                                cursorQuery2 = null;
                            }
                            if (cursorQuery2 != null) {
                                try {
                                    try {
                                        z11 = true;
                                        if (cursorQuery2.moveToFirst()) {
                                            try {
                                                String string4 = cursorQuery2.getString(cursorQuery2.getColumnIndexOrThrow("_data"));
                                                Intrinsics.f(string4, "thumbCursor.getString(\n …                        )");
                                                str3 = string4;
                                            } catch (Exception e13) {
                                                e = e13;
                                                e.printStackTrace();
                                                if (cursorQuery2 != null) {
                                                }
                                                String str5 = str3;
                                                uo.b.a.f(uo.b.f78622a, "SelectVideoManager", "size:" + i11 + ",path:" + string2 + ",thumbPath:" + str5, false, 4, null);
                                                photoEntity = new PhotoEntity();
                                                photoEntity.setImageTitle(string);
                                                photoEntity.setLocalPath(string2);
                                                photoEntity.setImageSize((long) i11);
                                                photoEntity.setThumbPath(str5);
                                                photoEntity.setHeight(i13);
                                                photoEntity.setWidth(i12);
                                                if (!emitter.isDisposed()) {
                                                    cursorQuery.close();
                                                    return;
                                                }
                                                emitter.onNext(photoEntity);
                                                z12 = true;
                                                bVar = this;
                                                str2 = str;
                                            }
                                        }
                                    } catch (Exception e14) {
                                        e = e14;
                                        z11 = true;
                                        e.printStackTrace();
                                        if (cursorQuery2 != null) {
                                            cursorQuery2.close();
                                        }
                                        String str6 = str3;
                                        uo.b.a.f(uo.b.f78622a, "SelectVideoManager", "size:" + i11 + ",path:" + string2 + ",thumbPath:" + str6, false, 4, null);
                                        photoEntity = new PhotoEntity();
                                        photoEntity.setImageTitle(string);
                                        photoEntity.setLocalPath(string2);
                                        photoEntity.setImageSize((long) i11);
                                        photoEntity.setThumbPath(str6);
                                        photoEntity.setHeight(i13);
                                        photoEntity.setWidth(i12);
                                        if (!emitter.isDisposed()) {
                                            cursorQuery.close();
                                            return;
                                        }
                                        emitter.onNext(photoEntity);
                                        z12 = true;
                                        bVar = this;
                                        str2 = str;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor2 = cursorQuery2;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            } else {
                                z11 = true;
                            }
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor2 = null;
                        }
                    } catch (Exception e15) {
                        e = e15;
                        str = str2;
                        z11 = true;
                        cursorQuery2 = null;
                    }
                    String str7 = str3;
                    uo.b.a.f(uo.b.f78622a, "SelectVideoManager", "size:" + i11 + ",path:" + string2 + ",thumbPath:" + str7, false, 4, null);
                    photoEntity = new PhotoEntity();
                    photoEntity.setImageTitle(string);
                    photoEntity.setLocalPath(string2);
                    photoEntity.setImageSize((long) i11);
                    photoEntity.setThumbPath(str7);
                    photoEntity.setHeight(i13);
                    photoEntity.setWidth(i12);
                    if (!emitter.isDisposed()) {
                        cursorQuery.close();
                        return;
                    }
                    emitter.onNext(photoEntity);
                    z12 = true;
                    bVar = this;
                    str2 = str;
                } catch (Exception e16) {
                    e = e16;
                    cursor = cursorQuery;
                    try {
                        e.printStackTrace();
                        emitter.onNext(new PhotoEntity());
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (!z12) {
                emitter.onNext(new PhotoEntity());
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e17) {
            e = e17;
            cursor = null;
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }
}
