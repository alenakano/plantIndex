package com.project.nakano.plantindex.jpa.model;

public class SearchResult extends NamedId {
  
  public SearchResult() {
    super();
  }
  
  public SearchResult(Long id, String nome, String texto) {
    super();
    super.setId(id);
    this.setTitle(nome);
    super.setNome(nome);
    this.desc = texto;
  }

  private String desc;
  
  private String title;
  
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
  
}
