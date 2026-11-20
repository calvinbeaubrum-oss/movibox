package com.applovin.impl;

import com.google.logging.type.LogSeverity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum fq {
    UNSPECIFIED(-1),
    RESOURCE_REJECTED(1),
    API_FRAMEWORK_OR_LANGUAGE_TYPE_NOT_SUPPORTED(2),
    FAILED_TO_LOAD_RESOURCE(3),
    XML_PARSING(100),
    GENERAL_WRAPPER_ERROR(LogSeverity.NOTICE_VALUE),
    TIMED_OUT(301),
    WRAPPER_LIMIT_REACHED(302),
    NO_WRAPPER_RESPONSE(303),
    GENERAL_LINEAR_ERROR(LogSeverity.WARNING_VALUE),
    NO_MEDIA_FILE_PROVIDED(401),
    MEDIA_FILE_TIMEOUT(402),
    MEDIA_FILE_ERROR(405),
    GENERAL_COMPANION_AD_ERROR(LogSeverity.CRITICAL_VALUE),
    UNABLE_TO_FETCH_COMPANION_AD_RESOURCE(603),
    CAN_NOT_FIND_COMPANION_AD_RESOURCE(604);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19097a;

    fq(int i11) {
        this.f19097a = i11;
    }

    public int b() {
        return this.f19097a;
    }
}
