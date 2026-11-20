package com.vungle.warren.ui;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface PresenterAdOpenCallback {

    /* JADX INFO: compiled from: source.java */
    public enum AdOpenType {
        DEFAULT,
        DEEP_LINK
    }

    void a(AdOpenType adOpenType);
}
