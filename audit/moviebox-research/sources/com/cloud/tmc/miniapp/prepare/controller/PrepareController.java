package com.cloud.tmc.miniapp.prepare.controller;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface PrepareController {

    /* JADX INFO: compiled from: source.java */
    public enum Status {
        INIT,
        EXECUTING,
        ERROR,
        FINISH;

        public boolean canContinue() {
            return this == INIT || this == EXECUTING;
        }
    }

    void finish();

    void lock(Object obj);

    void moveToError(PrepareException prepareException);

    void moveToNext();

    void start();

    void unlock(Object obj);
}
