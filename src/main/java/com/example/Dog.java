package com.example;

/* Dog entity, has:
   Dog id,
   Dog name,
   Owner name,
   Dog notes
 */
public class Dog {

    private long id;
    private String name;
    private String owner;
    private String notes;

    public Dog() {
        this.id = -1;
        this.name = null;
        this.owner = null;
        this.notes = null;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }


}
