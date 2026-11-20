package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.comparator;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOCase;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.d;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class ExtensionFileComparator extends AbstractFileComparator implements Serializable {
    public static final Comparator<File> EXTENSION_COMPARATOR;
    public static final Comparator<File> EXTENSION_INSENSITIVE_COMPARATOR;
    public static final Comparator<File> EXTENSION_INSENSITIVE_REVERSE;
    public static final Comparator<File> EXTENSION_REVERSE;
    public static final Comparator<File> EXTENSION_SYSTEM_COMPARATOR;
    public static final Comparator<File> EXTENSION_SYSTEM_REVERSE;
    private static final long serialVersionUID = 1928235200184222815L;
    private final IOCase caseSensitivity;

    static {
        ExtensionFileComparator extensionFileComparator = new ExtensionFileComparator();
        EXTENSION_COMPARATOR = extensionFileComparator;
        EXTENSION_REVERSE = new ReverseComparator(extensionFileComparator);
        ExtensionFileComparator extensionFileComparator2 = new ExtensionFileComparator(IOCase.INSENSITIVE);
        EXTENSION_INSENSITIVE_COMPARATOR = extensionFileComparator2;
        EXTENSION_INSENSITIVE_REVERSE = new ReverseComparator(extensionFileComparator2);
        ExtensionFileComparator extensionFileComparator3 = new ExtensionFileComparator(IOCase.SYSTEM);
        EXTENSION_SYSTEM_COMPARATOR = extensionFileComparator3;
        EXTENSION_SYSTEM_REVERSE = new ReverseComparator(extensionFileComparator3);
    }

    public ExtensionFileComparator() {
        this.caseSensitivity = IOCase.SENSITIVE;
    }

    public ExtensionFileComparator(IOCase iOCase) {
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        return this.caseSensitivity.checkCompareTo(d.a(file.getName()), d.a(file2.getName()));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort((List<File>) list);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.comparator.AbstractFileComparator
    public String toString() {
        return super.toString() + "[caseSensitivity=" + this.caseSensitivity + "]";
    }
}
