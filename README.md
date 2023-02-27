# Semestral Project SpaceRace
## By Denis Uhrík
### Translated by ChatGPT - I was too lazy.

## Description of semestral project

![slovak flag](https://em-content.zobj.net/thumbs/120/sony/336/flag-slovakia_1f1f8-1f1f0.png)
> Semestrálna práca bude upravovať pôvodný koncepčný model hry SpaceRace, kde dvaja hráči závodili o to kto sa viac krát a skôr dostane cez prekážky. Hra pôvodne obsahovala ovládanie hore a dole a cieľom bolo vyhnúť sa lietajúcim guličkám z prava a z ľavá v náhodných intervaloch.

> Upravená verzia hry SpaceRace bude obsahovať len jedného hráča, ktorý sa bude pohybovať mimo smeru hore a dole, taktiež aj smerom doľava a doprava. Na hracej ploche sa mu náhodne podľa obťažnosti vygenerujú loptičky a steny, do ktorých pokiaľ narazí, bude raketa nastavená na začiatok a uberie sa mu jeden z troch životov. Na každú hru má raketa 3 životy, po tom ako o tieto životy príde sa skóre resetuje. Hra bude obsahovať aj powerup, ktorý ak loď získa, bude môcť dočasne v intervale 15 sekúnd, prechádzať cez objekty bez strát života. V momente ako hráč dosiahne vrch hracej plochy, bude vrátený na spodok, za každé dosiahnutie hornej plochy získa 1 bod. Hra bude taktiež aj obsahovať powerup, kedy na 30 sekúnd bude hráč za každú aktivitu získavať 2x bodov. V prípade že hráč dosiahne nové najvyššie skóre, to sa uloží a vždy pri zapnutí hry tam bude uvedené.

![english flag](https://em-content.zobj.net/thumbs/120/sony/336/flag-england_1f3f4-e0067-e0062-e0065-e006e-e0067-e007f.png)
> The semester project will modify the original conceptual model of the game SpaceRace, where two players competed to see who could get through the obstacles more times and faster. The game originally contained control up and down and the goal was to avoid flying balls from the right and left at random intervals.

> The modified version of the SpaceRace game will contain only one player who will move in a direction other than up and down, as well as left and right. Balls and walls will be randomly generated on the playing field according to the difficulty, hitting which will cause the rocket to be set back to the beginning and one of the three lives will be lost. The rocket has 3 lives for each game, after losing them the score is reset. The game will also contain a power-up, which if obtained, the ship will be able to temporarily pass through objects without losing life for a period of 15 seconds. When the player reaches the top of the playing field, they will be returned to the bottom, earning 1 point for each reaching the upper field. The game will also contain a power-up, where for 30 seconds, the player will earn 2x points for each activity. If the player reaches a new high score, it will be saved and always displayed when the game is started.


## Description of code

![slovak flag](https://em-content.zobj.net/thumbs/120/sony/336/flag-slovakia_1f1f8-1f1f0.png)
> Program je naprogramovaný v programovacom jazyku Java. Jedna o program využívajúci grafickú knižnicu ShapesGE od docenta Jána Janecha. Pomocou tejto knižnice zobrazujeme guličky, steny, raketu, powerupy, životy či text na zobrazovanie skóre a zároveň aj zobrazenie domovskej obrazovky. Skladá sa z 19 tried, starajúcich sa o spúšťanie, zobrazovanie objektov, rátanie bodov, pohyb rakety, loptičiek, rátanie koordinácií objektov, spúšťanie časovačov, vyberanie mena, vyberanie obtiažnosti či kontrolu styku rakety s objektami.

![english flag](https://em-content.zobj.net/thumbs/120/sony/336/flag-england_1f3f4-e0067-e0062-e0065-e006e-e0067-e007f.png)
> The program is programmed in the Java programming language. It is a program using the graphical library ShapesGE by Docent Ján Janech. Using this library, we display balls, walls, rockets, power-ups, lives, and text to display scores and also display the home screen. It consists of 19 classes that are responsible for launching, displaying objects, counting points, rocket and ball movement, counting object coordinates, timer triggering, selecting name, selecting difficulty, or checking rocket contact with objects.

## User manual

![slovak flag](https://em-content.zobj.net/thumbs/120/sony/336/flag-slovakia_1f1f8-1f1f0.png)
> Hráč spustí hru pomocou JARu a to príkazom v príkazovom riadku
„Java -jar SpaceRace.jar”. Následne používateľ zadá svoje meno bez akýchkoľvek medzier. Odporúčane je použiť osobné meno alebo nejakú prezývku. Stlačením tlačidla OK alebo Enter sa spustí uvítacia obrazovka. Na tejto uvítacej obrazovke si môže zvoliť obtiažnosť kliknutím myši na tlačidlo alebo stlačením klávesy „E“, „M“ alebo „H“. Po zvolení obtiažnosti sa započne hra, hra sa ovláda na klávesnici šípkami alebo tlačidlami „W“, „A“, „S“ a „D“. „W“ slúži na pohyb hore, „S“ na pohyb dole, „A“ na pohyb doľava a „D“ na pohyb doprava. Cieľom hry je vyhnúť sa loptičkám a stenám, prípadne si taktiež môžete pomôcť power-upmi ako je duch alebo dvojité body. Ak získate ducha, môžete na dobu 15 sekúnd prechádzať cez akékoľvek objekty bez utrpenia straty života, double points znamená že za každé dosiahnutie vrcholu získate namiesto jedného bodu dva body. Pri každom náraze do objektu stratíte život, životov máte celkom tri, ak vyčerpáte všetky životy, skóre sa resetuje a začnete od začiatku. Hru zavriete stlačením „X“ v okne napravo hore.

![english flag](https://em-content.zobj.net/thumbs/120/sony/336/flag-england_1f3f4-e0067-e0062-e0065-e006e-e0067-e007f.png)
> The player launches the game using the JAR file by typing the command "Java -jar SpaceRace.jar" in the command prompt. Then, the user enters their name without any spaces. It is recommended to use a personal name or a nickname. Pressing the OK or Enter button will start the welcome screen. On this welcome screen, the player can choose the difficulty level by clicking the button or pressing the "E", "M", or "H" key. After selecting the difficulty, the game begins, which is controlled using the arrow keys or the "W", "A", "S", and "D" buttons. "W" is used for moving up, "S" for moving down, "A" for moving left, and "D" for moving right. The goal of the game is to avoid the balls and walls, and the player can also use power-ups such as ghosts or double points to help them. If the player gets a ghost, they can pass through any objects without losing a life for 15 seconds, and double points mean that they will earn two points for each successful top score. When the player hits an object, they lose a life, and they have a total of three lives. If they exhaust all of their lives, the score is reset, and the game starts again. To close the game, the player can press "X" in the top right window.

## UML Diagram
![UML Diagram](https://github.com/BrianMSK/FRI-SpaceRace/blob/main/UML.png?raw=true)
