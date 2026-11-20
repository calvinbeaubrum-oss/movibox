package com.bytedance.sdk.openadsdk.core.Tf.sc;

import androidx.annotation.NonNull;
import com.google.logging.type.LogSeverity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public enum sc {
    XML_PARSING_ERROR(100),
    SCHEMA_VALIDATION_ERROR(101),
    WRAPPER_TIMEOUT(301),
    NO_ADS_VAST_RESPONSE(303),
    GENERAL_LINEAR_AD_ERROR(LogSeverity.WARNING_VALUE),
    GENERAL_COMPANION_AD_ERROR(LogSeverity.CRITICAL_VALUE),
    UNDEFINED_ERROR(900);

    private final int Qj;

    sc(int i11) {
        this.Qj = i11;
    }

    @NonNull
    public String sc() {
        return String.valueOf(this.Qj);
    }
}
