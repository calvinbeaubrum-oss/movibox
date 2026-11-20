package com.transsnet.downloader.manager;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.config.Config;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import tr.g;
import tr.j;

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
public interface a {

    /* JADX INFO: renamed from: com.transsnet.downloader.manager.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0624a {
        public static /* synthetic */ void a(a aVar, DownloadBean downloadBean, boolean z11, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resume");
            }
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            aVar.s(downloadBean, z11);
        }
    }

    void A();

    void B(j jVar);

    Object C(Continuation<? super Unit> continuation);

    void D(List<? extends DownloadBean> list);

    void E();

    void F(DownloadBean downloadBean);

    void G();

    Object a(String str, int i11, String str2, Continuation<? super String> continuation);

    void d();

    Object e(String str, Continuation<? super List<? extends DownloadBean>> continuation);

    void f(g gVar);

    String h(DownloadBean downloadBean);

    boolean i();

    void j(DownloadBean downloadBean);

    void k(DownloadBean downloadBean, Function1<? super Boolean, Unit> function1);

    void l(Config config);

    void m(g00.b bVar);

    void n();

    void o();

    void p(DownloadBean downloadBean);

    void q();

    void r(String str, Function1<? super DownloadBean, Unit> function1);

    void s(DownloadBean downloadBean, boolean z11);

    Object t(String str, int i11, int i12, Continuation<? super DownloadBean> continuation);

    void u(DownloadBean downloadBean);

    void v(g gVar);

    void w();

    Long x();

    void y(List<? extends DownloadBean> list, Function1<? super Boolean, Unit> function1);

    boolean z(DownloadBean downloadBean);
}
