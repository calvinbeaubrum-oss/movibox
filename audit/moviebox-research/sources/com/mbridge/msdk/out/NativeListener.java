package com.mbridge.msdk.out;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class NativeListener {

    /* JADX INFO: compiled from: source.java */
    public interface FilpListener {
        void filpEvent(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface NativeAdListener {
        void onAdClick(Campaign campaign);

        void onAdFramesLoaded(List<Frame> list);

        void onAdLoadError(String str);

        void onAdLoaded(List<Campaign> list, int i11);

        void onLoggingImpression(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface NativeTrackingListener extends BaseTrackingListener {
        void onDismissLoading(Campaign campaign);

        void onDownloadFinish(Campaign campaign);

        void onDownloadProgress(int i11);

        void onDownloadStart(Campaign campaign);

        boolean onInterceptDefaultLoadingDialog();

        void onShowLoading(Campaign campaign);
    }

    /* JADX INFO: compiled from: source.java */
    public static class Template {
        private int adNum;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private int f46509id;

        public Template(int i11, int i12) {
            this.f46509id = i11;
            this.adNum = i12;
        }

        public int getAdNum() {
            return this.adNum;
        }

        public int getId() {
            return this.f46509id;
        }

        public void setAdNum(int i11) {
            this.adNum = i11;
        }

        public void setId(int i11) {
            this.f46509id = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface TrackingExListener extends NativeTrackingListener {
        void onLeaveApp();
    }
}
