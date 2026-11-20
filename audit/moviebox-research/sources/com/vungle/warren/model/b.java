package com.vungle.warren.model;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import com.transsion.push.PushConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements com.vungle.warren.persistence.c<a> {
    @Override // com.vungle.warren.persistence.c
    public String b() {
        return "adAsset";
    }

    @Override // com.vungle.warren.persistence.c
    @NonNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public a c(ContentValues contentValues) {
        a aVar = new a(contentValues.getAsString("ad_identifier"), contentValues.getAsString("server_path"), contentValues.getAsString("local_path"), contentValues.getAsString("item_id"));
        aVar.f62130f = contentValues.getAsInteger("file_status").intValue();
        aVar.f62131g = contentValues.getAsInteger("file_type").intValue();
        aVar.f62132h = contentValues.getAsInteger("file_size").intValue();
        aVar.f62133i = contentValues.getAsInteger(PushConstants.SP_KEY_RETRY_COUNT).intValue();
        aVar.f62134j = contentValues.getAsInteger("retry_error").intValue();
        aVar.f62127c = contentValues.getAsString("paren_id");
        return aVar;
    }

    @Override // com.vungle.warren.persistence.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ContentValues a(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", aVar.f62125a);
        contentValues.put("ad_identifier", aVar.f62126b);
        contentValues.put("paren_id", aVar.f62127c);
        contentValues.put("server_path", aVar.f62128d);
        contentValues.put("local_path", aVar.f62129e);
        contentValues.put("file_status", Integer.valueOf(aVar.f62130f));
        contentValues.put("file_type", Integer.valueOf(aVar.f62131g));
        contentValues.put("file_size", Long.valueOf(aVar.f62132h));
        contentValues.put(PushConstants.SP_KEY_RETRY_COUNT, Integer.valueOf(aVar.f62133i));
        contentValues.put("retry_error", Integer.valueOf(aVar.f62134j));
        return contentValues;
    }
}
