package com.cloud.tmc.integration.utils.share;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import com.applovin.exoplayer2.common.base.Ascii;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w0;

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
@SourceDebugExtension
public final class ShareStrategy implements yb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31111a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f31112b = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void o(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void p(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // yb.a
    public void a(Context context, c shareParams, com.cloud.tmc.integration.utils.share.a aVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(shareParams, "shareParams");
        TmcLogger.c("ShareStrategy", "doShare: " + shareParams);
        m(context, shareParams, aVar);
    }

    public final String f(byte[] bArr) {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.f(charArray, "this as java.lang.String).toCharArray()");
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b11 : bArr) {
            sb2.append(charArray[(b11 >> 4) & 15]);
            sb2.append(charArray[b11 & Ascii.SI]);
        }
        String string = sb2.toString();
        Intrinsics.f(string, "r.toString()");
        return string;
    }

    public final String g() {
        if (!q()) {
            return "";
        }
        String absolutePath = new File(h(), "MiniApp").getAbsolutePath();
        Intrinsics.f(absolutePath, "{\n            File(getEx…P).absolutePath\n        }");
        return absolutePath;
    }

    public final String h() {
        if (!q()) {
            return "";
        }
        String absolutePath = new File(l(), Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        Intrinsics.f(absolutePath, "{\n            File(getSD…S).absolutePath\n        }");
        return absolutePath;
    }

    public final byte[] i(File file) {
        if (file == null || !file.exists()) {
            return new byte[0];
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance("MD5"));
                try {
                    while (digestInputStream.read(new byte[262144]) > 0) {
                    }
                    byte[] bArrDigest = digestInputStream.getMessageDigest().digest();
                    Intrinsics.f(bArrDigest, "digest.digest()");
                    CloseableKt.a(digestInputStream, null);
                    CloseableKt.a(fileInputStream, null);
                    return bArrDigest;
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.a(digestInputStream, th2);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    CloseableKt.a(fileInputStream, th4);
                    throw th5;
                }
            }
        } catch (Throwable th6) {
            TmcLogger.g("ShareStrategy", "getFileMD5: ", th6);
            return new byte[0];
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00b1 -> B:33:0x00b4). Please report as a decompilation issue!!! */
    public final Object j(Context context, File file, Continuation<? super Uri> continuation) throws Throwable {
        ShareStrategy$getFileUriByCursor$1 shareStrategy$getFileUriByCursor$1;
        int i11;
        File file2;
        ShareStrategy shareStrategy;
        Uri uriR;
        Context context2;
        if (continuation instanceof ShareStrategy$getFileUriByCursor$1) {
            shareStrategy$getFileUriByCursor$1 = (ShareStrategy$getFileUriByCursor$1) continuation;
            int i12 = shareStrategy$getFileUriByCursor$1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                shareStrategy$getFileUriByCursor$1.label = i12 - Integer.MIN_VALUE;
            } else {
                shareStrategy$getFileUriByCursor$1 = new ShareStrategy$getFileUriByCursor$1(this, continuation);
            }
        } else {
            shareStrategy$getFileUriByCursor$1 = new ShareStrategy$getFileUriByCursor$1(this, continuation);
        }
        Object obj = shareStrategy$getFileUriByCursor$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i13 = shareStrategy$getFileUriByCursor$1.label;
        try {
            if (i13 == 0) {
                ResultKt.b(obj);
                File file3 = new File(g(), file.getName());
                if (!file.getAbsolutePath().equals(file3.getAbsolutePath()) && !Intrinsics.b(f(i(file)), f(i(file3)))) {
                    if (!xb.b.h(file, file3, false, false, 6, null)) {
                        return null;
                    }
                    xb.b.i(file3);
                    i11 = 0;
                    file2 = file3;
                    shareStrategy = this;
                    uriR = null;
                    context2 = context;
                    if (uriR == null || i11 >= 3) {
                        return uriR;
                    }
                    shareStrategy$getFileUriByCursor$1.L$0 = shareStrategy;
                    shareStrategy$getFileUriByCursor$1.L$1 = context2;
                    shareStrategy$getFileUriByCursor$1.L$2 = file2;
                    shareStrategy$getFileUriByCursor$1.I$0 = i11;
                    shareStrategy$getFileUriByCursor$1.label = 1;
                    if (r0.a(250L, shareStrategy$getFileUriByCursor$1) == objE) {
                        return objE;
                    }
                }
                String name = file3.getName();
                Intrinsics.f(name, "destFile.name");
                String absolutePath = file3.getAbsolutePath();
                Intrinsics.f(absolutePath, "destFile.absolutePath");
                return r(context, name, absolutePath);
            }
            if (i13 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i11 = shareStrategy$getFileUriByCursor$1.I$0;
            file2 = (File) shareStrategy$getFileUriByCursor$1.L$2;
            Context context3 = (Context) shareStrategy$getFileUriByCursor$1.L$1;
            shareStrategy = (ShareStrategy) shareStrategy$getFileUriByCursor$1.L$0;
            ResultKt.b(obj);
            context2 = context3;
            String name2 = file2.getName();
            Intrinsics.f(name2, "destFile.name");
            String absolutePath2 = file2.getAbsolutePath();
            Intrinsics.f(absolutePath2, "destFile.absolutePath");
            uriR = shareStrategy.r(context2, name2, absolutePath2);
            TmcLogger.c("ShareStrategy", "getFileUriByCursor: queryFileUriByCursor uri: " + uriR + " count: " + i11);
            i11++;
            if (uriR == null) {
            }
            return uriR;
        } catch (Throwable th2) {
            TmcLogger.g("ShareStrategy", "getFileUriByCursor: ", th2);
            return null;
        }
    }

    public final Uri k(Context context, File file) {
        try {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
        } catch (Throwable th2) {
            TmcLogger.g("ShareStrategy", "getFileUri: ", th2);
            return null;
        }
    }

    public final String l() {
        return q() ? Environment.getExternalStorageDirectory().getAbsolutePath() : "";
    }

    public final void m(final Context context, final c cVar, final com.cloud.tmc.integration.utils.share.a aVar) {
        n(context, cVar, aVar, new Function0<Unit>() { // from class: com.cloud.tmc.integration.utils.share.ShareStrategy$handleShareChannels$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (cVar.a() == 1) {
                    new b(context).a(cVar, aVar);
                    return;
                }
                TmcLogger.c("ShareStrategy", "handleShareChannels: no channel");
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(cVar.a(), 2);
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    public final void n(Context context, c cVar, com.cloud.tmc.integration.utils.share.a aVar, final Function0<Unit> function0) {
        File fileD = cVar.d();
        if (fileD == null) {
            f31112b.post(new Runnable() { // from class: com.cloud.tmc.integration.utils.share.e
                @Override // java.lang.Runnable
                public final void run() {
                    ShareStrategy.p(function0);
                }
            });
            return;
        }
        int i11 = Build.VERSION.SDK_INT;
        String[] strArr = i11 >= 33 ? new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"} : new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        try {
            if (!g.c(context, (String[]) Arrays.copyOf(strArr, strArr.length)) && i11 < 34) {
                TmcLogger.f("ShareStrategy", "handleShareFile: has no write permission");
                if (aVar != null) {
                    aVar.a(cVar.a(), 2);
                    return;
                }
                return;
            }
            try {
                if (!fileD.exists()) {
                    TmcLogger.f("ShareStrategy", "handleShareFile: file is not exist");
                    if (aVar != null) {
                        aVar.a(cVar.a(), 2);
                    }
                }
                if (!cVar.k()) {
                    j.d(l0.a(w0.b()), null, null, new ShareStrategy$handleShareFile$1$2(cVar, this, context, fileD, function0, null), 3, null);
                    return;
                }
                try {
                    cVar.l(k(context, fileD));
                    f31112b.post(new Runnable() { // from class: com.cloud.tmc.integration.utils.share.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            ShareStrategy.o(function0);
                        }
                    });
                } catch (Throwable th2) {
                    th = th2;
                    TmcLogger.g("ShareStrategy", "handleShareFile: exception", th);
                    if (aVar != null) {
                        aVar.a(cVar.a(), 2);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                TmcLogger.g("ShareStrategy", "handleShareFile: exception", th);
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final boolean q() {
        return Intrinsics.b("mounted", Environment.getExternalStorageState());
    }

    public final Uri r(Context context, String str, String str2) {
        Uri contentUri = MediaStore.Files.getContentUri("external");
        Intrinsics.f(contentUri, "getContentUri(\"external\")");
        Cursor cursorQuery = context.getContentResolver().query(contentUri, null, "_display_name=? AND _data=?", new String[]{str, str2}, null);
        if (cursorQuery == null || !cursorQuery.moveToNext()) {
            if (cursorQuery == null) {
                return null;
            }
            cursorQuery.close();
            return null;
        }
        Uri uriWithAppendedId = ContentUris.withAppendedId(contentUri, cursorQuery.getLong(cursorQuery.getColumnIndex("_id")));
        Intrinsics.f(uriWithAppendedId, "withAppendedId(contentUri, id)");
        TmcLogger.c("ShareStrategy", "queryFileUriByCursor: uri: " + uriWithAppendedId + " displayName: " + cursorQuery.getString(cursorQuery.getColumnIndex("_display_name")) + " path: " + cursorQuery.getString(cursorQuery.getColumnIndex("_data")));
        cursorQuery.close();
        return uriWithAppendedId;
    }
}
