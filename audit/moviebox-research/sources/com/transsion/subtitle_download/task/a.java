package com.transsion.subtitle_download.task;

import android.app.Application;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.report.m;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.subtitle_download.utils.b;
import com.transsion.subtitle_download.utils.c;
import java.util.LinkedHashMap;
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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f58372a = new a();

    public final String a() {
        String simpleName = a.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void b(String str, SubtitleDownloadTable subtitleDownloadTable) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("resource_id", subtitleDownloadTable.getResourceId());
        String taskId = subtitleDownloadTable.getTaskId();
        if (taskId == null) {
            taskId = "";
        }
        linkedHashMap.put("taskId", taskId);
        String subjectId = subtitleDownloadTable.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        if (subtitleDownloadTable.getEp() > 0) {
            linkedHashMap.put("ep", String.valueOf(subtitleDownloadTable.getEp()));
        }
        if (subtitleDownloadTable.getSe() > 0) {
            linkedHashMap.put("se", String.valueOf(subtitleDownloadTable.getSe()));
        }
        String lan = subtitleDownloadTable.getLan();
        if (lan == null) {
            lan = "";
        }
        linkedHashMap.put("lan", lan);
        String lanName = subtitleDownloadTable.getLanName();
        linkedHashMap.put("lan_name", lanName != null ? lanName : "");
        linkedHashMap.put("type", String.valueOf(subtitleDownloadTable.getType()));
        linkedHashMap.put(NotificationCompat.CATEGORY_STATUS, String.valueOf(subtitleDownloadTable.getStatus()));
        linkedHashMap.put("action", str);
        m.f51277a.m("st_download_v2", "subtitle_download", linkedHashMap);
    }

    public final void c(SubtitleDownloadTable stDownloadTable) {
        Intrinsics.g(stDownloadTable, "stDownloadTable");
        b.f58375a.c(a() + " --> reportDownloadSuccess() --> 字幕任务下载成功 --> taskId = " + stDownloadTable.getTaskId() + " ");
        b("success", stDownloadTable);
    }

    public final void d(SubtitleDownloadTable stDownloadTable) {
        Intrinsics.g(stDownloadTable, "stDownloadTable");
        if (TextUtils.isEmpty(stDownloadTable.getTaskId())) {
            String strG = c.f58376a.g();
            stDownloadTable.setTaskId(strG);
            SubtitleDownloadDatabase.b bVar = SubtitleDownloadDatabase.f58352p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            bVar.b(applicationA).J().f(stDownloadTable);
            b.f58375a.c(a() + " --> reportDownloadTrigger() --> 用户创建了字幕下载任务 --> taskId = " + strG);
            b("trigger", stDownloadTable);
        }
    }
}
