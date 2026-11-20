package xq;

import android.content.Context;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f80669a = new d();

    public final boolean a(Context context, String assetFileName, File destinationFile) {
        Intrinsics.g(context, "context");
        Intrinsics.g(assetFileName, "assetFileName");
        Intrinsics.g(destinationFile, "destinationFile");
        try {
            InputStream inputStreamOpen = context.getAssets().open(assetFileName);
            Intrinsics.f(inputStreamOpen, "context.assets.open(assetFileName)");
            FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);
            ByteStreamsKt.b(inputStreamOpen, fileOutputStream, 0, 2, null);
            inputStreamOpen.close();
            fileOutputStream.close();
            return true;
        } catch (IOException e11) {
            com.transsion.ad.a.z(com.transsion.ad.a.f50276a, "AssetsUtil --> copyAssetFile() --> 复制失败 --> e = " + Log.getStackTraceString(e11), false, 2, null);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    public final String b(String fileName) throws Throwable {
        Intrinsics.g(fileName, "fileName");
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Utils.a().getResources().getAssets().open(fileName)));
            try {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    ?? line = bufferedReader2.readLine();
                    objectRef.element = line;
                    if (line == 0) {
                        bufferedReader2.close();
                        String string = sb2.toString();
                        Intrinsics.f(string, "sb.toString()");
                        bufferedReader2.close();
                        return string;
                    }
                    sb2.append((String) line);
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
