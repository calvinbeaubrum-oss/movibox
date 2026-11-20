package com.bumptech.glide.request;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public interface RequestCoordinator {

    /* JADX INFO: compiled from: source.java */
    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        RequestState(boolean z11) {
            this.isComplete = z11;
        }

        public boolean isComplete() {
            return this.isComplete;
        }
    }

    boolean canNotifyCleared(Request request);

    boolean canNotifyStatusChanged(Request request);

    boolean canSetImage(Request request);

    RequestCoordinator getRoot();

    boolean isAnyResourceSet();

    void onRequestFailed(Request request);

    void onRequestSuccess(Request request);
}
