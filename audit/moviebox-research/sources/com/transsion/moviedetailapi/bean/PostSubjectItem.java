package com.transsion.moviedetailapi.bean;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.ad.bidding.nativead.c;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

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
@Keep
@Metadata
public final class PostSubjectItem implements Serializable {
    public static final a Companion = new a(null);

    @SerializedName("blur")
    private Integer blur;
    private boolean builtIn;

    @SerializedName(AppLovinEventTypes.USER_VIEWED_CONTENT)
    private String content;

    @SerializedName("createdAt")
    private String createdAt;
    private transient String distanceStr;

    @SerializedName("group")
    private Group group;

    @SerializedName("hasLike")
    private Boolean hasLike;
    private boolean isCache;
    private transient boolean isMore;
    private transient boolean isRoomList;

    @SerializedName("isSubjectRate")
    private Boolean isSubjectRate;

    @SerializedName("itemType")
    private String itemType;
    private Float lat;

    @SerializedName("link")
    private Link link;
    private Float lon;

    @SerializedName("media")
    private Media media;
    private transient c nonAdDelegate;

    @SerializedName("ops")
    private String ops;
    private OperateItem opsItemBean;

    @SerializedName("poiName")
    private String poiName;

    @SerializedName("postId")
    private String postId;
    private transient List<RoomItem> roomList;

    @SerializedName("stat")
    private Stat stat;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private Integer status;

    @SerializedName("subject")
    private Subject subject;

    @SerializedName("subjectRate")
    private Integer subjectRate;

    @SerializedName(CampaignEx.JSON_KEY_TITLE)
    private String title;
    private String tran_ops;

    @SerializedName("updatedAt")
    private String updatedAt;

    @SerializedName("user")
    private User user;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PostSubjectItem a(PostSubjectItem data) {
            Intrinsics.g(data, "data");
            return new PostSubjectItem(data.getContent(), data.getCreatedAt(), data.getGroup(), data.getHasLike(), data.isSubjectRate(), data.getLink(), data.getMedia(), data.getPostId(), data.getStat(), data.getStatus(), data.getSubject(), data.getSubjectRate(), data.getTitle(), data.getUpdatedAt(), data.getUser(), data.getOps(), data.getItemType(), data.getBlur(), data.getTran_ops(), data.isCache(), data.getOpsItemBean(), null, null, null, null, false, null, false, null, data.getBuiltIn(), 534773760, null);
        }
    }

    public PostSubjectItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, null, false, null, false, 1073741823, null);
    }

    public PostSubjectItem(String str, String str2, Group group, Boolean bool, Boolean bool2, Link link, Media media, String str3, Stat stat, Integer num, Subject subject, Integer num2, String str4, String str5, User user, String str6, String str7, Integer num3, String str8, boolean z11, OperateItem operateItem, Float f11, Float f12, String str9, String str10, boolean z12, List<RoomItem> list, boolean z13, c cVar, boolean z14) {
        this.content = str;
        this.createdAt = str2;
        this.group = group;
        this.hasLike = bool;
        this.isSubjectRate = bool2;
        this.link = link;
        this.media = media;
        this.postId = str3;
        this.stat = stat;
        this.status = num;
        this.subject = subject;
        this.subjectRate = num2;
        this.title = str4;
        this.updatedAt = str5;
        this.user = user;
        this.ops = str6;
        this.itemType = str7;
        this.blur = num3;
        this.tran_ops = str8;
        this.isCache = z11;
        this.opsItemBean = operateItem;
        this.lon = f11;
        this.lat = f12;
        this.poiName = str9;
        this.distanceStr = str10;
        this.isRoomList = z12;
        this.roomList = list;
        this.isMore = z13;
        this.nonAdDelegate = cVar;
        this.builtIn = z14;
    }

    public /* synthetic */ PostSubjectItem(String str, String str2, Group group, Boolean bool, Boolean bool2, Link link, Media media, String str3, Stat stat, Integer num, Subject subject, Integer num2, String str4, String str5, User user, String str6, String str7, Integer num3, String str8, boolean z11, OperateItem operateItem, Float f11, Float f12, String str9, String str10, boolean z12, List list, boolean z13, c cVar, boolean z14, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : group, (i11 & 8) != 0 ? null : bool, (i11 & 16) != 0 ? null : bool2, (i11 & 32) != 0 ? null : link, (i11 & 64) != 0 ? null : media, (i11 & 128) != 0 ? null : str3, (i11 & 256) != 0 ? null : stat, (i11 & 512) != 0 ? null : num, (i11 & 1024) != 0 ? null : subject, (i11 & 2048) != 0 ? null : num2, (i11 & 4096) != 0 ? null : str4, (i11 & 8192) != 0 ? null : str5, (i11 & 16384) != 0 ? null : user, (i11 & 32768) != 0 ? null : str6, (i11 & 65536) != 0 ? null : str7, (i11 & 131072) != 0 ? null : num3, (i11 & 262144) != 0 ? null : str8, (i11 & 524288) != 0 ? false : z11, (i11 & 1048576) != 0 ? null : operateItem, (i11 & 2097152) != 0 ? null : f11, (i11 & 4194304) != 0 ? null : f12, (i11 & 8388608) != 0 ? null : str9, (i11 & 16777216) != 0 ? null : str10, (i11 & ASTNode.PCTX_STORED) != 0 ? false : z12, (i11 & 67108864) != 0 ? null : list, (i11 & ASTNode.NOJIT) != 0 ? false : z13, (i11 & ASTNode.DEOP) != 0 ? null : cVar, (i11 & ASTNode.DISCARD) == 0 ? z14 : false);
    }

    public static /* synthetic */ Integer getCoverHeightWith$default(PostSubjectItem postSubjectItem, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        return postSubjectItem.getCoverHeightWith(z11);
    }

    public static /* synthetic */ String getCoverUrl$default(PostSubjectItem postSubjectItem, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return postSubjectItem.getCoverUrl(z11);
    }

    public final String component1() {
        return this.content;
    }

    public final Integer component10() {
        return this.status;
    }

    public final Subject component11() {
        return this.subject;
    }

    public final Integer component12() {
        return this.subjectRate;
    }

    public final String component13() {
        return this.title;
    }

    public final String component14() {
        return this.updatedAt;
    }

    public final User component15() {
        return this.user;
    }

    public final String component16() {
        return this.ops;
    }

    public final String component17() {
        return this.itemType;
    }

    public final Integer component18() {
        return this.blur;
    }

    public final String component19() {
        return this.tran_ops;
    }

    public final String component2() {
        return this.createdAt;
    }

    public final boolean component20() {
        return this.isCache;
    }

    public final OperateItem component21() {
        return this.opsItemBean;
    }

    public final Float component22() {
        return this.lon;
    }

    public final Float component23() {
        return this.lat;
    }

    public final String component24() {
        return this.poiName;
    }

    public final String component25() {
        return this.distanceStr;
    }

    public final boolean component26() {
        return this.isRoomList;
    }

    public final List<RoomItem> component27() {
        return this.roomList;
    }

    public final boolean component28() {
        return this.isMore;
    }

    public final c component29() {
        return this.nonAdDelegate;
    }

    public final Group component3() {
        return this.group;
    }

    public final boolean component30() {
        return this.builtIn;
    }

    public final Boolean component4() {
        return this.hasLike;
    }

    public final Boolean component5() {
        return this.isSubjectRate;
    }

    public final Link component6() {
        return this.link;
    }

    public final Media component7() {
        return this.media;
    }

    public final String component8() {
        return this.postId;
    }

    public final Stat component9() {
        return this.stat;
    }

    public final PostSubjectItem copy(String str, String str2, Group group, Boolean bool, Boolean bool2, Link link, Media media, String str3, Stat stat, Integer num, Subject subject, Integer num2, String str4, String str5, User user, String str6, String str7, Integer num3, String str8, boolean z11, OperateItem operateItem, Float f11, Float f12, String str9, String str10, boolean z12, List<RoomItem> list, boolean z13, c cVar, boolean z14) {
        return new PostSubjectItem(str, str2, group, bool, bool2, link, media, str3, stat, num, subject, num2, str4, str5, user, str6, str7, num3, str8, z11, operateItem, f11, f12, str9, str10, z12, list, z13, cVar, z14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.b(PostSubjectItem.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.e(obj, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.PostSubjectItem");
        PostSubjectItem postSubjectItem = (PostSubjectItem) obj;
        if (!TextUtils.equals(this.postId, postSubjectItem.postId)) {
            return false;
        }
        Subject subject = this.subject;
        String subjectId = subject != null ? subject.getSubjectId() : null;
        Subject subject2 = postSubjectItem.subject;
        if (!TextUtils.equals(subjectId, subject2 != null ? subject2.getSubjectId() : null)) {
            return false;
        }
        Group group = this.group;
        String groupId = group != null ? group.getGroupId() : null;
        Group group2 = postSubjectItem.group;
        return TextUtils.equals(groupId, group2 != null ? group2.getGroupId() : null);
    }

    public final Integer getBlur() {
        return this.blur;
    }

    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final String getContent() {
        return this.content;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    /* JADX WARN: Code duplicated, block: B:30:0x006d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0072  */
    /* JADX WARN: Code duplicated, block: B:34:0x0079  */
    /* JADX WARN: Code duplicated, block: B:35:0x007e  */
    /* JADX WARN: Code duplicated, block: B:41:0x008b  */
    /* JADX WARN: Code duplicated, block: B:43:0x008f  */
    /* JADX WARN: Code duplicated, block: B:46:0x009a  */
    /* JADX WARN: Code duplicated, block: B:49:0x009f  */
    public final Integer getCoverHeightWith(boolean z11) {
        Integer num;
        Integer width;
        Cover cover;
        Integer width2;
        Integer height;
        Cover cover2;
        Integer width3;
        Subject subject;
        Integer height2;
        Subject subject2;
        Cover cover3;
        Cover cover4;
        List<Image> image;
        Integer height3 = 0;
        Media media = this.media;
        if (media != null) {
            String mediaType = media.getMediaType();
            if (mediaType == null) {
                mediaType = "IMAGE";
            }
            int iHashCode = mediaType.hashCode();
            if (iHashCode != 62628790) {
                if (iHashCode != 69775675) {
                    if (iHashCode == 81665115 && mediaType.equals("VIDEO")) {
                        cover = media.getCover();
                        width2 = null;
                        if (cover != null) {
                            height = cover.getHeight();
                        } else {
                            height = null;
                        }
                        cover2 = media.getCover();
                        if (cover2 != null) {
                            width3 = cover2.getWidth();
                        } else {
                            width3 = null;
                        }
                        if (height != null || height.intValue() == 0) {
                            subject = this.subject;
                            if (subject != null || (cover4 = subject.getCover()) == null) {
                                height2 = null;
                            } else {
                                height2 = cover4.getHeight();
                            }
                            subject2 = this.subject;
                            if (subject2 != null && (cover3 = subject2.getCover()) != null) {
                                width2 = cover3.getWidth();
                            }
                            Integer num2 = width2;
                            height3 = height2;
                            width = num2;
                        } else {
                            height3 = height;
                            width = width3;
                        }
                    }
                } else if (mediaType.equals("IMAGE") && (image = media.getImage()) != null && (!image.isEmpty())) {
                    height3 = image.get(0).getHeight();
                    width = image.get(0).getWidth();
                }
                width = height3;
            } else if (mediaType.equals("AUDIO")) {
                cover = media.getCover();
                width2 = null;
                if (cover != null) {
                    height = cover.getHeight();
                } else {
                    height = null;
                }
                cover2 = media.getCover();
                if (cover2 != null) {
                    width3 = cover2.getWidth();
                } else {
                    width3 = null;
                }
                if (height != null) {
                    subject = this.subject;
                    if (subject != null) {
                        height2 = null;
                    } else {
                        height2 = null;
                    }
                    subject2 = this.subject;
                    if (subject2 != null) {
                        width2 = cover3.getWidth();
                    }
                    Integer num3 = width2;
                    height3 = height2;
                    width = num3;
                } else {
                    subject = this.subject;
                    if (subject != null) {
                        height2 = null;
                    } else {
                        height2 = null;
                    }
                    subject2 = this.subject;
                    if (subject2 != null) {
                        width2 = cover3.getWidth();
                    }
                    Integer num4 = width2;
                    height3 = height2;
                    width = num4;
                }
            } else {
                width = height3;
            }
            Integer num5 = height3;
            height3 = width;
            num = num5;
        } else {
            num = height3;
        }
        return z11 ? num : height3;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0089  */
    /* JADX WARN: Code duplicated, block: B:36:0x008f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0094  */
    /* JADX WARN: Code duplicated, block: B:40:0x009b  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00cb  */
    public final String getCoverUrl(boolean z11) {
        String thumbnail;
        String thumbnail2;
        Cover cover;
        String url;
        Cover cover2;
        Subject subject;
        String url2;
        Subject subject2;
        Cover cover3;
        Cover cover4;
        List<Image> image;
        Media media = this.media;
        if (media == null) {
            thumbnail = "";
            thumbnail2 = thumbnail;
        } else {
            String mediaType = media.getMediaType();
            if (mediaType == null) {
                mediaType = "IMAGE";
            }
            int iHashCode = mediaType.hashCode();
            thumbnail2 = null;
            if (iHashCode != 62628790) {
                if (iHashCode != 69775675) {
                    if (iHashCode == 81665115 && mediaType.equals("VIDEO")) {
                        cover = media.getCover();
                        if (cover != null) {
                            url = cover.getUrl();
                        } else {
                            url = null;
                        }
                        cover2 = media.getCover();
                        if (cover2 != null) {
                            thumbnail = cover2.getThumbnail();
                        } else {
                            thumbnail = null;
                        }
                        if (TextUtils.isEmpty(url)) {
                            subject = this.subject;
                            if (subject != null || (cover4 = subject.getCover()) == null) {
                                url2 = null;
                            } else {
                                url2 = cover4.getUrl();
                            }
                            subject2 = this.subject;
                            if (subject2 != null && (cover3 = subject2.getCover()) != null) {
                                thumbnail2 = cover3.getThumbnail();
                            }
                            String str = thumbnail2;
                            thumbnail2 = url2;
                            thumbnail = str;
                        } else {
                            thumbnail2 = url;
                        }
                    }
                } else if (mediaType.equals("IMAGE") && (image = media.getImage()) != null && (!image.isEmpty())) {
                    if (TextUtils.equals(image.get(0).getFormat(), "gif")) {
                        GifBean gifBean = image.get(0).getGifBean();
                        thumbnail2 = gifBean != null ? gifBean.getFirstFrameUrl() : null;
                        thumbnail = "";
                    } else {
                        thumbnail2 = image.get(0).getUrl();
                        thumbnail = image.get(0).getThumbnail();
                    }
                }
                thumbnail = "";
                thumbnail2 = thumbnail;
            } else if (mediaType.equals("AUDIO")) {
                cover = media.getCover();
                if (cover != null) {
                    url = cover.getUrl();
                } else {
                    url = null;
                }
                cover2 = media.getCover();
                if (cover2 != null) {
                    thumbnail = cover2.getThumbnail();
                } else {
                    thumbnail = null;
                }
                if (TextUtils.isEmpty(url)) {
                    subject = this.subject;
                    if (subject != null) {
                        url2 = null;
                    } else {
                        url2 = null;
                    }
                    subject2 = this.subject;
                    if (subject2 != null) {
                        thumbnail2 = cover3.getThumbnail();
                    }
                    String str2 = thumbnail2;
                    thumbnail2 = url2;
                    thumbnail = str2;
                } else {
                    thumbnail2 = url;
                }
            } else {
                thumbnail = "";
                thumbnail2 = thumbnail;
            }
        }
        if (z11) {
            return thumbnail == null ? "" : thumbnail;
        }
        return thumbnail2 == null ? "" : thumbnail2;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getDistanceStr() {
        return this.distanceStr;
    }

    public final Group getGroup() {
        return this.group;
    }

    public final Boolean getHasLike() {
        return this.hasLike;
    }

    public final String getItemType() {
        return this.itemType;
    }

    public final Float getLat() {
        return this.lat;
    }

    public final Link getLink() {
        return this.link;
    }

    public final Float getLon() {
        return this.lon;
    }

    public final Media getMedia() {
        return this.media;
    }

    public final c getNonAdDelegate() {
        return this.nonAdDelegate;
    }

    public final String getOps() {
        return this.ops;
    }

    public final OperateItem getOpsItemBean() {
        return this.opsItemBean;
    }

    public final String getPoiName() {
        return this.poiName;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final String getRec_ops() {
        return TextUtils.isEmpty(this.ops) ? this.tran_ops : this.ops;
    }

    public final List<RoomItem> getRoomList() {
        return this.roomList;
    }

    public final Stat getStat() {
        return this.stat;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Subject getSubject() {
        return this.subject;
    }

    public final Integer getSubjectRate() {
        return this.subjectRate;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTran_ops() {
        return this.tran_ops;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        String str = this.postId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final boolean isCache() {
        return this.isCache;
    }

    public final boolean isMore() {
        return this.isMore;
    }

    public final boolean isRoomList() {
        return this.isRoomList;
    }

    public final Boolean isSubjectRate() {
        return this.isSubjectRate;
    }

    public final boolean isVideo() {
        Media media = this.media;
        return Intrinsics.b(media != null ? media.getMediaType() : null, MediaType.VIDEO.getValue());
    }

    public final void setBlur(Integer num) {
        this.blur = num;
    }

    public final void setBuiltIn(boolean z11) {
        this.builtIn = z11;
    }

    public final void setCache(boolean z11) {
        this.isCache = z11;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public final void setDistanceStr(String str) {
        this.distanceStr = str;
    }

    public final void setGroup(Group group) {
        this.group = group;
    }

    public final void setHasLike(Boolean bool) {
        this.hasLike = bool;
    }

    public final void setItemType(String str) {
        this.itemType = str;
    }

    public final void setLat(Float f11) {
        this.lat = f11;
    }

    public final void setLink(Link link) {
        this.link = link;
    }

    public final void setLon(Float f11) {
        this.lon = f11;
    }

    public final void setMedia(Media media) {
        this.media = media;
    }

    public final void setMore(boolean z11) {
        this.isMore = z11;
    }

    public final void setNonAdDelegate(c cVar) {
        this.nonAdDelegate = cVar;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setOpsItemBean(OperateItem operateItem) {
        this.opsItemBean = operateItem;
    }

    public final void setPoiName(String str) {
        this.poiName = str;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final void setRoomList(List<RoomItem> list) {
        this.roomList = list;
    }

    public final void setRoomList(boolean z11) {
        this.isRoomList = z11;
    }

    public final void setStat(Stat stat) {
        this.stat = stat;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public final void setSubject(Subject subject) {
        this.subject = subject;
    }

    public final void setSubjectRate(Boolean bool) {
        this.isSubjectRate = bool;
    }

    public final void setSubjectRate(Integer num) {
        this.subjectRate = num;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTran_ops(String str) {
        this.tran_ops = str;
    }

    public final void setUpdatedAt(String str) {
        this.updatedAt = str;
    }

    public final void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        return "PostSubjectItem(content=" + this.content + ", createdAt=" + this.createdAt + ", group=" + this.group + ", hasLike=" + this.hasLike + ", isSubjectRate=" + this.isSubjectRate + ", link=" + this.link + ", media=" + this.media + ", postId=" + this.postId + ", stat=" + this.stat + ", status=" + this.status + ", subject=" + this.subject + ", subjectRate=" + this.subjectRate + ", title=" + this.title + ", updatedAt=" + this.updatedAt + ", user=" + this.user + ", ops=" + this.ops + ", itemType=" + this.itemType + ", blur=" + this.blur + ", tran_ops=" + this.tran_ops + ", isCache=" + this.isCache + ", opsItemBean=" + this.opsItemBean + ", lon=" + this.lon + ", lat=" + this.lat + ", poiName=" + this.poiName + ", distanceStr=" + this.distanceStr + ", isRoomList=" + this.isRoomList + ", roomList=" + this.roomList + ", isMore=" + this.isMore + ", nonAdDelegate=" + this.nonAdDelegate + ", builtIn=" + this.builtIn + ")";
    }
}
