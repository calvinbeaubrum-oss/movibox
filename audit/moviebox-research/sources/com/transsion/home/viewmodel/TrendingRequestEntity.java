package com.transsion.home.viewmodel;

import com.transsion.baselib.report.recent_event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import java.util.Queue;
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
public final class TrendingRequestEntity implements Serializable {
    public static final int $stable = 8;
    private Queue<ActionEvent> latest_events;
    private List<String> optPlaylistIds;
    private int tabId;
    private String page = "1";
    private int perPage = 12;
    private String userPrefer = "";
    private String deepLink = "";
    private String sessionId = "";
    private String postId = "0";
    private Integer channelId = 0;
    private Boolean disablePlaylist = Boolean.TRUE;

    public final Integer getChannelId() {
        return this.channelId;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final Boolean getDisablePlaylist() {
        return this.disablePlaylist;
    }

    public final Queue<ActionEvent> getLatest_events() {
        return this.latest_events;
    }

    public final List<String> getOptPlaylistIds() {
        return this.optPlaylistIds;
    }

    public final String getPage() {
        return this.page;
    }

    public final int getPerPage() {
        return this.perPage;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final String getUserPrefer() {
        return this.userPrefer;
    }

    public final void setChannelId(Integer num) {
        this.channelId = num;
    }

    public final void setDeepLink(String str) {
        this.deepLink = str;
    }

    public final void setDisablePlaylist(Boolean bool) {
        this.disablePlaylist = bool;
    }

    public final void setLatest_events(Queue<ActionEvent> queue) {
        this.latest_events = queue;
    }

    public final void setOptPlaylistIds(List<String> list) {
        this.optPlaylistIds = list;
    }

    public final void setPage(String str) {
        Intrinsics.g(str, "<set-?>");
        this.page = str;
    }

    public final void setPerPage(int i11) {
        this.perPage = i11;
    }

    public final void setPostId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.postId = str;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final void setTabId(int i11) {
        this.tabId = i11;
    }

    public final void setUserPrefer(String str) {
        this.userPrefer = str;
    }
}
