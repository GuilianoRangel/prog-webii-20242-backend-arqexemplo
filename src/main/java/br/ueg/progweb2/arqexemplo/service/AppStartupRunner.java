package br.ueg.progweb2.arqexemplo.service;

import br.ueg.progweb2.arqexemplo.model.Category;
import br.ueg.progweb2.arqexemplo.model.Student;
import br.ueg.progweb2.arqexemplo.repository.CategoryRepository;
import br.ueg.progweb2.arqexemplo.repository.StudentRepository;
import br.ueg.progweb2.arquitetura.adminmodule.service.SecurityInitializeService;
import br.ueg.progweb2.arquitetura.service.AbstractAppStartupRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AppStartupRunner extends AbstractAppStartupRunner {

    private static final Logger LOG =
            LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SecurityInitializeService securityInitializeService;

    public void runInitData(){
        this.securityInitializeService.initialize();
        initDataArqExampleApplication();
    }

    private void initDataArqExampleApplication() {
        Student student = null;
        for (int i = 1; i<=30; i++){
            student = Student.builder()
                    .registerNumber("230322001")
                    .name("Fulano da Silva"+i)
                    .course("Sistemas de Informação")
                    .createdDate(LocalDate.now().minusDays(1))
                    .build();
            this.studentRepository.save(student);
        }

        Category cat1 = Category.builder().name("Prioridade Baixa").build();
        Category cat2 = Category.builder().name("Prioridade Média").build();
        Category cat3 = Category.builder().name("Prioridade Alta").build();
        categoryRepository.save(cat1);
        categoryRepository.save(cat2);
        categoryRepository.save(cat3);
        LOG.info("Fim da execução");
    }

}
