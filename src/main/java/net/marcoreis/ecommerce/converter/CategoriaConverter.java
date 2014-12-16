package net.marcoreis.ecommerce.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.service.CategoriaService;

@ManagedBean
@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {
    @Inject
    private CategoriaService categoriaService;

    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        try {
            Long id = Long.parseLong(value);
            Categoria categoria = categoriaService.buscarPorId(id);
            return categoria;
        } catch (Exception e) {
            return null;
        }
    }

    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        try {
            Categoria categoria = (Categoria) value;
            return String.valueOf(categoria.getId());
        } catch (Exception e) {
            return value.toString();
        }
    }

}
