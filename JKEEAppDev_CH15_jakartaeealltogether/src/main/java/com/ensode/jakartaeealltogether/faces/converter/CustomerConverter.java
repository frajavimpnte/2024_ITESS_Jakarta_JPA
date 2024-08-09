package com.ensode.jakartaeealltogether.faces.converter;

import com.ensode.jakartaeealltogether.entity.Customer;
import com.ensode.jakartaeealltogether.faces.controller.CustomerController;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Customer.class)
public class CustomerConverter implements Converter {

  @Override
  public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
    if (string == null || string.length() == 0) {
      return null;
    }
    Integer id = Integer.valueOf(string);
    CustomerController controller = (CustomerController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "customerController");
    return controller.findCustomer(id);
  }

  @Override
  public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
    if (object == null) {
      return null;
    }
    if (object instanceof Customer) {
      Customer o = (Customer) object;
      return o.getCustomerId() == null ? "" : o.getCustomerId().toString();
    } else {
      throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: com.ensode.jakartaeealltogether.entity.Customer");
    }
  }

}
