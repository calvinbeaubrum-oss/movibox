package ct;

import com.transsion.moviedetailapi.bean.Subject;
import java.util.HashMap;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {
    public static final void a(Subject subject, String pageName, String moduleName) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(moduleName, "moduleName");
        if (subject == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("event_type", "click_rank_list_item");
        map.put("module_name", moduleName);
        map.put("seenStatus", String.valueOf(subject.getSeenStatus()));
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        map.put("subject_id", subjectId);
        map.put("has_resource", String.valueOf(subject.getHasResource()));
        map.put("subject_type", String.valueOf(subject.getSubjectType()));
        String ops = subject.getOps();
        map.put("ops", ops != null ? ops : "");
        map.put("tag", String.valueOf(subject.getTags()));
        com.transsion.baselib.helper.a.f51183a.d(pageName, map);
    }

    public static final void b(Subject subject, String pageName, String moduleName) {
        String subjectId;
        String ops;
        Integer seenStatus;
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(moduleName, "moduleName");
        HashMap map = new HashMap();
        map.put("event_type", (subject == null || (seenStatus = subject.getSeenStatus()) == null || seenStatus.intValue() != 1) ? "click_course_subscribe" : "click_course_unsubscribe");
        map.put("module_name", moduleName);
        String str = "";
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            subjectId = "";
        }
        map.put("subject_id", subjectId);
        map.put("has_resource", String.valueOf(subject != null ? subject.getHasResource() : null));
        map.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
        if (subject != null && (ops = subject.getOps()) != null) {
            str = ops;
        }
        map.put("ops", str);
        map.put("tag", String.valueOf(subject != null ? subject.getTags() : null));
        map.put("seenStatus", String.valueOf(subject != null ? subject.getSeenStatus() : null));
        com.transsion.baselib.helper.a.f51183a.b(pageName, map);
    }
}
