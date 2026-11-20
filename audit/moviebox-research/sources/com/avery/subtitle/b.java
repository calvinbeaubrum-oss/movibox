package com.avery.subtitle;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onSubtitleChanged(@Nullable a8.b bVar);
    }

    /* JADX INFO: renamed from: com.avery.subtitle.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0209b {
        void onRefreshSubtitle();

        void onSubtitlePrepared();
    }

    void destroy();

    void initSubtitle(y7.a aVar, boolean z11);

    void pause();

    void refreshImmediately();

    void reset();

    void resume();

    void selectSubtitle(String str, String str2, y7.b bVar);

    void setDefaultSubtitle(String str);

    void setOnSubtitleChangeListener(a aVar);

    void setOnSubtitlePreparedListener(InterfaceC0209b interfaceC0209b);

    void setSubtitlePath(String str, String str2);

    void start();

    void stop();

    void subtitleDelay(long j11);
}
