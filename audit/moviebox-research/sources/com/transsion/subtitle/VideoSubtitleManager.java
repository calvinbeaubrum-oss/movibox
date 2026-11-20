package com.transsion.subtitle;

import com.transsion.baselib.db.download.DownloadBean;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface VideoSubtitleManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f58109a = Companion.f58110a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f58110a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<VideoSubtitleManagerImp> f58111b = LazyKt__LazyJVMKt.b(new Function0<VideoSubtitleManagerImp>() { // from class: com.transsion.subtitle.VideoSubtitleManager$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VideoSubtitleManagerImp invoke() {
                return new VideoSubtitleManagerImp();
            }
        });

        public final VideoSubtitleManager a() {
            return f58111b.getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(VideoSubtitleManager videoSubtitleManager, DownloadBean downloadBean, Function1 function1, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVideoPageInNet2CheckSubtitle");
            }
            if ((i11 & 2) != 0) {
                function1 = null;
            }
            videoSubtitleManager.d(downloadBean, function1);
        }
    }

    Object a(String str, Continuation<? super List<vx.a>> continuation);

    void b(vx.a aVar);

    void c(DownloadBean downloadBean);

    void d(DownloadBean downloadBean, Function1<? super Boolean, Unit> function1);

    void destroy();

    void e(com.transsion.subtitle_download.a aVar);

    void f(vx.a aVar);

    void g(vx.a aVar);

    void h(xx.c cVar);

    void i(xx.c cVar);

    void init();

    void j(com.transsion.subtitle_download.a aVar);

    void reset();
}
