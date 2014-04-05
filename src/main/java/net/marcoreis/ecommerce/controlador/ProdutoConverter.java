package net.marcoreis.ecommerce.controlador;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import net.marcoreis.ecommerce.entidades.Produto;
import net.marcoreis.ecommerce.service.ProdutoService;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {

    @Inject
    private ProdutoService produtoService;

    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        Produto produto;
        try {
            Long id = Long.parseLong(value);
            produto = produtoService.consultarPeloId(id);
            return produto;
        } catch (Exception e) {
            return null;
        }
    }

    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        Produto p = (Produto) value;
        String id = String.valueOf(p.getId());
        return id;
    }

}
