package com.cloud.tmc.integration.proxy;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface StartActivityProxy {
    Boolean checkFeedBackApp(@Nullable String str);

    Boolean checkOpenMutipleTask(@Nullable String str);

    @NonNull
    Class<?> getLauncherShortCutActivity();

    @NonNull
    Class<?> getWebViewActivity();

    void launchMiniApp(@NonNull Context context, @NonNull String str);

    void launchMiniAppForId(@NonNull Context context, @NonNull String str);

    void removeMiniAppTask(@Nullable String str, @Nullable Activity activity);

    void removeMiniAppTaskByRecent(@Nullable String str);

    void updateTaskRootId(String str);
}
