package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.monitor;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOCase;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.c;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.comparator.NameFileComparator;
import java.io.File;
import java.io.FileFilter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class FileAlterationObserver implements Serializable {
    private static final long serialVersionUID = 1185122225658782848L;
    private final Comparator<File> comparator;
    private final FileFilter fileFilter;
    private final List<a> listeners;
    private final FileEntry rootEntry;

    public FileAlterationObserver(FileEntry fileEntry, FileFilter fileFilter, IOCase iOCase) {
        this.listeners = new CopyOnWriteArrayList();
        if (fileEntry == null) {
            throw new IllegalArgumentException("Root entry is missing");
        }
        if (fileEntry.getFile() == null) {
            throw new IllegalArgumentException("Root directory is missing");
        }
        this.rootEntry = fileEntry;
        this.fileFilter = fileFilter;
        if (iOCase == null || iOCase.equals(IOCase.SYSTEM)) {
            this.comparator = NameFileComparator.NAME_SYSTEM_COMPARATOR;
        } else if (iOCase.equals(IOCase.INSENSITIVE)) {
            this.comparator = NameFileComparator.NAME_INSENSITIVE_COMPARATOR;
        } else {
            this.comparator = NameFileComparator.NAME_COMPARATOR;
        }
    }

    public FileAlterationObserver(File file) {
        this(file, (FileFilter) null);
    }

    public FileAlterationObserver(File file, FileFilter fileFilter) {
        this(file, fileFilter, (IOCase) null);
    }

    public FileAlterationObserver(File file, FileFilter fileFilter, IOCase iOCase) {
        this(new FileEntry(file), fileFilter, iOCase);
    }

    public FileAlterationObserver(String str) {
        this(new File(str));
    }

    public FileAlterationObserver(String str, FileFilter fileFilter) {
        this(new File(str), fileFilter);
    }

    public FileAlterationObserver(String str, FileFilter fileFilter, IOCase iOCase) {
        this(new File(str), fileFilter, iOCase);
    }

    private void checkAndNotify(FileEntry fileEntry, FileEntry[] fileEntryArr, File[] fileArr) {
        FileEntry[] fileEntryArr2 = fileArr.length > 0 ? new FileEntry[fileArr.length] : FileEntry.EMPTY_ENTRIES;
        int i11 = 0;
        for (FileEntry fileEntry2 : fileEntryArr) {
            while (i11 < fileArr.length && this.comparator.compare(fileEntry2.getFile(), fileArr[i11]) > 0) {
                FileEntry fileEntryCreateFileEntry = createFileEntry(fileEntry, fileArr[i11]);
                fileEntryArr2[i11] = fileEntryCreateFileEntry;
                doCreate(fileEntryCreateFileEntry);
                i11++;
            }
            if (i11 >= fileArr.length || this.comparator.compare(fileEntry2.getFile(), fileArr[i11]) != 0) {
                checkAndNotify(fileEntry2, fileEntry2.getChildren(), c.f40079i);
                doDelete(fileEntry2);
            } else {
                doMatch(fileEntry2, fileArr[i11]);
                checkAndNotify(fileEntry2, fileEntry2.getChildren(), listFiles(fileArr[i11]));
                fileEntryArr2[i11] = fileEntry2;
                i11++;
            }
        }
        while (i11 < fileArr.length) {
            FileEntry fileEntryCreateFileEntry2 = createFileEntry(fileEntry, fileArr[i11]);
            fileEntryArr2[i11] = fileEntryCreateFileEntry2;
            doCreate(fileEntryCreateFileEntry2);
            i11++;
        }
        fileEntry.setChildren(fileEntryArr2);
    }

    private FileEntry createFileEntry(FileEntry fileEntry, File file) {
        FileEntry fileEntryNewChildInstance = fileEntry.newChildInstance(file);
        fileEntryNewChildInstance.refresh(file);
        fileEntryNewChildInstance.setChildren(doListFiles(file, fileEntryNewChildInstance));
        return fileEntryNewChildInstance;
    }

    private void doCreate(FileEntry fileEntry) {
        for (a aVar : this.listeners) {
            if (fileEntry.isDirectory()) {
                aVar.h(fileEntry.getFile());
            } else {
                aVar.d(fileEntry.getFile());
            }
        }
        for (FileEntry fileEntry2 : fileEntry.getChildren()) {
            doCreate(fileEntry2);
        }
    }

    private void doDelete(FileEntry fileEntry) {
        for (a aVar : this.listeners) {
            if (fileEntry.isDirectory()) {
                aVar.f(fileEntry.getFile());
            } else {
                aVar.b(fileEntry.getFile());
            }
        }
    }

    private FileEntry[] doListFiles(File file, FileEntry fileEntry) {
        File[] fileArrListFiles = listFiles(file);
        FileEntry[] fileEntryArr = fileArrListFiles.length > 0 ? new FileEntry[fileArrListFiles.length] : FileEntry.EMPTY_ENTRIES;
        for (int i11 = 0; i11 < fileArrListFiles.length; i11++) {
            fileEntryArr[i11] = createFileEntry(fileEntry, fileArrListFiles[i11]);
        }
        return fileEntryArr;
    }

    private void doMatch(FileEntry fileEntry, File file) {
        if (fileEntry.refresh(file)) {
            for (a aVar : this.listeners) {
                if (fileEntry.isDirectory()) {
                    aVar.g(file);
                } else {
                    aVar.c(file);
                }
            }
        }
    }

    private File[] listFiles(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory()) {
            FileFilter fileFilter = this.fileFilter;
            fileArrListFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        } else {
            fileArrListFiles = null;
        }
        if (fileArrListFiles == null) {
            fileArrListFiles = c.f40079i;
        }
        Comparator<File> comparator = this.comparator;
        if (comparator != null && fileArrListFiles.length > 1) {
            Arrays.sort(fileArrListFiles, comparator);
        }
        return fileArrListFiles;
    }

    public void addListener(a aVar) {
        if (aVar != null) {
            this.listeners.add(aVar);
        }
    }

    public void checkAndNotify() {
        Iterator<a> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        File file = this.rootEntry.getFile();
        if (file.exists()) {
            FileEntry fileEntry = this.rootEntry;
            checkAndNotify(fileEntry, fileEntry.getChildren(), listFiles(file));
        } else if (this.rootEntry.isExists()) {
            FileEntry fileEntry2 = this.rootEntry;
            checkAndNotify(fileEntry2, fileEntry2.getChildren(), c.f40079i);
        }
        Iterator<a> it2 = this.listeners.iterator();
        while (it2.hasNext()) {
            it2.next().e(this);
        }
    }

    public void destroy() throws Exception {
    }

    public File getDirectory() {
        return this.rootEntry.getFile();
    }

    public FileFilter getFileFilter() {
        return this.fileFilter;
    }

    public Iterable<a> getListeners() {
        return this.listeners;
    }

    public void initialize() throws Exception {
        FileEntry fileEntry = this.rootEntry;
        fileEntry.refresh(fileEntry.getFile());
        this.rootEntry.setChildren(doListFiles(this.rootEntry.getFile(), this.rootEntry));
    }

    public void removeListener(a aVar) {
        if (aVar != null) {
            while (this.listeners.remove(aVar)) {
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("[file='");
        sb2.append(getDirectory().getPath());
        sb2.append('\'');
        if (this.fileFilter != null) {
            sb2.append(", ");
            sb2.append(this.fileFilter.toString());
        }
        sb2.append(", listeners=");
        sb2.append(this.listeners.size());
        sb2.append("]");
        return sb2.toString();
    }
}
