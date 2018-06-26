package com.umanis.jean.poc_jsf.poc_projet_jsf.converter;

import java.time.LocalDate;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.umanis.jean.poc_jsf.poc_projet_jsf.Utils.PersonneUtils;
import com.umanis.jean.poc_jsf.poc_projet_jsf.bean.Personne;

/**
 *
 * @author Jean
 */
@FacesConverter(value = "MyConverter", forClass = Personne.class)
public class PersonneConverter implements Converter {

    
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        return PersonneUtils.parse(value);
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof LocalDate) {
            return PersonneUtils.format((LocalDate) value);
        }
        return "";
    }
}
