package com.amazonaws.services.s3.model;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class StaticEncryptionMaterialsProvider implements EncryptionMaterialsAccessor {
    private final EncryptionMaterials materials;

    public StaticEncryptionMaterialsProvider(EncryptionMaterials encryptionMaterials) {
        this.materials = encryptionMaterials;
    }

    public EncryptionMaterials getEncryptionMaterials() {
        return this.materials;
    }

    @Override // com.amazonaws.services.s3.model.EncryptionMaterialsAccessor
    public EncryptionMaterials getEncryptionMaterials(Map<String, String> map) {
        EncryptionMaterials encryptionMaterials;
        Map<String, String> materialsDescription = this.materials.getMaterialsDescription();
        if (map != null && map.equals(materialsDescription)) {
            return this.materials;
        }
        EncryptionMaterialsAccessor accessor = this.materials.getAccessor();
        if (accessor != null && (encryptionMaterials = accessor.getEncryptionMaterials(map)) != null) {
            return encryptionMaterials;
        }
        boolean z11 = true;
        boolean z12 = map == null || map.size() == 0;
        if (materialsDescription != null && materialsDescription.size() != 0) {
            z11 = false;
        }
        if (z12 && z11) {
            return this.materials;
        }
        return null;
    }

    public void refresh() {
    }
}
