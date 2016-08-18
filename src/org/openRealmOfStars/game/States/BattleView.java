package org.openRealmOfStars.game.States;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.openRealmOfStars.game.GameCommands;
import org.openRealmOfStars.gui.BlackPanel;
import org.openRealmOfStars.gui.MapPanel;
import org.openRealmOfStars.player.PlayerInfo;
import org.openRealmOfStars.player.combat.Combat;
import org.openRealmOfStars.player.combat.CombatMapMouseListener;
import org.openRealmOfStars.player.fleet.Fleet;
import org.openRealmOfStars.player.ship.ShipImage;
import org.openRealmOfStars.starMap.StarMap;

/**
 * 
 * Open Realm of Stars game project
 * Copyright (C) 2016  Tuomo Untinen
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see http://www.gnu.org/licenses/
 * 
 * 
 * Battle view for handling space combat
 * 
 */
public class BattleView extends BlackPanel {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  /**
   * MapPanel for drawing the star map
   */
  private MapPanel mapPanel;

  /**
   * Current combat
   */
  private Combat combat;
  
  /**
   * Star map where combat happens
   */
  private StarMap map;

  /**
   * Combat map mouse listener
   */
  private CombatMapMouseListener combatMapMouseListener;
  
  /**
   * Battle view for space combat
   * @param fleet1 First fleet in combat
   * @param player1 First player in combat
   * @param fleet2 Second fleet in combat
   * @param player2 Second player in combat
   * @param StarMap star map
   * @param listener ActionListener
   */
  public BattleView(Fleet fleet1, PlayerInfo player1, Fleet fleet2,
      PlayerInfo player2,StarMap map, ActionListener listener) {
    BlackPanel base = new BlackPanel();
    this.map = map;
    combat = new Combat(fleet1, fleet2, player1, player2);
    mapPanel = new MapPanel();
    mapPanel.setSize(Combat.MAX_X*ShipImage.MAX_WIDTH, 
        Combat.MAX_Y*ShipImage.MAX_HEIGHT);
    mapPanel.drawBattleMap(combat, player1, this.map);

    combatMapMouseListener = new CombatMapMouseListener(combat, mapPanel, null);
    mapPanel.addMouseListener(combatMapMouseListener);
    mapPanel.addMouseMotionListener(combatMapMouseListener);

    
    this.setLayout(new BorderLayout());
    base.add(mapPanel,BorderLayout.CENTER);
    this.add(base,BorderLayout.CENTER);

  }

  
  /**
   * Update panels on BattleView
   */
  public void updatePanels() {
  }

  /**
   * Handle actions for battle view
   * @param arg0 Active Event
   */
  public void handleActions(ActionEvent arg0) {
    if (arg0.getActionCommand().equalsIgnoreCase(
        GameCommands.COMMAND_ANIMATION_TIMER) ) {
      mapPanel.drawBattleMap(combat, map.getCurrentPlayerInfo(), map);
      mapPanel.repaint();
    }

  }

}
