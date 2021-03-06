package com.example.backend.userhandling.logic.api.to;

import com.sun.istack.NotNull;

import java.util.Objects;

public class SimpleUserTo {
  public SimpleUserTo() {
  }

  public SimpleUserTo(String name, String surname, Long accountId, Long roleId) {
    this.name = name;
    this.surname = surname;
    this.accountId = accountId;
    this.roleId = roleId;
  }

  @NotNull
  private String name;

  @NotNull
  private String surname;

  @NotNull
  private Long accountId;

  @NotNull
  private Long roleId;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SimpleUserTo)) return false;
    SimpleUserTo userTo = (SimpleUserTo) o;
    return name.equals(userTo.name) &&
        surname.equals(userTo.surname) &&
        accountId.equals(userTo.accountId) &&
        roleId.equals(userTo.roleId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, accountId, roleId);
  }
}