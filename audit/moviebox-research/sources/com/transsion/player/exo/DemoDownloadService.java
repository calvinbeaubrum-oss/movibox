package com.transsion.player.exo;

import android.app.Notification;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.media3.exoplayer.scheduler.PlatformScheduler;
import com.transsion.player.R$mipmap;
import com.transsion.player.R$string;
import java.util.List;
import o4.h;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class DemoDownloadService extends DownloadService {
    public DemoDownloadService() {
        super(0, 1000L, "download_channel", R$string.exo_download_notification_channel_name, 0);
    }

    @Override // androidx.media3.exoplayer.offline.DownloadService
    public DownloadManager m() {
        DownloadManager downloadManagerH = a.h(this);
        a.i(this);
        return downloadManagerH;
    }

    @Override // androidx.media3.exoplayer.offline.DownloadService
    public Notification n(List<androidx.media3.exoplayer.offline.c> list, int i11) {
        return a.i(this).b(this, R$mipmap.player_ic_download, null, null, list, i11);
    }

    @Override // androidx.media3.exoplayer.offline.DownloadService
    public h q() {
        if (u0.f81838a >= 21) {
            return new PlatformScheduler(this, 1);
        }
        return null;
    }
}
