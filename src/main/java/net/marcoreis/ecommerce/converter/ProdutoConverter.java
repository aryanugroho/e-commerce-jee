package net.marcoreis.ecommerce.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import net.marcoreis.ecommerce.entidades.Produto;
import net.marcoreis.ecommerce.service.ProdutoService;

@ManagedBean
@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {
    @Inject
    private ProdutoService produtoService;

    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        try {
            Long id = Long.parseLong(value);
            Produto produto = produtoService.consultarPeloId(id);
            return produto;
        } catch (Exception e) {
            return null;
        }
    }

    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        try {
            Produto p = (Produto) value;
            String id = String.valueOf(p.getId());
            return id;
        } catch (Exception e) {
            return null;
        }
    }

}
