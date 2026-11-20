package com.vungle.warren.model.admarkup;

import androidx.annotation.NonNull;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mbridge.msdk.foundation.entity.b;
import com.vungle.warren.model.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class AdMarkupV2 extends AdMarkup {
    private final String advertisementJsonObject;
    private final String placementId;

    public AdMarkupV2(JsonObject jsonObject, String[] strArr) {
        this.impressions = strArr;
        JsonElement jsonElement = jsonObject.getAsJsonArray(b.JSON_KEY_ADS).get(0);
        this.placementId = jsonElement.getAsJsonObject().get("placement_reference_id").getAsString();
        this.advertisementJsonObject = jsonElement.getAsJsonObject().toString();
    }

    @NonNull
    public c getAdvertisement() {
        c cVar = new c(JsonParser.parseString(this.advertisementJsonObject).getAsJsonObject());
        cVar.e0(this.placementId);
        cVar.b0(true);
        return cVar;
    }

    @Override // com.vungle.warren.model.admarkup.AdMarkup
    public String getEventId() {
        return getAdvertisement().v();
    }

    @Override // com.vungle.warren.model.admarkup.AdMarkup
    public int getVersion() {
        return 2;
    }
}
