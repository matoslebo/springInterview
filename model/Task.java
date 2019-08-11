package com.springLearn.springApp.model;

import java.util.Objects;

public class Task {

    private Integer id;

    private String title;

    private Integer idcategory;

    public Task() {}

    public Task(String title, Integer idcategory) {
        this.title = title;
        this.idcategory = idcategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Integer idcategory) {
        this.idcategory = idcategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(title, task.title) &&
                Objects.equals(idcategory, task.idcategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, idcategory);
    }
}
