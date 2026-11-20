# MovieBox — Guide de configuration sans pubs (méthode légitime)

> Guide pas-à-pas pour utiliser MovieBox 3.0.16 **sans modifier l'application** : blocage réseau des publicités, refus des permissions intrusives, réglages de confidentialité intégrés.
>
> ⚠️ Ce guide ne contient **aucun APK modifié** et ne débloque pas le VIP : le contenu premium est validé **côté serveur** (`vip/member/rights-check`) et le DEX 3.0.16 est chiffré (Ijiami). Voir `04-vip-et-limites.md`.

## Ce que vous obtenez en suivant ce guide

| Objectif | Moyen | Efficacité |
|---|---|---|
| **Supprimer les pubs** | Blocage DNS des 30 domaines des 6 régies (listes fournies dans `lists/`) | La grande majorité des pubs disparaît (banner/interstitial/récompensées ne chargent plus) |
| **Refuser les demandes intrusives** | Ne pas accorder les permissions au premier lancement | L'app fonctionne, seule la partie liée à chaque permission se dégrade (documenté) |
| **Couper la télémétrie** | Réglage confidentialité intégré + domaines optionnels | Firebase coupé ; télémétrie Transsion fortement réduite |
| **VIP** | Abonnement officiel uniquement | Serveur-décisionnel — voir limites |

## Structure

| Fichier | Contenu |
|---|---|
| `01-bloquer-publicites.md` | AdGuard Android / NextDNS pas-à-pas avec nos listes + ce qui reste |
| `02-premier-lancement-permissions.md` | Quoi refuser, qu'est-ce qui se dégrade, comment réaccorder |
| `03-confidentialite-in-app.md` | Le réglage intégré qui coupe Firebase + les domaines de télémétrie Transsion |
| `04-vip-et-limites.md` | Pourquoi aucun patch client ne donne le VIP, et les voies légitimes |
| `lists/adguard-hosts.txt` | Liste AdGuard/uBlock prête à coller (30 domaines, 6 régies) |
| `lists/nextdns-hosts.txt` | Liste NextDNS prête à coller |

## Source des listes

Extraction statique du code décompilé 3.0.15 (31 903 fichiers) — détail par régie et avertissements dans le dépôt frère **`moviebox-audit/03-eradication-pub/`**.
