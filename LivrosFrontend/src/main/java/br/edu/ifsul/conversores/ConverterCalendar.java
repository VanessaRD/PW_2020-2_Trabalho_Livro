/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.conversores;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author Vanessa Rossi D.
 */
@FacesConverter(value = "converterCalendar")
@RequestScoped
public class ConverterCalendar implements Serializable, Converter{
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Calendar returnCalendarConvert = Calendar.getInstance();
            returnCalendarConvert.setTime(sdf.parse(value));
            return returnCalendarConvert;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
        if (object == null){
            return null;
        }
        Calendar obj = (Calendar) object;
        return sdf.format(obj.getTime());
    }
    
}
