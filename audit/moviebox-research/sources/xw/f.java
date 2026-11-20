package xw;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.style.ImageSpan;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.facade.Postcard;
import com.transsion.baselib.utils.m;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.R$drawable;
import com.transsnet.downloader.DownloadManagerApi;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class f {
    public static final ImageSpan a(Context context, int i11) {
        Intrinsics.g(context, "context");
        return Build.VERSION.SDK_INT >= 29 ? new ImageSpan(context, i11, 2) : new ImageSpan(context, i11, 1);
    }

    public static final ImageSpan b(Context context) {
        Intrinsics.g(context, "context");
        int i11 = R$drawable.ic_search_result_split;
        return Build.VERSION.SDK_INT >= 29 ? new ImageSpan(context, i11, 2) : new ImageSpan(context, i11, 1);
    }

    public static final void c(Subject subject, String playModule) {
        Intrinsics.g(playModule, "playModule");
        if (subject == null) {
            return;
        }
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
        Integer subjectType = subject.getSubjectType();
        postcardB.withInt("subject_type", subjectType != null ? subjectType.intValue() : SubjectType.MOVIE.getValue()).withString("id", subject.getSubjectId()).withString("module_name", playModule).withInt("season", subject.getSeason()).withBoolean("autoPlay", true).withString("ops", subject.getOps()).navigation();
    }

    public static final String d(Subject subject, String pageName, Context context, String playModule) throws InterruptedException {
        String resourceLink;
        ResourceDetectors resourceDetector;
        String subjectId;
        ResourceDetectors resourceDetector2;
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(context, "context");
        Intrinsics.g(playModule, "playModule");
        if (subject != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi.f60274j.a().a2((FragmentActivity) context, pageName, (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : true, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                return "download_subject";
            }
        }
        if (m.f51320a.b()) {
            c(subject, playModule);
        } else {
            DownloadManagerApi.a aVar = DownloadManagerApi.f60274j;
            if (!DownloadManagerApi.n2(aVar.a(), subject != null ? subject.getSubjectId() : null, (subject == null || (resourceDetector2 = subject.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId(), subject != null && subject.isSeries(), false, 8, null)) {
                DownloadManagerApi downloadManagerApiA = aVar.a();
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                String ops = subject != null ? subject.getOps() : null;
                if (subject == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) {
                    resourceLink = "";
                }
                downloadManagerApiA.P1(fragmentActivity, subject, pageName, (960 & 8) != 0 ? "" : null, ops, resourceLink, (960 & 64) != 0 ? "" : null, (960 & 128) != 0 ? null : null, (960 & 256) != 0 ? null : null, (960 & 512) != 0 ? false : false);
                return "download_subject";
            }
            if (subject != null && (subjectId = subject.getSubjectId()) != null) {
                DownloadManagerApi.p2(aVar.a(), subjectId, context, pageName, null, 8, null);
            }
        }
        return "play_subject";
    }

    public static final boolean e(Resources resources) {
        Intrinsics.g(resources, "resources");
        return (resources.getConfiguration().screenLayout & 15) >= 3;
    }
}
