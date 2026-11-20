package pr;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.banner.OpSubBannerNew;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.report.m;
import com.transsion.bean.AhaGameAllGames;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.moviedetailapi.bean.AppointSubject;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.LiveListItem;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PlayListItem;
import com.transsion.moviedetailapi.bean.PlayListType;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.shorttv.widget.ShortTVHistoryView;
import com.transsion.web.api.WebConstants;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f74040a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashSet<String> f74041b = new HashSet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashSet<String> f74042c = new HashSet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashSet<Integer> f74043d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashSet<String> f74044e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashSet<String> f74045f = new HashSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashSet<String> f74046g = new HashSet<>();

    public final void A(OperateItem operateItem, Staff item, int i11) {
        Intrinsics.g(operateItem, "operateItem");
        Intrinsics.g(item, "item");
        Map<String, String> mapB = b(operateItem, null, Integer.valueOf(i11));
        mapB.put("staff_id", String.valueOf(item.getStaffId()));
        com.transsion.baselib.helper.a.f51183a.e(HomeTabType.TAB_CODE_TRENDING, mapB);
    }

    public final void B(OperateItem operateItem, long j11, int i11, Subject subject, String str) {
        Map<String, String> mapB = b(operateItem, Long.valueOf(j11), Integer.valueOf(i11));
        mapB.put("subject_id", String.valueOf(subject.getSubjectId()));
        com.transsion.baselib.helper.a.f51183a.d(str, mapB);
    }

    public final void a() {
        f74041b.clear();
        f74042c.clear();
        f74043d.clear();
        f74044e.clear();
    }

    public final Map<String, String> b(OperateItem operateItem, Long l11, Integer num) {
        String ops;
        String label;
        String category;
        String recType;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String type = operateItem.getType();
        if (type == null) {
            type = "";
        }
        linkedHashMap.put("opt_type", type);
        PlayListItem playListData = operateItem.getPlayListData();
        if (playListData == null || (ops = playListData.getOps()) == null) {
            ops = "";
        }
        linkedHashMap.put("ops", ops);
        if (num != null) {
            int iIntValue = num.intValue();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(iIntValue);
            linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        }
        if (l11 != null) {
            long jLongValue = l11.longValue();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(jLongValue);
            linkedHashMap.put("browse_duration", sb3.toString());
        }
        PlayListItem playListData2 = operateItem.getPlayListData();
        linkedHashMap.put("id", String.valueOf(playListData2 != null ? playListData2.getId() : null));
        PlayListItem playListData3 = operateItem.getPlayListData();
        if (playListData3 == null || (label = playListData3.getLabel()) == null) {
            label = "";
        }
        linkedHashMap.put("label", label);
        PlayListItem playListData4 = operateItem.getPlayListData();
        if (playListData4 == null || (category = playListData4.getCategory()) == null) {
            category = "";
        }
        linkedHashMap.put("category", category);
        PlayListItem playListData5 = operateItem.getPlayListData();
        if (playListData5 == null || (recType = playListData5.getRecType()) == null) {
            recType = "";
        }
        linkedHashMap.put("rec_type", recType);
        String title = operateItem.getTitle();
        linkedHashMap.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
        return linkedHashMap;
    }

    public final void c(OperateItem operateItem, String str, List<BannerData> bannerData, long j11, int i11) {
        Intrinsics.g(operateItem, "operateItem");
        Intrinsics.g(bannerData, "bannerData");
        HashSet<String> hashSet = f74046g;
        if (CollectionsKt___CollectionsKt.X(hashSet, operateItem.getOpId())) {
            return;
        }
        String opId = operateItem.getOpId();
        if (opId == null) {
            opId = "";
        }
        hashSet.add(opId);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("opt_type", str);
        String opId2 = operateItem.getOpId();
        if (opId2 == null) {
            opId2 = "";
        }
        linkedHashMap.put("op_id", opId2);
        String title = operateItem.getTitle();
        linkedHashMap.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        linkedHashMap.put("browse_duration", String.valueOf(j11));
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        int i12 = 0;
        for (Object obj : bannerData) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                g.u();
            }
            BannerData bannerData2 = (BannerData) obj;
            String subjectId = bannerData2 != null ? bannerData2.getSubjectId() : null;
            if (subjectId == null || subjectId.length() == 0) {
                sb4.append(bannerData2 != null ? bannerData2.getDeepLink() : null);
                sb4.append(",");
            } else {
                sb3.append(bannerData2 != null ? bannerData2.getSubjectId() : null);
                sb3.append(",");
            }
            i12 = i13;
        }
        String string = sb3.toString();
        Intrinsics.f(string, "subjectIds.toString()");
        linkedHashMap.put("subject_ids", StringsKt__StringsKt.b1(string, ','));
        String string2 = sb4.toString();
        Intrinsics.f(string2, "deeplinks.toString()");
        linkedHashMap.put("deeplinks", StringsKt__StringsKt.b1(string2, ','));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008a A[RETURN] */
    public final void d(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, String str7, Integer num, String str8, long j11, Boolean bool2, String str9, String str10, String str11) {
        boolean zContains;
        String str12 = str4;
        String str13 = str5;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", str2 == null ? "" : str2);
        linkedHashMap.put("opt_type", str3 == null ? "" : str3);
        if (Intrinsics.b(str3, OpSubBannerNew.OP_GROUPS)) {
            if (str13 != null) {
                HashSet<String> hashSet = f74041b;
                zContains = hashSet.contains(str5);
                hashSet.add(str5);
                if (zContains) {
                    return;
                }
            }
        } else if (Intrinsics.b(str3, PostItemType.RANKING_MOVIE_HORIZONTAL.getValue()) || Intrinsics.b(str3, PostItemType.OP_SUBJECTS_MOVIE.getValue())) {
            if (str12 != null) {
                HashSet<String> hashSet2 = f74042c;
                zContains = hashSet2.contains(str4);
                hashSet2.add(str4);
                if (zContains) {
                    return;
                }
            }
        } else if (Intrinsics.b(str3, PostItemType.BANNER.getValue())) {
            if (num != null) {
                HashSet<Integer> hashSet3 = f74043d;
                zContains = hashSet3.contains(num);
                hashSet3.add(num);
                if (zContains) {
                    return;
                }
            }
        } else if (Intrinsics.b(str3, PostItemType.OP_RANKING.getValue()) && str12 != null) {
            HashSet<String> hashSet4 = f74044e;
            zContains = hashSet4.contains(str4);
            hashSet4.add(str4);
            if (zContains) {
                return;
            }
        }
        if (str12 == null) {
            str12 = "";
        }
        linkedHashMap.put("subject_id", str12);
        if (str13 == null) {
            str13 = "";
        }
        linkedHashMap.put("group_id", str13);
        linkedHashMap.put("ops", str6 == null ? "" : str6);
        linkedHashMap.put("has_resource", String.valueOf(bool));
        linkedHashMap.put(WebConstants.FIELD_DEEPLINK, str7);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        linkedHashMap.put("cover", str8);
        linkedHashMap.put("browse_duration", String.valueOf(j11));
        linkedHashMap.put("builtin", Intrinsics.b(bool2, Boolean.TRUE) ? "1" : "0");
        linkedHashMap.put("tag", String.valueOf(str9));
        linkedHashMap.put("opTitle", str10 == null ? "" : str10);
        linkedHashMap.put("opId", str11 == null ? "" : str11);
        com.transsion.baselib.helper.a.f51183a.d(str != null ? str : "", linkedHashMap);
    }

    public final void f(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, Integer num, String str8, Boolean bool3, String str9, String str10, String str11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", str2 == null ? "" : str2);
        linkedHashMap.put("opt_type", str3 == null ? "" : str3);
        linkedHashMap.put("subject_id", str4 == null ? "" : str4);
        linkedHashMap.put("group_id", str5 == null ? "" : str5);
        linkedHashMap.put("ops", str6 == null ? "" : str6);
        linkedHashMap.put("has_resource", String.valueOf(bool));
        linkedHashMap.put("check_in", String.valueOf(bool2));
        linkedHashMap.put(WebConstants.FIELD_DEEPLINK, str7);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        linkedHashMap.put("cover", str8);
        linkedHashMap.put("builtin", Intrinsics.b(bool3, Boolean.TRUE) ? "1" : "0");
        linkedHashMap.put("tag", String.valueOf(str9));
        linkedHashMap.put("opTitle", str10 == null ? "" : str10);
        linkedHashMap.put("opId", str11 == null ? "" : str11);
        com.transsion.baselib.helper.a.f51183a.e(str != null ? str : "", linkedHashMap);
    }

    public final void h(AhaGameAllGames game, int i11) {
        Intrinsics.g(game, "game");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", PostItemType.GAME_LIST.getValue());
        linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i11));
        linkedHashMap.put("id", String.valueOf(game.getId()));
        linkedHashMap.put("name", String.valueOf(game.getName()));
        linkedHashMap.put("link", String.valueOf(game.getLink()));
        com.transsion.baselib.helper.a.f51183a.e(HomeTabType.TAB_CODE_TRENDING, linkedHashMap);
    }

    public final void i() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", PostItemType.GAME_LIST.getValue());
        linkedHashMap.put("module_name", "must_play_game");
        com.transsion.baselib.helper.a.f51183a.f(HomeTabType.TAB_CODE_TRENDING, linkedHashMap);
    }

    public final void j(VideoDetailPlayBean videoDetailPlayBean, int i11) {
        String subjectId;
        String playMode;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", ShortTVHistoryView.TYPE_HISTORY);
        linkedHashMap.put("opt_type", "Honor_History");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        String str = "";
        if (videoDetailPlayBean == null || (subjectId = videoDetailPlayBean.getSubjectId()) == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        if (videoDetailPlayBean != null && (playMode = videoDetailPlayBean.getPlayMode()) != null) {
            str = playMode;
        }
        linkedHashMap.put("play_mode", str);
        m.f51277a.t(HomeTabType.TAB_CODE_TRENDING, "browse", linkedHashMap);
    }

    public final void k(VideoDetailPlayBean videoDetailPlayBean, int i11) {
        String subjectId;
        String playMode;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", ShortTVHistoryView.TYPE_HISTORY);
        linkedHashMap.put("opt_type", "Honor_History");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        String str = "";
        if (videoDetailPlayBean == null || (subjectId = videoDetailPlayBean.getSubjectId()) == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        if (videoDetailPlayBean != null && (playMode = videoDetailPlayBean.getPlayMode()) != null) {
            str = playMode;
        }
        linkedHashMap.put("play_mode", str);
        m.f51277a.m(HomeTabType.TAB_CODE_TRENDING, "click", linkedHashMap);
    }

    public final void l(int i11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", ShortTVHistoryView.TYPE_HISTORY);
        linkedHashMap.put("opt_type", "Honor_History_View_All");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        m.f51277a.t(HomeTabType.TAB_CODE_TRENDING, "browse", linkedHashMap);
    }

    public final void m(int i11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", ShortTVHistoryView.TYPE_HISTORY);
        linkedHashMap.put("opt_type", "Honor_History_View_All");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        m.f51277a.m(HomeTabType.TAB_CODE_TRENDING, "click", linkedHashMap);
    }

    public final void n(Subject subject, int i11) {
        String subjectId;
        String ops;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "rec");
        linkedHashMap.put("opt_type", "Honor_History_Rec");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        String str = "";
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        if (subject != null && (ops = subject.getOps()) != null) {
            str = ops;
        }
        linkedHashMap.put("ops", str);
        m.f51277a.t(HomeTabType.TAB_CODE_TRENDING, "browse", linkedHashMap);
    }

    public final void o(Subject subject, int i11) {
        String subjectId;
        String ops;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "rec");
        linkedHashMap.put("opt_type", "Honor_History_Rec");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        String str = "";
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        if (subject != null && (ops = subject.getOps()) != null) {
            str = ops;
        }
        linkedHashMap.put("ops", str);
        m.f51277a.m(HomeTabType.TAB_CODE_TRENDING, "click", linkedHashMap);
    }

    public final void p(int i11, long j11, OperateItem operateItem) {
        String type;
        String opId;
        String title;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str = "";
        if (operateItem == null || (type = operateItem.getType()) == null) {
            type = "";
        }
        linkedHashMap.put("opt_type", type);
        if (operateItem == null || (opId = operateItem.getOpId()) == null) {
            opId = "";
        }
        linkedHashMap.put("opId", opId);
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str = title;
        }
        linkedHashMap.put("opTitle", str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        linkedHashMap.put("browse_duration", String.valueOf(j11));
        m.f51277a.t(HomeTabType.TAB_CODE_TRENDING, "browse", linkedHashMap);
    }

    public final void q(int i11, OperateItem operateItem) {
        String type;
        String opId;
        String title;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str = "";
        if (operateItem == null || (type = operateItem.getType()) == null) {
            type = "";
        }
        linkedHashMap.put("opt_type", type);
        if (operateItem == null || (opId = operateItem.getOpId()) == null) {
            opId = "";
        }
        linkedHashMap.put("opId", opId);
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str = title;
        }
        linkedHashMap.put("opTitle", str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        m.f51277a.m(HomeTabType.TAB_CODE_TRENDING, "click", linkedHashMap);
    }

    public final void r(Subject subject, int i11, OperateItem operateItem) {
        String type;
        String opId;
        String title;
        Intrinsics.g(subject, "subject");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str = "";
        if (operateItem == null || (type = operateItem.getType()) == null) {
            type = "";
        }
        linkedHashMap.put("opt_type", type);
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        String ops = subject.getOps();
        if (ops == null) {
            ops = "";
        }
        linkedHashMap.put("ops", ops);
        linkedHashMap.put("has_resource", String.valueOf(subject.getHasResource()));
        if (operateItem == null || (opId = operateItem.getOpId()) == null) {
            opId = "";
        }
        linkedHashMap.put("opId", opId);
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str = title;
        }
        linkedHashMap.put("opTitle", str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        m.f51277a.t(HomeTabType.TAB_CODE_TRENDING, "browse", linkedHashMap);
    }

    public final void s(Subject subject, int i11, OperateItem operateItem) {
        String type;
        String opId;
        String title;
        Intrinsics.g(subject, "subject");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str = "";
        if (operateItem == null || (type = operateItem.getType()) == null) {
            type = "";
        }
        linkedHashMap.put("opt_type", type);
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        String ops = subject.getOps();
        if (ops == null) {
            ops = "";
        }
        linkedHashMap.put("ops", ops);
        linkedHashMap.put("has_resource", String.valueOf(subject.getHasResource()));
        if (operateItem == null || (opId = operateItem.getOpId()) == null) {
            opId = "";
        }
        linkedHashMap.put("opId", opId);
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str = title;
        }
        linkedHashMap.put("opTitle", str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        m.f51277a.m(HomeTabType.TAB_CODE_TRENDING, "click", linkedHashMap);
    }

    public final void t(OperateItem operateItem, Integer num) {
        String type;
        String deepLink;
        String opId;
        String title;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str = "";
        if (operateItem == null || (type = operateItem.getType()) == null) {
            type = "";
        }
        linkedHashMap.put("opt_type", type + "_RANK_MORE");
        if (operateItem == null || (deepLink = operateItem.getDeepLink()) == null) {
            deepLink = "";
        }
        linkedHashMap.put(WebConstants.FIELD_DEEPLINK, deepLink);
        if (operateItem == null || (opId = operateItem.getOpId()) == null) {
            opId = "";
        }
        linkedHashMap.put("op_id", opId);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str = title;
        }
        linkedHashMap.put("opTitle", str);
        m.f51277a.m(HomeTabType.TAB_CODE_TRENDING, "click", linkedHashMap);
    }

    public final void u(OperateItem operateItem, long j11, int i11, String pageName) {
        List<Staff> staffs;
        List<Staff> staffs2;
        Intrinsics.g(operateItem, "operateItem");
        Intrinsics.g(pageName, "pageName");
        Map<String, String> mapB = b(operateItem, Long.valueOf(j11), Integer.valueOf(i11));
        StringBuilder sb2 = new StringBuilder();
        PlayListItem playListData = operateItem.getPlayListData();
        int i12 = 0;
        if (Intrinsics.b(playListData != null ? playListData.getCategory() : null, PlayListType.CAST.getValue())) {
            PlayListItem playListData2 = operateItem.getPlayListData();
            if (playListData2 != null && (staffs2 = playListData2.getStaffs()) != null) {
                int i13 = 0;
                for (Object obj : staffs2) {
                    int i14 = i13 + 1;
                    if (i13 < 0) {
                        g.u();
                    }
                    sb2.append(((Staff) obj).getStaffId());
                    sb2.append(",");
                    i13 = i14;
                }
            }
        } else {
            List<AppointSubject> subjects = operateItem.getSubjects();
            if (subjects != null) {
                int i15 = 0;
                for (Object obj2 : subjects) {
                    int i16 = i15 + 1;
                    if (i15 < 0) {
                        g.u();
                    }
                    sb2.append(((AppointSubject) obj2).getSubjectId());
                    sb2.append(",");
                    i15 = i16;
                }
            }
        }
        int iLastIndexOf = sb2.lastIndexOf(",");
        if (iLastIndexOf != -1) {
            sb2.deleteCharAt(iLastIndexOf);
        }
        String string = sb2.toString();
        Intrinsics.f(string, "sb.toString()");
        mapB.put("play_list_ids", string);
        PlayListItem playListData3 = operateItem.getPlayListData();
        sb2.append(playListData3 != null ? playListData3.getId() : null);
        String string2 = sb2.toString();
        Intrinsics.f(string2, "sb.append(operateItem.playListData?.id).toString()");
        HashSet<String> hashSet = f74045f;
        if (hashSet.contains(string2)) {
            return;
        }
        hashSet.add(string2);
        PlayListItem playListData4 = operateItem.getPlayListData();
        if (Intrinsics.b(playListData4 != null ? playListData4.getCategory() : null, PlayListType.CAST.getValue())) {
            PlayListItem playListData5 = operateItem.getPlayListData();
            if (playListData5 != null && (staffs = playListData5.getStaffs()) != null) {
                for (Object obj3 : staffs) {
                    int i17 = i12 + 1;
                    if (i12 < 0) {
                        g.u();
                    }
                    f74040a.z(operateItem, j11, i12, (Staff) obj3, pageName);
                    i12 = i17;
                }
            }
        } else {
            List<AppointSubject> subjects2 = operateItem.getSubjects();
            if (subjects2 != null) {
                for (Object obj4 : subjects2) {
                    int i18 = i12 + 1;
                    if (i12 < 0) {
                        g.u();
                    }
                    f74040a.B(operateItem, j11, i12, (AppointSubject) obj4, pageName);
                    i12 = i18;
                }
            }
        }
        com.transsion.baselib.helper.a.f51183a.d(pageName, mapB);
    }

    public final void v(OperateItem operateItem, Subject item, int i11, int i12, String pageName) {
        Intrinsics.g(operateItem, "operateItem");
        Intrinsics.g(item, "item");
        Intrinsics.g(pageName, "pageName");
        Map<String, String> mapB = b(operateItem, null, Integer.valueOf(i11));
        mapB.put("subject_id", String.valueOf(item.getSubjectId()));
        mapB.put("tab_id", String.valueOf(i12));
        com.transsion.baselib.helper.a.f51183a.e(pageName, mapB);
    }

    public final void w(OperateItem operateItem, String pageName) {
        List<Staff> staffs;
        Intrinsics.g(operateItem, "operateItem");
        Intrinsics.g(pageName, "pageName");
        Map<String, String> mapB = b(operateItem, null, null);
        StringBuilder sb2 = new StringBuilder();
        PlayListItem playListData = operateItem.getPlayListData();
        String category = playListData != null ? playListData.getCategory() : null;
        int i11 = 0;
        if (Intrinsics.b(category, PlayListType.CAST.getValue())) {
            PlayListItem playListData2 = operateItem.getPlayListData();
            if (playListData2 != null && (staffs = playListData2.getStaffs()) != null) {
                for (Object obj : staffs) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        g.u();
                    }
                    sb2.append(((Staff) obj).getStaffId());
                    sb2.append(",");
                    i11 = i12;
                }
            }
        } else {
            List<AppointSubject> subjects = operateItem.getSubjects();
            if (subjects != null) {
                for (Object obj2 : subjects) {
                    int i13 = i11 + 1;
                    if (i11 < 0) {
                        g.u();
                    }
                    sb2.append(((AppointSubject) obj2).getSubjectId());
                    sb2.append(",");
                    i11 = i13;
                }
            }
        }
        int iLastIndexOf = sb2.lastIndexOf(",");
        if (iLastIndexOf != -1) {
            sb2.deleteCharAt(iLastIndexOf);
        }
        String string = sb2.toString();
        Intrinsics.f(string, "sb.toString()");
        mapB.put("play_list_ids", string);
        mapB.put("module_name", "check_full_list");
        com.transsion.baselib.helper.a.f51183a.h(pageName, mapB);
    }

    public final void x(OperateItem operateItem, String str, List<? extends Subject> subjects, long j11, int i11) {
        Intrinsics.g(operateItem, "operateItem");
        Intrinsics.g(subjects, "subjects");
        HashSet<String> hashSet = f74046g;
        if (CollectionsKt___CollectionsKt.X(hashSet, operateItem.getOpId())) {
            return;
        }
        String opId = operateItem.getOpId();
        if (opId == null) {
            opId = "";
        }
        hashSet.add(opId);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("opt_type", str);
        String opId2 = operateItem.getOpId();
        if (opId2 == null) {
            opId2 = "";
        }
        linkedHashMap.put("op_id", opId2);
        StringBuilder sb2 = new StringBuilder();
        int i12 = 0;
        for (Object obj : subjects) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                g.u();
            }
            sb2.append(((Subject) obj).getSubjectId());
            sb2.append(",");
            i12 = i13;
        }
        String string = sb2.toString();
        Intrinsics.f(string, "sb.toString()");
        linkedHashMap.put("subject_ids", StringsKt__StringsKt.b1(string, ','));
        String title = operateItem.getTitle();
        linkedHashMap.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb3.toString());
        linkedHashMap.put("browse_duration", String.valueOf(j11));
        com.transsion.baselib.helper.a.f51183a.d(HomeTabType.TAB_CODE_TRENDING, linkedHashMap);
    }

    public final void y(OperateItem operateItem, String str, List<LiveListItem> liveList, long j11, int i11) {
        Intrinsics.g(operateItem, "operateItem");
        Intrinsics.g(liveList, "liveList");
        HashSet<String> hashSet = f74046g;
        if (CollectionsKt___CollectionsKt.X(hashSet, operateItem.getOpId())) {
            return;
        }
        String opId = operateItem.getOpId();
        if (opId == null) {
            opId = "";
        }
        hashSet.add(opId);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("opt_type", str);
        String opId2 = operateItem.getOpId();
        if (opId2 == null) {
            opId2 = "";
        }
        linkedHashMap.put("op_id", opId2);
        String title = operateItem.getTitle();
        linkedHashMap.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
        StringBuilder sb2 = new StringBuilder();
        int i12 = 0;
        for (Object obj : liveList) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                g.u();
            }
            sb2.append(((LiveListItem) obj).getMatchId());
            sb2.append(",");
            i12 = i13;
        }
        String string = sb2.toString();
        Intrinsics.f(string, "sb.toString()");
        linkedHashMap.put("match_ids", StringsKt__StringsKt.b1(string, ','));
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i11);
        linkedHashMap.put(RequestParameters.POSITION, sb3.toString());
        linkedHashMap.put("browse_duration", String.valueOf(j11));
        com.transsion.baselib.helper.a.f51183a.d(HomeTabType.TAB_CODE_TRENDING, linkedHashMap);
    }

    public final void z(OperateItem operateItem, long j11, int i11, Staff staff, String str) {
        Map<String, String> mapB = b(operateItem, Long.valueOf(j11), Integer.valueOf(i11));
        mapB.put("staff_id", String.valueOf(staff.getStaffId()));
        com.transsion.baselib.helper.a.f51183a.d(str, mapB);
    }
}
