package com.transsion.search.widget;

import com.transsion.search.bean.SearchSuggestEntity;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class BoundaryLinkedHashMap extends LinkedHashMap<String, SearchSuggestEntity> {
    private static final int MAX_SIZE = 30;

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, SearchSuggestEntity> entry) {
        return size() > 30;
    }
}
