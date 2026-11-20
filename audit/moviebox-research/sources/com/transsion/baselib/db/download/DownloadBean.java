package com.transsion.baselib.db.download;

import android.net.Uri;
import android.os.Environment;
import androidx.annotation.Keep;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.h0;
import com.hisavana.common.interfacz.TAdListener;
import com.hisavana.common.interfacz.TAdditionalListener;
import com.transsion.baselib.utils.h;
import com.transsion.player.orplayer.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.k;
import kotlin.text.l;
import org.mvel2.ast.ASTNode;
import tr.g;

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
@Keep
@Metadata
public class DownloadBean implements e9.a {
    public static final int AUDIO = 1;
    public static final a Companion = new a(null);
    public static final int DOWNLOAD_ERROR_MAX_COUNT = 15;
    public static final int INNER = 1;
    public static final int MOVIE = 2;
    public static final int OUTSIDE = 2;
    public static final int PATH_TYPE_ALBUM = 3;
    public static final int PATH_TYPE_BM_INNER = 1;
    public static final int PATH_TYPE_SDCARD = 2;
    public static final int READ = 2;
    public static final int SERVER_AUDIO = 4;
    public static final int SERVER_EDUCATION = 5;
    public static final int SERVER_MOVIE = 1;
    public static final int SERVER_MUSIC = 6;
    public static final int SERVER_SHORT_TV = 7;
    public static final int SERVER_TV = 2;
    public static final int SERVER_VSHOW = 3;
    public static final int STATUS_AD_ITEM = 13;
    public static final int STATUS_ALL_EP_BTN = 14;
    public static final int STATUS_COMPLETED = 5;
    public static final int STATUS_COMPLETED_REMOVED = 57;
    public static final int STATUS_DOWNLOADING = 2;
    public static final int STATUS_ERROR = 6;
    public static final int STATUS_HIDE_MORE = 12;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_PATH = 15;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_PREPARE_DOWNLOAD = 1;
    public static final int STATUS_REMOVED = 7;
    public static final int STATUS_SERIES = 10;
    public static final int STATUS_TITLE = 11;
    public static final int STATUS_WAIT = 3;
    public static final int TRANSFER_RECEIVED = 3;
    public static final int TV = 3;
    public static final int TYPE_EDUCATION = 5;
    public static final int TYPE_MUSIC = 6;
    public static final int TYPE_STREAM = 7;
    public static final int UNREAD = 1;
    private TAdListener adProvide;
    private e audioListener;
    private int audioStatus;
    private String averageHueLight;
    private int count;
    private String countryName;
    private String cover;
    private long createAt;
    private long currentDownloadSpeed;
    private String currentDubLanCode;
    private String currentDubLanName;
    private long currentOffset;
    private int downloadErrorCount;
    private long downloadHeaderSize;
    private g downloadListener;
    private List<DownloadRange> downloadRanges;
    private Long duration;

    /* JADX INFO: renamed from: ep, reason: collision with root package name */
    private int f51068ep;
    private String epNameLocal;
    private int epse;
    private int errorCount;
    private DownloadException exception;
    private int fileType;
    private String genre;
    private String groupId;
    private String imdbRate;
    private int index;
    private boolean isAutoPause;
    private boolean isCheck;
    private boolean isClosedTransferFailed;
    private boolean isDownloadingPlay;
    private boolean isFroYouList;
    private boolean isMore;
    private boolean isPlaying;
    private boolean isPreDownload;
    private boolean isQuitDPRestart;
    private int isRead;
    private boolean isSeriesAllCheck;
    private boolean isStartRequested;
    private boolean isStream;
    private boolean isStreamVideoDetail;
    private boolean isTransferFailed;
    private int itemType;
    private Long lastAdEndTimeStamp;
    private Long lastAdStartTimeStamp;
    private String lastPageFrom;
    private long lastPlayTimeStamp;
    private long lastProgress;
    private int multiresolution;
    private String name;
    private String ops;
    private String pageFrom;
    private String path;
    private String playingUrl;
    private int position;
    private String postId;
    private int preErrorCode;
    private int preStatus;
    private volatile long progress;
    private boolean reDownload;
    private long readProgress;
    private String releaseDate;
    private int reportStatus;
    private int requestNewSourceCount;
    private Integer requireMemberType;
    private int resolution;
    private String resourceId;
    private int resourcePosition;
    private int restartDownloadCount;
    private String restrictLevel;
    private String rootPath;
    private int rootPathType;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    private int f51069se;
    private Integer seNum;
    private List<DownloadBean> seriesList;
    private long sessionTime;
    private Long size;
    private String sizeFormat;
    private String sourceUrl;
    private int status;
    private Integer subjectDurationSeconds;
    private String subjectId;
    private String subjectName;
    private int subjectType;
    private List<SubtitleBean> subtitleList;
    private String subtitleSelectId;
    private int subtitleStarted;
    private String subtitles;
    private int supportRanges;
    private String taskId;
    private String thumbnail;
    private String titleNameLocal;
    private String titleNameReLocal;
    private int totalEpisode;
    private String totalTitleNameLocal;
    private int type;
    private Long updateTimeStamp;
    private String uploadBy;
    private String url;
    private long urlCreateAt;
    private int videoHeight;
    private int videoWidth;
    private TAdditionalListener wrapNativeManager;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(Integer num) {
            if (num != null && num.intValue() == 2) {
                return 1;
            }
            if (num != null && num.intValue() == 3) {
                return 2;
            }
            if (num != null && num.intValue() == 1) {
                return 4;
            }
            if (num != null && num.intValue() == 5) {
                return 5;
            }
            return (num != null && num.intValue() == 6) ? 6 : 1;
        }

        public final boolean b(int i11) {
            return i11 == 2 || i11 == 3 || i11 == 5 || i11 == 6;
        }

        public final int c(Integer num) {
            if (num != null && num.intValue() == 1) {
                return 2;
            }
            if (num == null || num.intValue() != 2) {
                if (num != null && num.intValue() == 4) {
                    return 1;
                }
                if (num != null && num.intValue() == 5) {
                    return 5;
                }
                if (num != null && num.intValue() == 6) {
                    return 6;
                }
                if (num == null || num.intValue() != 7) {
                    return 2;
                }
            }
            return 3;
        }
    }

    public DownloadBean(String url, String str, String str2, String str3, Long l11, String str4, String str5, String str6, Long l12, Long l13, long j11, int i11, int i12, int i13, long j12, long j13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, int i24, int i25, String str7, String str8, String str9, String str10, long j14, int i26, int i27, String str11, String str12, long j15, String str13, String str14, long j16, int i28, long j17, String str15, int i29, String str16, String str17, boolean z11, boolean z12, int i31, String str18, Integer num, String str19, String str20, String str21, String str22, String str23, String str24, Integer num2, String str25, String str26, Long l14, Long l15) {
        Intrinsics.g(url, "url");
        this.url = url;
        this.resourceId = str;
        this.name = str2;
        this.cover = str3;
        this.size = l11;
        this.postId = str4;
        this.sizeFormat = str5;
        this.path = str6;
        this.duration = l12;
        this.updateTimeStamp = l13;
        this.progress = j11;
        this.supportRanges = i11;
        this.status = i12;
        this.type = i13;
        this.readProgress = j12;
        this.createAt = j13;
        this.isRead = i14;
        this.epse = i15;
        this.f51068ep = i16;
        this.f51069se = i17;
        this.resolution = i18;
        this.resourcePosition = i19;
        this.multiresolution = i21;
        this.videoWidth = i22;
        this.videoHeight = i23;
        this.downloadErrorCount = i24;
        this.subtitleStarted = i25;
        this.subjectId = str7;
        this.pageFrom = str8;
        this.lastPageFrom = str9;
        this.subjectName = str10;
        this.lastPlayTimeStamp = j14;
        this.fileType = i26;
        this.totalEpisode = i27;
        this.uploadBy = str11;
        this.sourceUrl = str12;
        this.urlCreateAt = j15;
        this.subtitleSelectId = str13;
        this.taskId = str14;
        this.sessionTime = j16;
        this.reportStatus = i28;
        this.downloadHeaderSize = j17;
        this.rootPath = str15;
        this.rootPathType = i29;
        this.thumbnail = str16;
        this.averageHueLight = str17;
        this.isTransferFailed = z11;
        this.isClosedTransferFailed = z12;
        this.subjectType = i31;
        this.genre = str18;
        this.subjectDurationSeconds = num;
        this.currentDubLanName = str19;
        this.currentDubLanCode = str20;
        this.ops = str21;
        this.restrictLevel = str22;
        this.releaseDate = str23;
        this.countryName = str24;
        this.seNum = num2;
        this.subtitles = str25;
        this.imdbRate = str26;
        this.lastAdStartTimeStamp = l14;
        this.lastAdEndTimeStamp = l15;
        this.downloadRanges = new CopyOnWriteArrayList();
        this.groupId = "";
        this.subtitleList = new CopyOnWriteArrayList();
        this.seriesList = new ArrayList();
        this.preErrorCode = -1;
        this.requireMemberType = 0;
        this.playingUrl = "";
        this.isSeriesAllCheck = true;
        this.itemType = this.status;
    }

    public /* synthetic */ DownloadBean(String str, String str2, String str3, String str4, Long l11, String str5, String str6, String str7, Long l12, Long l13, long j11, int i11, int i12, int i13, long j12, long j13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, int i24, int i25, String str8, String str9, String str10, String str11, long j14, int i26, int i27, String str12, String str13, long j15, String str14, String str15, long j16, int i28, long j17, String str16, int i29, String str17, String str18, boolean z11, boolean z12, int i31, String str19, Integer num, String str20, String str21, String str22, String str23, String str24, String str25, Integer num2, String str26, String str27, Long l14, Long l15, int i32, int i33, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, l11, (i32 & 32) != 0 ? "" : str5, (i32 & 64) != 0 ? "" : str6, (i32 & 128) != 0 ? "" : str7, (i32 & 256) != 0 ? 0L : l12, (i32 & 512) != 0 ? Long.valueOf(System.currentTimeMillis()) : l13, (i32 & 1024) != 0 ? 0L : j11, (i32 & 2048) != 0 ? 0 : i11, (i32 & 4096) != 0 ? 0 : i12, (i32 & 8192) != 0 ? 2 : i13, (i32 & 16384) != 0 ? 0L : j12, (i32 & 32768) != 0 ? System.currentTimeMillis() : j13, (i32 & 65536) != 0 ? 1 : i14, (i32 & 131072) != 0 ? 0 : i15, (i32 & 262144) != 0 ? 0 : i16, (i32 & 524288) != 0 ? 0 : i17, (i32 & 1048576) != 0 ? 0 : i18, (i32 & 2097152) != 0 ? 0 : i19, (i32 & 4194304) != 0 ? 0 : i21, (i32 & 8388608) != 0 ? 0 : i22, (i32 & 16777216) != 0 ? 0 : i23, (i32 & ASTNode.PCTX_STORED) != 0 ? 0 : i24, (i32 & 67108864) != 0 ? 0 : i25, (i32 & ASTNode.NOJIT) != 0 ? "" : str8, (i32 & ASTNode.DEOP) != 0 ? "" : str9, (i32 & ASTNode.DISCARD) != 0 ? "" : str10, (i32 & 1073741824) != 0 ? "" : str11, (i32 & Integer.MIN_VALUE) != 0 ? 0L : j14, (i33 & 1) != 0 ? 1 : i26, (i33 & 2) != 0 ? 1 : i27, (i33 & 4) != 0 ? "" : str12, (i33 & 8) != 0 ? "" : str13, (i33 & 16) != 0 ? 0L : j15, (i33 & 32) != 0 ? "" : str14, (i33 & 64) != 0 ? "" : str15, (i33 & 128) != 0 ? 0L : j16, (i33 & 256) != 0 ? 0 : i28, (i33 & 512) != 0 ? 0L : j17, (i33 & 1024) != 0 ? "" : str16, (i33 & 2048) != 0 ? 1 : i29, (i33 & 4096) != 0 ? "" : str17, (i33 & 8192) != 0 ? null : str18, (i33 & 16384) != 0 ? false : z11, (32768 & i33) != 0 ? false : z12, (i33 & 65536) != 0 ? 1 : i31, (i33 & 131072) != 0 ? null : str19, (i33 & 262144) != 0 ? 0 : num, (i33 & 524288) != 0 ? null : str20, (i33 & 1048576) != 0 ? null : str21, (2097152 & i33) == 0 ? str22 : "", (4194304 & i33) != 0 ? null : str23, (8388608 & i33) != 0 ? null : str24, (16777216 & i33) != 0 ? null : str25, (33554432 & i33) != 0 ? 0 : num2, (67108864 & i33) != 0 ? null : str26, (134217728 & i33) != 0 ? null : str27, (268435456 & i33) != 0 ? null : l14, (i33 & ASTNode.DISCARD) != 0 ? null : l15);
    }

    public static /* synthetic */ String getEpTitleName$default(DownloadBean downloadBean, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEpTitleName");
        }
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        return downloadBean.getEpTitleName(z11);
    }

    public static /* synthetic */ void getPreStatus$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.b(getClass(), obj.getClass())) {
            return false;
        }
        return l.w(this.resourceId, ((DownloadBean) obj).resourceId, false, 2, null);
    }

    public final TAdListener getAdProvide() {
        return this.adProvide;
    }

    public final e getAudioListener() {
        return this.audioListener;
    }

    public final int getAudioStatus() {
        return this.audioStatus;
    }

    public final String getAverageHueLight() {
        return this.averageHueLight;
    }

    public final boolean getCanPlay() {
        int i11 = this.status;
        return (i11 == 0 || i11 == 7) ? false : true;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final String getCover() {
        return this.cover;
    }

    public final long getCreateAt() {
        return this.createAt;
    }

    public final String getCreateAtFormat() {
        String strH = h0.h(this.createAt);
        Intrinsics.f(strH, "millis2String(createAt)");
        return strH;
    }

    public final long getCurrentDownloadSpeed() {
        return this.currentDownloadSpeed;
    }

    public final String getCurrentDubLanCode() {
        return this.currentDubLanCode;
    }

    public final String getCurrentDubLanName() {
        return this.currentDubLanName;
    }

    public final long getCurrentOffset() {
        return this.currentOffset;
    }

    public final int getDownloadErrorCount() {
        return this.downloadErrorCount;
    }

    public final long getDownloadHeaderSize() {
        return this.downloadHeaderSize;
    }

    public final g getDownloadListener() {
        return this.downloadListener;
    }

    public final List<DownloadRange> getDownloadRanges() {
        return this.downloadRanges;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final int getEp() {
        return this.f51068ep;
    }

    public final String getEpName() {
        String str = this.epNameLocal;
        if (str != null && str.length() > 0) {
            String str2 = this.epNameLocal;
            Intrinsics.d(str2);
            return str2;
        }
        if (!isSeries() || this.status == 10) {
            return "";
        }
        int i11 = this.f51068ep;
        if (i11 > 0) {
            String strB = h.b(i11, this.f51069se, Integer.valueOf(this.type));
            this.epNameLocal = strB;
            Intrinsics.d(strB);
            return strB;
        }
        String strC = h.c(this.epse, isVideo());
        this.epNameLocal = strC;
        Intrinsics.d(strC);
        return strC;
    }

    public final String getEpTitleName(boolean z11) {
        if (this.subjectType == 5) {
            return "Lesson " + this.f51068ep + h.d(this.name);
        }
        if (z11) {
            return getEpName() + h.d(this.name);
        }
        return h.a(this.f51068ep) + h.d(this.name);
    }

    public final int getEpse() {
        return this.epse;
    }

    public final int getErrorCount() {
        return this.errorCount;
    }

    public final DownloadException getException() {
        return this.exception;
    }

    public final String getFileName() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = "";
        if ((isSeries() || this.status == 10) && (str = this.subjectName) != null && str.length() > 0) {
            String str6 = this.subjectName;
            if (str6 == null) {
                str6 = "";
            }
            int i11 = this.resolution;
            if (i11 > 0) {
                str2 = "_" + i11 + "P";
            } else {
                str2 = "";
            }
            str3 = str6 + str2;
        } else if (this.resolution <= 0 || (str4 = this.subjectName) == null || str4.length() <= 0) {
            str3 = this.name;
            if (str3 == null) {
                str3 = "";
            }
        } else {
            str3 = this.subjectName + "_" + this.resolution + "P";
        }
        if (getEpName().length() > 0) {
            str5 = " " + getEpName();
        }
        return l.F(str3 + str5, " ", "_", false, 4, null);
    }

    public final int getFileType() {
        return this.fileType;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getImdbRate() {
        return this.imdbRate;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // e9.a
    public int getItemType() {
        return this.itemType;
    }

    public final Long getLastAdEndTimeStamp() {
        return this.lastAdEndTimeStamp;
    }

    public final Long getLastAdStartTimeStamp() {
        return this.lastAdStartTimeStamp;
    }

    public final String getLastPageFrom() {
        return this.lastPageFrom;
    }

    public final long getLastPlayTimeStamp() {
        return this.lastPlayTimeStamp;
    }

    public final long getLastProgress() {
        return this.lastProgress;
    }

    public final int getMultiresolution() {
        return this.multiresolution;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOps() {
        return this.ops;
    }

    public final String getPageFrom() {
        return this.pageFrom;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getPlayingUrl() {
        return this.playingUrl;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final String getPostIdNotNull() {
        String str = this.postId;
        if (str != null) {
            return str;
        }
        String str2 = this.resourceId;
        return str2 == null ? String.valueOf(this.url.hashCode()) : str2;
    }

    public final int getPreErrorCode() {
        return this.preErrorCode;
    }

    public final int getPreStatus() {
        return this.preStatus;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final boolean getReDownload() {
        return this.reDownload;
    }

    public final long getReadProgress() {
        return this.readProgress;
    }

    public final String getReleaseDate() {
        return this.releaseDate;
    }

    public final int getReportStatus() {
        return this.reportStatus;
    }

    public final int getRequestNewSourceCount() {
        return this.requestNewSourceCount;
    }

    public final Integer getRequireMemberType() {
        return this.requireMemberType;
    }

    public final int getResolution() {
        return this.resolution;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final int getResourcePosition() {
        return this.resourcePosition;
    }

    public final int getRestartDownloadCount() {
        return this.restartDownloadCount;
    }

    public final String getRestrictLevel() {
        return this.restrictLevel;
    }

    public final String getRootPath() {
        return this.rootPath;
    }

    public final int getRootPathType() {
        return this.rootPathType;
    }

    public final int getSe() {
        return this.f51069se;
    }

    public final Integer getSeNum() {
        return this.seNum;
    }

    public final List<DownloadBean> getSeriesList() {
        return this.seriesList;
    }

    public final long getSessionTime() {
        return this.sessionTime;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getSizeFormat() {
        return this.sizeFormat;
    }

    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    public final int getStatus() {
        return this.status;
    }

    public final Integer getSubjectDurationSeconds() {
        return this.subjectDurationSeconds;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getSubjectName() {
        return this.subjectName;
    }

    public final int getSubjectType() {
        return this.subjectType;
    }

    public final List<SubtitleBean> getSubtitleList() {
        return this.subtitleList;
    }

    public final String getSubtitleResId() {
        return this.subjectId + "_" + this.f51069se + "_" + this.f51068ep + "_en_" + (this.isStream ? 2 : 1);
    }

    public final String getSubtitleSelectId() {
        return this.subtitleSelectId;
    }

    public final int getSubtitleStarted() {
        return this.subtitleStarted;
    }

    public final String getSubtitles() {
        return this.subtitles;
    }

    public final int getSupportRanges() {
        return this.supportRanges;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    public final String getTitleName() {
        String str;
        String str2;
        String str3;
        String str4 = this.titleNameLocal;
        if (str4 != null && str4.length() > 0) {
            String str5 = this.titleNameLocal;
            Intrinsics.d(str5);
            return str5;
        }
        if (isSeries() || (this.status == 10 && (str3 = this.subjectName) != null && str3.length() > 0)) {
            str = this.subjectName;
            if (str == null) {
                str = "";
            }
        } else if (this.resolution <= 0 || (str2 = this.subjectName) == null || str2.length() <= 0) {
            str = this.name;
            if (str == null) {
                str = "";
            }
        } else {
            str = this.resolution + "P " + this.subjectName;
        }
        this.titleNameLocal = str;
        Intrinsics.d(str);
        return str;
    }

    public final String getTitleNameAppendResolution() {
        String str;
        String str2;
        String str3;
        String str4 = this.titleNameReLocal;
        if (str4 != null && str4.length() > 0) {
            String str5 = this.titleNameReLocal;
            Intrinsics.d(str5);
            return str5;
        }
        String str6 = "";
        if (isSeries() || (this.status == 10 && (str3 = this.subjectName) != null && str3.length() > 0)) {
            String str7 = this.subjectName;
            if (str7 == null) {
                str7 = "";
            }
            int i11 = this.resolution;
            if (i11 > 0) {
                str6 = " " + i11 + "P";
            }
            str = str7 + str6;
        } else if (this.resolution <= 0 || (str2 = this.subjectName) == null || str2.length() <= 0) {
            str = this.name;
            if (str == null) {
                str = "";
            }
        } else {
            str = this.resolution + "P " + this.subjectName;
        }
        this.titleNameReLocal = str;
        Intrinsics.d(str);
        return str;
    }

    public final int getTotalEpisode() {
        return this.totalEpisode;
    }

    public final String getTotalTitleName() {
        String str = this.totalTitleNameLocal;
        if (str != null && str.length() > 0) {
            String str2 = this.totalTitleNameLocal;
            Intrinsics.d(str2);
            return str2;
        }
        String str3 = getTitleName() + " " + getEpName();
        this.totalTitleNameLocal = str3;
        Intrinsics.d(str3);
        return str3;
    }

    public final int getType() {
        return this.type;
    }

    public final Long getUpdateTimeStamp() {
        return this.updateTimeStamp;
    }

    public final String getUploadBy() {
        return this.uploadBy;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getUrlCreateAt() {
        return this.urlCreateAt;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final TAdditionalListener getWrapNativeManager() {
        return this.wrapNativeManager;
    }

    public int hashCode() {
        String str = this.resourceId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final boolean is4xxError() {
        DownloadException downloadException = this.exception;
        int responseCode = downloadException != null ? downloadException.getResponseCode() : 0;
        return 400 <= responseCode && responseCode < 500;
    }

    public final boolean isAllFileExist() {
        if (this.status != 10) {
            return isFileExist();
        }
        Iterator<DownloadBean> it = this.seriesList.iterator();
        while (it.hasNext()) {
            if (it.next().isFileExist()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isAutoPause() {
        return this.isAutoPause;
    }

    public final boolean isCNDError() {
        DownloadException.a aVar = DownloadException.Companion;
        DownloadException downloadException = this.exception;
        if (!aVar.c(downloadException != null ? downloadException.getCode() : 0)) {
            DownloadException downloadException2 = this.exception;
            int responseCode = downloadException2 != null ? downloadException2.getResponseCode() : 0;
            if (500 > responseCode || responseCode >= 600) {
                return false;
            }
        }
        return true;
    }

    public final boolean isCheck() {
        return this.isCheck;
    }

    public final boolean isClosedTransferFailed() {
        return this.isClosedTransferFailed;
    }

    public final boolean isCompleted() {
        return this.status == 5;
    }

    public final boolean isDownloadInSDCard() {
        return this.rootPathType == 2;
    }

    public final boolean isDownloading() {
        int i11 = this.status;
        return i11 == 1 || i11 == 2;
    }

    public final boolean isDownloadingPlay() {
        return this.isDownloadingPlay;
    }

    public final boolean isFileExist() {
        String str = this.path;
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = this.path;
        Intrinsics.d(str2);
        if (l.L(str2, AppLovinEventTypes.USER_VIEWED_CONTENT, false, 2, null)) {
            l3.a aVarG = l3.a.g(Utils.a(), Uri.parse(this.path));
            if (aVarG != null) {
                return aVarG.e();
            }
        } else {
            String str3 = this.path;
            Intrinsics.d(str3);
            File file = new File(str3);
            if (!file.exists() || file.length() <= 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean isFroYouList() {
        return this.isFroYouList;
    }

    public final boolean isInnerRes() {
        return this.fileType == 1;
    }

    public final boolean isInnerSubjectRes() {
        if (this.fileType == 1) {
            String str = this.resourceId;
            if ((str != null ? k.n(str) : null) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean isMore() {
        return this.isMore;
    }

    public final boolean isMultiresolution() {
        return this.multiresolution > 0;
    }

    public final boolean isMusic() {
        return this.type == 6;
    }

    public final boolean isNoNetError() {
        DownloadException downloadException = this.exception;
        return Intrinsics.b(downloadException != null ? downloadException.getMessage() : null, DownloadException.EXCEPTION_MESSAGE_NO_NET);
    }

    public final boolean isOutside() {
        return this.fileType == 2;
    }

    public final boolean isPause() {
        int i11 = this.status;
        return i11 == 4 || i11 == 6 || i11 == 7 || i11 == 3;
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    public final boolean isPreDownload() {
        return this.isPreDownload;
    }

    public final boolean isQuitDPRestart() {
        return this.isQuitDPRestart;
    }

    public final int isRead() {
        return this.isRead;
    }

    public final boolean isRemoved() {
        return this.status == 7;
    }

    public final boolean isSaved() {
        String strR0;
        String str = this.path;
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = this.path;
        if (str2 == null || (strR0 = StringsKt__StringsKt.R0(str2, "/", null, 2, null)) == null) {
            strR0 = "";
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + File.separatorChar + "MovieBox", strR0);
        return file.exists() && file.length() > 0;
    }

    public final boolean isSeries() {
        return this.epse > 0 || this.f51068ep > 0 || this.totalEpisode > 1;
    }

    public final boolean isSeriesAllCheck() {
        return this.isSeriesAllCheck;
    }

    public final boolean isSeriesCollection() {
        return this.status == 10;
    }

    public final boolean isShotTV() {
        return this.subjectType == 7;
    }

    public final boolean isStartRequested() {
        return this.isStartRequested;
    }

    public final boolean isStream() {
        return this.isStream;
    }

    public final boolean isStreamVideoDetail() {
        return this.isStreamVideoDetail;
    }

    public final boolean isSupportRanges() {
        return this.supportRanges == 0;
    }

    public final boolean isTransferFailed() {
        return this.isTransferFailed;
    }

    public final boolean isUnable() {
        int i11 = this.status;
        return (i11 == 0 || i11 == 7) ? false : true;
    }

    public final boolean isVideo() {
        return Companion.b(this.type);
    }

    public final void setAdProvide(TAdListener tAdListener) {
        this.adProvide = tAdListener;
    }

    public final void setAudioListener(e eVar) {
        this.audioListener = eVar;
    }

    public final void setAudioStatus(int i11) {
        this.audioStatus = i11;
    }

    public final void setAutoPause(boolean z11) {
        this.isAutoPause = z11;
    }

    public final void setAverageHueLight(String str) {
        this.averageHueLight = str;
    }

    public final void setCheck(boolean z11) {
        this.isCheck = z11;
    }

    public final void setClosedTransferFailed(boolean z11) {
        this.isClosedTransferFailed = z11;
    }

    public final void setCount(int i11) {
        this.count = i11;
    }

    public final void setCountryName(String str) {
        this.countryName = str;
    }

    public final void setCover(String str) {
        this.cover = str;
    }

    public final void setCreateAt(long j11) {
        this.createAt = j11;
    }

    public final void setCurrentDownloadSpeed(long j11) {
        this.currentDownloadSpeed = j11;
    }

    public final void setCurrentDubLanCode(String str) {
        this.currentDubLanCode = str;
    }

    public final void setCurrentDubLanName(String str) {
        this.currentDubLanName = str;
    }

    public final void setCurrentOffset(long j11) {
        this.currentOffset = j11;
    }

    public final void setDownloadErrorCount(int i11) {
        this.downloadErrorCount = i11;
    }

    public final void setDownloadHeaderSize(long j11) {
        this.downloadHeaderSize = j11;
    }

    public final void setDownloadListener(g gVar) {
        this.downloadListener = gVar;
    }

    public final void setDownloadRanges(List<DownloadRange> list) {
        Intrinsics.g(list, "<set-?>");
        this.downloadRanges = list;
    }

    public final void setDownloadingPlay(boolean z11) {
        this.isDownloadingPlay = z11;
    }

    public final void setDuration(Long l11) {
        this.duration = l11;
    }

    public final void setEp(int i11) {
        this.f51068ep = i11;
    }

    public final void setEpse(int i11) {
        this.epse = i11;
    }

    public final void setErrorCount(int i11) {
        this.errorCount = i11;
    }

    public final void setException(DownloadException downloadException) {
        this.exception = downloadException;
    }

    public final void setFileType(int i11) {
        this.fileType = i11;
    }

    public final void setFroYouList(boolean z11) {
        this.isFroYouList = z11;
    }

    public final void setGenre(String str) {
        this.genre = str;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setImdbRate(String str) {
        this.imdbRate = str;
    }

    public final void setIndex(int i11) {
        this.index = i11;
    }

    public void setItemType(int i11) {
        this.itemType = i11;
    }

    public final void setLastAdEndTimeStamp(Long l11) {
        this.lastAdEndTimeStamp = l11;
    }

    public final void setLastAdStartTimeStamp(Long l11) {
        this.lastAdStartTimeStamp = l11;
    }

    public final void setLastPageFrom(String str) {
        this.lastPageFrom = str;
    }

    public final void setLastPlayTimeStamp(long j11) {
        this.lastPlayTimeStamp = j11;
    }

    public final void setLastProgress(long j11) {
        this.lastProgress = j11;
    }

    public final void setMore(boolean z11) {
        this.isMore = z11;
    }

    public final void setMultiresolution(int i11) {
        this.multiresolution = i11;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setPageFrom(String str) {
        this.pageFrom = str;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final void setPlaying(boolean z11) {
        this.isPlaying = z11;
    }

    public final void setPlayingUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.playingUrl = str;
    }

    public final void setPosition(int i11) {
        this.position = i11;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final void setPreDownload(boolean z11) {
        this.isPreDownload = z11;
    }

    public final void setPreErrorCode(int i11) {
        this.preErrorCode = i11;
    }

    public final void setPreStatus(int i11) {
        this.preStatus = i11;
    }

    public final void setProgress(long j11) {
        this.progress = j11;
    }

    public final void setQuitDPRestart(boolean z11) {
        this.isQuitDPRestart = z11;
    }

    public final void setReDownload(boolean z11) {
        this.reDownload = z11;
    }

    public final void setRead(int i11) {
        this.isRead = i11;
    }

    public final void setReadProgress(long j11) {
        this.readProgress = j11;
    }

    public final void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public final void setReportStatus(int i11) {
        this.reportStatus = i11;
    }

    public final void setRequestNewSourceCount(int i11) {
        this.requestNewSourceCount = i11;
    }

    public final void setRequireMemberType(Integer num) {
        this.requireMemberType = num;
    }

    public final void setResolution(int i11) {
        this.resolution = i11;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final void setResourcePosition(int i11) {
        this.resourcePosition = i11;
    }

    public final void setRestartDownloadCount(int i11) {
        this.restartDownloadCount = i11;
    }

    public final void setRestrictLevel(String str) {
        this.restrictLevel = str;
    }

    public final void setRootPath(String str) {
        this.rootPath = str;
    }

    public final void setRootPathType(int i11) {
        this.rootPathType = i11;
    }

    public final void setSe(int i11) {
        this.f51069se = i11;
    }

    public final void setSeNum(Integer num) {
        this.seNum = num;
    }

    public final void setSeriesAllCheck(boolean z11) {
        this.isSeriesAllCheck = z11;
    }

    public final void setSeriesList(List<DownloadBean> list) {
        Intrinsics.g(list, "<set-?>");
        this.seriesList = list;
    }

    public final void setSessionTime(long j11) {
        this.sessionTime = j11;
    }

    public final void setSize(Long l11) {
        this.size = l11;
    }

    public final void setSizeFormat(String str) {
        this.sizeFormat = str;
    }

    public final void setSourceUrl(String str) {
        this.sourceUrl = str;
    }

    public final void setStartRequested(boolean z11) {
        this.isStartRequested = z11;
    }

    public final void setStatus(int i11) {
        this.status = i11;
    }

    public final void setStream(boolean z11) {
        this.isStream = z11;
    }

    public final void setStreamVideoDetail(boolean z11) {
        this.isStreamVideoDetail = z11;
    }

    public final void setSubjectDurationSeconds(Integer num) {
        this.subjectDurationSeconds = num;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setSubjectName(String str) {
        this.subjectName = str;
    }

    public final void setSubjectType(int i11) {
        this.subjectType = i11;
    }

    public final void setSubtitleList(List<SubtitleBean> list) {
        Intrinsics.g(list, "<set-?>");
        this.subtitleList = list;
    }

    public final void setSubtitleSelectId(String str) {
        this.subtitleSelectId = str;
    }

    public final void setSubtitleStarted(int i11) {
        this.subtitleStarted = i11;
    }

    public final void setSubtitles(String str) {
        this.subtitles = str;
    }

    public final void setSupportRanges(int i11) {
        this.supportRanges = i11;
    }

    public final void setSupportRanges(boolean z11) {
        this.supportRanges = !z11 ? 1 : 0;
    }

    public final void setTaskId(String str) {
        this.taskId = str;
    }

    public final void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public final void setTotalEpisode(int i11) {
        this.totalEpisode = i11;
    }

    public final void setTransferFailed(boolean z11) {
        this.isTransferFailed = z11;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public final void setUpdateTimeStamp(Long l11) {
        this.updateTimeStamp = l11;
    }

    public final void setUploadBy(String str) {
        this.uploadBy = str;
    }

    public final void setUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.url = str;
    }

    public final void setUrlCreateAt(long j11) {
        this.urlCreateAt = j11;
    }

    public final void setVideoHeight(int i11) {
        this.videoHeight = i11;
    }

    public final void setVideoWidth(int i11) {
        this.videoWidth = i11;
    }

    public final void setWrapNativeManager(TAdditionalListener tAdditionalListener) {
        this.wrapNativeManager = tAdditionalListener;
    }
}
