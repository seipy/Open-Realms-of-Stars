package org.openRealmOfStars.player.ship;

import org.openRealmOfStars.player.SpaceRace;

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
 * Static ship images for different races
 * 
 */

public class ShipImages {

  /**
   * Human ships
   */
  private static ShipImage humans;

  /**
   * Mechion ships
   */
  private static ShipImage mechions;

  /**
   * Sporks ships
   */
  private static ShipImage sporks;

  /**
   * Greyans ships
   */
  private static ShipImage greyans;

  /**
   * Centaurs ships
   */
  private static ShipImage centaurs;

  /**
   * Init all images
   */
  private static void initImages() {
    humans = new ShipImage("humanships.png");
    // FIXME: Need to create ships for other races too
    mechions = new ShipImage("humanships.png");
    sporks = new ShipImage("humanships.png");
    greyans = new ShipImage("humanships.png");
    centaurs = new ShipImage("humanships.png");
  }
  
  /**
   * Get Human ship images
   * @return Human ship images
   */
  public static ShipImage Humans() {
    if (humans == null) {
      initImages();
    }
    return humans;
  }
  /**
   * Get Mechions ship images
   * @return Mechions ship images
   */
  public static ShipImage Mechions() {
    if (mechions == null) {
      initImages();
    }
    return mechions;
  }
  /**
   * Get Sporks ship images
   * @return Sporks ship images
   */
  public static ShipImage Sporks() {
    if (sporks == null) {
      initImages();
    }
    return sporks;
  }
  /**
   * Get Greyans ship images
   * @return Greyans ship images
   */
  public static ShipImage Greyans() {
    if (greyans == null) {
      initImages();
    }
    return greyans;
  }
  /**
   * Get Centaurs ship images
   * @return Centaurs ship images
   */
  public static ShipImage Centaurs() {
    if (centaurs == null) {
      initImages();
    }
    return centaurs;
  }
  
  /**
   * Get ship images for certain race
   * @param race Space race which images to get
   * @return ShipImage
   */
  public static ShipImage getByRace(SpaceRace race) {
    switch (race) {
    case HUMAN: return Humans();
    case MECHIONS: return Mechions();
    case GREYANS: return Greyans();
    case CENTAURS: return Centaurs();
    case SPORKS: return Sporks();
    }
    // Default images
    return Humans();
  }

}
