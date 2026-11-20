package com.transsion.room.helper;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.transsion.baselib.report.m;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.web.api.WebConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.s;
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
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f57301a = new k();

    public final void a(String pageName) {
        Intrinsics.g(pageName, "pageName");
        m.f51277a.m(pageName, "click", s.l(TuplesKt.a("source", "my_room"), TuplesKt.a("module_name", "all")));
    }

    public final void b(String pageName, RoomItem item) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(item, "item");
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.a("source", "my_room");
        pairArr[1] = TuplesKt.a("module_name", WebConstants.FIELD_ITEM);
        String groupId = item.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        pairArr[2] = TuplesKt.a("group_id", groupId);
        pairArr[3] = TuplesKt.a("ops", item.getOps());
        m.f51277a.m(pageName, "click", s.l(pairArr));
    }

    public final void c(String pageName, String str) {
        Intrinsics.g(pageName, "pageName");
        m.f51277a.m(pageName, "click", s.l(TuplesKt.a("source", str), TuplesKt.a("module_name", "all")));
    }

    public final void d(String pageName, String moduleName, RoomItem item) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(moduleName, "moduleName");
        Intrinsics.g(item, "item");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.a("module_name", moduleName);
        String groupId = item.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        pairArr[1] = TuplesKt.a("group_id", groupId);
        pairArr[2] = TuplesKt.a("ops", item.getOps());
        m.f51277a.t(pageName, "browse", s.l(pairArr));
    }

    public final void e(String pageName, String str) {
        Intrinsics.g(pageName, "pageName");
        m.f51277a.m(pageName, "click", s.l(TuplesKt.a("source", str), TuplesKt.a("module_name", "explore")));
    }

    public final void f(String pageName, String str, RoomItem item) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(item, "item");
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.a("source", str);
        pairArr[1] = TuplesKt.a("module_name", WebConstants.FIELD_ITEM);
        String groupId = item.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        pairArr[2] = TuplesKt.a("group_id", groupId);
        pairArr[3] = TuplesKt.a("has_join", Intrinsics.b(item.getHasJoin(), Boolean.TRUE) ? "1" : "0");
        pairArr[4] = TuplesKt.a("ops", item.getOps());
        m.f51277a.m(pageName, "click", s.l(pairArr));
    }

    public final void g(String str, String pageName, int i11, long j11, RoomItem item) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(item, "item");
        Pair[] pairArr = new Pair[6];
        String groupId = item.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        pairArr[0] = TuplesKt.a("group_id", groupId);
        pairArr[1] = TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11));
        pairArr[2] = TuplesKt.a(WebConstants.PAGE_FROM, str);
        pairArr[3] = TuplesKt.a("browse_duration", String.valueOf(j11));
        pairArr[4] = TuplesKt.a("module_name", WebConstants.FIELD_ITEM);
        pairArr[5] = TuplesKt.a("ops", item.getOps());
        m.f51277a.t(pageName, "browse", s.l(pairArr));
    }

    public final void h(String str, String pageName, int i11, RoomItem item) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(item, "item");
        Pair[] pairArr = new Pair[5];
        String groupId = item.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        pairArr[0] = TuplesKt.a("group_id", groupId);
        pairArr[1] = TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11));
        pairArr[2] = TuplesKt.a(WebConstants.PAGE_FROM, str);
        pairArr[3] = TuplesKt.a("module_name", WebConstants.FIELD_ITEM);
        pairArr[4] = TuplesKt.a("ops", item.getOps());
        m.f51277a.m(pageName, "click", s.l(pairArr));
    }
}
