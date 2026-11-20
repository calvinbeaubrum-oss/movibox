package com.transsnet.downloader.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.UtilsTransActivity;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DocumentsUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentsUtils f61126a = new DocumentsUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f61127b = DocumentsUtils.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f61128c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function1<? super Uri, Unit> f61129d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class DocumentsPermissionTransActivityImpl extends UtilsTransActivity.TransActivityDelegate {
        private static final String ROOT_PATH = "extra_root_path";
        private Uri uri;
        public static final a Companion = new a(null);
        private static final Lazy<DocumentsPermissionTransActivityImpl> instance$delegate = LazyKt__LazyJVMKt.b(new Function0<DocumentsPermissionTransActivityImpl>() { // from class: com.transsnet.downloader.util.DocumentsUtils$DocumentsPermissionTransActivityImpl$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DocumentsUtils.DocumentsPermissionTransActivityImpl invoke() {
                return new DocumentsUtils.DocumentsPermissionTransActivityImpl();
            }
        });

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static final void d(String rootPath, Intent intent) {
                Intrinsics.g(rootPath, "$rootPath");
                intent.putExtra(DocumentsPermissionTransActivityImpl.ROOT_PATH, rootPath);
            }

            public final DocumentsPermissionTransActivityImpl b() {
                return (DocumentsPermissionTransActivityImpl) DocumentsPermissionTransActivityImpl.instance$delegate.getValue();
            }

            public final void c(final String rootPath) {
                Intrinsics.g(rootPath, "rootPath");
                UtilsTransActivity.M(new Utils.b() { // from class: com.transsnet.downloader.util.d
                    @Override // com.blankj.utilcode.util.Utils.b
                    public final void accept(Object obj) {
                        DocumentsUtils.DocumentsPermissionTransActivityImpl.a.d(rootPath, (Intent) obj);
                    }
                }, b());
            }
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onActivityResult(UtilsTransActivity activity, int i11, int i12, Intent intent) {
            Intrinsics.g(activity, "activity");
            this.uri = intent != null ? intent.getData() : null;
            activity.finish();
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onCreated(UtilsTransActivity activity, Bundle bundle) {
            Object objM163constructorimpl;
            StorageVolume storageVolume;
            Intrinsics.g(activity, "activity");
            activity.getWindow().addFlags(262160);
            String stringExtra = activity.getIntent().getStringExtra(ROOT_PATH);
            if (stringExtra == null || stringExtra.length() == 0) {
                activity.finish();
                return;
            }
            try {
                Result.Companion companion = Result.Companion;
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    Intent intent = null;
                    if (Build.VERSION.SDK_INT >= 24 && (storageVolume = ((StorageManager) activity.getSystemService(StorageManager.class)).getStorageVolume(new File(stringExtra))) != null) {
                        intent = storageVolume.createAccessIntent(null);
                    }
                    if (intent == null) {
                        intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                    }
                    activity.startActivityForResult(intent, 10011);
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                    if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                        activity.finish();
                    }
                }
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onDestroy(UtilsTransActivity activity) {
            Intrinsics.g(activity, "activity");
            Function1 function1 = DocumentsUtils.f61129d;
            if (function1 != null) {
                function1.invoke(this.uri);
            }
        }
    }

    public final boolean c(File file) {
        Intrinsics.g(file, "file");
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = file.exists() && file.canWrite();
        if (z13 || file.exists()) {
            return z13;
        }
        try {
            try {
                if (file.isDirectory()) {
                    if (!file.mkdirs() || !file.delete()) {
                        z11 = false;
                    }
                } else if (!file.createNewFile() || !file.delete()) {
                    z11 = false;
                }
                z12 = z11;
            } catch (Throwable unused) {
            }
            return z12;
        } catch (IOException e11) {
            e11.printStackTrace();
            return z13;
        }
    }

    public final boolean d(Context context, String rootPath) {
        l3.a aVarH;
        Intrinsics.g(context, "context");
        Intrinsics.g(rootPath, "rootPath");
        File file = new File(rootPath);
        if (file.canWrite()) {
            return false;
        }
        if (j(file, context)) {
            l3.a aVarE = e(file, true, context);
            if (aVarE != null && aVarE.a()) {
                return false;
            }
        } else {
            String string = RoomAppMMKV.f51271a.a().getString(rootPath, "");
            if (string != null && string.length() != 0 && (aVarH = l3.a.h(context, Uri.parse(string))) != null && aVarH.a()) {
                return false;
            }
        }
        return true;
    }

    public final l3.a e(File file, boolean z11, Context context) {
        String strSubstring;
        boolean z12;
        List listL;
        Intrinsics.g(file, "file");
        Intrinsics.g(context, "context");
        String strF = f(file, context);
        if (strF == null) {
            return null;
        }
        try {
            String fullPath = file.getCanonicalPath();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getDocumentFile, fullPath = ");
            sb2.append(fullPath);
            sb2.append(", baseFolder = ");
            sb2.append(strF);
            if (Intrinsics.b(strF, fullPath)) {
                strSubstring = null;
                z12 = true;
            } else {
                Intrinsics.f(fullPath, "fullPath");
                strSubstring = fullPath.substring(strF.length() + 1);
                Intrinsics.f(strSubstring, "substring(...)");
                z12 = false;
            }
        } catch (IOException unused) {
            return null;
        } catch (Exception unused2) {
        }
        String string = RoomAppMMKV.f51271a.a().getString(strF, "");
        Uri uri = (string == null || string.length() <= 0) ? null : Uri.parse(string);
        if (uri == null) {
            return null;
        }
        l3.a aVarH = l3.a.h(context, uri);
        if (z12) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("originalDirectory, treeUri = ");
            sb3.append(uri);
            return aVarH;
        }
        Intrinsics.d(strSubstring);
        List<String> listSplit = new Regex("/").split(strSubstring, 0);
        if (listSplit.isEmpty()) {
            listL = kotlin.collections.g.l();
            break;
        }
        ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                listL = kotlin.collections.g.l();
                break;
            }
            if (listIterator.previous().length() != 0) {
                listL = CollectionsKt___CollectionsKt.F0(listSplit, listIterator.nextIndex() + 1);
                break;
            }
        }
        String[] strArr = (String[]) listL.toArray(new String[0]);
        int length = strArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            String str = strArr[i11];
            StringBuilder sb4 = new StringBuilder();
            sb4.append("----- = ");
            sb4.append(str);
            Intrinsics.d(aVarH);
            l3.a aVarF = aVarH.f(strArr[i11]);
            if (aVarF != null) {
                aVarH = aVarF;
            } else if (i11 < strArr.length - 1 || z11) {
                String str2 = strArr[i11];
                StringBuilder sb5 = new StringBuilder();
                sb5.append("createDirector DES = ");
                sb5.append(str2);
                aVarH = aVarH.b(strArr[i11]);
            } else {
                String str3 = strArr[i11];
                StringBuilder sb6 = new StringBuilder();
                sb6.append("createFile DES = ");
                sb6.append(str3);
                aVarH = aVarH.c("video", strArr[i11]);
            }
        }
        return aVarH;
    }

    public final String f(File file, Context context) {
        String[] strArrG = g();
        try {
            int length = strArrG.length;
            for (int i11 = 0; i11 < length; i11++) {
                String canonicalPath = file.getCanonicalPath();
                Intrinsics.f(canonicalPath, "file.canonicalPath");
                if (kotlin.text.l.L(canonicalPath, strArrG[i11], false, 2, null)) {
                    return strArrG[i11];
                }
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public final String[] g() {
        List<String> list = f61128c;
        if (list.size() > 0) {
            return (String[]) list.toArray(new String[0]);
        }
        Iterator<f00.e> it = DownloadSDCardUtil.f61130a.b().iterator();
        while (it.hasNext()) {
            f61128c.add(it.next().b());
        }
        return (String[]) f61128c.toArray(new String[0]);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003b -> B:19:0x003c). Please report as a decompilation issue!!! */
    public final InputStream h(Context context, File destFile) {
        InputStream inputStreamOpenInputStream;
        Intrinsics.g(context, "context");
        Intrinsics.g(destFile, "destFile");
        try {
            if (c(destFile) || !j(destFile, context)) {
                inputStreamOpenInputStream = new FileInputStream(destFile);
            } else {
                l3.a aVarE = e(destFile, false, context);
                inputStreamOpenInputStream = (aVarE == null || !aVarE.a()) ? null : context.getContentResolver().openInputStream(aVarE.j());
            }
        } catch (FileNotFoundException e11) {
            e11.printStackTrace();
        }
        return inputStreamOpenInputStream;
    }

    public final OutputStream i(Context context, File destFile, Function1<? super String, Unit> function1) {
        Intrinsics.g(context, "context");
        Intrinsics.g(destFile, "destFile");
        try {
            if (c(destFile) || !j(destFile, context)) {
                return new FileOutputStream(destFile);
            }
            l3.a aVarE = e(destFile, false, context);
            if (aVarE != null && aVarE.a()) {
                Uri uriJ = aVarE.j();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getOutputStream, file.uri = ");
                sb2.append(uriJ);
                if (function1 != null) {
                    String string = aVarE.j().toString();
                    Intrinsics.f(string, "file.uri.toString()");
                    function1.invoke(string);
                }
                return context.getContentResolver().openOutputStream(aVarE.j());
            }
            return null;
        } catch (FileNotFoundException e11) {
            e11.printStackTrace();
        }
    }

    @TargetApi(19)
    public final boolean j(File file, Context c11) {
        Intrinsics.g(file, "file");
        Intrinsics.g(c11, "c");
        return f(file, c11) != null;
    }

    public final void k(String rootPath, final Function1<? super Uri, Unit> callback) {
        Intrinsics.g(rootPath, "rootPath");
        Intrinsics.g(callback, "callback");
        f61129d = new Function1<Uri, Unit>() { // from class: com.transsnet.downloader.util.DocumentsUtils$requestPermission$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
                invoke2(uri);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Uri uri) {
                callback.invoke(uri);
                DocumentsUtils.f61129d = null;
            }
        };
        DocumentsPermissionTransActivityImpl.Companion.c(rootPath);
    }

    public final boolean l(Context context, String rootPath, Uri uri) {
        Intrinsics.g(rootPath, "rootPath");
        Intrinsics.g(uri, "uri");
        Intrinsics.d(context);
        l3.a aVarH = l3.a.h(context, uri);
        if (aVarH == null || !aVarH.a()) {
            Log.e(f61127b, "no write permission: " + rootPath);
            return false;
        }
        Log.e(f61127b, "saveTreeUri: rootPath = " + rootPath + "， uri = " + uri);
        RoomAppMMKV.f51271a.a().putString(rootPath, uri.toString());
        return true;
    }
}
