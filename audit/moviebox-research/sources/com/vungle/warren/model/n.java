package com.vungle.warren.model;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import com.vungle.warren.AdConfig;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class n implements com.vungle.warren.persistence.c<m> {
    @Override // com.vungle.warren.persistence.c
    public String b() {
        return "placement";
    }

    @Override // com.vungle.warren.persistence.c
    @NonNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public m c(ContentValues contentValues) {
        m mVar = new m();
        mVar.f62186a = contentValues.getAsString("item_id");
        mVar.f62189d = contentValues.getAsLong("wakeup_time").longValue();
        mVar.f62188c = com.vungle.warren.persistence.b.a(contentValues, "incentivized");
        mVar.f62192g = com.vungle.warren.persistence.b.a(contentValues, "header_bidding");
        mVar.f62187b = com.vungle.warren.persistence.b.a(contentValues, "auto_cached");
        mVar.f62193h = com.vungle.warren.persistence.b.a(contentValues, "is_valid");
        mVar.f62190e = contentValues.getAsInteger("refresh_duration").intValue();
        mVar.f62194i = contentValues.getAsInteger("supported_template_types").intValue();
        mVar.f62195j = AdConfig.AdSize.fromName(contentValues.getAsString("ad_size"));
        mVar.f62191f = contentValues.getAsInteger("autocache_priority").intValue();
        mVar.f62197l = contentValues.getAsInteger("max_hb_cache").intValue();
        mVar.f62196k = AdConfig.AdSize.fromName(contentValues.getAsString("recommended_ad_size"));
        return mVar;
    }

    @Override // com.vungle.warren.persistence.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ContentValues a(m mVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", mVar.f62186a);
        contentValues.put("incentivized", Boolean.valueOf(mVar.f62188c));
        contentValues.put("header_bidding", Boolean.valueOf(mVar.f62192g));
        contentValues.put("auto_cached", Boolean.valueOf(mVar.f62187b));
        contentValues.put("wakeup_time", Long.valueOf(mVar.f62189d));
        contentValues.put("is_valid", Boolean.valueOf(mVar.f62193h));
        contentValues.put("refresh_duration", Integer.valueOf(mVar.f62190e));
        contentValues.put("supported_template_types", Integer.valueOf(mVar.f62194i));
        contentValues.put("ad_size", mVar.b().getName());
        contentValues.put("autocache_priority", Integer.valueOf(mVar.f62191f));
        contentValues.put("max_hb_cache", Integer.valueOf(mVar.f62197l));
        contentValues.put("recommended_ad_size", mVar.g().getName());
        return contentValues;
    }
}
