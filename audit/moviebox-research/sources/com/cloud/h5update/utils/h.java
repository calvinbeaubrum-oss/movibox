package com.cloud.h5update.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.annotation.RequiresApi;
import com.cloud.h5update.TH5Update;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.error.VungleException;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f28911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f28912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f28913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f28914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f28915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f28916g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void e(Closeable... closeables) {
            Intrinsics.g(closeables, "closeables");
            for (Closeable closeable : closeables) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
            }
        }

        public final void f(Closeable... closeableArr) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public final ContentResolver g() {
            ContentResolver contentResolver = TH5Update.f28868c.c().getContentResolver();
            Intrinsics.f(contentResolver, "getContext().contentResolver");
            return contentResolver;
        }

        @RequiresApi(api = VungleException.INCORRECT_DEFAULT_API_USAGE)
        public final Uri h(Context context, File file) {
            Intrinsics.g(context, "context");
            Intrinsics.g(file, "file");
            try {
                String absolutePath = file.getAbsolutePath();
                Uri EXTERNAL_CONTENT_URI = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
                Intrinsics.f(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
                Cursor cursorQuery = context.getContentResolver().query(EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    if (!file.exists()) {
                        return null;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_data", absolutePath);
                    return context.getContentResolver().insert(EXTERNAL_CONTENT_URI, contentValues);
                }
                int i11 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                cursorQuery.close();
                return Uri.withAppendedPath(EXTERNAL_CONTENT_URI, "" + i11);
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        }

        public final String i() {
            String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
            Intrinsics.f(absolutePath, "getExternalStoragePublic…            .absolutePath");
            return absolutePath;
        }

        public final String j() {
            String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            Intrinsics.f(absolutePath, "getExternalStoragePublic…            .absolutePath");
            return absolutePath;
        }

        public final String k() {
            String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
            Intrinsics.f(absolutePath, "getExternalStoragePublic…            .absolutePath");
            return absolutePath;
        }

        public final String l() {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            Intrinsics.f(absolutePath, "getExternalStorageDirectory().absolutePath");
            return absolutePath;
        }

        public final File m(String str) {
            if (str == null || kotlin.text.l.y(str) || y(str)) {
                return null;
            }
            return new File(str);
        }

        public final InputStream n(File file) {
            InputStream fileInputStream = null;
            try {
                if (x()) {
                    Uri uriP = p(file);
                    if (uriP == null) {
                        return null;
                    }
                    fileInputStream = g().openInputStream(uriP);
                } else {
                    fileInputStream = new FileInputStream(file);
                }
            } catch (Exception e11) {
                po.b.f73956a.e(e11);
            }
            return fileInputStream;
        }

        public final Uri o(Context context, File file) {
            try {
                String absolutePath = file.getAbsolutePath();
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    if (!file.exists()) {
                        return null;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_data", absolutePath);
                    return context.getContentResolver().insert(uri, contentValues);
                }
                int i11 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                cursorQuery.close();
                return Uri.withAppendedPath(uri, "" + i11);
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        }

        public final Uri p(File file) {
            if (file == null) {
                return null;
            }
            if (!x() || !v(file)) {
                return q(file);
            }
            String filePath = file.getAbsolutePath();
            Intrinsics.f(filePath, "filePath");
            if (kotlin.text.l.L(filePath, h.f28914e, false, 2, null)) {
                return h(TH5Update.f28868c.c(), file);
            }
            return (kotlin.text.l.L(filePath, h.f28915f, false, 2, null) || kotlin.text.l.L(filePath, h.f28916g, false, 2, null)) ? o(TH5Update.f28868c.c(), file) : q(file);
        }

        public final Uri q(File file) {
            if (file == null) {
                return null;
            }
            return Uri.fromFile(file);
        }

        public final boolean r(File file) {
            if (file == null) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            return s(file.getAbsolutePath());
        }

        public final boolean s(String str) {
            File fileM = m(str);
            if (fileM == null) {
                return false;
            }
            if (fileM.exists()) {
                return true;
            }
            return t(str);
        }

        public final boolean t(String str) {
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                    AssetFileDescriptor assetFileDescriptorZ = z(Uri.parse(str));
                    if (assetFileDescriptorZ == null) {
                        f(assetFileDescriptorZ);
                        return false;
                    }
                    f(assetFileDescriptorZ);
                    f(assetFileDescriptorZ);
                    return true;
                } catch (FileNotFoundException unused) {
                    f(null);
                } catch (Throwable th2) {
                    f(null);
                    throw th2;
                }
            }
            return false;
        }

        public final boolean u(String str, File file) {
            return str == null || kotlin.text.l.y(str) || kotlin.text.l.v(str, i.f28917a.b(file), true);
        }

        public final boolean v(File file) {
            if (file == null) {
                return false;
            }
            try {
                String canonicalPath = file.getCanonicalPath();
                Intrinsics.f(canonicalPath, "file.canonicalPath");
                return w(canonicalPath);
            } catch (IOException e11) {
                e11.printStackTrace();
                return false;
            }
        }

        public final boolean w(String str) {
            return (y(str) || !kotlin.text.l.L(str, h.f28911b, false, 2, null) || kotlin.text.l.L(str, h.f28913d, false, 2, null)) ? false : true;
        }

        public final boolean x() {
            return Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy();
        }

        public final boolean y(String str) {
            if (str == null) {
                return true;
            }
            int length = str.length();
            for (int i11 = 0; i11 < length; i11++) {
                if (!Character.isWhitespace(str.charAt(i11))) {
                    return false;
                }
            }
            return true;
        }

        public final AssetFileDescriptor z(Uri uri) throws FileNotFoundException {
            ContentResolver contentResolverG = g();
            Intrinsics.d(uri);
            return contentResolverG.openAssetFileDescriptor(uri, CampaignEx.JSON_KEY_AD_R);
        }
    }

    static {
        a aVar = new a(null);
        f28910a = aVar;
        String strL = aVar.l();
        f28911b = strL;
        String str = strL + File.separator;
        f28912c = str;
        f28913d = str + "Android";
        f28914e = aVar.j();
        f28915f = aVar.k();
        f28916g = aVar.i();
    }
}
