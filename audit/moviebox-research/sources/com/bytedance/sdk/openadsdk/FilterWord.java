package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class FilterWord {
    private List<FilterWord> We;
    private String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f27080sc;
    private boolean zY;

    public FilterWord() {
    }

    public FilterWord(String str, String str2) {
        this.f27080sc = str;
        this.pFF = str2;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.We == null) {
            this.We = new ArrayList();
        }
        this.We.add(filterWord);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof FilterWord)) {
            return false;
        }
        FilterWord filterWord = (FilterWord) obj;
        return filterWord.getId().equals(getId()) && filterWord.getName().equals(getName());
    }

    public String getId() {
        return this.f27080sc;
    }

    public boolean getIsSelected() {
        return this.zY;
    }

    public String getName() {
        return this.pFF;
    }

    public List<FilterWord> getOptions() {
        return this.We;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.We;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.f27080sc) || TextUtils.isEmpty(this.pFF)) ? false : true;
    }

    public void setId(String str) {
        this.f27080sc = str;
    }

    public void setIsSelected(boolean z11) {
        this.zY = z11;
    }

    public void setName(String str) {
        this.pFF = str;
    }
}
