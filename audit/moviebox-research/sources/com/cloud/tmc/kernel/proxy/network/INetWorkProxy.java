package com.cloud.tmc.kernel.proxy.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import wc.a;
import wc.b;
import wc.f;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.integration.defaultImpl.TmcNetworkImpl")
public interface INetWorkProxy {
    public static final String HEADER_CALLBACK_ID = "callbackId";

    void cancelDownloadCall(String str, a aVar);

    void cancelHttpRequest(@NonNull String str, a aVar);

    void cancelUploadCall(String str, a aVar);

    void clearDownloadCall();

    void delete(@NonNull String str, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @Nullable Map<String, String> map3, @NonNull Boolean bool, @NonNull b bVar);

    void downloadPackage(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, String> map, @Nullable String str4, f fVar);

    void get(@NonNull String str, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @NonNull Boolean bool, @NonNull b bVar);

    void post(@NonNull String str, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @Nullable Map<String, String> map3, @NonNull Boolean bool, @NonNull b bVar);

    void postJson(@NonNull String str, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @Nullable Object obj, @NonNull Boolean bool, @NonNull b bVar);

    void postMultipart(@NonNull String str, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @Nullable Map<String, String> map3, @NonNull Boolean bool, @NonNull b bVar);

    void postV2(@NonNull String str, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @Nullable Map<String, String> map3, @NonNull Boolean bool, @NonNull b bVar);

    void put(@NonNull String str, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @Nullable Map<String, String> map3, @NonNull Boolean bool, @NonNull b bVar);

    void startPreConnect();

    void uploadFile(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @Nullable Map<String, String> map3, @NonNull Boolean bool, @NonNull wc.c cVar);
}
