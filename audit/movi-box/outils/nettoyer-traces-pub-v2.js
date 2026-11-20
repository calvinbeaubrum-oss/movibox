// V2 — nettoyage des blocs publicitaires restants du manifest (activités multi-lignes
// auto-fermées que la v1 ratait). Parsing par regex sur le texte entier.
// Usage : node outils/nettoyer-traces-pub-v2.js (depuis la racine du dépôt)
const fs = require("fs");

const PUB = [
  /com\.bytedance\.sdk/i, /com\.mintegral/i, /com\.mbridge/i, /\bmbridge_/i,
  /com\.cloud\.hisavana/i, /com\.hisavana/i, /hisavana/i, /tran_hisavana/i,
  /eagllwin/i, /com\.cloud\.tmc\.miniapp\.ad\./i,
  /com\.vungle/i, /com\.liftoff/i, /com\.facebook\.ads/i,
  /gms\.permission\.AD_ID/i, /ACCESS_ADSERVICES/i, /iab\.omid/i, /\bomid_session/i,
  /com\.google\.android\.gms\.ads/i,        // AdMob
  /com\.google\.android\.gms\.measurement/i, // AppMeasurement (mesure pub Google)
  /android\.adservices/i, /android\.ext\.adservices/i, /ga_ad_services/i, // Privacy Sandbox
];
const isPub = (s) => PUB.some((re) => re.test(s));

function cleanText(path, tags, pred) {
  let xml = fs.readFileSync(path, "utf8");
  const removed = [];
  for (const tag of tags) {
    // [^>]* traverse les sauts de ligne : gère <activity\n  attr...\n  attr.../>
    const re = new RegExp(`<${tag}\\b[^>]*?(/>|>([\\s\\S]*?)</${tag}>)`, "g");
    xml = xml.replace(re, (m0) => {
      if (pred(m0)) {
        const n = m0.match(/(?:name|value)="([^"]*)"/);
        removed.push(`<${tag}> ${n ? n[1] : "(sans nom)"}`);
        return "";
      }
      return m0;
    });
  }
  // netttoyage des lignes vides laissées par les suppressions
  xml = xml.replace(/\n[ \t]*(?=\n)/g, "\n");
  fs.writeFileSync(path, xml, "utf8");
  return removed;
}

const removedManifest = cleanText("resources/AndroidManifest.xml", ["activity", "service", "receiver", "provider", "meta-data", "uses-permission"], isPub);
console.log(`Manifest — blocs publicitaires supprimés (v2) : ${removedManifest.length}`);
for (const r of removedManifest) console.log("  " + r);
fs.writeFileSync("AUDIT/journal-nettoyage-manifest-v2.txt", removedManifest.join("\n") + "\n", "utf8");

// values : le prédicat teste le préfixe du name= (et le parent=) — PAS les motifs du manifest
const valuesDir = "resources/res/values";
const PUB_VALUE = /^(mbridge_|mintegral|hisavana|tt_|ad_|tmc_adn|tran_ad)/i;
const isPubValue = (block) => {
  const n = block.match(/name="([^"]*)"/);
  return (n && PUB_VALUE.test(n[1])) || /parent="(mbridge_|tt_|hisavana_|ad_)/i.test(block);
};
let removedValues = 0;
for (const f of fs.readdirSync(valuesDir).filter((x) => x.endsWith(".xml"))) {
  const rem = cleanText(`${valuesDir}/${f}`, ["public", "style", "attr", "color", "dimen", "string", "integer", "bool", "item", "id", "plurals", "array"], isPubValue);
  removedValues += rem.length;
  if (rem.length) console.log(`${f} : ${rem.length} entrées de plus`);
}
console.log(`Values — entrées supplémentaires supprimées : ${removedValues}`);

// Vérifications finales
const xml = fs.readFileSync("resources/AndroidManifest.xml", "utf8");
for (const tag of ["manifest", "application", "activity", "service", "receiver", "provider", "meta-data", "uses-permission"]) {
  const open = (xml.match(new RegExp(`<${tag}\\b[^>]*[^/]?>`, "g")) || []).length;
  const close = (xml.match(new RegExp(`</${tag}>`, "g")) || []).length;
  const selfc = (xml.match(new RegExp(`<${tag}\\b[^>]*/>`, "g")) || []).length;
  if (open !== close + selfc) console.log(`*** DESEQUILIBRE <${tag}> ouverts=${open} fermés=${close} auto=${selfc}`);
}
console.log("Équilibre des balises : vérifié");
const residusMan = (xml.match(/bytedance\.sdk|mintegral|mbridge|hisavana|eagllwin|vungle|AD_ID|ADSERVICES|pangle|liftoff|omid/gi) || []).length;
console.log("Résidus motifs pub dans le manifest :", residusMan);
let residusValues = 0;
for (const f of fs.readdirSync(valuesDir).filter((x) => x.endsWith(".xml"))) {
  const t = fs.readFileSync(`${valuesDir}/${f}`, "utf8");
  residusValues += (t.match(/name="(mbridge_|mintegral|hisavana|tt_|ad_)[^"]*"/gi) || []).length;
}
console.log("Résidus motifs pub dans values :", residusValues);
