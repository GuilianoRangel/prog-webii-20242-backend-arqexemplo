package br.ueg.progweb2.arqexemplo.converters;

import br.ueg.progweb2.arqexemplo.service.CategoryService;
import br.ueg.progweb2.arquitetura.converters.LongConverter;
import br.ueg.progweb2.arquitetura.interfaces.IConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CategoryConverter implements IConverter {
    @Autowired
    private CategoryService categoryService;

    private static final Logger LOG =
            LoggerFactory.getLogger(LongConverter.class);
    @Override
    public Object converter(String value) {
        if(Objects.nonNull(value)){
            try {
                Long pk = Long.valueOf(value);
                return categoryService.getById(pk);
            }catch (Exception e){
                LOG.error("Erro ao Converter valor(%s) para Category",value);
            }
        }
        return null;
    }
}