package w9;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.io.File;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f79382a = new p();

    public static final void e(String zipPath, String outPutPath, AdsDTO adsDTO, final g gVar) {
        Preconditions.a aVar;
        File[] fileArrListFiles;
        Intrinsics.g(zipPath, "$zipPath");
        Intrinsics.g(outPutPath, "$outPutPath");
        String str = f.b(com.cloud.sdk.commonutil.util.f.a()) + File.separator + "interactive_zip";
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length >= 10) {
                int length = fileArrListFiles.length - 5;
                for (int i11 = 0; i11 < length; i11++) {
                    File file2 = fileArrListFiles[i11];
                    if (file2 != null) {
                        f.a(file2);
                    }
                }
            }
        }
        if (e0.b(zipPath, outPutPath)) {
            adsDTO.setIndexLocation(f.e(outPutPath));
            aVar = new Preconditions.a() { // from class: w9.n
                @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                public final void onRun() {
                    p.f(gVar);
                }
            };
        } else {
            AthenaTracker.U(adsDTO, 2);
            aVar = new Preconditions.a() { // from class: w9.o
                @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                public final void onRun() {
                    p.g(gVar);
                }
            };
        }
        Preconditions.d(aVar);
    }

    public static final void f(g gVar) {
        gVar.a(true);
    }

    public static final void g(g gVar) {
        gVar.a(false);
    }

    public final void d(final AdsDTO adsDTO, final String str, final String str2, final g gVar) {
        if (gVar == null || adsDTO == null) {
            return;
        }
        com.cloud.sdk.commonutil.util.i.f30292a.e(new Runnable() { // from class: w9.m
            @Override // java.lang.Runnable
            public final void run() {
                p.e(str, str2, adsDTO, gVar);
            }
        });
    }

    public final void h(AdsDTO adsDTO, String zipPath, g listener) {
        Intrinsics.g(zipPath, "zipPath");
        Intrinsics.g(listener, "listener");
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f.b(com.cloud.sdk.commonutil.util.f.a()));
        String str = File.separator;
        sb2.append(str);
        sb2.append("interactive_zip");
        sb2.append(str);
        sb2.append(jCurrentTimeMillis);
        String string = sb2.toString();
        if (new File(string).exists()) {
            if (!TextUtils.isEmpty(adsDTO != null ? adsDTO.getIndexLocation() : null)) {
                listener.a(true);
                return;
            }
        }
        d(adsDTO, zipPath, string, listener);
    }
}
