/*
 * This file is part of MyPet
 *
 * Copyright © 2011-2018 Keyle
 * MyPet is licensed under the GNU Lesser General Public License.
 *
 * MyPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MyPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package de.Keyle.MyPet.skill.skills;

import de.Keyle.MyPet.MyPetApi;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.skill.skills.Fire;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;

import java.util.Random;

public class FireImpl implements Fire {
    protected int chance = 0;
    protected int duration = 0;
    private static Random random = new Random();
    private MyPet myPet;

    public FireImpl(MyPet myPet) {
        this.myPet = myPet;
    }

    public MyPet getMyPet() {
        return myPet;
    }

    public boolean isActive() {
        return chance > 0 && duration > 0;
    }

    @Override
    public void reset() {
        chance = 0;
        duration = 0;
    }

    public String toPrettyString() {
        return "" + ChatColor.GOLD + chance + ChatColor.RESET + "% -> " + ChatColor.GOLD + duration + ChatColor.RESET + "sec";
    }

    public boolean trigger() {
        return random.nextDouble() <= chance / 100.;
    }

    public int getDuration() {
        return duration;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void apply(LivingEntity target) {
        target.setFireTicks(getDuration() * 20);
        MyPetApi.getPlatformHelper().playParticleEffect(target.getLocation(), "SMOKE_LARGE", .5f, .5f, .5f, 0.02f, 20, 20);
    }

    @Override
    public String toString() {
        return "FireImpl{" +
                "chance=" + chance +
                ", duration=" + duration +
                '}';
    }
}