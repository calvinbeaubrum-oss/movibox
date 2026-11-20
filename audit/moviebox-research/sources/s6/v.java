package s6;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.work.WorkInfo;
import java.util.List;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"UnknownNullness"})
public interface v {
    List<u.c> A(String str);

    LiveData<List<u.c>> B(List<String> list);

    int C(String str);

    List<u.c> D(List<String> list);

    void a(String str);

    void b();

    void c(String str);

    List<u> d(long j11);

    void e(u uVar);

    List<u> f();

    List<String> g(String str);

    u.c h(String str);

    WorkInfo.State i(String str);

    u j(String str);

    void k(String str, long j11);

    List<String> l(String str);

    List<androidx.work.d> m(String str);

    List<u.c> n(String str);

    List<u> o(int i11);

    int p();

    void q(u uVar);

    int r(String str, long j11);

    List<u.b> s(String str);

    List<u> t(int i11);

    int u(WorkInfo.State state, String str);

    void v(String str, androidx.work.d dVar);

    List<u> w();

    List<String> x();

    boolean y();

    int z(String str);
}
