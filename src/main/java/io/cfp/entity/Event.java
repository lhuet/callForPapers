/*
 * Copyright (c) 2016 BreizhCamp
 * [http://breizhcamp.org]
 *
 * This file is part of CFP.io.
 *
 * CFP.io is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package io.cfp.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author <a href="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 */
@Entity
@Table(name = "events")
public class Event {

    private static ThreadLocal<String> current = new ThreadLocal<String>();

    public static String current() {
        String s = current.get();
        return s != null ? s : "default";
    }

    @Id
    private String id;

    @Column(name = "short_description")
    private String shortDescription;

    @Type(type="date")
    private Date date;

    @Type(type="date")
    private Date releaseDate;

    @Type(type="date")
    private Date decisionDate;

    private boolean open = true;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public static void setCurrent(String tenant) {
        current.set(tenant);
    }

    public static void unsetCurrent() {
        current.remove();
    }


    public Event id(String id) {
        this.id = id;
        return this;
    }

    public Event shortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public Event date(Date date) {
        this.date = date;
        return this;
    }

    public Event releaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Event decisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
        return this;
    }

    public Event open(boolean open) {
        this.open = open;
        return this;
    }
}
