package com.open.micro.service.model;

public class Dictionary {
  private String id;
  private String name;
  private String engName;
  private Dictionary parent;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEngName() {
    return engName;
  }

  public void setEngName(String engName) {
    this.engName = engName;
  }

  public Dictionary getParent() {
    return parent;
  }

  public void setParent(Dictionary parent) {
    this.parent = parent;
  }
  
}
