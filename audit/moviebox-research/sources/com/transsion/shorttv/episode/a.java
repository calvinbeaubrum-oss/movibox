package com.transsion.shorttv.episode;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.db.video.ShortTVPlayBean;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.shorttv.source.ShortTvInfoEpisodeList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

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

    /* JADX INFO: renamed from: com.transsion.shorttv.episode.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0597a {
        public static /* synthetic */ Object a(a aVar, String str, int i11, int i12, int i13, String str2, Continuation continuation, int i14, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShortTvEpisodeList");
            }
            int i15 = (i14 & 8) != 0 ? 1 : i13;
            if ((i14 & 16) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return aVar.a(str, i11, i12, i15, str2, continuation);
        }

        public static boolean b(a aVar) {
            return false;
        }
    }

    Object a(String str, int i11, int i12, int i13, String str2, Continuation<? super BaseDto<ShortTvInfoEpisodeList>> continuation);

    boolean b();

    void c(ShortTvEpisodeListDialog shortTvEpisodeListDialog, Subject subject, qx.d dVar, int i11, int i12);

    Object d(String str, Continuation<? super ShortTVPlayBean> continuation);

    b e();

    int f();

    Object g(Subject subject, ShortTVItem shortTVItem, long j11, Continuation<? super Unit> continuation);

    int h(int i11, ShortTVPlayBean shortTVPlayBean, Subject subject, int i12, boolean z11);
}
