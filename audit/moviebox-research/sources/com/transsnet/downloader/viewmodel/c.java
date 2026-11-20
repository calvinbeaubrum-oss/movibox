package com.transsnet.downloader.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.h0;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsnet.downloader.R$string;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import org.mvel2.ast.ASTNode;
import z2.f;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f61276a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ContentResolver f61277b = Utils.a().getContentResolver();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f61278c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f61279d;

    public final void A() {
        if (f61279d) {
            return;
        }
        f61279d = true;
        long jCurrentTimeMillis = System.currentTimeMillis();
        x("开始扫描本地磁盘");
        List<String> listO = o();
        x("获取公共文件夹的所有视频文件路径 -- sdCardVideoPathList = " + (listO != null ? Integer.valueOf(listO.size()) : null));
        if (listO != null) {
            Iterator<T> it = listO.iterator();
            while (it.hasNext()) {
                Uri uriFromFile = Uri.fromFile(new File((String) it.next()));
                Intrinsics.f(uriFromFile, "fromFile(File(it))");
                Utils.a().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uriFromFile));
            }
        }
        x("本地磁盘扫描完成 consume = " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public final String B(String str, Bitmap bm2) {
        Intrinsics.g(bm2, "bm");
        String str2 = "";
        File fileI = i(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileI);
            bm2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            String absolutePath = fileI.getAbsolutePath();
            Intrinsics.f(absolutePath, "saveFile.absolutePath");
            try {
                x("the picture is save to your phone! --- coverPath = " + absolutePath);
                return absolutePath;
            } catch (IOException e11) {
                e = e11;
                str2 = absolutePath;
                e.printStackTrace();
                x("保存图片出现了异常 --- ex = " + Log.getStackTraceString(e));
                return str2;
            }
        } catch (IOException e12) {
            e = e12;
        }
    }

    public final void C() {
        try {
            Intent intent = new Intent(Utils.a().getPackageName());
            intent.setFlags(ASTNode.DEOP);
            intent.setComponent(new ComponentName("com.google.android.permissioncontroller", "com.android.permissioncontroller.permission.ui.ManagePermissionsActivity"));
            Utils.a().startActivity(intent);
        } catch (Exception e11) {
            y("跳转应用权限设置界面失败 e = " + Log.getStackTraceString(e11));
            D();
        }
    }

    public final void D() {
        Intent intent = new Intent();
        intent.addFlags(ASTNode.DEOP);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", Utils.a().getPackageName(), null));
        Utils.a().startActivity(intent);
    }

    public final String E(long j11) {
        if (u(j11)) {
            String string = Utils.a().getString(R$string.download_today);
            Intrinsics.f(string, "getApp().getString(R.string.download_today)");
            return string;
        }
        if (w(j11)) {
            String string2 = Utils.a().getString(R$string.download_yesterday);
            Intrinsics.f(string2, "getApp().getString(R.string.download_yesterday)");
            return string2;
        }
        String strG = TimeUtilKt.g(j11);
        if (strG.length() != 5) {
            return strG;
        }
        List listE0 = StringsKt__StringsKt.E0(strG, new String[]{"-"}, false, 0, 6, null);
        return z((String) listE0.get(0)) + InstructionFileId.DOT + listE0.get(1);
    }

    public final boolean a() {
        int i11 = Build.VERSION.SDK_INT;
        int iCheckSelfPermission = (i11 >= 23 && i11 >= 33) ? z2.a.checkSelfPermission(Utils.a(), "android.permission.READ_MEDIA_VIDEO") : f.c(Utils.a(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return iCheckSelfPermission == 0;
    }

    public final boolean b(File file) {
        boolean z11 = true;
        if (file == null || file.exists()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            return b(parentFile);
        }
        if (!file.mkdirs() && !file.exists()) {
            z11 = false;
        }
        if (!z11) {
            Log.e("FileUtil", "createFileDir fail " + file);
        }
        return z11;
    }

    public final void c(File file) {
        b(file);
        if (file.exists() && file.isDirectory()) {
            file.delete();
        }
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile()) {
                return;
            }
            x("create file failure --> file.path = " + file.getAbsolutePath());
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public final List<String> d(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    Intrinsics.f(file2, "file");
                    d(file2);
                } else {
                    String absolutePath = file2.getAbsolutePath();
                    Intrinsics.f(absolutePath, "absolutePath");
                    if (v(absolutePath)) {
                        f61278c.add(absolutePath);
                        x("--------- ========== path = " + absolutePath);
                    }
                }
            }
        }
        return f61278c;
    }

    public final Bitmap e(String path) {
        Intrinsics.g(path, "path");
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return BitmapFactory.decodeFile(path);
    }

    public final long f(String filePath) {
        Intrinsics.g(filePath, "filePath");
        return h0.a(new Date(new File(filePath).lastModified()));
    }

    public final long g(String path) {
        Intrinsics.g(path, "path");
        return new File(path).length();
    }

    public final File h(Context context) {
        File filesDir = Utils.a().getFilesDir();
        if (filesDir == null) {
            return null;
        }
        File file = new File(filesDir, "outside");
        if (file.mkdirs() || (file.exists() && file.isDirectory())) {
            return file;
        }
        return null;
    }

    public final File i(String str) {
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        File fileH = h(applicationA);
        File file = new File(j(fileH != null ? fileH.getAbsolutePath() : null, str));
        c(file);
        return file;
    }

    public final String j(String str, String str2) {
        return str + File.separator + str2 + ".jpg";
    }

    public final String k(d video) {
        Intrinsics.g(video, "video");
        try {
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            File fileH = h(applicationA);
            String absolutePath = fileH != null ? fileH.getAbsolutePath() : null;
            String strE = video.e();
            if (strE == null) {
                strE = "";
            }
            File file = new File(j(absolutePath, l(strE)));
            if (file.exists() && file.isFile()) {
                String absolutePath2 = file.getAbsolutePath();
                Intrinsics.f(absolutePath2, "file.absolutePath");
                return absolutePath2;
            }
        } catch (Exception e11) {
            x("getLocalVideoCover e = " + Log.getStackTraceString(e11));
        }
        return "";
    }

    public final String l(String filePath) {
        Intrinsics.g(filePath, "filePath");
        if (TextUtils.isEmpty(filePath)) {
            return "";
        }
        String name = new File(filePath).getName();
        Intrinsics.f(name, "File(filePath).name");
        return name;
    }

    public final String[] m() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23 && i11 >= 33) {
            return new String[]{"android.permission.READ_MEDIA_VIDEO"};
        }
        return new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
    }

    public final File n() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory();
        }
        return null;
    }

    public final List<String> o() {
        try {
            File fileN = n();
            if (fileN == null) {
                return null;
            }
            f61278c.clear();
            return f61276a.d(fileN);
        } catch (Exception e11) {
            y("FileManagerUtil --> getSdCardVideoPathList() --> e = " + e11.getMessage());
            return null;
        }
    }

    public final Bitmap p(d video) {
        Intrinsics.g(video, "video");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(f61277b, video.c(), 1, options);
        y("getVideoThumbnail --- name = " + video.d() + " ----  bitmap = " + thumbnail);
        return thumbnail;
    }

    public final List<d> q() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = f61277b.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, CampaignEx.JSON_KEY_TITLE);
                while (true) {
                    Intrinsics.d(cursorQuery);
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    if (r(string)) {
                        int i11 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("_id"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("resolution"));
                        long j11 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_size"));
                        long j12 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("duration"));
                        arrayList.add(new d(i11, string, string2, string3, Long.valueOf(j11), Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("date_modified"))), Long.valueOf(j12), cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("width")), cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("height"))));
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                y("出问题了 --- " + Log.getStackTraceString(e11));
                if (cursorQuery != null) {
                    break;
                }
                return arrayList;
            }
            cursorQuery.close();
            return arrayList;
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    public final boolean r(String str) {
        if (str != null) {
            return new File(str).exists();
        }
        return false;
    }

    public final boolean s(Activity activity) {
        Intrinsics.g(activity, "activity");
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        if (roomAppMMKV.a().getBoolean("download_local_permission_first", true)) {
            roomAppMMKV.a().putBoolean("download_local_permission_first", false);
            return false;
        }
        boolean z11 = false;
        for (String str : m()) {
            if (!ActivityCompat.j(activity, str)) {
                z11 = true;
            }
        }
        return z11;
    }

    public final boolean t(long j11, String str) {
        Date date = new Date(j11);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        String str2 = simpleDateFormat.format(date);
        Intrinsics.f(str2, "sdf.format(date)");
        String str3 = simpleDateFormat.format(new Date());
        Intrinsics.f(str3, "sdf.format(Date())");
        return Intrinsics.b(str2, str3);
    }

    public final boolean u(long j11) {
        return t(j11, "yyyy-MM-dd");
    }

    public final boolean v(String path) {
        Intrinsics.g(path, "path");
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return l.u(path, ".avi", false, 2, null) || l.u(path, ".wmv", false, 2, null) || l.u(path, ".mpg", false, 2, null) || l.u(path, ".mpeg", false, 2, null) || l.u(path, ".mov", false, 2, null) || l.u(path, ".rm", false, 2, null) || l.u(path, ".ram", false, 2, null) || l.u(path, ".swf", false, 2, null) || l.u(path, ".flv", false, 2, null) || l.u(path, ".mp4", false, 2, null);
    }

    public final boolean w(long j11) throws ParseException {
        Date dateJ = h0.j(h0.h(j11));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = simpleDateFormat.parse(simpleDateFormat.format(date));
        if (date2 == null) {
            return false;
        }
        long time = date2.getTime() - dateJ.getTime();
        return 1 <= time && time < ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED;
    }

    public final void x(String msg) {
        Intrinsics.g(msg, "msg");
    }

    public final void y(String msg) {
        Intrinsics.g(msg, "msg");
        Log.e("zxb_log_historical", msg);
    }

    public final String z(String str) {
        int iHashCode = str.hashCode();
        switch (iHashCode) {
            case 1537:
                return !str.equals("01") ? str : "Jan";
            case 1538:
                return !str.equals("02") ? str : "Feb";
            case 1539:
                return !str.equals("03") ? str : "Mar";
            case 1540:
                return !str.equals("04") ? str : "Apr";
            case 1541:
                return !str.equals("05") ? str : "May";
            case 1542:
                return !str.equals("06") ? str : "Jun";
            case 1543:
                return !str.equals("07") ? str : "Jul";
            case 1544:
                return !str.equals("08") ? str : "Aug";
            case 1545:
                return !str.equals("09") ? str : "Sept";
            default:
                switch (iHashCode) {
                    case 1567:
                        return !str.equals(PrepareException.ERROR_MINI_APPID) ? str : "Oct";
                    case 1568:
                        return !str.equals(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY) ? str : "Nov";
                    case 1569:
                        return !str.equals(PrepareException.ERROR_LOCAL_DATA_FILE_SCAN) ? str : "Dec";
                    default:
                        return str;
                }
        }
    }
}
