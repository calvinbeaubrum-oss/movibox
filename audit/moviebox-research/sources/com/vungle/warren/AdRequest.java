package com.vungle.warren;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.model.admarkup.AdMarkup;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class AdRequest implements Serializable {
    private final long adCount;

    @Nullable
    private final AdMarkup adMarkup;
    private final boolean isExplicit;

    @NonNull
    private final String placementId;
    public AtomicLong timeStamp;
    private final int type;

    public AdRequest(@NonNull String str, int i11, long j11, boolean z11) {
        this.timeStamp = new AtomicLong(0L);
        this.placementId = str;
        this.adMarkup = null;
        this.type = i11;
        this.adCount = j11;
        this.isExplicit = z11;
    }

    public AdRequest(@NonNull String str, @Nullable AdMarkup adMarkup, boolean z11) {
        this.timeStamp = new AtomicLong(0L);
        this.placementId = str;
        this.adMarkup = adMarkup;
        this.type = 0;
        this.adCount = 1L;
        this.isExplicit = z11;
    }

    public AdRequest(@NonNull String str, boolean z11) {
        this(str, null, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdRequest.class != obj.getClass()) {
            return false;
        }
        AdRequest adRequest = (AdRequest) obj;
        if (this.type != adRequest.type || !this.placementId.equals(adRequest.placementId)) {
            return false;
        }
        AdMarkup adMarkup = this.adMarkup;
        AdMarkup adMarkup2 = adRequest.adMarkup;
        if (adMarkup != null) {
            return adMarkup.equals(adMarkup2);
        }
        return adMarkup2 == null;
    }

    public long getAdCount() {
        return this.adCount;
    }

    @Nullable
    public AdMarkup getAdMarkup() {
        return this.adMarkup;
    }

    @Nullable
    public String getEventId() {
        AdMarkup adMarkup = this.adMarkup;
        if (adMarkup == null) {
            return null;
        }
        return adMarkup.getEventId();
    }

    @Nullable
    public String[] getImpression() {
        if (getAdMarkup() != null) {
            return getAdMarkup().getImpressions();
        }
        return null;
    }

    @Nullable
    public boolean getIsExplicit() {
        return this.isExplicit;
    }

    @NonNull
    public String getPlacementId() {
        return this.placementId;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.placementId.hashCode() * 31;
        AdMarkup adMarkup = this.adMarkup;
        return ((iHashCode + (adMarkup != null ? adMarkup.hashCode() : 0)) * 31) + this.type;
    }

    public String toString() {
        return "AdRequest{placementId='" + this.placementId + "', adMarkup=" + this.adMarkup + ", type=" + this.type + ", adCount=" + this.adCount + ", isExplicit=" + this.isExplicit + '}';
    }
}
