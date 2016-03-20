package com.azazellj.a500pxreader.model.entity;

/**
 * Created by azazellj on 18.03.16.
 */
public abstract class Entity {
    public int id;

    public Entity() {
        this.id = 0;
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return id == entity.id;
    }
}
