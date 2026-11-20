package com.cloud.tmc.offline.download.model;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import rc.b;

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
/* JADX INFO: loaded from: classes4.dex */
@kotlin.Metadata
@SourceDebugExtension
public final class OfflineDownloadBuilder extends b {
    private String app;
    private String downloadModel = "startup";
    private HashMap<String, String> extInfo;
    private OffPkgConfigExtParams extParams;
    private String extraConfig;
    private String group;
    private String language;
    private String name;
    private String nation;
    private String networkType;
    private String pkgEncrypted;
    private String pkgUrl;
    private int priority;
    private HashMap<String, String> resMap;
    private String type;
    private String version;

    public final OffPkgConfig build() {
        return new OffPkgConfig(this.downloadModel, this.app, this.group, this.language, this.name, this.nation, this.networkType, this.pkgUrl, this.priority, this.version, this.type, this.resMap, this.extInfo, this.extraConfig, this.pkgEncrypted, null, this.extParams, null, 163840, null);
    }

    public final String getApp() {
        return this.app;
    }

    public final String getDownloadModel() {
        return this.downloadModel;
    }

    public final HashMap<String, String> getExtInfo() {
        return this.extInfo;
    }

    public final OffPkgConfigExtParams getExtParams() {
        return this.extParams;
    }

    public final String getExtraConfig() {
        return this.extraConfig;
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNation() {
        return this.nation;
    }

    public final String getNetworkType() {
        return this.networkType;
    }

    public final String getPkgEncrypted() {
        return this.pkgEncrypted;
    }

    public final String getPkgUrl() {
        return this.pkgUrl;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final HashMap<String, String> getResMap() {
        return this.resMap;
    }

    public final String getType() {
        return this.type;
    }

    public final String getVersion() {
        return this.version;
    }

    public final OfflineDownloadBuilder setApp(String app) {
        Intrinsics.g(app, "app");
        this.app = app;
        return this;
    }

    /* JADX INFO: renamed from: setApp, reason: collision with other method in class */
    public final void m123setApp(String str) {
        this.app = str;
    }

    public final OfflineDownloadBuilder setDownloadModel(String downloadModel) {
        Intrinsics.g(downloadModel, "downloadModel");
        this.downloadModel = downloadModel;
        return this;
    }

    /* JADX INFO: renamed from: setDownloadModel, reason: collision with other method in class */
    public final void m124setDownloadModel(String str) {
        Intrinsics.g(str, "<set-?>");
        this.downloadModel = str;
    }

    public final OfflineDownloadBuilder setExtInfo(HashMap<String, String> extInfo) {
        Intrinsics.g(extInfo, "extInfo");
        this.extInfo = extInfo;
        return this;
    }

    /* JADX INFO: renamed from: setExtInfo, reason: collision with other method in class */
    public final void m125setExtInfo(HashMap<String, String> map) {
        this.extInfo = map;
    }

    public final OfflineDownloadBuilder setExtParams(OffPkgConfigExtParams extParams) {
        Intrinsics.g(extParams, "extParams");
        this.extParams = extParams;
        return this;
    }

    /* JADX INFO: renamed from: setExtParams, reason: collision with other method in class */
    public final void m126setExtParams(OffPkgConfigExtParams offPkgConfigExtParams) {
        this.extParams = offPkgConfigExtParams;
    }

    public final OfflineDownloadBuilder setExtraConfig(String extraConfig) {
        Intrinsics.g(extraConfig, "extraConfig");
        this.extraConfig = extraConfig;
        return this;
    }

    /* JADX INFO: renamed from: setExtraConfig, reason: collision with other method in class */
    public final void m127setExtraConfig(String str) {
        this.extraConfig = str;
    }

    public final OfflineDownloadBuilder setGroup(String group) {
        Intrinsics.g(group, "group");
        this.group = group;
        return this;
    }

    /* JADX INFO: renamed from: setGroup, reason: collision with other method in class */
    public final void m128setGroup(String str) {
        this.group = str;
    }

    public final OfflineDownloadBuilder setLanguage(String language) {
        Intrinsics.g(language, "language");
        this.language = language;
        return this;
    }

    /* JADX INFO: renamed from: setLanguage, reason: collision with other method in class */
    public final void m129setLanguage(String str) {
        this.language = str;
    }

    public final OfflineDownloadBuilder setName(String name) {
        Intrinsics.g(name, "name");
        this.name = name;
        return this;
    }

    /* JADX INFO: renamed from: setName, reason: collision with other method in class */
    public final void m130setName(String str) {
        this.name = str;
    }

    public final OfflineDownloadBuilder setNation(String nation) {
        Intrinsics.g(nation, "nation");
        this.nation = nation;
        return this;
    }

    /* JADX INFO: renamed from: setNation, reason: collision with other method in class */
    public final void m131setNation(String str) {
        this.nation = str;
    }

    public final OfflineDownloadBuilder setNetworkType(String networkType) {
        Intrinsics.g(networkType, "networkType");
        this.networkType = networkType;
        return this;
    }

    /* JADX INFO: renamed from: setNetworkType, reason: collision with other method in class */
    public final void m132setNetworkType(String str) {
        this.networkType = str;
    }

    public final OfflineDownloadBuilder setPkgEncrypted(String pkgEncrypted) {
        Intrinsics.g(pkgEncrypted, "pkgEncrypted");
        this.pkgEncrypted = pkgEncrypted;
        return this;
    }

    /* JADX INFO: renamed from: setPkgEncrypted, reason: collision with other method in class */
    public final void m133setPkgEncrypted(String str) {
        this.pkgEncrypted = str;
    }

    public final OfflineDownloadBuilder setPkgUrl(String pkgUrl) {
        Intrinsics.g(pkgUrl, "pkgUrl");
        this.pkgUrl = pkgUrl;
        return this;
    }

    /* JADX INFO: renamed from: setPkgUrl, reason: collision with other method in class */
    public final void m134setPkgUrl(String str) {
        this.pkgUrl = str;
    }

    public final OfflineDownloadBuilder setPriority(int i11) {
        this.priority = i11;
        return this;
    }

    /* JADX INFO: renamed from: setPriority, reason: collision with other method in class */
    public final void m135setPriority(int i11) {
        this.priority = i11;
    }

    public final OfflineDownloadBuilder setResMap(HashMap<String, String> resMap) {
        Intrinsics.g(resMap, "resMap");
        this.resMap = resMap;
        return this;
    }

    /* JADX INFO: renamed from: setResMap, reason: collision with other method in class */
    public final void m136setResMap(HashMap<String, String> map) {
        this.resMap = map;
    }

    public final OfflineDownloadBuilder setType(String type) {
        Intrinsics.g(type, "type");
        this.type = type;
        return this;
    }

    /* JADX INFO: renamed from: setType, reason: collision with other method in class */
    public final void m137setType(String str) {
        this.type = str;
    }

    public final OfflineDownloadBuilder setVersion(String version) {
        Intrinsics.g(version, "version");
        this.version = version;
        return this;
    }

    /* JADX INFO: renamed from: setVersion, reason: collision with other method in class */
    public final void m138setVersion(String str) {
        this.version = str;
    }
}
