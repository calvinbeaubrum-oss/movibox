package com.vungle.warren.model.admarkup;

import androidx.annotation.NonNull;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AdMarkup implements Serializable {
    String[] impressions = new String[0];

    public abstract String getEventId();

    @NonNull
    public String[] getImpressions() {
        return this.impressions;
    }

    public abstract int getVersion();
}
