package rw;

import com.transsion.home.p003enum.BottomTabType;
import kotlin.Metadata;

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
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f75743a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f75744b = true;

    public static /* synthetic */ void b(e eVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        eVar.a(str, str2);
    }

    public final void a(String str, String str2) {
        if (f75744b) {
            com.alibaba.android.arouter.launcher.a.d().b("/main/tab").withString("bottomTab", BottomTabType.TAB_CODE_COMMUNITY).withString("topTab", "Community").navigation();
        } else {
            com.alibaba.android.arouter.launcher.a.d().b("/room/home").withString("post_id", str).withString("ops", str2).navigation();
        }
    }

    public final void c(boolean z11) {
        f75744b = z11;
    }
}
