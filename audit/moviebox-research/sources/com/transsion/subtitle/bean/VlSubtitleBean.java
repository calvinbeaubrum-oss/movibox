package com.transsion.subtitle.bean;

import androidx.annotation.Keep;
import androidx.compose.animation.core.r;
import com.transsion.moviedetailapi.bean.SubtitleItem;
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
@Keep
@Metadata
public final class VlSubtitleBean {
    private final String IDMovie;
    private final String IDMovieImdb;
    private final String IDSubMovieFile;
    private final String IDSubtitle;
    private final String IDSubtitleFile;
    private final String ISO639;
    private final String InfoFormat;
    private final String InfoOther;
    private final String InfoReleaseGroup;
    private final String LanguageName;
    private final String MatchedBy;
    private final String MovieByteSize;
    private final String MovieFPS;
    private final String MovieHash;
    private final String MovieImdbRating;
    private final String MovieKind;
    private final String MovieName;
    private final Object MovieNameEng;
    private final String MovieReleaseName;
    private final String MovieTimeMS;
    private final String MovieYear;
    private final int QueryCached;
    private final String QueryNumber;
    private final QueryParameters QueryParameters;
    private final double Score;
    private final String SeriesEpisode;
    private final String SeriesIMDBParent;
    private final String SeriesSeason;
    private final String SubActualCD;
    private final String SubAddDate;
    private final String SubAuthorComment;
    private final String SubAutoTranslation;
    private final String SubBad;
    private final String SubComments;
    private final String SubDownloadLink;
    private final String SubDownloadsCnt;
    private final String SubEncoding;
    private final String SubFeatured;
    private final String SubFileName;
    private final String SubForeignPartsOnly;
    private final String SubFormat;
    private final String SubFromTrusted;
    private final String SubHD;
    private final String SubHash;
    private final String SubHearingImpaired;
    private final String SubLanguageID;
    private final String SubLastTS;
    private final String SubRating;
    private final String SubSize;
    private final String SubSumCD;
    private final String SubSumVotes;
    private final String SubTSGroup;
    private final String SubTSGroupHash;
    private final String SubTranslator;
    private final String SubtitlesLink;
    private final String UserID;
    private final String UserNickName;
    private final String UserRank;
    private final String ZipDownloadLink;

    public VlSubtitleBean(String IDMovie, String IDMovieImdb, String IDSubMovieFile, String IDSubtitle, String IDSubtitleFile, String ISO639, String InfoFormat, String InfoOther, String InfoReleaseGroup, String LanguageName, String MatchedBy, String MovieByteSize, String MovieFPS, String MovieHash, String MovieImdbRating, String MovieKind, String MovieName, Object MovieNameEng, String MovieReleaseName, String MovieTimeMS, String MovieYear, int i11, String QueryNumber, QueryParameters QueryParameters, double d11, String SeriesEpisode, String SeriesIMDBParent, String SeriesSeason, String SubActualCD, String SubAddDate, String SubAuthorComment, String SubAutoTranslation, String SubBad, String SubComments, String SubDownloadLink, String SubDownloadsCnt, String SubEncoding, String SubFeatured, String SubFileName, String SubForeignPartsOnly, String SubFormat, String SubFromTrusted, String SubHD, String SubHash, String SubHearingImpaired, String SubLanguageID, String SubLastTS, String SubRating, String SubSize, String SubSumCD, String SubSumVotes, String SubTSGroup, String SubTSGroupHash, String SubTranslator, String SubtitlesLink, String UserID, String UserNickName, String UserRank, String ZipDownloadLink) {
        Intrinsics.g(IDMovie, "IDMovie");
        Intrinsics.g(IDMovieImdb, "IDMovieImdb");
        Intrinsics.g(IDSubMovieFile, "IDSubMovieFile");
        Intrinsics.g(IDSubtitle, "IDSubtitle");
        Intrinsics.g(IDSubtitleFile, "IDSubtitleFile");
        Intrinsics.g(ISO639, "ISO639");
        Intrinsics.g(InfoFormat, "InfoFormat");
        Intrinsics.g(InfoOther, "InfoOther");
        Intrinsics.g(InfoReleaseGroup, "InfoReleaseGroup");
        Intrinsics.g(LanguageName, "LanguageName");
        Intrinsics.g(MatchedBy, "MatchedBy");
        Intrinsics.g(MovieByteSize, "MovieByteSize");
        Intrinsics.g(MovieFPS, "MovieFPS");
        Intrinsics.g(MovieHash, "MovieHash");
        Intrinsics.g(MovieImdbRating, "MovieImdbRating");
        Intrinsics.g(MovieKind, "MovieKind");
        Intrinsics.g(MovieName, "MovieName");
        Intrinsics.g(MovieNameEng, "MovieNameEng");
        Intrinsics.g(MovieReleaseName, "MovieReleaseName");
        Intrinsics.g(MovieTimeMS, "MovieTimeMS");
        Intrinsics.g(MovieYear, "MovieYear");
        Intrinsics.g(QueryNumber, "QueryNumber");
        Intrinsics.g(QueryParameters, "QueryParameters");
        Intrinsics.g(SeriesEpisode, "SeriesEpisode");
        Intrinsics.g(SeriesIMDBParent, "SeriesIMDBParent");
        Intrinsics.g(SeriesSeason, "SeriesSeason");
        Intrinsics.g(SubActualCD, "SubActualCD");
        Intrinsics.g(SubAddDate, "SubAddDate");
        Intrinsics.g(SubAuthorComment, "SubAuthorComment");
        Intrinsics.g(SubAutoTranslation, "SubAutoTranslation");
        Intrinsics.g(SubBad, "SubBad");
        Intrinsics.g(SubComments, "SubComments");
        Intrinsics.g(SubDownloadLink, "SubDownloadLink");
        Intrinsics.g(SubDownloadsCnt, "SubDownloadsCnt");
        Intrinsics.g(SubEncoding, "SubEncoding");
        Intrinsics.g(SubFeatured, "SubFeatured");
        Intrinsics.g(SubFileName, "SubFileName");
        Intrinsics.g(SubForeignPartsOnly, "SubForeignPartsOnly");
        Intrinsics.g(SubFormat, "SubFormat");
        Intrinsics.g(SubFromTrusted, "SubFromTrusted");
        Intrinsics.g(SubHD, "SubHD");
        Intrinsics.g(SubHash, "SubHash");
        Intrinsics.g(SubHearingImpaired, "SubHearingImpaired");
        Intrinsics.g(SubLanguageID, "SubLanguageID");
        Intrinsics.g(SubLastTS, "SubLastTS");
        Intrinsics.g(SubRating, "SubRating");
        Intrinsics.g(SubSize, "SubSize");
        Intrinsics.g(SubSumCD, "SubSumCD");
        Intrinsics.g(SubSumVotes, "SubSumVotes");
        Intrinsics.g(SubTSGroup, "SubTSGroup");
        Intrinsics.g(SubTSGroupHash, "SubTSGroupHash");
        Intrinsics.g(SubTranslator, "SubTranslator");
        Intrinsics.g(SubtitlesLink, "SubtitlesLink");
        Intrinsics.g(UserID, "UserID");
        Intrinsics.g(UserNickName, "UserNickName");
        Intrinsics.g(UserRank, "UserRank");
        Intrinsics.g(ZipDownloadLink, "ZipDownloadLink");
        this.IDMovie = IDMovie;
        this.IDMovieImdb = IDMovieImdb;
        this.IDSubMovieFile = IDSubMovieFile;
        this.IDSubtitle = IDSubtitle;
        this.IDSubtitleFile = IDSubtitleFile;
        this.ISO639 = ISO639;
        this.InfoFormat = InfoFormat;
        this.InfoOther = InfoOther;
        this.InfoReleaseGroup = InfoReleaseGroup;
        this.LanguageName = LanguageName;
        this.MatchedBy = MatchedBy;
        this.MovieByteSize = MovieByteSize;
        this.MovieFPS = MovieFPS;
        this.MovieHash = MovieHash;
        this.MovieImdbRating = MovieImdbRating;
        this.MovieKind = MovieKind;
        this.MovieName = MovieName;
        this.MovieNameEng = MovieNameEng;
        this.MovieReleaseName = MovieReleaseName;
        this.MovieTimeMS = MovieTimeMS;
        this.MovieYear = MovieYear;
        this.QueryCached = i11;
        this.QueryNumber = QueryNumber;
        this.QueryParameters = QueryParameters;
        this.Score = d11;
        this.SeriesEpisode = SeriesEpisode;
        this.SeriesIMDBParent = SeriesIMDBParent;
        this.SeriesSeason = SeriesSeason;
        this.SubActualCD = SubActualCD;
        this.SubAddDate = SubAddDate;
        this.SubAuthorComment = SubAuthorComment;
        this.SubAutoTranslation = SubAutoTranslation;
        this.SubBad = SubBad;
        this.SubComments = SubComments;
        this.SubDownloadLink = SubDownloadLink;
        this.SubDownloadsCnt = SubDownloadsCnt;
        this.SubEncoding = SubEncoding;
        this.SubFeatured = SubFeatured;
        this.SubFileName = SubFileName;
        this.SubForeignPartsOnly = SubForeignPartsOnly;
        this.SubFormat = SubFormat;
        this.SubFromTrusted = SubFromTrusted;
        this.SubHD = SubHD;
        this.SubHash = SubHash;
        this.SubHearingImpaired = SubHearingImpaired;
        this.SubLanguageID = SubLanguageID;
        this.SubLastTS = SubLastTS;
        this.SubRating = SubRating;
        this.SubSize = SubSize;
        this.SubSumCD = SubSumCD;
        this.SubSumVotes = SubSumVotes;
        this.SubTSGroup = SubTSGroup;
        this.SubTSGroupHash = SubTSGroupHash;
        this.SubTranslator = SubTranslator;
        this.SubtitlesLink = SubtitlesLink;
        this.UserID = UserID;
        this.UserNickName = UserNickName;
        this.UserRank = UserRank;
        this.ZipDownloadLink = ZipDownloadLink;
    }

    public final String component1() {
        return this.IDMovie;
    }

    public final String component10() {
        return this.LanguageName;
    }

    public final String component11() {
        return this.MatchedBy;
    }

    public final String component12() {
        return this.MovieByteSize;
    }

    public final String component13() {
        return this.MovieFPS;
    }

    public final String component14() {
        return this.MovieHash;
    }

    public final String component15() {
        return this.MovieImdbRating;
    }

    public final String component16() {
        return this.MovieKind;
    }

    public final String component17() {
        return this.MovieName;
    }

    public final Object component18() {
        return this.MovieNameEng;
    }

    public final String component19() {
        return this.MovieReleaseName;
    }

    public final String component2() {
        return this.IDMovieImdb;
    }

    public final String component20() {
        return this.MovieTimeMS;
    }

    public final String component21() {
        return this.MovieYear;
    }

    public final int component22() {
        return this.QueryCached;
    }

    public final String component23() {
        return this.QueryNumber;
    }

    public final QueryParameters component24() {
        return this.QueryParameters;
    }

    public final double component25() {
        return this.Score;
    }

    public final String component26() {
        return this.SeriesEpisode;
    }

    public final String component27() {
        return this.SeriesIMDBParent;
    }

    public final String component28() {
        return this.SeriesSeason;
    }

    public final String component29() {
        return this.SubActualCD;
    }

    public final String component3() {
        return this.IDSubMovieFile;
    }

    public final String component30() {
        return this.SubAddDate;
    }

    public final String component31() {
        return this.SubAuthorComment;
    }

    public final String component32() {
        return this.SubAutoTranslation;
    }

    public final String component33() {
        return this.SubBad;
    }

    public final String component34() {
        return this.SubComments;
    }

    public final String component35() {
        return this.SubDownloadLink;
    }

    public final String component36() {
        return this.SubDownloadsCnt;
    }

    public final String component37() {
        return this.SubEncoding;
    }

    public final String component38() {
        return this.SubFeatured;
    }

    public final String component39() {
        return this.SubFileName;
    }

    public final String component4() {
        return this.IDSubtitle;
    }

    public final String component40() {
        return this.SubForeignPartsOnly;
    }

    public final String component41() {
        return this.SubFormat;
    }

    public final String component42() {
        return this.SubFromTrusted;
    }

    public final String component43() {
        return this.SubHD;
    }

    public final String component44() {
        return this.SubHash;
    }

    public final String component45() {
        return this.SubHearingImpaired;
    }

    public final String component46() {
        return this.SubLanguageID;
    }

    public final String component47() {
        return this.SubLastTS;
    }

    public final String component48() {
        return this.SubRating;
    }

    public final String component49() {
        return this.SubSize;
    }

    public final String component5() {
        return this.IDSubtitleFile;
    }

    public final String component50() {
        return this.SubSumCD;
    }

    public final String component51() {
        return this.SubSumVotes;
    }

    public final String component52() {
        return this.SubTSGroup;
    }

    public final String component53() {
        return this.SubTSGroupHash;
    }

    public final String component54() {
        return this.SubTranslator;
    }

    public final String component55() {
        return this.SubtitlesLink;
    }

    public final String component56() {
        return this.UserID;
    }

    public final String component57() {
        return this.UserNickName;
    }

    public final String component58() {
        return this.UserRank;
    }

    public final String component59() {
        return this.ZipDownloadLink;
    }

    public final String component6() {
        return this.ISO639;
    }

    public final String component7() {
        return this.InfoFormat;
    }

    public final String component8() {
        return this.InfoOther;
    }

    public final String component9() {
        return this.InfoReleaseGroup;
    }

    public final VlSubtitleBean copy(String IDMovie, String IDMovieImdb, String IDSubMovieFile, String IDSubtitle, String IDSubtitleFile, String ISO639, String InfoFormat, String InfoOther, String InfoReleaseGroup, String LanguageName, String MatchedBy, String MovieByteSize, String MovieFPS, String MovieHash, String MovieImdbRating, String MovieKind, String MovieName, Object MovieNameEng, String MovieReleaseName, String MovieTimeMS, String MovieYear, int i11, String QueryNumber, QueryParameters QueryParameters, double d11, String SeriesEpisode, String SeriesIMDBParent, String SeriesSeason, String SubActualCD, String SubAddDate, String SubAuthorComment, String SubAutoTranslation, String SubBad, String SubComments, String SubDownloadLink, String SubDownloadsCnt, String SubEncoding, String SubFeatured, String SubFileName, String SubForeignPartsOnly, String SubFormat, String SubFromTrusted, String SubHD, String SubHash, String SubHearingImpaired, String SubLanguageID, String SubLastTS, String SubRating, String SubSize, String SubSumCD, String SubSumVotes, String SubTSGroup, String SubTSGroupHash, String SubTranslator, String SubtitlesLink, String UserID, String UserNickName, String UserRank, String ZipDownloadLink) {
        Intrinsics.g(IDMovie, "IDMovie");
        Intrinsics.g(IDMovieImdb, "IDMovieImdb");
        Intrinsics.g(IDSubMovieFile, "IDSubMovieFile");
        Intrinsics.g(IDSubtitle, "IDSubtitle");
        Intrinsics.g(IDSubtitleFile, "IDSubtitleFile");
        Intrinsics.g(ISO639, "ISO639");
        Intrinsics.g(InfoFormat, "InfoFormat");
        Intrinsics.g(InfoOther, "InfoOther");
        Intrinsics.g(InfoReleaseGroup, "InfoReleaseGroup");
        Intrinsics.g(LanguageName, "LanguageName");
        Intrinsics.g(MatchedBy, "MatchedBy");
        Intrinsics.g(MovieByteSize, "MovieByteSize");
        Intrinsics.g(MovieFPS, "MovieFPS");
        Intrinsics.g(MovieHash, "MovieHash");
        Intrinsics.g(MovieImdbRating, "MovieImdbRating");
        Intrinsics.g(MovieKind, "MovieKind");
        Intrinsics.g(MovieName, "MovieName");
        Intrinsics.g(MovieNameEng, "MovieNameEng");
        Intrinsics.g(MovieReleaseName, "MovieReleaseName");
        Intrinsics.g(MovieTimeMS, "MovieTimeMS");
        Intrinsics.g(MovieYear, "MovieYear");
        Intrinsics.g(QueryNumber, "QueryNumber");
        Intrinsics.g(QueryParameters, "QueryParameters");
        Intrinsics.g(SeriesEpisode, "SeriesEpisode");
        Intrinsics.g(SeriesIMDBParent, "SeriesIMDBParent");
        Intrinsics.g(SeriesSeason, "SeriesSeason");
        Intrinsics.g(SubActualCD, "SubActualCD");
        Intrinsics.g(SubAddDate, "SubAddDate");
        Intrinsics.g(SubAuthorComment, "SubAuthorComment");
        Intrinsics.g(SubAutoTranslation, "SubAutoTranslation");
        Intrinsics.g(SubBad, "SubBad");
        Intrinsics.g(SubComments, "SubComments");
        Intrinsics.g(SubDownloadLink, "SubDownloadLink");
        Intrinsics.g(SubDownloadsCnt, "SubDownloadsCnt");
        Intrinsics.g(SubEncoding, "SubEncoding");
        Intrinsics.g(SubFeatured, "SubFeatured");
        Intrinsics.g(SubFileName, "SubFileName");
        Intrinsics.g(SubForeignPartsOnly, "SubForeignPartsOnly");
        Intrinsics.g(SubFormat, "SubFormat");
        Intrinsics.g(SubFromTrusted, "SubFromTrusted");
        Intrinsics.g(SubHD, "SubHD");
        Intrinsics.g(SubHash, "SubHash");
        Intrinsics.g(SubHearingImpaired, "SubHearingImpaired");
        Intrinsics.g(SubLanguageID, "SubLanguageID");
        Intrinsics.g(SubLastTS, "SubLastTS");
        Intrinsics.g(SubRating, "SubRating");
        Intrinsics.g(SubSize, "SubSize");
        Intrinsics.g(SubSumCD, "SubSumCD");
        Intrinsics.g(SubSumVotes, "SubSumVotes");
        Intrinsics.g(SubTSGroup, "SubTSGroup");
        Intrinsics.g(SubTSGroupHash, "SubTSGroupHash");
        Intrinsics.g(SubTranslator, "SubTranslator");
        Intrinsics.g(SubtitlesLink, "SubtitlesLink");
        Intrinsics.g(UserID, "UserID");
        Intrinsics.g(UserNickName, "UserNickName");
        Intrinsics.g(UserRank, "UserRank");
        Intrinsics.g(ZipDownloadLink, "ZipDownloadLink");
        return new VlSubtitleBean(IDMovie, IDMovieImdb, IDSubMovieFile, IDSubtitle, IDSubtitleFile, ISO639, InfoFormat, InfoOther, InfoReleaseGroup, LanguageName, MatchedBy, MovieByteSize, MovieFPS, MovieHash, MovieImdbRating, MovieKind, MovieName, MovieNameEng, MovieReleaseName, MovieTimeMS, MovieYear, i11, QueryNumber, QueryParameters, d11, SeriesEpisode, SeriesIMDBParent, SeriesSeason, SubActualCD, SubAddDate, SubAuthorComment, SubAutoTranslation, SubBad, SubComments, SubDownloadLink, SubDownloadsCnt, SubEncoding, SubFeatured, SubFileName, SubForeignPartsOnly, SubFormat, SubFromTrusted, SubHD, SubHash, SubHearingImpaired, SubLanguageID, SubLastTS, SubRating, SubSize, SubSumCD, SubSumVotes, SubTSGroup, SubTSGroupHash, SubTranslator, SubtitlesLink, UserID, UserNickName, UserRank, ZipDownloadLink);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VlSubtitleBean)) {
            return false;
        }
        VlSubtitleBean vlSubtitleBean = (VlSubtitleBean) obj;
        return Intrinsics.b(this.IDMovie, vlSubtitleBean.IDMovie) && Intrinsics.b(this.IDMovieImdb, vlSubtitleBean.IDMovieImdb) && Intrinsics.b(this.IDSubMovieFile, vlSubtitleBean.IDSubMovieFile) && Intrinsics.b(this.IDSubtitle, vlSubtitleBean.IDSubtitle) && Intrinsics.b(this.IDSubtitleFile, vlSubtitleBean.IDSubtitleFile) && Intrinsics.b(this.ISO639, vlSubtitleBean.ISO639) && Intrinsics.b(this.InfoFormat, vlSubtitleBean.InfoFormat) && Intrinsics.b(this.InfoOther, vlSubtitleBean.InfoOther) && Intrinsics.b(this.InfoReleaseGroup, vlSubtitleBean.InfoReleaseGroup) && Intrinsics.b(this.LanguageName, vlSubtitleBean.LanguageName) && Intrinsics.b(this.MatchedBy, vlSubtitleBean.MatchedBy) && Intrinsics.b(this.MovieByteSize, vlSubtitleBean.MovieByteSize) && Intrinsics.b(this.MovieFPS, vlSubtitleBean.MovieFPS) && Intrinsics.b(this.MovieHash, vlSubtitleBean.MovieHash) && Intrinsics.b(this.MovieImdbRating, vlSubtitleBean.MovieImdbRating) && Intrinsics.b(this.MovieKind, vlSubtitleBean.MovieKind) && Intrinsics.b(this.MovieName, vlSubtitleBean.MovieName) && Intrinsics.b(this.MovieNameEng, vlSubtitleBean.MovieNameEng) && Intrinsics.b(this.MovieReleaseName, vlSubtitleBean.MovieReleaseName) && Intrinsics.b(this.MovieTimeMS, vlSubtitleBean.MovieTimeMS) && Intrinsics.b(this.MovieYear, vlSubtitleBean.MovieYear) && this.QueryCached == vlSubtitleBean.QueryCached && Intrinsics.b(this.QueryNumber, vlSubtitleBean.QueryNumber) && Intrinsics.b(this.QueryParameters, vlSubtitleBean.QueryParameters) && Double.compare(this.Score, vlSubtitleBean.Score) == 0 && Intrinsics.b(this.SeriesEpisode, vlSubtitleBean.SeriesEpisode) && Intrinsics.b(this.SeriesIMDBParent, vlSubtitleBean.SeriesIMDBParent) && Intrinsics.b(this.SeriesSeason, vlSubtitleBean.SeriesSeason) && Intrinsics.b(this.SubActualCD, vlSubtitleBean.SubActualCD) && Intrinsics.b(this.SubAddDate, vlSubtitleBean.SubAddDate) && Intrinsics.b(this.SubAuthorComment, vlSubtitleBean.SubAuthorComment) && Intrinsics.b(this.SubAutoTranslation, vlSubtitleBean.SubAutoTranslation) && Intrinsics.b(this.SubBad, vlSubtitleBean.SubBad) && Intrinsics.b(this.SubComments, vlSubtitleBean.SubComments) && Intrinsics.b(this.SubDownloadLink, vlSubtitleBean.SubDownloadLink) && Intrinsics.b(this.SubDownloadsCnt, vlSubtitleBean.SubDownloadsCnt) && Intrinsics.b(this.SubEncoding, vlSubtitleBean.SubEncoding) && Intrinsics.b(this.SubFeatured, vlSubtitleBean.SubFeatured) && Intrinsics.b(this.SubFileName, vlSubtitleBean.SubFileName) && Intrinsics.b(this.SubForeignPartsOnly, vlSubtitleBean.SubForeignPartsOnly) && Intrinsics.b(this.SubFormat, vlSubtitleBean.SubFormat) && Intrinsics.b(this.SubFromTrusted, vlSubtitleBean.SubFromTrusted) && Intrinsics.b(this.SubHD, vlSubtitleBean.SubHD) && Intrinsics.b(this.SubHash, vlSubtitleBean.SubHash) && Intrinsics.b(this.SubHearingImpaired, vlSubtitleBean.SubHearingImpaired) && Intrinsics.b(this.SubLanguageID, vlSubtitleBean.SubLanguageID) && Intrinsics.b(this.SubLastTS, vlSubtitleBean.SubLastTS) && Intrinsics.b(this.SubRating, vlSubtitleBean.SubRating) && Intrinsics.b(this.SubSize, vlSubtitleBean.SubSize) && Intrinsics.b(this.SubSumCD, vlSubtitleBean.SubSumCD) && Intrinsics.b(this.SubSumVotes, vlSubtitleBean.SubSumVotes) && Intrinsics.b(this.SubTSGroup, vlSubtitleBean.SubTSGroup) && Intrinsics.b(this.SubTSGroupHash, vlSubtitleBean.SubTSGroupHash) && Intrinsics.b(this.SubTranslator, vlSubtitleBean.SubTranslator) && Intrinsics.b(this.SubtitlesLink, vlSubtitleBean.SubtitlesLink) && Intrinsics.b(this.UserID, vlSubtitleBean.UserID) && Intrinsics.b(this.UserNickName, vlSubtitleBean.UserNickName) && Intrinsics.b(this.UserRank, vlSubtitleBean.UserRank) && Intrinsics.b(this.ZipDownloadLink, vlSubtitleBean.ZipDownloadLink);
    }

    public final String getIDMovie() {
        return this.IDMovie;
    }

    public final String getIDMovieImdb() {
        return this.IDMovieImdb;
    }

    public final String getIDSubMovieFile() {
        return this.IDSubMovieFile;
    }

    public final String getIDSubtitle() {
        return this.IDSubtitle;
    }

    public final String getIDSubtitleFile() {
        return this.IDSubtitleFile;
    }

    public final String getISO639() {
        return this.ISO639;
    }

    public final String getInfoFormat() {
        return this.InfoFormat;
    }

    public final String getInfoOther() {
        return this.InfoOther;
    }

    public final String getInfoReleaseGroup() {
        return this.InfoReleaseGroup;
    }

    public final String getLanguageName() {
        return this.LanguageName;
    }

    public final String getMatchedBy() {
        return this.MatchedBy;
    }

    public final String getMovieByteSize() {
        return this.MovieByteSize;
    }

    public final String getMovieFPS() {
        return this.MovieFPS;
    }

    public final String getMovieHash() {
        return this.MovieHash;
    }

    public final String getMovieImdbRating() {
        return this.MovieImdbRating;
    }

    public final String getMovieKind() {
        return this.MovieKind;
    }

    public final String getMovieName() {
        return this.MovieName;
    }

    public final Object getMovieNameEng() {
        return this.MovieNameEng;
    }

    public final String getMovieReleaseName() {
        return this.MovieReleaseName;
    }

    public final String getMovieTimeMS() {
        return this.MovieTimeMS;
    }

    public final String getMovieYear() {
        return this.MovieYear;
    }

    public final int getQueryCached() {
        return this.QueryCached;
    }

    public final String getQueryNumber() {
        return this.QueryNumber;
    }

    public final QueryParameters getQueryParameters() {
        return this.QueryParameters;
    }

    public final double getScore() {
        return this.Score;
    }

    public final String getSeriesEpisode() {
        return this.SeriesEpisode;
    }

    public final String getSeriesIMDBParent() {
        return this.SeriesIMDBParent;
    }

    public final String getSeriesSeason() {
        return this.SeriesSeason;
    }

    public final String getSubActualCD() {
        return this.SubActualCD;
    }

    public final String getSubAddDate() {
        return this.SubAddDate;
    }

    public final String getSubAuthorComment() {
        return this.SubAuthorComment;
    }

    public final String getSubAutoTranslation() {
        return this.SubAutoTranslation;
    }

    public final String getSubBad() {
        return this.SubBad;
    }

    public final String getSubComments() {
        return this.SubComments;
    }

    public final String getSubDownloadLink() {
        return this.SubDownloadLink;
    }

    public final String getSubDownloadsCnt() {
        return this.SubDownloadsCnt;
    }

    public final String getSubEncoding() {
        return this.SubEncoding;
    }

    public final String getSubFeatured() {
        return this.SubFeatured;
    }

    public final String getSubFileName() {
        return this.SubFileName;
    }

    public final String getSubForeignPartsOnly() {
        return this.SubForeignPartsOnly;
    }

    public final String getSubFormat() {
        return this.SubFormat;
    }

    public final String getSubFromTrusted() {
        return this.SubFromTrusted;
    }

    public final String getSubHD() {
        return this.SubHD;
    }

    public final String getSubHash() {
        return this.SubHash;
    }

    public final String getSubHearingImpaired() {
        return this.SubHearingImpaired;
    }

    public final String getSubLanguageID() {
        return this.SubLanguageID;
    }

    public final String getSubLastTS() {
        return this.SubLastTS;
    }

    public final String getSubRating() {
        return this.SubRating;
    }

    public final String getSubSize() {
        return this.SubSize;
    }

    public final String getSubSumCD() {
        return this.SubSumCD;
    }

    public final String getSubSumVotes() {
        return this.SubSumVotes;
    }

    public final String getSubTSGroup() {
        return this.SubTSGroup;
    }

    public final String getSubTSGroupHash() {
        return this.SubTSGroupHash;
    }

    public final String getSubTranslator() {
        return this.SubTranslator;
    }

    public final String getSubtitlesLink() {
        return this.SubtitlesLink;
    }

    public final String getUserID() {
        return this.UserID;
    }

    public final String getUserNickName() {
        return this.UserNickName;
    }

    public final String getUserRank() {
        return this.UserRank;
    }

    public final String getZipDownloadLink() {
        return this.ZipDownloadLink;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.IDMovie.hashCode() * 31) + this.IDMovieImdb.hashCode()) * 31) + this.IDSubMovieFile.hashCode()) * 31) + this.IDSubtitle.hashCode()) * 31) + this.IDSubtitleFile.hashCode()) * 31) + this.ISO639.hashCode()) * 31) + this.InfoFormat.hashCode()) * 31) + this.InfoOther.hashCode()) * 31) + this.InfoReleaseGroup.hashCode()) * 31) + this.LanguageName.hashCode()) * 31) + this.MatchedBy.hashCode()) * 31) + this.MovieByteSize.hashCode()) * 31) + this.MovieFPS.hashCode()) * 31) + this.MovieHash.hashCode()) * 31) + this.MovieImdbRating.hashCode()) * 31) + this.MovieKind.hashCode()) * 31) + this.MovieName.hashCode()) * 31) + this.MovieNameEng.hashCode()) * 31) + this.MovieReleaseName.hashCode()) * 31) + this.MovieTimeMS.hashCode()) * 31) + this.MovieYear.hashCode()) * 31) + this.QueryCached) * 31) + this.QueryNumber.hashCode()) * 31) + this.QueryParameters.hashCode()) * 31) + r.a(this.Score)) * 31) + this.SeriesEpisode.hashCode()) * 31) + this.SeriesIMDBParent.hashCode()) * 31) + this.SeriesSeason.hashCode()) * 31) + this.SubActualCD.hashCode()) * 31) + this.SubAddDate.hashCode()) * 31) + this.SubAuthorComment.hashCode()) * 31) + this.SubAutoTranslation.hashCode()) * 31) + this.SubBad.hashCode()) * 31) + this.SubComments.hashCode()) * 31) + this.SubDownloadLink.hashCode()) * 31) + this.SubDownloadsCnt.hashCode()) * 31) + this.SubEncoding.hashCode()) * 31) + this.SubFeatured.hashCode()) * 31) + this.SubFileName.hashCode()) * 31) + this.SubForeignPartsOnly.hashCode()) * 31) + this.SubFormat.hashCode()) * 31) + this.SubFromTrusted.hashCode()) * 31) + this.SubHD.hashCode()) * 31) + this.SubHash.hashCode()) * 31) + this.SubHearingImpaired.hashCode()) * 31) + this.SubLanguageID.hashCode()) * 31) + this.SubLastTS.hashCode()) * 31) + this.SubRating.hashCode()) * 31) + this.SubSize.hashCode()) * 31) + this.SubSumCD.hashCode()) * 31) + this.SubSumVotes.hashCode()) * 31) + this.SubTSGroup.hashCode()) * 31) + this.SubTSGroupHash.hashCode()) * 31) + this.SubTranslator.hashCode()) * 31) + this.SubtitlesLink.hashCode()) * 31) + this.UserID.hashCode()) * 31) + this.UserNickName.hashCode()) * 31) + this.UserRank.hashCode()) * 31) + this.ZipDownloadLink.hashCode();
    }

    public String toString() {
        return "VlSubtitleBean(IDMovie=" + this.IDMovie + ", IDMovieImdb=" + this.IDMovieImdb + ", IDSubMovieFile=" + this.IDSubMovieFile + ", IDSubtitle=" + this.IDSubtitle + ", IDSubtitleFile=" + this.IDSubtitleFile + ", ISO639=" + this.ISO639 + ", InfoFormat=" + this.InfoFormat + ", InfoOther=" + this.InfoOther + ", InfoReleaseGroup=" + this.InfoReleaseGroup + ", LanguageName=" + this.LanguageName + ", MatchedBy=" + this.MatchedBy + ", MovieByteSize=" + this.MovieByteSize + ", MovieFPS=" + this.MovieFPS + ", MovieHash=" + this.MovieHash + ", MovieImdbRating=" + this.MovieImdbRating + ", MovieKind=" + this.MovieKind + ", MovieName=" + this.MovieName + ", MovieNameEng=" + this.MovieNameEng + ", MovieReleaseName=" + this.MovieReleaseName + ", MovieTimeMS=" + this.MovieTimeMS + ", MovieYear=" + this.MovieYear + ", QueryCached=" + this.QueryCached + ", QueryNumber=" + this.QueryNumber + ", QueryParameters=" + this.QueryParameters + ", Score=" + this.Score + ", SeriesEpisode=" + this.SeriesEpisode + ", SeriesIMDBParent=" + this.SeriesIMDBParent + ", SeriesSeason=" + this.SeriesSeason + ", SubActualCD=" + this.SubActualCD + ", SubAddDate=" + this.SubAddDate + ", SubAuthorComment=" + this.SubAuthorComment + ", SubAutoTranslation=" + this.SubAutoTranslation + ", SubBad=" + this.SubBad + ", SubComments=" + this.SubComments + ", SubDownloadLink=" + this.SubDownloadLink + ", SubDownloadsCnt=" + this.SubDownloadsCnt + ", SubEncoding=" + this.SubEncoding + ", SubFeatured=" + this.SubFeatured + ", SubFileName=" + this.SubFileName + ", SubForeignPartsOnly=" + this.SubForeignPartsOnly + ", SubFormat=" + this.SubFormat + ", SubFromTrusted=" + this.SubFromTrusted + ", SubHD=" + this.SubHD + ", SubHash=" + this.SubHash + ", SubHearingImpaired=" + this.SubHearingImpaired + ", SubLanguageID=" + this.SubLanguageID + ", SubLastTS=" + this.SubLastTS + ", SubRating=" + this.SubRating + ", SubSize=" + this.SubSize + ", SubSumCD=" + this.SubSumCD + ", SubSumVotes=" + this.SubSumVotes + ", SubTSGroup=" + this.SubTSGroup + ", SubTSGroupHash=" + this.SubTSGroupHash + ", SubTranslator=" + this.SubTranslator + ", SubtitlesLink=" + this.SubtitlesLink + ", UserID=" + this.UserID + ", UserNickName=" + this.UserNickName + ", UserRank=" + this.UserRank + ", ZipDownloadLink=" + this.ZipDownloadLink + ")";
    }

    public final SubtitleItem toSubtitleBean() {
        long j11;
        int i11;
        int i12;
        String str = this.IDSubtitle;
        String str2 = this.ISO639;
        String str3 = this.LanguageName;
        String str4 = this.SubFileName;
        String str5 = this.SubDownloadLink;
        try {
            j11 = Long.parseLong(this.SubSize);
        } catch (Exception unused) {
            j11 = 0;
        }
        Long lValueOf = Long.valueOf(j11);
        try {
            i11 = Integer.parseInt(this.SeriesSeason);
        } catch (Exception unused2) {
            i11 = Integer.parseInt(this.QueryParameters.getSeason());
        }
        Integer numValueOf = Integer.valueOf(i11);
        try {
            i12 = Integer.parseInt(this.SeriesEpisode);
        } catch (Exception unused3) {
            i12 = Integer.parseInt(this.QueryParameters.getEpisode());
        }
        return new SubtitleItem(str, str2, str3, str4, str5, lValueOf, 0L, numValueOf, Integer.valueOf(i12), 0, 4);
    }
}
