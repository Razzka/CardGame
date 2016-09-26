<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Field</title>
	<link href="<c:url value="/resources/css/all.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/drag.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
  </head>
  <body>
  	<div class="mainfield" ng-controller="FieldController as fieldCtrl">
  	
  	<script type="text/ng-template" id="minionPopupContent.html">
    <div class="minion-popup">
        <div class="minion-popup-wrapper">
            <minion m="minion"></minion>
        </div>

        <div class="arrow-up hp-up-btn" ng-click="addHp(1)" ng-class="{grayscale: minion.hp >= 9999}"></div>
        <div class="arrow-down hp-down-btn" ng-click="addHp(-1)" ng-class="{grayscale: minion.hp <= 1}"></div>
        <div class="arrow-up attack-up-btn" ng-click="addAttack(1)" ng-class="{grayscale: minion.attack >= 9999}"></div>
        <div class="arrow-down attack-down-btn" ng-click="addAttack(-1)" ng-class="{grayscale: minion.attack <= 0}"></div>
        <input type="number" ng-change="attackChange()" class="minion-popup-attack transparent-input belwe size-small" ng-class="{buffed: minion.attack > minion.card.defaultAttack}" ng-model="minion.attack"></input>
        <input type="number" min="1" ng-min="1" ng-change="hpChange()" class="minion-popup-hp transparent-input belwe size-small" ng-model="minion.hp" ng-class="{damaged: minion.hp < minion.card.defaultHp, buffed: minion.hp > minion.card.defaultHp}"></input>
        <div class="toggle-container">
            <div class="divine-shield-toggle" ng-class="{grayscale: !divine}" ng-click="clickToggle('divine')"></div>
            <div class="stealth-toggle" ng-class="{grayscale: !stealth}" ng-click="clickToggle('stealth')"></div>
            <div class="taunt-toggle" ng-class="{grayscale: !taunt}" ng-click="clickToggle('taunt')"></div>
            <div class="frozen-toggle" ng-class="{grayscale: !frozen}" ng-click="clickToggle('frozen')"></div>
            <div ng-show="!minion.enemy" class="sleep-toggle" ng-class="{grayscale: !sleep}" ng-click="clickToggle('sleep')"></div>
        </div>
    </div>
    <div class="popup-btn-ok-wrapper">
        <div class="btn-confirm" type="button" ng-click="ok()"></div>
    </div>
    </script>
    
    <script type="text/ng-template" id="cardPopupContent.html">
    <div class="card-popup">
        <div class="card-popup-wrapper">
            <card c="card"></card>
        </div>

        <div ng-show="card.card.type != 'Spell'" class="arrow-up hp-up-btn" ng-click="addHp(1)" ng-class="{grayscale: card.hp >= 9999}"></div>
        <div ng-show="card.card.type != 'Spell'" class="arrow-down hp-down-btn" ng-click="addHp(-1)" ng-class="{grayscale: card.hp <= 1}"></div>
        <div ng-show="card.card.type != 'Spell'" class="arrow-up attack-up-btn" ng-click="addAttack(1)" ng-class="{grayscale: card.attack >= 9999}"></div>
        <div ng-show="card.card.type != 'Spell'" class="arrow-down attack-down-btn" ng-click="addAttack(-1)" ng-class="{grayscale: card.attack <= 0}"></div>
        <div class="arrow-up cost-up-btn" ng-click="addCost(1)" ng-class="{grayscale: card.cost >= 99}"></div>
        <div class="arrow-down cost-down-btn" ng-click="addCost(-1)" ng-class="{grayscale: card.cost <= 0}"></div>
        <input type="number" ng-change="costChange()" class="card-popup-cost transparent-input belwe" ng-class="{damaged: card.cost > card.card.defaultCost, buffed: card.cost < card.card.defaultCost}" ng-model="card.cost"></input>
        <input type="number" ng-change="attackChange()" class="card-popup-attack transparent-input belwe" ng-class="{buffed: card.attack > card.card.defaultAttack}" ng-model="card.attack"></input>
        <input type="number" min="1" ng-min="1" ng-change="hpChange()" class="card-popup-hp transparent-input belwe" ng-model="card.hp" ng-class="{damaged: card.hp < card.card.defaultHp, buffed: card.hp > card.card.defaultHp}"></input>
    </div>
    <div class="popup-btn-ok-wrapper">
        <div class="btn-confirm" type="button" ng-click="ok()"></div>
    </div>
    </script>
    
    <script type="text/ng-template" id="heroPopupContent.html">
    <div class="hero-popup">
        <div class="hero-popup-wrapper">
            <hero h="hero"></hero>
        </div>

        <div class="arrow-up hero-armor-up-btn" ng-click="addArmor(1)" ng-class="{grayscale: hero.armor >= 9999}"></div>
        <div class="arrow-down hero-armor-down-btn" ng-click="addArmor(-1)" ng-class="{grayscale: hero.armor <= 0}"></div>
        <div class="arrow-up hero-hp-up-btn" ng-click="addHp(1)" ng-class="{grayscale: hero.hp >= 9999}"></div>
        <div class="arrow-down hero-hp-down-btn" ng-click="addHp(-1)" ng-class="{grayscale: hero.hp <= 1}"></div>
        <div ng-hide="hero.enemy" class="arrow-up hero-attack-up-btn" ng-click="addAttack(1)" ng-class="{grayscale: hero.attack >= 9999}"></div>
        <div ng-hide="hero.enemy" class="arrow-down hero-attack-down-btn" ng-click="addAttack(-1)" ng-class="{grayscale: hero.attack <= 0}"></div>

        <div class="hero-classes">
            <img ng-repeat="h in heroes" ng-src="/Hearthpuzzle/resources/images/classes/{{h.name}}Hero.png" alt="hero" class="select-class-image" ng-click="changeHero(h)"></img>
        </div>

        <input type="number" ng-change="armorChange()" ng-hide="hero.armor == 0" class="hero-popup-armor transparent-input belwe" ng-model="hero.armor"></input>
        <input type="number" ng-change="hpChange()" class="hero-popup-hp transparent-input belwe" ng-class="{ damaged: hero.hp < hero.hero.maxhp, buffed: hero.hp > hero.hero.maxhp }" ng-model="hero.hp"></input>
        <input type="number" ng-change="attackChange()" ng-hide="hero.attack == 0 || hero.enemy" class="hero-popup-attack transparent-input belwe" ng-model="hero.attack"></input>
    </div>

    <div class="popup-btn-ok-wrapper">
        <div class="btn-confirm" type="button" ng-click="ok()"></div>
    </div>
    </script>
    
    <script type="text/ng-template" id="heropowerPopupContent.html">
    <div class="heropower-popup">
        <div class="heropower-popup-wrapper">
            <heropower p="hero"></hero>
        </div>

        <div class="arrow-up heropower-cost-up-btn" ng-click="addCost(1)" ng-class="{grayscale: hero.heropowerCost >= 9999}"></div>
        <div class="arrow-down heropower-cost-down-btn" ng-click="addCost(-1)" ng-class="{grayscale: hero.heropowerCost <= 0}"></div>

        <div class="heropower-classes">
            <img ng-repeat="h in heropowers" ng-src="/Hearthpuzzle/resources/images/cards/{{h.imageId}}c.png" alt="heropower" class="select-heropower-image" ng-click="changeHeropower(h)"></img>
        </div>

        <input ng-class="{damaged: hero.heropowerCost > 2, buffed: hero.heropowerCost < 2}" type="number" ng-change="costChange()" 
            class="heropower-popup-cost transparent-input belwe" ng-model="hero.heropowerCost"></input>
    </div>

    <div class="popup-btn-ok-wrapper">
        <div class="btn-confirm" type="button" ng-click="ok()"></div>
    </div>
    </script>
    
    <script type="text/ng-template" id="weaponPopupContent.html">
    <div class="weapon-popup">
        <div class="weapon-popup-wrapper">
            <weapon w="weapon"></weapon>
        </div>

        <div class="arrow-up hp-up-btn" ng-click="addHp(1)" ng-class="{grayscale: weapon.hp >= 9999}"></div>
        <div class="arrow-down hp-down-btn" ng-click="addHp(-1)" ng-class="{grayscale: weapon.hp <= 1}"></div>
        <div class="arrow-up attack-up-btn" ng-click="addAttack(1)" ng-class="{grayscale: weapon.attack >= 9999}"></div>
        <div class="arrow-down attack-down-btn" ng-click="addAttack(-1)" ng-class="{grayscale: weapon.attack <= 0}"></div>
        <input type="number" ng-change="attackChange()" class="weapon-popup-attack transparent-input belwe" ng-class="{buffed: weapon.attack > weapon.card.defaultAttack}" ng-model="weapon.attack"></input>
        <input type="number" min="1" ng-min="1" ng-change="hpChange()" class="weapon-popup-hp transparent-input belwe" ng-model="weapon.hp" ng-class="{damaged: weapon.hp < weapon.card.defaultHp, buffed: weapon.hp > weapon.card.defaultHp}"></input>
    </div>
    <div class="popup-btn-ok-wrapper">
        <div class="btn-confirm" type="button" ng-click="ok()"></div>
    </div>
    </script>
    
    <script type="text/ng-template" id="manaPopupContent.html">
    <div class="mana-popup">
        <div class="belwe manaTotalPopup mana-crystal used">{{mana.manaTotal}}</div>
        <div class="belwe manaAvailPopup mana-crystal">{{mana.manaAvailable}}</div>
        <div class="belwe manaLockedPopup mana-crystal locked" ng-show="!mana.enemy">{{mana.manaLocked}}</div>

        <div class="arrow-up totalMana-up-btn" ng-click="addManaTotal(1)" ng-class="{grayscale: mana.manaTotal >= 10}"></div>
        <div class="arrow-down totalMana-down-btn" ng-click="addManaTotal(-1)" ng-class="{grayscale: mana.manaTotal <= 1}"></div>
        <div class="arrow-up availMana-up-btn" ng-click="addManaAvailable(1)" ng-class="{grayscale: mana.manaAvailable >= mana.manaTotal - mana.manaLocked}"></div>
        <div class="arrow-down availMana-down-btn" ng-click="addManaAvailable(-1)" ng-class="{grayscale: mana.manaAvailable <= 0}"></div>
        <div ng-show="!mana.enemy" class="arrow-up lockedMana-up-btn" ng-click="addManaLocked(1)" ng-class="{grayscale: mana.manaLocked >= mana.manaTotal - mana.manaAvailable}"></div>
        <div ng-show="!mana.enemy" class="arrow-down lockedMana-down-btn" ng-click="addManaLocked(-1)" ng-class="{grayscale: mana.manaLocked <= 0}"></div>
    </div>
    <div class="popup-btn-ok-wrapper">
        <div class="btn-confirm" type="button" ng-click="ok()"></div>
    </div>
    </script>
  	
  		<img src="<c:url value='/resources/images/puzzle-bg-3.jpg' />" alt="battlefield"></img>
  		<div class="player enemy-player">
  			<hero h="fieldCtrl.enemyhero" ng-click="editHero(fieldCtrl.enemyhero, true)"></hero>
  		</div>
  		<div class="player puzzle-player">
  			<hero h="fieldCtrl.playerhero" ng-click="editHero(fieldCtrl.playerhero, false)"></hero>
  		</div>
  		<heropower class="hero-power hero-power-player" p="fieldCtrl.playerhero" ng-click="editHeropower(fieldCtrl.playerhero)"></heropower>
  		<heropower class="hero-power hero-power-enemy" p="fieldCtrl.enemyhero" ng-click="editHeropower(fieldCtrl.enemyhero)"></heropower>
  		<weapon style="box-sizing: border-box"
  		        dnd-list="[]" 
  		        dnd-drop="dndWeapon(event, index, item, external, type, 'playerhero')"
  		        dnd-allowed-types="['Weapon']"
  		        dnd-draggable="fieldCtrl.playerhero.weapon"
  		        dnd-moved="fieldCtrl.playerhero.weapon = null"
  		        dnd-type="'Weapon'" 
  		        dnd-dragstart="dragStart(fieldCtrl.playerhero.weapon)"
                dnd-dragend="dragEnd()"
  		        class="weapon weapon-player" 
  		        ng-click="editWeapon(fieldCtrl.playerhero.weapon)"
  		        ng-class="{cursorPointer: !!fieldCtrl.playerhero.weapon}"
  		        w="fieldCtrl.playerhero.weapon">
        </weapon>
  		<weapon dnd-list="[]" 
                dnd-drop="dndWeapon(event, index, item, external, type, 'enemyhero')"
                dnd-allowed-types="['Weapon']"
                dnd-draggable="fieldCtrl.enemyhero.weapon"
                dnd-moved="fieldCtrl.enemyhero.weapon = null"
                dnd-type="'Weapon'"
                dnd-dragstart="dragStart(fieldCtrl.enemyhero.weapon)"
                dnd-dragend="dragEnd()" 
                class="weapon weapon-enemy"
                ng-click="editWeapon(fieldCtrl.enemyhero.weapon)"
                ng-class="{cursorPointer: !!fieldCtrl.enemyhero.weapon}" 
                w="fieldCtrl.enemyhero.weapon">
        </weapon>
  		<div ng-click="editMana(fieldCtrl.playerMana, false)" class="mana mana-player size-small belwe">
  			<span>{{fieldCtrl.playerhero.manaAvailable}}/{{fieldCtrl.playerhero.manaTotal}}</span>
  		</div>
		<ul class="mana-crystals">
			<li ng-class="{used: crystal.used, locked: crystal.locked}" class="mana-crystal" ng-repeat="crystal in fieldCtrl.manaCrystals"></li>
		</ul>
  		<div ng-click="editMana(fieldCtrl.enemyMana, true)" class="mana mana-enemy size-small belwe">
  			<span>{{fieldCtrl.enemyhero.manaAvailable}}/{{fieldCtrl.enemyhero.manaTotal}}</span>
  		</div>
  		<div class="minions enemy-minions">
	  		<ul dnd-list="fieldCtrl.enemyhero.minions"
	  		    dnd-horizontal-list="true"
	  		    dnd-allowed-types="['Minion']"
	  		    dnd-drop="minionDrop(item, true)"
	  		    dnd-disable-if="fieldCtrl.enemyhero.minions.length >= 7">
	  			<li ng-repeat="minion in fieldCtrl.enemyhero.minions"
	  			    dnd-draggable="minion"
	  			    dnd-moved="fieldCtrl.enemyhero.minions.splice($index, 1)"
	  			    dnd-effect-allowed="copyMove"
	  			    dnd-dragstart="dragStart(minion)"
	  			    dnd-dragend="dragEnd()"
	  			    dnd-type="minion.card.type">
	  				<minion m="minion" ng-click="editMinion(minion)"></minion>
	  			</li>
	  		</ul>
  		</div>
  		<div class="minions player-minions">
	  		<ul dnd-list="fieldCtrl.playerhero.minions"
	  		    dnd-horizontal-list="true"
	  		    dnd-allowed-types="['Minion']"
	  		    dnd-drop="minionDrop(item, false)"
	  		    dnd-disable-if="fieldCtrl.playerhero.minions.length >= 7">
	  			<li ng-repeat="minion in fieldCtrl.playerhero.minions"
	  			    dnd-draggable="minion"
	  			    dnd-moved="fieldCtrl.playerhero.minions.splice($index, 1)"
	  			    dnd-effect-allowed="copyMove"
	  			    dnd-dragstart="dragStart(minion)"
	  			    dnd-dragend="dragEnd()"
	  			    dnd-type="minion.card.type">
	  				<minion m="minion" ng-click="editMinion(minion)"></minion>
	  			</li>
	  		</ul>
  		</div>
  		
  		<div class="player-hand">
	  		<ul dnd-list="fieldCtrl.playerhero.cardsInHand"
	  		    dnd-horizontal-list="true"
	  		    dnd-drop="dndDropHand(event, index, item, external, type, 'itemType')"
	  		    dnd-allowed-types="['Minion','Spell','Weapon']"
	  		    dnd-disable-if="fieldCtrl.playerhero.cardsInHand.length >= 8">
	  			<li ng-repeat="card in fieldCtrl.playerhero.cardsInHand"
	  				dnd-draggable="card"
	  				dnd-moved="fieldCtrl.playerhero.cardsInHand.splice($index, 1)"
	  				dnd-effect-allowed="copyMove"
	  				dnd-dragstart="dragStart(card)"
                    dnd-dragend="dragEnd()"
	  				dnd-type="card.card.type">
	  				<card c="card" ng-click="editCard(card)"></card>
	  			</li>
	  		</ul>
  		</div>
  		
  		<div class="show-search-btn up-btn" ></div>
  		<div class="show-search-btn down-btn" ></div>
  		<div class="trash-drop-zone" 
  		     ng-show="dragging"
  		     dnd-list="[]"></div>
  		
	    <div class="search-results display-none">
		    <input type="text" id="search" />
	        <input type="button" id="searchBtn" value="Search" />
	        <input type="button" id="closeSearch" value="Close" />
	    
	        <ul class="dnd-list">
	            <li ng-repeat="card in fieldCtrl.searchCardsList"
	                dnd-draggable="card"
	                dnd-effect-allowed="copy"
	                dnd-dragstart="dragStart(card)"
                    dnd-dragend="dragEnd()"
	                dnd-type="card.card.type">
	                <card c="card"></card>
	            </li>
	        </ul>
	    </div>
  		
  	</div>
  
  
	<script src="<c:url value='/resources/js/lib/jquery-1.12.2.min.js' />"></script>
	<script src="<c:url value='/resources/js/lib/angular.js' />"></script>
	<script src="<c:url value='/resources/js/lib/ui-bootstrap-tpls-2.1.2.js' />"></script>
    <script src="<c:url value='/resources/js/directives/directives.js' />"></script>
    <script src="<c:url value='/resources/js/app.js' />"></script>
    <script src="<c:url value='/resources/js/directives/minion-popup.js' />"></script>
    <script src="<c:url value='/resources/js/directives/card-popup.js' />"></script>
    <script src="<c:url value='/resources/js/directives/weapon-popup.js' />"></script>
    <script src="<c:url value='/resources/js/directives/hero-popup.js' />"></script>
    <script src="<c:url value='/resources/js/directives/mana-popup.js' />"></script>
    <script src="<c:url value='/resources/js/directives/heropower-popup.js' />"></script>
    <script src="<c:url value='/resources/js/lib/angular-drag-and-drop-lists.js' />"></script>
    <script src="<c:url value='/resources/js/controller/fieldController.js' />"></script>
    <script src="<c:url value='/resources/js/service/puzzleService.js' />"></script>
  </body>
</html>