package com.transsion.ninegridview.helper;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.Utils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.l;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.w0;
import uo.b;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class FileHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FileHelper f53955a = new FileHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f53956b = Environment.DIRECTORY_PICTURES;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f53957c = 100;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static q1 f53958d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f53959a;

        public a(File file) {
            this.f53959a = file;
        }

        public /* synthetic */ a(File file, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : file);
        }

        public final File a() {
            return this.f53959a;
        }

        public final void b(File file) {
            this.f53959a = file;
        }
    }

    public static /* synthetic */ Uri u(FileHelper fileHelper, Bitmap bitmap, Context context, String str, String str2, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            str2 = "MovieBox";
        }
        return fileHelper.s(bitmap, context, str, str2, (i12 & 8) != 0 ? 75 : i11);
    }

    public final void e(AppCompatActivity appCompatActivity, Function0<Unit> function0) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            function0.invoke();
            return;
        }
        if (i11 < 23) {
            function0.invoke();
        } else if (z2.a.checkSelfPermission(appCompatActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && z2.a.checkSelfPermission(appCompatActivity, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            function0.invoke();
        } else {
            q(appCompatActivity);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object f(File file, Context context, String str, String str2, Continuation<? super Uri> continuation) throws Throwable {
        FileHelper$copyToAlbum$1 fileHelper$copyToAlbum$1;
        Closeable closeable;
        if (continuation instanceof FileHelper$copyToAlbum$1) {
            fileHelper$copyToAlbum$1 = (FileHelper$copyToAlbum$1) continuation;
            int i11 = fileHelper$copyToAlbum$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                fileHelper$copyToAlbum$1.label = i11 - Integer.MIN_VALUE;
            } else {
                fileHelper$copyToAlbum$1 = new FileHelper$copyToAlbum$1(this, continuation);
            }
        } else {
            fileHelper$copyToAlbum$1 = new FileHelper$copyToAlbum$1(this, continuation);
        }
        FileHelper$copyToAlbum$1 fileHelper$copyToAlbum$2 = fileHelper$copyToAlbum$1;
        Object obj = fileHelper$copyToAlbum$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = fileHelper$copyToAlbum$2.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            try {
                if (file.canRead() && file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        FileHelper fileHelper = f53955a;
                        fileHelper$copyToAlbum$2.L$0 = fileInputStream;
                        fileHelper$copyToAlbum$2.label = 1;
                        Object objT = fileHelper.t(fileInputStream, context, str, str2, fileHelper$copyToAlbum$2);
                        if (objT == objE) {
                            return objE;
                        }
                        obj = objT;
                        closeable = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = fileInputStream;
                        throw th;
                    }
                }
                b.a.f(b.f78622a, "FileHelper", "check: read file error: " + file, false, 4, null);
                return null;
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        closeable = (Closeable) fileHelper$copyToAlbum$2.L$0;
        try {
            ResultKt.b(obj);
        } catch (Throwable th3) {
            th = th3;
            try {
                throw th;
            } catch (Throwable th4) {
                CloseableKt.a(closeable, th);
                throw th4;
            }
        }
        Uri uri = (Uri) obj;
        CloseableKt.a(closeable, null);
        return uri;
    }

    public final void g(File file, Context context, String fileName, String str) {
        Intrinsics.g(file, "file");
        Intrinsics.g(context, "context");
        Intrinsics.g(fileName, "fileName");
        try {
            Result.Companion companion = Result.Companion;
            Result.m163constructorimpl(j.d(l0.a(w0.b()), null, null, new FileHelper$copyToAlbumAsync$1$1(this, file, context, fileName, str, null), 3, null));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void h(Uri uri, Context context, ContentResolver contentResolver, File file) {
        ContentValues contentValues = new ContentValues();
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", (Integer) 0);
            contentResolver.update(uri, contentValues, null, null);
        } else {
            if (file != null) {
                contentValues.put("_size", Long.valueOf(file.length()));
            }
            contentResolver.update(uri, contentValues, null, null);
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uri));
        }
    }

    public final Bitmap.CompressFormat i(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        if (l.u(lowerCase, ".png", false, 2, null)) {
            return Bitmap.CompressFormat.PNG;
        }
        if (l.u(lowerCase, ".jpg", false, 2, null) || l.u(lowerCase, ".jpeg", false, 2, null)) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (l.u(lowerCase, ".webp", false, 2, null)) {
            return Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSLESS : Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.PNG;
    }

    public final String j(String str) {
        List listL;
        List listL2;
        if (str == null) {
            return System.currentTimeMillis() + ".jpg";
        }
        int i11 = Utils.a().getApplicationInfo().uid;
        List<String> listSplit = new Regex("[?]").split(str, 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    listL = g.l();
                    break;
                }
                if (listIterator.previous().length() != 0) {
                    listL = CollectionsKt___CollectionsKt.F0(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
        } else {
            listL = g.l();
            break;
        }
        String[] strArr = (String[]) listL.toArray(new String[0]);
        if (!(strArr.length == 0)) {
            List<String> listSplit2 = new Regex("/").split(strArr[0], 0);
            if (!listSplit2.isEmpty()) {
                ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                while (true) {
                    if (!listIterator2.hasPrevious()) {
                        listL2 = g.l();
                        break;
                    }
                    if (listIterator2.previous().length() != 0) {
                        listL2 = CollectionsKt___CollectionsKt.F0(listSplit2, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
            } else {
                listL2 = g.l();
                break;
            }
            String[] strArr2 = (String[]) listL2.toArray(new String[0]);
            if (!(strArr2.length == 0)) {
                return i11 + "_" + strArr2[strArr2.length - 1];
            }
        }
        return System.currentTimeMillis() + ".jpg";
    }

    public final String k(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        if (l.u(lowerCase, ".png", false, 2, null)) {
            return "image/png";
        }
        if (l.u(lowerCase, ".jpg", false, 2, null) || l.u(lowerCase, ".jpeg", false, 2, null)) {
            return "image/jpeg";
        }
        if (l.u(lowerCase, ".webp", false, 2, null)) {
            return "image/webp";
        }
        if (l.u(lowerCase, ".gif", false, 2, null)) {
            return "image/gif";
        }
        return null;
    }

    public final int l() {
        return f53957c;
    }

    public final File m(String fileName) {
        Intrinsics.g(fileName, "fileName");
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MovieBox" + File.separator + fileName);
    }

    public final Uri n(ContentResolver contentResolver, String fileName, String str, a aVar) {
        Uri EXTERNAL_CONTENT_URI;
        String str2;
        Intrinsics.g(contentResolver, "<this>");
        Intrinsics.g(fileName, "fileName");
        ContentValues contentValues = new ContentValues();
        String strK = f53955a.k(fileName);
        if (strK != null) {
            contentValues.put("mime_type", strK);
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        contentValues.put("date_added", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(jCurrentTimeMillis));
        int i11 = 1;
        if (Build.VERSION.SDK_INT >= 29) {
            if (str != null) {
                str2 = f53956b + "/" + str;
            } else {
                str2 = f53956b;
            }
            contentValues.put("_display_name", fileName);
            contentValues.put("relative_path", str2);
            contentValues.put("is_pending", (Integer) 1);
            EXTERNAL_CONTENT_URI = MediaStore.Images.Media.getContentUri("external_primary");
            Intrinsics.f(EXTERNAL_CONTENT_URI, "getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)");
        } else {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(f53956b);
            if (str != null) {
                externalStoragePublicDirectory = new File(externalStoragePublicDirectory, str);
            }
            if (!externalStoragePublicDirectory.exists() && !externalStoragePublicDirectory.mkdirs()) {
                b.a.f(b.f78622a, "FileHelper", "save: error: can't create Pictures directory", false, 4, null);
                return null;
            }
            File file = new File(externalStoragePublicDirectory, fileName);
            String strU = FilesKt__UtilsKt.u(file);
            String strT = FilesKt__UtilsKt.t(file);
            String absolutePath = file.getAbsolutePath();
            Intrinsics.f(absolutePath, "imageFile.absolutePath");
            Uri uriP = p(contentResolver, absolutePath);
            while (uriP != null) {
                int i12 = i11 + 1;
                File file2 = new File(externalStoragePublicDirectory, strU + "(" + i11 + ")." + strT);
                String absolutePath2 = file2.getAbsolutePath();
                Intrinsics.f(absolutePath2, "imageFile.absolutePath");
                Uri uriP2 = p(contentResolver, absolutePath2);
                i11 = i12;
                file = file2;
                uriP = uriP2;
            }
            contentValues.put("_display_name", file.getName());
            String absolutePath3 = file.getAbsolutePath();
            b.a.s(b.f78622a, "FileHelper", "save file: " + absolutePath3, false, 4, null);
            contentValues.put("_data", absolutePath3);
            if (aVar != null) {
                aVar.b(file);
            }
            EXTERNAL_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.f(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
        }
        return contentResolver.insert(EXTERNAL_CONTENT_URI, contentValues);
    }

    public final OutputStream o(Uri uri, ContentResolver contentResolver) {
        try {
            return contentResolver.openOutputStream(uri);
        } catch (FileNotFoundException e11) {
            b.a.f(b.f78622a, "FileHelper", "save: open stream error: " + e11, false, 4, null);
            return null;
        }
    }

    public final Uri p(ContentResolver contentResolver, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        File file = new File(str);
        if (file.canRead() && file.exists()) {
            b.a.s(b.f78622a, "FileHelper", "query: path: " + str + " exists", false, 4, null);
            return Uri.fromFile(file);
        }
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"_id", "_data"}, "_data == ?", new String[]{str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToNext()) {
                    Uri uriWithAppendedId = ContentUris.withAppendedId(uri, cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id")));
                    Intrinsics.f(uriWithAppendedId, "withAppendedId(collection, id)");
                    b.a.s(b.f78622a, "FileHelper", "query: path: " + str + " exists uri: " + uriWithAppendedId, false, 4, null);
                    CloseableKt.a(cursorQuery, null);
                    return uriWithAppendedId;
                }
                Unit unit = Unit.f68710a;
                CloseableKt.a(cursorQuery, null);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(cursorQuery, th2);
                    throw th3;
                }
            }
        }
        return null;
    }

    public final void q(AppCompatActivity appCompatActivity) {
        ActivityCompat.g(appCompatActivity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, f53957c);
    }

    public final void r(final AppCompatActivity activity, final Bitmap bitmap, final String fileName, final Function2<? super Boolean, ? super File, Unit> function2) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(fileName, "fileName");
        if (bitmap == null) {
            return;
        }
        e(activity, new Function0<Unit>() { // from class: com.transsion.ninegridview.helper.FileHelper$saveBitmapToPicture$1

            /* JADX INFO: renamed from: com.transsion.ninegridview.helper.FileHelper$saveBitmapToPicture$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "com.transsion.ninegridview.helper.FileHelper$saveBitmapToPicture$1$1", f = "FileHelper.kt", l = {333, 340}, m = "invokeSuspend")
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                final /* synthetic */ AppCompatActivity $activity;
                final /* synthetic */ Bitmap $bitmap;
                final /* synthetic */ Function2<Boolean, File, Unit> $callback;
                final /* synthetic */ String $fileName;
                int label;

                /* JADX INFO: renamed from: com.transsion.ninegridview.helper.FileHelper$saveBitmapToPicture$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: source.java */
                @Metadata
                @DebugMetadata(c = "com.transsion.ninegridview.helper.FileHelper$saveBitmapToPicture$1$1$1", f = "FileHelper.kt", l = {}, m = "invokeSuspend")
                public static final class C05791 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function2<Boolean, File, Unit> $callback;
                    final /* synthetic */ File $imgFile;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C05791(Function2<? super Boolean, ? super File, Unit> function2, File file, Continuation<? super C05791> continuation) {
                        super(2, continuation);
                        this.$callback = function2;
                        this.$imgFile = file;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C05791(this.$callback, this.$imgFile, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                        return ((C05791) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        kotlin.coroutines.intrinsics.a.e();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        Function2<Boolean, File, Unit> function2 = this.$callback;
                        if (function2 == null) {
                            return null;
                        }
                        function2.invoke(Boxing.a(true), this.$imgFile);
                        return Unit.f68710a;
                    }
                }

                /* JADX INFO: renamed from: com.transsion.ninegridview.helper.FileHelper$saveBitmapToPicture$1$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: source.java */
                @Metadata
                @DebugMetadata(c = "com.transsion.ninegridview.helper.FileHelper$saveBitmapToPicture$1$1$2", f = "FileHelper.kt", l = {}, m = "invokeSuspend")
                public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function2<Boolean, File, Unit> $callback;
                    final /* synthetic */ File $imgFile;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass2(Function2<? super Boolean, ? super File, Unit> function2, File file, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$callback = function2;
                        this.$imgFile = file;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.$callback, this.$imgFile, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        kotlin.coroutines.intrinsics.a.e();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        Function2<Boolean, File, Unit> function2 = this.$callback;
                        if (function2 != null) {
                            function2.invoke(Boxing.a(false), this.$imgFile);
                        }
                        return Unit.f68710a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass1(String str, Bitmap bitmap, AppCompatActivity appCompatActivity, Function2<? super Boolean, ? super File, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$fileName = str;
                    this.$bitmap = bitmap;
                    this.$activity = appCompatActivity;
                    this.$callback = function2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$fileName, this.$bitmap, this.$activity, this.$callback, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objE = kotlin.coroutines.intrinsics.a.e();
                    int i11 = this.label;
                    if (i11 != 0) {
                        if (i11 == 1) {
                            ResultKt.b(obj);
                            return Unit.f68710a;
                        }
                        if (i11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        return Unit.f68710a;
                    }
                    ResultKt.b(obj);
                    FileHelper fileHelper = FileHelper.f53955a;
                    File fileM = fileHelper.m(this.$fileName);
                    if (fileM.exists()) {
                        a2 a2VarC = w0.c();
                        C05791 c05791 = new C05791(this.$callback, fileM, null);
                        this.label = 1;
                        if (h.g(a2VarC, c05791, this) == objE) {
                            return objE;
                        }
                        return Unit.f68710a;
                    }
                    FileHelper.u(fileHelper, this.$bitmap, this.$activity, this.$fileName, null, 0, 12, null);
                    a2 a2VarC2 = w0.c();
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$callback, fileM, null);
                    this.label = 2;
                    if (h.g(a2VarC2, anonymousClass2, this) == objE) {
                        return objE;
                    }
                    return Unit.f68710a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                q1 q1Var = FileHelper.f53958d;
                if (q1Var != null) {
                    q1.a.b(q1Var, null, 1, null);
                }
                FileHelper.f53958d = j.d(v.a(activity), w0.b(), null, new AnonymousClass1(fileName, bitmap, activity, function2, null), 2, null);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Uri s(Bitmap bitmap, Context context, String fileName, String relativePath, int i11) {
        Intrinsics.g(bitmap, "<this>");
        Intrinsics.g(context, "context");
        Intrinsics.g(fileName, "fileName");
        Intrinsics.g(relativePath, "relativePath");
        ContentResolver resolver = context.getContentResolver();
        a aVar = new a(null, 1, 0 == true ? 1 : 0);
        Intrinsics.f(resolver, "resolver");
        Uri uriN = n(resolver, fileName, relativePath, aVar);
        if (uriN == null) {
            b.a.f(b.f78622a, "FileHelper", "insert: error: uri == null", false, 4, null);
            return null;
        }
        OutputStream outputStreamO = o(uriN, resolver);
        if (outputStreamO == null) {
            return null;
        }
        try {
            FileHelper fileHelper = f53955a;
            bitmap.compress(fileHelper.i(fileName), i11, outputStreamO);
            fileHelper.h(uriN, context, resolver, aVar.a());
            Unit unit = Unit.f68710a;
            CloseableKt.a(outputStreamO, null);
            return uriN;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(outputStreamO, th2);
                throw th3;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4 */
    public final Object t(InputStream inputStream, Context context, String str, String str2, Continuation<? super Uri> continuation) throws Throwable {
        FileHelper$saveToAlbum$1 fileHelper$saveToAlbum$1;
        Throwable th2;
        Uri uri;
        Closeable closeable;
        Closeable closeable2;
        Closeable closeable3;
        InputStream inputStream2 = inputStream;
        if (continuation instanceof FileHelper$saveToAlbum$1) {
            fileHelper$saveToAlbum$1 = (FileHelper$saveToAlbum$1) continuation;
            int i11 = fileHelper$saveToAlbum$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                fileHelper$saveToAlbum$1.label = i11 - Integer.MIN_VALUE;
            } else {
                fileHelper$saveToAlbum$1 = new FileHelper$saveToAlbum$1(this, continuation);
            }
        } else {
            fileHelper$saveToAlbum$1 = new FileHelper$saveToAlbum$1(this, continuation);
        }
        Object obj = fileHelper$saveToAlbum$1.result;
        ?? E = kotlin.coroutines.intrinsics.a.e();
        int i12 = fileHelper$saveToAlbum$1.label;
        int i13 = 1;
        File file = null;
        boolean z11 = false;
        try {
            if (i12 == 0) {
                ResultKt.b(obj);
                ContentResolver resolver = context.getContentResolver();
                a aVar = new a(file, i13, z11 ? 1 : 0);
                Intrinsics.f(resolver, "resolver");
                Uri uriN = n(resolver, str, str2, aVar);
                if (uriN == null) {
                    b.a.f(b.f78622a, "FileHelper", "insert: error: uri == null", false, 4, null);
                    return null;
                }
                OutputStream outputStreamO = o(uriN, resolver);
                if (outputStreamO == null) {
                    return null;
                }
                try {
                    ByteStreamsKt.b(inputStream2, outputStreamO, 0, 2, null);
                    f53955a.h(uriN, context, resolver, aVar.a());
                    a2 a2VarC = w0.c();
                    FileHelper$saveToAlbum$2$1$1 fileHelper$saveToAlbum$2$1$1 = new FileHelper$saveToAlbum$2$1$1(null);
                    fileHelper$saveToAlbum$1.L$0 = uriN;
                    fileHelper$saveToAlbum$1.L$1 = outputStreamO;
                    fileHelper$saveToAlbum$1.L$2 = inputStream2;
                    fileHelper$saveToAlbum$1.label = 1;
                    if (h.g(a2VarC, fileHelper$saveToAlbum$2$1$1, fileHelper$saveToAlbum$1) == E) {
                        return E;
                    }
                    uri = uriN;
                    closeable = outputStreamO;
                    closeable3 = inputStream2;
                } catch (Throwable th3) {
                    th2 = th3;
                    E = outputStreamO;
                    closeable2 = inputStream2;
                    throw th2;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable3 = (Closeable) fileHelper$saveToAlbum$1.L$2;
                closeable = (Closeable) fileHelper$saveToAlbum$1.L$1;
                uri = (Uri) fileHelper$saveToAlbum$1.L$0;
                try {
                    ResultKt.b(obj);
                    closeable3 = closeable3;
                    closeable = closeable;
                } catch (Throwable th4) {
                    th2 = th4;
                    closeable2 = closeable3;
                    E = closeable;
                    try {
                        throw th2;
                    } catch (Throwable th5) {
                        CloseableKt.a(closeable2, th2);
                        throw th5;
                    }
                }
            }
            Unit unit = Unit.f68710a;
            CloseableKt.a(closeable3, null);
            CloseableKt.a(closeable, null);
            return uri;
        } catch (Throwable th6) {
            try {
                throw th6;
            } catch (Throwable th7) {
                CloseableKt.a(E, th6);
                throw th7;
            }
        }
    }
}
