package wv;

import android.view.View;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.layer.local.LocalUiType;
import com.transsion.subtitle.VideoSubtitleControl;
import com.transsion.videofloat.bean.FloatActionType;
import java.util.Map;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface d {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static View a(d dVar) {
            return null;
        }

        public static void b(d dVar, View rootView, boolean z11) {
            Intrinsics.g(rootView, "rootView");
        }

        public static void c(d dVar, DownloadBean bean) {
            Intrinsics.g(bean, "bean");
        }

        public static void d(d dVar, boolean z11) {
        }

        public static void e(d dVar) {
        }

        public static void f(d dVar, LocalUiType newConfig) {
            Intrinsics.g(newConfig, "newConfig");
        }

        public static void g(d dVar) {
        }

        public static void h(d dVar, boolean z11, String requestKey) {
            Intrinsics.g(requestKey, "requestKey");
        }

        public static void i(d dVar) {
        }

        public static void j(d dVar, String subjectId, String resourceId) {
            Intrinsics.g(subjectId, "subjectId");
            Intrinsics.g(resourceId, "resourceId");
        }

        public static /* synthetic */ void k(d dVar, String str, long j11, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showToast");
            }
            if ((i11 & 2) != 0) {
                j11 = 3000;
            }
            dVar.j(str, j11);
        }

        public static void l(d dVar, PostSubjectItem postSubjectItem) {
        }

        public static void m(d dVar, int i11) {
        }

        public static void n(d dVar, float f11) {
        }
    }

    void A();

    void B(VideoSubtitleControl videoSubtitleControl);

    void C(int i11);

    void D(DownloadBean downloadBean);

    void a(LocalUiType localUiType);

    void b(boolean z11, boolean z12);

    void c();

    void d();

    void e(b bVar);

    boolean f(FloatActionType floatActionType);

    void g(boolean z11, String str);

    void h();

    void i(String str, String str2);

    boolean isVisible();

    void j(String str, long j11);

    void k(DownloadBean downloadBean, String str, boolean z11);

    void l(Map<Integer, Integer> map);

    void m(LocalUiType localUiType);

    void n();

    void o(float f11);

    void onBackPressed();

    void onViewPause();

    void onViewResume();

    void p(String str, String str2, String str3, boolean z11, boolean z12);

    void q(int i11, int i12);

    void r(View view, LocalUiType localUiType);

    void s();

    void t(boolean z11);

    void u(String str, String str2);

    void updateTitle(String str);

    void v(boolean z11);

    void w(PostSubjectItem postSubjectItem);

    void x(c cVar);

    void y(String str);

    void z(View view, boolean z11);
}
