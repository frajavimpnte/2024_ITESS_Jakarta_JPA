package com.ensode.jakartaeealltogether.faces.controller;

import com.ensode.jakartaeealltogether.dao.AddressTypeDao;
import com.ensode.jakartaeealltogether.faces.util.JsfUtil;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class AddressTypeController implements Serializable {

  @EJB
  private AddressTypeDao dao;

  public SelectItem[] getAddressTypeItemsAvailableSelectOne() {
    return JsfUtil.getSelectItems(dao.findAddressTypeEntities(), true);
  }

  public AddressTypeDao getDao() {
    return dao;
  }
}
