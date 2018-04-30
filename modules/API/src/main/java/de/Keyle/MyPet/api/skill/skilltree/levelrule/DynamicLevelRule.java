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

package de.Keyle.MyPet.api.skill.skilltree.levelrule;

public class DynamicLevelRule implements LevelRule {
    int modulo = 1;
    int start = 0;
    int end = 0;

    public DynamicLevelRule(int modulo, int start, int end) {
        this.modulo = modulo;
        this.start = start;
        this.end = end;
    }

    public DynamicLevelRule(int modulo) {
        this.modulo = modulo;
    }

    public DynamicLevelRule() {
    }

    public int getModulo() {
        return modulo;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public boolean check(int level) {
        if (start > 0 && level < start) {
            return false;
        }
        if (end > 0 && level > end) {
            return false;
        }
        level -= start;
        return level % modulo == 0;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String toString() {
        return "DynamicLevelRule{" +
                "every=" + modulo +
                (start > 0 ? ", start=" + start : "") +
                (end > 0 ? ", end=" + end : "") +
                '}';
    }
}