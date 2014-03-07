package net.marcoreis.ecommerce.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.service.CategoriaService;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {
    @Inject
    private CategoriaService categoriaService;

    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        Long id = Long.parseLong(value);
        Categoria categoria = categoriaService.buscarPorId(id);
        return categoria;
    }

    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        Categoria categoria = (Categoria) value;
        return String.valueOf(categoria.getId());
    }

}
