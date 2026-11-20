package gw;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import com.google.android.gms.common.util.GmsVersion;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.publish.api.VsMediaInfo;
import io.reactivex.rxjava3.core.k;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f65600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContentResolver f65601b;

    public c(Context context) {
        Intrinsics.g(context, "context");
        this.f65600a = context;
        this.f65601b = context.getContentResolver();
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0101 A[Catch: all -> 0x0105, Exception -> 0x0109, PHI: r3 r4 r8
  0x0101: PHI (r3v16 java.lang.String) = (r3v9 java.lang.String), (r3v19 java.lang.String) binds: [B:52:0x0112, B:42:0x00ff] A[DONT_GENERATE, DONT_INLINE]
  0x0101: PHI (r4v11 android.database.Cursor) = (r4v4 android.database.Cursor), (r4v16 android.database.Cursor) binds: [B:52:0x0112, B:42:0x00ff] A[DONT_GENERATE, DONT_INLINE]
  0x0101: PHI (r8v5 int) = (r8v3 int), (r8v9 int) binds: [B:52:0x0112, B:42:0x00ff] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #10 {Exception -> 0x0109, all -> 0x0105, blocks: (B:15:0x0086, B:17:0x008c, B:43:0x0101, B:54:0x0115, B:56:0x0167, B:61:0x0177, B:62:0x017a, B:64:0x017d), top: B:87:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0167 A[Catch: all -> 0x0105, Exception -> 0x0109, TRY_LEAVE, TryCatch #10 {Exception -> 0x0109, all -> 0x0105, blocks: (B:15:0x0086, B:17:0x008c, B:43:0x0101, B:54:0x0115, B:56:0x0167, B:61:0x0177, B:62:0x017a, B:64:0x017d), top: B:87:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0197  */
    /* JADX WARN: Code duplicated, block: B:90:0x0171 A[SYNTHETIC] */
    public final void a(k<VsMediaInfo> emitter) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        Cursor cursor2;
        Cursor cursorQuery2;
        VsMediaInfo vsMediaInfo;
        Intrinsics.g(emitter, "emitter");
        String[] strArr = {CampaignEx.JSON_KEY_TITLE, "_size", "duration", "_data", "_id", "date_added", "mime_type", "height", "width"};
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return;
        }
        try {
            ContentResolver contentResolver = this.f65601b;
            int i11 = 4;
            int i12 = 3;
            int i13 = 2;
            int i14 = 0;
            int i15 = 1;
            if (contentResolver != null) {
                Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                String str = String.format("%1$s IN (?, ?, ?) AND %2$s > %3$s AND %2$s < %4$s", Arrays.copyOf(new Object[]{"mime_type", "duration", 500, Integer.valueOf(GmsVersion.VERSION_MANCHEGO)}, 4));
                Intrinsics.f(str, "format(...)");
                cursorQuery = contentResolver.query(uri, strArr, str, new String[]{MimeTypes.VIDEO_MP4, "video/ext-mp4", MimeTypes.VIDEO_H263}, "date_added DESC");
            } else {
                cursorQuery = null;
            }
            boolean z11 = false;
            while (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext() != i15) {
                        break;
                    }
                    String string = cursorQuery.getString(i14);
                    Intrinsics.f(string, "videoCursor.getString(0)");
                    long j11 = cursorQuery.getLong(i15);
                    long j12 = cursorQuery.getLong(i13);
                    String string2 = cursorQuery.getString(i12);
                    Intrinsics.f(string2, "videoCursor.getString(3)");
                    String string3 = cursorQuery.getString(i11);
                    Intrinsics.f(string3, "videoCursor.getString(4)");
                    String str2 = "";
                    try {
                        try {
                            ContentResolver contentResolver2 = this.f65601b;
                            if (contentResolver2 != null) {
                                try {
                                    Uri uri2 = MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI;
                                    String[] strArr2 = new String[i13];
                                    strArr2[i14] = "_data";
                                    strArr2[1] = "video_id";
                                    cursorQuery2 = contentResolver2.query(uri2, strArr2, "video_id=?", new String[]{string3}, null);
                                } catch (Exception e11) {
                                    e = e11;
                                    cursorQuery2 = null;
                                    i15 = 1;
                                    e.printStackTrace();
                                    if (cursorQuery2 != null) {
                                        cursorQuery2.close();
                                    }
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("size:");
                                    sb2.append(j11);
                                    sb2.append(",duration:");
                                    sb2.append(j12);
                                    sb2.append(",path:");
                                    sb2.append(string2);
                                    sb2.append(",thumbPath:");
                                    sb2.append(str2);
                                    long j13 = cursorQuery.getLong(7);
                                    long j14 = cursorQuery.getLong(8);
                                    vsMediaInfo = new VsMediaInfo();
                                    vsMediaInfo.setVideoDuration(j12);
                                    vsMediaInfo.setVideoTitle(string);
                                    vsMediaInfo.setVideoPath(string2);
                                    vsMediaInfo.setVideoSize(j11);
                                    vsMediaInfo.setImagePath(str2);
                                    vsMediaInfo.setHeight((int) j13);
                                    vsMediaInfo.setWidth((int) j14);
                                    if (!emitter.isDisposed()) {
                                        cursorQuery.close();
                                        return;
                                    }
                                    emitter.onNext(vsMediaInfo);
                                    z11 = true;
                                    i11 = 4;
                                    i12 = 3;
                                    i13 = 2;
                                    i14 = 0;
                                }
                            } else {
                                cursorQuery2 = null;
                            }
                            if (cursorQuery2 != null) {
                                try {
                                    try {
                                        i15 = 1;
                                        if (cursorQuery2.moveToFirst()) {
                                            try {
                                                String string4 = cursorQuery2.getString(cursorQuery2.getColumnIndexOrThrow("_data"));
                                                Intrinsics.f(string4, "thumbCursor.getString(\n …                        )");
                                                str2 = string4;
                                            } catch (Exception e12) {
                                                e = e12;
                                                e.printStackTrace();
                                                if (cursorQuery2 != null) {
                                                }
                                                StringBuilder sb3 = new StringBuilder();
                                                sb3.append("size:");
                                                sb3.append(j11);
                                                sb3.append(",duration:");
                                                sb3.append(j12);
                                                sb3.append(",path:");
                                                sb3.append(string2);
                                                sb3.append(",thumbPath:");
                                                sb3.append(str2);
                                                long j15 = cursorQuery.getLong(7);
                                                long j16 = cursorQuery.getLong(8);
                                                vsMediaInfo = new VsMediaInfo();
                                                vsMediaInfo.setVideoDuration(j12);
                                                vsMediaInfo.setVideoTitle(string);
                                                vsMediaInfo.setVideoPath(string2);
                                                vsMediaInfo.setVideoSize(j11);
                                                vsMediaInfo.setImagePath(str2);
                                                vsMediaInfo.setHeight((int) j15);
                                                vsMediaInfo.setWidth((int) j16);
                                                if (!emitter.isDisposed()) {
                                                    cursorQuery.close();
                                                    return;
                                                }
                                                emitter.onNext(vsMediaInfo);
                                                z11 = true;
                                                i11 = 4;
                                                i12 = 3;
                                                i13 = 2;
                                                i14 = 0;
                                            }
                                        }
                                    } catch (Exception e13) {
                                        e = e13;
                                        i15 = 1;
                                        e.printStackTrace();
                                        if (cursorQuery2 != null) {
                                            cursorQuery2.close();
                                        }
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append("size:");
                                        sb4.append(j11);
                                        sb4.append(",duration:");
                                        sb4.append(j12);
                                        sb4.append(",path:");
                                        sb4.append(string2);
                                        sb4.append(",thumbPath:");
                                        sb4.append(str2);
                                        long j17 = cursorQuery.getLong(7);
                                        long j18 = cursorQuery.getLong(8);
                                        vsMediaInfo = new VsMediaInfo();
                                        vsMediaInfo.setVideoDuration(j12);
                                        vsMediaInfo.setVideoTitle(string);
                                        vsMediaInfo.setVideoPath(string2);
                                        vsMediaInfo.setVideoSize(j11);
                                        vsMediaInfo.setImagePath(str2);
                                        vsMediaInfo.setHeight((int) j17);
                                        vsMediaInfo.setWidth((int) j18);
                                        if (!emitter.isDisposed()) {
                                            cursorQuery.close();
                                            return;
                                        }
                                        emitter.onNext(vsMediaInfo);
                                        z11 = true;
                                        i11 = 4;
                                        i12 = 3;
                                        i13 = 2;
                                        i14 = 0;
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
                                i15 = 1;
                            }
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                        } catch (Exception e14) {
                            e = e14;
                            cursorQuery2 = null;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("size:");
                        sb5.append(j11);
                        sb5.append(",duration:");
                        sb5.append(j12);
                        sb5.append(",path:");
                        sb5.append(string2);
                        sb5.append(",thumbPath:");
                        sb5.append(str2);
                        long j19 = cursorQuery.getLong(7);
                        long j110 = cursorQuery.getLong(8);
                        vsMediaInfo = new VsMediaInfo();
                        vsMediaInfo.setVideoDuration(j12);
                        vsMediaInfo.setVideoTitle(string);
                        vsMediaInfo.setVideoPath(string2);
                        vsMediaInfo.setVideoSize(j11);
                        vsMediaInfo.setImagePath(str2);
                        vsMediaInfo.setHeight((int) j19);
                        vsMediaInfo.setWidth((int) j110);
                        if (!emitter.isDisposed()) {
                            cursorQuery.close();
                            return;
                        }
                        emitter.onNext(vsMediaInfo);
                        z11 = true;
                        i11 = 4;
                        i12 = 3;
                        i13 = 2;
                        i14 = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor2 = null;
                    }
                } catch (Exception e15) {
                    e = e15;
                    cursor = cursorQuery;
                    try {
                        e.printStackTrace();
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
            if (!z11) {
                emitter.onNext(new VsMediaInfo());
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e16) {
            e = e16;
            cursor = null;
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }
}
