Semestral Project SpaceRace

Denis Uhrík

# Description of semestral project

`	`Semestrálna práca bude upravovať pôvodný koncepčný model hry SpaceRace, kde dvaja hráči závodili o to kto sa viac krát a skôr dostane cez prekážky. Hra pôvodne obsahovala ovládanie hore a dole a cieľom bolo vyhnúť sa lietajúcim guličkám z prava a z ľavá v náhodných intervaloch.

`	`Upravená verzia hry SpaceRace bude obsahovať len jedného hráča, ktorý sa bude pohybovať mimo smeru hore a dole, taktiež aj smerom doľava a doprava. Na hracej ploche sa mu náhodne podľa obťažnosti vygenerujú loptičky a steny, do ktorých pokiaľ narazí, bude raketa nastavená na začiatok a uberie sa mu jeden z troch životov. Na každú hru má raketa 3 životy, po tom ako o tieto životy príde sa skóre resetuje. Hra bude obsahovať aj powerup, ktorý ak loď získa, bude môcť dočasne v intervale 15 sekúnd, prechádzať cez objekty bez strát života. V momente ako hráč dosiahne vrch hracej plochy, bude vrátený na spodok, za každé dosiahnutie hornej plochy získa 1 bod. Hra bude taktiež aj obsahovať powerup, kedy na 30 sekúnd bude hráč za každú aktivitu získavať 2x bodov. V prípade že hráč dosiahne nové najvyššie skóre, to sa uloží a vždy pri zapnutí hry tam bude uvedené.

# Description of code

`	`Program je naprogramovaný v programovacom jazyku Java. Jedna o program využívajúci grafickú knižnicu ShapesGE od docenta Jána Janecha. Pomocou tejto knižnice zobrazujeme guličky, steny, raketu, powerupy, životy či text na zobrazovanie skóre a zároveň aj zobrazenie domovskej obrazovky. Skladá sa z 19 tried, starajúcich sa o spúšťanie, zobrazovanie objektov, rátanie bodov, pohyb rakety, loptičiek, rátanie koordinácií objektov, spúšťanie časovačov, vyberanie mena, vyberanie obtiažnosti či kontrolu styku rakety s objektami.

# User manual

`	`Hráč spustí hru pomocou JARu a to príkazom v príkazovom riadku
„Java -jar SpaceRace.jar”. Následne používateľ zadá svoje meno bez akýchkoľvek medzier. Odporúčane je použiť osobné meno alebo nejakú prezývku. Stlačením tlačidla OK alebo Enter sa spustí uvítacia obrazovka. Na tejto uvítacej obrazovke si môže zvoliť obtiažnosť kliknutím myši na tlačidlo alebo stlačením klávesy „E“, „M“ alebo „H“. Po zvolení obtiažnosti sa započne hra, hra sa ovláda na klávesnici šípkami alebo tlačidlami „W“, „A“, „S“ a „D“. „W“ slúži na pohyb hore, „S“ na pohyb dole, „A“ na pohyb doľava a „D“ na pohyb doprava. Cieľom hry je vyhnúť sa loptičkám a stenám, prípadne si taktiež môžete pomôcť power-upmi ako je duch alebo dvojité body. Ak získate ducha, môžete na dobu 15 sekúnd prechádzať cez akékoľvek objekty bez utrpenia straty života, double points znamená že za každé dosiahnutie vrcholu získate namiesto jedného bodu dva body. Pri každom náraze do objektu stratíte život, životov máte celkom tri, ak vyčerpáte všetky životy, skóre sa resetuje a začnete od začiatku. Hru zavriete stlačením „X“ v okne napravo hore.
