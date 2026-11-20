package tr;

import android.os.Environment;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f77264a = new a(0 == true ? 1 : 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f77265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f77266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f77267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final File f77268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f77269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f77270g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return b.f77267d;
        }

        public final String b() {
            return b.f77265b;
        }

        public final File c() {
            return b.f77268e;
        }

        public final String d() {
            return b.f77270g;
        }

        public final String e() {
            return b.f77266c;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String str = Environment.DIRECTORY_DCIM;
        String str2 = File.separator;
        f77265b = str + str2 + "MovieBox";
        f77266c = Environment.DIRECTORY_DOWNLOADS + str2 + "MovieBox";
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        char c11 = File.separatorChar;
        f77267d = absolutePath + c11 + Environment.DIRECTORY_DCIM + str2 + "MovieBox";
        File externalFilesDir = Utils.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        f77268e = externalFilesDir;
        f77269f = Environment.getExternalStorageDirectory().getAbsolutePath() + c11 + "OneRoom";
        f77270g = (externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null) + c11 + DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D;
    }
}
