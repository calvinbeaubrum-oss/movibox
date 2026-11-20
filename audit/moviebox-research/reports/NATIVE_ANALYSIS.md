# NATIVE_ANALYSIS.md — libxybzvgn.so (packer Ijiami, MovieBox 3.0.16)

> Analyse 100 % statique (aucune exécution, aucun émulateur). 14 novembre 2026.
> Cible : `libxybzvgn.so` arm64-v8a — 747 728 octets.
> SHA-256 : `1f3fe693586b069264b80a47349c2aee29daacab4511ccc54d7d5d9023124dfd`
> (identique à la copie `AUDIT/libs-packer/` ; origine `assets/MSDvUDPFc/arm64-v8a/` —
> la lib n'est PAS dans `lib/` de l'APK, elle est extraite vers `files/` au démarrage)

## 1. Fiche d'identité

| Champ | Valeur | Preuve |
|---|---|---|
| Format | ELF64, AArch64, DYN (PIE) | parseur ELF (`SYMBOLS.txt`) |
| Compilateur | **"ijiami SecLLVM compiler 1.7.4.20"** | chaîne à 0x0917fa |
| Export principal | `JNI_OnLoad` (RegisterNatives dynamique) | `.dynstr` |
| Export marqueur | **`ijm_vmp`** (Virtual Machine Protection) | `.dynstr` |
| Table de symboles | **.dynsym truquée** (3 entrées) ; vrais noms dans .dynstr (544) | dump `SYMBOLS.txt` |
| Dépendances | liblog, libandroid, libc, libm, libdl | DT_NEEDED |
| Anti-analyse | ptrace, fork/waitpid/kill, prctl, sigaction, dl_iterate_phdr, readlink, /proc/self/maps, app_process64, "\x7fELF" | imports + strings |
| Auto-modification | mmap + mprotect + __clear_cache | imports |
| Accès APK direct | AAssetManager_open/getLength/read | imports |

## 2. Cartographie du binaire (segment RX = offset fichier)

| Zone | Contenu | Entropie |
|---|---|---|
| 0x00000–0x24000 | Tables crypto + chaînes système | 3,4–5,6 |
| 0x24f40 / 0x2887c | **CRC-32 IEEE** (poly 0xEDB88320, ×2) | — |
| 0x251d0 | **Constantes d'init MD5** (67452301 EFCDAB89 98BADCFE 10325476) | — |
| 0x25100–0x269xx | Chaînes C++/libunwind/xz, `/proc/self/maps`, `liblzma.so`, `app_process64`, `\x7fELF` | — |
| **0x26ba0** | **Table CK de SM4** : les 32 constantes `00070E15 … 646B7279` en slots 64 bits | — |
| **0x26ca0** | **S-box SM4 canonique (256 octets)** — vérifiée octet par octet | — |
| 0x26da0 | Constantes : magic ZIP `PK`, 10000, 80000, 7000 | — |
| **0x26db8+** | **Blob chiffré intégré (~1 Ko visible)**, 60 octets distincts, autocorrélation période 4 significative | 4,87 |
| **0x40000–0x917c4 (~330 Ko)** | **CODE CHIFFRÉ AU REPOS** : 0 instruction ARM64 décodable (Capstone), entropie 7,8 bits/octet | 7,8 |

Preuves du chiffrement du code : seulement **5 `RET`** dans 576 Ko ; densité Capstone ≈ 0 % sur tous les blocs ; les immédiats FK de SM4 trouvés à 0x5a970–0x5a980 sont des **littéraux de bytecode VMP**, pas du code natif direct (aucun voisinage décodable).

## 3. Algorithme de déchiffrement — déduction (Étape 5)

**Conclusion centrale : le chiffrement de bloc utilisé par Ijiami 3.0.16 est SM4 (SMS4)**, le standard national chinois — pas AES.

| Question | Réponse | Preuves |
|---|---|---|
| Algorithme | **SM4, 32 tours, bloc 128 bits** | S-box canonique complète (0x26ca0, `d690e9fe cce13db7 …`), 32 constantes CK (0x26ba0), FK `A3B1BAC6/56AA3350/677D9197/B27022DC` présents en littéraux (0x5a970+) |
| AES ? | **Non** | 0 S-box AES (`63 7c 77 7b…` et inverse absentes), 0 import SSL/crypto |
| ChaCha/Salsa ? | Non | magic `expand 32-byte k` absent |
| Clé | **128 bits, dérivée à l'exécution** dans le code chiffré — origine exacte non récupérable statiquement | code chiffré au repos ; pas de clé de 16 octets en clair |
| Candidats d'origine de clé | (a) blob intégré 0x26db8 déchiffré par une routine maison ; (b) dérivée du package/signature (le stub Java passe `com.community.oneroom` aux hooks natifs) ; (c) partie du header ijiami.dat (`d8a6fd5a664a7f199562db04eb302609`) | voir §4 |
| IV/salt | Inconnu statiquement (mode ECB/CBC/CTR non déterminable sans le code déchiffré) | — |
| Intégrité | **MD5** (empreinte 32 hex du header) + **CRC-32** (entrées ZIP, comme le code Java du stub) | constantes présentes |
| Entropie du payload | 5,7–6,3 bits/octet (audit précédent) — compatible SM4 par blocs sur un DEX à zones nulles | AUDIT/analyse-packer-ijiami.md §4 |

**Hypothèse de travail (documentée, non prouvée)** : le flux de démarrage est
`AppComponentFactory → IjiamiFakeApplication → libs extraites → IjiamiNativeBridge.al() (native) → déchiffrement SM4 du payload ijiami.dat → DexClassLoader`. La clé SM4 est probablement matérialisée par `b2b()`/`loadDEso` (com.ijm.dataencryption.DETool) à partir du blob 0x26db8 et/ou de données du package. **Test négatif documenté** : le blob 0x26db8 ne se déchiffre PAS avec l'algorithme XOR du stub Java (4 jeux de clés testés, sortie = bruit ; voir UNPACKER_DRAFT.py §autotest).

## 4. Ce que l'analyse statique ne peut PAS donner (franchement)

1. **La valeur de la clé SM4** et son mode d'enchaînement : le code qui les calcule est lui-même chiffré (0x40000–0x917c4) et la clé n'existe probablement pas en clair dans le fichier.
2. La vérification à froid d'un unpacker : tout test réel nécessite soit d'émuler le déchiffreur VMP (réimplémentation lourde), soit un dump dynamique (Phase 3).
3. Les rôles exacts des natives `al/b2b/l/m/r/ra/sa` au-delà des signatures Java visibles.

## 5. Artéfacts de cette analyse

| Fichier | Contenu |
|---|---|
| `SYMBOLS.txt` | parseur ELF complet + dump .dynstr (544 symboles) + annotations |
| `STRINGS.txt` / `STRINGS_ALL.txt` | 2 690 chaînes, 26 filtrées crypto/anti-analyse |
| `ASM_SM4_CLEAN.txt` / `ASM_SM4WIN.txt` | listings Ghidra des fenêtres crypto (montrent le désync sur données) |
| `GHIDRA_DUMP.txt` / `GHIDRA_DECOMP.txt` | journal des tentatives d'analyse Ghidra (ELF truqué → analyse quasi vide, cf. §6) |
| `UNPACKER_DRAFT.py` | ébauche d'unpacker : parseur ijiami.dat + implémentation SM4 pure Python + points d'injection de clé |
| `scripts/elf-symbols.py`, `scripts/native-strings.py` | outils réutilisables (readelf/strings non disponibles sous Git Bash) |

## 6. Difficultés d'outillage rencontrées (pour reproduction)

- `readelf/strings/nm` absents de Git Bash → parseurs Python stdlib écrits (`scripts/elf-symbols.py`).
- REA/Ghidra provider : ELF arm64 non supporté sous Windows (PE uniquement).
- Ghidra headless : analyse auto quasi vide (sections ELF truquées, relocations cassées), PyGhidra indisponible en headless (scripts Java utilisés), rebasage +0x100000 à prendre en compte, `DisassembleCommand` suit le flux et ne balaie pas linéairement.
- Capstone (déjà installé) : confirme 0 % d'instructions décodables dans le code chiffré.

## 7. Pistes pour récupérer la clé (ordre de coût croissant)

1. **Émuler le déchiffreur de code** : retrouver la routine d'auto-déchiffrement (.init_array est dans la zone 0x340–0x40000, elle-même partiellement opaque) et la réimplémenter. Coût : élevé, incertain.
2. **Dump dynamique** (Phase 3) : exécuter sur émulateur rooté + Frida → hooker `mprotect`/`__clear_cache` pour capturer le texte déchiffré, puis hooker la sortie de `b2b()` (byte[] Java) pour capturer la clé/le DEX. Coût : moyen — c'est la voie recommandée.
3. **BlackDex/FRIDA-DEXDump** directement sur le DEX déchiffré en mémoire (court-circuite la clé SM4).
4. Comparaison avec la 3.0.15 non packée pour retrouver le code applicatif sans le packer.
