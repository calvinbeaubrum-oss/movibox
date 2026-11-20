package com.vungle.warren.model;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class s implements com.vungle.warren.persistence.c<r> {
    @Override // com.vungle.warren.persistence.c
    public String b() {
        return "vision_data";
    }

    @Override // com.vungle.warren.persistence.c
    @NonNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public r c(ContentValues contentValues) {
        return new r(contentValues.getAsLong(CampaignEx.JSON_KEY_TIMESTAMP).longValue(), contentValues.getAsString("creative"), contentValues.getAsString("campaign"), contentValues.getAsString("advertiser"));
    }

    @Override // com.vungle.warren.persistence.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ContentValues a(r rVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(rVar.f62233a));
        contentValues.put("creative", rVar.f62234b);
        contentValues.put("campaign", rVar.f62235c);
        contentValues.put("advertiser", rVar.f62236d);
        return contentValues;
    }
}
