package kotlin.io;

import com.google.android.gms.common.api.Api;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class FileTreeWalk implements Sequence<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f68833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileWalkDirection f68834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<File, Boolean> f68835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<File, Unit> f68836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<File, IOException, Unit> f68837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f68838f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class FileTreeWalkIterator extends AbstractIterator<File> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayDeque<b> f68839c;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f68841a;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                try {
                    iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f68841a = iArr;
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public final class a extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f68842b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public File[] f68843c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f68844d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public boolean f68845e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ FileTreeWalkIterator f68846f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.g(rootDir, "rootDir");
                this.f68846f = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.b
            public File b() {
                if (!this.f68845e && this.f68843c == null) {
                    Function1 function1 = FileTreeWalk.this.f68835c;
                    if (function1 != null && !((Boolean) function1.invoke(a())).booleanValue()) {
                        return null;
                    }
                    File[] fileArrListFiles = a().listFiles();
                    this.f68843c = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        Function2 function2 = FileTreeWalk.this.f68837e;
                        if (function2 != null) {
                            function2.invoke(a(), new AccessDeniedException(a(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.f68845e = true;
                    }
                }
                File[] fileArr = this.f68843c;
                if (fileArr != null) {
                    int i11 = this.f68844d;
                    Intrinsics.d(fileArr);
                    if (i11 < fileArr.length) {
                        File[] fileArr2 = this.f68843c;
                        Intrinsics.d(fileArr2);
                        int i12 = this.f68844d;
                        this.f68844d = i12 + 1;
                        return fileArr2[i12];
                    }
                }
                if (!this.f68842b) {
                    this.f68842b = true;
                    return a();
                }
                Function1 function3 = FileTreeWalk.this.f68836d;
                if (function3 != null) {
                    function3.invoke(a());
                }
                return null;
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        @SourceDebugExtension
        public final class b extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f68847b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ FileTreeWalkIterator f68848c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(FileTreeWalkIterator fileTreeWalkIterator, File rootFile) {
                super(rootFile);
                Intrinsics.g(rootFile, "rootFile");
                this.f68848c = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.b
            public File b() {
                if (this.f68847b) {
                    return null;
                }
                this.f68847b = true;
                return a();
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public final class c extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f68849b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public File[] f68850c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f68851d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ FileTreeWalkIterator f68852e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.g(rootDir, "rootDir");
                this.f68852e = fileTreeWalkIterator;
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
            
                if (r0.length == 0) goto L31;
             */
            @Override // kotlin.io.FileTreeWalk.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public File b() {
                Function2 function2;
                if (!this.f68849b) {
                    Function1 function1 = FileTreeWalk.this.f68835c;
                    if (function1 != null && !((Boolean) function1.invoke(a())).booleanValue()) {
                        return null;
                    }
                    this.f68849b = true;
                    return a();
                }
                File[] fileArr = this.f68850c;
                if (fileArr != null) {
                    int i11 = this.f68851d;
                    Intrinsics.d(fileArr);
                    if (i11 >= fileArr.length) {
                        Function1 function3 = FileTreeWalk.this.f68836d;
                        if (function3 != null) {
                            function3.invoke(a());
                        }
                        return null;
                    }
                }
                if (this.f68850c == null) {
                    File[] fileArrListFiles = a().listFiles();
                    this.f68850c = fileArrListFiles;
                    if (fileArrListFiles == null && (function2 = FileTreeWalk.this.f68837e) != null) {
                        function2.invoke(a(), new AccessDeniedException(a(), null, "Cannot list files in a directory", 2, null));
                    }
                    File[] fileArr2 = this.f68850c;
                    if (fileArr2 != null) {
                        Intrinsics.d(fileArr2);
                    }
                    Function1 function4 = FileTreeWalk.this.f68836d;
                    if (function4 != null) {
                        function4.invoke(a());
                    }
                    return null;
                }
                File[] fileArr3 = this.f68850c;
                Intrinsics.d(fileArr3);
                int i12 = this.f68851d;
                this.f68851d = i12 + 1;
                return fileArr3[i12];
            }
        }

        public FileTreeWalkIterator() {
            ArrayDeque<b> arrayDeque = new ArrayDeque<>();
            this.f68839c = arrayDeque;
            if (FileTreeWalk.this.f68833a.isDirectory()) {
                arrayDeque.push(g(FileTreeWalk.this.f68833a));
            } else if (FileTreeWalk.this.f68833a.isFile()) {
                arrayDeque.push(new b(this, FileTreeWalk.this.f68833a));
            } else {
                c();
            }
        }

        @Override // kotlin.collections.AbstractIterator
        public void a() {
            File fileI = i();
            if (fileI != null) {
                d(fileI);
            } else {
                c();
            }
        }

        public final a g(File file) {
            int i11 = WhenMappings.f68841a[FileTreeWalk.this.f68834b.ordinal()];
            if (i11 == 1) {
                return new c(this, file);
            }
            if (i11 == 2) {
                return new a(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }

        public final File i() {
            while (true) {
                b bVarPeek = this.f68839c.peek();
                if (bVarPeek == null) {
                    return null;
                }
                File fileB = bVarPeek.b();
                if (fileB == null) {
                    this.f68839c.pop();
                } else {
                    if (Intrinsics.b(fileB, bVarPeek.a()) || !fileB.isDirectory() || this.f68839c.size() >= FileTreeWalk.this.f68838f) {
                        return fileB;
                    }
                    this.f68839c.push(g(fileB));
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static abstract class a extends b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(File rootDir) {
            super(rootDir);
            Intrinsics.g(rootDir, "rootDir");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f68853a;

        public b(File root) {
            Intrinsics.g(root, "root");
            this.f68853a = root;
        }

        public final File a() {
            return this.f68853a;
        }

        public abstract File b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileTreeWalk(File start, FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        Intrinsics.g(start, "start");
        Intrinsics.g(direction, "direction");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1<? super File, Boolean> function1, Function1<? super File, Unit> function2, Function2<? super File, ? super IOException, Unit> function3, int i11) {
        this.f68833a = file;
        this.f68834b = fileWalkDirection;
        this.f68835c = function1;
        this.f68836d = function2;
        this.f68837e = function3;
        this.f68838f = i11;
    }

    public /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function2, Function2 function3, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i12 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, function1, function2, function3, (i12 & 32) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i11);
    }

    public final FileTreeWalk h(Function2<? super File, ? super IOException, Unit> function) {
        Intrinsics.g(function, "function");
        return new FileTreeWalk(this.f68833a, this.f68834b, this.f68835c, this.f68836d, function, this.f68838f);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<File> iterator() {
        return new FileTreeWalkIterator();
    }
}
