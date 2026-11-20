package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import wj.a;
import wj.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AndFileFilter extends a implements Serializable {
    private static final long serialVersionUID = 7215974688563965257L;
    private final List<b> fileFilters;

    public AndFileFilter() {
        this.fileFilters = new ArrayList();
    }

    public AndFileFilter(List<b> list) {
        if (list == null) {
            this.fileFilters = new ArrayList();
        } else {
            this.fileFilters = new ArrayList(list);
        }
    }

    public AndFileFilter(b bVar, b bVar2) {
        if (bVar == null || bVar2 == null) {
            throw new IllegalArgumentException("The filters must not be null");
        }
        this.fileFilters = new ArrayList(2);
        addFileFilter(bVar);
        addFileFilter(bVar2);
    }

    @Override // wj.a, wj.b, java.io.FileFilter
    public boolean accept(File file) {
        if (this.fileFilters.isEmpty()) {
            return false;
        }
        Iterator<b> it = this.fileFilters.iterator();
        while (it.hasNext()) {
            if (!it.next().accept(file)) {
                return false;
            }
        }
        return true;
    }

    @Override // wj.a, wj.b, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (this.fileFilters.isEmpty()) {
            return false;
        }
        Iterator<b> it = this.fileFilters.iterator();
        while (it.hasNext()) {
            if (!it.next().accept(file, str)) {
                return false;
            }
        }
        return true;
    }

    public void addFileFilter(b bVar) {
        this.fileFilters.add(bVar);
    }

    public List<b> getFileFilters() {
        return Collections.unmodifiableList(this.fileFilters);
    }

    public boolean removeFileFilter(b bVar) {
        return this.fileFilters.remove(bVar);
    }

    public void setFileFilters(List<b> list) {
        this.fileFilters.clear();
        this.fileFilters.addAll(list);
    }

    @Override // wj.a
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("(");
        if (this.fileFilters != null) {
            for (int i11 = 0; i11 < this.fileFilters.size(); i11++) {
                if (i11 > 0) {
                    sb2.append(",");
                }
                b bVar = this.fileFilters.get(i11);
                sb2.append(bVar == null ? "null" : bVar.toString());
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
