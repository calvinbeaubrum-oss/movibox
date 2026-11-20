package jx;

import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.bean.GroupInfo;
import com.transsion.search.bean.HotSubject;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.hot.SearchHotFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f68176a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Group group, int i11, long j11, String str, String str2, String str3) {
            String groupId;
            HashMap map = new HashMap();
            map.put("event_type", "result_item_browse");
            String str4 = "";
            if (str == null) {
                str = "";
            }
            map.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            map.put("search_from", str2);
            map.put("index", String.valueOf(i11));
            map.put("tabId", String.valueOf(str3));
            map.put("duration", String.valueOf(j11));
            if (group != null && (groupId = group.getGroupId()) != null) {
                str4 = groupId;
            }
            map.put("group_id", str4);
            map.put("hasJoin", String.valueOf(group != null ? group.getHasJoin() : null));
            com.transsion.baselib.helper.a.f51183a.d("searchresult", map);
        }

        public final void b(Group group, int i11, String str, String str2, String str3) {
            String groupId;
            HashMap map = new HashMap();
            map.put("event_type", "result_item_click");
            String str4 = "";
            if (str == null) {
                str = "";
            }
            map.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            map.put("search_from", str2);
            map.put("index", String.valueOf(i11));
            map.put("tabId", String.valueOf(str3));
            if (group != null && (groupId = group.getGroupId()) != null) {
                str4 = groupId;
            }
            map.put("group_id", str4);
            map.put("hasJoin", String.valueOf(group != null ? group.getHasJoin() : null));
            com.transsion.baselib.helper.a.f51183a.e("searchresult", map);
        }

        public final void c() {
            com.transsion.baselib.helper.a.f51183a.e(SearchHotFragment.PAGE_NAME, r.f(TuplesKt.a("event_type", "history_delete")));
        }

        public final void d(boolean z11) {
            HashMap map = new HashMap();
            map.put("isExpand", String.valueOf(z11));
            map.put("event_type", "history_expand");
            com.transsion.baselib.helper.a.f51183a.e(SearchHotFragment.PAGE_NAME, map);
        }

        public final void e(String str, int i11) {
            HashMap map = new HashMap();
            if (str == null) {
                str = "";
            }
            map.put("keyword", str);
            map.put("index", String.valueOf(i11));
            map.put("event_type", "history_browse");
            com.transsion.baselib.helper.a.f51183a.a(SearchHotFragment.PAGE_NAME, map);
        }

        public final void f(String keyWord, int i11) {
            Intrinsics.g(keyWord, "keyWord");
            HashMap map = new HashMap();
            map.put("keyword", keyWord);
            map.put("index", String.valueOf(i11));
            map.put("event_type", "history_click");
            com.transsion.baselib.helper.a.f51183a.e(SearchHotFragment.PAGE_NAME, map);
        }

        public final void g(String str, int i11) {
            HashMap map = new HashMap();
            if (str == null) {
                str = "";
            }
            map.put("keyword", str);
            map.put("index", String.valueOf(i11));
            map.put("event_type", "hot_word_browse");
            com.transsion.baselib.helper.a.f51183a.d(SearchHotFragment.PAGE_NAME, map);
        }

        public final void h(String keyword, int i11) {
            Intrinsics.g(keyword, "keyword");
            HashMap map = new HashMap();
            map.put("keyword", keyword);
            map.put("index", String.valueOf(i11));
            map.put("event_type", "hot_word_click");
            com.transsion.baselib.helper.a.f51183a.e(SearchHotFragment.PAGE_NAME, map);
        }

        public final void i(String str, String str2) {
            HashMap map = new HashMap();
            if (str == null) {
                str = "";
            }
            map.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            map.put("search_from", str2);
            map.put("event_type", "result_empty");
            com.transsion.baselib.helper.a.f51183a.d("searchresult", map);
        }

        public final void j(VerticalRank verticalRank, int i11, long j11, String str, String str2, String str3) {
            String title;
            HashMap map = new HashMap();
            map.put("event_type", "result_item_browse");
            String str4 = "";
            if (str == null) {
                str = "";
            }
            map.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            map.put("search_from", str2);
            map.put("index", String.valueOf(i11));
            map.put("tabId", String.valueOf(str3));
            map.put("duration", String.valueOf(j11));
            if (verticalRank != null && (title = verticalRank.getTitle()) != null) {
                str4 = title;
            }
            map.put("rank_title", str4);
            com.transsion.baselib.helper.a.f51183a.d("searchresult", map);
        }

        public final void k(VerticalRank verticalRank, int i11, String str, String str2, String str3) {
            String title;
            HashMap map = new HashMap();
            map.put("event_type", "result_item_click");
            String str4 = "";
            if (str == null) {
                str = "";
            }
            map.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            map.put("search_from", str2);
            map.put("index", String.valueOf(i11));
            map.put("tabId", String.valueOf(str3));
            if (verticalRank != null && (title = verticalRank.getTitle()) != null) {
                str4 = title;
            }
            map.put("rank_title", str4);
            com.transsion.baselib.helper.a.f51183a.e("searchresult", map);
        }

        public final void l(GroupInfo group, int i11, String parentCategory, int i12, boolean z11) {
            Intrinsics.g(group, "group");
            Intrinsics.g(parentCategory, "parentCategory");
            HashMap map = new HashMap();
            map.put("event_type", "hot_rank_browse");
            map.put("group_id", group.getGroupId());
            map.put("ops", group.getOps());
            map.put("index", String.valueOf(i11));
            map.put("lowMemoryDevice", String.valueOf(z11));
            map.put("parentTitle", parentCategory);
            map.put("parentIndex", String.valueOf(i12));
            com.transsion.baselib.helper.a.f51183a.a(SearchHotFragment.PAGE_NAME, map);
        }

        public final void m(HotSubject hotSubject, int i11, String parentCategory, int i12, boolean z11) {
            Intrinsics.g(hotSubject, "hotSubject");
            Intrinsics.g(parentCategory, "parentCategory");
            HashMap map = new HashMap();
            map.put("event_type", "hot_rank_browse");
            String subjectId = hotSubject.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            map.put("subject_id", subjectId);
            map.put("index", String.valueOf(i11));
            map.put("subject_type", String.valueOf(hotSubject.getSubjectType()));
            String ops = hotSubject.getOps();
            map.put("ops", ops != null ? ops : "");
            map.put("lowMemoryDevice", String.valueOf(z11));
            map.put("parentTitle", parentCategory);
            map.put("parentIndex", String.valueOf(i12));
            com.transsion.baselib.helper.a.f51183a.a(SearchHotFragment.PAGE_NAME, map);
        }

        public final void n(String str, String str2, long j11, int i11) {
            HashMap map = new HashMap();
            map.put("event_type", "result_scroll_skip");
            if (str2 == null) {
                str2 = "";
            }
            map.put("keyword", str2);
            map.put("tabId", String.valueOf(str));
            map.put("skip_item", String.valueOf(j11));
            map.put("fromIndex", String.valueOf(i11));
            com.transsion.baselib.helper.a.f51183a.e("searchresult", map);
        }

        public final void o(Staff staff, int i11, long j11, String str, String str2, String str3) {
            String staffId;
            String ops;
            HashMap map = new HashMap();
            map.put("event_type", "result_item_browse");
            String str4 = "";
            if (str == null) {
                str = "";
            }
            map.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            map.put("search_from", str2);
            map.put("index", String.valueOf(i11));
            map.put("tabId", String.valueOf(str3));
            map.put("duration", String.valueOf(j11));
            if (staff == null || (staffId = staff.getStaffId()) == null) {
                staffId = "";
            }
            map.put("staff_id", staffId);
            if (staff != null && (ops = staff.getOps()) != null) {
                str4 = ops;
            }
            map.put("ops", str4);
            com.transsion.baselib.helper.a.f51183a.d("searchresult", map);
        }

        public final void p(Staff staff, int i11, String str, String str2, String str3) {
            String staffId;
            String ops;
            HashMap map = new HashMap();
            map.put("event_type", "result_item_click");
            String str4 = "";
            if (str == null) {
                str = "";
            }
            map.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            map.put("search_from", str2);
            map.put("index", String.valueOf(i11));
            map.put("tabId", String.valueOf(str3));
            if (staff == null || (staffId = staff.getStaffId()) == null) {
                staffId = "";
            }
            map.put("staff_id", staffId);
            if (staff != null && (ops = staff.getOps()) != null) {
                str4 = ops;
            }
            map.put("ops", str4);
            com.transsion.baselib.helper.a.f51183a.e("searchresult", map);
        }

        public final void q(Subject subject, int i11, long j11, String str, String str2, String str3) {
            String subjectId;
            String ops;
            HashMap map = new HashMap();
            map.put("event_type", "result_item_browse");
            String str4 = "";
            if (str == null) {
                str = "";
            }
            map.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            map.put("search_from", str2);
            map.put("index", String.valueOf(i11));
            map.put("tabId", String.valueOf(str3));
            map.put("duration", String.valueOf(j11));
            if (subject == null || (subjectId = subject.getSubjectId()) == null) {
                subjectId = "";
            }
            map.put("subject_id", subjectId);
            map.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
            if (subject != null && (ops = subject.getOps()) != null) {
                str4 = ops;
            }
            map.put("ops", str4);
            com.transsion.baselib.helper.a.f51183a.d("searchresult", map);
        }

        public final void r(Subject subject, int i11, String str, String str2, String str3) {
            String subjectId;
            String ops;
            HashMap map = new HashMap();
            map.put("event_type", "result_item_click");
            String str4 = "";
            if (str == null) {
                str = "";
            }
            map.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            map.put("search_from", str2);
            map.put("index", String.valueOf(i11));
            map.put("tabId", String.valueOf(str3));
            if (subject == null || (subjectId = subject.getSubjectId()) == null) {
                subjectId = "";
            }
            map.put("subject_id", subjectId);
            map.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
            if (subject != null && (ops = subject.getOps()) != null) {
                str4 = ops;
            }
            map.put("ops", str4);
            com.transsion.baselib.helper.a.f51183a.e("searchresult", map);
        }

        public final void s(String str, String str2) {
            HashMap map = new HashMap();
            if (str == null) {
                str = "";
            }
            map.put("keyword", str);
            map.put("tabId", String.valueOf(str2));
            map.put("event_type", "result_tab_click");
            com.transsion.baselib.helper.a.f51183a.e("searchresult", map);
        }
    }
}
