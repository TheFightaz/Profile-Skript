
  #Skrypt napisany przez THEFIGHTAZ
#Wszelkie prawa zastrzezone
#Wersja v.1.0


#ZMIENNE
variables:
	{sekundy.%player%} = 0
	{minuty.%player%} = 0
	{godziny.%player%} = 0
	{zgony.%player%} = 0
	{kill.%player%} = 0
	{zabite.zombie.%player%} = 0
	{zabite.szkielety.%player%} = 0
	{zabite.spider.%player%} = 0
	{zabite.creeper.%player%} = 0
	{sqcoin.godz.%player%} = 0
	{sqcoin.kupio.%player%} = 0
	{sqcoin.wyko.%player%} = 0
on join:
	if {PROFIL::okee::%player%} is not set:
		set {PROFIL::Break::diamond::%player%} to 0 
		set {PROFIL::Break::iron::%player%} to 0
		set {PROFIL::Break::gold::%player%} to 0
		set {PROFIL::Break::coal::%player%} to 0
		set {PROFIL::Break::redstone::%player%} to 0
		set {PROFIL::Break::emerald::%player%} to 0
		set {PROFIL::Break::lapis::%player%} to 0
		set {PROFIL::Break::stone::%player%} to 0
		set {PROFIL::KILLS::zombie::%player%} to 0
		set {PROFIL::KILLS::skeeleton::%player%} to 0
		set {PROFIL::KILLS::creeper::%player%} to 0
		set {PROFIL::KILLS::spider::%player%} to 0
		set {PROFIL::KILLS::zombie::%player%} to 0
		set {PROFIL::KILLS::skeeleton::%player%} to 0  
		set {PROFIL::KILLS::creeper::%player%} to 0
		set {PROFIL::KILLS::spider::%player%} to 0
		set {PROFIL::DEATH::Player::%player%} to 0
		set {PROFIL::KILLS::Player::%player%} to 0
		set {PROFIL::okee::%player%} to true
		set {zabite.spider.%player%} to 0
		set {zabite.creeper.%player%} to 0
		set {zabite.szkielety.%player%} to 0
		set {zabite.zombie.%player%} to 0
		
on first join:
	set {sekundy.%player%} to 0
	set {minuty.%player%} to 0
	set {godziny.%player%} to 0
	set {zgony.%player%} to 0
	set {kill.%player%} to 0
	set {zabite.zombie.%player%} to 0
	set {zabite.szkielety.%player%} to 0
	set {zabite.spider.%player%}  to 0
	set {zabite.creeper.%player%} to 0
	set {sqcoin.godz.%player%} to 0
	set {sqcoin.kupio.%player%} to 0
	set {sqcoin.wyko.%player%} to 0

#CZASÓWKI
every 1 second:
	loop all players:
		add 1 to {sekundy.%loop-player%}
		if {sekundy.%loop-player%} is 60:
			add 1 to {minuty.%loop-player%}
			set {sekundy.%loop-player%} to 0
		if {minuty.%loop-player%} is 60:
			add 1 to {godziny.%loop-player%}
			add 1 to {sqcoin.godz.%loop-player%}
			set {minuty.%loop-player%} to 0
#STATY	
on break of stone:
	add 1 to {PROFIL::Break::stone::%player%}
	
on break of stone:
	chance of 0.5%:
		add 1 to {sqcoin.wyko.%player%}
		send "&8&l| &2&lMC&6&lSquare&f&l.pl &8&l| &2Zdobyto &7&lX1 &6&lSquare&f&lCoin &2z kopania!"
		
on break of any ore:
	if event-block is diamond ore:
		add 1 to {PROFIL::Break::diamond::%player%}
	if event-block is iron ore:
		add 1 to {PROFIL::Break::iron::%player%}
	if event-block is gold ore:
		add 1 to {PROFIL::Break::gold::%player%}
	if event-block is coal ore:
		add 1 to {PROFIL::Break::coal::%player%}
	if event-block is redstone ore:
		add 1 to {PROFIL::Break::redstone::%player%}
	if event-block is emerald ore:
		add 1 to {PROFIL::Break::emerald::%player%}
	if event-block is lapis lazuli ore:
		add 1 to {PROFIL::Break::lapis::%player%}
		
on death:
	if victim is a player:
		add 1 to {zgony.%player%}
		if attacker is a player:
			add 1 to {kill.%player%}
			
on death:
	if attacker is a player:
		if victim is zombie:
			add 1 to {PROFIL::KILLS::zombie::%attacker%}
		if victim is skeleton:
			add 1 to {PROFIL::KILLS::skeeleton::%attacker%}
		if victim is creeper:
			add 1 to {PROFIL::KILLS::creeper::%attacker%}
		if victim is spider:
			add 1 to {PROFIL::KILLS::spider::%attacker%}
#KOMENDY			
command /profil:
	trigger:
		open chest with 3 rows named "&2&lMC&6&lSquare&f&l.pl &8&l| &6&lPROFIL &8&l|" to player
		wait 2 tick
		set slot 0 of player's current inventory to green stained glass pane named "&l"
		set slot 1 of player's current inventory to green stained glass pane named "&l"
		set slot 2 of player's current inventory to green stained glass pane named "&l"
		set slot 3 of player's current inventory to green stained glass pane named "&l"
		set slot 4 of player's current inventory to green stained glass pane named "&l"
		set slot 5 of player's current inventory to green stained glass pane named "&l"
		set slot 6 of player's current inventory to green stained glass pane named "&l"
		set slot 7 of player's current inventory to green stained glass pane named "&l"
		set slot 8 of player's current inventory to green stained glass pane named "&l"
		set slot 9 of player's current inventory to green stained glass pane named "&l"
		set slot 10 of player's current inventory to green stained glass pane named "&l"
		set slot 11 of player's current inventory to player head named "&6&lProfil" with lore "&7Tutaj znajdziesz informacje" and "&7na temat swojego profilu"
		set slot 12 of player's current inventory to green stained glass pane named "&l"
		set slot 13 of player's current inventory to paper named "&6&lStatystki" with lore "&7Chcesz wiedziec ile wykopales" and "&7ile  zabiles czy nawet" and "&7ile grasz?"
		set slot 14 of player's current inventory to green stained glass pane named "&l"
		set slot 15 of player's current inventory to gold ingot named "&6&lSquare&f&lCoinsy" with lore "&7Kliknij i dowiedz sie" and "&7ile ich masz!"
		set slot 16 of player's current inventory to green stained glass pane named "&l"
		set slot 17 of player's current inventory to green stained glass pane named "&l"
		set slot 18 of player's current inventory to green stained glass pane named "&l"
		set slot 19 of player's current inventory to green stained glass pane named "&l"
		set slot 20 of player's current inventory to green stained glass pane named "&l"
		set slot 21 of player's current inventory to green stained glass pane named "&l"
		set slot 22 of player's current inventory to green stained glass pane named "&l"
		set slot 23 of player's current inventory to green stained glass pane named "&l"
		set slot 24 of player's current inventory to green stained glass pane named "&l"
		set slot 25 of player's current inventory to green stained glass pane named "&l"
		set slot 26 of player's current inventory to green stained glass pane named "&l"
on inventory click:
	inventory name of current inventory of player is "&2&lMC&6&lSquare&f&l.pl &8&l| &6&lPROFIL &8&l|":
		clicked slot is 11:
			open chest with 1 row named "&8&l| &6&lInformacje &2&lProfilu &8&l|" to player
			wait 2 tick
			set slot 0 of player's current inventory to green stained glass pane named "&l"
			set slot 1 of player's current inventory to green stained glass pane named "&l"
			set slot 2 of player's current inventory to green stained glass pane named "&l"
			set slot 3 of player's current inventory to green stained glass pane named "&l"
			set slot 4 of player's current inventory to player head named "&6&lProfil" with lore "&8&l▃ ▃ ▃ &2&lPROFIL &8&l▃ ▃ ▃" and "&2Ranga &8&l| &6&l%player's group% &8&l|" and "&2Kasa &8&l| &6&l%player's money% &8&l|" and "&2Ping &8&l| &6&l%player's ping% &8&l|" and "&2Zdrowie &8&l| &6&l%player's health% &8&l|" and "&2Twój Tryb &8&l| &6&l%player's gamemode% &8&l|" and "&2Level &8&l| &6&l%player's level% &8&l|" and "&8&l▃ ▃ ▃ &2&lPROFIL &8&l▃ ▃ ▃ "
			set slot 5 of player's current inventory to green stained glass pane named "&l"
			set slot 6 of player's current inventory to green stained glass pane named "&l"
			set slot 7 of player's current inventory to green stained glass pane named "&l"
			set slot 8 of player's current inventory to arrow named "&2&lPowrót" with lore "&7Kliknij, aby powrócić"
on inventory click:
	inventory name of current inventory of player is "&2&lMC&6&lSquare&f&l.pl &8&l| &6&lPROFIL &8&l|":
		clicked slot is 13:
			open chest with 1 row named "&8&l| &6&lStatystyki &8&l|" to player
			wait 2 tick
			set slot 0 of player's current inventory to green stained glass pane named "&l"
			set slot 1 of player's current inventory to green stained glass pane named "&l"
			set slot 2 of player's current inventory to diamond pickaxe named "&6&lStatystyki &2Kopania" with lore "&8&l▃ ▃ ▃ &2&lSTATYSTYKI &2&lKOPANIA &8&l▃ ▃ ▃" and "&2Kamień &8&l| &6%{PROFIL::Break::stone::%player%}% &8&l|" and "&2Żelazo &8&l| &6%{PROFIL::Break::iron::%player%}% &8&l|" and "&2Złoto &8&l| &6%{PROFIL::Break::gold::%player%}% &8&l|" and "&2Lapis &8&l| &6%{PROFIL::Break::lapis::%player%}% &8&l|" and "&2Redstone &8&l| &6%{PROFIL::Break::redstone::%player%}% &8&l|" and "&2Diamenty &8&l| &6%{PROFIL::Break::diamond::%player%}% &8&l|" and "&2Szmaragdy &8&l| &6%{PROFIL::Break::emerald::%player%}% &8&l|" and "&2Coinsy &8&l| &6%{sqcoin.wyko.%player%}% &8&l|" and "&8&l▃ ▃ ▃ &2&lSTATYSTYKI &2&lKOPANIA &8&l▃ ▃ ▃"
			set slot 3 of player's current inventory to green stained glass pane named "&l"
			set slot 4 of player's current inventory to paper named "&6&lStatystyki &2Gracza" with lore "&8&l▃ ▃ ▃ &2&lSTATYSTYKI &2&lGRACZA &8&l▃ ▃ ▃" and "&2Cas gry &8&l| &6%{godziny.%player%}% &2Godzin &6%{minuty.%player%}% &2Minut &6%{sekundy.%player%}% &2Sekund &8&l|" and "&2Śmierci &8&l| &6%{zgony.%player%}% &8&l|" and "&2Zabójstwa &8&l| &6%{kill.%player%}% &8&l|" and "&8&l▃ ▃ ▃ &2&lSTATYSTYKI &2&lGRACZA &8&l▃ ▃ ▃"
			set slot 5 of player's current inventory to green stained glass pane named "&l"
			set slot 6 of player's current inventory to diamond sword named "&6&lStatystyki &2Zabójstw Moba" with lore "&8&l▃ ▃ ▃ &2&lSTATYSTYKI &2&lZABÓJSTW &8&l▃ ▃ ▃" and "&2Zabite Zombie &8&l| &6%{PROFIL::KILLS::zombie::%player%}% &8&l|" and "&2Zabite Szkielety &8&l| &6%{PROFIL::KILLS::skeeleton::%player%}% &8&l|" and "&2Zabite Pająki &8&l| &6%{PROFIL::KILLS::spider::%player%}% &8&l|" and "&2Zabite Creepery &8&l| &6%{PROFIL::KILLS::creeper::%player%}% &8&l|" and "&8&l▃ ▃ ▃ &2&lSTATYSTYKI &2&lZABÓJSTW &8&l▃ ▃ ▃"
			set slot 7 of player's current inventory to green stained glass pane named "&l"
			set slot 8 of player's current inventory to arrow named "&2&lPowrót" with lore "&7Kliknij, aby powrócić"
on inventory click:
	inventory name of current inventory of player is "&2&lMC&6&lSquare&f&l.pl &8&l| &6&lPROFIL &8&l|":
		clicked slot is 15:
			open chest with 1 row named "&8&l| &6&lSquare&f&lCoinsy &8&l|" to player
			wait 2 tick
			set slot 0 of player's current inventory to green stained glass pane named "&l"
			set slot 1 of player's current inventory to green stained glass pane named "&l"
			set slot 2 of player's current inventory to barrier named "&6&lSklep Square&f&lCoinsów" with lore "&7Wkrótce!"
			set slot 3 of player's current inventory to green stained glass pane named "&l"
			set slot 4 of player's current inventory to player head named "&6&lSquare&f&lCoinsy" with lore "&8&l▃ ▃ ▃ &6&lSTAN &2&lKONTA &8&l▃ ▃ ▃" and "&2Stan Konta &7(&2&lG&7) &8&l| &6%{sqcoin.godz.%player%}% &8&l|" and "&2Stan Konta &7(&2&lK&7) &8&l| &6%{sqcoin.kupio.%player%}% &8&l|" and "&2Stan Konta &7(&2&lW&7) &8&l| &6%{sqcoin.wyko.%player%}% &8&l|" and "&8&l▃ ▃ ▃ &6&lStan &2&lKonta &8&l▃ ▃ ▃"
			set slot 5 of player's current inventory to green stained glass pane named "&l"
			set slot 6 of player's current inventory to paper named "&2Skróty" with lore "&8&l▃ ▃ ▃ &6&lSKRÓTY &8&l▃ ▃ ▃" and "&2G &7- &6Zdobyte za &2&lGODZINY" and "&2K &7- &6Zdobyte za &2&lKUPNO" and "&2W &7- &6Zdobyte za &2&lWYKOPANIE" and "&8&l▃ ▃ ▃ &6&lSKRÓTY &8&l▃ ▃ ▃"
			set slot 7 of player's current inventory to green stained glass pane named "&l"
			set slot 8 of player's current inventory to arrow named "&2&lPowrót" with lore "&7Kliknij, aby powrócić"
on inventory click:
	inventory name of current inventory of player is "&8&l| &6&lSquare&f&lCoinsy &8&l|":
		clicked slot is 2:
			send "&8&l| &2&lMC&6&lSquare&f&l.pl &8&l| &7Wkrótce ta opcja zostanie włączona! Zbieraj &6&lSquare&f&lCoinsy &7i wyczekuj aktualizacji!"
			close player's inventory
on inventory click:
	inventory name of current inventory of player is "&8&l| &6&lStatystyki &8&l|":
		clicked slot is 8:
			open chest with 3 rows named "&2&lMC&6&lSquare&f&l.pl &8&l| &6&lPROFIL &8&l|" to player
			wait 2 tick
			set slot 0 of player's current inventory to green stained glass pane named "&l"
			set slot 1 of player's current inventory to green stained glass pane named "&l"
			set slot 2 of player's current inventory to green stained glass pane named "&l"
			set slot 3 of player's current inventory to green stained glass pane named "&l"
			set slot 4 of player's current inventory to green stained glass pane named "&l"
			set slot 5 of player's current inventory to green stained glass pane named "&l"
			set slot 6 of player's current inventory to green stained glass pane named "&l"
			set slot 7 of player's current inventory to green stained glass pane named "&l"
			set slot 8 of player's current inventory to green stained glass pane named "&l"
			set slot 9 of player's current inventory to green stained glass pane named "&l"
			set slot 10 of player's current inventory to green stained glass pane named "&l"
			set slot 11 of player's current inventory to player head named "&6&lProfil" with lore "&7Tutaj znajdziesz informacje" and "&7na temat swojego profilu"
			set slot 12 of player's current inventory to green stained glass pane named "&l"
			set slot 13 of player's current inventory to paper named "&6&lStatystki" with lore "&7Chcesz wiedziec ile wykopales" and "&7ile  zabiles czy nawet" and "&7ile grasz?"
			set slot 14 of player's current inventory to green stained glass pane named "&l"
			set slot 15 of player's current inventory to gold ingot named "&6&lSquare&f&lCoinsy" with lore "&7Kliknij i dowiedz sie" and "&7ile ich masz!"
			set slot 16 of player's current inventory to green stained glass pane named "&l"
			set slot 17 of player's current inventory to green stained glass pane named "&l"
			set slot 18 of player's current inventory to green stained glass pane named "&l"
			set slot 19 of player's current inventory to green stained glass pane named "&l"
			set slot 20 of player's current inventory to green stained glass pane named "&l"
			set slot 21 of player's current inventory to green stained glass pane named "&l"
			set slot 22 of player's current inventory to green stained glass pane named "&l"
			set slot 23 of player's current inventory to green stained glass pane named "&l"
			set slot 24 of player's current inventory to green stained glass pane named "&l"
			set slot 25 of player's current inventory to green stained glass pane named "&l"
			set slot 26 of player's current inventory to green stained glass pane named "&l"
on inventory click:
	inventory name of current inventory of player is "&8&l| &6&lInformacje &2&lProfilu &8&l|":
		clicked slot is 8:
			open chest with 3 rows named "&2&lMC&6&lSquare&f&l.pl &8&l| &6&lPROFIL &8&l|" to player
			wait 2 tick
			set slot 0 of player's current inventory to green stained glass pane named "&l"
			set slot 1 of player's current inventory to green stained glass pane named "&l"
			set slot 2 of player's current inventory to green stained glass pane named "&l"
			set slot 3 of player's current inventory to green stained glass pane named "&l"
			set slot 4 of player's current inventory to green stained glass pane named "&l"
			set slot 5 of player's current inventory to green stained glass pane named "&l"
			set slot 6 of player's current inventory to green stained glass pane named "&l"
			set slot 7 of player's current inventory to green stained glass pane named "&l"
			set slot 8 of player's current inventory to green stained glass pane named "&l"
			set slot 9 of player's current inventory to green stained glass pane named "&l"
			set slot 10 of player's current inventory to green stained glass pane named "&l"
			set slot 11 of player's current inventory to player head named "&6&lProfil" with lore "&7Tutaj znajdziesz informacje" and "&7na temat swojego profilu"
			set slot 12 of player's current inventory to green stained glass pane named "&l"
			set slot 13 of player's current inventory to paper named "&6&lStatystki" with lore "&7Chcesz wiedziec ile wykopales" and "&7ile  zabiles czy nawet" and "&7ile grasz?"
			set slot 14 of player's current inventory to green stained glass pane named "&l"
			set slot 15 of player's current inventory to gold ingot named "&6&lSquare&f&lCoinsy" with lore "&7Kliknij i dowiedz sie" and "&7ile ich masz!"
			set slot 16 of player's current inventory to green stained glass pane named "&l"
			set slot 17 of player's current inventory to green stained glass pane named "&l"
			set slot 18 of player's current inventory to green stained glass pane named "&l"
			set slot 19 of player's current inventory to green stained glass pane named "&l"
			set slot 20 of player's current inventory to green stained glass pane named "&l"
			set slot 21 of player's current inventory to green stained glass pane named "&l"
			set slot 22 of player's current inventory to green stained glass pane named "&l"
			set slot 23 of player's current inventory to green stained glass pane named "&l"
			set slot 24 of player's current inventory to green stained glass pane named "&l"
			set slot 25 of player's current inventory to green stained glass pane named "&l"
			set slot 26 of player's current inventory to green stained glass pane named "&l"
on inventory click:
	inventory name of current inventory of player is "&8&l| &6&lSquare&f&lCoinsy &8&l|":
		clicked slot is 8:
			open chest with 3 rows named "&2&lMC&6&lSquare&f&l.pl &8&l| &6&lPROFIL &8&l|" to player
			wait 2 tick
			set slot 0 of player's current inventory to green stained glass pane named "&l"
			set slot 1 of player's current inventory to green stained glass pane named "&l"
			set slot 2 of player's current inventory to green stained glass pane named "&l"
			set slot 3 of player's current inventory to green stained glass pane named "&l"
			set slot 4 of player's current inventory to green stained glass pane named "&l"
			set slot 5 of player's current inventory to green stained glass pane named "&l"
			set slot 6 of player's current inventory to green stained glass pane named "&l"
			set slot 7 of player's current inventory to green stained glass pane named "&l"
			set slot 8 of player's current inventory to green stained glass pane named "&l"
			set slot 9 of player's current inventory to green stained glass pane named "&l"
			set slot 10 of player's current inventory to green stained glass pane named "&l"
			set slot 11 of player's current inventory to player head named "&6&lProfil" with lore "&7Tutaj znajdziesz informacje" and "&7na temat swojego profilu"
			set slot 12 of player's current inventory to green stained glass pane named "&l"
			set slot 13 of player's current inventory to paper named "&6&lStatystki" with lore "&7Chcesz wiedziec ile wykopales" and "&7ile  zabiles czy nawet" and "&7ile grasz?"
			set slot 14 of player's current inventory to green stained glass pane named "&l"
			set slot 15 of player's current inventory to gold ingot named "&6&lSquare&f&lCoinsy" with lore "&7Kliknij i dowiedz sie" and "&7ile ich masz!"
			set slot 16 of player's current inventory to green stained glass pane named "&l"
			set slot 17 of player's current inventory to green stained glass pane named "&l"
			set slot 18 of player's current inventory to green stained glass pane named "&l"
			set slot 19 of player's current inventory to green stained glass pane named "&l"
			set slot 20 of player's current inventory to green stained glass pane named "&l"
			set slot 21 of player's current inventory to green stained glass pane named "&l"
			set slot 22 of player's current inventory to green stained glass pane named "&l"
			set slot 23 of player's current inventory to green stained glass pane named "&l"
			set slot 24 of player's current inventory to green stained glass pane named "&l"
			set slot 25 of player's current inventory to green stained glass pane named "&l"
			set slot 26 of player's current inventory to green stained glass pane named "&l"
on inventory click:
	inventory name of current inventory of player is "&2&lMC&6&lSquare&f&l.pl &8&l| &6&lPROFIL &8&l|":
		cancel event
on inventory click:
	inventory name of current inventory of player is "&8&l| &6&lInformacje &2&lProfilu &8&l|":
		cancel event
on inventory click:
	inventory name of current inventory of player is "&8&l| &6&lStatystyki &8&l|":
		cancel event
on inventory click:
	inventory name of current inventory of player is "&8&l| &6&lSquare&f&lCoinsy &8&l|":
		cancel event
